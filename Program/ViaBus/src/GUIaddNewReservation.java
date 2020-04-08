import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.INITIALIZE;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GUIaddNewReservation extends JFrame
{

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;
   private JTextField textField_3;
   private JTextField textField_4;
   private JTextField textField_5;
   private JTextField textField_6;
   private JTable table;

   
   public GUIaddNewReservation()
   {
      super("New reservation");
      addElements();
   }

   public void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 716, 565);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JLabel lblAddingANew = new JLabel("Adding a new reservation");
      lblAddingANew.setBounds(10, 11, 189, 20);
      lblAddingANew.setFont(new Font("Tahoma", Font.PLAIN, 16));
      contentPane.add(lblAddingANew);

      JLabel label = new JLabel("Customer name*:");
      label.setBounds(10, 57, 109, 14);
      label.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(label);

      textField = new JTextField();
      textField.setBounds(141, 55, 86, 20);
      textField.setColumns(10);
      contentPane.add(textField);

      textField_1 = new JTextField();
      textField_1.setBounds(141, 80, 86, 20);
      textField_1.setColumns(10);
      contentPane.add(textField_1);

      JLabel label_1 = new JLabel("Address*:");
      label_1.setBounds(10, 82, 91, 14);
      label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(label_1);

      JLabel label_2 = new JLabel("Phone number*:");
      label_2.setBounds(10, 107, 109, 14);
      label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(label_2);

      textField_2 = new JTextField();
      textField_2.setBounds(141, 105, 86, 20);
      textField_2.setColumns(10);
      contentPane.add(textField_2);

      JLabel label_3 = new JLabel("Birthday:");
      label_3.setBounds(10, 132, 91, 14);
      label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(label_3);

      textField_3 = new JTextField();
      textField_3.setBounds(141, 130, 86, 20);
      textField_3.setColumns(10);
      contentPane.add(textField_3);

      JLabel label_4 = new JLabel("Company name:");
      label_4.setBounds(10, 157, 109, 14);
      label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(label_4);

      textField_4 = new JTextField();
      textField_4.setBounds(141, 155, 86, 20);
      textField_4.setColumns(10);
      contentPane.add(textField_4);

      JLabel label_5 = new JLabel("CVR number:");
      label_5.setBounds(10, 182, 109, 14);
      label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(label_5);

      textField_5 = new JTextField();
      textField_5.setBounds(141, 180, 86, 20);
      textField_5.setColumns(10);
      contentPane.add(textField_5);

      JLabel label_6 = new JLabel("Email address:");
      label_6.setBounds(10, 207, 109, 14);
      label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(label_6);

      textField_6 = new JTextField();
      textField_6.setBounds(141, 205, 86, 20);
      textField_6.setColumns(10);
      contentPane.add(textField_6);

      JLabel label_7 = new JLabel("Passangers:");
      label_7.setBounds(451, 20, 190, 20);
      label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
      contentPane.add(label_7);

      JSeparator separator = new JSeparator();
      separator.setOrientation(SwingConstants.VERTICAL);
      separator.setBounds(242, 34, 2, 310);
      contentPane.add(separator);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(264, 51, 239, 267);
      contentPane.add(scrollPane);

      table = new JTable();
      table.setModel(new DefaultTableModel(new Object[][] {},
            new String[] { "Fist name", "Last name" }));
      scrollPane.setViewportView(table);

      JButton btnAddPassenger = new JButton("Add passenger");
      btnAddPassenger.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent arg0)
         {

            int clicks = 0;
            clicks++;

            int numCols = table.getModel().getColumnCount();
            int numRows = table.getModel().getRowCount();

            Object[] rows = new Object[numRows];
            Object[] cols = new Object[numCols];
            

            ((DefaultTableModel) table.getModel()).addRow(cols);

         }
      });
      btnAddPassenger.setBounds(513, 98, 153, 23);
      contentPane.add(btnAddPassenger);

      JButton btnRemovePassenger = new JButton("Remove passenger");
      btnRemovePassenger.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int i = table.getSelectedRow();
            ((DefaultTableModel)table.getModel()).removeRow(i);
         }
      });
      btnRemovePassenger.setBounds(513, 132, 153, 23);
      contentPane.add(btnRemovePassenger);
      
      JButton button = new JButton("SAVE");
      button.setFont(new Font("Tahoma", Font.BOLD, 14));
      button.setBounds(604, 488, 86, 34);
      contentPane.add(button);
      
      JLabel lblCustomerGoing = new JLabel("Customer going:");
      lblCustomerGoing.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblCustomerGoing.setBounds(513, 56, 109, 17);
      contentPane.add(lblCustomerGoing);
      
      JComboBox comboBox = new JComboBox();
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
      comboBox.setBounds(625, 55, 51, 20);
      contentPane.add(comboBox);
      
      JLabel label_8 = new JLabel("Seats map");
      label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
      label_8.setBounds(10, 335, 70, 14);
      contentPane.add(label_8);
      
      JLabel lblPleaseTheBoxes = new JLabel("Select the boxes where the customers want to stay.");
      lblPleaseTheBoxes.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblPleaseTheBoxes.setBounds(10, 360, 321, 14);
      contentPane.add(lblPleaseTheBoxes);
      
      JCheckBox checkBox = new JCheckBox("");
      checkBox.setBounds(11, 388, 21, 23);
      contentPane.add(checkBox);
      
      JCheckBox checkBox_1 = new JCheckBox("");
      checkBox_1.setBounds(35, 388, 21, 23);
      contentPane.add(checkBox_1);
      
      JCheckBox checkBox_2 = new JCheckBox("");
      checkBox_2.setBounds(57, 388, 21, 23);
      contentPane.add(checkBox_2);
      
      JCheckBox checkBox_3 = new JCheckBox("");
      checkBox_3.setBounds(80, 389, 21, 23);
      contentPane.add(checkBox_3);
      
      JCheckBox checkBox_4 = new JCheckBox("");
      checkBox_4.setBounds(103, 388, 21, 23);
      contentPane.add(checkBox_4);
      
      JCheckBox checkBox_5 = new JCheckBox("");
      checkBox_5.setBounds(126, 388, 21, 23);
      contentPane.add(checkBox_5);
      
      JCheckBox checkBox_6 = new JCheckBox("");
      checkBox_6.setBounds(149, 388, 21, 23);
      contentPane.add(checkBox_6);
      
      JCheckBox checkBox_7 = new JCheckBox("");
      checkBox_7.setBounds(172, 388, 21, 23);
      contentPane.add(checkBox_7);
      
      JCheckBox checkBox_8 = new JCheckBox("");
      checkBox_8.setBounds(195, 388, 21, 23);
      contentPane.add(checkBox_8);
      
      JCheckBox checkBox_9 = new JCheckBox("");
      checkBox_9.setBounds(219, 388, 21, 23);
      contentPane.add(checkBox_9);
      
      JCheckBox checkBox_10 = new JCheckBox("");
      checkBox_10.setBounds(241, 388, 21, 23);
      contentPane.add(checkBox_10);
      
      JCheckBox checkBox_11 = new JCheckBox("");
      checkBox_11.setBounds(264, 389, 21, 23);
      contentPane.add(checkBox_11);
      
      JCheckBox checkBox_12 = new JCheckBox("");
      checkBox_12.setBounds(287, 388, 21, 23);
      contentPane.add(checkBox_12);
      
      JCheckBox checkBox_13 = new JCheckBox("");
      checkBox_13.setBounds(310, 388, 21, 23);
      contentPane.add(checkBox_13);
      
      JCheckBox checkBox_14 = new JCheckBox("");
      checkBox_14.setBounds(333, 388, 21, 23);
      contentPane.add(checkBox_14);
      
      JCheckBox checkBox_15 = new JCheckBox("");
      checkBox_15.setBounds(356, 388, 21, 23);
      contentPane.add(checkBox_15);
      
      JCheckBox checkBox_16 = new JCheckBox("");
      checkBox_16.setBounds(379, 388, 21, 23);
      contentPane.add(checkBox_16);
      
      JCheckBox checkBox_17 = new JCheckBox("");
      checkBox_17.setBounds(379, 413, 21, 23);
      contentPane.add(checkBox_17);
      
      JCheckBox checkBox_18 = new JCheckBox("");
      checkBox_18.setBounds(356, 413, 21, 23);
      contentPane.add(checkBox_18);
      
      JCheckBox checkBox_19 = new JCheckBox("");
      checkBox_19.setBounds(333, 413, 21, 23);
      contentPane.add(checkBox_19);
      
      JCheckBox checkBox_20 = new JCheckBox("");
      checkBox_20.setBounds(310, 413, 21, 23);
      contentPane.add(checkBox_20);
      
      JCheckBox checkBox_21 = new JCheckBox("");
      checkBox_21.setBounds(287, 413, 21, 23);
      contentPane.add(checkBox_21);
      
      JCheckBox checkBox_22 = new JCheckBox("");
      checkBox_22.setBounds(264, 413, 21, 23);
      contentPane.add(checkBox_22);
      
      JCheckBox checkBox_23 = new JCheckBox("");
      checkBox_23.setBounds(241, 413, 21, 23);
      contentPane.add(checkBox_23);
      
      JCheckBox checkBox_24 = new JCheckBox("");
      checkBox_24.setBounds(220, 413, 21, 23);
      contentPane.add(checkBox_24);
      
      JCheckBox checkBox_25 = new JCheckBox("");
      checkBox_25.setBounds(195, 413, 21, 23);
      contentPane.add(checkBox_25);
      
      JCheckBox checkBox_26 = new JCheckBox("");
      checkBox_26.setBounds(172, 413, 21, 23);
      contentPane.add(checkBox_26);
      
      JCheckBox checkBox_27 = new JCheckBox("");
      checkBox_27.setBounds(149, 413, 21, 23);
      contentPane.add(checkBox_27);
      
      JCheckBox checkBox_28 = new JCheckBox("");
      checkBox_28.setBounds(126, 413, 21, 23);
      contentPane.add(checkBox_28);
      
      JCheckBox checkBox_29 = new JCheckBox("");
      checkBox_29.setBounds(103, 413, 21, 23);
      contentPane.add(checkBox_29);
      
      JCheckBox checkBox_30 = new JCheckBox("");
      checkBox_30.setBounds(80, 413, 21, 23);
      contentPane.add(checkBox_30);
      
      JCheckBox checkBox_31 = new JCheckBox("");
      checkBox_31.setBounds(57, 413, 21, 23);
      contentPane.add(checkBox_31);
      
      JCheckBox checkBox_32 = new JCheckBox("");
      checkBox_32.setBounds(36, 413, 21, 23);
      contentPane.add(checkBox_32);
      
      JCheckBox checkBox_33 = new JCheckBox("");
      checkBox_33.setBounds(11, 413, 21, 23);
      contentPane.add(checkBox_33);
      
      JCheckBox checkBox_34 = new JCheckBox("");
      checkBox_34.setBounds(11, 459, 21, 23);
      contentPane.add(checkBox_34);
      
      JLabel label_10 = new JLabel("");
      label_10.setBounds(11, 488, 21, 23);
      contentPane.add(label_10);
      
      JCheckBox checkBox_35 = new JCheckBox("");
      checkBox_35.setBounds(34, 484, 21, 23);
      contentPane.add(checkBox_35);
      
      JCheckBox checkBox_36 = new JCheckBox("");
      checkBox_36.setBounds(34, 459, 21, 23);
      contentPane.add(checkBox_36);
      
      JLabel label_11 = new JLabel("Aisle");
      label_11.setBounds(48, 439, 32, 14);
      contentPane.add(label_11);
      
      JLabel label_12 = new JLabel("Aisle");
      label_12.setBounds(138, 439, 32, 14);
      contentPane.add(label_12);
      
      JLabel label_13 = new JLabel("Aisle");
      label_13.setBounds(230, 439, 32, 14);
      contentPane.add(label_13);
      
      JLabel label_14 = new JLabel("Aisle");
      label_14.setBounds(310, 439, 32, 14);
      contentPane.add(label_14);
      
      JCheckBox checkBox_37 = new JCheckBox("");
      checkBox_37.setBounds(379, 435, 21, 23);
      contentPane.add(checkBox_37);
      
      JCheckBox checkBox_38 = new JCheckBox("");
      checkBox_38.setBounds(379, 459, 21, 23);
      contentPane.add(checkBox_38);
      
      JCheckBox checkBox_39 = new JCheckBox("");
      checkBox_39.setBounds(379, 484, 21, 23);
      contentPane.add(checkBox_39);
      
      JCheckBox checkBox_40 = new JCheckBox("");
      checkBox_40.setBounds(356, 484, 21, 23);
      contentPane.add(checkBox_40);
      
      JCheckBox checkBox_41 = new JCheckBox("");
      checkBox_41.setBounds(333, 484, 21, 23);
      contentPane.add(checkBox_41);
      
      JCheckBox checkBox_42 = new JCheckBox("");
      checkBox_42.setBounds(333, 459, 21, 23);
      contentPane.add(checkBox_42);
      
      JCheckBox checkBox_43 = new JCheckBox("");
      checkBox_43.setBounds(356, 459, 21, 23);
      contentPane.add(checkBox_43);
      
      JCheckBox checkBox_44 = new JCheckBox("");
      checkBox_44.setBounds(310, 459, 21, 23);
      contentPane.add(checkBox_44);
      
      JCheckBox checkBox_45 = new JCheckBox("");
      checkBox_45.setBounds(287, 459, 21, 23);
      contentPane.add(checkBox_45);
      
      JCheckBox checkBox_46 = new JCheckBox("");
      checkBox_46.setBounds(287, 484, 21, 23);
      contentPane.add(checkBox_46);
      
      JCheckBox checkBox_47 = new JCheckBox("");
      checkBox_47.setBounds(310, 484, 21, 23);
      contentPane.add(checkBox_47);
      
      JCheckBox checkBox_48 = new JCheckBox("");
      checkBox_48.setBounds(264, 484, 21, 23);
      contentPane.add(checkBox_48);
      
      JCheckBox checkBox_49 = new JCheckBox("");
      checkBox_49.setBounds(264, 459, 21, 23);
      contentPane.add(checkBox_49);
      
      JCheckBox checkBox_50 = new JCheckBox("");
      checkBox_50.setBounds(241, 459, 21, 23);
      contentPane.add(checkBox_50);
      
      JCheckBox checkBox_51 = new JCheckBox("");
      checkBox_51.setBounds(241, 484, 21, 23);
      contentPane.add(checkBox_51);
      
      JCheckBox checkBox_52 = new JCheckBox("");
      checkBox_52.setBounds(218, 484, 21, 23);
      contentPane.add(checkBox_52);
      
      JCheckBox checkBox_53 = new JCheckBox("");
      checkBox_53.setBounds(218, 459, 21, 23);
      contentPane.add(checkBox_53);
      
      JCheckBox checkBox_54 = new JCheckBox("");
      checkBox_54.setBounds(195, 459, 21, 23);
      contentPane.add(checkBox_54);
      
      JCheckBox checkBox_55 = new JCheckBox("");
      checkBox_55.setBounds(195, 484, 21, 23);
      contentPane.add(checkBox_55);
      
      JCheckBox checkBox_56 = new JCheckBox("");
      checkBox_56.setBounds(172, 484, 21, 23);
      contentPane.add(checkBox_56);
      
      JCheckBox checkBox_57 = new JCheckBox("");
      checkBox_57.setBounds(172, 459, 21, 23);
      contentPane.add(checkBox_57);
      
      JCheckBox checkBox_58 = new JCheckBox("");
      checkBox_58.setBounds(149, 459, 21, 23);
      contentPane.add(checkBox_58);
      
      JCheckBox checkBox_59 = new JCheckBox("");
      checkBox_59.setBounds(149, 484, 21, 23);
      contentPane.add(checkBox_59);
      
      JCheckBox checkBox_60 = new JCheckBox("");
      checkBox_60.setBounds(126, 484, 21, 23);
      contentPane.add(checkBox_60);
      
      JCheckBox checkBox_61 = new JCheckBox("");
      checkBox_61.setBounds(126, 459, 21, 23);
      contentPane.add(checkBox_61);
      
      JCheckBox checkBox_62 = new JCheckBox("");
      checkBox_62.setBounds(103, 460, 21, 23);
      contentPane.add(checkBox_62);
      
      JCheckBox checkBox_63 = new JCheckBox("");
      checkBox_63.setBounds(103, 484, 21, 23);
      contentPane.add(checkBox_63);
      
      JCheckBox checkBox_64 = new JCheckBox("");
      checkBox_64.setBounds(80, 484, 21, 23);
      contentPane.add(checkBox_64);
      
      JCheckBox checkBox_65 = new JCheckBox("");
      checkBox_65.setBounds(80, 459, 21, 23);
      contentPane.add(checkBox_65);
      
      JCheckBox checkBox_66 = new JCheckBox("");
      checkBox_66.setBounds(58, 459, 21, 23);
      contentPane.add(checkBox_66);
      
      JCheckBox checkBox_67 = new JCheckBox("");
      checkBox_67.setBounds(59, 484, 21, 23);
      contentPane.add(checkBox_67);
      
      JLabel label_15 = new JLabel("");
      label_15.setIcon(new ImageIcon("C:\\Users\\Chris\\Desktop\\steering_wheel.png"));
      label_15.setBounds(11, 488, 21, 23);
      contentPane.add(label_15);
   }
}
