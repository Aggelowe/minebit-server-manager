package eu.aggelowe.projects.mbsm.gui.additives;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class represents a {@link JButton} shaped for this application as it
 * contains extra features such as multiple custom actions.
 * 
 * @author Aggelowe
 *
 */
public class AppButton extends JButton implements ActionListener {

	private final IAction[] actions;

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
	
	private static final long serialVersionUID = 268902900084298268L;
	
}
