import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Window that pops up and allows the user to enter detailed guest information
 * @author John
 *
 */
public class PopUp extends JFrame
{
   private JLabel name;
   private JLabel homeadress;
   private JLabel phone;
   private JLabel email;
   private JLabel passport;
   private JLabel dateofbirth;
   private JLabel roomnumber;
   private JLabel arrivaldeparture;
   private JLabel minus;
   private JLabel min;
   private JLabel min1;

   private JTextField namebutton;
   private JTextField homeadressbutton;
   private JTextField phonebutton;
   private JTextField emailbutton;
   private JTextField passportbutton;
   private JTextField dateofbirthbutton;
   private JTextField dateofbirthbutton1;
   private JTextField dateofbirthbutton2;
   private JTextField roomnumberbutton;
   private JTextField arrivaldeparturebutton;
   private JTextField arrivaldeparturebutton1;

   private JPanel namepanel;
   private JPanel homeadresspanel;
   private JPanel phonepanel;
   private JPanel emailpanel;
   private JPanel passportpanel;
   private JPanel dateofbirthpanel;
   private JPanel roomnumberpanel;
   private JPanel arrivaldeparturepanel;
   private JPanel allpanel;
   private JPanel savepanel;

   private JButton savebutton;

   private MyButtonListener listener;
   
   private PopUp thiswindow;
   
   private CheckIn checkinwindow;
   
