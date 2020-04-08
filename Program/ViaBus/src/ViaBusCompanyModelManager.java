import java.io.Serializable;

/**
 * A class representing the main model class, which allows to save the data in the model
 * to a file and allows the data in the model be used and processed by the controller
 *
 * @author Krystof Spiller
 * @version 0.3, 12/12/2016
 */

public class ViaBusCompanyModelManager implements Serializable
{
	private static final long serialVersionUID = 1L;
	private CustomerList customers;
	private ReservationList reservations;
	private TourList tours;
	private BusList buses;
	private ChauffeurList chauffeurs;
	private FileIO file;
	
   /**
	* Constructor, where all the variables are initialized as a new objects of their respective classes.
	*/
	
	public ViaBusCompanyModelManager()
	{
		customers = new CustomerList();
		reservations = new ReservationList();
		tours = new TourList();
		buses = new BusList();
		chauffeurs = new ChauffeurList();
		file = new FileIO();
	}
	
   /**
	* Searches for the customers based on the inputed search phrase. Calls all the methods of the 
	* CustomerList for specific customer parameters. Returned lists are merged together 
	* and returned as one CustomerList object.
	* 
	* @param searchPhrase
	* 		 the search phrase as a String
	* @return the CustomerList object containing all the customers who were found based on the
	* 		  search phrase from the argument
	*/
	
	public CustomerList searchCustomers(String searchPhrase)
	{
		CustomerList results = new CustomerList();
		results.mergeWith(customers.getCustomersByFullName(searchPhrase));
		results.mergeWith(customers.getCustomersByAddress(searchPhrase));
		results.mergeWith(customers.getCustomersByEmailAddress(searchPhrase));
		results.mergeWith(customers.getCustomersByCVR(searchPhrase));
		results.mergeWith(customers.getCustomersByPhoneNumber(searchPhrase));
		results.mergeWith(customers.getCustomersByCompanyName(searchPhrase));
		
		DateTime birthday = DateTime.parse(searchPhrase);
		if(birthday != null)
			results.mergeWith(customers.getCustomersByBirthday(birthday));
		
		return results;
	}
	
   /**
	* Searches for one specific customer based on the given arguments. Uses same methods as 
	* searchCustomers, but rather than merging them (uniting the lists), it does an intersection
	* of the lists returned for each entered argument. If there is more than one customer in the
	* intersection, null is returned. 
	* 
	* @param fullName
    *  		 the full name of a customer
    * @param address
    *  	 	 the address of a customer
    * @param phoneNumber
    *  	 	 the phone number of a customer
    * @param emailAddress
    *  	 	 the email address of a customer
    * @param CVR
    *  	 	 the CVR number of a company
    * @param companyName
    *  	 	 the company name
    * @param birthday
    *  	 	 the birthday of a customer as a String in format day/month/year (instead of slash, dot,
    *  		 space, hyphen and underscore can also be used)
	* @return the Customer object based on the inputed arguments
	*/
	
	public Customer findCustomer(String fullName, String address, String phoneNumber, String emailAddress, String CVR, String companyName, String birthday)
	{
		CustomerList results = null;
		boolean company = false;
		if(fullName != null)
			results = customers.getCustomersByFullName(fullName);
		if(address != null)
			results = customers.getCustomersByAddress(address);
		if(phoneNumber != null)
			results = customers.getCustomersByPhoneNumber(phoneNumber);
		if(emailAddress != null)
			results = customers.getCustomersByEmailAddress(emailAddress);
		if(birthday != null)
		{	
			DateTime DateTimeBirthday = DateTime.parse(birthday);
			if(DateTimeBirthday != null)
				results = customers.getCustomersByBirthday(DateTimeBirthday);
		}
		if(CVR != null)
		{
			results = customers.getCustomersByCVR(CVR);
			company = true;
		}
		if(companyName != null)
		{
			results = customers.getCustomersByCompanyName(companyName);
			company = true;
		}
		
		if(company)
		{
			if(CVR != null)
				results = results.getCustomersByCVR(CVR);
			if(companyName != null)
				results = results.getCustomersByCompanyName(companyName);
		}
		else
		{
			if(fullName != null)
				results = results.getCustomersByFullName(fullName);
			if(address != null)
				results = results.getCustomersByAddress(address);
			if(phoneNumber != null)
				results = results.getCustomersByPhoneNumber(phoneNumber);
			if(emailAddress != null)
				results = results.getCustomersByEmailAddress(emailAddress);
			if(birthday != null)
			{	
				DateTime DateTimeBirthday = DateTime.parse(birthday);
				if(DateTimeBirthday != null)
					results = results.getCustomersByBirthday(DateTimeBirthday);
			}
		}
		
		if(results.getCustomerCount() == 1)
			return results.getCustomer(0);
		else
			return null;
	}
	
