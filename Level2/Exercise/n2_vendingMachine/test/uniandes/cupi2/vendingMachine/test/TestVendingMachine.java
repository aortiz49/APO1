/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n2_VendingMachine
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.test;

import uniandes.cupi2.vendingMachine.world.Amount;
import uniandes.cupi2.vendingMachine.world.Product;
import uniandes.cupi2.vendingMachine.world.VendingMachine;

// Each method is isolated in that a new instance of VendingMachine is used in each method.
public class TestVendingMachine {
	
	public static void main(String[] args) {
		// Testing constructor.
		System.out.println("Testing VendingMachine() and getProduct(): ");
		testConstructor();
		
		// Testing addCoin.
		System.out.println("Testing addCoin() and creditValue(): ");
		testAddCoin();
		
		// Testing purchaseProduct.
		System.out.println("Testing addCoin(), creditValue(), and purchaseProduct(): ");
		testPurchaseProduct();
		
		// Testing terminatePurchase
		System.out.println("Testing terminatePurchase(): ");
		testTerminatePurchase();
		
		// Testing getTotalQuantityOfUnitsSPurchased, getValueTotalPurchases,
		// getPercentAvailability, getDonationsPerType, getQuantityOfFopreUnitsAvailable,
		// getMostPurchasedProduct, and getTotalDonations.
		System.out.println("Testing all sales information methods: ");
		testSalesInformation();
		
	}
	
	
	private static void testConstructor() {
		VendingMachine newMachine = new VendingMachine();
		System.out.print("Products in vending machine: \n");
		System.out.println("Product 1: " + newMachine.getProduct("A1").getName());
		System.out.println("Product 2: " + newMachine.getProduct("A2").getName());
		System.out.println("Product 3: " + newMachine.getProduct("B1").getName());
		System.out.println("Product 4: " + newMachine.getProduct("B2").getName());
		System.out.println("\n===================================================");
		
	}
	
