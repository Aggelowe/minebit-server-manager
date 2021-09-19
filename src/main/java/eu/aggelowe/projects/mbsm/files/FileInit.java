package eu.aggelowe.projects.mbsm.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.servers.ServerReference;
import eu.aggelowe.projects.mbsm.servers.ServerUtil;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidFileTypeException;

/**
 * This class is used to initialise and manage the files of the application.
 * 
 * @author Aggelowe
 *
 */
public class FileInit {

	public static final List<IFile> REGISTERED_FILES = new ArrayList<IFile>();

	public static final PropertyFile GENERAL_SETTINGS = new PropertyFile("MBSM General Properties", FileReference.APPLICATION_FOLDER_PATH + "general.properties", "defaults/general.properties");

	/**
	 * This method is used to initialise the management of the application's files.
	 */
	public static void initFiles() {
		FileReference.FILES_LOGGER.info("Initializing application's folder..");
		try {
			FileInit.initFolder(FileReference.APPLICATION_FOLDER_PATH);
			FileInit.initFolder(ServerReference.SERVER_PATH);
			FileInit.initFolder(FileReference.DATA_PATH);
			FileInit.initFolder(ServerReference.RUNNABLES_PATH);
			ServerUtil.loadServers();
		} catch (Exception exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.FATAL);
		}
		registerFiles();
		FileReference.FILES_LOGGER.debug("Loading files..");
		loadFiles();
		FileReference.FILES_LOGGER.info("Loading runnable versions...");	
		ServerUtil.loadRunnableVersions();
	}

	/**
	 * This method checks if the given directory exists and creates the folder if it
	 * doesn't.
	 * 
	 * @throws InvalidFileTypeException
	 */
	public static void initFolder(String path) throws InvalidFileTypeException {
		final File serverDirectory = new File(path);
		if (!serverDirectory.exists()) {
			serverDirectory.mkdir();
		} else if (!serverDirectory.isDirectory()) {
			throw new InvalidFileTypeException("\"" + serverDirectory + "\" already exists and it is a file.");
		}
	}

	/**
	 * This method registers all files.
	 */
	public static void registerFiles() {
		REGISTERED_FILES.add(GENERAL_SETTINGS);
		REGISTERED_FILES.add(ServerReference.RUNNABLE_VERSION_FILE);
	}

	/**
	 * This method saves all important changes to their files.
	 */
	public static void loadFiles() {
		for (IFile file : FileInit.REGISTERED_FILES) {
			if (file != null) {
				file.load();
			}
		}
	}

	/**
	 * This method saves all important changes to their files.
	 */
	public static void saveFiles() {
		for (IFile file : FileInit.REGISTERED_FILES) {
			if (file != null) {
				file.save();
			}
		}
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

}
