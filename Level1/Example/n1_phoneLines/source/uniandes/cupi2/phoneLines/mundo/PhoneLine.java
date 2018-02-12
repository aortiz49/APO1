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

//Class that represents a phone line
public class PhoneLine {

    //-----------------------------------------------------------------
    //Attributes
    //-----------------------------------------------------------------

    //Number of calls made
    private int numberOfCalls;

    //Number of minutes consumed
    private int numberOfMinutes;

    //Total cost of calls
    private double costOfCalls;

    //-----------------------------------------------------------------
    //Methods
    //-----------------------------------------------------------------

    //Initialize telephone line
    public PhoneLine() {
    	numberOfCalls = 0;
    	numberOfMinutes = 0;
    	costOfCalls = 0;
    }

    //Returns cost of calls
    public double getCostOfCalls() {
        return costOfCalls;
    }

    //Returns number of calls
    public int getNumberOfCalls() {
       return numberOfCalls;
    }

    //Returns minutes consumed
    public int getNumberOfMinutes() {
        return numberOfMinutes;
    }

    //Resets the line, setting every parameter to 0
	public void reset() {
        numberOfCalls = 0;
        numberOfMinutes = 0;
        costOfCalls = 0;
	}

	//Adds a local call to the line
    public void addLocalCall(int pMinutes) {
        //One more call
        numberOfCalls = numberOfCalls + 1;

        //Add minutes consumed
        numberOfMinutes = numberOfMinutes + pMinutes;

        //Add the cost (cost per minute: 35 pesos)
        costOfCalls = costOfCalls + (pMinutes * 35);
    }

    //Adds a long-distance call
    public void addLongDistance(int pMinutes) {
        //One more call
        numberOfCalls = numberOfCalls + 1;

        //Add minutes consumed
        numberOfMinutes = numberOfMinutes + pMinutes;

        //Add the cost (cost per minute: 35 pesos)
        costOfCalls = costOfCalls + (pMinutes * 380);
    }

    //Adds a cellphone call
    public void addCellCall(int pMinutes) {
        //One more call
        numberOfCalls = numberOfCalls + 1;

        //Add minutes consumed
        numberOfMinutes = numberOfMinutes + pMinutes;

        //Add the cost (cost per minute: 35 pesos)
        costOfCalls = costOfCalls + (pMinutes * 999);
    }

}