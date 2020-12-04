package planetarium;

public class Ecliptic {

    private static final double OBLIQUITY = 23.438055d;

    private double eclipticRightAscention;
    private double eclipticDeclination;

    private double equatorialRightAscention;
    private double equatorialDeclination;

    private double tempY;
    private double tempX;
    
    public double getEquatorialRightAscention() {
    	return this.equatorialRightAscention;
    }
    
    public double getEquatorialDeclination() {
    	return this.equatorialDeclination;
    }


    public Ecliptic(
               double eclipticRightAscention,
               double eclipticDeclination
            ) {

            this.eclipticRightAscention = eclipticRightAscention;
            this.eclipticDeclination = eclipticDeclination;

            calculateEquatorialDeclination(eclipticRightAscention, eclipticDeclination);
            calculateTempY(eclipticRightAscention, eclipticDeclination);
            calculateTempX(eclipticRightAscention);
            calculateEquatorialRightAscention(tempX,tempY);
    }


    private void calculateEquatorialDeclination(double rightAscention, double declination) {

         double tempDeclination = (Math.sin( Math.toRadians( declination )) * Math.cos(Math.toRadians(OBLIQUITY)));

         tempDeclination += (Math.cos( Math.toRadians( declination )) * Math.sin(Math.toRadians(OBLIQUITY)) * Math.sin(Math.toRadians(rightAscention)) );

         this.equatorialDeclination = Math.toDegrees(Math.asin(tempDeclination));
    }

   private void calculateTempY(double rightAscention, double declination) {

        this.tempY = (Math.sin( Math.toRadians( rightAscention)) * Math.cos(Math.toRadians(OBLIQUITY)));
        this.tempY -= Math.tan(Math.toRadians(declination))* Math.sin(Math.toRadians(OBLIQUITY));
   }

   private void calculateTempX(double rightAscention) {

        this.tempX = Math.cos( Math.toRadians( rightAscention )); 
   }

   private void calculateEquatorialRightAscention(double x, double y) {
       this.equatorialRightAscention = Math.toDegrees(Math.atan(y / x));

       if (x<0) {
             this.equatorialRightAscention += 180;
       }

       this.equatorialRightAscention = this.equatorialRightAscention / 15;

   }
}