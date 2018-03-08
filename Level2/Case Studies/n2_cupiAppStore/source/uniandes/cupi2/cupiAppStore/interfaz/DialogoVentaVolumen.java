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

import javax.swing.JDialog;

/**
 * Dialogo que se muestra cuando se quiere obtener descuentos por volumen.
 */
@SuppressWarnings("serial")
public class DialogoVentaVolumen extends JDialog
{

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel donde se seleccionan las cantidades de licencias a comprar.
     */
    private PanelVentaVolumen panelVentaVolumen;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazJuegosCelular principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el diálogo para consultar ventas en volumen.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoVentaVolumen( InterfazJuegosCelular pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Consultar venta en volumen" );
        setSize( 400, 240 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        panelVentaVolumen = new PanelVentaVolumen( this );

        add( panelVentaVolumen );

        setModal( true );
        setLocationRelativeTo( pPrincipal );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Acción del botón cancelar.
     */
    public void cancelar( )
    {
        dispose( );
    }

    /**
     * Acción del botón aceptar.
     * @param pCantidadLicenciasJuego1 Cantidad de licencias del juego1. pCantidadLicenciasJuego1 >= 0.
     * @param pCantidadLicenciasJuego2 Cantidad de licencias del juego2. pCantidadLicenciasJuego2 >= 0.
     * @param pCantidadLicenciasJuego3 Cantidad de licencias del juego3. pCantidadLicenciasJuego3 >= 0.
     * @param pCantidadLicenciasJuego4 Cantidad de licencias del juego4. pCantidadLicenciasJuego4 >= 0.
     */
    public void aceptar( int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
    {
        principal.consultarDescuento( pCantidadLicenciasJuego1, pCantidadLicenciasJuego2, pCantidadLicenciasJuego3, pCantidadLicenciasJuego4 );
        dispose( );
    }

}
