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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Panel que contiene el boton lateral de navegacion.
 */
public class PanelLateral extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constante que representa la accion de ir al anterior.
     */
    public static final String ANTERIOR = "<";

    /**
     * Constante que representa la accion de ir al siguiente.
     */
    public static final String SIGUIENTE = ">";

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
     * Boton con la flecha of the  direccion.
     */
    private JButton btnDireccion;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el panel con la informacion of the  lamina. <br>
     * <b>post:</b> Todos los botones fueron inicializados. Se asigno la ventana principal con el valor dado por parametro.
     * @param pUserInterface UserInterface principal of the  aplicacion. pUserInterface != null
     * @param pDireccion Direccion que representa el panel lateral. pDireccion != null && pDireccion pertenece a {ANTERIOR, SIGUIENTE}
     */
    public PanelLateral( albumInterface pUserInterface, String pDireccion )
    {
        principal = pUserInterface;

        setLayout( new GridLayout( 5, 1) );
        setOpaque( false );

        add(new JLabel());
        add(new JLabel());
        btnDireccion = new JButton( );
        btnDireccion.setActionCommand( pDireccion );
        btnDireccion.setContentAreaFilled( false );
        btnDireccion.setBorder( null );
        btnDireccion.setIcon( new ImageIcon(pDireccion.equals( ANTERIOR ) ? "./data/images/previous.png" : "./data/images/next.png") );
        btnDireccion.addActionListener( this );

        add( btnDireccion, BorderLayout.CENTER );
        add(new JLabel());
        add(new JLabel());

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
            case ANTERIOR:
                principal.anterior( );
                break;
            case SIGUIENTE:
                principal.siguiente( );
                break;

        }

    }

}
