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
public final class ServersTab {

	/**
	 * This method calls all the methods necessary for the servers tab to work.
	 */
	public static void setupServersTab() {
		GuiLayoutSetup.GUI_LOGGER.debug("Setting up servers tab components...");
		ServersTab.configureComponent();
		ServersTab.initServerTabComponents();

	}

	/**
	 * This method is used to configure the servers tab panel.
	 */
	private static void configureComponent() {
		final AppPanel serversTabPanel = ComponentReference.SERVERS_TAB_PANEL;
		AppUtils.setFinalComponentSize(serversTabPanel, ComponentData.TAB_PANEL_SIZE);
		serversTabPanel.setOpaque(false);
		serversTabPanel.setVisible(false);
		serversTabPanel.setPropertyValue("isShowing", "false");
	}

	/**
	 * This method handles the management of the methods which are part of the
	 * server tab.
	 */
	private static void initServerTabComponents() {
		
	}

	/**
	 * This class contains all the important components and data for the servers tab
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public final class ServersTabReference {
		
	}

}
