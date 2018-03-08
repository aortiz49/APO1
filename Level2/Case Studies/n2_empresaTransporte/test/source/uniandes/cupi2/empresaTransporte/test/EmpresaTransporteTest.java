/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_transporte
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empresaTransporte.test;

import org.junit.Test;

import junit.framework.TestCase;
import uniandes.cupi2.empresaTransporte.mundo.EmpresaTransporte;

/**
 * Clase usada para verificar que los métodos de la clase EmpresaTransporte estén correctamente implementados
 */
public class EmpresaTransporteTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas
     */
    private EmpresaTransporte empresaTransporte;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva EmpresaTransporte con 4 camiones sin carga.
     */
    private void setupEscenario1( )
    {
        empresaTransporte = new EmpresaTransporte( );
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * EmpresaTransporte<br>
     * darCamion1<br>
     * darCamion2<br>
     * darCamion3<br>
     * darCamion4<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testEmpresaTransporte( )
    {
        setupEscenario1( );

        assertNotNull( "El camión 1 debería existir.", empresaTransporte.darCamion1( ) );
        assertNotNull( "El camión 2 debería existir.", empresaTransporte.darCamion2( ) );
        assertNotNull( "El camión 3 debería existir.", empresaTransporte.darCamion3( ) );
        assertNotNull( "El camión 4 debería existir.", empresaTransporte.darCamion4( ) );
    }

    /**
     * Prueba 2: Verifica el método cargarCamion.<br>
     * <b> Métodos a probar: </b> <br>
     * cargarCamion<br>
     * darCargaTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún camión tiene carga.
     */
    @Test
    public void testCargarCamion( )
    {
        setupEscenario1( );
        assertTrue( "Debería permitir cargar el camión.", empresaTransporte.cargarCamion( "BAC213", 100 ) );
    }

    /**
     * Prueba 3: Verifica el método descargarCamion.<br>
     * <b> Métodos a probar: </b> <br>
     * descargarCamion<br>
     * darCargaTotal<br>
     * darCamion1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Un camión tiene carga.
     */
    @Test
    public void testDescargarCamion( )
    {
        setupEscenario1( );
        empresaTransporte.cargarCamion( "BAC213", 100 );
        empresaTransporte.descargarCamion( "BAC213" );
        assertEquals( "Debería descargar el camión.", 0, empresaTransporte.darCamion1( ).darCargaActual( ) );
    }

    /**
     * Prueba 4: Verifica el método darCapacidadTotal.<br>
     * <b> Métodos a probar: </b> <br>
     * darCapacidadTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún camión tiene carga.<br>
     */
    @Test
    public void testDarCapacidadTotal( )
    {
        setupEscenario1( );
        assertEquals( "La capacidad total no corresponde.", 835, empresaTransporte.darCapacidadTotal( ) );
    }

    /**
     * Prueba 5: Verifica el método darCargaTotal.<br>
     * <b> Métodos a probar: </b> <br>
     * cargarCamion<br>
     * darCapacidadTotal<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún camión tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testDarCargaTotal( )
    {
        setupEscenario1( );
        assertEquals( "La carga total no corresponde.", 0, empresaTransporte.darCargaTotal( ) );
        empresaTransporte.cargarCamion( "BAC213", 10 );
        empresaTransporte.cargarCamion( "CAP384", 20 );
        empresaTransporte.cargarCamion( "GER273", 30 );
        empresaTransporte.cargarCamion( "JKV232", 40 );
        assertEquals( "La carga total no corresponde.", 100, empresaTransporte.darCargaTotal( ) );
    }

    /**
     * Prueba 6: Verifica el método calcularCargaPromedio.<br>
     * <b> Métodos a probar: </b> <br>
     * cargarCamion<br>
     * calcularCargaPromedio<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún camión tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testCalcularCargaPromedio( )
    {
        setupEscenario1( );
        assertEquals( "El promedio está mal calculado.", 0, empresaTransporte.calcularCargaPromedio( ), 0.01 );
        empresaTransporte.cargarCamion( "BAC213", 10 );
        empresaTransporte.cargarCamion( "CAP384", 20 );
        empresaTransporte.cargarCamion( "GER273", 30 );
        empresaTransporte.cargarCamion( "JKV232", 40 );
        assertEquals( "El promedio está mal calculado.", 25, empresaTransporte.calcularCargaPromedio( ), 0.01 );
    }

    /**
     * Prueba 7: Verifica el método darMejorCamion.<br>
     * <b> Métodos a probar: </b> <br>
     * cargarCamion<br>
     * darMejorCamion<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún camión tiene carga.<br>
     * 2. Todos los camiones tienen carga.
     */
    @Test
    public void testDarMejorCamion( )
    {
        setupEscenario1( );
        assertNull( "No debería sugerir ningun camión.", empresaTransporte.darMejorCamion( 2000 ) );
        assertNotNull( "Debería sugerir un camión.", empresaTransporte.darMejorCamion( 140 ) );
        assertEquals( "Debería sugerir un camión.", "CAP384", empresaTransporte.darMejorCamion( 140 ).darMatricula( ) );
    }

}