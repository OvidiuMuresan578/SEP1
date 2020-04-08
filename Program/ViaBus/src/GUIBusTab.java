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

public class GUIBusTab extends JPanel
{

   private JLabel busLabel;
   private JLabel busJLabelLabel;
   private JButton addBusButton;
   private JScrollPane scrollPaneBus;
   private JTable busTabel;
   
   private ArrayList<JButton> sideButtonsInfo;
   private int btnNr;
   private int boundXInfo = 643;
   private int boundYInfo = 96;
   
   public GUIBusTab()
   {

      initializing();
      addElements();
      setVisible(true);
   }

   public void addRowBus(Object data[], GUIHandler handler)
   {
      

      int numCols = busTabel.getModel().getColumnCount();
      int numRows = busTabel.getModel().getRowCount();
      Object[] cols = new Object[numCols];
      Object[]rows = new Object[numRows];
      cols[0] = data[0];
      cols[1] = data[1];
      cols[2] = data[2];
      cols[3] = data[3];
      cols[4] = data[4];
      ((DefaultTableModel) busTabel.getModel()).addRow(cols);

           
      this.addButtonsChaffeur(handler);
      btnNr++;

   }
   
   public void addButtonsChaffeur(GUIHandler handler)
   {
           
   // Info button
      sideButtonsInfo.add(new JButton(btnNr + ""));
      this.add(sideButtonsInfo.get(btnNr));
      sideButtonsInfo.get(btnNr).setBounds(boundXInfo, boundYInfo, 50,
            16);
      sideButtonsInfo.get(btnNr)
            .setIcon(new ImageIcon("C:\\Users\\Chris\\Desktop\\info.png"));
      sideButtonsInfo.get(btnNr)
            .setToolTipText("Information about this tour");
      sideButtonsInfo.get(btnNr).setActionCommand(GUIMain.INFO_BUS + btnNr);
      
      boundYInfo = boundYInfo + 16;
      
       sideButtonsInfo.get(btnNr).addActionListener(handler);
   }
   
   
   public void initializing()
   {

      busLabel = new JLabel("Busses");
      addBusButton = new JButton();
      scrollPaneBus = new JScrollPane();
      busTabel = new JTable();
      busJLabelLabel = new JLabel("Add a bus");
     
      sideButtonsInfo = new ArrayList<>();
      btnNr = 0;
   }
   

   public void addElements()
   {
      setLayout(null);
      busLabel.setBounds(599, 11, 90, 37);
      busLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
      this.add(busLabel);
      
     
      busJLabelLabel.setBounds(65, 21, 88, 25);
      busJLabelLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
      this.add(busJLabelLabel);

      addBusButton.setActionCommand(GUIMain.ADD_BUS);
      addBusButton.setBounds(10, 11, 45, 45);
      addBusButton.setIcon(
            new ImageIcon("C:\\Users\\Chris\\Desktop\\studentsbutton.png"));
      addBusButton.setFont(addBusButton.getFont()
            .deriveFont(addBusButton.getFont().getSize() + 7f));
      this.add(addBusButton);

      scrollPaneBus.setBounds(2, 75, 590, 311);
      this.add(scrollPaneBus);

      busTabel = new JTable();
      busTabel.setModel(new DefaultTableModel(new Object[][] {},
            new String[] { "Bus model", "Color","Seats", "Party bus", "Toilet"
         })
      );
      
      scrollPaneBus.setViewportView(busTabel);

   }
   public void addActionListener(ActionListener listener)
   {
      addBusButton.addActionListener(listener);
   }
}
