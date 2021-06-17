package eu.aggelowe.projects.tbsm.util.interfaces;

/**
 * This class is used to return the object wanted using the {@link #obtain()}
 * method.
 * 
 * @author Aggelowe
 *
 * @param <ObjectType> The type of object which is going to be obtained.
 */
public interface IDynamicObject<InputObjectType, OutputObjectType> {

	/**
	 * This class is used to return an object of which the type is given on the
	 * construction of the class.
	 * 
	 * @param inputObject The object given used for the processing of the application
	 * @return The object returned from running this method.
	 */
	public OutputObjectType obtain(InputObjectType inputObject);

}