   /**
	* Adds a customer to the CustomerList. Uses homonymous method from Customer class.
	* 
	* @param customer
	*        An object of type Customer
	*/
	
	public void addCustomer(Customer customer)
	{
		customers.addCustomer(customer);
	}
	
   /**
	* Deletes a customer from the CustomerList. Uses homonymous method from Customer class.
	* 
	* @param customer
	*        An object of type Customer
	*/
	
	public void deleteCustomer(Customer customer)
	{
		customers.deleteCustomer(customer);
	}	
	
   /**
	* Searches for the reservations based on the inputed search phrase. Calls two-argument homonymous
	* method with default second argument set to true, therefore searching for a tour,
	* and returns the result.
	* 
	* @param searchPhrase
	* 		 the search phrase as a String
	* @return the ReservationList object containing all the reservations which were found based on the
	* 		  search phrase from the argument
	*/
	
	public ReservationList searchReservations(String searchPhrase)
	{
		return searchReservations(searchPhrase, true);
	}
	
   /**
	* Searches for the reservations based on the inputed search phrase. Calls all the methods of the 
	* ReservationList for specific reservation parameters. Based on boolean variable, which is 
	* the second argument of the method, is decided whether the search for reservations based on
	* the tour parameter also has to be performed. This is important in order to prevent infinite
	* loop, because the method for searching tours calls this method. Returned lists are merged
	* together and returned as one ReservationList object.
	* 
	* @param searchPhrase
	* 		 the search phrase as a String
	* @param searchForTour
	* 		 boolean, telling the method if search based on tour has to be perfomed (true) or not (false)
	* @return the ReservationList object containing all the reservations which were found based on the
	* 		  search phrase from the argument
	*/
	
	private ReservationList searchReservations(String searchPhrase, boolean searchForTour)
	{
		ReservationList results = new ReservationList();
		results.mergeWith(reservations.getReservationsByPassenger(searchPhrase));
		
		if(searchPhrase.matches("[0-9]*[.,]?[0-9]+$"))
		{
			String doubleString = searchPhrase.replaceAll(",", ".");
			double price = Double.parseDouble(doubleString);
			results.mergeWith(reservations.getReservationsByPrice(price));
		}
		
		CustomerList customers = searchCustomers(searchPhrase);
		for(int i = 0; i < customers.getCustomerCount(); i++)
			results.mergeWith(reservations.getReservationsByCustomer(customers.getCustomer(i)));
		
		if(searchForTour)
		{
			TourList tours = searchTours(searchPhrase, false);
			for(int i = 0; i < tours.getTourCount(); i++)
				results.mergeWith(reservations.getReservationsByTour(tours.getTour(i)));
		}
		
		return results;
	}
	
   /**
	* Adds a reservation to the ReservationList. Uses homonymous method from Reservation class.
	* 
	* @param reservation
	*        An object of type Reservation
	*/
	
	public void addReservation(Reservation reservation)
	{
		reservations.addReservation(reservation);
	}
	
   /**
	* Deletes a reservation from the ReservationList. Uses homonymous method from Reservation class.
	* 
	* @param reservation
	*        An object of type Reservation
	*/
	
	public void deleteReservation(Reservation reservation)
	{
		reservations.deleteReservation(reservation);
	}
	
   /**
    * @return the TourList object containing only Travel objects
    */
	
	public TourList getTravels()
	{
		TourList travels = new TourList();
		for(int i = 0; i < tours.getTourCount(); i++)
			if(tours.getTour(i).getClassName() == "Travel")
				travels.addTour(tours.getTour(i));
		return travels;
	}

   /**
    * @return the TourList object containing only OneDayTrip objects
    */
		
	public TourList getOneDayTrips()
	{
		TourList oneDayTrips = new TourList();
		for(int i = 0; i < tours.getTourCount(); i++)
			if(tours.getTour(i).getClassName() == "OneDayTrip")
				oneDayTrips.addTour(tours.getTour(i));
		return oneDayTrips;
	}
	

