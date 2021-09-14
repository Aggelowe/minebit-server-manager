package eu.aggelowe.projects.mbsm;

import eu.aggelowe.projects.mbsm.files.FileInit;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.servers.ServerUtil;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.Reference;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class is the main class of the project and is used to call all the
 * important methods for the application to run and is being called when the
 * program is executed.
 * 
 * @author Aggelowe
 */
public final class MBSM {

	private static ExitStatus exitStatus = ExitStatus.GRACEFUL;

	private static final IAction SHUTDOWN_ACTION = new IAction() {
		@Override
		public void execute() {
			if (exitStatus == ExitStatus.GRACEFUL) {
				Reference.MAIN_LOGGER.debug("Stopping servers...");
				ServerUtil.stopServers(false);
				Reference.MAIN_LOGGER.debug("Saving files...");
				FileInit.saveFiles();
			} else {
				Reference.MAIN_LOGGER.debug("Force stopping servers...");
				ServerUtil.stopServers(true);
			}
		}
	};

	/**
	 * This class is the main method of the project and is used to call all the
	 * important methods for the application to run and is being called when the
	 * program is executed.
	 * 
	 * @param args The given arguments when the program is executed.
	 */
	public static void main(String[] args) throws Throwable {
		Reference.MAIN_LOGGER.info("Starting the application...");
		AppUtils.addActionOnShutdown(SHUTDOWN_ACTION);
		Reference.MAIN_LOGGER.debug("Calling the storage manager...");
		FileInit.initFiles();
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
		exitStatus = status;
		Reference.MAIN_LOGGER.info(status.getOutputMessage());
		System.exit(status.getExitCode());
	}

}
