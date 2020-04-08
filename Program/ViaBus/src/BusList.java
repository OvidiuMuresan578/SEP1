import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a list of buses
 *
 * @author Krystof Spiller
 * @version 0.2, 07/12/2016
 */

public class BusList implements Serializable
{
	private static final long serialVersionUID = 41L;
	private ArrayList<Bus> buses;
	
   /**
	* No-argument constructor. Buses variable is initialized as an arraylist.
	*/
	
	public BusList()
	{
		buses = new ArrayList<>();
	}
	
   /**
    * @param index
	* 		 the index of the Bus object in an arraylist as an integer
	* @return the object of type Bus on the given index of an arraylist only if the index is within the
	* 		  size boundaries of a buses arraylist
	*/
	
	public Bus getBus(int index)
	{
		if(index >= 0 && index < buses.size())
			return buses.get(index);
		return null;
	}
	
   /**
	* @return the number of busses as an integer
	*/
	
	public int getBusCount()
	{
		return buses.size();
	}
	
   /**
	* @return the object of type BusList containing all the party busses
	*/
	
	public BusList getPartyBuses()
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).isPartyBus())
				returnList.addBus(buses.get(i));
		return returnList;
	}

   /**
	* @return the object of type BusList containing all the busses with toilet
	*/

	public BusList getBusesWithToilet()
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).hasToilet())
				returnList.addBus(buses.get(i));
		return returnList;
	}
	
   /**
    * @param manufacturingYear
    * 		 the manufacturing year as an integer
	* @return the object of type BusList containing all the busses with the same manufacturing year
	*/
	
	public BusList getBusesByManufacturingYear(int manufacturingYear)
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).getManufacturingYear() == manufacturingYear)
				returnList.addBus(buses.get(i));
		return returnList;
	}

   /**
    * @param manufacturer
    * 		 the manufacturer of a bus as a String
	* @return the object of type BusList containing all the busses containing the manufacturer String in their
	* 		  stored manufacturer String
	*/
	
	public BusList getBusesByManufacturer(String manufacturer)
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).getManufacturer().matches("(?i).*" + manufacturer + ".*")) // regex for case insensitive search
				returnList.addBus(buses.get(i));
		return returnList;
	}

   /**
    * @param color
    * 		 the manufacturer of a bus as a String
	* @return the object of type BusList containing all the busses containing the manufacturer String in their
	* 		  stored manufacturer String
	*/

	public BusList getBusesByColor(String color)
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).getColor().matches("(?i).*" + color + ".*")) // regex for case insensitive search
				returnList.addBus(buses.get(i));
		return returnList;
	}

   /**
    * @param model
    * 		 the model of a bus as a String
	* @return the object of type BusList containing all the busses containing the model String in their
	* 		  stored model String
	*/	

	public BusList getBusesByModel(String model)
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).getModel().matches("(?i).*" + model + ".*")) // regex for case insensitive search
				returnList.addBus(buses.get(i));
		return returnList;
	}
	
   /**
    * @param plateNumber
    * 		 the plate number of a bus as a String
	* @return the object of type BusList containing all the busses containing the plateNumber String in their
	* 		  stored plateNumber String
	*/	
	
	public BusList getBusesByPlateNumber(String plateNumber)
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).getPlateNumber().matches("(?i).*" + plateNumber + ".*")) // regex for case insensitive search
				returnList.addBus(buses.get(i));
		return returnList;
	}

   /**
    * @param uniqueNumber
    * 		 the company's unique ID for each bus as a String
	* @return the object of type BusList containing all the busses containing the uniqueNumber String in their
	* 		  stored uniqueNumber String
	*/	
	
	public BusList getBusesByUniqueNumber(String uniqueNumber)
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).getUniqueNumber().matches("(?i).*" + uniqueNumber + ".*")) // regex for case insensitive search
				returnList.addBus(buses.get(i));
		return returnList;
	}
	
   /**
	* Returns BusList of busses which are available in a given date interval 
	* 
	* @param from
	*        Starting date as an object of type DateTime
	* @param to
    *        Ending date as an object of type DateTime
	* @return the object of type BusList containing all the busses which are available in a given date interval
	*/
	
	public BusList getAvailableBuses(DateTime from, DateTime to)
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).isAvailable(from, to))
				returnList.addBus(buses.get(i));
		return returnList;
	}
	
   /**
	* Returns BusList of busses which are available in a given date interval and which are party buses
	* 
	* @param from
	*        Starting date as an object of type DateTime
	* @param to
    *        Ending date as an object of type DateTime
	* @return the object of type BusList containing all the busses which are available in a given date interval
	* 		  and which are party buses
	*/
	
	public BusList getAvailablePartyBuses(DateTime from, DateTime to)
	{
		BusList returnList = new BusList();
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).isAvailable(from, to) && buses.get(i).isPartyBus())
				returnList.addBus(buses.get(i));
		return returnList;
	}
	
   /**
	* Merges BusList in the argument to the current BusList in a way that the buses are not duplicated
	* 
	* @param busList
	*        An object of type BusList
	*/
	
	public void mergeWith(BusList busList)
	{
		for(int i = 0; i < busList.getBusCount(); i++)
			this.addBus(busList.getBus(i));
	}
	
   /**
	* Adds a bus to the list only if the same bus or a bus with the same unique ID or plate number doesn't exist yet.
	* Prevents duplication.
	* 
	* @param bus
	*        An object of type Bus
	*/
	
	public void addBus(Bus bus)
	{
		for(int i = 0; i < buses.size(); i++)
			if(buses.get(i).equals(bus) || buses.get(i).getUniqueNumber().equals(bus.getUniqueNumber()) || buses.get(i).getPlateNumber().equals(bus.getPlateNumber()))
				return;
		buses.add(bus);
	}
	
   /**
	* Deletes a bus from the list of busses if it's found.
	* 
	* @param bus
	*        An object of type Bus
	*/
	
	public void deleteBus(Bus bus)
	{
		buses.remove(bus);
	}
}