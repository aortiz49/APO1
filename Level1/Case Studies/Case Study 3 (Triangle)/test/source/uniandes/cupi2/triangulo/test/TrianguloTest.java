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

import uniandes.cupi2.triangulo.mundo.Punto;
import uniandes.cupi2.triangulo.mundo.Triangulo;

/**
 * Clase usada para verificar que los métodos de la clase Triangulo estén correctamente implementados.
 */
public class TrianguloTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Triángulo usado para hacer las pruebas.
     */
    private Triangulo triangulo;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo triángulo e inicializa sus atributos.
     */
    private void setupEscenario1( )
    {

        // Crea el punto 1
        Punto punto1 = new Punto( 0, 4 );

        // Crea el punto 2
        Punto punto2 = new Punto( 0, 0 );

        // Crea el punto 1
        Punto punto3 = new Punto( 8, 4 );

        // Inicializa el color del relleno en Azul
        // Valor RGB = (0, 0, 150)
        uniandes.cupi2.triangulo.mundo.Color colorRelleno = new uniandes.cupi2.triangulo.mundo.Color( 0, 0, 170 );

        // Inicializa el color de las líneas en negro
        // Valor RGB = (0, 0, 0)
        uniandes.cupi2.triangulo.mundo.Color colorLineas = new uniandes.cupi2.triangulo.mundo.Color( 0, 0, 0 );

        // Crea el triángulo
        triangulo = new Triangulo( );
    }

    /**
     * Prueba 1: Método que se encarga de verificar el método darArea.<br>
     * <b> Métodos a probar: </b> <br>
     * darArea<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El área está bien calculada.
     */
    @Test
    public void testDarArea( )
    {
        setupEscenario1( );
        assertEquals( "El área no es el esperado.", 15000, triangulo.darArea( ), 0 );
    }

    /**
     * Prueba 2: Método que se encarga de verificar el método darPerimetro.<br>
     * <b> Métodos a probar: </b> <br>
     * darPerimetro<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El perímetro está bien calculado.
     */
    @Test
    public void testDarPerimetro( )
    {
        setupEscenario1( );
        assertEquals( "El perímetro no es el esperado.", 560.55, triangulo.darPerimetro( ), 0.2 );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método darAltura.<br>
     * <b> Métodos a probar: </b> <br>
     * darAltura<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La altura está bien calculada.
     */
    @Test
    public void testDarAltura( )
    {
        setupEscenario1( );
        assertEquals( "La altura no es la esperada.", 166.41, triangulo.darAltura( ), 2 );
    }

    /**
     * Prueba 4: Método que se encarga de verificar el método cambiarPunto1.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarPunto1<br>
     * darPunto1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Las nuevas coordenadas son válidas.
     */
    @Test
    public void testCambiarPunto1( )
    {
        setupEscenario1( );
        triangulo.cambiarPunto1( 25, 30 );
        assertEquals( "La coordenada X del punto 1 debería ser 25", 25, triangulo.darPunto1( ).darX( ), 0 );
        assertEquals( "La coordenada Y del punto 1 debería ser 30", 30, triangulo.darPunto1( ).darY( ), 0 );
    }

    /**
     * Prueba 5: Método que se encarga de verificar el método cambiarPunto2.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarPunto2<br>
     * darPunto2<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Las nuevas coordenadas son válidas.
     */
    @Test
    public void testCambiarPunto2( )
    {
        setupEscenario1( );
        triangulo.cambiarPunto2( 45, 70 );
        assertEquals( "La coordenada X del punto 2 debería ser 45", 45, triangulo.darPunto2( ).darX( ), 0 );
        assertEquals( "La coordenada Y del punto 2 debería ser 70", 70, triangulo.darPunto2( ).darY( ), 0 );
    }

    /**
     * Prueba 6: Método que se encarga de verificar el método cambiarPunto3.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarPunto3<br>
     * darPunto3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Las nuevas coordenadas son válidas.
     */
    @Test
    public void testCambiarPunto3( )
    {
        setupEscenario1( );
        triangulo.cambiarPunto3( 55, 170 );
        assertEquals( "La coordenada X del punto 3 debería ser 55", 55, triangulo.darPunto3( ).darX( ), 0 );
        assertEquals( "La coordenada Y del punto 3 debería ser 170", 170, triangulo.darPunto3( ).darY( ), 0 );
    }

    /**
     * Prueba 7: Método que se encarga de verificar el método cambiarColorLineas.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarColorLineas<br>
     * darColorLineas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El nuevo color es válido.
     */
    @Test
    public void testCambiarColorLineas( )
    {
        setupEscenario1( );
        triangulo.cambiarColorLineas( 100, 250, 180 );
        assertEquals( "El valor del componente rojo del color debería ser 100", 100, triangulo.darColorLineas( ).darRojo( ), 0 );
        assertEquals( "El valor del componente verde del color debería ser 250", 250, triangulo.darColorLineas( ).darVerde( ), 0 );
        assertEquals( "El valor del componente azul del color debería ser 180", 180, triangulo.darColorLineas( ).darAzul( ), 0 );

    }

    /**
     * Prueba 8: Método que se encarga de verificar el método cambiarColorRelleno.<br>
     * <b> Métodos a probar: </b> <br>
     * cambiarColorRelleno<br>
     * darColorRelleno<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El nuevo color es válido.
     */
    @Test
    public void testCambiarColorRelleno( )
    {
        setupEscenario1( );
        triangulo.cambiarColorRelleno( 140, 220, 150 );
        assertEquals( "El valor del componente rojo del color debería ser 140", 140, triangulo.darColorRelleno( ).darRojo( ), 0 );
        assertEquals( "El valor del componente verde del color debería ser 220", 220, triangulo.darColorRelleno( ).darVerde( ), 0 );
        assertEquals( "El valor del componente azul del color debería ser 150", 150, triangulo.darColorRelleno( ).darAzul( ), 0 );

    }

}