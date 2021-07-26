package eu.aggelowe.projects.mbsm.util.exceptions;

public class InvalidParameterException extends MBSMException {

	/**
	 * This constructor constructs the base exception which should be thrown when a
	 * parameter is invalid.
	 */
	public InvalidParameterException() {
		super();
	}

	/**
	 * This constructor constructs the base exception which should be thrown when a
	 * parameter is invalid.
	 * 
	 * @param message The message shown when the exception is thrown.
	 */
	public InvalidParameterException(String message) {
		super(message);
	}

	/**
	 * This constructor constructs the base exception which should be thrown when a
	 * parameter is invalid.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public InvalidParameterException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor constructs the base exception which should be thrown when a
	 * parameter is invalid.
	 * 
	 * @param message The message shown when the exception is thrown.
	 * 
	 * @param cause   The cause of the exception shown when the exception is thrown.
	 */
	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = 4624090009420063874L;

}
