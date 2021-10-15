package eu.aggelowe.projects.mbsm.servers;

import java.util.Comparator;

import eu.aggelowe.projects.mbsm.util.ComparisonDirection;
import eu.aggelowe.projects.mbsm.util.VersionComparator;

/**
 * This class represents a new {@link Comparator} which is used to sort multiple
 * servers.
 * 
 * @author Aggelowe
 *
 */
public class ServerComparator implements Comparator<MinecraftServer> {

	private final ServerComparisonType comparisonType;
	private final ComparisonDirection direction;

	/**
	 * This constructor constructs a new {@link Comparator} which is used to sort
	 * multiple versions.
	 *
	 */
	public ServerComparator() {
		this(ServerComparisonType.LAST_USED, ComparisonDirection.NORMAL);
	}

	/**
	 * This constructor constructs a new {@link Comparator} which is used to sort
	 * multiple versions.
	 *
	 * @param direction The direction the {@link Comparator} should be sorting
	 *
	 */
	public ServerComparator(ComparisonDirection direction) {
		this(ServerComparisonType.LAST_USED, direction);
	}

	/**
	 * This constructor constructs a new {@link Comparator} which is used to sort
	 * multiple versions.
	 *
	 * @param comparisonType The type of sorting data the comparator will use to
	 *                       sort.
	 */
	public ServerComparator(ServerComparisonType comparisonType) {
		this(comparisonType, ComparisonDirection.NORMAL);
	}

	/**
	 * 
	 * This constructor constructs a new {@link Comparator} which is used to sort
	 * multiple versions.
	 *
	 * @param direction      The direction the {@link Comparator} should be sorting
	 * @param comparisonType The type of sorting data the comparator will use to
	 *                       sort.
	 * 
	 */
	public ServerComparator(ServerComparisonType comparisonType, ComparisonDirection direction) {
		this.comparisonType = comparisonType;
		this.direction = direction;
	}

	@Override
	public int compare(MinecraftServer inputServer1, MinecraftServer inputServer2) {
		switch (comparisonType) {
		case VERSION:
			String version1 = inputServer1.getVersion().getMinecraftVersion();
			String version2 = inputServer2.getVersion().getMinecraftVersion();
			return new VersionComparator(this.direction).compare(version1, version2);
		case ID:
			String id1 = inputServer1.getId();
			String id2 = inputServer2.getId();
			int idResult = id1.compareToIgnoreCase(id2);
			if (this.direction == ComparisonDirection.INVERTED) {
				idResult = idResult * -1;
			}
			return idResult;
		case NAME:
			String name1 = inputServer1.getName();
			String name2 = inputServer2.getName();
			int nameResult = name1.compareToIgnoreCase(name2);
			if (this.direction == ComparisonDirection.INVERTED) {
				nameResult = nameResult * -1;
			}
			return nameResult;
		case LAST_USED:
			Long lastUsage1 = Long.valueOf(inputServer1.getlastUsed());
			Long lastUsage2 = Long.valueOf(inputServer2.getlastUsed());
			int lastUsageResult = lastUsage1.compareTo(lastUsage2);
			if (this.direction == ComparisonDirection.INVERTED) {
				lastUsageResult = lastUsageResult * -1;
			}
			return lastUsageResult;
		default:
			return 0;
		}
	}

	/**
	 * This enum is used to determine he type of sorting data a
	 * {@link ServerComparator} will use to sort.
	 */
	public enum ServerComparisonType {
		NAME, ID, VERSION, LAST_USED;
	}

}
