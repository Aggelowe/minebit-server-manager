package eu.aggelowe.projects.mbsm.gui.components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JToolBar;

import eu.aggelowe.projects.mbsm.util.AppUtils;

/**
 * This class is used to create a new {@link JToolBar} which can be used as a
 * never ending vertical list with a specific width.
 * 
 * @author Aggelowe
 *
 */
public class AppList extends JToolBar {

	private int listWidth;

	/**
	 * This constructor constructs a new {@link JToolBar} which can be used as a
	 * never ending vertical list with a specific width.
	 *
	 */
	public AppList() {
		this(null, 300);
	}

	/**
	 * This constructor constructs a new {@link JToolBar} which can be used as a
	 * never ending vertical list with a specific width.
	 * 
	 * @param listWidth The width of the list
	 */
	public AppList(int listWidth) {
		this(null, listWidth);
	}

	/**
	 * This constructor constructs a new {@link JToolBar} which can be used as a
	 * never ending vertical list with a specific width.
	 * 
	 * @param name The name of the toolbar
	 */
	public AppList(String name) {
		this(name, 300);
	}

	/**
	 * This constructor constructs a new {@link JToolBar} which can be used as a
	 * never ending vertical list with a specific width.
	 * 
	 * @param listWidth The width of the list
	 * @param name      The name of the toolbar
	 * 
	 */
	public AppList(String name, int listWidth) {
		super(name, VERTICAL);
		this.listWidth = listWidth;
	}

	/**
	 * This method updates the size of the list based on the components added to
	 * this {@link AppList}.
	 */
	public void updateSize() {
		int componentHeight = 0;
		for (Component component : this.getComponents()) {
			if (component != null) {
				componentHeight = componentHeight + component.getHeight();
			}
		}
		AppUtils.setFinalComponentSize(this, new Dimension(listWidth, componentHeight));
	}

	public int getListWidth() {
		return listWidth;
	}

	public void setListWidth(int listWidth) {
		this.listWidth = listWidth;
	}

	private static final long serialVersionUID = 7666719126678653815L;

}
