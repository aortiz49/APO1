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

import uniandes.cupi2.album.world.Player.Position;
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
	
	/**
	 * Maximum quantity of goalkeepers on the team.
	 */
	public static final int MAX_GOALKEEPERS = 1;
	
	/**
	 * Maximum quantity of defenders on the team.
	 */
	public static final int MAX_DEFENDERS = 5;
	
	/**
	 * Maximum quantity of strikers on the team.
	 */
	public static final int MAX_STRIKERS = 4;
	
	/**
	 * Maximum quantity of favorite cards in the team.
	 */
	public static final int MAX_FAVORITES = 2;
	
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
	 * @param pCountry Team's country. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear &gt; 0.
	 */
	public Team(String pCountry, int pYear) {
		country = pCountry;
		year = pYear;
		players = new Player[QUANTITY_OF_PLAYERS];
		
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(-(i + 1), "Player" + Integer.toString(i + 1), Position.UNKNOWN,
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
	 * Returns the array that contains the players on the team.
	 *
	 * @return Array that contains team players.
	 */
	public Player[] getPlayers() {
		return players;
	}
	
	/**
	 * Returns a player with the shirt number given by the parameter.
	 * <b>pre: </b> The list of teams is initialized. <br>
	 *
	 * @param pShirtNumber Player's shirt number. pShirtNumber &gt; 0.
	 *
	 * @return Player with given shirt number, null if player not found.
	 */
	public Player findPlayer(int pShirtNumber) {
		Player tempPlayer = null;
		boolean isFound = false;
		for (int i = 0; i < players.length && !isFound; i++) {
			if (players[i].getShirtNumber() == pShirtNumber) {
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
	 * @throws Exception If the card has already been pasted.
	 */
	public void pasteTeamCard() throws Exception {
		if (teamCard == null)
			teamCard = new Card(CardType.TEAM, TEAM_CARD_NAME);
		else
			throw new Exception("This team card has already been pasted");
		
	}
	
	/**
	 * Pastes the team crest card. <br>
	 * <b>post: </b> If the card didn't already exist, a card of type CREST was initialized with
	 * the name of the corresponding image.
	 *
	 * @throws Exception If the card has already been pasted.
	 */
	public void pasteCrestCard() throws Exception {
		if (crestCard == null)
			crestCard = new Card(CardType.CREST, CREST_CARD_NAME);
		else
			throw new Exception("This crest card has already been pasted");
		
	}
	
	/**
	 * Pastes the card of the player with the shirt number given by the parameter. <br>
	 * <b>pre: </b> The array that contains the players is initialized.
	 * <b>post: </b> If the card didn't already exist, the corresponding player's card was
	 * pasted
	 *
	 * @param pShirtNumber Player's shirt number. pShirtNumber &gt; 0.
	 *
	 * @throws Exception If the card has already been pasted.
	 */
	public void pastePlayerCard(int pShirtNumber) throws Exception {
		Player tempPlayer = findPlayer(pShirtNumber);
		try {
			tempPlayer.pasteCard();
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		
	}
	
	/**
	 * Returns the quantity of cards that were marked as favorites.
	 * <br>
	 * <b>pre: </b> The list of players is initialized.
	 *
	 * @return Number of cards that were pasted in the team.
	 */
	private int countFavoriteCards() {
		int favoriteCards = 0;
		if (teamCard != null && teamCard.isFavorite())
			favoriteCards++;
		if (crestCard != null && crestCard.isFavorite())
			favoriteCards++;
		
		for (Player player : players) {
			if (player.hasCard() && player.getCard().isFavorite())
				favoriteCards++;
		}
		
		return favoriteCards;
	}
	
	/**
	 * Changes the status of favorite for a team card. <br>
	 * <b> post: </b> If the card was a favorite, it changes to not being a favorite and vice
	 * versa.  <br>
	 *
	 * @throws Exception If the team already has the maximum allowed amount of favorite cards.
	 *                   If the team doesn't have a card.
	 */
	public void changeFavoriteTeam() throws Exception {
		if (countFavoriteCards() == MAX_FAVORITES &&
			teamCard != null && !teamCard.isFavorite()) {
			throw new Exception("The team has already reached the max limit of favorite cards");
		} else if (teamCard != null)
			teamCard.changeFavorite();
		else
			throw new Exception("There is no team card pasted");
	}
	
	/**
	 * Changes the status of favorite for a crest card. <br>
	 * <b> post: </b> If the card was a favorite, it changes to not being a favorite and vice
	 * versa.  <br>
	 *
	 * @throws Exception If the team already has the maximum allowed amount of favorite cards.
	 *                   If the crest doesn't have a card.
	 */
	public void changeFavoriteCrest() throws Exception {
		if (countFavoriteCards() == MAX_FAVORITES &&
			crestCard != null && !crestCard.isFavorite()) {
			throw new Exception("The team has already already reached the max limit of favorite " +
				                    "cards");
		} else if (crestCard != null)
			crestCard.changeFavorite();
		else
			throw new Exception("There is no crest card pasted");
	}
	
	/**
	 * Changes the status of favorite for a player card with the shirt number given by the
	 * parameter. <br>
	 * <b>pre: </b> The list of players is initialized. Specified player exists.
	 * <b>post: </b> If the card was a favorite, it changes to not being a favorite and vice
	 * versa.  <br>
	 *
	 * @param pShirtNumber Player's shirt number. pShirtNumber &gt; 0.
	 *
	 * @throws Exception If the team already has the maximum allowed amount of favorite cards.
	 */
	public void changeFavoritePlayer(int pShirtNumber) throws Exception {
		if (countFavoriteCards() == MAX_FAVORITES && findPlayer(pShirtNumber).getCard() != null &&
			!findPlayer(pShirtNumber).getCard().isFavorite())
			throw new Exception("The team has already already reached the max limit of favorite " +
				                    "cards");
		else {
			for (Player player : players) {
				if (player.getShirtNumber() == pShirtNumber) {
					player.changeFavorite();
				}
			}
		}
	}
	
	
	/**
	 * Modifies the information of a player with the shirt number given by the parameter.
	 * If the new shirt number is already owned by another player, the information isn't modified.
	 *
	 * <b>pre: </b> The list of players is initialized. Specified player exists.
	 * <br>
	 * <b>post: </b> If the shirt number didn't change(same player) and a player existed with the
	 * new shirt number, or if a player with the new shirt number didn't exist and the current
	 * shirt number was different from the new shirt number, the player information was modified.
	 *
	 * @param pShirtNumber    Player's shirt number. pShirtNumber &gt; 0.
	 * @param pNewShirtNumber New shirt number. pNewShirtNumber &gt; 0.
	 * @param pName           New player name. pName != null &amp;&amp;  pName != "".
	 * @param pPosition       New player position.pPosition belongs to {Position.GOALKEEPER,
	 *                        Position.DEFENDER,Position.WINGER,Position.STRIKER,
	 *                        Position.UNKNOWN}.
	 * @param pBirthYear      Player's birth year. pBirthYear &gt; 0.
	 * @param pHeight         New player height. pHeight &gt; 0.
	 * @param pWeight         New player weight. pWeight &gt; 0.
	 *
	 * @throws Exception If the the maximum quantity of goalkeepers on the team has been reached.
	 *                   If the the maximum quantity of defenders on the team has been reached.
	 *                   If the the maximum quantity of strikers on the team has been reached.
	 *                   If there is an attempt to modify a player's shirt number, but the new
	 *                   shirt number already belongs to another player.
	 *                   If there is an attempt to modify a player that already has a card pasted.
	 */
	public void modifyPlayer(int pShirtNumber, int pNewShirtNumber, String pName,
	                         Position pPosition, int pBirthYear, double pHeight, double pWeight)
		throws Exception {
		int numGoalkeepers = countPlayersPosition(Position.GOALKEEPER);
		int numDefenders = countPlayersPosition(Position.DEFENDER);
		int numStrikers = countPlayersPosition(Position.STRIKER);
		
		Player playerToBeModified = findPlayer(pShirtNumber);
		
		// If the old shirt number is different from the new shirt number and if a player with
		// the new shirt number already exists, throw an exception.
		if (pShirtNumber != pNewShirtNumber && findPlayer(pNewShirtNumber) != null)
			throw new Exception("Error when modifying player " + playerToBeModified.getName() +
				                    ": The new shirt number is assigned to another player.");
		
		if (playerToBeModified.getPosition()!= Position.GOALKEEPER &&
			pPosition == Position.GOALKEEPER && numGoalkeepers == MAX_GOALKEEPERS)
			throw new Exception("Error when modifying player " + playerToBeModified.getName() +
				                    ": The maximum amount of goalkeepers on the team has been" +
				                    "reached.");
		else if (playerToBeModified.getPosition()!= Position.DEFENDER &&
			pPosition == Position.DEFENDER && numDefenders == MAX_DEFENDERS)
			throw new Exception("Error when modifying player " + playerToBeModified.getName() +
				                    ": The maximum amount of defenders on the team has been" +
				                    "reached.");
		else if (playerToBeModified.getPosition()!= Position.STRIKER &&
			pPosition == Position.STRIKER &&	numStrikers == MAX_STRIKERS)
			throw new Exception("Error when modifying player " + playerToBeModified.getName() +
				                    ": The maximum amount of strikers on the team has been" +
				                    "reached.");
			
			// If the new and old shirt numbers are the same, and a player with the new shirt
			// doesn't exist.
			// If the new and old shirt numbers are the same, and a player with the new shirt
			// number does exist.
			// If the new and old shirt numbers are different, and a player with the new shirt
			// number doesn't exist.
		else playerToBeModified.modifyPlayer(pNewShirtNumber, pName, pPosition, pBirthYear,
		                                     pHeight,
		                                     pWeight);
		
		
		
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
		
		if (pCardType == CardType.CREST && crestCard == null)
			cardsNotPasted++;
		else if (pCardType == CardType.TEAM && teamCard == null)
			cardsNotPasted++;
		else if (pCardType == CardType.PLAYER)
			for (Player player : players) {
				if (!player.hasCard())
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
		
		// Store frequency of each value in another array.
		for (int i = 0; i < players.length; i++) {
			// Create array that holds all the player's ages.
			ages[i] = year - players[i].getBirthYear();
			int count = 0; // Reset the count for every iteration.
			for (int j = 0; j < ages.length; j++) {
				if (ages[i] == ages[j])
					count++;
			}
			frequency[i] = count;
			// Finds which ages is most common.
			if (frequency[i] > larger) {
				larger = frequency[i];
				mostCommonAge = ages[i];
				
			}
			
		}
		return mostCommonAge;
	}
	
	/**
	 * Returns the number of players on the team that play in a position given by the parameter.
	 * <br>
	 * <b>pre: </b> The list of players is initialized.
	 *
	 * @param pPosition New player position.pPosition belongs to {Position.GOALKEEPER,
	 *                  Position.DEFENDER,Position.WINGER,Position.STRIKER,
	 *                  Position.UNKNOWN}..
	 *
	 * @return The number of players in a position.
	 */
	private int countPlayersPosition(Position pPosition) {
		int numPlayers = 0;
		for (Player player : players) {
			if (player.getPosition() == pPosition)
				numPlayers++;
		}
		return numPlayers;
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


