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
 * Class that represents a client's savings account.
 */
public class SavingsAccount {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Current balance in the savings account.
     */
    private double balance;

    /**
     * Monthly interest of the savings account.
     */
    private double monthlyInterest;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Initializes the savings account with the monthly interest paid by the bank. <br>
     * <b>post: </b> The account balance was initialized to 0 and the monthly interest to 0.006.
     */
    public SavingsAccount() {
        balance = 0;
        monthlyInterest = 0.006;
    }

    /**
     * Returns the client's savings account balance. <br>
     *
     * @return Balance in the savings account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the monthly interest of the savings account.  <br>
     *
     * @return Monthly interest of the savings account.
     */
    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    /**
     * Deposits money into the client's savings account. <br>
     * <b>post: </b> The savings account balance is increased by the amount given in the
     * parameter. <br>
     *
     * @param pAmount Amount of money to be deposited into the savings account. pAmount > 0.
     */
    public void depositAmount(double pAmount) {
        balance += pAmount;
    }

    /**
     * Withdraws money from the client's savings account. <br>
     * <b>post: </b> The savings account balance is decreased by the amount given in the parameter.
     * <br>
     *
     * @param pAmount Amount of money to be withdrawn from the savings account. pAmount > 0.
     */
    public void withdrawAmount(double pAmount) {
        balance -= pAmount;
    }

    /**
     * Updates the savings account balance with the accrued monthly interest. (one month
     * has passed). <br>
     * <b>post: </b> The savings account balance was updated applying the respective monthl
     * interest.
     */
    public void updateSavingsAccountBalanceEndOfMonth() {
        balance += (balance * monthlyInterest);
    }
}