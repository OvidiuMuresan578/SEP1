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
 * panel designed to fill in the guest tab
 * @author Dean Bozic
 *
 */
public class GuestTab extends JPanel
{
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    private JTextField text;
    
    private GuestTablePanel table;
    
    /**
     * default constructor, takes all booking to pass later on and creates the GUI
     * @param b all bookings
     */
    public GuestTab(Bookings b) 
    {
       panel1 = new JPanel();
       panel2 = new JPanel();
       
       
      
       button1 = new JButton("Edit Note");
       button2 = new JButton("Check out");
       button3 = new JButton("Edit Form");
       button4 = new JButton("Search");
       
       text = new JTextField(15);
       table = new GuestTablePanel(b, button4, text, button1, button2, button3);
       
       panel3 = new JPanel();
       panel3.add(table);
       
       add(panel1);
       panel1.setPreferredSize(new Dimension(280, 35));
       panel1.add(button4);
       panel1.add(text);
       setVisible(true);
       
       add(panel3);
       
       add(panel2);
       panel2.add(button1);
       panel2.add(button2);
       panel2.add(button3);
    } 
      /**
       * remakes the table
       */
    public void remakeTable()
    {
       table.remake();
    }
}
    
 

