/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- phone lines
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.phoneLines.mundo;

/**
 * Class that represents the company
 */
public class Company {

    //-----------------------------------------------------------------
    //Attributes
    //-----------------------------------------------------------------

    /**
     * Phone line telephone numbers
     */
    private PhoneLine line1;
    private PhoneLine line2;
    private PhoneLine line3;

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    //Initialize phone lines of the company
    public Company() {
        line1 = new PhoneLine();
        line2 = new PhoneLine();
        line3 = new PhoneLine();

    }

    //Return line 1
    public PhoneLine getLine1() {return line1; }

    //Return line 2
    public PhoneLine getLine2() {return line2; }

    //Return line 2
    public PhoneLine getLine3() {return line3; }

    //Returns total number of calls
	public int getTotalNumberOfCalls() {
        return line1.getNumberOfCalls() + line2.getNumberOfCalls() + line3.getNumberOfCalls();
	}

	//Returns total minutes consumed
	public int getTotalMinutes() {
        return line1.getNumberOfMinutes() + line2.getNumberOfMinutes() + line3.getNumberOfMinutes();
	}

	//Returns total cost of calls
	public double getTotalCostOfCalls() {
        return line1.getCostOfCalls() + line2.getCostOfCalls() + line3.getCostOfCalls();
	}

	//Returns average cost per minute
	public double getAverageCostPerMinute() {
        return getTotalCostOfCalls() /getTotalMinutes();

	}

	//Adds a local call to line1
    public void addLocalCallLine1(int pMinutes) {
        line1.addLocalCall(pMinutes);
    }

    //Adds a local call to line2
    public void addLocalCallLine2(int pMinutes) {
        line2.addLocalCall(pMinutes);
    }

    //Adds a local call to line3
    public void addLocalCallLine3(int pMinutes) {
        line3.addLocalCall(pMinutes);
    }

    //Adds a long-distance call to line1
    public void addLongDistanceLine1(int pMinutes) {
    	line1.addLongDistance(pMinutes);
    }

    //Adds a long-distance call to line2
    public void addLongDistanceLine2(int pMinutes) {
        line2.addLongDistance(pMinutes);
    }

    //Adds a long-distance call to line3
    public void addLongDistanceLine3(int pMinutes) {
        line3.addLongDistance(pMinutes);
    }

    //Adds a cellphone call to line1
    public void addCellCallLine1(int pMinutes) {
    	line1.addCellCall(pMinutes);
    }

    //Adds a cellphone call to line2
    public void addCellCallLine2(int pMinutes) {
        line2.addCellCall(pMinutes);
    }

    //Adds a cellphone call to line3
    public void addCellCallLine3(int pMinutes) {
        line3.addCellCall(pMinutes);
    }

    //Resets all phone lines
    public void reset() {
        line1.reset();
        line2.reset();
        line3.reset();

    }

    //-----------------------------------------------------------------
    //Extension Points
    //-----------------------------------------------------------------

    //Method for extension 1
    public String metodo1() {
        return "Response 1";
    }

    //Method for extension 1
    public String metodo2() {
        return "Response 2";
    }

}
