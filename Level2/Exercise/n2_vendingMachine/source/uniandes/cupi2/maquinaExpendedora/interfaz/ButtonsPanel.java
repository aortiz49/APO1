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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Panel con los botones de la aplicación..
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ejecutar la acción del botón btnValorCompras.
     */
    private static final String VALOR_TOTAL_COMPRAS = "Valor total de las compras";

    /**
     * Comando para ejecutar la acción del botón btnPorcentaje.
     */
    private static final String PORCENTAJE_DISPONIBILIDAD = "Porcentaje de disponibilidad";

    /**
     * Comando para ejecutar la acción del botón btn.
     */
    private static final String UNIDADES_COMPRADAS = "Unidades compradas";

    /**
     * Comando para ejecutar la acción del botón btnInfoDonacionFopre.
     */
    private static final String INFO_DONACION_FOPRE = "Información FOPRE";

    /**
     * Comando para ejecutar la acción del botón btnProductoMasComprado.
     */
    private static final String PRODUCTO_MAS_COMPRADO = "Producto más comprado";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazMaquinaExpendedora principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para conocer el valor de las compras.
     */
    private JButton btnValorCompras;

    /**
     * Botón para calcular el porcentaje de disponibilidad de la máquina.
     */
    private JButton btnPorcentajeDisponibilidad;

    /**
     * Botón para obtener las ventas por producto.
     */
    private JButton btnUnidadesCompradas;

    /**
     * Botón para obtener la información de donación al FOPRE.
     */
    private JButton btnInfoDonacionFopre;

    /**
     * Botón para obtener el producto más comprado.
     */
    private JButton btnProductoMasComprado;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los botones. <br>
     * <b>post:</b> Todos los botones fueron inicializados.
     * @param pInterfaz Interfaz principal de la aplicación. pInterfaz != null.
     */
    public PanelBotones( InterfazMaquinaExpendedora pInterfaz )
    {
        principal = pInterfaz;
        setLayout( new GridLayout( 5, 1, 5, 5 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        btnUnidadesCompradas = new JButton( UNIDADES_COMPRADAS );
        btnUnidadesCompradas.setActionCommand( UNIDADES_COMPRADAS );
        btnUnidadesCompradas.addActionListener( this );
        add( btnUnidadesCompradas );

        btnProductoMasComprado = new JButton( PRODUCTO_MAS_COMPRADO );
        btnProductoMasComprado.setActionCommand( PRODUCTO_MAS_COMPRADO );
        btnProductoMasComprado.addActionListener( this );
        add( btnProductoMasComprado );
        
        btnValorCompras = new JButton( VALOR_TOTAL_COMPRAS );
        btnValorCompras.setActionCommand( VALOR_TOTAL_COMPRAS );
        btnValorCompras.addActionListener( this );
        add( btnValorCompras );

        btnPorcentajeDisponibilidad = new JButton( PORCENTAJE_DISPONIBILIDAD );
        btnPorcentajeDisponibilidad.setActionCommand( PORCENTAJE_DISPONIBILIDAD );
        btnPorcentajeDisponibilidad.addActionListener( this );
        add( btnPorcentajeDisponibilidad );

        btnInfoDonacionFopre = new JButton( INFO_DONACION_FOPRE );
        btnInfoDonacionFopre.setActionCommand( INFO_DONACION_FOPRE );
        btnInfoDonacionFopre.addActionListener( this );
        add( btnInfoDonacionFopre );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos del usuario.
     * @param pEvento Evento de usuario. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        switch( comando )
        {
            case VALOR_TOTAL_COMPRAS:
                principal.darValorTotalCompras( );
                break;
            case PORCENTAJE_DISPONIBILIDAD:
                principal.darPorcentajeDeDisponibilidad( );
                break;
            case UNIDADES_COMPRADAS:
                principal.mostrarDialogoUnidadesCompradas( );
                break;
            case INFO_DONACION_FOPRE:
                principal.mostrarDialogoInfoDonacionFopre( );
                break;
            case PRODUCTO_MAS_COMPRADO:
                principal.darProductoMasComprado( );
                break;
        }
    }

}
