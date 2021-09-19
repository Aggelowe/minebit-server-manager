package eu.aggelowe.projects.mbsm.servers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.mbsm.files.FileReference;
import eu.aggelowe.projects.mbsm.files.TextObjectFile;
import eu.aggelowe.projects.mbsm.util.NamedArrayList;

public final class ServerReference {

	public static final NamedArrayList<MinecraftServer> SERVERS = new NamedArrayList<MinecraftServer>();

	public static final Logger SERVER_LOGGER = LogManager.getLogger("Servers");

	public static final String SERVER_PATH = FileReference.APPLICATION_FOLDER_PATH + "servers/";

	public static final String DEFAULT_SERVER_FILE = "defaults/example.server";
	
	public static final List<String> VERSION_TYPES = new ArrayList<String>();
	
	public static final TextObjectFile RUNNABLE_VERSION_FILE = new TextObjectFile(FileReference.DATA_PATH + "versions.tof", null);
	
	public static final NamedArrayList<RunnableVersion> RUNNABLE_VERSIONS = new NamedArrayList<RunnableVersion>();
	
	public static final String RUNNABLES_PATH = FileReference.DATA_PATH + "runnables/";
	
	public static final List<String> RELEASE_VERSIONS = new ArrayList<String>();
}
