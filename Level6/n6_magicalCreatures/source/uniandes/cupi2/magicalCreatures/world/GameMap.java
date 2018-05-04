package uniandes.cupi2.magicalCreatures.world;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class GameMap {
	
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
	 * The latest data loaded by the game.
	 */
	private Properties data;
	
	
	public GameMap(File pFile) throws Exception {
		initializeMap(loadMapInformation(pFile));
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
	
}
	
	
