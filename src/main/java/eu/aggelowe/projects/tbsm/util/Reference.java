package eu.aggelowe.projects.tbsm.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class contains a lot of <b>very important</b> variables for the project to work
 * properly. All of the variables are <code>final</code> and must <b>only</b> be
 * modified if necessary.
 * 
 * @author Aggelowe
 *
 */
public final class Reference {
	
	/**
	 * The long name of the application.
	 */
	public static final String LONG_NAME = "Thunderbolt Server Manager";
	
	/**
	 * A shorter name for the application.
	 */
	public static final String SHORT_NAME = "TBSM";
	
	/**
	 *  The full name of the application.
	 */
	public static final String FULL_NAME = new String(Reference.LONG_NAME + " - " + Reference.VERSION);
	
	/**
	 * The version of the application.
	 */
	public static final String VERSION = "0.1";
	
	/**
	 * The id of the application.
	 */
	public static final String APP_ID = "tbsm";
	
	/**
	 * The main {@link Logger} of the application.
	 */
	public static final Logger MAIN_LOGGER = LogManager.getLogger("Main");
		
}
