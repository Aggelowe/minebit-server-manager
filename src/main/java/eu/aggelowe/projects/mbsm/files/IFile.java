package eu.aggelowe.projects.mbsm.files;

import java.io.File;

/**
 * This class represents a {@link File} that contains non-specific data which
 * can be used to create complicated file readers and writers.
 * 
 * @author Aggelowe
 *
 */

public interface IFile {

	/**
	 * This method is used to load the data of the file.
	 */
	public void load();

	/**
	 * This method is used to save the data of the file.
	 */
	public void save();

	/**
	 * This class is used to determine the file which this object represents
	 * 
	 * @return The represented file.
	 */
	public File getFile();

}
