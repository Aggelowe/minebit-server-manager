package eu.aggelowe.projects.mbsm.servers;

import eu.aggelowe.projects.mbsm.util.INamed;

/**
 * This class represents a new minecraft version type.
 * 
 * @author Aggelowe
 *
 */
public class VersionType implements INamed {

	private final String name;
	
	/**
	 * This constructor constructs a new minecraft version type.
	 * 
	 * @param name The name of the version type
	 *
	 */
	public VersionType(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
