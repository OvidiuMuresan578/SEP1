import java.io.Serializable;

/**
 * A class representing a seat
 *
 * @author Krystof Spiller
 * @version 0.2, 12/12/2016
 */

public class Seat implements Serializable
{
	private static final long serialVersionUID = 36L;
	private int seatNumber;
	private boolean occupied;
	public Reservation reservation;
	
	/**
    * One-argument constructor. Sets the boolean occupied to false and reservation to null.  
    * 
    * @param seatNumber
    *    	 the number of a seatNumber as a Integer
    */	
	
	public Seat(int seatNumber)
	{
		this.seatNumber = seatNumber;
		unOccupy();
		this.reservation = null;
	}
	
   /**
	* @return the number of a seat as an integer
	*/
	
	public int getSeatNumber()
	{
		return seatNumber;
	}
	
   /**
	* @return the reservation of a seat as a Reservation object
	*/
	
	public Reservation getReservation()
	{
		return reservation;
	}

   /**
	* @return if a seat is reserved and therefore occupied (true) or not (false)
	*/
	
	public boolean isOccupied()
	{
		return occupied;
	}
	
   /**
    * Sets the reservation for a seat
    * 
	* @param reservation
	* 		 the reservation as a Reservation object
	*/
	
	public void setReservation(Reservation reservation)
	{
		this.reservation = reservation;
	}
	
   /**
	*  Sets a seat status to occupied
	*/

	public void occupy()
	{
		occupied = true;
	}
	
   /**
	*  Sets a seat status to unoccupied
	*/
	
	public void unOccupy()
	{
		occupied = false;
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
		if(!(obj instanceof Seat))
			return false;
		Seat other = (Seat)obj;
		return this.occupied == other.occupied &&
			   this.seatNumber == other.seatNumber &&
			!((this.reservation == null || other.reservation == null) && this.reservation != other.reservation) &&
			 ((this.reservation == null && other.reservation == null) || 
			   this.reservation.equals(other.reservation));
	}
}