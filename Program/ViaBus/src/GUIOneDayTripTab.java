import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GUIOneDayTripTab extends JPanel
{

   private JLabel oneDayTripLabel;
   private JLabel oneDayTripJFrameLabel;
   private JButton addOneDayTripButton;
   private JScrollPane scrollPaneOneDayTrip;
   private JTable oneDayTripTourTable;
   
   private ArrayList<JButton> sideButtonsNewReservation;
   private ArrayList<JButton> sideButtonsInfo;
   private int btnNr;
   private int boundsXNewReservation = 592;
   private int boundYNewReservation = 96;
   private int boundXInfo = 643;
   private int boundYInfo = 96;

   public GUIOneDayTripTab()
   {
      initializing();
      addElements();
      setVisible(true);
   }

   public void addRowOneDayTrip(Object data[], GUIHandler handler)
   {
      int numCols = oneDayTripTourTable.getModel().getColumnCount();
      int numRows = oneDayTripTourTable.getModel().getRowCount();
      Object[] cols = new Object[numCols];
      Object[] rows = new Object[numRows];
      cols[0] = data[0];
      cols[1] = data[1];
      cols[2] = data[3];
      cols[3] = data[2] + "-" + data[4];
      ((DefaultTableModel) oneDayTripTourTable.getModel()).addRow(cols);

      this.addButtonsOneDayTrip(handler);
      
      btnNr++;
   }
   public void addButtonsOneDayTrip(GUIHandler handler)
   {
      // Reservation button
      sideButtonsNewReservation.add(new JButton(btnNr + ""));
      this.add(sideButtonsNewReservation.get(btnNr));

      sideButtonsNewReservation.get(btnNr)
            .setBounds(boundsXNewReservation, boundYNewReservation, 50, 16);
      sideButtonsNewReservation.get(btnNr)
            .setIcon(new ImageIcon("C:\\Users\\Chris\\Desktop\\add.png"));
      sideButtonsNewReservation.get(btnNr)
            .setToolTipText("Add a new reservation for this tour");
      sideButtonsNewReservation.get(btnNr)
            .setActionCommand(GUIMain.ADD_NEW_RESERVATION + btnNr);
      
      boundYNewReservation = boundYNewReservation + 16;
     
   // Info button
      sideButtonsInfo.add(new JButton(btnNr + ""));
      this.add(sideButtonsInfo.get(btnNr));
      sideButtonsInfo.get(btnNr).setBounds(boundXInfo, boundYInfo, 50,
            16);
      sideButtonsInfo.get(btnNr)
            .setIcon(new ImageIcon("C:\\Users\\Chris\\Desktop\\info.png"));
      sideButtonsInfo.get(btnNr)
            .setToolTipText("Information about this tour");
      sideButtonsInfo.get(btnNr).setActionCommand(GUIMain.INFO + btnNr);
      
      boundYInfo = boundYInfo + 16;
      
      sideButtonsNewReservation.get(btnNr).addActionListener(handler);
      sideButtonsInfo.get(btnNr).addActionListener(handler);
   }

   public void initializing()
   {
      oneDayTripLabel = new JLabel("One-day trips");
      addOneDayTripButton = new JButton();
      scrollPaneOneDayTrip = new JScrollPane();
      oneDayTripTourTable = new JTable();
      oneDayTripJFrameLabel = new JLabel("Add one day trip");
      
      sideButtonsNewReservation = new ArrayList<>();
      sideButtonsInfo = new ArrayList<>();
      
      btnNr = 0;
   }

   public void addElements()
   {
      oneDayTripLabel.setBounds(509, 11, 180, 34);
      oneDayTripLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
      this.add(oneDayTripLabel);

      oneDayTripJFrameLabel.setBounds(65, 21, 148, 22);
      oneDayTripJFrameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
      this.add(oneDayTripJFrameLabel);

      addOneDayTripButton.setActionCommand(GUIMain.ADD_ONE_DAY_TRIP);
      addOneDayTripButton.setBounds(10, 11, 45, 45);
      addOneDayTripButton.setIcon(
            new ImageIcon("C:\\Users\\Chris\\Desktop\\studentsbutton.png"));
      addOneDayTripButton.setFont(addOneDayTripButton.getFont()
            .deriveFont(addOneDayTripButton.getFont().getSize() + 7f));
      this.add(addOneDayTripButton);

      scrollPaneOneDayTrip.setBounds(2, 75, 590, 311);
      this.add(scrollPaneOneDayTrip);

      
      String data[][] = { };
      String col[] = { "From", "To", "Date", "Time","Seats" };
      DefaultTableModel model = new DefaultTableModel(data, col);
      oneDayTripTourTable = new JTable(model);
      scrollPaneOneDayTrip.setViewportView(oneDayTripTourTable);
   }

   public void addActionListener(ActionListener listener)
   {
      addOneDayTripButton.addActionListener(listener);
   }
}