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
 * New window that pops up when the user attempts to checkin a booking
 * @author Filip Zelenika
 *
 */
public class CheckIn extends JFrame
{
   private JButton add;
   private JButton remove;
   private JButton edit;
   private JButton save;
   private JButton cancel;
   
   
   private JPanel panel1;
   private JPanel panel2;
   private JPanel panel3;
   private JPanel panel4;
   private JPanel panel5;
   
   JPanel table;
   private JLabel guests;
   private MyButtonListener listener;
   
   
   Booking booking;
   CheckIn thiswindow;
   Bookings bookings;
   JPanel bigtable;
   
   /**
    * The default constructor. Takes all the booking to be checked in, the list of all bookings and the window that created it as arguments
    * @param b booking to be checked in
    * @param AB list of all bookings
    * @param bigT panel(table) it was called from
    */
   public CheckIn(Booking b, Bookings AB, JPanel bigT)
   {
     super("Check In Form");
      
      booking = b;
      bookings = AB;
      bigtable = bigT;
      setLayout(new FlowLayout());
      
      panel1=new JPanel();
      panel2=new JPanel();
      panel3=new JPanel();
      panel4=new JPanel();
      panel5=new JPanel();
      
      table = new GuestCheckInTable(booking);
      panel2.add(table);
      
      listener = new MyButtonListener();
      guests=new JLabel("Guests");
      
      add=new JButton("Add");
      remove=new JButton("Remove");
      edit=new JButton("Edit");
      save=new JButton("Save");
      cancel=new JButton("Cancel");
      add.addActionListener(listener);
      remove.addActionListener(listener);
      edit.addActionListener(listener);
      save.addActionListener(listener);
      cancel.addActionListener(listener);
      
      
      add(panel1);
      panel1.setPreferredSize(new Dimension(170, 25));
      panel1.add(guests);
      panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
      
      add(panel2);
      
      panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel3.add(add);
      panel3.add(remove);
      panel3.add(edit);
      add(panel3);
      //panel2.add(panel3);
      
      add(panel4);
      panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));
      panel5.add(save);
      panel5.add(cancel);
      panel4.add(panel5);
      
      setSize(600, 350);
      setVisible(true);
      setLocationRelativeTo(null);
      
      thiswindow = this;
   }
   
   /**
    * 
    * Does different things depending on which button is pressed
    * If the Save button is pressed, does something different depending on where it was created from
    * Manages the small table inside of it and reaches out to the whole system
    * 
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == add)
         {
            PopUp p = new PopUp(thiswindow);
         }
         if(e.getSource() == edit)
         {
            PopUp p = new PopUp(thiswindow, ((GuestCheckInTable) table).getSelectedGuest());
         }
         if(e.getSource() == remove)
         {
            int choice = JOptionPane.showConfirmDialog(null,
                  "Are you sure you want to delete this person?", "Exit",
                  JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION)
            {
                  ((GuestCheckInTable) table).guests.remove(((GuestCheckInTable) table).getSelectedGuest());
                  ((GuestCheckInTable) table).remake();
            }
         }
         
         if(e.getSource() == save)
         {
            if(bigtable instanceof BookingTablePanel)
            {
               bookings.checkInBooking(booking, ((GuestCheckInTable) table).guests);
               ((BookingTablePanel) bigtable).updateMain();
               thiswindow.dispose();
            }
            if(bigtable instanceof GuestTablePanel)
            {
               bookings.updateBooking(booking, ((GuestCheckInTable) table).guests);
               ((GuestTablePanel) bigtable).updateMain();
               thiswindow.dispose();
            }
            if(bigtable instanceof RoomTablePanel)
            {
               bookings.checkInBooking(booking, ((GuestCheckInTable) table).guests);
               ((RoomTablePanel) bigtable).updateMain();
               thiswindow.dispose();
            }
               
         }
         if(e.getSource() == cancel)
         {
            thiswindow.dispose();
         }
         
      }
         
         
   }
   
}