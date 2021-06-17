package eu.aggelowe.projects.tbsm.gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.tbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.tbsm.gui.components.AppButton;
import eu.aggelowe.projects.tbsm.gui.components.AppFrame;
import eu.aggelowe.projects.tbsm.util.AppUtils;

/**
 * This class is used to setup the layout of the application and to call the
 * setup methods for each major components.
 * 
 * @author Aggelowe
 *
 */
public final class GuiLayoutSetup {

	public static final Logger GUI_LOGGER = LogManager.getLogger("GuiManager");

	/**
	 * This method is being called at the start of the application and is used to
	 * launch the user interface. This method should <b>only</b> be called by the
	 * main class as if it is run by anther class the interface may not work
	 * properly or window duplication could be caused.
	 */
	public static void initGui() {
		GUI_LOGGER.info("Drawing gui...");
		GUI_LOGGER.debug("Setting up the application's components and layout...");
		GuiLayoutSetup.setupComponents();
		GUI_LOGGER.debug("Showing frame...");
		ComponentReference.WINDOW.setVisible(true);
		GUI_LOGGER.info("Gui drawn sucessfully!");
	}

	/**
	 * This class is used to call the setup method of every component necessary.
	 */
	private static void setupComponents() {
		GuiLayoutSetup.setupWindowLayout();
		GuiLayoutSetup.setupMainframeLayout();
		GuiLayoutSetup.setupActionPanelLayout();
		GuiLayoutSetup.setupWindowOperationBarLayout();
		GuiLayoutSetup.setupCloseButtonLayout();
		GuiLayoutSetup.setupTabSelectionBarLayout();
	}

	/**
	 * This method is used to manage the layout of the application's main window and
	 * to set up it's look and feel.
	 */
	private static void setupWindowLayout() {
		final AppFrame window = ComponentReference.WINDOW;
		AppUtils.setFinalComponentSize(window, ComponentData.WINDOW_SIZE);
		GuiComponentCustomization.customizeWindow();
		window.getContentPane().add(ComponentReference.MAINFRAME);
	}

	/**
	 * This method is used to manage the layout of the application's main window.
	 */
	private static void setupMainframeLayout() {
		final JPanel mainframe = ComponentReference.MAINFRAME;
		mainframe.setLayout(new BorderLayout());
		AppUtils.setFinalComponentSize(mainframe, ComponentData.WINDOW_SIZE);
		GuiComponentCustomization.customizeMainframe();
		mainframe.add(ComponentReference.ACTION_PANEL, BorderLayout.NORTH);
	}

	/**
	 * This method is used to manage the action panel and to set up it's look and
	 * feel.
	 */
	private static void setupActionPanelLayout() {
		final JPanel actionPanel = ComponentReference.ACTION_PANEL;
		final LayoutManager panelLayout = new BorderLayout();
		AppUtils.setFinalComponentSize(actionPanel, ComponentData.ACTION_PANEL_SIZE);
		actionPanel.setLayout(panelLayout);
		GuiComponentCustomization.customizeActionPanel();
		actionPanel.add(ComponentReference.WINDOW_OPERATIONS_BAR, BorderLayout.NORTH);
		actionPanel.add(ComponentReference.TAB_SELECTION_BAR, BorderLayout.SOUTH);
	}

	/**
	 * This method is used to manage the window operation bar and to set up it's
	 * look and feel.
	 */
	private static void setupWindowOperationBarLayout() {
		final JToolBar windowOperationBar = ComponentReference.WINDOW_OPERATIONS_BAR;
		final Dimension barSize = new Dimension(ComponentReference.WINDOW.getWidth(), 25);
		windowOperationBar.setOrientation(JToolBar.HORIZONTAL);
		windowOperationBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		AppUtils.setFinalComponentSize(windowOperationBar, barSize);
		GuiComponentCustomization.customizeWindowOperationBar();
		windowOperationBar.addSeparator(new Dimension(4, 25));
		windowOperationBar.add(ComponentReference.CLOSE_BUTTON);
	}

	/**
	 * This method is used to manage the close button and to set up it's look and
	 * feel.
	 */
	private static void setupCloseButtonLayout() {
		final AppButton closeButton = ComponentReference.CLOSE_BUTTON;
		AppUtils.setFinalComponentSize(closeButton, ComponentData.WINDOW_OPERATION_BUTTON_SIZE);
		GuiComponentCustomization.customizeCloseButton();
	}

	/**
	 * This method is used to manage the tab selection bar and to set up it's look
	 * and feel.
	 */
	private static void setupTabSelectionBarLayout() {
		final JToolBar tabSelectionBar = ComponentReference.TAB_SELECTION_BAR;
		final Dimension barSize = new Dimension(ComponentReference.WINDOW.getWidth(), 55);
		tabSelectionBar.setOrientation(JToolBar.HORIZONTAL);
		AppUtils.setFinalComponentSize(tabSelectionBar, barSize);
		GuiComponentCustomization.customizeTabSelectionBar();
		tabSelectionBar.addSeparator(new Dimension(4, 25));
		final JLabel barIcon = new JLabel(AppUtils.resizeImageIcon(ComponentData.APP_LOGO, new Dimension((barSize.height / 5) * 4, (barSize.height / 5) * 4)));
		AppUtils.setFinalComponentSize(barIcon, new Dimension(barSize.height, barSize.height));
		tabSelectionBar.add(barIcon);
		tabSelectionBar.addSeparator(new Dimension(8, 25));
	}

}