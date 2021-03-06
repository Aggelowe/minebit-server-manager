package eu.aggelowe.projects.mbsm.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.util.DataSet;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.exceptions.FileStructureException;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidParameterException;

/**
 * This class represents a new {@link IFile} that contains text in a special
 * format that constructs an object.
 * 
 * @author Aggelowe
 *
 */
public class TextObjectFile implements IFile {

	private final List<DataSet<String[]>> elements = new ArrayList<DataSet<String[]>>();

	private final String file;

	/**
	 * This constructor constructs a new {@link IFile} that contains text in a
	 * special format that constructs an object.
	 * 
	 * @author Aggelowe
	 *
	 */
	public TextObjectFile(String file, String defaultFile) {
		this.file = file;
		if (new File(file).isDirectory()) {
			new InvalidParameterException("The given file is a directory").printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		if (!new File(file).exists()) {
			try {
				new File(file).createNewFile();
				if (defaultFile != null) {
					FileReader reader = new FileReader(new File(defaultFile));
					String fileText = "";
					int charData;
					while ((charData = reader.read()) != -1) {
						fileText = fileText + (char) charData;
					}
					reader.close();
					fileText = fileText.replaceAll("\n", "");
					String[] elements = fileText.split(";");
					for (String element : elements) {
						if (element != "") {
							String[] objectData = element.split("\\(");
							if (objectData.length != 2) {
								throw new FileStructureException("The structure of the given file is invalid");
							}
							String objectName = objectData[0];
							if ((objectName.split("\\)", -1).length - 1) != 0) {
								throw new FileStructureException("The structure of the given file is invalid");
							}
							while (objectName.startsWith(" ")) {
								objectName = objectName.substring(1);
							}
							while (objectName.endsWith(" ")) {
								objectName = objectName.substring(0, objectName.length() - 1);
							}
							String objectParameterString = objectData[1];
							if (!objectParameterString.endsWith(")")) {
								throw new FileStructureException("The structure of the given file is invalid");
							}
							objectParameterString = objectParameterString.substring(0, objectParameterString.length() - 1);
							List<String> objectParameters = new ArrayList<String>();
							for (final String parameter : objectParameterString.split(",")) {
								String changedParameter = parameter;
								while (changedParameter.startsWith(" ")) {
									changedParameter = changedParameter.substring(1);
								}
								while (changedParameter.endsWith(" ")) {
									changedParameter = changedParameter.substring(0, changedParameter.length() - 1);
								}
								objectParameters.add(changedParameter);
							}
							String[] parametersArray = {};
							this.elements.add(new DataSet<String[]>(objectName, objectParameters.toArray(parametersArray)));
						}
					}
				}
			} catch (IOException | FileStructureException exception) {
				exception.printStackTrace();
				MBSM.exit(ExitStatus.ERROR);
			}
		}
	}

	/**
	 * This method adds an element to the text object file.
	 *
	 * @param element The name of the element to process
	 * 
	 */
	public void addElement(String element, String... data) throws InvalidParameterException {
		for (DataSet<String[]> containedElement : this.elements) {
			if (containedElement.getObjectName().equals(element)) {
				throw new InvalidParameterException("The element " + element + " already exists.");
			}
		}
		this.elements.add(new DataSet<String[]>(element, data));
	}

	/**
	 * This method removes an element from the text object file.
	 * 
	 * @param element The name of the element to process
	 *
	 * 
	 */
	public void removeElement(String element) throws InvalidParameterException {
		for (DataSet<String[]> containedElement : this.elements) {
			if (containedElement.getObjectName().equals(element)) {
				this.elements.remove(containedElement);
				return;
			}
		}
		throw new InvalidParameterException("The element " + element + " doesn't exist.");
	}

	/**
	 * This method checks if a element is contained in the text object file.
	 *
	 * @param element The name of the element to process
	 *
	 */
	public boolean contains(String element) {
		for (DataSet<String[]> containedElement : this.elements) {
			if (containedElement.getObjectName().equals(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method loads the objects from the file.
	 *
	 */
	@Override
	public void load() {
		try {
			FileReader reader = new FileReader(new File(file));
			String fileText = "";
			int charData;
			while ((charData = reader.read()) != -1) {
				fileText = fileText + (char) charData;
			}
			reader.close();
			fileText = fileText.replaceAll("\n", "");
			String[] elements = fileText.split(";");
			for (String element : elements) {
				if (element != "") {
					String[] objectData = element.split("\\(");
					if (objectData.length != 2) {
						throw new FileStructureException("The structure of the given file is invalid");
					}
					String objectName = objectData[0];
					if ((objectName.split("\\)", -1).length - 1) != 0) {
						throw new FileStructureException("The structure of the given file is invalid");
					}
					while (objectName.startsWith(" ")) {
						objectName = objectName.substring(1);
					}
					while (objectName.endsWith(" ")) {
						objectName = objectName.substring(0, objectName.length() - 1);
					}
					String objectParameterString = objectData[1];
					if (!objectParameterString.endsWith(")")) {
						throw new FileStructureException("The structure of the given file is invalid");
					}
					objectParameterString = objectParameterString.substring(0, objectParameterString.length() - 1);
					List<String> objectParameters = new ArrayList<String>();
					for (final String parameter : objectParameterString.split(",")) {
						String changedParameter = parameter;
						while (changedParameter.startsWith(" ")) {
							changedParameter = changedParameter.substring(1);
						}
						while (changedParameter.endsWith(" ")) {
							changedParameter = changedParameter.substring(0, changedParameter.length() - 1);
						}
						objectParameters.add(changedParameter);
					}
					String[] parametersArray = {};
					this.elements.add(new DataSet<String[]>(objectName, objectParameters.toArray(parametersArray)));
				}
			}
		} catch (IOException | FileStructureException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	/**
	 * This method saves the objects to the file.
	 *
	 */
	@Override
	public void save() {
		FileInit.emptyTextFile(file);
		try {
			FileWriter writer = new FileWriter(new File(file));
			String fileText = "";
			for (DataSet<String[]> element : elements) {
				String parameters = "";
				for (String parameter : element.getData()) {
					if (parameters == "") {
						parameters = parameters + parameter;
					} else {
						parameters = parameters + ", " + parameter;
					}
				}
				if (fileText.equals("")) {
					fileText = fileText + element.getObjectName() + "(" + parameters + ");";
				} else {
					fileText = fileText + "\n" + element.getObjectName() + "(" + parameters + ");";
				}
			}
			writer.write(fileText);
			writer.close();
		} catch (IOException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	@Override
	public File getFile() {
		return new File(file);
	}

	public List<DataSet<String[]>> getElements() {
		return elements;
	}

}
