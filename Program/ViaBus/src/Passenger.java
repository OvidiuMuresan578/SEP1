import java.io.Serializable;

/**
 * A class representing a passenger
 *
 * @author Krystof Spiller
 * @version 0.2, 8/12/2016
 */

public class Passenger implements Serializable
{
	private static final long serialVersionUID = 23L;
	private String fullName;
	
   /**
	* One-argument constructor setting the full name of passenger.  
    * 
    * @param fullName
    *    	 the full name of a passenger as a String
    */	

	public Passenger(String fullName)
	{
		if(fullName != null)
			setFullName(fullName);
		else
			this.fullName = fullName;
	}
	
   /**
	* @return the full name of a passenger as a String
	*/

	public String getFullName()
	{
		return fullName;
	}
	
   /**
    * Sets the full name of a passenger. Capitalizes the first letter of the inputed string.
    * 
    * @param fullName
    *        the full name of a passenger as a String
    */
	
	public void setFullName(String fullName)
	{
			this.fullName = fullName.toUpperCase().charAt(0) + fullName.substring(1);
	}
}