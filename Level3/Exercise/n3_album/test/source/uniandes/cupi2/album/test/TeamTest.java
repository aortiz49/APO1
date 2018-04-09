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
	 * Team on which the tests will be realized.
	 */
	private Team team;
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Prepare the team for the tests. <br>
	 * <b>post </b> A team is created for the tests.
	 */
	@Before
	public void setupScenario1() {
		team = new Team("Colombia", 2018);
	}
	
	/**
	 * <b>Test:</b> Verifies the constructor method and the methods that return the country and
	 * year <br>
	 * <b>Methods to test:</b><br>
	 * Team<br>
	 * getCountry<br>
	 * getYear<br>
	 * getPlayers<br>
	 * <b>Test Cases:</b><br>
	 * Creates and returns team information. The team was created properly.
	 */
	@Test
	public void testTeam() {
		assertTrue("The country is not correct.", team.getCountry().equals("Colombia"));
		assertTrue("The year is not correct.", team.getYear() == 2018);
		assertTrue("List of players was not initialized.", team.getPlayers() != null);
		assertTrue("The size of the players is not correct.", team.getPlayers().length
				== Team.QUANTITY_OF_PLAYERS);
		for(int i = 0; i < team.getPlayers().length; i++) {
			assertTrue("The default player position is not correct.",
			           team.getPlayers()[i].getPosition() == Position.UNKNOWN);
		}
		for(int i = 0; i < team.getPlayers().length; i++) {
			assertTrue("The shirt number is not correct.",
			           team.getPlayers()[i].getShirtNumber() == -(i+1));
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method findPlayer.<br>
	 * <b>Methods to test:</b><br>
	 * findPlayer<br>
	 * <b>Test Cases:</b><br>
	 * 1. A player is searched with a shirt number that doesn't exist.
	 * 2. Searches all players by their shirt number.
	 */
	@Test
	public void testFindPlayer() {
		assertNull("There should not exist a player with this shirt number.",
		           team.findPlayer(-50));
		for(int i = 0; i < team.getPlayers().length; i++) {
			assertNotNull("The player should exist.",
			              team.findPlayer(team.getPlayers()[i].getShirtNumber()));
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method modifyPlayer.<br>
	 * <b>Methods to test:</b><br>
	 * modifyPlayer<br>
	 * <b>Test Cases:</b><br>
	 * 1. Player is not modified if the new and old shirt numbers don't coincide and the the player
	 * with the specified new shirt number already exists.
	 * 2. Player is modified if a player with the specified new shirt number doesn't exist.
	 * 3. Player is modified if a player with the specified new shirt number exists and the new
	 * and old shirt numbers coincide.
	 */
	@Test
	public void testModifyPlayer() {
		Player playerToModify = team.getPlayers()[0];
		Player playerToModify1 = team.getPlayers()[1];
		
		assertFalse("The player must not be modified when the new and old shirt numbers don't " +
				            "coincide and the the player with the specified new shirt number " +
				            "already exists.",
		            team.modifyPlayer(playerToModify1.getShirtNumber(),
		                              playerToModify.getShirtNumber(), "New name",
		                              Position.GOALKEEPER, 1970, 1.80, 75));
		
		assertTrue("Player should have been modified because a player with the specified new " +
				           "shirt" +
				           " number doesn't exist",
		           team.modifyPlayer(playerToModify.getShirtNumber(), 25, "New Name",
		                             Position.GOALKEEPER, 1970, 1.80, 75));
		
		assertTrue("Player should have been modified because player with the specified new shirt" +
				           " " +
				           "number exists and the new and old shirt numbers coincide.",
		           team.modifyPlayer(playerToModify.getShirtNumber(),
		                             playerToModify.getShirtNumber(), "New Name",
		                             Position.GOALKEEPER, 1970, 1.80, 75));
		
	}
	
	/**
	 * <b>Test:</b> Verifies the method pasteTeamCard.<br>
	 * <b>Methods to test:</b><br>
	 * getTeamCard<br>
	 * pasteTeamCard<br>
	 * <b>Test Cases:</b><br>
	 * 1. Team doesn't have a card yet.  <br>
	 * 2. Team does have a card. <br>
	 * 3. Card is not pasted since it already exists.
	 */
	@Test
	public void testPasteTeamCard() {
		assertNull("Team card should not exist since team was just created.", team.getTeamCard());
		assertTrue("Card should have been pasted since it didn't have one", team.pasteTeamCard());
		assertNotNull("Card should exist since the card was pasted", team.getTeamCard());
		assertFalse("Card should not have been pasted since it was already pasted",
		            team.pasteTeamCard());
	}
	
	/**
	 * <b>Test:</b> Verifies the method pasteCrestCard.<br>
	 * <b>Methods to test:</b><br>
	 * getCrestCard<br>
	 * pasteCrestCard<br>
	 * <b>Test Cases:</b><br>
	 * 1. Crest doesn't have a card yet.  <br>
	 * 2. Crest does have a card. <br>
	 * 3. Card is not pasted since it already exists.
	 */
	@Test
	public void testPasteCrestCard() {
		assertNull("Crest card should not exist since team was just created.",
		           team.getCrestCard());
		assertTrue("Card should have been pasted since it didn't have one.", team.pasteCrestCard
				());
		assertNotNull("Card should exist since the card was pasted.", team.getCrestCard());
		assertFalse("Card should not have been pasted since it was already pasted.",
		            team.pasteCrestCard());
	}
	
	/**
	 * <b>Test:</b> Verifies the method pastePlayerCard.<br>
	 * <b>Methods to test:</b><br>
	 * pastePlayerCard<br>
	 * <b>Test Cases:</b><br>
	 * 1. Player doesn't have a card yet.  <br>
	 * 2. Player does have a card. <br>
	 * 3. Card is not pasted since it already exists.
	 */
	@Test
	public void testPastePlayerCard() {
		Player player = team.getPlayers()[0];
		assertNull("Player card should not exist since player was just created.", player.getCard
				());
		assertTrue("Card should have been pasted because it didn't have one.",
		           team.pastePlayerCard(player.getShirtNumber()));
		player = team.getPlayers()[0];
		assertNotNull("Card should exist since the card was pasted.", player.getCard());
		assertFalse("Card should not have been pasted since it was already pasted.", team
				.pastePlayerCard
						(player.getShirtNumber()));
	}
	
	/**
	 * <b>Test:</b> Verifies the method countCardsNotPasted.<br>
	 * <b>Methods to test:</b><br>
	 * countCardsNotPasted<br>
	 * <b>Test Cases:</b><br>
	 * 1. All cards are counted upon creating a new team. <br>
	 * 2. Quantity of cards is modified upon pasting a few.
	 */
	@Test
	public void testCountCardsNotPasted() {
		assertEquals("Team card should not be pasted.", team.countCardsNotPasted
				(CardType.TEAM), 1);
		assertEquals("Crest card should not be pasted.", team.countCardsNotPasted
				(CardType.CREST), 1);
		assertEquals("No player cards should be pasted.",
		             team.countCardsNotPasted(CardType.PLAYER), 12);
		team.pasteTeamCard();
		team.pasteCrestCard();
		team.pastePlayerCard(team.getPlayers()[0].getShirtNumber());
		team.pastePlayerCard(team.getPlayers()[1].getShirtNumber());
		assertEquals("Team card should be pasted.", team.countCardsNotPasted
				(CardType.TEAM), 0);
		assertEquals("Crest card should be pasted.", team.countCardsNotPasted
				(CardType.CREST), 0);
		assertEquals("2 player cards should be pasted.", team.countCardsNotPasted
				(CardType.PLAYER), 10);
	}
	
	/**
	 * <b>Test:</b> Verifies the method getMostCommonAge.<br>
	 * <b>Methods to test:</b><br>
	 * getMostCommonAge<br>
	 * <b>Test Cases:</b><br>
	 * 1. Returns the most common age predetermined.
	 * <br>
	 * 2. Most common age is modified that new age is obtained. S
	 */
	@Test
	public void testDarMostCommonAge() {
		
		assertTrue("The age is not correct.", team.getMostCommonAge() == team.getYear() - 1990);
		Player[] players = team.getPlayers();
		for(int i = 0; i < players.length - 4; i++) {
			Player player = players[i];
			team.modifyPlayer(player.getShirtNumber(), player.getShirtNumber(), player.getName()
					, player.getPosition(), 1950, player.getHeight(), player.getWeight());
		}
		assertTrue("The age is incorrect", team.getMostCommonAge() == team.getYear() - 1950);
	}
	
}