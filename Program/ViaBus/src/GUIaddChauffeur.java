import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIaddChauffeur extends JFrame
{

   private JPanel contentPane;
   private JTextField employeeId;
   private JTextField fullNameField;
   private JTextField addressField;
   private JTextField phoneNumberField;
   private JButton saveButton;
   private JTextField emailAddressField;
   private JComboBox fullTime;
  
   public GUIaddChauffeur()
   {
      super("Add a chauffeur");
      addElements();
     
      setVisible(false);
   }
   
   

   public void addActionListener(ActionListener listener)
   {
      saveButton.addActionListener(listener);
   }
   public Object[] getDataChaffeur()
   {
      
      Object[] data = new Object[10];
      data[0] = fullNameField.getText();
      data[1] = employeeId.getText();
      data[2] = phoneNumberField.getText();
      data[3] = emailAddressField.getText();
      data[4] = fullTime.getSelectedItem();
      
      
      return data;
   }

   public void addElements()
   {
      setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      setBounds(100, 100, 330, 401);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblAddingANew = new JLabel("Adding a new chauffeur");
      lblAddingANew.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblAddingANew.setBounds(10, 11, 175, 19);
      contentPane.add(lblAddingANew);
      
      JLabel lblEmployeeId = new JLabel("Employee ID:");
      lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblEmployeeId.setBounds(10, 61, 73, 14);
      contentPane.add(lblEmployeeId);
      
      employeeId = new JTextField();
      employeeId.setBounds(108, 59, 86, 20);
      contentPane.add(employeeId);
      employeeId.setColumns(10);
      
      JLabel lblFullName = new JLabel("Full name:");
      lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblFullName.setBounds(10, 88, 73, 14);
      contentPane.add(lblFullName);
      
      fullNameField = new JTextField();
      fullNameField.setColumns(10);
      fullNameField.setBounds(108, 86, 86, 20);
      contentPane.add(fullNameField);
      
      JLabel lblAddress = new JLabel("Address:");
      lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblAddress.setBounds(10, 115, 73, 14);
      contentPane.add(lblAddress);
      
      addressField = new JTextField();
      addressField.setColumns(10);
      addressField.setBounds(108, 113, 86, 20);
      contentPane.add(addressField);
      
      JLabel lblPhoneNumber = new JLabel("Phone number:");
      lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblPhoneNumber.setBounds(10, 140, 88, 14);
      contentPane.add(lblPhoneNumber);
      
      phoneNumberField = new JTextField();
      phoneNumberField.setColumns(10);
      phoneNumberField.setBounds(108, 138, 86, 20);
      contentPane.add(phoneNumberField);
      
      JLabel lblWishesForTrips = new JLabel("Wishes for trips:");
      lblWishesForTrips.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblWishesForTrips.setBounds(10, 225, 88, 14);
      contentPane.add(lblWishesForTrips);
      
      JTextPane wishesTripText = new JTextPane();
      wishesTripText.setBounds(10, 252, 184, 60);
      contentPane.add(wishesTripText);
      
      
      saveButton = new JButton("SAVE");
      saveButton.setActionCommand(GUIMain.SAVE_BUTTON_CHAUFFEUR);
      saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
      saveButton.setBounds(218, 318, 86, 34);
      contentPane.add(saveButton);
      
      JLabel lblEmailaddres = new JLabel("Email address:");
      lblEmailaddres.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblEmailaddres.setBounds(10, 165, 88, 14);
      contentPane.add(lblEmailaddres);
      
      emailAddressField = new JTextField();
      emailAddressField.setColumns(10);
      emailAddressField.setBounds(108, 163, 86, 20);
      contentPane.add(emailAddressField);
      
      fullTime = new JComboBox();
      fullTime.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
      fullTime.setBounds(108, 189, 86, 20);
      contentPane.add(fullTime);
      
      JLabel lblFullTime = new JLabel("Full time:");
      lblFullTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
      lblFullTime.setBounds(10, 190, 88, 14);
      contentPane.add(lblFullTime);
   }
}
