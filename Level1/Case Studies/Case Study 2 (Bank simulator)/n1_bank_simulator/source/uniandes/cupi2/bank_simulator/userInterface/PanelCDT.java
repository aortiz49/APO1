/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.bank_simulator.userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de la aplicaci�n.
 */
@SuppressWarnings("serial")
public class PanelCertificateOfDeposit extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para abrir un CertificateOfDeposit.
     */
    private final static String ABRIR_CertificateOfDeposit = "ABRIR CertificateOfDeposit";

    /**
     * Constante para cerrar un CertificateOfDeposit.
     */
    private final static String CERRAR_CertificateOfDeposit = "CERRAR CertificateOfDeposit";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Ventana principal del simulador.
     */
    private InterfazSimulador principal;

    // -----------------------------------------------------------------
    // Attributes de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta del saldo del CertificateOfDeposit.
     */
    private JLabel etiquetaSaldoCdt;

    /**
     * Campo donde se visualiza el saldo del CertificateOfDeposit.
     */
    private JTextField txtSaldoCdt;

    /**
     * Boton para abrir un nuevo CertificateOfDeposit.
     */
    private JButton btnAbrirCertificateOfDeposit;

    /**
     * Boton para cancelar un CertificateOfDeposit.
     */
    private JButton btnCerrarCertificateOfDeposit;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo panel e inicializa sus elementos. <br>
     * <b>post: </b> Se inicializ� el panel.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelCertificateOfDeposit( InterfazSimulador pPrincipal )
    {

        // Inicializa los elementos del panel
        principal = pPrincipal;

        etiquetaSaldoCdt = new JLabel( "Saldo CertificateOfDeposit: " );
        txtSaldoCdt = new JTextField( 14 );
        txtSaldoCdt.setEditable( false );

        btnAbrirCertificateOfDeposit = new JButton( "Abrir" );
        btnAbrirCertificateOfDeposit.setActionCommand( ABRIR_CertificateOfDeposit );
        btnAbrirCertificateOfDeposit.addActionListener( this );
        btnAbrirCertificateOfDeposit.setPreferredSize( new Dimension( 100, 0 ) );

        btnCerrarCertificateOfDeposit = new JButton( "Cerrar" );
        btnCerrarCertificateOfDeposit.setActionCommand( CERRAR_CertificateOfDeposit );
        btnCerrarCertificateOfDeposit.addActionListener( this );
        btnCerrarCertificateOfDeposit.setPreferredSize( new Dimension( 100, 0 ) );

        JPanel panelInfo = new JPanel( );
        JPanel panelBotones = new JPanel( );
        panelInfo.setLayout( new GridLayout( 1, 2 ) );
        panelInfo.setBorder( new EmptyBorder( 0, 0, 5, 0 ) );
        panelBotones.setLayout( new BorderLayout( ) );
        panelBotones.setBorder( new EmptyBorder( 0, 5, 5, 5 ) );
        panelBotones.setPreferredSize( new Dimension( 215, 0 ) );

        // Ubica los elementos en el panel
        panelInfo.add( etiquetaSaldoCdt );
        panelInfo.add( txtSaldoCdt );
        panelBotones.add( btnAbrirCertificateOfDeposit, BorderLayout.WEST );
        panelBotones.add( new JLabel( " " ), BorderLayout.CENTER );
        panelBotones.add( btnCerrarCertificateOfDeposit, BorderLayout.EAST );

        setLayout( new BorderLayout( ) );
        add( panelInfo, BorderLayout.CENTER );
        add( panelBotones, BorderLayout.EAST );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 3, 5, 3 ), new TitledBorder( "CertificateOfDeposit" ) ) );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Actualiza el saldo del CertificateOfDeposit del cliente en la userInterface. <br>
     * <b>post: </b> Se actualiz� la informaci�n con el saldo en CertificateOfDeposit.
     * @param pSaldo Saldo en el CertificateOfDeposit del cliente. pSaldo != null.
     */
    public void actualizarSaldoCertificateOfDeposit( String pSaldo )
    {
        txtSaldoCdt.setText( pSaldo );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un bot�n. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String command = pEvento.getActionCommand( );
        if( command.equals( ABRIR_CertificateOfDeposit ) )
        {
            String strValor = JOptionPane.showInputDialog( principal, "Introduzca el monto de dinero de la inversi�n", "Abrir CertificateOfDeposit", JOptionPane.QUESTION_MESSAGE );
            if( strValor != null )
            {
                String strInteres = JOptionPane.showInputDialog( principal, "Introduzca el inter�s mensual en porcentaje", "Abrir CertificateOfDeposit", JOptionPane.QUESTION_MESSAGE );
                if( strInteres != null )
                {
                    principal.invertirCertificateOfDeposit( strValor, strInteres );
                }
            }
        }
        else if( command.equals( CERRAR_CertificateOfDeposit ) )
        {
            principal.cerrarCertificateOfDeposit( );
        }


    }

}
