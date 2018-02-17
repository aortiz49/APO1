/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_maquinaExpendedora
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.maquinaExpendedora.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;

/**
 * Representa el dialogo de la información FOPRE.
 */
@SuppressWarnings("serial")
public class DialogoInformacionFopre extends JDialog
{

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto con la información del total de donaciones.
     */
    private JTextField txtDonacionTotal;

    /**
     * Campo de texto con la información de la donación para productos de tipo comida.
     */
    private JTextField txtDonacionComida;

    /**
     * Campo de texto con la información de la donación para productos de tipo bebida.
     */
    private JTextField txtDonacionBebida;
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Construye un nuevo dialogo de información FOPRE.<br>
     * <b>post:</b> Todos los botones fueron inicializados.
     * @param cantidadVentasComida Cantidad de ventas por cuenta de productos de tipo COMIDA.
     * @param donacionComida Valor de la donación realizada por los productos de tipo COMIDA.
     * @param cantidadVentasBebida Cantidad de ventas por cuenta de productos de tipo BEBIDA.
     * @param donacionBebida Valor de la donación realizada por los productos de tipo BEBIDA.
     * @param donacionTotal Donación total al FOPRE.
     */
    public DialogoInformacionFopre(  int cantidadVentasComida, double donacionComida, int cantidadVentasBebida, double donacionBebida, double donacionTotal )
    {
        setTitle( "Información FOPRE" );
        setSize( 400, 300 );
        setLayout( new BorderLayout( ) );
        setLocationRelativeTo( null );

        JPanel panelGeneral = new JPanel( );
        panelGeneral.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
        panelGeneral.setLayout( new BorderLayout( ) );
        add( panelGeneral, BorderLayout.CENTER );

        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,### COP" );

        JPanel panelInferior = new JPanel( );
        panelInferior.setBorder( new CompoundBorder( new TitledBorder( "Donaciones:" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
        panelInferior.setLayout( new GridLayout( 3, 2, 3, 3 ) );
        panelGeneral.add( panelInferior, BorderLayout.CENTER );

        panelInferior.add( new JLabel( "Total: " ) );

        txtDonacionTotal = new JTextField(df.format(donacionTotal ) );
        txtDonacionTotal.setFont( new Font( "Tahoma", Font.BOLD, 18 ) );
        txtDonacionTotal.setEditable( false );
        txtDonacionTotal.setHorizontalAlignment( JTextField.CENTER );
        panelInferior.add( txtDonacionTotal );

        panelInferior.add( new JLabel( "Comida:" ) );

        txtDonacionComida = new JTextField(df.format( donacionComida )+ "(" + cantidadVentasComida + " unidades)" );
        txtDonacionComida.setEditable( false );
        txtDonacionComida.setHorizontalAlignment( JTextField.CENTER );
        panelInferior.add( txtDonacionComida );

        panelInferior.add( new JLabel( "Bebida:" ) );

        txtDonacionBebida = new JTextField( df.format(donacionBebida )+ " (" + cantidadVentasBebida + " unidades)" );
        txtDonacionBebida.setEditable( false );
        txtDonacionBebida.setHorizontalAlignment( JTextField.CENTER );

        panelInferior.add( txtDonacionBebida );

    }

}
