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

package uniandes.cupi2.album.userInterface;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import uniandes.cupi2.album.world.Album;
import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Position;
import uniandes.cupi2.album.world.Card.CardType;

/**
 * Principal window of the application.
 */
public class AlbumInterface extends JFrame {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Association to the main class of the album.
	 */
	private Album world;
	
	/**
	 * Index of the team that is currently being shown.
	 */
	private int currentIndex;
	
	// -----------------------------------------------------------------
	// User interface attributes
	// -----------------------------------------------------------------
	
	/**
	 * Contains information about the current team.
	 */
	private TeamPanel teamPanel;
	
	/**
	 * Contains the options fot he application.
	 */
	private OptionsPanel optionsPanel;
	
	/**
	 * Contains the navigation panel on the left.
	 */
	private LateralPanel leftLateralPanel;
	
	/**
	 * Contains the navigation panel on the right.
	 */
	private LateralPanel rightLateralPanel;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the principal window of the application.  <br>
	 * <b>post:</b> All components of the user interface were initialized.
	 */
	public AlbumInterface() {
		world = new Album();
		loadTeams();
		
		setTitle("Album");
		setSize(1020, 790);
		BackgroundPanel backgroundPanel = new BackgroundPanel();
		backgroundPanel.setLayout(new BorderLayout(10, 10));
		add(backgroundPanel);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		currentIndex = 0;
		teamPanel = new TeamPanel(this, world.getTeams().get(currentIndex));
		backgroundPanel.add(teamPanel, BorderLayout.CENTER);
		
		optionsPanel = new OptionsPanel(this);
		backgroundPanel.add(optionsPanel, BorderLayout.SOUTH);
		
		leftLateralPanel = new LateralPanel(this, LateralPanel.PREVIOUS);
		backgroundPanel.add(leftLateralPanel, BorderLayout.WEST);
		
		rightLateralPanel = new LateralPanel(this, LateralPanel.NEXT);
		backgroundPanel.add(rightLateralPanel, BorderLayout.EAST);
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Pastes team card of the team given by the country and year parameters into the Album. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 * <b>post: </b> The team card was pasted.
	 *
	 * @param pCountry Team's country. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear &gt; 0.
	 */
	public void pasteTeamCard(String pCountry, int pYear) {
		try {
			world.pasteTeamCard(pCountry, pYear);
			updateInterface();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Paste team card", JOptionPane
				.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Pastes crest card of the team given by the country and year parameters into the Album. <br>
	 * <b>pre: </b> The list of teams is initialized. Specified team exists.<br>
	 * <b>post: </b> The crest card was pasted.
	 *
	 * @param pCountry Team's country. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear    Year in which the team represented the country. pYear &gt; 0.
	 */
	public void pasteCrestCard(String pCountry, int pYear) {
		try {
			world.pasteCrestCard(pCountry, pYear);
			updateInterface();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Paste crest card",
			                              JOptionPane.INFORMATION_MESSAGE);
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
	 */
	public void pastePlayerCard(String pCountry, int pYear, int pShirtNumber) {
		try {
			world.pastePlayerCard(pShirtNumber, pCountry, pYear);
			updateInterface();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Paste player card",
			                              JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Mark a card as a favorite. <br>
	 * <b>pre: </b> The team exists.<br>
	 * <b>post: </b> Card was marked as a favorite.
	 *
	 * @param pCountry     Team's country. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear        Year in which the team represented the country. pYear &gt; 0.
	 * @param pCardType    Card type of the card. pCardType belongs to {CardType.CREST,
	 *                     CardType.TEAM, CardType.PLAYER}.
	 * @param pShirtNumber Player's shirt number. pShirtNumber &gt; 0.
	 */
	public void changeFavoriteCardAlbum(String pCountry, int pYear, CardType pCardType, int
		pShirtNumber) {
		try {
			if (pCardType == CardType.CREST) {
				world.changeFavoriteCrest(pCountry, pYear);
			} else if (pCardType == CardType.TEAM) {
				world.changeFavoriteTeam(pCountry, pYear);
			} else {
				world.changeFavoritePlayer(pCountry, pYear, pShirtNumber);
			}
			updateInterface();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mark as favorite",
			                              JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Navigates to the previous team.<br>
	 * <b>post: </b> The team index was decreased by one if it was greater than 0.
	 */
	public void previous() {
		if (currentIndex == 0) {
			JOptionPane.showMessageDialog(this, "There are no more teams", "Previous team",
			                              JOptionPane.ERROR_MESSAGE);
		} else {
			currentIndex--;
			updateInterface();
		}
	}
	
	/**
	 * Navigates to the next team.<br>
	 * <b>post: </b> The team index was increased by one if it was greater than 0.
	 */
	public void next() {
		ArrayList<Team> teams = world.getTeams();
		if (teams.size() == currentIndex + 1) {
			JOptionPane.showMessageDialog(this, "There are no more teams", "Next team",
			                              JOptionPane.ERROR_MESSAGE);
		} else {
			currentIndex++;
			updateInterface();
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
	 *                           pCountry != "".
	 * @param pYear           Year in which the searched team represented the country. pYear
	 *                           &gt; 0.
	 * @param pShirtNumber    Player's shirt number. pShirtNumber &gt; 0.
	 * @param pNewShirtNumber New shirt number. pNewShirtNumber &gt; 0.
	 * @param pName           New player name. pName != null &amp;&amp;  pName != "".
	 * @param pPosition       New player position.pPosition belongs to {Position.GOALKEEPER,
	 *                        Position.DEFENDER,Position.WINGER,Position.STRIKER,
	 *                        Position.UNKNOWN}.
	 * @param pBirthYear      Player's birth year. pBirthYear &gt; 0.
	 * @param pHeight         New player height. pHeight &gt; 0.
	 * @param pWeight         New player weight. pWeight &gt; 0.
	 */
	public void modifyPlayer(String pCountry, int pYear, int pShirtNumber, int
		pNewShirtNumber, String pName, String pPosition, int pBirthYear, double
		                         pHeight, double pWeight) {
		/* This code is unnecessary.
		if (pNewShirtNumber <= 0)
			JOptionPane.showMessageDialog(this, "The new shirt number is invalid",
			                              "Modify Player", JOptionPane.ERROR_MESSAGE); */
		try {
			world.modifyPlayer(pCountry, pYear, pShirtNumber, pNewShirtNumber,
			                   pName,
			                   getPosition(pPosition), pBirthYear, pHeight, pWeight);
			updateInterface();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Modify player",
			                              JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Adds a team to the album given by country and year parameters. <br>
	 * <b>pre: </b> The list of teams is initialized. <br>
	 * <b>post: </b> If a team with the information given by the parameter didn't exist, a new
	 * team is added to the list. <br>
	 *
	 * @param pCountry Country of the player searched. pCountry != null &amp;&amp;  pCountry != "".
	 * @param pYear    Year in which the searched team represented the country. pYear &gt; 0.
	 */
	public void addTeam(String pCountry, int pYear) {
		boolean isAdded = world.addTeam(pCountry, pYear);
		if (!isAdded) {
			JOptionPane.showMessageDialog(this, "This team already exists in the album", "Add " +
				                              "team",
			                              JOptionPane.ERROR_MESSAGE);
		} else {
			currentIndex = world.getTeams()
			                    .size() - 1;
			updateInterface();
			JOptionPane.showMessageDialog(this, "The team was added successfully", "Add team",
			                              JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	/**
	 * Shows the dialog for entering a year and displays the teams from that year.
	 */
	public void findTeamsByYear() {
		
		String input = JOptionPane.showInputDialog(this, "Enter a year to consult",
		                                           "Find teams by year",
		                                           JOptionPane.QUESTION_MESSAGE);
		try {
			int year = Integer.parseInt(input);
			ArrayList<Team> teams = world.findTeamsByYear(year);
			StringBuilder message = new StringBuilder(teams.size() > 0 ? "The teams from " + year
				+ " are:" : "No teams " +
				"from " + year + " were found.");
			for (Team team : teams) {
				message.append("\n- ")
				       .append(team.getCountry());
			}
			JOptionPane.showMessageDialog(this, message.toString(), "Find teams by year",
			                              JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "The year must be a numeric value", "Find teams " +
				"by year", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * Finds the player given by shirt number, country, and year parameters. <br>
	 *
	 * @param pShirtNumber Shirt number of the player. pShirtNumber &gt; 0.
	 * @param pCountry     Country of the player searched. pCountry != null &amp;&amp;  pCountry
	 *                        != "".
	 * @param pYear        Year in which the searched team represented the country. pYear &gt; 0.
	 */
	public void findPlayer(int pShirtNumber, String pCountry, int pYear) {
		Player player = world.findPlayer(pShirtNumber, pCountry, pYear);
		if (player == null) {
			JOptionPane.showMessageDialog(this, "The player doesn't exist", "Find player",
			                              JOptionPane.ERROR_MESSAGE);
		} else {
			
			PlayerDialog dialog = new PlayerDialog(world.getTeams()
			                                            .get(world.findTeam(pCountry, pYear)),
			                                       player);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(this);
		}
	}
	
	/**
	 * Shows the dialog that displayed the most common age of a team in the album.
	 */
	public void showMostCommonAge() {
		Object[] teams = world.getTeams().toArray();
		Team team = (Team)JOptionPane.showInputDialog(this, "Select the team", "Most common age",
		                                              JOptionPane.QUESTION_MESSAGE, null, teams,
		                                              teams[0]);
		int mostCommonAge = world.getMostCommonAge(team.getCountry(), team.getYear());
		JOptionPane.showMessageDialog(this, "The most common age of team \"" + team + "\" is " +
			mostCommonAge + "", "Most common age", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	/**
	 * Updates the user interface with the information from the world.  <br>
	 * <b>post: </b> The team was updated with all of its components.
	 */
	private void updateInterface() {
		Team teamActual = world.getTeams().get(currentIndex);
		teamPanel.updateInterface(teamActual);
	}
	
	/**
	 * Load initial teams.<br>
	 * <b>pre: </b> The world is initialized.<br>
	 * <b>post: </b> The teams from the file ./data/data.txt were loaded.
	 */
	private void loadTeams() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("./data/data.txt"));
			String infoTeam;
			while ((infoTeam = in.readLine()) != null) {
				String country = infoTeam.split(";")[0];
				int year = Integer.parseInt(infoTeam.split(";")[1]);
				
				world.addTeam(country, year);
				for (int i = 0; i < Team.QUANTITY_OF_PLAYERS; i++) {
					String infoPlayer[] = in.readLine()
					                        .split(";");
					
					int ShirtNumber = Integer.parseInt(infoPlayer[0]);
					String name = infoPlayer[1];
					String position = infoPlayer[2];
					double peso = Double.parseDouble(infoPlayer[5]);
					double height = Double.parseDouble(infoPlayer[4]);
					int birthYear = Integer.parseInt(infoPlayer[3]);
					world.modifyPlayer(country, year, -(i + 1), ShirtNumber, name, getPosition
						(position), birthYear, height, peso);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Returns the player's position given by the string version in the parameter.
	 *
	 * @param pPosition Name of position.
	 *
	 * @return Position of the given name.
	 */
	private Position getPosition(String pPosition) {
		String pPosition2 = pPosition.toUpperCase();
		Position position;
		switch (pPosition2) {
			case "GOALKEEPER":
				position = Position.GOALKEEPER;
				break;
			case "DEFENDER":
				position = Position.DEFENDER;
				break;
			case "STRIKER":
				position = Position.STRIKER;
				break;
			case "WINGER":
				position = Position.WINGER;
				break;
			default:
				position = Position.UNKNOWN;
				break;
		}
		return position;
	}
	
	/**
	 * Shows the dialog with the album statistics. <br>
	 * <b>pre: </b> The world is initialized.
	 */
	public void showStatistics() {
		double percentCrestsPasted = world.getPercentageCompletenessCardType(CardType.CREST);
		double percentTeamsPasted = world.getPercentageCompletenessCardType(CardType.TEAM);
		double percentPlayersPasted = world.getPercentageCompletenessCardType(CardType.PLAYER);
		
		String message = "- You've pasted " + percentCrestsPasted + "% of the escudos.\n";
		message += "- You've pasted " + percentTeamsPasted + "% of the teams.\n";
		message += "- You've pasted " + percentPlayersPasted + "% of the players.\n";
		
		JOptionPane.showMessageDialog(this, message, "Statistics",
		                              JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Shows the dialog with the album error report.<br>
	 * <b>pre: </b> The world is initialized.
	 */
	public void showAnnotations() {
		ArrayList<String> report = world.getReports();
		StringBuilder message = new StringBuilder();
		for (String reportPart : report) {
			message.append(reportPart).append(".\n");
		}
		JOptionPane.showMessageDialog(this, message.toString(), "Report",
		                              JOptionPane.INFORMATION_MESSAGE);
	}
	
	// -----------------------------------------------------------------
	// Extension points
	// -----------------------------------------------------------------
	
	/**
	 * Extension  1
	 */
	public void reqFuncOption1() {
		
		String result = world.method1();
		JOptionPane.showMessageDialog(this, result, "Response 1", JOptionPane.INFORMATION_MESSAGE);
		updateInterface();
	}
	
	/**
	 * Extension  2
	 */
	public void reqFuncOption2() {
		
		String result = world.method2();
		JOptionPane.showMessageDialog(this, result, "Response 2", JOptionPane.INFORMATION_MESSAGE);
		updateInterface();
	}
	
	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------
	
	/**
	 * This method executes the application and creates a new user interface.
	 *
	 * @param args Optional array of arguments that are received via cli.
	 */
	public static void main(String[] args) {
		try {
			// Unifies the look and feel for Mac and Windows
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			AlbumInterface userInterface = new AlbumInterface();
			userInterface.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}