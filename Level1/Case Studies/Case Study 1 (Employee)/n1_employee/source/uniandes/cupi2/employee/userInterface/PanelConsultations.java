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

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Panel for consultations and operations of the application
 */
public class PanelConsultations extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    // Constant to calculate employee age
    private final static String CALCULATE_AGE = "CALCULATE AGE";

    // Constant to calculate employee work history
    private final static String CALCULATE_WORK_HISTORY = "CALCULATE WORK HISTORY";

    // Constant to calculate employee benefits
    private final static String CALCULATE_BENEFITS = "CALCULATE BENEFITS";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Principal window of application
     */
    private EmployeeInterface principal;

    // -----------------------------------------------------------------
    // Interface attributes
    // -----------------------------------------------------------------

    // Field to show employee age
    private JTextField txtAge;

    // Field to show employee work history
    private JTextField txtWorkHistory;

    // Field to show employee benefits
    private JTextField txtBenefits;

    // Button to calculate employee age
    private JButton btnAge;

    // Button to calculate employee work history
    private JButton btnWorkHistory;

    // Button to calculate employee benefits
    private JButton btnBenefits;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs the panel of data to consult.
     * pPrincipal: Principal interface of the application. pPrincipal != null.
     */
    public PanelConsultations(EmployeeInterface pPrincipal) {
        principal = pPrincipal;
        setLayout(new BorderLayout());
        TitledBorder border = new TitledBorder("Actions");
        border.setTitleColor(Color.BLACK);
        setBorder(border);

        btnAge = new JButton();
        btnAge.setText("Calculate age");
        btnAge.setActionCommand(PanelConsultations.CALCULATE_AGE);
        btnAge.addActionListener(this);

        btnWorkHistory = new JButton();
        btnWorkHistory.setText("Calculate work history");
        btnWorkHistory.setActionCommand(PanelConsultations.CALCULATE_WORK_HISTORY);
        btnWorkHistory.addActionListener(this);

        btnBenefits = new JButton();
        btnBenefits.setText("Calculate benefits");
        btnBenefits.setActionCommand(PanelConsultations.CALCULATE_BENEFITS);
        btnBenefits.addActionListener(this);

        txtAge = new JTextField(10);
        txtAge.setEditable(false);

        txtWorkHistory = new JTextField(10);
        txtWorkHistory.setEditable(false);

        txtBenefits = new JTextField(10);
        txtBenefits.setEditable(false);

        JPanel panelCalculations = new JPanel(new GridLayout(3, 2));
        JLabel emptySpace1 = new JLabel("");
        JLabel emptySpace2 = new JLabel("");
        emptySpace1.setPreferredSize(new Dimension(120, 0));
        emptySpace2.setPreferredSize(new Dimension(120, 0));

        add(emptySpace1, BorderLayout.EAST);
        add(panelCalculations, BorderLayout.CENTER);
        add(emptySpace2, BorderLayout.WEST);
        panelCalculations.add(btnAge);
        panelCalculations.add(txtAge);
        panelCalculations.add(btnWorkHistory);
        panelCalculations.add(txtWorkHistory);
        panelCalculations.add(btnBenefits);
        panelCalculations.add(txtBenefits);

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Cleans all fields
     */
    public void clearFields() {
        txtAge.setText("");
        txtWorkHistory.setText("");
        txtBenefits.setText("");
    }

    /**
     * Updates age text field with value given by parameter.
     * pAge: Employee's age. pAge > 0.
     */
    public void updateAge(int pAge) {
        txtAge.setText("" + pAge);
    }

    /**
     * Updates work history text field with value given by parameter.
     * pWorkHistory: Employee's work history. pWorkHistory > 0.
     */
    public void updateWorkHistory(int pWorkHistory) {
        txtWorkHistory.setText("" + pWorkHistory);
    }

    /**
     * Updates benefits text field with value given by parameter.
     * pBenefits: Employee's benefits. pBenefits > 0.
     */
    public void updateBenefits(double pBenefits) {
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        df.applyPattern("$###,###.##");
        txtBenefits.setText(df.format(pBenefits));
    }

    /**
     * Manages button events
     * pEvent: Action that generates the event. pEvent != null.
     */
    public void actionPerformed(ActionEvent pEvent) {
        String command = pEvent.getActionCommand();

        switch (command) {
            case CALCULATE_AGE:
                principal.calculateEmployeeAge();
                break;
            case CALCULATE_WORK_HISTORY:
                principal.calculateEmployeeWorkHistory();
                break;
            case CALCULATE_BENEFITS:
                principal.calculateEmployeeBenefits();
                break;
        }
    }

}
