/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- vendingMachine
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.userInterface;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.InterfaceAddress;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import uniandes.cupi2.vendingMachine.world.VendingMachine;
import uniandes.cupi2.vendingMachine.world.Product;

/**
 * Principal class for interface
 */
@SuppressWarnings("serial")
public class InterfaceVendingMachine extends JFrame
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Associate principal class to the world
     */
    private VendingMachine world;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Contains the banner
     */
    private PanelImage panelImage;

    /**
     * Button pannel located in the lower zone of the interface
     */
    private PanelOptions panelOptions;

    /**
     * Panel for product 1
     */
    private PanelProduct panelProduct1;

    /**
     * Panel for product 2
     */
    private PanelProduct panelProduct2;

    /**
     * Panel del producto 3
     */
    private PanelProduct panelProduct3;

    /**
     * Panel del producto 4
     */
    private PanelProduct panelProduct4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfaceVendingMachine( )
    {
        setTitle( "Máquina expendedora" );
        setSize( 610, 690 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( true );

        world = new VendingMachine( );

        Product p1 = world.getProduct1( );
        Product p2 = world.getProduct2( );
        Product p3 = world.getProduct3( );
        Product p4 = world.getProduct4( );

        panelProduct1 = new PanelProduct( this, p1.getName( ), p1.getIdentifier( ), p1.getPrice( ), p1.getQuantityOfUnitsAvailable( ) );
        panelProduct2 = new PanelProduct( this, p2.getName( ), p2.getIdentifier( ), p2.getPrice( ), p2.getQuantityOfUnitsAvailable( ) );
        panelProduct3 = new PanelProduct( this, p3.getName( ), p3.getIdentifier( ), p3.getPrice( ), p3.getQuantityOfUnitsAvailable( ) );
        panelProduct4 = new PanelProduct( this, p4.getName( ), p4.getIdentifier( ), p4.getPrice( ), p4.getQuantityOfUnitsAvailable( ) );

        JPanel panelCentro = new JPanel( new GridLayout( 2, 2 ) );

        panelCentro.add( panelProduct1 );
        panelCentro.add( panelProduct2 );
        panelCentro.add( panelProduct3 );
        panelCentro.add( panelProduct4 );

        add( panelCentro, BorderLayout.CENTER );

        panelImage = new PanelImage( );
        add( panelImage, BorderLayout.NORTH );

        PanelButtons panelBotones = new PanelButtons( this );
        add( panelBotones, BorderLayout.EAST );

        panelOptions = new PanelOptions( this );
        add( panelOptions, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Abastece la máquina con un número de unidades de un producto especificado.
     * @param pIdentificador Identificador del producto.
     * @param pUnidades Número de unidades a restock.
     */
    public void restock( String pIdentificador, int pUnidades )
    {
        Product p1 = world.getProduct1( );
        Product p2 = world.getProduct2( );
        Product p3 = world.getProduct3( );
        Product p4 = world.getProduct4( );

        if( pIdentificador.equals( p1.getIdentifier( ) ) )
        {
            world.restockProduct1( pUnidades );
            panelProduct1.actualizarInterfaz( p1.getPrice( ), p1.getQuantityOfUnitsAvailable( ) );
        }
        else if( pIdentificador.equals( p2.getIdentifier( ) ) )
        {
            world.restockProduct2( pUnidades );
            panelProduct2.actualizarInterfaz( p2.getPrice( ), p2.getQuantityOfUnitsAvailable( ) );

        }
        else if( pIdentificador.equals( p3.getIdentifier( ) ) )
        {
            world.restockProduct3( pUnidades );
            panelProduct3.actualizarInterfaz( p3.getPrice( ), p3.getQuantityOfUnitsAvailable( ) );

        }
        else if( pIdentificador.equals( p4.getIdentifier( ) ) )
        {
            world.restockProduct4( pUnidades );
            panelProduct4.actualizarInterfaz( p4.getPrice( ), p4.getQuantityOfUnitsAvailable( ) );

        }

    }

    /**
     * Vende un producto de la máquina.
     * @param pIdentificador Identificador del producto a comprar.
     */
    public void sell( String pIdentificador )
    {

        Product p1 = world.getProduct1( );
        Product p2 = world.getProduct2( );
        Product p3 = world.getProduct3( );
        Product p4 = world.getProduct4( );

        if( pIdentificador.equals( p1.getIdentifier( ) ) )
        {
            if( p1.getQuantityOfUnitsAvailable( ) > 0 )
            {
                world.sellProduct1( );
                panelProduct1.actualizarInterfaz( p1.getPrice( ), p1.getQuantityOfUnitsAvailable( ) );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El producto se encuentra agotado", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pIdentificador.equals( p2.getIdentifier( ) ) )
        {
            if( p2.getQuantityOfUnitsAvailable( ) > 0 )
            {
                world.sellProduct2( );
                panelProduct2.actualizarInterfaz( p2.getPrice( ), p2.getQuantityOfUnitsAvailable( ) );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El producto se encuentra agotado", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pIdentificador.equals( p3.getIdentifier( ) ) )
        {
            if( p3.getQuantityOfUnitsAvailable( ) > 0 )
            {
                world.sellProduct3( );
                panelProduct3.actualizarInterfaz( p3.getPrice( ), p3.getQuantityOfUnitsAvailable( ) );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El producto se encuentra agotado", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pIdentificador.equals( p4.getIdentifier( ) ) )
        {
            if( p4.getQuantityOfUnitsAvailable( ) > 0 )
            {
                world.sellProduct4( );
                panelProduct4.actualizarInterfaz( p4.getPrice( ), p4.getQuantityOfUnitsAvailable( ) );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El producto se encuentra agotado", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Muestra el diálogo con la cantidad de ventas de la máquina
     */
    public void mostrarDialogoCantidadVentas( )
    {
        int totalVentas = world.getQuantityOfTotalSales( );
        String mensaje = "La cantidad de ventas de la máquina es " + totalVentas + ".";
        JOptionPane.showMessageDialog( this, mensaje, "Cantidad de ventas", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra el diálogo con el valor total de ventas de la máquina
     */
    public void mostrarDialogoValorTotalVentas( )
    {
        double valorTotalVentas = world.getValueOfTotalSales( );
        String mensaje = "El valor total de las ventas de la máquina es $" + valorTotalVentas + ".";
        JOptionPane.showMessageDialog( this, mensaje, "Valor total de las ventas", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Muestra el diálogo con la capacidad disponible de la máquina.
     */
    public void mostrarDialogoPorcentajeDeDisponibilidad( )
    {
        String capacidad = JOptionPane.showInputDialog( this, "Ingrese la capacidad de la máquina" );

        if( capacidad != null )
        {
            try
            {
                int capacidadInt = Integer.parseInt( capacidad );

                if( capacidadInt < 1 )
                {
                    JOptionPane.showMessageDialog( this, "La capacidad debe ser mayor o igual a 1.", "Error", JOptionPane.INFORMATION_MESSAGE );
                }

                else
                {
                    double capacidadDisponible = world.getPercentOfAvailability( capacidadInt );
                    String mensaje = "El porcentaje de disponibilidad de la máquina es del " + capacidadDisponible + "%.";
                    JOptionPane.showMessageDialog( this, mensaje, "Porcentaje de disponibilidad", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar números enteros.", "Error", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    /**
     * Muestra el diálogo con las ventas por producto.
     */
    public void mostrarDialogoUnidadesVendidas( )
    {
        Product p1 = world.getProduct1( );
        Product p2 = world.getProduct2( );
        Product p3 = world.getProduct3( );
        Product p4 = world.getProduct4( );

        String mensaje = "La cantidad de unidades vendidas por producto es:";
        mensaje += "\n" + p1.getName( ) + ": " + p1.getQuantityOfUnitsSold( );
        mensaje += "\n" + p2.getName( ) + ": " + p2.getQuantityOfUnitsSold( );
        mensaje += "\n" + p3.getName( ) + ": " + p3.getQuantityOfUnitsSold( );
        mensaje += "\n" + p4.getName( ) + ": " + p4.getQuantityOfUnitsSold( );

        JOptionPane.showMessageDialog( this, mensaje, "Unidades vendidas", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Puntos de extensión
    // -----------------------------------------------------------------

    /**
     * Extensión 1
     */
    public void reqFuncOpcion1( )
    {

        String resultado = world.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Extensión 2
     */
    public void reqFuncOpcion2( )
    {

        String resultado = world.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo opcional de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfaceVendingMachine userInterface = new InterfaceVendingMachine( );
            userInterface.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

}
