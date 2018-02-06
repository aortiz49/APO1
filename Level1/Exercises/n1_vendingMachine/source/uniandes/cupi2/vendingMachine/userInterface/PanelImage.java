/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- vendingMachine
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.userInterface;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Contains the banner
 */

public class PanelImage extends JPanel {

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------
    /**
     * Constructs the panel and adds the banner to the interface
     */
    public PanelImage() {
        JLabel lblImage = new JLabel();
        ImageIcon icon = new ImageIcon("data/img/banner.png");
        setSize(icon.getIconHeight(), icon.getIconWidth());
        lblImage = new JLabel("");
        lblImage.setIcon(icon);
        add(lblImage);

        setBackground(Color.BLACK);
    }

}
