package planetarium;

import javafx.scene.paint.Color;

public class Star extends CelestialObject {
  private String starId;
  private String constellation;
  private double hour;
  private double minute;
  private double second;
  private double degree;
  private double arcMinute;
  private double arcSecond;
  private double magnitude;
  private int spectrum;

  public Star(
         String starId, 
         String constellation,
         String starName,
         double hour,
         double minute,
         double second,
         double degree,
         double arcMinute,
         double arcSecond,
         boolean latitudeBelowZero,
         double magnitude,
         int spectrum,
         String multi
       ) {

	  setInitialValues(starId, constellation, starName, hour, minute, second, degree, arcMinute, arcSecond,latitudeBelowZero, magnitude, spectrum, multi);
  }
  
  public Star(
	         String starId, 
	         String constellation,
	         String starName,
	         Position position,
	         double magnitude,
	         int spectrum,
	         String multi
	       ) {
	  
	  boolean latitudeBelowZero = false;
	  
	  if (position.getDegrees()< 0) {
		  latitudeBelowZero = true;
	  }
	  
	  setInitialValues(starId, constellation, starName, position.getHour(), position.getMinutes(), position.getSeconds(), position.getDegrees(), position.getArcMinutes(), position.getArcSeconds(),latitudeBelowZero, magnitude, spectrum, multi);
  }
  
  private void setInitialValues(
	         String starId, 
	         String constellation,
	         String starName,
	         double hour,
	         double minute,
	         double second,
	         double degree,
	         double arcMinute,
	         double arcSecond,
	         boolean latitudeBelowZero,
	         double magnitude,
	         int spectrum,
	         String multi
	       ) {
	  this.starId = starId;
      this.constellation = constellation;
      this.starName = starName;
      this.hour = hour;
      this.minute = minute;
      this.second = second;
      this.degree = degree;
      this.arcMinute = arcMinute;
      this.arcSecond = arcSecond;
      this.magnitude = magnitude;
      this.spectrum = spectrum;
      this.multi = multi;

      calculateStarPosition(hour,minute,second,degree,arcMinute,arcSecond,latitudeBelowZero);
      calculateStarRadius(magnitude);
      DetermineStarColor(spectrum);
  }
  
  
  

  public String getConstellation() {
	  return this.constellation;
  }

  private void calculateStarPosition(double hour, double minute, double second, double degree, double arcMinute, double arcSecond, boolean latitudeBelowZero) {

     this.starX = hour + (minute / 60) + (second / 3600);
     this.starY = degree + (arcMinute / 60) + (arcSecond / 3600);
     
     if (latitudeBelowZero) {
    	 this.starY = degree - (arcMinute / 60) - (arcSecond / 3600);
     }
            
  }

  private void calculateStarRadius(double magnitude) {
       this.starRadius = (int) ((5 - magnitude) * 2);
  }

  private void DetermineStarColor(int x) {
	//Color color;
	switch(x) {
		case 0:
			this.starColor = Color.WHITE;
			break;
		case 1:
			this.starColor = Color.GREEN;
			break;
		case 2:
			this.starColor = Color.YELLOW;
			break;
		case 3:
			this.starColor = Color.BLUE;
			break;
		case 4:
			this.starColor = Color.RED;
			break;
		case 5:
			this.starColor = Color.PURPLE;
			break;
                case 6:
			this.starColor = Color.ORANGE;
			break;

		default:
			this.starColor = Color.BLACK;
	}
  }

}