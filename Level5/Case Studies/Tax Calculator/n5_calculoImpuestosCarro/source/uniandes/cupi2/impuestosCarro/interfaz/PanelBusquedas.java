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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Panel para las consultas sobre los veh�culos.
 */
@SuppressWarnings("serial")
public class PanelBusquedas extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para buscar un veh�culo por line.
     */
    public final static String BUSCAR_POR_LINEA = "Buscar por line";

    /**
     * Comando para buscar un veh�culo por brand.
     */
    public final static String BUSCAR_POR_MARCA = "Buscar por brand";

    /**
     * Comando para buscar el veh�culo m�s caro.
     */
    public final static String BUSCAR_MAS_CARO = "Buscar veh�culo m�s Caro";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Instancia of the  clase principal.
     */
    private InterfazImpuestosCarro principal;

    // -----------------------------------------------------------------
    // Elementos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto para la line.
     */
    private JTextField txtLine;

    /**
     * Campo de texto para la brand.
     */
    private JTextField txtBrand;

    /**
     * Bot�n para buscar por line.
     */
    private JButton btnBuscarLine;

    /**
     * Bot�n para buscar por brand.
     */
    private JButton btnBuscarBrand;

    /**
     * Bot�n para buscar el m�s caro.
     */
    private JButton btnBuscarCaro;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los botones y campos de texto.
     * @param pPrincipal Instancia principal of the  aplicaci�n.
     */
    public PanelBusquedas( InterfazImpuestosCarro pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridLayout( 3, 2 ) );
        setPreferredSize( new Dimension( 0, 100) );
        TitledBorder border = new TitledBorder( "B�squedas" );
        border.setTitleColor( Color.BLUE );
        setBorder(  border);
        

        txtLine = new JTextField( );
        add( txtLine );

        btnBuscarLine = new JButton( BUSCAR_POR_LINEA );
        btnBuscarLine.addActionListener( this );
        btnBuscarLine.setActionCommand( BUSCAR_POR_LINEA );
        add( btnBuscarLine );

        txtBrand = new JTextField( );
        add( txtBrand );

        btnBuscarBrand = new JButton( BUSCAR_POR_MARCA );
        btnBuscarBrand.addActionListener( this );
        btnBuscarBrand.setActionCommand( BUSCAR_POR_MARCA );
        add( btnBuscarBrand );

        add( new JLabel( ) );

        btnBuscarCaro = new JButton( BUSCAR_MAS_CARO );
        btnBuscarCaro.addActionListener( this );
        btnBuscarCaro.setActionCommand( BUSCAR_MAS_CARO );
        add( btnBuscarCaro );

    }

    /**
     * Respuesta a los eventos en los elementos of the  interfaz.
     * @param pEvento Evento generado. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( BUSCAR_MAS_CARO ) )
        {
            principal.buscarMasCaro( );
        }
        else if( comando.equals( BUSCAR_POR_LINEA ) )
        {
            String line = txtLine.getText( );
            if( line.isEmpty( ) )
            {
                JOptionPane.showMessageDialog( principal, "Debe ingresar una line.", "Buscar por line", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                principal.buscarPorLine( line );
                txtLine.setText( "" );
            }
        }
        else
        {
            String brand = txtBrand.getText( );
            if( brand.isEmpty( ) )
            {
                JOptionPane.showMessageDialog( principal, "Debe ingresar una brand.", "Buscar por brand", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                principal.buscarPorBrand( brand );
                txtBrand.setText( "" );
            }
        }
    }

}
