/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- employee
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.employee.world;

// Class to represent a date
public class DateInfo {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Date day, month, and year
    private int day;
    private int month;
    private int year;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Construct a date with the values given by the parameters
     * pDay: Date's day. pDay > 0 && pDay <= 31. (valid depending on the month)
     * pMonth: Date's month. pMonth > 0 && pMonth <= 12.
     * pYear: Date's year. pYear > 0.
     */
    public DateInfo(int pDay, int pMonth, int pYear) {
        day = pDay;
        month = pMonth;
        year = pYear;
    }

    // Returns the day
    public int getDay() {
        return day;
    }

    // Returns the month
    public int getMonth() {
        return month;
    }

    // Returns the year
    public int getYear() {
        return year;
    }

    /**
     * Returns the difference in months between two dates
     * pDate: Date that is being compared to. pDate != null.
     */
    public int getDifferenceInMonths(DateInfo pDate) {
        int difference = 0;

        int tempYear = pDate.getYear();
        int tempMonth = pDate.getMonth();
        int tempDay = pDate.getDay();

        // Calculate the difference in months
        difference = 12 * (tempYear - year) + (tempMonth - month);

        // If the day is not greater, subtract one month.
        if (tempDay < day) {
            difference--;
        }
        return difference;
    }

    /**
     * Return a string that represents the date.
     */
    public String dateToString() {
        String tempDay = Integer.toString(day);
        String tempMonth = Integer.toString(month);
        if (day < 10) tempDay = "0" + Integer.toString(day);
        if (month < 10) tempMonth = "0" + Integer.toString(month);


        return tempDay + "-" + tempMonth + "-" + year;
    }


}
