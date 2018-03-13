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
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.album.world.Player;

import java.awt.Font;

/**
 * Panel que contiene los elementos que conforman una card.
 */
@SuppressWarnings("serial")
public class PanelCard extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Imagen of the  lamina por defecto.
     */
    public static final ImageIcon LAMINA_DEFECTO = new ImageIcon( "./data/images/player.png" );

    /**
     * Comando para ejecutar la accion del boton btnCard.
     */
    private static final String PEGAR_LAMINA = "PEGAR LÁMINA";

    /**
     * Comando para ejecutar la accion del boton btnTechInfo.
     */
    private static final String FICHA_TECNICA = "FICHA TÉCNICA";

    /**
     * Comando para ejecutar la accion del boton btnModify.
     */
    private static final String MODIFICAR = "MODIFICAR";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Player al cual pertenece la lamina.
     */
    private Player player;

    /**
     * Country al cual represento el player of the  lamina.
     */
    private String country;

    /**
     * Year en el cual represento al pais el player of the  lamina.
     */
    private int year;

    /**
     * Ventana principal of the  aplicacion
     */
    private albumInterface principal;

    // -----------------------------------------------------------------
    // Attributes of the  userInterface
    // -----------------------------------------------------------------

    /**
     * Label que contiene el nombre del player.
     */
    private JLabel lblNamePlayer;

    /**
     * Boton para paste la lamina o mostrar la imagen of the  lamina.
     */
    private JButton btnCard;

    /**
     * Boton para ver la ficha tecnica.
     */
    private JButton btnTechInfo;

    /**
     * Boton para modify la informacion del player.
     */
    private JButton btnModify;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la informacion of the  lamina. <br>
     * <b>post:</b> Todos los botones fueron inicializados. Se asignaron los atributos principal, player, country y year con los parametros dados.
     * @param pUserInterface UserInterface principal of the  aplicacion. pUserInterface != null
     * @param pCountry Country al cual represento el player of the  lamina. pCountry != null && pCountry != "".
     * @param pYear Year en el cual el player of the  lamina represento al pais. pYear > 0.
     * @param pPlayer Player al cual pertenece la lamina. pPlayer != null.
     */
    public PanelCard( albumInterface pUserInterface, String pCountry, int pYear, Player pPlayer )
    {
        player = pPlayer;
        principal = pUserInterface;
        country = pCountry;
        year = pYear;

        setLayout( new BorderLayout( 0, 5 ) );
        setOpaque( false );
        setBorder( null );

        JPanel panelOpciones = new JPanel( new GridLayout( 2, 1 ) );
        add( panelOpciones, BorderLayout.SOUTH );

        lblNamePlayer = new JLabel( player.getName( ) );
        lblNamePlayer.setHorizontalAlignment( JLabel.CENTER );
        lblNamePlayer.setForeground( new Color(220, 232, 255) );
        lblNamePlayer.setFont( new Font( new JLabel().getFont( ).getFontName( ), Font.BOLD, 13 ) );
        add( lblNamePlayer, BorderLayout.NORTH );

        btnCard = new JButton( "Paste" );
        btnCard.setActionCommand( PEGAR_LAMINA );
        btnCard.addActionListener( this );
        btnCard.setContentAreaFilled( false );
        btnCard.setBorder( null );
        btnCard.setForeground( Color.WHITE );
        btnCard.setHorizontalTextPosition( JLabel.CENTER );
        btnCard.setFont( new Font( new JLabel().getFont( ).getFontName( ), Font.BOLD, 16 ) );
        btnCard.setIcon( new ImageIcon( "./data/images/toPaste.png") );

        add( btnCard, BorderLayout.CENTER );

        btnTechInfo = new JButton( "Ficha tecnica" );
        btnTechInfo.setActionCommand( FICHA_TECNICA );
        btnTechInfo.addActionListener( this );
        panelOpciones.add( btnTechInfo );

        btnModify = new JButton( "Modify" );
        btnModify.setActionCommand( MODIFICAR );
        btnModify.addActionListener( this );
        panelOpciones.add( btnModify );

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Actualiza la informacion mostrada con la informacion dada por parametro.<br>
     * <b>pre: </b>Los botones y etiquetas estan inicializados y agregados.<br>
     * <b>post:</b>La informacion mostrada se actualizo. Se modifyon los atributos country, year y player con los parametros dados..<br>
     * @param pCountry Country al cual represento el player of the  lamina. pCountry != null && pCountry != "".
     * @param pYear Year en el cual el player of the  lamina represento al pais. pYear > 0.
     * @param pPlayer Player cuya informacion sera mostrada en el panel. pPlayer != null.
     */
    public void actualizar( String pCountry, int pYear, Player pPlayer )
    {
        player = pPlayer;
        country = pCountry;
        year = pYear;

        if( player.getCard( ) != null )
        {
            btnCard.setText( "" );
            File archImagen = new File( "./data/images/" + pCountry + "/" + pYear + "/" + player.getCard( ).getImageName( ) );
            ImageIcon icono = archImagen.exists( ) ? new ImageIcon( archImagen.getAbsolutePath( ) ) : LAMINA_DEFECTO;
            btnCard.setIcon( icono );
            btnCard.setContentAreaFilled( false );
            btnCard.setBorderPainted( false );
            btnModify.setEnabled( false );
        }
        else
        {
            btnCard.setIcon( new ImageIcon("./data/images/toPaste.png") );
            btnCard.setText( "Paste" );
            btnModify.setEnabled( true );
            btnCard.setContentAreaFilled( false );
            btnCard.setBorderPainted( false );
            btnCard.setBorder( null );
            btnCard.setHorizontalTextPosition( JLabel.CENTER );
        }
        lblNamePlayer.setText( player.getName( ) );

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
            case PEGAR_LAMINA:
                principal.pastePlayerCard( country, year, player.getShirtNumber( ) );
                break;

            case MODIFICAR:
                DialogModifyPlayer dialogoModify = new DialogModifyPlayer( principal, country, year, player );
                dialogoModify.setVisible( true );
                dialogoModify.setLocationRelativeTo( principal );
                break;
            case FICHA_TECNICA:
                DialogTechInfo dialogoFicha = new DialogTechInfo( player );
                dialogoFicha.setVisible( true );
                dialogoFicha.setLocationRelativeTo( principal );
                break;

        }

    }
}
