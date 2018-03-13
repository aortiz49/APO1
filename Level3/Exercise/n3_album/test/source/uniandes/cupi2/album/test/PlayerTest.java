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

import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Positions;
import uniandes.cupi2.album.world.Card.CardType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;

/**
 * Test class for the player.
 */
public class PlayerTest {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Player on which the tests will be realized.
	 */
	private Player player;
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Prepare the player for the tests. <br>
	 * <b>post </b> A player is created for the tests.
	 */
	@Before
	public void setupScenario1() {
		player = new Player(10, "Carlos Valderrama", Positions.STRIKER, 1961, 1.75, 70);
	}
	
	/**
	 * <b>Test</b> Verifies the constructor method and the methods that return the attributes.<br>
	 * <b>Methods to test</b><br>
	 * Player<br>
	 * getShirtNumber<br>
	 * getName<br>
	 * getPosition<br>
	 * getBirthYear<br>
	 * getHeight<br>
	 * getWeight<br>
	 * <b>Test Cases</b><br>
	 * Tests that a player is created and that all the correct information is returned.
	 */
	@Test
	public void testPlayer() {
		assertTrue("Incorrect shirt number.", player.getShirtNumber()	== 10);
		assertTrue("Incorrect name.", player.getName().equals("Carlos Valderrama"));
		assertTrue("Incorrect position.", player.getPosition() == Positions.STRIKER);
		assertTrue("Incorrect birth year.", player.getBirthYear() == 1961);
		assertTrue("Incorrect height.", player.getHeight() == 1.75);
		assertTrue("Incorrect weight.", player.getWeight() == 70);
	}
	
	/**
	 * <b>Test</b> Verifies the method modifyPlayer.<br>
	 * <b>Methods to test</b><br>
	 * modify<br>
	 * getShirtNumber<br>
	 * getName<br>
	 * getPosition<br>
	 * getBirthYear<br>
	 * getHeight<br>
	 * getWeight<br>
	 * <b>Test Cases</b><br>
	 * Tests to see if the new player information is correct.
	 */
	@Test
	public void testModifyPlayer() {
		player.modifyPlayer(11, "Juan Guillermo Cuadrado", Positions.WINGER, 1988, 1.78, 71);
		assertTrue("Incorrect shirt number.", player.getShirtNumber() == 11);
		assertTrue("Incorrect name.", player.getName().equals("Juan Guillermo Cuadrado"));
		assertTrue("Incorrect position.", player.getPosition() == Positions.WINGER);
		assertTrue("Incorrect birth year.", player.getBirthYear() == 1988);
		assertTrue("Incorrect height.", player.getHeight() == 1.78);
		assertTrue("Incorrect weight.", player.getWeight() == 71);
	}
	
	/**
	 * <b>Test</b> Verifies the method pasteCard.<br>
	 * <b>Methods to test</b><br>
	 * getCard<br>
	 * hasCard<br>
	 * pasteCard<br>
	 * <b>Test Cases</b><br>
	 * 1. The player doesn't have a card. <br>
	 * 2. The player has a card.
	 */
	@Test
	public void testPasteCard() {
		assertTrue("The player should not have a card upon being created",
		           player.getCard() == null);
		assertTrue("The player should not have a card upon being created.", !player.hasCard());
		player.pasteCard();
		assertTrue("The player should have a card.", player.getCard() != null);
		assertTrue("The player should have a card.", player.hasCard());
		assertTrue("The name of the card is not correct", player.getCard().getImageName()
                .equals("10_CarlosValderrama.png"));
		assertTrue("The type of card is not correct", player.getCard().getCardType() ==
                CardType.PLAYER);
	}
	
}