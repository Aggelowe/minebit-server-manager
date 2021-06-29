package eu.aggelowe.projects.tbsm.storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.tbsm.TBSM;
import eu.aggelowe.projects.tbsm.storage.StorageReference.ApplicationPreferences;
import eu.aggelowe.projects.tbsm.util.AppUtils;
import eu.aggelowe.projects.tbsm.util.ExitStatus;
import eu.aggelowe.projects.tbsm.util.exceptions.InvalidFileTypeException;

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
			TBSM.exit(ExitStatus.FATAL);
		}
		try {
			StorageInit.setupApplicationPreferences();
		} catch (Exception e) {
			e.printStackTrace();
			TBSM.exit(ExitStatus.FATAL);
		}
	}

	/**
	 * This method sets up the application preferences serialised file of the
	 * application.
	 * 
	 * @throws Exception
	 */
	private static void setupApplicationPreferences() throws Exception {
		StorageInit.setApplicationPreferencesDefaults();
		if (!ApplicationPreferences.get().getFile().exists()) {
			StorageInit.STORAGE_LOGGER.debug("Application preferences file doesn't exist! Creating a new one...");
			ApplicationPreferences.get().save();
		} else {
			StorageInit.STORAGE_LOGGER.debug("Loading application preferences...");
			ApplicationPreferences.get().load();
		}
	}

	/**
	 * This method sets all the default values of the application preferences
	 * serialised file.
	 */
	private static void setApplicationPreferencesDefaults() {
		ApplicationPreferences.get().setPropertyValue("size_multiplier", ApplicationPreferences.DEFAULT_SIZE_MULTIPLIER);
	}

}
