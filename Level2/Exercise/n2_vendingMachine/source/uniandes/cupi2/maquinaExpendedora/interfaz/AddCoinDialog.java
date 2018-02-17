/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_maquinaExpendedora
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.maquinaExpendedora.interfaz;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 * Dialogo para agregar una moneda.
 */
@SuppressWarnings("serial")
public class DialogoAgregarMoneda extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el tamaño de las imágenes de las monedas.
     */
    private final static int ICON_DIMENSION = 100;

    /**
     * Constante que representa la ruta donde se encuentran las imágenes.
     */
    private final static String RUTA = "./data/imagenes/";

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Arreglo con los botones de monedas.
     */
    private JButton[] btnMoneda;
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazMaquinaExpendedora principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo dialogo. <br>
     * <b> post: </b> Se inicializaron todos los componentes del diálogo.
     * @param pPrincipal Ventana principal de la aplicación. pPrincial != null.
     */
    public DialogoAgregarMoneda( InterfazMaquinaExpendedora pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Agregar Moneda" );
        setSize( ICON_DIMENSION * 6, ( int ) ( ICON_DIMENSION * 1.5 ) );
        setLayout( new GridLayout( 1, 5 ) );

        String[] monedas = { "50", "100", "200", "500", "1000" };
        btnMoneda = new JButton[monedas.length];

        for( int i = 0; i < monedas.length; i++ )
        {
            btnMoneda[ i ] = new JButton( );
            ImageIcon icon = new ImageIcon( RUTA + monedas[ i ] + ".png" );
            icon = new ImageIcon( icon.getImage( ).getScaledInstance( ICON_DIMENSION, ICON_DIMENSION, Image.SCALE_SMOOTH ) );
            btnMoneda[ i ].setIcon( icon );
            btnMoneda[ i ].setActionCommand( monedas[ i ] );
            btnMoneda[ i ].addActionListener( this );
            add( btnMoneda[ i ] );
        }
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
        int moneda = Integer.parseInt( pEvento.getActionCommand( ) );
        dispose( );
        principal.agregarMoneda( moneda );
    }

}
