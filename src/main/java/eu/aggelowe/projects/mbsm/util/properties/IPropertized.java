package eu.aggelowe.projects.mbsm.util.properties;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface is used to manage properties of the objects which implement it
 * using the {@link Property} class.
 * 
 * @author Aggelowe
 *
 */
public interface IPropertized {

	/**
	 * This method returns all the properties of this object.
	 * 
	 * @return
	 */
	public default List<Property> getProperties() {
		List<Property> properties = new ArrayList<Property>();
		for (Property property : PropertyManager.getProperties()) {
			if (property.getOwner() == this) {
				properties.add(property);
			}
		}
		return properties;
	}

	/**
	 * This method is used to retrieve a method from the property list using the
	 * name given.
	 * 
	 * @param name The name of the property.
	 * @return The property retrieved from the list.
	 */
	public default Property getProperty(String name) {
		return PropertyManager.getProperty(this, name);
	}

	/**
	 * This method is used to get the value of the property retrieved by the given
	 * name.
	 * 
	 * @param name The name of the property.
	 * @return The value of the given property.
	 */
	public default String getPropertyValue(String name) {
		return PropertyManager.getPropertyValue(this, name);
	}

	/**
	 * This method is used to set the value of the property retrieved by the given
	 * name.
	 * 
	 * @param name  The name of the property.
	 * @param value The value of the property.
	 */
	public default void setPropertyValue(String name, String value) {
		PropertyManager.setPropertyValue(this, name, value);
	}

	/**
	 * This method returns if the property with the given name is contained in this
	 * object.
	 * 
	 * @param name The name of the property.
	 * @return If this object contains a property with the given name.
	 */
	public default boolean containsProperty(String name) {
		return PropertyManager.containsProperty(this, name);
	}

}
