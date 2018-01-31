/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- vendingMachine
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.userInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Contains the buttons located on the right part of the window.
 */

public class PanelButtons extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Command to execute the action of button btnQuantityOfSales
     */
    private static final String QUANTITY_SALES = "Quantity of sales";

    /**
     * Command to execute the action of button btnValueOfSales
     */
    private static final String TOTAL_VALUE_SALES = "Total value of sales";
    
    /**
     * Command to execute the action of button btnPercentage
     */
    private static final String PERCENT_AVAILABILITY = "% of product availability";
    
    /**
     * Command to execute the action of button btnUnitsSold
     */
    private static final String UNITS_SOLD = "Units sold";


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

    /**
     * Button to know the quantity of sales 
     */
    private JButton btnQuantityOfSales;

    /**
     * Button to know the total value of sales
     */
    private JButton btnValueOfSales;
    
    /**
     * Button to calculate the percentage of product availability in the machine
     */
    private JButton btnPercentage;
    
    /**
     * Button to know the quantity of units of each product sold
     */
    private JButton btnUnitsSold;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs the panel with the buttons
     * Every button is initialized 
     * pInterface: Principal interface of the application. pInterface != null
     */
    public PanelButtons(InterfaceVendingMachine pInterface) {
        TitledBorder b = BorderFactory.createTitledBorder("");
        setBorder(b);
        
        JLabel lblImage = new JLabel();
        ImageIcon icon = new ImageIcon("data/img/lateral.png");
        lblImage.setIcon(icon);

        principal = pInterface;
        setLayout(new BorderLayout());

        add(lblImage, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel (new GridLayout(4, 1));
        add(panelInferior, BorderLayout.SOUTH);
        
        btnQuantityOfSales = new JButton(QUANTITY_SALES);
        btnValueOfSales = new JButton(TOTAL_VALUE_SALES);
        btnPercentage = new JButton(PERCENT_AVAILABILITY);
        btnUnitsSold = new JButton(UNITS_SOLD);

        btnQuantityOfSales.addActionListener(this);
        btnValueOfSales.addActionListener(this);
        btnPercentage.addActionListener(this);
        btnUnitsSold.addActionListener(this);

        btnQuantityOfSales.setActionCommand(QUANTITY_SALES);
        btnValueOfSales.setActionCommand(TOTAL_VALUE_SALES);
        btnPercentage.setActionCommand(PERCENT_AVAILABILITY);
        btnUnitsSold.setActionCommand(UNITS_SOLD);

        panelInferior.add(btnQuantityOfSales);
        panelInferior.add(btnValueOfSales);
        panelInferior.add(btnPercentage);
        panelInferior.add(btnUnitsSold);

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Management of user events 
     * pEvent: user event. pEvent != null.
     */
    public void actionPerformed(ActionEvent pEvent) {
        if(pEvent.getActionCommand().equals(QUANTITY_SALES))
            principal.showDialogQuantityOfSales();
        
        else if(pEvent.getActionCommand().equals(TOTAL_VALUE_SALES))
            principal.showDialogValueOfTotalSales();
        
        else if(pEvent.getActionCommand().equals(PERCENT_AVAILABILITY))
            principal.showDialogPercentOfAvailability();

        else if(pEvent.getActionCommand().equals(UNITS_SOLD))
            principal.showDialogOfUnitsSold();
    }

}
