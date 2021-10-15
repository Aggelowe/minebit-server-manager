package eu.aggelowe.projects.mbsm.gui.additives;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.TripleObject;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

/**
 * This class represents a new {@link AppButton} that has multiple forms and
 * changes to the next one every time it gets clicked.
 * 
 * @author Aggelowe
 *
 */
public class AppCyclableButton extends AppButton {

	private final TripleObject<String, Icon, IAction>[] buttonData;

	private int counter = 0;

	/**
	 * This constructor constructs a new {@link AppButton} that has multiple forms
	 * and changes to the next one every time it gets clicked.
	 *
	 * @param buttonData The data of the button forms.
	 */
	public AppCyclableButton(TripleObject<String, Icon, IAction>... buttonData) {
		if (buttonData.length == 0) {
			buttonData[0] = new TripleObject<String, Icon, IAction>(null, null, null);
		}
		this.buttonData = buttonData;
		this.setText(this.buttonData[0].getFirstObject());
		this.setIcon(this.buttonData[0].getSecondObject());
		if (this.buttonData[0].getThirdObject() != null) {
			this.buttonData[0].getThirdObject().execute();
		}
	}

	/**
	 * This method sets the form of the button to the next one in the array. If
	 * there are no forms remaining then the form gets back to 0.
	 */
	public void next() {
		this.counter++;
		if (this.counter >= this.buttonData.length) {
			this.counter = 0;
		}
		this.setText(this.buttonData[this.counter].getFirstObject());
		this.setIcon(this.buttonData[this.counter].getSecondObject());
		if (this.buttonData[this.counter].getThirdObject() != null) {
			this.buttonData[this.counter].getThirdObject().execute();
		}
	}

	/**
	 * This method sets the form of the button to the previous one in the array. If
	 * there are no previous forms then the form gets back to the top one.
	 */
	public void prev() {
		this.counter--;
		if (this.counter < 0) {
			this.counter = this.buttonData.length - 1;
		}
		this.setText(this.buttonData[this.counter].getFirstObject());
		this.setIcon(this.buttonData[this.counter].getSecondObject());
		if (this.buttonData[this.counter].getThirdObject() != null) {
			this.buttonData[this.counter].getThirdObject().execute();
		}
	}

	public int getCounter() {
		return counter;
	}

	/**
	 * This method sets the form of the button to a specific form in the array.
	 */
	public void setCounter(int counter) {
		int tmpCounter = new Integer(counter);
		tmpCounter = AppUtils.getMinNumber(tmpCounter, this.buttonData.length);
		tmpCounter = AppUtils.getMaxNumber(tmpCounter, 0);
		this.counter = tmpCounter;
		this.setText(this.buttonData[this.counter].getFirstObject());
		this.setIcon(this.buttonData[this.counter].getSecondObject());
		if (this.buttonData[this.counter].getThirdObject() != null) {
			this.buttonData[this.counter].getThirdObject().execute();
		}
	}

	@Override
	public final void actionPerformed(ActionEvent e) {
		this.next();
	}

	private static final long serialVersionUID = -5097713170769615372L;

}
