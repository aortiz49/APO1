/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n4_Album
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.userInterface;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import uniandes.cupi2.album.world.Player;

import java.awt.Graphics;

/**
 * Panel that contains the background.
 */
@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {
	// -----------------------------------------------------------------
	// User interface attributes
	// -----------------------------------------------------------------
	
	/**
	 * Background image of the album.
	 */
	private ImageIcon background;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the panel with the album background. <br>
	 * <b>post:</b> The panel with the album background was created.
	 */
	public BackgroundPanel() {
		background = new ImageIcon("./data/images/background.png");
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Paints the panel and its components.
	 *
	 * @param pG Surface of the panel.
	 */
	public void paintComponent(Graphics pG) {
		pG.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(pG);
	}
}
