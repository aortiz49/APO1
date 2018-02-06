/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
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

import uniandes.cupi2.vendingMachine.world.VendingMachine;
import uniandes.cupi2.vendingMachine.world.Product;

/**
 * Clase usada para verificar que los métodos de la clase VendingMachine.
 */
public class VendingMachineTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Máquina expendedora en la que se realizarán las pruebas.
     */
    private VendingMachine vendingMachine;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase vendingMachine. Este método se ejecuta antes de cada método de prueba.
     */
    @Before
    public void setupEscenario1( )
    {
        vendingMachine = new VendingMachine( );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------

    /**
     * <b>Prueba 1</b> : verifica el método constructor VendingMachine.<br>
     * <b>Métodos a probar: </b><br>
     * VendingMachine<br>
     * getProduct1<br>
     * getProduct2<br>
     * getProduct3<br>
     * getProduct4<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea la máquina expendedora correctamente.
     */
    @Test
    public void testVendingMachine( )
    {
        // Caso de prueba 1
        Product p1 = vendingMachine.getProduct1( );
        Product p2 = vendingMachine.getProduct2( );
        Product p3 = vendingMachine.getProduct3( );
        Product p4 = vendingMachine.getProduct4( );

        assertNotNull( "El producto 1 no debe ser null", p1 );
        assertNotNull( "El producto 2 no debe ser null", p2 );
        assertNotNull( "El producto 3 no debe ser null", p3 );
        assertNotNull( "El producto 4 no debe ser null", p4 );

        assertEquals( "El identificador asignado no corresponde", "A1", p1.getIdentifier( ) );
        assertEquals( "El nombre del producto asignado no corresponde", "Papas Natural Margarita", p1.getName( ) );
        assertEquals( "El precio asignado no corresponde", 1300, p1.getPrice( ), 0.1 );

        assertEquals( "El identificador asignado no corresponde", "B2", p2.getIdentifier( ) );
        assertEquals( "El nombre del producto asignado no corresponde", "Jugo Hit", p2.getName( ) );
        assertEquals( "El precio asignado no corresponde", 2000, p2.getPrice( ), 0.1 );

        assertEquals( "El identificador asignado no corresponde", "C3", p3.getIdentifier( ) );
        assertEquals( "El nombre del producto asignado no corresponde", "Chocolatina Jet", p3.getName( ) );
        assertEquals( "El precio asignado no corresponde", 500, p3.getPrice( ), 0.1 );

        assertEquals( "El identificador asignado no corresponde", "D4", p4.getIdentifier( ) );
        assertEquals( "El nombre del producto asignado no corresponde", "Galletas Festival", p4.getName( ) );
        assertEquals( "El precio asignado no corresponde", 800, p4.getPrice( ), 0.1 );

    }

    /**
     * <b>Prueba 2</b> : verifica los métodos de restock de VendingMachine.<br>
     * <b>Métodos a probar: </b><br>
     * getProduct1<br>
     * getProduct2<br>
     * getProduct3<br>
     * getProduct4<br>
     * restockProduct1<br>
     * restockProduct2<br>
     * restockProduct3<br>
     * restockProduct4<br>
     * * <b>Casos de prueba:</b><br>
     * 1. Se abastece la máquina correctamente.
     */
    @Test
    public void testAbastecerProducts( )
    {
        // Caso de prueba 1
        Product p1 = vendingMachine.getProduct1( );
        Product p2 = vendingMachine.getProduct2( );
        Product p3 = vendingMachine.getProduct3( );
        Product p4 = vendingMachine.getProduct4( );

        vendingMachine.restockProduct1( 13 );
        vendingMachine.restockProduct2( 14 );
        vendingMachine.restockProduct3( 15 );
        vendingMachine.restockProduct4( 16 );

        assertEquals( "El producto no fue abastecido correctamente", 13, p1.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "El producto no fue abastecido correctamente", 14, p2.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "El producto no fue abastecido correctamente", 15, p3.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "El producto no fue abastecido correctamente", 16, p4.getQuantityOfUnitsAvailable( ), 0.01 );
    }

    /**
     * <b>Prueba 3</b> : verifica los métodos sell de VendingMachine.<br>
     * <b>Métodos a probar: </b><br>
     * getProduct1<br>
     * getProduct2<br>
     * getProduct3<br>
     * getProduct4<br>
     * restockProduct1<br>
     * restockProduct2<br>
     * restockProduct3<br>
     * restockProduct4<br>
     * sellProduct1<br>
     * sellProduct2<br>
     * sellProduct3<br>
     * sellProduct4<br>
     * * <b>Casos de prueba:</b><br>
     * 1. Se venden los productos correctamente.
     */
    @Test
    public void testVenderProducts( )
    {
        // Caso de prueba 1
        Product p1 = vendingMachine.getProduct1( );
        Product p2 = vendingMachine.getProduct2( );
        Product p3 = vendingMachine.getProduct3( );
        Product p4 = vendingMachine.getProduct4( );

        vendingMachine.restockProduct1( 13 );
        vendingMachine.restockProduct2( 14 );
        vendingMachine.restockProduct3( 15 );
        vendingMachine.restockProduct4( 16 );

        vendingMachine.sellProduct1( );
        vendingMachine.sellProduct2( );
        vendingMachine.sellProduct3( );
        vendingMachine.sellProduct4( );

        assertEquals( "El producto no fue abastecido correctamente", 12, p1.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "El producto no fue abastecido correctamente", 13, p2.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "El producto no fue abastecido correctamente", 14, p3.getQuantityOfUnitsAvailable( ), 0.01 );
        assertEquals( "El producto no fue abastecido correctamente", 15, p4.getQuantityOfUnitsAvailable( ), 0.01 );
    }

    /**
     * <b>Prueba 4</b> : verifica el método getQuantityOfTotalSales.<br>
     * <b>Métodos a probar: </b><br>
     * getQuantityOfTotalSales<br>
     * restockProduct1<br>
     * restockProduct2<br>
     * restockProduct3<br>
     * restockProduct4<br>
     * sellProduct1<br>
     * sellProduct2<br>
     * sellProduct3<br>
     * sellProduct4<br>
     * * <b>Casos de prueba:</b><br>
     * 1. Se venden los 4 productos una vez.<br>
     * 2. Se venden los 4 productos 2 veces.
     */
    @Test
    public void testCantidadTotalVentas( )
    {
        vendingMachine.restockProduct1( 13 );
        vendingMachine.restockProduct2( 14 );
        vendingMachine.restockProduct3( 15 );
        vendingMachine.restockProduct4( 16 );

        // Caso de prueba 1
        vendingMachine.sellProduct1( );
        vendingMachine.sellProduct2( );
        vendingMachine.sellProduct3( );
        vendingMachine.sellProduct4( );
        assertEquals( "La cantidad total de ventas no es correcta", 4, vendingMachine.getQuantityOfTotalSales( ), 0.01 );

        // Caso de prueba 2
        vendingMachine.sellProduct1( );
        vendingMachine.sellProduct2( );
        vendingMachine.sellProduct3( );
        vendingMachine.sellProduct4( );
        assertEquals( "La cantidad total de ventas no es correcta", 8, vendingMachine.getQuantityOfTotalSales( ), 0.01 );

    }

    /**
     * <b>Prueba 5</b> : verifica el método getValueOfTotalSales.<br>
     * <b>Métodos a probar: </b><br>
     * getValueOfTotalSales<br>
     * restockProduct1<br>
     * restockProduct2<br>
     * restockProduct3<br>
     * restockProduct4<br>
     * sellProduct1<br>
     * sellProduct2<br>
     * sellProduct3<br>
     * sellProduct4<br>
     * * <b>Casos de prueba:</b><br>
     * 1. Se venden los 4 productos una vez.<br>
     * 2. Se venden los 4 productos 2 veces.
     */
    @Test
    public void testDarValorTotalVentas( )
    {
        vendingMachine.restockProduct1( 20 );
        vendingMachine.restockProduct2( 20 );
        vendingMachine.restockProduct3( 20 );
        vendingMachine.restockProduct4( 20 );
        assertEquals( "El valor de ventas no es correcto", 0, vendingMachine.getValueOfTotalSales( ), 0.01 );

        // Caso de prueba 1
        vendingMachine.sellProduct1( );
        vendingMachine.sellProduct2( );
        vendingMachine.sellProduct3( );
        vendingMachine.sellProduct4( );
        assertEquals( "El valor de ventas no es correcto", 4600, vendingMachine.getValueOfTotalSales( ), 0.01 );

        // Caso de prueba 2
        vendingMachine.sellProduct1( );
        vendingMachine.sellProduct2( );
        vendingMachine.sellProduct3( );
        vendingMachine.sellProduct4( );
        assertEquals( "La cantidad total de ventas no es correcta", 9200, vendingMachine.getValueOfTotalSales( ), 0.01 );

    }

    /**
     * <b>Prueba 6</b> : verifica el método getPercentOfAvailability.<br>
     * <b>Métodos a probar: </b><br>
     * getPercentOfAvailability<br>
     * restockProduct1<br>
     * restockProduct2<br>
     * restockProduct3<br>
     * restockProduct4<br>
     * sellProduct1<br>
     * sellProduct2<br>
     * sellProduct3<br>
     * sellProduct4<br>
     * <b>Casos de prueba:</b><br>
     * 1. Capacidad 20<br>
     * 2. Capacidad 50.<br>
     * 3. Capacidad 100.
     */
    @Test
    public void testDarPorcentajeDisponibilidad( )
    {
        // Caso de prueba 1
        assertEquals( "El porcentaje no es correcto", 100, vendingMachine.getPercentOfAvailability( 20 ), 0.1 );
        vendingMachine.restockProduct1( 1 );
        vendingMachine.restockProduct2( 1 );
        vendingMachine.restockProduct3( 1 );
        vendingMachine.restockProduct4( 1 );
        assertEquals( "El porcentaje no es correcto", 80, vendingMachine.getPercentOfAvailability( 20 ), 0.1 );
        vendingMachine.restockProduct1( 4 );
        vendingMachine.restockProduct2( 4 );
        vendingMachine.restockProduct3( 4 );
        vendingMachine.restockProduct4( 4 );
        assertEquals( "El porcentaje no es correcto", 0, vendingMachine.getPercentOfAvailability( 20 ), 0.1 );

        // Caso de prueba 2
        setupEscenario1( );
        assertEquals( "El porcentaje no es correcto", 100, vendingMachine.getPercentOfAvailability( 50 ), 0.1 );
        vendingMachine.restockProduct1( 1 );
        vendingMachine.restockProduct2( 1 );
        vendingMachine.restockProduct3( 1 );
        vendingMachine.restockProduct4( 1 );
        assertEquals( "El porcentaje no es correcto", 92, vendingMachine.getPercentOfAvailability( 50 ), 0.1 );
        vendingMachine.restockProduct1( 4 );
        vendingMachine.restockProduct2( 4 );
        vendingMachine.restockProduct3( 4 );
        vendingMachine.restockProduct4( 4 );
        assertEquals( "El porcentaje no es correcto", 60, vendingMachine.getPercentOfAvailability( 50 ), 0.1 );

        // Caso de prueba 3
        setupEscenario1( );
        assertEquals( "El porcentaje no es correcto", 100, vendingMachine.getPercentOfAvailability( 100 ), 0.1 );
        vendingMachine.restockProduct1( 1 );
        vendingMachine.restockProduct2( 1 );
        vendingMachine.restockProduct3( 1 );
        vendingMachine.restockProduct4( 1 );
        assertEquals( "El porcentaje no es correcto", 96, vendingMachine.getPercentOfAvailability( 100 ), 0.1 );
        vendingMachine.restockProduct1( 4 );
        vendingMachine.restockProduct2( 4 );
        vendingMachine.restockProduct3( 4 );
        vendingMachine.restockProduct4( 4 );
        assertEquals( "El porcentaje no es correcto", 80, vendingMachine.getPercentOfAvailability( 100 ), 0.1 );
    }

}
