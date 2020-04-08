import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
 * new window that pops up and provides the user with a form to create a booking
 * @author Filip Zelenika
 *
 */
public class MakeBooking extends JFrame
{

   private JLabel roomnumber;
   private JLabel arrivaldeparture;
   private JLabel minus;
   private JLabel Name;

   private JTextField roomnumberbutton;
   private JTextField arrivaldeparturebutton;
   private JTextField arrivaldeparturebutton1;
   private JTextField namefield;

   private JPanel roomnumberpanel;
   private JPanel arrivaldeparturepanel;
   private JPanel allpanel;
   private JPanel savepanel;
   private JPanel namepanel;

   private JButton savebutton;
   
   private Bookings bookings;

   private MyButtonListener listener;
   
   Object thiswindow;
   BookingTablePanel tab;
   RoomTablePanel tabR;
   Booking selected;
   Room selectedR;

   /**
    * The default constructor that creates the window and takes no extra arguments
    * @param b all bookings
    * @param tb the panel that created this window
    */
   public MakeBooking(Bookings b, BookingTablePanel tb)
   {
      super("Make a booking");
      bookings = b;
      setSize(400, 190);
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new FlowLayout());

      listener = new MyButtonListener();
      tab =tb;
      roomnumberpanel = new JPanel();
      arrivaldeparturepanel = new JPanel();
      allpanel = new JPanel();
      savepanel = new JPanel();
      namepanel = new JPanel();
      
      Name = new JLabel("                              Name");
      roomnumber = new JLabel("               Room number");
      arrivaldeparture = new JLabel("Arrival/Departure date");
      minus = new JLabel("-");

      roomnumberbutton = new JTextField(20);
      arrivaldeparturebutton = new JTextField(6);
      arrivaldeparturebutton1 = new JTextField(6);
      namefield = new JTextField(20);

      savebutton = new JButton("Save");
      savebutton.addActionListener(listener);

      savepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      namepanel.add(Name);
      namepanel.add(namefield);

      roomnumberpanel.add(roomnumber);
      roomnumberpanel.add(roomnumberbutton);

      arrivaldeparturepanel.add(arrivaldeparture);
      arrivaldeparturepanel.add(arrivaldeparturebutton);
      arrivaldeparturepanel.add(minus);
      arrivaldeparturepanel.add(arrivaldeparturebutton1);

      savepanel.add(savebutton);
      
      allpanel.add(namepanel);
      allpanel.add(roomnumberpanel);
      allpanel.add(arrivaldeparturepanel);

