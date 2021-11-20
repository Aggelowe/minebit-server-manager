package eu.aggelowe.projects.mbsm.gui.tabs.servers;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.gui.additives.AppButton;
import eu.aggelowe.projects.mbsm.gui.additives.AppPopupButton;
import eu.aggelowe.projects.mbsm.gui.additives.AppSingleSelectionButton;
import eu.aggelowe.projects.mbsm.gui.popups.ConfirmDeletionPopup;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ServerList.ServerListReference;
import eu.aggelowe.projects.mbsm.servers.MinecraftServer;
import eu.aggelowe.projects.mbsm.servers.ServerReference;
import eu.aggelowe.projects.mbsm.servers.ServerUtil;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.INamed;
import eu.aggelowe.projects.mbsm.util.exceptions.ServerException;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class is used to setup the components of the tool viewer which is part
 * of the servers tab.
 * 
 * @author Aggelowe
 *
 */
public class ToolViewer {

	/**
	 * This method calls all the methods necessary for the tool viewer to work.
	 */
	public static void setupToolViewer() {
		GuiLayoutSetup.GUI_LOGGER.debug("Setting up tool viewer...");
		ToolViewer.configureComponent();
		ToolViewer.initToolViewerComponents();
		OverviewToolTab.setupOverviewToolTab();
	}

	/**
	 * This method is used to configure the tool viewer panel.
	 */
	private static void configureComponent() {
		final JPanel toolViewerPanel = ToolViewerReference.TOOL_VIEWER_PANEL;
		AppUtils.setFinalComponentSize(toolViewerPanel, ToolViewerReference.PANEL_SIZE);
		toolViewerPanel.setOpaque(false);
		toolViewerPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolViewerPanel.setLayout(new OverlayLayout(toolViewerPanel));
		toolViewerPanel.add(ToolViewerReference.OVERVIEW_TOOL_TAB);
	}

	/**
	 * This method handles the management of the methods which are part of the tool
	 * viewer.
	 */
	private static void initToolViewerComponents() {

	}

	/**
	 * This method changes the currently viewed tab based on the data given.
	 */
	public static void viewToolTab(String serverId, String toolName) {
		for (JPanel toolTab : ToolViewerReference.TOOL_TABS) {
			if (toolTab != null && toolTab.getName() != null && toolTab.getName().equals(toolName)) {
				for (JPanel unviewedToolTab : ToolViewerReference.TOOL_TABS) {
					if (unviewedToolTab != toolTab) {
						unviewedToolTab.setVisible(false);
					}
				}
				toolTab.setVisible(true);
				return;
			}
		}
		for (JPanel toolTab : ToolViewerReference.TOOL_TABS) {
			toolTab.setVisible(false);
		}
	}

	/**
	 * This method calls the 'update' method in every tab of the tool viewer.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static void updateTabs() {
		OverviewToolTab.update();
	}

	/**
	 * This class is used to setup the components of the overview tool tab which is
	 * part of the servers tab.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class OverviewToolTab {

		/**
		 * This method calls all the methods necessary for the overview tool tab to
		 * work.
		 */
		public static void setupOverviewToolTab() {
			OverviewToolTab.configureComponent();
			OverviewToolTab.initOverviewTabComponents();
			OverviewToolTab.setupOverviewLabel();
			OverviewToolTab.setupNameBox();
			OverviewToolTab.setupNameField();
			OverviewToolTab.setupOperationBox();
			OverviewToolTab.setupSaveButton();
			OverviewToolTab.setupCopyButton();
			OverviewToolTab.setupDeleteButton();
		}

		/**
		 * This method updates the components of the 'overview' tab.
		 */
		public static void update() {
			String currentServerName = ServerList.getSelectedButton().getText();
			OverviewToolTabReference.NAME_FIELD.setText(currentServerName);
		}

