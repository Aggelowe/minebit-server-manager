package eu.aggelowe.projects.mbsm.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a new {@link ArrayList} which can only be used for
 * instances of {@link INamed} and contains a lot of methods to utilise them.
 * 
 * @author Aggelowe
 *
 * @param <InputType> The input type of the {@link ArrayList}
 */
public class NamedArrayList<NamedType extends INamed> extends ArrayList<NamedType> {

	/**
	 * This constructor constructs a new {@link ArrayList} which can only be used
	 * for instances of {@link INamed} and contains a lot of methods to utilise
	 * them.
	 * 
	 * @author Aggelowe
	 */
	public NamedArrayList() {
		super();
	}

	/**
	 * This constructor constructs a new {@link ArrayList} which can only be used
	 * for instances of {@link INamed} and contains a lot of methods to utilise
	 * them.
	 * 
	 * @author Aggelowe
	 *
	 * @param initialCapacity The initial capacity of the {@link ArrayList}
	 */
	public NamedArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * This constructor constructs a new {@link ArrayList} which can only be used
	 * for instances of {@link INamed} and contains a lot of methods to utilise
	 * them.
	 * 
	 * @author Aggelowe
	 *
	 * @param collection The initial elements of the list
	 */
	public NamedArrayList(Collection<NamedType> collection) {
		super(collection);
	}

	/**
	 * This method should return true if the given name is bound to any of the
	 * elements contained in the list.
	 * 
	 * @param name The given name
	 * @return If the given name is bound to any of the elements
	 */
	public boolean containsNamedObject(String name) {
		for (Object object : this) {
			if (object instanceof INamed) {
				INamed namedObject = (INamed) object;
				if (namedObject.getObjectName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method should return the {@link INamed} object with the given name if
	 * the given name is bound to any of the elements contained in the list.
	 * 
	 * @param name The given name
	 * @return The {@link INamed} object with the given name.
	 */
	public INamed getNamedObject(String name) {
		for (Object object : this) {
			if (object instanceof INamed) {
				INamed namedObject = (INamed) object;
				if (namedObject.getObjectName().equals(name)) {
					return namedObject;
				}
			}
		}
		return null;
	}

	private static final long serialVersionUID = -6079184179503772822L;

}
