package eu.aggelowe.projects.mbsm.servers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is used to determine the minecraft version of a
 * {@link ServerVersion}.
 * 
 * @author Aggelowe
 *
 */
public class MinecraftVersion {

	public static final MinecraftVersion v1_17_1 = new MinecraftVersion("1.17.1");
	public static final MinecraftVersion v1_17 = new MinecraftVersion("1.17");
	public static final MinecraftVersion v1_16_5 = new MinecraftVersion("1.16.5");
	public static final MinecraftVersion v1_16_4 = new MinecraftVersion("1.16.4");
	public static final MinecraftVersion v1_16_3 = new MinecraftVersion("1.16.3");
	public static final MinecraftVersion v1_16_2 = new MinecraftVersion("1.16.2");
	public static final MinecraftVersion v1_16_1 = new MinecraftVersion("1.16.1");
	public static final MinecraftVersion v1_16 = new MinecraftVersion("1.16");
	public static final MinecraftVersion v1_15_2 = new MinecraftVersion("1.15.2");
	public static final MinecraftVersion v1_15_1 = new MinecraftVersion("1.15.1");
	public static final MinecraftVersion v1_15 = new MinecraftVersion("1.15");
	public static final MinecraftVersion v1_14_4 = new MinecraftVersion("1.14.4");
	public static final MinecraftVersion v1_14_3 = new MinecraftVersion("1.14.3");
	public static final MinecraftVersion v1_14_2 = new MinecraftVersion("1.14.2");
	public static final MinecraftVersion v1_14_1 = new MinecraftVersion("1.14.1");
	public static final MinecraftVersion v1_14 = new MinecraftVersion("1.14");
	public static final MinecraftVersion v1_13_2 = new MinecraftVersion("1.13.2");
	public static final MinecraftVersion v1_13_1 = new MinecraftVersion("1.13.1");
	public static final MinecraftVersion v1_13 = new MinecraftVersion("1.13");
	public static final MinecraftVersion v1_12_2 = new MinecraftVersion("1.12.2");
	public static final MinecraftVersion v1_12_1 = new MinecraftVersion("1.12.1");
	public static final MinecraftVersion v1_12 = new MinecraftVersion("1.12");
	public static final MinecraftVersion v1_11_2 = new MinecraftVersion("1.11.2");
	public static final MinecraftVersion v1_11_1 = new MinecraftVersion("1.11.1");
	public static final MinecraftVersion v1_11 = new MinecraftVersion("1.11");
	public static final MinecraftVersion v1_10_2 = new MinecraftVersion("1.10.2");
	public static final MinecraftVersion v1_10_1 = new MinecraftVersion("1.10.1");
	public static final MinecraftVersion v1_10 = new MinecraftVersion("1.10");
	public static final MinecraftVersion v1_9_4 = new MinecraftVersion("1.9.4");
	public static final MinecraftVersion v1_9_3 = new MinecraftVersion("1.9.3");
	public static final MinecraftVersion v1_9_2 = new MinecraftVersion("1.9.2");
	public static final MinecraftVersion v1_9_1 = new MinecraftVersion("1.9.1");
	public static final MinecraftVersion v1_9 = new MinecraftVersion("1.9");
	public static final MinecraftVersion v1_8_9 = new MinecraftVersion("1.8.9");
	public static final MinecraftVersion v1_8_8 = new MinecraftVersion("1.8.8");
	public static final MinecraftVersion v1_8_7 = new MinecraftVersion("1.8.7");
	public static final MinecraftVersion v1_8_6 = new MinecraftVersion("1.8.6");
	public static final MinecraftVersion v1_8_5 = new MinecraftVersion("1.8.5");
	public static final MinecraftVersion v1_8_4 = new MinecraftVersion("1.8.4");
	public static final MinecraftVersion v1_8_3 = new MinecraftVersion("1.8.3");
	public static final MinecraftVersion v1_8_2 = new MinecraftVersion("1.8.2");
	public static final MinecraftVersion v1_8_1 = new MinecraftVersion("1.8.1");
	public static final MinecraftVersion v1_8 = new MinecraftVersion("1.8");
	public static final MinecraftVersion v1_7_10 = new MinecraftVersion("1.7.10");
	public static final MinecraftVersion v1_7_9 = new MinecraftVersion("1.7.9");
	public static final MinecraftVersion v1_7_8 = new MinecraftVersion("1.7.8");
	public static final MinecraftVersion v1_7_7 = new MinecraftVersion("1.7.7");
	public static final MinecraftVersion v1_7_6 = new MinecraftVersion("1.7.6");
	public static final MinecraftVersion v1_7_5 = new MinecraftVersion("1.7.5");
	public static final MinecraftVersion v1_7_4 = new MinecraftVersion("1.7.4");
	public static final MinecraftVersion v1_7_3 = new MinecraftVersion("1.7.3");
	public static final MinecraftVersion v1_7_2 = new MinecraftVersion("1.7.2");
	public static final MinecraftVersion v1_6_4 = new MinecraftVersion("1.6.4");
	public static final MinecraftVersion v1_6_2 = new MinecraftVersion("1.6.2");
	public static final MinecraftVersion v1_6_1 = new MinecraftVersion("1.6.1");
	public static final MinecraftVersion v1_5_2 = new MinecraftVersion("1.5.2");
	public static final MinecraftVersion v1_5_1 = new MinecraftVersion("1.5.1");
	public static final MinecraftVersion v1_5 = new MinecraftVersion("1.5");
	public static final MinecraftVersion v1_4_7 = new MinecraftVersion("1.4.7");
	public static final MinecraftVersion v1_4_6 = new MinecraftVersion("1.4.6");
	public static final MinecraftVersion v1_4_5 = new MinecraftVersion("1.4.5");
	public static final MinecraftVersion v1_4_4 = new MinecraftVersion("1.4.4");
	public static final MinecraftVersion v1_4_2 = new MinecraftVersion("1.4.2");
	public static final MinecraftVersion v1_3_2 = new MinecraftVersion("1.3.2");
	public static final MinecraftVersion v1_3_1 = new MinecraftVersion("1.3.2");
	public static final MinecraftVersion v1_2_5 = new MinecraftVersion("1.2.5");
	public static final MinecraftVersion v1_2_4 = new MinecraftVersion("1.2.4");
	public static final MinecraftVersion v1_2_3 = new MinecraftVersion("1.2.3");
	public static final MinecraftVersion v1_2_2 = new MinecraftVersion("1.2.2");
	public static final MinecraftVersion v1_2_1 = new MinecraftVersion("1.2.1");
	public static final MinecraftVersion v1_1 = new MinecraftVersion("1.1");
	public static final MinecraftVersion v1_0_1 = new MinecraftVersion("1.0.1");
	public static final MinecraftVersion v1_0 = new MinecraftVersion("1.0");

	public static final List<MinecraftVersion> MINECRAFT_VERSIONS = new ArrayList<MinecraftVersion>();

	private final String name;

	/**
	 * 
	 * This constructor constructs a new {@link MinecraftVersion} which is used to
	 * determine the minecraft version of a {@link ServerVersion}.
	 * 
	 * @author Aggelowe
	 *
	 */
	private MinecraftVersion(String name) {
		this.name = name;
		MINECRAFT_VERSIONS.add(this);
	}

	public String getName() {
		return name;
	}

}
