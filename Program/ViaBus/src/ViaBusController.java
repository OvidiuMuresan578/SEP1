public class ViaBusController
{
   private ViaBusCompanyModelManager modelManager;
   private GUIMain viaBusGUI;

   public ViaBusController(ViaBusCompanyModelManager modelManager, GUIMain viaBusGUI)
   {
      this.modelManager = modelManager;
      this.viaBusGUI = viaBusGUI;
   }

   public void execute(String mode)
   {
      if(mode.contains(GUIMain.ADD_NEW_RESERVATION))
      {
         int index = Integer.parseInt(mode.replaceAll(GUIMain.ADD_NEW_RESERVATION, ""));
         mode = mode.replaceAll((index + ""), "");
      }
      if(mode.contains(GUIMain.INFO))
      {
         int index = Integer.parseInt(mode.replaceAll(GUIMain.INFO, ""));
         mode = mode.replaceAll((index + ""), "");
      }
      if(mode.contains(GUIMain.INFO_CHAFFEUR))
      {
         int index = Integer.parseInt(mode.replaceAll(GUIMain.INFO_CHAFFEUR, ""));
         mode = mode.replaceAll((index + ""), "");
      }
      if(mode.contains(GUIMain.INFO_BUS))
      {
         int index = Integer.parseInt(mode.replaceAll(GUIMain.INFO_BUS, ""));
         mode = mode.replaceAll((index + ""), "");
      }
     if(mode.contains(GUIMain.INFO_BUS_AND_CHAFFEUR))
     {
        int index = Integer.parseInt(mode.replaceAll(GUIMain.INFO_BUS_AND_CHAFFEUR, ""));
        mode = mode.replaceAll((index + ""), "");
     }
      
      switch (mode)
      {
         case GUIMain.ADD_ONE_DAY_TRIP:
            viaBusGUI.open(GUIMain.ADD_ONE_DAY_TRIP);
            break;
         case GUIMain.ADD_TRAVEL:
            viaBusGUI.open(GUIMain.ADD_TRAVEL);
            break;
         case GUIMain.ADD_BUS_AND_CHAUFFEUR:
            viaBusGUI.open(GUIMain.ADD_BUS_AND_CHAUFFEUR);
            break;
         case GUIMain.ADD_BUS:
            viaBusGUI.open(GUIMain.ADD_BUS);
            break;
         case GUIMain.ADD_CHAUFFEUR:
            viaBusGUI.open(GUIMain.ADD_CHAUFFEUR);
            break;
         case GUIMain.SAVE_BUTTON_ONE_DAY_TRIP:
            viaBusGUI.open(GUIMain.SAVE_BUTTON_ONE_DAY_TRIP);
            viaBusGUI.executeSaveButtonOneDayTrip();
            break;
         
         case GUIMain.ADD_STOP_ONE_DAY_TRIP:
            viaBusGUI.executeAddStopOneDayTrip();
            break;
         case GUIMain.DELETE_STOP_ONE_DAY_TRIP:
            viaBusGUI.executeDeleteStopOneDayTrip();
            break;
         case GUIMain.ADD_STOP_TRAVEL:
            viaBusGUI.executeAddStopTravel();
            break;
         case GUIMain.DELETE_STOP_TRAVEL:
            viaBusGUI.executeDeleteStopTravel();
            break;
         case GUIMain.ADD_STOP_BUS_AND_CHAUFFEUR:
            viaBusGUI.executeAddStopBusAndChauffeur();
            break;
         case GUIMain.DELETE_STOP_BUS_AND_CHAUFFEUR:
            viaBusGUI.executeDeleteStopBusAndChauffeur();
         case GUIMain.SAVE_BUTTON_TRAVEL:
            viaBusGUI.open(GUIMain.SAVE_BUTTON_TRAVEL);
            viaBusGUI.executeSaveButtonTravel();
            break;
         case GUIMain.SAVE_BUTTON_BUS_AND_CHAUFFEURS:
            viaBusGUI.open(GUIMain.SAVE_BUTTON_BUS_AND_CHAUFFEURS);
            viaBusGUI.executeSaveButtonBusAndChauffeur();
            break;
         case GUIMain.SAVE_BUTTON_CHAUFFEUR:
            viaBusGUI.open(GUIMain.SAVE_BUTTON_CHAUFFEUR);
            viaBusGUI.executeSaveButtonChaffeur();
            break;
         case GUIMain.SAVE_BUTTON_BUS:
            viaBusGUI.open(GUIMain.SAVE_BUTTON_BUS);
            viaBusGUI.executeSaveButtonBus();
            break;
         case GUIMain.ADD_NEW_RESERVATION:
            viaBusGUI.open(GUIMain.ADD_NEW_RESERVATION);
            break;
         case GUIMain.INFO:
            viaBusGUI.open(GUIMain.INFO);
            break;
         case GUIMain.INFO_CHAFFEUR:
            viaBusGUI.open(GUIMain.INFO_CHAFFEUR);
            break;
         case GUIMain.INFO_BUS:
            viaBusGUI.open(GUIMain.INFO_BUS);
            break;
         case GUIMain.INFO_BUS_AND_CHAFFEUR:
            viaBusGUI.open(GUIMain.INFO_BUS_AND_CHAFFEUR);
            break;
         
      }
   }

}