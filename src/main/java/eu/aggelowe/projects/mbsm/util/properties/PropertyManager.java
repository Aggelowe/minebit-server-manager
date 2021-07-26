package eu.aggelowe.projects.mbsm.util.properties;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to manage the properties of a specific object using the
 * {@link Property} class.
 * 
 * @author Aggelowe
 *
 */
public final class PropertyManager {

	private static final List<Property> PROPERTIES = new ArrayList<Property>();

	/**
	 * This method returns all the properties of all objects.
	 * 
	 * @return
	 */
	public static List<Property> getProperties() {
		return PROPERTIES;
	}

	/**
	 * This method is used to retrieve a method from the property list using the
	 * name and owner given.
	 * 
	 * @param owner The owner {@link IPropertized} object.
	 * @param name  The name of the property.
	 * @return The property retrieved from the list.
	 */
	public static Property getProperty(IPropertized owner, String name) {
		if (name == null || owner == null) {
			throw new RuntimeException("Owner or Name cannot be NULL!");
		}
		for (Property property : PROPERTIES) {
			if (property != null) {
				if (owner.equals(property.getOwner()) && name.equals(property.getName())) {
					return property;
				}
			}

		}
		return null;
	}

	/**
	 * This method is used to get the value of the property retrieved by the given
	 * name and owner.
	 * 
	 * @param owner The owner {@link IPropertized} object.
	 * @param name  The name of the property.
	 * @return The value of the given property.
	 */
	public static String getPropertyValue(IPropertized owner, String name) {
		final Property property = PropertyManager.getProperty(owner, name);
		if (property == null) {
			return null;
		}
		return property.getValue();
	}

	/**
	 * This method is used to set the value of the property retrieved by the given
	 * name and owner.
	 * 
	 * @param owner The owner {@link IPropertized} object.
	 * @param name  The name of the property.
	 * @param value The value of the property.
	 */
	public static void setPropertyValue(IPropertized owner, String name, String value) {
		if (value == null) {
			throw new RuntimeException("Value cannot be NULL!");
		}
		final Property property = PropertyManager.getProperty(owner, name);
		if (property != null) {
			PROPERTIES.remove(property);
		}
		PROPERTIES.add(new Property(owner, name, value));
	}

	/**
	 * This method returns if the property with the given name is contained in the
	 * owning object.
	 * 
	 * @param owner The owner {@link IPropertized} object.
	 * @param name  The name of the property.
	 * @return If the given owner contains a property with the given name.
	 */
	public static boolean containsProperty(IPropertized owner, String name) {
		final Property inputProperty = PropertyManager.getProperty(owner, name);
		if (inputProperty != null) {
			return true;
		}
		return false;
	}

}
