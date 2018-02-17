/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_maquinaExpendedora
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.maquinaExpendedora.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import uniandes.cupi2.maquinaExpendedora.mundo.Producto;
import uniandes.cupi2.maquinaExpendedora.mundo.Producto.Tipo;

/**
 * Clase usada para verificar que los métodos de la clase Producto estén correctamente implementados.
 */
public class ProductoTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto en el cual se harán las pruebas
     */
    private Producto producto;

    /**
     * Producto FOPRE en el cual se harán las pruebas
     */
    private Producto productoFopre;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo producto para realizar las pruebas.
     */
    @Before
    public void setupEscenario1( )
    {
        producto = new Producto( "F2", "Fuze Tea", 1300, false, Tipo.BEBIDA );
        productoFopre = new Producto( "H4", "Gansito", 850, true, Tipo.COMIDA );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------

    /**
     * <b>Prueba 1</b> : verifica el método constructor Producto.<br>
     * <b>Métodos a probar: </b><br>
     * Producto<br>
     * darIdentificador<br>
     * darNombre<br>
     * darPrecio<br>
     * esFopre<br>
     * darCantidadUnidadesDisponibles<br>
     * darCantidadUnidadesVendidas<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el producto correctamente.
     */
    @Test
    public void testProducto( )
    {
        // Caso de prueba 1
        assertEquals( "El identificador asignado no corresponde", "F2", producto.darIdentificador( ) );
        assertEquals( "El nombre asignado no corresponde", "Fuze Tea", producto.darNombre( ) );
        assertEquals( "El precio asignado no corresponde", 1300, producto.darPrecio( ), 0.1 );
        assertEquals( "La cantidad de unidades disponibles no se asignó correctamente", 10, producto.darCantidadUnidadesDisponibles( ), 0.01 );
        assertEquals( "La cantidad de unidades vendidas no se asignó correctamente", 0, producto.darCantidadUnidadesCompradas( ), 0.01 );

        assertFalse( "El indicador de FOPRE no fue asignado correctamente", producto.esFopre( ) );
        assertTrue( "El indicador de FOPRE no fue asignado correctamente", productoFopre.esFopre( ) );
        assertEquals( "El tipo no se asigno correctamente", Tipo.BEBIDA, producto.darTipo( ) );
        assertEquals( "El tipo no se asigno correctamente", Tipo.COMIDA, productoFopre.darTipo( ) );
    }


    /**
     * <b>Prueba 2</b> : Verifica el método vender.<br>
     * <b>Métodos a probar: </b><br>
     * vender<br>
     * abastecer<br>
     * darCantidadUnidadesDisponibles<br>
     * darCantidadUnidadesVendidas<br>
     * <b>Casos de prueba:</b><br>
     * 1. Hay unidades disponibles. <br>
     * 2. No hay unidades disponibles. <br>
     */
    @Test
    public void testVender( )
    {
        // Caso de prueba 1
        assertTrue( "El producto debería haberse vendido.", producto.comprar( ) );
        assertEquals( "La cantidad de unidades disponibles no es la esperada.", 9, producto.darCantidadUnidadesDisponibles( ) );
        assertEquals( "La cantidad de unidades vendidas no es la esperada.", 1, producto.darCantidadUnidadesCompradas( ) );

        assertTrue( "El producto debería haberse vendido.", producto.comprar( ) );
        assertEquals( "La cantidad de unidades disponibles no es la esperada.", 8, producto.darCantidadUnidadesDisponibles( ) );
        assertEquals( "La cantidad de unidades vendidas no es la esperada.", 2, producto.darCantidadUnidadesCompradas( ) );

        producto.comprar( );
        producto.comprar( );
        producto.comprar( );
        producto.comprar( );
        producto.comprar( );
        producto.comprar( );
        producto.comprar( );
        
        assertTrue( "El producto debería haberse vendido.", producto.comprar( ) );
        assertEquals( "La cantidad de unidades disponibles no es la esperada.", 0, producto.darCantidadUnidadesDisponibles( ) );
        assertEquals( "La cantidad de unidades vendidas no es la esperada.", 10, producto.darCantidadUnidadesCompradas( ) );

        // Caso de prueba 2
        assertFalse( "No debería poder vender el producto.", producto.comprar( ) );
        assertEquals( "El producto no fue vendido correctamente.", 0, producto.darCantidadUnidadesDisponibles( ) );
        assertEquals( "No se debieron vender unidades.", 10, producto.darCantidadUnidadesCompradas( ) );
    }
    /**
     * <b>Prueba 3</b>: Verifica el método calcularDonacionFopre.<br>
     * <b>Métodos a probar: </b><br>
     * calcularDonacionFopre<br>
     * abastecer<br>
     * vender<br>
     * <b>Casos de prueba:</b><br>
     * 1. El producto no aporta al FOPRE. <br>
     * 2. El producto no aporta al FOPRE.
     */
    @Test
    public void testCalcularDonacionFopre( )
    {
        // Caso de prueba 1
        producto.comprar( );
        producto.comprar( );
        producto.comprar( );
        assertEquals( "Los productos que no son FOPRE no deben aportar.", 0, producto.calcularDonacionFopre( ), 0.01 );

        // Caso de prueba 2
        productoFopre.comprar( );
        assertEquals( "El valor de la donación no es correcto.", 51, productoFopre.calcularDonacionFopre( ), 0.01 );

        productoFopre.comprar( );
        productoFopre.comprar( );
        productoFopre.comprar( );
        assertEquals( "El valor de la donación no es correcto.", 204, productoFopre.calcularDonacionFopre( ), 0.01 );

    }
}
