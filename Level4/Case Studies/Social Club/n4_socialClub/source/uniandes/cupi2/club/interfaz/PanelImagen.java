/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_club
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.club.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel que conhasBill el banner con la imagen.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Ruta de la imagen del banner.
     */
    public final static String RUTA_IMAGEN = "./data/banner.png";

    // -----------------------------------------------------------------
    // Attributes de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta de la imagen.
     */
    private JLabel labImagen;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el panel con el banner.
     */
    public PanelImagen( )
    {
        labImagen = new JLabel( );
        labImagen.setIcon( new ImageIcon( RUTA_IMAGEN ) );
        add( labImagen );
    }
}
