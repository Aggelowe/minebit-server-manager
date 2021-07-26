package eu.aggelowe.projects.mbsm.util.exceptions;

/**
 * This exception is the base exception of the project which all of the
 * project's other exceptions extend.
 * 
 * @author Aggelowe
 */
public class MBSMException extends Exception {

	/**
	 * This constructor constructs the base exception which every exception in this
	 * project should extend.
	 */
	public MBSMException() {
		super();
	}

	/**
	 * This constructor constructs the base exception which every exception in this
	 * project should extend.
	 * 
	 * @param message The message shown when the exception is thrown.
	 */
	public MBSMException(String message) {
		super(message);
	}

	/**
	 * This constructor constructs the base exception which every exception in this
	 * project should extend.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public MBSMException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor constructs the base exception which every exception in this
	 * project should extend.
	 * 
	 * @param message The message shown when the exception is thrown.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public MBSMException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = 7369610412589849527L;

}
