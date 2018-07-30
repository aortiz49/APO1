/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
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

    // Employee's number of children
    private int numberOfChildren;

    // Number of subordinates
    private int numberOfSubordinates;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Constructs the employee and initializes him with default values.
    public Employee() {
        name = "Andres";
        lastName = "Ortiz";
        gender = 1;
        dateOfBirth = new DateInfo(10, 7, 1993);
        dateOfEntry = new DateInfo(5, 10, 2016);
        image = "employee1.png";
        salary = 1800000;
        numberOfChildren = 2;
        numberOfSubordinates = 3;
    }

    /**
     * Returns the number of children the employee has.
     *
     * @return The number of children of the employee.
     */
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    /**
     * Returns the number of subordinates the employee has.
     *
     * @return The number of subordinates of the employee.
     */
    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    /**
     * Sets the number of subordinates that an employee has. <br>
     * <b>post: </b> Number of subordinates is set with value given by parameter.
     *
     * @param pNumberOfSubordinates The number of subordinates. pNumberOfSubordinates &gt;= 0.
     */
    public void setNumberOfSubordinates(int pNumberOfSubordinates) {
        numberOfSubordinates = pNumberOfSubordinates;
    }

    /**
     * Calculates the amount of money the employee receives for educational aid of his children
     * set at 5% of his income per child.
     *
     * @return The amount of money in educational aid.
     */
    public double calculateChildEducationalAid() {
        return numberOfChildren * salary * 0.05;
    }

    /**
     * Calculates the amount of money the employee receives for educational aid of his children
     * set at the percentage given by the parameter.
     *
     * @param pPercentage The percentage of employee's income. pPercentage &gt;= 0;
     * @return The amount of money in educational aid.
     */
    public double calculateChildEducationalAidPercent(double pPercentage) {
        return numberOfChildren * salary * pPercentage / 100.0;
    }

    /**
     * Calculates the difference in salary between two different employees.
     * One is given by the parameter.
     *
     * @param pEmployee The employee that is being compared. pEmployee != null.
     * @return The salary difference.
     */
    public double getSalaryDifference(Employee pEmployee) {
        double employeeSalary = pEmployee.getSalary();
        double salaryDifference = salary - employeeSalary;
        if (salaryDifference < 0) {
            double temp = employeeSalary;
            employeeSalary = salary;
            salary = temp;
            salaryDifference = salary - employeeSalary;
        }

        return salaryDifference;
    }

    /**
     * Calculates the coordination bonus of the employee. (7% of the salary x number of
     * subordinates)
     *
     * @return The coordination bonus.
     */
    public double calculateCoordinationBonus() {
        return salary * numberOfSubordinates * .07;
    }

    // Returns employee name
    public String getName() {
        return name;
    }

    // Returns employee gender
    public int getGender() {
        return gender;
    }

    // Returns employee date of birth
    public String getDateOfBirth() {
        return dateOfBirth.dateToString();
    }

    // Returns employee date of entry
    public String getDateOfEntry() {
        return dateOfEntry.dateToString();
    }

    // Returns image path of the employee
    public String getImage() {
        return image;
    }

    // Returns employee salary
    public double getSalary() {
        return salary;
    }

    // Returns employee last name
    public String getLastName() {
        return lastName;
    }

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
     * Returns employee benefits using the formula: p = (wh * sp)/12
     * The work history that is used is in years, so if an employee has laboured less than 1 year
     * in the company his benefits will be = 0.
     * sp is the salary plus coordination bonus.
     */
    public double calculateBenefits() {
        int workHistory = calculateWorkHistory();
        double salaryPlus = salary + calculateCoordinationBonus();
        return (workHistory * salaryPlus / 12.0);
    }

    /**
     * Changes the information of the employee with the values given iby the parameters
     *
     * @param pName:         Employee's name. pName != null && pName != "".
     * @param pLastName:     Employee's last name. pLastName != null && pLastName != "".
     * @param pGender:       Employee's gender. pGender == 1 || pGender == 0.
     * @param pDateOfBirth:  Employee's date of birth. pDateOfBirth != null.
     * @param pDateOfEntry:  Employee's date of entry. pDateOfEntry != null.
     * @param pSalary:       Employee's salary. pSalary > 0.
     * @param pImage:        Employee's image path. pImage != null && pImage != "".
     * @param pChildren:     Employee's children. pChildren !=null && pChildren &gt;=0;
     * @param pSubordinates: Employee's subordinates. pSubordinates !=null && pSubordinates &gt;=0;
     */
    public void changeEmployee(String pName, String pLastName, int pGender, DateInfo pDateOfBirth,
                               DateInfo pDateOfEntry, int pSalary, String pImage, int pChildren,
                               int pSubordinates) {
        name = pName;
        lastName = pLastName;
        gender = pGender;
        dateOfBirth = pDateOfBirth;
        dateOfEntry = pDateOfEntry;
        salary = pSalary;
        image = pImage;
        numberOfChildren = pChildren;
        numberOfSubordinates = pSubordinates;
    }

    /**
     * Changes the employee's salary with the value given by the parameter.
     *
     * @param pSalary: Employee's new salary. pSalary > 0.
     */
    public void changeSalary(double pSalary) {
        salary = pSalary;
    }

    // Returns current date
    public DateInfo getCurrentDate() {
        GregorianCalendar gc = new GregorianCalendar();

        int day = gc.get(Calendar.DAY_OF_MONTH);
        int month = gc.get(Calendar.MONTH) + 1;
        int year = gc.get(Calendar.YEAR);

        return new DateInfo(day, month, year);
    }

    public double calculateSalaryDifference(Employee pEmployee) {

        return salary - pEmployee.getSalary();
    }


    public void printEmployee() {
        String sGender;
        if (gender == 0) sGender = "Male";
        else sGender = "Female";

        System.out.println(
                "+--------------+ \n" + "|User Name     | " + name + " " + lastName + "\n"
                        + "+--------------+ \n" + "|Gender        | " + sGender + "\n"
                        + "+--------------+ \n" + "|Date of Birth | " + dateOfBirth.dateToString()
                        + "\n" + "+--------------+ \n" + "|Date of Entry | " + dateOfEntry
                        .dateToString() + "\n" + "+--------------+ \n" + "|Salary        | $"
                        + salary + " COP \n" + "+--------------+ \n");

    }


    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    /**
     * Method for extension 1
     */
    public String method1() {
        return "Response 1";
    }

    /**
     * Method for extension 2
     */
    public String method2() {
        return "Response 2";
    }

}