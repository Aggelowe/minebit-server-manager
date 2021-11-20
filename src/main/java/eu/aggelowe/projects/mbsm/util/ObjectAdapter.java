package eu.aggelowe.projects.mbsm.util;

/**
 * This class is used to create a new {@link Object} that represents another
 * one.
 * 
 * @author Aggelowe
 * 
 * @param <ObjectType> The type of object to adapt.
 */
public class ObjectAdapter<ObjectType> {

	private ObjectType object;

	/**
	 * This constructor constructs a new {@link Object} that represents another one.
	 */
	public ObjectAdapter() {
		this(null);
	}

	/**
	 * This constructor constructs a new {@link Object} that represents another one.
	 * 
	 * @param object The starting object of the adapter
	 */
	public ObjectAdapter(ObjectType object) {
		this.object = object;
	}

	/**
	 * This method returns the currently adapted object.
	 * 
	 * @return The current object.
	 */
	public ObjectType get() {
		return object;
	}

	/**
	 * This method sets the currently adapted object the given one.
	 * 
	 * @param object The new adapted object.
	 */
	public void set(ObjectType object) {
		this.object = object;
	}

}
