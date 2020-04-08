import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a chauffeur
 *
 * @author Krystof Spiller
 * @version 0.2, 12/12/2016
 */

public class Chauffeur implements Serializable
{
	private static final long serialVersionUID = 52L;
	private String fullName, address, ID, phoneNumber, emailAddress, wishes;
	private boolean fullTime;
	ArrayList <Schedule> schedules;
	
   /**
    * Six-argument constructor. String representing wishes of a chauffeur is set to a empty string.
    * Schedules variable is initialized as an arraylist. 
    * 
    * @param fullName
    *    	 the full name of a chauffeur as a String
    * @param address
    *        the address of a chauffeur as a String
    * @param ID
    *    	 the 5-digit unique employee id as a String
    * @param phoneNumber
    *    	 the phone number as a String
    * @param emailAddress
    *        the email address as a String
    * @param fullTime
    *    	 boolean representing if a chauffeur is a full time employee (true) or not (false)
    */
	
	public Chauffeur(String fullName, String address, String ID, String phoneNumber, String emailAddress, boolean fullTime)
	{
		setFullName(fullName);
		setAddress(address);
		setID(ID);
		setPhoneNumber(phoneNumber);
		setEmailAddress(emailAddress);
		setFullTime(fullTime);
		wishes = "";
		schedules = new ArrayList<>();
	}
	
   /**
	* @return the full name of a chauffeur as a String
	*/
	
	public String getFullName()
	{
		return fullName;
	}
	
   /**
	* @return the address of a chauffeur as a String
    */
		
	public String getAddress()
	{
		return address;
	}
	
   /**
	* @return the 5-digit unique employee ID of a chauffeur as a String
	*/

	public String getID()
	{
		return ID;
	}
	
   /**
	* @return the 8-character phone number of a chauffeur as a String
	*/
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
   /**
	* @return the email address of a chauffeur as a String
	*/
		
	public String getEmail()
	{
		return emailAddress;
	}
	
   /**
	* @return the whether a chauffeur is a full time employee (true) or not (false)
    */
	
	public boolean getFullTime()
	{
		return fullTime;
	}
  
	/**
	* @return the wishes of a chauffeur as a String
	*/
	
	public String getWishes()
	{
		return wishes;
	}
	
   /**
	* Converts an arraylist to an array and returns it.
	* 
	* @return the schedules as an array of Schedule objects
	*/
	
	public Schedule[] getSchedules()
	{
		Schedule[] schedules = new Schedule[this.schedules.size()];
		for(int i = 0; i < schedules.length; i++)
			schedules[i] = this.schedules.get(i);
		return schedules;
	}
	
   /**
	* Compares following 168 hours with all the schedules for the chauffeur. If an hour is overlaping with
	* bus schedule, the respective hour is set to true in a two dimensional array. First dimension 
	* represents the number of days, second number of hours in a day.
	* 
	* @return the week schedule as a two dimensional array of booleans
	*/
	
	public boolean[][] getWeekSchedule()
	{
		boolean[][] weekSchedule = new boolean[7][24];
		for(int i = 0; i < 7; i++)
			for(int j = 0; j < 24; j++)
				weekSchedule[i][j] = false;
		
		DateTime startOfTheWeek = new DateTime(), endOfTheWeek = new DateTime();
		startOfTheWeek.setHour(0);
		startOfTheWeek.setMinute(0);
		startOfTheWeek.setSecond(0);
		
		endOfTheWeek.stepForward(6);
		endOfTheWeek.setHour(23);
		endOfTheWeek.setMinute(59);
		endOfTheWeek.setSecond(59);
		
		Schedule week = new Schedule(new Stop("start", startOfTheWeek), new Stop("end", endOfTheWeek));
		
		for(int i = 0; i < schedules.size(); i++)
			if(schedules.get(i).overlap(week))
			{
				DateTime counter = startOfTheWeek.copy();
				for(int j = 0; j < 7; j++)
				{
					for(int k = 0; k < 24; k++)
					{
						counter.setHour(k);
						if(schedules.get(i).overlap(counter))
							weekSchedule[j][k] = true;
					}
					counter.stepForwardOneDay();
				}
			}
		return weekSchedule;
	}
	
   /**
	* Checks if the chauffeur is available in a given date interval
	* 
	* @param from
	*        Starting date as an object of type DateTime
	* @param to
	*        Ending date as an object of type DateTime
	* @return true if the chauffeur is available
	*/
	
	public boolean isAvailable(DateTime from, DateTime to)
	{
		Schedule fromTo = new Schedule(new Stop("from", from), new Stop("to", to));
		for(int i = 0; i < schedules.size(); i++)
			if(schedules.get(i).overlap(fromTo))
				return false;
		return true;
	}

   /**
	* Calculates how many hours a chauffeur worked in current month
	* 
	* @return number of hours worked this month as an integer
	*/

