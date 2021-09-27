package eu.aggelowe.projects.mbsm.servers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import eu.aggelowe.projects.mbsm.util.INamed;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidFileTypeException;

/**
 * This class represents a new runnable minecraft version.
 * 
 * @author Aggelowe
 *
 */
public class RunnableVersion implements INamed {

	private final String name;
	private final String type;
	private final String version;
	private final String downloadUrl;

	/**
	 * This constructor constructs represents a new runnable minecraft version.
	 * 
	 * @param name        The name of the version
	 * @param type        The type of the version
	 * @param version     The release version
	 * @param downloadUrl The executable's download url
	 *
	 */
	public RunnableVersion(String name, String type, String version, String downloadUrl) {
		this.name = name;
		this.type = type;
		this.version = version;
		this.downloadUrl = downloadUrl;
	}

	/**
	 * This method downloads the given file to the <i>runnables</i> folder 
	 */
	public void download() {
		if (new File(ServerReference.RUNNABLES_PATH + name + ".jar").isDirectory()) {
			new InvalidFileTypeException("The given version already exists as a directory");
		}
		if (!new File(ServerReference.RUNNABLES_PATH + name + ".jar").exists()) {
			try {
				BufferedInputStream in = new BufferedInputStream(new URL(downloadUrl).openStream());
				FileOutputStream fileOutputStream = new FileOutputStream(ServerReference.RUNNABLES_PATH + name + ".jar");
				byte dataBuffer[] = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					fileOutputStream.write(dataBuffer, 0, bytesRead);
				}
				fileOutputStream.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}

	@Override
	public String getObjectName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

}
