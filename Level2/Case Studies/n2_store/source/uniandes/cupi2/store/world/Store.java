/**
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

import uniandes.cupi2.store.world.Product.Types;

// Store has 4 products
public class Store {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Products in store
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    // Total cash received in sales
    private double moneyInRegister;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    // Creates store with 4 products
    public Store() {
        product1 = new Product(Types.STATIONERY, "Pencil", 550.0, 18, 5, "pencil.png");
        product2 = new Product(Types.PHARMACY, "Aspirin", 109.5, 25, 8, "aspirin.png");
        product3 = new Product(Types.STATIONERY, "Eraser", 207.3, 30, 10, "eraser.png");
        product4 = new Product(Types.SUPERMARKET, "Bread", 150.0, 15, 20, "bread.png");
        moneyInRegister = 0;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Returns product 1
    public Product getProduct1() {
        return product1;
    }

    // Returns product 2
    public Product getProduct2() {
        return product2;
    }

    // Returns product 2
    public Product getProduct3() {
        return product3;
    }

    // Returns product 3
    public Product getProduct4() {
        return product4;
    }

    // Returns cash in register
    public double getMoneyInRegister() {
        return moneyInRegister;
    }


    /**
     * Returns the product with the name given by parameter.
     * pName: Name of product searched. pName != null && pName != "".
     * return: Product with name given by parameter, null if not found.
     */
    public Product getProduct(String pName) {
        Product searched = null;

        if (product1.getName().equals(pName))
            searched = product1;

        else if (product2.getName().equals(pName))
            searched = product2;

        else if (product3.getName().equals(pName))
            searched = product3;

        else if (product4.getName().equals(pName))
            searched = product4;

        return searched;

    }

    /**
     * Returns the average of sales.
     * returns: Average amount of cash obtained per unit of product sold.
     */
    public double getAverageOfSales() {
        double response = 0.0;
        double totalUnitsSold = product1.getQuantityUnitsSold() + product2.getQuantityUnitsSold() +
                product3.getQuantityUnitsSold() + product4.getQuantityUnitsSold();
        if (totalUnitsSold > 0)
            response = moneyInRegister / totalUnitsSold;
        return response;
    }

    /**
     * Returns the product with most sold units.
     * return: Product with most units sold. Null if no product has units sold.
     */
    public Product getMostSoldProduct() {
        int sale1 = product1.getQuantityUnitsSold();
        int sale2 = product2.getQuantityUnitsSold();
        int sale3 = product3.getQuantityUnitsSold();
        int sale4 = product4.getQuantityUnitsSold();

        Product mostSold = null;
        int biggerQuantity = 0;

        if (sale1 > biggerQuantity) {
            mostSold = product1;
            biggerQuantity = sale1;
        }

        if (sale2 > biggerQuantity) {
            mostSold = product2;
            biggerQuantity = sale2;
        }

        if (sale3 > biggerQuantity) {
            mostSold = product3;
            biggerQuantity = sale3;
        }

        if (sale4 > biggerQuantity) {
            mostSold = product4;
        }

        return mostSold;
    }

    /**
     * Returns quantity with least sold units.
     * return: Product with least sold units. Null if no product has units sold.
     */
    public Product getLeastSoldProduct() {
        int sale1 = product1.getQuantityUnitsSold();
        int sale2 = product2.getQuantityUnitsSold();
        int sale3 = product3.getQuantityUnitsSold();
        int sale4 = product4.getQuantityUnitsSold();

        Product leastSold = null;

        if (sale1 > 0 || sale2 > 0 || sale3 > 0 || sale4 > 0) {
            if (sale1 <= sale2 && sale1 <= sale3 && sale1 <= sale4)
                leastSold = product1;

            else if (sale2 <= sale1 && sale2 <= sale3 && sale2 <= sale4)
                leastSold = product2;

            else if (sale3 <= sale2 && sale3 <= sale1 && sale3 <= sale4)
                leastSold = product3;
            else
                leastSold = product4;
        }

        return leastSold;
    }

    /**
     * Sells the quantity of units of a product in the store given by the product and name parameters.
     * Decreases the quantity of units of the product given, and updates the amount of cash in the register.
     * pProductName: Name of product to sell. pProductName != null && pProductName != "".
     * pQuantity: Quantity of units to sell. pQuantity > 0.
     * return: Quantity of units that were sold.
     */


    public int sellProduct(String pProductName, int pQuantity) {
        int quantitySold = 0;
        Product productTest = getProduct(pProductName);
        quantitySold = productTest.sell(pQuantity);
        moneyInRegister += quantitySold * productTest.calculateFinalPrice();

        return quantitySold;
    }

    /**
     * Restocks the quantity of units of a product in the store given by the product and name parameters.
     * Decreases the quantity of units of the product given.
     * pProductName: Name of product to restock. pProductName != null && pProductName != "".
     * pQuantity: Quantity of units to restock. quantity >= 0.
     * return: Returns true if restock was possible, false if contrary.
     */
    public boolean restockProduct(String pProductName, int pQuantity) {
        boolean restock = false;
        Product product = getProduct(pProductName);

        if (product.canRestock()) {
            product.restock(pQuantity);
            restock = true;
        }

        return restock;
    }

    /**
     * Changes the product attributes with values given by parameters.
     * pCurrentName: Current name of product. pCurrentName != null && pCurrentName != "".
     * pNewName: New name of product. pNewName != null && pNewName != "".
     * pType: Type of product. pType != null.
     * pUnitValue: Unit value of product
     * pStockQuantity: Quantity of product in stock. pStockQuantity >= 0.
     * pMinimumQuantity: Minimum quantity of product in stock to make order. pMinimumQuantity > 0.
     * pImagePath: Image path. pImagePath != null && pImagePath != "".
     * return: Returns true if the product change was successful, false if a product already exists with that name.
     */
    public boolean changeProduct(String pCurrentName, String pNewName, Types pType, double pUnitValue,
                                 int pStockQuantity, int pMinimumQuantity, String pImagePath) {
        boolean change = false;
        if (pCurrentName.equals(pNewName) || getProduct(pNewName) == null) {

            if (product1.getName().equals(pCurrentName))
                product1 = new Product(pType, pNewName, pUnitValue, pStockQuantity, pMinimumQuantity, pImagePath);

            else if (product2.getName().equals(pCurrentName))
                product2 = new Product(pType, pNewName, pUnitValue, pStockQuantity, pMinimumQuantity, pImagePath);

            else if (product3.getName().equals(pCurrentName))
                product3 = new Product(pType, pNewName, pUnitValue, pStockQuantity, pMinimumQuantity, pImagePath);

            else if (product4.getName().equals(pCurrentName))
                product4 = new Product(pType, pNewName, pUnitValue, pStockQuantity, pMinimumQuantity, pImagePath);

            change = true;
        }
        return change;
    }


    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    // Method for extension 1
    public String method1() {
        return "Response 1";
    }

    // Method for extension 1
    public String method2() {
        return "Response 2";
    }


    private static boolean canLoad(double pLoadWeight) {
        boolean canLoad = false;
        if(pLoadWeight <= capacity) {
            load = pLoadWeight;
            canLoad = true;
        }

        return canLoad;
    }


    private static boolean loadTruck(String pPlates, int pLoadWeight) {
        boolean truckLoaded = false;
        if(truck1.getPlates().equals(pPlates) && canLoad()) {
            load = pLoadWeight;
            truckLoaded = true
        }
        else if(truck2.getPlates().equals(pPlates) && canLoad()) {
            load = pLoadWeight;
            truckLoaded = true
        }
        else if(truck3.getPlates().equals(pPlates) && canLoad()) {
            load = pLoadWeight;
            truckLoaded = true
        }
        else if(truck4.getPlates().equals(pPlates) && canLoad()) {
            load = pLoadWeight;
            truckLoaded = true
        }
            

            


    
    }

























}