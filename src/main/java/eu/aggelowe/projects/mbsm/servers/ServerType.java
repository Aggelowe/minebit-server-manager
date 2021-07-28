package eu.aggelowe.projects.mbsm.servers;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to determine the type of a {@link ServerVersion}.
 * 
 * @author Aggelowe
 *
 */
public final class ServerType {

	public static final ServerType VANILLA = new ServerType("Vanilla", new MinecraftVersion[] {MinecraftVersion.v1_0, MinecraftVersion.v1_0_1, MinecraftVersion.v1_1, MinecraftVersion.v1_2_1, MinecraftVersion.v1_2_2, MinecraftVersion.v1_2_3, MinecraftVersion.v1_2_4});
	public static final ServerType SPIGOT = new ServerType("Spigot", new MinecraftVersion[] {MinecraftVersion.v1_0, MinecraftVersion.v1_0_1, MinecraftVersion.v1_1, MinecraftVersion.v1_2_1, MinecraftVersion.v1_2_2, MinecraftVersion.v1_2_3, MinecraftVersion.v1_2_4, MinecraftVersion.v1_3_1, MinecraftVersion.v1_3_2, MinecraftVersion.v1_4_2, MinecraftVersion.v1_4_4, MinecraftVersion.v1_4_5, MinecraftVersion.v1_5, MinecraftVersion.v1_6_1, MinecraftVersion.v1_7_3, MinecraftVersion.v1_7_4, MinecraftVersion.v1_7_6, MinecraftVersion.v1_7_7, MinecraftVersion.v1_8_1, MinecraftVersion.v1_8_9, MinecraftVersion.v1_9, MinecraftVersion.v1_9_1, MinecraftVersion.v1_9_3, MinecraftVersion.v1_10_1});

	private final String name;
	private final List<MinecraftVersion> unsupportedVersions;

	/**
	 * This constructor constructs a new {@link ServerType} which is used to
	 * determine the type of a {@link ServerVersion}.
	 * 
	 * @param name
	 * @param supportedVersions
	 */
	private ServerType(String name, MinecraftVersion[] unasupportedVersions) {
		this.name = name;
		this.unsupportedVersions = new ArrayList<MinecraftVersion>();
		if (unsupportedVersions != null) {
			for (MinecraftVersion version : unsupportedVersions) {
				if (!this.unsupportedVersions.contains(version)) {
					this.unsupportedVersions.add(version);
				}
			}
		}
	}

	public final String getName() {
		return this.name;
	}

	public final List<MinecraftVersion> getUnupportedVersions() {
		return this.unsupportedVersions;
	}

}
