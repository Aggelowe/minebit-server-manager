package eu.aggelowe.projects.tbsm.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

/**
 * This class is used to manage the layout of the application's components and
 * to add important parts of the frame to the frame's registry.
 * 
 * @author Aggelowe
 */
public final class GuiLayout {

	/**
	 * This method is used to initialise the application's layout by registering
	 * specific components to the main frame and by setting up the main components
	 * used for the layout to work.
	 */
	public static void initAppLayout() {
		GuiLayout.setupWindowControlBar();
		GuiManager.MAINFRAME.add(AppComponents.WINDOW_CONTROL_BAR, BorderLayout.NORTH);
	}
	
	/**
	 * This method is used to setup the control bar of the application in order to make
	 * it work and operational.
	 */
	private static void setupWindowControlBar() {
		Color controlBarColor = new Color(0, 70, 190);
		Dimension controlBarSize = new Dimension(1200, 75);
		AppComponents.WINDOW_CONTROL_BAR.setMinimumSize(controlBarSize);
		AppComponents.WINDOW_CONTROL_BAR.setPreferredSize(controlBarSize);
		AppComponents.WINDOW_CONTROL_BAR.setMaximumSize(controlBarSize);
		AppComponents.WINDOW_CONTROL_BAR.setVisible(true);
		AppComponents.WINDOW_CONTROL_BAR.setOpaque(true);
		AppComponents.WINDOW_CONTROL_BAR.setBackground(controlBarColor);
		AppComponents.WINDOW_CONTROL_BAR.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		AppComponents.WINDOW_CONTROL_BAR.setLayout(new BorderLayout());
		GuiLayout.setupWindowOperationBar();
		GuiLayout.setupWindowActionBar();
		AppComponents.WINDOW_CONTROL_BAR.add(AppComponents.WINDOW_OPERATION_BAR, BorderLayout.NORTH);
		AppComponents.WINDOW_CONTROL_BAR.add(AppComponents.WINDOW_ACTION_BAR, BorderLayout.SOUTH);
	}

	/**
	 * This method is used to setup the operation bar of the application in order to make
	 * it work and operational.
	 */
	private static void setupWindowOperationBar() {
		Dimension operationBarSize = new Dimension(1200, 25);
		AppComponents.WINDOW_OPERATION_BAR.setMinimumSize(operationBarSize);
		AppComponents.WINDOW_OPERATION_BAR.setPreferredSize(operationBarSize);
		AppComponents.WINDOW_OPERATION_BAR.setMaximumSize(operationBarSize);
		GuiComponentHandler.customiseWindowOperationBar();
	}
	
	/**
	 * This method is used to setup the action bar of the application in order to make
	 * it work and operational.
	 */
	private static void setupWindowActionBar() {
		Dimension actionBarSize = new Dimension(1200, 50);
		AppComponents.WINDOW_ACTION_BAR.setMinimumSize(actionBarSize);
		AppComponents.WINDOW_ACTION_BAR.setPreferredSize(actionBarSize);
		AppComponents.WINDOW_ACTION_BAR.setMaximumSize(actionBarSize);
		GuiComponentHandler.customiseWindowActionBar();
	}

	/**
	 * This class contains all of the application major components in order to keep
	 * them organised in one class.
	 * 
	 * @author Aggelowe
	 */
	public static class AppComponents {

		public static final JPanel WINDOW_CONTROL_BAR = new JPanel();
		
		public static final JToolBar WINDOW_OPERATION_BAR = new JToolBar(JToolBar.HORIZONTAL);
		
		public static final JToolBar WINDOW_ACTION_BAR = new JToolBar(JToolBar.HORIZONTAL);

	}

}
