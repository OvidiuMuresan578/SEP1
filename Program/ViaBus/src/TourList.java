import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a list of tours
 *
 * @author Krystof Spiller
 * @version 0.2, 07/12/2016
 */

public class TourList implements Serializable
{
	private static final long serialVersionUID = 31L;
	private ArrayList<Tour> tours;
	
   /**
	* No-argument constructor. Tours variable is initialized as an arraylist.
	*/
	
	public TourList()
	{
		tours = new ArrayList<>();
	}
	
   /**
    * @param index
	* 		 the index of the Tour object in an arraylist as an integer
	* @return the object of type Tour on the given index of an arraylist only if the index is within the
	* 		  size boundaries of a tours arraylist
	*/
	
	public Tour getTour(int index)
	{
		if(index >= 0 && index < tours.size())
			return tours.get(index);
		return null;
	}
	
	/**
	* @return the number of tours as an integer
	*/
	
	public int getTourCount()
	{
		return tours.size();
	}
	
   /**
    * @param destination
    * 		 the destination as a String
	* @return the object of type TourList containing all the tours containing the destination String in 
	* 		  one of its stops stored destinations String
	*/
	
	public TourList getToursByDestination(String destination)
	{
		TourList returnList = new TourList();
		for(int i = 0; i < tours.size(); i++)
			for(int j = 0; j < tours.get(i).getSchedule().getStops().length; j++)
				if(tours.get(i).getSchedule().getStop(j).getDestination().matches("(?i).*" + destination + ".*")) // regex for case insensitive search
					returnList.addTour(tours.get(i));
		return returnList;
	}
	
   /**
    * @param dateTime
    * 		 the date and time as a DateTime object
	* @return the object of type TourList containing all the tours whose schedule is overlaping with
	* 		  the dateTime specified in the argument
	*/
	
	public TourList getToursByDateTime(DateTime dateTime)
	{
		TourList returnList = new TourList();
		for(int i = 0; i < tours.size(); i++)
			if(tours.get(i).getSchedule().overlap(dateTime))
				returnList.addTour(tours.get(i));
		return returnList;
	}
	
   /**
    * @param chauffeur
    * 		 the chauffeur as a Chauffeur object
	* @return the object of type TourList containing all the tours which have the same chauffeur
	* 		  as the chauffeur specified in the argument
	*/
	
	public TourList getToursByChauffeur(Chauffeur chauffeur)
	{
		TourList returnList = new TourList();
		for(int i = 0; i < tours.size(); i++)
			if(tours.get(i).getChauffeur().equals(chauffeur))
				returnList.addTour(tours.get(i));
		return returnList;
	}
	
   /**
    * @param bus
    * 		 the bus as a Bus object
	* @return the object of type TourList containing all the tours which have the same bus
	* 		  as the bus specified in the argument
	*/
	
	public TourList getToursByBus(Bus bus)
	{
		TourList returnList = new TourList();
		for(int i = 0; i < tours.size(); i++)
			if(tours.get(i).getBus().equals(bus))
				returnList.addTour(tours.get(i));
		return returnList;
	}
	
   /**
    * @param reservation
    * 		 the reservation as a Reservation object
	* @return the object of type TourList containing the tour which have the same reservation
	* 		  as the reservation specified in the argument
	*/
	
	public TourList getToursByReservation(Reservation reservation)
	{
		TourList returnList = new TourList();
		for(int i = 0; i < tours.size(); i++)
			for(int j = 0; j < tours.get(i).getReservations().getReservationCount(); j++)
				if(tours.get(i).getReservations().getReservation(j).equals(reservation))
					returnList.addTour(tours.get(i));
		return returnList;
	}
	
   /**
	* Merges TourList in the argument to the current TourList in a way that the 
	* tours are not duplicated.
	* 
	* @param tourList
	*        An object of type TourList
	*/
	
	public void mergeWith(TourList tourList)
	{
		for(int i = 0; i < tourList.getTourCount(); i++)
			this.addTour(tourList.getTour(i));
	}
	
   /**
	* Adds a tour to the list only if the same tour doesn't exist yet.
	* Prevents duplication.
	* 
	* @param tour
	*        An object of type Tour
	*/
	
	public void addTour(Tour tour)
	{
		for(int i = 0; i < tours.size(); i++)
			if(tours.get(i).equals(tour))
				return;
		tours.add(tour);
	}
	
   /**
	* Deletes a tour from the list of tours if it's found.
	* 
	* @param tour
	*        An object of type Tour
	*/
	
	public void deleteTour(Tour tour)
	{
		tour.getChauffeur().removeSchedule(tour.getSchedule());
		tour.getBus().removeSchedule(tour.getSchedule());
		tours.remove(tour);
	}
}