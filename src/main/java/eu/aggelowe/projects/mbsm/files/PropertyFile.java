package eu.aggelowe.projects.mbsm.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.DataSet;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidParameterException;

/**
 * This class represents a {@link File} that is used read from and write to the
 * given properties files.
 * 
 * @param file              The given property file
 * @param defaultProperties The default settings
 */
public class PropertyFile implements IFile {

	private final String comment;
	private final String file;
	private final InputStream inputStream;
	private final OutputStream outputStream;
	private final Properties propertiesFile = new Properties();

	/**
	 * This constructor constructs a new {@link IFile} that is used read from and
	 * write to the given properties files.
	 * 
	 * @param file              The given property file
	 * @param defaultProperties The default settings
	 */
	public PropertyFile(String comment, String file, String defaultFile) {
		this.comment = comment;
		this.file = file;
		if (new File(file).isDirectory()) {
			new InvalidParameterException("The given file is a directory").printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		if (!new File(file).exists()) {
			try {
				new File(file).createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
				MBSM.exit(ExitStatus.ERROR);
			}
		}
		this.inputStream = FileInit.getFileInputStream(file);
		this.outputStream = FileInit.getFileOutputStream(file);
		if (defaultFile != null) {
			Properties defaultPropertiesFile = new Properties();
			try {
				InputStream defaultInputStream = AppUtils.getResourceAsStream(defaultFile);
				defaultPropertiesFile.load(defaultInputStream);
			} catch (IOException exception) {
				exception.printStackTrace();
				MBSM.exit(ExitStatus.ERROR);
			}
			for (Object object : Collections.list(defaultPropertiesFile.keys())) {
				if (object instanceof String) {
					String key = (String) object;
					String value = defaultPropertiesFile.getProperty(key);
					this.propertiesFile.setProperty(key, value);
				}
			}
		}
	}

	public List<DataSet<String>> getProperties() {
		List<DataSet<String>> properties = new ArrayList<DataSet<String>>();
		for (Object object : Collections.list(propertiesFile.keys())) {
			if (object instanceof String) {
				String key = (String) object;
				String value = propertiesFile.getProperty(key);
				properties.add(new DataSet<String>(key, value));
			}
		}
		return properties;
	}
	
	public String getDataValue(String value) {
		return propertiesFile.getProperty(value);
	}

	public void setDataValue(DataSet<String> dataSet) {
		propertiesFile.setProperty(dataSet.getName(), dataSet.getData());
	}

	/**
	 * This method loads all the properties from the given file.
	 */
	@Override
	public void load() {
		try {
			propertiesFile.load(inputStream);
			inputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	/**
	 * This method saves all the properties to the given file.
	 */
	@Override
	public void save() {
		FileInit.emptyTextFile(file);
		try {
			propertiesFile.store(outputStream, comment);
			outputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	@Override
	public File getFile() {
		return new File(file);
	}

}
