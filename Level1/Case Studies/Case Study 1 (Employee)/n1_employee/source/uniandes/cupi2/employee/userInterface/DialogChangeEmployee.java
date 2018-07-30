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

import com.toedter.calendar.JDateChooser;
import uniandes.cupi2.employee.world.DateInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

/**
 * Dialog to change employee
 */

public class DialogChangeEmployee extends JDialog implements ActionListener {
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    // Constants to accept changes
    private final static String SELECT_IMAGE = "SELECT_IMAGE";
    private final static String ACCEPT = "ACCEPT";
    private final static String CANCEL = "CANCEL";

    // -----------------------------------------------------------------
    // AtTRIBUTES
    // -----------------------------------------------------------------

    /**
     * Principal window of application
     */
    private EmployeeInterface principal;

    // -----------------------------------------------------------------
    // Interface attributes
    // -----------------------------------------------------------------

    // Text field for name
    private JTextField txtName;

    // Text field for last name
    private JTextField txtLastName;

    // Combo box for gender
    private JComboBox cbGender;

    // Text field for date of birth
    private JDateChooser dcDateOfBirth;

    // Text field for date of entry
    private JDateChooser dcDateOfEntry;

    // Text field for salary
    private JTextField txtSalary;

    // Text field for children
    private JTextField txtChildren;

    // Text field for subordinates
    private JTextField txtSubordinates;

    // Text field for the image
    private JTextField txtImage;

    // Button to select image
    private JButton btnSelectImage;

    // Button to accept changes
    private JButton btnAccept;

    // Button to cancel changes
    private JButton btnCancel;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs a dialog to modify employee data 
     * pPrincipal: Principal window of the application. pPrincipal != null.
     */
    public DialogChangeEmployee(EmployeeInterface pPrincipal) {
        principal = pPrincipal;

        setTitle("Change employee");
        setSize(450, 250);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(10, 2));

        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Last Name:"));
        txtLastName = new JTextField();
        add(txtLastName);

        add(new JLabel("Gender:"));
        cbGender = new JComboBox();
        cbGender.addItem("Female");
        cbGender.addItem("Male");
        add(cbGender);

        add(new JLabel("Date of Birth:"));
        dcDateOfBirth = new JDateChooser();
        add(dcDateOfBirth);

        add(new JLabel("Date of Entry:"));
        dcDateOfEntry = new JDateChooser();
        add(dcDateOfEntry);

        add(new JLabel("Salary:"));
        txtSalary = new JTextField();
        add(txtSalary);

        add(new JLabel("Children:"));
        txtChildren = new JTextField();
        add(txtChildren);

        add(new JLabel("Subordinates:"));
        txtSubordinates = new JTextField();
        add(txtSubordinates);

        add(new JLabel("Image:"));
        JPanel panelAux = new JPanel();
        panelAux.setLayout(new BorderLayout());
        txtImage = new JTextField();
        txtImage.setEditable(false);
        panelAux.add(txtImage, BorderLayout.CENTER);
        btnSelectImage = new JButton("Select");
        btnSelectImage.setActionCommand(SELECT_IMAGE);
        btnSelectImage.addActionListener(this);
        panelAux.add(btnSelectImage, BorderLayout.EAST);
        add(panelAux);

        btnAccept = new JButton("Accept");
        btnAccept.setActionCommand(ACCEPT);
        btnAccept.addActionListener(this);
        add(btnAccept);

        btnCancel = new JButton("Cancel");
        btnCancel.setActionCommand(CANCEL);
        btnCancel.addActionListener(this);
        add(btnCancel);

        setModal(true);
        setLocationRelativeTo(principal);
        setResizable(false);
    }

    /**
     * Manages button events
     * pEvent: Action that generates the event. pEvent != null.
     */
    public void actionPerformed(ActionEvent pEvent) {
        String command = pEvent.getActionCommand();
        if (command.equals(ACCEPT)) {
            String name = txtName.getText();
            String lastName = txtLastName.getText();
            int gender = cbGender.getSelectedIndex();
            Date dateOfEntry = dcDateOfEntry.getDate();
            DateInfo dateOfEntry2 = new DateInfo(dateOfEntry.getDay(), dateOfEntry.getMonth(),
                                                 dateOfEntry.getYear() + 1900);
            Date dateOfBirth = dcDateOfBirth.getDate();
            DateInfo dateOfBirth2 = new DateInfo(dateOfBirth.getDay(), dateOfBirth.getMonth(),
                                                 dateOfBirth.getYear() + 1900);
            String salaryStr = txtSalary.getText();
            String childrenStr = txtChildren.getText();
            String subordinateStr = txtSubordinates.getText();
            String image = txtImage.getText();
            if (name.equals("") || lastName.equals("") || dateOfEntry == null || dateOfBirth == null
                    || salaryStr.equals("") || image.equals("")) JOptionPane
                    .showMessageDialog(this, "You must fill out every entry.", "Change Employee",
                                       JOptionPane.ERROR_MESSAGE);

            else {
                try {
                    int salary = Integer.parseInt(salaryStr);
                    int children = Integer.parseInt(childrenStr);
                    int subordinates = Integer.parseInt(subordinateStr);
                    if (salary <= 0) JOptionPane
                            .showMessageDialog(this, "Salary must be greater than 0.",
                                               "Change Employee", JOptionPane.ERROR_MESSAGE);

                    else if (dateOfBirth2.getDifferenceInMonths(dateOfEntry2) < 0) JOptionPane
                            .showMessageDialog(this,
                                               "Date of entry cannot be before date of birth.",
                                               "Change Employee", JOptionPane.ERROR_MESSAGE);

                    else {
                        principal.changeEmployee(name, lastName, gender, dateOfBirth2, dateOfEntry2,
                                                 salary, image, children, subordinates);
                        dispose();
                    }

                } catch (NumberFormatException e) {
                    JOptionPane
                            .showMessageDialog(this, "Salary must be a number.", "Change Employee",
                                               JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (command.equals(SELECT_IMAGE)) {
            JFileChooser jfc = new JFileChooser("./data/images");
            if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selected = jfc.getSelectedFile();
                if (selected != null) txtImage.setText(selected.getName());
            }
        } else if (command.equals(CANCEL)) dispose();
    }

}
