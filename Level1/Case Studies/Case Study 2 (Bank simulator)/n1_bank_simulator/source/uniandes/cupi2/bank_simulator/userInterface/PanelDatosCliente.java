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

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con los datos del cliente.
 */
@SuppressWarnings("serial")
public class PanelDatosCliente extends JPanel
{

    // -----------------------------------------------------------------
    // Attributes de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta de nombre del cliente.
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta de c�dula.
     */
    private JLabel etiquetaCedula;

    /**
     * Campo para visualizar el nombre del cliente.
     */
    private JTextField txtNombre;

    /**
     * Campo para visualizar la cedula del cliente.
     */
    private JTextField txtCedula;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel con los elementos necesarios para su operaci�n y los inicializa adecuadamente. <br>
     * <b>post: </b> Se inicializ� el panel.
     */
    public PanelDatosCliente( )
    {

        // Inicializa los elementos del panel
        etiquetaNombre = new JLabel( " Nombre: " );
        etiquetaCedula = new JLabel( "  C�dula: " );

        txtNombre = new JTextField( 11 );
        txtCedula = new JTextField( 7 );
        txtNombre.setEditable( false );
        txtCedula.setEditable( false );

        // ubica los elemento del panel
        JPanel panelInfo = new JPanel( );
        panelInfo.setLayout( new GridLayout( 1, 4 ) );
        panelInfo.setBorder( new EmptyBorder( 0, 0, 5, 0 ) );
        panelInfo.add( etiquetaNombre );
        panelInfo.add( txtNombre );
        panelInfo.add( etiquetaCedula );
        panelInfo.add( txtCedula );

        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Datos cliente" ) ) );
        setLayout( new GridLayout( 1, 1 ) );
        add( panelInfo );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Actualiza en la userInterface el campo de nombre del cliente. <br>
     * <b>post: </b> Se mostr� el nombre del cliente en el campo correspondiente.
     * @param pNombre Nombre del cliente. pNombre != null && pNombre != "".
     */
    public void actualizarNombre( String pNombre )
    {
        txtNombre.setText( pNombre );
    }

    /**
     * Actualiza en la userInterface el campo de c�dula del cliente. <br>
     * <b>post: </b>Se mostr� la c�dula del cliente en el campo correspondiente.
     * @param pCedula C�dula del cliente. pCedula != null && pCedula != "".
     */
    public void actualizarCedula( String pCedula )
    {
        txtCedula.setText( "" + pCedula );
    }

}
