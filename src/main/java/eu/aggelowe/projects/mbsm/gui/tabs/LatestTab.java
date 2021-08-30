package eu.aggelowe.projects.mbsm.gui.tabs;

import javax.swing.JPanel;

import eu.aggelowe.projects.mbsm.gui.ComponentReference;
import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.util.AppUtils;

/**
 * This class is used to setup the components of the latest tab which is part
 * of the main frame/window.
 * 
 * @author Aggelowe
 *
 */
public final class LatestTab {

	/**
	 * This method calls all the methods necessary for the latest tab to work.
	 */
	public static void setupLatestTab() {
		GuiLayoutSetup.GUI_LOGGER.debug("Setting up main tab components...");
		LatestTab.configureComponent();
		LatestTab.initLatestTabComponents();

	}

	/**
	 * This method is used to configure the latest tab panel.
	 */
	private static void configureComponent() {
		final JPanel latestTabPanel = ComponentReference.LATEST_TAB_PANEL;
		AppUtils.setFinalComponentSize(latestTabPanel, ComponentData.TAB_PANEL_SIZE);
		latestTabPanel.setOpaque(false);
		latestTabPanel.setVisible(false);
	}

	/**
	 * This method handles the management of the methods which are part of the
	 * latest tab.
	 */
	private static void initLatestTabComponents() {
		
	}

	/**
	 * This class contains all the important components and data for the latest tab
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public final class LatestTabReference {
		
	}

}
