import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a list of chauffeurs
 *
 * @author Krystof Spiller
 * @version 0.1, 08/12/2016
 */

public class ChauffeurList implements Serializable 
{
	private static final long serialVersionUID = 51L;
	private ArrayList<Chauffeur> chauffeurs;
	
   /**
	* No-argument constructor. Chauffeurs variable is initialized as an arraylist.
	*/
	
	public ChauffeurList()
	{
		chauffeurs = new ArrayList<>();
	}

   /**
    * @param index
	* 		 the index of the Chauffeur object in an arraylist as an integer
	* @return the object of type Chauffeur on the given index of an arraylist only if the index is within the
	* 		  size boundaries of a chauffeurs arraylist
	*/

	public Chauffeur getChauffeur(int index)
	{
		if(index >= 0 && index < chauffeurs.size())
			return chauffeurs.get(index);
		return null;
	}
	
   /**
	* @return the number of chauffeurs as an integer
	*/
	
	public int getChauffeurCount()
	{
		return chauffeurs.size();
	}
	 
   /**
	* @param fullName
	* 		 the full name of a chauffeur as a String
	* @return the object of type ChauffeurList containing all the chauffeurs containing the fullName String in their
	* 		  stored fullName String
	*/	
	
	public ChauffeurList getChauffeursByFullName(String fullName)
	{
		ChauffeurList returnList = new ChauffeurList();
		for(int i = 0; i < chauffeurs.size(); i++)
			if(chauffeurs.get(i).getFullName().matches("(?i).*" + fullName + ".*"))
				returnList.addChauffeur(chauffeurs.get(i));
		return returnList;
	}

   /**
	* @param address
	* 		 the address of a chauffeur as a String
	* @return the object of type ChauffeurList containing all the chauffeurs containing the address String in their
	* 		  stored address String
	*/	

	public ChauffeurList getChauffeursByAddress(String address)
	{
		ChauffeurList returnList = new ChauffeurList();
		for(int i = 0; i < chauffeurs.size(); i++)
			if(chauffeurs.get(i).getAddress().matches("(?i).*" + address + ".*"))
				returnList.addChauffeur(chauffeurs.get(i));
		return returnList;
	}
	
   /**
	* @param ID
	* 		 the ID of a chauffeur as a String
	* @return the object of type ChauffeurList containing all the chauffeurs containing the ID String in their
	* 		  stored ID String
	*/	
	
	public ChauffeurList getChauffeursByID(String ID)
	{
		ChauffeurList returnList = new ChauffeurList();
		for(int i = 0; i < chauffeurs.size(); i++)
			if(chauffeurs.get(i).getID().matches("(?i).*" + ID + ".*"))
				returnList.addChauffeur(chauffeurs.get(i));
		return returnList;
	}
	
   /**
	* @param phoneNumber
	* 		 the phone number of a chauffeur as a String
	* @return the object of type ChauffeurList containing all the chauffeurs containing the phoneNumber String in their
	* 		  stored phoneNumber String
	*/	
	
	public ChauffeurList getChauffeursByPhoneNumber(String phoneNumber)
	{
		ChauffeurList returnList = new ChauffeurList();
		for(int i = 0; i < chauffeurs.size(); i++)
			if(chauffeurs.get(i).getPhoneNumber().matches("(?i).*" + phoneNumber + ".*"))
				returnList.addChauffeur(chauffeurs.get(i));
		return returnList;
	}
	
   /**
	* @param emailAddress
	* 		 the email address of a chauffeur as a String
	* @return the object of type ChauffeurList containing all the chauffeurs containing the emailAddress String in their
	* 		  stored emailAddress String
	*/	
	
	public ChauffeurList getChauffeursByEmailAddress(String emailAddress)
	{
		ChauffeurList returnList = new ChauffeurList();
		for(int i = 0; i < chauffeurs.size(); i++)
			if(chauffeurs.get(i).getEmail().matches("(?i).*" + emailAddress + ".*"))
				returnList.addChauffeur(chauffeurs.get(i));
		return returnList;
	}
	
   /**
	* @param wishes
	* 		 the wishes of chauffeur as a String
	* @return the object of type ChauffeurList containing all the chauffeurs containing the wishes String in their
	* 		  stored wishes String
	*/	
	
	public ChauffeurList getChauffeursByWishes(String wishes)
	{
		ChauffeurList returnList = new ChauffeurList();
		for(int i = 0; i < chauffeurs.size(); i++)
			if(chauffeurs.get(i).getWishes() != null && chauffeurs.get(i).getWishes().matches("(?i).*" + wishes + ".*"))
				returnList.addChauffeur(chauffeurs.get(i));
		return returnList;
	}
	
   /**
	* Returns ChauffeurList of chauffeurs which are available in a given date interval
	* 
	* @param from
	*        Starting date as an object of type DateTime
	* @param to
    *        Ending date as an object of type DateTime
	* @return the object of type ChauffeurList containing all the chauffeurs which are 
	* 		  available in a given date interval
	*/
	
	public ChauffeurList getAvailableChauffeurs(DateTime from, DateTime to)
	{
		ChauffeurList returnList = new ChauffeurList();
		for(int i = 0; i < chauffeurs.size(); i++)
			if(chauffeurs.get(i).isAvailable(from, to))
				returnList.addChauffeur(chauffeurs.get(i));
		return returnList;
	}
	
   /**
	* Merges ChauffeurList in the argument to the current ChauffeurList in a way 
	* that the chauffeurs are not duplicated
	* 
	* @param chauffeurList
	*        An object of type ChauffeurList
	*/
	
	public void mergeWith(ChauffeurList chauffeurList)
	{
		for(int i = 0; i < chauffeurList.getChauffeurCount(); i++)
			this.addChauffeur(chauffeurList.getChauffeur(i));
	}
	
	/**
	* Add a chauffeur to the list only if the same chauffeur or a chauffeur with the same 
	* employee ID, phone number or email doesn't exist yet. Prevents duplication.
	* 
	* @param chauffeur
	*        an object of type Chauffeur
	*/
	
	public void addChauffeur(Chauffeur chauffeur)
	{
		for(int i = 0; i < chauffeurs.size(); i++)
			if(chauffeurs.get(i).equals(chauffeur) || 
			   chauffeurs.get(i).getID().equals(chauffeur.getID()) || 
			   chauffeurs.get(i).getPhoneNumber().equals(chauffeur.getPhoneNumber()) ||
			   chauffeurs.get(i).getEmail().equals(chauffeur.getEmail()))
				return;
		chauffeurs.add(chauffeur);
	}
	
   /**
	* Deletes a chauffeur from the list of chauffeurs if it's found.
	* 
	* @param chauffeur
	*        An object of type Chauffeur
	*/
	
	public void deleteChauffeur(Chauffeur chauffeur)
	{
		chauffeurs.remove(chauffeur);
	}
}