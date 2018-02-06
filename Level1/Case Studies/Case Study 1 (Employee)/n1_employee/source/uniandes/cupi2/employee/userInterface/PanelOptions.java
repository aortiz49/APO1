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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel with application options
 */

public class PanelOptions extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    // Constant to change employee
    private final String CHANGE_EMPLOYEE = "changeEmployee";

    // Constant for extension 1
    private final String OPTION_1 = "option1";

    // Constant for extension 2
    private final String OPTION_2 = "option2";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Principal application window
    private EmployeeInterface principal;

    // -----------------------------------------------------------------
    // Interface attributes
    // -----------------------------------------------------------------

    // Button to change employee
    private JButton btnChangeEmployee;

    // Button for extension 1
    private JButton btnOption1;

    // Button for extension 2
    private JButton btnOption2;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs options panel
     * pPrincipal: Principal application window. pPrincipal != null.
     */
    public PanelOptions(EmployeeInterface pPrincipal) {
        principal = pPrincipal;

        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 5, 0), new TitledBorder("Options")));

        setLayout(new GridLayout(1, 3));

        btnChangeEmployee = new JButton("Change employee");
        btnChangeEmployee.setActionCommand(CHANGE_EMPLOYEE);
        btnChangeEmployee.addActionListener(this);

        btnOption1 = new JButton("Option 1");
        btnOption1.setActionCommand(OPTION_1);
        btnOption1.addActionListener(this);

        btnOption2 = new JButton("Option 2");
        btnOption2.setActionCommand(OPTION_2);
        btnOption2.addActionListener(this);

        add(btnChangeEmployee);
        add(btnOption1);
        add(btnOption2);
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Manages button events
     * pEvent: Action that generates the events. pEvent != null.
     */
    public void actionPerformed(ActionEvent pEvent) {
        String command = pEvent.getActionCommand();
        if(CHANGE_EMPLOYEE.equals(command))
            principal.showDialogToChangeEmployee();
        else if(OPTION_1.equals(command))
            principal.reqFuncOption1();
        else if(OPTION_2.equals(command))
            principal.reqFuncOption2();
    }

}
