import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The main window that holds everything together
 * @author John
 *
 */
public class MAIN extends JFrame
{

  

   private JTabbedPane tPane;

   private MyButtonListener buttonListener;
   private MyTabListener tabListener;

   private JMenuBar menuBar;
   private JMenu fileMenu;

   private JMenuItem exitMenuItem;
   
   private JPanel HomeTabP;
   private JPanel BookingsTabP;
   private JPanel GuestsTabP;
   private JPanel RoomTabP;
   
   
   private FileIO file;
   
   
   /**
    * Default construcotr takes everything like all rooms, all bookings, the note and the file IO
    *  
    * @param rooms all rooms
    * @param b all bookings
    * @param Note notice for the specific booking
    * @param f fileIO thing and wasn't that bad
    */
   public MAIN(Rooms rooms, Bookings b, String Note, FileIO f)
   {
      super("Deer Alley Hotel");

      file = f;
      
      buttonListener = new MyButtonListener();
      tabListener = new MyTabListener();

      exitMenuItem = new JMenuItem("Exit");
      exitMenuItem.addActionListener(buttonListener);

      fileMenu = new JMenu("File");

      setJMenuBar(menuBar);

      HomeTabP = new HomeTab(b, Note, file);
      BookingsTabP =  new BookingTab(b);
      GuestsTabP =  new GuestTab(b);
      RoomTabP =  new RoomTab(rooms, b);
      
      
      
      
      tPane = new JTabbedPane();

      tPane.addTab("                Home             ", HomeTabP );
      tPane.addTab("               Booking           ", BookingsTabP );
            
      tPane.addTab("              Guest           ", GuestsTabP);
      tPane.addTab("              Room        ", RoomTabP );
      tPane.addChangeListener(tabListener);

      add(tPane);

      setSize(700, 500);
      setVisible(true);
      setResizable(false);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      addWindowListener(new WindowAdapter()
      {
          @Override
          public void windowClosing(WindowEvent e)
          {
              ((HomeTab) HomeTabP).onExit();
              e.getWindow().dispose();
          }
      });
   }
   /**
    * Action Listener that servicing MAIN
    *
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == exitMenuItem)
         {
            int choice = JOptionPane.showConfirmDialog(null,
                  "Do you really want to exit the program?", "Exit",
                  JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION)
            {
               System.exit(0);
            }
         }

      }
   }
   /**
    * remake all tables
    */
   public void remakeAllTables()
   {
      ((HomeTab) HomeTabP).remakeTable();
      ((BookingTab) BookingsTabP).remakeTable();
      ((GuestTab) GuestsTabP).remakeTable();
      ((RoomTab) RoomTabP).remakeTable();
      
   }
   public class MyTabListener implements ChangeListener
   {

      public void stateChanged(ChangeEvent e)
      {

      }

   }
   

}
