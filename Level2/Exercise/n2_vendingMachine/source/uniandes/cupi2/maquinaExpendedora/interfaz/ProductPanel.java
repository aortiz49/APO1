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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.maquinaExpendedora.mundo.Producto.Tipo;

/**
 * Contiene la información de un producto de la máquina.
 */
@SuppressWarnings("serial")
public class PanelProducto extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Ruta de la carpeta donde se encuentran las imágenes.
     */
    private final static String RUTA = "./data/imagenes/";
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la información del producto.
     */
    private JTextField lblInfo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los botones. <br>
     * <b>post:</b> Todos los botones fueron inicializados.
     * @param pInterfaz Interfaz principal de la aplicación. pInterfaz != null.
     * @param pNombre Nombre del producto.
     * @param pIdentificador Identificador del producto.
     * @param pPrecio Precio del producto.
     * @param pCantidad Cantidad de unidades del producto.
     * @param pTipo Tipo del producto.
     * @param esFopre Indicador de que el producto dona al FOPRE.
     */
    public PanelProducto( InterfazMaquinaExpendedora pInterfaz, String pNombre, String pIdentificador, double pPrecio, int pCantidad, Tipo pTipo, boolean esFopre )
    {
        TitledBorder b = BorderFactory.createTitledBorder( pIdentificador );
        setBorder( b );
        setLayout( new BorderLayout( ) );

        String rutaImagen = "";

        if( pNombre.startsWith( "Jugo" ) )
        {
            rutaImagen = RUTA + "jugo.png";
        }
        else if( pNombre.startsWith( "Chocolatina" ) )
        {
            rutaImagen = RUTA + "chocolatina.png";
        }
        else if( pNombre.startsWith( "Galletas" ) )
        {
            rutaImagen = RUTA + "galletas.png";
        }
        else if( pNombre.startsWith( "Papas" ) )
        {
            rutaImagen = RUTA + "papas.png";
        }

        JLabel lblNombre = new JLabel( pNombre, JLabel.CENTER );
        add( lblNombre, BorderLayout.NORTH );

        ImageIcon icono = new ImageIcon( rutaImagen );
        JLabel lblImagen = new JLabel( icono );
        add( lblImagen, BorderLayout.CENTER );

        JPanel panelInferior = new JPanel( new GridLayout( 4, 1 ) );

        JPanel panelInfo = new JPanel( new GridLayout( 1, 2 ) );

        panelInfo.add( new JLabel( "Disponibles: " ) );
        lblInfo = new JTextField( "" + pCantidad, JLabel.CENTER );
        lblInfo.setHorizontalAlignment( JLabel.CENTER );
        lblInfo.setEditable( false );
        panelInfo.add( lblInfo );
        panelInferior.add( panelInfo );

        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$###,###" );
        JPanel panelPrecio = new JPanel( new GridLayout( 1, 2 ) );
        JTextField txtPrecio = new JTextField( df.format( pPrecio ), JTextField.CENTER );
        txtPrecio.setEditable( false );
        txtPrecio.setHorizontalAlignment( JLabel.CENTER );
        panelPrecio.add( new JLabel( "Precio: " ) );

        panelPrecio.add( txtPrecio );
        panelInferior.add( panelPrecio );

        JPanel panelTipo = new JPanel( new GridLayout( 1, 2 ) );
        String tipo = pTipo == Tipo.COMIDA ? "Comida" : "Bebida";
        JTextField txtTipo = new JTextField( tipo, JTextField.CENTER );
        txtTipo.setEditable( false );
        txtTipo.setHorizontalAlignment( JTextField.CENTER );
        panelTipo.add( new JLabel( "Tipo:" ) );
        panelTipo.add( txtTipo );
        panelInferior.add( panelTipo );

        JPanel panelFopre = new JPanel( new GridLayout( 1, 2 ) );
        panelFopre.add( new JLabel( "FOPRE: " ) );
        JTextField txtFopre = new JTextField( esFopre ? "Sí" : "No" );
        txtFopre.setEditable( false );
        txtFopre.setHorizontalAlignment( JTextField.CENTER );
        panelFopre.add( txtFopre );

        panelInferior.add( panelFopre );

        add( panelInferior, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el panel con la información recibida por parámetro.
     * @param pPrecio Precio del producto.
     * @param pCantidad Cantidad del producto.
     */
    public void actualizarInterfaz( double pPrecio, int pCantidad )
    {
        lblInfo.setText( pCantidad + "" );
    }

}
