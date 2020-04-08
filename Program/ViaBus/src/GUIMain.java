import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class GUIMain extends JFrame
{
   public static final String ADD_ONE_DAY_TRIP = "addOneDayTrip";
   public static final String ADD_TRAVEL = "addTravel";
   public static final String ADD_BUS_AND_CHAUFFEUR = "addBusAndChauffeur";
   public static final String ADD_BUS = "addBus";
   public static final String ADD_CHAUFFEUR = "addChauffeur";

   public static final String SAVE_BUTTON_ONE_DAY_TRIP = "saveButtonOneDayTrip";
   public static final String SAVE_BUTTON_TRAVEL = "saveButtonTravel";
   public static final String SAVE_BUTTON_BUS_AND_CHAUFFEURS = "saveButtonBusAndChauffeurs";
   public static final String SAVE_BUTTON_BUS = "saveButtonBus";
   public static final String SAVE_BUTTON_CHAUFFEUR = "saveButtonChauffeur";
   
   public static final String ADD_STOP_ONE_DAY_TRIP = "addStopOneDayTrip";
   public static final String DELETE_STOP_ONE_DAY_TRIP = "deleteStopOneDayTrip";
   
   public static final String ADD_STOP_TRAVEL ="addStopTravel";
   public static final String DELETE_STOP_TRAVEL = "deleteStopTravel";
   
   public static final String ADD_STOP_BUS_AND_CHAUFFEUR = "addStopBusAndChauffeur";
   public static final String DELETE_STOP_BUS_AND_CHAUFFEUR = "deleteStopBusAndCheauffeur";
   
   public static final String REFRESH_BUTTON = "refreshButton";
   
   public static final String ADD_NEW_RESERVATION = "addNewReservation";
   public static final String INFO = "infoAboutTour";
  
   public static final String INFO_CHAFFEUR = "infoChaffeur";
   public static final String INFO_BUS = "infoBus";
   public static final String INFO_BUS_AND_CHAFFEUR = "infoBusAndChaffeur";

   public static final String SEARCH = "search";
   
   private JPanel contentPane;
   private JTabbedPane tabbedPane;
   private JLabel systemTime;
   private JButton btnSearch;
   private JTextField searchTextField;
   private JComboBox comboBox;

   private GUIHandler handler;
   
   private GUIOneDayTripTab oneDayTripTab;
   private GUITravelTab travelTab;
   private GUIBusAndChauffeurTab busAndChauffeurTab;
   private GUIChauffeurTab chauffeurTab;
   private GUIBusTab busTab;

   private GUIaddOneDayTrip addOneDayTrip;
   private GUIaddTravel addTravel;
   private GUIaddBusAndChauffeur addBusAndChauffeur;
   private GUIaddBus addBus;
   private GUIaddChauffeur addChauffeur;
   
   private GUIaddNewReservation addNewReservation;
   private GUIinfoOneDayTripAndTour infoOneDayTripAndTravel;
   private GUIinfoChaffeur infoChaffeur;
   private GUIinfoBus infoBus;
   private GUIinfoBusAndChaffeur1 infoBusAndChaffeur;
   
   private GUIsearchChaffeurs searchShaffeurs;
   private GUIsearchCustomers searchCustomers;
   private GUIsearchReservations searchReservations;
   private GUIsearchTours searchTours;
   private GUIsearchBusses searchBusses;

   public GUIMain()
   {
      super("Main");
      initializing();
      addElements();
      clock();
      setVisible(true);
   }

   public GUIHandler getHandler()
   {
      return handler;
   }
   
   public void open(String type)
   {
      switch (type)
      {
         case GUIMain.ADD_ONE_DAY_TRIP:
            addOneDayTrip.setVisible(true);
            break;
         case GUIMain.ADD_TRAVEL:
            addTravel.setVisible(true);
            break;
         case GUIMain.ADD_BUS_AND_CHAUFFEUR:
            addBusAndChauffeur.setVisible(true);
            break;
         case GUIMain.ADD_CHAUFFEUR:
            addChauffeur.setVisible(true);
            break;
         case GUIMain.ADD_BUS:
            addBus.setVisible(true);
            break;
         case GUIMain.SAVE_BUTTON_ONE_DAY_TRIP:
            addOneDayTrip.setVisible(false);
            break;
         case GUIMain.SAVE_BUTTON_TRAVEL:
            addTravel.setVisible(false);
             break;
         case GUIMain.SAVE_BUTTON_BUS_AND_CHAUFFEURS:
            addBusAndChauffeur.setVisible(false);
            break;
         case GUIMain.SAVE_BUTTON_CHAUFFEUR:
            addChauffeur.setVisible(false);
            break;
         case GUIMain.SAVE_BUTTON_BUS:
            addBus.setVisible(false);
            break;
         case GUIMain.ADD_NEW_RESERVATION:
            addNewReservation.setVisible(true);
            break;
         case GUIMain.INFO:
            infoOneDayTripAndTravel.setVisible(true);
            break;
         case GUIMain.INFO_CHAFFEUR:
            infoChaffeur.setVisible(true);
            break;
         case GUIMain.INFO_BUS:
            infoBus.setVisible(true);
            break;
         case GUIMain.INFO_BUS_AND_CHAFFEUR:
            infoBusAndChaffeur.setVisible(true);
            break;
         
      }
   }

   public void executeSaveButtonOneDayTrip()
   {
      Object data[] = new Object[10];
      data = addOneDayTrip.getDataScheduleTable();
      oneDayTripTab.addRowOneDayTrip(data, handler);
   }
   public void executeSaveButtonTravel()
   {
      Object data[] = new Object[10];
      data = addTravel.getDataScheduleTable();
      travelTab.addRowTravel(data, handler);
   }
  public void executeSaveButtonBusAndChauffeur()
  {
     Object data[] = new Object[10];
     data = addBusAndChauffeur.getDataScheduleTable();
     busAndChauffeurTab.addRowBusAndChaffeur(data, handler);
                        
  }
  public void executeSaveButtonChaffeur()
  {
     Object data[] = new Object[10];
     data = addChauffeur.getDataChaffeur();
     chauffeurTab.addRowChaffeur(data, handler);
  }
  public void executeSaveButtonBus()
  {
     Object data[] = new Object[10];
     data = addBus.getDataBus();
     busTab.addRowBus(data, handler);
  }
   public void executeAddStopOneDayTrip()
   {
     addOneDayTrip.addStopOneDayTrip();
     addOneDayTrip.setVisible(true);
   }
   public void executeDeleteStopOneDayTrip()
   {
      addOneDayTrip.deleteStopOneDayTrip(); 
      addOneDayTrip.setVisible(true);
   }
   public void executeAddStopTravel()
   {
      addTravel.addStopTravel();
      addTravel.setVisible(true);
   }
   public void executeDeleteStopTravel()
   {
      addTravel.deleteStopTravel();
      addTravel.setVisible(true);
   }
   public void executeDeleteStopBusAndChauffeur()
   {
      addBusAndChauffeur.addStopTravel();
      addBusAndChauffeur.setVisible(true);
   }
   public void executeAddStopBusAndChauffeur()
   {
      addBusAndChauffeur.deleteStopTravel();
      addBusAndChauffeur.setVisible(true);
   }
   

   public void startGUI(ViaBusController controller)
   {
      handler = new GUIHandler(this, controller);
      
      oneDayTripTab.addActionListener(handler);
      travelTab.addActionListener(handler);
      busAndChauffeurTab.addActionListener(handler);
      chauffeurTab.addActionListener(handler);
      busTab.addActionListener(handler);
      
      addOneDayTrip.addActionListener(handler);
      addTravel.addActionListener(handler);
      
      addBusAndChauffeur.addActionListener(handler);
           
      addChauffeur.addActionListener(handler);
      addBus.addActionListener(handler);
      
      
      
   }

   private void initializing()
   {
      // Clock
      systemTime = new JLabel("CLOCK");

      // Search
      btnSearch = new JButton("SEARCH");
      searchTextField = new JTextField(10);
      comboBox = new JComboBox();

      // Tabbed Pane
      contentPane = new JPanel();
      tabbedPane = new JTabbedPane(JTabbedPane.TOP);

      // Tabs
      oneDayTripTab = new GUIOneDayTripTab();
      travelTab = new GUITravelTab();
      busAndChauffeurTab = new GUIBusAndChauffeurTab();
      chauffeurTab = new GUIChauffeurTab();
      busTab = new GUIBusTab();

      // Individual windows
      addOneDayTrip = new GUIaddOneDayTrip();
      addTravel = new GUIaddTravel();
      addBusAndChauffeur = new GUIaddBusAndChauffeur();
      addBus = new GUIaddBus();
      addChauffeur = new GUIaddChauffeur();
      
      // Create a new reservation
      addNewReservation = new GUIaddNewReservation();
      //infoButtons
      infoOneDayTripAndTravel = new GUIinfoOneDayTripAndTour();
      infoChaffeur = new GUIinfoChaffeur();
      infoBus = new GUIinfoBus();
      infoBusAndChaffeur = new GUIinfoBusAndChaffeur1();
   }

   private void addElements()
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(720, 520);
      setLocationRelativeTo(null);

      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane.setBounds(0, 43, 704, 417);
      contentPane.add(tabbedPane);

      tabbedPane.addTab("One-day trips", oneDayTripTab);
      tabbedPane.addTab("Travels", travelTab);
      tabbedPane.addTab("Bus-and-chauffeurs", busAndChauffeurTab);
      tabbedPane.addTab("Chauffeurs", chauffeurTab);
      tabbedPane.addTab("Busses", busTab);
      oneDayTripTab.setLayout(null);

      // TIME&DATE
      systemTime = new JLabel("CLOCK");
      systemTime.setBounds(10, 10, 286, 40);
      contentPane.add(systemTime);
      systemTime.setFont(new Font("Tahoma", Font.BOLD, 16));

      // search
      btnSearch.setBounds(606, 12, 88, 22);
      contentPane.add(btnSearch);
      searchTextField.setBounds(407, 13, 88, 22);
      contentPane.add(searchTextField);
      comboBox.setBounds(499, 12, 105, 22);
      contentPane.add(comboBox);
   }

   public void clock()
   {
      Thread clock = new Thread()
      {
         public void run()
         {
            try
            {
               for (;;)
               {
                  Calendar now = GregorianCalendar.getInstance();
                  int day = now.get(Calendar.DAY_OF_MONTH);
                  int month = now.get(Calendar.MONTH) + 1;
                  int year = now.get(Calendar.YEAR);

                  int seconds = now.get(Calendar.SECOND);
                  int minutes = now.get(Calendar.MINUTE);
                  int hours = now.get(Calendar.HOUR);

                  systemTime.setText(
                        "Time: " + hours + ":" + minutes + ":" + seconds
                              + "    Date: " + day + "/" + month + "/" + year);
                  sleep(1000);
               }
            }
            catch (InterruptedException e)
            {

               e.printStackTrace();
            }
         }

      };
      clock.start();
   }

}
