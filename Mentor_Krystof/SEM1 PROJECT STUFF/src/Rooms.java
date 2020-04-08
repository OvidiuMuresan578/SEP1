import java.io.Serializable;
import java.util.ArrayList;
/**
 * This class hodls all the room objects
 * The ArrayList storing the data is static
 * @author John
 *
 */
public class Rooms implements Serializable
{
   private static ArrayList<Room> rooms = new ArrayList<Room>();;
   
   /**
    * empty constructor
    */
   public Rooms()
   {
   }
   /**
    * constructor that takes an ArrayList and makes it the new argument
    * @param r list of rooms to be turned into the main one
    */
   public Rooms(ArrayList<Room> r)
   {
      rooms = r;
   }
   /** adds a room
    * @param r room to be added
    */
   public void add(Room r)
   {
      rooms.add(r);
   }
   /**
    *  Returns a room object depending on the num
    * @param n the room number
    * @return returns the Room object it e
    */
   public static Room getRoomByNumber(int n)
   {
      int i = 0;
      while(i<rooms.size())
      {
         if(rooms.get(i).getRoomNumber()==n)return rooms.get(i);
         i++;
      }
      return null;
   }
   /**
    * Simply accesses a certain elemtn
    * @param i the search index
    * @return the gotten room
    */
   public static Room get(int i)
   {
      return rooms.get(i);
   }
   /** Returns room array holding the rooms filtered by type
    * 
    * @param t the type they're filtered by
    * @return the Array Product of our efforts
    */
   public Room[] getRoomByType(int t)
   {
      ArrayList<Room> temp = new ArrayList<Room>();
      int i = 0;
      while(i<rooms.size())
      {
         if(rooms.get(i).getType()==t)temp.add(rooms.get(i));
         i++;
      }
      Room[] tempRes = new Room[temp.size()];
      tempRes = temp.toArray(tempRes);
      return tempRes;
   }
   
   /**
    * Returns an array of rooms all of which meet a certain criteria, in this case just by price range
    * @param p1 starting price
    * @param p2 ending price
    * @return the room[] that is the result
    */
   
   public Room[] getRoomsByPriceRange(int p1, int p2)
   {
      ArrayList<Room> temp = new ArrayList<Room>();
      int i = 0;
      while(i<rooms.size())
      {
         if(rooms.get(i).getPricePerNight()>=p1 && rooms.get(i).getPricePerNight()<=p2)temp.add(rooms.get(i));
         i++;
      }
      Room[] tempRes = new Room[temp.size()];
      tempRes = temp.toArray(tempRes);
      return tempRes;
   }
   
   /**
    * Returns the rooms that fit in a given date range
    * @param d1 being the first one
    * @param d2 the 2nd one
    * @return Room[] that only has the filtered elems in it
    */
   public Room[] getRoomsByDateRange(String d1, String d2)
   {
      ArrayList<Room> temp = new ArrayList<Room>();
      int i = 0;
      while(i<rooms.size())
      {
         if(rooms.get(i).checkDateAvailability(d1, d2))temp.add(rooms.get(i));
         i++;
      }
      Room[] tempRes = new Room[temp.size()];
      tempRes = temp.toArray(tempRes);
      return tempRes;
      
      
   }
   /**
    * Returns an array of Rooms filtered by both date and price avalability, for that it needs both the decorations
    * @param d1 new checkin date
    * @param d2 new checkout date
    * @param p1 lower price
    * @param p2 higher price
    * @return filtered Room[]
    */
   public Room[] getRoomsByDateAndPriceRange(String d1, String d2, int p1, int p2)
   {
      ArrayList<Room> temp = new ArrayList<Room>();
      ArrayList<Room> temp2 = new ArrayList<Room>();
      ArrayList<Room> temp3 = new ArrayList<Room>();
      int i = 0;
      while(i<rooms.size())
      {
         if(rooms.get(i).getPricePerNight()>=p1 && rooms.get(i).getPricePerNight()<=p2)temp.add(rooms.get(i));
         i++;
      }
      i=0;
      while(i<rooms.size())
      {
         if(rooms.get(i).checkDateAvailability(d1, d2))temp2.add(rooms.get(i));
         i++;
      }
      i=0;
      if(temp2.size()>temp.size())
      {
    	  while(i<temp.size())
    	  {
    		  if(temp2.contains(temp.get(i)))temp3.add(temp.get(i));
    		  i++;
    	  }
      }
      else
      {
    	  while(i<temp2.size())
    	  {
    		  if(temp.contains(temp2.get(i)))temp3.add(temp2.get(i));
    		  i++;
    	  }
      }
      Room[] tempRes = new Room[temp3.size()];
      tempRes = temp3.toArray(tempRes);
      return tempRes;
      
      
      
      
   }
   
   
   
   
   public ArrayList<Room> getList(){return rooms;}
   
}
