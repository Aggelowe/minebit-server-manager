package eu.aggelowe.projects.tbsm.util;

import java.net.URL;

/**
 * This class contains a lot of very useful utilities for the application which
 * can be used to increase the performance of make the coding of the application
 * easier.
 * 
 * @author Aggelowe
 *
 */
public final class AppUtils {

	/**
	 * This method returns the given resource as a {@link URL} based on the
	 * information got from the input {@link String}.
	 * 
	 * @param resource The resource which is going to be obtained from the resources
	 *                 folder.
	 * @return The actual resource as a {@link URL}
	 */
	public static URL getResource(String resource) {
		if (resource == null) {
			return null;
		}
		return Thread.currentThread().getContextClassLoader().getResource(resource);
	}

}
