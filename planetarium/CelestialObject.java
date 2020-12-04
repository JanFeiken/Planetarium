package planetarium;

import javafx.scene.paint.Color;

public class CelestialObject extends CelestialCalculation {

	protected String starName;
	protected double starX;
	protected double starY;
	
	protected int starRadius;
	protected String multi;
	protected Color starColor;
	
	CelestialObject() {
		System.out.println("Start of the Celestial Object constructor...");
	}
	
	public String getStarName() {
		return this.starName;
	}
	
	public double getStarX() {
		return this.starX;
	}
	
	public double getStarY() {
		return this.starY;
	}
	
	public int getStarRadius() {
		  return this.starRadius;
	}

	public Color getStarColor() {
		  return this.starColor;
	}
	
	public String getMulti() {
		  return this.multi;
	}
}