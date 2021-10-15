package eu.aggelowe.projects.mbsm.util;

/**
 * This class represents two new objects and can be used in returning multiple
 * types of objects in a method.
 * 
 * @author Aggelowe
 *
 * @param <FirstObjectType>  The object type of the first object.
 * @param <SecondObjectType> The object type of the second object.
 */
public class DoubleObject<FirstObjectType, SecondObjectType> {

	private final FirstObjectType firstObject;
	private final SecondObjectType secondObject;

	/**
	 * This constructor constructs an object that contains another two objects which
	 * can be used in returning multiple types of objects in a method.
	 *
	 * @param firstObject The first object.
	 * @param secondObject The second object.
	 */
	public DoubleObject(FirstObjectType firstObject, SecondObjectType secondObject) {
		this.firstObject = firstObject;
		this.secondObject = secondObject;
	}

	public FirstObjectType getFirstObject() {
		return firstObject;
	}

	public SecondObjectType getSecondObject() {
		return secondObject;
	}

}
