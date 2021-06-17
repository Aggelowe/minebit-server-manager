package eu.aggelowe.projects.tbsm.gui.components;

import java.awt.GraphicsConfiguration;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import eu.aggelowe.projects.tbsm.TBSM;
import eu.aggelowe.projects.tbsm.util.ExitStatus;
import eu.aggelowe.projects.tbsm.util.interfaces.IAction;

/**
 * This class is used to create a new {@link JFrame} which uses the closing
 * method of the executable and runs the given actions before the closure takes
 * place.
 * 
 * @author Aggelowe
 *
 */
public final class AppFrame extends JFrame {

	private final IAction[] closeActions;

	/**
	 * This constructor constructs a new {@link JFrame} which uses the closing
	 * method of the executable and runs the given actions before the closure takes
	 * place.
	 * 
	 * @param closeActions The actions ran before the closure occurs.
	 *
	 */
	public AppFrame(IAction... closeActions) {
		this(null, null, closeActions);
	}

	/**
	 * This constructor constructs a new {@link JFrame} which uses the closing
	 * method of the executable and runs the given actions before the closure takes
	 * place.
	 * 
	 * @param title        The name of the frame.
	 * @param closeActions The actions ran before the closure occurs.
	 *
	 */
	public AppFrame(String title, IAction... closeActions) {
		this(title, null, closeActions);
	}

	/**
	 * This constructor constructs a new {@link JFrame} which uses the closing
	 * method of the executable and runs the given actions before the closure takes
	 * place.
	 * 
	 * @param graphicsConfiguration The {@link GraphicsConfiguration} used for the
	 *                              frame.
	 * @param closeActions          The actions ran before the closure occurs.
	 *
	 */
	public AppFrame(GraphicsConfiguration graphicsConfiguration, IAction... closeActions) {
		this(null, graphicsConfiguration, closeActions);
	}

	/**
	 * This constructor constructs a new {@link JFrame} which uses the closing
	 * method of the executable and runs the given actions before the closure takes
	 * place.
	 * 
	 * @param title                 The name of the frame.
	 * @param graphicsConfiguration The {@link GraphicsConfiguration} used for the
	 *                              frame.
	 * @param closeActions          The actions ran before the closure occurs.
	 * 
	 *
	 */
	public AppFrame(String title, GraphicsConfiguration graphicsConfiguration, IAction... closeActions) {
		super(title, graphicsConfiguration);
		this.closeActions = closeActions;
	}

	@Override
	protected final void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			for (IAction action : this.closeActions) {
				action.execute();
			}
			dispose();
			TBSM.exit(ExitStatus.GRACEFUL);
		}
	}

	private static final long serialVersionUID = -7584865893918465747L;

}
