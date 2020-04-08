public class Test 
{
	public static void main(String[] args)
	{
		ViaBusCompanyModelManager model = new ViaBusCompanyModelManager();
		
		int[] seatsK440 = {12, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44,
				  		   51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 83,
				  		   91, 92, 93, 94, 101, 102, 103, 104, 111, 112, 113, 114,
				  		   121, 122, 123, 124, 131, 132, 133, 134, 141, 142, 143, 144, 145}; //53
		int[] seatsK480 = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44,
						   51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 83,
						   91, 92, 93, 94, 101, 102, 103, 104, 111, 112, 113, 114,
						   121, 122, 123, 124, 131, 132, 133, 134, 141, 142, 143, 144, 145}; //55
		Bus k440eb = new Bus("K440-1", "DK23456", "Scania", "K440EB", 2012, seatsK440);
		Bus k480eb = new Bus("K480-1", "DK12345", "Scania", "K480EB", 2015, seatsK480);
		k440eb.setColor("Blue");
		k480eb.setToilet(true);
		k480eb.setParty(true);
		
		Chauffeur cristian = new Chauffeur("Cristian Cuibaru", "Student Village 123", "12345", "12345678", "cristian@email.com", true);
		Chauffeur denis = new Chauffeur("Denis Durovic", "Student Village 124", "98765", "23456789", "denis@email.com", false);
		
		Schedule oneDayTripSchedule = new Schedule(new Stop("Horsens", new DateTime(14, 1, 2017, 6, 0, 0)), new Stop("Horsens", new DateTime(14, 1, 2017, 22, 0, 0)));
		oneDayTripSchedule.addStop(new Stop("Copenhagen", new DateTime(14, 1, 2017, 10, 0, 0)));
		oneDayTripSchedule.setMainDestination(1);
		
		Schedule travelSchedule = new Schedule(new Stop("Horsens", new DateTime(14, 1, 2017, 8, 0, 0)), new Stop("Horsens", new DateTime(20, 1, 2017, 20, 0, 0)));
		travelSchedule.addStop(new Stop("Roskilde", new DateTime(14, 1, 2017, 12, 0, 0)));
		travelSchedule.addStop(new Stop("Copenhagen", new DateTime(14, 1, 2017, 18, 0, 0)));
		travelSchedule.setMainDestination(2);
		
		Schedule busAndChauffeurSchedule1 = new Schedule(new Stop("Horsens", new DateTime(15, 1, 2017, 8, 0, 0)), new Stop("Horsens", new DateTime(20, 1, 2017, 20, 0, 0)));
		busAndChauffeurSchedule1.addStop(new Stop("Odense", new DateTime(15, 1, 2017, 10, 30, 0)));
		busAndChauffeurSchedule1.addStop(new Stop("Copenhagen", new DateTime(15, 1, 2017, 20, 0, 0)));
		busAndChauffeurSchedule1.setMainDestination(2);
		
		Schedule busAndChauffeurSchedule2 = new Schedule(new Stop("Horsens", new DateTime(21, 1, 2017, 9, 0, 0)), new Stop("Horsens", new DateTime(25, 1, 2017, 21, 0, 0)));
		busAndChauffeurSchedule2.addStop(new Stop("Malmo", new DateTime(21, 1, 2017, 15, 0, 0)));
		busAndChauffeurSchedule2.setMainDestination(1);
		
		OneDayTrip oneDayTrip = new OneDayTrip(denis, k440eb, oneDayTripSchedule, false);
		Travel travel = new Travel(cristian, k480eb, travelSchedule, true);
		BusAndChauffeur busAndChauffeur1 = new BusAndChauffeur(denis, k440eb, busAndChauffeurSchedule1, true);
		BusAndChauffeur busAndChauffeur2 = new BusAndChauffeur(cristian, k480eb, busAndChauffeurSchedule2, true);
		
		Customer krystof = new Customer("Anna Spiller", "Kamtjatka 13", "12311321");
		krystof.setBirthday(new DateTime(27, 12, 1996));
		krystof.setEmailAddress("krystof@email.com");
		Customer greatCorp = new Customer("Secretary Anna", "Corpgade 1", "11111111");
		greatCorp.setEmailAddress("info@greatcorp.inc");
		greatCorp.setCompany("Great Corp Inc.", "54535251");
		
		Reservation reservation1 = new Reservation(krystof, oneDayTrip, 700);
		reservation1.addPassenger(new Passenger("Tobias Jensen"));
		reservation1.addPassenger(new Passenger("Emma Jensen"));
		reservation1.bookSeat(31);
		reservation1.bookSeat(32);
		reservation1.bookSeat(33);
		
		Reservation reservation2 = new Reservation(greatCorp, travel, 1800);
		reservation2.addPassenger(new Passenger("Frederk Nielsen"));
		reservation2.addPassenger(new Passenger("Julie Nielsen"));
		reservation2.addPassenger(new Passenger("Simon Hansen"));
		reservation2.addPassenger(new Passenger("Emma Hansen"));
		reservation2.addPassenger(new Passenger("Mathias Pedersen"));
		reservation2.addPassenger(new Passenger("Sofie Andersen"));
		reservation2.addPassenger(new Passenger("Christian Larsen"));
		reservation2.addPassenger(new Passenger("Cecilie Christensen"));
		reservation2.bookSeat(61);
		reservation2.bookSeat(62);
		reservation2.bookSeat(63);
		reservation2.bookSeat(64);
		reservation2.bookSeat(71);
		reservation2.bookSeat(72);
		reservation2.bookSeat(73);
		reservation2.bookSeat(74);
		
		Reservation reservation3 = new Reservation(krystof, busAndChauffeur1, 6000);
		reservation3.setCountOfPassengers(25);
		
		Reservation reservation4 = new Reservation(greatCorp, busAndChauffeur2, 9000);
		reservation4.setCountOfPassengers(40);
		
		model.addBus(k480eb);
		model.addBus(k440eb);
		
		model.addChauffeur(cristian);
		model.addChauffeur(denis);
	
		model.addCustomer(greatCorp);
		model.addCustomer(krystof);
		
		model.addReservation(reservation1);
		model.addReservation(reservation2);
		model.addReservation(reservation3);
		model.addReservation(reservation4);
		
		model.addTour(busAndChauffeur1);
		model.addTour(busAndChauffeur2);
		model.addTour(travel);
		model.addTour(oneDayTrip);
		
		model.deleteBus(k480eb);
		model.deleteChauffeur(cristian);
		model.deleteCustomer(krystof);
		model.deleteReservation(reservation3);
		model.deleteTour(busAndChauffeur2);
		
		model.addBus(k480eb);
		model.addChauffeur(cristian);
		model.addCustomer(krystof);
		model.addReservation(reservation3);
		model.addTour(busAndChauffeur2);
		
		System.out.println("Model Customer Function 1: " + model.searchCustomers("").getCustomerCount());
		System.out.println("Model Customer Function 2: " + model.findCustomer("Anna", "Corp", null, null, null, null, null).getAddress());
		System.out.println("Model Reservation Function 1: " + model.searchReservations("Copenhagen").getReservationCount());
	}
}