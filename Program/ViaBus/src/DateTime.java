import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A class representing a date and a time
 *
 * @author Krystof Spiller
 * @version 0.3, 10/12/2016
 */

public class DateTime implements Serializable
{	
	private static final long serialVersionUID = 61L;
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int second;
   
   /**
	* Six-argument constructor with month name.
	*
	* @param day
	*    	 the day as an integer
	* @param monthName
	*    	 the month name as a String
	* @param year
	*    	 the year as an integer
	* @param hour
	*    	 the hour as an integer
	* @param minute  
	*    	 the minute as an integer
	* @param second 
	*    	 the second as an integer
	*/
	
	public DateTime(int day, String monthName, int year, int hour, int minute, int second)
	{
		set(day, monthName, year, hour, minute, second);
	}
   
   /**
	* Six-argument constructor with month number.
	*
	* @param day
	*    	 the day as an integer
	* @param month
	*    	 the month as an integer 
	* @param year
	*    	 the year as an integer
	* @param hour
	*    	 the hour as an integer
	* @param minute  
	*    	 the minute as an integer
	* @param second 
	*   	 the second as an integer
	*/
	
	public DateTime(int day, int month, int year, int hour, int minute, int second)
	{
		set(day, month, year, hour, minute, second);
	}
   
   /**
	* Three-argument constructor with month name.
	*
	* @param day
	*    	 the day as an integer
	* @param monthName
	*    	 the month name as a String
	* @param year
	*    	 the year as an integer
	*/
	
	public DateTime(int day, String monthName, int year)
	{
		set(day, monthName, year);
	}
	

   /**
	* Three-argument constructor with month number.
	*
	* @param day
	*    	 the day as an integer
	* @param month
	*    	 the month as an integer
	* @param year
	*    	 the year as an integer
	*/
	
	public DateTime(int day, int month, int year)
	{
		set(day, month, year);
	}

   /**
	* No-argument constructor with month name. Sets the object to current date and time.
	*/
	
