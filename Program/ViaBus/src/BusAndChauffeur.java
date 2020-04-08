/**
 * A class extending a Tour and representing a bus-and-chauffeur tour
 *
 * @author Krystof Spiller
 * @version 0.3, 12/12/2016
 */

public class BusAndChauffeur extends Tour
{
	private static final long serialVersionUID = 35L;
	private boolean breakfast, lunch, dinner, partyBus, partyGuide;
	
   /**
	* Four-argument constructor. Constructor from the super class Tour is called. 
	* Booleans representing availability of breakfast, lunch, dinner and request
	* for party bus and party guide are set to false.
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
	
	public BusAndChauffeur(Chauffeur chauffeur, Bus bus, Schedule schedule, boolean food)
	{
		super(chauffeur, bus, schedule, food);
		setBreakfast(false);
		setLunch(false);
		setDinner(false);
		setPartyBus(false);
		setPartyGuide(false);
	}
	
   /**
	* @return the class name as String
	*/
	
	public String getClassName()
	{
		return "BusAndChauffeur";
	}
	
   /**
	* @return if a breakfast is available
	*/
	
	public boolean getBreakfast()
	{
		return breakfast;
	}

   /**
	* @return if a lunch is available
	*/
	
	public boolean getLunch()
	{
		return lunch;
	}

   /**
	* @return if a dinner is available
	*/
	
	public boolean getDinner()
	{
		return dinner;
	}

   /**
	* @return if a party bus is requested
	*/
	
	public boolean getPartyBus()
	{
		return partyBus;
	}
	
   /**
	* @return if a party guide is requested
	*/
	
	public boolean getPartyGuide()
	{
		return partyGuide;
	}
	
   /**
	* Sets if a breakfast is available or not.
	* 
	* @param breakfast
	* 	     boolean representing if a breakfast is available (true) or not (false)
	*/
	
	public void setBreakfast(boolean breakfast)
	{
		this.breakfast = breakfast;
	}

   /**
    * Sets if a lunch is available or not.
    * 
	* @param lunch
	* 	     boolean representing if a lunch is available (true) or not (false)
	*/
	
	public void setLunch(boolean lunch)
	{
		this.lunch = lunch;
	}

   /**
    * Sets if a dinner is available or not.
    * 
	* @param dinner
	* 	     boolean representing if a dinner is available (true) or not (false)
	*/	

	public void setDinner(boolean dinner)
	{
		this.dinner = dinner;
	}
	
   /**
	* Sets if a party bus is requested or not.
	* 
	* @param partyBus
	* 	     boolean representing if a party bus is requested (true) or not (false)
	*/
	
	public void setPartyBus(boolean partyBus)
	{
		this.partyBus = partyBus;
	}
	
   /**
	* Sets if a party guide is requested or not.
	* 
	* @param partyGuide
	* 	     boolean representing if a party guide is requested (true) or not (false)
	*/
	
	public void setPartyGuide(boolean partyGuide)
	{
		this.partyGuide = partyGuide;
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
		if(!(obj instanceof BusAndChauffeur))
			return false;
		BusAndChauffeur other = (BusAndChauffeur)obj;
		return super.equals(other) &&
			   this.breakfast == other.breakfast &&
			   this.lunch == other.lunch &&
			   this.dinner == other.dinner &&
			   this.partyBus == other.partyBus &&
			   this.partyGuide == other.partyGuide;
	}
}