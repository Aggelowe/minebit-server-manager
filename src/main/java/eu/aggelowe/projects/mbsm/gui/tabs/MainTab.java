package eu.aggelowe.projects.mbsm.gui.tabs;

import javax.swing.JPanel;

import eu.aggelowe.projects.mbsm.gui.ComponentReference;
import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.util.AppUtils;

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
		final JPanel mainTabPanel = ComponentReference.MAIN_TAB_PANEL;
		AppUtils.setFinalComponentSize(mainTabPanel, ComponentData.TAB_PANEL_SIZE);
		mainTabPanel.setOpaque(false);
		mainTabPanel.setVisible(false);
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