	public DateTime()
	{
		Calendar now = GregorianCalendar.getInstance();
		set(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR), now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now.get(Calendar.SECOND));
	}
   
   /**
	* @return the day as an integer
    */
	
	public int getDay()
	{
		return day;
	}

   /**
	* @return the month as an integer
    */
		
	public int getMonth()
	{
		return month;
	}

   /**
	* @return the month name as a String
    */
		
	public String getMonthName()
	{
		switch (month)
		{
			case 1:  return "January";
			case 2:  return "February";
			case 3:  return "March";
			case 4:  return "April";
			case 5:  return "May";
			case 6:  return "June";
			case 7:  return "July";
			case 8:  return "August";
			case 9:  return "September";
			case 10: return "October";
			case 11: return "November";
			case 12: return "December";
			default: return "Wrong month";
		}
	}

   /**
	* @return the year as an integer
    */
		   
	public int getYear()
	{
		return year;
	}

   /**
	* @return the hour as an integer
    */
		
	public int getHour()
	{
		return hour;
	}

   /**
	* @return the minute as an integer
    */
		   
	public int getMinute()
	{
		return minute;
	}

   /**
	* @return the second as an integer
    */
		   
	public int getSecond()
	{
		return second;
	}

   /**
	* Sets the day, month and year for the DateTime object based on the arguments and
	* sets the hour, minute a second to zero. Processes the arguments:
	* Makes an absolute value of the year argument. 
	* Month is limited from 1 to 12.
	* Day is limited from 1 to maximum day in a month.
	* 
    * @param day
    *        the day as an integer 
    * @param month
    *        the month as an integer
    * @param year
    *        the year as an integer
    */
	
	public void set(int day, int month, int year)
	{
		if(year < 0)
			year = -year;
		this.year = year;

		if(month < 1)
			month = 1;
		if(month > 12)
			month = 12;
		this.month = month;
	   
		if(day < 1)
			day = 1;
		if(day > numberOfDaysInMonth())
			day = numberOfDaysInMonth();
		this.day = day;
		
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}
   
   /**
	* Calls the three-argument set method above after the month name is converted to month number.
	* 
    * @param day
    *        the day as an integer 
    * @param monthName
    *        the month name as a String
    * @param year
    *        the year as an integer
    */
	
	public void set(int day, String monthName, int year)
	{
		int month = DateTime.convertToMonthNumber(monthName);
		this.set(day, month, year);
	}
   
   /**
	* Calls the three-argument set method with integers and sets
	* hour, minute and second. Processes the arguments:
	* Hour is limited from 0 to 23.
	* Minute and second is limited from 0 to 59.
	*
	* @param day
	*    	 the day as an integer
	* @param month
	*    	 the month as an integer 
	* @param year
	*    	 the year as an integer
	* @param hour
	*    	 the hour as an integer
	* @param minute  
	*    	 the minute as an integer
	* @param second 
	*   	 the second as an integer
	*/
	
	public void set(int day, int month, int year, int hour, int minute, int second)
	{
		set(day, month, year);
		if(hour < 0)
			hour = 0;
		if(hour > 23)
			hour = 23;
		this.hour = hour;
		
		if(minute < 0)
			minute = 0;
		if(minute > 59)
			minute = 59;
		this.minute = minute;
	   
		if(second < 0)
			second = 0;
		if(second > 59)
			second = 59;
		this.second = second;
	}
   
   /**
	* Calls the six-argument set method above after the month name is converted to month number.
	* 
    * @param day
    *        the day as an integer 
    * @param monthName
    *        the month name as a String
    * @param year
    *        the year as an integer
    * @param hour
	*    	 the hour as an integer
	* @param minute  
	*    	 the minute as an integer
	* @param second 
	*   	 the second as an integer
    */
	
	public void set(int day, String monthName, int year, int hour, int minute, int second)
	{
		int month = DateTime.convertToMonthNumber(monthName);
		set(day, month, year, hour, minute, second);
	}
	
   /**
    * Sets the day for the DateTime object.
    * 
    * @param day
    * 		 the day as an integer 
    */
	
	public void setDay(int day)
	{
		set(day, month, year, hour, minute, second);
	}

   /**
    * Sets the month for the DateTime object.
    * 
    * @param month
    * 		 the month as an integer 
    */
	
	public void setMonth(int month)
	{
		set(day, month, year, hour, minute, second);
	}

   /**
    * Sets the month for the DateTime object after the month name is converted to month number.
    * 
    * @param month
    * 		 the month as a String 
    */
	
	public void setMonth(String month)
	{
		set(day, month, year, hour, minute, second);
	}
   
   /**
    * Sets the year for the DateTime object.
    * 
    * @param year
    * 		 the year as an integer 
    */
	
	public void setYear(int year)
	{
		set(day, month, year, hour, minute, second);
	}
   
   /**
    * Sets the hour for the DateTime object.
    * 
    * @param hour
    * 		 the hour as an integer 
    */
	
	public void setHour(int hour)
	{
		set(day, month, year, hour, minute, second);
	}
	   
   /**
    * Sets the minute for the DateTime object.
    * 
    * @param minute
    * 		 the minute as an integer 
    */

	public void setMinute(int minute)
	{
		set(day, month, year, hour, minute, second);
	}
   
   /**
    * Sets the second for the DateTime object.
    * 
    * @param second
    * 		 the second as an integer 
    */
	
	public void setSecond(int second)
	{
		set(day, month, year, hour, minute, second);
	}
   
   /**
    * @return whether the year is leap year (true) or not (false) 
    */
	
	public boolean isLeapYear()
	{
		return (year % 4 == 0 && ((year % 100 != 0) || (year % 400 == 0)));
	}	

   /**
    * Steps forward by one day. Takes care of stepping on next month or next year.
    */
	
	public void stepForwardOneDay()
	{
		day++;
		if(day > numberOfDaysInMonth())
		{
			day = 1;
			month++;
			if (month > 12)
			{
				month = 1;
				year++;
			}
		}
	}

   /**
    * Steps forward by number of days specified in the argument 
    * by calling the stepForwardOneDay method in a loop
    * 
    * @param days
    * 		 number of days the DateTime steps forward as an integer
    */
	
	public void stepForward(int days)
	{
		for (int i = 0; i < days; i++)
			stepForwardOneDay();
	}
	
   /**
    * @return the number of days in month as an integer
    */
	
	public int numberOfDaysInMonth()
	{
		switch (month)
		{
			case 4:
	   		case 6:
	   		case 9:
	   		case 11:
	   			return 30;
	   		case 2:
	   			if(isLeapYear())
	   				return 29;
	   			else
	   				return 28;
	   		default:
	   			return 31;
		}	
	}

   /**
    * Calculates the number of years between a given date in the argument and this date
    * 
    * @param other
    * 		 the other date as a DateTime object
    * @return the number of years between this DateTime and other DateTime specified in the argument.
    */
	
	public int yearsBetween(DateTime other)
	{
		int years = Math.abs(this.year - other.year);

		DateTime date1 = new DateTime(this.day, this.month, 2000);
		DateTime date2 = new DateTime(other.day, other.month, 2000);

		if((this.isBefore(other) && date2.isBefore(date1)) || ((other.isBefore(this) && date1.isBefore(date2))))
			years--;
		return years;
	}

   /**
    * Calculates the number of days between a given date in the argument and this date
    * 
    * @param other
    * 		 the other date as a DateTime object
    * @return the number of days between this DateTime and other DateTime specified in the argument.
    */
	
	public int daysBetween(DateTime other)
	{
		int days = 0;

	    DateTime counterDate, endDate;

	    if (this.isBefore(other))
	    {
	    	counterDate = new DateTime(this.day, this.month, this.year);
	    	endDate = new DateTime(other.day, other.month, other.year);
	    }
	    else
	    {
	    	counterDate = new DateTime(other.day, other.month, other.year);
	    	endDate = new DateTime(this.day, this.month, this.year);
	    }
	    
	    while (!counterDate.equals(endDate))
	    {
	    	days++;
	    	counterDate.stepForwardOneDay();
	    }
	    return days;
	}

   /**
    * Calculates the time between a given date in the argument and this date 
    * 
    * @param other
    * 		 the other date as a DateTime object
    * @return the DateTime object representing the time between this and other DateTime
    */
	
	public DateTime dateTimeBetween(DateTime other)
	{
		int seconds = 0, minutes = 0, hours = 0, days = 0;
		DateTime from, to, result = new DateTime(0, 0, 0);
		
		if(this.isBefore(other))
		{
			from = this;
			to = other;
		}
		else
		{
			from = other;
			to = this;
		}
		
		seconds += to.getSecond() - from.getSecond();
		if(seconds < 0)
		{
			seconds += 60;
			minutes--;
		}
		
		minutes += to.getMinute() - from.getMinute();
		if(minutes < 0)
		{
			minutes += 60;
			hours--;
		}
		
		hours += to.getHour() - from.getHour();
		if(hours < 0)
		{
			hours += 24;
			days--;
		}
		
		days += from.daysBetween(to);
		
		result.stepForward(days);
		result.setHour(hours);
		result.setMinute(minutes);
		result.setSecond(seconds);
		return result;
	}
	
   /**
    * Returns values in a format appropriate for calculation.
    * 
    * @return an array of six integers, representing years, months, days, hours, minutes and seconds
    */
	
	public int[] toArray()
	{
		int[] lengths = new int[6];
		lengths[0] = this.getYear();
		lengths[1] = this.getMonth() - 1;
		lengths[2] = this.getDay() - 1;
		lengths[3] = this.getHour();
		lengths[4] = this.getMinute();
		lengths[5] = this.getSecond();
		return lengths;
	}
	
   /**
    * Adds to this DateTime an other DateTime specified in the argument.
    * 
    * @param other
    * 		 the other date as a DateTime object
    */
	
	public void addDateTime(DateTime other)
	{
		int[] thisArray = this.toArray(), otherArray = other.toArray(), resultArray = new int[6];
		
		for(int i = 0; i < 6; i++)
			resultArray[i] = thisArray[i] + otherArray[i];
		
		if(resultArray[5] >= 60) // seconds
		{
			resultArray[5] -= 60;
			resultArray[4]++;
		}
		if(resultArray[4] >= 60) // minutes
		{
			resultArray[4] -= 60;
			resultArray[3]++;
		}
		if(resultArray[3] >= 24) // hours
		{
			resultArray[3] -= 24;
			resultArray[2]++;
		}
		if(resultArray[1] >= 12) // months
		{
			resultArray[1] -= 12;
			resultArray[0]++;
		}
		
		this.set(resultArray[2] + 1, resultArray[1] + 1, resultArray[0], resultArray[3], resultArray[4], resultArray[5]);
		
		if(resultArray[2] >= numberOfDaysInMonth()) // days
		{
			this.setDay(1);
			System.out.println(this);
			this.stepForward(numberOfDaysInMonth());
		}
	}
	
   /**
    * Compares this DateTime with the DateTime specified in the argument and returns if it's before or not.
    * 
    * @param other
    * 		 the date and time which is compared to this object's date and time
    * @return if the other DateTime specified in the argument is before this DateTime (true) or not (false)
    */
	
	public boolean isBefore(DateTime other)
	{
		return ((this.year < other.getYear()) || (this.year == other.getYear() && this.month < other.getMonth()) || 
			    (this.year == other.getYear() && this.month == other.getMonth() && this.day < other.getDay()) ||
			    (this.year == other.getYear() && this.month == other.getMonth() && this.day == other.getDay() && this.hour < other.getHour()) ||
			    (this.year == other.getYear() && this.month == other.getMonth() && this.day == other.getDay() && this.hour == other.getHour() && this.minute < other.getMinute()) || 
			    (this.year == other.getYear() && this.month == other.getMonth() && this.day == other.getDay() && this.hour == other.getHour() && this.minute == other.getMinute() && this.second < other.getSecond()));
	}

   /**
    * @return the copy of this DateTime
    */
	
	public DateTime copy()
	{
		return new DateTime(day, month, year, hour, minute, second);
	}
   
   /**
    * @param monthName
    * 		 the month name as a String
    * @return the number of the month as an integer based on the month name specified in the argument
    */
	
	public static int convertToMonthNumber(String monthName)
	{
		monthName = monthName.toUpperCase().charAt(0) + monthName.substring(1).toLowerCase();
		int month;
		switch(monthName)
		{
			case "January": 	month = 1; break;
			case "February": 	month = 2; break;
			case "March": 		month = 3; break;
			case "April": 		month = 4; break;
			case "May": 		month = 5; break;
			case "June": 		month = 6; break;
			case "July":		month = 7; break;
			case "August": 		month = 8; break;
			case "September": 	month = 9; break;
			case "October": 	month = 10; break;
			case "November": 	month = 11; break;
			case "December": 	month = 12; break;
			default:			month = 0; break;
		}
		return month;
	}

   /**
    * Parses the string specified in the argument. First splits the string in the argument by every dot,
    * slash, hyphen, space or underscore. Then it checks, if the string has been split to three parts and
    * all the parts contain only numbers. If this condition is true, then it parses the individual parts to
    * day, month and year. If these variables are within their respective limits with their values, the
    * DateTieme object is created and returned.
    * 
    * @param string
    * 		 the string which is parsed
    * @return the DateTime object if the string could be parsed, otherwise returns null
    */
	
	public static DateTime parse(String string)
	{
		String[] dateParts = string.split("[./ _-]");
		DateTime dateTime = null;
		if(dateParts.length == 3 && !dateParts[0].matches(".*[^0-9].*") && !dateParts[1].matches(".*[^0-9].*") && !dateParts[2].matches(".*[^0-9].*"))
		{
			int day = Integer.parseInt(dateParts[0]);
			int month = Integer.parseInt(dateParts[1]);
			int year = Integer.parseInt(dateParts[2]);
			if(day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <= 9999)
				dateTime = new DateTime(day, month, year);
		}
		return dateTime;
	}
	
   /**
	* @return the DateTime object with current date and time.
	*/
	
	public static DateTime now()
	{
		return new DateTime();
	}
   
   /**
	* Comparing objects to one another.
    * 
    * @param obj
    * 		 an Object for comparison
    * @return if the objects equal to each other   
    */
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof DateTime))
			return false;
		DateTime other = (DateTime)obj;
		return day == other.day && month == other.month && year == other.year && hour == other.hour && minute == other.minute && second == other.second;
	}

   /**
	* Returns a DateTime object in a format "day/month/year hour:minute:second" and for
	* day, month and time it always keeps two characters (e.g. 07/09/2016 12:05:29).
    * 
    * @return if the objects equal to each other   
    */
	
	public String toString()
	{
		String s = "";
		if(day < 10)
			s += "0";
		s += day + "/";
      
		if(month < 10)
			s += "0";
		s += month + "/" + year + " " + hour + ":";

		if(minute < 10)
			s += "0";
		s += minute + ":";
		
		if(second < 10)
			s += "0";
		s += second;
		
		return s;
	}	
}