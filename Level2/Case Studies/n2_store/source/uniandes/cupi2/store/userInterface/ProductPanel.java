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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.store.world.Product;
import uniandes.cupi2.store.world.Product.Types;

// Panel that shows the information of the product

public class ProductPanel extends JPanel implements ActionListener {
    // ----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    // Command to change the product
    private static final String CHANGE_PRODUCT = "ChangeProduct";

    // Command to restock product
    private static final String RESTOCK_BUTTON = "Restock";

    // Command to sell product
    private static final String SELL_BUTTON = "Sell";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Principal window of the application
    private StoreInterface principal;

    // Product panel
    private Product product;

    // -----------------------------------------------------------------
    // Attributes de userInterface
    // -----------------------------------------------------------------

    // Type label
    private JLabel lblType;

    // Unit value label
    private JLabel lblUnitValue;

    // Stock quantity label
    private JLabel lblStockQuantity;

    // Units sold label
    private JLabel lblQuantitySold;

    // Minimum quantity label
    private JLabel lblMinimumQuantity;

    // Type text field
    private JTextField txtType;

    // Unit value text field
    private JTextField txtUnitValue;

    // Stock quantity text field
    private JTextField txtStockQuantity;

    // Quantity sold text label
    private JTextField txtQuantitySold;

    /// Minimum quantity text field
    private JTextField txtMinimumQuantity;

    // Image label
    private JLabel lblImage;

    // Sell button
    private JButton btnSell;

    // Restock button
    private JButton btnRestock;

    // Change product button
    private JButton btnChangeProduct;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /*
        Constructs panel with product information
        pPrincipal: Main window of the application.
     */
    public ProductPanel(StoreInterface pPrincipal) {
        principal = pPrincipal;

        setLayout(new BorderLayout());

        JPanel productPanel = new JPanel();
        add(productPanel, BorderLayout.CENTER);

        productPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setBorder(new TitledBorder("Product"));

        productPanel.setLayout(new GridLayout(5, 1, 0, 5));

        lblType = new JLabel("Type: ");
        txtType = new JTextField(15);
        txtType.setEditable(false);
        productPanel.add(lblType);
        productPanel.add(txtType);

        lblStockQuantity = new JLabel("Quantity in stock: ");
        txtStockQuantity = new JTextField(15);
        txtStockQuantity.setEditable(false);
        productPanel.add(lblStockQuantity);
        productPanel.add(txtStockQuantity);

        lblUnitValue = new JLabel("Unit value: ");
        txtUnitValue = new JTextField(15);
        txtUnitValue.setEditable(false);
        productPanel.add(lblUnitValue);
        productPanel.add(txtUnitValue);

        lblQuantitySold = new JLabel("Quantity sold: ");
        txtQuantitySold = new JTextField(15);
        txtQuantitySold.setEditable(false);
        productPanel.add(lblQuantitySold);
        productPanel.add(txtQuantitySold);

        lblMinimumQuantity = new JLabel("Minimum quantity: ");
        txtMinimumQuantity = new JTextField(15);
        txtMinimumQuantity.setEditable(false);
        productPanel.add(lblMinimumQuantity);
        productPanel.add(txtMinimumQuantity);

        JPanel panelSur = new JPanel();
        panelSur.setLayout(new GridLayout(1, 3));

        btnRestock = new JButton("Restock");
        btnRestock.setActionCommand(RESTOCK_BUTTON);
        btnRestock.addActionListener(this);
        panelSur.add(btnRestock);

        btnSell = new JButton("Sell");
        btnSell.setActionCommand(SELL_BUTTON);
        btnSell.addActionListener(this);
        panelSur.add(btnSell);

        btnChangeProduct = new JButton("Change");
        btnChangeProduct.setActionCommand(CHANGE_PRODUCT);
        btnChangeProduct.addActionListener(this);
        panelSur.add(btnChangeProduct);

        add(panelSur, BorderLayout.SOUTH);

        lblImage = new JLabel();
        add(lblImage, BorderLayout.WEST);

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /*
        Updates product information with data from parameter
        pProduct: Product to update. pProduct != null.
     */
    public void updateInfo(Product pProduct) {
        product = pProduct;
        setBorder(new TitledBorder(product.getName()));
        ImageIcon icon = new ImageIcon("./data/images/" + product.getImagePath());
        lblImage.setIcon(icon);
        Types typeOrig = product.getType();
        String type = "";
        switch (typeOrig) {
            case SUPERMARKET: {
                type = "Supermarket";
                break;
            }
            case PHARMACY: {
                type = "Pharmacy";
                break;
            }
            case STATIONERY: {
                type = "Stationery";
                break;
            }
        }
        txtType.setText(type);
        txtUnitValue.setText(product.getUnitValue() + " $");
        txtStockQuantity.setText(product.getStockQuantity() + "");
        txtMinimumQuantity.setText(product.getMinimumQuantity() + "");
        txtQuantitySold.setText(product.getQuantityUnitsSold() + "");
    }

    /*
        Manages button events
        pEvent: Action that generates the event.
     */
    public void actionPerformed(ActionEvent pEvent) {
        String command = pEvent.getActionCommand();

        if (command.equals(SELL_BUTTON))
            principal.sellProduct(product.getName());
        else if (command.equals(RESTOCK_BUTTON))
            principal.restockProduct(product.getName());
        else if (command.equals(CHANGE_PRODUCT))
            principal.showChangeProductDialog(product.getName());

    }

}
