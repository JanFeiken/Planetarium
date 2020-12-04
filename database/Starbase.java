package database;

import planetarium.*;

import java.util.List;
import java.util.ArrayList;

import java.sql.*;
import java.io.FileReader;
import org.h2.tools.RunScript;

public class Starbase {
	
	private Connection conn=null;
	
	private String jdbcUrl;
	private String username;
	private String password;
	
	
	public Starbase(String jdbcUrl, String username, String password) {
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;
		
		System.out.println("Just inside the constructor of the Starbase class...");

		getConnection(this.jdbcUrl, this.username, this.password);
		fillDatabaseWithStars();
		fillDatabaseWithConstellations();
		fillDatabaseWithLunarELP200082Data();
		
	}
	
	public void getConnection(String jdbcUrl, String username, String password) {
		try {
        	conn = DriverManager.getConnection(this.jdbcUrl, this.username, this.password);
        } catch (SQLException e) {
        	System.out.println(e);
        }	
	}
	
	public void closeConnection() {
		try {
			if (conn != null) {
				System.out.println("Just before close database connection...");
				conn.close();
			} else {
				System.out.println("No Database connection opened...");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} 
	}
	
	public List<Star> getListOfStars() {
		
		List<Star> listOfStars = new ArrayList<Star>();
		
		String theSqlStatement = "SELECT ID"
		        + ", CONSTELLATION"
		        + ", STAR_NAME"
				+ ", HOUR"
				+ ", MINUTES"
				+ ", SECONDS"
				+ ", DEGREES"
				+ ", ARC_MINUTES"
				+ ", ARC_SECONDS"
				+ ", MAGNITUDE"
				+ ", SPECTRUM"
				+ ", MULTI"
				+ " FROM STARS"
				+ " ORDER BY ID ASC"
				+ ";";
		
		try {
			PreparedStatement starsStatement = conn.prepareStatement(theSqlStatement);
			ResultSet rsStars = starsStatement.executeQuery();
			while (rsStars.next()) {
				String starId = rsStars.getString("ID");
				String constellation = rsStars.getString("CONSTELLATION");
				String starName = rsStars.getString("STAR_NAME");
				double hour = rsStars.getDouble("HOUR");
				double minute = rsStars.getDouble("MINUTES");
				double second = rsStars.getDouble("SECONDS");
				double degree = rsStars.getDouble("DEGREES");
				double arcMinute = rsStars.getDouble("ARC_MINUTES");
				double arcSecond = rsStars.getDouble("ARC_SECONDS");
				
				boolean latitudeBelowZero = false;
				if (rsStars.getString("DEGREES").indexOf('-', 0) != -1) {
                	latitudeBelowZero = true;
                }
				
				double magnitude = rsStars.getDouble("MAGNITUDE");
            	int spectrum = rsStars.getInt("SPECTRUM");
            	String multi = rsStars.getString("MULTI");
            	
            	
            	Star currentStar = new Star(starId,constellation,starName,hour,minute,second,degree,arcMinute,arcSecond,latitudeBelowZero,magnitude,spectrum,multi);
            	listOfStars.add(currentStar);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listOfStars;
	}
	
	public List<ConstellationLine> getListOfConstellationLines() {
		
		List<ConstellationLine> listofConstellationLines = new ArrayList<ConstellationLine>();
		
		String theSqlStatement = "SELECT CONSTELLATION"
				+ ", START_STAR_ID"
				+ ", END_STAR_ID"
				+ " FROM CONSTELLATIONS"
				+ " ORDER BY CONSTELLATION ASC"
				+ ", START_STAR_ID ASC"
				+ ";";
		
		
		try {
			PreparedStatement constellationsStatement = conn.prepareStatement(theSqlStatement);
			
			ResultSet rsConstellations = constellationsStatement.executeQuery();
			while (rsConstellations.next()) {
				String constellation = rsConstellations.getString("CONSTELLATION");
	            int startStarId = rsConstellations.getInt("START_STAR_ID");
	            int endStarId = rsConstellations.getInt("END_STAR_ID");
	            
	            ConstellationLine constellationLine = new ConstellationLine(constellation, startStarId, endStarId);
	            listofConstellationLines.add(constellationLine);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return listofConstellationLines;
	}
	
	public LunarData getLunarData(double t) {
		
			
		
		LunarData lunarData = new LunarData(t);
		
		
		String theSqlStatement = "SELECT TYPE"
				+ ",SERIE"
				+ ",NBR"
				+ ",TERM1"
				+ ",TERM2"
				+ ",TERM3"
				+ ",TERM4"
				+ ",TERM5"
				+ ",TERM6 "
				+ "FROM LUNAR "
				+ "ORDER BY TYPE ASC"
				+ ", SERIE ASC"
				+ ", NBR ASC";
		
		try {
			PreparedStatement lunarStatement = conn.prepareStatement(theSqlStatement);
			
			ResultSet rsLunar = lunarStatement.executeQuery();
			
			while (rsLunar.next()) {
				String theType = rsLunar.getString("TYPE");
			    String theSerie = rsLunar.getString("SERIE");
			    int theNBR = rsLunar.getInt("NBR");
			    double theTerm1 = rsLunar.getDouble("TERM1");
			    double theTerm2 = rsLunar.getDouble("TERM2");
			    double theTerm3 = rsLunar.getDouble("TERM3");
			    double theTerm4 = rsLunar.getDouble("TERM4");
			    double theTerm5 = rsLunar.getDouble("TERM5");
			    double theTerm6 = rsLunar.getDouble("TERM6");
			    
			    //lunarData[lunarCount] = new Lunar(theType);
			    Lunar lunarLine = new Lunar(t, theType, theSerie,theNBR,theTerm1,theTerm2,theTerm3,theTerm4,theTerm5,theTerm6);
			    lunarData.add(lunarLine);
			    
			    //Lunar theLunar = new Lunar(theType);
			    //String name = rs.getNamex("NAME"); // Assuming there is a column called name.
			    System.out.println(theType+";"+theSerie+";"+theNBR+";"+theTerm1+";"+theTerm2+";"+theTerm3+";"+theTerm4+";"+theTerm5+";"+theTerm6);
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lunarData;
		
	}
	
	
	private void fillDatabaseWithStars() {
		try {			
			RunScript.execute(conn, new FileReader("C:\\Users\\janfe\\Documents\\Planetarium\\database\\Stars.sql"));
			System.out.println("Database is filled with stars...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void fillDatabaseWithConstellations() {
		try {
			RunScript.execute(conn, new FileReader("C:\\Users\\janfe\\Documents\\Planetarium\\database\\Constellation.sql"));
			System.out.println("Database is filled with constellations...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void fillDatabaseWithLunarELP200082Data() {
		try {
			RunScript.execute(conn, new FileReader("C:\\Users\\janfe\\Documents\\Planetarium\\database\\LunarELP82.sql"));
			System.out.println("Database is filled with Lunar ELP 2000/82 data...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}