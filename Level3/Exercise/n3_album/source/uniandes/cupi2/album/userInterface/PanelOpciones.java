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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel con las opciones generales.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Comando para ejecutar la accion del boton btnAddTeam.
     */
    private static final String ADD_TEAM = "ADD TEAM";

    /**
     * Comando para ejecutar la accion del boton btnFindTeams.
     */
    private static final String FIND_TEAM = "FIND TEAM";

    /**
     * Comando para ejecutar la accion del boton btnMostCommonAge.
     */
    private static final String EDAD_MAS_COMUN = "EDAD MAS COMÚN";

    /**
     * Comando para ejecutar la accion del boton btnEstadisticas.
     */
    private static final String ESTADISTICAS = "ESTADISTICAS";

    /**
     * Comando para ejecutar la accion del boton btnFindPlayer.
     */
    private static final String FIND_PLAYER = "FIND PLAYER";

    /**
     * Comando para ejecutar la accion del boton btnOpcion1.
     */
    private static final String OPCION_1 = "OPCIÓN 1";

    /**
     * Comando para ejecutar la accion del boton btnOpcion2.
     */
    private static final String OPCION_2 = "OPCIÓN 2";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Ventana principal of the  aplicacion
     */
    private albumInterface principal;

    // -----------------------------------------------------------------
    // Attributes of the  userInterface
    // -----------------------------------------------------------------

    /**
     * Boton para add un team.
     */
    private JButton btnAddTeam;

    /**
     * Boton para find un team.
     */
    private JButton btnFindTeams;

    /**
     * Boton para find un player.
     */
    private JButton btnFindPlayer;

    /**
     * Boton para conocer la edad mas común.
     */
    private JButton btnMostCommonAge;

    /**
     * Boton para conocer las estadisticas del album.
     */
    private JButton btnEstadisticas;

    /**
     * Boton para la opcion 1.
     */
    private JButton btnOpcion1;

    /**
     * Boton para la opcion 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los botones <br>
     * <b>post:</b> Todos los botones fueron inicializados. Se asigno el atributo principal con el valor dado por parametro.
     * @param pUserInterface UserInterface principal of the  aplicacion. pUserInterface != null
     */
    public PanelOpciones( albumInterface pUserInterface )
    {

        principal = pUserInterface;
        setOpaque( false );
        setLayout( new GridLayout( 1, 7 ) );

        btnAddTeam = new JButton( "Add Team" );
        btnAddTeam.setActionCommand( ADD_TEAM );
        btnAddTeam.addActionListener( this );
        add( btnAddTeam );

        btnFindPlayer = new JButton( "Find player" );
        btnFindPlayer.setActionCommand( FIND_PLAYER );
        btnFindPlayer.addActionListener( this );
        add( btnFindPlayer );

        btnFindTeams = new JButton( "Teams por año" );
        btnFindTeams.setActionCommand( FIND_TEAM );
        btnFindTeams.addActionListener( this );
        add( btnFindTeams );

        btnMostCommonAge = new JButton( "Edad mas común" );
        btnMostCommonAge.setActionCommand( EDAD_MAS_COMUN );
        btnMostCommonAge.addActionListener( this );
        add( btnMostCommonAge );

        btnEstadisticas = new JButton( "Estadisticas" );
        btnEstadisticas.setActionCommand( ESTADISTICAS );
        btnEstadisticas.addActionListener( this );
        add( btnEstadisticas );

        btnOpcion1 = new JButton( "Opcion 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        btnOpcion2 = new JButton( "Opcion 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

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
            case FIND_PLAYER:
                DialogFindPlayer dialogoFind = new DialogFindPlayer( principal );
                dialogoFind.setVisible( true );
                dialogoFind.setLocationRelativeTo( principal );
                break;
            case FIND_TEAM:
                principal.findTeamsPorYear( );
                break;
            case ADD_TEAM:
                DialogAddTeam dialogoAdd = new DialogAddTeam( principal );
                dialogoAdd.setVisible( true );
                dialogoAdd.setLocationRelativeTo( principal );
                break;
            case EDAD_MAS_COMUN:
                principal.mostrarMostCommonAge( );
                break;
            case ESTADISTICAS:
                principal.mostrarEstadisticas( );
                break;
            case OPCION_1:
                principal.reqFuncOpcion1( );
                break;
            case OPCION_2:
                principal.reqFuncOpcion2( );
                break;

        }

    }

}
