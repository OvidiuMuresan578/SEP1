/**
 * A class extending a Tour and representing a travel tour
 *
 * @author Krystof Spiller
 * @version 0.2, 08/12/2016
 */

public class Travel extends Tour
{
	private static final long serialVersionUID = 34L;

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
	
	public Travel(Chauffeur chauffeur, Bus bus, Schedule schedule, boolean food)
	{
		super(chauffeur, bus, schedule, food);
	}

   /**
	* @return the name of the class as a String
	*/
	
	public String getClassName()
	{
		return "Travel";
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
		if(!(obj instanceof Travel))
			return false;
		Travel other = (Travel)obj;
		return super.equals(other);
	}
}