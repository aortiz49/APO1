/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n5_MagicalCreatures
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.magicalCreatures.userInterface;

import uniandes.cupi2.magicalCreatures.world.Creature;
import uniandes.cupi2.magicalCreatures.world.MagicalCreatures;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * User interface of the magical creatures game.
 */

@SuppressWarnings("serial")
public class MagicalCreaturesUserInterface extends JFrame {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Image path of the banner.
	 */
	public final static String IMAGE_PATH = "./data/images/banner.png";
	
	/**
	 * Image path of the map.
	 */
	public final static String MAP_IMAGE_PATH = "./data/map.png";
	
	/**
	 * Image path of the creatures.
	 */
	public final static String CREATURES_PATH = "./data/creatures.properties";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Magical creatures.
	 */
	private MagicalCreatures magicalCreatures;
	
	
	// -----------------------------------------------------------------
	// Attributes of the interface
	// -----------------------------------------------------------------
	
	/**
	 * Panel that displays the status.
	 */
	private StatusPanel statusPanel;
	
	/**
	 * Panel that displays the encyclopedia.
	 */
	private EncyclopediaPanel encyclopediaPanel;
	
	/**
	 * Panel that displays the actions.
	 */
	private ActionsPanel actionsPanel;
	
	/**
	 * Panel that displays the options.
	 */
	private OptionsPanel optionsPanel;
	
	/**
	 * Panel that displays the map.
	 */
	private MapPanel mapPanel;
	
	
	public MagicalCreaturesUserInterface() throws Exception {
		
		setTitle("Magical creatures");
		setLayout(new BorderLayout());
		setSize(780, 750);
		getContentPane().setBackground(new Color(48, 41, 84));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create the magical creatures.
		magicalCreatures = new MagicalCreatures(CREATURES_PATH);
		
		
		// Create a label to hold the banner image and add it to the north border of the frame.
		JLabel imageLbl = new JLabel();
		imageLbl.setIcon(new ImageIcon(IMAGE_PATH));
		add(imageLbl, BorderLayout.NORTH);
		
		// Create center panel to hold status panel, map panel, and encyclopedia panel.
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		add(centerPanel, BorderLayout.CENTER);
		
		// Status panel: passive panel.
		// Create a status panel and add it to the north border of the center panel.
		statusPanel = new StatusPanel();
		centerPanel.add(statusPanel, BorderLayout.NORTH);
		
		//mapImageLbl= new JLabel();
		//centerPanel.add(mapImageLbl,BorderLayout.CENTER);
		mapPanel = new MapPanel();
		centerPanel.add(mapPanel, BorderLayout.CENTER);
		
		// Encyclopedia panel: active panel.
		// Create an encyclopedia panel and add it to the east border of the center panel.
		encyclopediaPanel = new EncyclopediaPanel(this);
		centerPanel.add(encyclopediaPanel, BorderLayout.EAST);
		
		// Create south panel to hold actions panel and options panel.
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		southPanel.setBackground(new Color(48, 41, 84));
		add(southPanel, BorderLayout.SOUTH);
		
		// Actions panel: active panel.
		// Add actions panel to the north border of the south panel.
		actionsPanel = new ActionsPanel(this);
		southPanel.add(actionsPanel, BorderLayout.NORTH);
		
		// Options panel: active panel.
		// Add options panel to the south border of the south panel.
		optionsPanel = new OptionsPanel(this);
		southPanel.add(optionsPanel, BorderLayout.SOUTH);
		
		Creature current = magicalCreatures.getCurrentCreature();
		encyclopediaPanel.updatePanel2(current.getName(), current.getPoints(), current
			.getCreatureImagePath(), current.getInterests(), current.getFears(), current
			.isBeingOfLight());
		
	}
	
	public void loadGame() {
		
		try {
			statusPanel.updatePanel(magicalCreatures.getPoints(), magicalCreatures
				.getRemainingMoves());
			mapPanel.loadMap(MAP_IMAGE_PATH);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "There were problems loading the" +
					" " +
					"map, the file could not be loaded.",
				JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	/**
	 * Muestra el nextCreature veh�culo en la lista.
	 */
	public void seeNext() {
		try {
			Creature nextCreature = magicalCreatures.getNext();
			encyclopediaPanel.updatePanel2(nextCreature.getName(), nextCreature.getPoints(),
				nextCreature
					.getCreatureImagePath(), nextCreature.getInterests(), nextCreature.getFears(),
				nextCreature
					.isBeingOfLight());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Ver veh�culo nextCreature",
				JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	/**
	 * Muestra el nextCreature veh�culo en la lista.
	 */
	public void seePrevious() {
		try {
			Creature previousCreature = magicalCreatures.getPrevious();
			encyclopediaPanel.updatePanel2(previousCreature.getName(),
				previousCreature.getPoints(), previousCreature.getCreatureImagePath(),
				previousCreature.getInterests(), previousCreature.getFears(),
				previousCreature.isBeingOfLight());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Ver veh�culo nextCreature",
				JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	public static void main(String[] args) {
		try {
			// Unify the interface for Mac and for Windows.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			
			MagicalCreaturesUserInterface userInterface = new MagicalCreaturesUserInterface();
			userInterface.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

