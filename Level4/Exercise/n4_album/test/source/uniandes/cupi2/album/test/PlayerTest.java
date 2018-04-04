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

import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Position;
import uniandes.cupi2.album.world.Card.CardType;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Test class for Player.
 */
public class PlayerTest {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Player on which the tests will be executed.
	 */
	private Player player;
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Prepare the player for the tests.  <br>
	 * <b>post: </b> A player was created for the tests.
	 */
	@Before
	public void setupScenario1() {
		player = new Player(10, "Carlos Valderrama", Position.STRIKER, 1961, 1.75, 70);
	}
	
	/**
	 * <b>Test:</b> Verifies the constructor method and the basic getter methods. <br>
	 * <b>Method to test:</b><br>
	 * Player<br>
	 * getShirtNumber<br>
	 * getName<br>
	 * getPosition<br>
	 * getBirthYear<br>
	 * getHeight<br>
	 * getWeight<br>
	 * getCard<br>
	 * <b>Test cases:</b><br>
	 * Tests if the player is created properly and returns all the information correctly.
	 */
	@Test
	public void testPlayer() {
		assertEquals("The shirt number is incorrect.", player.getShirtNumber(), 10);
		assertEquals("The name is incorrect.", player.getName(), "Carlos Valderrama");
		assertEquals("The position is incorrect.", player.getPosition(), Position.STRIKER);
		assertEquals("The birth year is incorrect.", player.getBirthYear(), 1961);
		assertEquals("The height is incorrect.", player.getHeight(), 1.75, 0);
		assertEquals("The weight is incorrect.", player.getWeight(), 70, 0);
		assertNull("The card should be null by default.", player.getCard());
	}
	
	/**
	 * <b>Test:</b> Verifies the method modifyPlayer.<br>
	 * <b>Method to test:</b><br>
	 * modifyPlayer<br>
	 * getShirtNumber<br>
	 * getName<br>
	 * getPosition<br>
	 * getBirthYear<br>
	 * getHeight<br>
	 * getWeight<br>
	 * getCard<br>
	 * <b>Test cases:</b><br>
	 * 1. The player doesn't have a card. <br>
	 * 2. The player has a card.
	 */
	@Test
	public void testModifyPlayer() {
		// Test case 1
		try {
			assertFalse("The player should not have a card by default.", player.hasCard());
			player.modifyPlayer(11, "Juan Guillermo Cuadrado", Position.WINGER, 1988, 1.78, 71);
		} catch (Exception e) {
			fail("No exception should be generated upon modifying the player.");
		}
		assertEquals("The shirt number is incorrect.", player.getShirtNumber(), 11);
		assertEquals("The name is incorrect.", player.getName(), "Juan Guillermo Cuadrado");
		assertEquals("The position is incorrect.", player.getPosition(), Position.WINGER);
		assertEquals("The birth year is incorrect.", player.getBirthYear(), 1988);
		assertEquals("The height is incorrect.", player.getHeight(), 1.78, 0);
		assertEquals("The weight is incorrect.", player.getWeight(), 71, 0);
		
		// Test case 2
		try {
			player.pasteCard();
			assertTrue("The player should have a card after pasting.", player.hasCard());
			player.modifyPlayer(11, "Juan Guillermo Cuadrado.", Position.WINGER, 1988, 1.78, 71);
			fail("Player should not be modified if he has a card.");
			
		} catch (Exception e) {
			// Should throw an exception.
			System.out.println("Trying to modify a player that has a card already pasted.");
			System.out.println(e.getMessage() + "\n");
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method pasteCard.<br>
	 * <b>Method to test:</b><br>
	 * getCard<br>
	 * hasCard<br>
	 * pasteCard<br>
	 * <b>Test cases:</b><br>
	 * 1. The player doesn't have a card. <br>
	 * 2. The player has a card.
	 */
	@Test
	public void testPasteCard() {
		// Test case 1
		
		try {
			player.pasteCard();
			
		} catch (Exception e) {
			fail("No exception should be thrown when pasting a card.");
		}
		assertNotNull("The player should have a card. (getCard)", player.getCard());
		assertTrue("The player should have a card. (hasCard)", player.hasCard());
		assertEquals("The name on the card is incorrect.", player.getCard().getImageName(),
		             "10.png");
		assertEquals("The type of card is incorrect.", player.getCard().getCardType(),
		             CardType.PLAYER);
		
		// Test case 2
		try {
			player.pasteCard();
			fail("The card should not be pasted when it is already pasted.");
			
		} catch (Exception e) {
			// Should throw an exception.
			System.out.println("Trying to paste a card that is already pasted.");
			System.out.println(e.getMessage() + "\n");
		}
	}
	
	/**
	 * <b>Test:</b> Verifies the method changeFavorite.<br>
	 * <b>Method to test:</b><br>
	 * changeFavorite<br>
	 * <b>Test cases:</b><br>
	 * 1. The player doesn't have a card. <br>
	 * 2. The card is a favorite. <br>.
	 * 3. The card is not a favorite.
	 */
	@Test
	public void testChangeFavorite() {
		// Test case 1
		try {
			player.changeFavorite();
			fail("Card should not be able to be changed to a favorite when it isn't pasted.");
			
		} catch (Exception e) {
			// Should generate an exception.
			System.out.println("Trying to change a card's favorite status when it isn't pasted.");
			System.out.println(e.getMessage() + "\n");
			
		}
		
		try {
			player.pasteCard();
		} catch (Exception e) {
			fail("No exception should be thrown when pasting a card.");
		}
		try {
			assertFalse("The card should not be a favorite by default.",
			            player.getCard().isFavorite());
			
			// Test case 2
			player.changeFavorite();
			assertTrue("The card should be a favorite.", player.getCard().isFavorite());
			
			// Test case 3
			player.changeFavorite();
			assertFalse("The card should not be a favorite.", player.getCard().isFavorite());
		} catch (Exception e) {
			fail("No exception should be thrown since the card is already pasted.");
		}
	}
	
}