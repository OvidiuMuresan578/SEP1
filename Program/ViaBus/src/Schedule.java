import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a schedule
 *
 * @author Krystof Spiller
 * @version 0.3, 05/12/2016
 */

public class Schedule implements Serializable
{
	private static final long serialVersionUID = 37L;
	ArrayList <Stop> stops;
	
   /**
	* Two-argument constructor. Stops variable is initialized as an arraylist and start stop
	* and end stop from the arguments are added to this arraylist.
	*
	* @param start
	*    	 the start of the schedule
	* @param end
	*    	 the end of the schedule
	*/
	
	public Schedule(Stop start, Stop end)
	{
		if(start.getDateTime().isBefore(end.getDateTime()))
		{
			stops = new ArrayList<>();
			stops.add(start);
			stops.add(end);
		}
		else
			throw new IllegalArgumentException("Start date is before end date");
	}
	
   /**
	* @return the start date as a DateTime object
    */
	
	public DateTime getFrom()
	{
		return stops.get(0).getDateTime();
	}
	
   /**
	* @return the end date as a DateTime object
    */
	
	public DateTime getTo()
	{
		return stops.get(stops.size() - 1).getDateTime();
	}
	
   /**
    * @return the length of the schedule, which means the time between the start and end date, 
    * 		  as a DateTime object
    */

	public DateTime getLength()
	{
		return getFrom().dateTimeBetween(getTo());
	}
	
   /**
	* Converts an arraylist to an array and returns it.
	* 
	* @return the stops as an array of Stop objects
	*/
	
	public Stop[] getStops()
	{
		Stop[] stops = new Stop[this.stops.size()];
		for(int i = 0; i < stops.length; i++)
			stops[i] = this.stops.get(i);
		return stops;
	}
	
   /**
    * @param index
	* 		 the index of the Stop object in an arraylist as an integer
	* @return the object of type Stop on the given index of an arraylist only if the index is within the
	* 		  size boundaries of a stops arraylist
	*/
	
	public Stop getStop(int index)
	{
		if(index >= 0 && index < stops.size())
			return stops.get(index);
		return null;
	}
	
   /**
	* Sets the start date if the inputed DateTime object is before the end date 
	* 
	* @param from
	*        the start date as a DateTime object
	*/
	
	public void setFrom(DateTime from)
	{
		if(from.isBefore(getTo()))
			stops.get(0).setDateTime(from);
	}
	
   /**
	* Sets the end date if the start date is before the inputed DateTime object
	* 
	* @param to
	*        the end date as a DateTime object
	*/
	
	public void setTo(DateTime to)
	{
		if(getFrom().isBefore(to))
			stops.get(stops.size() - 1).setDateTime(to);
	}
	
   /**
	* Sets the main destination from the schedule for only the stop number which is specified
	* in the argument, if the stop number is between the first and the last one. 
	* 
	* @param stopNumber
	*        the stop number as an integer
	*/
	
	public void setMainDestination(int stopNumber)
	{
		if(stopNumber >= 1 && stopNumber <= (stops.size() - 2))
		{
			for(int i = 0; i < stops.size(); i++)
				stops.get(i).unsetAsMainDestination();
			stops.get(stopNumber).setAsMainDestination();
		}
	}
	
   /**
	* Adds a stop to the list of stops to the penultimate position if the DateTime is before 
	* the end date and after the DateTime of the current penultimate stop
	* 
	* @param stop
	*        a stop of type Stop
	*/
	
	public void addStop(Stop stop)
	{
		if(stops.get(stops.size() - 2).getDateTime().isBefore(stop.getDateTime()) && (stop.getDateTime().isBefore(getTo())))
			stops.add(stops.size() - 1, stop);
	}
	
   /**
	* Deletes a stop from the list of stops from the penultimate position
	*/
	
	public void deleteStop()
	{
		if(stops.size() > 2)
			stops.remove(stops.size() - 2);
	}
	
   /**
	* Checks if this schedule overlaps with the schedule inputed in the argument.
	* 
	* @param schedule
	* 		 a Schedule object
	* @return boolean representing if the two schedules overlaps (true) or not (false)
	*/
	
	public boolean overlap(Schedule schedule)
	{
		return !(((this.getFrom().isBefore(schedule.getFrom())) && (this.getTo().isBefore(schedule.getFrom())) &&
				  (this.getFrom().isBefore(schedule.getTo())) && (this.getTo().isBefore(schedule.getTo()))) || 
				 ((!this.getFrom().isBefore(schedule.getFrom())) && (!this.getTo().isBefore(schedule.getFrom())) &&
				  (!this.getFrom().isBefore(schedule.getTo())) && (!this.getTo().isBefore(schedule.getTo()))));
	}

   /**
	* Checks if this schedule overlaps with the DateTime inputed in the argument.
	* 
	* @param dateTime
	* 		 a DateTime object
	* @return boolean representing if the schedule and the dateTime overlaps (true) or not (false)
	*/
	
	public boolean overlap(DateTime dateTime)
	{
		return (dateTime.isBefore(getTo()) && !dateTime.isBefore(getFrom()));
	}
	
   /**
	* Checks if the schedule has in of its stops the destination specified in the argument
	* 
	* @param destination
	* 		 a destination as a String
	* @return boolean representing if the schedule contains specified destination (true) or not (false)
	*/
	
	public boolean hasDestination(String destination)
	{
		for(int i = 0; i < stops.size(); i++)
			if(stops.get(i).getDestination().equals(destination))
				return true;
		return false;
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
		if(!(obj instanceof Schedule))
			return false;
		Schedule other = (Schedule)obj;
		for(int i = 0; i < this.stops.size(); i++)
			if(!this.stops.get(i).equals(other.stops.get(i)))
				return false;
		return true;
	}
}