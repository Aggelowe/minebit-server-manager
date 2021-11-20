package eu.aggelowe.projects.mbsm.gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.OverlayLayout;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.additives.AppButton;
import eu.aggelowe.projects.mbsm.gui.additives.AppDraggableToolbar;
import eu.aggelowe.projects.mbsm.gui.additives.AppFrame;
import eu.aggelowe.projects.mbsm.gui.tabs.latest.LatestTab;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ServerList;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ServersTab;
import eu.aggelowe.projects.mbsm.gui.tabs.settings.SettingsTab;
import eu.aggelowe.projects.mbsm.servers.MinecraftServer;
import eu.aggelowe.projects.mbsm.servers.ServerReference;
import eu.aggelowe.projects.mbsm.util.AppUtils;

/**
 * This class is used to setup the layout of the application and to call the
 * setup methods for each major components.
 * 
 * @author Aggelowe
 *
 */
public final class GuiLayoutSetup {

	public static final Logger GUI_LOGGER = LogManager.getLogger("GuiManager");

	/**
	 * This method is being called at the start of the application and is used to
	 * launch the user interface. This method should <b>only</b> be called by the
	 * main class as if it is run by anther class the interface may not work
	 * properly or window duplication could be caused.
	 */
	public static void initGui() {
		GUI_LOGGER.info("Drawing gui...");
		GUI_LOGGER.debug("Setting up the application's components and layout...");
		GuiLayoutSetup.setupComponents();
		GUI_LOGGER.debug("Showing frame...");
		ComponentReference.WINDOW.setVisible(true);
		GUI_LOGGER.debug("Showing buttons...");
		for (MinecraftServer server : ServerReference.SERVERS) {
			if (server != null) {
				ServerList.addServerButton(server);
			}
		}
		GUI_LOGGER.info("Gui drawn sucessfully!");
	}

	/**
	 * This class is used to call the setup method of every component necessary.
	 */
	private static void setupComponents() {
		GUI_LOGGER.debug("Setting up main components...");
		GuiLayoutSetup.setupWindowLayout();
		GuiLayoutSetup.setupMainframeLayout();
		GuiLayoutSetup.setupActionPanelLayout();
		GuiLayoutSetup.setupWindowOperationBarLayout();
		GuiLayoutSetup.setupCloseButtonLayout();
		GuiLayoutSetup.setupMinimiseButtonLayout();
		GuiLayoutSetup.setupTabSelectionBarLayout();
		GuiLayoutSetup.setupLatestTabButtonLayout();
		GuiLayoutSetup.setupServersTabButtonLayout();
		GuiLayoutSetup.setupSettingsTabButtonLayout();
		GuiLayoutSetup.setupTabPanelLayout();
		LatestTab.setupLatestTab();
		ServersTab.setupServersTab();
		SettingsTab.setupSettingsTab();
	}

	/**
	 * This method is used to manage the layout of the application's main window and
	 * to set up it's look and feel.
	 */
	private static void setupWindowLayout() {
		final AppFrame window = ComponentReference.WINDOW;
		AppUtils.setFinalComponentSize(window, ComponentData.WINDOW_SIZE);
		GuiComponentCustomization.customizeWindow();
		window.getContentPane().add(ComponentReference.MAINFRAME);
		window.setResizable(false);
	}
	
	/**
	 * This method is used to manage the layout of the application's main window.
	 */
	private static void setupMainframeLayout() {
		final JPanel mainframe = ComponentReference.MAINFRAME;
		mainframe.setLayout(new BorderLayout());
		AppUtils.setFinalComponentSize(mainframe, ComponentData.WINDOW_SIZE);
		GuiComponentCustomization.customizeMainframe();
		mainframe.add(ComponentReference.ACTION_PANEL, BorderLayout.NORTH);
		mainframe.add(ComponentReference.TAB_PANEL, BorderLayout.SOUTH);
	}

	/**
	 * This method is used to manage the action panel and to set up it's look and
	 * feel.
	 */
	private static void setupActionPanelLayout() {
		final JPanel actionPanel = ComponentReference.ACTION_PANEL;
		final LayoutManager panelLayout = new BorderLayout();
		AppUtils.setFinalComponentSize(actionPanel, ComponentData.ACTION_PANEL_SIZE);
		actionPanel.setLayout(panelLayout);
		GuiComponentCustomization.customizeActionPanel();
		actionPanel.add(ComponentReference.WINDOW_OPERATIONS_BAR, BorderLayout.NORTH);
		actionPanel.add(ComponentReference.TAB_SELECTION_BAR, BorderLayout.SOUTH);
	}