   boolean edit;
   Guest selected;
   /**
    * Standart constructor, only takes the table that created it as argument
    * @param parent element that calld this one
    */
   public PopUp(CheckIn parent)
   {

      super("Guest Info");
      setSize(400, 370);
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      
      checkinwindow = parent;
      
      listener = new MyButtonListener();

      namepanel = new JPanel();
      homeadresspanel = new JPanel();
      phonepanel = new JPanel();
      emailpanel = new JPanel();
      passportpanel = new JPanel();
      dateofbirthpanel = new JPanel();
      roomnumberpanel = new JPanel();
      arrivaldeparturepanel = new JPanel();
      allpanel = new JPanel();
      savepanel = new JPanel();

      name = new JLabel("                              Name");
      homeadress = new JLabel("                            Adress");
      phone = new JLabel("              Phone number");
      email = new JLabel("                E-mail adress");
      passport = new JLabel("          Passport number");
      dateofbirth = new JLabel("                    Date of birth");
      roomnumber = new JLabel("               Room number");
      arrivaldeparture = new JLabel("Arrival/Departure date");
      minus = new JLabel("-");
      min = new JLabel("-");
      min1 = new JLabel("-");

      namebutton = new JTextField(20);
      homeadressbutton = new JTextField(20);
      phonebutton = new JTextField(20);
      emailbutton = new JTextField(20);
      passportbutton = new JTextField(20);
      dateofbirthbutton = new JTextField(5);
      dateofbirthbutton1 = new JTextField(5);
      dateofbirthbutton2 = new JTextField(5);
      roomnumberbutton = new JTextField(20);
      roomnumberbutton.setText(String.valueOf(checkinwindow.booking.getFirstRoom()));
      arrivaldeparturebutton = new JTextField(checkinwindow.booking.getDates().getCheckInDateString());
      arrivaldeparturebutton1 = new JTextField(checkinwindow.booking.getDates().getCheckOutDateString());
      
      

      savebutton = new JButton("Save");
      savebutton.addActionListener(listener);

      namepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      homeadresspanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      phonepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      savepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

      namepanel.add(name);
      namepanel.add(namebutton);

      homeadresspanel.add(homeadress);
      homeadresspanel.add(homeadressbutton);

      phonepanel.add(phone);
      phonepanel.add(phonebutton);

      emailpanel.add(email);
      emailpanel.add(emailbutton);

      passportpanel.add(passport);
      passportpanel.add(passportbutton);

      dateofbirthpanel.add(dateofbirth);
      dateofbirthpanel.add(dateofbirthbutton);
      dateofbirthpanel.add(min1);
      dateofbirthpanel.add(dateofbirthbutton1);
      dateofbirthpanel.add(min);
      dateofbirthpanel.add(dateofbirthbutton2);

      roomnumberpanel.add(roomnumber);
      roomnumberpanel.add(roomnumberbutton);

      arrivaldeparturepanel.add(arrivaldeparture);
      arrivaldeparturepanel.add(arrivaldeparturebutton);
      arrivaldeparturepanel.add(minus);
      arrivaldeparturepanel.add(arrivaldeparturebutton1);

      savepanel.add(savebutton);

      allpanel.add(namepanel);
      allpanel.add(homeadresspanel);
      allpanel.add(phonepanel);
      allpanel.add(emailpanel);
      allpanel.add(passportpanel);
      allpanel.add(dateofbirthpanel);
      allpanel.add(roomnumberpanel);
      allpanel.add(arrivaldeparturepanel);

      allpanel.setPreferredSize(new Dimension(500, 290));
      add(allpanel);
      add(savepanel);
      savepanel.setPreferredSize(new Dimension(210, 100));
      thiswindow = this;
      edit = false;

   }
   /**
    * Edit constructor. Takes the table that created this one and the selected Guest from it as arguments
    * @param parent JPanel/GuestCheckInTable
    * @param selectedGuest guest that's being edited
    */
   public PopUp(CheckIn parent, Guest selectedGuest)
   {
      super("Check in");
      selected = selectedGuest;
      setSize(400, 370);
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      
      checkinwindow = parent;
      
      listener = new MyButtonListener();

      namepanel = new JPanel();
      homeadresspanel = new JPanel();
      phonepanel = new JPanel();
      emailpanel = new JPanel();
      passportpanel = new JPanel();
      dateofbirthpanel = new JPanel();
      roomnumberpanel = new JPanel();
      arrivaldeparturepanel = new JPanel();
      allpanel = new JPanel();
      savepanel = new JPanel();

      name = new JLabel("                              Name");
      homeadress = new JLabel("                            Adress");
      phone = new JLabel("              Phone number");
      email = new JLabel("                E-mail adress");
      passport = new JLabel("          Passport number");
      dateofbirth = new JLabel("                    Date of birth");
      roomnumber = new JLabel("               Room number");
      arrivaldeparture = new JLabel("Arrival/Departure date");
      minus = new JLabel("-");
      min = new JLabel("-");
      min1 = new JLabel("-");

      
      
      namebutton = new JTextField(20);
      homeadressbutton = new JTextField(20);
      phonebutton = new JTextField(20);
      emailbutton = new JTextField(20);
      passportbutton = new JTextField(20);
      dateofbirthbutton = new JTextField(5);
      dateofbirthbutton1 = new JTextField(5);
      dateofbirthbutton2 = new JTextField(5);
      roomnumberbutton = new JTextField(20);
      //roomnumberbutton.setText(String.valueOf(checkinwindow.booking.getFirstRoom()));
      arrivaldeparturebutton = new JTextField(checkinwindow.booking.getDates().getCheckInDateString());
      arrivaldeparturebutton1 = new JTextField(checkinwindow.booking.getDates().getCheckOutDateString());
      
      
      
      
      
      namebutton.setText(selected.getName());
      homeadressbutton.setText(selected.getHomeAdress());
      phonebutton.setText(selected.getPhone());
      emailbutton.setText(selected.getEmail());
      passportbutton.setText(selected.getPassportNumber());
      roomnumberbutton.setText(String.valueOf(selected.getRoomNum()));
      
      
      if(selected.getDateOfBirth().contains(".")&&selected.getDateOfBirth().length()>4){
         
         String[] splitDate = selected.getDateOfBirth().split("\\.");
         
         dateofbirthbutton.setText(splitDate[0]);
         dateofbirthbutton1.setText(splitDate[1]);
         dateofbirthbutton2.setText(splitDate[2]);
         
      }
      
      
      
      roomnumberbutton.setText(selected.getRoomNum());
      arrivaldeparturebutton = new JTextField(checkinwindow.booking.getDates().getCheckInDateString());
      arrivaldeparturebutton1 = new JTextField(checkinwindow.booking.getDates().getCheckOutDateString());
      
      

      savebutton = new JButton("Save");
      savebutton.addActionListener(listener);

      namepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      homeadresspanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      phonepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      savepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

      namepanel.add(name);
      namepanel.add(namebutton);

      homeadresspanel.add(homeadress);
      homeadresspanel.add(homeadressbutton);

      phonepanel.add(phone);
      phonepanel.add(phonebutton);

      emailpanel.add(email);
      emailpanel.add(emailbutton);

      passportpanel.add(passport);
      passportpanel.add(passportbutton);

      dateofbirthpanel.add(dateofbirth);
      dateofbirthpanel.add(dateofbirthbutton);
      dateofbirthpanel.add(min1);
      dateofbirthpanel.add(dateofbirthbutton1);
      dateofbirthpanel.add(min);
      dateofbirthpanel.add(dateofbirthbutton2);

      roomnumberpanel.add(roomnumber);
      roomnumberpanel.add(roomnumberbutton);

      arrivaldeparturepanel.add(arrivaldeparture);
      arrivaldeparturepanel.add(arrivaldeparturebutton);
      arrivaldeparturepanel.add(minus);
      arrivaldeparturepanel.add(arrivaldeparturebutton1);

      savepanel.add(savebutton);

      allpanel.add(namepanel);
      allpanel.add(homeadresspanel);
      allpanel.add(phonepanel);
      allpanel.add(emailpanel);
      allpanel.add(passportpanel);
      allpanel.add(dateofbirthpanel);
      allpanel.add(roomnumberpanel);
      allpanel.add(arrivaldeparturepanel);

      allpanel.setPreferredSize(new Dimension(500, 290));
      add(allpanel);
      add(savepanel);
      savepanel.setPreferredSize(new Dimension(210, 100));
      thiswindow = this;
      edit = true;
      

   }

