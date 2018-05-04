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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Es el diálogo donde se registra el resultado de un partido.
 */
@SuppressWarnings("serial")
public class DialogoResultado extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el comando del botón ok.
     */
    private static final String OK = "ok";

    /**
     * Constante para el comando del botón cancelar.
     */
    private static final String CANCELAR = "Cancelar";

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
     * El combo donde se selecciona el equipo 1.
     */
    private JComboBox comboEquipo1;

    /**
     * El combo donde se selecciona el equipo 2.
     */
    private JComboBox comboEquipo2;

    /**
     * Etiqueta VS.
     */
    private JLabel etiquetaVS;

    /**
     * Etiqueta "-".
     */
    private JLabel etiquetaGuion;

    /**
     * El campo de texto para los goles del equipo 1.
     */
    private JTextField txtGoles1;

    /**
     * El campo de texto para los goles del equipo 2.
     */
    private JTextField txtGoles2;

    /**
     * Es el botón para registrar el resultado.
     */
    private JButton botonOk;

    /**
     * Es el botón para cancelar el registro del resultado.
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo que permite ingresar un nuevo resultado al campeonato.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal != null.
     * @param pNombreEquipos Es un arreglo con los nombres de los equipos que hay en el campeonato. nombreEquipos != null.
     */
    public DialogoResultado( InterfazCampeonato pPrincipal, String[] pNombreEquipos )
    {
        super( pPrincipal, true );
        principal = pPrincipal;

        setTitle( "Registrar Resultado" );
        setSize( 270, 190 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 1, 2 ) );
        setLayout( new BorderLayout( ) );

        JPanel panelEquipos = new JPanel( );
        comboEquipo1 = new JComboBox( new DefaultComboBoxModel( pNombreEquipos ) );
        comboEquipo2 = new JComboBox( new DefaultComboBoxModel( pNombreEquipos ) );
        etiquetaVS = new JLabel( " vs " );
        panelEquipos.add( comboEquipo1 );
        panelEquipos.add( etiquetaVS );
        panelEquipos.add( comboEquipo2 );
        panelEquipos.setBorder( new TitledBorder( "Equipos" ) );
        add( panelEquipos, BorderLayout.NORTH );
        JPanel panelResultado = new JPanel( );
        etiquetaGuion = new JLabel( " - " );
        txtGoles1 = new JTextField( 2 );
        txtGoles2 = new JTextField( 2 );
        panelResultado.add( txtGoles1 );
        panelResultado.add( etiquetaGuion );
        panelResultado.add( txtGoles2 );
        panelResultado.setBorder( new TitledBorder( "Resultado" ) );
        add( panelResultado, BorderLayout.CENTER );
        add( panelBotones, BorderLayout.SOUTH );
        botonOk = new JButton( "Ok" );
        botonOk.setActionCommand( OK );
        botonOk.addActionListener( this );
        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        panelBotones.add( botonOk );
        panelBotones.add( botonCancelar );

        setModal( true );
        setLocationRelativeTo( principal );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa todos los paneles de la ventana de diálogo.
     */
    public void limpiar( )
    {
        comboEquipo1.setSelectedIndex( 0 );
        comboEquipo2.setSelectedIndex( 0 );
        txtGoles1.setText( "" );
        txtGoles2.setText( "" );
    }

    /**
     * Este método se ejecuta cuando se hace click sobre un botón.
     * @param pEvento El evento del click sobre un botón. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( OK.equals( comando ) )
        {
            try
            {
                int goles1 = Integer.parseInt( txtGoles1.getText( ) );
                int goles2 = Integer.parseInt( txtGoles2.getText( ) );
                int equipo1 = comboEquipo1.getSelectedIndex( );
                int equipo2 = comboEquipo2.getSelectedIndex( );
                principal.registrarResultado( equipo1, equipo2, goles1, goles2 );
                setVisible( false );
            }
            catch( NumberFormatException nfe )
            {
                JOptionPane.showMessageDialog( principal, "Debe indicar un número correcto de goles" );
            }
        }
        else if( CANCELAR.equals( comando ) )
        {
            this.setVisible( false );
        }
    }
}