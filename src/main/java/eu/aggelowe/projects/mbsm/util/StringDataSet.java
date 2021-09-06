package eu.aggelowe.projects.mbsm.util;

/**
 * This class is used to store multiple {@link String} objects easily.
 * 
 * @author Aggelowe
 *
 */
public final class StringDataSet extends DataSet<String> {

	/**
	 * This constructor constructs a new object which is used to store {@link String} values
	 * matching to a specific property name.
	 * 
	 * @param name The name of the property
	 * @param value The value of the property
	 */
	public StringDataSet(String name, String value) {
		super(name, value);
	}

}
