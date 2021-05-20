package eu.aggelowe.projects.tbsm.util;

/**
 * This class contain the exit statuses which are used to exit the application
 * based on the information given at the constructor.
 * 
 * @author Aggelowe
 *
 */
public enum ExitStatus {

	GRACEFUL("Exiting application...", 0), ERROR("An error occured. Forcing application to exit...", 1), FATAL("A fatal error occured. Stopping all operations imidiately...", 2);

	private final String outMessage;
	private final int exitCode;

	/**
	 * This constructor constructs enumerators used as exit codes for the program to
	 * exit while using the data given.
	 * 
	 * @param outMessage The message printed at the console when the application
	 *                   exits.
	 * @param exitCode   The exit code used for {@link System#exit(int)}.
	 */
	private ExitStatus(String outMessage, int exitCode) {
		this.outMessage = outMessage;
		this.exitCode = exitCode;
	}

	/**
	 * @return The message which is going to be printed at the console when the
	 *         program exits.
	 */
	public String getOutputMessage() {
		return outMessage;
	}

	/**
	 * @return The exit code used for {@link System#exit(int)}.
	 */
	public int getExitCode() {
		return exitCode;
	}

}
