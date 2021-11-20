package eu.aggelowe.projects.mbsm.gui.popups;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import eu.aggelowe.projects.mbsm.gui.ComponentReference;
import eu.aggelowe.projects.mbsm.gui.ComponentReference.ComponentData;
import eu.aggelowe.projects.mbsm.gui.additives.AppButton;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.Reference;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class is used to create a new {@link JFrame} which can be to create new
 * pop-ups that can be displayed to inform or ask the user for certain
 * information.
 * 
 * @author Aggelowe
 *
 */
public abstract class Popup {

	protected final IAction HIDE_POPUP = new IAction() {
		
		@Override
		public void execute() {
			hide();
		}
	};
	
	public static final Dimension POPUP_SIZE = new Dimension(400, 110);

	private final JFrame POPUP_FRAME = new JFrame();

	private final Box MESSAGE_BOX = new Box(BoxLayout.X_AXIS);

	private final JTextPane POPUP_TEXT = new JTextPane();

	private final Box BUTTON_BOX = new Box(BoxLayout.X_AXIS);

	/**
	 * This constructor constructs a new {@link JFrame} which can be to create new
	 * pop-ups that can be displayed to inform or ask the user for certain
	 * information.
	 */
	Popup() {
		this("You just recieved a notification from " + Reference.LONG_NAME);
	}

	/**
	 * This constructor constructs a new {@link JFrame} which can be to create new
	 * pop-ups that can be displayed to inform or ask the user for certain
	 * information.
	 * 
	 * @param text The message of the pop-up
	 * 
	 */
	Popup(String text) {
		super();
		this.setupFrame();
		this.setupPopupText();
		this.setupMessageBox();
		this.setupButtonBox();
		this.setText(text);
	}

	/**
	 * This method sets up the frame of the pop-up.
	 */
	private final void setupFrame() {
		AppUtils.setFinalComponentSize(POPUP_FRAME, POPUP_SIZE);
		POPUP_FRAME.setType(Type.UTILITY);
		POPUP_FRAME.setUndecorated(true);
		POPUP_FRAME.getContentPane().setBackground(ComponentData.MAIN_COLOR);
		POPUP_FRAME.setLocationRelativeTo(ComponentReference.WINDOW);
		POPUP_FRAME.setLayout(new BoxLayout(POPUP_FRAME.getContentPane(), BoxLayout.Y_AXIS));
		POPUP_FRAME.getContentPane().add(Box.createRigidArea(new Dimension(POPUP_SIZE.width, 20)));
		POPUP_FRAME.getContentPane().add(MESSAGE_BOX);
		POPUP_FRAME.getContentPane().add(BUTTON_BOX);
		POPUP_FRAME.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 14));
		POPUP_FRAME.setIconImage(ComponentData.APP_LOGO.getImage());
	}

	/**
	 * This method sets up the message box of the pop-up, which contains the image
	 * of the application and the message of the pop-up.
	 */
	private final void setupMessageBox() {
		final JLabel barIcon = new JLabel(AppUtils.resizeImageIcon(ComponentData.APP_LOGO, new Dimension(48, 48)));
		MESSAGE_BOX.setOpaque(false);
		MESSAGE_BOX.add(barIcon);
		MESSAGE_BOX.add(Box.createRigidArea(new Dimension(10, 48)));
		MESSAGE_BOX.add(POPUP_TEXT);
	}

	/**
	 * This method sets up the message of the pop-up.
	 */
	private final void setupPopupText() {
		AppUtils.setFinalComponentSize(POPUP_TEXT, new Dimension(300, 48));
		POPUP_TEXT.setOpaque(false);
		POPUP_TEXT.getStyledDocument();
		POPUP_TEXT.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 14));
		POPUP_TEXT.setForeground(ComponentData.MAIN_TEXT_COLOR);
		POPUP_TEXT.setFocusable(false);
		AppUtils.centerText(POPUP_TEXT);
	}

	/**
	 * This method sets up the button box of the pop-up, containing all the buttons
	 * of the pop-up.
	 */
	private final void setupButtonBox() {
		BUTTON_BOX.setOpaque(false);
	}

	/**
	 * This method sets the message of the pop-up.
	 * 
	 * @param text The message of the pop-up.
	 */
	protected final void setText(String text) {
		POPUP_TEXT.setText(text != null ? text : "");
	}

	/**
	 * This method returns the message of the pop-up.
	 * 
	 * @return The message of the pop-up.
	 */
	public final String getText() {
		return POPUP_TEXT.getText();
	}

	/**
	 * This method adds a button to the pop-up.
	 * 
	 * @param text   The text of the button.
	 * @param action What the button should do when clicked.
	 */
	protected final void addButton(String text, IAction action) {
		this.addButton(text, action, false);
	}

	/**
	 * This method adds a button to the pop-up.
	 * 
	 * @param text        The text of the button.
	 * @param action      What the button should do when clicked.
	 * @param isDangerous If the action of the button can have irreversable or
	 *                    dangerous effects.
	 */
	protected final void addButton(String text, IAction action, boolean isDangerous) {
		AppButton button = new AppButton(text, action, HIDE_POPUP);
		Color textColor = ComponentData.MAIN_TEXT_COLOR;
		if (isDangerous) {
			textColor = ComponentData.DANGER_COLOR;
		}
		AppUtils.setFinalComponentSize(button, new Dimension(POPUP_SIZE.width / 4, 25));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(true);
		button.setFocusPainted(false);
		button.setFont(new Font(ComponentData.MAIN_FONT, Font.BOLD, 12));
		button.setBorder(new LineBorder(ComponentData.BORDER_COLOR, 2));
		button.setForeground(textColor);
		if (BUTTON_BOX.getComponents().length != 0) {
			BUTTON_BOX.add(Box.createRigidArea(new Dimension(15, 30)));
		}
		BUTTON_BOX.add(button);
	}

	/**
	 * This shows the pop-up.
	 */
	public final void show() {
		POPUP_FRAME.setVisible(true);
		ComponentReference.WINDOW.setEnabled(false);
	}

	/**
	 * This hides the pop-up.
	 */
	public final void hide() {
		POPUP_FRAME.setVisible(false);
		ComponentReference.WINDOW.setEnabled(true);
	}

}
