import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Class that extends Thread designed to run when program ends
 * @author Filip Zelenika
 *
 */
public class OnExit extends Thread
{
   private FileIO file;
   private Rooms AR;
   private Bookings BR;
   private String RNote;
   /**
    * constructor takes the fileIO, all rooms and all bookings and the note as arguments
    * @param f fileIO
    * @param r all rooms
    * @param b all bookings
    * @param n home note text
    */
   public OnExit(FileIO f, Rooms r, Bookings b, String n)
   {
      file = f;
      AR = r;
      BR = b;
      RNote = n;
   }
   /**
    * activates when started by the system and executes what's in it, in this case writes the info to files
    */
   public void run()
   {
      try
      {
         file.writeToFile("Rooms.bin", AR.getList());
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file: "+ e.getMessage());
      }
      
      
      try
      {
         file.writeToFile("Bookings.bin", new Object[]{BR.getList(), BR.getCheckedIn()});
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file: "+ e.getMessage());
      }
      
      
      
   }
}