   /**
    * @return the TourList object containing only BusAndChauffeur objects
    */
		
	public TourList getBusAndChauffeurs()
	{
		TourList busAndChauffeurs = new TourList();
		for(int i = 0; i < tours.getTourCount(); i++)
			if(tours.getTour(i).getClassName() == "BusAndChauffeur")
				busAndChauffeurs.addTour(tours.getTour(i));
		return busAndChauffeurs;
	}
	
   /**
	* Searches for the tours based on the inputed search phrase. Calls two-argument homonymous
	* method with default second argument set to true, therefore searching for a reservation,
	* and returns the result.
	* 
	* @param searchPhrase
	* 		 the search phrase as a String
	* @return the TourList object containing all the tour which were found based on the
	* 		  search phrase from the argument
	*/
	
	public TourList searchTours(String searchPhrase)
	{
		return searchTours(searchPhrase, true);
	}
	
   /**
	* Searches for the tours based on the inputed search phrase. Calls all the methods of the TourList 
	* for specific tour parameters. Based on boolean variable, which is the second argument 
	* of the method, is decided whether the search for tours based on the reservation parameter 
	* also has to be performed. This is important in order to prevent infinite loop, because 
	* the method for searching reservations calls this method. Returned lists are merged together 
	* and returned as one TourList object.
	* 
	* @param searchPhrase
	* 		 the search phrase as a String
	* @param searchForReervation
	* 		 boolean, telling the method if search based on reservation has to be perfomed (true) 
	* 		 or not (false)
	* @return the TourList object containing all the tour which were found based on the search 
	* 		  phrase from the argument
	*/
	
	private TourList searchTours(String searchPhrase, boolean searchForReservation)
	{
		TourList results = new TourList();
		results.mergeWith(tours.getToursByDestination(searchPhrase));

		DateTime date = DateTime.parse(searchPhrase);
		if(date != null)
			results.mergeWith(tours.getToursByDateTime(date));
		
		ChauffeurList chauffeurs = searchChauffeurs(searchPhrase);
		for(int i = 0; i < chauffeurs.getChauffeurCount(); i++)
			results.mergeWith(tours.getToursByChauffeur(chauffeurs.getChauffeur(i)));
		
		BusList buses = searchBuses(searchPhrase);
		for(int i = 0; i < buses.getBusCount(); i++)
			results.mergeWith(tours.getToursByBus(buses.getBus(i)));
		
		if(searchForReservation)
		{	
			ReservationList reservations = searchReservations(searchPhrase, false);
			for(int i = 0; i < reservations.getReservationCount(); i++)
				results.mergeWith(tours.getToursByReservation(reservations.getReservation(i)));
		}
		
		return results;
	}
	
   /**
	* Adds a tour to the TourList. Uses homonymous method from Tour class.
	* 
	* @param tour
	*        An object of type Tour
	*/
	
	public void addTour(Tour tour)
	{
		tours.addTour(tour);
	}
	
   /**
	* Deletes a tour from the TourList. Uses homonymous method from Tour class.
	* 
	* @param tour
	*        An object of type Tour
	*/
	
	public void deleteTour(Tour tour)
	{
		tours.deleteTour(tour);
	}
	
   /**
    * @return the BusList object containing all the buses stored in the model
    */
	
	public BusList getBuses()
	{
		return buses;
	}
	
   /**
	* Searches for the buses based on the inputed search phrase. Calls all the methods of the 
	* BusList for specific bus parameters. Returned lists are merged together 
	* and returned as one BusList object.
	* 
	* @param searchPhrase
	* 		 the search phrase as a String
	* @return the BusList object containing all the buses which were found based on the
	* 		  search phrase from the argument
	*/
	
	public BusList searchBuses(String searchPhrase)
	{
		BusList results = new BusList();
		results.mergeWith(buses.getBusesByManufacturer(searchPhrase));
		results.mergeWith(buses.getBusesByColor(searchPhrase));
		results.mergeWith(buses.getBusesByModel(searchPhrase));
		results.mergeWith(buses.getBusesByPlateNumber(searchPhrase));
		results.mergeWith(buses.getBusesByUniqueNumber(searchPhrase));
		
		if(!searchPhrase.matches(".*[^0-9].*"))
		{
			int manufacturingYear = Integer.parseInt(searchPhrase);
			if(manufacturingYear >= 1900 && manufacturingYear <= DateTime.now().getYear())
				results.mergeWith(buses.getBusesByManufacturingYear(manufacturingYear));
		}
		
		return results;
	}
	
