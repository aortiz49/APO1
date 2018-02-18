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
 * Class tha represents a set of coins.
 */
public class Amount {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    // Highest value of the amount
    private final static double MAX_VALUE = 10000;

    // Constant that represents a $50 COP coin.
    private final static int COIN_50 = 50;

    // Constant that represents a $100 COP coin
    private final static int COIN_100 = 100;

    // Constant that represents a $200 COP coin
    private final static int COIN_200 = 200;

    // Constant that represents a $500 COP coin
    private final static int COIN_500 = 500;

    // Constant that represents a $1000 COP coin
    private final static int COIN_1000 = 1000;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Quantity of $50 COP coins in the amount.
    private int quantityOfCoins50;

    // Quantity of $100 COP coins in the amount.
    private int quantityOfCoins100;

    // Quantity of $200 COP coins in the amount.
    private int quantityOfCoins200;

    // Quantity of $500 COP coins in the amount.
    private int quantityOfCoins500;

    // Quantity of $1000 COP coins in the amount.
    private int quantityOfCoins1000;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /*
     * Creates a new amount with zero coins.
     * All quantities initialized to 0.
     */
    public Amount() {
        quantityOfCoins50 = 0;
        quantityOfCoins100 = 0;
        quantityOfCoins200 = 0;
        quantityOfCoins500 = 0;
        quantityOfCoins1000 = 0;

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Returns the amount of $50 COP coins
    public int getQuantityOfCoins50() {
        return quantityOfCoins50;
    }

    // Returns the amount of $100 COP coins
    public int getQuantityOfCoins100() {
        return quantityOfCoins100;
    }

    // Returns the amount of $200 COP coins
    public int getQuantityOfCoins200() {
        return quantityOfCoins200;
    }

    // Returns the amount of $500 COP coins
    public int getQuantityOfCoins500() {
        return quantityOfCoins500;
    }

    // Returns the amount of $1000 COP coins
    public int getQuantityOfCoins1000() {
        return quantityOfCoins1000;
    }

    // Returns the total amount of coins
    public int getTotalQuantityOfCoins() {
        return quantityOfCoins50 + quantityOfCoins100 + quantityOfCoins200 + quantityOfCoins500 +
                quantityOfCoins1000;
    }

    // Returns the total value of coins
    public double getTotalValue() {
        return quantityOfCoins50 * COIN_50 + quantityOfCoins100 * COIN_100 + quantityOfCoins200 *
                COIN_200 + quantityOfCoins500 * COIN_500 + quantityOfCoins1000 * COIN_1000;
    }

    /*
     * Add a coin to the amount.
     * The quantity of coins of the given denomination is increased by one.
     * pCoin: Denomination of the coin. pCoin belongs to {COIN_50, COIN_100,
     * COIN_200, COIN_500, COIN_1000}.
     *
     * Return: true if coin was successfully added to the amount, false if the coin could not be
     * added because it exceeds the maximum value.
     */
    public boolean addCoin(int pCoin) {
        boolean coinAdded = false;


        if (getTotalValue() + pCoin <= MAX_VALUE) {
            coinAdded = true;
            switch (pCoin) {
                case COIN_50:
                    quantityOfCoins50++;
                    break;
                case COIN_100:
                    quantityOfCoins100++;
                    break;
                case COIN_200:
                    quantityOfCoins200++;
                    break;
                case COIN_500:
                    quantityOfCoins500++;
                    break;
                case COIN_1000:
                    quantityOfCoins1000++;
                    break;
                default:
                    // Do nothing
                    break;

            }
        }

        return coinAdded;
    }

    /*
     * Assigns the quantity of coins of each denominations necessary to complete teh value
     * given by the parameter.
     * The minimum quantity of coins must be used.
     * pValue: Value to complete using the coins. pValue >= 0 && pValue%50 == 0.
     */
    public void changeValue(double pValue) {
        // TODO Part 2 Point K: Complete the method according to the given documentation
        // See design considerations sheet.
    }

    /*
     * Reset the values of each coin.
     * All values reset to 0.
     */
    public void reset() {
        quantityOfCoins50 = 0;
        quantityOfCoins100 = 0;
        quantityOfCoins200 = 0;
        quantityOfCoins500 = 0;
        quantityOfCoins1000 = 0;
    }
}
