/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes                                          *
 * Department of Systems and Computer Engineering                   *
 * Licensed under Academic Free License version 2.1                 *
 *                                                                  *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)                     *
 * Exercise: L1- bankSimulator                                      *
 * Author: Andres Ortiz                                             *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

package source.uniandes.cupi2.bank_simulator.test;

import org.junit.Test;
import uniandes.cupi2.bank_simulator.world.CheckingAccount;


import static org.junit.Assert.assertEquals;

/**
 * Class used to verify that the methods in the CheckingAccount class are correctly
 * implemented.
 */
public class CheckingAccountTest {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Checking account used for the tests.
     */
    private CheckingAccount account;

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Scenario1: Creates a new checking account and initializes its attributes.
     * Attributes.
     */
    private void setupScenario1() {
        account = new CheckingAccount();
    }

    /**
     * Test 1: Method that tests initialization.<br>
     * <b> Methods to test: </b> <br>
     * CheckingAccount<br>
     * getBalance<br>
     * <b> Test cases: </b> <br>
     * 1. The account was initialized correctly.
     */
    @Test
    public void testCheckingAccount() {
        setupScenario1();
        assertEquals("The checking account balance is incorrect", 0, account.getBalance(), 1e-8);
    }

    /**
     * Test 2: Method that tests the deposit. <br>
     * <b> Methods to test: </b> <br>
     * depositAmount<br>
     * getBalance<br>
     * <b> Test cases: </b> <br>
     * 1. The checking account has no balance.
     */
    @Test
    public void testDepositAmount() {
        setupScenario1();
        account.depositAmount(10000);
        assertEquals("The account balance is incorrect", 10000, account.getBalance(), 1e-8);

    }

    /**
     * Test 3: Method that tests the withdraw method.<br>
     * <b> Methods to test: </b> <br>
     * withdrawAmount<br>
     * getBalance<br>
     * <b> Test cases: </b> <br>
     * 1. The checking account has sufficient balance to withdraw the given amount.
     */
    @Test
    public void testWithdrawAmount() {
        setupScenario1();
        account.depositAmount(10000);
        account.withdrawAmount(1000);
        assertEquals("The account balance is incorrect", 9000, account.getBalance(), 1e-8);


    }

}