	private static void testAddCoin() {
		VendingMachine newMachine = new VendingMachine();
		
		System.out.println("Adding two of each coin.");
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_500);
		newMachine.addCoin(Amount.COIN_200);
		newMachine.addCoin(Amount.COIN_100);
		newMachine.addCoin(Amount.COIN_50);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_500);
		newMachine.addCoin(Amount.COIN_200);
		newMachine.addCoin(Amount.COIN_100);
		newMachine.addCoin(Amount.COIN_50);
		
		System.out.println("Total quantity of coins in credit: " + newMachine.getCreditValue());
		System.out.println("\n===================================================");
		
	}
	
	private static void testPurchaseProduct() {
		VendingMachine newMachine = new VendingMachine();
		newMachine.addCoin(Amount.COIN_1000);
		System.out.println("Adding one $1000 coin.");
		System.out.println("Trying to buy product1 with " + newMachine.getCreditValue() + " " +
			                   "credit");
		System.out.println("Price and name of product1: " + newMachine.getProduct("A1").getName()
			                   + " || " + newMachine.getProduct("A1").getPrice());
		System.out.println("Product1 was purchased: " + newMachine.purchaseProduct("A1"));
		System.out.println("Quantity of products purchased: ");
		System.out.println("Product1: " +
			                   newMachine.getProduct("A1").getQuantityOfUnitsPurchased());
		
		
		System.out.println("Current machine credit is: " + newMachine.getCreditValue());
		System.out.println("");
		System.out.println("Adding another $1000 coin.");
		newMachine.addCoin(Amount.COIN_1000);
		System.out.println("Trying to buy product1 with " + newMachine.getCreditValue() + " " +
			                   "credit");
		System.out.println("Price and name of product1: " + newMachine.getProduct("A1").getName()
			                   + " || " + newMachine.getProduct("A1").getPrice());
		System.out.println("Product1 was purchased: " + newMachine.purchaseProduct("A1"));
		System.out.println("");
		System.out.println("Trying to buy product1 with " + newMachine.getCreditValue() + " " +
			                   "credit");
		System.out.println("Price and name of product1: " + newMachine.getProduct("A1").getName()
			                   + " || " + newMachine.getProduct("A1").getPrice());
		System.out.println("Product1 was purchased: " + newMachine.purchaseProduct("A1") + " " +
			                   "because " + newMachine.getCreditValue() + " credit " +
			                   "value is < " + newMachine.getProduct("A1").getPrice() + " " +
			                   "product" + " price");
		System.out.println("\n");
		System.out.println("Adding $9300 credit to the machine.");
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_100);
		newMachine.addCoin(Amount.COIN_100);
		newMachine.addCoin(Amount.COIN_100);
		System.out.println("Current credit: " + newMachine.getCreditValue() + " " +
			                   "credit");
		System.out.println("Buying units of product2.");
		System.out.println("Number of product2 units available before purchase: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsAvailable());
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("A2");
		System.out.println("Number of product2 units purchased: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsPurchased());
		System.out.println("Number of product2 units available after purchase: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsAvailable());
		
		System.out.println("\n");
		System.out.println("Adding $10000 credit to the machine.");
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		
		System.out.println("Current credit: " + newMachine.getCreditValue() + " " +
			                   "credit");
		System.out.println("Buying units of product2.");
		System.out.println("Number of product2 units available before purchase: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsAvailable());
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("A2");
		System.out.println("Number of product2 units purchased: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsPurchased());
		System.out.println("Number of product2 units available after purchase: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsAvailable());
		
		System.out.println("\n");
		System.out.println("Adding $2000 credit to the machine.");
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		System.out.println("Product2 was purchased: " + newMachine.purchaseProduct("A2") +
			                   " because " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsAvailable() + " " +
			                   "units" + " are available.");
		System.out.println("\n===================================================");
		
	}
	
	private static void testTerminatePurchase() {
		VendingMachine newMachine = new VendingMachine();
		
		System.out.println("Adding 4 $1000 coins");
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		
		System.out.println("Current credit: " + newMachine.getCreditValue());
		System.out.println("");
		System.out.println("Purchase 1 unit of product3.");
		newMachine.purchaseProduct("B1");
		System.out.println("Number of product3 units purchased: " +
			                   newMachine.getProduct("B1").getQuantityOfUnitsPurchased());
		System.out.println("Number of product3 units available after purchase: " +
			                   newMachine.getProduct("B1").getQuantityOfUnitsAvailable());
		System.out.println("Current credit: " + newMachine.getCreditValue());
		
		System.out.println("Terminate the purchase!");
		System.out.println("Amount of change returned: " +
			                   newMachine.terminatePurchase().getTotalValue());
		System.out.println("Current credit: " + newMachine.getCreditValue());
		System.out.println("\n===================================================");
		
	}
	
	private static void testSalesInformation() {
		VendingMachine newMachine = new VendingMachine();
		
		System.out.println("Adding $10000 of credit.");
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		System.out.println("Current credit: " + newMachine.getCreditValue());
		System.out.println();
		
		System.out.println("Purchase one unit of each product.");
		
		newMachine.purchaseProduct("A1");
		newMachine.purchaseProduct("A2");
		newMachine.purchaseProduct("B1");
		newMachine.purchaseProduct("B2");
		System.out.println("Quantity of products purchased: ");
		System.out.println("Product1: " +
			                   newMachine.getProduct("A1").getQuantityOfUnitsPurchased());
		System.out.println("Product2: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsPurchased());
		System.out.println("Product3: " +
			                   newMachine.getProduct("B1").getQuantityOfUnitsPurchased());
		System.out.println("Product4: " +
			                   newMachine.getProduct("B2").getQuantityOfUnitsPurchased());
		
		System.out.println("Current credit: " + newMachine.getCreditValue());
		System.out.println("Most-purchased product: " + newMachine.getMostPurchasedProduct()
			.getName());
		System.out.println("In this case, since all products have 1 unit purchased the code will" +
			                   " " +
			                   "pick the 1st one.");
		System.out.println();
		
		System.out.println("Purchase one unit of product1 and product2 each.");
		newMachine.purchaseProduct("A1");
		newMachine.purchaseProduct("A2");
		System.out.println("Quantity of products purchased: ");
		System.out.println("Product1: " +
			                   newMachine.getProduct("A1").getQuantityOfUnitsPurchased());
		System.out.println("Product2: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsPurchased());
		System.out.println("Product3: " +
			                   newMachine.getProduct("B1").getQuantityOfUnitsPurchased());
		System.out.println("Product4: " +
			                   newMachine.getProduct("B2").getQuantityOfUnitsPurchased());
		System.out.println("Current credit: " + newMachine.getCreditValue());
		System.out.println("");
		System.out.println("Adding $2000 of credit.");
		newMachine.addCoin(Amount.COIN_1000);
		newMachine.addCoin(Amount.COIN_1000);
		System.out.println("Current credit: " + newMachine.getCreditValue());
		System.out.println("Purchase four units of product4.");
		newMachine.purchaseProduct("B2");
		newMachine.purchaseProduct("B2");
		newMachine.purchaseProduct("B2");
		newMachine.purchaseProduct("B2");
		System.out.println("Quantity of products purchased: ");
		System.out.println("Product1: " +
			                   newMachine.getProduct("A1").getQuantityOfUnitsPurchased());
		System.out.println("Product2: " +
			                   newMachine.getProduct("A2").getQuantityOfUnitsPurchased());
		System.out.println("Product3: " +
			                   newMachine.getProduct("B1").getQuantityOfUnitsPurchased());
		System.out.println("Product4: " +
			                   newMachine.getProduct("B2").getQuantityOfUnitsPurchased());
		System.out.println("Current credit: " + newMachine.getCreditValue());
		System.out.println();
		System.out.println();
		
		System.out.println("Total quantity of products sold: " +
			                   newMachine.getTotalQuantityOfUnitsPurchased());
		System.out.println("Total value of products sold: " + newMachine.getValueTotalPurchases());
		System.out.println("Most-purchased product: " +
			                   newMachine.getMostPurchasedProduct().getName());
		
		
		System.out.println("Percent availability: " + newMachine.getPercentAvailability());
		System.out.println("Fopre donations for FOOD: " +
			                   newMachine.getDonationsPerType(Product.Types.FOOD));
		System.out.println("Fopre donations for DRINK: " +
			                   newMachine.getDonationsPerType(Product.Types.DRINK));
		System.out.println("Total quantity of Fopre units available for FOOD: " + newMachine
			.getQuantityOfFopreUnitsPurchased(Product.Types.FOOD));
		System.out.println("Total quantity of Fopre units available for DRINK: " + newMachine
			.getQuantityOfFopreUnitsPurchased(Product.Types.DRINK));
		System.out.println("Total donations: " + newMachine.getTotalDonations());
		System.out.println("\n===================================================");
		
	}
	
}
