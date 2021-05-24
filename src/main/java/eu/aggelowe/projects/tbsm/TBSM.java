package eu.aggelowe.projects.tbsm;

import javax.swing.SwingUtilities;

import eu.aggelowe.projects.tbsm.gui.GuiManager;
import eu.aggelowe.projects.tbsm.util.ExitStatus;
import eu.aggelowe.projects.tbsm.util.Reference;

/**
 * This class is the main class of the project and is used to call all the
 * important methods for the application to run and is being called when the
 * program is executed.
 * 
 * @author Aggelowe
 */
public final class TBSM {

	/**
	 * This class is the main method of the project and is used to call all the
	 * important methods for the application to run and is being called when the
	 * program is executed.
	 * 
	 * @param args The given arguments when the program is executed.
	 */
	public static void main(String[] args) throws Throwable {
		Reference.MAIN_LOGGER.info("Starting the application...");
		Reference.MAIN_LOGGER.debug("Calling the gui manager...");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GuiManager.initGui();				
			}
		});
		Reference.MAIN_LOGGER.info("Application started successfully!");
	}

	/**
	 * This class is used to exit the application while printing the specified
	 * messages on the console based on the status given.
	 * 
	 * @param status
	 */
	public static void exit(ExitStatus status) {
		Reference.MAIN_LOGGER.info(status.getOutputMessage());
		System.exit(status.getExitCode());
		
	}

}
