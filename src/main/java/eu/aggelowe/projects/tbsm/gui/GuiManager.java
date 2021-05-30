package eu.aggelowe.projects.tbsm.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.tbsm.TBSM;
import eu.aggelowe.projects.tbsm.util.AppUtils;
import eu.aggelowe.projects.tbsm.util.ExitStatus;
import eu.aggelowe.projects.tbsm.util.Reference;

/**
 * This class is used to manage the gui of the application. The enclosed method
 * {@link #initGui()} should <b>only</b> be called by the main method as it
 * might break the interface.d
 * 
 * @author Aggelowe
 */
public final class GuiManager {

	public static final Logger GUI_LOGGER = LogManager.getLogger("GuiManager");
	public static final JPanel MAINFRAME = new JPanel();
	public static final JFrame WINDOW = new JFrame() {

		protected void processWindowEvent(WindowEvent e) {
			if (e.getID() == WindowEvent.WINDOW_CLOSING) {
				dispose();
				TBSM.exit(ExitStatus.GRACEFUL);
			}
		}

		private static final long serialVersionUID = -1943892997658496084L;

	};

	/**
	 * This method is being called at the start of the application and is used to
	 * launch the user interface. This method should <b>only</b> be called by the
	 * main class as if it is run by anther class the interface may not work
	 * properly or window duplication could be caused.
	 */
	public static void initGui() {
		GUI_LOGGER.info("Starting drawing gui...");
		GUI_LOGGER.debug("Setting up window...");
		GuiManager.setupWindow();
		GUI_LOGGER.debug("Setting up mainframe...");
		GuiManager.setupMainframe();
		GUI_LOGGER.debug("Initialising layout...");
		GuiLayout.initAppLayout();
		GUI_LOGGER.debug("Showing frame...");
		WINDOW.setVisible(true);
		GUI_LOGGER.info("Gui drawn succesgully!");
	}

	/**
	 * This method is used to setup the frame/window in order to make it work and
	 * able to cooperate with the other components. This method should <b>only</b>
	 * be called by the {@link #initGui()} method as it might interfere with the
	 * application's appearance or even cause component duplications.
	 */
	private static void setupWindow() {
		GUI_LOGGER.debug("Creating frame...");
		WINDOW.setTitle(Reference.FULL_NAME);
		WINDOW.setName("Main frame");
		WINDOW.setMaximumSize(ComponentReference.WINDOW_SIZE);
		WINDOW.setPreferredSize(ComponentReference.WINDOW_SIZE);
		WINDOW.setMinimumSize(ComponentReference.WINDOW_SIZE);
		WINDOW.getContentPane().add(MAINFRAME);
		WINDOW.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		WINDOW.setFont(Font.getFont("Monospaced Bold"));
		WINDOW.setIconImage(ComponentReference.APP_LOGO.getImage());
		WINDOW.setLayout(new BorderLayout());
		WINDOW.getContentPane().setBackground(GuiManager.ComponentReference.MAIN_COLOR);
		WINDOW.setUndecorated(true);
	}

	/**
	 * This method is used to setup the main frame of the application in order to make it work and
	 * able to cooperate with the other components. This method should <b>only</b>
	 * be called by the {@link #initGui()} method as it might interfere with the
	 * application's appearance.
	 */
	private static void setupMainframe() {
		MAINFRAME.setOpaque(false);
		MAINFRAME.setVisible(true);
		MAINFRAME.setSize(WINDOW.getSize());
		MAINFRAME.setLayout(new BorderLayout());
	}

	/**
	 * This class contains a lot of very important variables of the application such
	 * as the default size of the window or frame layouts.
	 */
	 public static final class ComponentReference {
		 
		/**
		 * The window's default size.
		 */
		public static final Dimension WINDOW_SIZE = new Dimension(1200, 675);
		
		/**
		 * The application's logo.
		 */
		public static final ImageIcon APP_LOGO = new ImageIcon(AppUtils.getResource("assets/icon.png"));
		
		/**
		 * The application's main color.
		 */
		public static final Color MAIN_COLOR = new Color(0, 35, 90);

	}
}
