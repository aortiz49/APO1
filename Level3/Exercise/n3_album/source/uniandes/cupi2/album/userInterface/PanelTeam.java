/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogota - Colombia)
 * Departamento de  Ingenieria  de  Sistemas    y   Computacion
 * Licenciado   bajo    el  esquema Academic Free License version 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_album
 * Autor: Team Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import uniandes.cupi2.album.world.Team;
import java.awt.Font;

/**
 * Panel con la informacion del team.
 */
@SuppressWarnings("serial")
public class PanelTeam extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constante que representa el número de filas of the  matriz de playeres.
     */
    private static final int NUM_FILAS = 2;

    /**
     * Constante que representa el número de columnas of the  matriz de playeres.
     */
    private static final int NUM_COLUMNAS = 6;

    /**
     * Comando para ejecutar la accion del boton lamina crest.
     */
    private static final String LAMINA_CREST = "CREST CARD";

    /**
     * Comando para ejecutar la accion del boton lamina team.
     */
    private static final String LAMINA_TEAM = "TEAM CARD";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Team que se esta mostrando.
     */
    private Team team;

    /**
     * Ventana principal of the  aplicacion
     */
    private albumInterface principal;

    // -----------------------------------------------------------------
    // Attributes of the  userInterface
    // -----------------------------------------------------------------

    /**
     * Label que contiene el nombre y el año del team.
     */
    private JLabel lblTituloTeam;

    /**
     * Boton que contiene la lamina del crest.
     */
    private JButton btnCrestCard;

    /**
     * Boton que contiene la lamina del team.
     */
    private JButton btnTeamCard;

    /**
     * Matriz que contiene los paneles con las laminas de los playeres.
     */
    private PanelCard[][] lblCards;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la informacion del team. <br>
     * <b>post:</b> Todos los botones y etiquetas fueron inicializadas.
     * @param pTeam Team cuya informacion se va a mostrar. pTeam != null.
     * @param pUserInterface UserInterface principal of the  aplicacion. pUserInterface != null
     */
    public PanelTeam( albumInterface pUserInterface, Team pTeam )
    {
        setOpaque( false );
        
        team = pTeam;
        principal = pUserInterface;
        setLayout( new BorderLayout( 0, 10 ) );
        JPanel panelSuperior = new JPanel( new BorderLayout( ) );
        panelSuperior.setOpaque( false );
        JPanel panelCrestCard = new JPanel( new BorderLayout( ) );
        panelCrestCard.setBorder( null );
        panelCrestCard.setOpaque( false );
        JPanel teamPanelCard = new JPanel( new BorderLayout( ) );
        teamPanelCard.setBorder( null );
        teamPanelCard.setOpaque( false );

        panelSuperior.add( panelCrestCard, BorderLayout.WEST );
        panelSuperior.add( teamPanelCard, BorderLayout.EAST );
        add( panelSuperior, BorderLayout.NORTH );
        JPanel panelPlayers = new JPanel( new GridLayout( NUM_FILAS, NUM_COLUMNAS, 15, 15 ) );
        panelPlayers.setOpaque( false );
        add( panelPlayers, BorderLayout.CENTER );

        btnCrestCard = new JButton( "Paste" );
        btnCrestCard.setActionCommand( LAMINA_CREST );
        btnCrestCard.addActionListener( this );
        btnCrestCard.setContentAreaFilled( false );
        btnCrestCard.setBorder( null );
        btnCrestCard.setIcon( new ImageIcon("./data/images/toPasteCrest.png") );
        btnCrestCard.setPreferredSize( new Dimension( 105, 105 ) );
        btnCrestCard.setHorizontalTextPosition( JLabel.CENTER );
        btnCrestCard.setForeground( Color.WHITE );
        btnCrestCard.setFont( new Font( new JLabel().getFont( ).getFontName( ), Font.BOLD, 16 ) );
        panelCrestCard.add( btnCrestCard, BorderLayout.WEST );

        JLabel lblEscudo = new JLabel( "Crest" );
        lblEscudo.setHorizontalAlignment( JLabel.CENTER );
        lblEscudo.setForeground( Color.WHITE );
        lblEscudo.setFont( new Font( new JLabel().getFont( ).getFontName( ), Font.BOLD, 13 ) );
        panelCrestCard.add( lblEscudo, BorderLayout.SOUTH );

        lblTituloTeam = new JLabel( team.getCountry( ) + " - " + team.getYear( ) );
        lblTituloTeam.setFont( new Font( "Tahoma", Font.BOLD, 40 ) );
        lblTituloTeam.setHorizontalAlignment( JLabel.CENTER );
        lblTituloTeam.setForeground( new Color(220, 232, 255) );
        panelSuperior.add( lblTituloTeam, BorderLayout.CENTER );

        btnTeamCard = new JButton( "Paste" );
        btnTeamCard.setActionCommand( LAMINA_TEAM );
        btnTeamCard.addActionListener( this );
        btnTeamCard.setContentAreaFilled( false );
        btnTeamCard.setBorder( null );
        btnTeamCard.setIcon( new ImageIcon("./data/images/toPasteTeam.png") );
        btnTeamCard.setPreferredSize( new Dimension( 150, 100 ) );
        btnTeamCard.setHorizontalTextPosition( JLabel.CENTER );
        btnTeamCard.setForeground( Color.WHITE );
        btnTeamCard.setFont( new Font( new JLabel().getFont( ).getFontName( ), Font.BOLD, 16 ) );
        teamPanelCard.add( btnTeamCard, BorderLayout.CENTER );

        JLabel lblTeam = new JLabel( "Team" );
        lblTeam.setForeground( Color.WHITE );
        lblTeam.setFont( new Font( new JLabel().getFont( ).getFontName( ), Font.BOLD, 13 ) );
        lblTeam.setHorizontalAlignment( JLabel.CENTER );
        teamPanelCard.add( lblTeam, BorderLayout.SOUTH );

        lblCards = new PanelCard[NUM_FILAS][NUM_COLUMNAS];
        int indice = 0;
        for( int i = 0; i < NUM_FILAS; i++ )
        {
            for( int j = 0; j < NUM_COLUMNAS; j++ )
            {
                lblCards[ i ][ j ] = new PanelCard( principal, team.getCountry( ), team.getYear( ), team.getPlayers( )[ indice++ ] );
                panelPlayers.add( lblCards[ i ][ j ] );
            }
        }

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Actualiza la informacion del team con la informacion dada por parametro.<br>
     * <b>pre: </b> La matriz con las laminas esta inicializada y agregada al panel.<br>
     * <b>post:</b>La informacion mostrada se actualizo.
     * @param pTeam Team que se mostrara en el panel. pTeam != null.
     */
    public void actualizar( Team pTeam )
    {
        team = pTeam;
        int indice = 0;
        for( int i = 0; i < NUM_FILAS; i++ )
        {
            for( int j = 0; j < NUM_COLUMNAS; j++ )
            {
                lblCards[ i ][ j ].actualizar( team.getCountry( ), team.getYear( ), team.getPlayers( )[ indice++ ] );
            }
        }

        if( team.getTeamCard( ) != null )
        {
            ImageIcon icono = new ImageIcon( "./data/images/" + team.getCountry( ) + "/" + team.getYear( ) + "/" + team.getTeamCard( ).getImageName( ) );

            btnTeamCard.setText( "" );
            btnTeamCard.setBorderPainted( false );
            btnTeamCard.setContentAreaFilled( false );
            btnTeamCard.setIcon( icono );
        }
        else
        {
            btnTeamCard.setText( "Paste" );
            btnTeamCard.setBorderPainted( false );
            btnTeamCard.setContentAreaFilled( false );
            btnTeamCard.setIcon( new ImageIcon( "./data/images/toPasteTeam.png" ) );
        }

        if( team.getCrestCard( ) != null )
        {
            ImageIcon icono = new ImageIcon( "./data/images/" + team.getCountry( ) + "/" + team
                    .getYear( ) + "/" + team.getCrestCard( ).getImageName( ) );

            btnCrestCard.setText( "" );
            btnCrestCard.setBorderPainted( false );
            btnCrestCard.setContentAreaFilled( false );
            btnCrestCard.setIcon( icono );
        }
        else
        {
            btnCrestCard.setText( "Paste" );
            btnCrestCard.setBorderPainted( false );
            btnCrestCard.setContentAreaFilled( false );
            btnCrestCard.setIcon( new ImageIcon("./data/images/toPasteCrest.png") );
        }

        lblTituloTeam.setText( team.getCountry( ) + " - " + team.getYear( ) );
    }

    /**
     * Manejo de eventos del usuario.
     * @param pEvent Event de usuario. pEvent != null.
     */
    @Override
    public void actionPerformed( ActionEvent pEvent )
    {
        String command = pEvent.getActionCommand( );

        switch( command )
        {
            case LAMINA_TEAM:
                principal.pasteTeamCard( team.getCountry( ), team.getYear( ) );
                break;
            case LAMINA_CREST:
                principal.pasteCrestCard( team.getCountry( ), team.getYear( ) );
                break;

        }

    }

}
