package eu.aggelowe.projects.mbsm.gui.tabs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import eu.aggelowe.projects.mbsm.gui.ComponentReference;
import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.gui.components.AppButton;
import eu.aggelowe.projects.mbsm.gui.components.AppList;
import eu.aggelowe.projects.mbsm.gui.components.AppPanel;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

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
		ServersTab.setupServerManagementBar();
		ServersTab.setupAddServerButton();
		ServersTab.setupServerSelectionPane();
		ServersTab.setupServerSelectionToolbar();
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
		serverSelectionPanel.setLayout(new BorderLayout());
		serverSelectionPanel.add(ServersTabReference.SERVER_MANAGEMENT_BAR, BorderLayout.NORTH);
		serverSelectionPanel.add(ServersTabReference.SERVER_SELECTION_PANE, BorderLayout.SOUTH);
	}

	/**
	 * This method is used to configure the server management bar.
	 */
	private static void setupServerManagementBar() {
		final JToolBar serverManagementBar = ServersTabReference.SERVER_MANAGEMENT_BAR;
		final Dimension barSize = new Dimension(ServersTabReference.SERVER_SELECTION_PANEL.getWidth(), 25);
		final Border barBorder = new MatteBorder(0, 0, 2, 0, new Color(30, 45, 65));
		serverManagementBar.setFloatable(false);
		serverManagementBar.setOpaque(true);
		AppUtils.setFinalComponentSize(serverManagementBar, barSize);
		serverManagementBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		serverManagementBar.setBorder(barBorder);
		serverManagementBar.setBackground(ComponentData.ACTION_PANEL_COLOR);
		serverManagementBar.addSeparator(new Dimension(4, 25));
		serverManagementBar.add(ServersTabReference.ADD_SERVER_BUTTON);
	}

	/**
	 * This method is used to manage the add server button and to set up it's look
	 * and feel.
	 */
	private static void setupAddServerButton() {
		final AppButton addServerButton = ServersTabReference.ADD_SERVER_BUTTON;
		final Dimension buttonSize = new Dimension(16, 16);
		AppUtils.setFinalComponentSize(addServerButton, buttonSize);
		addServerButton.setIcon(AppUtils.resizeImageIcon(new ImageIcon(AppUtils.getResource("assets/gui/add_button.png")), buttonSize));
		addServerButton.setOpaque(false);
		addServerButton.setContentAreaFilled(false);
		addServerButton.setBorderPainted(false);
		addServerButton.setFocusPainted(false);
	}

	/**
	 * This method is used to configure the server selection bar.
	 */
	private static void setupServerSelectionPane() {
		final JScrollPane serverSelectionPane = ServersTabReference.SERVER_SELECTION_PANE;
		AppUtils.setFinalComponentSize(serverSelectionPane, new Dimension(ServersTabReference.SERVER_SELECTION_PANEL.getWidth(), ComponentData.TAB_PANEL_SIZE.height - 25));
		serverSelectionPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		serverSelectionPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		serverSelectionPane.setOpaque(false);
		serverSelectionPane.getViewport().setOpaque(false);
		serverSelectionPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		serverSelectionPane.setViewportView(ServersTabReference.SERVER_SELECTION_TOOLBAR);
	}

	/**
	 * This method is used to configure the server selection toolbar.
	 */
	private static void setupServerSelectionToolbar() {
		final AppList serverSelectionToolbar = ServersTabReference.SERVER_SELECTION_TOOLBAR;
		AppUtils.setFinalComponentSize(serverSelectionToolbar, new Dimension(ServersTabReference.SERVER_SELECTION_PANE.getViewport().getWidth(), ComponentData.TAB_PANEL_SIZE.height - 25));
		serverSelectionToolbar.setFloatable(false);
		serverSelectionToolbar.setOpaque(false);
		serverSelectionToolbar.setBorder(new EmptyBorder(0, 0, 0, 0));
		serverSelectionToolbar.setOrientation(JToolBar.VERTICAL);
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

		public static final JToolBar SERVER_MANAGEMENT_BAR = new JToolBar();

		public static final AppButton ADD_SERVER_BUTTON = new AppButton(new IAction() {
			@Override
			public void execute() {
				SERVER_SELECTION_TOOLBAR.add(new AppButton("LOL"));
				SERVER_SELECTION_TOOLBAR.updateSize();
			}
		});

		public static final JScrollPane SERVER_SELECTION_PANE = new JScrollPane();

		public static final AppList SERVER_SELECTION_TOOLBAR = new AppList();

		public static final JPanel TOOL_SELECTION_PANEL = new JPanel();

		public static final JPanel TOOL_VIEW_PANEL = new JPanel();

	}

}
