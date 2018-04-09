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
package uniandes.cupi2.album.test;

import org.junit.Test;

import uniandes.cupi2.album.world.Album;
import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Position;
import uniandes.cupi2.album.world.Card.CardType;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

/**
 * Test class for the album.
 */
public class AlbumTest {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Album on which the tests will be executed.
	 */
	private Album album;
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Prepares the album for the tests. <br>
	 * <b>post: </b> An album was created with 4 teams.
	 */
	@Before
	public void setupScenario1() {
		album = new Album();
		album.addTeam("Colombia", 2018);
		album.addTeam("Venezuela", 2018);
		album.addTeam("Venezuela", 2014);
		album.addTeam("Colombia", 2014);
	}
	
	/**
	 * <b>Test:</b> Verifies the method addTeam.<br>
	 * <b>Method to test:</b><br>
	 * getTeams<br>
	 * addTeam<br>
	 * <b>Test cases:</b><br>
	 * 1. Added teams successfully. <br>
	 * 2. Doesn't add a team that already exists.
	 */
	@Test
	public void testAddTeam() {
		// Test case 1
		assertEquals("The quantity of teams is incorrect.", album.getTeams().size(), 4);
		album.addTeam("Team1", 1950);
		album.addTeam("Team2", 1950);
		album.addTeam("Team3", 1950);
		assertEquals("The quantity of teams is incorrect.", album.getTeams().size(), 7);
		// Test case 2
		assertFalse("A team that already exists should not be able to be added.", album.addTeam
			("Team3", 1950));
	}
	
	/**
	 * <b>Test:</b> Verifies the method findTeamsByYear.<br>
	 * <b>Method to test:</b><br>
	 * findTeamsByYear<br>
	 * <b>Test cases:</b><br>
	 * 1. There exist teams that played in the year specified. <br>
	 * 2. There don't exist teams that played in the year specified.
	 */
	@Test
	public void testFindTeamsByYear() {
		// Test case 1
		assertEquals("The quantity of teams is incorrect.", album.findTeamsByYear(1920).size(), 0);
		album.addTeam("Team1", 1950);
		album.addTeam("Team2", 1950);
		album.addTeam("Team3", 1950);
		assertEquals("The quantity of teams is incorrect.", album.findTeamsByYear(1950).size(), 3);
		// Test case 2
		assertEquals("No team should be found in the year specified.",
		             album.findTeamsByYear(2050).size(), 0);
	}
	
	/**
	 * <b>Test:</b> Verifies the method findTeam.<br>
	 * <b>Method to test:</b><br>
	 * findTeam<br>
	 * <b>Test cases:</b><br>
	 * 1. The team doesn't exist. <br>
	 * 2. The team exists.
	 */
	@Test
	public void testFindTeam() {
		// Test case 1
		assertEquals("Team should not have been found since it doesn't exist.",
		             album.findTeam("Colombia", 1998), -1);
		
		// Test case 2
		assertEquals("Team was not found.", album.findTeam("Colombia", 2014), 3);
		int index = album.findTeam("Colombia", 2014);
		assertEquals("The team found is incorrect.", album.getTeams().get(index).getYear(), 2014);
		assertEquals("The team found is incorrect.", album.getTeams().get(index).getCountry(),
		             "Colombia");
	}
	
	/**
	 * <b>Test:</b> Verifies the method findPlayer.<br>
	 * <b>Method to test:</b><br>
	 * findPlayer<br>
	 * <b>Test cases:</b><br>
	 * 1. The team doesn't exist. <br>
	 * 2. The player doesn't exist. <br>
	 * 3. The player exists.
	 */
	@Test
	public void testFindPlayer() {
		// Test case 1
		assertNull("Player should not have been found since he doesn't exist.",
		           album.findPlayer(15, "Colombia", 1998));
		
		// Test case 2
		assertNull("Player should not have been found since he doesn't exist.",
		           album.findPlayer(35, "Colombia", 2014));
		
		// Test case 3
		Team team = album.getTeams().get(0);
		Player player = team.getPlayers()[0];
		assertNotNull("Player should have been found",
		              album.findPlayer(player.getShirtNumber(), team.getCountry(), team.getYear
			              ()));
		
		assertEquals("The player found is incorrect.",
		             album.findPlayer(player.getShirtNumber(), team.getCountry(),
		                              team.getYear()).getName(), player.getName());
	}
	
