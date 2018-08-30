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
 * Class that represents a certificate of deposit.
 */
public class CertificateOfDeposit {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Initial value of CD.
     */
    private double amountInvested;

    /**
     * Monthly interest of CD.
     */
    private double monthlyInterest;

    /**
     * Month in which the CD was opened.
     */
    private int openingMonth;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Initializes the certificate of deposit. <br>
     * <b>post: </b> The amount invested, the monthly interest, and the opening month were
     * initialized to 0. <br>
     */
    public CertificateOfDeposit() {
        amountInvested = 0;
        monthlyInterest = 0;
        openingMonth = 0;
    }

    /**
     * Returns the interest that the bank pays the client for this CD. <br>
     *
     * @return Monthly interest of CD.
     */
    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    /**
     * Initiates a CD investment .<br>
     * <b>post: </b> The values of the CD are modified with the values received through the
     * parameters. <br>
     *
     * @param pAmountInvested  Amount of money to be invested in the CD. pAmountInvested > 0.
     * @param pMonthlyInterest Monthly interest to be generated by the CD. pMonthlyInterest > 0.
     * @param pMonth           Month in which the CD was opened. pMonth > 0.
     */
    public void invest(double pAmountInvested, double pMonthlyInterest, int pMonth) {
        amountInvested = pAmountInvested;
        monthlyInterest = pMonthlyInterest;
        openingMonth = pMonth;
    }

    /**
     * Calculates the current value of the money invested in the CD. <br>
     *
     * @param pCurrentMonth Current month of the simulator. pMesActual > 0.
     * @return Current value of the money invested in CD.
     */
    public double calculateCurrentValue(int pCurrentMonth) {
        int monthsPassed = pCurrentMonth - openingMonth;
        return amountInvested + (monthsPassed * monthlyInterest * amountInvested);
    }

    /**
     * Coses the CD and returns the value invested. <br>
     * <b>post: </b> The performance of the CD was returned, and its attributes were reset to 0.
     * <br>
     *
     * @param pCurrentMonth Month in which the CD was closed. pCurrentMonth > 0.
     * @return Closing value of the CD.
     */
    public double close(int pCurrentMonth) {
        double closingValue = calculateCurrentValue(pCurrentMonth);
        amountInvested = 0;
        monthlyInterest = 0;
        openingMonth = 0;
        return closingValue;
    }
}