	public int getHoursWorkedThisMonth()
	{
		int currentMonth = DateTime.now().getMonth();
		int currentYear = DateTime.now().getYear();
		
		DateTime firstDay = new DateTime(1, currentMonth, currentYear);
		DateTime lastDay = new DateTime(firstDay.numberOfDaysInMonth(), currentMonth, currentYear, 23, 59, 59);
		
		Schedule thisMonth = new Schedule(new Stop("first day", firstDay), new Stop("last day", lastDay));
		
		DateTime counter = new DateTime(0, 0, 0, 0, 0, 0);
		for(int i = 0; i < schedules.size(); i++)
			if(schedules.get(i).overlap(thisMonth))
			{
				if(schedules.get(i).getFrom().isBefore(firstDay))
				{
					Schedule help = schedules.get(i);
					help.setFrom(firstDay);
					counter.addDateTime(help.getLength());
				}
				else if(lastDay.isBefore(schedules.get(i).getTo()))
				{
					Schedule help = schedules.get(i);
					help.setTo(lastDay);
					counter.addDateTime(help.getLength());
				}
				else
					counter.addDateTime(schedules.get(i).getLength());
			}
		int[] lenghts = counter.toArray();
		return lenghts[2] * 24 + lenghts[3];
	}
	
   /**
	* Sets the full name of a chauffeur. Capitalizes the first letter of the inputed string.
	* 
	* @param fullName
	*        the full name of a chauffeur as a String
	*/
	
	public void setFullName(String fullName) 
	{
		this.fullName = fullName.toUpperCase().charAt(0) + fullName.substring(1);
	}
	
   /**
	* Sets the address of a chauffeur.
	* 
	* @param address
	*        the address of a chauffeur as a String
	*/
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
   /**
	* Sets the 5-digit unique employee id of a chauffeur.
	* Inputed ID has to be 5 characters long, otherwise exception for illegal argument is thrown.
	* 
	* @param ID
	*        the ID of a chauffeur as a String
	*/
	
	public void setID(String ID)
	{
		if(ID.length() == 5)
			this.ID = ID;
		else
			throw new IllegalArgumentException("Not a valid ID");
	}
	
   /**
    * Sets the phone number of a chauffeur. Inputed string is processed so prefix for Denmark is erased if it's present, 
    * spaces are deleted and the resulting string is checked if it consists only of 8 digits. 
    * Otherwise exception for illegal argument is thrown
    * 
    * @param phoneNumber
    *        the phone number of a chauffeur as a String
    */
	
	public void setPhoneNumber(String phoneNumber)
	{
		if(phoneNumber.substring(0, 3).equals("+45"))
			phoneNumber = phoneNumber.substring(3);
		phoneNumber = phoneNumber.replaceAll("\\s+",""); // regex for whitespace
		if(phoneNumber.matches("[0-9]+") && phoneNumber.length() == 8)
			this.phoneNumber = phoneNumber;
		else
			throw new IllegalArgumentException("Not a valid phone number");
	}
	
   /**
	* Sets the email address of a chauffeur. Inputed string is not a valid email address if '@' (at sign) is the first letter, 
	* the last letter or isn't in the sting at all. In one or more of these cases, the exception for illegal argument is thrown.
	* 
	* @param emailAddress
	*        The email address of a chauffeur as a String
	*/
		
	public void setEmailAddress(String emailAddress)
	{
		if(emailAddress.indexOf('@') != -1 && emailAddress.indexOf('@') != 0 && emailAddress.indexOf('@') != (emailAddress.length() - 1))
			this.emailAddress = emailAddress;
		else
			throw new IllegalArgumentException("Not a valid email address");
	}
	
   /**
    * Sets if a chauffeur is a full time employee or not.
    * 
    * @param fullTime
    *        boolean representing if a chauffeur is a full time employee (true) or not (false)
    */
	
	public void setFullTime(boolean fullTime)
	{
		this.fullTime = fullTime;
	}
	
   /**
    * Sets the wishes of a chauffeur.
    * 
    * @param wishes
    *        the wishes of a chauffeur as a String
    */
	
	public void setWishes(String wishes)
	{
		this.wishes = wishes;
	}
	   
   /**
	* Add a schedule to chauffeur's schedules only if the inputed schedule doesn't overlap with other schedules. 
	* Otherwise it has no effect.
	* 
	* @param schedule
	*        an object of type Schedule
	*/
	
	public void addSchedule(Schedule schedule)
	{
		for(int i = 0; i < schedules.size(); i++)
			if(schedules.get(i).overlap(schedule))
				return;
		schedules.add(schedule);
	}
	   
   /**
	* Removes a schedule from chauffeur's schedules.
	* 
	* @param schedule
	*        an object of type Schedule 
	*/
	
	public void removeSchedule(Schedule schedule)
	{
		schedules.remove(schedule);
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
		if(!(obj instanceof Chauffeur))
			return false;
		Chauffeur other = (Chauffeur)obj;
		return this.schedules.equals(other.schedules) &&
			   this.fullTime == other.fullTime &&
			   this.fullName.equals(other.fullName) &&
			   this.address.equals(other.address) &&
			   this.ID.equals(other.ID) &&
			   this.phoneNumber.equals(other.phoneNumber) &&
			   this.emailAddress.equals(other.emailAddress) &&
			   this.wishes.equals(other.wishes);
	}
}