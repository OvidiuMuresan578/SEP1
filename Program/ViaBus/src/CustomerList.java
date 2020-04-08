import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a list of customers
 *
 * @author Krystof Spiller
 * @version 0.2, 07/12/2016
 */

public class CustomerList implements Serializable 
{
	private static final long serialVersionUID = 11L;
	private ArrayList<Customer> customers;
	
   /**
	* No-argument constructor. Customers variable is initialized as an arraylist.
	*/	
	
	public CustomerList()
	{
		customers = new ArrayList<>();
	}
	
   /**
	* @param index
	* 		 the index of the Customer object in an arraylist as an integer
	* @return the object of type Customer on the given index of an arraylist only if the index is within the
	* 		  size boundaries of a customers arraylist
	*/
	
	public Customer getCustomer(int index)
	{
		if(index >= 0 && index < customers.size())
			return customers.get(index);
		return null;
	}
	
   /**
	* @return the number of customers as an integer
	*/
	
	public int getCustomerCount()
	{
		return customers.size();
	}
	
   /**
    * @param fullName
    * 		 the full name of a customer as a String
	* @return the object of type CustomerList containing all the customers containing the fullName String in their
	* 		  stored fullName String
	*/
	
	public CustomerList getCustomersByFullName(String fullName)
	{
		CustomerList returnList = new CustomerList();
		for(int i = 0; i < customers.size(); i++)
			if(customers.get(i).getFullName().matches("(?i).*" + fullName + ".*")) // regex for case insensitive search
				returnList.addCustomer(customers.get(i));
		return returnList;
	}

   /**
    * @param address
    * 		 the address of a customer as a String
	* @return the object of type CustomerList containing all the customers containing the address String in their
	* 		  stored address String
	*/	
	
	public CustomerList getCustomersByAddress(String address)
	{
		CustomerList returnList = new CustomerList();
		for(int i = 0; i < customers.size(); i++)
			if(customers.get(i).getAddress().matches("(?i).*" + address + ".*")) // regex for case insensitive search
				returnList.addCustomer(customers.get(i));
		return returnList;
	}

   /**
    * @param emailAddress
    * 		 the email address of a customer as a String
	* @return the object of type CustomerList containing all the customers containing the emailAddress String in their
	* 		  stored emailAddress String
	*/	

	public CustomerList getCustomersByEmailAddress(String emailAddress)
	{
		CustomerList returnList = new CustomerList();
		for(int i = 0; i < customers.size(); i++)
			if(customers.get(i).getEmail() != null && customers.get(i).getEmail().matches("(?i).*" + emailAddress + ".*")) // regex for case insensitive search
				returnList.addCustomer(customers.get(i));
		return returnList;
	}
	
   /**
    * @param CVR
    * 		 the company CVR number as a String
	* @return the object of type CustomerList containing all the customers containing the CVR String in their
	* 		  stored CVR String
	*/	
	
	public CustomerList getCustomersByCVR(String CVR)
	{
		CustomerList returnList = new CustomerList();
		for(int i = 0; i < customers.size(); i++)
			if(customers.get(i).getCVR() != null && customers.get(i).getCVR().matches("(?i).*" + CVR + ".*")) // regex for case insensitive search
				returnList.addCustomer(customers.get(i));
		return returnList;
	}
	
   /**
    * @param birthday
    * 		 the birthday of a customer as a DateTime
	* @return the object of type CustomerList containing all the customers who have the birthday on the
	* 		  day which is represented by the parameter birthday
	*/	

	public CustomerList getCustomersByBirthday(DateTime birthday)
	{
		CustomerList returnList = new CustomerList();
		for(int i = 0; i < customers.size(); i++)
			if(customers.get(i).getBirthday() != null && customers.get(i).getBirthday().equals(birthday)) // regex for case insensitive search
				returnList.addCustomer(customers.get(i));
		return returnList;
	}
	
   /**
    * @param phoneNumber
    * 		 the phone number of a customer as a String
	* @return the object of type CustomerList containing all the customers containing the phoneNumber String in their
	* 		  stored phoneNumber String
	*/	

	public CustomerList getCustomersByPhoneNumber(String phoneNumber)
	{
		CustomerList returnList = new CustomerList();
		for(int i = 0; i < customers.size(); i++)
			if(customers.get(i).getPhoneNumber() != null && customers.get(i).getPhoneNumber().matches("(?i).*" + phoneNumber + ".*")) // regex for case insensitive search
				returnList.addCustomer(customers.get(i));
		return returnList;
	}
	
   /**
    * @param companyName
    * 		 the company name as a String
	* @return the object of type CustomerList containing all the customers containing the companyName String in their
	* 		  stored companyName String
	*/	

	public CustomerList getCustomersByCompanyName(String companyName)
	{
		CustomerList returnList = new CustomerList();
		for(int i = 0; i < customers.size(); i++)
			if(customers.get(i).getCompanyName() != null && customers.get(i).getCompanyName().matches("(?i).*" + companyName + ".*")) // regex for case insensitive search
				returnList.addCustomer(customers.get(i));
		return returnList;
	}
	
   /**
	* Merges CustomerList in the argument to the current CustomerList in a way that the customers are not duplicated
	* 
	* @param customerList
	*        An object of type CustomerList
	*/
	
	public void mergeWith(CustomerList customerList)
	{
		for(int i = 0; i < customerList.getCustomerCount(); i++)
			this.addCustomer(customerList.getCustomer(i));
	}
	
   /**
	* Adds a customer to the list only if the same customer or a customer with the same phone number or email 
	* doesn't exist yet. Prevents duplication.
	* 
	* @param customer
	*        An object of type Customer
	*/
	
	public void addCustomer(Customer customer)
	{
		for(int i = 0; i < customers.size(); i++)
			if(customers.get(i).equals(customer) || customers.get(i).getPhoneNumber().equals(customer.getPhoneNumber()) || customers.get(i).getEmail().equals(customer.getEmail()))
				return;
		customers.add(customer);
	}
	   
   /**
	* Deletes a customer from the list of customers if it's found.
	* 
	* @param customer
	*        An object of type Customer
	*/
	public void deleteCustomer(Customer customer)
	{
		customers.remove(customer);
	}
}