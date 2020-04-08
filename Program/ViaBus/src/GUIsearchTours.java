import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUIsearchTours extends JFrame
{

   private JPanel contentPane;
   private JScrollPane scrollPaneOneDayTrip;
   private JTable oneDayTripTourTable;
   private JLabel lblNewLabel_1;
   private JLabel lblTravelTours;
   private JScrollPane scrollPane;
   private JLabel lblBusAndChaffeur;
   private JScrollPane scrollPane_1;
   private JTable table;
   private JTable busAndChaffeurTabel;
   

   
   public GUIsearchTours()
   {
      super("Search results");
      addElements();
   }
   public void addElements()
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1107, 385);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Search results for tours");
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
      lblNewLabel.setBounds(10, 11, 187, 21);
      contentPane.add(lblNewLabel);
      
      scrollPaneOneDayTrip = new JScrollPane();
      scrollPaneOneDayTrip.setBounds(10, 78, 342, 255);
      contentPane.add(scrollPaneOneDayTrip);
      
      String data[][] = { };
      String col[] = { "From", "To", "Date", "Time","Seats" };
      DefaultTableModel model = new DefaultTableModel(data, col);
      oneDayTripTourTable = new JTable(model);
      
      scrollPaneOneDayTrip.setViewportView(oneDayTripTourTable);
      
      lblNewLabel_1 = new JLabel("One day trip tours");
      lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblNewLabel_1.setBounds(10, 57, 125, 14);
      contentPane.add(lblNewLabel_1);
      
      lblTravelTours = new JLabel("Travel tours");
      lblTravelTours.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblTravelTours.setBounds(376, 57, 125, 14);
      contentPane.add(lblTravelTours);
      
      scrollPane = new JScrollPane();
      scrollPane.setBounds(376, 78, 342, 255);
      contentPane.add(scrollPane);
      
      table = new JTable();
      table.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "From", "To", "Date and time", "Seats"
         }
      ));
      table.getColumnModel().getColumn(2).setResizable(false);
      table.getColumnModel().getColumn(2).setPreferredWidth(128);
      scrollPane.setViewportView(table);
      
      lblBusAndChaffeur = new JLabel("Bus and chaffeur tours");
      lblBusAndChaffeur.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblBusAndChaffeur.setBounds(743, 57, 154, 14);
      contentPane.add(lblBusAndChaffeur);
      
      scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(738, 78, 342, 255);
      contentPane.add(scrollPane_1);
      
      busAndChaffeurTabel = new JTable();
      busAndChaffeurTabel.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Customer", "From", "To", "Date and time", "Seats"
         }
      ));
      busAndChaffeurTabel.getColumnModel().getColumn(3).setResizable(false);
      busAndChaffeurTabel.getColumnModel().getColumn(3).setPreferredWidth(93);
      scrollPane_1.setViewportView(busAndChaffeurTabel);
   }

}
