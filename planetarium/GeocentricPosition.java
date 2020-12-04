package planetarium;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;

public class GeocentricPosition {

   private double rightAscention = 0.0d;
   private double declination = 0.0d;
   private int hour = 0;
   private int minutes = 0;
   private double seconds = 0.0d;
   private int degrees = 0;
   private int arcMinutes = 0;
   private double arcSeconds = 0.0d;

   GeocentricPosition(double rightAscentionDegrees, double declinationDegrees) {

      this.rightAscention = rightAscentionDegrees;
      this.declination = declinationDegrees;
      
      convertFromRHDECL(rightAscentionDegrees,declinationDegrees);
   }
   
   GeocentricPosition(int hour, int minutes, double seconds, int degrees, int arcMinutes, double arcSeconds) {
	   
	   this.hour = hour;
	   this.minutes = minutes;
	   this.seconds = seconds;
	   this.degrees = degrees;
	   this.arcMinutes = arcMinutes;
	   this.arcSeconds = arcSeconds;
	   
	   convertToRHDECl(hour, minutes,seconds,degrees,arcMinutes,arcSeconds);
   }
   
   private void convertToRHDECl(int hour, int minutes, double seconds, int degrees, int arcMinutes, double arcSeconds) {
	   
	   BigDecimal divider = new BigDecimal(1.0d/60.0d);
	   
	   BigDecimal temp = new BigDecimal(seconds);	   
	   temp = temp.multiply(divider);
	   temp = temp.add(new BigDecimal(minutes));
	   temp = temp.multiply(divider);
	   temp = temp.add(new BigDecimal(hour));
	   
	   this.rightAscention = temp.setScale(5, RoundingMode.HALF_UP).doubleValue(); 
	   
	   BigDecimal temp2 = new BigDecimal(arcSeconds);	
	   temp = temp.multiply(divider);
	   temp = temp.add(new BigDecimal(arcMinutes));
	   temp = temp.multiply(divider);
	   temp = temp.add(new BigDecimal(degrees));
	   
	   this.declination = temp2.setScale(5, RoundingMode.HALF_UP).doubleValue(); 
   }
   
   public void convertFromRHDECL(double rightAscentionDegrees, double declinationDegrees) {
	   BigDecimal temp = new BigDecimal(rightAscentionDegrees);
	      BigDecimal divider = new BigDecimal(1.0d/15.0d);
	      temp = temp.multiply(divider);
	      this.hour = temp.intValue();
	      temp = temp.subtract(new BigDecimal(this.hour));
	      temp = temp.multiply(new BigDecimal(60.0d));
	      this.minutes = temp.intValue();
	      temp = temp.subtract(new BigDecimal(this.minutes));
	      temp = temp.multiply(new BigDecimal(60.0d));
	      this.seconds = temp.setScale(5, RoundingMode.HALF_UP).doubleValue();

	      BigDecimal temp2 = new BigDecimal(declinationDegrees);
	      this.degrees = temp2.intValue();
	      temp2 = temp2.subtract(new BigDecimal(this.degrees));

	      if (this.degrees > 0) {
	         temp2 = temp2.multiply(new BigDecimal(60.0d));
	      } else {
	         temp2 = temp2.multiply(new BigDecimal(-60.0d));
	      }
	      
	      this.arcMinutes = temp2.intValue();
	      temp2 = temp2.subtract(new BigDecimal(this.arcMinutes));
	      temp2 = temp2.multiply(new BigDecimal(60.0d));
	      this.arcSeconds = temp2.setScale(5, RoundingMode.HALF_UP).doubleValue(); 

	      this.declination = declinationDegrees;
   }
   
   public double getRightAscention() {
	   return this.rightAscention;
   }
   
   public void setRightAscention(double rightAscention) {
	   this.rightAscention = rightAscention;
   }
   
   public double getDeclination() {
	   return this.declination;
   }
   
   public void setDeclination(double declination) {
	   this.declination = declination;
   }
   
   public int getHour() {
	   return this.hour;
   }
   
   public void setHour(int hour) {
	   this.hour = hour;
   }
   
   public int getMinutes() {
	   return this.minutes;
   }
   
   public void setMinutes(int minutes) {
	   this.minutes = minutes;
   }
   
   public double getSeconds() {
	   return this.seconds;
   }
   
   public void setSeconds(double seconds) {
	   this.seconds = seconds;
   }
   
   public int getDegrees() {
	   return this.degrees;
   }
   
   public void setDegrees(int degrees) {
	   this.degrees = degrees;
   }
   
   public int getArcMinutes() {
	   return this.arcMinutes;
   }
   
   public void setArcMinutes(int arcMinutes) {
	   this.arcMinutes = arcMinutes;
   }
   
   public double getArcSeconds() {
	   return this.arcSeconds;
   }
   
   public void setArcSeconds(double arcSeconds) {
	   this.arcSeconds = arcSeconds;
   }
   
   

   public String toString() {
	   
      StringBuilder result = new StringBuilder();

      result.append("Right Ascention:"+this.rightAscention);
      result.append(System.getProperty("line.separator"));
      result.append(String.valueOf(this.hour)+"h");
      
      if (String.valueOf(this.minutes).length() == 1) {
         result.append("0"+String.valueOf(this.minutes)+"m");
      } else {
         result.append(String.valueOf(this.minutes)+"m");
      }

      String secStr = String.valueOf(this.seconds);
      String[] arrOfStr = secStr.split("\\.");
      result.append(arrOfStr[0]+"s."+arrOfStr[1]);

      result.append(System.getProperty("line.separator"));

      result.append("Declination:"+String.valueOf(this.declination));
      result.append(System.getProperty("line.separator"));
      result.append(String.valueOf(this.degrees)+"\u00B0");
      result.append(String.valueOf(this.arcMinutes)+"\'");

      String arcSecStr = String.valueOf(this.arcSeconds);
      String[] arrOfArcSec = arcSecStr.split("\\.");
      result.append(arrOfArcSec[0]+"\""+"."+arrOfArcSec[1]);

      return result.toString();
   }

}