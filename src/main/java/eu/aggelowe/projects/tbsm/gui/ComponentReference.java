package eu.aggelowe.projects.tbsm.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.MatteBorder;

import eu.aggelowe.projects.tbsm.TBSM;
import eu.aggelowe.projects.tbsm.gui.components.AppButton;
import eu.aggelowe.projects.tbsm.gui.components.AppFrame;
import eu.aggelowe.projects.tbsm.gui.components.AppPanel;
import eu.aggelowe.projects.tbsm.util.AppUtils;
import eu.aggelowe.projects.tbsm.util.ExitStatus;
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
			TBSM.exit(ExitStatus.GRACEFUL);
		}
	});

	public static final JToolBar TAB_SELECTION_BAR = new JToolBar();

	public static final AppButton MAIN_TAB_BUTTON = new AppButton(new IAction() {
		@Override
		public void execute() {
			if (MAIN_TAB_BUTTON.getPropertyValue("isSelected") == "false") {
				MAIN_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, new Color(125, 215, 230)));
				MAIN_TAB_BUTTON.setPropertyValue("isSelected", "true");
				MAIN_TAB_PANEL.setVisible(true);
				MAIN_TAB_PANEL.setPropertyValue("isShowing", "true");
				SERVERS_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
				SERVERS_TAB_BUTTON.setPropertyValue("isSelected", "false");
				SERVERS_TAB_PANEL.setVisible(false);
				SERVERS_TAB_PANEL.setPropertyValue("isShowing", "false");
				SETTINGS_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
				SETTINGS_TAB_BUTTON.setPropertyValue("isSelected", "false");
				SETTINGS_TAB_PANEL.setVisible(false);
				SETTINGS_TAB_PANEL.setPropertyValue("isShowing", "false");
			}
		}
	});

	public static final AppButton SERVERS_TAB_BUTTON = new AppButton(new IAction() {
		@Override
		public void execute() {
			if (SERVERS_TAB_BUTTON.getPropertyValue("isSelected") == "false") {
				SERVERS_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, new Color(125, 215, 230)));
				SERVERS_TAB_BUTTON.setPropertyValue("isSelected", "true");
				SERVERS_TAB_PANEL.setVisible(true);
				SERVERS_TAB_PANEL.setPropertyValue("isShowing", "true");
				MAIN_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
				MAIN_TAB_BUTTON.setPropertyValue("isSelected", "false");
				MAIN_TAB_PANEL.setVisible(false);
				MAIN_TAB_PANEL.setPropertyValue("isShowing", "false");
				SETTINGS_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
				SETTINGS_TAB_BUTTON.setPropertyValue("isSelected", "false");
				SETTINGS_TAB_PANEL.setVisible(false);
				SETTINGS_TAB_PANEL.setPropertyValue("isShowing", "false");
			}
		}
	});

	public static final AppButton SETTINGS_TAB_BUTTON = new AppButton(new IAction() {
		@Override
		public void execute() {
			if (SETTINGS_TAB_BUTTON.getPropertyValue("isSelected") == "false") {
				SETTINGS_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, new Color(125, 215, 230)));
				SETTINGS_TAB_BUTTON.setPropertyValue("isSelected", "true");
				SETTINGS_TAB_PANEL.setVisible(true);
				SETTINGS_TAB_PANEL.setPropertyValue("isShowing", "true");
				MAIN_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
				MAIN_TAB_BUTTON.setPropertyValue("isSelected", "false");
				MAIN_TAB_PANEL.setVisible(false);
				MAIN_TAB_PANEL.setPropertyValue("isShowing", "false");
				SERVERS_TAB_BUTTON.setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
				SERVERS_TAB_BUTTON.setPropertyValue("isSelected", "false");
				SERVERS_TAB_PANEL.setVisible(false);
				SERVERS_TAB_PANEL.setPropertyValue("isShowing", "false");
			}
		}
	});

	public static final JPanel TAB_PANEL = new JPanel();

	public static final AppPanel MAIN_TAB_PANEL = new AppPanel();

	public static final AppPanel SERVERS_TAB_PANEL = new AppPanel();

	public static final AppPanel SETTINGS_TAB_PANEL = new AppPanel();

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
		public static final Dimension ACTION_PANEL_SIZE = new Dimension(ComponentData.WINDOW_SIZE.width, ComponentData.WINDOW_SIZE.height / 675 * 80);

		/**
		 * The size of the window operation buttons.
		 */
		public static final Dimension WINDOW_OPERATION_BUTTON_SIZE = new Dimension(ComponentData.ACTION_PANEL_SIZE.height / 80 * 16, ComponentData.ACTION_PANEL_SIZE.height / 80 * 16);

		/**
		 * The action panel's size.
		 */
		public static final Dimension TAB_PANEL_SIZE = new Dimension(ComponentData.WINDOW_SIZE.width, ComponentData.WINDOW_SIZE.height / 675 * 595);

	}

}
