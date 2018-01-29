/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Proyecto	Cupi2	(http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_vendingMachine
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.userInterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Contiene los botones ubicados en la parte inferior de la ventana principal.
 */
@SuppressWarnings("serial")
public class PanelOptions extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ejecutar la acción del botón btnOpcion1.
     */
    private static final String OPCION1 = "Opción 1";

    /**
     * Comando para ejecutar la acción del botón btnOpcion2.
     */
    private static final String OPCION2 = "Opción 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfaceVendingMachine principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para la opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón para la opción 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los botones <br>
     * <b>post:</b> Todos los botones fueron inicializados.
     * @param pInterfaz Interfaz principal de la aplicación. pInterfaz != null
     */
    public PanelOptions( InterfaceVendingMachine pInterfaz )
    {
        TitledBorder b = BorderFactory.createTitledBorder( "Opciones" );
        setBorder( b );

        principal = pInterfaz;
        setLayout( new GridLayout( 1, 3 ) );

        btnOpcion1 = new JButton( OPCION1 );
        btnOpcion2 = new JButton( OPCION2 );

        btnOpcion1.addActionListener( this );
        btnOpcion2.addActionListener( this );

        btnOpcion1.setActionCommand( OPCION1 );
        btnOpcion2.setActionCommand( OPCION2 );

        add( btnOpcion1 );
        add( btnOpcion2 );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos del usuario.
     * @param pEvento Evento de usuario. pEvento != null.
     */
    @Override
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( OPCION1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( pEvento.getActionCommand( ).equals( OPCION2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

}
