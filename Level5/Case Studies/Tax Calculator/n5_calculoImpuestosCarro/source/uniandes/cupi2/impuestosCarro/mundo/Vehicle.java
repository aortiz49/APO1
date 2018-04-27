/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n4_Album
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.impuestosCarro.mundo;

/**
 * Class that represents a vehicle.
 */
public class Vehicle {
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Name of the line.
	 */
	private String line;
	
	/**
	 * Name of the brand.
	 */
	private String brand;
	
	/**
	 * Year of the model.
	 */
	private String year;
	
	/**
	 * Price of the vehicle of this model..
	 */
	private double price;
	
	/**
	 * Image path of the vehicle.
	 */
	private String imagePath;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Creates a new vehicle with the information given by the parameter. <br>
	 * <b> post: </b> The brand, line, year, price, and image path were initialized with the
	 * given values.
	 *
	 * @param pLine      Name of the line. pLine != null &amp;&amp; pLine != "".
	 * @param pBrand     Name of the brand. pBrand != null &amp;&amp; pBrand != "".
	 * @param pYear      Year of the model. pYear &gt; 0.
	 * @param pPrice     Price of the model. pPrice &gt; 0.
	 * @param pImagePath ImagePath of the vehicle. pImagePath != null &amp;&amp; pImagePath != "".
	 */
	public Vehicle(String pBrand, String pLine, String pYear, double pPrice, String pImagePath) {
		brand = pBrand;
		line = pLine;
		year = pYear;
		price = pPrice;
		imagePath = pImagePath;
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns the name of the line.
	 *
	 * @return Name of the line.
	 */
	public String getLine() {
		return line;
	}
	
	/**
	 * Returns the name of the  brand.
	 *
	 * @return Name of the brand.
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Returns the year of the model.
	 *
	 * @return Year.
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Returns the price of the model.
	 *
	 * @return Price.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Returns the image path of the vehicle.
	 *
	 * @return ImagePath of the vehicle.
	 */
	public String getImagePath() {
		return imagePath;
	}
}
