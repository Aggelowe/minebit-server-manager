package eu.aggelowe.projects.tbsm.gui;

import java.awt.BorderLayout;

import javax.swing.JToolBar;

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
		GuiLayout.setupMenuBar();
		GuiManager.MAINFRAME.add(AppComponents.MENU_BAR, BorderLayout.NORTH);
	}

	/**
	 * This method is used to setup the menu bar of the application in order to make
	 * it work and operational.
	 */
	private static void setupMenuBar() {
		AppComponents.MENU_BAR.setFloatable(false);
		AppComponents.MENU_BAR.setOpaque(false);
		AppComponents.MENU_BAR.setSize(100,100);
	}

	/**
	 * This class contains all of the application components in order to keep them
	 * organised in one class.
	 * 
	 * @author Aggelowe
	 */
	public static class AppComponents {

		public static final JToolBar MENU_BAR = new JToolBar(JToolBar.HORIZONTAL);

		public static final JToolBar MAIN_TOOL_BAR = new JToolBar(JToolBar.HORIZONTAL);

	}

}
