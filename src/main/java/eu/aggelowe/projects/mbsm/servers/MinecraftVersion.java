package eu.aggelowe.projects.mbsm.servers;

import java.net.MalformedURLException;
import java.net.URL;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.util.ExitStatus;

public class MinecraftVersion {

	public static final MinecraftVersion VANILLA_1_17 = new MinecraftVersion("Vanilla-1.17", "https://launcher.mojang.com/v1/objects/0a269b5f2c5b93b1712d0f5dc43b6182b9ab254e/server.jar");
	
	private final String name;
	private final URL serverDownloadUrl;
	
	public MinecraftVersion(String name, String serverDownloadLink) {
		this.name = name;
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

	public URL getServerDownloadUrl() {
		return serverDownloadUrl;
	}
	
	
	
}
