package eu.aggelowe.projects.mbsm.gui.tabs.servers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.EmptyBorder;

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
		System.out.println(serverId + " : " + toolName);
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
	}

}
