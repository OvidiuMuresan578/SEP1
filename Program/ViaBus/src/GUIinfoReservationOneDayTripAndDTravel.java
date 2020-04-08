import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class GUIinfoReservationOneDayTripAndDTravel extends JFrame
{

   private JPanel contentPane;
   private JTable customerInfo;
   private JTable passangersNames;

  
   public GUIinfoReservationOneDayTripAndDTravel()
   {
      addElements();
   }


   private void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 714, 594);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Reservation details");
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
      lblNewLabel.setBounds(10, 11, 160, 14);
      contentPane.add(lblNewLabel);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 71, 681, 78);
      contentPane.add(scrollPane);
      
       customerInfo = new JTable();
      customerInfo.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Customer name", "Address", "Phone number", "Birthday", "Company name", "CVR number", "Email address"
         }
      ));
      
      scrollPane.setViewportView(customerInfo);
      
      JLabel lblCustomerInformation = new JLabel("Customer information");
      lblCustomerInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblCustomerInformation.setBounds(10, 46, 149, 14);
      contentPane.add(lblCustomerInformation);
      
      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(10, 197, 343, 251);
      contentPane.add(scrollPane_1);
      
      passangersNames = new JTable();
      passangersNames.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Passanger names"
         }
      ));
      scrollPane_1.setViewportView(passangersNames);
      
      JLabel passagersGoing = new JLabel("List of passangers");
      passagersGoing.setFont(new Font("Tahoma", Font.PLAIN, 14));
      passagersGoing.setBounds(10, 160, 120, 26);
      contentPane.add(passagersGoing);
      
      JLabel lblSeatSelection = new JLabel("Seat selection");
      lblSeatSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblSeatSelection.setBounds(366, 160, 120, 26);
      contentPane.add(lblSeatSelection);
      
      JSeparator separator = new JSeparator();
      separator.setOrientation(SwingConstants.VERTICAL);
      separator.setBounds(357, 180, 16, 272);
      contentPane.add(separator);
      
      JLabel label = new JLabel("Out of         passengers,       want food and         of those are vegetarians.");
      label.setFont(new Font("Tahoma", Font.BOLD, 14));
      label.setBounds(10, 478, 522, 29);
      contentPane.add(label);
      
      JLabel label_1 = new JLabel("0");
      label_1.setForeground(Color.RED);
      label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
      label_1.setBounds(62, 478, 470, 29);
      contentPane.add(label_1);
      
      JLabel label_2 = new JLabel("0");
      label_2.setForeground(Color.RED);
      label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
      label_2.setBounds(176, 478, 356, 29);
      contentPane.add(label_2);
      
      JLabel label_3 = new JLabel("0");
      label_3.setForeground(Color.RED);
      label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
      label_3.setBounds(304, 478, 228, 29);
      contentPane.add(label_3);
      
      JButton btnEdit = new JButton("EDIT");
      btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
      btnEdit.setActionCommand("saveButtonOneDayTrip");
      btnEdit.setBounds(605, 514, 86, 34);
      contentPane.add(btnEdit);
      
      JLabel lblCostumerGoing = new JLabel("Costumer going:");
      lblCostumerGoing.setFont(new Font("Tahoma", Font.BOLD, 13));
      lblCostumerGoing.setBounds(10, 514, 120, 30);
      contentPane.add(lblCostumerGoing);
      
      JLabel lblNull = new JLabel("null");
      lblNull.setFont(new Font("Tahoma", Font.BOLD, 13));
      lblNull.setBounds(137, 514, 34, 30);
      contentPane.add(lblNull);
      
   }

}
