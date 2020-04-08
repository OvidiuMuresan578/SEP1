import java.io.Serializable;
/**
 * Class designed to hold all the personal info for each guest
 * @author Filip Zelenika
 *
 */
public class Guest implements Serializable
{
   private String name;
   private String homeAdress;
   private String phone;
   private String email;
   private String passportNumber;
   private String dateOfBirth;
   private String roomNum;
   
   /**
    * Default constructor
    */
   public Guest()
   {
      name = "";
      homeAdress = "";
      phone = "";
      email = "";
      passportNumber = "";
      dateOfBirth = "";
      roomNum = "";
   }
   /**
    * Constructor that takes a rom as an argument and makes itself get the room number
    * 
    * @param r room number to be added
    * 
    */
   public Guest(Room r)
   {
      name = "";
      homeAdress = "";
      phone = "";
      email = "";
      passportNumber = "";
      dateOfBirth = "";
      roomNum = String.valueOf(r.getRoomNumber());
   }
   
   /**
    * Constructor that takes the name as an argument
    * @param s name string
    */
   public Guest(String s)
   {
      name = s;
      homeAdress = "";
      phone = "";
      email = "";
      passportNumber = "";
      dateOfBirth = "";
      roomNum = "";
   }
   /**
    * Constructor that takes every field as a parmater
    * @param n	note text
    * @param addr home address
    * @param p phone
    * @param dob date of birth
    * @param em email
    * @param pass passport code
    * @param roomN room number
    */
   public Guest(String n, String addr, String p, String dob, String em, String pass, String roomN)
   {
      name = n;
      homeAdress = addr; 
      phone = p;
      dateOfBirth = dob;
      email = em;
      passportNumber = pass;
      roomNum = roomN;
      
   }
   public String getName()
   {
      return name;
   }

   public String getHomeAdress()
   {
      return homeAdress;
   }

   public String getPhone()
   {
      return phone;
   }

   public String getEmail()
   {
      return email;
   }

   public String getPassportNumber()
   {
      return passportNumber;
   }

   public String getDateOfBirth()
   {
      return dateOfBirth;
   }

   public String getRoomNum()
   {
      return roomNum;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }

   public void setHomeAdress(String homeAdress)
   {
      this.homeAdress = homeAdress;
   }

   public void setPhone(String phone)
   {
      this.phone = phone;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public void setPassportNumber(String passportNumber)
   {
      this.passportNumber = passportNumber;
   }

   public void setDateOfBirth(String dateOfBirth)
   {
      this.dateOfBirth = dateOfBirth;
   }
   
   public void setRoomNum(String rn)
   {
      roomNum = rn;
   }
   
   
   
   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((homeAdress == null) ? 0 : homeAdress.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((passportNumber == null) ? 0 : passportNumber.hashCode());
      result = prime * result + ((phone == null) ? 0 : phone.hashCode());
      return result;
   }
   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (!(obj instanceof Guest))
         return false;
      Guest other = (Guest) obj;
      if (dateOfBirth == null)
      {
         if (other.dateOfBirth != null)
            return false;
      }
      else if (!dateOfBirth.equals(other.dateOfBirth))
         return false;
      if (email == null)
      {
         if (other.email != null)
            return false;
      }
      else if (!email.equals(other.email))
         return false;
      if (homeAdress == null)
      {
         if (other.homeAdress != null)
            return false;
      }
      else if (!homeAdress.equals(other.homeAdress))
         return false;
      if (name == null)
      {
         if (other.name != null)
            return false;
      }
      else if (!name.equals(other.name))
         return false;
      if (passportNumber == null)
      {
         if (other.passportNumber != null)
            return false;
      }
      else if (!passportNumber.equals(other.passportNumber))
         return false;
      if (phone == null)
      {
         if (other.phone != null)
            return false;
      }
      else if (!phone.equals(other.phone))
         return false;
      return true;
   }

}
