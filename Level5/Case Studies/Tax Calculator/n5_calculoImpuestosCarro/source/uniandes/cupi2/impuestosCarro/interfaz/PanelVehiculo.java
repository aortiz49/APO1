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
import java.text.*;

import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.impuestosCarro.mundo.Vehicle;

/**
 * Panel para mostrar la informaci�n de los veh�culos.
 */
@SuppressWarnings("serial")
public class PanelVehicle extends JPanel
{

    // -----------------------------------------------------------------
    // Attributes of the  interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto para visualizar la brand of the  veh�culo.
     */
    private JTextField txtBrand;

    /**
     * Campo de texto para escribir y visualizar la line of the  veh�culo.
     */
    private JTextField txtLine;

    /**
     * Campo de texto para escribir y visualizar el model of the  veh�culo.
     */
    private JTextField txtModelo;

    /**
     * Campo de texto para visualizar el valor of the  veh�culo.
     */
    private JTextField txtValor;

    /**
     * Etiqueta para mostrar la imagen of the  veh�culo.
     */
    private JLabel labImagen;

    /**
     * Panel para la navegaci�n of the  veh�culo.
     */
    private PanelNavegacion panelNavegacion;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Crea el panel donde se mostrar�n los veh�culos.
     * @param pPrincipal Ventana principal of the  aplicaci�n. pPrincipal != null.
     */
    public PanelVehicle( InterfazImpuestosCarro pPrincipal )
    {
        setLayout( new BorderLayout( ) );
        labImagen = new JLabel( );
        labImagen.setBorder( new EmptyBorder( 0, 0, 0, 10 ) );
        add( labImagen, BorderLayout.WEST );

        JPanel informacion = new JPanel( );
        informacion.setLayout( new GridLayout( 4, 2, 10, 5 ) );
        add( informacion, BorderLayout.CENTER );

        // Adiciona un marco con t�tulo
        TitledBorder border = new TitledBorder( "Datos of the  veh�culo" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );

        // Crea e inicializa los objetos of the  panel
        JLabel labBrand = new JLabel( "Brand" );
        informacion.add( labBrand );

        txtBrand = new JTextField( );
        txtBrand.setEditable( false );
        informacion.add( txtBrand );

        JLabel labLine = new JLabel( "L�nea" );
        JLabel labModelo = new JLabel( "Modelo" );
        JLabel labValor = new JLabel( "Valor" );
        txtLine = new JTextField( );
        txtLine.setEditable( false );
        txtModelo = new JTextField( );
        txtModelo.setEditable( false );

        txtValor = new JTextField( );
        txtValor.setEditable( false );
        txtValor.setForeground( Color.BLUE );
        txtValor.setBackground( Color.WHITE );

        // Adiciona los objetos al panel
        informacion.add( labLine );
        informacion.add( txtLine );
        informacion.add( labModelo );
        informacion.add( txtModelo );
        informacion.add( labValor );
        informacion.add( txtValor );

        panelNavegacion = new PanelNavegacion( pPrincipal );
        add( panelNavegacion, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Actualiza el panel con la informaci�n of the  veh�culo que entra por par�metro.
     * @param pBrand Brand of the  veh�culo a mostrar.
     * @param pLine L�nea of the  veh�culo a mostrar.
     * @param pYear Year of the  veh�culo a mostrar.
     * @param pPrice Price of the  veh�culo a mostrar.
     * @param pImagePathImagen ImagePath of the  vehiculo a mostrar
     */
    public void actualizar( String pBrand, String pLine, String pYear, double pPrice, String pImagePathImagen )
    {
        txtBrand.setText( pBrand );
        txtLine.setText( pLine );
        txtModelo.setText( pYear );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        txtValor.setText( df.format( pPrice ) );
        labImagen.setIcon( new ImageIcon( new ImageIcon( "./data/imagenes/" + pImagePathImagen ).getImage( ).getScaledInstance( 280, 170, Image.SCALE_DEFAULT ) ) );
    }

}