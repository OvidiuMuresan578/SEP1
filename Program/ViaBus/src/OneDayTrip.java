/**
 * A class extending a Tour and representing a one-day trip tour
 *
 * @author Krystof Spiller
 * @version 0.2, 08/12/2016
 */

public class OneDayTrip extends Tour
{
	private static final long serialVersionUID = 33L;

   /**
	* Four-argument constructor. Constructor from the super class Tour is called. 
	*
	* @param chauffeur
	*    	 an object of type Chauffeur
	* @param bus
	*    	 an object of type Bus
	* @param schedule
	*    	 an object of type Schedule
	* @param food
	*    	 an object of type boolean
	*/	
	
	public OneDayTrip(Chauffeur chauffeur, Bus bus, Schedule schedule, boolean food)
	{
		super(chauffeur, bus, schedule, food);
	}
	
   /**
	* @return the name of the class as a String
	*/
	
	public String getClassName()
	{
		return "OneDayTrip";
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
		if(!(obj instanceof OneDayTrip))
			return false;
		OneDayTrip other = (OneDayTrip)obj;
		return super.equals(other);
	}
}