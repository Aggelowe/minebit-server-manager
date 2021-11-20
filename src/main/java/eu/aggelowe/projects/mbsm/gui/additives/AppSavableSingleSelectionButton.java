package eu.aggelowe.projects.mbsm.gui.additives;

import java.util.List;

import eu.aggelowe.projects.mbsm.gui.popups.UnsavedObjectPopup;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ToolViewer;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class represents a {@link AppButton} that belongs to a certain group
 * with other {@link AppSingleSelectionButton} objects which after each other
 * when one of them gets clicked that throws a {@link UnsavedObjectPopup} to
 * verify that the target object can be saved.
 * 
 * @author Aggelowe
 *
 */
public abstract class AppSavableSingleSelectionButton extends AppSingleSelectionButton {

	public AppSavableSingleSelectionButton(String text, List<AppSingleSelectionButton> buttonGroup) {
		super(text, buttonGroup);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void select() {
		if (!ToolViewer.isChanged()) {
			super.select();
		} else {
			IAction saveAction = new IAction() {

				@Override
				public void execute() {
					ToolViewer.save();
					AppSavableSingleSelectionButton.super.select();
					ToolViewer.setChanged(false);
				}
			};
			IAction discardAction = new IAction() {

				@Override
				public void execute() {
					AppSavableSingleSelectionButton.super.select();
					ToolViewer.setChanged(false);
				}
			};
			UnsavedObjectPopup popup = new UnsavedObjectPopup("server", saveAction, discardAction);
			popup.show();
		}
	}

	private static final long serialVersionUID = -1588801886535717830L;

}
