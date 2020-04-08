import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that holds the 2 lists of bookings, one with all and the other with just the checked in
 * @author Anton Akov
 *
 */
public class Bookings implements Serializable
{
   ArrayList<Booking> bookings;
   ArrayList<Booking> checkedIn;
   
   /**
    * Default no-argument constructor
    */
   public Bookings()
   {
      bookings  = new ArrayList<Booking>();
      checkedIn = new ArrayList<Booking>();
   }
   /**
    * Constructor creating an object with already made arrayLists
    * @param b all bookings
    * @param c just the checked in
    */
   public Bookings(ArrayList<Booking> b, ArrayList<Booking> c)
   {
      bookings  = b;
      checkedIn = c;
   }
   
   /**
    * checks in the booking given as an argument
    * @param b booking to check in
    * @param guests guests to be checked in for that booking
    */
   public void checkInBooking(Booking b, ArrayList<Guest> guests)
   {
      b.setGuests(guests);
      b.setCheckedIn(true);
      checkedIn.add(b);
      
      
      
   }
   
   /**
    * adds one booking to the bookings list
    * @param b the booking to add
    */
   public void add(Booking b){bookings.add(b);}
   /**
    * Acesses the booking at the desired index
    * @param i the index
    * @return the booking
    */
   public Booking get(int i){return bookings.get(i);}
   /**
    * removes the desired booking from the system
    * @param b the desired booking
    */
   public void delete(Booking b){
      b.delete();
      bookings.remove(b);
      if(checkedIn.contains(b))checkedIn.remove(b);
   }
   /**
    * Returns the number of currently checked in bookings
    * @return size of the checkedIn list
    */
   public int getNumberOfCheckedIn(){return checkedIn.size();}
   /**
    * Method used to get the total number of bookings happeng in the current date
    * @return the counted bookings that match
    */
   public int getNumberOfToday()
   {
      int i=0;
      int cnt=0;
      while(i<bookings.size())
      {
         if(bookings.get(i).isBookingToday())cnt++;
         i++;
      }
      return cnt;
   }
   

   
   
   @Override
   /**
    * defualt generated hashCode
    */
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
	result = prime * result + ((checkedIn == null) ? 0 : checkedIn.hashCode());
	return result;
}

   /**
    * returns the current list of checcked in bookigns
    * @return the arraylist itself
    * 
    */
   
   public ArrayList<Booking> getCheckedIn(){return checkedIn;}
   
   /**
    * the current list of all bookings
    * @return the arraylist itslef
    */
   public ArrayList<Booking> getList(){return bookings;}
   
   /**
    * updates a booking by setting a new array of guests
    * @param booking the booking to be updated
    * @param guests the new arrayList of guests
    */
   public void updateBooking(Booking booking, ArrayList<Guest> guests)
   {
      booking.setGuests(guests);
   }
   
   
}
