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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uniandes.cupi2.bank_simulator.world.CertificateOfDeposit;
import uniandes.cupi2.bank_simulator.world.CertificateOfDeposit;

/**
 * Class used to verify that the methods in the CertificateOfDepositTest class are correctly
 * implemented.
 */
public class CertificateOfDepositTest {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * CertificateOfDeposit used for the tests.
     */
    private CertificateOfDeposit cd;

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Scenario  1: Creates a new certificate of deposit and initializes its attributes.
     */
    private void setupScenario1() {
        cd = new CertificateOfDeposit();
    }

    /**
     * Test 1: Method that tests the monthly interest and current value.<br>
     * <b> Methods to test: </b> <br>
     * getMonthlyInterest<br>
     * calculateCurrentValue<br>
     * <b> Test cases: </b> <br>
     * 1. The certificate of deposit was initialized correctly.
     */
    @Test
    public void testCertificateOfDeposit() {
        setupScenario1();
        assertEquals("The monthly interest is in correct", 0.0, cd.getMonthlyInterest(), 1e-8);
        assertEquals("The monthly interest is in correct", 0, cd.calculateCurrentValue(1), 1e-8);
    }

    /**
     * Test 2: Method that tests the investment of the cd. <br>
     * <b> Methods to test: </b> <br>
     * invest<br>
     * calculateCurrentValue<br>
     * <b> Test cases: </b> <br>
     * 1. The certificate of deposit doesn't have any money invested in it.
     */
    @Test
    public void testInvest() {
        setupScenario1();
        cd.invest(100000, 0.05, 1);
        assertEquals("The current value of the cd is not correct", 100000,
                     cd.calculateCurrentValue(1), 2);

    }

    /**
     * Test 3: Method that tests the current value of the account. <br>
     * <b> Methods to test: </b> <br>
     * invest<br>
     * calculateCurrentValue<br>
     * <b> Test cases: </b> <br>
     * 1. The certificate of deposit has money invested in it.
     */
    @Test
    public void testCalculatePresentValue() {
        setupScenario1();
        cd.invest(100000, 0.05, 1);
        assertEquals("The current value of the cd is not correct", 100000 * (1 + 0.05),
                     cd.calculateCurrentValue(2), 0.01);

    }

    /**
     * Test 4: Method that tests if the account closes properly. .<br>
     * <b> Methods to test: </b> <br>
     * invest <br>
     * calculateCurrentValue<br>
     * close<br>
     * <b> Test cases: </b> <br>
     * 1. The certificate of deposit was invested in.
     */
    @Test
    public void testClose() {
        setupScenario1();
        cd.invest(100000, 0.05, 1);
        assertEquals("The current value of the cd is incorrect", 100000 * (1 + 0.05), cd.close(2),
                     0.01);
        assertEquals("The monthly interest in incorrect", 0.0, cd.getMonthlyInterest(), 0.00001);
        assertEquals("The value of the account is incorrect", 0, cd.calculateCurrentValue(1),
                     0.00001);

    }

}

