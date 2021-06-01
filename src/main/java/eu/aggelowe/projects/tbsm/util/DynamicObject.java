package eu.aggelowe.projects.tbsm.util;

/**
 * This class is used to return the object wanted using the {@link #obtain()}
 * method.
 * 
 * @author Aggelowe
 *
 * @param <ObjectType> The type of object which is going to be obtained.
 */
public abstract class DynamicObject<ObjectType> {

	/**
	 * This class is used to return an object of which the type is given on the
	 * construction of the class.
	 * 
	 * @return The object returned from running this method.
	 */
	public abstract ObjectType obtain();

}
