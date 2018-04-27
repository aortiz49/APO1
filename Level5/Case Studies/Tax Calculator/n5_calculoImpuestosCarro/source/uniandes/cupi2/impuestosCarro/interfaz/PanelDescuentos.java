/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_calculoImpuestosCarro
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.impuestosCarro.interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel para presentar la informaci�n de descuentos.
 */
@SuppressWarnings("serial")
public class PanelDescuentos extends JPanel
{
    // -----------------------------------------------------------------
    // Elementos de la interfaz
    // -----------------------------------------------------------------

    /**
     * CheckBox para elegir si se quiere liquidar con pronto pago.
     */
    private JCheckBox cbPPago;

    /**
     * CheckBox para elegir si se quiere liquidar con descuento por servicio p�blico.
     */
    private JCheckBox cbSPublico;

    /**
     * CheckBox para elegir si se quiere liquidar con descuento por traslado de cuenta.
     */
    private JCheckBox cbTCuenta;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Crea el panel de descuentos.
     */
    public PanelDescuentos( )
    {
        // Establece el layout como una grilla de 2 filas y 2 columnas
        setLayout( new GridLayout( 2, 2 ) );

        // Adiciona un marco con t�tulo
        TitledBorder border = new TitledBorder( "Descuentos" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );

        // Crea los objetos of the  panel
        cbPPago = new JCheckBox( "Pronto pago" );
        cbSPublico = new JCheckBox( "Servicio p�blico" );
        cbTCuenta = new JCheckBox( "Traslado de cuenta" );

        // Adiciona los objetos of the  panel
        add( cbPPago );
        add( cbTCuenta );
        add( cbSPublico );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Indica si aplica el descuento pronto pago.
     * @return Retorna true si aplica el descuento, false en caso contrario.
     */
    public boolean hayDescuentoProntoPago( )
    {
        return cbPPago.isSelected( );
    }

    /**
     * Indica si aplica el descuento por servicio p�blico.
     * @return Retorna true si aplica el descuento, false en caso contrario.
     */
    public boolean hayDescuentoServicioPublico( )
    {
        return cbSPublico.isSelected( );
    }

    /**
     * Indica si aplica el descuento por traslado de cuenta.
     * @return Retorna true si aplica el descuento, false en caso contrario.
     */
    public boolean hayDescuentoTrasladoCuenta( )
    {
        return cbTCuenta.isSelected( );
    }

    /**
     * Limpia los campos of the  panel.
     */
    public void limpiar( )
    {
        cbPPago.setSelected( false );
        cbSPublico.setSelected( false );
        cbTCuenta.setSelected( false );
    }
}