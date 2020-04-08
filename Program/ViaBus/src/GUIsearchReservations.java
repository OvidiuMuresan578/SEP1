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

public class GUIsearchReservations extends JFrame
{

   private JPanel contentPane;
   private JTable reservationTable;

   
   public GUIsearchReservations()
   {
      addElements();
   }
   
   public void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 593, 372);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Search results for reservations");
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
      lblNewLabel.setBounds(10, 11, 243, 14);
      contentPane.add(lblNewLabel);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 41, 452, 281);
      contentPane.add(scrollPane);
      
      reservationTable = new JTable();
      reservationTable.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Customer", "Seats nr.", "Price", "Phone number"
         }
      ));
      reservationTable.getColumnModel().getColumn(3).setResizable(false);
      reservationTable.getColumnModel().getColumn(3).setPreferredWidth(117);
      scrollPane.setViewportView(reservationTable);
   }
}
