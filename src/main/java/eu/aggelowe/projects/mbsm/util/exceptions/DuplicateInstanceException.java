package eu.aggelowe.projects.mbsm.util.exceptions;

import java.util.Collection;

public class DuplicateInstanceException extends MBSMException {

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * instance is found twice in a {@link Collection} or array.
	 */
	public DuplicateInstanceException() {
		super();
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * instance is found twice in a {@link Collection} or array.
	 * 
	 * @param message The message shown when the exception is thrown.
	 */
	public DuplicateInstanceException(String message) {
		super(message);
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * instance is found twice in a {@link Collection} or array.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public DuplicateInstanceException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * instance is found twice in a {@link Collection} or array.
	 * 
	 * @param message The message shown when the exception is thrown.
	 * 
	 * @param cause   The cause of the exception shown when the exception is thrown.
	 */
	public DuplicateInstanceException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = -5913188237636487864L;

}
