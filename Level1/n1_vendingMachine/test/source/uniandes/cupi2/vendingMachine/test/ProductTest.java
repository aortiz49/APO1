/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_calculadoraNotas
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import uniandes.cupi2.vendingMachine.world.Product;

/**
 * Clase usada para verificar que los m�todos de la clase Product est�n correctamente implementados.
 */
public class ProductTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Product en el cual se har�n las pruebas
     */
    private Product producto;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo producto para realizar las pruebas.
     */
    @Before
    public void setupEscenario1( )
    {
        producto = new Product( "F2", "Chocorramo", 1300 );
    }

    // -----------------------------------------------------------------
    // M�todos de prueba
    // -----------------------------------------------------------------

    /**
     * <b>Prueba 1</b> : verifica el m�todo constructor Product.<br>
     * <b>M�todos a probar: </b><br>
     * Product<br>
     * getIdentifier<br>
     * getNambre<br>
     * getPrice<br>
     * getQuantityOfUnitsAvailable<br>
     * getQuantityOfUnitsSold<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el producto correctamente.
     */
    @Test
    public void testProduct( )
    {
        // Caso de prueba 1
        assertEquals( "El identificador asignado no corresponde", "F2", producto.getIdentifier( ) );
        assertEquals( "El nombre asignado no corresponde", "Chocorramo", producto.getName( ) );
        assertEquals( "El precio asignado no corresponde", 1300, producto.getPrice( ), 0.1 );
        assertEquals( "La cantidad de unidades disponibles no se asign� correctamente", 0, producto.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "La cantidad de unidades vendidas no se asign� correctamente", 0, producto.getQuantityOfUnitsSold( ), 0.01 );
    }

    /**
     * <b>Prueba 2</b> : verifica el m�todo restock.<br>
     * <b>M�todos a probar: </b><br>
     * restock<br>
     * getQuantityOfUnitsAvailable<br>
     * getQuantityOfUnitsSold<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se abastece el producto correctamente.
     */
    @Test
    public void testAbastecer( )
    {
        // Caso de prueba 1
        producto.restock( 20 );
        assertEquals( "El producto no fue abastecido correctamente", 20, producto.getQuantityOfUnitsAvailable( ), 0.01 );
        producto.restock( 25 );
        assertEquals( "El producto no fue abastecido correctamente", 45, producto.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "No se deb�an modificar las unidades vendidas", 0, producto.getQuantityOfUnitsSold( ), 0.01 );
    }

    /**
     * <b>Prueba 3</b> : verifica el m�todo sell.<br>
     * <b>M�todos a probar: </b><br>
     * restock<br>
     * sell<br>
     * getQuantityOfUnitsAvailable<br>
     * getQuantityOfUnitsSold<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se abastece el producto correctamente.
     */
    @Test
    public void testVender( )
    {
        // Caso de prueba 1
        producto.restock( 20 );
        producto.sell( );
        assertEquals( "El producto no fue vendido correctamente", 19, producto.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "El producto no fue vendido correctamente", 1, producto.getQuantityOfUnitsSold( ), 0.01 );
        producto.restock( 1 );
        assertEquals( "No se deb�an modificar las unidades vendidas", 1, producto.getQuantityOfUnitsSold( ), 0.01 );
    }
}
