package eu.aggelowe.projects.tbsm.storage;

/**
 * 
 * This class contains a lot of very important information for the
 * configurations of the application to work properly.
 * 
 * @author Aggelowe
 *
 */
public final class StorageReference {

	public static final String STORAGE_FILE_TYPE = ".tsu";

	public static final String APPLICATION_FILE_PATH = System.getProperty("user.home") + "/.tbsm";

	public static final class ApplicationPreferences {
		
		private static final Storage APPLICATION_PREFERENCES = new Storage(APPLICATION_FILE_PATH + "/preferences" + STORAGE_FILE_TYPE);
		
		public static final String DEFAULT_SIZE_MULTIPLIER = "1";
		
		public static Storage get() {
			return APPLICATION_PREFERENCES;
		}
	}

}
