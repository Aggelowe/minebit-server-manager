package eu.aggelowe.projects.tbsm.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import eu.aggelowe.projects.tbsm.gui.components.AppButton;
import eu.aggelowe.projects.tbsm.gui.components.AppFrame;
import eu.aggelowe.projects.tbsm.util.AppUtils;
import eu.aggelowe.projects.tbsm.util.interfaces.IAction;

/**
 * This class contains the most major components of the application as they must
 * be able to be seen by all components.
 * 
 * @author Aggelowe
 *
 */
public final class ComponentReference {

	public static final AppFrame WINDOW = new AppFrame();

	public static final JPanel MAINFRAME = new JPanel();

	public static final JPanel ACTION_PANEL = new JPanel();

	public static final JToolBar WINDOW_OPERATIONS_BAR = new JToolBar();

	public static final AppButton CLOSE_BUTTON = new AppButton(new IAction() {
		@Override
		public void execute() {
			WINDOW.setVisible(false);
		}
	});

	public static final JToolBar TAB_SELECTION_BAR = new JToolBar();

	/**
	 * This class contains a lot of component data important for the application to
	 * work.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class ComponentData {

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

		/**
		 * The application's main font.
		 */
		public static final Font MAIN_FONT = Font.getFont("FreeMono");

		/**
		 * The action panel's background color.
		 */
		public static final Color ACTION_PANEL_COLOR = new Color(0, 70, 190);

		/**
		 * The action panel's size.
		 */
		public static final Dimension ACTION_PANEL_SIZE = new Dimension(ComponentReference.WINDOW.getWidth(), 80);

		/**
		 * The size of the window operation buttons.
		 */
		public static final Dimension WINDOW_OPERATION_BUTTON_SIZE = new Dimension(16, 16);

	}

}
