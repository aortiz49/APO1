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

import static junit.framework.TestCase.assertEquals;

/**
 * Class used to verify
 */
public class DateTest {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Date 1 of test
     */
    private DateInfo Date1;

    /**
     * Date 2 of test
     */
    private DateInfo Date2;

    /**
     * Date 3 of test
     */
    private DateInfo Date3;

    /**
     * Date 4 of test
     */
    private DateInfo Date4;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Test 1: Constructs the 4 dates.
     */
    private void setupTest1() {
        Date1 = new DateInfo(14, 11, 1982);
        Date2 = new DateInfo(15, 11, 1983);
        Date3 = new DateInfo(15, 12, 1982);
        Date4 = new DateInfo(14, 10, 1984);
    }

    /**
     * Test 1: Tests date constructor.<br>
     * <b> Methods to test: </b> <br>
     * dateInfo<br>
     * getDay<br>
     * getMonth<br>
     * getYear<br>
     * <b> Test case: </b> <br>
     * 1. DateInfo is constructed properly.
     */
    @Test
    public void testDateInfo() {
        setupTest1();

        assertEquals("The day of Date is not correct.", 14, Date1.getDay());
        assertEquals("The month of Date is not correct.", 11, Date1.getMonth());
        assertEquals("The year of Date is not correct.", 1982, Date1.getYear());

        assertEquals("The day of Date is not correct.", 15, Date2.getDay());
        assertEquals("The month of Date is not correct.", 11, Date2.getMonth());
        assertEquals("The year of Date is not correct.", 1983, Date2.getYear());

        assertEquals("The month of Date is not correct.", 12, Date3.getMonth());
        assertEquals("The year of Date is not correct.", 1982, Date3.getYear());

    }

    /**
     * Test 2: Tests method that calculates difference in months. <br>
     * <b> Methods to test: </b> <br>
     * getDifferenceInMonths<br>
     * <b> Test cases: </b> <br>
     * 1. The two dates have a 12-month difference. <br>
     * 2. The two dates have a 1-month difference. <br>
     * 3. The two dates have a 23-month difference <br>
     */
    @Test
    public void testGetDifferenceInMonths() {
        setupTest1();

        assertEquals("The difference in months between  " + Date1 + " and " + Date2
                             + " should be 12 months", 12, Date1.getDifferenceInMonths(Date2));
        assertEquals("The difference in months between  " + Date1 + " and " + Date3 + " should be"
                             + " 1 month", 1, Date1.getDifferenceInMonths(Date3));
        assertEquals("The difference in months between  " + Date1 + " and " + Date4
                             + " should be 23 months", 23, Date1.getDifferenceInMonths(Date4));

    }
}
