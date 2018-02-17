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

import uniandes.cupi2.maquinaExpendedora.mundo.Monto;

/**
 * Clase usada para verificar que los métodos de la clase Monto estén correctamente implementados.
 */
public class MontoTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Monto sobre el cual se van a realizar las pruebas.
     */
    private Monto monto;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo monto sin monedas para realizar las pruebas.
     */
    @Before
    public void setupEscenario1( )
    {
        monto = new Monto( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * <b>Prueba 1</b>: Verifica el método constructor Monto.<br>
     * <b>Métodos a probar: </b><br>
     * Monto<br>
     * darCantidadMonedas1000 <br>
     * darCantidadMonedas500 <br>
     * darCantidadMonedas200 <br>
     * darCantidadMonedas100 <br>
     * darCantidadMonedas50 <br>
     * darValorTotal<br>
     * <b>Casos de prueba:</b><br>
     * 1. El monto no tiene ninguna moneda. <br>
     */
    @Test
    public void testMonto( )
    {
        // Caso de prueba 1
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 1000", 0, monto.darCantidadMonedas1000( ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 500", 0, monto.darCantidadMonedas500( ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 200", 0, monto.darCantidadMonedas200( ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 100", 0, monto.darCantidadMonedas100( ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 50", 0, monto.darCantidadMonedas50( ) );
        assertEquals( "El valor total no es correcto.", 0, monto.darValorTotal( ), 0.01 );

    }
    /**
     * <b>Prueba 2</b>: Verifica el método agregarMoneda.<br>
     * <b>Métodos a probar: </b><br>
     * agregarMoneda <br>
     * darCantidadMonedas1000 <br>
     * darCantidadMonedas500 <br>
     * darCantidadMonedas200 <br>
     * darCantidadMonedas100 <br>
     * darCantidadMonedas50 <br>
     * darValorTotal<br>
     * darCantidadMonedas<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se puede agregar la moneda.<br>
     * 2. No se puede agregar la moneda.
     */
    @Test
    public void testAgregarMoneda( )
    {
        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 1000.", 1, monto.darCantidadMonedas1000( ) );
        assertEquals( "El valor total no es correcto.", 1000, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 1, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 1000.", 2, monto.darCantidadMonedas1000( ) );
        assertEquals( "El valor total no es correcto.", 2000, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 2, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_500 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 500.", 1, monto.darCantidadMonedas500( ) );
        assertEquals( "El valor total no es correcto.", 2500, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 3, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_500 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 500.", 2, monto.darCantidadMonedas500( ) );
        assertEquals( "El valor total no es correcto.", 3000, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 4, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_200 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 200.", 1, monto.darCantidadMonedas200( ) );
        assertEquals( "El valor total no es correcto.", 3200, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 5, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_200 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 200.", 2, monto.darCantidadMonedas200( ) );
        assertEquals( "El valor total no es correcto.", 3400, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 6, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_100 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 100.", 1, monto.darCantidadMonedas100( ) );
        assertEquals( "El valor total no es correcto.", 3500, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 7, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_100 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 100.", 2, monto.darCantidadMonedas100( ) );
        assertEquals( "El valor total no es correcto.", 3600, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 8, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_50 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 50.", 1, monto.darCantidadMonedas50( ) );
        assertEquals( "El valor total no es correcto.", 3650, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 9, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_50 ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 50.", 2, monto.darCantidadMonedas50( ) );
        assertEquals( "El valor total no es correcto.", 3700, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 10, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );
        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );

        // Caso de prueba 2

        assertFalse( "No debería haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_1000 ) );
        assertEquals( "No debería haber aumentado la cantidad de monedas de 1000.", 8, monto.darCantidadMonedas1000( ) );
        assertEquals( "El valor total no es correcto.", 9700, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 16, monto.darCantidadTotalMonedas( ) );

        assertFalse( "No debería haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_500 ) );
        assertEquals( "No debería haber aumentado la cantidad de monedas de 500.", 2, monto.darCantidadMonedas500( ) );
        assertEquals( "El valor total no es correcto.", 9700, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 16, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_200 ) );

        assertFalse( "No debería haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_200 ) );
        assertEquals( "No debería haber aumentado la cantidad de monedas de 200.", 3, monto.darCantidadMonedas200( ) );
        assertEquals( "El valor total no es correcto.", 9900, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 17, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_50 ) );

        assertFalse( "No debería haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_100 ) );
        assertEquals( "No debería haber aumentado la cantidad de monedas de 100.", 2, monto.darCantidadMonedas100( ) );
        assertEquals( "El valor total no es correcto.", 9950, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 18, monto.darCantidadTotalMonedas( ) );

        assertTrue( "Deberia haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_50 ) );

        assertFalse( "No debería haber agregado la moneda.", monto.agregarMoneda( Monto.MONEDA_50 ) );
        assertEquals( "No debería haber aumentado la cantidad de monedas de 500.", 4, monto.darCantidadMonedas50( ) );
        assertEquals( "El valor total no es correcto.", 10000, monto.darValorTotal( ), 0.01 );
        assertEquals( "La cantidad total de monedas no es la esperada", 19, monto.darCantidadTotalMonedas( ) );

    }

    /**
     * <b>Prueba 3</b>: Verifica el método darValorTotal.<br>
     * <b>Métodos a probar: </b><br>
     * darValorTotal<br>
     * agregarMoneda <br>
     * <b>Casos de prueba:</b><br>
     * 1. No hay ninguna moneda en el monto.<br>
     * 2. Hay monedas en el monto.<br>
     */
    @Test
    public void testDarValorTotal( )
    {
        // Caso de prueba 1
        assertEquals( "El valor total no es correcto.", 0, monto.darValorTotal( ), 0.01 );

        // Caso de prueba 2
        monto.agregarMoneda( Monto.MONEDA_1000 );
        assertEquals( "El valor total no es correcto.", 1000, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_500 );
        assertEquals( "El valor total no es correcto.", 1500, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_200 );
        assertEquals( "El valor total no es correcto.", 1700, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_100 );
        assertEquals( "El valor total no es correcto.", 1800, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_50 );
        assertEquals( "El valor total no es correcto.", 1850, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_50 );
        assertEquals( "El valor total no es correcto.", 1900, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_100 );
        assertEquals( "El valor total no es correcto.", 2000, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_200 );
        assertEquals( "El valor total no es correcto.", 2200, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_500 );
        assertEquals( "El valor total no es correcto.", 2700, monto.darValorTotal( ), 0.01 );

        monto.agregarMoneda( Monto.MONEDA_1000 );
        assertEquals( "El valor total no es correcto.", 3700, monto.darValorTotal( ), 0.01 );
    }

    /**
     * <b> Prueba 4: </b> Verifica el método darCantidadMonedas. <br>
     * <b>Métodos a probar: </b> <br>
     * darCantidadMonedas <br>
     * <b> Casos de prueba:</b><br>
     * 1. No hay ninguna moneda en el monto <br>
     * 2. Hay monedas de 100 en el monto.<br>
     * 3. Hay monedas de 500 en el monto.<br>
     * 4. Hay monedas de 1000 en el monto.<br>
     * 5. Hay monedas de 200 en el monto.<br>
     * 6. Hay monedas de 50 en el monto.<br>
     */
    @Test
    public void testDarCantidadTotalMonedas( )
    {
        // Caso de prueba 1
        assertEquals( "La cantidad total de monedas no es la esperada.", 0, monto.darCantidadTotalMonedas( ) );

        // Caso de prueba 2
        monto.agregarMoneda( Monto.MONEDA_100 );
        assertEquals( "La cantidad total de monedas no es la esperada", 1, monto.darCantidadTotalMonedas( ) );

        // Caso de prueba 3
        monto.agregarMoneda( Monto.MONEDA_500 );
        assertEquals( "La cantidad total de monedas no es la esperada", 2, monto.darCantidadTotalMonedas( ) );

        // Caso de prueba 4
        monto.agregarMoneda( Monto.MONEDA_1000 );
        assertEquals( "La cantidad total de monedas no es la esperada", 3, monto.darCantidadTotalMonedas( ) );

        // Caso de prueba 5
        monto.agregarMoneda( Monto.MONEDA_200 );
        assertEquals( "La cantidad total de monedas no es la esperada", 4, monto.darCantidadTotalMonedas( ) );

        // Caso de prueba 6
        monto.agregarMoneda( Monto.MONEDA_50 );
        assertEquals( "La cantidad total de monedas no es la esperada", 5, monto.darCantidadTotalMonedas( ) );
    }

    /**
     * <b> Prueba 5: </b> Verifica el método reiniciar. <br>
     * <b>Métodos a probar: </b> <br>
     * reiniciar<br>
     * agregarMoneda <br>
     * darValorTotal<br>
     * darCantidadMonedas <br>
     * <b> Casos de prueba:</b><br>
     * 1. Hay monedas en el monto.<br>
     */
    @Test
    public void testReiniciar( )
    {

        // Caso de prueba 1
        monto.agregarMoneda( Monto.MONEDA_100 );
        monto.agregarMoneda( Monto.MONEDA_200 );
        monto.agregarMoneda( Monto.MONEDA_500 );

        monto.reiniciar( );
        assertEquals( "La cantidad total de monedas no es la esperada.", 0, monto.darCantidadTotalMonedas( ) );
        assertEquals( "El valor total del monto no es el esperado.", 0, monto.darValorTotal( ), 0.01 );

    }

    /**
     * <b>Prueba 6</b>: Verifica el método cambiarValor.<br>
     * <b>Métodos a probar: </b><br>
     * cambiarValor<br>
     * darCantidadMonedas1000 <br>
     * darCantidadMonedas500 <br>
     * darCantidadMonedas200 <br>
     * darCantidadMonedas100 <br>
     * darCantidadMonedas50 <br>
     * darValorTotal<br>
     * <b>Casos de prueba:</b><br>
     * 1. Se crea el monto con un valor de $9950. <br>
     */
    @Test
    public void testCambiarValor( )
    {
        monto.cambiarValor( 9950 );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 1000", 9, monto.darCantidadMonedas1000( ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 500", 1, monto.darCantidadMonedas500( ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 200", 2, monto.darCantidadMonedas200( ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 100", 0, monto.darCantidadMonedas100( ) );
        assertEquals( "No se asignaron correctamente la cantidad de monedas de 50", 1, monto.darCantidadMonedas50( ) );
        assertEquals( "El valor total no es correcto.", 9950, monto.darValorTotal( ), 0.01 );

    }
}
