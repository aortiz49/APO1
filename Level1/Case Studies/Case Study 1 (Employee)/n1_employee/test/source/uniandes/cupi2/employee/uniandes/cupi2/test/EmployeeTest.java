/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- employee
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.test;

import org.junit.Test;
import uniandes.cupi2.employee.world.DateInfo;
import uniandes.cupi2.employee.world.Employee;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertEquals;

/**
 * Class used to verify the methods in Employee class
 */
public class EmployeeTest {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Class used for tests
     */
    private Employee employee1;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Test 1: Constructs a new employee.
     */
    private void setupTest1() {
        employee1 = new Employee();
    }

    /**
     * Test 1: Tests employee constructor. <br>
     * <b> Methods to test: </b> <br>
     * employee<br>
     * getName<br>
     * getLastName<br>
     * getGender<br>
     * getDateOfBirth<br>
     * <b> Test cases: </b> <br>
     * 1. Employee is constructed properly.
     */
    @Test
    public void testEmployee() {

        setupTest1();
        DateInfo Date1 = new DateInfo(10, 7, 1993);

        assertEquals("The name of employee 1 is Andres", "Andres", employee1.getName());
        assertEquals("The last name of employee 1 is Ortiz", "Ortiz", employee1.getLastName());
        assertEquals("The gender of employee 1 is masculine", 1, employee1.getGender());
        assertEquals("The date of birth of employee 1 is " + Date1, Date1.dateToString(),
                     employee1.getDateOfBirth());
    }

    /**
     * Test 2: Tests salary change <br>
     * <b> Methods to test: </b> <br>
     * changeSalary<br>
     * getSalary<br>
     * <b> Test cases: </b> <br>
     * 1. Employee's salary is changed.<br>
     */
    @Test
    public void testChangeSalary() {
        setupTest1();
        int salary = 2000000;

        employee1.changeSalary(salary);
        assertEquals("The employee's salary should be " + salary, salary, employee1.getSalary(), 2);

    }

    /**
     * Test 3: Tests employee work history.<br>
     * <b> Methods to test: </b> <br>
     * calculateWorkHistory <br>
     * <b> Test cases: </b> <br>
     * 1. The employee entered on 5/10/2016.
     */
    @Test
    public void testCalculateWorkHistory() {
        setupTest1();

        GregorianCalendar gc = new GregorianCalendar();
        int day = gc.get(Calendar.DAY_OF_MONTH);
        int month = gc.get(Calendar.MONTH) + 1;
        int year = gc.get(Calendar.YEAR);
        DateInfo today = new DateInfo(day, month, year);
        DateInfo dateOfEntry = new DateInfo(5, 10, 2016);
        int workHistory = dateOfEntry.getDifferenceInMonths(today) / 12;

        assertEquals("The employee's work history is incorrect", workHistory,
                     employee1.calculateWorkHistory());
    }

    /**
     * Test 4: Tests employee benefits calculator.<br>
     * <b> Methods to test: </b> <br>
     * calculateBenefits<br>
     * calculateWorkHistory<br>
     * calculateCoordinationBonus <br>
     * getSalary<br>
     * <b> Test cases: </b> <br>
     * 1. The employee entered on 5/10/2016.
     */
    @Test
    public void testCalculateBenefits() {
        setupTest1();

        double expected = (employee1.calculateWorkHistory() * (employee1.getSalary() + employee1
                .calculateCoordinationBonus())) /12.0;
        double benefits = employee1.calculateBenefits();

        assertEquals("The calculation of employee benefits is incorrect: it was " + benefits
                             + " instead of " + expected, benefits, expected, 0);
    }
}