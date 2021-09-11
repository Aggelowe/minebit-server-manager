package eu.aggelowe.projects.mbsm.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidParameterException;

/**
 * This class represents a new {@link IFile} that contains multiple words in a
 * special format that construct a list.
 * 
 * @author Aggelowe
 *
 */
public class ListFile implements IFile {

	private final List<String> elements = new ArrayList<String>();

	private final String file;

	/**
	 * This constructor constructs a new {@link IFile} that contains multiple words
	 * in a special format that construct a list.
	 *
	 * @param file The file
	 */
	public ListFile(String file) {
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
	}

	/**
	 * This method adds an word to the list file.
	 *
	 * @param element The word to process
	 * 
	 */
	public void addElement(String element) throws InvalidParameterException {
		if (this.contains(element)) {
			throw new InvalidParameterException("The element " + element + " already exists.");
		}
		this.elements.add(element);
	}

	/**
	 * This method removes an word from the list file.
	 * 
	 * @param element The word to process
	 *
	 * 
	 */
	public void removeElement(String element) throws InvalidParameterException {
		if (!this.contains(element)) {
			throw new InvalidParameterException("The element " + element + " doesn't exist.");
		}
		this.elements.remove(element);
	}

	/**
	 * This method checks if a word is contained in the list file.
	 *
	 * @param element The word to process
	 *
	 */
	public boolean contains(String element) {
		for (String containedElement : this.elements) {
			if (containedElement.equals(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method loads the list from the file.
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
			fileText = fileText.replaceAll("\n", "");
			reader.close();
			String[] elements = fileText.split(", ");
			for (String element : elements) {
				if (!this.contains(element)) {
					this.elements.add(element);
				}
			}
		} catch (IOException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	/**
	 * This method saves the list to the file.
	 *
	 */
	@Override
	public void save() {
		FileInit.emptyTextFile(file);
		try {
			FileWriter writer = new FileWriter(new File(file));
			String fileText = null;
			for (String element : elements) {
				if (fileText == null) {
					fileText = element;
				} else {
					fileText = fileText + ", " + element;
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

	public List<String> getElements() {
		return elements;
	}

}
