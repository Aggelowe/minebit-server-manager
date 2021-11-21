package eu.aggelowe.projects.mbsm.gui.popups;

import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class is used to create a new {@link Popup} that asks the user if he
 * wants the written data to be saved or not before performing another action.
 * 
 * @author Aggelowe
 */
public class UnsavedObjectPopup extends Popup {

	/**
	 * This constructor constructs a new {@link Popup} that asks the user if he
	 * wants the written data to be saved or not before performing another action.
	 * 
	 * @param target        The type of the object that is going to get deleted.
	 * @param discardAction What happens if the user wants the changes to be saved.
	 * @param discardAction What happens if the user doens't want the changes to be
	 *                      saved.
	 *
	 */
	public UnsavedObjectPopup(String target, IAction saveAction, IAction discardAction) {
		super("Do you want to save the changes done to this " + target + "?");
		this.addButton("Save", saveAction, false);
		this.addButton("Don't Save", discardAction, true);
		this.addButton("Cancel", HIDE_POPUP);
	}

}
