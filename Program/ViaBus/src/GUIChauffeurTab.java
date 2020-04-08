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

public class GUIChauffeurTab extends JPanel
{

   private JLabel chauffeurLabel;
   private JLabel chauffeurJLabelLabel;
   private JButton addChauffeurButton;
   private JScrollPane scrollPaneChauffeur;
   private JTable chauffeurTabel;
   
   private ArrayList<JButton> sideButtonsInfo;
   private int btnNr;
   private int boundXInfo = 643;
   private int boundYInfo = 96;
   
   public GUIChauffeurTab()
   {

      initializing();
      addElements();
      setVisible(true);
   }

   public void addRowChaffeur(Object data[], GUIHandler handler)
   {
      

      int numCols = chauffeurTabel.getModel().getColumnCount();
      int numRows = chauffeurTabel.getModel().getRowCount();
      Object[] cols = new Object[numCols];
      Object[]rows = new Object[numRows];
      cols[0] = data[0];
      cols[1] = data[1];
      cols[2] = data[2];
      cols[3] = data[3];
      cols[4] = data[4];
      ((DefaultTableModel) chauffeurTabel.getModel()).addRow(cols);

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
      sideButtonsInfo.get(btnNr).setActionCommand(GUIMain.INFO_CHAFFEUR + btnNr);
      
      boundYInfo = boundYInfo + 16;
      
       sideButtonsInfo.get(btnNr).addActionListener(handler);
   }
   
   public void initializing()
   {

      chauffeurLabel = new JLabel("Chauffeurs");
      addChauffeurButton = new JButton();
      scrollPaneChauffeur = new JScrollPane();
      chauffeurTabel = new JTable();
      chauffeurJLabelLabel = new JLabel("Add a chauffeur");
      
      sideButtonsInfo = new ArrayList<>();
      btnNr = 0;
   }

   
   public void addElements()
   {
      setLayout(null);
      chauffeurLabel.setBounds(544, 11, 145, 37);
      chauffeurLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
      this.add(chauffeurLabel);
      
     
      chauffeurJLabelLabel.setBounds(65, 21, 145, 25);
      chauffeurJLabelLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
      this.add(chauffeurJLabelLabel);

      addChauffeurButton.setActionCommand(GUIMain.ADD_CHAUFFEUR);
      addChauffeurButton.setBounds(10, 11, 45, 45);
      addChauffeurButton.setIcon(
            new ImageIcon("C:\\Users\\Chris\\Desktop\\studentsbutton.png"));
      addChauffeurButton.setFont(addChauffeurButton.getFont()
            .deriveFont(addChauffeurButton.getFont().getSize() + 7f));
      this.add(addChauffeurButton);

      scrollPaneChauffeur.setBounds(2, 75, 590, 311);
      this.add(scrollPaneChauffeur);

      chauffeurTabel = new JTable();
      chauffeurTabel.setModel(new DefaultTableModel(new Object[][] {},
            new String[] { "Name", "ID", "Phone number", "Email address", "Full time"
         })
      );
      
      scrollPaneChauffeur.setViewportView(chauffeurTabel);

   }
   public void addActionListener(ActionListener listener)
   {
      addChauffeurButton.addActionListener(listener);
   }
   
}
