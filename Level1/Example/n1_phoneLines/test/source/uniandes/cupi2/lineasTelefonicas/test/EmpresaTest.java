/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_phoneLines
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.phoneLines.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import uniandes.cupi2.phoneLines.mundo.Company;

/**
 * Clase usada para verificar que los métodos de la clase Company estén correctamente implementados.
 */
public class CompanyTest
{

    //-----------------------------------------------------------------
    //Attributes
    //-----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Company company;

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo objeto de la clase company vacía.
     */
    private void setupEscenario1( )
    {
        company = new Company( );
    }

    /**
     * Escenario 2: Construye un nuevo objeto de la clase company con llamadas.
     */
    private void setupEscenario2( )
    {
        company = new Company( );

        company.addLocalCallLine1( 1 );
        company.addLongDistanceLine1( 2 );
        company.addCellCallLine1( 3 );

        company.addLocalCallLine2( 10 );
        company.addLongDistanceLine2( 20 );
        company.addCellCallLine2( 30 );

        company.addLocalCallLine2( 100 );
        company.addLongDistanceLine2( 200 );
        company.addCellCallLine2( 300 );
    }

    /**
     * Prueba 1: Método que se encarga de verificar el método inicializar.<br>
     * <b> Methods a probar: </b> <br>
     * Company<br>
     * getLine1<br>
     * getLine2<br>
     * getLine3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company no tiene llamadas en ninguna línea.
     */
    @Test
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "La línea telefónica 1 debe estar inicializada", company.getLine1( ) );
        assertNotNull( "La línea telefónica 2 debe estar inicializada", company.getLine2( ) );
        assertNotNull( "La línea telefónica 3 debe estar inicializada", company.getLine3( ) );
    }

    /**
     * Prueba 2: Método que se encarga de verificar el método addLocalCallLine1.<br>
     * <b> Methods a probar: </b> <br>
     * addLocalCallLine1<br>
     * getLine1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarLlamadaLocalLine1( )
    {
        setupEscenario1( );
        company.addLocalCallLine1( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine1( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 3: Método que se encarga de verificar el método addLocalCallLine2.<br>
     * <b> Methods a probar: </b> <br>
     * addLocalCallLine2<br>
     * getLine2<br>
     * <b> Casos de prueba: </b> <br>
     * Se agrega una llamada local a la línea 2 de la company.
     */
    @Test
    public void testAgregarLlamadaLocalLine2( )
    {
        setupEscenario1( );
        company.addLocalCallLine2( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine2( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 4: Método que se encarga de verificar el método addLocalCallLine3.<br>
     * <b> Methods a probar: </b> <br>
     * addLocalCallLine3<br>
     * getLine3<br>
     * <b> Casos de prueba: </b> <br>
     * Se agrega una llamada local a la línea 3 de la company.
     */
    @Test
    public void testAgregarLlamadaLocalLine3( )
    {
        setupEscenario1( );
        company.addLocalCallLine3( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine3( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 5: Método que se encarga de verificar el método addLongDistanceLine1.<br>
     * <b> Methods a probar: </b> <br>
     * addLongDistanceLine1<br>
     * getLine1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLine1( )
    {
        setupEscenario1( );
        company.addLongDistanceLine1( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine1( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 6: Método que se encarga de verificar el método addLongDistanceLine2.<br>
     * <b> Methods a probar: </b> <br>
     * addLongDistanceLine2<br>
     * getLine2<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLine2( )
    {
        setupEscenario1( );
        company.addLongDistanceLine2( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine2( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 7: Método que se encarga de verificar el método addLongDistanceLine3.<br>
     * <b> Methods a probar: </b> <br>
     * addLongDistanceLine3<br>
     * getLine3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLine3( )
    {
        setupEscenario1( );
        company.addLongDistanceLine3( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine3( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 8: Método que se encarga de verificar el método addCellCallLine1.<br>
     * <b> Methods a probar: </b> <br>
     * addCellCallLine1<br>
     * getLine1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarCelularDistanciaLine1( )
    {
        setupEscenario1( );
        company.addCellCallLine1( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine1( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 9: Método que se encarga de verificar el método addCellCallLine2.<br>
     * <b> Methods a probar: </b> <br>
     * addCellCallLine2<br>
     * getLine2<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarCelularDistanciaLine2( )
    {
        setupEscenario1( );
        company.addCellCallLine2( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine2( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 10: Método que se encarga de verificar el método addCellCallLine3.<br>
     * <b> Methods a probar: </b> <br>
     * addCellCallLine3<br>
     * getLine3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company no tiene llamadas en ninguna línea.
     */
    @Test
    public void testAgregarCelularDistanciaLine3( )
    {
        setupEscenario1( );
        company.addCellCallLine3( 10 );
        assertEquals( "La llamada no quedó registrada", 1, company.getLine3( ).getNumberOfCalls( ) );
    }

    /**
     * Prueba 11: Método que se encarga de verificar el método getTotalNumberOfCalls.<br>
     * <b> Methods a probar: </b> <br>
     * getTotalNumberOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company tiene llamadas en las 3 líneas telefónicas.
     */
    @Test
    public void testDarTotalCalls( )
    {
        setupEscenario2( );
        assertEquals( "El number de llamadas debe ser 9", 9, company.getTotalNumberOfCalls( ) );
    }

    /**
     * Prueba 12: Método que se encarga de verificar el método getTotalMinutes.<br>
     * <b> Methods a probar: </b> <br>
     * getTotalMinutes<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company tiene llamadas en las 3 líneas telefónicas.
     */
    @Test
    public void testDarTotalMinutes( )
    {
        setupEscenario2( );
        assertEquals( "El total de minutes debe ser 666", 666, company.getTotalMinutes( ) );
    }

    /**
     * Prueba 13: Método que se encarga de verificar el método getTotalCostOfCalls.<br>
     * <b> Methods a probar: </b> <br>
     * getTotalCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company tiene llamadas en las 3 líneas telefónicas.
     */
    public void testDarTotalCost( )
    {
        setupEscenario2( );
        assertEquals( "El costo es inválido. Debe ser $ 420.912", 420912, company.getTotalCostOfCalls( ), 0.001 );
    }

    /**
     * Prueba 14: Método que se encarga de verificar el método getAverageCostPerMinute.<br>
     * <b> Methods a probar: </b> <br>
     * getAverageCostPerMinute<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company tiene llamadas en las 3 líneas telefónicas.
     */
    @Test
    public void testDarCostPromedio( )
    {
        setupEscenario2( );
        assertEquals( "El costo promedio es inválido. Debe ser $632", 632, company.getAverageCostPerMinute( ), 0.001 );
    }

    /**
     * Prueba 14: Método que se encarga de verificar el método reset.<br>
     * <b> Methods a probar: </b> <br>
     * reset<br>
     * getTotalNumberOfCalls<br>
     * getTotalMinutes<br>
     * getTotalCostOfCalls<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La company tiene llamadas en las 3 líneas telefónicas.
     */
    @Test
    public void testReiniciar( )
    {
        setupEscenario2( );
        company.reset( );
        assertEquals( "El total de llamadas debe ser cero", 0, company.getTotalNumberOfCalls( ) );
        assertEquals( "El total de minutes debe ser cero", 0, company.getTotalMinutes( ) );
        assertEquals( "El costo total de llamadas debe ser cero", 0, company.getTotalCostOfCalls( ), 0.01 );
    }

}