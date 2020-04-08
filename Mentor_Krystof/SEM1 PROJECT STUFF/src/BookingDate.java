import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
/**
 * 
 * Class used to store the checkin and checkout dates for a booking
 * @author Anton Akov
 *
 */
public class BookingDate implements Serializable
{
   private Calendar date1;
   private Calendar date2;
   private SimpleDateFormat format;
   //private boolean hasHours;
   //private SimpleDateFormat formatHours;
   private boolean date1TimeSet;
   private boolean date2TimeSet;
   
   /**
    * default constructor
    */
   public BookingDate()
   {
      date1 = Calendar.getInstance();
      date2 = Calendar.getInstance();
      date1TimeSet = false;
      date2TimeSet = false;
   }
   
   /**
    * 2-argument contstructor which parses the dates from the 2 arguments and turns them into Calendar objects
    * @param in check in date in string, "01.01.2015 00:00" or "01.01.2015" format
    * @param out check out date in string, "01.01.2015 00:00" or "01.01.2015" format
    */
   public BookingDate(String in, String out)
   {
      date1 = Calendar.getInstance();
      date2 = Calendar.getInstance();
      //hasHours = false;
      
      date1TimeSet = true;
      date2TimeSet = true;
      
      
      format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
      try
      {
         date1.setTime(format.parse(in));
      }
      catch (ParseException e)
      {
         try{
            date1TimeSet = false;
            format.applyPattern("dd.MM.yyyy");
            date1.setTime(format.parse(in));
         }
         catch (ParseException e1){}
      }
      format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
      try
      {
         date2.setTime(format.parse(out));
      }
      catch (ParseException e)
      {
         try{
            date2TimeSet = false;
            format.applyPattern("dd.MM.yyyy");
            date2.setTime(format.parse(out));
         }
         catch (ParseException e1){}
      }
      
      
   }
   /**
    * creates a new object from 2 existing calendars
    * @param d1 first one, the check in date
    * @param d2 second one, the checkout date
    */
   public BookingDate(Calendar d1, Calendar d2)
   {
      date1 = d1;
      date2 = d2;
      
      date1TimeSet = false;
      date2TimeSet = false;
   }
   
   /**
    * sets the current checkin to the new one
    * @param c string of the new one
    */
   public void setCheckIn(String c)
   {
      try
      {
         date1.setTime(format.parse(c));
      }
      catch (ParseException e)
      {
      }
   }
   /**
    * sets the current checkout to the new one
    * @param c string of the new one
    */
   public void setCheckOut(String c)
   {
      try
      {
         date2.setTime(format.parse(c));
      }
      catch (ParseException e)
      {
      }
   }
   /** 
    * grants access to the first date
    * @return Calendar object
    */
   public Calendar getCheckIn(){return date1;}
   /** 
    * grants access to the second date
    * @return Calendar object
    */
   public Calendar getCheckOut(){return date2;}
   
   //System.out.println(cal.get(Calendar.DATE)+(("."+(cal.get(Calendar.MONTH)+1)).length()<3?".0"+(cal.get(Calendar.MONTH)+1):"."+(cal.get(Calendar.MONTH)+1))+"."+cal.get(Calendar.YEAR));
 
   //public boolean getHasHours(){return hasHours;}
   /**
    * Returns just the expected arrival date without the exact time
    * @return String of the date in the "01.01.2015" format
    */
   public String getCheckInDateString()
   {
      SimpleDateFormat tempF = new SimpleDateFormat("dd.MM.yyyy");
      return tempF.format(date1.getTime());
   }
   /**
    * Returns just the expected departure date without the exact time
    * @return String of the date in the "01.01.2015" format
    */
   public String getCheckOutDateString()
   {
      SimpleDateFormat tempF = new SimpleDateFormat("dd.MM.yyyy");
      return tempF.format(date2.getTime());
   }
   /**
    * Returns only the exact time of the arrival date
    * @return "Unknown" if the time has not been set manually, else a string in the "HH:mm" format
    */
   public String getCheckInHourString()
   {
      if(!date1TimeSet)return "Unknown";
      SimpleDateFormat tempF = new SimpleDateFormat("HH:mm");
      return tempF.format(date1.getTime());
   }
   /**
    * Returns only the exact time of the departure date
    * @return "Unknown" if the time has not been set manually, else a string in the "HH:mm" format
    */
   public String getCheckOutHourString()
   {
      if(!date2TimeSet)return "Unknown";
      SimpleDateFormat tempF = new SimpleDateFormat("HH:mm");
      return tempF.format(date2.getTime());
   }
   
