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

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.cupiAppStore.mundo.AppStore;

/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazJuegosCelular extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private AppStore appStore;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen del título.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel para mostrar la información del juego1.
     */
    private PanelJuego panelJuego1;

    /**
     * Panel para mostrar la información del juego2.
     */
    private PanelJuego panelJuego2;

    /**
     * Panel para mostrar la información del juego3.
     */
    private PanelJuego panelJuego3;

    /**
     * Panel para mostrar la información del juego4.
     */
    private PanelJuego panelJuego4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicación inicializando cada panel con sus características iniciales respectivas.
     */
    public InterfazJuegosCelular( )
    {
        setTitle( "Cupi2 AppStore" );
        setSize( 800, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        appStore = new AppStore( );

        setLayout( new BorderLayout( ) );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        JPanel panelCentro = new JPanel( );
        panelCentro.setLayout( new GridLayout( 2, 2 ) );

        panelJuego1 = new PanelJuego( this );
        panelCentro.add( panelJuego1 );
        panelJuego2 = new PanelJuego( this );
        panelCentro.add( panelJuego2 );
        panelJuego3 = new PanelJuego( this );
        panelCentro.add( panelJuego3 );
        panelJuego4 = new PanelJuego( this );
        panelCentro.add( panelJuego4 );

        add( panelCentro, BorderLayout.CENTER );

        setLocationRelativeTo( null );
        setResizable( false );

        actualizar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información de los paneles.
     */
    private void actualizar( )
    {
        panelJuego1.actualizarInfo( appStore.darJuego1( ) );
        panelJuego2.actualizarInfo( appStore.darJuego2( ) );
        panelJuego3.actualizarInfo( appStore.darJuego3( ) );
        panelJuego4.actualizarInfo( appStore.darJuego4( ) );
    }

    /**
     * Vende una cantidad de licencias del juego con el nombre dado por parámetro.
     * @param pNombreJuego Nombre del juego. pNombreJuego != null && pNombreJuego != "".
     */
    public void venderLicencias( String pNombreJuego )
    {
        String pCant = JOptionPane.showInputDialog( this, "Cantidad de licencias a vender:", "Vender licencias", JOptionPane.INFORMATION_MESSAGE );
        if( pCant != null )
        {
            try
            {
                int cantidad = Integer.parseInt( pCant );
                if( cantidad > 0 )
                {
                    boolean venta = appStore.venderLicenciasJuego( pNombreJuego, cantidad );
                    if( venta == true )
                    {
                        actualizar( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El juego no tiene suficientes licencias para realizar la venta.", "Vender licencias", JOptionPane.ERROR_MESSAGE );
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad ingresada debe ser mayor a cero.", "Vender licencias", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor numérico.", "Vender licencias", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Compra una cantidad de licencias del juego con el nombre dado por parámetro.
     * @param pNombreJuego Nombre del juego. pNombreJuego != null && pNombreJuego != "".
     */
    public void comprarLicencias( String pNombreJuego )
    {
        String pCant = JOptionPane.showInputDialog( this, "Cantidad de licencias a comprar:", "Comprar licencias", JOptionPane.INFORMATION_MESSAGE );
        if( pCant != null )
        {
            try
            {
                int cantidad = Integer.parseInt( pCant );
                if( cantidad > 0 )
                {
                    appStore.comprarLicenciasJuego( pNombreJuego, cantidad );
                    actualizar( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La cantidad ingresada debe ser mayor a cero.", "Comprar licencias", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "El valor ingresado debe ser un valor numérico.", "Comprar licencias", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Muestra el juego más vendido.
     */
    public void mostrarMasVendido( )
    {
        JOptionPane.showMessageDialog( this, "El juego más vendido es: " + appStore.darJuegoMasVendido( ), "Juego más vendido", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra el dialogo para seleccionar la cantidad de juegos para consultar una venta por volumen.
     */
    public void mostrarDialogoDescuentos( )
    {
        DialogoVentaVolumen dialogo = new DialogoVentaVolumen( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Calcula el porcentaje de descuento para una compra en volumen.
     * @param pCantidadLicenciasJuego1 Cantidad de licencias del juego 1 para la consulta.
     * @param pCantidadLicenciasJuego2 Cantidad de licencias del juego 1 para la consulta.
     * @param pCantidadLicenciasJuego3 Cantidad de licencias del juego 1 para la consulta.
     * @param pCantidadLicenciasJuego4 Cantidad de licencias del juego 1 para la consulta.
     */
    public void consultarDescuento( int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
    {
        JOptionPane.showMessageDialog( this, appStore.calcularVentaPorVolumen( pCantidadLicenciasJuego1, pCantidadLicenciasJuego2, pCantidadLicenciasJuego3, pCantidadLicenciasJuego4 ), "Resultados", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = appStore.metodo1( );
        actualizar();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = appStore.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazJuegosCelular interfaz = new InterfazJuegosCelular( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

}