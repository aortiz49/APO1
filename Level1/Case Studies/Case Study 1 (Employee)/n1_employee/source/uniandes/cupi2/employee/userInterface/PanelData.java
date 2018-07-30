/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- employee
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.employee.userInterface;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// Panel that shows employee data
public class PanelData extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    // Constant to modify salary
    private final static String MODIFY_SALARY = "MODIFY SALARY";

    // Constant to modify subordinates
    private final static String MODIFY_SUBORDINATES = "MODIFY SUBORDINATES";

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

    // Children label
    private JLabel lblChildren;

    // Subordinates label
    private JLabel lblSubordinates;

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

    // Children text field
    private JTextField txtChildren;

    // Subordinates text field
    private JTextField txtSubordinates;

    // Button to modify salary
    private JButton btnModifySalary;

    // Button to modify subordinates
    private JButton btnModifySubordinates;


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
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 6, 0), new TitledBorder("Data")));

        lblName = new JLabel("Name: ");
        lblLastName = new JLabel("Last Name: ");
        lblGender = new JLabel("Gender: ");
        lblDateOfBirth = new JLabel("Date of Birth: ");
        lblDateOfEntry = new JLabel("Date of Entry: ");
        lblSalary = new JLabel("Salary: ");
        lblChildren = new JLabel("Children: ");
        lblSubordinates = new JLabel("Subordinates:");

        txtName = new JTextField();
        txtName.setEditable(false);
        txtLastName = new JTextField();
        txtLastName.setEditable(false);
        txtGender = new JTextField();
        txtGender.setEditable(false);
        txtDateOfBirth = new JTextField();
        txtDateOfBirth.setEditable(false);
        txtDateOfEntry = new JTextField();
        txtDateOfEntry.setEditable(false);
        txtSalary = new JTextField();
        txtSalary.setEditable(false);
        txtSalary.setDisabledTextColor(Color.DARK_GRAY);
        txtChildren = new JTextField();
        txtChildren.setEditable(false);
        txtSubordinates = new JTextField();
        txtSubordinates.setEditable(false);

        btnModifySalary = new JButton();
        btnModifySalary.setText("Modify salary");
        btnModifySalary.setActionCommand(MODIFY_SALARY);
        btnModifySalary.addActionListener(this);

        btnModifySubordinates = new JButton();
        btnModifySubordinates.setText("Modify subordinates");
        btnModifySubordinates.setActionCommand(MODIFY_SUBORDINATES);
        btnModifySubordinates.addActionListener(this);

        JPanel panelData = new JPanel(new GridLayout(9, 2));
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
        panelData.add(lblChildren);
        panelData.add(txtChildren);
        panelData.add(lblSubordinates);
        panelData.add(txtSubordinates);
        panelData.add(btnModifySubordinates);
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
     *
     * @param pName:         Employee's name. pName != null && pName != "".
     * @param pLastName:     Employee's last name. pLastName != null && pLastName != "".
     * @param pGender:       Employee's gender. pGender belongs to {"m","f"}.
     * @param pDateOfEntry:  Employee's date of entry. pDateOfEntry != null && pDateOfEntry != "".
     * @param pDateOfBirth:  Employee's date of birth. pDateOfBirth != null && pDateOfBirth != "".
     * @param pImage:        Image path. pImage != null.
     * @param pChildren:     Employee's children. pChildren &gt;=0.
     * @param pSubordinates: Employee's subordinates. pSubordinates &gt;=0.
     */
    public void updateFields(String pName, String pLastName, String pGender, String pDateOfEntry,
                             String pDateOfBirth, String pImage, int pChildren, int pSubordinates) {

        txtName.setText(pName);
        txtLastName.setText(pLastName);
        txtGender.setText(pGender);
        txtDateOfEntry.setText(pDateOfEntry);
        txtDateOfBirth.setText(pDateOfBirth);
        txtChildren.setText(Integer.toString(pChildren));
        txtSubordinates.setText(Integer.toString(pSubordinates));
        remove(lblImage);
        lblImage = new JLabel(new ImageIcon("./data/images/" + pImage));
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setVerticalAlignment(JLabel.CENTER);
        lblImage.setPreferredSize(new Dimension(170, 0));
        add(lblImage, BorderLayout.EAST);

    }

    /**
     * Updates salary.
     * pSalary: Employee salary. pSalary > 0.
     */
    public void updateSalary(double pSalary) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("$###,###.##");
        txtSalary.setText(df.format(pSalary));
    }

    /**
     * Updates subordinates.
     *
     * @param pSubordinates: Employee salary. pSalary > 0.
     */
    public void updateSubordinates(int pSubordinates) {
        txtSubordinates.setText(Integer.toString(pSubordinates));
    }

    /**
     * Manages events from the button
     * pEvent: Event generated by button click. pEvent != null.
     */
    public void actionPerformed(ActionEvent pEvent) {
        String command = pEvent.getActionCommand();

        if (command.equals(MODIFY_SALARY)) principal.modifySalary();
        else if(command.equals(MODIFY_SUBORDINATES)) principal.modifySubordinates();

        }



}