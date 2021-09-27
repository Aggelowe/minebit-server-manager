package eu.aggelowe.projects.mbsm.gui.additives;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import eu.aggelowe.projects.mbsm.gui.ComponentReference;

/**
 * This class is used to create a new {@link JToolBar} which moves the main
 * {@link JFrame} based on the movement of the mouse using a
 * {@link MouseMotionListener}.
 * 
 * @author Aggelowe
 *
 */
public class AppDraggableToolbar extends JToolBar {

	private int xEventPosition = 0, yEventPosition = 0;

	/**
	 * This constructor constructs a new {@link JToolBar} which moves the main
	 * {@link JFrame} based on the movement of the mouse using a
	 * {@link MouseMotionListener}.
	 *
	 */
	public AppDraggableToolbar() {
		this(null, HORIZONTAL);
	}

	/**
	 * This constructor constructs a new {@link JToolBar} which moves the main
	 * {@link JFrame} based on the movement of the mouse using a
	 * {@link MouseMotionListener}.
	 * 
	 * @param orientation The orientation of the toolbar
	 */
	public AppDraggableToolbar(int orientation) {
		this(null, orientation);
	}

	/**
	 * This constructor constructs a new {@link JToolBar} which moves the main
	 * {@link JFrame} based on the movement of the mouse using a
	 * {@link MouseMotionListener}.
	 * 
	 * @param name The name of the toolbar
	 */
	public AppDraggableToolbar(String name) {
		this(name, HORIZONTAL);
	}

	/**
	 * This constructor constructs a new {@link JToolBar} which moves the main
	 * {@link JFrame} based on the movement of the mouse using a
	 * {@link MouseMotionListener}.
	 * 
	 * @param orientation The orientation of the toolbar
	 * @param name        The name of the toolbar
	 * 
	 */
	public AppDraggableToolbar(String name, int orientation) {
		super(name, orientation);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				AppDraggableToolbar.this.xEventPosition = event.getX();
				AppDraggableToolbar.this.yEventPosition = event.getY();
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent event) {
				ComponentReference.WINDOW.setLocation(event.getXOnScreen() - xEventPosition, event.getYOnScreen() - yEventPosition);
			}
		});
	}

	private static final long serialVersionUID = -5232417146999339345L;
}
