/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_cupiAppStore
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiAppStore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.cupiAppStore.mundo.AppStore;

/**
 * Clase usada para verificar que los métodos de la clase AppStore estén correctamente implementados
 */
public class AppStoreTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private AppStore appStore;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva AppStore con 4 juegos.
     */
    private void setupEscenario1( )
    {
        appStore = new AppStore( );
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * EmpresaJuegos<br>
     * darJuego1<br>
     * darJuego2<br>
     * darJuego3<br>
     * darJuego4<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se crearon los 4 juegos en la appstore.
     */
    @Test
    public void testAppStore( )
    {
        setupEscenario1( );
        assertNotNull( "Al crear el juego 1, este debería ser válido.", appStore.darJuego1( ) );
        assertNotNull( "Al crear el juego 2, este debería ser válido.", appStore.darJuego2( ) );
        assertNotNull( "Al crear el juego 3, este debería ser válido.", appStore.darJuego3( ) );
        assertNotNull( "Al crear el juego 4, este debería ser válido.", appStore.darJuego4( ) );
        assertEquals( "El nombre del juego 1 no corresponde.", "Candy Crush", appStore.darJuego1( ).darNombre( ) );
        assertEquals( "El nombre del juego 2 no corresponde.", "Flow", appStore.darJuego2( ).darNombre( ) );
        assertEquals( "El nombre del juego 3 no corresponde.", "FIFA", appStore.darJuego3( ).darNombre( ) );
        assertEquals( "El nombre del juego 4 no corresponde.", "Clash of Clans", appStore.darJuego4( ).darNombre( ) );

    }

    /**
     * Prueba 2: Verifica el método buscarJuego<br>
     * <b> Métodos a probar: </b> <br>
     * buscarJuego<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El juego existe.<br>
     * 2. El juego no existe.<br>
     */
    @Test
    public void testBuscarJuego( )
    {
        setupEscenario1( );

        assertNotNull( "Debería existir el juego.", appStore.buscarJuego( "FIFA" ) );
        assertNull( "No debería existir el juego.", appStore.buscarJuego( "Mario Bros" ) );
    }

    /**
     * Prueba 3: Verifica el método comprarLicenciasJuego<br>
     * <b> Métodos a probar: </b> <br>
     * darJuego1<br>
     * comprarLicenciasJuego<br>
     * <b> Métodos a probar: </b> <br>
     * 1. Aumenta la cantidad de licencias del juego.<br>
     */
    @Test
    public void testComprarLicenciasJuego( )
    {
        setupEscenario1( );
        appStore.comprarLicenciasJuego( "Candy Crush", 10 );
        assertEquals( "La cantidad actual del juego 1 debería ser 60", 60, appStore.darJuego1( ).darCantidadLicencias( ) );
    }

    /**
     * Prueba 4: Verifica el método venderLicenciasJuego<br>
     * <b> Métodos a probar: </b> <br>
     * venderLicenciasJuego<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El juego no existe, la venta no se realiza.<br>
     * 2. El juego existe pero la cantidad a vender es mayor a la actual y la venta no se realiza.<br>
     * 3. El juego existe y la venta se realiza.<br>
     */
    @Test
    public void testVenderLicenciasJuego( )
    {
        setupEscenario1( );
        assertFalse( "El juego no existe y no debería realiza la venta.", appStore.venderLicenciasJuego( "Juego", 10 ) );

        assertFalse( "El juego no tiene suficientes licencias para realizar la venta.", appStore.venderLicenciasJuego( "Candy Crush", 80 ) );

        assertTrue( "Debería realizarse la venta.", appStore.venderLicenciasJuego( "Candy Crush", 10 ) );
    }

    /**
     * Prueba 5: Verifica el método darJuegoMasVendido<br>
     * <b> Métodos a probar: </b> <br>
     * darJuegoMasVendido <br>
     * <b> Casos de estudio: </b> <br>
     * 1. Ningún juego tiene ventas.<br>
     * 2. Hay un juego con más ventas que los demás.<br>
     */
    @Test
    public void testObtenerJuegoMasVendido( )
    {
        setupEscenario1( );
        assertEquals( "El juego más vendido debería ser ninguno", "Ninguno", appStore.darJuegoMasVendido( ) );
        appStore.venderLicenciasJuego( "Candy Crush", 10 );
        assertEquals( "El juego más vendido debería ser el segundo", "Candy Crush", appStore.darJuegoMasVendido( ) );
    }
}