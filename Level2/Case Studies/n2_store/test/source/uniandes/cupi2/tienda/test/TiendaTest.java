/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_store
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.store.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.store.world.Product;
import uniandes.cupi2.store.world.Store;
import uniandes.cupi2.store.world.Product.Type;

/**
 * Clase usada para verificar que los métodos de la clase Store estén correctamente implementados.
 */
public class StoreTest {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Store store;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Crea una store con cuatro product, dos de ellos de PHARMACY, uno de STATIONERY y uno de SUPERMARKET.
     */
    private void setupEscenario1() {
        store = new Store();
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Methods a probar: </b> <br>
     * Store<br>
     * getProduct1<br>
     * getProduct2<br>
     * getProduct3<br>
     * getProduct4<br>
     * getName<br>
     * getMoneyInRegister<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testStore() {
        setupEscenario1();

        assertNotNull("Debería existir el product 1.", store.getProduct1());
        assertNotNull("Debería existir el product 2.", store.getProduct2());
        assertNotNull("Debería existir el product 3.", store.getProduct3());
        assertNotNull("Debería existir el product 4.", store.getProduct4());
        assertEquals("No debería haber dinero en caja.", 0.0, store.getMoneyInRegister(), 0.0);
    }

    /**
     * Prueba 2: Verifica el método sellProduct.<br>
     * <b> Methods a probar: </b> <br>
     * sellProduct<br>
     * getMoneyInRegister<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se venden todas las unidades.<br>
     * 2. Se venden menos unidades porque no hay suficiente en bodega.
     */
    @Test
    public void testSellProduct() {
        setupEscenario1();
        assertEquals("El result de la sale no corresponde.", 10, store.sellProduct("Pencil", 10));
        assertEquals("El dinero en caja no corresponde", 6380.0, store.getMoneyInRegister(), 0.01);
        assertEquals("El result de la sale no corresponde.", 8, store.sellProduct("Pencil", 30));
        assertEquals("El dinero en caja no corresponde", 11484.0, store.getMoneyInRegister(), 0.01);
    }

    /**
     * Prueba 3: Verifica el método restockProduct.<br>
     * <b> Methods a probar: </b> <br>
     * restockProduct<br>
     * sell<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se puede restock.<br>
     * 2. No se puede restock.
     */
    @Test
    public void testRestockProduct() {
        setupEscenario1();
        assertFalse("No debería poder restock.", store.restockProduct("Pencil", 10));
        store.sellProduct("Pencil", 15);
        assertTrue("Debería poder restock.", store.restockProduct("Pencil", 20));
    }

    /**
     * Prueba 4: Verifica el método getMostSoldProduct.<br>
     * <b> Methods a probar: </b> <br>
     * getMostSoldProduct<br>
     * sellProduct<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún product tiene sales.<br>
     * 2. Todos los products tienen sales.
     */
    @Test
    public void testDarProductMostSold() {
        setupEscenario1();
        assertNull("No debería haber ningún product con sales.", store.getMostSoldProduct());
        store.sellProduct("Pencil", 5);
        store.sellProduct("Bread", 6);
        store.sellProduct("Aspirin", 15);
        store.sellProduct("Eraser", 10);
        assertNotNull("Debería existir al menos un product con sales.", store.getMostSoldProduct());
        assertEquals("El name del product más vendido no corresponde.", "Aspirin", store.getMostSoldProduct().getName());
    }

    /**
     * Prueba 5: Verifica el método getLeastSoldProduct.<br>
     * <b> Methods a probar: </b> <br>
     * getLeastSoldProduct<br>
     * sellProduct<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún product tiene sales.<br>
     * 2. Todos los products tienen sales.
     */
    @Test
    public void testDarProductLeastSold() {
        setupEscenario1();
        assertNull("No debería haber ningún product con sales.", store.getLeastSoldProduct());
        store.sellProduct("Pencil", 5);
        store.sellProduct("Bread", 6);
        store.sellProduct("Aspirin", 15);
        store.sellProduct("Eraser", 10);
        assertNotNull("Debería existir al menos un product con sales.", store.getLeastSoldProduct());
        assertEquals("El name del product menos vendido no corresponde.", "Pencil", store.getLeastSoldProduct().getName());

    }

    /**
     * Prueba 6: Verifica el método getAverageOfSales.<br>
     * <b> Methods a probar: </b> <br>
     * getAverageOfSales<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Ningún product tiene sales.<br>
     * 2. Todos los products tienen sales.
     */
    @Test
    public void testDarAverageSales() {
        setupEscenario1();
        assertEquals("El promedio está mal calculado.", 0.0, store.getAverageOfSales(), 0.01);
        store.sellProduct("Pencil", 5);
        store.sellProduct("Bread", 6);
        store.sellProduct("Aspirin", 15);
        store.sellProduct("Eraser", 10);
        assertEquals("El promedio está mal calculado.", 232.5, store.getAverageOfSales(), 0.01);
    }

    /**
     * Prueba 7: Verifica el método changeProduct.<br>
     * <b> Methods a probar: </b> <br>
     * changeProduct<br>
     * getProduct<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No se cambia el name del product.<br>
     * 2. Se cambia el name del product y no existe un product con ese name.<br>
     * 3. Existe otro product con el mismo name.<br>
     */
    @Test
    public void testChangeProduct() {
        setupEscenario1();

        boolean change = store.changeProduct("Pencil", "Pencil", Type.STATIONERY, 2000, 11, 8, "pencil.jpg");
        assertTrue("Debería haber cambiado el product.", change);
        Product p = store.getProduct("Pencil");
        assertNotNull("El product debería existir", p);
        assertEquals("El valor unitario no es el esperado.", 2000, p.darUnitValue(), 0.01);
        assertEquals("La quantity en bodega no es la esperada", 11, p.darStockQuantity());
        assertEquals("La quantity mínima no es la esperada", 8, p.darMinimumQuantity());

        change = store.changeProduct("Pencil", "Jabón", Type.PHARMACY, 1000, 10, 7, "jabon.jpg");
        assertTrue("Debería haber cambiado el product.", change);
        p = store.getProduct("Jabón");
        assertNotNull("El product debería existir", p);
        assertEquals("El name no es el esperado.", "Jabón", p.getName());
        assertEquals("El valor unitario no es el esperado.", 1000, p.darUnitValue(), 0.01);
        assertEquals("La quantity en bodega no es la esperada", 10, p.darStockQuantity());
        assertEquals("La quantity mínima no es la esperada", 7, p.darMinimumQuantity());

        change = store.changeProduct("Jabón", "Aspirin", Type.PHARMACY, 1000, 10, 7, "aspirin.jpg");
        assertFalse("No debería haber cambiado el product", change);
        p = store.getProduct("Jabón");
        assertNotNull("El product debería existir", p);
    }
}
