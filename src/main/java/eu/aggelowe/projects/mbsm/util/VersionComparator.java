package eu.aggelowe.projects.mbsm.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import eu.aggelowe.projects.mbsm.MBSM;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidParameterException;

/**
 * This class represents a new {@link Comparator} which is used to sort multiple
 * versions.
 * 
 * @author Aggelowe
 *
 */
public final class VersionComparator implements Comparator<String> {

	private final SortingDirection sortingDirection;

	/**
	 * This constructor constructs a new {@link Comparator} which is used to sort
	 * multiple versions from the newest to the oldest.
	 *
	 */
	public VersionComparator() {
		this(SortingDirection.NEWEST_TO_OLDEST);
	}

	/**
	 * This constructor constructs a new {@link Comparator} which is used to sort
	 * multiple versions using the given {@link SortingDirection}.
	 *
	 * @param sortingDirection The direction the {@link Comparator} will be sorting.
	 */
	public VersionComparator(SortingDirection sortingDirection) {
		this.sortingDirection = sortingDirection;
	}

	@Override
	public int compare(String version1, String version2) {
		if (checkVersionFormat(version1) == false || checkVersionFormat(version2) == false) {
			new InvalidParameterException("One of the given versions uses a false format").printStackTrace();
			MBSM.exit(ExitStatus.ERROR);
		}
		List<String> firstVersionElements = Arrays.asList(version1.split("\\."));
		List<String> secondVersionElements = Arrays.asList(version2.split("\\."));
		int maxVersionElements = AppUtils.getMaxNumber(firstVersionElements.size(), secondVersionElements.size(), 0);
		for (int counter = 0; counter < maxVersionElements; counter++) {
			if (firstVersionElements.size() == counter && secondVersionElements.size() == counter) {
				return 0;
			}
			if (firstVersionElements.size() == counter) {
				return sortingDirection == SortingDirection.NEWEST_TO_OLDEST ? 1 : -1;
			}
			if (secondVersionElements.size() == counter) {
				return sortingDirection == SortingDirection.NEWEST_TO_OLDEST ? -1 : 1;
			}
			int firstIntElement = Integer.valueOf(firstVersionElements.get(counter));
			int secondIntElement = Integer.valueOf(secondVersionElements.get(counter));
			if (firstIntElement < secondIntElement) {
				return sortingDirection == SortingDirection.NEWEST_TO_OLDEST ? 1 : -1;
			}
			if (firstIntElement > secondIntElement) {
				return sortingDirection == SortingDirection.NEWEST_TO_OLDEST ? -1 : 1;
			}
		}
		return 0;
	}

	/**
	 * This method checks if the given {@link String} object follows the version
	 * format.
	 * 
	 * @param version The version to check
	 *
	 */
	private boolean checkVersionFormat(String version) {
		String versionCopy = new String(version);
		String[] validChars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." };
		if (versionCopy.startsWith(".") || versionCopy.endsWith(".")) {
			return false;
		}
		for (String character : validChars) {
			versionCopy = versionCopy.replace(character, "");
		}
		return versionCopy.equals("");
	}

	public static enum SortingDirection {
		NEWEST_TO_OLDEST, OLDEST_TO_NEWEST;
	}

}
