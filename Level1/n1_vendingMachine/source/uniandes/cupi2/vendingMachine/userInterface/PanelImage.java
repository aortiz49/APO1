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

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contiene el Banner.
 */
@SuppressWarnings("serial")
public class PanelImage extends JPanel
{

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel y a�ade el banner a la interfaz.
     */
    public PanelImage( )
    {
        JLabel lblImagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "data/img/banner.png" );
        setSize( icono.getIconHeight( ), icono.getIconWidth( ) );
        lblImagen = new JLabel( "" );
        lblImagen.setIcon( icono );
        add( lblImagen );

        setBackground( Color.WHITE );
    }

}
