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

public class GUIBusAndChauffeurTab extends JPanel
{

   private JLabel busAndChauffeurLabel;
   private JLabel busAndChauffeurJLabelLabel;
   private JButton addBusAndChauffeurButton;
   private JScrollPane scrollPaneBusAndChauffeur;
   private JTable busAndChauffeurTabel;
   
   private ArrayList<JButton> sideButtonsInfo;
   private int btnNr;
   private int boundXInfo = 643;
   private int boundYInfo = 96;
   
   public GUIBusAndChauffeurTab()
   {

      initializing();
      addElements();
      setVisible(true);
   }

  

   public void addRowBusAndChaffeur(Object data[], GUIHandler handler)
   {
      

      int numCols = busAndChauffeurTabel.getModel().getColumnCount();
      int numRows = busAndChauffeurTabel.getModel().getRowCount();
      Object[] cols = new Object[numCols];
      Object[]rows = new Object[numRows];
      cols[0] = data[0];
      cols[1] = data[1];
      cols[2] = data[2];
      cols[3] = data[4] + " " + data[5] +"-" + data[3] + " " +data[6];
      cols[4] = "NO SEATS";
      ((DefaultTableModel) busAndChauffeurTabel.getModel()).addRow(cols);

           
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
      sideButtonsInfo.get(btnNr).setActionCommand(GUIMain.INFO_BUS_AND_CHAFFEUR+ btnNr);
      
      boundYInfo = boundYInfo + 16;
      
       sideButtonsInfo.get(btnNr).addActionListener(handler);
   }
   
   public void initializing()
   {

      busAndChauffeurLabel = new JLabel("Bus-and-chauffeur");
      addBusAndChauffeurButton = new JButton();
      scrollPaneBusAndChauffeur = new JScrollPane();
      busAndChauffeurTabel = new JTable();
      busAndChauffeurJLabelLabel = new JLabel("Add bus-and-chauffeur");
      
      sideButtonsInfo = new ArrayList<>();
      btnNr = 0;
   }
   
      
   public void addElements()
   {
      setLayout(null);
      busAndChauffeurLabel.setBounds(441, 11, 248, 37);
      busAndChauffeurLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
      this.add(busAndChauffeurLabel);
      
     
      busAndChauffeurJLabelLabel.setBounds(65, 21, 201, 25);
      busAndChauffeurJLabelLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
      this.add(busAndChauffeurJLabelLabel);

      addBusAndChauffeurButton.setActionCommand(GUIMain.ADD_BUS_AND_CHAUFFEUR);
      addBusAndChauffeurButton.setBounds(10, 11, 45, 45);
      addBusAndChauffeurButton.setIcon(
            new ImageIcon("C:\\Users\\Chris\\Desktop\\studentsbutton.png"));
      addBusAndChauffeurButton.setFont(addBusAndChauffeurButton.getFont()
            .deriveFont(addBusAndChauffeurButton.getFont().getSize() + 7f));
      this.add(addBusAndChauffeurButton);

      scrollPaneBusAndChauffeur.setBounds(2, 75, 590, 311);
      this.add(scrollPaneBusAndChauffeur);

      busAndChauffeurTabel = new JTable();
      busAndChauffeurTabel.setModel(new DefaultTableModel(new Object[][] {},
            new String[] { "Customer", "From", "To", "Date & Time", "Seats"
         })
      );
      
      scrollPaneBusAndChauffeur.setViewportView(busAndChauffeurTabel);

   }
   public void addActionListener(ActionListener listener)
   {
      addBusAndChauffeurButton.addActionListener(listener);
   }
}
