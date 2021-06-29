package eu.aggelowe.projects.tbsm.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import eu.aggelowe.projects.tbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.tbsm.gui.components.AppButton;
import eu.aggelowe.projects.tbsm.gui.components.AppFrame;
import eu.aggelowe.projects.tbsm.util.AppUtils;
import eu.aggelowe.projects.tbsm.util.Reference;

/**
 * This class is used to customise the components of the application.
 * 
 * @author Aggelowe
 *
 */
public class GuiComponentCustomization {

	/**
	 * This method is used to manage the look and feel of the main window of the
	 * application.
	 */
	public static void customizeWindow() {
		final AppFrame window = ComponentReference.WINDOW;
		window.setTitle(Reference.FULL_NAME);
		window.setName(Reference.FULL_NAME);
		window.setIconImage(ComponentData.APP_LOGO.getImage());
		window.setUndecorated(true);
		window.setFont(ComponentData.MAIN_FONT);
		window.getContentPane().setBackground(ComponentData.MAIN_COLOR);
		window.setLocationRelativeTo(null);
		window.setType(Type.POPUP);
	}

	/**
	 * This method is used to manage the look and feel of the mainframe.
	 */
	public static void customizeMainframe() {
		final JPanel mainframe = ComponentReference.MAINFRAME;
		mainframe.setOpaque(false);
		mainframe.setVisible(true);
	}

	/**
	 * This method is used to manage the look and feel of the action panel.
	 */
	public static void customizeActionPanel() {
		final JPanel actionPanel = ComponentReference.ACTION_PANEL;
		final Color borderColor = new Color(30, 45, 65);
		final Border panelBorder = new MatteBorder(0, 0, 2, 0, borderColor);
		actionPanel.setOpaque(true);
		actionPanel.setVisible(true);
		actionPanel.setBackground(ComponentData.ACTION_PANEL_COLOR);
		actionPanel.setBorder(panelBorder);
	}

	/**
	 * This method is used to manage the look and feel of the action panel.
	 */
	public static void customizeWindowOperationBar() {
		final JToolBar windowOperationBar = ComponentReference.WINDOW_OPERATIONS_BAR;
		windowOperationBar.setFloatable(false);
		windowOperationBar.setOpaque(false);
		windowOperationBar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	}

	/**
	 * This method is used to manage the look and feel of the close button.
	 */
	public static void customizeCloseButton() {
		final AppButton closeButton = ComponentReference.CLOSE_BUTTON;
		closeButton.setIcon(AppUtils.resizeImageIcon(new ImageIcon(AppUtils.getResource("assets/gui/close_button.png")), ComponentData.WINDOW_OPERATION_BUTTON_SIZE));
		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
	}

	/**
	 * This method is used to manage the look and feel of the action panel.
	 */
	public static void customizeTabSelectionBar() {
		final JToolBar tabSelectionBar = ComponentReference.TAB_SELECTION_BAR;
		tabSelectionBar.setFloatable(false);
		tabSelectionBar.setOpaque(false);
		tabSelectionBar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	}
	
	/**
	 * This method is used to manage the look and feel of the main tab button.
	 */
	public static void customizeMainTabButton() {
		final AppButton mainTabButton = ComponentReference.MAIN_TAB_BUTTON;
		final Color buttonColor = new Color(125, 215, 230);
		final Font buttonFont = new Font("FreeMono", Font.PLAIN, 24);
		mainTabButton.setForeground(buttonColor);
		mainTabButton.setText("Main");
		mainTabButton.setFont(buttonFont);
		mainTabButton.setOpaque(false);
		mainTabButton.setContentAreaFilled(false);
		mainTabButton.setFocusPainted(false);
		mainTabButton.setBorder(new MatteBorder(0, 0, 3, 0, new Color(125, 215, 230)));
		mainTabButton.setPropertyValue("isSelected", "true");
	}
	
	/**
	 * This method is used to manage the look and feel of the servers tab button.
	 */
	public static void customizeServersTabButton() {
		final AppButton serversTabButton = ComponentReference.SERVERS_TAB_BUTTON;
		final Color buttonColor = new Color(125, 215, 230);
		final Font buttonFont = new Font("FreeMono", Font.PLAIN, 24);
		serversTabButton.setForeground(buttonColor);
		serversTabButton.setText("Servers");
		serversTabButton.setFont(buttonFont);
		serversTabButton.setOpaque(false);
		serversTabButton.setContentAreaFilled(false);
		serversTabButton.setFocusPainted(false);
		serversTabButton.setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
		serversTabButton.setPropertyValue("isSelected", "false");
	}
	
	/**
	 * This method is used to manage the look and feel of the settings tab button.
	 */
	public static void customizeSettingsTabButton() {
		final AppButton settingsTabButton = ComponentReference.SETTINGS_TAB_BUTTON;
		final Color buttonColor = new Color(125, 215, 230);
		final Font buttonFont = new Font("FreeMono", Font.PLAIN, 24);
		settingsTabButton.setForeground(buttonColor);
		settingsTabButton.setText("Settings");
		settingsTabButton.setFont(buttonFont);
		settingsTabButton.setOpaque(false);
		settingsTabButton.setContentAreaFilled(false);
		settingsTabButton.setFocusPainted(false);
		settingsTabButton.setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
		settingsTabButton.setPropertyValue("isSelected", "false");
	}
	
	/**
	 * This method is used to manage the look and feel of the tab panel.
	 */
	public static void customizeTabPanel() {
		final JPanel actionPanel = ComponentReference.TAB_PANEL;
		actionPanel.setOpaque(false);
		actionPanel.setVisible(true);
	}
}