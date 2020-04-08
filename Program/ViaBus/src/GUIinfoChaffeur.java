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
import javax.swing.JButton;

public class GUIinfoChaffeur extends JFrame
{

   private JPanel contentPane;
   private JTable table;
   private JTable table_1;

   
   public GUIinfoChaffeur()
      
   {
      super("Chauffeur's info");
      addElements();
   }

   private void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 642, 556);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Chauffeur's information");
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblNewLabel.setBounds(10, 11, 174, 14);
      contentPane.add(lblNewLabel);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 59, 606, 69);
      contentPane.add(scrollPane);
      
      table = new JTable();
      table.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Employee ID", "Full name", "Address", "Phone nr.", "Full time", "Wishes"
         }
      ));
      scrollPane.setViewportView(table);
      
      JSeparator separator = new JSeparator();
      separator.setBounds(10, 139, 606, 19);
      contentPane.add(separator);
      
      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(10, 157, 606, 224);
      contentPane.add(scrollPane_1);
      
      table_1 = new JTable();
      table_1.setModel(new DefaultTableModel(
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
      table_1.getColumnModel().getColumn(0).setPreferredWidth(118);
      table_1.getColumnModel().getColumn(0).setMinWidth(12);
      table_1.getColumnModel().getColumn(1).setPreferredWidth(38);
      table_1.getColumnModel().getColumn(2).setResizable(false);
      table_1.getColumnModel().getColumn(2).setPreferredWidth(29);
      table_1.getColumnModel().getColumn(3).setResizable(false);
      table_1.getColumnModel().getColumn(3).setPreferredWidth(29);
      table_1.getColumnModel().getColumn(4).setResizable(false);
      table_1.getColumnModel().getColumn(4).setPreferredWidth(25);
      table_1.getColumnModel().getColumn(5).setPreferredWidth(35);
      table_1.getColumnModel().getColumn(6).setPreferredWidth(32);
      table_1.getColumnModel().getColumn(7).setPreferredWidth(31);
      table_1.getColumnModel().getColumn(8).setPreferredWidth(26);
      table_1.getColumnModel().getColumn(9).setPreferredWidth(26);
      table_1.getColumnModel().getColumn(10).setPreferredWidth(24);
      table_1.getColumnModel().getColumn(11).setPreferredWidth(30);
      table_1.getColumnModel().getColumn(12).setPreferredWidth(27);
      table_1.getColumnModel().getColumn(13).setPreferredWidth(28);
      table_1.getColumnModel().getColumn(14).setPreferredWidth(23);
      table_1.getColumnModel().getColumn(15).setPreferredWidth(40);
      table_1.getColumnModel().getColumn(16).setPreferredWidth(33);
      table_1.getColumnModel().getColumn(17).setPreferredWidth(32);
      table_1.getColumnModel().getColumn(18).setPreferredWidth(32);
      table_1.getColumnModel().getColumn(19).setPreferredWidth(32);
      table_1.getColumnModel().getColumn(20).setPreferredWidth(34);
      table_1.getColumnModel().getColumn(21).setPreferredWidth(31);
      table_1.getColumnModel().getColumn(22).setPreferredWidth(25);
      table_1.getColumnModel().getColumn(23).setPreferredWidth(30);
      table_1.getColumnModel().getColumn(24).setPreferredWidth(33);
      table_1.getColumnModel().getColumn(25).setPreferredWidth(24);
      scrollPane_1.setViewportView(table_1);
      
      JButton btnDelete = new JButton("Delete");
      btnDelete.setBounds(527, 426, 89, 23);
      contentPane.add(btnDelete);
      
      JButton btnEdit = new JButton("Edit");
      btnEdit.setBounds(527, 392, 89, 23);
      contentPane.add(btnEdit);
      
      JButton button = new JButton("SAVE");
      button.setFont(new Font("Tahoma", Font.BOLD, 14));
      button.setBounds(530, 477, 86, 34);
      contentPane.add(button);
      
   }
}
