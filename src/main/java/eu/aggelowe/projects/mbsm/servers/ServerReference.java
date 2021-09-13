package eu.aggelowe.projects.mbsm.servers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.mbsm.files.FileReference;
import eu.aggelowe.projects.mbsm.files.ListFile;
import eu.aggelowe.projects.mbsm.files.TextObjectFile;
import eu.aggelowe.projects.mbsm.util.NamedArrayList;

public final class ServerReference {

	public static final NamedArrayList<MinecraftServer> SERVERS = new NamedArrayList<MinecraftServer>();

	public static final Logger SERVER_LOGGER = LogManager.getLogger("Servers");

	public static final String SERVER_PATH = FileReference.APPLICATION_FOLDER_PATH + "servers/";

	public static final String DEFAULT_SERVER_FILE = "defaults/example.server";

	public static final ListFile VERSIONS_LIST = new ListFile(FileReference.DATA_PATH+ "versions.list", "defaults/versions.list");

	public static final NamedArrayList<ReleaseVersion> VERSIONS = new NamedArrayList<ReleaseVersion>();
	
	public static final ListFile VERSION_TYPE_LIST = new ListFile(FileReference.DATA_PATH + "version_types.list", "defaults/version_types.list");

	public static final NamedArrayList<VersionType> VERSION_TYPES = new NamedArrayList<VersionType>();
	
	public static final TextObjectFile RUNNABLE_VERSION_FILE = new TextObjectFile(FileReference.DATA_PATH + "runnable_versions.tof", null);
	
}