   /**
	* Returns available buses based on the two arguments in a BusList object.
	* 
	* @param from
	*        the the date and time from which it searches for available buses as a DateTime object
	* @param to
	*        the the date and time to which it searches for available buses as a DateTime object    
	* @return return BusList object containing all the buses which are available from the date and
	* 		  time specified as the first argument until the date and time specified as the second
	* 		  argument   
	*/
	
	public BusList getAvailableBuses(DateTime from, DateTime to)
	{	
		return buses.getAvailableBuses(from, to);
	}
	
   /**
	* Adds a bus to the BusList. Uses homonymous method from Bus class.
	* 
	* @param bus
	*        An object of type Bus
	*/

	public void addBus(Bus bus)
	{
		buses.addBus(bus);
	}
	
   /**
	* Deletes a bus from the BusList. Uses homonymous method from Bus class.
	* 
	* @param bus
	*        An object of type Bus
	*/
	
	public void deleteBus(Bus bus)
	{
		buses.deleteBus(bus);
	}
	
   /**
    * @return the ChauffeurList object containing all the chauffeurs stored in the model
    */
	
	public ChauffeurList getChauffeurs()
	{
		return chauffeurs;
	}
	
   /**
	* Searches for the chauffeurs based on the inputed search phrase. Calls all the methods of the 
	* ChauffeurList for specific chauffeur parameters. Returned lists are merged together 
	* and returned as one ChauffeurList object.
	* 
	* @param searchPhrase
	* 		 the search phrase as a String
	* @return the ChauffeurList object containing all the chauffeurs who were found based on the
	* 		  search phrase from the argument
	*/
	
	public ChauffeurList searchChauffeurs(String searchPhrase)
	{
		ChauffeurList results = new ChauffeurList();
		results.mergeWith(chauffeurs.getChauffeursByFullName(searchPhrase));
		results.mergeWith(chauffeurs.getChauffeursByAddress(searchPhrase));
		results.mergeWith(chauffeurs.getChauffeursByID(searchPhrase));
		results.mergeWith(chauffeurs.getChauffeursByPhoneNumber(searchPhrase));
		results.mergeWith(chauffeurs.getChauffeursByEmailAddress(searchPhrase));
		results.mergeWith(chauffeurs.getChauffeursByWishes(searchPhrase));
		return results;
	}
	
   /**
	* Returns available chauffeurs based on the two arguments in a ChauffeurList object.
	* 
	* @param from
	*        the the date and time from which it searches for available buses as a DateTime object
	* @param to
	*        the the date and time to which it searches for available buses as a DateTime object    
	* @return return ChauffeurList object containing all the chauffeurs which are available from 
	* 		  the date and time specified as the first argument until the date and time specified 
	* 		  as the second argument   
	*/

	public ChauffeurList getAvailableChauffeurs(DateTime from, DateTime to)
	{
		return chauffeurs.getAvailableChauffeurs(from, to);
	}
	
   /**
	* Adds a chauffeur to the ChauffeurList. Uses homonymous method from Chauffeur class.
	* 
	* @param chauffeur
	*        An object of type Chauffeur
	*/
	
	public void addChauffeur(Chauffeur chauffeur)
	{
		chauffeurs.addChauffeur(chauffeur);
	}
	
   /**
	* Deletes a chauffeur from the ChauffeurList. Uses homonymous method from Chauffeur class.
	* 
	* @param chauffeur
	*        An object of type Chauffeur
	*/
	
	public void deleteChauffeur(Chauffeur chauffeur)
	{
		chauffeurs.deleteChauffeur(chauffeur);
	}
	
   /**
	* Saves the model to the binary file using FileIO class method.
	*/
	
	public void save()
	{
		file.write(this);
	}
	
   /**
	* Loads the model from the binary file using FileIO class method and assigns in to the instance variables
	*/
	
	public void load()
	{
		ViaBusCompanyModelManager that = file.read();
		this.buses = that.buses;
		this.chauffeurs = that.chauffeurs;
		this.customers = that.customers;
		this.file = that.file;
		this.reservations = that.reservations;
		this.tours = that.tours;
	}
}