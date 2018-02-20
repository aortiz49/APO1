/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n2_VendingMachine
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.world;

/*
 * Represents a product from he vending machine
 */
public class Product {
	
	// -----------------------------------------------------------------
	// Enums
	// -----------------------------------------------------------------
	
	/*
	 * Enum that defines the types of products that can exist.
	 */
	public enum Types {
		DRINK,
		FOOD
	}
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	// Constant that represents the donation percentage to FOPRE.
	public final static double FOPRE_PERCENTAGE = 0.06;
	
	// Constant that represents the maximum quantity of units that a product can have.
	public final static int CAPACITY = 10;
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	// Type of product.
	private Types type;
	
	// Attribute that indicates if the product donates a portion of its profit to the FOPRE
	// program.
	private boolean fopre;
	
	// Product identifier.
	private String identifier;
	
	// Product name.
	private String name;
	
	// Product price.
	private double price;
	
	// Quantity of units available.
	private int quantityOfUnitsAvailable;
	
	// Quantity of units purchased.
	private int quantityOfUnitsPurchased;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/*
	 * Creates a product using the information received by the parameters.
	 *
	 * Quantity of units purchased initialized to 0.
	 * Quantity of units available initialized to its capacity.
	 * identifier, name, price, fopre and typo were initialized with the values received by the
	 * parameters.
	 *
	 * pIdentifier: Product identifier. pIdentifier != null && pIdentifier != "".
	 * pName: Name del product. pName != null && pName != "".
	 * pPrice: Price of the product. pPrice >= 50.
	 * pFopre: Indicates if the product donates a portion of its profit to the FOPRE program.
	 * pType: Type of product. pType belongs to a {Type.DRINK , Type.FOOD}.
	 */
	public Product(String pIdentifier, String pName, double pPrice, boolean pFopre, Types pTypes) {
		quantityOfUnitsPurchased = 0;
		quantityOfUnitsAvailable = CAPACITY;
		identifier = pIdentifier;
		name = pName;
		price = pPrice;
		fopre = pFopre;
		type = pTypes;
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	// Returns product identifier.
	public String getIdentifier() {
		return identifier;
	}
	
	// Returns product name.
	public String getName() {
		return name;
	}
	
	// Returns product price.
	public double getPrice() {
		return price;
	}
	
	// Returns quantity of units available.
	public int getQuantityOfUnitsAvailable() {
		return quantityOfUnitsAvailable;
	}
	
	// Returns quantity of units purchased.
	public int getQuantityOfUnitsPurchased() {
		return quantityOfUnitsPurchased;
	}
	
	// Returns type of product.
	public Types getType() {
		return type;
	}
	
	// Returns true if the product donates a portion of its profit to the FOPRE program.
	public boolean isFopre() {
		return fopre;
	}
	
	/*
	 * Purchases one unit of the product if there are units available.
	 *
	 * If there are units available, quantity of units available is decreased by 1 and the
	 * quantity of units purchased is increased by 1.
	 *
	 * Returns true if a purchase was made, false in case there is no availability of the product.
	 */
	public boolean purchase() {
		boolean purchaseMade = false;
		if (getQuantityOfUnitsAvailable() > 0) {
			quantityOfUnitsAvailable--;
			quantityOfUnitsPurchased++;
			purchaseMade = true;
		}
		return purchaseMade;
	}
	
	/*
	 * Calculates the value of the donation of the product to fopre.
	 * Return: Donation to fopre.
	 */
	public double calculateFopreDonation() {
		double fopreDonation = 0;
		if (isFopre())
			fopreDonation = getQuantityOfUnitsPurchased() * getPrice() * FOPRE_PERCENTAGE;
		
		return fopreDonation;
		
	}
	
}
