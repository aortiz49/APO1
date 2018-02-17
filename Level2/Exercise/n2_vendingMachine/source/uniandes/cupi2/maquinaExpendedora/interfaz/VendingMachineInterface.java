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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import uniandes.cupi2.maquinaExpendedora.mundo.MaquinaExpendedora;
import uniandes.cupi2.maquinaExpendedora.mundo.Monto;
import uniandes.cupi2.maquinaExpendedora.mundo.Producto;
import uniandes.cupi2.maquinaExpendedora.mundo.Producto.Tipo;

/**
 * Clase principal de la interfaz.
 */
@SuppressWarnings("serial")
public class InterfazMaquinaExpendedora extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Asociación a la clase principal del maquinaExpendedora.
     */
    private MaquinaExpendedora maquinaExpendedora;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de botones ubicado en la zona inferior de la interfaz.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con el teclado alfanumérico de la máquina.
     */
    private PanelTeclado panelTeclado;

    /**
     * Panel del producto 1.
     */
    private PanelProducto panelProducto1;

    /**
     * Panel del producto 2.
     */
    private PanelProducto panelProducto2;

    /**
     * Panel del producto 3.
     */
    private PanelProducto panelProducto3;

    /**
     * Panel del producto 4.
     */
    private PanelProducto panelProducto4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazMaquinaExpendedora( )
    {
        setTitle( "Máquina expendedora" );
        setSize( 750, 690 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( true );

        maquinaExpendedora = new MaquinaExpendedora( );

        JLabel lblImagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "data/imagenes/banner.png" );
        lblImagen.setIcon( icono );
        add( lblImagen, BorderLayout.NORTH );

        JPanel panelCentro = new JPanel( new GridLayout( 2, 2 ) );
        add( panelCentro, BorderLayout.CENTER );

        Producto p1 = maquinaExpendedora.darProducto( "A1" );
        panelProducto1 = new PanelProducto( this, p1.darNombre( ), p1.darIdentificador( ), p1.darPrecio( ), p1.darCantidadUnidadesDisponibles( ), p1.darTipo( ), p1.esFopre( ) );
        panelCentro.add( panelProducto1 );

        Producto p2 = maquinaExpendedora.darProducto( "A2" );
        panelProducto2 = new PanelProducto( this, p2.darNombre( ), p2.darIdentificador( ), p2.darPrecio( ), p2.darCantidadUnidadesDisponibles( ), p2.darTipo( ), p2.esFopre( ) );
        panelCentro.add( panelProducto2 );

        Producto p3 = maquinaExpendedora.darProducto( "B1" );
        panelProducto3 = new PanelProducto( this, p3.darNombre( ), p3.darIdentificador( ), p3.darPrecio( ), p3.darCantidadUnidadesDisponibles( ), p3.darTipo( ), p3.esFopre( ) );
        panelCentro.add( panelProducto3 );

        Producto p4 = maquinaExpendedora.darProducto( "B2" );
        panelProducto4 = new PanelProducto( this, p4.darNombre( ), p4.darIdentificador( ), p4.darPrecio( ), p4.darCantidadUnidadesDisponibles( ), p4.darTipo( ), p4.esFopre( ) );
        panelCentro.add( panelProducto4 );

        JPanel panelDerecho = new JPanel( new BorderLayout( ) );
        add( panelDerecho, BorderLayout.EAST );

        PanelBotones panelBotones = new PanelBotones( this );
        panelDerecho.add( panelBotones, BorderLayout.CENTER );

        panelTeclado = new PanelTeclado( this );
        panelDerecho.add( panelTeclado, BorderLayout.NORTH );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega una moneda de la denominación recibida por parámetro a la máquina.<br>
     * <b>post:</b> Se agregó la moneda de la denominación dada.
     * @param pMoneda Denominación de la moneda.
     */
    public void agregarMoneda( int pMoneda )
    {
        boolean agrego = maquinaExpendedora.agregarMoneda( pMoneda );
        if( !agrego )
        {

            DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
            df.applyPattern( "$###,### COP" );
            JOptionPane.showMessageDialog( this, "El crédito máximo permitido es " + df.format( Monto.VALOR_MAXIMO ) + ".", "Agregar moneda", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            actualizar( );
        }
    }

    /**
     * Realiza la compra de un producto con el identificador dado.<br>
     * <b>pre:</b> El identificador recibido existe.<br>
     * <b>post:>/b> Se realizó la compra y se actualizó la interfaz.
     * @param pIdentificador Identificador del producto. pIdentificador != null.
     */
    public void comprarProducto( String pIdentificador )
    {
        Producto producto = maquinaExpendedora.darProducto( pIdentificador );

        boolean compro = maquinaExpendedora.comprarProducto( pIdentificador );
        actualizar( );

        if( !compro )
        {
            if( producto.darCantidadUnidadesDisponibles( ) == 0 )
            {

                JOptionPane.showMessageDialog( this, "El producto no tiene unidades disponibles.", "Comprar producto", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No hay crédito suficiente para realizar la compra.", "Comprar producto", JOptionPane.ERROR_MESSAGE );
            }
        }
        else
        {
            panelTeclado.reiniciarIdentificador( );
            JOptionPane.showMessageDialog( this, "La compra del producto fue exitosa.", "Comprar producto", JOptionPane.INFORMATION_MESSAGE );
        }

    }

    /**
     * Termina la compra actual y muestra el dinero del cambio.<br>
     * <b>post:</b> Reinició el crédito.
     */
    public void terminarCompra( )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$###,###" );

        Monto cambio = maquinaExpendedora.terminarCompra( );
        actualizar( );
        String mensaje = "Se terminó la compra. \nEl cambio es de: " + df.format( cambio.darValorTotal( ) ) + " COP:\n\t";
        mensaje += "- $1000 x " + cambio.darCantidadMonedas1000( ) + " = $" + ( cambio.darCantidadMonedas1000( ) * Monto.MONEDA_1000 ) + "\n\t";
        mensaje += "- $500 x " + cambio.darCantidadMonedas500( ) + " = " + df.format( ( cambio.darCantidadMonedas500( ) * Monto.MONEDA_500 ) ) + "\n\t";
        mensaje += "- $200 x " + cambio.darCantidadMonedas200( ) + " = " + df.format( ( cambio.darCantidadMonedas200( ) * Monto.MONEDA_200 ) ) + "\n\t";
        mensaje += "- $100 x " + cambio.darCantidadMonedas100( ) + " = " + df.format( ( cambio.darCantidadMonedas100( ) * Monto.MONEDA_100 ) ) + "\n\t";
        mensaje += "- $50 x " + cambio.darCantidadMonedas50( ) + " = " + df.format( ( cambio.darCantidadMonedas50( ) * Monto.MONEDA_50 ) );
        JOptionPane.showMessageDialog( this, mensaje, "Terminar compra", JOptionPane.INFORMATION_MESSAGE );

    }

    /**
     * Muestra el diálogo con el valor total de compras de la máquina.
     */
    public void darValorTotalCompras( )
    {

        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$###,### COP" );
        double valorTotalCompras = maquinaExpendedora.darValorTotalCompras( );
        String mensaje = "El valor total de las compras de la máquina es " + df.format( valorTotalCompras ) + ".";
        JOptionPane.showMessageDialog( this, mensaje, "Valor total de las compras", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra el diálogo con la capacidad disponible de la máquina.
     */
    public void darPorcentajeDeDisponibilidad( )
    {
        String mensaje = "El porcentaje de disponibilidad de la máquina es del " + maquinaExpendedora.darPorcentajeDisponibilidad( ) + "%.";
        JOptionPane.showMessageDialog( this, mensaje, "Porcentaje de disponibilidad", JOptionPane.INFORMATION_MESSAGE );

    }

    /**
     * Muestra el diálogo con las compras por producto.
     */
    public void mostrarDialogoUnidadesCompradas( )
    {
        Producto p1 = maquinaExpendedora.darProducto( "A1" );
        Producto p2 = maquinaExpendedora.darProducto( "A2" );
        Producto p3 = maquinaExpendedora.darProducto( "B1" );
        Producto p4 = maquinaExpendedora.darProducto( "B2" );

        int cantidadTotal = maquinaExpendedora.darCantidadTotalUnidadesCompradas( );
        String nombreProducto1 = p1.darNombre( );
        String nombreProducto2 = p2.darNombre( );
        String nombreProducto3 = p3.darNombre( );
        String nombreProducto4 = p4.darNombre( );
        int cantidadProducto1 = p1.darCantidadUnidadesCompradas( );
        int cantidadProducto2 = p2.darCantidadUnidadesCompradas( );
        int cantidadProducto3 = p3.darCantidadUnidadesCompradas( );
        int cantidadProducto4 = p4.darCantidadUnidadesCompradas( );

        DialogoUnidadesCompradas dialogo = new DialogoUnidadesCompradas( cantidadTotal, cantidadProducto1, nombreProducto1, cantidadProducto2, nombreProducto2, cantidadProducto3, nombreProducto3, cantidadProducto4, nombreProducto4 );
        dialogo.setVisible( true );
    }

    /**
     * Muestra el dialogo con la donación total al FOPRE.
     */
    public void mostrarDialogoInfoDonacionFopre( )
    {
        int cantidadComida = maquinaExpendedora.darCantidadUnidadesCompradasFopre( Tipo.COMIDA );
        int cantidadBebida = maquinaExpendedora.darCantidadUnidadesCompradasFopre( Tipo.BEBIDA );
        double donacionComida = maquinaExpendedora.darDonacionPorTipo( Tipo.COMIDA );
        double donacionBebida = maquinaExpendedora.darDonacionPorTipo( Tipo.BEBIDA );
        double donacionTotal = maquinaExpendedora.darDonacionTotal( );

        if( donacionTotal == 0 )
        {
            JOptionPane.showMessageDialog( this, "No se han comprado productos que contribuyan al FOPRE.", "Información FOPRE", JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            DialogoInformacionFopre dialogo = new DialogoInformacionFopre( cantidadComida, donacionComida, cantidadBebida, donacionBebida, donacionTotal );
            dialogo.setVisible( true );
            dialogo.setLocationRelativeTo( this );
        }
    }

    /**
     * Muestra el dialogo con el producto más comprado.
     */
    public void darProductoMasComprado( )
    {
        Producto masComprado = maquinaExpendedora.darProductoMasComprado( );
        String mensaje = "El producto más comprado es: " + masComprado.darIdentificador( ) + " - " + masComprado.darNombre( ) + ".\n";
        mensaje += "Se han comprado " + masComprado.darCantidadUnidadesCompradas( ) + " unidades.";

        JOptionPane.showMessageDialog( this, mensaje, "Producto más comprado", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Actualiza la información de los paneles.<br>
     * <b>post:</b>
     */
    private void actualizar( )
    {
        panelTeclado.actualizar( maquinaExpendedora.darValorCredito( ) );

        Producto p1 = maquinaExpendedora.darProducto( "A1" );
        Producto p2 = maquinaExpendedora.darProducto( "A2" );
        Producto p3 = maquinaExpendedora.darProducto( "B1" );
        Producto p4 = maquinaExpendedora.darProducto( "B2" );

        panelProducto1.actualizarInterfaz( p1.darPrecio( ), p1.darCantidadUnidadesDisponibles( ) );
        panelProducto2.actualizarInterfaz( p2.darPrecio( ), p2.darCantidadUnidadesDisponibles( ) );
        panelProducto3.actualizarInterfaz( p3.darPrecio( ), p3.darCantidadUnidadesDisponibles( ) );
        panelProducto4.actualizarInterfaz( p4.darPrecio( ), p4.darCantidadUnidadesDisponibles( ) );

    }

    // -----------------------------------------------------------------
    // Puntos de extensión
    // -----------------------------------------------------------------

    /**
     * Extensión 1.
     */
    public void reqFuncOpcion1( )
    {

        String resultado = maquinaExpendedora.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = maquinaExpendedora.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args Arreglo opcional de argumentos que se recibe por línea de comandos.
     */
    public static void main( String[] args )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazMaquinaExpendedora interfaz = new InterfazMaquinaExpendedora( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

}
