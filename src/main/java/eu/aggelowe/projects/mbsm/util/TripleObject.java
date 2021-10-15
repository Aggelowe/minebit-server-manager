package eu.aggelowe.projects.mbsm.util;

/**
 * This class represents three new objects and can be used in returning multiple
 * types of objects in a method.
 * 
 * @author Aggelowe
 *
 * @param <FirstObjectType>  The object type of the first object.
 * @param <SecondObjectType> The object type of the second object.
 * @param <ThirdObjectType>  The object type of the third object.
 */
public class TripleObject<FirstObjectType, SecondObjectType, ThirdObjectType> extends DoubleObject<FirstObjectType, SecondObjectType> {

	private final ThirdObjectType thirdObject;

	/**
	 * This constructor constructs an object that contains another three objects
	 * which can be used in returning multiple types of objects in a method.
	 *
	 * @param firstObject  The first object.
	 * @param secondObject The second object.
	 * @param thirdObject  The third object.
	 */
	public TripleObject(FirstObjectType firstObject, SecondObjectType secondObject, ThirdObjectType thirdObject) {
		super(firstObject, secondObject);
		this.thirdObject = thirdObject;
	}

	public ThirdObjectType getThirdObject() {
		return thirdObject;
	}

}
