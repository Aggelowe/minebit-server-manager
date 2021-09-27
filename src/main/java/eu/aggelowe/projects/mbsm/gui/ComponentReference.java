package eu.aggelowe.projects.mbsm.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.gui.additives.AppButton;
import eu.aggelowe.projects.mbsm.gui.additives.AppDraggableToolbar;
import eu.aggelowe.projects.mbsm.gui.additives.AppFrame;
import eu.aggelowe.projects.mbsm.gui.additives.AppSingleSelectionButton;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.RepetitiveProcess;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;
import eu.aggelowe.projects.mbsm.util.interfaces.IDynamicObject;

/**
 * This class contains the most major components of the application as they must
 * be able to be seen by all components.
 * 
 * @author Aggelowe
 *
 */
public final class ComponentReference {

	public static final AppFrame WINDOW = new AppFrame();

	public static final JPanel MAINFRAME = new JPanel();

	public static final JPanel ACTION_PANEL = new JPanel();

	public static final AppDraggableToolbar WINDOW_OPERATIONS_BAR = new AppDraggableToolbar();

	public static final AppButton CLOSE_BUTTON = new AppButton(new IAction() {
		@Override
		public void execute() {
			MBSM.exit(ExitStatus.GRACEFUL);
		}
	});

	public static final AppButton MINIMISE_BUTTON = new AppButton(new IAction() {
		@Override
		public void execute() {
			WINDOW.setState(JFrame.ICONIFIED);
		}
	});

	public static final AppDraggableToolbar TAB_SELECTION_BAR = new AppDraggableToolbar();

	public static final List<AppSingleSelectionButton> TAB_BUTTONS = new ArrayList<AppSingleSelectionButton>();

	public static final AppSingleSelectionButton LATEST_TAB_BUTTON = new AppSingleSelectionButton(TAB_BUTTONS) {

		@Override
		protected void onButtonSelected() {
			setBorder(new MatteBorder(0, 0, 3, 0, new Color(125, 215, 230)));
			if (LATEST_TAB_PANEL == null) {
				RepetitiveProcess process = new RepetitiveProcess(new IDynamicObject<Boolean>() {
					@Override
					public Boolean obtain() {
						if (LATEST_TAB_PANEL == null) {
							return false;
						}
						LATEST_TAB_PANEL.setVisible(true);
						return true;
					}
				});
				process.start();
			} else {
				LATEST_TAB_PANEL.setVisible(true);
			}
		}

		@Override
		protected void onButtonDeselected() {
			setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
			if (LATEST_TAB_PANEL == null) {
				RepetitiveProcess process = new RepetitiveProcess(new IDynamicObject<Boolean>() {
					@Override
					public Boolean obtain() {
						if (LATEST_TAB_PANEL == null) {
							return false;
						}
						LATEST_TAB_PANEL.setVisible(false);
						return true;
					}
				});
				process.start();
			} else {
				LATEST_TAB_PANEL.setVisible(false);
			}
		}

		@Override
		protected boolean isDefaultSelected() {
			return true;
		}

		private static final long serialVersionUID = 673637536380188767L;

	};

	public static final AppSingleSelectionButton SERVERS_TAB_BUTTON = new AppSingleSelectionButton(TAB_BUTTONS) {

		@Override
		protected void onButtonSelected() {
			setBorder(new MatteBorder(0, 0, 3, 0, new Color(125, 215, 230)));
			if (SERVERS_TAB_PANEL == null) {
				RepetitiveProcess process = new RepetitiveProcess(new IDynamicObject<Boolean>() {
					@Override
					public Boolean obtain() {
						if (SERVERS_TAB_PANEL == null) {
							return false;
						}
						SERVERS_TAB_PANEL.setVisible(true);
						return true;
					}
				});
				process.start();
			} else {
				SERVERS_TAB_PANEL.setVisible(true);
			}
		}

		@Override
		protected void onButtonDeselected() {
			setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
			if (SERVERS_TAB_PANEL == null) {
				RepetitiveProcess process = new RepetitiveProcess(new IDynamicObject<Boolean>() {
					@Override
					public Boolean obtain() {
						if (SERVERS_TAB_PANEL == null) {
							return false;
						}
						SERVERS_TAB_PANEL.setVisible(false);
						return true;
					}
				});
				process.start();
			} else {
				SERVERS_TAB_PANEL.setVisible(false);
			}
		}

		@Override
		protected boolean isDefaultSelected() {
			return false;
		}

		private static final long serialVersionUID = 7010237715276254039L;

	};

	public static final AppSingleSelectionButton SETTINGS_TAB_BUTTON = new AppSingleSelectionButton(TAB_BUTTONS) {
		
		@Override
		protected void onButtonSelected() {
			setBorder(new MatteBorder(0, 0, 3, 0, new Color(125, 215, 230)));
			if (SETTINGS_TAB_PANEL == null) {
				RepetitiveProcess process = new RepetitiveProcess(new IDynamicObject<Boolean>() {
					@Override
					public Boolean obtain() {
						if (SETTINGS_TAB_PANEL == null) {
							return false;
						}
						SETTINGS_TAB_PANEL.setVisible(true);
						return true;
					}
				});
				process.start();
			} else {
				SETTINGS_TAB_PANEL.setVisible(true);
			}
		}

		@Override
		protected void onButtonDeselected() {
			setBorder(new MatteBorder(0, 0, 3, 0, ComponentData.ACTION_PANEL_COLOR));
			if (SETTINGS_TAB_PANEL == null) {
				RepetitiveProcess process = new RepetitiveProcess(new IDynamicObject<Boolean>() {
					@Override
					public Boolean obtain() {
						if (SETTINGS_TAB_PANEL == null) {
							return false;
						}
						SETTINGS_TAB_PANEL.setVisible(false);
						return true;
					}
				});
				process.start();
			} else {
				SETTINGS_TAB_PANEL.setVisible(false);
			}
		}

		@Override
		protected boolean isDefaultSelected() {
			return false;
		}

		private static final long serialVersionUID = -353924712070637614L;

	};

	public static final JPanel TAB_PANEL = new JPanel();

	public static final JPanel LATEST_TAB_PANEL = new JPanel();

	public static final JPanel SERVERS_TAB_PANEL = new JPanel();

	public static final JPanel SETTINGS_TAB_PANEL = new JPanel();

	/**
	 * This class contains a lot of component data important for the application to
	 * work.
	 * 
	 * @author Aggelowe
	 *
	 */
	public static final class ComponentData {

		/**
		 * The window's default size.
		 */
		public static final Dimension WINDOW_SIZE = new Dimension(1200, 675);

		/**
		 * The application's logo.
		 */
		public static final ImageIcon APP_LOGO = new ImageIcon(AppUtils.getResource("assets/icon.png"));

		/**
		 * The application's main color.
		 */
		public static final Color MAIN_COLOR = new Color(0, 35, 90);

		/**
		 * The application's main font.
		 */
		public static final String MAIN_FONT = "DejaVu Sans";

		/**
		 * The action panel's background color.
		 */
		public static final Color ACTION_PANEL_COLOR = new Color(0, 70, 190);

		/**
		 * The action panel's size.
		 */
		public static final Dimension ACTION_PANEL_SIZE = new Dimension(ComponentData.WINDOW_SIZE.width, 80);

		/**
		 * The size of the window operation buttons.
		 */
		public static final Dimension WINDOW_OPERATION_BUTTON_SIZE = new Dimension(16, 16);

		/**
		 * The action panel's size.
		 */
		public static final Dimension TAB_PANEL_SIZE = new Dimension(ComponentData.WINDOW_SIZE.width, 595);

	}

}
