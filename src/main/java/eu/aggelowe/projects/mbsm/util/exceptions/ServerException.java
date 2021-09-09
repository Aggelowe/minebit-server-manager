package eu.aggelowe.projects.mbsm.util.exceptions;

public class ServerException extends MBSMException {

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * unwanted event occurs on a server.
	 */
	public ServerException() {
		super();
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * unwanted event occurs on a server.
	 * 
	 * @param message The message shown when the exception is thrown.
	 */
	public ServerException(String message) {
		super(message);
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * unwanted event occurs on a server.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public ServerException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor constructs an exception which should be thrown when an
	 * unwanted event occurs on a server.
	 * 
	 * @param message The message shown when the exception is thrown.
	 * 
	 * @param cause   The cause of the exception shown when the exception is thrown.
	 */
	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = -2104720435450148838L;

}
