package eu.aggelowe.projects.mbsm.servers;

import eu.aggelowe.projects.mbsm.util.INamed;

/**
 * This class represents a new minecraft release version.
 * 
 * @author aggelos
 *
 */
public class ReleaseVersion implements INamed {

	private final String name;

	/**
	 * This constructor constructs a new minecraft release version.
	 * 
	 * @param name The name of the version
	 *
	 */
	public ReleaseVersion(String name) {
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
