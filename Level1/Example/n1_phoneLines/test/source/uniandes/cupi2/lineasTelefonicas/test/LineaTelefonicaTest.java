/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
 * Clase usada para verificar que los métodos de la clase PhoneLine estén correctamente implementados.
 */
public class PhoneLineTest
{

    //-----------------------------------------------------------------
    //Attributes
    //-----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private PhoneLine linea;

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva línea telefónica vacía.
     */
    private void setupEscenario1( )
    {
        linea = new PhoneLine( );
    }

    /**
     * Prueba 1: Método que se encarga de verificar el método addCellCall. <br>
     * <b> Methods a probar: </b> <br>
     * addCellCall<br>
     * getNumberOfCalls<br>
     * getNumberOfMinutes<br>
     * getCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay llamadas el la línea.
     */
    @Test
    public void testAgregarLlamadaCelular( )
    {
        setupEscenario1( );
        linea.addCellCall( 10 );
        assertEquals( "El número de llamadas debe ser 1", 1, linea.getNumberOfCalls( ) );
        assertEquals( "El número de minutes debe ser 10", 10, linea.getNumberOfMinutes( ) );
        assertEquals( "El costo debe ser $9.990", 9990, linea.getCostOfCalls( ), 0.001 );
    }

    /**
     * Prueba 2: Método que se encarga de verificar el método addLocalCall. <br>
     * <b> Methods a probar: </b> <br>
     * addLocalCall<br>
     * getNumberOfCalls<br>
     * getNumberOfMinutes<br>
     * getCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay una llamada en la línea.
     */
    @Test
    public void testAgregarLlamadaLocal( )
    {
        setupEscenario1( );
        linea.addLocalCall( 5 );
        assertEquals( "El número de llamadas debe ser 1", 1, linea.getNumberOfCalls( ) );
        assertEquals( "El número de minutes debe ser 5", 5, linea.getNumberOfMinutes( ) );
        assertEquals( "El costo debe ser $175", 175, linea.getCostOfCalls( ), 0.001 );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método addLongDistance.<br>
     * <b> Methods a probar: </b> <br>
     * addLongDistance<br>
     * getNumberOfCalls<br>
     * getNumberOfMinutes<br>
     * getCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay llamadas el la línea.
     */
    @Test
    public void testAgregarLlamadaLargaDistancia( )
    {
        setupEscenario1( );
        linea.addLongDistance( 7 );
        assertEquals( "El número de llamadas debe ser 1", 1, linea.getNumberOfCalls( ) );
        assertEquals( "El número de minutes debe ser 5", 7, linea.getNumberOfMinutes( ) );
        assertEquals( "El costo debe ser $2.660", 2660, linea.getCostOfCalls( ), 0.001 );
    }

    /**
     * Prueba 4: Método que se encarga de verificar el método reset. <br>
     * <b> Methods a probar: </b> <br>
     * reset<br>
     * addLongDistance<br>
     * getNumberOfCalls<br>
     * getNumberOfMinutes<br>
     * getCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay una llamada en la línea.
     */
    @Test
    public void testReiniciar( )
    {
        setupEscenario1( );
        linea.addLongDistance( 7 );
        linea.reset( );
        assertEquals( "El número de llamadas debe ser 0", 0, linea.getNumberOfCalls( ) );
        assertEquals( "El número de minutes debe ser 0", 0, linea.getNumberOfMinutes( ) );
        assertEquals( "El costo debe ser $0.0", 0, linea.getCostOfCalls( ), 0.001 );
    }

}
