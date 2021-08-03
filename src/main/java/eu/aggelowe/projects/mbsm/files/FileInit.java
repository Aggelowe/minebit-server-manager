package eu.aggelowe.projects.mbsm.files;

import java.io.File;

import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.Reference;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidFileTypeException;

/**
 * This class is used to initialise and manage the files of the application.
 * 
 * @author Aggelowe
 *
 */
public class FileInit {

	/**
	 * This method is used to initialise the management of the application's files.
	 */
	public static void initFiles() {
		FileReference.FILES_LOGGER.info("Initializing application's folder..");
		try {
			FileInit.initStorageFolder();
		} catch (InvalidFileTypeException e) {
			e.printStackTrace();
			Reference.MAIN_LOGGER.info(ExitStatus.FATAL.getOutputMessage());
			System.exit(ExitStatus.FATAL.getExitCode());
		}
	}

	/**
	 * This method checks if the application directory exists and creates the folder
	 * if it doesn't or throws an {@link InvalidFileTypeException} if a file with
	 * the same name exists in it's position.
	 * 
	 * @throws InvalidFileTypeException
	 */
	private static void initStorageFolder() throws InvalidFileTypeException {
		final File applicationDirectory = new File(FileReference.APPLICATION_FOLDER_PATH);
		if (!applicationDirectory.exists()) {
			applicationDirectory.mkdir();
		} else if (!applicationDirectory.isDirectory()) {
			throw new InvalidFileTypeException("\"" + FileReference.APPLICATION_FOLDER_PATH + "\" already exists and it is a file.");
		}
	}
	

	/**
	 * This method saves all important changes to their files.
	 */
	public static void saveFiles() {

	}

}
