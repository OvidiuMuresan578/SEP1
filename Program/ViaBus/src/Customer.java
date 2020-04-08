import java.io.Serializable;

/**
 * A class representing a customer
 *
 * @author Krystof Spiller
 * @version 0.3, 12/12/2016
 */

public class Customer implements Serializable
{
	private static final long serialVersionUID = 12L;
	String fullName, address, phoneNumber, emailAddress, companyName, CVR;
	DateTime birthday;
	ReservationList reservations;
	
   /**
    * Three-argument constructor. Email address, company name, CVR and birthday variables are set to empty strings.
    * Reservations variable is initialized as an arraylist. 
    *
    * @param fullName
    *  		 the full name of a customer
    * @param address
    *  	 	 the address of a customer
    * @param phoneNumber
    *  	 	 the phone number of a customer
    */
	
	public Customer(String fullName, String address, String phoneNumber)
	{
		setFullName(fullName);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		emailAddress = "";
		companyName = "";
		CVR = "";
		birthday = null;
		reservations = new ReservationList();
	}
	
   /**
	* @return the full name of a customer as a String
	*/

	public String getFullName()
	{
		return fullName;
	}
	
   /**
	* @return the address of a customer as a String
	*/
	
	public String getAddress()
	{
		return address;
	}
	
   /**
	* @return the phone number of a customer as a String
	*/	
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
   /**
	* @return the email address of a customer as a String
	*/
	
	public String getEmail()
	{
		return emailAddress;
	}
	
   /**
	* @return the birthday of a customer as a DateTime
	*/
	
	public DateTime getBirthday()
	{
		return birthday;
	}

   /**
	* @return the age of a customer as an integer
	*/
	
	public int getAge()
	{
		if(birthday != null)
			return birthday.yearsBetween(DateTime.now());
		return -1;
	}
	
   /**
	* @return the company CVR number as a String
	*/
	
	public String getCVR()
	{
		return CVR;
	}

   /**
	* @return the company name as a String
	*/

	public String getCompanyName()
	{
		return companyName;
	}
	
   /**
	* @return the reservations as a ReservationList
	*/
	
	public ReservationList getReservations()
	{
		return reservations;
	}
   
   /**
    * @return the total price for all customer's reservations as a double
    */
	
	public double getReservationsTotalPrice()
	{
		double total = 0;
		for(int i = 0; i < reservations.getReservationCount(); i++)
			total += reservations.getReservation(i).getPrice();
		return total;
	}
	
   /**
	* @return the total length for all customer's reservations as a DateTime
	*/
	
	public DateTime getReservationsTotalLength()
	{
		DateTime counter = new DateTime(0, 0, 0);
		for(int i = 0; i < reservations.getReservationCount(); i++)
			counter.addDateTime(reservations.getReservation(i).getTour().getSchedule().getLength());
		return counter;
	}
	
   /**
    * Sets the full name of a customer. Capitalizes the first letter of the inputed string.
    * 
    * @param fullName
    *        the full name of a customer as a String
    */
	
	public void setFullName(String fullName) 
	{
		this.fullName = fullName.toUpperCase().charAt(0) + fullName.substring(1);
	}
	
   /**
	* Sets the address of a customer.
	* 
	* @param address
	*        the address of a customer as a String
	*/
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
   /**
    * Sets the phone number of a customer. Inputed string is processed so prefix for Denmark is erased if it's present, 
    * spaces are deleted and the resulting string is checked if it consists only of 8 digits. 
    * Otherwise exception for illegal argument is thrown
    * 
    * @param phoneNumber
    *        the phone number of a customer as a String
    */
	
	public void setPhoneNumber(String phoneNumber)
	{
		if(phoneNumber.substring(0, 3).equals("+45"))
			phoneNumber = phoneNumber.substring(3);
		phoneNumber = phoneNumber.replaceAll("\\s+",""); // regex for whitespace
		if(phoneNumber.matches("[0-9]+") && phoneNumber.length() == 8)
			this.phoneNumber = phoneNumber;
		else
			throw new IllegalArgumentException("Not a valid phone number");
	}
	
   /**
	* Sets the email address of a customer. Inputed string is not a valid email address if '@' (at sign) is the first letter, 
	* the last letter or isn't in the sting at all. In one or more of these cases, the exception for illegal argument is thrown.
	* 
	* @param emailAddress
	*        The email address of a customer as a String
	*/
	
	public void setEmailAddress(String emailAddress)
	{
		if(emailAddress.indexOf('@') != -1 && emailAddress.indexOf('@') != 0 && emailAddress.indexOf('@') != (emailAddress.length() - 1))
			this.emailAddress = emailAddress;
		else
			throw new IllegalArgumentException("Not a valid email address");
	}
	
   /**
	* Sets the birthday of a customer.
	* 
	* @param birthday
	*        the birthday of a customer as a DateTime
	*/	
	
	public void setBirthday(DateTime birthday)
	{
		this.birthday = birthday;
	}
	
   /**
	* Sets the company name and company's CVR number only if the CVR number is 8 characters long.
	* Otherwise exception for illegal argument is thrown.
	* 
	* @param companyName
	*        the company name as a String
	* @param CVR
	*        the company CVR number as a String
	*/		

	public void setCompany(String companyName, String CVR)
	{
		if(CVR.length() == 8)
		{
			this.companyName = companyName;
			this.CVR = CVR;
		}
		else
			throw new IllegalArgumentException("Not a valid CVR");
	}
	
   /**
	* Adds a reservation to customer's list of reservations.
	* 
	* @param reservation
	*        an object of type Reservation
	*/
	
	public void addReservation(Reservation reservation)
	{
		reservations.addReservation(reservation);
	}
	
   /**
	* Removes a reservation from customer's list of reservations.
	* 
	* @param reservation
	*        an object of type Reservation
	*/
	
	public void removeReservation(Reservation reservation)
	{
		reservations.deleteReservation(reservation);
	}
	
   /**
	* Comparing objects to one another.
    * 
    * @param obj
    * 		 an Object for comparison
    * @return if the objects equal to each other   
    */
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Customer))
			return false;
		Customer other = (Customer)obj;
		
		return this.fullName.equals(other.fullName) &&
			   this.address.equals(other.address) &&
			   this.phoneNumber.equals(other.phoneNumber) &&
			   this.emailAddress.equals(other.emailAddress) && 
			   this.companyName.equals(other.companyName) &&
			   this.CVR.equals(other.CVR) &&
			   this.reservations.getReservationCount() == other.reservations.getReservationCount() &&
			!((this.birthday == null || other.birthday == null) && this.birthday != other.birthday) &&
			 ((this.birthday == null && other.birthday == null) ||
			   this.birthday.equals(other.birthday));
	}
}