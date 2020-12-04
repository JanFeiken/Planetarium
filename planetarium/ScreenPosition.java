package planetarium;

public class ScreenPosition {
	
	private double posX;
	private double posY;
	
	private double currentPosX;
	private double currentPosY;
	
	public ScreenPosition(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public double getPosX() {
		return this.posX;
	}
	
	public void setPosX(double posX) {
		this.posX = posX;
	}
	
	public double getPosY() {
		return this.posY;
	}
	
	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	/************************************************/
	public double getCurrentPosX() {
		return this.currentPosX;
	}
	
	public void setCurrentPosX(double currentPosX) {
		this.currentPosX = currentPosX;
	}
	
	public double getCurrentPosY() {
		return this.currentPosY;
	}
	
	public void setCurrentPosY(double currentPosY) {
		this.currentPosY = currentPosY;
	}
}
