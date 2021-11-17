package eu.aggelowe.projects.mbsm.gui.tabs.servers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.GuiLayoutSetup;
import eu.aggelowe.projects.mbsm.gui.additives.AppList;
import eu.aggelowe.projects.mbsm.gui.additives.AppScrollBarUI;
import eu.aggelowe.projects.mbsm.gui.additives.AppSingleSelectionButton;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ServersTab.ServersTabReference;
import eu.aggelowe.projects.mbsm.util.AppUtils;

/**
 * This class is used to setup the components of the tool list which is part of
 * the servers tab.
 * 
 * @author Aggelowe
 *
 */
public class ToolList {

	/**
	 * This method calls all the methods necessary for the tool list to work.
	 */
	public static void setupServersList() {
		GuiLayoutSetup.GUI_LOGGER.debug("Setting up tool list...");
		ToolList.configureComponent();
		ToolList.initToolListComponents();
		ToolList.registerDefaultButtons();
	}

	/**
	 * This method registers all the default buttons of the tool list.
	 */
	private static void registerDefaultButtons() {
		ToolList.addToolButton("Overview");
		ToolList.addToolButton("Banlist");
		ToolList.addToolButton("Whitelist");
		ToolList.addToolButton("Operators");
		ToolList.addToolButton("Console");
		ToolList.addToolButton("Configurations");
		ToolList.addToolButton("Logs");
	}

	/**
	 * This method is used to configure the tool list panel.
	 */
	private static void configureComponent() {
		final JPanel toolListPanel = ToolListReference.TOOL_LIST_PANEL;
		final Border panelBorder = new MatteBorder(0, 0, 0, 2, ToolListReference.BORDER_COLOR);
		AppUtils.setFinalComponentSize(toolListPanel, ToolListReference.PANEL_SIZE);
		toolListPanel.setOpaque(false);
		toolListPanel.setBorder(panelBorder);
		toolListPanel.setLayout(new BorderLayout());
		toolListPanel.add(ToolListReference.TOOL_SELECTION_PANE);
	}

	/**
	 * This method handles the management of the methods which are part of the
	 * server panel.
	 */
	private static void initToolListComponents() {
		ToolList.setupToolSelectionPane();
		ToolList.setupToolSelectionList();
	}

	/**
	 * This method is used to configure the tool selection pane.
	 */
	private static void setupToolSelectionPane() {
		final JScrollPane toolSelectionPane = ToolListReference.TOOL_SELECTION_PANE;
		AppUtils.setFinalComponentSize(toolSelectionPane, ToolListReference.PANEL_SIZE);
		toolSelectionPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		toolSelectionPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		toolSelectionPane.setOpaque(false);
		toolSelectionPane.getViewport().setOpaque(false);
		toolSelectionPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolSelectionPane.setViewportView(ToolListReference.TOOL_SELECTION_LIST);
		toolSelectionPane.getVerticalScrollBar().setUI(new AppScrollBarUI(ServersTabReference.TAB_BACKGROUND_COLOR, ComponentData.ACTION_PANEL_COLOR, ToolListReference.BORDER_COLOR, 2));
		toolSelectionPane.getVerticalScrollBar().setBackground(ServersTabReference.TAB_BACKGROUND_COLOR);
		toolSelectionPane.getVerticalScrollBar().setUnitIncrement(16);
	}

	/**
	 * This method is used to configure the tool selection list.
	 */
	private static void setupToolSelectionList() {
		final AppList toolSelectionList = ToolListReference.TOOL_SELECTION_LIST;
		AppUtils.setFinalComponentSize(toolSelectionList, ToolListReference.PANEL_SIZE);
		toolSelectionList.setFloatable(false);
		toolSelectionList.setOpaque(false);
		toolSelectionList.setBorder(new EmptyBorder(0, 0, 0, 0));
		toolSelectionList.setOrientation(JToolBar.VERTICAL);
	}

	/**
	 * This method adds a new {@link AppSingleSelectionButton} which represents a
	 * specific server.
	 * 
	 * @param name The name of the server
	 */
	public static void addToolButton(String name) {
		AppSingleSelectionButton toolButton = new AppSingleSelectionButton(name, ToolListReference.TOOL_BUTTONS) {

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
				ToolListReference.selectedButton = this;
				AppSingleSelectionButton selectedServerButton = ServerList.getSelectedButton();
				if (selectedServerButton != null && selectedServerButton.getName() != null && this.getText() != null) {
					ToolViewer.viewToolTab(selectedServerButton.getName(), this.getText());
				}
			}

			private static final long serialVersionUID = -3467532756216305521L;

		};
		AppUtils.setFinalComponentSize(toolButton, new Dimension(ToolListReference.PANEL_SIZE.width, 30));
		toolButton.setHorizontalAlignment(SwingConstants.LEFT);
		toolButton.setBorderPainted(false);
		toolButton.setFocusPainted(false);
		toolButton.setContentAreaFilled(false);
		toolButton.setForeground(ComponentData.MAIN_TEXT_COLOR);
		toolButton.setOpaque(true);
		ToolListReference.TOOL_SELECTION_LIST.add(toolButton, -1);
		ToolListReference.TOOL_SELECTION_LIST.updateSize();
		ToolListReference.TOOL_SELECTION_PANE.getVerticalScrollBar().setValue(0);
	}

	/**
	 * This method returns the currently selected button. If no button is selected
	 * it will return null.
	 * 
	 * @return The currently selected button.
	 */
	public static AppSingleSelectionButton getSelectedButton() {
		return ToolListReference.selectedButton;
	}

	/**
	 * This method sets the currently selected button to the one with the same text
	 * as the given {@link String}.
	 * 
	 * @param button The button to select
	 */
	public static void setSelectedButton(String button, boolean updateTab) {
		for (AppSingleSelectionButton toolButton : ToolListReference.TOOL_BUTTONS) {
			if (toolButton != null && toolButton.getText() != null && button.equals(toolButton.getText())) {
				if (updateTab == false) {
					toolButton.setSingleSelected();
					toolButton.setBackground(ComponentData.MAIN_COLOR);
					ToolListReference.selectedButton = toolButton;
				} else {
					toolButton.select();
				}
				return;
			}
		}
	}

	/**
	 * This class contains all the important components and data for the tool list
	 * to work properly.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class ToolListReference {

		public static final JPanel TOOL_LIST_PANEL = new JPanel();

		public static final Dimension PANEL_SIZE = new Dimension(ComponentData.WINDOW_SIZE.width / 4, ComponentData.TAB_PANEL_SIZE.height);

		public static final Color BORDER_COLOR = new Color(30, 45, 65);

		public static final JScrollPane TOOL_SELECTION_PANE = new JScrollPane();

		public static final AppList TOOL_SELECTION_LIST = new AppList();

		public static final List<AppSingleSelectionButton> TOOL_BUTTONS = new ArrayList<AppSingleSelectionButton>();

		private static AppSingleSelectionButton selectedButton = null;

	}

}