	/**
	 * This method is used to manage the window operation bar and to set up it's
	 * look and feel.
	 */
	private static void setupWindowOperationBarLayout() {
		final AppDraggableToolbar windowOperationBar = ComponentReference.WINDOW_OPERATIONS_BAR;
		final Dimension barSize = new Dimension(ComponentData.WINDOW_SIZE.width, 25);
		windowOperationBar.setOrientation(JToolBar.HORIZONTAL);
		windowOperationBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		AppUtils.setFinalComponentSize(windowOperationBar, barSize);
		GuiComponentCustomization.customizeWindowOperationBar();
		windowOperationBar.addSeparator(new Dimension(4, 25));
		windowOperationBar.add(ComponentReference.CLOSE_BUTTON);
		windowOperationBar.addSeparator(new Dimension(8, 25));
		windowOperationBar.add(ComponentReference.MINIMISE_BUTTON);
	}

	/**
	 * This method is used to manage the close button and to set up it's look and
	 * feel.
	 */
	private static void setupCloseButtonLayout() {
		final AppButton closeButton = ComponentReference.CLOSE_BUTTON;
		AppUtils.setFinalComponentSize(closeButton, ComponentData.WINDOW_OPERATION_BUTTON_SIZE);
		GuiComponentCustomization.customizeCloseButton();
	}

	/**
	 * This method is used to manage the close button and to set up it's look and
	 * feel.
	 */
	private static void setupMinimiseButtonLayout() {
		final AppButton minimiseButton = ComponentReference.MINIMISE_BUTTON;
		AppUtils.setFinalComponentSize(minimiseButton, ComponentData.WINDOW_OPERATION_BUTTON_SIZE);
		GuiComponentCustomization.customizeMinimiseButton();
	}

	/**
	 * This method is used to manage the tab selection bar and to set up it's look
	 * and feel.
	 */
	private static void setupTabSelectionBarLayout() {
		final AppDraggableToolbar tabSelectionBar = ComponentReference.TAB_SELECTION_BAR;
		final Dimension barSize = new Dimension(ComponentData.WINDOW_SIZE.width, 55);
		tabSelectionBar.setOrientation(JToolBar.HORIZONTAL);
		AppUtils.setFinalComponentSize(tabSelectionBar, barSize);
		GuiComponentCustomization.customizeTabSelectionBar();
		tabSelectionBar.addSeparator(new Dimension(4, 25));
		final JLabel barIcon = new JLabel(AppUtils.resizeImageIcon(ComponentData.APP_LOGO, new Dimension((barSize.height / 5) * 4, (barSize.height / 5) * 4)));
		AppUtils.setFinalComponentSize(barIcon, new Dimension(barSize.height, barSize.height));
		tabSelectionBar.add(barIcon);
		tabSelectionBar.addSeparator(new Dimension(8, 25));
		tabSelectionBar.add(ComponentReference.LATEST_TAB_BUTTON);
		tabSelectionBar.add(ComponentReference.SERVERS_TAB_BUTTON);
		tabSelectionBar.add(ComponentReference.SETTINGS_TAB_BUTTON);
	}

	/**
	 * This method is used to manage the latest tab button and to set up it's look
	 * and feel.
	 */
	private static void setupLatestTabButtonLayout() {
		final AppButton latestTabButton = ComponentReference.LATEST_TAB_BUTTON;
		final Dimension buttonDimension = new Dimension(110, 55);
		AppUtils.setFinalComponentSize(latestTabButton, buttonDimension);
		GuiComponentCustomization.customizeLatestTabButton();
	}

	/**
	 * This method is used to manage the servers button and to set up it's look and
	 * feel.
	 */
	private static void setupServersTabButtonLayout() {
		final AppButton serversTabButton = ComponentReference.SERVERS_TAB_BUTTON;
		final Dimension buttonDimension = new Dimension(110, 55);
		AppUtils.setFinalComponentSize(serversTabButton, buttonDimension);
		GuiComponentCustomization.customizeServersTabButton();
	}

	/**
	 * This method is used to manage the servers button and to set up it's look and
	 * feel.
	 */
	private static void setupSettingsTabButtonLayout() {
		final AppButton settingsTabButton = ComponentReference.SETTINGS_TAB_BUTTON;
		final Dimension buttonDimension = new Dimension(110, 55);
		AppUtils.setFinalComponentSize(settingsTabButton, buttonDimension);
		GuiComponentCustomization.customizeSettingsTabButton();
	}

	/**
	 * This method is used to manage the tab panel and to set up it's look and feel.
	 */
	private static void setupTabPanelLayout() {
		final JPanel tabPanel = ComponentReference.TAB_PANEL;
		AppUtils.setFinalComponentSize(tabPanel, ComponentData.TAB_PANEL_SIZE);
		tabPanel.setLayout(new OverlayLayout(tabPanel));
		GuiComponentCustomization.customizeTabPanel();
		tabPanel.add(ComponentReference.LATEST_TAB_PANEL);
		tabPanel.add(ComponentReference.SERVERS_TAB_PANEL);
		tabPanel.add(ComponentReference.SETTINGS_TAB_PANEL);
	}

}