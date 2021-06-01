package eu.aggelowe.projects.tbsm.gui.managment.toolbars;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.ImageIcon;

import eu.aggelowe.projects.tbsm.TBSM;
import eu.aggelowe.projects.tbsm.gui.GuiManager;
import eu.aggelowe.projects.tbsm.gui.components.AppButton;
import eu.aggelowe.projects.tbsm.util.AppUtils;
import eu.aggelowe.projects.tbsm.util.ExitStatus;
import eu.aggelowe.projects.tbsm.util.interfaces.IAction;

/**
 * This class is used to customise the window operation bar's component.
 */
public final class OperationBar {

	public static final Dimension MINIMISE_BUTTON_SIZE = new Dimension(16, 16);

	public static final ImageIcon MINIMISE_BUTTON_IMAGE = AppUtils.resizeImageIcon(new ImageIcon(AppUtils.getResource("assets/gui/minimise_button.png")), MINIMISE_BUTTON_SIZE);

	public static final IAction MINIMIZE_BUTTON_ACTION = new IAction() {
		@Override
		public void execute() {
			GuiManager.WINDOW.setState(Frame.ICONIFIED);
		}
	};

	public static final AppButton MINIMISE_BUTTON = new AppButton(MINIMISE_BUTTON_IMAGE, MINIMIZE_BUTTON_ACTION);

	/**
	 * This method is used to setup the minimise button of the application.
	 */
	public static void setupMinimiseButton() {
		MINIMISE_BUTTON.setMinimumSize(MINIMISE_BUTTON_SIZE);
		MINIMISE_BUTTON.setPreferredSize(MINIMISE_BUTTON_SIZE);
		MINIMISE_BUTTON.setMaximumSize(MINIMISE_BUTTON_SIZE);
		MINIMISE_BUTTON.setOpaque(false);
		MINIMISE_BUTTON.setContentAreaFilled(false);
		MINIMISE_BUTTON.setBorderPainted(false);
		MINIMISE_BUTTON.setFocusPainted(false);
	}

	public static final Dimension EXIT_BUTTON_SIZE = new Dimension(16, 16);

	public static final ImageIcon EXIT_BUTTON_IMAGE = AppUtils.resizeImageIcon(new ImageIcon(AppUtils.getResource("assets/gui/exit_button.png")), EXIT_BUTTON_SIZE);

	public static final IAction EXIT_BUTTON_ACTION = new IAction() {
		@Override
		public void execute() {
			GuiManager.WINDOW.dispose();
			TBSM.exit(ExitStatus.GRACEFUL);
		}
	};

	public static final AppButton EXIT_BUTTON = new AppButton(EXIT_BUTTON_IMAGE, EXIT_BUTTON_ACTION);

	/**
	 * This method is used to setup the minimise button of the application.
	 */
	public static void setupExitButton() {
		EXIT_BUTTON.setMinimumSize(EXIT_BUTTON_SIZE);
		EXIT_BUTTON.setPreferredSize(EXIT_BUTTON_SIZE);
		EXIT_BUTTON.setMaximumSize(EXIT_BUTTON_SIZE);
		EXIT_BUTTON.setOpaque(false);
		EXIT_BUTTON.setContentAreaFilled(false);
		EXIT_BUTTON.setBorderPainted(false);
		EXIT_BUTTON.setFocusPainted(false);
	}
}
