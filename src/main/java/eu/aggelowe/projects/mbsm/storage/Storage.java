package eu.aggelowe.projects.mbsm.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URI;
import java.util.List;

import eu.aggelowe.projects.mbsm.util.exceptions.InvalidFileTypeException;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidInstanceException;
import eu.aggelowe.projects.mbsm.util.properties.IPropertized;
import eu.aggelowe.projects.mbsm.util.properties.Property;

/**
 * This class is used to manage the storage files of the application.
 * 
 * @author Aggelowe
 *
 */
public class Storage implements IPropertized, Serializable {

	private final File file;

	/**
	 * This constructor constructs a storage files used to store information for the
	 * application.
	 * 
	 * @param path The path of the storage file.
	 *
	 */
	public Storage(String path) {
		this(new File(path));
	}

	/**
	 * This constructor constructs a storage files used to store information for the
	 * application.
	 * 
	 * @param path The path of the storage file.
	 *
	 */
	public Storage(URI path) {
		this(new File(path));
	}

	/**
	 * This constructor constructs a storage files used to store information for the
	 * application.
	 * 
	 * @param path The storage file.
	 *
	 */
	public Storage(File file) {
		this.file = file;
	}

	/**
	 * This method saves the properties of this object to the given file.
	 *
	 * @throws Exception The exceptions thrown from the method.
	 */
	public void save() throws Exception {
		if (!file.exists()) {
			file.createNewFile();
		} else if (file.isDirectory()) {
			throw new InvalidFileTypeException();
		}
		OutputStream saveStream = new FileOutputStream(file);
		ObjectOutputStream objectSaveStream = new ObjectOutputStream(saveStream);
		objectSaveStream.writeObject(this.getProperties());
		objectSaveStream.flush();
		objectSaveStream.close();
	}

	/**
	 * This method loads the properties of this object from the given file.
	 *
	 * @throws Exception The exceptions thrown from the method.
	 */
	public void load() throws Exception {
		if (!file.exists()) {
			throw new FileNotFoundException("The given file was not found.");
		}
		InputStream loadStream = new FileInputStream(file);
		ObjectInputStream objectLoadStream = new ObjectInputStream(loadStream);
		Object inputObject = objectLoadStream.readObject();
		List<Property> properties;
		if (inputObject instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<Property> castedProperties = (List<Property>) inputObject;
			properties = castedProperties;
			objectLoadStream.close();
		} else {
			objectLoadStream.close();
			throw new InvalidInstanceException("The object obtained from the file is not a property list.");
		}
		for (Property property : properties) {
			final String name = property.getName();
			final String value = property.getValue();
			IPropertized.super.setPropertyValue(name, value);
		}
	}

	/**
	 * This method returns the given file.
	 *
	 * @return The given file
	 */
	public File getFile() {
		return file;
	}

	private static final long serialVersionUID = 6482394744839466642L;

}
