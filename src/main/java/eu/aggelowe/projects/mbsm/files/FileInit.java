package eu.aggelowe.projects.mbsm.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import eu.aggelowe.projects.mbsm.MBSM;
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

	public static PropertyFile generalSettings = new PropertyFile("MBSM General Properties", FileReference.APPLICATION_FOLDER_PATH + "/general.properties", "defaults/general.properties");;

	/**
	 * This method is used to initialise the management of the application's files.
	 */
	public static void initFiles() {
		FileReference.FILES_LOGGER.info("Initializing application's folder..");
		try {
			FileInit.initStorageFolder();
		} catch (InvalidFileTypeException exception) {
			exception.printStackTrace();
			Reference.MAIN_LOGGER.info(ExitStatus.FATAL.getOutputMessage());
			System.exit(ExitStatus.FATAL.getExitCode());

		}
		FileReference.FILES_LOGGER.debug("Loading files..");
		loadFiles();
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
	public static void loadFiles() {
		generalSettings.load();
	}

	/**
	 * This method saves all important changes to their files.
	 */
	public static void saveFiles() {
		generalSettings.save();
	}

	/**
	 * This method is used to remove all the text from the given text file.
	 */
	public static final void emptyTextFile(String file) {
		try {
			FileWriter outputStream = new FileWriter(file);
			outputStream.write("");
			outputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	/**
	 * This method is used to remove all the text from the given text file.
	 */
	public static final void emptyTextFile(File file) {
		try {
			FileWriter outputStream = new FileWriter(file);
			outputStream.write("");
			outputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	/**
	 * This method is used to generate a new {@link InputStream} which is used to
	 * read data from the file given at the constructor.
	 * 
	 * @return The generated {@link FileInputStream}
	 */
	public static final FileInputStream getFileInputStream(String inputFile) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(inputFile);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		return inputStream;
	}

	/**
	 * This method is used to generate a new {@link InputStream} which is used to
	 * read data from the file given at the constructor.
	 * 
	 * @return The generated {@link FileInputStream}
	 */
	public static final FileInputStream getFileInputStream(File inputFile) {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(inputFile);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		return inputStream;
	}

	/**
	 * This method is used to generate a new {@link OutputStream} which is used to
	 * write data to the file given at the constructor.
	 * 
	 * @return The generated {@link FileOutputStream}
	 */
	public static final FileOutputStream getFileOutputStream(String outputFile) {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(outputFile, true);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		return outputStream;
	}

	/**
	 * This method is used to generate a new {@link OutputStream} which is used to
	 * write data to the file given at the constructor.
	 * 
	 * @return The generated {@link FileOutputStream}
	 */
	public static final FileOutputStream getFileOutputStream(File outputFile) {
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(outputFile, true);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		return outputStream;
	}

	public static PropertyFile getGeneralSettings() {
		return generalSettings;
	}

}
