import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * A class facilitating work with the file
 *
 * @author Krystof Spiller
 * @version 0.2, 07/12/2016
 */

public class FileIO implements Serializable
{
	private static final long serialVersionUID = 62L;
	File file;
	
   /**
	* No-argument constructor. Creating a Text object with the argument representing the name of binary file.
	*/	
	
	public FileIO()
	{
		file = new File("ViaBusCompany.bin");
	}
	
   /**
    * Write all the data from the object in the argument, which is the whole model, into a binary file.
    * 
    * @param obj
    * 		 an object of type ViaBusCompanyModelManager representing the model
	*/
	
	public void write(ViaBusCompanyModelManager obj)
	{
		ObjectOutputStream out = null;
		try
		{
			FileOutputStream fos = new FileOutputStream(file);
			out = new ObjectOutputStream(fos);
			out.writeObject(obj);	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				out.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
   /**
    * Read all the data the binary file and return the object representing the model.
    * 
    * @return an object of type ViaBusCompanyModelManager representing the model
	*/	
	
	public ViaBusCompanyModelManager read()
	{
		ObjectInputStream in = null;
		try
		{
			FileInputStream fis = new FileInputStream(file);
			in = new ObjectInputStream(fis);
			Object readObject =  in.readObject();
			if(readObject instanceof ViaBusCompanyModelManager)
				return (ViaBusCompanyModelManager)readObject;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				in.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
}