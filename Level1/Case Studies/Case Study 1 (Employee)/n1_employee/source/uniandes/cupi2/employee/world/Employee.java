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
package uniandes.cupi2.employee.world;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class that represents an employee
 */
public class Employee {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Employee's name
    private String name;

    // Employee's last name
    private String lastName;

    /**
     * Employee's gender
     * 0 indicates male
     * 1 indicates female
     */
    private int gender;

    // Employee's date of birth
    private DateInfo dateOfBirth;

    // Employee's date of entry
    private DateInfo dateOfEntry;

    // Image path
    private String image;

    // Employee's salary
    private double salary;

    // Employee's number pf children
    private int numberOfChildren;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

  // Constructs the employee and initializes him with default values
    public Employee() {
        name = "Andres";
        lastName = "Ortiz";
        gender = 1;
        dateOfBirth = new DateInfo(10, 7, 1993);
        dateOfEntry = new DateInfo(5, 10, 2017);
        image = "employee1.png";
        salary = 1800000;
        numberOfChildren = 2;
    }


    public int getNumberOfChildren() {return numberOfChildren; }

    public double calculateEducationalAid(double pPercent) {
        return numberOfChildren * salary * pPercent/100;
    }

    public double getSalaryDifference(Employee pEmployee) {
        double employeeSalary = pEmployee.getSalary();
        double salaryDifference = salary - employeeSalary;
            if(salaryDifference < 0){
                double temp = employeeSalary;
                employeeSalary = salary;
                salary = temp;
                salaryDifference = salary - employeeSalary;
            }

        return salaryDifference;
    }



    // Returns employee name
    public String getName() {return name; }

    // Returns employee gender
    public int getGender() {return gender; }

    // Returns employee date of birth
    public String getDateOfBirth() {
        return dateOfBirth.dateToString();
    }

    // Returns employee date of entry
    public String getDateOfEntry() { return dateOfEntry.dateToString(); }

    // Returns image path of the employee
    public String getImage() {return image; }

    // Returns employee salary
    public double getSalary() {return salary; }

    // Returns employee last name
    public String getLastName() {return lastName; }

    // Returns employee age
    public int getAge() {
        DateInfo today = getCurrentDate();
        return dateOfBirth.getDifferenceInMonths(today) / 12;
    }

    // Returns employee work history
    public int calculateWorkHistory() {
        DateInfo today = getCurrentDate();
        return dateOfEntry.getDifferenceInMonths(today) / 12;
    }

    /**
     * Returns employee benefits using the formula: p = (wh * s)/12
     * The work history that is used is in years, so if an employee has laboured less than 1 year in the company his
     * benefits will be = 0.
     */
    public double calculateBenefits() {
        int workHistory = calculateWorkHistory();

        return workHistory * salary / 12.0;
    }

    /**
     * Changes the information of the employee with the values given iby the parameters
     * pName: Employee's name. pName != null && pName != "".
     * pLastName: Employee's last name. pLastName != null && pLastName != "".
     * pGender: Employee's gender. pGender == 1 || pGender == 0.
     * pDateOfBirth: Employee's date of birth. pDateOfBirth != null.
     * pDateOfEntry: Employee's date of entry. pDateOfEntry != null.
     * pSalary: Employee's salary. pSalary > 0.
     * pImage: Employee's image path. pImage != null && pImage != "".
     */
    public void changeEmployee(String pName, String pLastName, int pGender, DateInfo pDateOfBirth, DateInfo pDateOfEntry,
                                 int pSalary, String pImage) {
        name = pName;
        lastName = pLastName;
        gender = pGender;
        dateOfBirth = pDateOfBirth;
        dateOfEntry = pDateOfEntry;
        salary = pSalary;
        image = pImage;
    }

    /**
     * Changes the employee's salary with the value given by the parameter.
     * pSalary: Employee's new salary. pSalary > 0.
     */
    public void changeSalary(double pSalary) {salary = pSalary; }

    // Returns current date
    public DateInfo getCurrentDate() {
        GregorianCalendar gc = new GregorianCalendar();

        int day = gc.get(Calendar.DAY_OF_MONTH);
        int month = gc.get(Calendar.MONTH) + 1;
        int year = gc.get(Calendar.YEAR);

        return new DateInfo(day, month, year);
    }

    public double calculateSalaryDifference(Employee pEmployee){

        return salary - pEmployee.getSalary();
    }


    public void printEmployee() {
        String sGender;
        if(gender == 0)
             sGender = "Male";
        else
            sGender = "Female";

        System.out.println("+--------------+ \n" +
                           "|User Name     | " + name + " " + lastName + "\n" +
                           "+--------------+ \n" +
                           "|Gender        | " + sGender + "\n" +
                           "+--------------+ \n" +
                           "|Date of Birth | " + dateOfBirth.dateToString() + "\n" +
                           "+--------------+ \n" +
                           "|Date of Entry | " + dateOfEntry.dateToString() + "\n" +
                           "+--------------+ \n" +
                           "|Salary        | $" + salary + " COP \n" +
                           "+--------------+ \n");

    }


    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    /**
     * Method for extension 1
     */
    public String method1()
    {
        return "Response 1";
    }

    /**
     * Method for extension 2
     */
    public String method2()
    {
        return "Response 2";
    }

}