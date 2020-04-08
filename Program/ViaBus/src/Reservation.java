import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a reservation
 *
 * @author Krystof Spiller
 * @version 0.3, 12/12/2016
 */

public class Reservation implements Serializable 
{
	private static final long serialVersionUID = 22L;
	private Customer customer;
	private ArrayList<Passenger> passengers;
	private Tour tour;
	private double price;
	private int vegetarians, nonEaters;
	
   /**
    * Three-argument constructor. Passengers variable is initialized as an arraylist.
    * Vegetarians and non-eaters are set to zero. The newly created reservation is added to
    * the list of reservations of assigned customer and tour.
    *
    * @param customer
    *    	 the object of a type Customer
    * @param tour
    *    	 the object of a type Tour
    * @param price
    *    	 the price of the reservation as a double
    */
	
	public Reservation(Customer customer, Tour tour, double price)
	{
		this.customer = customer;
		passengers = new ArrayList<>();
		this.tour = tour;
		setPrice(price);
		vegetarians = 0;
		nonEaters = 0;
		this.customer.addReservation(this);
		this.tour.addReservation(this);
	}
	
   /**
    * @return the price of the reservation as a double
    */
	
	public double getPrice()
	{
		return price;
	}

   /**
    * @return the number of vegetarians as an integer
    */
	
	public int getVegetarians()
	{
		return vegetarians;
	}

   /**
    * @return the number of non-eaters as an integer
    */

	public int getNonEaters()
	{
		return nonEaters;
	}
   
   /**
    * @return the customer as a Customer object
    */
	
	public Customer getCustomer()
	{
		return customer;
	}
	
   /**
    * @return the number of passengers as an integer
    */
	
	public int getCountOfPassengers()
	{
		return passengers.size();
	}
	
   /**
	* @param index
	*        An index of the passenger in the passengers arraylist
    * @return the object of type Passenger on the given index of an arraylist only if the index is within the
	* 		  size boundaries of a passengers arraylist
    */
	
	public Passenger getPassenger(int index)
	{
		if(index >= 0 && index < passengers.size())
			return passengers.get(index);
		return null;
	}
	
   /**
    * @return the passengers as an array of Passenger objects
    */
	
	public Passenger[] getPassengers()
	{
		Passenger[] passengers = new Passenger[this.passengers.size()];
		for(int i = 0; i < passengers.length; i++)
			passengers[i] = this.passengers.get(i);
		return passengers;
	}
	
   /**
	* @return the reserved seats for the reservation as an array of Seat objects
	*/
	
	public Seat[] getSeats()
	{
		return tour.getSeatsForReservation(this);
	}
	
   /**
    * @return the tour as a Tour object
    */
	
	public Tour getTour()
	{
		return tour;
	}
	
   /**
    * Sets the price of a reservation.
    * 
    * @param price
    *        the price of a reservation as a double
    */
	
	public void setPrice(double price)
	{
		this.price = (price >= 0) ? price : price * -1;
	}
	
   /**
    * Sets the number of vegetarians for a reservation.
    * 
    * @param vegetarians
    *        the number of vegetarians for a reservation as an integer
    */	

	public void setVegetarians(int vegetarians)
	{
		this.vegetarians = vegetarians;
	}
	
   /**
    * Sets the number of non-eaters for a reservation.
    * 
    * @param nonEaters
    *        the number of non-eaters for a reservation as an integer
    */	
	
	public void setNonEaters(int nonEaters)
	{
		this.nonEaters = nonEaters;
	}
	
   /**
    * Sets the customer for a reservation.
    * 
    * @param customer
    * 		 the customer as a Customer object
    */
	
	public void setCustomer(Customer customer)
	{
		this.customer.removeReservation(this);
		this.customer = customer;
		this.customer.addReservation(this);
	}
	
   /**
    * Sets the number of passengers for a reservation.
    * 
    * @param count
    * 		 number of passengers as an integer
    */
	
	public void setCountOfPassengers(int count)
	{
		if(count < tour.getAvailableSeats().length)
		{
			for(int i = 0; i < count; i++)
				passengers.add(new Passenger(null));
		}
		else
			throw new IllegalArgumentException("More passengers then there are free seats");
	}
	
   /**
	* Adds a passenger to reservation's passengers.
	* 
	* @param passenger
	*        an object of type Passenger
	*/
	
	public void addPassenger(Passenger passenger)
	{
		passengers.add(passenger);
	}
	
   /**
	* Removes a passenger from reservation's passengers.
	* 
	* @param passenger
	*        an object of type Passenger
	*/
	
	public void removePassenger(Passenger passenger)
	{
		passengers.remove(passenger);
	}
	
   /**
	* Books a seat on a tour for this reservation if the seat with the seat number 
	* specified in the argument exists and if it is free.
    * 
    * @param seatNumber
    * 		 the seat number as an integer
    */
	
	public void bookSeat(int seatNumber)
	{
		tour.bookSeat(seatNumber, this);
	}
	
   /**
	* Cancels a seat booking on a tour if the seat with the seat number specified 
	* in the argument exists.
    * 
    * @param seatNumber
    * 		 the seat number as an integer
    */
	
	public void cancelSeatBooking(int seatNumber)
	{
		tour.cancelSeatBooking(seatNumber);
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
		if(!(obj instanceof Reservation))
			return false;
		Reservation other = (Reservation)obj;
		return this.customer.equals(other.customer) &&
			   this.passengers.equals(other.passengers) &&
			   this.tour.equals(other.tour) &&
			   this.price == other.price &&
			   this.vegetarians == other.vegetarians &&
			   this.nonEaters == other.nonEaters;
	}
}