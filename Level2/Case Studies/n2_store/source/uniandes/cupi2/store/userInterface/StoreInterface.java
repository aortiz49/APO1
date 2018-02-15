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
package uniandes.cupi2.store.userInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.store.world.Product.Types;
import uniandes.cupi2.store.world.Store;

// Principal window of the application
public class StoreInterface extends JFrame {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Principal class of world
    private Store store;

    // -----------------------------------------------------------------
    // Attributes of the interface
    // -----------------------------------------------------------------

    // Panel with title image
    private ImagePanel imagePanel;

    // Panel with options
    private OptionsPanel optionsPanel;

    // Panel to show products
    private ProductPanel productPanel1;
    private ProductPanel productPanel2;
    private ProductPanel productPanel3;
    private ProductPanel productPanel4;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs main application window
     */
    public StoreInterface() {
        setTitle("Cupi2 Store");
        setSize(800, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        store = new Store();

        setLayout(new BorderLayout());

        imagePanel = new ImagePanel();
        add(imagePanel, BorderLayout.NORTH);

        optionsPanel = new OptionsPanel(this);
        add(optionsPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2));

        productPanel1 = new ProductPanel(this);
        centerPanel.add(productPanel1);
        productPanel2 = new ProductPanel(this);
        centerPanel.add(productPanel2);
        productPanel3 = new ProductPanel(this);
        centerPanel.add(productPanel3);
        productPanel4 = new ProductPanel(this);
        centerPanel.add(productPanel4);

        add(centerPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setResizable(false);

        update();
    }

    // -----------------------------------------------------------------
    // Methodos
    // -----------------------------------------------------------------

    // Updates panel information
    private void update() {
        productPanel1.updateInfo(store.getProduct1());
        productPanel2.updateInfo(store.getProduct2());
        productPanel3.updateInfo(store.getProduct3());
        productPanel4.updateInfo(store.getProduct4());
    }

    /**
     * Sells quantity of units of product who's name is given by the parameter.
     * pProductName: Name of product. pProductName != null && pProductName != "".
     */
    public void sellProduct(String pProductName) {
        String pQuantity = JOptionPane.showInputDialog(this, "Quantity of units to sell:", "Sell product", JOptionPane.INFORMATION_MESSAGE);
        if (pQuantity != null) {
            try {
                int quantity = Integer.parseInt(pQuantity);
                if (quantity > 0) {
                    int sale = store.sellProduct(pProductName, quantity);
                    if (sale > 0) {
                        JOptionPane.showMessageDialog(this, sale + " units were sold", "Sell product", JOptionPane.INFORMATION_MESSAGE);
                        update();
                    } else {
                        JOptionPane.showMessageDialog(this, "This product has no units available to sell.", "Sell product", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "The quantity entered must be > 0.", "Sell product", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "The value entered must be numeric.", "Sell product", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Restocks quantity of units of product given by the parameter.
     * pProductName: Name of product. pProductName != null && pProductName != "".
     */
    public void restockProduct(String pProductName) {
        String pQuantity = JOptionPane.showInputDialog(this, "Quantity of units to restock:", "Restock product", JOptionPane.INFORMATION_MESSAGE);
        if (pQuantity != null) {
            try {
                int quantity = Integer.parseInt(pQuantity);
                if (quantity > 0) {
                    boolean restocked = store.restockProduct(pProductName, quantity);
                    update();
                    if (restocked)
                        JOptionPane.showMessageDialog(this, "Store was restocked.", "Restock product", JOptionPane.INFORMATION_MESSAGE);
                    else

                        JOptionPane.showMessageDialog(this, "Store could not be restocked.", "Restock product", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Quantity entered must be > 0.", "Restock product", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "The value entered must be numeric.", "Restock product", JOptionPane.ERROR_MESSAGE);
            }
        }
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
    public void changeProduct(String pCurrentName, String pNewName, Types pType, double pUnitValue, int pStockQuantity, int pMinimumQuantity, String pImagePath) {
        boolean change = store.changeProduct(pCurrentName, pNewName, pType, pUnitValue, pStockQuantity, pMinimumQuantity, pImagePath);
        if (!change)
            JOptionPane.showMessageDialog(this, "There is already an existing product with this name. " + pNewName + ".", "Change product", JOptionPane.ERROR_MESSAGE);

        else
            update();

    }

    // Shows most sold product
    public void showMostSoldProduct() {
        if (store.getMostSoldProduct() != null)
            JOptionPane.showMessageDialog(this, "The most sold product is: " + store.getMostSoldProduct().getName(), "Most sold product", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "No product has been sold yet.", "Most sold product", JOptionPane.ERROR_MESSAGE);
    }

    // Shows least sold product
    public void showLeastSoldProduct() {
        if (store.getLeastSoldProduct() != null)
            JOptionPane.showMessageDialog(this, "The least sold product is: " + store.getLeastSoldProduct().getName(), "Least sold product", JOptionPane.INFORMATION_MESSAGE);

        else
            JOptionPane.showMessageDialog(this, "No product has been sold yet.", "Least sold product", JOptionPane.ERROR_MESSAGE);

    }

    /**
     * Shows dialog to select quantity of products to sell in bulk.
     * pProductName: Name of product. pProductName != null && pProductName != "".
     */
    public void showChangeProductDialog(String pProductName) {
        ChangeProductDialog dialog = new ChangeProductDialog(this, pProductName);
        dialog.setVisible(true);
    }

    // Shows total cash in register
    public void showMoneyInRegister() {
        JOptionPane.showMessageDialog(this, "There are: " + store.getMoneyInRegister() + " $.", "Money in register", JOptionPane.INFORMATION_MESSAGE);
    }

    // Shows average of sales
    public void showAverageOfSales() {
        JOptionPane.showMessageDialog(this, "The average of sales is: " + store.getAverageOfSales(), "Average of sales", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    // Method for extension 1
    public void reqFuncOption1() {
        String result = store.method1();
        update();
        JOptionPane.showMessageDialog(this, result, "Response 1", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method for extension 1
    public void reqFuncOption2() {
        String result = store.method2();
        update();
        JOptionPane.showMessageDialog(this, result, "Response 2", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    // Executes the application
    public static void main(String[] pArgs) {
        try {
            // Unify interface for Mac & Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            StoreInterface userInterface = new StoreInterface();
            userInterface.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}