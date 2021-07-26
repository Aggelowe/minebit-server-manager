package eu.aggelowe.projects.mbsm.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;

import eu.aggelowe.projects.mbsm.storage.StorageReference;
import eu.aggelowe.projects.mbsm.util.exceptions.InvalidFileTypeException;

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

	/**
	 * This method returns the given {@link ImageIcon} resized to the given size;
	 * 
	 * @param inputImage The initial image.
	 * @param size       The size to which the image is going to get resized.
	 * @return the resized image.
	 */
	public static ImageIcon resizeImageIcon(ImageIcon inputImage, Dimension size) {
		Image sourceImage = inputImage.getImage();
		BufferedImage outputImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = outputImage.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics.drawImage(sourceImage, 0, 0, size.width, size.height, null);
		return new ImageIcon(outputImage);
	}
	
	public static void setFinalComponentSize(Component component, Dimension size) {
		component.setMaximumSize(size);
		component.setPreferredSize(size);
		component.setMinimumSize(size);
	}
	
	/**
	 * This method checks if the application directory exists and creates the folder
	 * if it doesn't or throws an {@link InvalidFileTypeException} if a file with
	 * the same name exists in it's position.
	 * 
	 * @throws InvalidFileTypeException
	 */
	public static void initStorageLocation() throws InvalidFileTypeException {
		final File applicationDirectory = new File(StorageReference.APPLICATION_FILE_PATH);
		if (!applicationDirectory.exists()) {
			applicationDirectory.mkdir();
		} else if (!applicationDirectory.isDirectory()) {
			throw new InvalidFileTypeException();
		}
	}

}
