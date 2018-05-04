/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_campeonato
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.campeonato.interfaz;

import java.awt.*;
import java.io.*;

import javax.swing.*;

import uniandes.cupi2.campeonato.mundo.*;

/**
 * Es la clase principal de la interfaz.
 */
@SuppressWarnings("serial")
public class InterfazCampeonato extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al campeonato.
     */
    private Campeonato campeonato;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se muestra el banner de la aplicación.
     */
    private PanelImagen panelImagen;

    /**
     * Es el panel donde se muestra el estado actual de la tabla de goles.
     */
    private PanelTablaGoles panelTablaGoles;

    /**
     * Es el panel donde se muestra el estado actual de la tabla de posiciones.
     */
    private PanelTablaPosiciones panelTablaPosiciones;

    /**
     * Es el panel donde se muestran los botones para controlar la aplicación.
     */
    private PanelBotones panelBotones;

    /**
     * Es la ventana de diálogo para obtener los datos de un partido.
     */
    private DialogoResultado dialogo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz e inicializa el campeonato indicando que no se ha cargado la información de ningún archivo.
     */
    public InterfazCampeonato( )
    {
        campeonato = null;
        panelImagen = new PanelImagen( );
        panelTablaGoles = new PanelTablaGoles( );
        panelBotones = new PanelBotones( this );
        panelTablaPosiciones = new PanelTablaPosiciones( );
        JPanel centro = new JPanel( );
        centro.setLayout( new GridLayout( 2, 1 ) );

        add( panelImagen, BorderLayout.NORTH );
        add( centro, BorderLayout.CENTER );
        centro.add( panelTablaPosiciones );
        centro.add( panelTablaGoles );
        add( panelBotones, BorderLayout.SOUTH );

        setSize( 830, 700 );
        setResizable( false );

        setLocationRelativeTo( null );
        setTitle( "Tabla de resultados" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Muestra el diálogo usado para registrar el resultado de un partido. Este diálogo solo se despliega si el campeonato ya ha sido inicializado.
     */
    public void mostarDialogoResultado( )
    {
        if( campeonato == null )
        {
            JOptionPane.showMessageDialog( this, "Debe cargar un campeonato primero", "Registrar resultado", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            dialogo.limpiar( );
            dialogo.setVisible( true );
        }
    }

    /**
     * Registra un nuevo resultado en el campeonato.
     * @param pEquipo1 Es el número del equipo 1.
     * @param pEquipo2 Es el número del equipo 2.
     * @param pGoles1 Es el número de goles marcados por el equipo 1.
     * @param pGoles2 Es el número de goles marcados por el equipo 2.
     */
    public void registrarResultado( int pEquipo1, int pEquipo2, int pGoles1, int pGoles2 )
    {
        if( campeonato != null )
        {
            try
            {
                campeonato.registrarResultado( pEquipo1, pEquipo2, pGoles1, pGoles2 );
                refrescar( );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ) );
            }
        }
    }

    /**
     * Carga los equipos a partir de un archivo seleccionado por el usuario.
     */
    public void cargarEquipos( )
    {
        JFileChooser fc = new JFileChooser( "./data" );
        fc.setDialogTitle( "Abrir archivo de campeonato" );
        int resultado = fc.showOpenDialog( this );
        if( resultado == JFileChooser.APPROVE_OPTION )
        {
            File archivoCampeonato = fc.getSelectedFile( );
            try
            {
                // Crea el modelo del mundo, pasándole como parámetro el archivo del cual se debe cargar
                campeonato = new Campeonato( archivoCampeonato );
                // Crea el diálogo de captura de resultados, pasando como parámetro el nombre de los equipos del campeonato
                String[] nombreEquipos = new String[campeonato.darNumeroEquipos( )];
                for( int i = 0; i < campeonato.darNumeroEquipos( ); i++ )
                {
                    nombreEquipos[ i ] = campeonato.darEquipo( i ).toString( );
                }
                dialogo = new DialogoResultado( this, nombreEquipos );
                // Refresca la visualización de los paneles con los resultados
                panelTablaGoles.iniciarTablaGoles( campeonato );
                panelTablaPosiciones.crearTabla( campeonato );
                // Desactiva el botón con el que se cargó el campeonato
                panelBotones.desactivarBotonCargar( );
            }
            catch( Exception e )
            {
                campeonato = null;
                JOptionPane.showMessageDialog( this, "Hubo problemas cargando el campeonato: \n" + e.getMessage( ), "Cargar", JOptionPane.ERROR_MESSAGE );
                e.printStackTrace( );
            }
        }
    }

    /**
     * Actualiza los paneles con la tabla de goles y la tabla de posiciones.
     */
    private void refrescar( )
    {
        panelTablaGoles.refrescar( );
        panelTablaPosiciones.refrescar( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        if( campeonato == null )
        {
            JOptionPane.showMessageDialog( this, "Debe cargar un campeonato primero", "Respuesta", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            String resultado = campeonato.metodo1( );
            refrescar( );
            JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Ejecuta el punto de extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        if( campeonato == null )
        {
            JOptionPane.showMessageDialog( this, "Debe cargar un campeonato primero", "Respuesta", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            String resultado = campeonato.metodo2( );
            refrescar( );
            JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
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

            InterfazCampeonato interfaz = new InterfazCampeonato( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( null, e.getMessage( ), "Interfaz campeonato", JOptionPane.ERROR_MESSAGE );
        }
    }
}