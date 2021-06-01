package eu.aggelowe.projects.tbsm.gui.managment;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import eu.aggelowe.projects.tbsm.gui.GuiManager;
import eu.aggelowe.projects.tbsm.gui.managment.toolbars.OperationBar;
import eu.aggelowe.projects.tbsm.util.AppUtils;

/**
 * This class is used to configure multiple components and contains a lot of
 * various methods and classes in order to set them up
 * 
 * @author Aggelowe
 */
public final class GuiComponentHandler {

	/**
	 * This method is used to set up the application's menu bar.
	 */
	public static void customiseWindowOperationBar() {
		Dimension seperatorSize = new Dimension(8, 25);
		JToolBar windowOperationBar = GuiLayout.AppComponents.WINDOW_OPERATION_BAR;
		windowOperationBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		windowOperationBar.setFloatable(false);
		windowOperationBar.setOpaque(false);
		windowOperationBar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		OperationBar.setupMinimiseButton();
		OperationBar.setupExitButton();
		windowOperationBar.addSeparator(seperatorSize);
		windowOperationBar.add(OperationBar.EXIT_BUTTON);
		windowOperationBar.addSeparator(seperatorSize);
		windowOperationBar.add(OperationBar.MINIMISE_BUTTON);
	}

	/**
	 * This method is used to set up the application's action bar.
	 */
	public static void customiseWindowActionBar() {
		Dimension seperatorSize = new Dimension(8, 50);
		JToolBar windowActionBar = GuiLayout.AppComponents.WINDOW_ACTION_BAR;
		windowActionBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		windowActionBar.setFloatable(false);
		windowActionBar.setOpaque(false);
		windowActionBar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		windowActionBar.addSeparator(seperatorSize);
		windowActionBar.add(new JLabel(AppUtils.resizeImageIcon(GuiManager.ComponentReference.APP_LOGO, new Dimension(44, 44))));
		windowActionBar.addSeparator(seperatorSize);
	}


}