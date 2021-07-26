package eu.aggelowe.projects.mbsm.gui.tabs;

import eu.aggelowe.projects.mbsm.gui.ComponentReference;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.components.AppPanel;
import eu.aggelowe.projects.mbsm.util.AppUtils;

/**
 * This class is used to setup the components of the settings tab which is part
 * of the main frame/window.
 * 
 * @author Aggelowe
 *
 */
public final class SettingsTab {

	/**
	 * This method calls all the methods necessary for the settings tab to work.
	 */
	public static void setupSettingsTab() {
		GuiLayoutSetup.GUI_LOGGER.debug("Setting up main components...");
		SettingsTab.configureComponent();
		SettingsTab.initSettingsTabComponents();

	}

	/**
	 * This method is used to configure the settings tab panel.
	 */
	private static void configureComponent() {
		final AppPanel settingsTabPanel = ComponentReference.SETTINGS_TAB_PANEL;
		AppUtils.setFinalComponentSize(settingsTabPanel, ComponentData.TAB_PANEL_SIZE);
		settingsTabPanel.setOpaque(false);
		settingsTabPanel.setVisible(false);
		settingsTabPanel.setPropertyValue("isShowing", "false");
	}

	/**
	 * This method handles the management of the methods which are part of the
	 * settings tab.
	 */
	private static void initSettingsTabComponents() {
		
	}

	/**
	 * This class contains all the important components and data for the settings tab
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public final class SettingsTabReference {
		
	}

}
