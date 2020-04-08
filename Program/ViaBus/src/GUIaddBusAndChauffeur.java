import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class GUIaddBusAndChauffeur extends JFrame
{

   private JPanel contentPane;
   private JTextField customerNameField;
   private JTextField addressField;
   private JTextField phoneNumberField;
   private JTextField birthdayField;
   private JTextField companyNameField;
   private JTextField cvrNumberField;
   private JTextField emailAddressField;
   private JTextField passangerCountField;
   private JTable avaibleChauffeurTable;
   private JTextField vegetariansField;
   private JTextField noneEatersField;
   private JTable availableBusTable;
   private JButton saveButton;
   private JTable scheduleTable;
   private JButton addStopButton;
   private JButton deleteStopButton;
   private int clicks = 0;

   public GUIaddBusAndChauffeur()
   {

      super("Add a bus-and-chauffeur");
      initialize();
      addElements();
      setVisible(false);

   }

   private void initialize()
   {
      addStopButton = new JButton("Add stop");
      deleteStopButton = new JButton("Delete stop");

   }

   public void addActionListener(ActionListener listener)
   {
      saveButton.addActionListener(listener);
      addStopButton.addActionListener(listener);
      deleteStopButton.addActionListener(listener);
   }
   

   public Object[] getDataScheduleTable()
   {

      Object[] data = new Object[10];
      data[0] = customerNameField.getText();//customer name
      data[1] = getData(scheduleTable, 0, 1);//startDest
      data[2] = getData(scheduleTable, 1, 1);// endDest
      data[4] = getData(scheduleTable, 0, 2);// startTime
      data[3] = getData(scheduleTable, 1, 2);// endTime
      data[5] = getData(scheduleTable, 0, 3);// startDate
      data[6] = getData(scheduleTable, 1, 3);// endDate
      return data;
   }

   public Object getData(JTable table, int rowIndex, int colIndex)
   {
      if (table.isEditing())
         table.getCellEditor().stopCellEditing();
      return table.getModel().getValueAt(rowIndex, colIndex);

   }

   private void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 1230, 604);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JLabel lblAddingBusandchauffeur = new JLabel("Adding bus-and-chauffeur");
      lblAddingBusandchauffeur.setBounds(10, 11, 190, 20);
      lblAddingBusandchauffeur.setFont(new Font("Tahoma", Font.PLAIN, 16));
      contentPane.add(lblAddingBusandchauffeur);

      JLabel lblCustomerName = new JLabel("Customer name*:");
      lblCustomerName.setBounds(477, 461, 109, 14);
      lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(lblCustomerName);

      customerNameField = new JTextField();
      customerNameField.setBounds(596, 459, 86, 20);
      contentPane.add(customerNameField);
      customerNameField.setColumns(10);

      JLabel lblAddress = new JLabel("Address*:");
      lblAddress.setBounds(477, 486, 91, 14);
      lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(lblAddress);

      addressField = new JTextField();
      addressField.setBounds(596, 484, 86, 20);
      addressField.setColumns(10);
      contentPane.add(addressField);

      JLabel lblPhoneNumber = new JLabel("Phone number*:");
      lblPhoneNumber.setBounds(477, 511, 109, 14);
      lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(lblPhoneNumber);

      phoneNumberField = new JTextField();
      phoneNumberField.setBounds(596, 509, 86, 20);
      phoneNumberField.setColumns(10);
      contentPane.add(phoneNumberField);

      JLabel lblBirthday = new JLabel("Birthday:");
      lblBirthday.setBounds(477, 536, 91, 14);
      lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(lblBirthday);

      birthdayField = new JTextField();
      birthdayField.setBounds(596, 534, 86, 20);
      birthdayField.setColumns(10);
      contentPane.add(birthdayField);

      JLabel lblCompanyName = new JLabel("Company name:");
      lblCompanyName.setBounds(703, 461, 109, 14);
      lblCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(lblCompanyName);

      JLabel lblCvrNumber = new JLabel("CVR number:");
      lblCvrNumber.setBounds(703, 486, 109, 14);
      lblCvrNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(lblCvrNumber);

      JLabel lblEmailAddress = new JLabel("Email address:");
      lblEmailAddress.setBounds(703, 511, 109, 14);
      lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(lblEmailAddress);

      companyNameField = new JTextField();
      companyNameField.setBounds(815, 459, 86, 20);
      companyNameField.setColumns(10);
      contentPane.add(companyNameField);

      cvrNumberField = new JTextField();
      cvrNumberField.setBounds(815, 484, 86, 20);
      cvrNumberField.setColumns(10);
      contentPane.add(cvrNumberField);

      emailAddressField = new JTextField();
      emailAddressField.setBounds(815, 509, 86, 20);
      emailAddressField.setColumns(10);
      contentPane.add(emailAddressField);

      JLabel lblPassangers = new JLabel("Passangers:");
      lblPassangers.setBounds(6, 435, 91, 20);
      lblPassangers.setFont(new Font("Tahoma", Font.BOLD, 14));
      contentPane.add(lblPassangers);

      JLabel lblPassangerCount = new JLabel("Passangers count:");
      lblPassangerCount.setBounds(6, 461, 109, 14);
      lblPassangerCount.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(lblPassangerCount);

      passangerCountField = new JTextField();
      passangerCountField.setBounds(125, 459, 21, 20);
      contentPane.add(passangerCountField);
      passangerCountField.setColumns(10);

      JLabel lblChoose = new JLabel("Choose an available chauffeur:");
      lblChoose.setBounds(321, 42, 213, 14);
      lblChoose.setFont(new Font("Tahoma", Font.BOLD, 14));
      contentPane.add(lblChoose);

      JSeparator separator_2 = new JSeparator();
      separator_2.setBounds(311, 52, 4, 288);
      separator_2.setOrientation(SwingConstants.VERTICAL);
      contentPane.add(separator_2);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(321, 67, 421, 288);
      contentPane.add(scrollPane);

      avaibleChauffeurTable = new JTable();
      avaibleChauffeurTable.setModel(new DefaultTableModel(new Object[][] {},
            new String[] { "MFR", "Model", "MFR year", "Color", "Seats nr.",
                  "Toilet", "Party" }));
      scrollPane.setViewportView(avaibleChauffeurTable);

      saveButton = new JButton("SAVE");
      saveButton.setActionCommand(GUIMain.SAVE_BUTTON_BUS_AND_CHAUFFEURS);
      saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
      saveButton.setBounds(1117, 486, 86, 34);
      contentPane.add(saveButton);

      JLabel lblPartyBus = new JLabel("Party bus:");
      lblPartyBus.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblPartyBus.setBounds(10, 594, 62, 14);
      contentPane.add(lblPartyBus);

      JLabel lblVegetarians = new JLabel("Vegetarians:");
      lblVegetarians.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblVegetarians.setBounds(164, 461, 78, 20);
      contentPane.add(lblVegetarians);

      JLabel lblPartyGuide = new JLabel("Party guide:");
      lblPartyGuide.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblPartyGuide.setBounds(10, 619, 78, 20);
      contentPane.add(lblPartyGuide);

      JLabel lblNoneaters = new JLabel("Non-eaters:");
      lblNoneaters.setFont(new Font("Tahoma", Font.PLAIN, 13));
      lblNoneaters.setBounds(164, 489, 78, 14);
      contentPane.add(lblNoneaters);

      JCheckBox partyBysCheckbox = new JCheckBox("");
      partyBysCheckbox.setVerticalAlignment(SwingConstants.BOTTOM);
      partyBysCheckbox.setHorizontalAlignment(SwingConstants.CENTER);
      partyBysCheckbox.setBounds(88, 590, 21, 23);
      contentPane.add(partyBysCheckbox);

      JCheckBox partyGuideCheckbox = new JCheckBox("");
      partyGuideCheckbox.setVerticalAlignment(SwingConstants.BOTTOM);
      partyGuideCheckbox.setHorizontalAlignment(SwingConstants.CENTER);
      partyGuideCheckbox.setBounds(88, 618, 21, 23);
      contentPane.add(partyGuideCheckbox);

      vegetariansField = new JTextField();
      vegetariansField.setBounds(254, 462, 21, 20);
      contentPane.add(vegetariansField);
      vegetariansField.setColumns(10);

      noneEatersField = new JTextField();
      noneEatersField.setColumns(10);
      noneEatersField.setBounds(254, 487, 21, 20);
      contentPane.add(noneEatersField);

      JLabel lblAddServices = new JLabel("Add services:");
      lblAddServices.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblAddServices.setBounds(174, 438, 101, 14);
      contentPane.add(lblAddServices);

      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(763, 67, 447, 288);
      contentPane.add(scrollPane_1);

      availableBusTable = new JTable();
      availableBusTable.setModel(new DefaultTableModel(new Object[][] {},
            new String[] { "Employee ID", "Full name", "Address", "Phone nr.",
                  "Full time", "Wishes" }));
      scrollPane_1.setViewportView(availableBusTable);

      JLabel lblChooseAnAvailable = new JLabel("Choose an available bus:");
      lblChooseAnAvailable.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblChooseAnAvailable.setBounds(766, 42, 213, 14);
      contentPane.add(lblChooseAnAvailable);

      JSeparator separator_1 = new JSeparator();
      separator_1.setOrientation(SwingConstants.VERTICAL);
      separator_1.setBounds(463, 423, 4, 130);
      contentPane.add(separator_1);

      JCheckBox customerGoingCheckbox = new JCheckBox("Customer going");
      customerGoingCheckbox.setBounds(6, 483, 140, 23);
      contentPane.add(customerGoingCheckbox);

      JCheckBox chckbxBreakfast = new JCheckBox("Breakfast");
      chckbxBreakfast.setBounds(299, 508, 102, 23);
      contentPane.add(chckbxBreakfast);

      JCheckBox chckbxDinner = new JCheckBox("Dinner");
      chckbxDinner.setBounds(299, 483, 102, 23);
      contentPane.add(chckbxDinner);

      JCheckBox chckbxLunch = new JCheckBox("Lunch");
      chckbxLunch.setBounds(299, 458, 94, 23);
      contentPane.add(chckbxLunch);

      JLabel lblCustomerInfo = new JLabel("Customer info:");
      lblCustomerInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblCustomerInfo.setBounds(481, 435, 109, 20);
      contentPane.add(lblCustomerInfo);

      JScrollPane scrollPane_2 = new JScrollPane();
      scrollPane_2.setBounds(10, 64, 291, 291);
      contentPane.add(scrollPane_2);

      String data[][] = { { "Start", null, null }, { "End", null, null } };
      String col[] = { "", "Destination", "Time", "Date" };
      DefaultTableModel model = new DefaultTableModel(data, col);
      scheduleTable = new JTable(model);
      scrollPane_2.setViewportView(scheduleTable);

      JLabel lblInputDestinationInformation = new JLabel(
            "Input destination information:");
      lblInputDestinationInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblInputDestinationInformation.setBounds(10, 42, 213, 14);
      contentPane.add(lblInputDestinationInformation);

      JSeparator separator = new JSeparator();
      separator.setOrientation(SwingConstants.VERTICAL);
      separator.setBounds(752, 52, 4, 288);
      contentPane.add(separator);

      JSeparator separator_3 = new JSeparator();
      separator_3.setOrientation(SwingConstants.VERTICAL);
      separator_3.setBounds(156, 427, 4, 120);
      contentPane.add(separator_3);

      deleteStopButton.setActionCommand(GUIMain.ADD_STOP_BUS_AND_CHAUFFEUR);
      deleteStopButton.setBounds(57, 366, 122, 23);
      contentPane.add(addStopButton);

      addStopButton.setActionCommand(GUIMain.DELETE_STOP_BUS_AND_CHAUFFEUR);
      addStopButton.setBounds(189, 366, 112, 23);
      contentPane.add(deleteStopButton);

   }

   public void addStopTravel()
   {
      clicks++;

      int numCols = scheduleTable.getModel().getColumnCount();
      int numRows = scheduleTable.getModel().getRowCount();

      Object[] rows = new Object[numRows];
      Object[] cols = new Object[numCols];
      cols[0] = clicks + ".Stop";

      ((DefaultTableModel) scheduleTable.getModel()).insertRow(rows.length - 1,
            cols);

   }

   public void deleteStopTravel()
   {
      int i = scheduleTable.getSelectedRow();
      ((DefaultTableModel) scheduleTable.getModel()).removeRow(i);
   }
}
