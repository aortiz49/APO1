/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_calculoImpuestosCarro
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.impuestosCarro.test;

import org.junit.Test;
import static org.junit.Assert.*;
import uniandes.cupi2.impuestosCarro.mundo.RangoImpuesto;

/**
 * Clase de prueba para el rango de impuestos
 */
public class RangoImpuestoTest
{

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Rango de impuesto
     */
    private RangoImpuesto rango;
    /**
     * Valor inicial of the  rango
     */
    private double inicio;
    /**
     * Valor final of the  rango
     */
    private double fin;
    /**
     * porcentaje of the  rango
     */
    private double porcentaje;
    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Crea un escenario configurando un rango
     */
    private void setupEscenario1( )
    {
        inicio = 0;
        fin = 100000000;
        porcentaje = 5;
        rango = new RangoImpuesto( inicio, fin, porcentaje );
    }

    /**
     * Prueba que el rango contenga a su l�mite inferior
     */
    @Test
    public void testContieneALimiteInferior( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Prueba que el l�mite inferior est� contenido
        assertTrue( rango.contieneA( inicio ) );
    }

    /**
     * Prueba que el rango no contenga a su l�mite superior
     */
    @Test
    public void testContieneALimiteSuperior( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Prueba que el l�mite superior no est� contenido
        assertFalse( rango.contieneA( fin ) );
    }

    /**
     * Prueba que el rango contenga al valor medio entre el l�mite inferior y el l�mite superior
     */
    @Test
    public void testContieneAValorMedio( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Prueba que el valor medio est� contenido
        assertTrue( rango.contieneA( ( inicio + fin ) / 2 ) );
    }

    /**
     * Prueba que retorne el porcentaje correctamente
     */
    @Test
    public void testDarPorcentaje( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Prueba que el porcentaje dado sea correcto
        assertEquals( porcentaje, rango.darPorcentaje( ), 0 );
    }

}