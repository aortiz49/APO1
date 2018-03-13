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
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Player;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

/**
 * Dialog que muestra la informacion total de un player.
 */
@SuppressWarnings("serial")
public class DialogPlayer extends JDialog
{

    // -----------------------------------------------------------------
    // Attributes of the  userInterface
    // -----------------------------------------------------------------

    /**
     * Campo de texto con el nombre de player.
     */
    private JTextField txtName;

    /**
     * Campo de texto con el año de nacimiento del player.
     */
    private JTextField txtBirthYear;

    /**
     * Campo de texto con la altura del player.
     */
    private JTextField txtHeight;

    /**
     * Campo de texto con el peso del player.
     */
    private JTextField txtWeight;

    /**
     * Campo de texto con la posicion del player.
     */
    private JTextField txtPosition;
    
    /**
     * Campo de texto con el team del player.
     */
    private JTextField txtTeam;
    
    /**
     * Etiqueta que contiene la imagen of the  lamina del player.
     */
    private JLabel lblCard;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el dialogo que contiene la ficha tecnica el player.<br>
     * <b> post: </b> Todos los botones, etiquetas y campos de texto fueron inicializados y ubicados.
     * @param pTeam Team al que pertenece el player. pTeam != null.
     * @param pPlayer Player que se va a modify. pPlayer != null.
     */
    public DialogPlayer(Team pTeam, Player pPlayer )
    {

        setSize( 450, 300 );
        setTitle( "Ficha tecnica" );
        JPanel panelGeneral = new JPanel( );
        panelGeneral.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
        add( panelGeneral );

        panelGeneral.setLayout( new BorderLayout( 0, 15 ) );
        JPanel panelInfo = new JPanel( new GridLayout( 5, 2, 0, 15 ) );
        panelGeneral.add( panelInfo, BorderLayout.CENTER );
        
       lblCard = new JLabel(  );
       ImageIcon icono;
      
       if(pPlayer.hasCard( )){
           File archImagen = new File( "./data/images/" + pTeam.getCountry( ) + "/" + pTeam.getYear( ) + "/" + pPlayer.getCard( ).getImageName( ) );
           icono= archImagen.exists( ) ? new ImageIcon( archImagen.getAbsolutePath( ) ) : PanelCard.LAMINA_DEFECTO;
       }
       else{
           icono = new ImageIcon("./data/images/toPaste.png");
       }
       lblCard.setIcon( icono );
       add(lblCard, BorderLayout.WEST);

        txtName = new JTextField( pPlayer.getName( ) );
        txtName.setFont( new Font( "Tahoma", Font.BOLD, 24 ) );
        txtName.setHorizontalAlignment( SwingConstants.CENTER );
        txtName.setEditable( false );
        panelGeneral.add( txtName, BorderLayout.NORTH );

        JLabel lblTeam = new JLabel( "Team: " );
        panelInfo.add( lblTeam );
        txtTeam = new JTextField( pTeam.toString( ) );
        txtTeam.setEditable( false );
        panelInfo.add( txtTeam );
        
        JLabel lblBirthYear = new JLabel( "Year de nacimiento: " );
        panelInfo.add( lblBirthYear );
        txtBirthYear = new JTextField( pPlayer.getBirthYear( ) + "" );
        txtBirthYear.setEditable( false );
        panelInfo.add( txtBirthYear );

        JLabel lblHeight = new JLabel( "Height: " );
        panelInfo.add( lblHeight );
        txtHeight = new JTextField( pPlayer.getHeight( ) + "" );
        txtHeight.setEditable( false );
        panelInfo.add( txtHeight );

        JLabel lblWeight = new JLabel( "Weight: " );
        panelInfo.add( lblWeight );
        txtWeight = new JTextField( pPlayer.getWeight( ) + "" );
        txtWeight.setEditable( false );
        panelInfo.add( txtWeight );

        JLabel lblPosition = new JLabel( "Position: " );
        panelInfo.add( lblPosition );
        txtPosition = new JTextField( pPlayer.getPosition( ).toString( ).toLowerCase( ) );
        txtPosition.setEditable( false );
        panelInfo.add( txtPosition );

    }

}
