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

/**
 * Creature that can inhabit a territory.
 */
public class Creature {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Creature's name.
	 */
	private String name;
	
	/**
	 * Creature's interests.
	 */
	private String interests;
	
	/**
	 * Creature's fears.
	 */
	private String fears;
	
	/**
	 * Indicates if a creature is a being of light.
	 */
	private boolean beingOfLight;
	
	/**
	 * Points the player obtains when finding a creature.
	 */
	private int points;
	
	/**
	 * Image path of the creature.
	 */
	private String creatureImagePath;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Creates a creature with the characteristics specified by the parameters. <br>
	 * <b>post: </b> The attributes were initialized with the values given by the parameter.
	 *
	 * @param pName              Name of the creature. pName != null &amp;&amp; pName != "".
	 * @param pInterests         Interests of the creature. pInterests != null &amp;&amp;
	 *                           pInterests != "".
	 * @param pFears             Fears of the creature. pFears != null &amp;&amp; pFears != "".
	 * @param pBeingOfLight      True if the creature is a being of light, false if contrary.
	 * @param pPoints            Points the player obtains when finding a creature. pPoints &gt; 0.
	 * @param pCreatureImagePath Image path of the creature.
	 *                           pCreatureImagePath != null &amp;&amp; pCreatureImagePath != "".
	 */
	public Creature(String pName, String pInterests, String pFears, boolean pBeingOfLight, int
		pPoints, String pCreatureImagePath) {
		name = pName;
		interests = pInterests;
		fears = pFears;
		beingOfLight = pBeingOfLight;
		points = pPoints;
		creatureImagePath = pCreatureImagePath;
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns the name of the creature.
	 *
	 * @return Name of the creature.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the interests of the creature.
	 *
	 * @return Interests of the creature.
	 */
	public String getInterests() {
		return interests;
	}
	
	/**
	 * Returns the fears of the creature.
	 *
	 * @return The  fears of the creature.
	 */
	public String getFears() {
		return fears;
	}
	
	/**
	 * Indicates if the creature is a being of light.
	 *
	 * @return True if the creature is a being of light, false if contrary.
	 */
	public boolean isBeingOfLight() {
		return beingOfLight;
	}
	
	/**
	 * Returns the quantity of points the player receives when finding a creature.
	 *
	 * @return Quantity of points received by the player when finding a creature.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Returns the path of the creature image.
	 *
	 * @return Creature image path.
	 */
	public String getCreatureImagePath() {
		return creatureImagePath;
	}
}
