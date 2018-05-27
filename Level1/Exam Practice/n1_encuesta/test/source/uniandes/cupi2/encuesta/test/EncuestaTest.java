/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_encuesta
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.encuesta.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uniandes.cupi2.encuesta.mundo.*;

/**
 * Clase usada para verificar que los métodos de la clase Encuesta estén correctamente implementados.
 */
public class EncuestaTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Encuesta encuesta;

    // -----------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------

    /**
     * Escenario 1: Crea una encuesta.
     */
    private void setupEscenario1( )
    {
        encuesta = new Encuesta( );
    }

    /**
     * Escenario 2: Crea un encuesta con opiniones para cada rango.
     */
    private void setupEscenario2( )
    {
        encuesta = new Encuesta( );

        encuesta.agregarOpinionRangoEdadJovenesCasado( 8 );
        encuesta.agregarOpinionRangoEdadAdultosCasado( 6 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 7 );
        encuesta.agregarOpinionRangoEdadJovenesSoltero( 8 );
        encuesta.agregarOpinionRangoEdadAdultosSoltero( 9 );
        encuesta.agregarOpinionRangoEdadMayoresSoltero( 4 );
    }

    /**
     * Prueba 1: Método que se encarga de verificar el método agregarOpinionRangoEdadJovenesCasado. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadJovenesCasado<br>
     * darResultadosJovenesCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones de casados al rango de edad jóvenes de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadJovenesCasado( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionRangoEdadJovenesCasado( 8 );
        encuesta.agregarOpinionRangoEdadJovenesCasado( 10 );
        encuesta.agregarOpinionRangoEdadJovenesCasado( 5 );
        encuesta.agregarOpinionRangoEdadJovenesCasado( 3 );

        double promedioEncuesta = ( double ) ( 8 + 10 + 5 + 3 ) / 4;

        assertEquals( "No se están agregando bien las opiniones del rango 1", promedioEncuesta, encuesta.darResultadosJovenesCasados( ), 2d );

    }

    /**
     * Prueba 2: Método que se encarga de verificar el método agregarOpinionRangoEdadAdultosCasado. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadAdultosCasado<br>
     * darResultadosAdultosCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones de casados al rango de edad adultos de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadAdultosCasado( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionRangoEdadAdultosCasado( 6 );
        encuesta.agregarOpinionRangoEdadAdultosCasado( 5 );
        encuesta.agregarOpinionRangoEdadAdultosCasado( 4 );
        encuesta.agregarOpinionRangoEdadAdultosCasado( 2 );
        encuesta.agregarOpinionRangoEdadAdultosCasado( 3 );
        encuesta.agregarOpinionRangoEdadAdultosCasado( 1 );
        encuesta.agregarOpinionRangoEdadAdultosCasado( 7 );

        double promedioEncuesta = ( double ) ( 6 + 5 + 4 + 2 + 3 + 1 + 7 ) / 7;

        assertEquals( "No se están agregando bien las opiniones del rango 2", promedioEncuesta, encuesta.darResultadosAdultosCasados( ), 2d );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método agregarOpinionRangoEdadMayoresCasado. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionMayoresCasado<br>
     * darResultadosMayoresCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones de casados al rango de edad mayores de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadMayoresCasado( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionRangoEdadMayoresCasado( 2 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 3 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 7 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 9 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 10 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 2 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 4 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 4 );
        encuesta.agregarOpinionRangoEdadMayoresCasado( 4 );

        double promedioEncuesta = ( double ) ( 2 + 3 + 7 + 9 + 10 + 2 + 4 + 4 + 4 ) / 9;

        assertEquals( "No se están agregando bien las opiniones del rango 3", promedioEncuesta, encuesta.darResultadosMayoresCasados( ), 2d );
    }

    /**
     * Prueba 4: Método que se encarga de verificar el método agregarOpinionRangoEdadJovenesSoltero. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadJovenesSoltero<br>
     * darResultadosJovenesSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se agregan varias opiniones de soltero al rango de edad jovenes de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadJovenesSoltero( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionRangoEdadJovenesSoltero( 10 );
        encuesta.agregarOpinionRangoEdadJovenesSoltero( 10 );
        encuesta.agregarOpinionRangoEdadJovenesSoltero( 4 );
        encuesta.agregarOpinionRangoEdadJovenesSoltero( 6 );
        encuesta.agregarOpinionRangoEdadJovenesSoltero( 7 );

        double promedioEncuesta = ( double ) ( 10 + 10 + 4 + 6 + 7 ) / 5;

        assertEquals( "No se están agregando bien las opiniones del rango 1", promedioEncuesta, encuesta.darResultadosJovenesSolteros( ), 2d );

    }

    /**
     * Prueba 5: Método que se encarga de verificar el método agregarOpinionRangoEdadAdultosSoltero. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadAdultosSoltero<br>
     * darResultadosAdultosSolteros<br>
     * <b> Caso de prueba: </b> <br>
     * 1. Se agregam varias opiniones de soltero al rango de edad adultos de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadAdultosSoltero( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionRangoEdadAdultosSoltero( 1 );
        encuesta.agregarOpinionRangoEdadAdultosSoltero( 2 );
        encuesta.agregarOpinionRangoEdadAdultosSoltero( 2 );
        encuesta.agregarOpinionRangoEdadAdultosSoltero( 5 );
        encuesta.agregarOpinionRangoEdadAdultosSoltero( 5 );

        double promedioEncuesta = ( double ) ( 1 + 2 + 2 + 5 + 5 ) / 5;

        assertEquals( "No se están agregando bien las opiniones del rango 2", promedioEncuesta, encuesta.darResultadosAdultosSolteros( ), 2d );
    }

    /**
     * Prueba 6: Método que se encarga de verificar el método agregarOpinionRangoEdadMayoresSoltero. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarOpinionRangoEdadMayoresSoltero<br>
     * darResultadosMayoresSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * Se agregan varias opiniones de soltero al rango de edad mayores de la encuesta.
     */
    @Test
    public void testAgregarOpinionRangoEdadMayoresSoltero( )
    {
        setupEscenario1( );

        encuesta.agregarOpinionRangoEdadMayoresSoltero( 4 );
        encuesta.agregarOpinionRangoEdadMayoresSoltero( 5 );
        encuesta.agregarOpinionRangoEdadMayoresSoltero( 9 );
        encuesta.agregarOpinionRangoEdadMayoresSoltero( 8 );
        encuesta.agregarOpinionRangoEdadMayoresSoltero( 8 );
        encuesta.agregarOpinionRangoEdadMayoresSoltero( 2 );
        encuesta.agregarOpinionRangoEdadMayoresSoltero( 2 );

        double promedioEncuesta = ( double ) ( 4 + 5 + 9 + 8 + 8 + 2 + 2 ) / 7;

        assertEquals( "No se están agregando bien las opiniones del rango 3", promedioEncuesta, encuesta.darResultadosMayoresSolteros( ), 2d );
    }

    /**
     * Prueba 7: Método que se encarga de verificar el método darPromedio. <br>
     * <b> Métodos a probar: </b> <br>
     * darPromedio<br>
     * darResultadosJovenesCasados<br>
     * darResultadosJovenesSolteros<br>
     * darResultadosAdultosCasados<br>
     * darResultadosAdultosSolteros<br>
     * darResultadosMayoresCasados<br>
     * darResultadosMayoresSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula el promedio de las opiniones de la encuesta.
     */
    @Test
    public void testDarPromedio( )
    {
        setupEscenario2( );

        double totalPromedios;
        double promedioEncuesta;

        totalPromedios = encuesta.darResultadosJovenesCasados( ) + encuesta.darResultadosJovenesSolteros( ) + encuesta.darResultadosAdultosCasados( ) + encuesta.darResultadosAdultosSolteros( ) + encuesta.darResultadosMayoresCasados( )
                + encuesta.darResultadosMayoresSolteros( );

        promedioEncuesta = totalPromedios / 6;

        assertEquals( "No se está calculando bien el promedio total de la encuesta", encuesta.darPromedio( ), promedioEncuesta, promedioEncuesta );
    }

    /**
     * Prueba 8: Método que se encarga de verificar el método darPromedioCasados. <br>
     * <b> Métodos a probar: </b> <br>
     * darPromedioCasados<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula el promedio de las opiniones de casados de la encuesta.
     */
    @Test
    public void testDarPromedioCasados( )
    {
        setupEscenario2( );

        double totalPromedios;
        double promedioEncuesta;
        totalPromedios = 8 + 6 + 7;
        promedioEncuesta = totalPromedios / 3;

        assertEquals( "No se está calculando bien el promedio total de casados de la encuesta", promedioEncuesta, encuesta.darPromedioCasados( ), 2d );
    }

    /**
     * Prueba 8: Método que se encarga de verificar el método darPromedioSolteros. <br>
     * <b> Métodos a probar: </b> <br>
     * darPromedioSolteros<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula el promedio de las opiniones de solteros de la encuesta.
     */
    @Test
    public void testDarPromedioSolteros( )
    {
        setupEscenario2( );

        double totalPromedios;
        double promedioEncuesta;
        totalPromedios = 8 + 9 + 4;
        promedioEncuesta = totalPromedios / 3;

        assertEquals( "No se está calculando bien el promedio total de solteros de la encuesta", promedioEncuesta, encuesta.darPromedioSolteros( ), 2d );
    }

    /**
     * Prueba 9: Método que se encarga de verificar el método darNumeroTotalOpiniones.<br>
     * <b> Métodos a probar: </b> <br>
     * darNumeroTotalOpiniones<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se calcula el total de las opiniones de la encuesta.
     */
    @Test
    public void testDarNumeroTotalOpiniones( )
    {
        setupEscenario2( );
        int numeroDeOpinionesTotal;
        numeroDeOpinionesTotal = 6;
        assertEquals( "No se suma bien el total de numero de opiniones en la encuesta", encuesta.darNumeroTotalOpiniones( ), numeroDeOpinionesTotal );
    }

}
