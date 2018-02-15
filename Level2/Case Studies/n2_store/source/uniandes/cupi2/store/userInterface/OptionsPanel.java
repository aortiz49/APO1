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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

// Panel to show options
public class OptionsPanel extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    // Command to show most sold product
    private static final String MOST_SOLD = "MostSold";

    // Command to show least sold product
    private static final String LEAST_SOLD = "LeastSold";

    // Command to show average sales
    private static final String AVERAGE_SALES = "AverageSales";

    // Command to show money in register
    private static final String MONEY_IN_REGISTER = "MoneyInRegister";

    // Command option 1
    private static final String OPTION_1 = "OPTION_1";

    // Command option 2
    private static final String OPTION_2 = "OPTION_2";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Principal window of application
    private StoreInterface principal;

    // -----------------------------------------------------------------
    // Attributes of interface
    // -----------------------------------------------------------------

    // Button to show most sold product
    private JButton btnMostSold;

    // Button to show  sold product
    private JButton btnLeastSold;

    // Button to show average sales
    private JButton btnAverageSales;

    // Button for money in register
    private JButton btnMoneyInRegister;

    // Button option1
    private JButton btnoption1;

    // Button option2
    private JButton btnoption2;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Panel constructor.
     * pPrincipal: Principal window. pPrincipal != null.
     */
    public OptionsPanel(StoreInterface pPrincipal) {
        principal = pPrincipal;

        setBorder(new TitledBorder("Options"));
        setLayout(new GridLayout(2, 3));

        btnMostSold = new JButton("Most sold product");
        btnMostSold.setActionCommand(MOST_SOLD);
        btnMostSold.addActionListener(this);
        add(btnMostSold);

        btnLeastSold = new JButton("Least sold product");
        btnLeastSold.setActionCommand(LEAST_SOLD);
        btnLeastSold.addActionListener(this);
        add(btnLeastSold);

        btnAverageSales = new JButton("Average of sales");
        btnAverageSales.setActionCommand(AVERAGE_SALES);
        btnAverageSales.addActionListener(this);
        add(btnAverageSales);

        btnMoneyInRegister = new JButton("Money in register");
        btnMoneyInRegister.setActionCommand(MONEY_IN_REGISTER);
        btnMoneyInRegister.addActionListener(this);
        add(btnMoneyInRegister);

        btnoption1 = new JButton("Option 1");
        btnoption1.setActionCommand(OPTION_1);
        btnoption1.addActionListener(this);
        add(btnoption1);

        btnoption2 = new JButton("Option 2");
        btnoption2.setActionCommand(OPTION_2);
        btnoption2.addActionListener(this);
        add(btnoption2);
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Manage event buttons
    public void actionPerformed(ActionEvent pEvent) {
        String command = pEvent.getActionCommand();
        switch (command) {
            case MOST_SOLD:
                principal.showMostSoldProduct();
                break;
            case LEAST_SOLD:
                principal.showLeastSoldProduct();
                break;
            case MONEY_IN_REGISTER:
                principal.showMoneyInRegister();
                break;
            case AVERAGE_SALES:
                principal.showAverageOfSales();
                break;
            case OPTION_1:
                principal.reqFuncOption1();
                break;
            case OPTION_2:
                principal.reqFuncOption2();
                break;
        }

    }

}
