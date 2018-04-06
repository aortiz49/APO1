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

package uniandes.cupi2.album.world;

import uniandes.cupi2.album.world.Card.CardType;


/**
 * Represents a card in the album.
 */
public class Player {
	
	// -----------------------------------------------------------------
	// Enums
	// -----------------------------------------------------------------
	
	/**
	 * Position types.
	 */
	public enum Position {
		GOALKEEPER,
		WINGER,
		DEFENDER,
		STRIKER,
		UNKNOWN
	}
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Player's card.
	 */
	private Card card;
	
	/**
	 * Player's shirt number.
	 */
	private int shirtNumber;
	
	/**
	 * Player's name.
	 */
	private String name;
	
	/**
	 * Player's position.
	 */
	private Position position;
	
	/**
	 * Player's birth year.
	 */
	private int birthYear;
	
	/**
	 * Player's height.
	 */
	private double height;
	
	/**
	 * Player's weight.
	 */
	private double weight;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs a new player.<br>
	 * <b> post: </b> Player's shirt number, name, position, birth year, height, and weight
	 * were initialized with the values given by the parameters.  <br>
	 *
	 * @param pShirtNumber Shirt number of the player. pShirtNumber > 0.
	 * @param pName        Player's name. pName != null && pName !="".
	 * @param pPosition    New player position.pPosition belongs to {Position.GOALKEEPER,
	 *                     Position.DEFENDER,Position.WINGER,Position.STRIKER,
	 *                     Position.UNKNOWN}..
	 * @param pBirthYear   Player's birth year. pBirthYear > 0.
	 * @param pHeight      New player height. pHeight > 0.
	 * @param pWeight      New player weight. pWeight > 0.
	 */
	public Player(int pShirtNumber, String pName, Position pPosition, int pBirthYear,
	              double pHeight, double pWeight) {
		shirtNumber = pShirtNumber;
		name = pName;
		position = pPosition;
		birthYear = pBirthYear;
		height = pHeight;
		weight = pWeight;
	}
	
	/**
	 * Returns the player's shirt number.
	 *
	 * @return Player's shirt number.
	 */
	public int getShirtNumber() {
		return shirtNumber;
	}
	
	/**
	 * Returns the name of the player.
	 *
	 * @return Player's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the player's position.
	 *
	 * @return Player's position.
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * Returns the player's birth year.
	 *
	 * @return Player's birth year.
	 */
	public int getBirthYear() {
		return birthYear;
	}
	
	/**
	 * Returns the player's height.
	 *
	 * @return Player's height.
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Returns the player's weight.
	 *
	 * @return Player's weight.
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Returns the player's height.
	 *
	 * @return Player's height.
	 */
	public Card getCard() {
		return card;
	}
	
	/**
	 * Modifies an existing player.<br>
	 * <b> post: </b> If he doesn't already have a card, the player's shirt number, name, position,
	 * birth year, height, and weight were modified with the values given by the parameters.  <br>
	 *
	 * @param pShirtNumber Shirt number of the player. pShirtNumber > 0.
	 * @param pName        Player's name. pName != null && pName !="".
	 * @param pPosition    New player position.pPosition belongs to {Position.GOALKEEPER,
	 *                     Position.DEFENDER,Position.WINGER,Position.STRIKER,
	 *                     Position.UNKNOWN}..
	 * @param pBirthYear   Player's birth year. pBirthYear > 0.
	 * @param pHeight      New player height. pHeight > 0.
	 * @param pWeight      New player weight. pWeight > 0.
	 *
	 * @throws Exception If the player already has a card.
	 */
	public void modifyPlayer(int pShirtNumber, String pName, Position pPosition, int pBirthYear,
	                         double pHeight, double pWeight) throws Exception {
		if (!hasCard()) {
			shirtNumber = pShirtNumber;
			name = pName;
			position = pPosition;
			birthYear = pBirthYear;
			height = pHeight;
			weight = pWeight;
		}
		
		else
			throw new Exception("Error when modifying player " + name + ":" + " Cannot modify a " +
					                    "player that already has a card.");
		
	}
	
	/**
	 * Pastes the player's card. <br>
	 * <b>post: </b> If the card didn't already exist, a card of type PLAYER was initialized with
	 * the name of the corresponding image.
	 *
	 * @throws Exception if the card was already pasted.
	 */
	public void pasteCard() throws Exception {
		String imageName = shirtNumber + ".png";
		if (!hasCard())
			card = new Card(CardType.PLAYER, imageName);
		else
			throw new Exception("Card has already been pasted.");
		
	}
	
	/**
	 * Checks to see if the player has an existing card. <br>
	 *
	 * @return True if the card exists, false if the card doesn't exist.
	 */
	public boolean hasCard() {
		boolean hasPlayerCard = false;
		if (card != null)
			hasPlayerCard = true;
		
		return hasPlayerCard;
	}
	
	/**
	 * Changes the status of favorite for a player card. <br>
	 * <b> post: </b> If the card was a favorite, it changes to not being a favorite and vice
	 * versa.  <br>
	 * @throws Exception if there is no player card pasted.
	 */
	public void changeFavorite() throws Exception {
		if (hasCard())
			card.changeFavorite();
		else
			throw new Exception("There is no player card pasted.");
		
	}
	
}
