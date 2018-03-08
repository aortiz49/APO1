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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.empresaTransporte.mundo.Camion;

/**
 * Clase usada para verificar que los métodos de la clase Camion estén correctamente implementados.
 */
public class CamionTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas
     */
    private Camion camion;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un camión sin carga.
     */
    private void setupEscenario1( )
    {
        camion = new Camion( "ZZZ111", 25000, 2.58 );
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Métodos a probar: </b> <br>
     * Camion<br>
     * darMatricula<br>
     * darCargaActual<br>
     * darCapacidad<br>
     * darConsumo<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testCamion( )
    {
        setupEscenario1( );
        assertEquals( "La matrícula no corresponde.", "ZZZ111", camion.darMatricula( ) );
        assertEquals( "La capacidad no coincide.", 25000, camion.darCapacidad( ) );
        assertEquals( "El consumo no corresponde.", 2.58, camion.darConsumo( ), 0.01 );
        assertEquals( "La carga actual no corresponde.", 0, camion.darCargaActual( ) );
    }

    /**
     * Prueba 2: Verifica el método cargar.<br>
     * <b> Métodos a probar: </b> <br>
     * cargar<br>
     * darCargaActual<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El camión se encontraba vacío.<br>
     * 2. La carga supera la capacidad.
     */
    @Test
    public void testCargar( )
    {
        setupEscenario1( );
        assertTrue( "Debería realizarse la carga.", camion.cargar( 1000 ) );
        assertEquals( "La carga no coincide.", 1000, camion.darCargaActual( ) );

        assertFalse( "No debería realizarse la carga.", camion.cargar( 40000 ) );
    }

    /**
     * Prueba 3: Verifica el método descargar.<br>
     * <b> Métodos a probar: </b> <br>
     * cargar<br>
     * descargar<br>
     * darCargaActual<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El camión tenía carga..
     */
    @Test
    public void testDescargar( )
    {
        setupEscenario1( );
        camion.cargar( 5000 );
        camion.descargar( );
        assertEquals( "La carga no coincide.", 0, camion.darCargaActual( ) );
    }
}
