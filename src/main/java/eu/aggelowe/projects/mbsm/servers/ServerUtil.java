package eu.aggelowe.projects.mbsm.servers;

import eu.aggelowe.projects.mbsm.util.exceptions.ServerException;

/**
 * This class contains many useful utilities for the management of the Minecraft
 * servers.
 * 
 * @author Aggelowe
 *
 */
public final class ServerUtil {

	/**
	 * This method is used to initialise all the existing minecraft servers.
	 */
	public static void initServers() {
		for (MinecraftServer server : ServerReference.SERVERS) {
			try {
				server.init();
			} catch (ServerException exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * This method is used to stop all the running minecraft servers.
	 */
	public static void stopServers(boolean forceStop) {
		for (MinecraftServer server : ServerReference.SERVERS) {
			try {
				if (forceStop == true) {
					server.forceStop();
				} else {
					server.stop();
				}
			} catch (ServerException exception) {
				exception.printStackTrace();
			}
		}
	}

}
