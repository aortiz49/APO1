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

import uniandes.cupi2.album.world.Card;
import uniandes.cupi2.album.world.Card.CardType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;

/**
 * Test class for the album cards.
 */
public class CardTest {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Card on which the tests will be executed.
	 */
	private Card card;
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Prepares the card for the tests.<br>
	 * <b>post: </b> A card was created for a player.
	 */
	@Before
	public void setupScenario1() {
		card = new Card(CardType.PLAYER, "elPibe.png");
	}
	
	/**
	 * <b>Test:</b> Verifies the constructor method and the basic getter methods. <br>
	 * <b>Method to test:</b><br>
	 * Card<br>
	 * getImageName<br>
	 * getCardType<br>
	 * isFavorite<br>
	 * <b>Test cases:</b><br>
	 * Tests if the card is was properly and returns all the information correctly.
	 */
	@Test
	public void testCard() {
		assertEquals("The name of the image is not correct.", card.getImageName(), "elPibe.png");
		assertEquals("The type is not correct.", card.getCardType(), CardType.PLAYER);
		assertFalse("The card should not be a favorite by default.", card.isFavorite());
	}
	
	/**
	 * <b>Test:</b> Verify the method changeFavorite.<br>
	 * <b>Method to test:</b><br>
	 * changeFavorite<br>
	 * <b>Test cases:</b><br>
	 * 1. The card is a favorite.<br>
	 * 2. The card is not a favorite.
	 */
	@Test
	public void testChangeFavorite() {
		assertFalse("The card should not be a favorite by default.", card.isFavorite());
		
		// Test case 1
		card.changeFavorite();
		assertTrue("The card should be a favorite.", card.isFavorite());
		
		// Test case 2
		card.changeFavorite();
		assertFalse("The card should not be a favorite.", card.isFavorite());
	}
	
}