package eu.aggelowe.projects.tbsm.gui;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.tbsm.util.Reference;

/**
 * This class is used to manage the gui of the application. The enclosed method
 * {@link #initGui()} should <b>only</b> be called by the main method as it
 * might break the interface.
 * 
 * @author Aggelowe
 */
public final class GuiManager {

	static final Logger GUI_LOGGER = LogManager.getLogger("GuiManager");
	
	static final JFrame FRAME = new JFrame();
	
	/**
	 * This method is being called at the start of the application and is used to
	 * launch the user interface. This method should <b>only</b> be called by the
	 * main class as if it is run by anther class the interface may not work
	 * properly or window duplication could be caused.
	 */
	public static void initGui() {
		GUI_LOGGER.info("Starting drawing gui...");
		setupFrame();
		GUI_LOGGER.debug("Showing frame...");
		FRAME.setVisible(true);
		GUI_LOGGER.info("Gui drawn succesgully!");
	}
	
	private static void setupFrame() {
		GUI_LOGGER.debug("Creating frame...");
		FRAME.setTitle(Reference.FULL_NAME);
		FRAME.setName("Main frame");
		FRAME.setSize(960, 540);
	}
}
