/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package source.uniandes.cupi2.bank_simulator.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uniandes.cupi2.bank_simulator.world.SimuladorBancario;

/**
 * Clase usada para verificar que los Methods de la clase CuentaBancaria est�n correctamente implementados.
 */
public class SimuladorBancarioTest
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Cuenta bancaria usada para las pruebas.
     */
    private SimuladorBancario cuenta;

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Scenario  1: Crea una cuenta bancaria sin CertificateOfDeposit, sin cuenta de ahorros y sin cuenta corriente.
     */
    private void setupScenario1( )
    {
        cuenta = new SimuladorBancario( "50.152.468", "Sergio L�pez" );
    }

    /**
     * Scenario  2: Crea una cuenta bancaria con valores en todas las cuentas.
     */
    private void setupScenario 2( )
    {
        setupScenario1( );
        cuenta.invertirCertificateOfDeposit( 1000000, 10 );
        cuenta.consignarCuentaAhorros( 500000 );
        cuenta.consignarCheckingAccount( 600000 );
    }

    /**
     * Scenario  3:Cre una cuenta bancaria con valores en todas las cuentas y retiros.
     */
    private void setupScenario 3( )
    {
        setupScenario1( );
        cuenta.invertirCertificateOfDeposit( 1000000, 10 );
        cuenta.consignarCuentaAhorros( 500000 );
        cuenta.retirarCuentaAhorros( 200000 );
        cuenta.consignarCheckingAccount( 600000 );
        cuenta.retirarCheckingAccount( 100000 );
    }

    /**
     * Test 1: M�todo que se encarga de verificar el m�todo invertirCertificateOfDeposit.<br>
     * <b> Methods to test: </b> <br>
     * invertirCertificateOfDeposit<br>
     * darCertificateOfDeposit<br>
     * <b> Test cases: </b> <br>
     * 1. El CertificateOfDeposit no tiene saldo..
     */
    @Test
    public void testInvestCertificateOfDeposit( )
    {
        setupScenario 2( );
        assertEquals( "El valor presente del CertificateOfDeposit no es el esperado", 1000000, cuenta.darCertificateOfDeposit( ).calculateCurrentValue( 1 ), 2 );

    }

    /**
     * Test 2: M�todo que se encarga de verificar el m�todo consignarCheckingAccount.<br>
     * <b> Methods to test: </b> <br>
     * consignarCheckingAccount<br>
     * darCheckingAccount<br>
     * <b> Test cases: </b> <br>
     * 1. La cuenta corriente no tiene saldo.
     */
    @Test
    public void testConsignarCheckingAccount( )
    {
        setupScenario 2( );
        assertEquals( "El saldo de la cuenta corriente no es el esperado", 600000, cuenta.darCheckingAccount( ).darSaldo( ), 2 );

    }

    /**
     * Test 3: M�todo que se encarga de verificar el m�todo consignarCuentaAhorro.<br>
     * <b> Methods to test: </b> <br>
     * consignarCuentaAhorro<br>
     * darCuentaAhorro<br>
     * <b> Test cases: </b> <br>
     * 1. La cuenta de ahorros no tiene saldo.
     */
    @Test
    public void testConsignarCuentaAhorros( )
    {
        setupScenario 2( );
        assertEquals( "El saldo de la cuenta de ahorros no es el esperado", 500000, cuenta.darCuentaAhorros( ).darSaldo( ), 2 );
    }

    /**
     * Test 4: M�todo que se encarga de verificar el m�todo cerrarCertificateOfDeposit.<br>
     * <b> Methods to test: </b> <br>
     * cerrarCertificateOfDeposit<br>
     * darCertificateOfDeposit<br>
     * calcularSaldoTotal<br>
     * <b> Test cases: </b> <br>
     * 1. El CertificateOfDeposit tiene saldo.
     */
    @Test
    public void testCerrarCertificateOfDeposit( )
    {
        setupScenario 2( );
        double cerrado = cuenta.darCertificateOfDeposit( ).calculateCurrentValue( 1 );
        double saldo = 1100000 + cerrado;
        cuenta.cerrarCertificateOfDeposit( );
        assertEquals( "El saldo de la cuenta bancaria no es el esperado", ( int )saldo, ( int )cuenta.calcularSaldoTotal( ), 0.01 );
    }

    /**
     * Test 5: M�todo que se encarga de verificar el m�todo retirarCheckingAccount.<br>
     * <b> Methods to test: </b> <br>
     * retirarCheckingAccount<br>
     * darCheckingAccount<br>
     * <b> Test cases: </b> <br>
     * 1. La cuenta corriente tiene suficiente saldo para retirar.
     */
    @Test
    public void testRetirarCheckingAccount( )
    {
        setupScenario 3( );
        assertEquals( "El saldo de la cuenta corriente no es el esperado", 500000, cuenta.darCheckingAccount( ).darSaldo( ), 2 );
    }

    /**
     * Test 6: M�todo que se encarga de verificar el m�todo retirarCuentaAhorro.<br>
     * <b> Methods to test: </b> <br>
     * retirarCuentaAhorro<br>
     * darCuentaAhorro<br>
     * <b> Test cases: </b> <br>
     * 1. La cuenta ahorros tiene suficiente saldo para retirar.
     */
    @Test
    public void testRetirarCuentaAhorros( )
    {
        setupScenario 3( );
        assertEquals( "El saldo de la cuenta de ahorro no es el esperado", 300000, cuenta.darCuentaAhorros( ).darSaldo( ), 2 );
    }

    /**
     * Test 7: M�todo que se encarga de verificar el m�todo calcularSaldoTotal.<br>
     * <b> Methods to test: </b> <br>
     * calcularSaldoTotal<br>
     * <b> Test cases: </b> <br>
     * 1. El CertificateOfDeposit, la cuenta ahorros y la cuenta corriente tienen saldo.
     */
    @Test
    public void testSaldoTotal( )
    {
        setupScenario 3( );
        assertEquals( 1800000, ( int )cuenta.calcularSaldoTotal( ) );
    }

}
