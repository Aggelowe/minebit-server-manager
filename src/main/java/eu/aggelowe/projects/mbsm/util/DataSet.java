package eu.aggelowe.projects.mbsm.util;

/**
 * This class is used to store multiple data of multiple types easily.
 * 
 * @author Aggelowe
 * 
 * @param <DataType> The data of the property
 *
 */
public class DataSet<DataType> implements INamed {

	private final String name;
	private DataType data;

	/**
	 * This constructor constructs a new object which is used to store data values
	 * matching to a specific property name.
	 * 
	 * @param name The name of the property
	 * @param data The data of the property
	 */
	public DataSet(String name, DataType data) {
		this.name = name;
		this.data = data;
	}

	public String getObjectName() {
		return name;
	}

	public DataType getData() {
		return data;
	}

	public void setData(DataType data) {
		this.data = data;
	}
	
}
