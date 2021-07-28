package eu.aggelowe.projects.mbsm.servers;

import java.net.MalformedURLException;
import java.net.URL;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.util.ExitStatus;

public class ServerVersion {
	
	private final ServerType type;
	private final MinecraftVersion minecraftVersion;
	private final String name;
	private final URL serverDownloadUrl;
	
	public ServerVersion(ServerType type, MinecraftVersion minecraftVersion, String serverDownloadLink) {
		this.type = type;
		this.minecraftVersion = minecraftVersion;
		this.name = type.getName() + "" + minecraftVersion.getName();
		URL serverDownloadUrl = null;
		try {
			serverDownloadUrl = new URL(serverDownloadLink);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		this.serverDownloadUrl = serverDownloadUrl;
	}

	
	public String getName() {
		return name;
	}

	public ServerType getType() {
		return type;
	}

	public MinecraftVersion getMinecraftVersion() {
		return minecraftVersion;
	}
	
	public URL getServerDownloadUrl() {
		return serverDownloadUrl;
	}
	
}
