import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a list of reservations
 *
 * @author Krystof Spiller
 * @version 0.2, 12/12/2016
 */

public class ReservationList implements Serializable
{
	private static final long serialVersionUID = 21L;
	private ArrayList<Reservation> reservations;
	
   /**
	* No-argument constructor. Reservations variable is initialized as an arraylist.
	*/	
	
	public ReservationList()
	{
		reservations = new ArrayList<>();
	}
	
   /**
    * @param index
	* 		 the index of the Reservation object in an arraylist as an integer
	* @return the object of type Reservation on the given index of an arraylist only if the index is within the
	* 		  size boundaries of a reservations arraylist
	*/
	
	public Reservation getReservation(int index)
	{
		if(index >= 0 && index < reservations.size())
			return reservations.get(index);
		return null;
	}
	
   /**
	* @return the number of reservations as an integer
	*/
	
	public int getReservationCount()
	{
		return reservations.size();
	}
	
   /**
    * @param customer
    * 		 the customer as a Customer object
	* @return the object of type ReservationList containing all the reservations which have the same 
	* 		  customer as the customer specified in the argument
	*/	
	
	public ReservationList getReservationsByCustomer(Customer customer)
	{
		ReservationList returnList = new ReservationList();
		for(int i = 0; i < reservations.size(); i++)
			if(reservations.get(i).getCustomer().equals(customer))
				returnList.addReservation(reservations.get(i));
		return returnList;
	}
	
   /**
    * @param fullName
    * 		 the full name of a passenger as a String
	* @return the object of type ReservationList containing all the reservations containing the manufacturer 
	* 		  String specified in the argument in their stored manufacturer String
	*/
	
	public ReservationList getReservationsByPassenger(String fullName)
	{
		ReservationList returnList = new ReservationList();
		for(int i = 0; i < reservations.size(); i++)
			for(int j = 0; j < reservations.get(i).getPassengers().length; j++)
				if(reservations.get(i).getPassenger(j).getFullName() != null && reservations.get(i).getPassenger(j).getFullName().matches("(?i).*" + fullName + ".*")) // regex for case insensitive search
					returnList.addReservation(reservations.get(i));
		return returnList;
	}
	
   /**
    * @param price
    * 		 the price of a reservation as a double
	* @return the object of type ReservationList containing all the reservations with the same price
	*/
	
	public ReservationList getReservationsByPrice(double price)
	{
		ReservationList returnList = new ReservationList();
		for(int i = 0; i < reservations.size(); i++)
			if(reservations.get(i).getPrice() == price)
				returnList.addReservation(reservations.get(i));
		return returnList;
	} 
	
   /**
    * @param tour
    * 		 the tour as a Tour object
	* @return the object of type ReservationList containing all the reservations which have the same tour
	* 		  as the tour specified in the argument
	*/	
	
	public ReservationList getReservationsByTour(Tour tour)
	{
		ReservationList returnList = new ReservationList();
		for(int i = 0; i < reservations.size(); i++)
			if(reservations.get(i).getTour().equals(tour))
				returnList.addReservation(reservations.get(i));
		return returnList;
	}
	
   /**
	* Merges ReservationList in the argument to the current ReservationList in a way that the 
	* reservations are not duplicated.
	* 
	* @param reservationList
	*        An object of type ReservationList
	*/
	
	public void mergeWith(ReservationList reservationList)
	{
		for(int i = 0; i < reservationList.getReservationCount(); i++)
			this.addReservation(reservationList.getReservation(i));
	}
	
   /**
	* Adds a reservation to the list only if the same reservation doesn't exist yet.
	* Prevents duplication.
	* 
	* @param reservation
	*        An object of type Reservation
	*/

	public void addReservation(Reservation reservation)
	{
		for(int i = 0; i < reservations.size(); i++)
			if(reservations.get(i).equals(reservation))
				return;
		reservations.add(reservation);
	}
	
   /**
	* Deletes a reservation from the list of reservations if it's found.
	* 
	* @param reservation
	*        An object of type Reservation
	*/
		
	public void deleteReservation(Reservation reservation)
	{
		reservation.getCustomer().removeReservation(reservation);
		reservation.getTour().removeReservation(reservation);
		Seat[] seats = reservation.getTour().getSeatsForReservation(reservation);
		for(int i = 0; i < seats.length; i++)
		{
			seats[i].setReservation(null);
			seats[i].unOccupy();
		}
		reservations.remove(reservation);
	}
}