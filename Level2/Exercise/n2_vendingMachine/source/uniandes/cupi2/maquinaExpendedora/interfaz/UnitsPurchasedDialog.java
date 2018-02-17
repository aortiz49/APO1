/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_maquinaExpendedora
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.maquinaExpendedora.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Representa el dialogo de la información de las compras.
 */
@SuppressWarnings("serial")
public class DialogoUnidadesCompradas extends JDialog
{

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto con la información de la cantidad total de compras.
     */
    private JTextField txtCantidadTotal;

    /**
     * Campo de texto con la información de la cantidad de compras del producto 1.
     */
    private JTextField txtCantidadProducto1;

    /**
     * Campo de texto con la información de la cantidad de compras del producto 2.
     */
    private JTextField txtCantidadProducto2;

    /**
     * Campo de texto con la información de la cantidad de compras del producto 3.
     */
    private JTextField txtCantidadProducto3;

    /**
     * Campo de texto con la información de la cantidad de compras del producto 4.
     */
    private JTextField txtCantidadProducto4;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo con la información de las unidades compradas.<br>
     * <b>post:</b> Creó el diálogo con cada uno de sus componentes.
     * @param pCantidadTotal Cantidad total de unidades compradas. pCantidadTotal >=0.
     * @param pCantidadProducto1 Cantidad de unidades compradas del producto 1. pCantidadProducto1>=0.
     * @param pNombreProducto1 Nombre del producto 1. pNombre != null && pNombre != "".
     * @param pCantidadProducto2 Cantidad de unidades compradas del producto 2. pCantidadProducto2>=0.
     * @param pNombreProducto2 Nombre del producto 2. pNombre != null && pNombre != "".
     * @param pCantidadProducto3 Cantidad de unidades compradas del producto 3. pCantidadProducto3>=0.
     * @param pNombreProducto3 Nombre del producto 3. pNombre != null && pNombre != "".
     * @param pCantidadProducto4 Cantidad de unidades compradas del producto 4. pCantidadProducto4>=0.
     * @param pNombreProducto4 Nombre del producto 4. pNombre != null && pNombre != "".
     */
    public DialogoUnidadesCompradas( int pCantidadTotal, int pCantidadProducto1, String pNombreProducto1, int pCantidadProducto2, String pNombreProducto2, int pCantidadProducto3, String pNombreProducto3, int pCantidadProducto4,
            String pNombreProducto4 )
    {
        setTitle( "Información unidades compradas" );
        setSize( 380, 250 );
        setLayout( new BorderLayout( ) );
        setLocationRelativeTo( null );

        JPanel panelGeneral = new JPanel( );
        panelGeneral.setBorder( new CompoundBorder( new EmptyBorder( 10, 10, 10, 10 ), new TitledBorder( "Cantidad unidades compradas:" ) ) );
        panelGeneral.setLayout( new GridLayout( 5, 2, 4, 4 ) );
        add( panelGeneral, BorderLayout.CENTER );

        JLabel lblTotal = new JLabel( "Total:" );
        panelGeneral.add( lblTotal );

        txtCantidadTotal = new JTextField( pCantidadTotal + "" );
        txtCantidadTotal.setEditable( false );
        panelGeneral.add( txtCantidadTotal );

        JLabel lblProducto1 = new JLabel( pNombreProducto1 + ":" );
        panelGeneral.add( lblProducto1 );

        txtCantidadProducto1 = new JTextField( pCantidadProducto1 + "" );
        txtCantidadProducto1.setEditable( false );
        panelGeneral.add( txtCantidadProducto1 );

        JLabel lblProducto2 = new JLabel( pNombreProducto2 + ":" );
        panelGeneral.add( lblProducto2 );

        txtCantidadProducto2 = new JTextField( pCantidadProducto2 + "" );
        txtCantidadProducto2.setEditable( false );
        panelGeneral.add( txtCantidadProducto2 );

        JLabel lblProducto3 = new JLabel( pNombreProducto3 + ":" );
        panelGeneral.add( lblProducto3 );

        txtCantidadProducto3 = new JTextField( pCantidadProducto3 + "" );
        txtCantidadProducto3.setEditable( false );
        panelGeneral.add( txtCantidadProducto3 );

        JLabel lblProducto4 = new JLabel( pNombreProducto4 + ":" );
        panelGeneral.add( lblProducto4 );

        txtCantidadProducto4 = new JTextField( pCantidadProducto4 + "" );
        txtCantidadProducto4.setEditable( false );
        panelGeneral.add( txtCantidadProducto4 );
    }
}