	/**
	 * <b>Test:</b> Verifies the method pasteTeamCard.<br>
	 * <b>Method to test:</b><br>
	 * pasteTeamCard<br>
	 * <b>Test cases:</b><br>
	 * 1. Team's card is pasted. <br>
	 * 2. Team's card isn't pasted.
	 */
	@Test
	public void testPasteCardTeam() {
		// Test case 1
		try {
			album.pasteTeamCard("Colombia", 2014);
			assertNotNull("Team card isn't found after pasting.",
			              album.getTeams().get(album.findTeam("Colombia", 2014)).getTeamCard());
		} catch (Exception e) {
			fail("Team card should have been pasted.");
		}
		
		// Test case 2
		try {
			album.pasteTeamCard("Colombia.", 2014);
			fail("Team card shouldn't have been pasted since it was already pasted.");
		} catch (Exception e) {
			// Should generate an exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method pasteCrestCard.<br>
	 * <b>Method to test:</b><br>
	 * pasteCrestCard<br>
	 * <b>Test cases:</b><br>
	 * 1. Team's crest card is pasted. <br>
	 * 2. Team's crest card isn't pasted.
	 */
	@Test
	public void testPasteCardCrest() {
		// Test case 1
		try {
			album.pasteCrestCard("Colombia", 2014);
			assertNotNull("Crest card isn't found after pasting.",
			              album.getTeams().get(album.findTeam("Colombia", 2014)).getCrestCard());
		} catch (Exception e) {
			fail("Crest card should have been pasted.");
		}
		
		// Test case 2
		try {
			album.pasteCrestCard("Colombia.", 2014);
			fail("Crest card shouldn't have been pasted since it was already pasted.");
		} catch (Exception e) {
			// Should generate an exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method pastePlayerCard.<br>
	 * <b>Method to test:</b><br>
	 * pastePlayerCard<br>
	 * <b>Test cases:</b><br>
	 * 1. Team doesn't have a player card pasted. <br>
	 * 2. Team has a player card pasted.
	 */
	@Test
	public void testPastePlayerCard() {
		// Test case 1
		Player player = album.getTeams().get(0).getPlayers()[0];
		try {
			album.pastePlayerCard(player.getShirtNumber(), "Colombia", 2018);
			assertNotNull("Player card isn't found after pasting.",
			              album.getTeams().get(album.findTeam("Colombia", 2018))
			                   .findPlayer(player.getShirtNumber()).getCard());
			
		} catch (Exception e) {
			fail("Team card should have been pasted.");
		}
		
		// Test case 2
		try {
			album.pastePlayerCard(player.getShirtNumber(), "Colombia", 2018);
			fail("Player card shouldn't have been pasted since it was already pasted.");
		} catch (Exception e) {
			// Should generate an exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method changeFavoriteTeam.<br>
	 * <b>Method to test:</b><br>
	 * changeFavoriteTeam<br>
	 * <b>Test cases:</b><br>
	 * 1. Team card isn't card pasted. <br>
	 * 2. Team card is a favorite card. <br>
	 * 3. Team card isn't a favorite card. <br>
	 * 4. Maximum amount of favorite cards is reached.
	 */
	@Test
	public void testChangeFavoriteTeam() {
		// Test case 1
		
		Team team = album.getTeams().get(0);
		try {
			album.changeFavoriteTeam(team.getCountry(), team.getYear());
			fail("Should not be able to change team card to favorite when it isn't pasted.");
			
		} catch (Exception e) {
			// Should generate an exception.
		}
		
		try {
			album.pasteTeamCard(team.getCountry(), team.getYear());
		} catch (Exception e) {
			fail("An exception shouldn't be thrown when pasting the team card.");
		}
		try {
			assertFalse("The team card should not be a favorite by default.",
			            album.getTeams().get(0).getTeamCard().isFavorite());
			
			// Test case 2
			album.changeFavoriteTeam(team.getCountry(), team.getYear());
			assertTrue("The team card should be a favorite.",
			           album.getTeams().get(0).getTeamCard().isFavorite());
			
			// Test case 3
			album.changeFavoriteTeam(team.getCountry(), team.getYear());
			assertFalse("The team card shouldn't be a favorite.",
			            album.getTeams().get(0).getTeamCard().isFavorite());
		} catch (Exception e) {
			fail("An exception shouldn't be thrown when pasting the team card.");
		}
		
		// Test case 4
		try {
			album.pastePlayerCard(team.getPlayers()[1].getShirtNumber(), team.getCountry(),
			                      team.getYear());
			album.pastePlayerCard(team.getPlayers()[2].getShirtNumber(), team.getCountry(),
			                      team.getYear());
			album.changeFavoritePlayer(team.getCountry(), team.getYear(),
			                           team.getPlayers()[1].getShirtNumber());
			album.changeFavoritePlayer(team.getCountry(), team.getYear(),
			                           team.getPlayers()[2].getShirtNumber());
			album.changeFavoriteTeam(team.getCountry(), team.getYear());
			fail("Maximum amount of favorite cards has already been reached.");
		} catch (Exception e) {
			// Should generate an exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method changeFavoriteCrest.<br>
	 * <b>Method to test:</b><br>
	 * changeFavoriteCrest<br>
	 * <b>Test cases:</b><br>
	 * 1. Crest card isn't card pasted. <br>
	 * 2. Crest card is a favorite card. <br>
	 * 3. Crest card isn't a favorite card. <br>
	 * 4. Maximum amount of favorite cards is reached.
	 */
	@Test
	public void testChangeFavoriteCrest() {
		// Test case 1
		
		Team team = album.getTeams().get(0);
		try {
			album.changeFavoriteCrest(team.getCountry(), team.getYear());
			fail("Should not be able to change crest card to favorite when it isn't pasted.");
			
		} catch (Exception e) {
			// Should generate an exception.
		}
		
		try {
			album.pasteCrestCard(team.getCountry(), team.getYear());
		} catch (Exception e) {
			fail("An exception shouldn't be thrown when pasting the crest card.");
		}
		try {
			assertFalse("The crest card should not be a favorite by default.",
			            album.getTeams().get(0).getCrestCard().isFavorite());
			
			// Test case 2
			album.changeFavoriteCrest(team.getCountry(), team.getYear());
			assertTrue("The crest card should be a favorite.",
			           album.getTeams().get(0).getCrestCard().isFavorite());
			
			// Test case 3
			album.changeFavoriteCrest(team.getCountry(), team.getYear());
			assertFalse("The crest card shouldn't be a favorite.",
			            album.getTeams().get(0).getCrestCard().isFavorite());
		} catch (Exception e) {
			fail("An exception shouldn't be thrown when pasting the crest card.");
		}
		
		// Test case 4
		try {
			album.pastePlayerCard(team.getPlayers()[1].getShirtNumber(), team.getCountry(),
			                      team.getYear());
			album.pastePlayerCard(team.getPlayers()[2].getShirtNumber(), team.getCountry(),
			                      team.getYear());
			album.changeFavoritePlayer(team.getCountry(), team.getYear(),
			                           team.getPlayers()[1].getShirtNumber());
			album.changeFavoritePlayer(team.getCountry(), team.getYear(),
			                           team.getPlayers()[2].getShirtNumber());
			album.changeFavoriteCrest(team.getCountry(), team.getYear());
			fail("Maximum amount of favorite cards has already been reached.");
		} catch (Exception e) {
			// Should generate an exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method changeFavoritePlayer.<br>
	 * <b>Method to test:</b><br>
	 * changeFavoritePlayer<br>
	 * <b>Test cases:</b><br>
	 * 1. Player card isn't card pasted. <br>
	 * 2. Player card is a favorite card. <br>
	 * 3. Player card isn't a favorite card. <br>
	 * 4. Maximum amount of favorite cards is reached.
	 */
	@Test
	public void testChangeFavoritePlayer() {
		// Test case 1
		Team team = album.getTeams().get(0);
		int ShirtNumber = team.getPlayers()[0].getShirtNumber();
		try {
			album.changeFavoritePlayer(team.getCountry(), team.getYear(), ShirtNumber);
			fail("Should not be able to change player card to favorite when it isn't pasted.");
			
		} catch (Exception e) {
			// Should generate an exception.
		}
		
		try {
			album.pastePlayerCard(ShirtNumber, team.getCountry(), team.getYear());
		} catch (Exception e) {
			fail("An exception shouldn't be thrown when pasting the player card.");
		}
		try {
			assertFalse("The player card should not be a favorite by default.",
			            album.getTeams().get(0).findPlayer(ShirtNumber).getCard().isFavorite());
			
			// Test case 2
			
			album.changeFavoritePlayer(team.getCountry(), team.getYear(), ShirtNumber);
			assertTrue("The player card should be a favorite.",
			           album.getTeams().get(0).findPlayer(ShirtNumber).getCard().isFavorite());
			
			// Test case 3
			
			album.changeFavoritePlayer(team.getCountry(), team.getYear(), ShirtNumber);
			assertFalse("The player card shouldn't be a favorite",
			            album.getTeams().get(0).findPlayer(ShirtNumber).getCard().isFavorite());
		} catch (Exception e) {
			fail("An exception shouldn't be thrown when pasting the crest card.");
		}
		
		// Test case 4
		
		try {
			team.changeFavoritePlayer(team.getPlayers()[0].getShirtNumber());
			album.pastePlayerCard(team.getPlayers()[1].getShirtNumber(), team.getCountry(),
			                      team.getYear());
			album.pastePlayerCard(team.getPlayers()[2].getShirtNumber(), team.getCountry(),
			                      team.getYear());
			album.changeFavoritePlayer(team.getCountry(), team.getYear(),
			                           team.getPlayers()[1].getShirtNumber());
			album.changeFavoritePlayer(team.getCountry(), team.getYear(),
			                           team.getPlayers()[2].getShirtNumber());
			fail("Maximum amount of favorite cards has already been reached.");
		} catch (Exception e) {
			// Should generate an exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method modifyPlayer. <br>
	 * <b>Method to test:</b><br>
	 * modifyPlayer<br>
	 * <b>Test cases:</b><br>
	 * 1. The new and old shirt numbers don't coincide and a player with the specified new shirt
	 * number exists. <br>
	 * 2. A player with the specified new shirt number does not exist.
	 * 3. The new and old shirt numbers coincide.  <br>
	 * 4. Player has a card pasted. <br>
	 * 5. Maximum amount of goalkeepers has been reached. <br>
	 * 6. Maximum amount of defenders has been reached. <br>
	 * 7. Maximum amount of strikers has been reached.
	 */
	@Test
	public void testModifyPlayer() {
		// Test case 1
		
		Team team = album.getTeams().get(0);
		Player playerToBeModified = team.getPlayers()[0];
		Player playerToBeModified1 = team.getPlayers()[1];
		
		try {
			album.modifyPlayer(team.getCountry(), team.getYear(),
			                   playerToBeModified1.getShirtNumber(),
			                   playerToBeModified.getShirtNumber(), "New name", Position
				                   .GOALKEEPER,
			                   1970, 1.80, 75);
			fail("Player must not be modified when the new and old shirt numbers don't coincide " +
				     "and there already exists a player with the new new shirt number.");
		} catch (Exception e) {
			// Should generate an exception.
		}
		
		// Test case 2
		
		try {
			team.modifyPlayer(playerToBeModified.getShirtNumber(), 25, "New name",
			                  Position.GOALKEEPER, 1970, 1.80, 75);
			assertEquals("After modifying, the player's shirt number is incorrect.",
			             playerToBeModified.getShirtNumber(), 25);
			assertEquals("After modifying, the player's name is incorrect.",
			             playerToBeModified.getName(), "New name");
			assertEquals("After modifying, the player's position is incorrect.",
			             playerToBeModified.getPosition(), Position.GOALKEEPER);
			assertEquals("After modifying, the player's birth year is incorrect",
			             playerToBeModified.getBirthYear(), 1970);
			assertEquals("After modifying, the player's height is incorrect",
			             playerToBeModified.getHeight(), 1.80, 0);
			assertEquals("After modifying, the player's height is incorrect",
			             playerToBeModified.getWeight(), 75, 0);
		} catch (Exception e) {
			fail("The player should have been modified since no other player existed with " +
				     "the new shirt number.");
		}
		
		// Test case 3
		
		// Test case 3
		try {
			team.modifyPlayer(playerToBeModified.getShirtNumber(),
			                  playerToBeModified.getShirtNumber(), "New name2", Position.WINGER,
			                  1974, 1.88, 70);
			assertEquals("After modifying, the player's name is incorrect.",
			             playerToBeModified.getName(), "New name2");
			assertEquals("After modifying, the player's position is incorrect.",
			             playerToBeModified.getPosition(), Position.WINGER);
			assertEquals("After modifying, the player's birth year is incorrect",
			             playerToBeModified.getBirthYear(), 1974);
			assertEquals("After modifying, the player's height is incorrect",
			             playerToBeModified.getHeight(), 1.88, 0);
			assertEquals("After modifying, the player's height is incorrect",
			             playerToBeModified.getWeight(), 70, 0);
		} catch (Exception e) {
			fail("The player should have been modified since the new and old shirt numbers " +
				     "coincide.");
		}
		
		// Test case 4
		
		try {
			team.pastePlayerCard(playerToBeModified.getShirtNumber());
			team.modifyPlayer(playerToBeModified.getShirtNumber(), playerToBeModified
				.getShirtNumber(), "New name", Position.UNKNOWN, 1970, 1.80, 75);
			fail("Player should not have been modified since he already had a card pasted.");
		} catch (Exception e) {
			// Should throw exception.
		}
		
		// Test case 5
		setupScenario1();
		team = album.getTeams().get(0);
		try {
			for (int i = 0; i < Team.MAX_GOALKEEPERS; i++) {
				album.modifyPlayer(team.getCountry(), team.getYear(),
				                   team.getPlayers()[i].getShirtNumber(),
				                   team.getPlayers()[i].getShirtNumber(), "New name",
				                   Position.GOALKEEPER, 1970, 1.80, 75);
			}
		} catch (Exception e) {
			fail("No exception should be thrown when the number of goalkeepers is below the max.");
		}
		
		try {
			album.modifyPlayer(team.getCountry(), team.getYear(),
			                   team.getPlayers()[11].getShirtNumber(),
			                   team.getPlayers()[11].getShirtNumber(), "New name",
			                   Position.GOALKEEPER, 1970, 1.80, 75);
			fail("No goalkeepers should be added after the team has reached the maximum amount " +
				     "of goalkeepers.");
		} catch (Exception e) {
			// Should generate an exception.
		}
		
		// Test case 6
		setupScenario1();
		
		try {
			for (int i = 0; i < Team.MAX_DEFENDERS; i++) {
				album.modifyPlayer(team.getCountry(), team.getYear(),
				                   team.getPlayers()[i].getShirtNumber(),
				                   team.getPlayers()[i].getShirtNumber(), "New name",
				                   Position.DEFENDER, 1970, 1.80, 75);
			}
		} catch (Exception e) {
			fail("No exception should be thrown when the number of defenders is below the max.");
		}
		
		try {
			album.modifyPlayer(team.getCountry(), team.getYear(),
			                   team.getPlayers()[11].getShirtNumber(),
			                   team.getPlayers()[11].getShirtNumber(), "New name",
			                   Position.DEFENDER, 1970, 1.80, 75);
			fail("No defenders should be added after the team has reached the maximum amount " +
				     "of defenders.");
		} catch (Exception e) {
			// Should generate an exception.
		}
		
		// Test case 7
		
		setupScenario1();
		
		try {
			for (int i = 0; i < Team.MAX_STRIKERS; i++) {
				album.modifyPlayer(team.getCountry(), team.getYear(),
				                   team.getPlayers()[i].getShirtNumber(),
				                   team.getPlayers()[i].getShirtNumber(), "New name",
				                   Position.STRIKER, 1970, 1.80, 75);
			}
		} catch (Exception e) {
			fail("No exception should be thrown when the number of strikers is below the max.");
			
		}
		
		try {
			album.modifyPlayer(team.getCountry(), team.getYear(),
			                   team.getPlayers()[11].getShirtNumber(),
			                   team.getPlayers()[11].getShirtNumber(), "New name",
			                   Position.STRIKER, 1970, 1.80, 75);
			fail("No strikers should be added after the team has reached the maximum amount of " +
				     "strikers.");
		} catch (Exception e) {
			// Should generate an exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method getMostCommonAge.<br>
	 * <b>Method to test:</b><br>
	 * getMostCommonAge<br>
	 * <b>Test cases:</b><br>
	 * 1. The most common age is correct for every team.  <br>
	 * 2. The most common age is correct after modifying the ages of the players.
	 */
	@Test
	public void testGetMostCommonAge() {
		ArrayList<Team> teams = album.getTeams();
		for (Team team : teams) {
			int expectedAge = team.getYear() - 1990;
			assertEquals("The expected age is incorrect.", team.getMostCommonAge(), expectedAge);
		}
		
		Team team = teams.get(0);
		Player[] players = team.getPlayers();
		for (int i = 0; i < players.length / 2 + 2; i++) {
			try {
				album.modifyPlayer(team.getCountry(), team.getYear(),
				                   players[i].getShirtNumber(), players[i].getShirtNumber(),
				                   players[i].getName(),
				                   players[i].getPosition(), 1987, 1.80, 80);
			} catch (Exception e) {
				fail("No exception should be thrown when modifying a player.");
			}
		}
		assertEquals("The expected age is incorrect.", team.getYear() - 1987,
		             album.getMostCommonAge(team.getCountry(), team.getYear()));
	}
	
	/**
	 * <b>Test:</b> Verifies the method getPercentageCompletenessCardType.<br>
	 * <b>Method to test:</b><br>
	 * getPercentageCompletenessCardType<br>
	 * <b>Test cases:</b><br>
	 * 1. The album is empty. <br>
	 * 2. The crest and team cards are pasted as well as half of the player cards from half of
	 * the teams.
	 */
	@Test
	public void testGetPercentageCompletenessCardType() {
		// Test case 1
		
		assertEquals("The percentage of completeness of the player cards should be 0 upon " +
			             "creating the album.",
		             album.getPercentageCompletenessCardType(CardType.PLAYER), 0, 0);
		assertEquals("The percentage of completeness of the team cards should be 0 upon creating" +
			             " the album.",
		             album.getPercentageCompletenessCardType(CardType.TEAM), 0, 0);
		assertEquals("The percentage of completeness of the crest cards should be 0 upon " +
			             "creating the album.",
		             album.getPercentageCompletenessCardType(CardType.TEAM), 0, 0);
		
		// Test case 2
		
		ArrayList<Team> teams = album.getTeams();
		for (int i = 0; i < teams.size(); i = i + 2) {
			Team team = teams.get(i);
			try {
				album.pasteTeamCard(team.getCountry(), team.getYear());
				album.pasteCrestCard(team.getCountry(), team.getYear());
			} catch (Exception e) {
				fail("No exception should be thrown when pasting this card.");
			}
			Player[] players = team.getPlayers();
			for (int j = 0; j < players.length / 2; j++) {
				Player player = players[j];
				try {
					album.pastePlayerCard(player.getShirtNumber(), team.getCountry(), team.getYear
						());
				} catch (Exception e) {
					fail("No exception should be thrown when pasting this player card.");
				}
			}
		}
		
		assertEquals("The percentage of completeness of the player cards is incorrect.", album
			.getPercentageCompletenessCardType(CardType.PLAYER), 25.0, 0);
		assertEquals("The percentage of completeness of the team cards is incorrect.", album
			.getPercentageCompletenessCardType(CardType.TEAM), 50.0, 0);
		assertEquals("The percentage of completeness of the crest cards is incorrect.", album
			.getPercentageCompletenessCardType(CardType.CREST), 50.0, 0);
		
	}
	
}