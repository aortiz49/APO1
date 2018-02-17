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

import uniandes.cupi2.maquinaExpendedora.mundo.MaquinaExpendedora;
import uniandes.cupi2.maquinaExpendedora.mundo.Monto;
import uniandes.cupi2.maquinaExpendedora.mundo.Producto;
import uniandes.cupi2.maquinaExpendedora.mundo.Producto.Tipo;

/**
 * Clase usada para verificar que los métodos de la clase MaquinaExpendedora.
 */
public class MaquinaExpendedoraTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Máquina expendedora sobre se cual se realizarán las pruebas.
     */
    private MaquinaExpendedora maquinaExpendedora;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    /**
     * Crea una instancia de la clase maquinaExpendedora.
     */
    @Before
    public void setupEscenario1( )
    {
        maquinaExpendedora = new MaquinaExpendedora( );
    }

    // -----------------------------------------------------------------
    // Métodos de prueba
    // -----------------------------------------------------------------

    /**
     * <b>Prueba 1</b>: Verifica el método constructor MaquinaExpendedora.<br>
     * <b>Métodos a probar: </b><br>
     * MaquinaExpendedora<br>
     * darValorCredito <br>
     * darProducto<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea la máquina expendedora correctamente.
     */
    @Test
    public void testMaquinaExpendedora( )
    {
        assertEquals( "El crédito inicial de la máquina no corresponde", 0, maquinaExpendedora.darValorCredito( ), 0.1 );

        Producto p1 = maquinaExpendedora.darProducto( "A1" );
        assertNotNull( "El producto 1 no debe ser null", p1 );
        assertEquals( "El identificador asignado no corresponde", "A1", p1.darIdentificador( ) );
        assertEquals( "El nombre del producto asignado no corresponde", "Papas Natural Margarita", p1.darNombre( ) );
        assertEquals( "El precio asignado no corresponde", 1300, p1.darPrecio( ), 0.1 );
        assertEquals( "El tipo asignado no corresponde", Tipo.COMIDA, p1.darTipo( ) );
        assertTrue( "El indicador de FOPRE no coressponde", p1.esFopre( ) );

        Producto p2 = maquinaExpendedora.darProducto( "A2" );
        assertNotNull( "El producto 2 no debe ser null", p2 );
        assertEquals( "El identificador asignado no corresponde", "A2", p2.darIdentificador( ) );
        assertEquals( "El nombre del producto asignado no corresponde", "Jugo Hit", p2.darNombre( ) );
        assertEquals( "El precio asignado no corresponde", 2000, p2.darPrecio( ), 0.1 );
        assertEquals( "El tipo asignado no corresponde", Tipo.BEBIDA, p2.darTipo( ) );
        assertTrue( "El indicador de FOPRE no coressponde", p2.esFopre( ) );

        Producto p3 = maquinaExpendedora.darProducto( "B1" );
        assertNotNull( "El producto 3 no debe ser null", p3 );
        assertEquals( "El identificador asignado no corresponde", "B1", p3.darIdentificador( ) );
        assertEquals( "El nombre del producto asignado no corresponde", "Chocolatina Jet", p3.darNombre( ) );
        assertEquals( "El precio asignado no corresponde", 450, p3.darPrecio( ), 0.1 );
        assertEquals( "El tipo asignado no corresponde", Tipo.COMIDA, p3.darTipo( ) );
        assertFalse( "El indicador de FOPRE no coressponde", p3.esFopre( ) );

        Producto p4 = maquinaExpendedora.darProducto( "B2" );
        assertNotNull( "El producto 4 no debe ser null", p4 );
        assertEquals( "El identificador asignado no corresponde", "B2", p4.darIdentificador( ) );
        assertEquals( "El nombre del producto asignado no corresponde", "Galletas Festival", p4.darNombre( ) );
        assertEquals( "El precio asignado no corresponde", 800, p4.darPrecio( ), 0.1 );
        assertEquals( "El tipo asignado no corresponde", Tipo.COMIDA, p4.darTipo( ) );
        assertFalse( "El indicador de FOPRE no coressponde", p4.esFopre( ) );
    }

    /**
     * <b>Prueba 2</b> : Verifica el método agregarMoneda.<br>
     * <b>Métodos a probar: </b><br>
     * agregarMoneda<br>
     * darValorCredito<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se puede agregar una moneda. <br>
     * 2. No se puede agregar una moneda.
     */
    @Test
    public void testAgregarMoneda( )
    {
        // Caso de prueba 1
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 ) );
        assertEquals( "El crédito la máquina no corresponde", 3000, maquinaExpendedora.darValorCredito( ), 0.1 );

        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 ) );

        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_200 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_200 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_200 ) );
        assertEquals( "El crédito la máquina no corresponde", 5600, maquinaExpendedora.darValorCredito( ), 0.1 );

        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_100 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_100 ) );
        assertEquals( "El crédito la máquina no corresponde", 5800, maquinaExpendedora.darValorCredito( ), 0.1 );

        assertTrue( "Debería agregar la moneda a la máquina",maquinaExpendedora.agregarMoneda( Monto.MONEDA_50 ));
        assertEquals( "El crédito la máquina no corresponde", 5850, maquinaExpendedora.darValorCredito( ), 0.1 );

        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 ) );
        
        // Caso de prueba 2
        assertFalse( "No debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 ) );
        assertEquals( "El crédito la máquina no corresponde", 9850, maquinaExpendedora.darValorCredito( ), 0.1 );

        assertFalse( "No debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 ) );
        assertEquals( "El crédito la máquina no corresponde", 9850, maquinaExpendedora.darValorCredito( ), 0.1 );

        assertFalse( "No debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_200 ) );
        assertEquals( "El crédito la máquina no corresponde", 9850, maquinaExpendedora.darValorCredito( ), 0.1 );

        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_100 ) );

        assertFalse( "No debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_100 ) );
        assertEquals( "El crédito la máquina no corresponde", 9950, maquinaExpendedora.darValorCredito( ), 0.1 );

        assertTrue( "Debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_50 ) );

        assertFalse( "No debería agregar la moneda a la máquina", maquinaExpendedora.agregarMoneda( Monto.MONEDA_50 ) );
        assertEquals( "El crédito la máquina no corresponde", 10000, maquinaExpendedora.darValorCredito( ), 0.1 );
    }

    /**
     * <b>Prueba 4</b>: Verifica el método compraProducto.<br>
     * <b>Métodos a probar: </b><br>
     * comprarProducto<br>
     * darProducto<br>
     * abastecerProducto<br>
     * * <b>Casos de prueba:</b><br>
     * 1. No hay crédito suficiente <br>
     * 2. Hay suficientes unidades disponibles y hay crédito suficiente para hacer la venta. <br>
     * 3. No hay unidades disponibles <br>
     */
    @Test
    public void testComprarProducto( )
    {
        // Caso de prueba 1

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_200 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_200 );

        assertFalse( "No debe retornar cambio.", maquinaExpendedora.comprarProducto( "A1" ) );
        assertFalse( "No debe retornar cambio.", maquinaExpendedora.comprarProducto( "A2" ) );
        assertFalse( "No debe retornar cambio.", maquinaExpendedora.comprarProducto( "B1" ) );
        assertFalse( "No debe retornar cambio.", maquinaExpendedora.comprarProducto( "B2" ) );

        assertEquals( "No se debió modificar el crédito.", 400.0, maquinaExpendedora.darValorCredito( ), 0.01 );

        // Caso de prueba 2
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );

        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "A1" ) );
        assertEquals( "Las unidades disponibles no corresponden", 9, maquinaExpendedora.darProducto( "A1" ).darCantidadUnidadesDisponibles( ), 0.01 );
        assertEquals( "El crédito no es el esperado.", 4100.0, maquinaExpendedora.darValorCredito( ), 0.01 );

        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "A2" ) );
        assertEquals( "Las unidades disponibles no corresponden", 9, maquinaExpendedora.darProducto( "A2" ).darCantidadUnidadesDisponibles( ), 0.01 );
        assertEquals( "El crédito no es el esperado.", 2100.0, maquinaExpendedora.darValorCredito( ), 0.01 );

        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertEquals( "Las unidades disponibles no corresponden", 9, maquinaExpendedora.darProducto( "B1" ).darCantidadUnidadesDisponibles( ), 0.01 );
        assertEquals( "El crédito no es el esperado.", 1650.0, maquinaExpendedora.darValorCredito( ), 0.01 );

        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B2" ) );
        assertEquals( "Las unidades disponibles no corresponden", 9, maquinaExpendedora.darProducto( "B2" ).darCantidadUnidadesDisponibles( ), 0.01 );
        assertEquals( "El crédito no es el esperado.", 850.0, maquinaExpendedora.darValorCredito( ), 0.01 );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );

        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertTrue( "Debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );

        // Caso de prueba 3
        assertFalse( "No debió comprar  el  producto", maquinaExpendedora.comprarProducto( "B1" ) );
        assertEquals( "No se debió modificar el crédito.", 800, maquinaExpendedora.darValorCredito( ), 0.01 );
    }

    /**
     * <b>Prueba 5</b>: Verifica el método darCantidadTotalUnidadesCompradas.<br>
     * <b>Métodos a probar: </b><br>
     * darCantidadTotalUnidadesCompradas<br>
     * comprarProducto<br>
     * * <b>Casos de prueba:</b><br>
     * 1. No se ha comprado ningún producto.<br>
     * 2. Hay productos comprados.
     */
    @Test
    public void testCantidadTotalUnidadesCompradas( )
    {
        // Caso de prueba 1
        assertEquals( "La cantidad total de compras no es correcta", 0, maquinaExpendedora.darCantidadTotalUnidadesCompradas( ), .01 );

        // Caso de prueba 2

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );

        maquinaExpendedora.comprarProducto( "A1" );
        assertEquals( "La cantidad total de compras no es correcta", 1, maquinaExpendedora.darCantidadTotalUnidadesCompradas( ), .01 );
        maquinaExpendedora.comprarProducto( "B1" );
        assertEquals( "La cantidad total de compras no es correcta", 2, maquinaExpendedora.darCantidadTotalUnidadesCompradas( ), .01 );

        maquinaExpendedora.comprarProducto( "A2" );
        assertEquals( "La cantidad total de compras no es correcta", 3, maquinaExpendedora.darCantidadTotalUnidadesCompradas( ), .01 );

        maquinaExpendedora.comprarProducto( "B2" );
        assertEquals( "La cantidad total de compras no es correcta", 4, maquinaExpendedora.darCantidadTotalUnidadesCompradas( ), .01 );
    }

    /**
     * <b>Prueba 6</b>: Verifica el método darValorTotalCompras.<br>
     * <b>Métodos a probar: </b><br>
     * darValorTotalCompras<br>
     * abastecerProducto<br>
     * comprarProducto<br>
     * * <b>Casos de prueba:</b><br>
     * 1. No se ha comprado ningún producto.<br>
     * 2. Hay productos comprados.
     */
    @Test
    public void testDarValorTotalCompras( )
    {
        // Caso de prueba 1
        assertEquals( "El valor de la compras no es el esperado.", 0, maquinaExpendedora.darValorTotalCompras( ), 0.01 );

        // Caso de prueba 2

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );

        maquinaExpendedora.comprarProducto( "A1" );
        assertEquals( "El valor de la compras no es el esperado.", 1300, maquinaExpendedora.darValorTotalCompras( ), 0.01 );

        maquinaExpendedora.comprarProducto( "B1" );
        assertEquals( "El valor de la compras no es el esperado.", 1750, maquinaExpendedora.darValorTotalCompras( ), 0.01 );

        maquinaExpendedora.comprarProducto( "A2" );
        assertEquals( "El valor de la compras no es el esperado.", 3750, maquinaExpendedora.darValorTotalCompras( ), 0.01 );

        maquinaExpendedora.comprarProducto( "B2" );
        assertEquals( "La cantidad total de compras no es correcta", 4550, maquinaExpendedora.darValorTotalCompras( ), 0.01 );
    }

    /**
     * <b>Prueba 7</b>: Verifica el método darPorcentajeDisponibilidad.<br>
     * <b>Métodos a probar: </b><br>
     * darPorcentajeDisponibilidad<br>
     * comprarProducto<br>
     * <b>Casos de prueba:</b><br>
     * 1. La máquina está llena.<br>
     * 2. Hay productos en la máquina, pero no está llena.<br>
     * 3. No hay ningún producto en la máquina.<br>
     */
    @Test
    public void testDarPorcentajeDisponibilidad( )
    {
  
        // Caso de prueba 1
        assertEquals( "El porcentaje no es correcto", 0, maquinaExpendedora.darPorcentajeDisponibilidad( ), 0.1 );

        // Caso de prueba 2

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        assertEquals( "El porcentaje no es correcto", 25, maquinaExpendedora.darPorcentajeDisponibilidad( ), 0.1 );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_500 );
        maquinaExpendedora.comprarProducto( "B1" );
        assertEquals( "El porcentaje no es correcto", 50, maquinaExpendedora.darPorcentajeDisponibilidad( ), 0.1 );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        assertEquals( "El porcentaje no es correcto", 75, maquinaExpendedora.darPorcentajeDisponibilidad( ), 0.1 );

     // Caso de prueba 3

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        assertEquals( "El porcentaje no es correcto.", 100, maquinaExpendedora.darPorcentajeDisponibilidad( ), 0.1 );

    }

    /**
     * <b>Prueba 8</b>: Verifica el método darDonacionPorTipo.<br>
     * <b>Métodos a probar: </b><br>
     * darDonacionPorTipo<br>
     * <b>Casos de prueba:</b><br>
     * 1. No se ha comprado ningún producto. <br>
     * 3. Se han comprado productos que no son FOPRE.<br>
     * 2. Se han comprado varios productos FOPRE.<br>
     */
    @Test
    public void testDarDonacionPorTipo( )
    {

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );

        // Caso de prueba 1
        assertEquals( "El valor no es el esperado.", 0, maquinaExpendedora.darDonacionPorTipo( Tipo.COMIDA ), 0.01 );

        assertEquals( "El valor no es el esperado.", 0, maquinaExpendedora.darDonacionPorTipo( Tipo.BEBIDA ), 0.01 );

        // Caso de prueba 2
        maquinaExpendedora.comprarProducto( "B1" );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );

        maquinaExpendedora.comprarProducto( "B1" );
        assertEquals( "La donación no es la esperada", 0, maquinaExpendedora.darDonacionPorTipo( Tipo.COMIDA ), 0.01 );

        // Caso de prueba 3
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        assertEquals( "La donación no es la esperada", 156, maquinaExpendedora.darDonacionPorTipo( Tipo.COMIDA ), 0.01 );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        assertEquals( "La donación no es la esperada", 360, maquinaExpendedora.darDonacionPorTipo( Tipo.BEBIDA ), 0.01 );

    }

    /**
     * <b>Prueba 9</b>: Verifica el método darCantidadUnidadesCompradasFopre.<br>
     * <b>Métodos a probar: </b><br>
     * darCantidadUnidadesCompradasFopre<br>
     * agregarMoneda<br>
     * comprarProducto <br>
     * <b>Casos de prueba:</b><br>
     * <b>Casos de prueba:</b><br>
     * 1. No se ha comprado ningún producto. <br>
     * 3. Se han comprado productos que no son FOPRE.<br>
     * 2. Se han comprado varios productos FOPRE.<br>
     */
    @Test
    public void testDarCantidadUnidadesCompradasFopre( )
    {
        // Caso de prueba 1
        assertEquals( "El valor no es el esperado.", 0, maquinaExpendedora.darCantidadUnidadesCompradasFopre( Tipo.COMIDA ), 0.01 );
        assertEquals( "El valor no es el esperado.", 0, maquinaExpendedora.darCantidadUnidadesCompradasFopre( Tipo.BEBIDA ), 0.01 );

        // Caso de prueba 2

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B1" );
        assertEquals( "La donación no es la esperada", 0, maquinaExpendedora.darCantidadUnidadesCompradasFopre( Tipo.COMIDA ), 0.01 );

        // Caso de prueba 3
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        assertEquals( "La donación no es la esperada", 3, maquinaExpendedora.darCantidadUnidadesCompradasFopre( Tipo.COMIDA ), 0.01 );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        assertEquals( "La donación no es la esperada", 4, maquinaExpendedora.darCantidadUnidadesCompradasFopre( Tipo.BEBIDA ), 0.01 );
    }

    /**
     * <b>Prueba 10</b>: Verifica el método darProductoMascomprado.<br>
     * <b>Métodos a probar: </b><br>
     * darProductoMascomprado<br>
     * abastecerProducto<br>
     * agregarMoneda<br>
     * comprarProducto <br>
     * <b>Casos de prueba:</b><br>
     * 2. Ya se compraron varios productos.
     */
    @Test
    public void testDarProductoMasComprado( )
    {
        Producto mascomprado;

        // Caso de prueba 1

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );

        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        mascomprado = maquinaExpendedora.darProductoMasComprado( );
        assertNotNull( "El producto más comprado debe ser diferente a null.", mascomprado );
        assertEquals( "El producto más comprado no es el correcto.", "B1", mascomprado.darIdentificador( ) );

        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A2" );
        mascomprado = maquinaExpendedora.darProductoMasComprado( );
        assertNotNull( "El producto más comprado debe ser diferente a null.", mascomprado );
        assertEquals( "El producto más comprado no es el correcto.", "A2", mascomprado.darIdentificador( ) );

        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        mascomprado = maquinaExpendedora.darProductoMasComprado( );
        assertNotNull( "El producto más comprado debe ser diferente a null.", mascomprado );
        assertEquals( "El producto más comprado no es el correcto.", "A1", mascomprado.darIdentificador( ) );

        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        mascomprado = maquinaExpendedora.darProductoMasComprado( );
        assertNotNull( "El producto más comprado debe ser diferente a null", mascomprado );
        assertEquals( "El producto más comprado no es el correcto", "B2", mascomprado.darIdentificador( ) );
    }
    
    /**
     * <b>Prueba 14</b> : verifica el método darDonacionTotal.<br>
     * <b>Métodos a probar: </b><br>
     * darDonacionTotal<br>
     * agregarMoneda<br>
     * comprarProducto <br>
     * <b>Casos de prueba:</b><br>
     * 1. No se ha comprado ningún producto. <br>
     * 2. Ya se compraron productos.<br>
     */
    @Test
    public void testDarDonacionTotal( )
    {
        // Caso de prueba 1
        assertEquals( "La donación total no corresponde", 0, maquinaExpendedora.darDonacionTotal( ), 0.01 );

        // Caso de prueba 2

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        assertEquals( "La donación total no corresponde", 156, maquinaExpendedora.darDonacionTotal( ), 0.01 );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B1" );
        assertEquals( "La donación total no corresponde", 156, maquinaExpendedora.darDonacionTotal( ), 0.01 );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "A1" );
        assertEquals( "La donación total no corresponde", 312, maquinaExpendedora.darDonacionTotal( ), 0.01 );

        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.agregarMoneda( Monto.MONEDA_1000 );
        maquinaExpendedora.comprarProducto( "B2" );
        assertEquals( "La donación total no corresponde", 312, maquinaExpendedora.darDonacionTotal( ), 0.01 );
    }

}
