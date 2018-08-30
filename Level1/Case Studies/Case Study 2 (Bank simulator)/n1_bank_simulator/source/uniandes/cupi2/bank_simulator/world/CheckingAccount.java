/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes                                          *
 * Department of Systems and Computer Engineering                   *
 * Licensed under Academic Free License version 2.1                 *
 *                                                                  *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)                     *
 * Exercise: L1- bankSimulator                                      *
 * Author: Andres Ortiz                                             *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

package uniandes.cupi2.bank_simulator.world;

/**
 * Class that represents a client's checking account.
 */
public class CheckingAccount {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Current balance in the checking account.
     */
    private double balance;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Initializes a checking account. <br>
     * <b>post: </b> Account balance was initialized to 0. <br>
     */
    public CheckingAccount() {
        balance = 0;
    }

    /**
     * Returns the client's checking account balance. <br>
     *
     * @return Balance in the checking account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits money into the client's checking account. <br>
     * <b>post: </b> The checking account balance is increased by the amount given in the
     * parameter.  <br>
     *
     * @param pAmount Amount of money to be deposited into the checking account. pAmount > 0.
     */
    public void depositAmount(double pAmount) {
        balance += pAmount;
    }

    /**
     * Withdraws money from the client's checking account. <br>
     * <b>post: </b> The checking account balance is decreased by the amount given in the
     * parameter. <br>
     *
     * @param pAmount Amount of money to be withdrawn from the checking account. pAmount > 0.
     */
    public void withdrawAmount(double pAmount) {
        balance -= pAmount;
    }
}