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
package uniandes.cupi2.magicalCreatures.world;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Magical creatures searching game.
 */
public class MagicalCreatures {
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Encyclopedia of creatures that can be found.
	 */
	private Creature[] encyclopedia;
	
	/**
	 * Array that contains the cells.
	 */
	private MapCell[][] cells;
	
	/**
	 * The latest creature data loaded by the game.
	 */
	private Properties data;
	
	/**
	 * Properties of the map.
	 */
	private Properties mapData;
	
	/**
	 * Current creature on display.
	 */
	private int currentCreature;
	
	/**
	 * Current number of moves remaining.
	 */
	private int numberOfMoves;
	
	/**
	 * Default number of moves from properties.
	 */
	private int defaultMoves;
	
	/**
	 * Player's points.
	 */
	private int playerPoints;
	
	/**
	 * Number of rows in the map
	 */
	private int numberOfRows;
	
	/**
	 * Number of columns in the map
	 */
	private int numberOfColumns;
	
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Creates the magical creatures and loads the encyclopedia. <br>
	 * <b>post: </b> Array of creatures is initialized with the information from the encyclopedia.
	 *
	 * @param pFilePath Image path of the creatures' pictures.
	 *                  pFilePath != null &amp;&amp; pFilePath != "".
	 *
	 * @throws Exception If there was an error when loading the file.
	 *                   If there was an error when reading the format of the file.
	 */
	public MagicalCreatures(String pFilePath) throws Exception {
		loadCreatureProperties(pFilePath);
		initializeCreatures();
	}
	
	/**
	 * Loads the file given by the parameter to process it in order to access creature information.
	 *
	 * @param pFilePath File path of specified file. . pImagePath != null &amp;&amp; pImagePath
	 *                  != "".
	 *
	 * @throws Exception If there is a problem when loading the file.
	 */
	private void loadCreatureProperties(String pFilePath) throws Exception {
		data = new Properties();
		FileInputStream in = new FileInputStream(pFilePath);
		try {
			data.load(in);
			in.close();
			
		} catch (IOException e) {
			throw new Exception("Error when loading the file, file not valid.");
		}
	}
	
