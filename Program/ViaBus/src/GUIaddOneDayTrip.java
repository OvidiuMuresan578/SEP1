import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIaddOneDayTrip extends JFrame
{

   private JPanel contentPane;
   private JTable scheduleTable;
   private JTable busTable;
   private JTable chauffeurTable;
   private JButton saveButton;
   private JLabel lblSchedule;
   private JScrollPane scrollPane;
   private DefaultTableModel model;
   private JButton addStop;
   private JButton deleteStop;
   private JCheckBox food;
   private JLabel chooseAnAvailableBus;
   private JScrollPane scrollPane_1;
   private JSeparator separator;
   private JSeparator separator_1;
   private JScrollPane scrollPane_2;
   private JLabel chooseAnAvailableChauffeur;
   private int clicks;
   private JButton refreshButton;
   private JLabel errorSelectABus;
   private JLabel errorSelectChaffeur;
   private JLabel errorStartDestination;
   private JLabel errorPleaseInputEnd;
   private Object[] data;

   public GUIaddOneDayTrip()
   {
      super("Schedule");
      initialize();
      addElements();
      setVisible(false);
   }

   public void addActionListener(ActionListener listener)
   {
      saveButton.addActionListener(listener);
      addStop.addActionListener(listener);
      deleteStop.addActionListener(listener);
   }

   public void addErrorLabels()
   {
      errorSelectABus = new JLabel("Please select a bus*");
      errorSelectABus.setForeground(Color.RED);
      errorSelectABus.setFont(new Font("Tahoma", Font.BOLD, 14));
      errorSelectABus.setBounds(332, 415, 140, 14);
      contentPane.add(errorSelectABus);

      errorSelectChaffeur = new JLabel("Please select a chaffeur*");
      errorSelectChaffeur.setForeground(Color.RED);
      errorSelectChaffeur.setFont(new Font("Tahoma", Font.BOLD, 14));
      errorSelectChaffeur.setBounds(773, 413, 185, 14);
      contentPane.add(errorSelectChaffeur);

      errorPleaseInputEnd = new JLabel("Please input end destination*");
      errorPleaseInputEnd.setForeground(Color.RED);
      errorPleaseInputEnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
      errorPleaseInputEnd.setBounds(10, 447, 174, 14);
      contentPane.add(errorPleaseInputEnd);
   }

   public Object[] getDataScheduleTable()
   {
      data = new Object[10];
      data[0] = getData(scheduleTable, 0, 1);// startDest
      data[1] = getData(scheduleTable, 1, 1);// endDest
      data[2] = getData(scheduleTable, 0, 2);// startTime
      data[4] = getData(scheduleTable, 1, 2);// endTime
      data[3] = getData(scheduleTable, 0, 3);// date

      return data;
   }

   public Object getData(JTable table, int rowIndex, int colIndex)
   {
      if (table.isEditing())
         table.getCellEditor().stopCellEditing();
      return table.getModel().getValueAt(rowIndex, colIndex);
   }

   public void addStopOneDayTrip()
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

   public void deleteStopOneDayTrip()
   {
      int i = scheduleTable.getSelectedRow();
      ((DefaultTableModel) scheduleTable.getModel()).removeRow(i);
   }

   private void initialize()
   {
      contentPane = new JPanel();
      lblSchedule = new JLabel("Schedule");
      scrollPane = new JScrollPane();
      model = new DefaultTableModel();
      addStop = new JButton("Add stop");
      deleteStop = new JButton("Delete stop");
      food = new JCheckBox("Food");
      chooseAnAvailableBus = new JLabel("Choose an available bus:");
      scrollPane_1 = new JScrollPane();
      separator = new JSeparator();
      separator_1 = new JSeparator();
      scrollPane_2 = new JScrollPane();
      chooseAnAvailableChauffeur = new JLabel("Choose an available chauffeur");
      saveButton = new JButton("SAVE");
      refreshButton = new JButton("REFRESH");
   }

   public void addElements()
   {
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 1209, 520);

      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      lblSchedule.setBounds(10, 11, 86, 23);
      lblSchedule.setFont(new Font("Tahoma", Font.PLAIN, 19));
      contentPane.add(lblSchedule);

      scrollPane.setBounds(10, 77, 291, 322);
      contentPane.add(scrollPane);

      String data[][] = { { "Start", null, null }, { "End", null, null } };
      String col[] = { "", "Destination", "Time", "Date" };
      DefaultTableModel model = new DefaultTableModel(data, col);
      scheduleTable = new JTable(model);
      JTableHeader header = scheduleTable.getTableHeader();
      header.setBackground(Color.cyan);
      scrollPane.setViewportView(scheduleTable);

      addStop.setActionCommand(GUIMain.ADD_STOP_ONE_DAY_TRIP);
      addStop.setBounds(194, 410, 109, 23);
      addStop.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(addStop);

      refreshButton.setActionCommand(GUIMain.REFRESH_BUTTON);
      refreshButton.setBounds(980, 437, 95, 34);
      refreshButton.setFont(new Font("Tahoma", Font.BOLD, 13));
      contentPane.add(refreshButton);

      saveButton.setActionCommand(GUIMain.SAVE_BUTTON_ONE_DAY_TRIP);
      saveButton.setBounds(1098, 437, 86, 34);
      saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
      contentPane.add(saveButton);

      deleteStop.setActionCommand(GUIMain.DELETE_STOP_ONE_DAY_TRIP);
      deleteStop.setBounds(192, 444, 109, 23);
      deleteStop.setFont(new Font("Tahoma", Font.PLAIN, 13));
      contentPane.add(deleteStop);

      food.setBounds(10, 406, 97, 23);
      contentPane.add(food);

      chooseAnAvailableBus.setBounds(332, 44, 179, 14);
      chooseAnAvailableBus.setFont(new Font("Tahoma", Font.BOLD, 14));
      contentPane.add(chooseAnAvailableBus);

      scrollPane_1.setBounds(320, 77, 421, 322);
      contentPane.add(scrollPane_1);

      busTable = new JTable();
      busTable
            .setModel(new DefaultTableModel(
                  new Object[][] {
                        { null, null, null, null, null, null, null }, },
                  new String[] { "MFR", "Model", "MFR Year", "Color",
                        "Seats nr.", "Toilet", "Party" }));
      busTable.getColumnModel().getColumn(2).setPreferredWidth(90);
      scrollPane_1.setViewportView(busTable);

      separator.setBounds(311, 51, 2, 395);
      separator.setOrientation(SwingConstants.VERTICAL);
      contentPane.add(separator);

      separator_1.setOrientation(SwingConstants.VERTICAL);
      separator_1.setBounds(751, 51, 2, 395);
      contentPane.add(separator_1);

      scrollPane_2.setBounds(763, 77, 421, 322);
      contentPane.add(scrollPane_2);

      chauffeurTable = new JTable();
      chauffeurTable.setModel(new DefaultTableModel(
            new Object[][] { { null, null, null, null, null, null }, },
            new String[] { "Employee ID", "Full name", "Address", "Phone nr.",
                  "Full time", "Wishes" }));
      scrollPane_2.setViewportView(chauffeurTable);

      chooseAnAvailableChauffeur.setFont(new Font("Tahoma", Font.BOLD, 14));
      chooseAnAvailableChauffeur.setBounds(763, 46, 220, 14);
      contentPane.add(chooseAnAvailableChauffeur);

   }
}
