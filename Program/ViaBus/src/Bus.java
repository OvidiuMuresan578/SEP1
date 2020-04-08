import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a bus
 *
 * @author Krystof Spiller
 * @version 0.3, 05/12/2016
 */

public class Bus implements Serializable
{
	private static final long serialVersionUID = 42L;
	int manufacturingYear;
	int[] seatNumbers;
	String uniqueNumber, plateNumber, manufacturer, model, color;
	boolean toilet, party;
	ArrayList <Schedule> schedules;
	
   /**
	* Six-argument constructor. Color is set to black. Toilet and party bus variables are set to false. 
	* Schedules variable is initialized as an arraylist.
	*
	* @param uniqueNumber
	*    	 the company's unique ID for each bus as a String
	* @param plateNumber
	*    	 the plate number as a String
	* @param manufacturer
	*    	 the manufacturer of a bus as a String
	* @param model
	*    	 the model of a bus as a String
	* @param manufacturingYear  
	*    	 the manufacturing year as an integer, has to be between 1900 and current year
	* @param seatNumbers 
	*    	 the seat numbers as an array of integers
	*/
	
	public Bus(String uniqueNumber, String plateNumber, String manufacturer, String model, int manufacturingYear, int[] seatNumbers)
	{
		this.uniqueNumber = uniqueNumber;
		setPlateNumber(plateNumber);
		this.manufacturer = manufacturer.toUpperCase().charAt(0) + manufacturer.substring(1);
		this.model = model.toUpperCase().charAt(0) + model.substring(1);
		if(manufacturingYear >= 1900 && manufacturingYear <= DateTime.now().getYear())
			this.manufacturingYear = manufacturingYear;
		else
			throw new IllegalArgumentException("Not a valid manufacturing year");
		setSeatNumbers(seatNumbers);
		color = "black";
		toilet = false;
		party = false;
		schedules = new ArrayList<>();
	}
	
   /**
	* @return the company's unique ID for each bus as a String
	*/
	
	public String getUniqueNumber()
	{
		return uniqueNumber;
	}
	
   /**
	* @return the plate number as a String
	*/
	
	public String getPlateNumber()
	{
		return plateNumber;
	}
	
   /**
	* @return the manufacturer of a bus as a String
	*/
	
	public String getManufacturer()
	{
		return manufacturer;
	}
	
   /**
	* @return the model of a bus as a String
	*/
	
	public String getModel()
	{
		return model;
	}
	
	/**
	* @return the manufacturing year as an integer
	*/
	
	public int getManufacturingYear()
	{
		return manufacturingYear;
	}
	
   /**
	* @return the number of seats in a bus as an integer
	*/
	
	public int getNumberOfSeats()
	{
		return seatNumbers.length;
	}
	
   /**
	* @return the seat numbers as an array of integers
	*/
	
	public int[] getSeatNumbers()
	{
		return seatNumbers;
	}
	
   /**
	* @return the color of a bus as a String
	*/
	
	public String getColor()
	{
		return color;
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
	* Compares following 168 hours with all the schedules for the bus. If an hour is overlaping with
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
	* Checks if the bus is available in a given date interval
	* 
	* @param from
	*        Starting date as an object of type DateTime
	* @param to
	*        Ending date as an object of type DateTime
	* @return true if the bus is available
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
	* @return if the bus is a party bus as a boolean
	*/
	public boolean isPartyBus()
	{
		return party;
	}
	
   /**
	* @return if the bus has a toilet as a boolean
	*/
	
	public boolean hasToilet()
	{
		return toilet;
	}
	
	/**
	* Sets the plate number if the inputed plate number is seven characters long. 
	* Otherwise exception for illegal argument is thrown.
	* 
	* @param plateNumber
	*        the plate number of a bus as a String
	*/
	
	public void setPlateNumber(String plateNumber)
	{
		if(plateNumber.length() == 7)
			this.plateNumber = plateNumber;
		else
			throw new IllegalArgumentException("Not a valid plate number");
	}
	
	/**
	 * Sets the color of a bus.
	 * 
	 * @param color
	 *        the color of a bus as a String
	 */
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
   /**
	* Sets the seat numbers of a bus.
	* 
	* @param seatNumbers
	*        an array of integers representing the seat numbers 
	*/
	
	public void setSeatNumbers(int[] seatNumbers)
	{
		this.seatNumbers = seatNumbers;
	}
	
   /**
    * Sets if a bus is a party bus or not.
    * 
	* @param party
	*  	     boolean representing if a bus is a party bus (true) or not (false)
	*/
	
	public void setParty(boolean party)
	{
		this.party = party;
	}

   /**
    * Sets if a bus has a toilet or not.
    * 
	* @param toilet
	*  	     boolean representing if a bus has a toilet (true) or not (false)
	*/

	public void setToilet(boolean toilet)
	{
		this.toilet = toilet;
	}
	
   /**
	* Add a schedule to bus schedules only if the inputed schedule doesn't overlap with other schedules. 
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
	* Removes a schedules from bus schedules.
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
		if(!(obj instanceof Bus))
			return false;
		Bus other = (Bus)obj;
		if(this.getNumberOfSeats() != other.getNumberOfSeats())
			return false;
		for(int i = 0; i < this.getNumberOfSeats(); i++)
			if(this.seatNumbers[i] != other.seatNumbers[i])
				return false;
		return this.schedules.equals(other.schedules) &&
			   this.manufacturingYear == other.manufacturingYear &&
			   this.toilet == other.toilet &&
			   this.party == other.party &&
			   this.uniqueNumber.equals(other.uniqueNumber) &&
			   this.plateNumber.equals(other.plateNumber) &&
			   this.manufacturer.equals(other.manufacturer) &&
			   this.model.equals(other.model) &&
			   this.color.equals(other.color);
	}
}