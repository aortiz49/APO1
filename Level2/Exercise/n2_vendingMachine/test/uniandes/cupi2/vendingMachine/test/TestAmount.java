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

public class TestAmount {

    public static void main(String[] args) {

        // Test addCoin.
        System.out.println("Testing: addCoin() \n");
        testAddCoin();

        // Test changeValue().
        System.out.println("Testing: changeValue() \n");
        testChangeValue(19950);

        // Test getTotalValue().
        System.out.println("Testing: getTotalValue() \n");
        testGetTotalValueOfCoins();

        // Test reset().
        System.out.println("Testing: reset() \n");
        testReset();

    }

    private static void testGetTotalValueOfCoins() {
        Amount test = new Amount();
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_500);
        test.addCoin(Amount.COIN_200);
        test.addCoin(Amount.COIN_200);
        test.addCoin(Amount.COIN_200);
        test.addCoin(Amount.COIN_100);
        test.addCoin(Amount.COIN_100);
        test.addCoin(Amount.COIN_50);
        test.addCoin(Amount.COIN_50);

        System.out.println("The amount of coins is: " + "\n$1000 coins: " +
                                   test.getQuantityOfCoins1000() + "\n$500 coins: " +
                                   test.getQuantityOfCoins500() + "\n$200 coins: " +
                                   test.getQuantityOfCoins200() + "\n$100 coins: " +
                                   test.getQuantityOfCoins100() + "\n$50 coins: " +
                                   test.getQuantityOfCoins50());
        System.out.println("Total value of coins is: " + test.getTotalValue());
        System.out.println("\n===================================================");

    }

    private static void testAddCoin() {
        // Create a test object
        Amount test = new Amount();

        // Add 9 $1000 coins
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        System.out.println("Adding 9 $1000 coins");
        System.out.println("The amount of coins is: " + "\n$1000 coins: " +
                                   test.getQuantityOfCoins1000() + "\n$500 coins: " +
                                   test.getQuantityOfCoins500() + "\n$200 coins: " +
                                   test.getQuantityOfCoins200() + "\n$100 coins: " +
                                   test.getQuantityOfCoins100() + "\n$50 coins: " +
                                   test.getQuantityOfCoins50());

        // Add 2 $500 coins. Total value in amount is now $1000
        test.addCoin(Amount.COIN_500);
        test.addCoin(Amount.COIN_500);

        System.out.println("\nAdding 2 $500 coins");
        System.out.println("The amount of coins is: " + "\n$1000 coins: " +
                                   test.getQuantityOfCoins1000() + "\n$500 coins: " +
                                   test.getQuantityOfCoins500() + "\n$200 coins: " +
                                   test.getQuantityOfCoins200() + "\n100 coins: " +
                                   test.getQuantityOfCoins100() + "\n$50 coins: " +
                                   test.getQuantityOfCoins50());

        System.out.println("The amount of cash in the vending machine is : " +
                                   test.getTotalValue());
        System.out.println("Total coins : " + test.getTotalQuantityOfCoins() + "\n");

        System.out.println("Trying to add a new coin of value $50");
        // Try adding one $50 coin.
        System.out.println("adding coin = " + test.addCoin(Amount.COIN_50));

        // This results in $10000 still because $50 coin was never added
        System.out.println("The amount of cash in the vending machine is : " + test
                .getTotalValue());
        System.out.println("Total coins : " + test.getTotalQuantityOfCoins());
        System.out.println("\n===================================================");
    }


    private static void testChangeValue(double pValue) {
        Amount test = new Amount();
        test.changeValue(pValue);

        System.out.println("The amount of coins in " + pValue + " is: " + "\n$1000 coins: " +
                                   test.getQuantityOfCoins1000() + "\n$500 coins: " +
                                   test.getQuantityOfCoins500() + "\n$200 coins: " +
                                   test.getQuantityOfCoins200() + "\n100 coins: " +
                                   test.getQuantityOfCoins100() + "\n$50 coins: " +
                                   test.getQuantityOfCoins50());
        System.out.println("\n===================================================");

    }

    private static void testReset() {
        Amount test = new Amount();
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_1000);
        test.addCoin(Amount.COIN_500);
        test.addCoin(Amount.COIN_200);
        test.addCoin(Amount.COIN_200);
        test.addCoin(Amount.COIN_200);
        test.addCoin(Amount.COIN_100);
        test.addCoin(Amount.COIN_100);
        test.addCoin(Amount.COIN_50);
        test.addCoin(Amount.COIN_50);

        System.out.println("Total quantity of coins is : " + test.getTotalQuantityOfCoins());

        test.reset();
        System.out.println("After the reset, total quantity of coins is: " +
                                   test.getTotalQuantityOfCoins());
        System.out.println("\n===================================================");

    }

}


