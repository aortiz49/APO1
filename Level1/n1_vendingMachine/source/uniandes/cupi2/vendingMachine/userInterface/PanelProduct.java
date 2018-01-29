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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Contiene los botones ubicados en la parte inferior de la ventana principal.
 */
@SuppressWarnings("serial")
public class PanelProduct extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ejecutar la acción del botón btnAbasceter.
     */
    private static final String ABASTECER = "Abastecer";

    /**
     * Comando para ejecutar la acción del botón btnComprar.
     */
    private static final String COMPRAR = "Comprar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfaceVendingMachine principal;

    /**
     * Identificador del producto.
     */
    private String identificador;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón que permite comprar el producto
     */
    private JButton btnComprar;

    /**
     * Botón que permite restock
     */
    private JButton btnAbastecer;

    /**
     * Etiqueta con la información del producto.
     */
    private JLabel lblInfo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los botones <br>
     * <b>post:</b> Todos los botones fueron inicializados.
     * @param pInterfaz Interfaz principal de la aplicación. pInterfaz != null
     * @param pNombre Nombre del producto.
     * @param pIdentificador Identificador del producto.
     * @param pPrecio Precio del producto.
     * @param pCantidad Cantidad de unidades del producto.
     */
    public PanelProduct( InterfaceVendingMachine pInterfaz, String pNombre, String pIdentificador, double pPrecio, int pCantidad )
    {
        principal = pInterfaz;
        identificador = pIdentificador;

        TitledBorder b = BorderFactory.createTitledBorder( pIdentificador );
        setBorder( b );
        setLayout( new BorderLayout( ) );

        String rutaImagen = "";

        if( pNombre.startsWith( "Jugo" ) )
        {
            rutaImagen = "data/img/jugo.png";
        }
        else if( pNombre.startsWith( "Chocolatina" ) )
        {
            rutaImagen = "data/img/chocolatina.png";
        }
        else if( pNombre.startsWith( "Galletas" ) )
        {
            rutaImagen = "data/img/galletas.png";
        }
        else if( pNombre.startsWith( "Papas" ) )
        {
            rutaImagen = "data/img/papas.png";
        }

        JLabel lblNombre = new JLabel( pNombre, SwingConstants.CENTER );
        add( lblNombre, BorderLayout.NORTH );

        ImageIcon icono = new ImageIcon( rutaImagen );
        JLabel lblImagen = new JLabel( icono );
        add( lblImagen, BorderLayout.CENTER );

        JPanel panelInferior = new JPanel( new GridLayout( 3, 1 ) );

        JPanel panelInfo = new JPanel( new GridLayout( 1, 2 ) );

        panelInfo.add( new JLabel( "Disponibles: " ) );
        lblInfo = new JLabel( "" + pCantidad, SwingConstants.CENTER );
        panelInfo.add( lblInfo );
        panelInferior.add( panelInfo );

        JPanel panelPrecio = new JPanel( new GridLayout( 1, 2 ) );
        JLabel lblPrecio = new JLabel( "$" + pPrecio, SwingConstants.CENTER );

        panelPrecio.add( new JLabel( "Precio: " ) );
        panelPrecio.add( lblPrecio );
        panelInferior.add( panelPrecio );
        JPanel panelBotones = new JPanel( new GridLayout( 1, 2 ) );

        btnComprar = new JButton( "Comprar" );
        btnComprar.addActionListener( this );
        btnComprar.setActionCommand( COMPRAR );
        panelBotones.add( btnComprar );

        btnAbastecer = new JButton( "Abastecer" );
        btnAbastecer.addActionListener( this );
        btnAbastecer.setActionCommand( ABASTECER );
        panelBotones.add( btnAbastecer );

        panelInferior.add( panelBotones );

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

    /**
     * Manejo de eventos del usuario.
     * @param pEvento Evento de usuario. pEvento != null.
     */
    @Override
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( ABASTECER ) )
        {

            String unidades = JOptionPane.showInputDialog( principal, "Ingrese el número de unidades que ingresará del producto" );
            try
            {
                if( unidades != null )
                {
                    int numUnidades = Integer.parseInt( unidades );
                    principal.restock( identificador, numUnidades );
                }

            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( principal, "Solo puede ingresar números enteros", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }

        else if( pEvento.getActionCommand( ).equals( COMPRAR ) )
        {
            principal.sell( identificador );
        }

    }

}
