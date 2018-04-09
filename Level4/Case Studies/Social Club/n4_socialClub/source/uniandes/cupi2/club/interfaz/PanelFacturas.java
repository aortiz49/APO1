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

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.club.world.Bill;

/**
 * Panel que administra las Bills de los usuarios.
 */
@SuppressWarnings("serial")
public class PanelBills extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String PAGAR_FACTURA = "Pagar factura";

    // -----------------------------------------------------------------
    // Attributes de Interfaz
    // -----------------------------------------------------------------

    /**
     * Scroll de bills.
     */
    private JScrollPane scrollDesplazamiento;

    /**
     * Lista de bills.
     */
    private JList listaBills;

    /**
     * Bot�n pagar factura.
     */
    private JButton btnPagarBill;

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
     * Crea el panel de bills
     * @param pPrincipal Instancia del panel contenedor. pPrincipal != null.
     */
    public PanelBills( InterfazClub pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Bills" ) );

        scrollDesplazamiento = new JScrollPane( );
        // Lista donde se almacenaran las bills
        listaBills = new JList( );
        listaBills.setSelectionMode( javax.swing.ListSelectionModel.SINGLE_SELECTION );
        // Scroll que desplegara la lista de bills
        scrollDesplazamiento.setVerticalScrollBarPolicy( javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scrollDesplazamiento.setViewportView( listaBills );
        add( scrollDesplazamiento, BorderLayout.CENTER );

        btnPagarBill = new JButton( PAGAR_FACTURA);
        btnPagarBill.setActionCommand( PAGAR_FACTURA );
        btnPagarBill.addActionListener( this );
        btnPagarBill.setEnabled( false );
        add( btnPagarBill, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------


    /**
     * Se encarga de procesar eventos ejecutados por el usuario.
     * @param pEvento Evento realizado por el usuario. pEvento != null-
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String actionCommand = pEvento.getActionCommand( );

        if( PAGAR_FACTURA.equals( actionCommand ) )
        {
            principal.pagarBill( );
        }
    }

    /**
     * Indica si alguna factura seleccionada.
     * @return Retorna true si hay una factura seleccionada, false en caso contrario.
     */
    public boolean hayBillSeleccionada( )
    {
        return listaBills.getSelectedIndex( ) != -1;
    }

    /**
     * Retorna el �ndice de la factura seleccionada.
     * @return El �ndice de la factura seleccionada.
     */
    public int darPosicionBillSeleccionada( )
    {
        return listaBills.getSelectedIndex( );
    }

    /**
     * Actualiza la lista de bills mostrada.
     * @param pBills La nueva lista con las bills que se deben mostrar.
     */
    public void cambiarBills( ArrayList<Bill> pBills )
    {
        listaBills.removeAll( );
        listaBills.setListData( pBills.toArray( ) );
        if(!pBills.isEmpty( ))
        {
            listaBills.setSelectedIndex( 0 );
           btnPagarBill.setEnabled( true );
        }
        else
        {
            btnPagarBill.setEnabled( false );
        }
    }

}
