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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import eu.aggelowe.projects.mbsm.util.exceptions.InvalidParameterException;
import eu.aggelowe.projects.mbsm.util.interfaces.IAction;

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

	/**
	 * This method generates a new random id which can be used to identify different
	 * objects.
	 * 
	 * @param chars    The number of characters of the id
	 * @param charSets The number of character sets separated by a "-"
	 * 
	 * @return The generated id
	 */
	public static String getRandomID(int chars, int charSets) {
		String serverId = "";
		for (int counter = 0; counter < charSets; counter++) {
			if (serverId.equals("")) {
				serverId = getRandomID(chars);
			} else {
				serverId = serverId + "-" + getRandomID(chars);
			}
		}
		return serverId;
	}

	/**
	 * This method generates a new random id which can be used to identify different
	 * objects.
	 * 
	 * @param chars The number of characters of the id
	 * @return The generated id
	 */
	public static String getRandomID(int chars) {
		if (chars <= 0) {
			new InvalidParameterException("The number of characters must be more than zero");
		}
		String id = "";
		Random random = new Random();
		for (int counter = 0; counter < chars; counter++) {
			id = id + random.nextInt(10);
		}
		return id;
	}

	/**
	 * This method adds a new {@link IAction} to be executed when the application
	 * exits.
	 * 
	 * @param action The action to execute
	 */
	public static void addActionOnShutdown(IAction action) {
		Thread thread = new Thread("Shutdown-thread" + getRandomID(4)) {
			public void run() {
				if (action != null) {
					action.execute();
				}
			};
		};
		Runtime.getRuntime().addShutdownHook(thread);
	}

	/**
	 * This method makes the first letter of the {@link String} object to upper
	 * case.
	 * 
	 * @param string The object mentioned above
	 * 
	 * @return The changed string
	 */
	public static String capitaliseFirstLetter(String string) {
		String firstLetter = string.substring(0, 1);
		String unchangedString = string.substring(1);
		return firstLetter.toUpperCase() + unchangedString;
	}

	/**
	 * This method is used to sort alphabetically the elements of the given
	 * {@link List}.
	 * 
	 * @param names The elements of the {@link List}
	 */
	public static void sortAlphabetically(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String input1, String input2) {
				return input1.compareToIgnoreCase(input2);
			}
		});
	}

	/**
	 * This method is used to sort numerically the elements of the given
	 * {@link List}.
	 * 
	 * @param ints The elements of the {@link List}
	 */
	public static void sortNumerically(List<Integer> ints) {
		Collections.sort(ints, new Comparator<Integer>() {
			@Override
			public int compare(Integer input1, Integer input2) {
				return input1.compareTo(input2);
			}
		});
	}

	/**
	 * This method returns the maximum number from the given array.
	 * 
	 * @param ints The given array
	 * 
	 * @return The maximum number
	 */
	public static int getMaxNumber(Integer... ints) {
		return getMaxNumber(Arrays.asList(ints));
	}

	/**
	 * This method returns the maximum number from the given {@link List}.
	 * 
	 * @param ints The given {@link List}
	 * 
	 * @return The maximum number
	 */
	public static int getMaxNumber(List<Integer> ints) {
		int maximumInt = ints.get(0);
		for (int processInt : ints) {
			if (processInt > maximumInt) {
				maximumInt = processInt;
			}
		}
		return maximumInt;
	}

	/**
	 * This method returns the minimum number from the given array.
	 * 
	 * @param ints The given array
	 * 
	 * @return The minimum number
	 */
	public static int getMinNumber(Integer... ints) {
		return getMinNumber(Arrays.asList(ints));
	}

	/**
	 * This method returns the minimum number from the given {@link List}.
	 * 
	 * @param ints The given {@link List}
	 * 
	 * @return The minimum number
	 */
	public static int getMinNumber(List<Integer> ints) {
		if (ints.size() == 0) {
			return 0;
		}
		int minimumInt = ints.get(0);
		for (int processInt : ints) {
			if (processInt < minimumInt) {
				minimumInt = processInt;
			}
		}
		return minimumInt;
	}

	/**
	 * This method centers the text of a {@link JTextPane}.
	 * 
	 * @param text The {@link JTextPane} to center it's text.
	 */
	public static final void centerText(JTextPane text) {
		StyledDocument doc = text.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}

	/**
	 * This method combines all the given {@link IAction} objects into one.
	 * 
	 * @param actions The actions to be combined
	 * @return The result action
	 */
	public static final IAction combineActions(IAction... actions) {
		IAction result = new IAction() {
			@Override
			public void execute() {
				for (IAction action : actions) {
					action.execute();
				}
			}
		};
		return result;
	}

}