   /**
    * returns the current format used to format the dates
    * @return the current state of the SimpleDateFormat object
    */
   public SimpleDateFormat getFormat(){return format;}
   
   /**
    * returns the number of nights between the 2 dates in the object, independant of the time of day
    * @return the number of nights
    */
   public long getNumberOfNights()
   {
      if(date2.get(Calendar.HOUR_OF_DAY)<date1.get(Calendar.HOUR_OF_DAY))return TimeUnit.DAYS.convert(date2.getTime().getTime()-date1.getTime().getTime(), TimeUnit.MILLISECONDS)+1;
      return TimeUnit.DAYS.convert(date2.getTime().getTime()-date1.getTime().getTime(), TimeUnit.MILLISECONDS);
   }
   
   /**
    * Method copied from one of the referanced websites, checks if 2 calendar objects are pointing to the same day in time
    * @param cal1 first calendar
    * @param cal2 2nd calendar
    * @return returns true if they're on the same day
    */
   public static boolean isSameDay(Calendar cal1, Calendar cal2)
   {
      if (cal1 == null || cal2 == null) {
          throw new IllegalArgumentException("The dates must not be null");
      }
      return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
              cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
              cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
   }
   /**
    * checks if a specific date is today
    * @param cal the specific day
    * @return returns true it the day matches
    */
   public static boolean isToday(Calendar cal)
   {
      return isSameDay(cal, Calendar.getInstance());
   }
   /**
    * returns wether one of the 2 dates in the BookingDate object are on today's day
    * @return true if either of them is
    */
   public boolean isDateToday()
   {
      return isToday(date1) || isToday(date2);
   }
   /**
    * method used in the home tab to return just the hour depending on which day in the booking matches the current one
    * @return either hour of arrival or departure depending on which one is today
    */
   public String getCalendarString()
   {
      if(isToday(date1))return getCheckInHourString();
      if(isToday(date2))return getCheckOutHourString();
      
      
      
      return "";
   }
   /**
    * method that checks if the date its called from overlaps with the one given in the argument
    * @param d date to check for
    * @return true if they overlap, false if they're clear apart
    */
   public boolean Overlaps(BookingDate d)
   {
	   if(date1.getTime().after(d.getCheckOut().getTime())||date2.getTime().before(d.getCheckIn().getTime()))return false;
	   
	   return true;
	   
   }
   
   @Override
   /**
    * default autogenerated hashCode
    */
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((date1 == null) ? 0 : date1.hashCode());
      result = prime * result + (date1TimeSet ? 1231 : 1237);
      result = prime * result + ((date2 == null) ? 0 : date2.hashCode());
      result = prime * result + (date2TimeSet ? 1231 : 1237);
      result = prime * result + ((format == null) ? 0 : format.hashCode());
      return result;
   }

    
   @Override
   /**
    * default autogenerated equals method
    */
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (!(obj instanceof BookingDate))
         return false;
      BookingDate other = (BookingDate) obj;
      if (date1 == null)
      {
         if (other.date1 != null)
            return false;
      }
      else if (!date1.equals(other.date1))
         return false;
      if (date1TimeSet != other.date1TimeSet)
         return false;
      if (date2 == null)
      {
         if (other.date2 != null)
            return false;
      }
      else if (!date2.equals(other.date2))
         return false;
      if (date2TimeSet != other.date2TimeSet)
         return false;
      if (format == null)
      {
         if (other.format != null)
            return false;
      }
      else if (!format.equals(other.format))
         return false;
      return true;
   }
   /**
    * return format example: 02.12.2015 (Unknown)  - 15.12.2015 (10:00)
    */
   public String toString()
   {
      return getCheckInDateString() + " (" + getCheckInHourString()+") "+ " - " + getCheckOutDateString() + " (" + getCheckOutHourString()+") ";
   }
}
