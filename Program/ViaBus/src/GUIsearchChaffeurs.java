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

public class GUIsearchChaffeurs extends JFrame
{

   private JPanel contentPane;
   private JTable chauffeurTable;
   
   public GUIsearchChaffeurs()
   {
     addElements();
     
   }
   public void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 616, 353);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Search results for chaffeurs");
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
      lblNewLabel.setBounds(10, 11, 221, 14);
      contentPane.add(lblNewLabel);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 41, 580, 262);
      contentPane.add(scrollPane);
      
      chauffeurTable = new JTable();
      chauffeurTable.setModel(new DefaultTableModel(
            new Object[][] { { null, null, null, null, null, null }, },
            new String[] { "Employee ID", "Full name", "Address", "Phone nr.",
                  "Full time", "Wishes" }));
      
      scrollPane.setViewportView(chauffeurTable);
      
   }

}
