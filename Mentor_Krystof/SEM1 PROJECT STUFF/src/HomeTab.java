import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Panel filling the home tab with information
 * it contains a table showing the events for today and a convinient note field
 * @author Dean Bozic
 *
 */
public class HomeTab extends JPanel
{
   private JPanel calendar;
   private JPanel notes;
   private JTextArea text;
   private JScrollPane pane;
   private JLabel T;
   private JLabel N;
   private String note;
   private FileIO file;
   HomeTablePanel table;
   
   /**
    * default constructor, takes all bookings, the text for the note and the file IO object because the note is actually saved in this class and not with the other ones
    * @param bookings all bookings
    * @param n text for note
    * @param f fileIO object
    */
   public HomeTab(Bookings bookings, String n, FileIO f)
   {
      setLayout(new FlowLayout());
      calendar = new JPanel();
      
      file = f;
      
      note = n;
      notes = new JPanel();
      T = new JLabel("Arrivals/Departures today:");
      N = new JLabel("Receptionist's notes:");
      text = new JTextArea(note);
      //text.setPreferredSize(new Dimension(250, 350));
      text.setAutoscrolls(true);
      
      
      pane = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      pane.setPreferredSize(new Dimension(250, 350));
      
      calendar.setBounds(61, 11, 81, 140);
      calendar.setLayout(new BoxLayout(calendar, BoxLayout.Y_AXIS));
      calendar.add(T);
      table = new HomeTablePanel(bookings);
      calendar.add(table);
      
      notes.setBounds(61, 11, 81, 140);
      notes.setLayout(new BoxLayout(notes, BoxLayout.Y_AXIS));
      
      notes.add(N);
      notes.add(pane);
      add(calendar);
      add(notes);
   }
   /**
    * remakes the table in it
    */
   public void remakeTable()
   {
      table.remake();
   }
   /**
    * the method that saves the note every time the program closes
    */
   public void onExit()
   {
      try
      {
         file.writeToFile("RNote.bin", text.getText());
         //System.out.println(text.getText());
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file: "+ e.getMessage());
      }
   }
}
