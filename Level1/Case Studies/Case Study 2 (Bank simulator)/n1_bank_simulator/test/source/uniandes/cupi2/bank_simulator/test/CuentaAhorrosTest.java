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

import uniandes.cupi2.bank_simulator.world.SavingsAccount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class used to verify that the methods in SavingsAccount are correctly implemented.
 */
public class SavingsAccountTest {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Creates a savings accountCuenta de ahorros usada para las pruebas.
     */
    private SavingsAccount account;

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Scenario  1: Crea una nueva account de ahorros y inicializa sus Attributes.
     */
    private void setupScenario1() {
        account = new SavingsAccount();
    }

    /**
     * Test 1: M�todo que se encarga de verificar el m�todo inicializar.<br>
     * <b> Methods to test: </b> <br>
     * inicializar<br>
     * darMonthlyInterest<br>
     * darSaldo<br>
     * <b> Test cases: </b> <br>
     * 1. La account de ahorros fue inicializada correctamente.
     */
    @Test
    public void testCuentaAhorros() {
        setupScenario1();
        assertEquals("El interes mensual no es el esperado", 0.006, account.darMonthlyInterest(),
                     0.00001);
        assertEquals("El saldo de la account de ahorros", 0, account.darSaldo(), 0.00001);
    }

    /**
     * Test 2: M�todo que se encarga de verificar el m�todo consignarMonto.<br>
     * <b> Methods to test: </b> <br>
     * consignarMonto<br>
     * darSaldo<br>
     * <b> Test cases: </b> <br>
     * 1. La account de ahorros no tiene saldo.
     */
    @Test
    public void testConsigarMonto() {
        setupScenario1();
        account.consignarMonto(10000);
        assertEquals("El saldo de la account no es el esperado", 10000, account.darSaldo(), 2);

    }
    /**
     * Test 3: M�todo que se encarga de verificar el m�todo retirarMonto.<br>
     * <b> Methods to test: </b> <br>
     * retirarMonto<br>
     * darSaldo<br>
     * <b> Test cases: </b> <br>
     * 1. La account de ahorros tiene saldo suficiente para retirar.
     */
    @Test
    public void testRetirarMonto() {
        setupScenario1();
        account.consignarMonto(10000);
        account.retirarMonto(1000);
        assertEquals("El saldo de la account no es el esperado", 9000, account.darSaldo(), 2);

    }

    /**
     * Test 4: M�todo que se encarga de verificar el m�todo actualizarSaldoPorPasoMes.<br>
     * <b> Methods to test: </b> <br>
     * actualizarSaldoPorPasoMes<br>
     * consignarMonto<br>
     * darSaldo<br>
     * <b> Test cases: </b> <br>
     * 1. La account de ahorros tiene saldo.
     */
    @Test
    public void testActualizarSaldoPorPasoMes() {
        setupScenario1();
        account.consignarMonto(10000);
        account.updateSavingsAccountBalanceEndOfMonth();
        assertEquals("El saldo de la account no es el esperado", 10000 * (0.006 + 1),
                     account.darSaldo(), 0.0001);
    }

}
