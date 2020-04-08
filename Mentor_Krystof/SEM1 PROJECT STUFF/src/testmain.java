import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
  
/*
 * DO is room available from time to time date11>date22 || date12< date21 date11,date12 // date21, date22
 * DO Room search system
 * TODO Fix date search
 * DO Home Tab, Calendar Table
 * DO Guest Tab Table
 * TODO connect everything(checkout calculations and shit
 * DO discount thing
 * DO File System
 * DO File System Finishing touches(all the stuff)
 * DO Edit Buttons to Labels
*/

/**
 * Class to run the program with to test it
 * @author Sujan Varma
 *
 */
public class testmain 
{
   public static OnExit exitSave;
   
   /**
    * Test part of code to creatae bookings with fast
    * @param name name for the booking
    * @param date1 arrival date
    * @param date2 departure date
    * @param bR booked rooms array
    * @param AR all rooms
    * @param AB all bookings
    */
   public static void makeBooking(String name, String date1, String date2, int[] bR, Rooms AR, Bookings AB)
   {
      int[] tna = bR;
      int i=0;
       ArrayList<Room> resultA = new ArrayList<Room>();
      Room[] result;
      while(i<tna.length)
      {
         if(tna[i]!=0)resultA.add(AR.getRoomByNumber(tna[i]));
         i++;
      }
      result=new Room[resultA.size()];
      result = resultA.toArray(result);
      AB.add(new Booking(new Guest(name), new BookingDate(date1, date2), result));
      
      
   }
   
   public static void main(String[] args) throws ParseException {
      
      String homeNote = "";
      BookingDate time = new BookingDate("2.12.2015", "15.12.2015 10:00");
      
      Rooms AllRooms = new Rooms();
      Bookings AllBookings = new Bookings();
      FileIO file = new FileIO();
      
      /*
      AllRooms.add(new Room(1, 0, 220));
      AllRooms.add(new Room(2, 0, 220));
      AllRooms.add(new Room(3, 1, 340));
      AllRooms.add(new Room(4, 2, 450));
      AllRooms.add(new Room(5, 3, 110));
      AllRooms.add(new Room(6, 3, 110));
      AllRooms.add(new Room(7, 3, 110));
      AllRooms.add(new Room(8, 4, 170));
      AllRooms.add(new Room(9, 4, 170));
      AllRooms.add(new Room(10, 4, 170));
      AllRooms.add(new Room(11, 4, 170));
      AllRooms.add(new Room(12, 4, 170));
      AllRooms.add(new Room(13, 4, 170));
      AllRooms.add(new Room(14, 4, 170));
      AllRooms.add(new Room(15, 4, 170));
      AllRooms.add(new Room(16, 4, 170));
      AllRooms.add(new Room(17, 4, 170));
      AllRooms.add(new Room(18, 4, 170));
      AllRooms.add(new Room(19, 4, 170));
      AllRooms.add(new Room(20, 5, 170));
      AllRooms.add(new Room(21, 5, 170));
      AllRooms.add(new Room(22, 5, 170));
      AllRooms.add(new Room(23, 5, 170));
      AllRooms.add(new Room(24, 5, 170));
      AllRooms.add(new Room(25, 5, 170));
     */
      
      
      
      //AllBookings.delete(AllBookings.get(2));
      
      try
      {
         homeNote = (String) file.readObjectFromFile("RNote.bin");
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file: "+ e.getMessage());
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      
      //AllRooms = null;
      
      
      try
      {
         AllRooms = new Rooms( (ArrayList<Room>) file.readObjectFromFile("Rooms.bin"));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file: "+ e.getMessage());
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      
      
      /*
      
      makeBooking("Name 1", "01.01.2015", "25.01.2015", new int[]{1}, AllRooms, AllBookings);
      makeBooking("Name 2", "01.02.2015", "25.02.2015", new int[]{2}, AllRooms, AllBookings);
      makeBooking("Name 3", "01.03.2015", "25.03.2015", new int[]{3}, AllRooms, AllBookings);
      makeBooking("Name 4", "01.04.2015", "25.04.2015", new int[]{4}, AllRooms, AllBookings);
      makeBooking("Name 5", "01.05.2015", "25.05.2015", new int[]{5}, AllRooms, AllBookings);
      makeBooking("Name 6", "01.06.2015", "25.06.2015", new int[]{6}, AllRooms, AllBookings);
      makeBooking("Name 7", "01.07.2015", "25.07.2015", new int[]{7}, AllRooms, AllBookings);
      makeBooking("Name 8", "01.08.2015", "25.08.2015", new int[]{8}, AllRooms, AllBookings);
      makeBooking("Name 9", "01.09.2015", "25.09.2015", new int[]{9}, AllRooms, AllBookings);
      makeBooking("Name 10", "01.10.2015", "25.10.2015", new int[]{10}, AllRooms, AllBookings);
      makeBooking("Name 11", "01.11.2015", "25.11.2015", new int[]{11}, AllRooms, AllBookings);
      makeBooking("Name 12", "09.12.2015", "25.12.2015", new int[]{1,12}, AllRooms, AllBookings);
      */
      try
      {
         Object[] asdf = file.readArrayFromFile("Bookings.bin");
         AllBookings = new Bookings((ArrayList<Booking>)asdf[0],(ArrayList<Booking>) asdf[1]);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file: "+ e.getMessage());
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      //AllBookings = new Bookings();
      
      Runtime.getRuntime().addShutdownHook(new OnExit(file, AllRooms, AllBookings, homeNote));
      
      MAIN runrun = new MAIN(AllRooms, AllBookings, homeNote, file);
      //testMAINwindow run = new testMAINwindow(AllBookings);
      
      
      
      //AllBookings.delete(AllBookings.get(2));
      
      /*Room[] temp = AllRooms.getRoomsByDateAndPriceRange("01.12.2015", "23.12.2015", 150, 200);
      
      while(i<temp.length)
      {
         System.out.println(temp[i]);
         i++;
      }*/
      //MySearchTable window = new MySearchTable(AllRooms);
      //JTableRoomTest table = new JTableRoomTest(AllRooms);
      //System.out.println(time.getHasHours());
      System.out.println(time.getCheckInDateString() + " (" + time.getCheckInHourString()+") "+ " - " + time.getCheckOutDateString() + " (" + time.getCheckOutHourString()+") "+ "\nNumber of nights: "+time.getNumberOfNights());
      //System.out.println(time.getNumberOfNights());
      
   }
   /*private static Rooms getRoomsByNumbers(int[] numbers, Rooms r)
   {
      int i=0;
      Rooms result = new Rooms();
      while(i<numbers.length)
      {
         result.add(r.getRoomByNumber(numbers[i]));
         i++;
      }
      return result;
   }*/
}