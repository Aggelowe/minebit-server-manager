package eu.aggelowe.projects.mbsm.gui.additives;

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
	private int componentHeight = 30;
	
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
		AppUtils.setFinalComponentSize(this, new Dimension(listWidth, this.getComponents().length * componentHeight));
		this.validate();
	}

	public int getListWidth() {
		return listWidth;
	}
	
	public int getComponentHeight() {
		return componentHeight;
	}

	public void setListWidth(int listWidth) {
		this.listWidth = listWidth;
	}
	
	public void setComponentHeight(int componentHeight) {
		this.componentHeight = componentHeight;
	}

	private static final long serialVersionUID = 7666719126678653815L;

}
