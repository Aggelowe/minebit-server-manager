package eu.aggelowe.projects.mbsm.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.mbsm.util.Reference;

/**
 * 
 * This class contains a lot of very important information for the files in
 * order to make the application work properly.
 * 
 * @author Aggelowe
 */
public class FileReference {

	public static final Logger FILES_LOGGER = LogManager.getLogger("FileManager");

	public static final String APPLICATION_FOLDER_PATH = System.getProperty("user.home") + "/." + Reference.APP_ID +"/";
	
	public static final String DATA_PATH = APPLICATION_FOLDER_PATH + "data/";

}
