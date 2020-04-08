import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * New window that pops up when the user desires to check out a booking
 * Show the note for the specific booking and performs price calculation
 * @author Anton Akov
 *
 */
public class CheckOut extends JFrame
{
   private JLabel priceOfStay;
   private JLabel number1;
   private JLabel discount;
   private JLabel number2;
   private JLabel extras;
   private JTextField number3;
   private JButton calculate;
   private JLabel total;
   private JLabel taxL;
   private JLabel number4;
   private JLabel taxTotal;
   
   private JLabel totalL;
   private JLabel taxTotalL;
   //TODO NAME LABELS, MAKE CHECKOUT BUTTON IN THECHECKOUT FORM
   private JPanel fortotal;
   
   private JButton checkOut;
   
   private JTextArea text;
   private JScrollPane pane;
   
   private JPanel stay;
   private JPanel disc;
   private JPanel extra;
   private JPanel totalPrice;
   private JPanel notepad;
   private JPanel tax;
   private JPanel finalP;
   
   private ActionListener listener;
   Bookings bookings;
   Booking selected;
   private int stayP=0;
   private GuestTablePanel guestTable;
   private CheckOut thisWindow;
   /**
    * Default constructor, takes all bookings, the one desired to be checked out and table that requested the creation of the window
    * @param ab list of all bookings
    * @param b booking to be checked out
    * @param that table(JPanel) that created the window
    */
   public CheckOut(Bookings ab, Booking b, GuestTablePanel that)
   {
      super("Check Out");
      bookings = ab;
      selected = b;
      
      int nights=0;
      
      if(b.getDates().isDateToday())nights=(int) b.getDates().getNumberOfNights();
      else nights = nightsSinceCheckin();
      
      
      int i = 0;
      while(i<selected.getBookedRooms().length)
      {
         stayP = stayP + selected.getBookedRooms()[i].getPricePerNight()*nights;
         i++;
      }
      
      
      
      
      
      priceOfStay=new JLabel("Price of stay:");
      number1=new JLabel(String.valueOf(stayP));
      discount=new JLabel("Discount:");
      
      if(selected.getDiscount().length()>0)number2=new JLabel(selected.getDiscount()+"%");
      else number2=new JLabel("0%");
      
      extras=new JLabel("Additional costs");
      number3=new JTextField(10);
      calculate=new JButton("Calculate");
      listener = new ButtonListener();
      calculate.addActionListener(listener);
      
      checkOut = new JButton("Check Out");
      checkOut.addActionListener(listener);
      
      
      totalL = new JLabel("Subtotal: ");      
      total=new JLabel();
      
      
      
      taxL=new JLabel("Tax:");
      number4=new JLabel("25%");
      
      
      taxTotal = new JLabel();
      taxTotalL = new JLabel("Total: ");
      
      notepad=new JPanel();
      stay=new JPanel();
      disc=new JPanel();
      extra=new JPanel();
      totalPrice=new JPanel();
      tax=new JPanel();
      finalP = new JPanel();
      
      
      JTextArea text = new JTextArea();
      text.setText(selected.getNote());
      //text.setPreferredSize(new Dimension(250, 350));
      text.setAutoscrolls(true);
      JScrollPane pane = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      pane.setMinimumSize(new Dimension(450, 150));
      pane.setMaximumSize(new Dimension(450, 150));
      pane.setPreferredSize(new Dimension(450, 150));
      
      getContentPane().setLayout(
            new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)
        );
      add(pane);
      
      
      stay.add(priceOfStay);
      stay.add(number1);
      
      disc.add(discount);
      disc.add(number2);
      
      extra.add(extras);
      extra.add(number3);
      
      totalPrice.add(totalL);
      totalPrice.add(total);
      
      tax.add(taxL);
      tax.add(number4);
      
      finalP.add(calculate);
      finalP.add(taxTotalL);
      finalP.add(taxTotal);
      finalP.add(checkOut);
      
      add(notepad);
      add(stay);
      add(disc);
      add(extra);
      add(totalPrice);
      add(tax);
      add(finalP);
      
      
      setSize(600, 400);
      setVisible(true);
      setLocationRelativeTo(null);
      
      guestTable = that;
      thisWindow = this;
   }
   /**
    * method that gets the number of nights from a set date to the current day
    * used when the user is checking out before the expected date
    * @return number of nights
    */
   public int nightsSinceCheckin()
   {
      BookingDate tempdate = new BookingDate(selected.getDates().getCheckIn(), Calendar.getInstance());
      
      
      return (int) tempdate.getNumberOfNights();
   }
   /**
    * 
    * Private ActionListener for this window, used pretty much to do the calculations and after that the booking deletion
    *
    */
   private class ButtonListener implements ActionListener
   {

      @Override
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource()==calculate)
         {
            if(number3.getText().length()>0&&selected.getDiscount().length()>0)
            {
               total.setText(String.valueOf(((double)stayP/100)*(100-Integer.parseInt(selected.getDiscount())+Integer.parseInt(number3.getText()))));
               taxTotal.setText(String.valueOf((((double)stayP/100)*(100-Integer.parseInt(selected.getDiscount())+Integer.parseInt(number3.getText()))*(double)1.25))  );
            }
            else if(selected.getDiscount().length()>0)
            {
               total.setText(String.valueOf(((double)stayP/100)*(100-Integer.parseInt(selected.getDiscount()))));
               taxTotal.setText(String.valueOf(((double)stayP/100)*(100-Integer.parseInt(selected.getDiscount())*(double)1.25)));
               
            }
            else if(number3.getText().length()>0)
            {
               total.setText(String.valueOf((stayP+Integer.parseInt(number3.getText()))));
               taxTotal.setText(String.valueOf((stayP+Integer.parseInt(number3.getText()))*(double)1.25));
               
            }
            else
            {
               total.setText(String.valueOf(stayP));
               taxTotal.setText(String.valueOf(stayP*(double)1.25));
               
            }
         }
         if(e.getSource()==checkOut&&total.getText().length()!=0)
         {
            bookings.delete(selected);
            guestTable.updateMain();
            thisWindow.dispose();
         }
         
      }
      
      
      
   }
   
   
   
   
   
}