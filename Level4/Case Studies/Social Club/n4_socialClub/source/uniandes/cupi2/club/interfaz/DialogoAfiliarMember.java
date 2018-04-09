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

import uniandes.cupi2.club.world.Member.MembershipType;

/**
 * Di�logo para add un nuevo socio al club.
 */
public class DialogoAfiliarMember extends JDialog implements ActionListener
{
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constante para el comando Regular.
     */
    private static final String TIPO_REGULAR = "Regular";

    /**
     * Constante para el comando VIP.
     */
    private static final String TIPO_VIP = "VIP";

    /**
     * Constante para el comando Afiliar.
     */
    private static final String AFILIAR = "AFILIAR";

    // -----------------------------------------------------------------
    // Attributes de Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto de la c�dula del nuevo socio.
     */
    private JTextField txtIdentification;

    /**
     * Campo de texto del name del nuevo socio.
     */
    private JTextField txtName;

    /**
     * Combobox para el tipo de la suscripci�n.
     */
    private JComboBox<String> cmbMembershipTypeSuscripcion;

    /**
     * Bot�n para afiliar el socio.
     */
    private JButton botonAfiliar;

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
     * Construye el di�logo con todos sus componentes.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public DialogoAfiliarMember( InterfazClub pPrincipal )
    {
        principal = pPrincipal;
        setTitle( "Afiliar nuevo socio" );
        setSize( 350, 250 );
        setLocationRelativeTo( principal );

        JPanel panelGeneral = new JPanel( );
        panelGeneral.setBorder( new CompoundBorder( new TitledBorder( "Datos socio" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
        panelGeneral.setLayout( new BorderLayout( ) );
        add( panelGeneral );

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 4, 2, 3, 3 ) );
        panelGeneral.add( panelDatos, BorderLayout.CENTER );

        JLabel etiquetaName = new JLabel( "Name completo:" );
        panelDatos.add( etiquetaName );

        txtName = new JTextField( );
        panelDatos.add( txtName );

        JLabel etiquetaIdentification = new JLabel( "Ceedula:" );
        panelDatos.add( etiquetaIdentification );

        txtIdentification = new JTextField( );
        panelDatos.add( txtIdentification );

        JLabel etiquetaMembershipType = new JLabel( "MembershipType suscripci�n: " );
        panelDatos.add( etiquetaMembershipType );

        cmbMembershipTypeSuscripcion = new JComboBox<String>( );
        cmbMembershipTypeSuscripcion.addItem( TIPO_REGULAR );
        cmbMembershipTypeSuscripcion.addItem( TIPO_VIP );
        panelDatos.add( cmbMembershipTypeSuscripcion );

        panelDatos.add( new JLabel( ) );
        panelDatos.add( new JLabel( ) );

        botonAfiliar = new JButton( "Afiliar" );
        botonAfiliar.setActionCommand( AFILIAR );
        botonAfiliar.addActionListener( this );
        panelGeneral.add( botonAfiliar, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Se encarga de procesar eventos ejecutados por el usuario.
     * @param pEvento Evento realizado por el usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String actionCommand = pEvento.getActionCommand( );

        if( AFILIAR.equals( actionCommand ) )
        {
            String strName = txtName.getText( );
            String strIdentification = txtIdentification.getText( );
            String strMembershipTypeSuscripcion = ( String )cmbMembershipTypeSuscripcion.getSelectedItem( );
            MembershipType tipoSuscripcion = null;
            switch( ( strMembershipTypeSuscripcion ) )
            {
                case ( TIPO_REGULAR ):
                    tipoSuscripcion = MembershipType.REGULAR;
                    break;
                case ( TIPO_VIP ):
                    tipoSuscripcion = MembershipType.VIP;
                    break;
            }

            // Valida los campos vac�os
            if( strName == null || strName.isEmpty( ) || strIdentification == null || strIdentification.isEmpty( ) )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar todos los datos.", "Afiliar socio", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                principal.registerMember( strIdentification, strName, tipoSuscripcion );
                dispose( );
            }
        }

    }

}
