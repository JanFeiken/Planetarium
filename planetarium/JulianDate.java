package planetarium;

import planetarium.exceptions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class JulianDate {

	private int year = 0;
	private int month = 0;
	private double days = 0.0d;
	
	private int hour = 0;
	private int minute = 0;
	private double seconds = 0.0d;
	
	private int nano = 0;
	
	private boolean isGregorionCalendar = false;
	
	private double JD = 0.0d;
	
	private int year2 = 0;
	private int month2 = 0;
	private double days2 = 0.0d;
	
	private double timeIntervalInDays = 0.0d;
	
	private int constructorFlag = 0;
	
	private double t = 0;
	
	//Constructor
	public JulianDate(int Y, int M, double D) throws Exception {
		
		if ((M < 1) || (M > 12)) {
			throw new IncorrectMonthNumberException("Exception occurred 1000, JulianDate Class: Month number out of range (1..12) exception: year="+Y+" month="+M+" day="+D);
		}
		
		constructorFlag = 0; //No hour, minute, seconds indication!!
		calculateJulianDateNumber(Y,M,D);
	}
	
	//Constructor
	//http://www.onlineconversion.com/julian_date
	public JulianDate(int year, int month, int day, int hour, int min, double sec) throws Exception {
		
		if ((month < 1) || (month > 12)) {
			throw new IncorrectMonthNumberException("Exception occurred 1001, JulianDate Class: Month number out of range (1..12) exception: month number:"+month);
		}
		
		constructorFlag=1; //Including hour, minute, seconds indication
		calculateJulianDateNumber(year,month,Double.valueOf(day));
		
		this.hour = hour;
		this.minute = min;
		this.seconds = sec;
		
		BigDecimal dayPartBig = new BigDecimal(0.0d);
		
		double dayPart = dayPartBig.add(new BigDecimal(sec))
				                   .divide(new BigDecimal(60.0d),16,RoundingMode.HALF_EVEN)
				                   .add(new BigDecimal(min))
				                   .divide(new BigDecimal(60.0d),16,RoundingMode.HALF_EVEN)
				                   .add(new BigDecimal(hour))
				                   .divide(new BigDecimal(24.0d),16,RoundingMode.HALF_EVEN)
				                   .doubleValue();
		
		this.JD += dayPart;
	}
	
	//Constructor
	public JulianDate(double JD) {
		constructorFlag=2; //From Julian Date to Calendar Date		
		calculateCalendarDate(JD);
	}
	
	//Constructor
	public JulianDate(int year, int month, double days, int year2, int month2, double days2) throws Exception {
		
		if ((month < 1) || (month > 12)) {
			throw new IncorrectMonthNumberException("Exception occurred 1002, JulianDate Class: Month number out of range (1..12) exception: month number:"+month);
		}
		
		constructorFlag=3;
		
		this.year = year;
		this.month = month;
		this.days = days;
		
		getTimeIntervalInDays(year2,month2,days2);
	}
	
	//Constructor
	public JulianDate() throws Exception {
		constructorFlag = 4;
			
		LocalDateTime now = LocalDateTime.now();
			
		int year = now.getYear();
		int month = now.getMonth().getValue();
		int days = now.getDayOfMonth();
			
		int hour = now.getHour();
		int minute = now.getMinute();
			
		this.nano = now.getNano();
		
		
		BigDecimal bigDecimalSeconds = new BigDecimal(0.0d);		
		double tempSecond = bigDecimalSeconds.add(new BigDecimal(now.getNano()))
				                             .divide(new BigDecimal(1000000000.0d),16,RoundingMode.HALF_EVEN)
				                             .add(new BigDecimal(now.getSecond()))
				                             .doubleValue();
			
		calculateJulianDateNumber(year,month,Double.valueOf(days));
		this.hour = hour;
		this.minute = minute;
		this.seconds = tempSecond;
		
		BigDecimal dayPartBig = new BigDecimal(0.0d);		      		
		double dayPart = dayPartBig.add(new BigDecimal(now.getNano()))
				                   .divide(new BigDecimal(1000000000.0d),16,RoundingMode.HALF_EVEN)
				                   .add(new BigDecimal(now.getSecond()))
				                   .divide(new BigDecimal(60.0d),16,RoundingMode.HALF_EVEN)
				                   .add(new BigDecimal(minute))
				                   .divide(new BigDecimal(60.0d),16,RoundingMode.HALF_EVEN)
				                   .add(new BigDecimal(hour))
				                   .divide(new BigDecimal(24.0d),16,RoundingMode.HALF_EVEN)
				                   .doubleValue();
		this.JD += dayPart;
	}
	
	public double getTimeIntervalInDays(int year2, int month2, double days2) throws Exception {
		
		if ((month2 < 1) || (month2 > 12)) {
			throw new IncorrectMonthNumberException("Exception occurred 1003, JulianDate Class: Month number out of range (1..12) exception: month number:"+month2);
		}
		
		int oriYear = this.year;
		int oriMonth = this.month;
		double oriDays = this.days;
		
		calculateJulianDateNumber(year2,month2,days2);
		double JD2 = this.JD;
		this.year2 = year2;
		this.month2 = month2;
		this.days2 = days2;
		
		calculateJulianDateNumber(oriYear,oriMonth,oriDays);
		double JD1 = this.JD;
		
		this.timeIntervalInDays = JD2 - JD1;
		
		return this.timeIntervalInDays;
	}
	
	private void calculateCalendarDate(double JD) {
		
		this.JD = JD;		
		double tempJD = JD + 0.5d;
		
		BigDecimal bigDecimal = new BigDecimal(String.valueOf(tempJD));
		int Z = bigDecimal.intValue();
		
		double F = bigDecimal.subtract(new BigDecimal(Z)).doubleValue();
		
		int A = Z;
		
		if (Z >= 2299161) {
			int alpha = (int) ((Z - 1867216.25d) / 36524.25d);			
			A = Z + 1 + alpha - (int) (alpha / 4);
		}
		
		int B = A + 1524;
		int C = (int) ((B - 122.1d) / 365.25d);
		int D = (int) (365.25d * C);		
		int E = (int) ((B - D) / 30.6001d);
		
		
		//BigDecimals are immutable!!! 
		BigDecimal tempDays = new BigDecimal(B - D - (int) (30.6001d * E) + F);
		this.days = tempDays.intValue();
		this.hour = tempDays.subtract(new BigDecimal(this.days))
				            .multiply(new BigDecimal(24.0d))
				            .intValue();
		this.minute = tempDays.subtract(new BigDecimal(this.days))
				              .multiply(new BigDecimal(24.0d))
				              .subtract(new BigDecimal(this.hour))
				              .multiply(new BigDecimal(60.0d))
				              .setScale(6,RoundingMode.HALF_EVEN)
				              .intValue();
		this.seconds = Double.valueOf(tempDays.subtract(new BigDecimal(this.days))
	                                          .multiply(new BigDecimal(24.0d))
	                                          .subtract(new BigDecimal(this.hour))
	                                          .multiply(new BigDecimal(60.0d))
	                                          .subtract(new BigDecimal(this.minute))
	                                          .multiply(new BigDecimal(60.0d))
	                                          .setScale(6,RoundingMode.HALF_EVEN)
	                                          .intValue());
		this.nano = tempDays.subtract(new BigDecimal(this.days))
	                        .multiply(new BigDecimal(24.0d))
	                        .subtract(new BigDecimal(this.hour))
	                        .multiply(new BigDecimal(60.0d))
	                        .subtract(new BigDecimal(this.minute))
	                        .multiply(new BigDecimal(60.0d))
	                        .subtract(new BigDecimal(this.seconds))
	                        .setScale(9,RoundingMode.HALF_EVEN)
	                        .multiply(new BigDecimal(1000000000.0d))	               
	                        .intValue();
		
		if (E<14) {
			this.month = E - 1;
		}
		
		if (E == 14 || E==15) {
			this.month = E - 13;
		}
		
		if (this.month > 2) {
			this.year = C - 4716;
		}
		
		if (this.month == 1 || this.month == 2) {
			this.year = C - 4715;
		}		
	}
	
	private void calculateJulianDateNumber(int year, int month, double days) throws Exception {
		
		if ((month < 1) || (month > 12)) {
			throw new IncorrectMonthNumberException("Exception occurred 1004, JulianDate Class: Month number out of range (1..12) exception: month number:"+month);
		}
		
		int Y = year;
		
		if (Y < 0) {
			Y -= -1;
		}
		
		int M = month;
		double D = days;
		
		this.year = year;
		this.month = month;
		this.days = D;
		
		this.isGregorionCalendar = isGregorionCalendar(Y,M,D);
		
		if (M <= 2) {
			Y -= 1;
			M += 12;
		}
		
		//In the Gregorian calendar: 1582 October 15 (first day Gregorian calendar)
		int A = (int) (Y / 100);
		int B = 2 - A + (int)  (A/4);
		
		//In the Julian calendar: 1582 October 4 (last day Julian calendar)
		if (!this.isGregorionCalendar) {
			B = 0;
		}
		
		this.JD = (int) (365.25d * (Y + 4716));
		this.JD += (int) (30.6001d * (M+1));
		this.JD += D;
		this.JD += B;
		this.JD -= 1524.5d;			
	}
	
	private String getNameOfTheDay(int dayNumber) throws Exception{
		
		if ((dayNumber < 0) || (dayNumber > 6)) {
			throw new IncorrectWeekDayNumberException("Exception occurred 1005, JulianDate Class: Weekday number out of range (0..6) exception: weekday number:"+dayNumber);
		}
		
		String nameOfTheDay = null;
		
		switch(dayNumber) {
		case 0:
			nameOfTheDay = "Sunday";
			break;
		case 1:
			nameOfTheDay = "Monday";
			break;
		case 2:
			nameOfTheDay = "Tuesday";
			break;
		case 3:
			nameOfTheDay = "Wednesday";
			break;
		case 4:
			nameOfTheDay = "Thursday";
			break;
		case 5:
			nameOfTheDay = "Friday";
			break;		
		case 6:
			nameOfTheDay = "Saturday";
			break;
		}		
		
		return nameOfTheDay;
	}
	
	public String getDayOfTheWeek() throws Exception {
		return getDayOfTheWeek(this.JD);
	}
	
	public String getDayOfTheWeek(double JD) throws Exception {
		double jdAtZeroUT = JD + 1.5d;
		
		int remainder = (int) jdAtZeroUT%7;
		
		return getNameOfTheDay(remainder);
	}
	
	public double getJulianDate() {
		return this.JD;
	}
	
	public double getTFromJulianDate() {
		double t = this.JD;
		t -= 2451545.0d;
		t /= 36525.0d;
		
		this.t = t;
		
		return t;
	}
	
	private boolean isGregorionCalendar(int Y, int M, double D) throws Exception {
		
		if ((M < 1) || (M > 12)) {
			throw new IncorrectMonthNumberException("Exception occurred 1006, JulianDate Class: Month number out of range (1..12) exception: Month number:"+M);
		}
		
		if (Y < 1582) {
			return false; //Julian calendar
		}
		
		if (Y > 1582) {
			return true; //Gregorian calendar
		}
		
		if (Y == 1582) {
			if (M < 10) {
				return false;  //Julian calendar
			}
			
			if (M > 10) {
				return true;  //Gregorian calendar
			}
			
			if (M == 10) {
				
				
				if ((D > 4.0d) && (D < 15.0d)) {
					throw new IncorrectDayNumberException("Exception occurred 1007, JulianDate Class: Date between 1582 Octorber 4th and 1582 October 15th: day number:"+D);
				}
				
				
				if (D <= 4.0d) {
					return false;  //In the Julian calendar: 1582 October 4 (last day Julian calendar)
				} else {
					return true;   //In the Gregorian calendar: 1582 October 15 (first day Gregorian calendar)
				}
			}
		}
		
		return false;
	}
	
	private String getNameOfTheMonth(int month) throws Exception {
		
		if ((month < 1) || (month > 12)) {
			throw new IncorrectMonthNumberException("Exception occurred 1008, JulianDate Class: Month number out of range (1..12) exception: Month number:"+month);
		}
		
		String nameOfTheMonth = null;
		switch(month) {
			case 1:
				nameOfTheMonth = "Januari";
				break;
			case 2:
				nameOfTheMonth = "Februari";
				break;
			case 3:
				nameOfTheMonth = "March";
				break;
			case 4:
				nameOfTheMonth = "April";
				break;
			case 5:
				nameOfTheMonth = "May";
				break;		
			case 6:
				nameOfTheMonth = "June";
				break;		
			case 7:
				nameOfTheMonth = "July";
				break;		
			case 8:
				nameOfTheMonth = "August";
				break;		
			case 9:
				nameOfTheMonth = "September";
				break;		
			case 10:
				nameOfTheMonth = "October";
				break;		
			case 11:
				nameOfTheMonth = "November";
				break;		
			case 12:
				nameOfTheMonth = "December";
				break;		
		}
		
		return nameOfTheMonth;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		
		try {
			if (constructorFlag == 0) {
				
				result.append(this.year+" "+getNameOfTheMonth(this.month)+" "+this.days+"    JD:"+this.JD + " Day of the week:"+getDayOfTheWeek());
				
						
			}
			
			
			
			if (constructorFlag == 1) {
				result.append(           this.year
						                 + " "
						                 + getNameOfTheMonth(this.month)
						                 + " "+this.days
						                 + " at "
						                 + this.hour + "h"
						                 + this.minute+"m"
						                 + this.seconds+"s:"
						                 + "   JD:" + this.JD 
						                 + " Day of the week:"+getDayOfTheWeek()
						      );
			}		
			
			if (constructorFlag == 2) {
				result.append(
						                 "Julian Date:"+this.JD
						                 + ": "
						                 + this.year
						                 + " "
						                 + getNameOfTheMonth(this.month)
						                 + " "+ (int) this.days
						                 + " at "
						                 + this.hour+"h"
						                 + this.minute+"m"
						                 + (int) this.seconds + "s."
						                 + this.nano
						                 + "  Day of the week:"+getDayOfTheWeek()
						      );
			}
			
			if (constructorFlag == 3) {
				result.append("Time interval in days between: " + this.year+" "+getNameOfTheMonth(this.month)+" "+this.days +" and "+this.year2+" "+getNameOfTheMonth(this.month2)+" "+this.days2+" is:"+this.timeIntervalInDays);
			}
			
			if (constructorFlag == 4) {
				result.append(
						                 "Now: "
				                         + this.year
				                         + " "
				                         + getNameOfTheMonth(this.month)
				                         + " "+ (int) this.days
				                         + " at "
				                         + this.hour+"h"
				                         + this.minute+"m"
				                         + (int) this.seconds+"s."
				                         + this.nano
				                         + "   JD:"+this.JD 
				                         + "  Day of the week:"+getDayOfTheWeek()
				              );
			}
		} catch (Exception e) {
			System.out.println("Exception occured:"+e);
		}	
		
		
			
		
		return result.toString();
	}
	
	public String toString2() {
		StringBuilder result = new StringBuilder();
		
		result.append("Year:"+this.year);
	    result.append(System.getProperty("line.separator"));
	    
	    result.append("Month:"+this.month);
	    result.append(System.getProperty("line.separator"));
	    
	    result.append("Day:"+this.days);
	    result.append(System.getProperty("line.separator"));
	    
	    result.append("Hour:"+this.hour);
	    result.append(System.getProperty("line.separator"));
	    
	    result.append("Minute:"+this.minute);
	    result.append(System.getProperty("line.separator"));
	    
	    result.append("Seconds:"+this.seconds);
	    result.append(System.getProperty("line.separator"));
	    
	    result.append("isGregorionCalendar:"+this.isGregorionCalendar);
	    result.append(System.getProperty("line.separator"));
	    
	    result.append("Julian Date Number:"+this.JD);
	    result.append(System.getProperty("line.separator"));
		
		return result.toString();
	}
}
