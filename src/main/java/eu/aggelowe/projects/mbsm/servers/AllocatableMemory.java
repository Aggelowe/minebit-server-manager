package eu.aggelowe.projects.mbsm.servers;

/**
 * This class is used to define how much memory is going to be allocated from
 * the given minecraft server.
 * 
 * @author Aggelowe
 *
 */
public enum AllocatableMemory {

	ALLOCATE_216M(216), ALLOCATE_512M(512), ALLOCATE_1024M(1024), ALLOCATE_2048M(2048), ALLOCATE_4096M(4096), ALLOCATE_8192M(8192), ALLOCATE_16384M(16384), ALLOCATE_32768M(32768);

	private final int asInt;

	/**
	 * This constructor constructs a new enum that defines how much memory is going
	 * to be allocated from the given minecraft server.
	 * 
	 * @author Aggelowe
	 *
	 */
	private AllocatableMemory(int asInt) {
		this.asInt = asInt;
	}

	@Override
	public String toString() {
		return Integer.toString(asInt);
	}

	public String toText() {
		return Integer.toString(asInt) + " Megabytes";
	}

	public static AllocatableMemory fromString(String string) {
		for (AllocatableMemory memory : values()) {
			if (memory.toString().equals(string)) {
				return memory;
			}
		}
		return null;
	}
}
