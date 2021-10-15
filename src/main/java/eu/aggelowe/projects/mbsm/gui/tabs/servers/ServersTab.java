package eu.aggelowe.projects.mbsm.gui.tabs.servers;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import eu.aggelowe.projects.mbsm.gui.ComponentReference;
import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ServerList.ServerListReference;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ToolList.ToolListReference;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ToolViewer.ToolViewerReference;
import eu.aggelowe.projects.mbsm.util.AppUtils;

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
		final JPanel serversTabPanel = ComponentReference.SERVERS_TAB_PANEL;
		final Color panelColor = ServersTabReference.TAB_BACKGROUND_COLOR;
		AppUtils.setFinalComponentSize(serversTabPanel, ComponentData.TAB_PANEL_SIZE);
		serversTabPanel.setOpaque(true);
		serversTabPanel.setBackground(panelColor);
		serversTabPanel.setVisible(false);
		serversTabPanel.setLayout(new BorderLayout());
		serversTabPanel.add(ServerListReference.SERVER_LIST_PANEL, BorderLayout.WEST);
		serversTabPanel.add(ToolListReference.TOOL_LIST_PANEL, BorderLayout.CENTER);
		serversTabPanel.add(ToolViewerReference.TOOL_VIEWER_PANEL, BorderLayout.EAST);
	}

	/**
	 * This method handles the management of the methods which are part of the
	 * server tab.
	 */
	private static void initServerTabComponents() {
		ServerList.setupServersList();
		ToolList.setupServersList();
		ToolViewer.setupToolViewer();
	}

	/**
	 * This class contains all the important components and data for the servers tab
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class ServersTabReference {
		
		public static final Color TAB_BACKGROUND_COLOR = new Color(0, 50, 140);

	}
	
}
