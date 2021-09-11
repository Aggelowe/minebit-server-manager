package eu.aggelowe.projects.mbsm.servers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.aggelowe.projects.mbsm.files.FileReference;
import eu.aggelowe.projects.mbsm.files.ListFile;
import eu.aggelowe.projects.mbsm.util.NamedArrayList;

public final class ServerReference {
	
	public static final ListFile SERVERS_LIST = new ListFile(FileReference.APPLICATION_FOLDER_PATH + "servers.list");
	
	public static final NamedArrayList<MinecraftServer> SERVERS = new NamedArrayList<MinecraftServer>();
	
	public static final Logger SERVER_LOGGER = LogManager.getLogger("Servers");
	
	public static final String SERVER_PATH = FileReference.APPLICATION_FOLDER_PATH + "servers/";
	
	public static final String DEFAULT_SERVER_FILE = "defaults/servers.properties";
	
}
