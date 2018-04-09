/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_club
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.club.test;

import org.junit.Before;
import org.junit.Test;

import uniandes.cupi2.club.world.Bill;
import static org.junit.Assert.*;

/**
 * Clase que modela las pruebas para una factura.
 */
public class BillTest
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * La factura a probar.
     */
    private Bill factura;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Escenario con una factura.
     */
    @Before
    public void setupEscenario1( )
    {
        factura = new Bill( "Jorge Bejarano", "Pi�a colada", 10000 );
    }
    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * 
     */
    @Test
    public void testBill( )
    {
        assertEquals( "El name no es el esperado.", "Jorge Bejarano", factura.getName( ) );
        assertEquals( "El invoice no es el esperado.", "Pi�a colada", factura.getInvoice( ) );
        assertEquals( "El value no es el esperado", 10000, factura.getValue( ), .2 );
    }
}
