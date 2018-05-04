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

import java.awt.event.*;

import javax.swing.*;

/**
 * Este es el panel donde están los botones que controlan la aplicación.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el comando del botón cargar equipos.
     */
    private static final String CARGAR_EQUIPOS = "Cargar equipos";

    /**
     * Constante para el comando del botón registrar resultado.
     */
    private static final String REGISTRAR_RESULTADO = "Registrar resultado";

    /**
     * Constante para el comando del botón opción 1.
     */
    private static final String OPCION_1 = "Opción 1";

    /**
     * Constante para el comando del botón opción 2.
     */
    private static final String OPCION_2 = "Opción 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz.
     */
    private InterfazCampeonato principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el botón para cargar los equipos.
     */
    private JButton botonCargarEquipos;

    /**
     * Es el botón para registrar un nuevo resultado.
     */
    private JButton botonRegistrarResultado;

    /**
     * Es el botón para ejecutar el punto de extensión 1.
     */
    private JButton botonOpcion1;

    /**
     * Es el botón para ejecutar el punto de extensión 2.
     */
    private JButton botonOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel de botones y sus elementos.
     * @param pPrincipal Referencia a la clase principal de la interfaz.
     */
    public PanelBotones( InterfazCampeonato pPrincipal )
    {
        principal = pPrincipal;

        // Inicializa el botón de cargar equipos
        botonCargarEquipos = new JButton( CARGAR_EQUIPOS );
        botonCargarEquipos.setActionCommand( CARGAR_EQUIPOS );
        botonCargarEquipos.addActionListener( this );
        add( botonCargarEquipos );

        // Inicializa el botón de registrar un partido
        botonRegistrarResultado = new JButton( REGISTRAR_RESULTADO );
        botonRegistrarResultado.setActionCommand( REGISTRAR_RESULTADO );
        botonRegistrarResultado.addActionListener( this );
        add( botonRegistrarResultado );

        // Inicializa los botones de extensión
        botonOpcion1 = new JButton( OPCION_1 );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );

        botonOpcion2 = new JButton( OPCION_2 );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este método se ejecuta cuando se hace click sobre un botón.
     * @param pEvento El evento del click sobre un botón. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( REGISTRAR_RESULTADO.equals( comando ) )
        {
            principal.mostarDialogoResultado( );
        }
        else if( CARGAR_EQUIPOS.equals( comando ) )
        {
            principal.cargarEquipos( );
        }
        else if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

    /**
     * Desactiva el botón de cargar, después de que el campeonato ya ha sido inicializado.
     */
    public void desactivarBotonCargar( )
    {
        botonCargarEquipos.setEnabled( false );
    }
}