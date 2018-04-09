/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_club
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.club.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 * Panel que administra los usuarios authorizedUsers.
 */
@SuppressWarnings("serial")
public class PanelAuthorizeds extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    /**
     * Constante para el comando agregar autorizado.
     */
    private final static String AGREGAR_AUTORIZADO = "Agregar autorizado";
    // -----------------------------------------------------------------
    // Attributes de Interfaz
    // -----------------------------------------------------------------

    /**
     * Scroll de authorizedUsers.
     */
    private JScrollPane scrollAuthorizeds;

    /**
     * Lista de authorizedUsers.
     */
    private JList listaAuthorizeds;

    /**
     * Bot�n para agregar el autorizado.
     */
    private JButton btnAgregarAuthorized;

    // -----------------------------------------------------------------
    // Attributes de Interfaz
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazClub principal;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Crea el panel para el manejo de members Authorizeds.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelAuthorizeds( InterfazClub pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Authorizeds" ) );


        // Lista Authorizeds
        listaAuthorizeds = new JList( new DefaultListModel( ) );
        listaAuthorizeds.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        
        // Scroll Desplazamiento
        scrollAuthorizeds = new JScrollPane( listaAuthorizeds );
        scrollAuthorizeds.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scrollAuthorizeds.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );

        
        JPanel contenedor = new JPanel( );
        contenedor.setLayout( new BorderLayout( ) );
        contenedor.add( scrollAuthorizeds, BorderLayout.CENTER );
        add( contenedor, BorderLayout.CENTER );

        btnAgregarAuthorized = new JButton( AGREGAR_AUTORIZADO );
        btnAgregarAuthorized.setActionCommand( AGREGAR_AUTORIZADO );
        btnAgregarAuthorized.addActionListener( this );
        btnAgregarAuthorized.setEnabled( false );
        add( btnAgregarAuthorized, BorderLayout.SOUTH );

    }

    /**
     * Actualiza la lista de authorizedUsers.
     * @param pAuthorizeds La nueva lista con los authorizedUsers que se deben mostrar.
     */
    public void cambiarAuthorizeds( ArrayList pAuthorizeds )
    {
        listaAuthorizeds.removeAll( );
        listaAuthorizeds.setListData( pAuthorizeds.toArray( ) );
        btnAgregarAuthorized.setEnabled( true );
       
    }

    /**
     * Se encarga de procesar eventos ejecutados por el usuario.
     * @param pEvento Evento realizado por el usuario. pEvento != null-
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR_AUTORIZADO ) )
        {
            principal.agregarAuthorized( );
        }

    }
}
