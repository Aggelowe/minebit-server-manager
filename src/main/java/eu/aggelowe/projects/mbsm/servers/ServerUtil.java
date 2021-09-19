package eu.aggelowe.projects.mbsm.servers;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.files.PropertyFile;
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
	 * This method is used to load all the release versions from the
	 * <i>versions</i> file.
	 */
	private static void loadReleaseVersions() {
		for (RunnableVersion version : ServerReference.RUNNABLE_VERSIONS) {
			if (version != null && version.getVersion() != null) {
				boolean canAdd = true;
				checkLoop: for (String releaseVersion : ServerReference.RELEASE_VERSIONS) {
					if (releaseVersion != null && version.getVersion().equals(releaseVersion)) {
						canAdd = false;
						break checkLoop;
					}
				}
				if (canAdd == true) {
					ServerReference.RELEASE_VERSIONS.add(version.getVersion());
				}
			}
		}
		sortVersions();
	}

	/**
	 * This method is used to load all the version types from the
	 * <i>versions</i> file.
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
			String name = runnableVersion.getName();
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
	public static void loadServer(String name) throws ServerException {
		PropertyFile serverFile = new PropertyFile("Server settings of the server: " + name, ServerReference.SERVER_PATH + name + ".server", ServerReference.DEFAULT_SERVER_FILE);
		serverFile.load();
		AllocatableMemory memory = AllocatableMemory.fromString(serverFile.getDataValue("general.memory"));
		if (memory == null) {
			memory = AllocatableMemory.ALLOCATE_4096M;
			serverFile.setDataValue(new DataSet<String>("general.memory", "4096"));
		}
		RunnableVersion version = (RunnableVersion) ServerReference.RUNNABLE_VERSIONS.getNamedObject(serverFile.getDataValue("general.version"));
		if (version == null) {
			version = (RunnableVersion) ServerReference.RUNNABLE_VERSIONS.get(0);
			serverFile.setDataValue(new DataSet<String>("general.version", version.getName()));
		}
		MinecraftServer server = new MinecraftServer(name, memory, version);
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

	/**
	 * This method sorts the given versions.
	 * 
	 * @param versions The versions given
	 */
	public static void sortVersions() {
		Collections.sort(ServerReference.RELEASE_VERSIONS, new VersionComparator());
	}

}
