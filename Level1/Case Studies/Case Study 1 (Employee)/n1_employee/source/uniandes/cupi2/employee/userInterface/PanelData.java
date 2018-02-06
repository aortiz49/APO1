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

import uniandes.cupi2.employee.userInterface.EmployeeInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

// Panel that shows employee data
public class PanelData extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    // Constant to modify salary
    private final static String MODIFY_SALARY = "MODIFY SALARY";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Principal application window
    private EmployeeInterface principal;

    // -----------------------------------------------------------------
    // Interface attributes
    // -----------------------------------------------------------------

    // Name label
    private JLabel lblName;

    // Last name label
    private JLabel lblLastName;

    // Date of entry label
    private JLabel lblDateOfEntry;

    // Date of birth label
    private JLabel lblDateOfBirth;

    // Gender label
    private JLabel lblGender;

    // Salary label
    private JLabel lblSalary;

    // Image path label
    private JLabel lblImage;

    // Name text field
    private JTextField txtName;

    // Last name text field
    private JTextField txtLastName;

    // Date of entry text field
    private JTextField txtDateOfEntry;

    // Date of birth text field
    private JTextField txtDateOfBirth;

    // Gender text field
    private JTextField txtGender;

    // Salary text field
    private JTextField txtSalary;

    // Button to modify salary
    private JButton btnModifySalary;

    // Button to modify date of entry
    private JButton btnModifyDateOfEntry;



    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs panel with employee information.
     * pPrincipal:  Principal application window. pPrincipal != null.
     */
    public PanelData(EmployeeInterface pPrincipal) {
        principal = pPrincipal;

        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 5, 0), new TitledBorder("Data")));

        lblName = new JLabel("Name: ");
        lblLastName = new JLabel("Last Name: ");
        lblGender = new JLabel("Gender: ");
        lblDateOfBirth = new JLabel("Date of Birth: ");
        lblDateOfEntry = new JLabel("Date of Entry: ");
        lblSalary = new JLabel("Salary: ");

        txtName = new JTextField(15);
        txtName.setEditable(false);
        txtLastName = new JTextField(15);
        txtLastName.setEditable(false);
        txtGender = new JTextField(2);
        txtGender.setEditable(false);
        txtDateOfBirth = new JTextField(10);
        txtDateOfBirth.setEditable(false);
        txtDateOfEntry = new JTextField(10);
        txtDateOfEntry.setEditable(false);
        txtSalary = new JTextField(10);
        txtSalary.setEditable(false);
        txtSalary.setDisabledTextColor(Color.DARK_GRAY);

        btnModifySalary = new JButton();
        btnModifySalary.setText("Modify salary");
        btnModifySalary.setActionCommand(MODIFY_SALARY);
        btnModifySalary.addActionListener(this);

        JPanel panelData = new JPanel(new GridLayout(7, 2));
        panelData.add(lblName);
        panelData.add(txtName);
        panelData.add(lblLastName);
        panelData.add(txtLastName);
        panelData.add(lblGender);
        panelData.add(txtGender);
        panelData.add(lblDateOfBirth);
        panelData.add(txtDateOfBirth);
        panelData.add(lblDateOfEntry);
        panelData.add(txtDateOfEntry);
        panelData.add(lblSalary);
        panelData.add(txtSalary);
        panelData.add(new JLabel());
        panelData.add(btnModifySalary);

        lblImage = new JLabel();
        add(panelData, BorderLayout.CENTER);
        add(lblImage, BorderLayout.EAST);
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Updates the panel fields with employee information.
     * pName: Employee's name. pName != null && pName != "".
     * pLastName: Employee's last name. pLastName != null && pLastName != "".
     * pGender: Employee's gender. pGender belongs to {"m","f"}.
     * pDateOfEntry: Employee's date of entry. pDateOfEntry != null && pDateOfEntry != "".
     * pDateOfBirth: Employee's date of birth. pDateOfBirth != null && pDateOfBirth != "".
     * pImage: Image path. pImage != null.
     */
    public void updateFields(String pName, String pLastName, String pGender, String pDateOfEntry, String pDateOfBirth, String pImage) {
        txtName.setText(pName);
        txtLastName.setText(pLastName);
        txtGender.setText(pGender);
        txtDateOfEntry.setText(pDateOfEntry);
        txtDateOfBirth.setText(pDateOfBirth);
        remove(lblImage);
        lblImage = new JLabel(new ImageIcon("./data/images/" + pImage));
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setVerticalAlignment(JLabel.CENTER);
        lblImage.setPreferredSize(new Dimension(170, 0));
        add(lblImage, BorderLayout.EAST);

    }

    /**
     * Updates salary
     * pSalary: Employee salary. pSalary > 0.
     */
    public void updateSalary(double pSalary) {
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        df.applyPattern("$###,###.##");
        txtSalary.setText(df.format(pSalary));
    }

    /**
     * Manages events from the button
     * pEvent: Event generated by button click. pEvent != null.
     */
    public void actionPerformed(ActionEvent pEvent) {
        String command = pEvent.getActionCommand();

        if(command.equals(MODIFY_SALARY))
            principal.modifySalary();

    }

}