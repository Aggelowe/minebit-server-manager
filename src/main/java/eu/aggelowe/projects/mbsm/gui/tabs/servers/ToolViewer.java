package eu.aggelowe.projects.mbsm.gui.tabs.servers;

import java.awt.Color;
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

import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.util.AppUtils;

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
			nameField.setBorder(new LineBorder(ToolViewerReference.BORDER_COLOR, 2));
			nameField.setOpaque(false);
			nameField.setForeground(ComponentData.MAIN_TEXT_COLOR);
			nameField.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 12));
			nameField.setHorizontalAlignment(JTextField.CENTER);
			nameField.setCaretColor(ComponentData.MAIN_TEXT_COLOR);
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

		public static final Color BORDER_COLOR = new Color(30, 45, 65);

		public static final List<JPanel> TOOL_TABS = new ArrayList<JPanel>();

		public static final JPanel OVERVIEW_TOOL_TAB = new JPanel();
		
		public static final Color DANGER_COLOR = new Color(156, 0, 0);
	}

}