		/**
		 * This method is used to configure the tool viewer panel.
		 */
		private static void configureComponent() {
			final JPanel toolViewerPanel = ToolViewerReference.OVERVIEW_TOOL_TAB;
			AppUtils.setFinalComponentSize(toolViewerPanel, ToolViewerReference.PANEL_SIZE);
			toolViewerPanel.setOpaque(false);
			toolViewerPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			toolViewerPanel.setLayout(new BoxLayout(toolViewerPanel, BoxLayout.Y_AXIS));
			toolViewerPanel.setName("Overview");
			toolViewerPanel.add(Box.createRigidArea(new Dimension(ToolViewerReference.PANEL_SIZE.width, 8)));
			toolViewerPanel.add(OverviewToolTabReference.OVERVIEW_LABEL);
			toolViewerPanel.add(Box.createRigidArea(new Dimension(ToolViewerReference.PANEL_SIZE.width, 7)));
			toolViewerPanel.add(OverviewToolTabReference.NAME_BOX);
			toolViewerPanel.add(Box.createRigidArea(new Dimension(ToolViewerReference.PANEL_SIZE.width, 7)));
			toolViewerPanel.add(OverviewToolTabReference.OPERATION_BOX);
			ToolViewerReference.TOOL_TABS.add(toolViewerPanel);
		}

		/**
		 * This method handles the management of the methods which are part of the tool
		 * viewer.
		 */
		private static void initOverviewTabComponents() {

		}

