/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n4_socialClub
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.club.world;

/**
 * Class that models a bill in the club.
 */
public class Bill {
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Description of consumption generated by bill.
	 */
	private String invoice;
	
	/**
	 * The value of consumption generated by bill.
	 */
	private double value;
	
	/**
	 * Name of person on bill.
	 */
	private String name;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs a bill object associated to an invoice of a member or authorizedUsers individual.
	 * <b>post: <b> Attributes were initialized with values given by the parameter.
	 *
	 * @param pName    Name of the person that made the purchase. pName != null && pName != "".
	 * @param pInvoice Invoice of consumption. pInvoice != null && pInvoice != "".
	 * @param pValue   Value of consumption. pValue >0.
	 */
	public Bill(String pName, String pInvoice, double pValue) {
		name = pName;
		invoice = pInvoice;
		value = pValue;
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns the invoice of the bill. <br>
	 *
	 * @return The invoice of the bill.
	 */
	public String getInvoice() {
		return invoice;
	}
	
	/**
	 * Return the value of the bill. <br>
	 *
	 * @return The value of the bill.
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Returns the name of the person who made the consumption that generated the bill. <br>
	 *
	 * @return The name on the bill.
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Return string that represents the bill.
	 *
	 * @return A string of characters with the bill information in the following format:
	 * <invoice> $<value> (<name>).
	 */
	public String toString() {
		return invoice + "    $" + value + "    (" + name + ")";
		
	}
}