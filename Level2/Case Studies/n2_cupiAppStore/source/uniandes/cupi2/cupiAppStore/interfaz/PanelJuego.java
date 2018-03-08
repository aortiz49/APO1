/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_cupiAppStore
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiAppStore.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiAppStore.mundo.Juego;

/**
 * Panel que muestra la información de un juego.
 */
@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener
{
    // ----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el botón de comprar.
     */
    private static final String BOTON_COMPRAR = "Comprar";

    /**
     * Comando para el botón de vender.
     */
    private static final String BOTON_VENDER = "Vender";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazJuegosCelular principal;

    /**
     * Juego que actualmente se presenta en el panel.
     */
    private Juego juego;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta "Categoría".
     */
    private JLabel lblCategoriaJuego;

    /**
     * Etiqueta "Precio".
     */
    private JLabel lblPrecioJuego;

    /**
     * Etiqueta "Tamaño KB".
     */
    private JLabel lblTamanhoJuego;

    /**
     * Etiqueta "Disponibles".
     */
    private JLabel lblDisponibles;

    /**
     * Etiqueta "Vendidas".
     */
    private JLabel lblVendidas;

    /**
     * Campo con la categoria del Juego.
     */
    private JTextField txtCategoriaJuego;

    /**
     * Campo con el precio del juego.
     */
    private JTextField txtPrecioJuego;

    /**
     * Campo con el tamaño en KB del juego.
     */
    private JTextField txtTamanhoJuego;

    /**
     * Campo con la cantidad de licencias disponibles del juego.
     */
    private JTextField txtDisponibles;

    /**
     * Campo con la cantidad de licencias vendidas del juego.
     */
    private JTextField txtVendidas;

    /**
     * Es el campo que muestra la imagen del Juego.
     */
    private JLabel lblImagen;

    /**
     * Es el campo que muestra el botón para Vender un juego.
     */
    private JButton botonVender;

    /**
     * Es el campo que muestra el botón para Comprar un juego.
     */
    private JButton botonComprar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel para la información de un juego.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz.
     */
    public PanelJuego( InterfazJuegosCelular pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );

        JPanel panelDatosJuego = new JPanel( );
        add( panelDatosJuego, BorderLayout.CENTER );

        panelDatosJuego.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setBorder( new TitledBorder( "Juego" ) );

        panelDatosJuego.setLayout( new GridLayout( 5, 1, 0, 5 ) );

        lblCategoriaJuego = new JLabel( "Categoría: " );
        txtCategoriaJuego = new JTextField( 15 );
        txtCategoriaJuego.setEditable( false );
        panelDatosJuego.add( lblCategoriaJuego );
        panelDatosJuego.add( txtCategoriaJuego );

        lblTamanhoJuego = new JLabel( "Tamaño en KB: " );
        txtTamanhoJuego = new JTextField( 15 );
        txtTamanhoJuego.setEditable( false );
        panelDatosJuego.add( lblTamanhoJuego );
        panelDatosJuego.add( txtTamanhoJuego );

        lblPrecioJuego = new JLabel( "Precio: " );
        txtPrecioJuego = new JTextField( 15 );
        txtPrecioJuego.setEditable( false );
        panelDatosJuego.add( lblPrecioJuego );
        panelDatosJuego.add( txtPrecioJuego );

        lblDisponibles = new JLabel( "Disponibles: " );
        txtDisponibles = new JTextField( 15 );
        txtDisponibles.setEditable( false );
        panelDatosJuego.add( lblDisponibles );
        panelDatosJuego.add( txtDisponibles );

        lblVendidas = new JLabel( "Vendidas: " );
        txtVendidas = new JTextField( 15 );
        txtVendidas.setEditable( false );
        panelDatosJuego.add( lblVendidas );
        panelDatosJuego.add( txtVendidas );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 1, 2 ) );

        botonComprar = new JButton( "Comprar" );
        botonComprar.setActionCommand( BOTON_COMPRAR );
        botonComprar.addActionListener( this );
        panelSur.add( botonComprar );

        botonVender = new JButton( "Vender" );
        botonVender.setActionCommand( BOTON_VENDER );
        botonVender.addActionListener( this );
        panelSur.add( botonVender );

        add( panelSur, BorderLayout.SOUTH );

        lblImagen = new JLabel( );
        add( lblImagen, BorderLayout.WEST );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información del panel con la información dada.
     * @param pJuego Juego para actualizar la información. pJuego != null.
     */
    public void actualizarInfo( Juego pJuego )
    {
        juego = pJuego;
        setBorder( new TitledBorder( pJuego.darNombre( ) ) );

        switch( pJuego.darCategoria( ) )
        {
            case ACCION:
            {
                txtCategoriaJuego.setText( "Acción" );
                break;
            }
            case DEPORTE:
            {
                txtCategoriaJuego.setText( "Deporte" );
                break;
            }
            case ROMPECABEZAS:
            {
                txtCategoriaJuego.setText( "Rompecabezas" );
                break;
            }
        }
        txtPrecioJuego.setText( pJuego.darPrecio( ) + "" );
        txtTamanhoJuego.setText( pJuego.darTamanio( ) + "" );
        txtDisponibles.setText( pJuego.darCantidadLicencias( ) + "" );
        txtVendidas.setText( pJuego.darCantidadVendidas( ) + "" );

        ImageIcon icono = new ImageIcon( "./data/imagenes/" + pJuego.darRutaImagen( ) );
        lblImagen.setIcon( icono );
        lblImagen.setBorder( new TitledBorder( "" ) );
    }

    /**
     * Se ejecuta una opción dependiendo de las acciones realizadas por el usuario
     * @param evento Evento de click sobre un botón. pEvento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( BOTON_VENDER ) )
        {
            principal.venderLicencias( juego.darNombre( ) );
        }
        else if( comando.equals( BOTON_COMPRAR ) )
        {
            principal.comprarLicencias( juego.darNombre( ) );
        }
    }

}
