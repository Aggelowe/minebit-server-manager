package eu.aggelowe.projects.tbsm;

import eu.aggelowe.projects.tbsm.gui.GuiManager;
import eu.aggelowe.projects.tbsm.util.Reference;

/**
 * This class is the main class of the project and is used to call all the
 * important methods for the application to run and is being called when the program is executed.
 * 
 * @author Aggelowe 
 */
public final class TBSM {
		
	/**
	 * This class is the main method of the project and is used to call all the
	 * important methods for the application to run and is being called when the program is executed.
	 * 
	 * @param args The given arguments when the program is executed.
	 */
	public static void main(String[] args) throws Throwable{
		Reference.MAIN_LOGGER.info("Starting the application...");
		Reference.MAIN_LOGGER.debug("Calling the gui manager...");
		GuiManager.initGui();
		Reference.MAIN_LOGGER.info("Application started successfully!");
	}
	
}
