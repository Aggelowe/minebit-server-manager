package eu.aggelowe.projects.mbsm.storage;

/**
 * 
 * This class contains a lot of very important information for the
 * configurations of the application to work properly.
 * 
 * @author Aggelowe
 *
 */
public final class StorageReference {

	/**
	 * <b>- APF =</b> Application Property File
	 */
	public static final String STORAGE_FILE_TYPE = ".apf";

	public static final String APPLICATION_FILE_PATH = System.getProperty("user.home") + "/.mbsm";

	/**
	 * This class contains all the data necessary for the application's primary
	 * stored data to work.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class ApplicationPrimaryData {

		private static final Storage APPLICATION_PRIMARY_DATA = new Storage(APPLICATION_FILE_PATH + "/primary_data" + STORAGE_FILE_TYPE);

		/**
		 * This method returns the applications primary data {@link Storage} object.
		 * 
		 * @return The application primary data {@link Storage}
		 */
		public static Storage get() {
			return APPLICATION_PRIMARY_DATA;
		}
	}

}
