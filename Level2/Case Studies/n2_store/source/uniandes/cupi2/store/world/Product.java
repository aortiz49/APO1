/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n2_store
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.store.world;

// Product of the store
public class Product {
    // -----------------------------------------------------------------
    // Enums
    // -----------------------------------------------------------------

    /**
     * Enums for the different types of products
     */
    public enum Types {

        // Represents the type for stationery
        STATIONERY,

        // Represents the type for supermarket
        SUPERMARKET,

        // Represents the type for pharmacy
        PHARMACY
    }

    //------------------------------------------------------------------
    // Constants
    //------------------------------------------------------------------


    /**
     * Represent the tax associated with each product.
     */
    private final static double TAX_STATIONERY = 0.16;
    private final static double TAX_SUPERMARKET = 0.04;
    private final static double TAX_PHARMACY = 0.12;

    //------------------------------------------------------------------
    // Attributes
    //------------------------------------------------------------------

    // Name of product
    private String name;

    // Type of product
    private Types type;

    // Unit value of product
    private double unitValue;

    // Quantity of units in stock
    private int stockQuantity;

    // Minimum quantity in stock to be able to make an order
    private int minimumQuantity;

    // Quantity of units sold 
    private int quantityUnitsSold;

    // Image path
    private String imagePath;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates a product with values given by the parameters.
     * pType: Type of product. pType != null.
     * pName: Name of product. pName != null && pName != "".
     * pUnitValue: Unit value of product. pUnitValue >= 0.
     * pStockQuantity: Initial quantity in stock. pStockQuantity >= 0.
     * pMinimumQuantity: Minimum quantity there needs to be in stock. pMinimumQuantity >= 0.
     * pImagePath: Image path of product. pImagePath != null && pImagePath != "".
     */
    public Product(Types pType, String pName, double punitValue, int pStockQuantity, int pMinimumQuantity, String pImagePath) {
        type = pType;
        name = pName;
        unitValue = punitValue;
        stockQuantity = pStockQuantity;
        minimumQuantity = pMinimumQuantity;
        imagePath = pImagePath;
        quantityUnitsSold = 0;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Returns the name of the product
    public String getName() {
        return name;
    }

    // Returns type of product
    public Types getType() {
        return type;
    }

    // Returns unit value of product
    public double getUnitValue() {
        return unitValue;
    }

    // Returns stock quantity
    public int getStockQuantity() {
        return stockQuantity;
    }

    // Returns minimum quantity
    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    // Returns quantities sold
    public int getQuantityUnitsSold() {
        return quantityUnitsSold;
    }

    // Returns image path
    public String getImagePath() {
        return imagePath;
    }

    // Calculates final product value including tax. el valor final del product, incluyendo los impuestos.
    public double calculateFinalPrice() {
        return unitValue + unitValue * getTax();
    }

    // Return corresponding tax for each product
    private double getTax() {
        double iva = 0;
        switch (type) {
            case STATIONERY: {
                iva = TAX_STATIONERY;
                break;
            }
            case SUPERMARKET: {
                iva = TAX_SUPERMARKET;
                break;
            }
            case PHARMACY: {
                iva = TAX_PHARMACY;
                break;
            }

        }

        return iva;
    }

    /**
     * Sells quantity of units given by parameter.
     * Decreases number of units of product in stock.
     * pQuantity: Quantity of units to sell. pQuantity > 0.
     * return: Quantity that was sold according to the availability in stock
     */
    public int sell(int pQuantity) {
        int quantitySold;
        if (pQuantity > stockQuantity) {
            quantitySold = stockQuantity;
            stockQuantity = 0;
        } else {
            stockQuantity -= pQuantity;
            quantitySold = pQuantity;
        }

        quantityUnitsSold += quantitySold;

        return quantitySold;
    }

    /*
        Restocks the quantity of units given by the parameter.
        Increases the quantity of units pf product in stock.
        pQuantity: Quantity of units to restock. pQuantity >= 0.
     */
    public void restock(int pQuantity) {
        stockQuantity += pQuantity;
    }

    /*
        Indicates if it is possible to restock the units of product.
        return: True if the quantity in stock is less than the minimum amount
              False if contrary
     */
    public boolean canRestock() {
        boolean response = false;
        if (stockQuantity < minimumQuantity)
            response = true;

        return response;
    }

    /*
        Indicates if it is possible to restock the units of product.
        return: True if the quantity in stock is less than the minimum amount
              False if contrary
     */
    public void increaseunitValue() {
        if (unitValue < 1000)
            unitValue *= 1.01;
        else if (unitValue <= 5000)
            unitValue *= 1.02;
        else
            unitValue *= 1.03;
    }

    /*
        Receives an order, only if the quantity in stock has less units than the one indicated
        by the minimum amount.

     */
    public void createOrder(int pQuantity) {
        if (stockQuantity < minimumQuantity)
            restock(pQuantity);

    }

    public void changeunitValue(Types pType) {
        if (pType.equals(Types.PHARMACY) || pType.equals(Types.STATIONERY))
            unitValue *= 0.9;
        else
            unitValue *= 1.05;

    }


}