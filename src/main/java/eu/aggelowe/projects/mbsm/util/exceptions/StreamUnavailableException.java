package eu.aggelowe.projects.mbsm.util.exceptions;

public class StreamUnavailableException extends MBSMException {

	/**
	 * This constructor constructs an exception which should be thrown when a stream
	 * is unavailable.
	 */
	public StreamUnavailableException() {
		super();
	}

	/**
	 * This constructor constructs an exception which should be thrown when a stream
	 * is unavailable.
	 * 
	 * @param message The message shown when the exception is thrown.
	 */
	public StreamUnavailableException(String message) {
		super(message);
	}

	/**
	 * This constructor constructs an exception which should be thrown when a stream
	 * is unavailable.
	 * 
	 * @param cause The cause of the exception shown when the exception is thrown.
	 */
	public StreamUnavailableException(Throwable cause) {
		super(cause);
	}

	/**
	 * This constructor constructs an exception which should be thrown when a stream
	 * is unavailable.
	 * 
	 * @param message The message shown when the exception is thrown.
	 * 
	 * @param cause   The cause of the exception shown when the exception is thrown.
	 */
	public StreamUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = -2104720435450148838L;
	
}
