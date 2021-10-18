package eu.aggelowe.projects.mbsm.gui.tabs.servers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.gui.additives.AppButton;
import eu.aggelowe.projects.mbsm.gui.additives.AppList;
import eu.aggelowe.projects.mbsm.gui.additives.AppScrollBarUI;
import eu.aggelowe.projects.mbsm.gui.additives.AppSingleSelectionButton;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ServersTab.ServersTabReference;
import eu.aggelowe.projects.mbsm.servers.MinecraftServer;
import eu.aggelowe.projects.mbsm.servers.ServerUtil;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class is used to setup the components of the server list which is part
 * of the servers tab.
 * 
 * @author Aggelowe
 *
 */
public final class ServerList {

	/**
	 * This method calls all the methods necessary for the servers list to work.
	 */
	public static void setupServersList() {
		GuiLayoutSetup.GUI_LOGGER.debug("Setting up server list...");
		ServerList.configureComponent();
		ServerList.initServerListComponents();
	}

	/**
	 * This method is used to configure the servers list panel.
	 */
	private static void configureComponent() {
		final JPanel serverListPanel = ServerListReference.SERVER_LIST_PANEL;
		final Border panelBorder = new MatteBorder(0, 0, 0, 2, ServerListReference.BORDER_COLOR);
		AppUtils.setFinalComponentSize(serverListPanel, ServerListReference.PANEL_SIZE);
		serverListPanel.setOpaque(false);
		serverListPanel.setBorder(panelBorder);
		serverListPanel.setLayout(new BorderLayout());
		serverListPanel.add(ServerListReference.SERVER_MANAGEMENT_BAR, BorderLayout.NORTH);
		serverListPanel.add(ServerListReference.SERVER_SELECTION_PANE, BorderLayout.SOUTH);
	}

	/**
	 * This method handles the management of the methods which are part of the
	 * server panel.
	 */
	private static void initServerListComponents() {
		ServerList.setupServerManagementBar();
		ServerList.setupServerAddButton();
		ServerList.setupServerSelectionPane();
		ServerList.setupServerSelectionList();
	}

	/**
	 * This method is used to configure the server management bar.
	 */
	private static void setupServerManagementBar() {
		final JToolBar serverManagementBar = ServerListReference.SERVER_MANAGEMENT_BAR;
		final Dimension barSize = new Dimension(ServerListReference.PANEL_SIZE.width, 25);
		final Border barBorder = new MatteBorder(0, 0, 2, 0, ServerListReference.BORDER_COLOR);
		AppUtils.setFinalComponentSize(serverManagementBar, barSize);
		serverManagementBar.setFloatable(false);
		serverManagementBar.setOpaque(true);
		serverManagementBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		serverManagementBar.setBorder(barBorder);
		serverManagementBar.setBackground(ComponentData.ACTION_PANEL_COLOR);
		serverManagementBar.addSeparator(new Dimension(4, 25));
		serverManagementBar.add(ServerListReference.SERVER_ADD_BUTTON);
	}

	/**
	 * This method is used to manage the server add button and to set up it's look
	 * and feel.
	 */
	private static void setupServerAddButton() {
		final AppButton serverAddButton = ServerListReference.SERVER_ADD_BUTTON;
		final Dimension buttonSize = new Dimension(16, 16);
		AppUtils.setFinalComponentSize(serverAddButton, buttonSize);
		serverAddButton.setIcon(AppUtils.resizeImageIcon(new ImageIcon(AppUtils.getResource("assets/gui/add_button.png")), buttonSize));
		serverAddButton.setOpaque(false);
		serverAddButton.setContentAreaFilled(false);
		serverAddButton.setBorderPainted(false);
		serverAddButton.setFocusPainted(false);
	}

	/**
	 * This method is used to configure the server selection pane.
	 */
	private static void setupServerSelectionPane() {
		final JScrollPane serverSelectionPane = ServerListReference.SERVER_SELECTION_PANE;
		AppUtils.setFinalComponentSize(serverSelectionPane, new Dimension(ServerListReference.PANEL_SIZE.width, ComponentData.TAB_PANEL_SIZE.height - 25));
		serverSelectionPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		serverSelectionPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		serverSelectionPane.setOpaque(false);
		serverSelectionPane.getViewport().setOpaque(false);
		serverSelectionPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		serverSelectionPane.setViewportView(ServerListReference.SERVER_SELECTION_LIST);
		serverSelectionPane.getVerticalScrollBar().setUI(new AppScrollBarUI(ServersTabReference.TAB_BACKGROUND_COLOR, ComponentData.ACTION_PANEL_COLOR, ServerListReference.BORDER_COLOR, 2));
		serverSelectionPane.getVerticalScrollBar().setBackground(ServersTabReference.TAB_BACKGROUND_COLOR);
		serverSelectionPane.getVerticalScrollBar().setUnitIncrement(16);
	}

