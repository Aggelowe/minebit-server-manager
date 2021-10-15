package eu.aggelowe.projects.mbsm.util;

import eu.aggelowe.projects.mbsm.util.interfaces.IDynamicObject;

/**
 * This class is represents a new {@link Thread} which repeats the given
 * {@link #repetitiveAction} over and over until the action return true.
 * 
 * @author Aggelowe
 *
 */
public final class RepetitiveProcess {

	private boolean isStopping = false;

	private final IDynamicObject<Boolean> repetitiveAction;

	private final Thread process = new Thread(new Runnable() {
		@Override
		public void run() {
			while (!isStopping && !repetitiveAction.obtain()) {
			}
			isStopping = false;
		}
	});

	/**
	 * This constructor constructs a new Process which repeats the given
	 * {@link #repetitiveAction} over and over until the action return true.
	 * 
	 * @param repetitiveAction The action given to execute
	 *
	 */
	public RepetitiveProcess(IDynamicObject<Boolean> repetitiveAction) {
		this("Repetitive Process", repetitiveAction);
	}

	/**
	 * This constructor constructs a new Process which repeats the given
	 * {@link #repetitiveAction} over and over until the action return true.
	 * 
	 * @param repetitiveAction The action given to execute
	 *
	 */
	public RepetitiveProcess(String name, IDynamicObject<Boolean> repetitiveAction) {
		this.repetitiveAction = repetitiveAction;
		this.process.setName(name);
	}

	/**
	 * This method starts the thread used for this {@link RepetitiveProcess} object.
	 */
	public void start() {
		process.start();
	}

	/**
	 * This method ends the {@link #repetitiveAction} loop.
	 */
	public void stop() {
		isStopping = true;
	}

	/**
	 * This method sets the priority of the thread.
	 * 
	 * @param priority The priority of the thread
	 */
	public void setPriority(int priority) {
		process.setPriority(priority);
	}

	/**
	 * This method returns the priority of the thread.
	 * 
	 * @return The priority of the thread
	 */
	public int getPriority(int priority) {
		return process.getPriority();
	}

}
