import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIHandler implements ActionListener
{
   private GUIMain gui;
   private ViaBusController controller;
   

   public GUIHandler(GUIMain gui, ViaBusController controller)
   {
      this.gui = gui;
      this.controller = controller;
   }
   

   public void actionPerformed(ActionEvent event)
   {
      String mode = event.getActionCommand();
      controller.execute(mode);
   }
}