package eu.aggelowe.projects.mbsm.util.properties;

import java.io.Serializable;

/**
 * This class is used to create properties in order to store and get multiple
 * data easily.
 * 
 * @author Aggelowe
 */
public final class Property implements Serializable {

	private final IPropertized owner;
	private final String name;
	private String value;

	/**
	 * This constructor constructs properties in order to store and get multiple
	 * data easily.
	 * 
	 * @param name The name of the property
	 */
	public Property(IPropertized owner, String name) {
		this(owner, name, null);
	}

	/**
	 * This constructor constructs properties in order to store and get multiple
	 * data easily.
	 * 
	 * @param name  The name of the property
	 * @param value The value of the property
	 */
	public Property(IPropertized owner, String name, String value) {
		this.name = name;
		this.value = value;
		this.owner = owner;
	}

	/**
	 * This method returns the owner {@link IPropertized} object of the property.
	 * 
	 * @return The owner {@link IPropertized} object of the property.
	 */
	public IPropertized getOwner() {
		return owner;
	}

	/**
	 * This method returns the name of the property.
	 * 
	 * @return The name of the property
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method returns the value of the property.
	 * 
	 * @return The value of the property
	 */
	public String getValue() {
		return value;
	}

	/**
	 * This method sets the value of the property.
	 * 
	 * @param value The value of the property
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	private static final long serialVersionUID = -7428406607459834436L;

}
