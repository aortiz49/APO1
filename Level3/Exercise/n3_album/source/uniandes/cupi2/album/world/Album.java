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

import java.util.ArrayList;

import uniandes.cupi2.album.world.Player.Positions;
import uniandes.cupi2.album.world.Card.CardType;

/**
 * Represents the album of football teams.
 */
public class Album {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Vector with the teams in the album.
	 */
	private ArrayList<Team> teams;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs a new album. <br>
	 * <b>post: </b> Initialized array with teams. <br>
	 */
	public Album() {
		teams = new ArrayList<>();
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns the teams in the album. <br>
	 *
	 * @return Teams in the album.
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	/**
	 * Returns a list of all the teams in a given year given by the parameter. <br>
	 * <b>pre: </b> The list of teams is initialized. <br>
	 *
	 * @param pYear: Year to search. pYear > 0.
	 *
	 * @return List of teams that participated in the searched year.
	 */
	public ArrayList<Team> findTeamsByYear(int pYear) {
		ArrayList<Team> teamsFound = new ArrayList<>();
		for(int i = 0; i < teams.size(); i++) {
			if(teams.get(i).getYear() == pYear)
				teamsFound.add(teams.get(i));
		}
		return teamsFound;
	}
	
	/**
	 * Returns the index of the list for a team given by country and year parameters. <br>
	 * <b>pre: </b>The list of teams is initialized. <br>
	 *
	 * @param pCountry Country of the team being searched. pCountry != null && pCountry != "".
	 * @param pYear    Year in which the searched team represented the country. pYear > 0.
	 *
	 * @return Index where the searched team is located. -1 if team is not found.
	 */
	public int findTeam(String pCountry, int pYear) {
		int indexOfTeam = -1;
		for(int i = 0; i < teams.size(); i++) {
			if(teams.get(i).getCountry().equals(pCountry) && teams.get(i).getYear() == pYear)
				indexOfTeam = i;
		}
		return indexOfTeam;
		
	}
	
	/**
	 * Returns the player given by shirt number, country, and year parameters. <br>
	 *
	 * @param pShirtNumber Shirt number of the player. pShirtNumber > 0.
	 * @param pCountry     Country of the player searched. pCountry != null && pCountry != "".
	 * @param pYear        Year in which the searched team represented the country. pYear > 0.
	 *
	 * @return Player with the given characteristics. Null if player not found.
	 */
	public Player findPlayer(int pShirtNumber, String pCountry, int pYear) {
		Player playerFound = null;
		boolean isFound = false;
		for(int i = 0; i < teams.size() && !isFound; i++) {
			
			String countryFound = teams.get(i).getCountry();
			int yearFound = teams.get(i).getYear();
			for(int j = 0; j < Team.QUANTITY_OF_PLAYERS && !isFound; j++) {
				int shirtNumberFound = teams.get(i).getPlayers()[j].getShirtNumber();
				if(shirtNumberFound == pShirtNumber && countryFound.equals(pCountry) &&
						yearFound == pYear) {
					playerFound = teams.get(i).getPlayers()[j];
					isFound = true;
				}
				
			}
			
		}
		return playerFound;
	}
	
	/**
	 * Adds a team to the album given by country and year parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. <br>
	 * <b>post: </b> If a team with the information given by the parameter didn't exist, a new
	 * team is added to the list. <br>
	 *
	 * @param pCountry Country of the player searched. pCountry != null && pCountry != "".
	 * @param pYear    Year in which the searched team represented the country. pYear > 0.
	 *
	 * @return True if the team was added, false if the team and country already existed.
	 */
	public boolean addTeam(String pCountry, int pYear) {
		boolean teamAdded = false;
		Team newTeam = new Team(pCountry, pYear);
		if(!teams.contains(newTeam)) {
			teams.add(newTeam);
			teamAdded = true;
		}
		
		return teamAdded;
		
	}
	
	/**
	 * Modifies the information of a player given by shirt number, country, and year
	 * parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team and player exist.
	 * <br>
	 * <b>post: </b> If the shirt number didn't change or a player with the new shirt number
	 * didn't exist, the player information was modified.
	 *
	 * @param pCountry        Country of the player searched. pCountry != null && pCountry !=
	 *                        "".
	 * @param pYear           Year in which the searched team represented the country. pYear
	 *                        > 0.
	 * @param pShirtNumber    Player's shirt number. pShirtNumber > 0.
	 * @param pNewShirtNumber New shirt number. pNewShirtNumber > 0.
	 * @param pName           New player name. pName != null && pName != "".
	 * @param pPosition       New player position.pPositions belongs to {Positions.GOALKEEPER,
	 *                        Positions.DEFENDER,Positions.WINGER,Positions.STRIKER,
	 *                        Positions.UNKNOWN}.
	 * @param pBirthYear      Player's birth year. pBirthYear > 0.
	 * @param pHeight         New player height. pHeight > 0.
	 * @param pWeight         New player weight. pWeight > 0.
	 *
	 * @return True if player's values were modified, false if contrary.
	 */
	public boolean modifyPlayer(String pCountry, int pYear, int pShirtNumber, int
			pNewShirtNumber, String pName, Positions pPosition, int pBirthYear, double
			                            pHeight, double pWeight) {

		return teams.get(findTeam(pCountry, pYear)).modifyPlayer(pShirtNumber, pNewShirtNumber, pName,
		                                                         pPosition, pBirthYear, pHeight,
		                                                         pWeight);
	}
	
	
	/**
	 * Pastes team card of the team given by the country and year parameters into the Album. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 * <b>post: </b> The team card was pasted.
	 *
	 * @param pCountry Team's country. pCountry != null && pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear > 0.
	 *
	 * @return True if the card was pasted to the album, false if the card was already pasted.
	 */
	public boolean pasteTeamCard(String pCountry, int pYear) {

		return teams.get(findTeam(pCountry, pYear)).pasteTeamCard();
	}
	
	/**
	 * Pastes team's crest card of the team given by the country and year parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 * <b>post: </b> The team's crest card was pasted.
	 *
	 * @param pCountry Team's country. pCountry != null && pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear > 0.
	 *
	 * @return True if the card was pasted to the album, false if the card was already pasted.
	 */
	public boolean pasteCrestCard(String pCountry, int pYear) {
		
		return teams.get(findTeam(pCountry, pYear)).pasteCrestCard();
	}
	
	/**
	 * Pastes the card of a player. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 * <b>post: </b> The player card was pasted.
	 *
	 * @param pShirtNumber Player's shirt number. pShirtNumber > 0.
	 * @param pCountry     Team's country. pCountry != null && pCountry != "".
	 * @param pYear        Year in which the team represented the country. pYear > 0.
	 *
	 * @return True if the card was pasted to the album, false if the card was already pasted.
	 */
	public boolean pastePlayerCard(int pShirtNumber, String pCountry, int pYear) {
		
		return findPlayer(pShirtNumber, pCountry, pYear).pasteCard();
	}
	
	/**
	 * Returns the mode of the players' ages given by country and year parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 *
	 * @param pCountry Team's country. pCountry != null && pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear > 0.
	 *
	 * @return Most common age among the players of the searched team.
	 */
	public int getMostCommonAge(String pCountry, int pYear) {
		return teams.get(findTeam(pCountry, pYear)).getMostCommonAge();
	}
	
	/**
	 * Returns the percentage of cards pasted in the album given by the card type parameter
	 * with respect to the total cards of that card type. <br>
	 * <b>pre: </b> The list of teams is initialized. <br>
	 *
	 * @param pCardType Card type of the card. pCardType belongs to {CardType.CREST, CardType
	 *                  .TEAM, CardType.PLAYER}.
	 *
	 * @return Percentage of completeness of the cards belonging to the card type received by
	 * the parameter.
	 */
	public double getPercentageCompletenessCardType(CardType pCardType) {
		double percentage = 0;
		double totalCards = 0;
		double cardsNotPasted = 0;
		for(int i = 0; i < teams.size(); i++) {
			cardsNotPasted += teams.get(i).countCardsNotPasted(pCardType);
		}
		if(pCardType == CardType.TEAM || pCardType == CardType.CREST)
			totalCards = teams.size();
		else
			totalCards = teams.size() * Team.QUANTITY_OF_PLAYERS;
		
		percentage = (int)(100 - (cardsNotPasted / totalCards) * 100) * 100 / 100.0;
		return percentage;
	}
	
	
	// -----------------------------------------------------------------
	// Extension Points
	// -----------------------------------------------------------------
	
	/**
	 * Extension 1.
	 *
	 * @return response1.
	 */
	public String metodo1() {
		return "Response 1";
	}
	
	/**
	 * Extension 2.
	 *
	 * @return response2.
	 */
	public String metodo2() {
		return "Response 2";
	}
	
}
