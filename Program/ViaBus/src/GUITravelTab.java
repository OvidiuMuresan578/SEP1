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

public class GUITravelTab extends JPanel
{

   private JLabel travelLabel;
   private JLabel travelJFrameLabel;
   private JButton addTravelButton;
   private JScrollPane scrollPaneTravel;
   private JTable travelTable;
   
   private ArrayList<JButton> sideButtonsNewReservation;
   private ArrayList<JButton> sideButtonsInfo;
   private int btnNr;
   private int boundsXNewReservation = 592;
   private int boundYNewReservation = 96;
   private int boundXInfo = 643;
   private int boundYInfo = 96;
   
   public GUITravelTab()
   {

      initializing();
      addElements();
      setVisible(true);
   }
   public void addRowTravel(Object data[], GUIHandler handler)
   {
      int numCols = travelTable.getModel().getColumnCount();
      int numRows = travelTable.getModel().getRowCount();
      Object[] cols = new Object[numCols];
      Object[] rows = new Object[numRows];
      cols[0] = data[0];
      cols[1] = data[1];
      cols[2] = data[3]+" " + data[2] + "-" + data[5] + " " + data[4];
      cols[3] = "NO SEATS";
      ((DefaultTableModel) travelTable.getModel()).addRow(cols);

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

      travelLabel = new JLabel("Travel");
      addTravelButton = new JButton();
      scrollPaneTravel = new JScrollPane();
     
      travelJFrameLabel = new JLabel("Add travel");
      sideButtonsNewReservation = new ArrayList<>();
      sideButtonsInfo = new ArrayList<>();
      
      btnNr = 0;
   }
   
   public void addElements()
   {
      setLayout(null);
      travelLabel.setBounds(598, 11, 91, 29);
      travelLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
      this.add(travelLabel);
      
     
      travelJFrameLabel.setBounds(65, 21, 148, 22);
      travelJFrameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
      this.add(travelJFrameLabel);

      
      addTravelButton.setActionCommand(GUIMain.ADD_TRAVEL);
      addTravelButton.setBounds(10, 11, 45, 45);
      addTravelButton.setIcon(
            new ImageIcon("C:\\Users\\Chris\\Desktop\\studentsbutton.png"));
      addTravelButton.setFont(addTravelButton.getFont()
            .deriveFont(addTravelButton.getFont().getSize() + 7f));
      this.add(addTravelButton);

      scrollPaneTravel.setBounds(2, 75, 590, 311);
      this.add(scrollPaneTravel);

      String data[][] = { };
      String col[] = { "From", "To", "Date & Time","Seats" };
      DefaultTableModel model = new DefaultTableModel(data, col);
      travelTable = new JTable(model);
      scrollPaneTravel.setViewportView(travelTable);
      
      scrollPaneTravel.setViewportView(travelTable);

   }
   
   
 

   
   public void addActionListener(ActionListener listener)
   {
      addTravelButton.addActionListener(listener);
   }
}
