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

import java.util.ArrayList;

import uniandes.cupi2.album.world.Player.Position;
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
	
	/**
	 * Vector with the exceptions in the album.
	 */
	private ArrayList<String> reports;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs a new album. <br>
	 * <b>post: </b> Initialized vector with empty teams. <br>
	 * Initialized vector with empty reports.
	 */
	public Album() {
		teams = new ArrayList<>();
		reports = new ArrayList<>();
		
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
	 * Returns the reports in the album. <br>
	 *
	 * @return Reports in the album.
	 */
	public ArrayList<String> getReports() {
		return reports;
	}
	
	/**
	 * Returns a list of all the teams in a given year given by the parameter. <br>
	 * <b>pre: </b> The list of teams is initialized. <br>
	 *
	 * @param pYear: Year to search. pYear &gt; 0.
	 *
	 * @return List of teams that participated in the searched year.
	 */
	public ArrayList<Team> findTeamsByYear(int pYear) {
		ArrayList<Team> teamsFound = new ArrayList<>();
		for (Team team : teams) {
			if (team.getYear() == pYear)
				teamsFound.add(team);
		}
		return teamsFound;
	}
	
	/**
	 * Returns the index of the list for a team given by country and year parameters. <br>
	 * <b>pre: </b>The list of teams is initialized. <br>
	 *
	 * @param pCountry Country of the team being searched. pCountry != null &amp;&amp;  pCountry
	 *                 != "".
	 * @param pYear    Year in which the searched team represented the country. pYear &gt; 0.
	 *
	 * @return Index where the searched team is located. -1 if team is not found.
	 */
	public int findTeam(String pCountry, int pYear) {
		int indexOfTeam = -1;
		boolean isFound = false;
		for (int i = 0; i < teams.size() && !isFound; i++) {
			if (teams.get(i).getCountry().equals(pCountry) && teams.get(i).getYear() == pYear) {
				isFound = true;
				indexOfTeam = i;
			}
		}
		return indexOfTeam;
		
	}
	
	/**
	 * Returns the player given by shirt number, country, and year parameters. <br>
	 *
	 * @param pShirtNumber Shirt number of the player. pShirtNumber &gt; 0.
	 * @param pCountry     Country of the player searched. pCountry != null &amp;&amp;  pCountry
	 *                     != "".
	 * @param pYear        Year in which the searched team represented the country. pYear &gt; 0.
	 *
	 * @return Player with the given characteristics. Null if player not found.
	 */
	public Player findPlayer(int pShirtNumber, String pCountry, int pYear) {
		Player playerFound = null;
		if (findTeam(pCountry, pYear) != -1)
			playerFound = teams.get(findTeam(pCountry, pYear)).findPlayer(pShirtNumber);
		
		return playerFound;
		
	}
	
	/**
	 * Adds a team to the album given by country and year parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. <br>
	 * <b>post: </b> If a team with the information given by the parameter didn't exist, a new
	 * team is added to the list. <br>
	 *
	 * @param pCountry Country of the player searched. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear    Year in which the searched team represented the country. pYear &gt; 0.
	 *
	 * @return True if the team was added, false if the team and country already existed.
	 */
	public boolean addTeam(String pCountry, int pYear) {
		boolean teamAdded = false;
		Team newTeam = new Team(pCountry, pYear);
		
		if (findTeam(pCountry, pYear) == -1) {
			teams.add(newTeam);
			teamAdded = true;
		}
		return teamAdded;
	}
	
	/**
	 * Pastes team card of the team given by the country and year parameters into the Album. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 * <b>post: </b> The team card was pasted.
	 *
	 * @param pCountry Team's country. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear &gt; 0.
	 *
	 * @throws Exception If the card has already been pasted.
	 */
	public void pasteTeamCard(String pCountry, int pYear) throws Exception {
		try {
			teams.get(findTeam(pCountry, pYear)).pasteTeamCard();
		} catch (Exception e) {
			reports.add(e.getMessage());
			throw new Exception(e.getMessage(), e);
			
		}
	}
	
	/**
	 * Pastes crest card of the team given by the country and year parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 * <b>post: </b> The team's crest card was pasted.
	 *
	 * @param pCountry Team's country. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear &gt; 0.
	 *
	 * @throws Exception If the card has already been pasted.
	 */
	public void pasteCrestCard(String pCountry, int pYear) throws Exception {
		try {
			teams.get(findTeam(pCountry, pYear)).pasteCrestCard();
		} catch (Exception e) {
			reports.add(e.getMessage());
			throw new Exception(e.getMessage());
			
		}
	}
	
	/**
	 * Pastes the card of a player given by the parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 * <b>post: </b> The player card was pasted.
	 *
	 * @param pShirtNumber Player's shirt number. pShirtNumber &gt; 0.
	 * @param pCountry     Team's country. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear        Year in which the team represented the country. pYear &gt; 0.
	 *
	 * @throws Exception If the card has already been pasted.
	 */
	public void pastePlayerCard(int pShirtNumber, String pCountry, int pYear) throws Exception {
		try {
			teams.get(findTeam(pCountry, pYear)).pastePlayerCard(pShirtNumber);
		} catch (Exception e) {
			reports.add(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * * Changes the status of favorite for a team card. <br>
	 * <b> post: </b> If the card was a favorite, it changes to not being a favorite and vice
	 * versa.  <br>
	 *
	 * @param pCountry Country of the team being searched. pCountry != null &amp;&amp;  pCountry
	 *                 != "".
	 * @param pYear    Year in which the searched team represented the country. pYear &gt; 0.
	 *
	 * @throws Exception If the team already has the maximum allowed amount of favorite cards.
	 *                   If the team doesn't have a card.
	 */
	public void changeFavoriteTeam(String pCountry, int pYear) throws Exception {
		try {
			teams.get(findTeam(pCountry, pYear)).changeFavoriteTeam();
		} catch (Exception e) {
			reports.add(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * * Changes the status of favorite for a crest card. <br>
	 * <b> post: </b> If the card was a favorite, it changes to not being a favorite and vice
	 * versa.  <br>
	 *
	 * @param pCountry Country of the team being searched. pCountry != null &amp;&amp;  pCountry
	 *                 != "".
	 * @param pYear    Year in which the searched team represented the country. pYear &gt; 0.
	 *
	 * @throws Exception If the team already has the maximum allowed amount of favorite cards.
	 *                   If the crest doesn't have a card.
	 */
	public void changeFavoriteCrest(String pCountry, int pYear) throws Exception {
		try {
			teams.get(findTeam(pCountry, pYear)).changeFavoriteCrest();
		} catch (Exception e) {
			reports.add(e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * * Changes the status of favorite for a player card. <br>
	 * <b> post: </b> If the card was a favorite, it changes to not being a favorite and vice
	 * versa.  <br>
	 *
	 * @param pCountry     Country of the team being searched. pCountry != null &amp;&amp;
	 *                     pCountry != "".
	 * @param pYear        Year in which the searched team represented the country. pYear &gt; 0.
	 * @param pShirtNumber Player's shirt number. pShirtNumber &gt; 0.
	 *
	 * @throws Exception If the team already has the maximum allowed amount of favorite cards.
	 *                   If the player doesn't have a card.
	 */
	public void changeFavoritePlayer(String pCountry, int pYear, int pShirtNumber) throws
		Exception {
		try {
			teams.get(findTeam(pCountry, pYear)).changeFavoritePlayer(pShirtNumber);
		} catch (Exception e) {
			reports.add(e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}
	
	/**
	 * Modifies the information of a player given by shirt number, country, and year
	 * parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team and player exist.
	 * <br>
	 * <b>post: </b> If the shirt number didn't change or a player with the new shirt number
	 * didn't exist, the player information was modified.
	 *
	 * @param pCountry        Country of the player searched. pCountry != null &amp;&amp;
	 *                        pCountry != "".
	 * @param pYear           Year in which the searched team represented the country.
	 *                        pYear &gt; 0.
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
	public void modifyPlayer(String pCountry, int pYear, int pShirtNumber, int
		pNewShirtNumber, String pName, Position pPosition, int pBirthYear, double
		                         pHeight, double pWeight) throws Exception {
		try {
			teams.get(findTeam(pCountry, pYear)).modifyPlayer(pShirtNumber, pNewShirtNumber,
			                                                  pName, pPosition, pBirthYear,
			                                                  pHeight,
			                                                  pWeight);
		} catch (Exception e) {
			reports.add(e.getMessage());
			throw new Exception(e.getMessage(), e);
		}
		
	}
	
	
	/**
	 * Returns the mode of the players' ages given by country and year parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 *
	 * @param pCountry Team's country. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear &gt; 0.
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
	 * @param pCardType Card type of the card. pCardType belongs to {CardType.CREST,
	 *                  CardType.TEAM, CardType.PLAYER}.
	 *
	 * @return Percentage of completeness of the cards belonging to the card type received by
	 * the parameter.
	 */
	public double getPercentageCompletenessCardType(CardType pCardType) {
		double percentage = 0;
		double totalCards = 0;
		double cardsNotPasted = 0;
		for (int i = 0; i < teams.size(); i++) {
			cardsNotPasted += teams.get(i).countCardsNotPasted(pCardType);
		}
		if (pCardType == CardType.TEAM || pCardType == CardType.CREST)
			totalCards = teams.size();
		else
			totalCards = teams.size() * Team.QUANTITY_OF_PLAYERS;
		
		percentage = (int)((100 - (cardsNotPasted / totalCards) * 100) * 100) / 100.0;
		
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
	public String method1() {
		return "Response 1";
	}
	
	/**
	 * Extension 2.
	 *
	 * @return response2.
	 */
	public String method2() {
		return "Response 2";
	}
	
}
