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
import java.awt.*;
import java.io.File;

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
	
	
	/**
	 * Constructs a new user interface. <br>
	 *
	 * @throws Exception if the interface cannot be loaded.
	 */
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
		
		// Create a map panel to hold the map of the game and add it to the center border of the
		// center panel.
		mapPanel = new MapPanel(this);
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
		
		encyclopediaPanel.updatePanel(current.getName(), current.getPoints(), current
			.getCreatureImagePath(), current.getInterests(), current.getFears(), current
			.isBeingOfLight());
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Updates the points of the game.
	 *
	 * <b>post: </b> Current player points are updated with the points of the found creature whose
	 * name is given by the parameter. If the amount of points reaches below 3000, the game is
	 * lost. If the amount of points reaches more than 5000, the game is won.
	 *
	 * @param pName Name of the creature. pName != null &amp;&amp; pName != "".
	 */
	public void updatePoints(String pName) {
		Creature tempCreature = magicalCreatures.findCreature(pName);
		
		if (!tempCreature.isBeingOfLight())
			magicalCreatures.addPlayerPoints(0 - tempCreature.getPoints());
		else
			magicalCreatures.addPlayerPoints(tempCreature.getPoints());
		
		statusPanel.updatePanel(magicalCreatures.getPoints(),
			magicalCreatures.getRemainingMoves());
		
		if (magicalCreatures.getPoints() <= -3000) {
			JOptionPane.showMessageDialog(this, "Sorry! You have lost the game.",
				"Visit cell", JOptionPane.INFORMATION_MESSAGE);
			mapPanel.disableMapButtons();
			actionsPanel.disableActionsPanel();
		} else if (magicalCreatures.getPoints() >= 5000) {
			JOptionPane.showMessageDialog(this, "Your points are greater than 5000!. You have " +
				"won the game!", "Visit cell", JOptionPane.INFORMATION_MESSAGE);
			mapPanel.disableMapButtons();
			actionsPanel.disableActionsPanel();
			
		}
		
	}
	
	/**
	 * Updates the amount of moves remaining in the game. <br>
	 * <b>post: </b> Modifies the moves remaining in the game. If the number of moves reaches 0,
	 * the game is lost.
	 */
	public void updateMovements() {
		magicalCreatures.decrementNumberOfMoves();
		statusPanel.updatePanel(magicalCreatures.getPoints(),
			magicalCreatures.getRemainingMoves());
		
		if (magicalCreatures.getRemainingMoves() == 0) {
			JOptionPane.showMessageDialog(this, "THE END OF THE GAME", "VISIT BOX",
				JOptionPane.INFORMATION_MESSAGE);
			mapPanel.disableMapButtons();
			actionsPanel.disableActionsPanel();
			
		}
		
	}
	
	
	/**
	 * Loads the information from the game. <br>
	 * <b>post: </b> Updates the encyclopedia information for current creature, loads the map
	 * image, and activates the disabled actions panel buttons.
	 */
	public void loadGame() {
		
		// Load the chosen map properties.
		JFileChooser fileChooser = new JFileChooser("./data");
		fileChooser.setDialogTitle("Load game map");
		int result = fileChooser.showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				magicalCreatures.LoadMapProperties(file);
				mapPanel.updateMap(magicalCreatures.getCells(),
					magicalCreatures.getNumberOfRows(), magicalCreatures.getNumberOfColumns());
				
				// Reset the player points every time a new map is loaded.
				magicalCreatures.addPlayerPoints(0);
				// Set initial number of moves for the map.
				magicalCreatures.setNumberOfMoves(magicalCreatures.getDefaultNumberOfMoves());
				statusPanel.updatePanel(magicalCreatures.getPoints(),
					magicalCreatures.getNumberOfMoves());
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "There were problems loading the file: \n" +
					e.getMessage(), "Load file", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		actionsPanel.enableActionsPanel();
	}
	
	/**
	 * Restarts the game.
	 * <b>post: </b> The map is reset to the default state, the status panel is reset to default
	 * values for points and movements.
	 */
	public void restartGame() {
		magicalCreatures.resetMagicalCreaturesMap();
		mapPanel.updateMap(magicalCreatures.getCells(),
			magicalCreatures.getNumberOfRows(), magicalCreatures.getNumberOfColumns());
		magicalCreatures.setNumberOfMoves(magicalCreatures.getDefaultNumberOfMoves());
		magicalCreatures.addPlayerPoints(0);
		statusPanel.updatePanel(magicalCreatures.getPoints(), magicalCreatures.getRemainingMoves
			());
	}
	
	/**
	 * Shows the next creature in the list.
	 * <b>post: </b> Updates the encyclopedia panel to display the next creature.
	 */
	public void seeNext() {
		try {
			Creature nextCreature = magicalCreatures.getNext();
			encyclopediaPanel.updatePanel(nextCreature.getName(), nextCreature.getPoints(),
				nextCreature.getCreatureImagePath(), nextCreature.getInterests(),
				nextCreature.getFears(), nextCreature.isBeingOfLight());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "See next creature",
				JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	/**
	 * Shows the previous creature in the list.
	 * <b>post: </b> Updates the encyclopedia panel to display the previous creature.
	 */
	public void seePrevious() {
		try {
			Creature previousCreature = magicalCreatures.getPrevious();
			encyclopediaPanel.updatePanel(previousCreature.getName(),
				previousCreature.getPoints(), previousCreature.getCreatureImagePath(),
				previousCreature.getInterests(), previousCreature.getFears(),
				previousCreature.isBeingOfLight());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "See previous creature",
				JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	/**
	 * Shows the number of creatures in the row.
	 */
	public void seeCreaturesInRow() {
		
		String str = " there are ";
		String str1 = " creatures.";
		try {
			String row = JOptionPane.showInputDialog(this, "Enter the row:", "See " +
				"creatures in row", JOptionPane.QUESTION_MESSAGE);
			
			if (row == null) {
				System.out.println("User pressed CANCEL, or window has been closed");
			} else {
				int quantity = magicalCreatures.getQuantityCreaturesRow(Integer.parseInt(row));
				
				if (quantity == 1) {
					str = " there is ";
					str1 = " creature.";
				}
				JOptionPane.showMessageDialog(this, "In row " + row + str +
					quantity + str1, "See creatures in row", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter an integer value.", "See " +
				"creatures in column", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "See creatures in row",
				JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Shows the number of creatures in the column.
	 */
	public void seeCreaturesInColumn() {
		String str = " there are ";
		String str1 = " creatures.";
		try {
			String column = JOptionPane.showInputDialog(this, "Enter the column:", "See " +
				"creatures in column", JOptionPane.QUESTION_MESSAGE);
			
			if (column == null) {
				System.out.println("User pressed CANCEL, or window has been closed");
			} else {
				int quantity = magicalCreatures.getQuantityCreaturesColumn(Integer.parseInt
					(column));
				if (quantity == 1) {
					str = " there is ";
					str1 = " creature.";
				}
				
				JOptionPane.showMessageDialog(this, "In column " + column + str +
						quantity + str1, "See creatures in column",
					JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter an integer value.", "See " +
				"creatures in column", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "See creatures in column",
				JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Shows the number of points in the quadrant.
	 */
	public void seePointsInQuadrant() {
		
		try {
			String quadrant = JOptionPane.showInputDialog(this, "Enter the quadrant:", "See " +
				"points in quadrant", JOptionPane.QUESTION_MESSAGE);
			
			if (quadrant == null) {
				System.out.println("User pressed CANCEL, or window has been closed");
			} else {
				
				JOptionPane.showMessageDialog(this, "There are " + magicalCreatures
						.calculatePointsInQuadrant(Integer.parseInt(quadrant)) + " points " +
						"available in quadrant " + quadrant + ".", "See points in quadrant",
					JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Value of the quadrant is invalid.", "See " +
				"points in quadrant", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "See points in quadrant",
				JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Shows the creature with the highest points that has not yet been found.
	 */
	public void seeHighestPointCreature() {
		
		try {
			JOptionPane.showMessageDialog(this, "The creature with the highest points that " +
				"has not yet been found is: " + magicalCreatures.getHighestPointsCreature()
				                                                .getName(), "See creature with " +
				"highest points", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "See points in quadrant",
				JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Display option 1.
	 */
	public void reqFunctOption1() {
		JOptionPane.showMessageDialog(this, "Response 1", "Response",
			JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Display option 2.
	 */
	public void reqFunctOption2() {
		try {
			JOptionPane.showMessageDialog(this, mapPanel.diagonal3(3,0), "Response",
				JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main method of the application that executes the interface.
	 *
	 * @param args Argument of main method.
	 */
	public static void main(String[] args) {
		try {
			// Unify the interface for Mac and for Windows.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			
			MagicalCreaturesUserInterface userInterface = new MagicalCreaturesUserInterface();
			userInterface.setVisible(true);
		} catch (Exception e) {
			// If you're reading this, thanks for a great semester. I learned a lot in this
			// course and I look forward to taking APO2. Good luck with finals!
			e.printStackTrace();
		}
	}
	
}

