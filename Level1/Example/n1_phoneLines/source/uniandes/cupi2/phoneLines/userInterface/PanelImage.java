/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- phone lines
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.phoneLines.userInterface;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Image panel
public class PanelImage extends JPanel {

    //-----------------------------------------------------------------
    //Attributes of the interface
    //-----------------------------------------------------------------

    //Label with application image
    private JLabel imageLabel;

    //-----------------------------------------------------------------
    //Constructors
    //-----------------------------------------------------------------

    //Panel constructor
    public PanelImage( ) {
        //Company label logo
        ImageIcon icon = new ImageIcon( "data/Banner.png" );
        imageLabel = new JLabel( "" );
        imageLabel.setIcon( icon );

        add( imageLabel );
    }

}
