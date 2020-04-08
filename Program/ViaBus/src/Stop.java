import java.io.Serializable;

/**
* A class representing a stop
*
* @author Krystof Spiller
* @version 0.3, 05/12/2016
*/

public class Stop implements Serializable
{
	private static final long serialVersionUID = 38L;
	private String destination;
	private DateTime dateTime;
	private boolean mainDestination;
	
   /**
    * Two-argument constructor. Sets boolean representing main destination to false.
    *
    * @param destination
    *    	 the destination of stop as a String
    * @param dateTime
    *    	 the date and time of stop as a DateTime object
    */
	
	public Stop(String destination, DateTime dateTime)
	{
		this.destination = destination;
		this.dateTime = dateTime.copy();
		mainDestination = false;
	}
	
   /**
	* @return the destination as a String
	*/
	
	public String getDestination()
	{
		return destination;
	}

   /**
    * @return the date and time as a DateTime object
    */
		
	public DateTime getDateTime()
	{
		return dateTime.copy();
	}

   /**
	* @return boolean representing whether the destination is a main destination (true) or not (false)
	*/
		
	public boolean isMainDestination()
	{
		return mainDestination;
	}

   /**
	* Sets the destination of a stop.
	* 
    * @param destination
    *        the destination as a String
    */
		
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
	
   /**
    * Sets the date and time of a stop.
    * 
    * @param dateTime
    *        the date and time as a DateTime object
    */
	
	public void setDateTime(DateTime dateTime)
	{
		this.dateTime = dateTime.copy();
	}
	
   /**
    * Sets the destination as a main destination
    */
	
	public void setAsMainDestination()
	{
		mainDestination = true;
	}
	
   /**
    * Unsets the destination as a main destination
    */
	
	public void unsetAsMainDestination()
	{
		mainDestination = false;
	}
	
   /**
    * @return the stop's destination followed by a date and time in parentheses as a String
    */
	
	public String toString()
	{
		return destination + " (" + dateTime + ")";
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
		if(!(obj instanceof Stop))
			return false;
		Stop other = (Stop)obj;
		return this.dateTime.equals(other.dateTime) &&
			   this.destination.equals(other.destination);
	}
                                                                                                                                                                              }