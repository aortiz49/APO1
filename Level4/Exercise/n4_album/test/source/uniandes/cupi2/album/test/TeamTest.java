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
package uniandes.cupi2.album.test;

import org.junit.Test;

import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Position;
import uniandes.cupi2.album.world.Card.CardType;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Test class for the team.
 */
public class TeamTest {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Team on which the tests will be executed.
	 */
	private Team team;
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Prepares the team for the tests. <br>
	 * <b>post: </b> Team was created.
	 */
	@Before
	public void setupScenario1() {
		team = new Team("Colombia", 2018);
	}
	
	/**
	 * <b>Test:</b> Verifies the constructor method and the basic getter methods for the team. <br>
	 * <b>Method to test:</b><br>
	 * Team<br>
	 * getCountry<br>
	 * getYear<br>
	 * getTeamCard<br>
	 * getCrestCard<br>
	 * getPlayers<br>
	 * <b>Test cases:</b><br>
	 * Creates the team
	 * Tests if the team was created properly and returns all the information correctly.
	 */
	@Test
	public void testTeam() {
		assertEquals("The team is incorrect.", team.getCountry(), "Colombia");
		assertEquals("The year is incorrect.", team.getYear(), 2018);
		assertNull("The team card should be null by default.", team.getTeamCard());
		assertNull("The crest card should be null by default.", team.getCrestCard());
		assertNotNull("The list of players wasn't initialized.", team.getPlayers());
		assertEquals("The size of the list of players is incorrect.", team.getPlayers().length,
		             Team.QUANTITY_OF_PLAYERS);
		
		for (int i = 0; i < team.getPlayers().length; i++) {
			assertEquals("The default player position is incorrect.",
			             team.getPlayers()[i].getPosition(), Position.UNKNOWN);
			assertEquals("The default player shirt number is incorrect.",
			             team.getPlayers()[i].getShirtNumber(), -(i + 1));
			assertEquals("The default player height number is incorrect.",
			             team.getPlayers()[i].getHeight(), 1.78, 0);
			assertEquals("The default player weight number is incorrect.",
			             team.getPlayers()[i].getWeight(), 65, 0);
			assertEquals("The default player name is incorrect.",
			             team.getPlayers()[i].getName(), "Player" + (i + 1));
			assertEquals("The default player birth year is incorrect.",
			             team.getPlayers()[i].getBirthYear(), 1990);
			
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method findPlayer.<br>
	 * <b>Method to test:</b><br>
	 * findPlayer<br>
	 * <b>Test cases:</b><br>
	 * 1. The player doesn't exist. <br>
	 * 2. The player exists.
	 */
	
	@Test
	public void testFindPlayer() {
		// Test case 1
		assertNull("No player should exists with this shirt number.", team.findPlayer(-50));
		
		// Test case 2
		for (int i = 0; i < team.getPlayers().length; i++) {
			assertNotNull("The player should exist.",
			              team.findPlayer(team.getPlayers()[i].getShirtNumber()));
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method pasteTeamCard.<br>
	 * <b>Method to test:</b><br>
	 * getTeamCard<br>
	 * pasteTeamCard<br>
	 * <b>Test cases:</b><br>
	 * 1. Team doesn't have a team card. <br>
	 * 2. Team already has a team card. <br>
	 */
	@Test
	public void testPasteTeamCard() {
		// Test case 1
		assertNull("The newly created team should not have a team card by default.",
		           team.getTeamCard());
		
		// Test case
		try {
			team.pasteTeamCard();
		} catch (Exception e) {
			fail("The team card should have been pasted since it didn't already have one.");
		}
		assertNotNull("The team should have a team card since it was already pasted.",
		              team.getTeamCard());
		
		try {
			team.pasteTeamCard();
			fail("The team card should not have been pasted since it was already pasted.");
		} catch (Exception e) {
			// Should throw exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verify the method pasteCrestCard. <br>
	 * <b>Method to test:</b><br>
	 * getCrestCard<br>
	 * pasteCrestCard<br>
	 * <b>Test cases:</b><br>
	 * 1. Team doesn't have a crest card. <br>
	 * 2. Team already has a crest card. <br>
	 */
	@Test
	public void testPasteCrestCard() {
		// Test case 1
		assertNull("The newly created team should not have a crest card by default.",
		           team.getCrestCard());
		
		// Test case 2
		try {
			team.pasteCrestCard();
		} catch (Exception e) {
			fail("The crest card should have been pasted since it didn't already have one.");
		}
		assertNotNull("The team should have a crest card since it was already pasted.",
		              team.getCrestCard());
		
		try {
			team.pasteCrestCard();
			fail("The crest card should not have been pasted since it was already pasted.");
		} catch (Exception e) {
			// Should throw exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method pastePlayerCard.<br>
	 * <b>Method to test:</b><br>
	 * pastePlayerCard<br>
	 * <b>Test cases:</b><br>
	 * 1. Player doesn't have a card. <br>
	 * 2. Player has a card. <br>
	 */
	@Test
	public void testPastePlayerCard() {
		// Test case 1
		Player player = team.getPlayers()[0];
		assertNull("The newly created player should not have a crest card by default.",
		           player.getCard());
		
		// Test case 2
		try {
			team.pastePlayerCard(player.getShirtNumber());
		} catch (Exception e) {
			fail("The player card should have been pasted since it didn't already have one.");
		}
		
		assertNotNull("The team should have a crest card since it was already pasted.",
		              player.getCard());
		
		try {
			team.pastePlayerCard(player.getShirtNumber());
			fail("The crest card should not have been pasted since it was already pasted.");
		} catch (Exception e) {
			// Should throw exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method changeFavoriteTeam.<br>
	 * <b>Method to test:</b><br>
	 * changeFavoriteTeam<br>
	 * <b>Test cases:</b><br>
	 * 1. Team doesn't have a card. <br>
	 * 2. The team card is a favorite. <br>
	 * 3. The team card is not a favorite. <br>
	 * 4. Number of favorite cards has reach the maximum limit.
	 */
	@Test
	public void testChangeFavoriteTeam() {
		// Test case 1
		try {
			team.changeFavoriteTeam();
			fail("Team card cannot be changed to favorite when it hasn't been pasted.");
			
		} catch (Exception e) {
			// Should throw exception.
		}
		
		try {
			team.pasteTeamCard();
		} catch (Exception e) {
			fail("An exception should not be thrown when pasting the card since it didn't " +
				     "already have one.");
		}
		try {
			assertFalse("The card should not be a favorite by default.",
			            team.getTeamCard().isFavorite());
			
			// Test case 2
			team.changeFavoriteTeam();
			assertTrue("The card should be a favorite.", team.getTeamCard().isFavorite());
			
			// Test case 3
			team.changeFavoriteTeam();
			assertFalse("The card should not be a favorite.", team.getTeamCard().isFavorite());
		} catch (Exception e) {
			fail("An exception should not be thrown since the team card is already pasted.");
		}
		
		// Test case 4
		try {
			team.getPlayers()[1].pasteCard();
			team.getPlayers()[2].pasteCard();
			team.changeFavoritePlayer(team.getPlayers()[1].getShirtNumber());
			team.changeFavoritePlayer(team.getPlayers()[2].getShirtNumber());
			team.changeFavoriteTeam();
			fail("The maximum amount of cards for the team has been violated.");
		} catch (Exception e) {
			// Should throw exception.
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method changeFavoriteCrest. <br>
	 * <b>Method to test:</b><br>
	 * changeFavoriteCrest<br>
	 * <b>Test cases:</b><br>
	 * 1. Crest doesn't have a card. <br>
	 * 2. The crest card is a favorite. <br>
	 * 3. The crest card is not a favorite. <br>
	 * 4. Number of favorite cards has reach the maximum limit.
	 */
	@Test
	public void testChangeFavoriteCrest() {
		// Test case 1
		try {
			team.changeFavoriteCrest();
			fail("Crest card cannot be changed to favorite when it hasn't been pasted.");
			
		} catch (Exception e) {
			// Should throw exception.
		}
		
		try {
			team.pasteCrestCard();
		} catch (Exception e) {
			fail("An exception should not be thrown when pasting the card since it didn't " +
				     "already have one.");
		}
		try {
			assertFalse("The card should not be a favorite by default.",
			            team.getCrestCard().isFavorite());
			
			// Test case 2
			team.changeFavoriteCrest();
			assertTrue("The card should be a favorite.", team.getCrestCard().isFavorite());
			
			// Test case 3
			team.changeFavoriteCrest();
			assertFalse("The card should not be a favorite.", team.getCrestCard().isFavorite());
		} catch (Exception e) {
			fail("An exception should not be thrown since the team card is already pasted.");
		}
		
		// Test case 4
		try {
			team.getPlayers()[1].pasteCard();
			team.getPlayers()[2].pasteCard();
			team.changeFavoritePlayer(team.getPlayers()[1].getShirtNumber());
			team.changeFavoritePlayer(team.getPlayers()[2].getShirtNumber());
			team.changeFavoriteCrest();
			fail("The maximum amount of cards for the team has been violated.");
		} catch (Exception e) {
			// Should throw exception.
		}
		
	}
	
	/**
	 * <b>Test:</b> Verifies the method changeFavoritePlayer.<br>
	 * <b>Method to test:</b><br>
	 * changeFavoritePlayer<br>
	 * <b>Test cases:</b><br>
	 * 1. Player doesn't have a card. <br>
	 * 2. The player card is a favorite. <br>
	 * 3. The player card is not a favorite. <br>
	 * 4. Number of favorite cards has reach the maximum limit.
	 */
	@Test
	public void testChangeFavoritePlayer() {
		// Test case 1
		int ShirtNumber = team.getPlayers()[0].getShirtNumber();
		try {
			team.changeFavoritePlayer(ShirtNumber);
			fail("Player card cannot be changed to favorite when it hasn't been pasted.");
			
		} catch (Exception e) {
			// Should throw exception.
		}
		
		try {
			team.pastePlayerCard(ShirtNumber);
		} catch (Exception e) {
			fail("An exception should not be thrown when pasting the card since it didn't " +
				     "already have one.");
		}
		try {
			assertFalse("The card should not be a favorite by default.",
			            team.findPlayer(ShirtNumber).getCard().isFavorite());
			
			// Test case 2
			team.changeFavoritePlayer(ShirtNumber);
			assertTrue("The card should be a favorite.",
			           team.findPlayer(ShirtNumber).getCard().isFavorite());
			
			// Test case 3
			team.changeFavoritePlayer(ShirtNumber);
			assertFalse("The card should not be a favorite.",
			            team.findPlayer(ShirtNumber).getCard().isFavorite());
		} catch (Exception e) {
			fail("An exception should not be thrown since the player card is already pasted.");
		}
		
		// Test case 4
		
		try {
			team.changeFavoritePlayer(team.getPlayers()[0].getShirtNumber());
			team.getPlayers()[1].pasteCard();
			team.getPlayers()[2].pasteCard();
			team.changeFavoritePlayer(team.getPlayers()[1].getShirtNumber());
			team.changeFavoritePlayer(team.getPlayers()[2].getShirtNumber());
			fail("The maximum amount of cards for the team has been violated.");
		} catch (Exception e) {
			// Should throw exception.
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
		Player playerToBeModified = team.getPlayers()[0];
		Player playerToBeModified1 = team.getPlayers()[1];
		try {
			team.modifyPlayer(playerToBeModified1.getShirtNumber(),
			                  playerToBeModified.getShirtNumber(), "New name",
			                  Position.GOALKEEPER, 1970, 1.80, 75);
			fail("Player must not be modified when the new and old shirt numbers don't coincide " +
				     "and there already exists a player with the new new shirt number.");
		} catch (Exception e) {
			// Should throw exception.
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
		try {
			for (int i = 0; i < Team.MAX_GOALKEEPERS; i++) {
				team.modifyPlayer(team.getPlayers()[i].getShirtNumber(),
				                  team.getPlayers()[i].getShirtNumber(), "New name",
				                  Position.GOALKEEPER, 1970, 1.80, 75);
			}
		} catch (Exception e) {
			fail("No exception should be thrown when the number of goalkeepers is below the max.");
		}
		
		try {
			team.modifyPlayer(team.getPlayers()[11].getShirtNumber(),
			                  team.getPlayers()[11].getShirtNumber(), "New name",
			                  Position.GOALKEEPER, 1970, 1.80, 75);
			fail("No goalkeepers should be added after the team has reached the maximum amount " +
				     "of goalkeepers.");
		} catch (Exception e) {
			// Should throw exception.
		}
		
		// Test case 6
		setupScenario1();
		
		try {
			for (int i = 0; i < Team.MAX_DEFENDERS; i++) {
				team.modifyPlayer(team.getPlayers()[i].getShirtNumber(),
				                  team.getPlayers()[i].getShirtNumber(), "New name",
				                  Position.DEFENDER, 1970, 1.80, 75);
			}
		} catch (Exception e) {
			fail("No exception should be thrown when the number of defenders is below the max.");
		}
		
		try {
			team.modifyPlayer(team.getPlayers()[11].getShirtNumber(),
			                  team.getPlayers()[11].getShirtNumber(), "New name",
			                  Position.DEFENDER, 1970, 1.80, 75);
			fail("No defenders should be added after the team has reached the maximum amount " +
				     "of defenders.");
		} catch (Exception e) {
			// Should throw exception.
		}
		
		// Test case 7
		
		setupScenario1();
		
		try {
			for (int i = 0; i < Team.MAX_STRIKERS; i++) {
				team.modifyPlayer(team.getPlayers()[i].getShirtNumber(),
				                  team.getPlayers()[i].getShirtNumber(), "New name",
				                  Position.STRIKER, 1970, 1.80, 75);
			}
		} catch (Exception e) {
			fail("No exception should be thrown when the number of strikers is below the max.");
		}
		
		try {
			team.modifyPlayer(team.getPlayers()[11].getShirtNumber(),
			                  team.getPlayers()[11].getShirtNumber(), "New name",
			                  Position.STRIKER, 1970, 1.80, 75);
			fail("No strikers should be added after the team has reached the maximum amount " +
				     "of strikers.");
		} catch (Exception e) {
			// Should throw exception.
		}
		
	}
	
	/**
	 * <b>Test:</b> Verifies the method countCardsNotPasted.<br>
	 * <b>Method to test:</b><br>
	 * countCardsNotPasted<br>
	 * <b>Test cases:</b><br>
	 * 1. The team doesn't have any cards pasted. <br>
	 * 2. The team has some cards pasted.
	 */
	@Test
	public void testCountCardsNotPasted() {
		// Test case 1
		assertEquals("The team card should not be pasted.",
		             team.countCardsNotPasted(CardType.TEAM), 1);
		assertEquals("The crest card should not be pasted.",
		             team.countCardsNotPasted(CardType.CREST), 1);
		assertEquals("No player cards should be pasted.",
		             team.countCardsNotPasted(CardType.PLAYER), 12);
		
		// Test case 2
		try {
			team.pasteTeamCard();
			team.pasteCrestCard();
			team.pastePlayerCard(team.getPlayers()[0].getShirtNumber());
		} catch (Exception e) {
			fail("No exception should be thrown when pasting cards that have not been pasted " +
				     "yet.");
		}
		assertEquals("Team card should be pasted.", team.countCardsNotPasted
			(CardType.TEAM), 0);
		assertEquals("Crest card should be pasted.", team.countCardsNotPasted
			(CardType.CREST), 0);
		assertEquals("There should be one player card pasted.", team.countCardsNotPasted
			(CardType.PLAYER), 11);
	}
	
	/**
	 * <b>Test:</b> Verifies the method getMostCommonAge.<br>
	 * <b>Method to test:</b><br>
	 * getMostCommonAge<br>
	 * <b>Test cases:</b><br>
	 * 1. The predetermined age is the most common. <br>
	 * 2. after modifying the ages, the most common age is correct.
	 */
	@Test
	public void testGetMostCommonAge() {
		// Test case 1
		assertEquals("The most common age is incorrect.", team.getMostCommonAge(),
		             team.getYear() - 1990);
		Player[] players = team.getPlayers();
		for (int i = 0; i < players.length / 2 + 2; i++) {
			try {
				team.modifyPlayer(players[i].getShirtNumber(), players[i].getShirtNumber(),
				                  players[i].getName(), players[i].getPosition(), 1987, 1.80, 80);
			} catch (Exception e) {
				fail("No exception should be thrown when modifying this player.");
			}
		}
		assertEquals("The most common age is incorrect", team.getYear() - 1987,
		             team.getMostCommonAge());
	}
	
}






	
