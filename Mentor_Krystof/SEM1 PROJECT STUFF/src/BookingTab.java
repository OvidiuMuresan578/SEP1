import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A GUI class that extends JPanel and fills in the Booking Tab
 * @author Dean Bozic
 *
 */
public class BookingTab extends JPanel
{
 private JButton button1;
 private JButton button2;
 private JButton button3;
 private JButton button4;
 private JButton editBooking;
 
 private JPanel panel1;
 private JPanel panel2;
 private JPanel panel3;
 
 private JTextField text;
 
 private ActionListener buttonListener;

 /**
  * default constructor
  * @param bookings list of all bookings the program is working with
  */
 public BookingTab(Bookings bookings) 
 {
    panel1 = new JPanel();
    panel2 = new JPanel();

    
   
    button1 = new JButton("Make a booking");
    button2 = new JButton("Cancel");
    button3 = new JButton("Check in");
    button4 = new JButton("Search");
    editBooking = new JButton("Edit Booking");
    
    
    text = new JTextField(15);
    
    panel3 = new BookingTablePanel(bookings, button4, text, button1, button2, button3, editBooking);
    
    add(panel1);
    panel1.setPreferredSize(new Dimension(280, 35));
    panel1.add(button4);
    panel1.add(text);
   
    
    add(panel3);
    
    add(panel2);
    panel2.add(button1);
    panel2.add(button2);
    panel2.add(button3);
    panel2.add(editBooking);
    
    setVisible(true);
} 
    
 	/**
 	 * Part of a method chain which has a perose of refreshing each of the tables in the tabs of the program
 	 */
    public void remakeTable()
    {
       ((BookingTablePanel) panel3).remake();
    }
 
 
       
}
    