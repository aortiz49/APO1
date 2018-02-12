/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_triangulo
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.triangulo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uniandes.cupi2.triangulo.mundo.Color;

/**
 * Clase usada para verificar que los métodos de la clase Color estén correctamente implementados.
 */
public class ColorTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Color usado para las pruebas.
     */
    private Color color;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo color e inicializa sus atributos.
     */
    private void setupEscenario1( )
    {
        color = new Color( 1, 1, 1 );
    }

    /**
     * Prueba 1: Método que se encarga de verificar el método cambiarRojo. <b> Métodos a probar: </b> <br>
     * inicializar<br>
     * cambiarRojo<br>
     * darRojo<br>
     * <b> Casos de prueba: </b> <br>
     * Se cambia el componente rojo del color.
     */
    @Test
    public void testCambiarRojo( )
    {
        setupEscenario1( );

        // Prueba el color Rojo
        assertEquals( "El rojo debe estar inicializado en 1", 1, color.darRojo( ) );
        color.cambiarRojo( 25 );
        assertEquals( "El rojo debe ser 25", 25, color.darRojo( ) );
    }

    /**
     * Prueba 2: Método que se encarga de verificar el método cambiarVerde. <b> Métodos a probar: </b> <br>
     * inicializar<br>
     * cambiarVerde<br>
     * darVerde<br>
     * <b> Casos de prueba: </b> <br>
     * Se cambia el componente verde del color.
     */
    @Test
    public void testVerde( )
    {
        setupEscenario1( );

        // Prueba el color Verde
        assertEquals( "El verde debe estar inicializado en 1", 1, color.darVerde( ) );
        color.cambiarVerde( 25 );
        assertEquals( "El verde debe ser 25", 25, color.darVerde( ) );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método cambiarAzul. <b> Métodos a probar: </b> <br>
     * inicializar<br>
     * cambiarAzul<br>
     * darAzul<br>
     * <b> Casos de prueba: </b> <br>
     * Se cambia el componente azul del color.
     */
    @Test
    public void testAzul( )
    {
        setupEscenario1( );

        // Prueba el color Azul
        assertEquals( "El azul debe estar inicializado en 1", 1, color.darAzul( ) );
        color.cambiarAzul( 25 );
        assertEquals( "El azul debe ser 25", 25, color.darAzul( ) );
    }

}
