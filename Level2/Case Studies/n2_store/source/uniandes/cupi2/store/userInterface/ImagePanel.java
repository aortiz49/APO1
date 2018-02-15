/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n2_store
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.store.userInterface;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel with application image.
 */
public class ImagePanel extends JPanel {

    // ------------------------------------------------------------
    // Attributes of user interface
    // ------------------------------------------------------------

    // ------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------

    // Image panel constructor
    public ImagePanel() {
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("./data/images/Banner.png");
        JLabel lblImage = new JLabel("");

        lblImage.setIcon(icon);
        lblImage.setBorder(new TitledBorder(""));
        add(lblImage, BorderLayout.CENTER);

    }
}