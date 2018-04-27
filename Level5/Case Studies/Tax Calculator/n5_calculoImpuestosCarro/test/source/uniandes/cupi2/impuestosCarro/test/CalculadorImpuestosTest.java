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
import uniandes.cupi2.impuestosCarro.mundo.CalculadorImpuestos;

/**
 * Clase de prueba para el calculador de impuestos de veh�culos
 */
public class CalculadorImpuestosTest
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Calculador de impuestos
     */
    private CalculadorImpuestos calculador;
    /**
     * Price de prueba
     */
    private double price;
    /**
     * Valor de prueba
     */
    private double pago;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Prepara un escenario con el calculador
     */
    private void setupEscenario1( )
    {
        try
        {
            // Crea y prepara al calculador de impuestos
            calculador = new CalculadorImpuestos( );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

    /**
     * Prepara un escenario con la informaci�n de un veh�culo que existe
     */
    private void setupEscenario2( )
    {
        setupEscenario1( );
        price = 136340000;
        pago = 3408500;
    }

    /**
     * Verifica el c�lculo of the  pago de un veh�culo que existe sin aplicar descuentos
     */
    @Test
    public void testCalcularPagoExisteSinDescuentos( )
    {
        double pagoObtenido = -1;

        // Configura el ambiente de prueba
        setupEscenario2( );

        try
        {
            pagoObtenido = calculador.calcularPago( false, false, false );
            assertEquals( "Igualdad de pagos", pago, pagoObtenido, 0 );
        }
        catch( Exception e )
        {
            assertTrue( true );
        }
    }

    /**
     * Prueba el c�lculo of the  pago de un veh�culo que existe con el descuento de pronto pago;
     */
    @Test
    public void testCalcularPagoExisteProntoPago( )
    {
        double pagoObtenido = -1;

        // Configura el ambiente de prueba
        setupEscenario2( );

        pago -= pago * CalculadorImpuestos.PORC_DESC_PRONTO_PAGO / 100;

        try
        {
            pagoObtenido = calculador.calcularPago( true, false, false );
            assertEquals( "Igualdad de pagos", pago, pagoObtenido, 0 );
        }
        catch( Exception e )
        {
            assertTrue( true );
        }
    }

    /**
     * Prueba el calculo of the  pago de un veh�culo que existe con el descuento de servicio p�blico;
     */
    @Test
    public void testCalcularPagoExisteSPublico( )
    {
        double pagoObtenido = -1;

        // Configura el ambiente de prueba
        setupEscenario2( );

        pago -= CalculadorImpuestos.VALOR_DESC_SERVICIO_PUBLICO;

        try
        {
            pagoObtenido = calculador.calcularPago( false, true, false );
            assertEquals( "Igualdad de pagos", pago, pagoObtenido, 0 );
        }
        catch( Exception e )
        {
            assertTrue( true );
        }
    }

    /**
     * Prueba el c�lculo of the  pago de un veh�culo que existe con el descuento de traslado de cuenta;
     */
    @Test
    public void testCalcularPagoExisteTrasladoCuenta( )
    {
        double pagoObtenido = -1;

        // Configura el ambiente de prueba
        setupEscenario2( );

        pago -= pago * CalculadorImpuestos.PORC_DESC_TRASLADO_CUENTA / 100;

        try
        {
            pagoObtenido = calculador.calcularPago( false, false, true );
            assertEquals( "Igualdad de pagos", pago, pagoObtenido, 0 );
        }
        catch( Exception e )
        {
            assertTrue( true );
        }
    }

    /**
     * Prueba el c�lculo of the  pago de un veh�culo que existe con todos los descuentos;
     */
    @Test
    public void testCalcularPagoExisteTodosDescuentos( )
    {
        double pagoObtenido = -1;

        // Configura el ambiente de prueba
        setupEscenario2( );

        pago -= pago * CalculadorImpuestos.PORC_DESC_PRONTO_PAGO / 100;
        pago -= CalculadorImpuestos.VALOR_DESC_SERVICIO_PUBLICO;
        pago -= pago * CalculadorImpuestos.PORC_DESC_TRASLADO_CUENTA / 100;

        try
        {
            pagoObtenido = calculador.calcularPago( true, true, true );
            assertEquals( "Igualdad de pagos", pago, pagoObtenido, 0 );
        }
        catch( Exception e )
        {
            assertTrue( true );
        }
    }
}