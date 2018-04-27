/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Impuestos de Carros
 * Autor: Katalina Marcos.
 * Modificaci�n: Diana Puentes - Jun 23, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.impuestosCarro.test;

import java.util.ArrayList;

import org.junit.Test;

import uniandes.cupi2.impuestosCarro.mundo.Vehicle;

import static org.junit.Assert.*;

/**
 * Clase de prueba para la line de un model
 */
public class VehicleTest
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Veh�culo of the  prueba 1
     */
    private Vehicle vehiculo1;

    /**
     * Name of the line
     */
    private String line;

    /**
     * Name of the brand
     */
    private String brand;

    /**
     * Year of the  model
     */
    private String year;

    /**
     * Price of the  veh�culo de este model
     */
    private double price;

    /**
     * ImagePath of the  imagen of the  veh�culo
     */
    private String imagePath;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Escenario con una line sin models
     */
    private void setupEscenario1( )
    {
        brand = "Chevrolet";
        line = "Silverado";
        year = "2017";
        price = 147000000;
        imagePath = "silverado2017.jpg";
        vehiculo1 = new Vehicle( brand, line, year, price, imagePath );
    }

    /**
     * Prueba la obtenci�n v�lida of the  brand of the  veh�culo
     */
    @Test
    public void testDarBrand( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Valida que el line sea la adecuada
        assertEquals( line, vehiculo1.darLine( ) );
    }

    /**
     * Prueba la obtenci�n v�lida of the  line of the  veh�culo
     */
    @Test
    public void testDarLine( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Valida que el line sea la adecuada
        assertEquals( line, vehiculo1.darLine( ) );
    }

    /**
     * Prueba la obtenci�n v�lida of the  year of the  veh�culo
     */
    @Test
    public void testDarYear( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Valida que el line sea la adecuada
        assertEquals( year, vehiculo1.darYear( ) );
    }

    /**
     * Prueba la obtenci�n v�lida of the  price of the  veh�culo
     */
    @Test
    public void testDarPrice( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Valida que el line sea la adecuada
        assertTrue( price == vehiculo1.darPrice( ) );
    }

    /**
     * Prueba la obtenci�n v�lida of the  ruta of the  imagen of the  veh�culo
     */
    @Test
    public void testDarImagePathImagen( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Valida que el line sea la adecuada
        assertEquals( imagePath, vehiculo1.darImagePathImagen( ) );
    }

}