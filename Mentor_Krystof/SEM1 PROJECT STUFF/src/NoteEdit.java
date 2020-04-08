import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * Window that pops up after a checked in booking is selected and the Edit Note button is pressed
 * Allows for editing and saving the note
 * @author Sujan Varma
 *
 */
public class NoteEdit extends JFrame
{
   
   JTextArea text;
   JButton save;
   
   JPanel textP;
   JPanel buttonP;
   JScrollPane pane;
   
   ActionListener listener;
   NoteEdit thiswindow;
   Booking edited;
   
   /**
    * Constructor that creates the window, takes the booking which's note is edited as argument
    * @param b the booking which's note is edited
    */
   public NoteEdit(Booking b)
   {
      super("Editing note");
      
      edited = b;
      text = new JTextArea();
      text.setText(edited.getNote());
      text.setAutoscrolls(true);
      
      pane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      
      pane.setPreferredSize(new Dimension(400, 220));
      
      
      textP = new JPanel();
      textP.add(pane);
      
      save = new JButton("Save");
      
      listener = new ButtonListener();
      
      save.addActionListener(listener);
      
      buttonP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      
      buttonP.add(save);
      
      setBounds(61, 11, 81, 140);
      getContentPane().setLayout(
            new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)
        );
      
      add(textP);
      add(buttonP);
      
      setSize(450, 310);
      setVisible(true);
      setLocationRelativeTo(null);
      
      
      thiswindow = this;
   }
   /**
    * saves the note and closes the window once the button is pressed
    *
    */
   private class ButtonListener implements ActionListener
   {

      @Override
      public void actionPerformed(ActionEvent e)
      {
         edited.setNote(text.getText());
         
         thiswindow.dispose();
      }
      
   }
   
   
}