      allpanel.setPreferredSize(new Dimension(400, 100));
      add(allpanel);
      add(savepanel);
      savepanel.setPreferredSize(new Dimension(210, 100));
      thiswindow = this;
      selected = null;
   }
   /**
    * The constructor that creates the field and fills it up with data from the selected booking, used when editing
    * @param b all bookings
    * @param tb the panel that created this window
    * @param sel the selected booking which is being edited
    */
   public MakeBooking(Bookings b, BookingTablePanel tb, Booking sel)
   {
      super("Make a booking");
      bookings = b;
      selected = sel;
      setSize(400, 190);
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new FlowLayout());

      listener = new MyButtonListener();
      tab =tb;
      roomnumberpanel = new JPanel();
      arrivaldeparturepanel = new JPanel();
      allpanel = new JPanel();
      savepanel = new JPanel();
      namepanel = new JPanel();
      
      Name = new JLabel("                              Name");
      roomnumber = new JLabel("               Room number");
      arrivaldeparture = new JLabel("Arrival/Departure date");
      minus = new JLabel("-");

      roomnumberbutton = new JTextField(20);
      String tempRoomString = "";
      int j=0;
      while(j<selected.getBookedRooms().length)
      {
         tempRoomString = tempRoomString + selected.getBookedRooms()[j].getRoomNumber()+", ";
         j++;
      }
      
      roomnumberbutton.setText(tempRoomString.substring(0, tempRoomString.length()-2));
      arrivaldeparturebutton = new JTextField(6);
      arrivaldeparturebutton.setText(selected.getDates().getCheckInDateString());
      arrivaldeparturebutton1 = new JTextField(6);
      arrivaldeparturebutton1.setText(selected.getDates().getCheckOutDateString());
      namefield = new JTextField(20);
      namefield.setText(selected.getName());

      savebutton = new JButton("Save");
      savebutton.addActionListener(listener);

      savepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      namepanel.add(Name);
      namepanel.add(namefield);

      roomnumberpanel.add(roomnumber);
      roomnumberpanel.add(roomnumberbutton);

      arrivaldeparturepanel.add(arrivaldeparture);
      arrivaldeparturepanel.add(arrivaldeparturebutton);
      arrivaldeparturepanel.add(minus);
      arrivaldeparturepanel.add(arrivaldeparturebutton1);

      savepanel.add(savebutton);
      
      allpanel.add(namepanel);
      allpanel.add(roomnumberpanel);
      allpanel.add(arrivaldeparturepanel);

      allpanel.setPreferredSize(new Dimension(400, 100));
      add(allpanel);
      add(savepanel);
      savepanel.setPreferredSize(new Dimension(210, 100));
      thiswindow = this;
      
   }
   

   /**
    * The constructor that takes a room as an argument and fills up the room field, used when a new booking is made from the Room Tab
    * @param b all bookings
    * @param tb the panel that created this window
    * @param sel selected room
    */
   public MakeBooking(Bookings b, RoomTablePanel tb, Room sel)
   {
      super("Make a booking");
      bookings = b;
      selectedR = sel;
      setSize(400, 190);
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
      //setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new FlowLayout());

      listener = new MyButtonListener();
      tabR =tb;
      roomnumberpanel = new JPanel();
      arrivaldeparturepanel = new JPanel();
      allpanel = new JPanel();
      savepanel = new JPanel();
      namepanel = new JPanel();
      
      Name = new JLabel("                              Name");
      roomnumber = new JLabel("               Room number");
      arrivaldeparture = new JLabel("Arrival/Departure date");
      minus = new JLabel("-");

      roomnumberbutton = new JTextField(20);
      roomnumberbutton.setText(String.valueOf(selectedR.getRoomNumber()));
      arrivaldeparturebutton = new JTextField(6);
      //arrivaldeparturebutton.setText(selected.getDates().getCheckInDateString());
      arrivaldeparturebutton1 = new JTextField(6);
      //arrivaldeparturebutton1.setText(selected.getDates().getCheckOutDateString());
      namefield = new JTextField(20);
      //namefield.setText(selected.getName());

      savebutton = new JButton("Save");
      savebutton.addActionListener(listener);

      savepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      namepanel.add(Name);
      namepanel.add(namefield);

      roomnumberpanel.add(roomnumber);
      roomnumberpanel.add(roomnumberbutton);

      arrivaldeparturepanel.add(arrivaldeparture);
      arrivaldeparturepanel.add(arrivaldeparturebutton);
      arrivaldeparturepanel.add(minus);
      arrivaldeparturepanel.add(arrivaldeparturebutton1);

      savepanel.add(savebutton);
      
      allpanel.add(namepanel);
      allpanel.add(roomnumberpanel);
      allpanel.add(arrivaldeparturepanel);

      allpanel.setPreferredSize(new Dimension(400, 100));
      add(allpanel);
      add(savepanel);
      savepanel.setPreferredSize(new Dimension(210, 100));
      thiswindow = this;
      selected = null;
      tab = null;
   }


   /**
    * 
    * Action Listener that serves the button inside this window, does different things for each depending on which constructor was used
    *
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == savebutton)
         {
            
            if((
                  namefield.getText().length()!=0&&
                  roomnumberbutton.getText().length()!=0&&
                  arrivaldeparturebutton.getText().length()!=0&&
                  arrivaldeparturebutton1.getText().length()!=0
                  ))
            {
            
               
               int choice = JOptionPane.showConfirmDialog(null,
                     "Do you really want to save this booking?", "Exit",
                     JOptionPane.YES_NO_OPTION);
   
               if (choice == JOptionPane.YES_OPTION && selected == null)
               {
                  
                  String [] parts = roomnumberbutton.getText().split(",");
                  
                  int[] tna = new int[parts.length];
                  int arrr =0;
                  while(arrr<parts.length)
                  {
                     if(Integer.parseInt(parts[arrr].trim())<=25)tna[arrr]=Integer.parseInt(parts[arrr].trim());
                     arrr++;
                  }
                  
                  
                  
                  
                  int i=0;
                  ArrayList<Room> resultA = new ArrayList<Room>();
                  Room[] result;
                  while(i<tna.length)
                  {
                     if(tna[i]!=0)resultA.add(Rooms.getRoomByNumber(tna[i]));
                     i++;
                  }
                  result=new Room[resultA.size()];
                  result = resultA.toArray(result);
                  bookings.add(new Booking(new Guest(namefield.getText()), new BookingDate(arrivaldeparturebutton.getText(), arrivaldeparturebutton1.getText()), result));
                  if(tab!=null)tab.updateMain();
                  else tabR.updateMain();
                  ((MakeBooking) thiswindow).dispose();
               }
               else if (choice == JOptionPane.YES_OPTION && selected != null)
               {
                  String [] parts = roomnumberbutton.getText().split(",");
                  
                  int[] tna = new int[parts.length];
                  int arrr =0;
                  while(arrr<parts.length)
                  {
                     if(Integer.parseInt(parts[arrr].trim())<=25)tna[arrr]=Integer.parseInt(parts[arrr].trim());
                     //System.out.println(parts[arrr]);
                     arrr++;
                  }
                  
                  
                  
                  
                  int i=0;
                  ArrayList<Room> resultA = new ArrayList<Room>();
                  Room[] result;
                  while(i<tna.length)
                  {
                     if(tna[i]!=0)resultA.add(Rooms.getRoomByNumber(tna[i]));
                     i++;
                  }
                  result=new Room[resultA.size()];
                  result = resultA.toArray(result);
                  
                  
                  
                  selected.setBookedRooms(result);//TODO bug here that im not sure how to fix
                  selected.setName(namefield.getText());
                  selected.setDates(new BookingDate(arrivaldeparturebutton.getText(), arrivaldeparturebutton1.getText()));
                  
                  tab.updateMain();
                  ((MakeBooking) thiswindow).dispose();
               }
            }
         }
      }
   }
}