	/**
	 * This method is used to configure the server selection list.
	 */
	private static void setupServerSelectionList() {
		final AppList serverSelectionList = ServerListReference.SERVER_SELECTION_LIST;
		AppUtils.setFinalComponentSize(serverSelectionList, new Dimension(ServerListReference.PANEL_SIZE.width, ComponentData.TAB_PANEL_SIZE.height - 25));
		serverSelectionList.setFloatable(false);
		serverSelectionList.setOpaque(false);
		serverSelectionList.setBorder(new EmptyBorder(0, 0, 0, 0));
		serverSelectionList.setOrientation(JToolBar.VERTICAL);
	}

	/**
	 * This method adds a new {@link AppSingleSelectionButton} which represents a
	 * specific server.
	 * 
	 * @param name The name of the server
	 */
	public static void addServerButton(MinecraftServer server) {
		AppSingleSelectionButton serverButton = new AppSingleSelectionButton(server.getName(), ServerListReference.SERVER_BUTTONS) {

			@Override
			protected boolean isDefaultSelected() {
				return false;
			}

			@Override
			protected void onButtonDeselected() {
				this.setBackground(ServersTabReference.TAB_BACKGROUND_COLOR);
			}

			@Override
			protected void onButtonSelected() {
				this.setBackground(ComponentData.MAIN_COLOR);
				ServerListReference.selectedButton = this;
				AppSingleSelectionButton selectedToolButton = ToolList.getSelectedButton();
				if (selectedToolButton != null && selectedToolButton.getText() != null && this.getName() != null) {
					ToolViewer.viewToolTab(this.getName(), selectedToolButton.getText());
				}
			}

			private static final long serialVersionUID = -3467532756216305521L;

		};
		AppUtils.setFinalComponentSize(serverButton, new Dimension(ServerListReference.PANEL_SIZE.width, 30));
		serverButton.setName(server.getId());
		serverButton.setHorizontalAlignment(SwingConstants.LEFT);
		serverButton.setBorderPainted(false);
		serverButton.setFocusPainted(false);
		serverButton.setContentAreaFilled(false);
		serverButton.setForeground(new Color(125, 215, 230));
		serverButton.setOpaque(true);
		serverButton.select();
		ServerListReference.SERVER_SELECTION_LIST.add(serverButton, 0);
		ServerListReference.SERVER_SELECTION_LIST.updateSize();
		ServerListReference.SERVER_SELECTION_PANE.getVerticalScrollBar().setValue(0);
	}

	/**
	 * This method returns the currently selected button. If no button is selected
	 * it will return null.
	 * 
	 * @return The currently selected button.
	 */
	public static AppSingleSelectionButton getSelectedButton() {
		return ServerListReference.selectedButton;
	}

	/**
	 * This class contains all the important components and data for the server list
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class ServerListReference {

		public static final JPanel SERVER_LIST_PANEL = new JPanel();

		public static final Dimension PANEL_SIZE = new Dimension(ComponentData.WINDOW_SIZE.width / 4, ComponentData.TAB_PANEL_SIZE.height);

		public static final Color BORDER_COLOR = new Color(30, 45, 65);

		public static final JToolBar SERVER_MANAGEMENT_BAR = new JToolBar();

		public static final JScrollPane SERVER_SELECTION_PANE = new JScrollPane();

		public static final AppList SERVER_SELECTION_LIST = new AppList();

		public static final List<AppSingleSelectionButton> SERVER_BUTTONS = new ArrayList<AppSingleSelectionButton>();

		public static final AppButton SERVER_ADD_BUTTON = new AppButton(new IAction() {
			@Override
			public void execute() {
				ServerUtil.consctructNewServer();
			}
		});

		private static AppSingleSelectionButton selectedButton = null;

	}

}
