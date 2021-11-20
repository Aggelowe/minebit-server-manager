package eu.aggelowe.projects.mbsm.gui.popups;

import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class is used to create a new {@link Popup} that asks the user if he is
 * sure to delete the given object.
 * 
 * @author Aggelowe
 *
 */
public final class ConfirmDeletionPopup extends Popup {

	/**
	 * This constructor constructs a new {@link Popup} that asks the user if he is
	 * sure to delete the given object.
	 * 
	 * @param target       The type of the object that is going to get deleted.
	 * @param deleteAction What happens if the user confirms the deletion.
	 *
	 */
	public ConfirmDeletionPopup(String target, IAction deleteAction) {
		super("Are you sure you want to delete this " + target + "?");
		this.addButton("Cancel", HIDE_POPUP);
		this.addButton("Delete", deleteAction, true);
	}

}
