package eu.aggelowe.projects.tbsm.gui.tabs;

import eu.aggelowe.projects.tbsm.gui.ComponentReference;
import eu.aggelowe.projects.tbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.tbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.tbsm.gui.components.AppPanel;
import eu.aggelowe.projects.tbsm.util.AppUtils;

/**
 * This class is used to setup the components of the servers tab which is part
 * of the main frame/window.
 * 
 * @author Aggelowe
 *
 */
public final class MainTab {

	/**
	 * This method calls all the methods necessary for the main tab to work.
	 */
	public static void setupMainTab() {
		GuiLayoutSetup.GUI_LOGGER.debug("Setting up main tab components...");
		MainTab.configureComponent();
		MainTab.initMainTabComponents();

	}

	/**
	 * This method is used to configure the main tab panel.
	 */
	private static void configureComponent() {
		final AppPanel mainTabPanel = ComponentReference.MAIN_TAB_PANEL;
		AppUtils.setFinalComponentSize(mainTabPanel, ComponentData.TAB_PANEL_SIZE);
		mainTabPanel.setOpaque(false);
		mainTabPanel.setVisible(false);
		mainTabPanel.setPropertyValue("isShowing", "true");
	}

	/**
	 * This method handles the management of the methods which are part of the
	 * main tab.
	 */
	private static void initMainTabComponents() {
		
	}

	/**
	 * This class contains all the important components and data for the main tab
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public final class MainTabReference {
		
	}

}
