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
package uniandes.cupi2.impuestosCarro.interfaz;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

import uniandes.cupi2.impuestosCarro.mundo.*;

/**
 * Interfaz de c�lculo de impuestos de carros.
 */
@SuppressWarnings("serial")
public class InterfazImpuestosCarro extends JFrame
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * ImagePath of the  imagen of the  banner.
     */
    public final static String RUTA_IMAGEN = "./data/banner.jpg";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Calculador de impuestos.
     */
    private CalculadorImpuestos calculador;

    // -----------------------------------------------------------------
    // Attributes de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de veh�culos.
     */
    private PanelVehicle panelVehicle;

    /**
     * Panel de descuentos.
     */
    private PanelDescuentos panelDescuentos;

    /**
     * Panel de opciones
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel de b�squedas.
     */
    private PanelBusquedas panelBusquedas;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea la interfaz de impuestos de carros.
     * @throws Exception Error al cargar los archivos.
     */
    public InterfazImpuestosCarro( ) throws Exception
    {
        setTitle( "C�lculo impuestos" );
        setSize( 600, 700 );
        setLocationRelativeTo( null );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // Crea el calculador de impuestos
        calculador = new CalculadorImpuestos( );

        setLayout( new BorderLayout( ) );

        // Crea los paneles y los agrega a la ventana

        // Imagen of the  t�tulo
        JLabel labImagen = new JLabel( );
        labImagen.setIcon( new ImageIcon( RUTA_IMAGEN ) );
        add( labImagen, BorderLayout.NORTH );

        JPanel centro = new JPanel( );
        centro.setLayout( new BorderLayout( ) );
        add( centro, BorderLayout.CENTER );

        // Panel de veh�culos: panel activo
        panelVehicle = new PanelVehicle( this );
        centro.add( panelVehicle, BorderLayout.CENTER );

        panelConsultas = new PanelBusquedas( this );
        centro.add( panelConsultas, BorderLayout.SOUTH );

        JPanel sur = new JPanel( );
        sur.setLayout( new BorderLayout( ) );
        add( sur, BorderLayout.SOUTH );

        // Panel de descuentos: panel pasivo
        panelDescuentos = new PanelDescuentos( );
        sur.add( panelDescuentos, BorderLayout.CENTER );

        // Panel de opciones: panel activo
        panelOpciones = new PanelOpciones( this );
        sur.add( panelOpciones, BorderLayout.SOUTH );

        Vehicle actual = calculador.darVehicleActual( );
        panelVehicle.actualizar( actual.darBrand( ), actual.darLine( ), actual.darYear( ), actual.darPrice( ), actual.darImagePathImagen( ) );

    }

    // -----------------------------------------------------------------
    // Requerimientos funcionales
    // -----------------------------------------------------------------

    /**
     * Calcula el pago of the  impuesto seg�n el veh�culo.
     */
    public void calcularImpuestos( )
    {
        // Pide al panel respectivo la informaci�n de los descuentos
        boolean descProntoPago = panelDescuentos.hayDescuentoProntoPago( );
        boolean descServicioPublico = panelDescuentos.hayDescuentoServicioPublico( );
        boolean descTrasladoCuenta = panelDescuentos.hayDescuentoTrasladoCuenta( );

        // Calcula el valor de los impuestos
        double pago = calculador.calcularPago( descProntoPago, descServicioPublico, descTrasladoCuenta );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );

        JOptionPane.showMessageDialog( this, "El valor a pagar es: " + df.format( pago ), "C�lcular impuestos", JOptionPane.INFORMATION_MESSAGE );

    }

    // ----------------------------------------------------------------
    // Puntos de Extensi�n
    // ----------------------------------------------------------------

    /**
     * Muestra el anterior veh�culo en la lista.
     */
    public void verAnterior( )
    {
        try
        {
            Vehicle anterior = calculador.darAnterior( );
            panelVehicle.actualizar( anterior.darBrand( ), anterior.darLine( ), anterior.darYear( ), anterior.darPrice( ), anterior.darImagePathImagen( ) );

        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Ver veh�culo anterior", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Muestra el siguiente veh�culo en la lista.
     */
    public void verSiguiente( )
    {
        try
        {
            Vehicle siguiente = calculador.darSiguiente( );
            panelVehicle.actualizar( siguiente.darBrand( ), siguiente.darLine( ), siguiente.darYear( ), siguiente.darPrice( ), siguiente.darImagePathImagen( ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Ver veh�culo siguiente", JOptionPane.WARNING_MESSAGE );
        }

    }

    /**
     * Muestra el primer veh�culo en la lista.
     */
    public void verPrimero( )
    {
        try
        {
            Vehicle primero = calculador.darPrimero( );
            panelVehicle.actualizar( primero.darBrand( ), primero.darLine( ), primero.darYear( ), primero.darPrice( ), primero.darImagePathImagen( ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Ver primer veh�culo", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Muestra el �ltimo veh�culo en la lista.
     */
    public void verUltimo( )
    {
        try
        {
            Vehicle ultimo = calculador.darUltimo( );
            panelVehicle.actualizar( ultimo.darBrand( ), ultimo.darLine( ), ultimo.darYear( ), ultimo.darPrice( ), ultimo.darImagePathImagen( ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Ver �ltimo veh�culo", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Busca el veh�culo m�s caro y lo muestra.
     */
    public void buscarMasCaro( )
    {
        Vehicle masCaro = calculador.buscarVehicleMasCaro( );
        panelVehicle.actualizar( masCaro.darBrand( ), masCaro.darLine( ), masCaro.darYear( ), masCaro.darPrice( ), masCaro.darImagePathImagen( ) );

    }

    /**
     * Busca el veh�culo of the  line y lo muestra. Si no hay ninguno le informa al usuario.
     * @param pLine L�nea of the  veh�culo. pLine != null &amp;&amp; pLine != "".
     */
    public void buscarPorLine( String pLine )
    {
        Vehicle respuesta = calculador.buscarVehiclePorLine( pLine );
        if( respuesta == null )
        {
            JOptionPane.showMessageDialog( this, "No se encontr� ning�n veh�culo de esta line", "Buscar por line", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            panelVehicle.actualizar( respuesta.darBrand( ), respuesta.darLine( ), respuesta.darYear( ), respuesta.darPrice( ), respuesta.darImagePathImagen( ) );

        }
    }

    /**
     * Busca el primer veh�culo of the  brand y lo muestra. Si no hay ninguno informa al usuario.
     * @param pBrand Brand of the  veh�culo. pBrand != null &amp;&amp; pBrand != "".
     */
    public void buscarPorBrand( String pBrand )
    {
        Vehicle respuesta = calculador.buscarVehiclePorBrand( pBrand );
        if( respuesta == null )
        {
            JOptionPane.showMessageDialog( this, "No se encontr� ning�n veh�culo de esta brand", "Buscar por brand", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            panelVehicle.actualizar( respuesta.darBrand( ), respuesta.darLine( ), respuesta.darYear( ), respuesta.darPrice( ), respuesta.darImagePathImagen( ) );
        }
    }

    // ----------------------------------------------------------------
    // Puntos de Extensi�n
    // ----------------------------------------------------------------
    /**
     * Llamado para realizar el m�todo de extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = calculador.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Llamado para realizar el m�todo de extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = calculador.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazImpuestosCarro interfaz = new InterfazImpuestosCarro( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}