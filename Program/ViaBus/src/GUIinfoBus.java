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

public class GUIinfoBus extends JFrame
{

   private JPanel contentPane;
   private JScrollPane scrollPane_1;
   private JTable scheduleTable;
   private JLabel lblTimeschedule;
   private JScrollPane scrollPane;
   private JTable table;
  
  
   public GUIinfoBus()
   {
      addElements();
      
   }
   
   
   public void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 835, 484);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblBusInfo = new JLabel("Bus information");
      lblBusInfo.setFont(new Font("Tahoma", Font.PLAIN, 17));
      lblBusInfo.setBounds(10, 11, 116, 31);
      contentPane.add(lblBusInfo);
      
      scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(10, 295, 799, 139);
      contentPane.add(scrollPane_1);
      
      scheduleTable = new JTable();
      scheduleTable.setModel(new DefaultTableModel(
         new Object[][] {
            {"Today", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ""},
            {"Tomorrow", "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
         },
         new String[] {
            "", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"
         }
      ) {
         boolean[] columnEditables = new boolean[] {
            false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
         };
         public boolean isCellEditable(int row, int column) {
            return columnEditables[column];
         }
      });
      scheduleTable.getColumnModel().getColumn(0).setPreferredWidth(118);
      scheduleTable.getColumnModel().getColumn(0).setMinWidth(12);
      scheduleTable.getColumnModel().getColumn(1).setPreferredWidth(38);
      scheduleTable.getColumnModel().getColumn(2).setResizable(false);
      scheduleTable.getColumnModel().getColumn(2).setPreferredWidth(29);
      scheduleTable.getColumnModel().getColumn(3).setResizable(false);
      scheduleTable.getColumnModel().getColumn(3).setPreferredWidth(29);
      scheduleTable.getColumnModel().getColumn(4).setResizable(false);
      scheduleTable.getColumnModel().getColumn(4).setPreferredWidth(25);
      scheduleTable.getColumnModel().getColumn(5).setPreferredWidth(35);
      scheduleTable.getColumnModel().getColumn(6).setPreferredWidth(32);
      scheduleTable.getColumnModel().getColumn(7).setPreferredWidth(31);
      scheduleTable.getColumnModel().getColumn(8).setPreferredWidth(26);
      scheduleTable.getColumnModel().getColumn(9).setPreferredWidth(26);
      scheduleTable.getColumnModel().getColumn(10).setPreferredWidth(24);
      scheduleTable.getColumnModel().getColumn(11).setPreferredWidth(30);
      scheduleTable.getColumnModel().getColumn(12).setPreferredWidth(27);
      scheduleTable.getColumnModel().getColumn(13).setPreferredWidth(28);
      scheduleTable.getColumnModel().getColumn(14).setPreferredWidth(23);
      scheduleTable.getColumnModel().getColumn(15).setPreferredWidth(40);
      scheduleTable.getColumnModel().getColumn(16).setPreferredWidth(33);
      scheduleTable.getColumnModel().getColumn(17).setPreferredWidth(32);
      scheduleTable.getColumnModel().getColumn(18).setPreferredWidth(32);
      scheduleTable.getColumnModel().getColumn(19).setPreferredWidth(32);
      scheduleTable.getColumnModel().getColumn(20).setPreferredWidth(34);
      scheduleTable.getColumnModel().getColumn(21).setPreferredWidth(31);
      scheduleTable.getColumnModel().getColumn(22).setPreferredWidth(25);
      scheduleTable.getColumnModel().getColumn(23).setPreferredWidth(30);
      scheduleTable.getColumnModel().getColumn(24).setPreferredWidth(33);
      scheduleTable.getColumnModel().getColumn(25).setPreferredWidth(24);
      scrollPane_1.setViewportView(scheduleTable);
      
      lblTimeschedule = new JLabel("Time schedule");
      lblTimeschedule.setFont(new Font("Tahoma", Font.PLAIN, 14));
      lblTimeschedule.setBounds(10, 260, 102, 24);
      contentPane.add(lblTimeschedule);
      
      scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 46, 799, 158);
      contentPane.add(scrollPane);
      
      table = new JTable();
      table.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Number", "MFG", "Model", "MFG year", "Color", "Plate number", "Seats nr", "Toilet", "Party bus", "Seats map"
         }
      ));
      table.getColumnModel().getColumn(6).setResizable(false);
      table.getColumnModel().getColumn(6).setPreferredWidth(59);
      table.getColumnModel().getColumn(7).setResizable(false);
      table.getColumnModel().getColumn(7).setPreferredWidth(42);
      table.getColumnModel().getColumn(8).setResizable(false);
      table.getColumnModel().getColumn(8).setPreferredWidth(59);
      scrollPane.setViewportView(table);
      
      
      
      
      
      
   }
}
