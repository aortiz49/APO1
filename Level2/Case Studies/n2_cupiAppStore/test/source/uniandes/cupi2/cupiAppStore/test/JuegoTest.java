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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.cupiAppStore.mundo.Juego;
import uniandes.cupi2.cupiAppStore.mundo.Juego.Categoria;

/**
 * Clase usada para verificar que los métodos de la clase Juego estén correctamente implementados
 */
public class JuegoTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas
     */
    private Juego juego;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo Juego.
     */
    private void setupEscenario1( )
    {
        juego = new Juego( "Juego", Categoria.ACCION, 35000, 2000, 45, "juego.jpg" );
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Juego<br>
     * darCategoria<br>
     * darNombre<br>
     * darCantidadLicencias<br>
     * darCantidadVendidas<br>
     * darTamanio<br>
     * darPrecio<br>
     * darRutaImagen <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testJuego( )
    {
        setupEscenario1( );
        assertEquals( "Nombre no iniciado correctamente.", "Juego", juego.darNombre( ) );
        assertTrue( "Categoría no iniciada correctamente.", juego.darCategoria( ) == Categoria.ACCION );
        assertEquals( "Cantidad licencias no iniciada correctamente.", 45, juego.darCantidadLicencias( ) );
        assertEquals( "Tamaño en KB no iniciada correctamente.", 2000, juego.darTamanio( ) );
        assertEquals( "Precio no iniciado correctamente.", 35000, juego.darPrecio( ) );
        assertEquals( "Cantidad vendidas no iniciada correctamente.", 0, juego.darCantidadVendidas( ) );
        assertEquals( "Ruta imagen no iniciada correctamente.", "juego.jpg", juego.darRutaImagen( ) );
    }

    /**
     * Prueba 2 : Verifica el método comprarLicencias.<br>
     * <b> Métodos a probar: </b> <br>
     * comprarLicencias<br>
     * darCantidadLicencias<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Aumenta correctamente la cantidad de licencias.<br>
     */
    @Test
    public void testComprarJuego( )
    {
        setupEscenario1( );
        juego.comprarLicencias( 5 );
        assertEquals( "La cantidad de licencias no coincide.", 50, juego.darCantidadLicencias( ) );
    }

    /**
     * Prueba 3: Verifica el método venderLicencias<br>
     * <b> Métodos a probar: </b> <br>
     * venderLicencias<br>
     * darCantidadLicencias<br>
     * darCantidadVendidas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se modifican correctamente la cantidad de licencias actual y vendidas <br>
     */
    @Test
    public void testVenderJuego( )
    {
        setupEscenario1( );
        juego.venderLicencias( 10 );
        assertEquals( "La cantidad de licencias actual no coincide.", 35, juego.darCantidadLicencias( ) );
        assertEquals( "La cantidad de licencias vendidas no coincida.", 10, juego.darCantidadVendidas( ) );
        juego.venderLicencias( 35 );
        assertEquals( "La cantidad de licencias actual no coincide", 0, juego.darCantidadLicencias( ) );
        assertEquals( "La cantidad de licencias vendidas no coincida.", 45, juego.darCantidadVendidas( ) );
    }

}
