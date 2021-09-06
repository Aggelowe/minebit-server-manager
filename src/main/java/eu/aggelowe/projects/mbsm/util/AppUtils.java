package eu.aggelowe.projects.mbsm.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

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
	 * This method returns the given resource as an {@link InputStream} based on the
	 * information got from the input {@link String}.
	 * 
	 * @param resource The resource which is going to be obtained from the resources
	 *                 folder.
	 * @return The actual resource as an {@link InputStream}
	 */
	public static InputStream getResourceAsStream(String resource) {
		if (resource == null) {
			return null;
		}
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
	}

	/**
	 * This method transforms a {@link Double} to an {@link Integer} using rounding.
	 * 
	 * @return
	 */
	public static int truncateDouble(double input) {
		return Integer.valueOf(new DecimalFormat("#").format(input));
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

	/**
	 * This method sets the final size of the given component.
	 * 
	 * @param component The component of which the size is going to be changed.
	 * @param sizeThe   new size of the component.
	 */
	public static void setFinalComponentSize(Component component, Dimension size) {
		component.setMaximumSize(size);
		component.setPreferredSize(size);
		component.setMinimumSize(size);
	}

	/**
	 * This method generates a new {@link ImageIcon} which is fully filled with the
	 * color given.
	 * 
	 * @param size  The size of the generated image.
	 * @param color The color of the generated image.
	 * @return The generated {@link ImageIcon}.
	 */
	public static ImageIcon getColorImageIcon(Dimension size, Color color) {
		BufferedImage image = new BufferedImage(AppUtils.truncateDouble(size.getWidth()), AppUtils.truncateDouble(size.getHeight()), BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics = image.createGraphics();
		graphics.setPaint(color);
		graphics.fillRect(0, 0, AppUtils.truncateDouble(size.getWidth()), AppUtils.truncateDouble(size.getHeight()));
		graphics.dispose();
		return new ImageIcon(image);
	}

}
