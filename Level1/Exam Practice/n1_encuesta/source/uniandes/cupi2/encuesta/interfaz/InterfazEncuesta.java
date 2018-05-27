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
package uniandes.cupi2.encuesta.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.encuesta.mundo.Encuesta;

/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazEncuesta extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Encuesta encuesta;

    // -----------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------

    /**
     * Panel con la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel donde se muestra la encuesta.
     */
    private PanelEncuesta panelEncuesta;

    // -----------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------

    /**
     * Constructor de la interfaz. <br>
     * <b>post: </b> Se inicializó la interfaz principal y sus paneles.
     */
    public InterfazEncuesta( )
    {
        setTitle( "Encuesta del curso" );
        setSize( 600, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        encuesta = new Encuesta( );

        setLayout( new BorderLayout( ) );

        // setResizable( false );

        encuesta = new Encuesta( );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        panelEncuesta = new PanelEncuesta( this );
        JPanel panelCentral = new JPanel( new GridLayout( 1, 1 ) );
        panelCentral.add( panelEncuesta );
        add( panelCentral, BorderLayout.CENTER );

        setLocationRelativeTo( null );
        setResizable( false );
    }

    // -----------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------

    /**
     * Devuelve el rango de edades de la encuesta.
     * @return Rango de edades de la encuesta.
     */
    public String[] darRangoEdades( )
    {
        String[] rangoEdades = new String[3];
        rangoEdades[ 0 ] = encuesta.darRangoEdad1( ) + " años";
        rangoEdades[ 1 ] = encuesta.darRangoEdad2( ) + " años";

        int edadMaxima = Integer.parseInt( encuesta.darRangoEdad3( ).split( "-" )[ 1 ] );
        if( edadMaxima > 100 )
        {
            rangoEdades[ 2 ] = encuesta.darRangoEdad3( ).split( "-" )[ 0 ] + " o más";
        }
        else
        {
            rangoEdades[ 2 ] = encuesta.darRangoEdad3( );
        }

        return rangoEdades;
    }

    /**
     * Devuelve los resultados parciales de un grupo dado por parámetro.
     * @param pRango Edad para el grupo del cual se consultará el promedio. pRango entre: 1, 2 ó 3.
     * @param pEsCasado Estado civil para el grupo del cual se consultará el promedio.
     * @return Calificación promedio para el grupo dado.
     */
    public double darResultadosParciales( int pRango, boolean pEsCasado )
    {
        double resultados = 0d;

        if( pEsCasado )
        {
            switch( pRango )
            {
                case 1:
                    resultados = encuesta.darResultadosJovenesCasados( );
                    break;
                case 2:
                    resultados = encuesta.darResultadosAdultosCasados( );
                    break;
                case 3:
                    resultados = encuesta.darResultadosMayoresCasados( );
                    break;
            }
        }
        else
        {
            switch( pRango )
            {
                case 1:
                    resultados = encuesta.darResultadosJovenesSolteros( );
                    break;
                case 2:
                    resultados = encuesta.darResultadosAdultosSolteros( );
                    break;
                case 3:
                    resultados = encuesta.darResultadosMayoresSolteros( );
                    break;
            }
        }
        return resultados;
    }

    /**
     * Devuelve el número total de opiniones recogidas.
     * @return Número total de opiniones recogidas.
     */
    public int darNumeroTotalDeOpiniones( )
    {
        return encuesta.darNumeroTotalOpiniones( );
    }

    /**
     * Devuelve el promedio total de la encuesta.
     * @return Promedio total de la encuesta.
     */
    public double darPromedioTotal( )
    {
        return encuesta.darPromedio( );
    }

    /**
     * Agrega una opinión a la encuesta en el grupo dado por el rango de edad y si es casado o no.
     * @param pRango Edad de la persona que opinó. pRango entre: 1,2 ó 3.
     * @param pEsCasado Estado civil de la persona que opinó.
     * @param pOpinion Valor de opinión que se agregará. pOpinion > 0 && pOpinion < 10.
     */
    public void agregarOpinion( int pRango, boolean pEsCasado, int pOpinion )
    {
        if( pEsCasado )
        {
            switch( pRango )
            {
                case 1:
                    encuesta.agregarOpinionRangoEdadJovenesCasado( pOpinion );
                    break;
                case 2:
                    encuesta.agregarOpinionRangoEdadAdultosCasado( pOpinion );
                    break;
                case 3:
                    encuesta.agregarOpinionRangoEdadMayoresCasado( pOpinion );
                    break;
            }
        }
        else
        {
            switch( pRango )
            {
                case 1:
                    encuesta.agregarOpinionRangoEdadJovenesSoltero( pOpinion );
                    break;
                case 2:
                    encuesta.agregarOpinionRangoEdadAdultosSoltero( pOpinion );
                    break;
                case 3:
                    encuesta.agregarOpinionRangoEdadMayoresSoltero( pOpinion );
                    break;
            }
        }
    }

    /**
     * Actualiza los resultados totales mostrados en la interfaz.
     */
    public void actualizar( )
    {
        panelEncuesta.actualizar( encuesta );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Punto de extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = encuesta.metodo1( );
        actualizar();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Punto de extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = encuesta.metodo2( );
        actualizar();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Formatea un valor numérico real para presentar en la interfaz. <br>
     * @param valor El valor numérico a ser formateado.
     * @return Cadena con el valor formateado con puntos y signos.
     */
    public String formatearValorReal( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazEncuesta interfaz = new InterfazEncuesta( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
