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
public class MapPanel extends JPanel {
	
	
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
	 * Array of buttons for the map.
	 */
	private JButton buttons[][];
	
	/**
	 * The latest data loaded by the game.
	 */
	private Properties data;
	
	
	public MapPanel() throws Exception {
		setLayout(new GridLayout(10, 12));
		System.out.println("data: " + numberOfColumns + "__" + numberOfRows);
	
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
		
		buttons = new JButton[numberOfRows][numberOfColumns];
		String[] properties;
		int[][] icons = new int[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				properties = pData.getProperty("map.row" + (i + 1)).split(",");
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
				//buttons[i][j].setBorderPainted(false);
				add(buttons[i][j]);
			}
		}
		setVisible(false);
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
		initializeMap(loadMapInformation(pFile));
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent event) {
	
	}
	
	
	
}
	


	

