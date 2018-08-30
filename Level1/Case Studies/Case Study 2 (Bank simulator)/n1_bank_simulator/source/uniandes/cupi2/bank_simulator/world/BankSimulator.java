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
 * Class that represents the bank simulator for the client's three accounts.
 */
public class BankSimulator {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Client's identification number.
     */
    private String identification;

    /**
     * Client's name.
     */
    private String name;

    /**
     * Current month.
     */
    private int currentMonth;

    /**
     * Client's checking account.
     */
    private CheckingAccount checking;

    /**
     * Client's savings account.
     */
    private SavingsAccount savings;

    /**
     * Client's CD account.
     */
    private CertificateOfDeposit certificateOfDeposit;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Initializes the simulator with the client's information. <br>
     * <b>post: </b> The month initialized to1, and the three accounts(checking, savings, and
     * CD) were initialized as empty.  <br>
     *
     * @param pIdentification New client's identification number. pIdentification != null &&
     *                        pIdentification != "".
     * @param pName           New client's name. pName !=null && pName !="".
     */
    public BankSimulator(String pIdentification, String pName) {
        // Initializes the personal attributes of the client
        name = pName;
        identification = pIdentification;

        // Initializes the month to1
        currentMonth = 1;

        // Initializes the three accounts to empty
        checking = new CheckingAccount();
        savings = new SavingsAccount();
        certificateOfDeposit = new CertificateOfDeposit();
    }

    /**
     * Returns the client's name.
     *
     * @return Client's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the clients identification number.
     *
     * @return Client's identification number.
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * Returns the client's checking account.
     *
     * @return Client's checking account.
     */
    public CheckingAccount getCheckingAccount() {
        return checking;
    }

    /**
     * Returns the client's savings account.
     *
     * @return Client's savings account.
     */
    public SavingsAccount getSavingsAccount() {
        return savings;
    }

    /**
     * Returns client's CD account.
     *
     * @return Client's CD account.
     */
    public CertificateOfDeposit getCertificateOfDeposit() {
        return certificateOfDeposit;
    }

    /**
     * Returns the current month of the simulation.
     *
     * @return Current month of simulation.
     */
    public int getCurrentMonth() {
        return currentMonth;
    }

    /**
     * Calculates the total balance of the client's accounts.
     *
     * @return Total balance of client's accounts.
     */
    public double calculateTotalBalance() {
        return checking.getBalance() + savings.getBalance() + certificateOfDeposit
                .calculateCurrentValue(currentMonth);
    }

    /**
     * Invests money in a CD account. <br>
     * <b>post: </b> Invested money amount given in parameter into a CD account.
     *
     * @param pAmount          Amount of money to invest in CD account. pAmount > 0.
     * @param pMonthlyInterest Interest rate of the CD account chosen by the client.
     *                         pMonthlyInterest > 0.
     */
    public void investInCD(double pAmount, double pMonthlyInterest) {
        certificateOfDeposit.invest(pAmount, pMonthlyInterest, currentMonth);
    }

    /**
     * Deposits money into the checking account. <br>
     * <b>post: </b> The checking account balance was increased by the amount given in the
     * parameter.
     *
     * @param pAmount Amount of money to be deposited into the checking account. pAmount > 0.
     */
    public void checkingAccountDeposit(double pAmount) {
        checking.depositAmount(pAmount);
    }

    /**
     * Deposits money into the savings account. <br>
     * <b>post: </b> The savings account balance was increased by the amount given in the parameter.
     *
     * @param pAmount Amount of money to be deposited into the savings account. pAmount > 0.
     */
    public void savingsAccountDeposit(double pAmount) {
        savings.depositAmount(pAmount);
    }

    /**
     * Withdraws money from the checking account.  <br>
     * <b>post: </b> The checking account balance was decreased by the amount given in the
     * parameter. <br>
     *
     * @param pAmount Amount of money to be withdrawn from the checking account. pAmount > 0.
     */
    public void withdrawCheckingAccount(double pAmount) {
        checking.withdrawAmount(pAmount);
    }

    /**
     * Withdraws money from the savings account.  <br>
     * <b>post: </b> The savings account balance was decreased by the amount given in the
     * parameter. <br>
     *
     * @param pAmount Amount of money to be withdrawn from the savings account. pAmount > 0.
     */
    public void withdrawSavingsAccount(double pAmount) {
        savings.withdrawAmount(pAmount);
    }

    /**
     * Advances the simulation by one month. <br>
     * <b>post: </b> Simulation was advanced by 1 month. The savings account balance was updated.
     */
    public void advanceSimulationOneMonth() {
        currentMonth += 1;
        savings.updateSavingsAccountBalanceEndOfMonth();

    }

    /**
     * Closes the CD, transferring the balance to the checking account. <br>
     * <b>pre: </b> The checking account and CD account have been initialized. <br>
     * <b>post: </b> The CD was closed with a balance of 0, and the the balance of the checking
     * account increased by the closing balance of the CD.
     */
    public void closeCD() {
        double closingBalanceCD = certificateOfDeposit.close(currentMonth);
        checking.depositAmount(closingBalanceCD);
    }

    /**
     * Returns the result from extension 1.
     *
     * @return Response 1.
     */
    public String method1() {
        return "Response 1";
    }

    /**
     * Returns the result from extension 2.
     *
     * @return Response 2.
     */
    public String method2() {
        return "Response 2";
    }
}