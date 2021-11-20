package eu.aggelowe.projects.mbsm.gui.additives;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.Icon;

/**
 * This class represents a {@link AppButton} that belongs to a certain group
 * with other {@link AppSingleSelectionButton} objects which after each other
 * when one of them gets clicked.
 * 
 * @author Aggelowe
 *
 */
public abstract class AppSingleSelectionButton extends AppButton {

	private final List<AppSingleSelectionButton> buttonGroup;

	private boolean isSelected = false;

	/**
	 * This class constructs a new {@link AppButton} that belongs to a certain group
	 * with other {@link AppSingleSelectionButton} objects which after each other
	 * when one of them gets clicked.
	 * 
	 * @author Aggelowe
	 * 
	 * @param buttonGroup The group the button belongs to.
	 */
	public AppSingleSelectionButton(List<AppSingleSelectionButton> buttonGroup) {
		this(null, null, buttonGroup);
	}

	/**
	 * This class constructs a new {@link AppButton} that belongs to a certain group
	 * with other {@link AppSingleSelectionButton} objects which after each other
	 * when one of them gets clicked.
	 * 
	 * @author Aggelowe
	 * 
	 * @param icon        The icon of the button.
	 * @param buttonGroup The group the button belongs to.
	 *
	 */
	public AppSingleSelectionButton(Icon icon, List<AppSingleSelectionButton> buttonGroup) {
		this(null, icon, buttonGroup);
	}

	/**
	 * This class constructs a new {@link AppButton} that belongs to a certain group
	 * with other {@link AppSingleSelectionButton} objects which after each other
	 * when one of them gets clicked.
	 * 
	 * @author Aggelowe
	 *
	 * @param name        The text of the button.
	 * @param buttonGroup The group the button belongs to.
	 */
	public AppSingleSelectionButton(String name, List<AppSingleSelectionButton> buttonGroup) {
		this(name, null, buttonGroup);
	}

	/**
	 * This class constructs a new {@link AppButton} that belongs to a certain group
	 * with other {@link AppSingleSelectionButton} objects which after each other
	 * when one of them gets clicked.
	 * 
	 * @author Aggelowe
	 * 
	 * @param name        The text of the button.
	 * @param icon        The icon of the button.
	 * @param buttonGroup The group the button belongs to.
	 *
	 */
	public AppSingleSelectionButton(String name, Icon icon, List<AppSingleSelectionButton> buttonGroup) {
		super(name, icon);
		this.buttonGroup = buttonGroup;
		init();
	}

	/**
	 * This method should initialise the button.
	 */
	public void init() {
		if (buttonGroup.size() > 0) {
			if (isDefaultSelected() == true) {
				select();
			} else {
				onButtonDeselected();
			}
		} else {
			onButtonSelected();
		}
		buttonGroup.add(this);
	}

	/**
	 * This method should return true if this button will be selected by default.
	 */
	protected abstract boolean isDefaultSelected();

	/**
	 * This method is called when the button gets selected.
	 */
	protected void onButtonSelected() {

	}

	/**
	 * This method is called when the button gets deselected.
	 */
	protected void onButtonDeselected() {

	}

	@Override
	public final void actionPerformed(ActionEvent e) {
		this.select();
	}

	public final boolean isSelected() {
		return isSelected;
	}

	/**
	 * This method selects the button.
	 */
	public void select() {
		setSingleSelected();
		onButtonSelected();
	}

	/**
	 * This method selects the button without running the
	 * {@link #onButtonSelected()} method.
	 */
	public final void setSingleSelected() {
		if (isSelected == true) {
			return;
		}
		isSelected = true;
		for (AppSingleSelectionButton button : buttonGroup) {
			if ((button != null) && (button != this)) {
				button.onButtonDeselected();
				button.isSelected = false;
			}
		}
	}

	private static final long serialVersionUID = -5736815643631198779L;

}
