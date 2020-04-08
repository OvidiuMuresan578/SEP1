import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIaddBus extends JFrame
{

   private JPanel contentPane;
   private JTextField busNumberField;
   private JTextField manufacturerField;
   private JTextField modelField;
   private JTextField manufacturingField;
   private JTextField colorField;
   private JTextField plateNumberField;
   private JTextField numberSeats;
   private JButton checkMapButton;
   private JCheckBox checkBox_1;
   private JCheckBox checkBox_2;
   private JCheckBox checkBox_3;
   private JCheckBox checkBox_4;
   private JCheckBox checkBox_5;
   private JCheckBox checkBox_6;
   private JCheckBox checkBox_7;
   private JCheckBox checkBox_8;
   private JCheckBox checkBox_9;
   private JCheckBox checkBox_10;
   private JCheckBox checkBox_11;
   private JCheckBox checkBox_12;
   private JCheckBox checkBox_13;
   private JCheckBox checkBox_14;
   private JCheckBox checkBox_15;
   private JCheckBox checkBox_16;
   private JCheckBox checkBox_17;
   private JCheckBox checkBox_18;
   private JCheckBox checkBox_19;
   private JCheckBox checkBox_20;
   private JCheckBox checkBox_21;
   private JCheckBox checkBox_22;
   private JCheckBox checkBox_23;
   private JCheckBox checkBox_24;
   private JCheckBox checkBox_25;
   private JCheckBox checkBox_26;
   private JCheckBox checkBox_27;
   private JCheckBox checkBox_28;
   private JCheckBox checkBox_29;
   private JCheckBox checkBox_30;
   private JCheckBox checkBox_31;
   private JCheckBox checkBox_32;
   private JCheckBox checkBox_33;
   private JCheckBox checkBox_34;
   private JCheckBox checkBox_35;
   private JCheckBox checkBox_36;
   private JCheckBox checkBox_37;
   private JCheckBox checkBox_38;
   private JCheckBox checkBox_39;
   private JCheckBox checkBox_40;
   private JCheckBox checkBox_41;
   private JCheckBox checkBox_42;
   private JCheckBox checkBox_43;
   private JCheckBox checkBox_44;
   private JCheckBox checkBox_45;
   private JCheckBox checkBox_46;
   private JCheckBox checkBox_47;
   private JCheckBox checkBox_48;
   private JCheckBox checkBox_49;
   private JCheckBox checkBox_50;
   private JCheckBox checkBox_51;
   private JCheckBox checkBox_52;
   private JCheckBox checkBox_53;
   private JCheckBox checkBox_54;
   private JCheckBox checkBox_55;
   private JCheckBox checkBox_56;
   private JCheckBox checkBox_57;
   private JCheckBox checkBox_58;
   private JCheckBox checkBox_59;
   private JCheckBox checkBox_60;
   private JCheckBox checkBox_61;
   private JCheckBox checkBox_62;
   private JCheckBox checkBox_63;
   private JCheckBox checkBox_64;
   private JCheckBox checkBox_65;
   private JCheckBox checkBox_66;
   private JCheckBox checkBox_67;
   private JCheckBox checkBox_68;
   private JButton saveButton;
   private JComboBox toilet;
   private JComboBox partyBus;
   private JLabel lblToilet;
   private JLabel lblPartyBus;
  
   
   public GUIaddBus()
   {
      super("Adding a new bus");
      initialize();
      addElements();
      checkMap();
      setVisible(false);

   }

   private void initialize()
   {
      modelField = new JTextField();
      colorField = new JTextField();
      numberSeats = new JTextField();
      
   }

   public void addActionListener(ActionListener listener)
   {
      saveButton.addActionListener(listener);
   }
   
   
   public Object[] getDataBus()
   {
      
      Object[] data = new Object[10];
      data[0] = modelField.getText();
      data[1] = colorField.getText();
      data[2] = numberSeats.getText();
      data[3] = partyBus.getSelectedItem();
      data[4] = toilet.getSelectedItem();
      
      
      return data;
   }

   
   private void checkMap()
   {

      checkMapButton.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
            checkBoxes.add(checkBox_1);
            checkBoxes.add(checkBox_2);
            checkBoxes.add(checkBox_3);
            checkBoxes.add(checkBox_4);
            checkBoxes.add(checkBox_5);
            checkBoxes.add(checkBox_6);
            checkBoxes.add(checkBox_7);
            checkBoxes.add(checkBox_8);
            checkBoxes.add(checkBox_9);
            checkBoxes.add(checkBox_10);
            checkBoxes.add(checkBox_11);
            checkBoxes.add(checkBox_12);
            checkBoxes.add(checkBox_13);
            checkBoxes.add(checkBox_14);
            checkBoxes.add(checkBox_15);
            checkBoxes.add(checkBox_16);
            checkBoxes.add(checkBox_17);
            checkBoxes.add(checkBox_18);
            checkBoxes.add(checkBox_19);
            checkBoxes.add(checkBox_20);
            checkBoxes.add(checkBox_21);
            checkBoxes.add(checkBox_22);
            checkBoxes.add(checkBox_23);
            checkBoxes.add(checkBox_24);
            checkBoxes.add(checkBox_25);
            checkBoxes.add(checkBox_26);
            checkBoxes.add(checkBox_27);
            checkBoxes.add(checkBox_28);
            checkBoxes.add(checkBox_28);
            checkBoxes.add(checkBox_30);
            checkBoxes.add(checkBox_31);
            checkBoxes.add(checkBox_32);
            checkBoxes.add(checkBox_33);
            checkBoxes.add(checkBox_34);
            checkBoxes.add(checkBox_35);
            checkBoxes.add(checkBox_36);
            checkBoxes.add(checkBox_37);
            checkBoxes.add(checkBox_38);
            checkBoxes.add(checkBox_39);
            checkBoxes.add(checkBox_40);
            checkBoxes.add(checkBox_41);
            checkBoxes.add(checkBox_42);
            checkBoxes.add(checkBox_43);
            checkBoxes.add(checkBox_44);
            checkBoxes.add(checkBox_45);
            checkBoxes.add(checkBox_46);
            checkBoxes.add(checkBox_47);
            checkBoxes.add(checkBox_48);
            checkBoxes.add(checkBox_49);
            checkBoxes.add(checkBox_50);
            checkBoxes.add(checkBox_51);
            checkBoxes.add(checkBox_52);
            checkBoxes.add(checkBox_53);
            checkBoxes.add(checkBox_54);
            checkBoxes.add(checkBox_55);
            checkBoxes.add(checkBox_56);
            checkBoxes.add(checkBox_57);
            checkBoxes.add(checkBox_58);
            checkBoxes.add(checkBox_59);
            checkBoxes.add(checkBox_60);
            checkBoxes.add(checkBox_61);
            checkBoxes.add(checkBox_62);
            checkBoxes.add(checkBox_63);
            checkBoxes.add(checkBox_64);
            checkBoxes.add(checkBox_65);
            checkBoxes.add(checkBox_66);
            checkBoxes.add(checkBox_67);
            checkBoxes.add(checkBox_68);
            

            String temp = numberSeats.getText();
            int checkNumber = Integer.parseInt(temp);

            ArrayList<JCheckBox> countSelectedBoxes = new ArrayList<>();

            for (int i = 0; i < checkBoxes.size(); i++)
            {
               if (checkBoxes.get(i).isSelected())
               {
                  countSelectedBoxes.add(checkBoxes.get(i));
               }

            }

            if (countSelectedBoxes.size() < checkNumber)
            {
               JOptionPane.showMessageDialog(null,
                     "You selected less seats than you inputed");
            }
            else if (countSelectedBoxes.size() > checkNumber)
            {
               JOptionPane.showMessageDialog(null,
                     "You selected more seats than you inputed");
            }
            
         }
      });

   }

   public void addElements()
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 720, 370);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JLabel lblNewLabel = new JLabel("Adding a new bus");
      lblNewLabel.setBounds(10, 11, 137, 20);
      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
      contentPane.add(lblNewLabel);

      JLabel lblBusNumber = new JLabel("Bus number:");
      lblBusNumber.setBounds(10, 60, 77, 14);
      lblBusNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
      contentPane.add(lblBusNumber);

      busNumberField = new JTextField();
      busNumberField.setBounds(129, 58, 101, 20);
      contentPane.add(busNumberField);
      busNumberField.setColumns(10);

      JLabel lblManufacturer = new JLabel("Manufacturer:");
      lblManufacturer.setBounds(10, 85, 77, 14);
      lblManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 12));
      contentPane.add(lblManufacturer);

      manufacturerField = new JTextField();
      manufacturerField.setBounds(129, 83, 101, 20);
      manufacturerField.setColumns(10);
      contentPane.add(manufacturerField);

      JLabel lblModel = new JLabel("Model:");
      lblModel.setBounds(10, 110, 46, 14);
      lblModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
      contentPane.add(lblModel);

      
      modelField.setBounds(129, 108, 101, 20);
      modelField.setColumns(10);
      contentPane.add(modelField);

      JLabel lblManufacturingYear = new JLabel("Manufacturing year:");
      lblManufacturingYear.setBounds(10, 135, 113, 14);
      lblManufacturingYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
      contentPane.add(lblManufacturingYear);

      manufacturingField = new JTextField();
      manufacturingField.setBounds(129, 133, 101, 20);
      manufacturingField.setColumns(10);
      contentPane.add(manufacturingField);

      JLabel lblColor = new JLabel("Color:");
      lblColor.setBounds(10, 160, 101, 14);
      lblColor.setHorizontalAlignment(SwingConstants.LEFT);
      lblColor.setVerticalAlignment(SwingConstants.BOTTOM);
      lblColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
      contentPane.add(lblColor);

      
      colorField.setBounds(129, 157, 101, 20);
      colorField.setColumns(10);
      contentPane.add(colorField);

      JLabel lblPlateNumber = new JLabel("Plate number:");
      lblPlateNumber.setBounds(10, 185, 84, 14);
      lblPlateNumber.setVerticalAlignment(SwingConstants.BOTTOM);
      lblPlateNumber.setHorizontalAlignment(SwingConstants.LEFT);
      lblPlateNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
      contentPane.add(lblPlateNumber);

      plateNumberField = new JTextField();
      plateNumberField.setBounds(129, 182, 101, 20);
      plateNumberField.setColumns(10);
      contentPane.add(plateNumberField);

      JLabel lblNumberOfSeats = new JLabel("Number of seats:");
      lblNumberOfSeats.setBounds(10, 211, 101, 14);
      lblNumberOfSeats.setVerticalAlignment(SwingConstants.BOTTOM);
      lblNumberOfSeats.setHorizontalAlignment(SwingConstants.LEFT);
      lblNumberOfSeats.setFont(new Font("Tahoma", Font.PLAIN, 12));
      contentPane.add(lblNumberOfSeats);

      
      numberSeats.setBounds(129, 208, 32, 20);
      numberSeats.setColumns(10);
      contentPane.add(numberSeats);

      saveButton = new JButton("SAVE");
      saveButton.setActionCommand(GUIMain.SAVE_BUTTON_BUS);
      saveButton.setBounds(605, 286, 86, 34);
      saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
      contentPane.add(saveButton);

      JSeparator separator = new JSeparator();
      separator.setBounds(289, 29, 2, 263);
      separator.setOrientation(SwingConstants.VERTICAL);
      contentPane.add(separator);

      checkMapButton = new JButton("Check map");

      checkMapButton.setBounds(563, 232, 128, 23);
      contentPane.add(checkMapButton);

      JLabel lblSeatsMap = new JLabel("Seats map");
      lblSeatsMap.setBounds(301, 32, 70, 14);
      lblSeatsMap.setFont(new Font("Tahoma", Font.BOLD, 12));
      contentPane.add(lblSeatsMap);

      JLabel lblPleaseCheckThe = new JLabel(
            "Please check the boxes where the seats are located");
      lblPleaseCheckThe.setBounds(301, 57, 293, 14);
      lblPleaseCheckThe.setFont(new Font("Tahoma", Font.PLAIN, 12));
      contentPane.add(lblPleaseCheckThe);

      JLabel lblNewLabel_3 = new JLabel("");
      lblNewLabel_3.setBounds(302, 185, 21, 23);
      lblNewLabel_3.setIcon(
            new ImageIcon("C:\\Users\\Chris\\Desktop\\steering_wheel.png"));
      contentPane.add(lblNewLabel_3);

      checkBox_1 = new JCheckBox("");
      checkBox_1.setBounds(302, 156, 21, 23);
      contentPane.add(checkBox_1);

      JLabel lblAisle = new JLabel("Aisle");
      lblAisle.setBounds(339, 136, 32, 14);
      contentPane.add(lblAisle);

      JLabel label = new JLabel("Aisle");
      label.setBounds(429, 136, 32, 14);
      contentPane.add(label);

      checkBox_9 = new JCheckBox("");
      checkBox_9.setBounds(325, 156, 21, 23);
      contentPane.add(checkBox_9);

      checkBox_10 = new JCheckBox("");
      checkBox_10.setBounds(325, 181, 21, 23);
      contentPane.add(checkBox_10);

      checkBox_11 = new JCheckBox("");
      checkBox_11.setBounds(350, 181, 21, 23);
      contentPane.add(checkBox_11);

      checkBox_12 = new JCheckBox("");
      checkBox_12.setBounds(349, 156, 21, 23);
      contentPane.add(checkBox_12);

      checkBox_14 = new JCheckBox("");
      checkBox_14.setBounds(371, 156, 21, 23);
      contentPane.add(checkBox_14);

      checkBox_15 = new JCheckBox("");
      checkBox_15.setBounds(371, 181, 21, 23);
      contentPane.add(checkBox_15);

      checkBox_16 = new JCheckBox("");
      checkBox_16.setBounds(394, 181, 21, 23);
      contentPane.add(checkBox_16);

      checkBox_17 = new JCheckBox("");
      checkBox_17.setBounds(394, 157, 21, 23);
      contentPane.add(checkBox_17);

      checkBox_18 = new JCheckBox("");
      checkBox_18.setBounds(417, 181, 21, 23);
      contentPane.add(checkBox_18);

      checkBox_20 = new JCheckBox("");
      checkBox_20.setBounds(417, 156, 21, 23);
      contentPane.add(checkBox_20);

      checkBox_21 = new JCheckBox("");
      checkBox_21.setBounds(440, 181, 21, 23);
      contentPane.add(checkBox_21);

      checkBox_22 = new JCheckBox("");
      checkBox_22.setBounds(440, 156, 21, 23);
      contentPane.add(checkBox_22);

      checkBox_23 = new JCheckBox("");
      checkBox_23.setBounds(463, 181, 21, 23);
      contentPane.add(checkBox_23);

      checkBox_24 = new JCheckBox("");
      checkBox_24.setBounds(463, 156, 21, 23);
      contentPane.add(checkBox_24);

      checkBox_25 = new JCheckBox("");
      checkBox_25.setBounds(486, 181, 21, 23);
      contentPane.add(checkBox_25);

      checkBox_26 = new JCheckBox("");
      checkBox_26.setBounds(486, 156, 21, 23);
      contentPane.add(checkBox_26);

      checkBox_27 = new JCheckBox("");
      checkBox_27.setBounds(509, 181, 21, 23);
      contentPane.add(checkBox_27);

      checkBox_28 = new JCheckBox("");
      checkBox_28.setBounds(509, 156, 21, 23);
      contentPane.add(checkBox_28);

      checkBox_29 = new JCheckBox("");
      checkBox_29.setBounds(532, 181, 21, 23);
      contentPane.add(checkBox_29);

      checkBox_30 = new JCheckBox("");
      checkBox_30.setBounds(532, 156, 21, 23);
      contentPane.add(checkBox_30);

      checkBox_31 = new JCheckBox("");
      checkBox_31.setBounds(555, 181, 21, 23);
      contentPane.add(checkBox_31);

      checkBox_32 = new JCheckBox("");
      checkBox_32.setBounds(555, 156, 21, 23);
      contentPane.add(checkBox_32);

      checkBox_33 = new JCheckBox("");
      checkBox_33.setBounds(578, 181, 21, 23);
      contentPane.add(checkBox_33);

      checkBox_34 = new JCheckBox("");
      checkBox_34.setBounds(578, 156, 21, 23);
      contentPane.add(checkBox_34);

      checkBox_35 = new JCheckBox("");
      checkBox_35.setBounds(601, 181, 21, 23);
      contentPane.add(checkBox_35);

      checkBox_36 = new JCheckBox("");
      checkBox_36.setBounds(601, 156, 21, 23);
      contentPane.add(checkBox_36);

      checkBox_37 = new JCheckBox("");
      checkBox_37.setBounds(624, 181, 21, 23);
      contentPane.add(checkBox_37);

      checkBox_38 = new JCheckBox("");
      checkBox_38.setBounds(624, 156, 21, 23);
      contentPane.add(checkBox_38);

      checkBox_39 = new JCheckBox("");
      checkBox_39.setBounds(647, 181, 21, 23);
      contentPane.add(checkBox_39);

      checkBox_40 = new JCheckBox("");
      checkBox_40.setBounds(647, 156, 21, 23);
      contentPane.add(checkBox_40);

      checkBox_41 = new JCheckBox("");
      checkBox_41.setBounds(670, 156, 21, 23);
      contentPane.add(checkBox_41);

      checkBox_42 = new JCheckBox("");
      checkBox_42.setBounds(670, 181, 21, 23);
      contentPane.add(checkBox_42);

      checkBox_2 = new JCheckBox("");
      checkBox_2.setBounds(302, 85, 21, 23);
      contentPane.add(checkBox_2);

      checkBox_3 = new JCheckBox("");
      checkBox_3.setBounds(302, 110, 21, 23);
      contentPane.add(checkBox_3);

      checkBox_4 = new JCheckBox("");
      checkBox_4.setBounds(326, 85, 21, 23);
      contentPane.add(checkBox_4);

      checkBox_5 = new JCheckBox("");
      checkBox_5.setBounds(327, 110, 21, 23);
      contentPane.add(checkBox_5);

      checkBox_6 = new JCheckBox("");
      checkBox_6.setBounds(348, 110, 21, 23);
      contentPane.add(checkBox_6);

      checkBox_7 = new JCheckBox("");
      checkBox_7.setBounds(348, 85, 21, 23);
      contentPane.add(checkBox_7);

      checkBox_8 = new JCheckBox("");
      checkBox_8.setBounds(371, 86, 21, 23);
      contentPane.add(checkBox_8);

      checkBox_13 = new JCheckBox("");
      checkBox_13.setBounds(371, 110, 21, 23);
      contentPane.add(checkBox_13);

      checkBox_19 = new JCheckBox("");
      checkBox_19.setBounds(394, 85, 21, 23);
      contentPane.add(checkBox_19);

      checkBox_43 = new JCheckBox("");
      checkBox_43.setBounds(394, 110, 21, 23);
      contentPane.add(checkBox_43);

      checkBox_44 = new JCheckBox("");
      checkBox_44.setBounds(417, 110, 21, 23);
      contentPane.add(checkBox_44);

      checkBox_45 = new JCheckBox("");
      checkBox_45.setBounds(417, 85, 21, 23);
      contentPane.add(checkBox_45);

      checkBox_46 = new JCheckBox("");
      checkBox_46.setBounds(440, 85, 21, 23);
      contentPane.add(checkBox_46);

      checkBox_47 = new JCheckBox("");
      checkBox_47.setBounds(440, 110, 21, 23);
      contentPane.add(checkBox_47);

      checkBox_48 = new JCheckBox("");
      checkBox_48.setBounds(463, 110, 21, 23);
      contentPane.add(checkBox_48);

      checkBox_49 = new JCheckBox("");
      checkBox_49.setBounds(463, 85, 21, 23);
      contentPane.add(checkBox_49);

      checkBox_50 = new JCheckBox("");
      checkBox_50.setBounds(486, 85, 21, 23);
      contentPane.add(checkBox_50);

      checkBox_51 = new JCheckBox("");
      checkBox_51.setBounds(486, 110, 21, 23);
      contentPane.add(checkBox_51);

      checkBox_52 = new JCheckBox("");
      checkBox_52.setBounds(510, 85, 21, 23);
      contentPane.add(checkBox_52);

      checkBox_53 = new JCheckBox("");
      checkBox_53.setBounds(511, 110, 21, 23);
      contentPane.add(checkBox_53);

      checkBox_54 = new JCheckBox("");
      checkBox_54.setBounds(532, 110, 21, 23);
      contentPane.add(checkBox_54);

      checkBox_55 = new JCheckBox("");
      checkBox_55.setBounds(532, 85, 21, 23);
      contentPane.add(checkBox_55);

      checkBox_56 = new JCheckBox("");
      checkBox_56.setBounds(555, 86, 21, 23);
      contentPane.add(checkBox_56);

      checkBox_57 = new JCheckBox("");
      checkBox_57.setBounds(555, 110, 21, 23);
      contentPane.add(checkBox_57);

      checkBox_58 = new JCheckBox("");
      checkBox_58.setBounds(578, 85, 21, 23);
      contentPane.add(checkBox_58);

      checkBox_59 = new JCheckBox("");
      checkBox_59.setBounds(578, 110, 21, 23);
      contentPane.add(checkBox_59);

      checkBox_60 = new JCheckBox("");
      checkBox_60.setBounds(601, 110, 21, 23);
      contentPane.add(checkBox_60);

      checkBox_61 = new JCheckBox("");
      checkBox_61.setBounds(601, 85, 21, 23);
      contentPane.add(checkBox_61);

      checkBox_62 = new JCheckBox("");
      checkBox_62.setBounds(624, 85, 21, 23);
      contentPane.add(checkBox_62);

      checkBox_63 = new JCheckBox("");
      checkBox_63.setBounds(624, 110, 21, 23);
      contentPane.add(checkBox_63);

      checkBox_64 = new JCheckBox("");
      checkBox_64.setBounds(647, 110, 21, 23);
      contentPane.add(checkBox_64);

      checkBox_65 = new JCheckBox("");
      checkBox_65.setBounds(647, 85, 21, 23);
      contentPane.add(checkBox_65);

      checkBox_66 = new JCheckBox("");
      checkBox_66.setBounds(670, 85, 21, 23);
      contentPane.add(checkBox_66);

      checkBox_67 = new JCheckBox("");
      checkBox_67.setBounds(670, 110, 21, 23);
      contentPane.add(checkBox_67);

      checkBox_68 = new JCheckBox("");
      checkBox_68.setBounds(670, 132, 21, 23);
      contentPane.add(checkBox_68);

      JLabel label_1 = new JLabel("Aisle");
      label_1.setBounds(521, 136, 32, 14);
      contentPane.add(label_1);

      JLabel label_2 = new JLabel("Aisle");
      label_2.setBounds(601, 136, 32, 14);
      contentPane.add(label_2);
      
      toilet = new JComboBox();
      toilet.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
      toilet.setBounds(129, 233, 46, 20);
      contentPane.add(toilet);
      
      partyBus = new JComboBox();
      partyBus.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
      partyBus.setBounds(129, 263, 46, 20);
      contentPane.add(partyBus);
      
      lblToilet = new JLabel("Toilet:");
      lblToilet.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblToilet.setBounds(65, 241, 46, 14);
      contentPane.add(lblToilet);
      
      lblPartyBus = new JLabel("Party bus:");
      lblPartyBus.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblPartyBus.setBounds(53, 265, 70, 14);
      contentPane.add(lblPartyBus);

   }
}
