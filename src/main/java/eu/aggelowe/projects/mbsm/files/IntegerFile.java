package eu.aggelowe.projects.mbsm.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidParameterException;

/**
 * This class represents a new {@link IFile} that contains a specific integer.
 * 
 * @author Aggelowe
 *
 */
public class IntegerFile implements IFile {

	private final String file;
	private final long defaultInteger;

	private long integer;

	/**
	 * This constructor constructs a new {@link IFile} that contains a specific
	 * integer.
	 * 
	 * @author Aggelowe
	 *
	 */
	public IntegerFile(String file, long defaultInteger) {
		this.file = file;
		this.defaultInteger = defaultInteger;
		if (new File(file).isDirectory()) {
			new InvalidParameterException("The given file is a directory").printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		if (!new File(file).exists()) {
			try {
				new File(file).createNewFile();
				this.integer = defaultInteger;
			} catch (IOException exception) {
				exception.printStackTrace();
				MBSM.exit(ExitStatus.ERROR);
			}
		}
	}


	/**
	 * This method loads the integer from the file.
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
			if (fileText.equals("")) {
				this.integer = this.defaultInteger;
			} else {
				this.integer = checkFormat(fileText) ? Long.valueOf(fileText) : this.defaultInteger;
			}
		} catch (IOException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	/**
	 * This method saves the integer to the file.
	 */
	@Override
	public void save() {
		FileInit.emptyTextFile(file);
		try {
			FileWriter writer = new FileWriter(new File(file));
			String fileText = String.valueOf(integer);
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

	public long getInteger() {
		return integer;
	}

	public void setInteger(long integer) {
		this.integer = integer;
	}

	private boolean checkFormat(String inputString) {
		String checkString = new String(inputString);
		char[] validChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };
		for (char character : validChars) {
			checkString = checkString.replace(String.valueOf(character), "");
		}
		if (checkString.equals("")) {
			return true;
		}
		return false;
	}

}
