/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n3_Album
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.world;

import uniandes.cupi2.album.world.Player.Positions;
import uniandes.cupi2.album.world.Card.CardType;


/**
 * Represents a Team in the album.
 */
public class Team {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Quantity of players on the team.
	 */
	public static final int QUANTITY_OF_PLAYERS = 12;
	
	/**
	 * Name of the team card image.
	 */
	public static final String TEAM_CARD_NAME = "team.png";
	
	/**
	 * Name of the team crest card image.
	 */
	public static final String CREST_CARD_NAME = "crest.png";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Country where the team is from.
	 */
	private String country;
	
	/**
	 * Year in which the team represented the country.
	 */
	private int year;
	
	/**
	 * Team card.
	 */
	private Card teamCard;
	
	/**
	 * Team crest card.
	 */
	private Card crestCard;
	
	/**
	 * Array of players on the team.
	 */
	private Player[] players;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Creates a new team. <br>
	 * <b>post: </b> Country and year attributes were initialized with the values given by the
	 * parameters. <br>
	 * List of players was initialized and players were created with the default values. <br>
	 *
	 * @param pCountry Team's country. pCountry != null && pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear > 0.
	 */
	public Team(String pCountry, int pYear) {
		country = pCountry;
		year = pYear;
		players = new Player[QUANTITY_OF_PLAYERS];
		
		for(int i = 0; i < players.length; i++) {
			players[i] = new Player(-(i+1), "Player" + Integer.toString(i+1), Positions.UNKNOWN,
			                        1990, 1.78, 65);
			
		}
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	
	/**
	 * Returns the team's country.
	 *
	 * @return Team's country.
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Returns the year in which the team represented the country.
	 *
	 * @return Year in which the team represented the country.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Returns the team's card.
	 *
	 * @return Team's card.
	 */
	public Card getTeamCard() {
		return teamCard;
	}
	
	/**
	 * Returns team crest card.
	 *
	 * @return Team crest card.
	 */
	public Card getCrestCard() {
		return crestCard;
	}
	
	/**
	 * Returns the array containing the players on the team.
	 *
	 * @return Array containing team players.
	 */
	public Player[] getPlayers() {
		return players;
	}
	
	/**
	 * Returns a player with the shirt number given by the parameter.
	 * <b>pre: </b> The list of teams is initialized. <br>
	 *
	 * @param pShirtNumber Player's shirt number. pShirtNumber > 0.
	 *
	 * @return Player with given shirt number, null if player not found.
	 */
	public Player findPlayer(int pShirtNumber) {
		Player tempPlayer = null;
		boolean isFound = false;
		for(int i = 0; i < players.length && !isFound; i++) {
			if(players[i].getShirtNumber() == pShirtNumber) {
				tempPlayer = players[i];
				isFound = true;
			}
		}
		return tempPlayer;
	}
	
	/**
	 * Pastes the team card. <br>
	 * <b>post: </b> If the card didn't already exist, a card of type TEAM was initialized
	 * with the name of the corresponding image.
	 *
	 * @return True if the card was pasted, false if the card was already pasted.
	 */
	public boolean pasteTeamCard() {
		boolean isPasted = false;
		if(teamCard == null) {
			teamCard = new Card(CardType.TEAM, TEAM_CARD_NAME);
			isPasted = true;
		}
		return isPasted;
	}
	
	/**
	 * Pastes the team crest card. <br>
	 * <b>post: </b> If the card didn't already exist, a card of type CREST was initialized
	 * with
	 * the
	 * name of the corresponding image.
	 *
	 * @return True if the card was pasted, false if the card was already pasted.
	 */
	public boolean pasteCrestCard() {
		boolean isPasted = false;
		if(crestCard == null) {
			crestCard = new Card(CardType.CREST, CREST_CARD_NAME);
			isPasted = true;
		}
		return isPasted;
	}
	
	/**
	 * Pastes the card of the player with the shirt number given by the parameter. <br>
	 * <b>pre: </b> The array containing the players is initialized.
	 * <b>post: </b> If the card didn't already exist, the corresponding player's card was
	 * pasted
	 *
	 * @param pShirtNumber Player's shirt number. pShirtNumber > 0.
	 *
	 * @return True if the card was pasted, false if the card was already pasted.
	 */
	public boolean pastePlayerCard(int pShirtNumber) {
		boolean isPasted = false;
		
		Player tempPlayer = findPlayer(pShirtNumber);
		if(tempPlayer != null && !tempPlayer.hasCard()) {
			tempPlayer.pasteCard();
			isPasted = true;
		}
		return isPasted;
	}
	
	/**
	 * Modifies the information of a player with the shirt number given by the parameter.
	 * If the new shirt number is already owned by another player, the information isn't modified.
	 * <p>
	 * <b>pre: </b> The list of teams is initialized. Specified player exists.
	 * <br>
	 * <b>post: </b> If the shirt number didn't change(same player) and a player existed with the
	 * new shirt number, or if a player with the new shirt number didn't exist and the current
	 * shirt number was different from the new shirt number, the player information was modified.
	 *
	 * @param pShirtNumber    Player's shirt number. pShirtNumber > 0.
	 * @param pNewShirtNumber New shirt number. pNewShirtNumber > 0.
	 * @param pName           New player name. pName != null && pName != "".
	 * @param pPositions      New player position.pPositions belongs to {Positions.GOALKEEPER,
	 *                        Positions.DEFENDER,Positions.WINGER,Positions.STRIKER,
	 *                        Positions.UNKNOWN}.
	 * @param pBirthYear      Player's birth year. pBirthYear > 0.
	 * @param pHeight         New player height. pHeight > 0.
	 * @param pWeight         New player weight. pWeight > 0.
	 *
	 * @return True if player's values were modified, false if contrary.
	 */
	public boolean modifyPlayer(int pShirtNumber, int pNewShirtNumber, String pName, Positions
			pPositions, int pBirthYear, double pHeight, double pWeight) {
		
		// Set to true if a player is modified.
		boolean playerModified = false;
		
		Player playerToModify = findPlayer(pShirtNumber);
		if((findPlayer(pNewShirtNumber) == null && pShirtNumber != pNewShirtNumber) ||
				(findPlayer(pNewShirtNumber) != null && pShirtNumber == pNewShirtNumber)) {
			playerToModify.modifyPlayer(pNewShirtNumber, pName, pPositions, pBirthYear, pHeight,
			                            pWeight);
			playerModified = true;
		}
		
		return playerModified;
	}
	
	/**
	 * Returns the quantity of cards yet to be pasted of a card type given by the parameter.
	 * <br>
	 * <b>pre: </b> The list of players is initialized.
	 *
	 * @param pCardType Card type of the cards to be counted.
	 *                  pCardType belongs to {CardType.CREST, CardType.TEAM, CardType.PLAYER}.
	 *
	 * @return Quantity of cards of given type that haven't been pasted.
	 */
	public int countCardsNotPasted(CardType pCardType) {
		int cardsNotPasted = 0;
		
		if(pCardType == CardType.CREST && crestCard == null)
			cardsNotPasted++;
		else if(pCardType == CardType.TEAM && teamCard == null)
			cardsNotPasted++;
		else if(pCardType == CardType.PLAYER)
			for(Player player : players) {
				if(!player.hasCard())
					cardsNotPasted++;
			}
		return cardsNotPasted;
		
	}
	
	/**
	 * Returns the mode of the players' ages. If there are multiple ages with the most
	 * frequency, return any. <br>
	 * <b>pre: </b> The list of players is initialized.
	 *
	 * @return Most common age among the players of the team.
	 */
	public int getMostCommonAge() {
		int[] frequency = new int[QUANTITY_OF_PLAYERS];
		int[] ages = new int[QUANTITY_OF_PLAYERS];
		int larger = 0;
		int mostCommonAge = 0;
		
		// Create array that holds all the player's ages.
		for(int i = 0; i < players.length; i++) {
			ages[i] = year - players[i].getBirthYear();
		}
		// Store frequency of each value in another array.
		for(int i = 0; i < ages.length; i++) {
			int count = 0; // Reset the count for every iteration.
			for(int j = 0; j < ages.length; j++) {
				if(ages[i] == ages[j])
					count++;
			}
			frequency[i] = count;
			// Finds which ages is most common.
			if(frequency[i] > larger) {
				larger = frequency[i];
				mostCommonAge = ages[i];
				
			}
			
		}
		return mostCommonAge;
	}
	
	
	/**
	 * Return a representation of the team in a string. <br>
	 * The format must be (country) - (year)
	 */
	@Override
	public String toString() {
		return country + " - " + year;
	}
}
	
	
