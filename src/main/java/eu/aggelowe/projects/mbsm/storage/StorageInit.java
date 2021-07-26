package eu.aggelowe.projects.mbsm.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.storage.StorageReference.ApplicationPrimaryData;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidFileTypeException;

/**
 * This class is used to manage the storage/serialised property files of the
 * application.
 * 
 * @author Aggelowe
 *
 */
public final class StorageInit {

	public static final Logger STORAGE_LOGGER = LogManager.getLogger("StorageManager");

	/**
	 * This method is used to initialise the setup of the storage/serialised
	 * property files.
	 */
	public static void setupStorage() {
		StorageInit.STORAGE_LOGGER.info("Initializing storage location..");
		try {
			AppUtils.initStorageLocation();
		} catch (InvalidFileTypeException e) {
			e.printStackTrace();
			MBSM.exit(ExitStatus.FATAL);
		}
		try {
			StorageInit.setupApplicationPrimaryData();
		} catch (Exception e) {
			e.printStackTrace();
			MBSM.exit(ExitStatus.FATAL);
		}
	}

	/**
	 * This method sets up the application primary data serialised file of the
	 * application.
	 * 
	 * @throws Exception
	 */
	private static void setupApplicationPrimaryData() throws Exception {
		StorageInit.setApplicationPrimaryDataDefaults();
		if (!ApplicationPrimaryData.get().getFile().exists()) {
			StorageInit.STORAGE_LOGGER.debug("Application primary data file doesn't exist! Creating a new one...");
			ApplicationPrimaryData.get().save();
		} else {
			StorageInit.STORAGE_LOGGER.debug("Loading application primary data...");
			ApplicationPrimaryData.get().load();
		}
	}

	/**
	 * This method sets all the default values of the application primary data
	 * serialised file.
	 */
	private static void setApplicationPrimaryDataDefaults() {
		final String[][] defaultPrimaryData = { { "x", "y" } };
		for (String[] defaultProperty : defaultPrimaryData) {
			ApplicationPrimaryData.get().setPropertyValue(defaultProperty[0], defaultProperty[1]);
		}

	}
}
