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

public class Test {

    public static void main(String[] args) {

        // Test addCoin
        testAddCoin();




    }

    public static void testAddCoin() {
        // Create a test object
        Amount testAmount = new Amount();

        // Add 9 $1000 coins
        testAmount.addCoin(Amount.COIN_1000);
        testAmount.addCoin(Amount.COIN_1000);
        testAmount.addCoin(Amount.COIN_1000);
        testAmount.addCoin(Amount.COIN_1000);
        testAmount.addCoin(Amount.COIN_1000);
        testAmount.addCoin(Amount.COIN_1000);
        testAmount.addCoin(Amount.COIN_1000);
        testAmount.addCoin(Amount.COIN_1000);
        testAmount.addCoin(Amount.COIN_1000);

        // Add 2 $500 coins. Total value in amount is now $1000
        testAmount.addCoin(Amount.COIN_500);
        testAmount.addCoin(Amount.COIN_500);

        System.out.println("The amount of coins is: " + "\n$1000 coins: " +
                                   testAmount.getQuantityOfCoins1000() + "\n$500 coins: " +
                                   testAmount.getQuantityOfCoins500() + "\n$200 coins: " +
                                   testAmount.getQuantityOfCoins200() + "\n100 coins: " +
                                   testAmount.getQuantityOfCoins100() + "\n$50 coins: " +
                                   testAmount.getQuantityOfCoins50());

        System.out.println("The amount of cash in the vending machine is : " +
                                   testAmount.getTotalValue());
        System.out.println("Total coins : " + testAmount.getTotalQuantityOfCoins());

        System.out.println("\nTry to add a new coin of value $50");
        // Try adding one $50 coin.
        System.out.println("adding coin = " + testAmount.addCoin(Amount.COIN_50));

        // This results in $10000 still because $50 coin was never added
        System.out.println("The amount of cash in the vending machine is : " + testAmount
                .getTotalValue());
        System.out.println("Total coins : " + testAmount.getTotalQuantityOfCoins());
    }

}


