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

import uniandes.cupi2.vendingMachine.world.Product.Types;

/*
 * Represents the vending machine.
 */
public class VendingMachine {
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	// Products 1-4 of the vending machine.
	private Product product1;
	
	private Product product2;
	
	private Product product3;
	
	private Product product4;
	
	// Available credit in machine.
	private Amount credit;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/*
	 * Constructs a new vending machine.
	 *
	 * Credit is initialized to 0.
	 * The 4 products are created with their initial values.
	 */
	public VendingMachine() {
		product1 = new Product("A1", "Papas Natural Margarita", 1300, true, Types.FOOD);
		product2 = new Product("A2", "Jugo Hit", 2000, true, Types.DRINK);
		product3 = new Product("B1", "Chocolatina Jet", 450, false, Types.FOOD);
		product4 = new Product("B2", "Galletas Festival", 800, false, Types.FOOD);
		credit = new Amount();
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	// Returns the amount of credit available in the machine.
	public double getCreditValue() {
		return credit.getTotalValue();
	}
	
	/*
	 * Returns the product with the identifier received by the parameter.
	 *
	 * pIdentifier: Identifier of product being searched. pIdentifier != null && pIdentifier != "".
	 */
	public Product getProduct(String pIdentifier) {
		Product tempProduct = null;
		
		if (product1.getIdentifier().equals(pIdentifier))
			tempProduct = product1;
		else if (product2.getIdentifier().equals(pIdentifier))
			tempProduct = product2;
		else if (product3.getIdentifier().equals(pIdentifier))
			tempProduct = product3;
		else if (product4.getIdentifier().equals(pIdentifier))
			tempProduct = product4;
		
		return tempProduct;
		
	}
	
	/*
	 * Adds a coin to the machine credit.
	 * pCoin: Denomination of the coin. pCoin = { Amount.COIN_50, Amount.COIN_100,
	 * Amount.COIN_200, Amount.COIN_500 ,Amount.COIN_1000}.
	 *
	 * Returns True if coin was added, false if amount exceeds maximum value.
	 */
	public boolean addCoin(int pCoin) {
		return credit.addCoin(pCoin);
		
	}
	
	/*
	 * Purchases one unit of the product given by the identifier parameter.
	 *
	 * If there is enough credit and there are enough units in stock, the purchase is made and the
	 * current credit is modified.
	 * pIdentifier: Identifier of product. pIdentifier != null && pIdentifier
	 * != "".
	 *
	 * Returns true if the purchase was made, false if there is no credit or no available units in
	 * stock of the product.
	 */
	public boolean purchaseProduct(String pIdentifier) {
		boolean purchaseMade = false;
		Product tempProduct = getProduct(pIdentifier);
		
		// purchase() returns true if the quantity of units available is > 0. If first condition
		// is not met, the second condition will not be evaluated. Therefore, even if there are
		// units available, if the credit is not enough it will not sell the item. (short-circuit
		// evaluation). If the purchase is possible, it occurs within the if statement.
		if ((getCreditValue() >= tempProduct.getPrice()) && tempProduct.purchase()) {
			purchaseMade = true;
			
			// To calculate the change, subtract the price of the product from the current credit.
			credit.changeValue(getCreditValue() - tempProduct.getPrice());
		}
		
		return purchaseMade;
		
	}
	
	/*
	 * Terminates the purchase and returns change.
	 * Calculates the amount of money that should be returned and resets the credit.
	 *
	 * Returns amount of money corresponding to the change.
	 */
	public Amount terminatePurchase() {
		Amount change = new Amount();
		change.changeValue(credit.getTotalValue());
		credit.reset();
		return change;
	}
	
	/*
	 * Calculates the quantity of units purchased from the machine.
	 *
	 * Returns Total quantity of units purchased.
	 */
	public int getTotalQuantityOfUnitsPurchased() {
		return product1.getQuantityOfUnitsPurchased() + product2.getQuantityOfUnitsPurchased() +
				product3.getQuantityOfUnitsPurchased() + product4.getQuantityOfUnitsPurchased();
		
	}
	
	/*
	 * Calculates the total value of purchases from the machine.
	 *
	 * Returns Total value of units purchased.
	 */
	public double getValueTotalPurchases() {
		return product1.getQuantityOfUnitsPurchased() * product1.getPrice() +
				product2.getQuantityOfUnitsPurchased() * product2.getPrice() +
				product3.getQuantityOfUnitsPurchased() * product3.getPrice() +
				product4.getQuantityOfUnitsPurchased() * product4.getPrice();
		
	}
	
	/* Calculates the percent of product availability of the machine.
	 * Returns the availability.
	 */
	public double getPercentAvailability() {
		return (100 - (((product1.getQuantityOfUnitsAvailable() +
				product2.getQuantityOfUnitsAvailable() + product3.getQuantityOfUnitsAvailable() +
				product4.getQuantityOfUnitsAvailable()) / (Product.CAPACITY * 4.0))) * 100);
	}
	
	/*
	 * Returns the total value of FOPRE donations of the specified product type.
	 *
	 * pType: Type of product of interest. pType belongs to {Type.DRINK , Type.FOOD}.
	 *
	 * Returns total value donations to FOPRE per type.
	 */
	public double getDonationsPerType(Types pType) {
		double donations = 0;
		
		if (product1.getType().equals(pType))
			donations = product1.calculateFopreDonation();
		if (product2.getType().equals(pType))
			donations += product2.calculateFopreDonation();
		if (product3.getType().equals(pType))
			donations += product3.calculateFopreDonation();
		if (product4.getType().equals(pType))
			donations += product4.calculateFopreDonation();
		
		return donations;
		
	}
	
	/*
	 * Returns the total FOPRE units purchased of a specific type.
	 *
	 * pType: Type of product of interest. pType belongs to  {Type.DRINK , Type.FOOD}.
	 *
	 * Returns the sum of FOPRE units purchased per type.
	 */
	public int getQuantityOfFopreUnitsPurchased(Types pType) {
		int fopreUnits = 0;
		
		if (product1.getType().equals(pType) && product1.isFopre())
			fopreUnits = product1.getQuantityOfUnitsPurchased();
		if (product2.getType().equals(pType) && product2.isFopre())
			fopreUnits += product2.getQuantityOfUnitsPurchased();
		if (product3.getType().equals(pType) && product3.isFopre())
			fopreUnits += product3.getQuantityOfUnitsPurchased();
		if (product4.getType().equals(pType) && product4.isFopre())
			fopreUnits += product4.getQuantityOfUnitsPurchased();
		
		return fopreUnits;
		
	}
	
	/*
	 * Returns most purchased product.
	 *
	 * If there are two products with the most units sold, the 1st one found is returned.
	 */
	public Product getMostPurchasedProduct() {
		Product mostSold = null;
		// Declare temporary variable.
		int largest = 0;
		
		int sold1 = product1.getQuantityOfUnitsPurchased();
		int sold2 = product2.getQuantityOfUnitsPurchased();
		int sold3 = product3.getQuantityOfUnitsPurchased();
		int sold4 = product4.getQuantityOfUnitsPurchased();
		
		if (sold1 > largest) {
			largest = sold1;
			mostSold = product1;
		}
		
		if (sold2 > largest) {
			largest = sold2;
			mostSold = product2;
		}
		
		if (sold3 > largest) {
			largest = sold3;
			mostSold = product3;
		}
		
		if (sold4 > largest) {
			mostSold = product4;
		}
		
		return mostSold;
	}
	
	/*
	 * Returns total FOPRE donations.
	 */
	public double getTotalDonations() {
		return product1.calculateFopreDonation() + product2.calculateFopreDonation() +
				product3.calculateFopreDonation() + product4.calculateFopreDonation();
	}
	
	// -----------------------------------------------------------------
	// Extension Points
	// -----------------------------------------------------------------
	
	// Extension 1.
	public String method1() {
		return "Response 1";
	}
	
	// Extension 2.
	public String method2() {
		return "Response 2";
	}
}
