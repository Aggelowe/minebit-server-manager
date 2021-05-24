package eu.aggelowe.projects.tbsm.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import eu.aggelowe.projects.tbsm.util.interfaces.IAction;

/**
 * This class represents a {@link JButton} shaped for this application as it
 * contains extra features such as multiple custom actions.
 * 
 * @author Aggelowe
 *
 */
public class AppButton extends JButton implements ActionListener {

	private final IAction[] actions;

	private String latestText;
	private boolean isIconSetAsButton = false;

	/**
	 * This constructor constructs a customised version of a {@link JButton} as it
	 * contains extra features such as multiple custom actions.
	 * 
	 * @param actions The actions which are going to be executed when the button is
	 *                clicked.
	 */
	public AppButton(IAction... actions) {
		this(null, null, actions);
	}

	/**
	 * This constructor constructs a customised version of a {@link JButton} as it
	 * contains extra features such as multiple custom actions.
	 * 
	 * @param The     icon used as the background of the button.
	 * @param actions The actions which are going to be executed when the button is
	 *                clicked.
	 */
	public AppButton(Icon icon, IAction... actions) {
		this(null, icon, actions);
	}

	/**
	 * This constructor constructs a customised version of a {@link JButton} as it
	 * contains extra features such as multiple custom actions.
	 * 
	 * @param text    The text shown on the button.
	 * @param actions The actions which are going to be executed when the button is
	 *                clicked.
	 */
	public AppButton(String text, IAction... actions) {
		this(text, null, actions);
	}

	/**
	 * This constructor constructs a customised version of a {@link JButton} as it
	 * contains extra features such as multiple custom actions.
	 * 
	 * @param text    The text shown on the button.
	 * @param icon    The icon used as the background of the button.
	 * @param actions The actions which are going to be executed when the button is
	 *                clicked.
	 */
	public AppButton(String text, Icon icon, IAction... actions) {
		super(text, icon);
		this.actions = actions;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (IAction action : actions) {
			if (action != null) {
				action.execute();
			}
		}
	}

	/**
	 * This method is used to entirely remove any <i>Swing</i> visuals from the
	 * {@link JButton} and use the given picture as the button.
	 * 
	 * @param iconAsButton
	 */
	public void setIconAsButton(boolean iconAsButton) {
		if (this.getIcon() == null) {
			return;
		}
		this.setOpaque(!iconAsButton);
		this.setContentAreaFilled(!iconAsButton);
		this.setBorderPainted(!iconAsButton);
		this.setFocusPainted(!iconAsButton);
		if (iconAsButton == true) {
			this.setText(null);
		} else {
			this.setText(this.latestText);
		}
		this.isIconSetAsButton = iconAsButton;
	}

	@Override
	public void setText(String text) {
		if (text != null) {
			this.latestText = text;
		}
		super.setText(text);
	}

	/**
	 * @return The latest non-null text given to the button.
	 */
	public String getLatestText() {
		return latestText;
	}

	/**
	 * @return The actions given to run when the button is clicked.
	 */
	public IAction[] getActions() {
		return actions;
	}

	/**
	 * @return If the icon is set as a button.
	 */
	public boolean isIconSetAsButton() {
		return isIconSetAsButton;
	}
	
	private static final long serialVersionUID = 268902900084298268L;

}
