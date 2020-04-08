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

public class GUIsearchCustomers extends JFrame
{

   private JPanel contentPane;
   private JTable table;

   
   public GUIsearchCustomers()
   {
      super("Customer search");
      addElements();
      
   }
   public void addElements()
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 546, 376);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblSearchResultsFor = new JLabel("Search results for customers");
      lblSearchResultsFor.setFont(new Font("Tahoma", Font.PLAIN, 17));
      lblSearchResultsFor.setBounds(10, 11, 228, 21);
      contentPane.add(lblSearchResultsFor);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 43, 406, 283);
      contentPane.add(scrollPane);
      
      table = new JTable();
      table.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Customer", "Birthday", "Phone number", "Email address"
         }
      ));
      table.getColumnModel().getColumn(2).setResizable(false);
      table.getColumnModel().getColumn(2).setPreferredWidth(114);
      table.getColumnModel().getColumn(3).setResizable(false);
      table.getColumnModel().getColumn(3).setPreferredWidth(102);
      scrollPane.setViewportView(table);
   }

}
