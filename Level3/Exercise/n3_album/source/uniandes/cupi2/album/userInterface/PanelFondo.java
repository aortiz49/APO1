/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogota - Colombia)
 * Departamento de  Ingenieria  de  Sistemas    y   Computacion
 * Licenciado   bajo    el  esquema Academic Free License version 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_album
 * Autor: Team Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.userInterface;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;

/**
 * Panel que contiene el fondo y todos los elementos.
 */
@SuppressWarnings("serial")
public class PanelFondo extends JPanel
{
    // -----------------------------------------------------------------
    // Attributes of the  userInterface
    // -----------------------------------------------------------------

    /**
     * Imagen del fondo del album.
     */
    private ImageIcon fondo;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el panel con el fondo del album. <br>
     * <b>post:</b> Se crea el panel con el fondo del album.
     */
    public PanelFondo( )
    {
        fondo = new ImageIcon("./data/images/background.png");
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Pinta el panel y sus componentes.
     * @param pG Superficie del panel.
     */
    public void paintComponent( Graphics pG )
    {
        pG.drawImage( fondo.getImage( ), 0, 0, null );
        setOpaque( false );
        super.paintComponent( pG );
    }
}
