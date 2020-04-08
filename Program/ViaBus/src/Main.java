public class Main
{
   public static void main(String[] args) 
   {
      ViaBusCompanyModelManager model = new ViaBusCompanyModelManager();
      GUIMain gui = new GUIMain();
      ViaBusController controller = new ViaBusController(model, gui);
      gui.startGUI(controller);
   }

}
