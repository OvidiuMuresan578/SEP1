import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

public class GUIcustomerInfo extends JFrame
{

   private JPanel contentPane;
   private JTable table;

   
   public GUIcustomerInfo()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 737, 308);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblCustomersInformation = new JLabel("Customer's information");
      lblCustomersInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblCustomersInformation.setBounds(10, 11, 178, 14);
      contentPane.add(lblCustomersInformation);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 53, 701, 78);
      contentPane.add(scrollPane);
      
      table = new JTable();
      table.setModel(new DefaultTableModel(
         new Object[][] {
            {null, null, null, null, null, null, null},
         },
         new String[] {
            "Customer name", "Address", "Phone number", "Birthday", "Company name", "CVR number", "Email address"
         }
      ));
      
      scrollPane.setViewportView(table);
      
      JSeparator separator = new JSeparator();
      separator.setBounds(58, 154, 608, 2);
      contentPane.add(separator);
      
      JLabel lblTotalReservationsMade = new JLabel("Total reservations made:");
      lblTotalReservationsMade.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblTotalReservationsMade.setBounds(20, 167, 144, 14);
      contentPane.add(lblTotalReservationsMade);
      
      JLabel lblTotalLengthOf = new JLabel("Total length of them:");
      lblTotalLengthOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblTotalLengthOf.setBounds(43, 192, 121, 14);
      contentPane.add(lblTotalLengthOf);
      
      JLabel lblTotalPriceOf = new JLabel("Total price of them:");
      lblTotalPriceOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblTotalPriceOf.setBounds(50, 217, 114, 14);
      contentPane.add(lblTotalPriceOf);
      
      JLabel lblNewLabel = new JLabel("0");
      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
      lblNewLabel.setBounds(202, 167, 46, 14);
      contentPane.add(lblNewLabel);
      
      JLabel label = new JLabel("0");
      label.setFont(new Font("Tahoma", Font.BOLD, 13));
      label.setBounds(202, 192, 46, 14);
      contentPane.add(label);
      
      JLabel label_1 = new JLabel("0");
      label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
      label_1.setBounds(202, 217, 46, 14);
      contentPane.add(label_1);
      
      
   }

}
