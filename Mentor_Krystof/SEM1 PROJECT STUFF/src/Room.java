import java.io.Serializable;
import java.util.ArrayList;
/**
 * The Room objects hold information about each individual room. 
 * @author Anton Akov
 *
 */
public class Room implements Serializable
{
   private int roomNumber;
   private int type; //0-suite, 1-2bedroom suite, 2-3bedroomsuite, 3-singleroom, 4-doubleroomKingsize, 5-doubleroom Double
   private int pricePerNight;
   private boolean inUse;
   private Bookings bookings;
   /**
    * Standart constructor taking the room numeber, type and price per night as arguments
    * @param i room number
    * @param j room type
    * @param k price per night
    */
   public Room(int i, int j, int k)
   {
      roomNumber = i;
      type = j;
      pricePerNight = k;
      inUse = false;
      bookings = new Bookings();
   }
   /**
    * returns the number of the room
    * @return number of the room that called the method
    */
   public int getRoomNumber(){return roomNumber;}
   /**
    * returns the type of the room
    * @return type of the room that called the method
    */
   public int getType(){return type;}
   /**
    * returns the price per night of the room
    * @return price per night of the room that called the method
    */
   public int getPricePerNight(){return pricePerNight;}
   /**
    * returns wether the room is used up or not
    * @return false if the room isavailable
    */
   public boolean isInUse(){return inUse;}
   /**
    * returns listed of bookings for that room
    * @return list of bookings
    */
   public Bookings getBookings(){return bookings;}
   
   /**
    * Adds new booking to the bookings in room list
    * @param b the bookings to add
    */
   public void addBooking(Booking b){bookings.add(b);}
   /**
    * Removes a given booking from the list of the room
    * NOTE equals methods needed troughout for this to work
    * @param b booking to be removed
    */
   public void removeBooking(Booking b){bookings.getList().remove(b);}
   /**
    * deletes the first bookin in line
    */
   public void removeBooking(){bookings.getList().remove(0);}
   /**
    * sets wether the room is used or not
    * @param iu new sate
    */
   public void setInUse(boolean iu){inUse = iu;}
   /**
    * sets room type
    * @param b new type
    */
   public void setType(byte b){type = b;}
   /** sets price per night
    * new price
    * @param p desired price per night
    */
   public void setPricePerNight(int p){pricePerNight = p;}
   
   /**
    *  checks if a room is available around a given date
    * @param d1 checkin date
    * @param d2 checkout date
    * @return true of it is, false if its not
    */
   public boolean checkDateAvailability(String d1, String d2)
   {
      int i=0;
      while(i<bookings.getList().size())
      {
         if(bookings.get(i).getDates().Overlaps(new BookingDate(d1, d2)))return false;
         
      
         i++;
      }
      return true;
   }
   
   
   
   

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Room))
		return false;
	Room other = (Room) obj;
	if (bookings == null) {
		if (other.bookings != null)
			return false;
	} else if (!bookings.equals(other.bookings))
		return false;
	if (inUse != other.inUse)
		return false;
	if (pricePerNight != other.pricePerNight)
		return false;
	if (roomNumber != other.roomNumber)
		return false;
	if (type != other.type)
		return false;
	return true;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
	result = prime * result + (inUse ? 1231 : 1237);
	result = prime * result + pricePerNight;
	result = prime * result + roomNumber;
	result = prime * result + type;
	return result;
}

   

   @Override
   public String toString()
   {
      return "Room [roomNumber=" + roomNumber + ", type=" + type + ", pricePerNight=" + pricePerNight 
             + ", inUse=" + inUse + ", booking=" + bookings + "]";
   }
}
