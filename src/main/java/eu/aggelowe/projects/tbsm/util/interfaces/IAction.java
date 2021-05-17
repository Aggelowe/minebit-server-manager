package eu.aggelowe.projects.tbsm.util.interfaces;

/**
 * This interface is used to run specific commands whenever it is called mostly
 * when application events occur.
 * 
 * @author Aggelowe
 * @see IAction#execute()
 */
public interface IAction {

	/**
	 * This method is being called by other methods most commonly when events happen
	 * in the application. For example:
	 * 
	 * <p><code>
	 * if (actionExample instanceof IAction) {<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;((IAction) actionExample).execute();<br>
	 * }
	 * </code></p>
	 * 
	 */
	public void execute();

}
