package eu.aggelowe.projects.mbsm.servers;

import java.io.File;
import java.util.Arrays;
import java.util.List;

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
	 * This method is used to load all the {@link MinecraftServer} objects from the
	 * <i>servers</i> directory.
	 */
	public static void loadServers() {
		File serversDirectory = new File(ServerReference.SERVER_PATH);
		File[] directoryElements = serversDirectory.listFiles();
		for (File directoryElement : directoryElements) {
			if (directoryElement.isFile()) {
				String filename = directoryElement.getName();
				String serverName = "";
				List<String> filenameElements = Arrays.asList(filename.split("\\."));
				String filenameEnding = filenameElements.get(filenameElements.size() - 1);
				if (filenameEnding.equals("server")) {
					for (int counter = 0; counter < filenameElements.size() - 1; counter++) {
						if (serverName.equals("")) {
							serverName = filenameElements.get(counter);
						} else {
							serverName = serverName + "." + filenameElements.get(counter);
						}
					}
				}
				try {
					loadServer(serverName);
				} catch (ServerException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method is used to load all the {@link ReleaseVersion} objects from the
	 * <i>versions</i> file.
	 */
	public static void loadReleaseVersions() {
		for (String version : ServerReference.VERSIONS_LIST.getElements()) {
			if (version != null) {
				ServerReference.VERSIONS.add(new ReleaseVersion(version));
			}
		}
	}

	/**
	 * This method is used to load all the {@link VersionType} objects from the
	 * <i>version_types</i> file.
	 */
	public static void loadVersionTypes() {
		for (String versionType : ServerReference.VERSION_TYPE_LIST.getElements()) {
			if (versionType != null) {
				ServerReference.VERSION_TYPES.add(new VersionType(versionType));
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
		PropertyFile serverFile = new PropertyFile("Server settings of the server: " + name, ServerReference.SERVER_PATH + name + ".server", ServerReference.DEFAULT_SERVER_FILE);
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
		PropertyFile serverFile = new PropertyFile("Server settings of the server: " + name, ServerReference.SERVER_PATH + name + ".server", ServerReference.DEFAULT_SERVER_FILE);
		INamed named = ServerReference.SERVERS.getNamedObject(name);
		MinecraftServer server = null;
		if (named instanceof MinecraftServer) {
			server = (MinecraftServer) named;
		}
		if (server.isDeleted()) {
			throw new ServerException("The given server has been deleted.");
		}
		AllocatableMemory memory = server.getMemory();
		serverFile.setDataValue(new DataSet<String>("general.memory", memory.toString()));
		serverFile.save();
	}

}
