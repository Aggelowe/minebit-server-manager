package eu.aggelowe.projects.mbsm.gui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.metal.MetalScrollBarUI;

import eu.aggelowe.projects.mbsm.util.AppUtils;

/**
 * This class creates a single color look and feel for the ScrollBar.
 * 
 * @author Aggelowe
 */
public class AppScrollBarUI extends MetalScrollBarUI {

	private final Color backgroundColor ,thumbColor, thumbBorderColor;
	private final int thumbBorderThickness;

	/**
	 * This constructor constructs a new single color look and feel for a
	 * {@link JScrollBar}.
	 * 
	 * @author aggelos
	 */
	public AppScrollBarUI(Color backgroundColor, Color thumbColor, Color thumbBorderColor, int thumbBorderThickness) {
		this.backgroundColor = backgroundColor;
		this.thumbColor = thumbColor;
		this.thumbBorderColor = thumbBorderColor;
		this.thumbBorderThickness = thumbBorderThickness;
	}
	
	@Override
	public void paint(Graphics graphics, JComponent component) {
		super.paint(graphics, component);
		component.setBackground(backgroundColor);
	}

	@Override
	protected void paintThumb(Graphics graphics, JComponent component, Rectangle thumbBounds) {
		graphics.setColor(thumbColor);
		Image thumb = AppUtils.getColorImageIcon(new Dimension(32, 32), thumbColor).getImage();
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.drawImage(thumb, thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, null);
		graphics.setColor(thumbBorderColor);
		Image thumbBorder = AppUtils.getColorImageIcon(new Dimension(32, 32), thumbBorderColor).getImage();
		graphics2d.drawImage(thumbBorder, thumbBounds.x, thumbBounds.y, thumbBorderThickness, thumbBounds.height, null);
		graphics2d.drawImage(thumbBorder, thumbBounds.x, thumbBounds.y - 2, thumbBounds.width, thumbBorderThickness, null);
		graphics2d.drawImage(thumbBorder, thumbBounds.x, thumbBounds.y + thumbBounds.height, thumbBounds.width, thumbBorderThickness, null);
	}

	@Override
	protected void paintTrack(Graphics graphics, JComponent component, Rectangle trackBounds) {
	}

	/**
	 * This button will not appear on this configuration.
	 */
	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton output = new JButton();
		AppUtils.setFinalComponentSize(output, new Dimension(0, 0));
		return output;
	}

	/**
	 * This button will not appear on this configuration.
	 */
	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton output = new JButton();
		AppUtils.setFinalComponentSize(output, new Dimension(0, 0));
		return output;
	}

}
