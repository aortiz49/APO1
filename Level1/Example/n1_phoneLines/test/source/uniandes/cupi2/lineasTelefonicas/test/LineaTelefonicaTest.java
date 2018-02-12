/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_phoneLines
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.phoneLines.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uniandes.cupi2.phoneLines.world.PhoneLine;

/**
 * Clase usada para verificar que los m�todos de la clase PhoneLine est�n correctamente implementados.
 */
public class PhoneLineTest
{

    //-----------------------------------------------------------------
    //Attributes
    //-----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private PhoneLine linea;

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva l�nea telef�nica vac�a.
     */
    private void setupEscenario1( )
    {
        linea = new PhoneLine( );
    }

    /**
     * Prueba 1: M�todo que se encarga de verificar el m�todo addCellCall. <br>
     * <b> Methods a probar: </b> <br>
     * addCellCall<br>
     * getNumberOfCalls<br>
     * getNumberOfMinutes<br>
     * getCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay llamadas el la l�nea.
     */
    @Test
    public void testAgregarLlamadaCelular( )
    {
        setupEscenario1( );
        linea.addCellCall( 10 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.getNumberOfCalls( ) );
        assertEquals( "El n�mero de minutes debe ser 10", 10, linea.getNumberOfMinutes( ) );
        assertEquals( "El costo debe ser $9.990", 9990, linea.getCostOfCalls( ), 0.001 );
    }

    /**
     * Prueba 2: M�todo que se encarga de verificar el m�todo addLocalCall. <br>
     * <b> Methods a probar: </b> <br>
     * addLocalCall<br>
     * getNumberOfCalls<br>
     * getNumberOfMinutes<br>
     * getCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay una llamada en la l�nea.
     */
    @Test
    public void testAgregarLlamadaLocal( )
    {
        setupEscenario1( );
        linea.addLocalCall( 5 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.getNumberOfCalls( ) );
        assertEquals( "El n�mero de minutes debe ser 5", 5, linea.getNumberOfMinutes( ) );
        assertEquals( "El costo debe ser $175", 175, linea.getCostOfCalls( ), 0.001 );
    }

    /**
     * Prueba 3: M�todo que se encarga de verificar el m�todo addLongDistance.<br>
     * <b> Methods a probar: </b> <br>
     * addLongDistance<br>
     * getNumberOfCalls<br>
     * getNumberOfMinutes<br>
     * getCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay llamadas el la l�nea.
     */
    @Test
    public void testAgregarLlamadaLargaDistancia( )
    {
        setupEscenario1( );
        linea.addLongDistance( 7 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.getNumberOfCalls( ) );
        assertEquals( "El n�mero de minutes debe ser 5", 7, linea.getNumberOfMinutes( ) );
        assertEquals( "El costo debe ser $2.660", 2660, linea.getCostOfCalls( ), 0.001 );
    }

    /**
     * Prueba 4: M�todo que se encarga de verificar el m�todo reset. <br>
     * <b> Methods a probar: </b> <br>
     * reset<br>
     * addLongDistance<br>
     * getNumberOfCalls<br>
     * getNumberOfMinutes<br>
     * getCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay una llamada en la l�nea.
     */
    @Test
    public void testReiniciar( )
    {
        setupEscenario1( );
        linea.addLongDistance( 7 );
        linea.reset( );
        assertEquals( "El n�mero de llamadas debe ser 0", 0, linea.getNumberOfCalls( ) );
        assertEquals( "El n�mero de minutes debe ser 0", 0, linea.getNumberOfMinutes( ) );
        assertEquals( "El costo debe ser $0.0", 0, linea.getCostOfCalls( ), 0.001 );
    }

}
