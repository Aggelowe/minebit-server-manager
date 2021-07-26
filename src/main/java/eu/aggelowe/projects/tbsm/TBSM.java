package eu.aggelowe.projects.tbsm;


import eu.aggelowe.projects.tbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.tbsm.storage.StorageInit;
import eu.aggelowe.projects.tbsm.storage.StorageReference.ApplicationPrimaryData;
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
		Reference.MAIN_LOGGER.debug("Calling the storage manager...");
		StorageInit.setupStorage();
		Reference.MAIN_LOGGER.debug("Calling the gui manager...");
		GuiLayoutSetup.initGui();
		Reference.MAIN_LOGGER.info("Application started successfully!");
	}

	/**
	 * This class is used to exit the application while printing the specified
	 * messages on the console based on the status given.
	 * 
	 * @param status
	 * @throws Exception
	 */
	public static void exit(ExitStatus status) {
		if (status == ExitStatus.GRACEFUL) {
			try {
				StorageInit.STORAGE_LOGGER.debug("Saving...");
				ApplicationPrimaryData.get().save();
			} catch (Exception e) {
				e.printStackTrace();
				Reference.MAIN_LOGGER.info(ExitStatus.FATAL.getOutputMessage());
				System.exit(ExitStatus.FATAL.getExitCode());
			}
		}
		Reference.MAIN_LOGGER.info(status.getOutputMessage());
		System.exit(status.getExitCode());
	}

}
