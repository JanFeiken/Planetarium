package planetarium;

public class DeltaT {
	
	private int year;
	private int month;
	
	private double y = 0.0d;
	
	private double deltaT = 0.0d;
	
	
	public DeltaT(int year, int month) {
		System.out.println("Start of the Delta T constructor...");
		
		this.year = year;
		this.month = month;
		
		calculateDecimalYear();
		calculateDeltaT();
	}
	
	private void calculateDecimalYear() {
		this.y = this.year + ((this.month - 0.5d) / 12);
	}
	
	private void calculateDeltaT() {
		betweenYears1941And1961();
		betweenYears1961And1986();
		betweenYears1986And2005();
		betweenYears2005And2050();
		betweenYears2050And2150();
		afterYear2150();
	}
	
	//https://eclipse.gsfc.nasa.gov/SEcat5/deltatpoly.html
	
	private void betweenYears1941And1961() {
		if (this.year > 1941 && year <= 1961) {
			double t = y - 1950.0d;
			this.deltaT = 29.07d;
			this.deltaT += 0.407d * t;
			this.deltaT -= Math.pow(t,2) / 233.0d;
			this.deltaT -= Math.pow(t,3) / 2547.0d;
		}
	}
	
	private void betweenYears1961And1986() {
		if (this.year > 1961 && year <= 1986) {
			double t = y - 1975.0d;
			this.deltaT = 45.45d;
			this.deltaT += 1.067d * t;
			this.deltaT -= Math.pow(t,2) / 260.0d;
			this.deltaT -= Math.pow(t,3) / 718.0d;
		}
	}
	
	private void betweenYears1986And2005() {
		if (this.year > 1986 && year <= 2005) {
			double t = y - 2000.0d;
			this.deltaT = 63.86d;
			this.deltaT += 0.3345d * t;
			this.deltaT -= 0.060374d * Math.pow(t,2);
			this.deltaT += 0.0017275d * Math.pow(t,3);
			this.deltaT += 0.000651814d * Math.pow(t,4);
			this.deltaT += 0.00002373599d * Math.pow(t,5);
		}
	}
	
	private void betweenYears2005And2050() {
		if (this.year > 2005 && year <= 2050) {
			double t = y - 2000.0d;
			this.deltaT = 62.92d;
			this.deltaT += 0.32217d * t;
			this.deltaT += 0.005589 * Math.pow(t,2);
		}
	}
	
	private void betweenYears2050And2150() {
		if (this.year > 2050 && year <= 2150) {
			this.deltaT = 32.0d * Math.pow(((this.y - 1820.0d) / 100.0d),2);
			this.deltaT -= 20;
			this.deltaT -= 0.5628d * (2150.0d - this.y);	
		}			
	}
	
	private void afterYear2150() {
		if (this.year > 2150) {
			double u = (y - 1820.0d) / 100.0d;
			this.deltaT = 32 * Math.pow(u,2);
			this.deltaT -= 20;
		}		
	}
	
	public double getDeltaT() {
		return this.deltaT;
	}
}