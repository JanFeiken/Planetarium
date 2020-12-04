package planetarium;

public class Lunar {
	private double t;
	private String type;
	private String Serie;
	private int nbr;
	private double term1;
	private double term2;
	private double term3;
	private double term4;
	private double term5;
	private double term6;
	
	private double t2;
	private double t3;
	private double t4;
	
	private final double d3 = 0.001;
	private final double d4 = 0.0001;
	private final double d6 = 0.000001;
	private final double d8 = 0.00000001;
	
	
	private double calc1;
	private double calc2;
	private double calc3;
	private double calc4;
	private double calc5;
	private double calc6;
	private double calc7;
	
	
	private double timeTerm3;
	
	//Constructor Lunar class
	public Lunar(double t, String type, String serie, int nbr, double term1, double term2, double term3, double term4, double term5, double term6) {
		this.t = t;
		this.type = type;
		this.Serie = serie;
		this.nbr = nbr;
		this.term1 = term1;
		this.term2 = term2;
		this.term3 = term3;
		this.term4 = term4;
		this.term5 = term5;
		this.term6 = term6;
		
		this.t2 = t*t;
		this.t3 = t*t*t;
		this.t4 = t*t*t*t;
		
		this.calc1 = term3 * t;
		this.calc2 = term4 * d4 * this.t2;
		this.calc3 = term5 * d6 * this.t3;
		this.calc4 = term6 * d8 * this.t4;
		
		this.calc5 = term2 + this.calc1 + this.calc2 + this.calc3 + this.calc4;
		
		if (type.equals("Distance")) {
			this.calc6 = Math.cos(Math.toRadians(this.calc5));
		} else {
			this.calc6 = Math.sin(Math.toRadians(this.calc5));
		}
		
		this.calc7 = term1 * this.calc6;
		
		
	}
	
	public void setT(double t) {
		this.t = t;
	}
	
	public double getT() {
		return this.t;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setSerie(String serie) {
		this.Serie = serie;
	}
	
	public String getSerie() {
		return this.Serie;
	}
	
	public void setNBR(int nbr) {
		this.nbr = nbr;
	}
	
	public int getNBR() {
		return this.nbr;
	}
	
	public void setTerm1(double term1) {
		this.term1 = term1;
	}
	
	public double getTerm1() {
		return this.term1;
	}
	
	public void setTerm2(double term2) {
		this.term2 = term2;
	}
	
	public double getTerm2() {
		return this.term2;
	}
	
	public void setTerm3(double term3) {
		this.term3 = term3;
	}
	
	public double getTerm3() {
		return this.term3;
	}
	
	public void setTerm4(double term4) {
		this.term4 = term4;
	}
	
	public double getTerm4() {
		return this.term4;
	}
	
	public void setTerm5(double term5) {
		this.term5 = term5;
	}
	
	public double getTerm5() {
		return this.term5;
	}
	
	public void setTerm6(double term6) {
		this.term6 = term6;
	}
	
	public double getTerm6() {
		return this.term6;
	}
	
	public double getCalc5() {
		return this.calc5;
	}
	
	public double getCalc6() {
		return this.calc6;
	}
	
	public double getCalc7() {
		return this.calc7;
	}
		
}