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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIinfoOneDayTripAndTour extends JFrame
{

   private JPanel contentPane;
   private JTable infoTable;
   private JTable busTable;
   private JTable chauffeurTable;
   
   public GUIinfoOneDayTripAndTour()
   {
      super("Info");
      addElements();
     
   }


   private void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 1029, 347);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblReservations = new JLabel("Reservations");
      lblReservations.setBounds(10, 11, 101, 14);
      lblReservations.setFont(new Font("Tahoma", Font.PLAIN, 16));
      contentPane.add(lblReservations);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 69, 317, 172);
      contentPane.add(scrollPane);
      
      infoTable = new JTable();
      infoTable.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Customer", "Seats", "Price", ""
         }
      ));
      scrollPane.setViewportView(infoTable);
      
      JButton btnNewReservation = new JButton("New reservation");
      btnNewReservation.setBounds(185, 252, 142, 23);
      contentPane.add(btnNewReservation);
      
      JLabel lblSeats = new JLabel("Seats:");
      lblSeats.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblSeats.setBounds(10, 247, 46, 14);
      contentPane.add(lblSeats);
      
      JButton saveButton = new JButton("SAVE");
      saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
      saveButton.setBounds(926, 272, 86, 34);
      contentPane.add(saveButton);
      
      JSeparator separator = new JSeparator();
      separator.setOrientation(SwingConstants.VERTICAL);
      separator.setBounds(337, 41, 2, 220);
      contentPane.add(separator);
      
      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(349, 69, 317, 172);
      contentPane.add(scrollPane_1);
      
      JLabel label = new JLabel("Choose an available bus:");
      label.setFont(new Font("Tahoma", Font.BOLD, 14));
      label.setBounds(349, 41, 179, 14);
      contentPane.add(label);
      
      JSeparator separator_1 = new JSeparator();
      separator_1.setOrientation(SwingConstants.VERTICAL);
      separator_1.setBounds(676, 41, 2, 220);
      contentPane.add(separator_1);
      
      JLabel label_1 = new JLabel("Choose an available chauffeur");
      label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
      label_1.setBounds(688, 41, 220, 14);
      contentPane.add(label_1);
      
      JScrollPane scrollPane_2 = new JScrollPane();
      scrollPane_2.setBounds(688, 69, 317, 172);
      contentPane.add(scrollPane_2);
      
      JLabel numberSeats = new JLabel("none");
      numberSeats.setFont(new Font("Tahoma", Font.PLAIN, 13));
      numberSeats.setBounds(53, 247, 46, 14);
      contentPane.add(numberSeats);
      
      JComboBox comboBoxFood = new JComboBox();
      comboBoxFood.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
      comboBoxFood.setBounds(103, 270, 57, 20);
      contentPane.add(comboBoxFood);
      
      JLabel lblFoodAvailable = new JLabel("Food available:");
      lblFoodAvailable.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblFoodAvailable.setBounds(10, 272, 101, 14);
      contentPane.add(lblFoodAvailable);
      
      busTable = new JTable();
      busTable
            .setModel(new DefaultTableModel(
                  new Object[][] {
                        { null, null, null, null, null, null, null }, },
                  new String[] { "MFR", "Model", "MFR Year", "Color",
                        "Seats nr.", "Toilet", "Party" }));
      busTable.getColumnModel().getColumn(2).setPreferredWidth(90);
      scrollPane_1.setViewportView(busTable);
      
      chauffeurTable = new JTable();
      chauffeurTable.setModel(new DefaultTableModel(
            new Object[][] { { null, null, null, null, null, null }, },
            new String[] { "Employee ID", "Full name", "Address", "Phone nr.",
                  "Full time", "Wishes" }));
      scrollPane_2.setViewportView(chauffeurTable);
      
   }
}
