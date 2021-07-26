package eu.aggelowe.projects.mbsm.gui.components;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import eu.aggelowe.projects.mbsm.util.properties.IPropertized;

/**
 * This class is used to create a new {@link JPanel} which implements the
 * {@link IPropertized} in order to have properties.
 * 
 * @author Aggelowe
 *
 */
public class AppPanel extends JPanel implements IPropertized {

	/**
	 * This constructor constructs a new {@link JPanel} which has properties in
	 * order to help with the construction of the application.
	 */
	public AppPanel() {
		super();
	}

	/**
	 * This constructor constructs a new {@link JPanel} which has properties in
	 * order to help with the construction of the application.
	 * 
	 * @param layout The layout of the {@link JPanel}
	 */
	public AppPanel(LayoutManager layout) {
		super(layout);
	}

	/**
	 * This constructor constructs a new {@link JPanel} which has properties in
	 * order to help with the construction of the application.
	 * 
	 * @param isDoubleBuffered If the {@link JPanel} is going to be double buffered.
	 */
	public AppPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * This constructor constructs a new {@link JPanel} which has properties in
	 * order to help with the construction of the application.
	 * 
	 * @param layout           The layout of the {@link JPanel}
	 * @param isDoubleBuffered If the {@link JPanel} is going to be double buffered.
	 */
	public AppPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	private static final long serialVersionUID = 1644925412797913014L;

}
