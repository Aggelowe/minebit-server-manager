package eu.aggelowe.projects.mbsm.gui.tabs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import eu.aggelowe.projects.mbsm.gui.ComponentReference;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.components.AppPanel;
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
		final AppPanel serversTabPanel = ComponentReference.SERVERS_TAB_PANEL;
		final Color panelColor = new Color(0, 50, 140);
		AppUtils.setFinalComponentSize(serversTabPanel, ComponentData.TAB_PANEL_SIZE);
		serversTabPanel.setOpaque(true);
		serversTabPanel.setBackground(panelColor);
		serversTabPanel.setVisible(false);
		serversTabPanel.setLayout(new BorderLayout());
		serversTabPanel.setPropertyValue("isShowing", "false");
		serversTabPanel.add(ServersTabReference.SERVER_SELECTION_PANEL, BorderLayout.WEST);
		serversTabPanel.add(ServersTabReference.TOOL_SELECTION_PANEL, BorderLayout.CENTER);
		serversTabPanel.add(ServersTabReference.TOOL_VIEW_PANEL, BorderLayout.EAST);
	}

	/**
	 * This method handles the management of the methods which are part of the
	 * server tab.
	 */
	private static void initServerTabComponents() {
		ServersTab.setupServerSelectionPanel();
		ServersTab.setupToolSelectionPanel();
		ServersTab.setupToolViewPanel();
	}

	/**
	 * This method is used to configure the server selection panel.
	 */
	private static void setupServerSelectionPanel() {
		final JPanel serverSelectionPanel = ServersTabReference.SERVER_SELECTION_PANEL;
		final Dimension panelSize = new Dimension(ComponentData.WINDOW_SIZE.width / 4, ComponentData.TAB_PANEL_SIZE.height);
		final Border panelBorder = new MatteBorder(0, 0, 0, 2, new Color(30, 45, 65));
		serverSelectionPanel.setOpaque(false);
		AppUtils.setFinalComponentSize(serverSelectionPanel, panelSize);
		serverSelectionPanel.setBorder(panelBorder);
	}

	/**
	 * This method is used to configure the tool selection panel.
	 */
	private static void setupToolSelectionPanel() {
		final JPanel toolSelectionPanel = ServersTabReference.TOOL_SELECTION_PANEL;
		final Dimension panelSize = new Dimension(ComponentData.WINDOW_SIZE.width / 4, ComponentData.TAB_PANEL_SIZE.height);
		final Border panelBorder = new MatteBorder(0, 0, 0, 2, new Color(30, 45, 65));
		toolSelectionPanel.setOpaque(false);
		AppUtils.setFinalComponentSize(toolSelectionPanel, panelSize);
		toolSelectionPanel.setBorder(panelBorder);
	}

	/**
	 * This method is used to configure the tool view panel.
	 */
	private static void setupToolViewPanel() {
		final JPanel toolViewPanel = ServersTabReference.TOOL_VIEW_PANEL;
		final Dimension panelSize = new Dimension(ComponentData.WINDOW_SIZE.width / 2, ComponentData.TAB_PANEL_SIZE.height);
		toolViewPanel.setOpaque(false);
		AppUtils.setFinalComponentSize(toolViewPanel, panelSize);
	}

	/**
	 * This class contains all the important components and data for the servers tab
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class ServersTabReference {

		public static final JPanel SERVER_SELECTION_PANEL = new JPanel();

		public static final JPanel TOOL_SELECTION_PANEL = new JPanel();

		public static final JPanel TOOL_VIEW_PANEL = new JPanel();

	}

}
