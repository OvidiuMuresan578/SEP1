import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Simple class designed to easen the saving to and reading from files by using convinient methods to do it
 * and avoiding the chore of writing big blocks of code every time
 * 
 * 
 * @author Sujan Varma
 *
 */
public class FileIO
{
	/**
	 * writes one object to a file
	 * @param fileName file to write object in
	 * @param obj object to be written
	 * @throws FileNotFoundException Thrown when the file is not found
	 * @throws IOException Throws when there's been an eror with the IO protocol
	 */
   public void writeToFile(String fileName, Object obj) throws FileNotFoundException, IOException
   {
      ObjectOutputStream writeToFile = null;
       
      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName, false);
         writeToFile = new ObjectOutputStream(fileOutStream);
         
         System.out.println("wrote to: "+fileName);
         
         writeToFile.writeObject(obj);
      }
      finally
      {
         if (writeToFile != null)
         {
            try
            {
               writeToFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
   }
   /**
	 * writes an array of objects to a file
	 * @param fileName file to write object in
	 * @param objs objects to be written
	 * @throws FileNotFoundException Thrown when the file is not found
	 * @throws IOException Throws when there's been an eror with the IO protocol
	 */
   public void writeToFile(String fileName, Object[] objs) throws FileNotFoundException, IOException
   {
      ObjectOutputStream writeToFile = null;

      try
      {
         FileOutputStream fileOutStream = new FileOutputStream(fileName);
         writeToFile = new ObjectOutputStream(fileOutStream);

         for (int i = 0; i < objs.length; i++)
         {
            writeToFile.writeObject(objs[i]);
         }
      }
      finally
      {
         if (writeToFile != null)
         {
            try
            {
               writeToFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
   }
   /**
    * method used to read an object from the file
    * @param fileName file to read from
    * @return returns the object read
    * @throws FileNotFoundException Throws when file is not found
    * @throws IOException Throws when an IO error has occured
    * @throws ClassNotFoundException Throws when the class is wrong
    */
   public Object readObjectFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      Object obj = null;
      ObjectInputStream readFromFile = null;
      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new ObjectInputStream(fileInStream);
         try
         {
            obj = readFromFile.readObject();
         }
         catch (EOFException eof)
         {
           //Done reading
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            try
            {
               readFromFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }

      return obj;
   }
   
   /**
    * method used to read an objects from the file
    * @param fileName file to read from
    * @return returns the object array read
    * @throws FileNotFoundException Throws when file is not found
    * @throws IOException Throws when an IO error has occured
    * @throws ClassNotFoundException Throws when the class is wrong
    */
   public Object[] readArrayFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      ArrayList<Object> objs = new ArrayList<Object>();
      //ArrayList<Object>[] result = null;
      ObjectInputStream readFromFile = null;
      try
      {
         FileInputStream fileInStream = new FileInputStream(fileName);
         readFromFile = new ObjectInputStream(fileInStream);
         while (true)
         {
            try
            {
               objs.add(readFromFile.readObject());
            }
            catch (EOFException eof)
            {
              //Done reading
               break;
            }
         }
      }
      finally
      {
         if (readFromFile != null)
         {
            try
            {
               readFromFile.close();
            }
            catch (IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
      
      return objs.toArray();
   }
}
