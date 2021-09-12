package eu.aggelowe.projects.mbsm.util.exceptions;

public class FileStructureException extends Exception {

	/**
	 * This constructor constructs an exception which should be thrown when the
	 * structure of a text file is invalid.
	 */
	public FileStructureException() {
		super();
	}

	/**
	 * This constructor constructs an exception which should be thrown when the
	 * structure of a text file is invalid.
	 * 
	 * @param message The message shown when the exception is thrown.
	 */
	public FileStructureException(String message) {
		super(message);
	}

	/**
	 * This constructor constructs an exception which should be thrown when the
	 * structure of a text file is invalid.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public FileStructureException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor constructs an exception which should be thrown when the
	 * structure of a text file is invalid.
	 * 
	 * @param message The message shown when the exception is thrown.
	 * 
	 * @param cause   The cause of the exception shown when the exception is thrown.
	 */
	public FileStructureException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = -8578348892585707317L;

}
