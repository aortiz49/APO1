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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.club.world.Member;

/**
 * Panel para ver la lista de members y consultar sus consumos.
 */
@SuppressWarnings("serial")
public class PanelListaSocios extends JPanel implements ListSelectionListener, ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    /**
     * Constante para el comando add.
     */
    private final static String AFILIAR = "Afiliar socio";
    // -----------------------------------------------------------------
    // Attributes de Interfaz
    // -----------------------------------------------------------------

    /**
     * Scroll de members.
     */
    private JScrollPane scrollMembers;

    /**
     * La lista de members.
     */
    private JList members;

    /**
     * Bot�n para add un nuevo socio.
     */
    private JButton btnAfiliar;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Instancia del la clase principal de la interfaz.
     */
    private InterfazClub principal;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Crea el Panel donde se organizar�n los objetos para mostrar las personas.
     * @param pPrincipal Instancia de la clase Interfaz. pPrincipal != null.
     */
    public PanelListaSocios(InterfazClub pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Members" ) );
        setPreferredSize( new Dimension( 300, 0 ) );

        members = new JList( );

        scrollMembers = new JScrollPane( members );
        members.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        members.addListSelectionListener( this );
        scrollMembers.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scrollMembers.setHorizontalScrollBarPolicy( javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        add( scrollMembers, BorderLayout.CENTER );

        btnAfiliar = new JButton( AFILIAR );
        btnAfiliar.setActionCommand( AFILIAR );
        btnAfiliar.addActionListener( this );
        add( btnAfiliar, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Retorna el value de la c�dula del socio seleccionado.
     * @return C�dula del socio seleccionado.
     */
    public String getIdentificationMemberSeleccionado( )
    {
        String cadena = "";
        if( members.getSelectedValue( ) != null )
        {
            Member actual = ( Member )members.getSelectedValue( );
            cadena = actual.getIdentification( );
        }
        return cadena;
    }

    /**
     * Actualiza la lista con los members enviados por par�metro.
     * @param pLista Lista de members.
     */
    public void refrescar( ArrayList<Member> pLista )
    {
        members.setListData( pLista.toArray( ) );
        if(!pLista.isEmpty( ))
        {
            members.setSelectedIndex( 0 );
        }
    }

    /**
     * Cambia el socio actualmente seleccionado.
     * @param pMember Member actual. pMember != null.
     */
    public void cambiarActual( Member pMember)
    {
        members.setSelectedValue( pMember, true );
    }
    /**
     * Manejo de los eventos del cambio de value en la lista de members.
     * @param pEvento Cambio de elemento que gener� el evento.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        if( members.getSelectedValue( ) != null )
        {
            principal.actualizar();
        }
    }

    /**
     * Se encarga de procesar eventos ejecutados por el usuario.
     * @param pEvento Evento realizado por el usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AFILIAR ) )
        {
            DialogoAfiliarMember dialogo = new DialogoAfiliarMember( principal );
            dialogo.setVisible( true );
        }
    }
}
