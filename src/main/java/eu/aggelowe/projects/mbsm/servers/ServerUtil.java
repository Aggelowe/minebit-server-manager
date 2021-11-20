package eu.aggelowe.projects.mbsm.servers;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.files.PropertyFile;
import eu.aggelowe.projects.mbsm.gui.tabs.servers.ServerList;
import eu.aggelowe.projects.mbsm.util.AppUtils;
import eu.aggelowe.projects.mbsm.util.DataSet;
import eu.aggelowe.projects.mbsm.util.ExitStatus;
import eu.aggelowe.projects.mbsm.util.INamed;
import eu.aggelowe.projects.mbsm.util.VersionComparator;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidParameterException;
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
				if (!server.isInitialised()) {
					server.init();
				}
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
		ServerReference.SERVER_LOGGER.info("Loading servers...");
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
	 * This method is used to save all the {@link MinecraftServer} objects to the
	 * <i>servers</i> directory.
	 */
	public static void saveServers() {

		ServerReference.SERVER_LOGGER.info("Saving servers...");
		try {
			for (MinecraftServer server : ServerReference.SERVERS) {
				if (server != null) {
					saveServer(server.getObjectName());
				}
			}
		} catch (ServerException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
	}

	/**
	 * This method is used to load all the release versions from the <i>versions</i>
	 * file.
	 */
	private static void loadReleaseVersions() {
		for (RunnableVersion version : ServerReference.RUNNABLE_VERSIONS) {
			if (version != null && version.getMinecraftVersion() != null) {
				boolean canAdd = true;
				checkLoop: for (String releaseVersion : ServerReference.RELEASE_VERSIONS) {
					if (releaseVersion != null && version.getMinecraftVersion().equals(releaseVersion)) {
						canAdd = false;
						break checkLoop;
					}
				}
				if (canAdd == true) {
					ServerReference.RELEASE_VERSIONS.add(version.getMinecraftVersion());
				}
			}
		}
		sortVersions();
	}

	/**
	 * This method is used to load all the version types from the <i>versions</i>
	 * file.
	 */
	private static void loadVersionTypes() {
		for (RunnableVersion version : ServerReference.RUNNABLE_VERSIONS) {
			if (version != null && version.getType() != null) {
				boolean canAdd = true;
				checkLoop: for (String versionType : ServerReference.VERSION_TYPES) {
					if (versionType != null && version.getType().equalsIgnoreCase(versionType)) {
						canAdd = false;
						break checkLoop;
					}
				}
				if (canAdd == true) {
					ServerReference.VERSION_TYPES.add(version.getType().toLowerCase());
				}
			}
		}
		AppUtils.sortAlphabetically(ServerReference.VERSION_TYPES);
	}

	/**
	 * This method is used to load all the {@link RunnableVersion} objects from the
	 * <i>runnable_versions</i> file.
	 */
	public static void loadRunnableVersions() {
		for (DataSet<String[]> runnableVersion : ServerReference.RUNNABLE_VERSION_FILE.getElements()) {
			String name = runnableVersion.getObjectName();
			if (runnableVersion.getData().length != 3) {
				new InvalidParameterException("Too many parameters are contained in the " + name + " runnable version text object.").printStackTrace();
				MBSM.exit(ExitStatus.ERROR);
			}
			String type = runnableVersion.getData()[0];
			String version = runnableVersion.getData()[1];
			String downloadUrl = runnableVersion.getData()[2];
			ServerReference.RUNNABLE_VERSIONS.add(new RunnableVersion(name, type, version, downloadUrl));
		}
		ServerUtil.loadReleaseVersions();
		ServerUtil.loadVersionTypes();
	}

	/**
	 * This method loads the properties of the given server and creates specific
	 * files if necessary.
	 * 
	 * @param name The name of the server to load
	 * 
	 * @throws ServerException
	 */
	public static void loadServer(String id) throws ServerException {
		ServerReference.SERVER_LOGGER.debug("Loading server: " + id);
		PropertyFile serverFile = new PropertyFile("Server settings of the server: " + id, ServerReference.SERVER_PATH + id + ".server", ServerReference.DEFAULT_SERVER_FILE);
		serverFile.load();
		String name = serverFile.getDataValue("general.name");
		if (name == null || name.equals("")) {
			name = "Unnamed Server";
			serverFile.setDataValue(new DataSet<String>("general.name", "Unnamed Server"));
		}
		AllocatableMemory memory = AllocatableMemory.fromString(serverFile.getDataValue("general.memory"));
		if (memory == null) {
			memory = AllocatableMemory.ALLOCATE_4096M;
			serverFile.setDataValue(new DataSet<String>("general.memory", "4096"));
		}
		RunnableVersion version = (RunnableVersion) ServerReference.RUNNABLE_VERSIONS.getNamedObject(serverFile.getDataValue("general.version"));
		if (version == null) {
			version = ServerReference.RUNNABLE_VERSIONS.size() > 0 ? (RunnableVersion) ServerReference.RUNNABLE_VERSIONS.get(0) : ServerReference.FALLBACK_VERSION;
			serverFile.setDataValue(new DataSet<String>("general.version", version.getObjectName()));
		}
		long lastUsed = 0;
		try {
			lastUsed = Long.valueOf(serverFile.getDataValue("general.lastUsed"));
		} catch (NumberFormatException e) {
			serverFile.setDataValue(new DataSet<String>("general.lastUsed", String.valueOf(0)));
		}
		MinecraftServer server = new MinecraftServer(name, id, memory, version);
		server.setLastUsed(lastUsed);
		server.init();
	}

	/**
	 * This method loads the properties of the given server and creates specific
	 * files if necessary.
	 * 
	 * @param name The name of the server to load
	 * 
	 * @throws ServerException
	 */
	public static void deleteServer(MinecraftServer server) throws ServerException {
		ServerReference.SERVER_LOGGER.debug("Deleting server: " + server.getObjectName());
		server.delete();
		File serverFile = new File(ServerReference.SERVER_PATH + server.getId() + ".server");
		if (serverFile.exists() && serverFile.isFile()) {
			serverFile.delete();
		}
		File serverFolder = new File(ServerReference.SERVER_PATH + server.getId());
		if (serverFolder.exists() && serverFolder.isDirectory()) {
			serverFolder.delete();
		}
	}

	/**
	 * This method saves the properties to the given server and creates specific
	 * files if necessary.
	 * 
	 * @param name The name of the server to load
	 * 
	 * @throws ServerException
	 */
	public static void saveServer(String id) throws ServerException {
		PropertyFile serverFile = new PropertyFile("Server settings of the server: " + id, ServerReference.SERVER_PATH + id + ".server", ServerReference.DEFAULT_SERVER_FILE);
		INamed named = ServerReference.SERVERS.getNamedObject(id);
		MinecraftServer server = null;
		if (named instanceof MinecraftServer) {
			server = (MinecraftServer) named;
		}
		if (server.isDeleted()) {
			throw new ServerException("The given server has been deleted.");
		}
		RunnableVersion version = server.getVersion();
		serverFile.setDataValue(new DataSet<String>("general.version", version.getObjectName()));
		AllocatableMemory memory = server.getMemory();
		serverFile.setDataValue(new DataSet<String>("general.memory", memory.toString()));
		String name = server.getName();
		serverFile.setDataValue(new DataSet<String>("general.name", name));
		long lastUsed = server.getlastUsed();
		serverFile.setDataValue(new DataSet<String>("general.lastUsed", String.valueOf(lastUsed)));
		serverFile.save();
	}

	/**
	 * This method sorts the given versions.
	 * 
	 * @param versions The versions given
	 */
	public static void sortVersions() {
		Collections.sort(ServerReference.RELEASE_VERSIONS, new VersionComparator());
	}

	/**
	 * This method constructs a new server
	 */
	public static void consctructNewServer() {
		String id = AppUtils.getRandomID(4, 4);
		while (ServerReference.SERVERS.containsNamedObject(id)) {
			id = AppUtils.getRandomID(4, 4);
		}
		MinecraftServer newServer = new MinecraftServer("Unnamed Server", AppUtils.getRandomID(4, 4), AllocatableMemory.ALLOCATE_2048M, ServerReference.RUNNABLE_VERSIONS.size() > 0 ? ServerReference.RUNNABLE_VERSIONS.get(0) : ServerReference.FALLBACK_VERSION);
		try {
			newServer.init();
			newServer.setLastUsed(System.currentTimeMillis());
			saveServer(newServer.getObjectName());
		} catch (ServerException exception) {
			exception.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		ServerList.addServerButton(newServer);
	}

}
