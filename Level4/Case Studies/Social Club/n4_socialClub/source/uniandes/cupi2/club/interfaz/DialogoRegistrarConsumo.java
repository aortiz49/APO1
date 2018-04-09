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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Di�logo para registrar un consumo.
 * 
 */
public class DialogoRegistrarConsumo extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String REGISTRAR_CONSUMO = "Registrar consumo";

    // -----------------------------------------------------------------
    // Attributes de Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo clientes.
     */
    private JComboBox cmbClientes;

    /**
     * Campo invoice.
     */
    private JTextField txtInvoice;

    /**
     * Campo value.
     */
    private JTextField txtValue;

    /**
     * Bot�n registrar consumo.
     */
    private JButton btnRegistrarConsumo;

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
     * Crea el di�logo y todos sus componentes.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     * @param pClientes Lista de clientes para registrar el consumo.
     */
    public DialogoRegistrarConsumo( InterfazClub pPrincipal, ArrayList pClientes )
    {
        principal = pPrincipal;
        setTitle( "Registrar consumo" );
        setSize( 350, 250 );
        setLocationRelativeTo( principal );

        JPanel panelGeneral = new JPanel( );
        panelGeneral.setBorder( new CompoundBorder( new TitledBorder( "Datos socio" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
        panelGeneral.setLayout( new BorderLayout( ) );
        add( panelGeneral );

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 4, 2, 3, 3 ) );
        panelGeneral.add( panelDatos, BorderLayout.CENTER );

        JLabel lblCliente = new JLabel( "Cliente:" );
        panelDatos.add( lblCliente );

        cmbClientes = new JComboBox( );
        for( int i = 0; i < pClientes.size( ); i++ )
        {
            String name = ( String )pClientes.get( i );
            cmbClientes.addItem( name );
        }
        panelDatos.add( cmbClientes );

        JLabel lblInvoice = new JLabel( "Invoice:" );
        panelDatos.add( lblInvoice );

        txtInvoice = new JTextField( );
        panelDatos.add( txtInvoice );

        JLabel lblValue = new JLabel( "Value" );
        panelDatos.add( lblValue );

        txtValue = new JTextField( );
        panelDatos.add( txtValue );

        panelDatos.add( new JLabel( ) );
        panelDatos.add( new JLabel( ) );

        btnRegistrarConsumo = new JButton( "Registrar" );
        btnRegistrarConsumo.setActionCommand( REGISTRAR_CONSUMO );
        btnRegistrarConsumo.addActionListener( this );
        panelGeneral.add( btnRegistrarConsumo, BorderLayout.SOUTH );
    }

    /**
     * Se encarga de procesar eventos ejecutados por el usuario.
     * @param pEvento Evento realizado por el usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String actionCommand = pEvento.getActionCommand( );
        if( REGISTRAR_CONSUMO.equals( actionCommand ) )
        {
            String strInvoice = txtInvoice.getText( );
            String strValue = txtValue.getText( );
            String strName = ( String )cmbClientes.getSelectedItem( );
            double value = 0;
            if( strInvoice == null || strInvoice.isEmpty( ) || strValue == null || strValue.isEmpty( ) )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar todos los datos.", "Registrar consumo", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                try
                {
                    value = Double.parseDouble( strValue );
                    if( value > 0 )
                    {
                        principal.registerConsumption( strName, strInvoice, value );
                        dispose( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El value a registrar debe ser mayor a cero.", "Registrar consumo", JOptionPane.ERROR_MESSAGE );

                    }
                }
                catch( Exception e )
                {
                    JOptionPane.showMessageDialog( this, "El value a registrar debe ser un value num�rico.", "Registrar consumo", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
    }
}