   /**
    * 
    * Creates or edits an already existing guest
    *
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == savebutton)
         {
            if(namebutton.getText().length()!=0&&
               homeadressbutton.getText().length()!=0&&   
               phonebutton.getText().length()!=0&&
               emailbutton.getText().length()!=0&&
               passportbutton.getText().length()!=0&&
               dateofbirthbutton.getText().length()!=0&&
               dateofbirthbutton1.getText().length()!=0&&
               dateofbirthbutton2.getText().length()!=0&&
               roomnumberbutton.getText().length()!=0&&
               arrivaldeparturebutton.getText().length()!=0&&
               arrivaldeparturebutton1.getText().length()!=0
                  )
            {
               if(edit==false)
               {
                  int choice = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to add this person?", "Exit",
                        JOptionPane.YES_NO_OPTION);
      
                  if (choice == JOptionPane.YES_OPTION)
                  {
                     String dob = dateofbirthbutton.getText() + "." + dateofbirthbutton1.getText() + "." + dateofbirthbutton2.getText();
                     ((GuestCheckInTable) checkinwindow.table).guests.add(new Guest(namebutton.getText(), homeadressbutton.getText(), phonebutton.getText(),   dob, emailbutton.getText(),passportbutton.getText(), roomnumberbutton.getText()));
                     ((GuestCheckInTable) checkinwindow.table).remake();
                     System.out.println("Do checkin stuff");
                     thiswindow.dispose();
                  }
                  else if (choice == JOptionPane.NO_OPTION)
                  {
                     System.out.println("Do no stuff");
                     thiswindow.dispose();
                  }
               }
               if(edit)
               {
                  
                  int choice = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to save the changes on this person?", "Exit",
                        JOptionPane.YES_NO_OPTION);
      
                  if (choice == JOptionPane.YES_OPTION)
                  {
                     String dob2 = dateofbirthbutton.getText() + "." + dateofbirthbutton1.getText() + "." + dateofbirthbutton2.getText();
                     ((GuestCheckInTable) checkinwindow.table).guests.set(((GuestCheckInTable) checkinwindow.table).guests.indexOf(selected), new Guest(namebutton.getText(), homeadressbutton.getText(), phonebutton.getText(),   dob2, emailbutton.getText(),passportbutton.getText(), roomnumberbutton.getText()));
                     //selected = new Guest(namebutton.getText(), homeadressbutton.getText(), phonebutton.getText(), emailbutton.getText(), passportbutton.getText(), dob2, roomnumberbutton.getText());
                     ((GuestCheckInTable) checkinwindow.table).remake();
                     System.out.println("Do checkin stuff");
                     thiswindow.dispose();
                  }
                  else if (choice == JOptionPane.NO_OPTION)
                  {
                     System.out.println("Do no stuff");
                     thiswindow.dispose();
                  }
                  
                  
                  
                  
                  
                  
                  
               }
            }
         }
      }
   }
}
