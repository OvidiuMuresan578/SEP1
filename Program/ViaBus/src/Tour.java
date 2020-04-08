import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a tour
 *
 * @author Krystof Spiller
 * @version 0.3, 05/12/2016
 */

public abstract class Tour implements Serializable 
{
	private static final long serialVersionUID = 32L;
	private boolean food;
	private Bus bus;
	private Chauffeur chauffeur;
	private Schedule schedule;
	private Seat[] seats;
	private ReservationList reservations;
	
   /**
	* Four-argument constructor. Initializes the seats array and constructs new Seat objects
	* according to bus seat numbers. Reservations variable is initialized as an arraylist.
	* The schedule for the tour is added to the bus' and chaffeur's schedules.
	*
	* @param chauffeur
	*        the chauffeur as a Chauffeur object
	* @param bus
	*        the bus as a Bus object
	* @param schedule
	*        the schedule as a Schedule object
	* @param food
    *        the food as a boolean
    */
	
	public Tour(Chauffeur chauffeur, Bus bus, Schedule schedule, boolean food)
	{
		this.chauffeur = chauffeur;
		this.bus = bus;
		this.schedule = schedule;
		this.food = food;
		seats = new Seat[this.bus.getNumberOfSeats()];
		for(int i = 0; i < seats.length; i++)
			seats[i] = new Seat(this.bus.getSeatNumbers()[i]);
		reservations = new ReservationList();
		this.bus.addSchedule(this.schedule);
		this.chauffeur.addSchedule(this.schedule);
	}

   /**
	* @return the schedule of a tour as a Schedule object
	*/

	public Schedule getSchedule()
	{
		return schedule;
	}
	
   /**
	* @return the assigned chauffeur for a tour as a Chauffeur object
	*/
	
	public Chauffeur getChauffeur()
	{
		return chauffeur;
	}
	
   /**
	* @return the assigned bus for a tour as a Bus object
	*/
	
	public Bus getBus()
	{
		return bus;
	}
	
   /**
	* @return the tour's reservations as a ReservationList object
	*/
	
	public ReservationList getReservations()
	{
		return reservations;
	}

   /**
	* @return both the available and reserved seats of this tour as an array of Seat objects
	*/
	
	public Seat[] getSeats()
	{
		return seats;
	}

   /**
	* @return only the available seats of this tour as an array of Seat objects
	*/
	
	public Seat[] getAvailableSeats()
	{
		ArrayList<Seat> availableSeats = new ArrayList<>();
		for(int i = 0; i < seats.length; i++)
			if(!seats[i].isOccupied())
				availableSeats.add(seats[i]);
		Seat[] seats = new Seat[availableSeats.size()];
		for(int i = 0; i < seats.length; i++)
			seats[i] = availableSeats.get(i);
		return seats;
	}
	
   /**
    * @param reservation
    * 		 the reservation as a Reservation object
	* @return the reserved seats for reservation specified in the argument as an array of Seat objects
	*/
	
	public Seat[] getSeatsForReservation(Reservation reservation)
	{
		ArrayList<Seat> seatsForReservation = new ArrayList<>();
		for(int i = 0; i < this.seats.length; i++)
			if(this.seats[i].getReservation().equals(reservation))
				seatsForReservation.add(this.seats[i]);
		Seat[] seats = new Seat[seatsForReservation.size()];
		for(int i = 0; i < seats.length; i++)
			seats[i] = seatsForReservation.get(i);
		return seats;
	}
	
   /**
	* @return boolean representing whether the food on tour is available (tour) or not (false)
	*/
	
	public boolean isFoodAvailable()
	{
		return food;
	}
	
   /**
	* @return the class name as a String
	*/
	
	public abstract String getClassName();
	
   /**
	* Sets the schedule of the tour to the one specified in the argument
	* 
	* @param schedule
	* 		 the schedule of a tour as a Schedule object
	*/
	
	public void setSchedule(Schedule schedule)
	{
		this.schedule = schedule;
	}
	
   /**
	* Sets the chauffeur of the tour to the one specified in the argument
	* 
	* @param chauffeur
	* 		 the chauffeur of a tour as a Chauffeur object
	*/

	public void setChauffeur(Chauffeur chauffeur)
	{
		this.chauffeur = chauffeur;
	}

   /**
	* Sets the bus of the tour to the one specified in the argument
	* 
	* @param bus
	* 		 the bus of a tour as a Bus object
	*/
	
	public void setBus(Bus bus)
	{
		this.bus = bus;
	}
	
   /**
	* Sets if the food is available or not on the tour based on the boolean specified in the argument
	* 
	* @param food
	* 		 boolean representing if the food on the tour is available (true) or not (false)
	*/
	
	public void setFood(boolean food)
	{
		this.food = food;
	}
	
   /**
	* Adds a reservation to tour's list of reservations.
	* 
	* @param reservation
	*        an object of type Reservation
	*/
	
	public void addReservation(Reservation reservation)
	{
		reservations.addReservation(reservation);
	}
	
   /**
	* Removes a reservation from tour's list of reservations.
	* 
	* @param reservation
	*        an object of type Reservation
	*/
	
	public void removeReservation(Reservation reservation)
	{
		reservations.deleteReservation(reservation);
	}
	
   /**
	* Books a seat on a tour for reservation and seat number specified in the arguments 
	* if the seat with the seat number exists and if it is free.
    * 
    * @param seatNumber
    * 		 the seat number as an integer
    * @param reservation
    * 		 the reservation as a Reservation object
    */
	
	public void bookSeat(int seatNumber, Reservation reservation)
	{
		for(int i = 0; i < seats.length; i++)
			if(seats[i].getSeatNumber() == seatNumber)
			{
				if(!seats[i].isOccupied())
				{
					seats[i].setReservation(reservation);
					seats[i].occupy();
				}
				break;
			}
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
		for(int i = 0; i < seats.length; i++)
			if(seats[i].getSeatNumber() == seatNumber)
			{
				seats[i].setReservation(null);
				seats[i].unOccupy();
			}
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
		if(!(obj instanceof Tour))
			return false;
		Tour other = (Tour)obj;
		
		if(this.seats.length != other.seats.length)
			return false;
		for(int i = 0; i < this.seats.length; i++)
			if(!this.seats[i].equals(other.seats[i]))
				return false;
		
		return this.food == other.food &&
			   this.bus.equals(other.bus) &&
			   this.chauffeur.equals(other.chauffeur) &&
			   this.schedule.equals(other.schedule) && 
			   this.reservations.getReservationCount() == other.reservations.getReservationCount();
	}
}