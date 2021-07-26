package eu.aggelowe.projects.mbsm.util.exceptions;

public class InvalidInstanceException extends MBSMException {

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * instance is invalid.
	 */
	public InvalidInstanceException() {
		super();
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * instance is invalid.
	 * 
	 * @param message The message shown when the exception is thrown.
	 */
	public InvalidInstanceException(String message) {
		super(message);
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * instance is invalid.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public InvalidInstanceException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * instance is invalid.
	 * 
	 * @param message The message shown when the exception is thrown.
	 * 
	 * @param cause   The cause of the exception shown when the exception is thrown.
	 */
	public InvalidInstanceException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = 8843790406402148135L;
	
}
