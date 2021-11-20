package eu.aggelowe.projects.mbsm.gui.additives;

import eu.aggelowe.projects.mbsm.gui.popups.Popup;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class is used to create a new Button that views a specific {@link Popup}
 * when clicked.
 * 
 * @author Aggelowe
 */
public class AppPopupButton extends AppButton {

	/**
	 * This constructor constructs a new Button that views a specific {@link Popup}
	 * when clicked.
	 * 
	 * @param popup The popup to display
	 */
	public AppPopupButton(Popup popup) {
		this(null, popup);
	}
	
	/**
	 * This constructor constructs a new Button that views a specific {@link Popup}
	 * when clicked.
	 * 
	 * @param text  The text of the button
	 * @param popup The popup to display
	 */
	public AppPopupButton(String text, Popup popup) {
		super(text, new IAction() {

			@Override
			public void execute() {
				popup.show();
			}
		});
	}

	private static final long serialVersionUID = 5450737533240598242L;

}
