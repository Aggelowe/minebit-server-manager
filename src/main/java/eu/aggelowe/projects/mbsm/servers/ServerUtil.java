package eu.aggelowe.projects.mbsm.servers;

import eu.aggelowe.projects.mbsm.files.PropertyFile;
import eu.aggelowe.projects.mbsm.util.DataSet;
import eu.aggelowe.projects.mbsm.util.INamed;
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
	@Deprecated
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
			if (server.isRunning()) {
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

	/**
	 * This method loads the properties of the given server and creates specific
	 * files if necessary.
	 * 
	 * @param name The name of the server to load
	 * 
	 * @throws ServerException
	 */
	public static void loadServer(String name) throws ServerException {
		PropertyFile serverFile = new PropertyFile("Server settings of the server: " + name, ServerReference.SERVER_PATH + name + ".properties", ServerReference.DEFAULT_SERVER_FILE);
		serverFile.load();
		AllocatableMemory memory = AllocatableMemory.fromString(serverFile.getDataValue("general.memory"));
		if (memory == null) {
			memory = AllocatableMemory.ALLOCATE_4096M;
			serverFile.setDataValue(new DataSet<String>("general.memory", "4096"));
		}
		MinecraftServer server = new MinecraftServer(name, memory);
		server.init();
	}

	/**
	 * This method saves the properties to the given server and creates specific
	 * files if necessary.
	 * 
	 * @param name The name of the server to load
	 * 
	 * @throws ServerException
	 */
	public static void saveServer(String name) throws ServerException {
		PropertyFile serverFile = new PropertyFile("Server settings of the server: " + name, ServerReference.SERVER_PATH + name + ".properties", ServerReference.DEFAULT_SERVER_FILE);
		INamed named = ServerReference.SERVERS.getNamedObject(name);
		MinecraftServer server = null;
		if (named instanceof MinecraftServer) {
			server = (MinecraftServer) named;
		}
		AllocatableMemory memory = AllocatableMemory.fromString(serverFile.getDataValue("general.memory"));
		serverFile.setDataValue(new DataSet<String>("general.memory", "4096"));
	}

}
