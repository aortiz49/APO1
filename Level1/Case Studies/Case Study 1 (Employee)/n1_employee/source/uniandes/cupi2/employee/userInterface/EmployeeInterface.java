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

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.employee.world.Employee;
import uniandes.cupi2.employee.world.DateInfo;

/**
 * Principal window of the application
 */

public class EmployeeInterface extends JFrame {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Principal class of world
     */
    private Employee employee;

    // -----------------------------------------------------------------
    // Interface attributes
    // -----------------------------------------------------------------

    // Panel holding image
    private PanelImage panelImage;

    // Panel to show employee data
    private PanelData panelData;

    // Panel to make employee consultations
    private PanelConsultations panelConsultations;

    // Panel to execute options
    private PanelOptions panelOptions;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs a new interface initialized with the data of a particular employee.
     */
    public EmployeeInterface() {
        setTitle("Employee System");
        setSize(600, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Construct an employee
        employee = new Employee();

        // Construct the panels
        JPanel panelCentral = new JPanel();
        panelData = new PanelData(this);
        panelConsultations = new PanelConsultations(this);
        panelOptions = new PanelOptions(this);
        panelImage = new PanelImage();

        // Organize principal panel
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelImage, BorderLayout.NORTH);
        getContentPane().add(panelCentral, BorderLayout.CENTER);
        getContentPane().add(panelOptions, BorderLayout.SOUTH);

        // Organize central panel
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(panelData, BorderLayout.NORTH);
        panelCentral.add(panelConsultations, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setResizable(false);

        refresh();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Calculates employee age
    public void calculateEmployeeAge() {
        panelConsultations.updateAge(employee.getAge());
    }

    // Calculate employee work history
    public void calculateEmployeeWorkHistory()
    {
        panelConsultations.updateWorkHistory(employee.calculateWorkHistory());
    }

    // Calculate work benefits
    public void calculateEmployeeBenefits()
    {
        panelConsultations.updateBenefits(employee.calculateBenefits());
    }

    /**
     * Modifies and updates employee salary.
     */
    public void modifySalary() {
        String strSalary = JOptionPane.showInputDialog(this, "Input new salary.", "Modify salary", JOptionPane.QUESTION_MESSAGE);

        if(strSalary != null) {
            try {
                double newSalary = Double.parseDouble(strSalary);
                if(newSalary <= 0)
                    JOptionPane.showMessageDialog(this, "Salary must be > 0.", "Modify salary", JOptionPane.ERROR_MESSAGE);

                else {
                    employee.changeSalary(newSalary);
                    panelData.updateSalary(employee.getSalary());
                }
            }
            catch(NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Salary must be a number.", "Modify salary", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Updates current employee data
     */
    private void refresh() {
        String name, lastName, gender, dateOfEntry, dateOfBirth, image;
        double salary;

        name = employee.getName();
        lastName = employee.getLastName();

        int iGender = employee.getGender();
        if(iGender == 1)
            gender = "Male";
        else
            gender = "Female";

        dateOfEntry = employee.getDateOfEntry();
        dateOfBirth = employee.getDateOfBirth();
        salary = employee.getSalary();
        image = employee.getImage();

        panelData.updateFields(name, lastName, gender, dateOfEntry, dateOfBirth, image);
        panelData.updateSalary(salary);

        panelConsultations.clearFields();

        validate();
    }

    /**
     * Changes employee 
     * pName: New employee name. pName != "" && pName != null.
     * pLastName: New employee last name. pLastName != "" && pLastName != null.
     * pGender: New employee gender pGender == 1 && pGender == 0.
     * pDateOfBirth: New employee date of birth. pDateOfBirth != null.
     * pDateOfEntry: New employee date of entry. pDateOfEntry != null.
     * pSalary: New employee salary. pSalary > 0.
     * pImage: New employee image. pImage != null && pImage != "".
     */
    public void changeEmployee(String pName, String pLastName, int pGender, DateInfo pDateOfBirth,
                               DateInfo pDateOfEntry, int pSalary, String pImage) {
        employee = new Employee();
        employee.changeEmployee(pName, pLastName, pGender, pDateOfBirth, pDateOfEntry, pSalary, pImage);
        refresh();
    }

    /**
     * Show dialog to change employee
     */
    public void showDialogToChangeEmployee() {
        DialogChangeEmployee dialog = new DialogChangeEmployee(this);
        dialog.setVisible(true);
    }

    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    /**
     * Method for extension 1
     */
    public void reqFuncOption1() {
        String response = employee.method1();
        refresh();
        JOptionPane.showMessageDialog(this, response, "Response", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Method for extension 1
     */
    public void reqFuncOption2() {
        String response = employee.method2();
        refresh();
        JOptionPane.showMessageDialog(this, response, "Response", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Executes the application
     */
    public static void main(String[] pArgs) {
        try {
            // Unifies interface for Mac and Windows
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            EmployeeInterface userInterface = new EmployeeInterface();
            userInterface.setVisible(true);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}