		/**
		 * This method sets up the 'overview' label.
		 */
		private static void setupOverviewLabel() {
			JLabel overviewLabel = OverviewToolTabReference.OVERVIEW_LABEL;
			overviewLabel.setHorizontalAlignment(JLabel.LEFT);
			overviewLabel.setOpaque(false);
			overviewLabel.setForeground(ComponentData.MAIN_TEXT_COLOR);
			overviewLabel.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 14));
			overviewLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		}

		/**
		 * This method sets up the 'name' box.
		 */
		private static void setupNameBox() {
			Box nameBox = OverviewToolTabReference.NAME_BOX;
			JLabel nameLabel = new JLabel("Name: ");
			nameLabel.setHorizontalAlignment(JLabel.RIGHT);
			nameLabel.setOpaque(false);
			nameLabel.setForeground(ComponentData.MAIN_TEXT_COLOR);
			nameLabel.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 14));
			nameBox.add(nameLabel);
			nameBox.add(OverviewToolTabReference.NAME_FIELD);
		}

		/**
		 * This method sets up the 'name' box.
		 */
		private static void setupNameField() {
			JTextField nameField = OverviewToolTabReference.NAME_FIELD;
			AppUtils.setFinalComponentSize(nameField, new Dimension(450, 30));
			nameField.setBorder(new LineBorder(ComponentData.BORDER_COLOR, 2));
			nameField.setOpaque(false);
			nameField.setForeground(ComponentData.MAIN_TEXT_COLOR);
			nameField.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 12));
			nameField.setHorizontalAlignment(JTextField.CENTER);
			nameField.setCaretColor(ComponentData.MAIN_TEXT_COLOR);
		}

		private static void setupOperationBox() {
			Box operationBox = OverviewToolTabReference.OPERATION_BOX;
			operationBox.add(OverviewToolTabReference.SAVE_BUTTON);
			operationBox.add(Box.createRigidArea(new Dimension(15, 30)));
			operationBox.add(OverviewToolTabReference.COPY_BUTTON);
			operationBox.add(Box.createRigidArea(new Dimension(15, 30)));
			operationBox.add(OverviewToolTabReference.DELETE_BUTTON);
		}

		private static void setupSaveButton() {
			AppButton saveButton = OverviewToolTabReference.SAVE_BUTTON;
			AppUtils.setFinalComponentSize(saveButton, new Dimension(140, 30));
			saveButton.setOpaque(false);
			saveButton.setContentAreaFilled(false);
			saveButton.setBorderPainted(true);
			saveButton.setFocusPainted(false);
			saveButton.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 12));
			saveButton.setBorder(new LineBorder(ComponentData.BORDER_COLOR, 2));
			saveButton.setForeground(ComponentData.MAIN_TEXT_COLOR);
		}

		private static void setupCopyButton() {
			AppButton copyButton = OverviewToolTabReference.COPY_BUTTON;
			AppUtils.setFinalComponentSize(copyButton, new Dimension(140, 30));
			copyButton.setOpaque(false);
			copyButton.setContentAreaFilled(false);
			copyButton.setBorderPainted(true);
			copyButton.setFocusPainted(false);
			copyButton.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 12));
			copyButton.setBorder(new LineBorder(ComponentData.BORDER_COLOR, 2));
			copyButton.setForeground(ComponentData.MAIN_TEXT_COLOR);
		}

		private static void setupDeleteButton() {
			AppButton deleteButton = OverviewToolTabReference.DELETE_BUTTON;
			AppUtils.setFinalComponentSize(deleteButton, new Dimension(140, 30));
			deleteButton.setOpaque(false);
			deleteButton.setContentAreaFilled(false);
			deleteButton.setBorderPainted(true);
			deleteButton.setFocusPainted(false);
			deleteButton.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 12));
			deleteButton.setBorder(new LineBorder(ComponentData.BORDER_COLOR, 2));
			deleteButton.setForeground(ComponentData.DANGER_COLOR);
		}

		/**
		 * This class contains all the important components and data for the overview
		 * tool tab to work properly.
		 * 
		 * @author Aggelowe
		 *
		 */
		public static final class OverviewToolTabReference {

			public static final JLabel OVERVIEW_LABEL = new JLabel("Overview");

			public static final Box NAME_BOX = new Box(BoxLayout.X_AXIS);

			public static final JTextField NAME_FIELD = new JTextField();

			public static final Box OPERATION_BOX = new Box(BoxLayout.X_AXIS);

			public static final IAction SAVE_ACTION = new IAction() {

				@Override
				public void execute() {
					String defaultName = "Unnamed Server";
					INamed named = ServerReference.SERVERS.getNamedObject(ServerList.getSelectedButton().getName());
					MinecraftServer server = null;
					if (named instanceof MinecraftServer) {
						server = (MinecraftServer) named;
					} else {
						return;
					}
					try {
						if (NAME_FIELD.getText() != null && !NAME_FIELD.getText().equals("")) {
							server.setName(NAME_FIELD.getText());
							ServerList.getSelectedButton().setText(NAME_FIELD.getText());
						} else {
							NAME_FIELD.setText(defaultName);
							server.setName(defaultName);
							ServerList.getSelectedButton().setText(defaultName);
						}
						ServerUtil.saveServer(server.getId());
					} catch (ServerException exception) {
						exception.printStackTrace();
						MBSM.exit(ExitStatus.ERROR);
					}
				}
			};

			public static final AppButton SAVE_BUTTON = new AppButton("Save", SAVE_ACTION);

			public static final IAction COPY_ACTION = new IAction() {

				@Override
				public void execute() {

				}
			};

			public static final AppButton COPY_BUTTON = new AppButton("Copy", COPY_ACTION);

			public static final IAction DELETE_ACTION = new IAction() {

				@Override
				public void execute() {
					INamed named = ServerReference.SERVERS.getNamedObject(ServerList.getSelectedButton().getName());
					MinecraftServer server = null;
					if (named instanceof MinecraftServer) {
						server = (MinecraftServer) named;
					} else {
						return;
					}
					try {
						ServerListReference.SERVER_SELECTION_LIST.remove(ServerList.getSelectedButton());
						ServerUtil.deleteServer(server);
						ServerListReference.SERVER_SELECTION_LIST.updateSize();
						ServerListReference.SERVER_SELECTION_PANE.updateUI();
						for (Component component : ServerListReference.SERVER_SELECTION_LIST.getComponents()) {
							if (component instanceof AppSingleSelectionButton) {
								((AppSingleSelectionButton) component).select();
								return;
							}
						}
						ServerUtil.consctructNewServer();
					} catch (ServerException exception) {
						exception.printStackTrace();
						MBSM.exit(ExitStatus.ERROR);
					}
				}
			};

			public static final AppPopupButton DELETE_BUTTON = new AppPopupButton("Delete", new ConfirmDeletionPopup("server", DELETE_ACTION));

		}

	}

	/**
	 * This class contains all the important components and data for the tool viewer
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class ToolViewerReference {

		public static final JPanel TOOL_VIEWER_PANEL = new JPanel();

		public static final Dimension PANEL_SIZE = new Dimension(ComponentData.WINDOW_SIZE.width / 2, ComponentData.TAB_PANEL_SIZE.height);

		public static final List<JPanel> TOOL_TABS = new ArrayList<JPanel>();

		public static final JPanel OVERVIEW_TOOL_TAB = new JPanel();
	}

}
