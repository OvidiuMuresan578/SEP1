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
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GUIinfoBusAndChaffeur1 extends JFrame
{

   private JPanel contentPane;
   private JTable busAndChaffeurTable;
   private JTable passangersServicesTable;
   private JScrollPane scrollPane_1;
   private JTable busses;
   private JTable chaffeursTable;

   
   public GUIinfoBusAndChaffeur1()
   {
      addElements();
   }
   public void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 1166, 649);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblBusAndChaffeurInfo = new JLabel("Bus and chaffeur information");
      lblBusAndChaffeurInfo.setBounds(10, 11, 222, 29);
      lblBusAndChaffeurInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
      contentPane.add(lblBusAndChaffeurInfo);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 76, 651, 199);
      contentPane.add(scrollPane);
            
      String data[][] = { };
      String col[] = { "Customer name", "Address", "Phone number", "Birthday", "Company name", "CVR number", "Email address" };
      DefaultTableModel model = new DefaultTableModel(data, col);
      busAndChaffeurTable = new JTable(model);
      scrollPane.setViewportView(busAndChaffeurTable);
      
      scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(10, 323, 651, 199);
      contentPane.add(scrollPane_1);
      
      String data1[][] = { };
      String col1[] = {"PAX count", "CUS going", "Breakfast", "Party bus","Party guide",
            "Lunch","Dinner","Vegetarians","Non-eaters" };
      DefaultTableModel model1 = new DefaultTableModel(data1, col1);
      passangersServicesTable = new JTable(model1);
      scrollPane_1.setViewportView(passangersServicesTable);
      
      JLabel lblCustomerInformation = new JLabel("Customer information");
      lblCustomerInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblCustomerInformation.setBounds(10, 51, 139, 14);
      contentPane.add(lblCustomerInformation);
      
      
      
      JLabel lblNumberOfPassangers = new JLabel("Number of passangers and services:");
      lblNumberOfPassangers.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblNumberOfPassangers.setBounds(10, 286, 233, 26);
      contentPane.add(lblNumberOfPassangers);
      
      JLabel lblFoodPreferences = new JLabel
            ("Out of         passengers,       "
                  + "want food and         of those are vegetarians.");
      lblFoodPreferences.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblFoodPreferences.setBounds(10, 537, 651, 29);
      contentPane.add(lblFoodPreferences);
      
      JLabel lblNumberofpassangers = new JLabel("0");
      lblNumberofpassangers.setForeground(Color.RED);
      lblNumberofpassangers.setFont(new Font("Tahoma", Font.BOLD, 15));
      lblNumberofpassangers.setBounds(62, 537, 25, 29);
      contentPane.add(lblNumberofpassangers);
      
      JLabel label = new JLabel("0");
      label.setForeground(Color.RED);
      label.setFont(new Font("Tahoma", Font.BOLD, 15));
      label.setBounds(176, 537, 25, 29);
      contentPane.add(label);
      
      JLabel label_1 = new JLabel("0");
      label_1.setForeground(Color.RED);
      label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
      label_1.setBounds(304, 537, 25, 29);
      contentPane.add(label_1);
      
      JSeparator separator = new JSeparator();
      separator.setOrientation(SwingConstants.VERTICAL);
      separator.setBounds(671, 62, 2, 223);
      contentPane.add(separator);
      
      JSeparator separator_1 = new JSeparator();
      separator_1.setOrientation(SwingConstants.VERTICAL);
      separator_1.setBounds(671, 307, 2, 223);
      contentPane.add(separator_1);
      
      JScrollPane scrollPane_2 = new JScrollPane();
      scrollPane_2.setBounds(683, 76, 457, 199);
      contentPane.add(scrollPane_2);
      
      busses = new JTable();
      busses.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
               "MFR", "Model", "MFR Year", "Color",
               "Seats nr.", "Toilet", "Party"
         }
      ));
      scrollPane_2.setViewportView(busses);
      
      JScrollPane scrollPane_3 = new JScrollPane();
      scrollPane_3.setBounds(683, 323, 457, 199);
      contentPane.add(scrollPane_3);
      
      chaffeursTable = new JTable();
      chaffeursTable.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
               "Employee ID", "Full name", "Address", "Phone nr.",
               "Full time", "Wishes"
         }
      ));
      scrollPane_3.setViewportView(chaffeursTable);
      
      JButton deleteButton = new JButton("DELETE");
      deleteButton.setFont(new Font("Tahoma", Font.BOLD, 14));
      deleteButton.setActionCommand("saveButtonOneDayTrip");
      deleteButton.setBounds(1054, 565, 86, 34);
      contentPane.add(deleteButton);
      
      JButton btnEdit = new JButton("EDIT");
      btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
      btnEdit.setActionCommand("saveButtonOneDayTrip");
      btnEdit.setBounds(958, 565, 86, 34);
      contentPane.add(btnEdit);
      
      JLabel lblAvailableBus = new JLabel("Available bus:");
      lblAvailableBus.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblAvailableBus.setBounds(683, 53, 93, 14);
      contentPane.add(lblAvailableBus);
      
      JLabel lblAvailableChaffeur = new JLabel("Available chaffeur:");
      lblAvailableChaffeur.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblAvailableChaffeur.setBounds(683, 298, 139, 14);
      contentPane.add(lblAvailableChaffeur);
   }
}
