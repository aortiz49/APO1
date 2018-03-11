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

import uniandes.cupi2.album.world.Card;
import uniandes.cupi2.album.world.Card.CardType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;

/**
 * Test class for cards in the album.
 */
public class CardTest {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Card on which the tests will be realized.
	 */
	private Card card;
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Prepare the card for the tests. <br>
	 * <b>post </b> A card is created for the tests.
	 */
	@Before
	public void setupScenario1() {
		card = new Card(CardType.PLAYER, "elPibe.png");
	}
	
	/**
	 * <b>Test</b> Verifies the constructor method and the methods getImageName and getCardType.<br>
	 * <b>Methods to test</b><br>
	 * Card<br>
	 * getImageName<br>
	 * getCardType<br>
	 * <b>Test cases</b><br>
	 * Card information is returned. .
	 */
	@Test
	public void testCard() {
		assertTrue("The name of the image is incorrect.", card.getImageName().equals(
				"elPibe" + ".png"));
		assertTrue("The card type is incorrect.", card.getCardType() == CardType.PLAYER);
	}
	
}