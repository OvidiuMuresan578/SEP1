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
 * The RoomTab panel fills the Room tab in the MAIN window
 * @author Dean Bozic
 *
 */
public class RoomTab extends JPanel
{
   private JButton button1;
   private JButton button2;
   private JButton button3;
   private JButton button4;
   private JButton button5;
   
   private JButton makeB;
   private JButton makeC;

   private JPanel panel1;
   private JPanel panel2;
   private JPanel panel3;
   private JPanel panel4;
   private JPanel panel5;
   private JPanel panel6;
   private JPanel panel7;

   private JTextField text;
   private JTextField text1;
   private JTextField text2;
   private JTextField text3;
   private JTextField text4;

   private JLabel label;
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JLabel label4;
   
   /**
    * Default constructor creating the visuals
    * @param r list of all rooms
    * @param b list of all bookings
    */
   public RoomTab(Rooms r, Bookings b)
   {
      

      label2 = new JLabel("Available from");
      label3 = new JLabel("Type");
      label4 = new JLabel("Price range");
      button4 = new JButton("Search");
      makeB = new JButton("Book");
      makeC = new JButton("Check in");

      label = new JLabel("-");
      label1 = new JLabel("-");

      text = new JTextField(6);
      text1 = new JTextField(6);
      text2 = new JTextField(6);
      text3 = new JTextField(6);
      text4 = new JTextField(6);

      panel1 = new RoomTablePanel(r, b, button4, text2, text, text1, text3, text4, makeB, makeC);
      panel2 = new JPanel();
      panel3 = new JPanel();
      panel4 = new JPanel();
      panel5 = new JPanel();
      panel6 = new JPanel();
      panel7 = new JPanel();
      
      add(panel1, new FlowLayout());
   
      
      //panel1.setPreferredSize(new Dimension(450, 250));

      panel2.add(label2);
      panel2.add(text);
      panel2.add(label);
      panel2.add(text1);
      panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

      

      panel3.add(label3);
      panel3.add(text2);

      panel5.add(label4);
      panel5.add(text3);
      panel5.add(label1);
      panel5.add(text4);
      
      panel6.add(button4);
      panel6.add(makeB);
      panel6.add(makeC);
  

      panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
      panel4.add(panel2);
      panel4.add(panel3);
      panel4.add(panel5);
      panel4.add(panel6);

      add(panel4);
     
     
   }
   /**
    * Remakes the table
    */
   public void remakeTable()
   {
      ((RoomTablePanel) panel1).remake();
   }

}
