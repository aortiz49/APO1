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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;

/**
 * Panel que contiene los botones y labels que componen el teclado de la máquina y los botones para abastecer y vender.
 */
@SuppressWarnings("serial")
public class PanelTeclado extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para ejecutar la acción de la tecla A.
     */
    private final static String TECLA_A = "A";

    /**
     * Constante para ejecutar la acción de la tecla B.
     */

    private final static String TECLA_B = "B";

    /**
     * Constante para ejecutar la acción de la tecla 1.
     */
    private final static String TECLA_1 = "1";

    /**
     * Constante para ejecutar la acción de la tecla 2.
     */
    private final static String TECLA_2 = "2";

    /**
     * Constante para ejecutar la acción del botón agregar.
     */
    private final static String AGREGAR = "Agregar moneda";

    /**
     * Constante para ejecutar la acción del botón para comprar.
     */
    private final static String COMPRAR = "Comprar producto";

    /**
     * Constante para ejecutar la acción del botón para terminar compra.
     */
    private final static String TERMINAR_COMPRA = "Terminar compra";

    /**
     * Constante que representa el caracter vació.
     */
    private final static char VACIO = '-';

    /**
     * Constante que representa la dimensión de las teclas del panel.
     */
    private final static int ICON_DIM = 30;

    /**
     * Ruta de la carpeta donde se encuentran las imágenes
     */
    private final static String RUTA = "./data/imagenes/";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Botón para la tecla A.
     */
    private JButton btnTeclaA;

    /**
     * Botón para la tecla B.
     */
    private JButton btnTeclaB;

    /**
     * Botón para la tecla 1.
     */
    private JButton btnTecla1;

    /**
     * Botón para la tecla 2.
     */
    private JButton btnTecla2;

    /**
     * Botón para la opción de agregar crédito.
     */
    private JButton btnAgregar;

    /**
     * Botón para la opción de comprar un producto.
     */
    private JButton btnComprar;

    /**
     * Botón para la opción de abastecer un producto.
     */
    private JButton btnTerminarCompra;

    /**
     * Etiqueta de texto para mostrar el crédito disponible.
     */
    private JLabel lblCredito;

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazMaquinaExpendedora principal;

    /**
     * Arreglo de caracteres que contiene el identificador seleccionado. <br>
     * En la posición 0 va la letra y en la posición 1 el número. <br>
     * Puede tener el carácter '-' que representa vacío.
     */
    private char[] identificador;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo panel teclado.<br>
     * <b> post: </b> Todos los botones y etiquetas fueron inicializados y ubicados. El identificador fue inicializado en '--'.
     * @param pInterfaz Ventana principal de la aplicación.
     */
    public PanelTeclado( InterfazMaquinaExpendedora pInterfaz )
    {
        principal = pInterfaz;

        setBackground( new Color( 65, 70, 73 ) );
        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 307, 310 ) );

        JPanel panelAux = new JPanel( new BorderLayout( ) );
        panelAux.setOpaque( false );
        panelAux.setBorder( new EmptyBorder( 15, 15, 0, 15 ) );
        add( panelAux, BorderLayout.NORTH );

        JPanel panelSuperior = new JPanel( new BorderLayout( ) );
        panelSuperior.setBackground( new Color( 121, 125, 126 ) );
        panelSuperior.setBorder( new EmptyBorder( 0, 15, 0, 15 ) );
        panelAux.add( panelSuperior, BorderLayout.NORTH );
        
        
        Image gradientBotonImg = new ImageIcon( RUTA + "boton2.png" ).getImage( );
        btnAgregar = new JButton( "Agregar moneda" );
        btnAgregar.setIcon( new ImageIcon( gradientBotonImg ) );
        btnAgregar.setBorderPainted( false );
        btnAgregar.setContentAreaFilled( false );
        btnAgregar.setHorizontalTextPosition( JButton.CENTER );
        btnAgregar.setForeground( Color.WHITE );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );
        panelSuperior.add( btnAgregar, BorderLayout.CENTER );

        JPanel auxImages = new JPanel( new BorderLayout( ) );
        auxImages.setOpaque( false );
        panelSuperior.add( auxImages, BorderLayout.NORTH );
        
        JLabel auxImg = new JLabel( new ImageIcon( RUTA + "play.png" ) );
        panelSuperior.add( auxImg, BorderLayout.WEST );
        
        JLabel auxImg2 = new JLabel( new ImageIcon( RUTA + "daniado.png" ) );
        auxImages.add( auxImg2, BorderLayout.WEST );
        
        JLabel auxImg3 = new JLabel( new ImageIcon( RUTA + "monedas.png" ) );
        auxImages.add( auxImg3, BorderLayout.CENTER );
        
        JPanel panelDisplay = new JPanel( new BorderLayout( ) );
        panelDisplay.setBackground( new Color( 121, 125, 126 ) );
        panelDisplay.setBorder( new EmptyBorder( 10, 15, 10, 15 ) );
        panelAux.add( panelDisplay, BorderLayout.CENTER );
        
        lblCredito = new JLabel( "$0000" );
        lblCredito.setBorder( new CompoundBorder( new LineBorder( new Color( 0, 0, 0 ), 2, true ), new EmptyBorder( 5, 0, 5, 0 ) ) );
        lblCredito.setOpaque( true );
        lblCredito.setBackground( new Color( 7, 100, 118 ) );
        lblCredito.setHorizontalAlignment( JLabel.CENTER );
        lblCredito.setForeground( new Color( 211, 232, 84 ) );
        
        Font font;
        try
        {
            font = Font.createFont( Font.TRUETYPE_FONT, new File( "./data/fonts/digital-readout/TrueType/SFDigitalReadout-Heavy.ttf" ) );
            lblCredito.setFont( font.deriveFont( 40f ) );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }

        panelDisplay.add( lblCredito, BorderLayout.CENTER );

        JPanel panelTeclas = new JPanel( new GridLayout( 0, 2 ) );
        panelTeclas.setOpaque( false );
        panelTeclas.setBorder( new EmptyBorder( 10, 0, 10, 0 ) );
        add( panelTeclas, BorderLayout.CENTER );

        identificador = new char[2];
        identificador[ 0 ] = VACIO;
        identificador[ 1 ] = VACIO;



        int btnFontSize = 16;
        Image icon = new ImageIcon( RUTA + "boton.png" ).getImage( ).getScaledInstance( ICON_DIM, ICON_DIM, java.awt.Image.SCALE_SMOOTH );

        btnTeclaA = new JButton( TECLA_A );
        btnTeclaA.setHorizontalAlignment( JButton.RIGHT );
        btnTeclaA.setBorderPainted( false );
        btnTeclaA.setFocusPainted( false );
        btnTeclaA.setForeground( Color.WHITE );
        btnTeclaA.setFont( new Font( "Tahoma", Font.PLAIN, btnFontSize ) );
        btnTeclaA.setHorizontalTextPosition( JButton.CENTER );
        btnTeclaA.setContentAreaFilled( false );
        btnTeclaA.setIcon( new ImageIcon( icon ) );
        btnTeclaA.setActionCommand( TECLA_A );
        btnTeclaA.addActionListener( this );
        panelTeclas.add( btnTeclaA );

        btnTecla1 = new JButton( TECLA_1 );
        btnTecla1.setHorizontalAlignment( JButton.LEFT );
        btnTecla1.setFocusPainted( false );
        btnTecla1.setBorderPainted( false );
        btnTecla1.setForeground( Color.WHITE );
        btnTecla1.setFont( new Font( "Tahoma", Font.PLAIN, btnFontSize ) );
        btnTecla1.setHorizontalTextPosition( JButton.CENTER );
        btnTecla1.setContentAreaFilled( false );
        btnTecla1.setIcon( new ImageIcon( icon ) );
        btnTecla1.addActionListener( this );
        btnTecla1.setActionCommand( TECLA_1 );
        panelTeclas.add( btnTecla1 );

        btnTeclaB = new JButton( TECLA_B );
        btnTeclaB.setHorizontalAlignment( JButton.RIGHT );
        btnTeclaB.setFocusPainted( false );
        btnTeclaB.setBorderPainted( false );
        btnTeclaB.setForeground( Color.WHITE );
        btnTeclaB.setFont( new Font( "Tahoma", Font.PLAIN, btnFontSize ) );
        btnTeclaB.setHorizontalTextPosition( JButton.CENTER );
        btnTeclaB.setContentAreaFilled( false );
        btnTeclaB.setIcon( new ImageIcon( icon ) );
        btnTeclaB.addActionListener( this );
        btnTeclaB.setActionCommand( TECLA_B );
        panelTeclas.add( btnTeclaB );

        btnTecla2 = new JButton( TECLA_2 );
        btnTecla2.setHorizontalAlignment( JButton.LEFT );
        btnTecla2.setFocusPainted( false );
        btnTecla2.setBorderPainted( false );
        btnTecla2.setForeground( Color.WHITE );
        btnTecla2.setFont( new Font( "Tahoma", Font.PLAIN, btnFontSize ) );
        btnTecla2.setHorizontalTextPosition( JButton.CENTER );
        btnTecla2.setContentAreaFilled( false );
        btnTecla2.setIcon( new ImageIcon( icon ) );
        btnTecla2.addActionListener( this );
        btnTecla2.setActionCommand( TECLA_2 );
        panelTeclas.add( btnTecla2 );

        JPanel panelOpciones = new JPanel(  );
        panelOpciones.setLayout( new GridLayout( 1, 2 ) );
        panelOpciones.setOpaque( false );
        panelOpciones.setBorder( new EmptyBorder( 10, 15, 10, 15 ) );
        add( panelOpciones, BorderLayout.SOUTH );

        btnComprar = new JButton( COMPRAR );
        btnComprar.setIcon( new ImageIcon( gradientBotonImg.getScaledInstance( 115, 30, Image.SCALE_SMOOTH ) ) );
        btnComprar.setForeground( Color.WHITE );
        btnComprar.setBorderPainted( false );
        btnComprar.setContentAreaFilled( false );
        btnComprar.setHorizontalTextPosition( JButton.CENTER );
        btnComprar.addActionListener( this );
        btnComprar.setActionCommand( COMPRAR );
        panelOpciones.add( btnComprar );

        btnTerminarCompra = new JButton( TERMINAR_COMPRA );
        btnTerminarCompra.setIcon( new ImageIcon( gradientBotonImg.getScaledInstance( 115, 30, Image.SCALE_SMOOTH ) ) );
        btnTerminarCompra.setForeground( Color.WHITE );
        btnTerminarCompra.setBorderPainted( false );
        btnTerminarCompra.setContentAreaFilled( false );
        btnTerminarCompra.setHorizontalTextPosition( JButton.CENTER );
        btnTerminarCompra.addActionListener( this );
        btnTerminarCompra.setActionCommand( TERMINAR_COMPRA );
        panelOpciones.add( btnTerminarCompra );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información mostrada del crédito disponible.
     * @param credito crédito disponible de la máquina.
     */
    public void actualizar( double credito )
    {
        lblCredito.setText( "$" + ( int )credito );
    }

    /**
     * Agrega un estilo de encendido al botón dado.
     * @param pBoton Botón al que se le desea agregar el estilo.
     */
    private void encenderBoton( JButton pBoton )
    {
        Image imagenesEncendido = new ImageIcon( RUTA + "boton-encendido.png" ).getImage( );
        pBoton.setIcon( new ImageIcon( imagenesEncendido.getScaledInstance( ICON_DIM, ICON_DIM, Image.SCALE_SMOOTH ) ) );

    }

    /**
     * Quita el estilo de encendido del botón dado.
     * @param pBoton Botón al cual se le quiere quitar el estilo de encendido.
     */
    private void apagarBoton( JButton pBoton )
    {
        Image botonImg = new ImageIcon( RUTA + "boton.png" ).getImage( );
        pBoton.setIcon( new ImageIcon( botonImg.getScaledInstance( ICON_DIM, ICON_DIM, Image.SCALE_SMOOTH ) ) );
    }

    /**
     * Reinicia los botones seleccionados y los caracteres correspondientes al identificador los vuelve vacíos.
     */
    public void reiniciarIdentificador( )
    {

        identificador[ 0 ] = VACIO;
        identificador[ 1 ] = VACIO;
        apagarBoton( btnTecla1 );
        apagarBoton( btnTecla2 );
        apagarBoton( btnTeclaA );
        apagarBoton( btnTeclaB );
    }

    /**
     * Manejo de eventos del usuario.
     * @param pEvento Evento de usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        switch( comando )
        {
            case AGREGAR:
                DialogoAgregarMoneda dialogo = new DialogoAgregarMoneda( principal );
                dialogo.setVisible( true );
                dialogo.setLocationRelativeTo( principal );
                dialogo.setAlwaysOnTop( true );
                break;
            case TECLA_A:
                identificador[ 0 ] = 'A';
                encenderBoton( btnTeclaA );
                apagarBoton( btnTeclaB );
                break;
            case TECLA_B:
                identificador[ 0 ] = 'B';
                encenderBoton( btnTeclaB );
                apagarBoton( btnTeclaA );
                break;
            case TECLA_1:
                identificador[ 1 ] = '1';
                encenderBoton( btnTecla1 );
                apagarBoton( btnTecla2 );
                break;
            case TECLA_2:
                identificador[ 1 ] = '2';
                encenderBoton( btnTecla2 );
                apagarBoton( btnTecla1 );
                break;
            case COMPRAR:
                if( ( identificador[ 0 ] == VACIO || identificador[ 1 ] == VACIO ) && ( comando.equals( TERMINAR_COMPRA ) || comando.equals( COMPRAR ) ) )
                {
                    JOptionPane.showMessageDialog( principal, "No hay identificador seleccionado.", comando, JOptionPane.WARNING_MESSAGE );
                }
                else
                {
                    principal.comprarProducto( new String( identificador ) );
                }
                break;
            case TERMINAR_COMPRA:
                reiniciarIdentificador( );
                principal.terminarCompra( );
                break;

        }
    }
}
