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
	 * The latest data loaded by the game.
	 */
	private Properties data;
	
	/**
	 * Current creature on display.
	 */
	private int currentCreature;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Creates the magical creatures and loads the encyclopedia. <br>
	 * <b>post: </b> Array of creatures is initialized with the information from the encyclopedia.
	 *
	 * @param pImagePathCreatures Image path of the creatures' pictures.
	 *                            pImagePathCreatures != null &amp;&amp; pImagePathCreatures != "".
	 *
	 * @throws Exception If there was an error when loading the file.
	 *                   If there was an error when reading the format of the file.
	 */
	public MagicalCreatures(String pImagePathCreatures) throws Exception {
		try {
			load(pImagePathCreatures);
			initializeCreatures();
		} catch (Exception e) {
			throw e;
		}
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns la creature actual of the encyclopedia.
	 *
	 * @return La creature actual of the encyclopedia.
	 */
	public Creature getCurrentCreature() {
		return encyclopedia[currentCreature];
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
		return 0;
	}
	
	/**
	 * Returns the player's quantity of remaining moves. This value is always 10.
	 *
	 * @return The player's quantity of remaining moves
	 */
	public int getRemainingMoves() {
		return 10;
	}
	
	/**
	 * Finds a new creature in the encyclopedia by the name given in the parameter.
	 *
	 * @param pName Name of the creature. pName != null &amp;&amp; pName != "".
	 *
	 * @return Creature with the specified name. If not found return null.
	 */
	public Creature findCreature(String pName) {
		Creature buscada = null;
		for (int i = 0; i < encyclopedia.length && buscada == null; i++) {
			if (encyclopedia[i].getName().equals(pName)) {
				buscada = encyclopedia[i];
			}
		}
		
		return buscada;
	}
	
	/**
	 * Loads the file given by the parameter to process it.
	 *
	 * @param pImagePath File path of specified file. . pImagePath != null &amp;&amp; pImagePath != "".
	 *
	 * @throws Exception If there is a problem when loading the file.
	 */
	private void load(String pImagePath) throws Exception {
		data = new Properties();
		FileInputStream in = new FileInputStream(pImagePath);
		try {
			data.load(in);
			in.close();
			
		} catch (IOException e) {
			throw new Exception("Error when loading the file, file not valid.");
		}
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
	 */
	public int getQuantityCreaturesRow(int pRow) {
		double randomValue = Math.random();
		int quantity = (int)(5 * randomValue);
		
		return quantity;
	}
	
	/**
	 * Returns the quantity of creatures in the specified column. This quantity is generated at
	 * random.
	 *
	 * @param pColumn Column to be consulted.
	 *
	 * @return Quantity of creatures in the specified column.
	 */
	public int getQuantityCreaturesColumn(int pColumn) {
		double randomValue = Math.random();
		int quantity = (int)(5 * randomValue);
		
		return quantity;
	}
	
	/**
	 * Returns the total amount of points that can be obtained if every creature in the specified
	 * quadrant is found. This quantity is generated at random.
	 *
	 * @param pQuadrant Quadrant to be consulted. pQuadrant &gt; 0 &amp;&amp; pQuadrant &lt; 4
	 *
	 * @return Points that can be obtained in a specific quadrant.
	 */
	public int calculatePointsInQuadrant(int pQuadrant) {
		double randomValue = Math.random();
		
		return (int)(2000 * randomValue);
		
	}
	
	/**
	 * Returns the creature of light that has not yet been found with the highest points. Always
	 * returns dragon.
	 *
	 * @return Creature with the highest points.
	 */
	public Creature getHighestPointsCreature() {
		return findCreature("Dragon");
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
