package uniandes.cupi2.club.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.club.world.Member;
import uniandes.cupi2.club.world.Member.MembershipType;

/**
 * Panel con la informaci�n de un socio
 */
public class PanelSocio extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    /**
     * Constante para la acci�n de registrar consumo.
     */
    private final static String REGISTRAR_CONSUMO = "Registrar consumo";

    /**
     * Constante para la acci�n de aumentar funds.
     */
    private final static String AUMENTAR_FONDOS = "Aumentar funds";

    // -----------------------------------------------------------------
    // Attributes de la interfaz
    // -----------------------------------------------------------------
    /**
     * Campo de texto con la c�dula del socio.
     */
    private JTextField txtIdentification;

    /**
     * Campo de texto con el name del socio.
     */
    private JTextField txtName;

    /**
     * Campo de texto con los funds del socio.
     */
    private JTextField txtFondos;

    /**
     * Campo de texto para el tipo de suscripci�n.
     */
    private JTextField txtMembershipTypeSuscripcion;

    /**
     * Bot�n para registrar consumo.
     */
    private JButton btnRegistrarConsumo;

    /**
     * Bot�n para aumentar funds.
     */
    private JButton btnAumentarFondos;
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazClub principal;
    
    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------
    /**
     * Construye el panel y todos sus componentes
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelSocio(InterfazClub pPrincipal )
    {
        setBorder( new TitledBorder( "Datos socio" ) );
        setLayout( new BorderLayout( ) );
        principal = pPrincipal;

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 6, 2, 5, 5 ) );
        add( panelDatos, BorderLayout.CENTER );

        JLabel lblIdentification = new JLabel( "Cedula:" );
        panelDatos.add( lblIdentification );

        txtIdentification = new JTextField( );
        txtIdentification.setEditable( false );
        panelDatos.add( txtIdentification );

        JLabel lblName = new JLabel( "Name:" );
        panelDatos.add( lblName );

        txtName = new JTextField( );
        txtName.setEditable( false );
        panelDatos.add( txtName );

        JLabel lblFondos = new JLabel( "Fondos disponibles:" );
        panelDatos.add( lblFondos );

        txtFondos = new JTextField( );
        txtFondos.setEditable( false );
        panelDatos.add( txtFondos );

        JLabel lblMembershipTypeSuscripcion = new JLabel( "MembershipType suscripci�n:" );
        panelDatos.add( lblMembershipTypeSuscripcion );

        txtMembershipTypeSuscripcion = new JTextField( );
        txtMembershipTypeSuscripcion.setEditable( false );
        panelDatos.add( txtMembershipTypeSuscripcion );

        panelDatos.add( new JLabel( ) );

        btnRegistrarConsumo = new JButton( REGISTRAR_CONSUMO );
        btnRegistrarConsumo.setEnabled( false );
        btnRegistrarConsumo.setActionCommand( REGISTRAR_CONSUMO );
        btnRegistrarConsumo.addActionListener( this );
        panelDatos.add( btnRegistrarConsumo );

        panelDatos.add( new JLabel( ) );

        btnAumentarFondos = new JButton( AUMENTAR_FONDOS );
        btnAumentarFondos.setEnabled( false );
        btnAumentarFondos.setActionCommand( AUMENTAR_FONDOS );
        btnAumentarFondos.addActionListener( this );
        panelDatos.add( btnAumentarFondos );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * Actualiza el panel con la informaci�n del socio recibido.
     * @param pMember Member a mostrar. pMember != null.
     */
    public void actualizar( Member pMember )
    {
        txtIdentification.setText( pMember.getIdentification( ) );
        txtName.setText( pMember.getName( ) );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$###,###.##" );
        txtFondos.setText( df.format( pMember.getFunds( ) ) );
        MembershipType tipoSuscripcion = pMember.getMembershipType( );
        switch( tipoSuscripcion )
        {
            case REGULAR:
                txtMembershipTypeSuscripcion.setText( "Regular" );
                break;
            case VIP:
                txtMembershipTypeSuscripcion.setText( "VIP" );
                break;
        }
        btnAumentarFondos.setEnabled( true );
        btnRegistrarConsumo.setEnabled( true );
    }
    
    /**
     * Se encarga de procesar eventos ejecutados por el usuario.
     * @param pEvento Evento realizado por el usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( REGISTRAR_CONSUMO ) )
        {
            DialogoRegistrarConsumo dialogo = new DialogoRegistrarConsumo( principal, principal.getAuthorizedUsers( ) );
            dialogo.setVisible( true );
        }
        else if( comando.equals( AUMENTAR_FONDOS ) )
        {
            principal.increaseFunds( );
        }

    }
}
