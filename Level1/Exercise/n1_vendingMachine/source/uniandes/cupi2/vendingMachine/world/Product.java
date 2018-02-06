/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- vendingMachine
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.vendingMachine.world;

/**
 * Represents a product from vending machine
 */
public class Product {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    
    // Identifier of product
    private String identifier;

    // Name of product
    private String name;

    // Price of product
    private double price;

    // Quantity of units available
    private int quantityOfUnitsAvailable;

    // Quantity of units sold
    private int quantityOfUnitsSold;
    
    // Calories of product in kcal
    private double calories;
    
    // Weight of product in grams
    private double weight;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates a product using the information received by parameter.
     * pIdentifier != null && pIdentifier != "".
     * pName != null && pName != ""
     * pPrice >= 50.
     */
    public Product(String pIdentifier, String pName, double pPrice, double pCalories, double pWeight) {

        identifier = pIdentifier;
        name = pName;
        price = pPrice;
        quantityOfUnitsAvailable = 0;
        quantityOfUnitsSold = 0;
        calories = pCalories;
        weight = pWeight;
        

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Returns product identifier
    public String getIdentifier() {
        return identifier;
    }

    // Returns name of product
    public String getName() {
        return name;
    }

    // Return price of product
    public double getPrice() {
        return price;
    }
    
    // Return calories of product
    public double getCalories() {return calories;}
    
    // Return weight
    public double getWeight() {return weight;}

    // Returns quantity of units available
    public int getQuantityOfUnitsAvailable() {
        return quantityOfUnitsAvailable;
    }

    // Returns quantity of units sold
    public int getQuantityOfUnitsSold() {
        return quantityOfUnitsSold;
    }
    
    // Changes the amount of calories of a product
    public void changeCalories(double pCalories) {
    	calories = pCalories;
    }

    // Calculates calories  
    public double calculateCaloriesPerUnit() {
    	return calories / weight;
    }
    
    
    
    
    /**
     * Increases the quantity of units available according to the units received by parameter.
     */
    public void restock(int pUnits) {
        quantityOfUnitsAvailable += pUnits;
    }

    /**
     * Sells one unit of the product
     * Quantity of available units decreases and quantity of units sold increases
     */
    public void sell() {
        quantityOfUnitsAvailable -= 1;
        quantityOfUnitsSold += 1;
    }
    
    
}
