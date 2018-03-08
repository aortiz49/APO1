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

/**
 * Represents a card in the album.
 */
public class Card {
	
	// -----------------------------------------------------------------
	// Enums
	// -----------------------------------------------------------------
	
	/**
	 * Card types.
	 */
	public enum CardType{
		PLAYER,
		CREST,
		TEAM
	}
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Name of the image.
	 */
	private String imageName;
	
	/**
	 * Card type of the card.
	 */
	private CardType cardType;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs a new card.<br>
	 * <b> post: </b> Image name and card type attributes were initialized with the value given
	 * by the parameter. <br>
	 *
	 * @param pCardType  Card type of the card. pCardType belongs to {CardType.PLAYER,
	 *                   CardType.CREST, CardType.TEAM}.
	 * @param pImageName Name of the image. pImageName != null && pImageName != "".
	 */
	public Card(CardType pCardType, String pImageName) {
		cardType = pCardType;
		imageName = pImageName;
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns the name of the image of the card.
	 * @return Name of the image.
	 */
	public String getImageName() {
		return imageName;
	}
	
	/**
	 * Returns the card type of the card.
	 * @return Card type of the card.
	 */
	public CardType getCardType() {
		return cardType;
	}
	
}
