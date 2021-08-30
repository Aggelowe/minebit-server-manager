package eu.aggelowe.projects.mbsm.util.interfaces;

/**
 * This interface is used to return the object wanted using the {@link #obtain()}
 * method.
 * 
 * @author Aggelowe
 *
 * @param <OutputObjectType> The type of object which is going to be obtained.
 */
public interface IDynamicObject<OutputObjectType> {

	/**
	 * This class is used to return an object of which the type is given on the
	 * construction of the class.
	 * 
	 * @param inputObject The object given used for the processing of the application
	 * @return The object returned from running this method.
	 */
	public OutputObjectType obtain();

}
