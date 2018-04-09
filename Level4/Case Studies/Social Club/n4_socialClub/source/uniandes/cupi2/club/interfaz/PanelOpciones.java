/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_prestamos
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.club.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Presenta las opciones de extensi�n del ejercicio.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
    /**
     * El comando para opci�n 1.
     */
    private final String OPCION_1 = "opci�n 1";

    /**
     * El comando para opci�n 2.
     */
    private final String OPCION_2 = "opci�n 2";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazClub principal;

    // -----------------------------------------------------------------
    // Attributes de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n de opci�n 1.
     */
    private JButton botonOpcion1;

    /**
     * Bot�n de opci�n 2.
     */
    private JButton botonOpcion2;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Crea el panel con los botones de extensi�n.
     * @param pPrincipal La ventana principal. pPrincipal != null.
     */
    public PanelOpciones( InterfazClub pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridLayout( 1, 2, 3, 10 ) );
        setBorder( new TitledBorder( "Opciones" ) );

        botonOpcion1 = new JButton( "Opci�n 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );

        botonOpcion2 = new JButton( "Opci�n 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );

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
        String comando = pEvento.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
}