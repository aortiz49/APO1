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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Contains the buttons contained in the lower part of the principal window
 */

public class PanelOptions extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Command to execute the acction of button btnOption1.
     */
    private static final String OPTION1 = "Option 1";

    /**
     * Command to execute the acction of button btnOption2.
     */
    private static final String OPTION2 = "Option 2";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Principal window of the application 
     */
    private InterfaceVendingMachine principal;

    // -----------------------------------------------------------------
    // Attributes of the interface
    // -----------------------------------------------------------------

    // Buttons for options 1 and 2
    private JButton btnOption1;
    private JButton btnOption2;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs the panel with the buttons 
     * Initializes every button
     * pInterface: Principal interface of the application. pInterface != null
     */
    public PanelOptions( InterfaceVendingMachine pInterface ) {
        TitledBorder b = BorderFactory.createTitledBorder("Options");
        setBorder(b);

        principal = pInterface;
        setLayout(new GridLayout(1, 3));

        btnOption1 = new JButton(OPTION1);
        btnOption2 = new JButton(OPTION2);

        btnOption1.addActionListener(this);
        btnOption2.addActionListener(this);

        btnOption1.setActionCommand(OPTION1);
        btnOption2.setActionCommand(OPTION2);

        add(btnOption1);
        add(btnOption2);

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Management of user events 
     * pEvent: User events. pEvent != null.
     */
    
    public void actionPerformed(ActionEvent pEvent) {
        if(pEvent.getActionCommand().equals(OPTION1))
            principal.reqFuncOption1();
    
        else if(pEvent.getActionCommand().equals(OPTION2))
            principal.reqFuncOption2();
    }

}