	/**
	 * Loads the game information with the creatures in an object of type Properties. <br>
	 *
	 * @param pFile File containing the map's properties. pFile != null &amp;&amp; pFile != "".
	 *
	 * @throws Exception Throws an exception if the file doesn't exist or if the format is
	 *                   invalid and cannot be read.
	 */
	public void LoadMapProperties(File pFile) throws Exception {
		//loadMapInformation(pFile);
		mapData = new Properties();
		FileInputStream in = new FileInputStream(pFile);
		try {
			mapData.load(in);
			in.close();
		} catch (Exception e) {
			throw new Exception("Invalid format");
		}
		initializeMapDetails();
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns the number of rows in the map.
	 *
	 * @return The number of rows.
	 */
	public int getNumberOfRows() {
		return numberOfRows;
	}
	
	/**
	 * Returns the number of columns in the map.
	 *
	 * @return The number of columns.
	 */
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	
	/**
	 * Returns the initial number of moves in the game..
	 *
	 * @return The initial number of moves.
	 */
	public int getDefaultNumberOfMoves() {
		return defaultMoves;
	}
	
	/**
	 * Returns the cells array.
	 *
	 * @return The cells from the map.
	 */
	public MapCell[][] getCells() {
		return cells;
	}
	
	/**
	 * Returns the number of moves the player currently has.
	 *
	 * @return Current number of moves.
	 */
	public int getNumberOfMoves() {
		return numberOfMoves;
	}
	
	
	/**
	 * Sets the number of moves to the number of moves given by the parameter. <br>
	 * <b> post:</b> The number of moves of the current map is set to the value given by the
	 * parameter.
	 *
	 * @param pNumberOfMoves Number of moves to be set.
	 */
	public void setNumberOfMoves(int pNumberOfMoves) {
		numberOfMoves = pNumberOfMoves;
	}
	
	/**
	 * Decreases number of moves available by one. <br>
	 * <b> post:</b> The number of moves of the current map is decremented by one.
	 */
	public void decrementNumberOfMoves() {
		numberOfMoves--;
	}
	
	/**
	 * Adds points to the current player map. <br>
	 * <b> post:</b> The number of points of the current map is updated to reflect the new
	 * creature found.
	 *
	 * @param pPoints The amount of points to be added to the total.
	 */
	public void addPlayerPoints(int pPoints) {
		// If the parameter is 0, reset the player's points.
		if (pPoints == 0)
			playerPoints = 0;
		playerPoints += pPoints;
	}
	
	/**
	 * Returns the current creature of the encyclopedia. <br>
	 *
	 * @return The current creature of the encyclopedia.
	 */
	public Creature getCurrentCreature() {
		return encyclopedia[currentCreature];
	}
	
	/**
	 * Initializes the map. <br>
	 * <b>post: </b> The cells on the map are populated with the terrain type, and creature. If
	 * the cell is visited, it modifies the status of the cell to visited.
	 *
	 * @throws Exception If there is an problem reading the file.
	 */
	private void initializeMapDetails() throws Exception {
		try {
			// Keep the number of moves from the configuration stored in order to make the reset
			// possible.
			defaultMoves = Integer.parseInt(mapData.getProperty("map.numberOfMoves"));
			numberOfRows = Integer.parseInt(mapData.getProperty("map.numberOfRows"));
			numberOfColumns = Integer.parseInt(mapData.getProperty("map.numberOfColumns"));
			int numberOfCreatures = Integer.parseInt(mapData.getProperty("map.numberOfCreatures"));
			
			// Create array of cells.
			cells = new MapCell[numberOfRows][numberOfColumns];
			
			// Create an array containing the map configuration for the terrain.
			//	terrainLocationArray = new int[numberOfRows][numberOfColumns];
			for (int i = 0; i < numberOfRows; i++) {
				String[] properties = mapData.getProperty("map.row" + (i + 1)).split(",");
				for (int j = 0; j < numberOfColumns; j++) {
					// Create all of the cell objects in the map.
					cells[i][j] = new MapCell();
					cells[i][j].setTerrainType(Integer.parseInt(properties[j]));
				}
			}
			
			// Create an array containing the locations of the creatures.
			// creatureLocationArray = new String[numberOfRows][numberOfColumns];
			int[] creatureX = new int[numberOfCreatures];
			int[] creatureY = new int[numberOfCreatures];
			
			for (int i = 0; i < numberOfCreatures; i++) {
				
				String[] creatureInfo = mapData.getProperty("map.creature" + (i + 1)).split(",");
				
				creatureX[i] = Integer.parseInt(creatureInfo[1]);
				creatureY[i] = Integer.parseInt(creatureInfo[2]);
				Creature creature = findCreature(creatureInfo[0]);
				cells[creatureX[i]][creatureY[i]].setCellCreature(creature);
				
			}
		} catch (Exception e) {
			throw new Exception("Error when reading the file format.");
		}
	}
	
	
	/**
	 * Resets the cells that were visited when the map is reset. <br>
	 *
	 * <b>post: </b> Every cell on the map is set to not visited.
	 */
	public void resetMagicalCreaturesMap() {
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				cells[i][j].setIsVisited(false);
			}
			
		}
	}
	
	/**
	 * Returns the creature next to the current one. <br>
	 * <b>post: </b> The current creature has been changed to the next creature.
	 *
	 * @return The nextCreature creature.
	 * @throws Exception If the last creature is the current creature in the encyclopedia.
	 */
	public Creature getNext() throws Exception {
		if (currentCreature == encyclopedia.length - 1) {
			throw new Exception("You are already on the last creature.");
		}
		
		currentCreature++;
		return encyclopedia[currentCreature];
	}
	
	/**
	 * Returns the creature previous to the current one. <br>
	 * <b>post: </b> The current creature has been changed to the previous creature.
	 *
	 * @return The previous creature.
	 * @throws Exception If the first creature is the current creature in the encyclopedia.
	 */
	public Creature getPrevious() throws Exception {
		if (currentCreature == 0) {
			throw new Exception("You are already on the first creature.");
		}
		
		currentCreature--;
		return encyclopedia[currentCreature];
	}
	
	/**
	 * Returns the player's points. This value is always 0.
	 *
	 * @return The player's points.
	 */
	public int getPoints() {
		return playerPoints;
	}
	
	/**
	 * Returns the player's quantity of remaining moves. This value is always 10.
	 *
	 * @return The player's quantity of remaining moves
	 */
	public int getRemainingMoves() {
		return numberOfMoves;
	}
	
	/**
	 * Finds a new creature in the encyclopedia by the name given in the parameter.
	 *
	 * @param pName Name of the creature. pName != null &amp;&amp; pName != "".
	 *
	 * @return Creature with the specified name. If not found return null.
	 */
	public Creature findCreature(String pName) {
		Creature found = null;
		for (int i = 0; i < encyclopedia.length && found == null; i++) {
			if (encyclopedia[i].getName().equals(pName)) {
				found = encyclopedia[i];
			}
		}
		return found;
	}
	
	/**
	 * Initialize the array of creatures from the configuration file.  <br>
	 * <b>post: </b> Encyclopedia of creatures has been initialized.
	 *
	 * @throws Exception If there is an error when initializing the creatures.
	 */
	private void initializeCreatures() throws Exception {
		try {
			int quantityCreatures = Integer.parseInt(data.getProperty("creatures.quantity"));
			
			encyclopedia = new Creature[quantityCreatures];
			for (int i = 0; i < quantityCreatures; i++) {
				String name = data.getProperty("creatures.creature" + (i + 1) + ".name");
				String interests = data.getProperty("creatures.creature" + (i + 1) + "" +
					".interests");
				String fears = data.getProperty("creatures.creature" + (i + 1) + ".fears");
				boolean isBeingOfLight = true;
				int points = Integer.parseInt(data.getProperty("creatures.creature" + (i + 1) +
					"" +
					".points"));
				
				if (data.getProperty("creatures.creature" + (i + 1) + ".isBeingOfLight").equals
					("false")) {
					isBeingOfLight = false;
				}
				String creatureImagePath = data.getProperty("creatures.creature" + (i + 1) + "" +
					".path");
				
				encyclopedia[i] = new Creature(name, interests, fears, isBeingOfLight, points,
					creatureImagePath);
			}
			
			currentCreature = 0;
		} catch (Exception e) {
			throw new Exception("Error when reading the file format.");
		}
	}
	
	/**
	 * Returns the quantity of creatures in the specified row. This quantity is generated at
	 * random.
	 *
	 * @param pRow Row to be consulted.
	 *
	 * @return Quantity of creatures in the specified row.
	 * @throws Exception If the value entered for the row query is out of bounds.
	 */
	public int getQuantityCreaturesRow(int pRow) throws Exception {
		int quantity = 0;
		if (pRow < 0 || pRow >= numberOfRows)
			throw new Exception("Invalid row value");
		for (int j = 0; j < numberOfColumns; j++) {
			if (cells[pRow][j].getCellCreature() != null)
				quantity++;
		}
		return quantity;
	}
	
	/**
	 * Returns the quantity of creatures in the specified column. This quantity is generated at
	 * random.
	 *
	 * @param pColumn Column to be consulted.
	 *
	 * @return Quantity of creatures in the specified column.
	 * @throws Exception If the value entered for the colum query is out of bounds.
	 */
	public int getQuantityCreaturesColumn(int pColumn) throws Exception {
		int quantity = 0;
		if (pColumn < 0 || pColumn >= numberOfColumns)
			throw new Exception("Invalid column value");
		for (int i = 0; i < numberOfRows; i++) {
			if (cells[i][pColumn].getCellCreature() != null)
				quantity++;
		}
		
		return quantity;
	}
	
	/**
	 * Returns the total amount of available points that can be obtained in the specified
	 * quadrant.
	 *
	 * @param pQuadrant Quadrant to be consulted. pQuadrant &gt; 0 &amp;&amp; pQuadrant &lt; 4
	 *
	 * @return Points that can be obtained in a specific quadrant.
	 * @throws Exception If the value of the quadrant entered is out of bounds.
	 */
	public int calculatePointsInQuadrant(int pQuadrant) throws Exception {
		if (pQuadrant < 0 || pQuadrant > 4)
			throw new Exception("Invalid quadrant value");
		int pointsInQuadrant = 0;
		int splitRow = (numberOfRows / 2);
		int splitColumn = (numberOfColumns / 2);
		switch (pQuadrant) {
			case 1:
				pointsInQuadrant = findPointsInQuadrant(0, splitRow, 0, splitColumn);
				break;
			case 2:
				pointsInQuadrant = findPointsInQuadrant(0, splitRow, splitColumn, numberOfColumns);
				break;
			case 3:
				pointsInQuadrant = findPointsInQuadrant(splitRow, numberOfRows, 0, splitColumn);
				break;
			case 4:
				pointsInQuadrant = findPointsInQuadrant(splitRow, numberOfRows, splitColumn,
					numberOfColumns);
				break;
		}
		return pointsInQuadrant;
	}
	
	/**
	 * Adds the amount of points remaining in the quadrant.
	 *
	 * @param pStartRow    The start index for the row search. pStartRow &gt; 0.
	 * @param pEndRow      The end index for the row search. pRow &gt; 0.
	 * @param pStartColumn The start index for the column search. pStartColumn &gt; 0.
	 * @param pEndColumn   The end index for the column search. pColumn &gt; 0.
	 *
	 * @return The total amount of points to be found in the quadrant.
	 */
	public int findPointsInQuadrant(int pStartRow, int pEndRow, int pStartColumn, int pEndColumn) {
		int points = 0;
		for (int i = pStartRow; i < pEndRow; i++) {
			for (int j = pStartColumn; j < pEndColumn; j++) {
				if (cells[i][j].getCellCreature() != null && !cells[i][j].isVisited() &&
					cells[i][j].getCellCreature().isBeingOfLight())
					points += cells[i][j].getCellCreature().getPoints();
			}
		}
		return points;
	}
	
	/**
	 * Returns the creature of light that has not yet been found with the highest points.
	 *
	 * @return Creature with the highest points.
	 * @throws Exception If all the creatures have already been found.
	 */
	public Creature getHighestPointsCreature() throws Exception {
		int highestPoints = 0;
		Creature highestPointsCreature = null;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				// Make sure that a cell contains a creature and that it is a being of light.
				if (!cells[i][j].isVisited() && cells[i][j].getCellCreature() != null &&
					cells[i][j].getCellCreature().getPoints() > highestPoints &&
					cells[i][j].getCellCreature().isBeingOfLight()) {
					highestPointsCreature = cells[i][j].getCellCreature();
					highestPoints = cells[i][j].getCellCreature().getPoints();
				}
			}
			
		}
		
		// If every creature has already been found.
		if (highestPointsCreature == null)
			throw new Exception("There are no more beings of light to be found!");
		return highestPointsCreature;
	}
	
	// ----------------------------------------------------------------
	// Extension methods
	// ----------------------------------------------------------------
	
	/**
	 * Method for extension 1.
	 *
	 * @return Response 1.
	 */
	public String method1() {
		return "Response 1";
	}
	
	/**
	 * Method for extension 2.
	 *
	 * @return Response 2.
	 */
	public String method2() {
		return "Response 2";
	}
	
}
