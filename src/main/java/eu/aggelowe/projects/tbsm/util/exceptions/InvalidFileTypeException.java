package eu.aggelowe.projects.tbsm.util.exceptions;

public class InvalidFileTypeException extends TBSMException {

	/**
	 * This constructor constructs an exception which should be thrown when a
	 * file type is invalid.
	 */
	public InvalidFileTypeException() {
		super();
	}

	/**
	 * This constructor constructs an exception which should be thrown when a
	 * file type is invalid.
	 * 
	 * @param message The message shown when the exception is thrown.
	 */
	public InvalidFileTypeException(String message) {
		super(message);
	}

	/**
	 * This constructor constructs an exception which should be thrown when a
	 * file type is invalid.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public InvalidFileTypeException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor constructs an exception which should be thrown when a
	 * file type is invalid.
	 * 
	 * @param message The message shown when the exception is thrown.
	 * 
	 * @param cause   The cause of the exception shown when the exception is thrown.
	 */
	public InvalidFileTypeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	private static final long serialVersionUID = -5913188237636487864L;
	
}
