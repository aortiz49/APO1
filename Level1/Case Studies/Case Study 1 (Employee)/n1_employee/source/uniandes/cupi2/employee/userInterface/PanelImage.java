/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- employee
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.employee.userInterface;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel with banner image
 */

public class PanelImage extends JPanel {
    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Panel constructor
     */
    public PanelImage() {
        JLabel image;
        ImageIcon icon = new ImageIcon("./data/images/banner.png");
        image = new JLabel("");
        image.setIcon(icon);
        add(image);
    }

}
