package uniandes.cupi2.magicalCreatures.userInterface;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Contains the map of the interface.
 */
public class MapPanel extends JPanel implements ActionListener {
	
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Path of the map.
	 */
	public final static String MAP_IMAGE_PATH = "./data/map.png";
	
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	
	/**
	 * Principal window of the application.
	 */
	private MagicalCreaturesUserInterface principal;
	
	/**
	 * Number of movements left for the player.
	 */
	private int numberOfMoves;
	
	/**
	 * Height of the map.
	 */
	private int numberOfRows;
	
	/**
	 * Length of the map.
	 */
	private int numberOfColumns;
	
	/**
	 * Number of creatures in the map.
	 */
	private int numberOfCreatures;
	
	/**
	 * Array of buttons for the map.
	 */
	private JButton buttons[][];
	
	/**
	 * The latest data loaded by the game.
	 */
	private Properties data;
	
	/**
	 * Array of creatures on the map.
	 */
	String[][] creaturesArray;
	
	int[] creatureX;
	
	int[] creatureY;
	
	/**
	 * Constructs a new map panel.
	 *
	 * @param pPrincipal
	 *
	 * @throws Exception
	 */
	public MapPanel(MagicalCreaturesUserInterface pPrincipal) throws Exception {
		
		principal = pPrincipal;
		setLayout(new GridLayout(10, 12));
		System.out.println("data: " + numberOfColumns + "__" + numberOfRows);
		JButton x = new JButton();
		
	}
	
	
	/**
	 * Loads the map information with the creatures in an object of type Properties.
	 *
	 * @param pFile The file that contains the description of the map and creatures.
	 *
	 * @return An object of the Properties class with the information from the file.
	 * @throws Exception Throws an exception if the file doesn't exist or if the format cis
	 *                   invalid and cannot be read.
	 */
	private Properties loadMapInformation(File pFile) throws Exception {
		
		Properties mapData = new Properties();
		FileInputStream in = new FileInputStream(pFile);
		try {
			mapData.load(in);
			in.close();
		} catch (Exception e) {
			throw new Exception("Invalid format");
		}
		return mapData;
	}
	
	
	private void initializeMap(Properties pData) {
		
		numberOfMoves = Integer.parseInt(pData.getProperty("map.numberOfMoves"));
		numberOfRows = Integer.parseInt(pData.getProperty("map.numberOfRows"));
		numberOfColumns = Integer.parseInt(pData.getProperty("map.numberOfColumns"));
		numberOfCreatures = Integer.parseInt(pData.getProperty("map.numberOfCreatures"));
		
		
		buttons = new JButton[numberOfRows][numberOfColumns];
		
		
		// Create an array containing the locations of the creatures.
		creaturesArray = new String[numberOfRows][numberOfColumns];
		creatureX = new int[numberOfCreatures];
		creatureY = new int[numberOfCreatures];
		for (int i = 0; i < numberOfCreatures; i++) {
			String[] creatures = pData.getProperty("map.creature" + (i + 1)).split(",");
			creatureX[i] = Integer.parseInt(creatures[1]);
			creatureY[i] = Integer.parseInt(creatures[2]);
			creaturesArray[creatureX[i]][creatureY[i]] = creatures[0];
			
		}
		
		// Set the map configuration according to the properties file.
		int[][] icons = new int[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			String[] properties = pData.getProperty("map.row" + (i + 1)).split(",");
			for (int j = 0; j < numberOfColumns; j++) {
				icons[i][j] = Integer.parseInt(properties[j]);
				buttons[i][j] = new JButton();
				
				switch (icons[i][j]) {
					case 0:
						buttons[i][j].setIcon(new ImageIcon("./data/images/meadow.png"));
						break;
					case 1:
						buttons[i][j].setIcon(new ImageIcon("./data/images/woods.png"));
						break;
					case 2:
						buttons[i][j].setIcon(new ImageIcon("./data/images/ocean.png"));
						break;
					case 3:
						buttons[i][j].setIcon(new ImageIcon("./data/images/cave.png"));
						break;
					
				}
				buttons[i][j].addActionListener(this);
				buttons[i][j].setActionCommand(Integer.toString(i) + Integer.toString(j));
				//buttons[i][j].setBorderPainted(false);
				buttons[i][j].setBackground(new Color(237, 221, 123));
				add(buttons[i][j]);
				
				setVisible(false);
				
			}
		}
		
	}
	
	
	public int getNumberOfMoves() {
		return numberOfMoves;
	}
	
	public int getNumberOfRows() {
		return numberOfRows;
	}
	
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	public void updateMap(File pFile) throws Exception {
		removeAll();
		//	setBackground(new Color(237, 221, 123));
		initializeMap(loadMapInformation(pFile));
		setVisible(true);
		
	}
	
	public JButton[][] getButtons() {
		return buttons;
	}
	
	
	public void actionPerformed(ActionEvent pEvent) {
		
		String command = pEvent.getActionCommand();
		//int creature
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				if (command.equals(Integer.toString(i) + Integer.toString(j))) {
					principal.updateMovements();
					if (creaturesArray[i][j] != null) {
						JOptionPane.showMessageDialog(this, "YOU FOUND A " + creaturesArray[i][j],
							"TEST", JOptionPane
								.INFORMATION_MESSAGE);
						buttons[i][j].setIcon(new ImageIcon(new ImageIcon("" +
							"./data/creatures/" + creaturesArray[i][j] + ".png")
							.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
						principal.updatePoints(creaturesArray[i][j]);
					} else {
						buttons[i][j].setIcon(new ImageIcon("./data/images/visited.png"));
				
					}
					
				}
				
			}
			
		}
		
	}
	
}


	

