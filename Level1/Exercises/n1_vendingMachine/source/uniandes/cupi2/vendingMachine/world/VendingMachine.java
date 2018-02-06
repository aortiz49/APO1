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
 * Represents the vending machine.
 */
public class VendingMachine {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------


    // Declare the 4 products of the vending machine
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs a new vending machine
     * 4 products are initialized.<br>
     */
    public VendingMachine() {

        product1 = new Product("A1", "Papas Natural Margarita", 1300);
        product2 = new Product("B2", "Jugo Hit", 2000);
        product3 = new Product("C3", "Chocolatina Jet", 500);
        product4 = new Product("D4", "Galletas Festival", 800);

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Returns products
    public Product getProduct1() {
        return product1;
    }

    public Product getProduct2() {
        return product2;
    }

    public Product getProduct3() {
        return product3;
    }

    public Product getProduct4() {
        return product4;
    }

    /**
     * Restocks products with units received by parameter
     */
    public void restockProduct1(int pUnidades) {
        product1.restock(pUnidades);
    }

    public void restockProduct2(int pUnidades) {
        product2.restock(pUnidades);
    }

    public void restockProduct3(int pUnidades) {
        product3.restock(pUnidades);
    }

    public void restockProduct4(int pUnidades) {
        product4.restock(pUnidades);
    }

    /**
     * Sells one unit of the product
     */
    public void sellProduct1() {
        product1.sell();
    }

    public void sellProduct2() {
        product2.sell();
    }

    public void sellProduct3() {
        product3.sell();
    }

    public void sellProduct4() {
        product4.sell();
    }


    /**
     * Calculate the total quantity of sales from the vending machine.
     */
    public int getQuantityOfTotalSales() {

        int totalQuantityOfSales = product1.getQuantityOfUnitsSold() + product2.getQuantityOfUnitsSold() +
                product3.getQuantityOfUnitsSold() + product4.getQuantityOfUnitsSold();

        return totalQuantityOfSales;

    }

    /**
     * Calculate the total value of sales from the vending machine.
     */
    public double getValueOfTotalSales() {
        double totalValueOfSales = (product1.getQuantityOfUnitsSold() * 1300) + (product2.getQuantityOfUnitsSold() * 2000) +
                (product3.getQuantityOfUnitsSold() * 500) + (product4.getQuantityOfUnitsSold() * 800);

        return totalValueOfSales;
    }


    /**
     * Calculate the percentage of product availability in the machine
     */
    public double getPercentOfAvailability(int pMaximumCapacity) {
        double percentOfAvailability = 100 - (product1.getQuantityOfUnitsAvailable() + product2.getQuantityOfUnitsAvailable()
                + product3.getQuantityOfUnitsAvailable() + product4.getQuantityOfUnitsAvailable()) * (100.0 / pMaximumCapacity);

        return percentOfAvailability;

    }


    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    /**
     * Extension 1.
     */
    public String method1() {
        return "Response 1";
    }

    /**
     * Extension 2.
     */
    public String method2() {
        return "Response 2";
    }
}
