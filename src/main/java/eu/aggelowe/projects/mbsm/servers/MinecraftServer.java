package eu.aggelowe.projects.mbsm.servers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import eu.aggelowe.projects.mbsm.files.FileInit;
import eu.aggelowe.projects.mbsm.files.FileReference;
import eu.aggelowe.projects.mbsm.util.INamed;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidFileTypeException;
import eu.aggelowe.projects.mbsm.util.exceptions.ServerException;
import eu.aggelowe.projects.mbsm.util.exceptions.StreamUnavailableException;

public final class MinecraftServer implements INamed {

	private final ProcessBuilder command;
	private final String path;
	private final AllocatableMemory memory;

	private boolean isDeleted = false;
	private boolean isInitialised = false;
	private String name;
	private Process process = null;
	private RunnableVersion version = null;

	public MinecraftServer(String name, AllocatableMemory memory, RunnableVersion version) {
		this.name = name;
		this.path = FileReference.APPLICATION_FOLDER_PATH + "servers/" + name + "/";
		this.command = new ProcessBuilder("java", "-Xmx" + memory + "M", "-jar", ServerReference.RUNNABLES_PATH + version.getName() + ".jar", "nogui");
		this.command.directory(new File(this.path));
		this.memory = memory;
		this.version = version;
		ServerReference.SERVERS.add(this);
	}

	public void init() throws ServerException {
		if (isDeleted) {
			throw new ServerException("Server has been deleted");
		} else if (isInitialised) {
			throw new ServerException("Server has already been initalised");
		}
		try {
			FileInit.initFolder(this.path);
		} catch (InvalidFileTypeException exception) {
			exception.printStackTrace();
			ServerReference.SERVER_LOGGER.error("The server " + name + " failed to construct.");
		}
		this.isInitialised = true;
	}

	public void delete() throws ServerException {
		if (isDeleted) {
			throw new ServerException("Server has already been deleted");
		}
		this.isDeleted = true;
		ServerReference.SERVERS.remove(this);
	}

	public void start() throws ServerException {
		if (isDeleted) {
			throw new ServerException("Server has been deleted");
		} else if (!isInitialised) {
			throw new ServerException("Server hasn't been initalised");
		} else if (process != null) {
			throw new ServerException("The server is already running");
		}
		try {
			process = command.start();
		} catch (IOException exception) {
			exception.printStackTrace();
			ServerReference.SERVER_LOGGER.error("The server " + name + " failed to launch.");
		}
	}

	public void stop() throws ServerException {
		if (isDeleted) {
			throw new ServerException("Server has been deleted");
		} else if (!isInitialised) {
			throw new ServerException("Server hasn't been initalised");
		} else if (process == null) {
			throw new ServerException("The server is already stopped");
		}
		process.destroy();
		this.process = null;
	}

	public void forceStop() throws ServerException {
		if (isDeleted) {
			throw new ServerException("Server has been deleted");
		} else if (!isInitialised) {
			throw new ServerException("Server hasn't been initalised");
		} else if (process == null) {
			throw new ServerException("The server is already stopped");
		}
		process.destroyForcibly();
		this.process = null;
	}

	public boolean isRunning() {
		if (process != null) {
			return process.isAlive();
		}
		return false;
	}

	public InputStream getServerOutputStream() throws StreamUnavailableException, ServerException {
		if (isDeleted) {
			throw new ServerException("Server has been deleted");
		} else if (!isInitialised) {
			throw new ServerException("Server hasn't been initalised");
		} else if (process == null) {
			throw new StreamUnavailableException("The Minecraft server hasn't started yet");
		}
		return process.getInputStream();
	}

	public InputStream getServerErrorStream() throws StreamUnavailableException, ServerException {
		if (isDeleted) {
			throw new ServerException("Server has been deleted");
		} else if (!isInitialised) {
			throw new ServerException("Server hasn't been initalised");
		} else if (process == null) {
			throw new StreamUnavailableException("The Minecraft server hasn't started yet");
		}
		return process.getErrorStream();
	}

	public OutputStream getServerInputStream() throws StreamUnavailableException, ServerException {
		if (isDeleted) {
			throw new ServerException("Server has been deleted");
		} else if (!isInitialised) {
			throw new ServerException("Server hasn't been initalised");
		} else if (process == null) {
			throw new StreamUnavailableException("The Minecraft server hasn't started yet");
		}
		return process.getOutputStream();
	}

	public String getPath() {
		return path;
	}

	public String getName() {
		return name;
	}
	
	public RunnableVersion getVersion() {
		return version;
	}

	public void setVersion(RunnableVersion version) throws ServerException {
		if (isRunning()) {
			throw new ServerException("The server is currently running");
		}
		this.version = version;
	}

	public void setName(String name) throws ServerException {
		if (isRunning()) {
			throw new ServerException("The server is currently running");
		}
		this.name = name;
	}

	public AllocatableMemory getMemory() {
		return memory;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public boolean isInitialised() {
		return isInitialised;
	}

}
