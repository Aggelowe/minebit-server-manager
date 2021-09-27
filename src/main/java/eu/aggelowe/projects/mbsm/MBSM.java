package eu.aggelowe.projects.mbsm;

import eu.aggelowe.projects.mbsm.files.FileInit;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.servers.ServerUtil;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.Reference;
import eu.aggelowe.projects.mbsm.util.RepetitiveProcess;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;
import eu.aggelowe.projects.mbsm.util.interfaces.IDynamicObject;

/**
 * This class is the main class of the project and is used to call all the
 * important methods for the application to run and is being called when the
 * program is executed.
 * 
 * @author Aggelowe
 */
public final class MBSM {

	private static ExitStatus exitStatus = ExitStatus.ERROR;

	private static final IAction SHUTDOWN_ACTION = new IAction() {
		@Override
		public void execute() {
			if (exitStatus != ExitStatus.FATAL) {
				Reference.MAIN_LOGGER.debug("Ending session...");
				SESSION_UPDATER.stop();
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
	
	private static final RepetitiveProcess SESSION_UPDATER = new RepetitiveProcess(new IDynamicObject<Boolean>() {			
		@Override
		public Boolean obtain() {
			long sec = 1000;
			FileInit.LAST_SESSION.setInteger(System.currentTimeMillis());
			FileInit.LAST_SESSION.save();
			try {
				Thread.sleep(sec * 10);
			} catch (InterruptedException exception) {
			}
			return false;
		}
	});

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
		Reference.MAIN_LOGGER.debug("Starting session management...");
		MBSM.manageSession();
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
	
	private static void manageSession() {
		long lastUpdated = FileInit.LAST_SESSION.getInteger();
		long timeDifference = System.currentTimeMillis() - lastUpdated;
		long sec = 1000;
		if (timeDifference < 20 * sec) {
			Reference.MAIN_LOGGER.warn("The given application is already running or has crashed.");
			Reference.MAIN_LOGGER.warn("If the application has crashed wait up to 20 seconds for the app to be reusable.");
			MBSM.exit(ExitStatus.FATAL);
		}
		FileInit.LAST_SESSION.getFile().deleteOnExit();
		SESSION_UPDATER.start();
	}
	
}
