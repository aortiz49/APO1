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

import uniandes.cupi2.vendingMachine.world.Product;
import uniandes.cupi2.vendingMachine.world.Product.Types;

public class TestProduct {


    public static void main(String[] args) {

        // Test product constructor
        System.out.println("Testing: Product constructor \n");
        testProductConstructor();

        // Test product purchase
        System.out.println("Testing: Product constructor \n");
        testPurchase();

        // Test fopre donation
        System.out.println("Testing: fopre donation \n");
        testCalculateFopreDonation();

    }

    private static void testProductConstructor() {
        Product product1 = new Product("A1", "Orange Juice", 1500, true, Types.DRINK);
        Product product2 = new Product("B2", "Chips", 2000, true, Types.FOOD);
        Product product3 = new Product("C3", "Chocolate Bar", 500, false, Types.FOOD);
        Product product4 = new Product("D4", "Water", 1000, false, Types.DRINK);

        System.out.println("PRODUCTS IN STORE: \n");
        System.out.println("Product1 : ");
        System.out.println("Identifier: " + product1.getIdentifier());
        System.out.println("Name: " + product1.getName());
        System.out.println("Price: " + product1.getPrice());
        System.out.println("Fopre: " + product1.isFopre());
        System.out.println("Type: " + product1.getType());
        System.out.println("---------------------------------------------------\n");

        System.out.println("Product2 : ");
        System.out.println("Identifier: " + product2.getIdentifier());
        System.out.println("Name: " + product2.getName());
        System.out.println("Price: " + product2.getPrice());
        System.out.println("Fopre: " + product2.isFopre());
        System.out.println("Type: " + product2.getType());
        System.out.println("---------------------------------------------------\n");

        System.out.println("Product3 : ");
        System.out.println("Identifier: " + product3.getIdentifier());
        System.out.println("Name: " + product3.getName());
        System.out.println("Price: " + product3.getPrice());
        System.out.println("Fopre: " + product3.isFopre());
        System.out.println("Type: " + product3.getType());
        System.out.println("---------------------------------------------------\n");

        System.out.println("Product4 : ");
        System.out.println("Identifier: " + product4.getIdentifier());
        System.out.println("Name: " + product4.getName());
        System.out.println("Price: " + product4.getPrice());
        System.out.println("Fopre: " + product4.isFopre());
        System.out.println("Type: " + product4.getType());
        System.out.println("---------------------------------------------------\n");

        System.out.println("\n===================================================");

    }

    private static void testPurchase() {
        Product test = new Product("A1", "Orange Juice", 1500, true, Types.DRINK);
        System.out.println("Quantity of units available: " + test.getQuantityOfUnitsAvailable());
        System.out.println("Quantity of units purchased: " + test.getQuantityOfUnitsPurchased());
        System.out.println("");

        System.out.println("Purchase 1 item.");
        System.out.println("Product 1 was purchased: " + test.purchase());
        System.out.println("Quantity of units purchased: " + test.getQuantityOfUnitsPurchased());
        System.out.println("Quantity of units available: " + test.getQuantityOfUnitsAvailable());
        System.out.println("");

        System.out.println("Purchase 9 items.");
        test.purchase();
        test.purchase();
        test.purchase();
        test.purchase();
        test.purchase();
        test.purchase();
        test.purchase();
        test.purchase();
        test.purchase();

        System.out.println("Quantity of units purchased: " + test.getQuantityOfUnitsPurchased());
        System.out.println("Quantity of units available: " + test.getQuantityOfUnitsAvailable());
        System.out.println("");

        System.out.println("Try to purchase one more product: ");
        System.out.println("Product 1 was purchased: " + test.purchase());
        System.out.println("\n===================================================");

    }

    private static void testCalculateFopreDonation() {
        Product test = new Product("K2", "Skittles", 1300, true, Types.FOOD);
        Product test1 = new Product("K3", "M&Ms", 2300, false, Types.FOOD);
        test.purchase();
        test.purchase();

        test1.purchase();
        test1.purchase();
        test1.purchase();
        test1.purchase();

        System.out.println("Product: " + test.getName());
        System.out.println("Fopre? " + test.isFopre());
        System.out.println("Quantity of units purchased: " + test.getQuantityOfUnitsPurchased());
        System.out.println("Quantity of units available: " + test.getQuantityOfUnitsAvailable());
        System.out.println("");
        System.out.println("The fopre donation is " + test.calculateFopreDonation());
        System.out.println("");

        System.out.println("Product: " + test1.getName());
        System.out.println("Fopre? " + test1.isFopre());
        System.out.println("Quantity of units purchased: " + test1.getQuantityOfUnitsPurchased());
        System.out.println("Quantity of units available: " + test1.getQuantityOfUnitsAvailable());
        System.out.println("");
        System.out.println("The fopre donation is " + test1.calculateFopreDonation());
        System.out.println("\n===================================================");

    }

}


