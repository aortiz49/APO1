/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogot�	- Colombia)
 * Departamento	de	Ingenier�a	de	Sistemas	y	Computaci�n
 * Licenciado	bajo	el	esquema	Academic Free License versi�n 2.1
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
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Contiene los botones ubicados en la parte derecha de la ventana.
 */
@SuppressWarnings("serial")
public class PanelButtons extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ejecutar la acci�n del bot�n btnCantidadVentas.
     */
    private static final String CANTIDAD_VENTAS = "Cantidad de ventas";

    /**
     * Comando para ejecutar la acci�n del bot�n btnValorVentas.
     */
    private static final String VALOR_TOTAL_VENTAS = "Valor total de las ventas";
    
    /**
     * Comando para ejecutar la acci�n del bot�n btnPorcentaje
     */
    private static final String PORCENTAJE_DISPONIBILIDAD = "% de disponibilidad";
    
    /**
     * Comando para ejecutar la acci�n del bot�n btnUnidadesVendidas
     */
    private static final String UNIDADES_VENDIDAS = "Unidades vendidas";


    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfaceVendingMachine principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para conover la cantidad de ventas.
     */
    private JButton btnCantidadVentas;

    /**
     * Bot�n para conocer el valor de las ventas.
     */
    private JButton btnValorVentas;
    
    /**
     * Bot�n para calcular el porcentaje de ocupaci�n de la m�quina
     */
    private JButton btnPorcentaje;
    
    /**
     * Bot�n para obtener las ventas por producto.
     */
    private JButton btnUnidadesVendidas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los botones <br>
     * <b>post:</b> Todos los botones fueron inicializados.
     * @param pInterfaz Interfaz principal de la aplicaci�n. pInterfaz != null
     */
    public PanelButtons(InterfaceVendingMachine pInterfaz )
    {
        TitledBorder b = BorderFactory.createTitledBorder( "" );
        setBorder( b );
        
        JLabel lblImagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "data/img/lateral.png" );
        lblImagen.setIcon( icono );

        principal = pInterfaz;
        setLayout( new BorderLayout() );

        add(lblImagen, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel (new GridLayout( 4, 1 ));
        add(panelInferior, BorderLayout.SOUTH);
        
        btnCantidadVentas = new JButton( CANTIDAD_VENTAS );
        btnValorVentas = new JButton( VALOR_TOTAL_VENTAS );
        btnPorcentaje = new JButton( PORCENTAJE_DISPONIBILIDAD );
        btnUnidadesVendidas = new JButton( UNIDADES_VENDIDAS );

        btnCantidadVentas.addActionListener( this );
        btnValorVentas.addActionListener( this );
        btnPorcentaje.addActionListener( this );
        btnUnidadesVendidas.addActionListener( this );

        btnCantidadVentas.setActionCommand( CANTIDAD_VENTAS );
        btnValorVentas.setActionCommand( VALOR_TOTAL_VENTAS );
        btnPorcentaje.setActionCommand( PORCENTAJE_DISPONIBILIDAD );
        btnUnidadesVendidas.setActionCommand( UNIDADES_VENDIDAS );

        panelInferior.add( btnCantidadVentas );
        panelInferior.add( btnValorVentas );
        panelInferior.add( btnPorcentaje );
        panelInferior.add( btnUnidadesVendidas );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos del usuario.
     * @param pEvento Evento de usuario. pEvento != null.
     */
    @Override
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( CANTIDAD_VENTAS ) )
        {
            principal.mostrarDialogoCantidadVentas( );
        }
        else if( pEvento.getActionCommand( ).equals( VALOR_TOTAL_VENTAS ) )
        {
            principal.mostrarDialogoValorTotalVentas( );
        }
        else if( pEvento.getActionCommand( ).equals( PORCENTAJE_DISPONIBILIDAD ) )
        {
            principal.mostrarDialogoPorcentajeDeDisponibilidad( );
        }
        else if( pEvento.getActionCommand( ).equals( UNIDADES_VENDIDAS ) )
        {
            principal.mostrarDialogoUnidadesVendidas( );
        }
    }

}
