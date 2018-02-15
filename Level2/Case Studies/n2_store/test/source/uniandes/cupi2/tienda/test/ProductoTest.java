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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uniandes.cupi2.store.world.Product;
import uniandes.cupi2.store.world.Product.Type;

/**
 * Clase usada para verificar que los métodos de la clase Product estén correctamente implementados.
 */
public class ProductTest {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Product product;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo product sin unidades vendidas.
     */
    private void setupEscenario1() {
        product = new Product(Type.PHARMACY, "pastilla", 1000.0, 50, 25, "pastilla.jpg");
    }

    /**
     * Prueba 1: Verifica el método constructor.<br>
     * <b> Methods a probar: </b> <br>
     * Product<br>
     * darType<br>
     * getName<br>
     * darUnitValue<br>
     * darStockQuantity<br>
     * darMinimumQuantity<br>
     * darQuantityidadVendidad<br>
     * darImagePath<br>
     * calculateFinalPrice<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Los valores de los atributos corresponden.
     */
    @Test
    public void testProduct() {
        setupEscenario1();
        System.out.println("Precio con iva: " + product.calculateFinalPrice());
        assertEquals("El name no corresponde.", "pastilla", product.getName());
        assertTrue("El type no corresponde.", Type.PHARMACY == product.darType());
        assertEquals("El valor unitario no corresponde.", 1000.0, product.darUnitValue(), 0.01);
        assertEquals("La quantity mínima no corresponde.", 25, product.darMinimumQuantity());
        assertEquals("La quantity en bodega no corresponde.", 50, product.darStockQuantity());
        assertEquals("La ruta de la imagen no corresponde.", "pastilla.jpg", product.darImagePath());
        assertEquals("La quantity de vendidas no corresponde.", 0, product.getQuantityUnitsSold());
        assertEquals("El precio final no corresponde.", 1120.0, product.calculateFinalPrice(), 0.01);
    }

    /**
     * Prueba 2: Verifica el método sell.<br>
     * <b> Methods a probar: </b> <br>
     * sell<br>
     * darStockQuantity<br>
     * darQuantitySold<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Logra sell todas las unidades. <br>
     * 2. No logra sell todas las unidades.
     */
    @Test
    public void testSell() {
        setupEscenario1();
        assertEquals("Debería realizar la sale de 10.", 10, product.sell(10));
        assertEquals("La quantity en bodega no corresponde.", 40, product.darStockQuantity());
        assertEquals("La quantity de vendidas no corresponde.", 10, product.getQuantityUnitsSold());
        assertEquals("Debería realizar la sale de 40.", 40, product.sell(50));
        assertEquals("La quantity en bodega no corresponde.", 0, product.darStockQuantity());
        assertEquals("La quantity de vendidas no corresponde.", 50, product.getQuantityUnitsSold());
    }

    /**
     * Prueba 3: Verifica el método restock.<br>
     * <b> Methods a probar: </b> <br>
     * darStockQuantity<br>
     * restock<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Logra restock las unidades.
     */
    @Test
    public void testRestock() {
        setupEscenario1();
        product.restock(10);
        assertEquals("Debería aumentar la quantity en bodega.", 60, product.darStockQuantity());
    }
}