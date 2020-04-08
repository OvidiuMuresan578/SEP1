import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class GUIsearchBusses extends JFrame
{

   private JPanel contentPane;
   private JTable busTable;
   private JScrollPane scrollPane;

   
   public GUIsearchBusses()
   {
   
      addElements();
      
   }
   
   public void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 576, 293);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblResultsForBusses = new JLabel("Results for busses");
      lblResultsForBusses.setFont(new Font("Tahoma", Font.PLAIN, 17));
      lblResultsForBusses.setBounds(10, 11, 153, 14);
      contentPane.add(lblResultsForBusses);
      
      scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 36, 540, 161);
      contentPane.add(scrollPane);
      
      
      busTable = new JTable();
      busTable
            .setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "MFR", "Model", "MFR Year", "Color", "Seats nr.", "Toilet", "Party"
         }
      ));
      busTable.getColumnModel().getColumn(2).setPreferredWidth(90);
      scrollPane.setViewportView(busTable);
      
      
   }

}
