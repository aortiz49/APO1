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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.store.world.Product;
import uniandes.cupi2.store.world.Product.Types;


public class ChangeProductDialog extends JDialog implements ActionListener {
    // -----------------------------------------------------------------
    // Attributes of user interface
    // -----------------------------------------------------------------

    // Represents command to select an image
    public final static String SELECT_IMAGE = "Select an image";

    // Represents command to accept
    public final static String ACCEPT = "Accept";

    // Represents command to cancel
    public final static String CANCEL = "Cancel";

    // -----------------------------------------------------------------
    // Attributes of user Interface
    // -----------------------------------------------------------------

    // Current name label
    private JLabel lblCurrentName;

    // New name label
    private JLabel lblNewName;

    // Type label
    private JLabel lblType;

    // Unit value label
    private JLabel lblUnitValue;

    // Stock quantity label
    private JLabel lblStockQuantity;

    // Minimum quantity label
    private JLabel lblMinimumQuantity;

    // Image label
    private JLabel lblImage;

    // Combo box for type
    private JComboBox cbType;

    // Current name text field
    private JTextField txtCurrentName;

    // New name text field
    private JTextField txtNewName;

    // Unit value text field
    private JTextField txtUnitValue;

    // Stock quantity text field
    private JTextField txtStockQuantity;

    // Minimum quantity text field
    private JTextField txtMinimumQuantity;

    // Image path text field
    private JTextField txtImage;

    // Button to accept
    private JButton btnAccept;

    // Button to cancel
    private JButton btnCancel;

    // Button select image
    private JButton btnSelectImage;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    // Principal window of the application
    private StoreInterface principal;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     *  Creates the dialog to consult sales in bulk.
     *  pPrincipal: Principal window of the application. pPrincipal != null.
     *  pProductName: Current name of product. pProductName != null && pCurrentName != "".
     */
    public ChangeProductDialog(StoreInterface pPrincipal, String pProductName) {
        principal = pPrincipal;

        setTitle("Change product");
        setSize(430, 280);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(8, 2, 5, 5));

        lblCurrentName = new JLabel("Name actual:");
        add(lblCurrentName);
        txtCurrentName = new JTextField(pProductName);
        txtCurrentName.setEditable(false);
        add(txtCurrentName);

        lblNewName = new JLabel("New name:");
        add(lblNewName);
        txtNewName = new JTextField();
        add(txtNewName);

        lblUnitValue = new JLabel("Unit value:");
        add(lblUnitValue);
        txtUnitValue = new JTextField();
        add(txtUnitValue);

        lblType = new JLabel("Type:");
        add(lblType);
        cbType = new JComboBox();
        cbType.addItem("Stationery");
        cbType.addItem("Supermarket");
        cbType.addItem("Pharmacy");
        add(cbType);

        lblStockQuantity = new JLabel("Quantity in stock:");
        add(lblStockQuantity);
        txtStockQuantity = new JTextField();
        add(txtStockQuantity);

        lblMinimumQuantity = new JLabel("Minimum quantity:");
        add(lblMinimumQuantity);
        txtMinimumQuantity = new JTextField();
        add(txtMinimumQuantity);

        lblImage = new JLabel("Image:");
        add(lblImage);
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 2));
        txtImage = new JTextField();
        txtImage.setEditable(false);
        imagePanel.add(txtImage);
        btnSelectImage = new JButton("Select");
        btnSelectImage.setActionCommand(SELECT_IMAGE);
        btnSelectImage.addActionListener(this);
        imagePanel.add(btnSelectImage);
        add(imagePanel);

        btnAccept = new JButton("Accept");
        btnAccept.setActionCommand(ACCEPT);
        btnAccept.addActionListener(this);
        add(btnAccept);

        btnCancel = new JButton("Cancel");
        btnCancel.setActionCommand(CANCEL);
        btnCancel.addActionListener(this);
        add(btnCancel);

        setModal(true);
        setLocationRelativeTo(pPrincipal);
        setResizable(false);
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    // Button event management
    public void actionPerformed(ActionEvent pEvent) {
        String command = pEvent.getActionCommand();
        switch (command) {
            case CANCEL:
                dispose();
                break;
            case ACCEPT:
                String newName = txtNewName.getText();
                String typeStr = (String) cbType.getSelectedItem();
                String valorStr = txtUnitValue.getText();
                String stockQuantityStr = txtStockQuantity.getText();
                String minQuantityStr = txtMinimumQuantity.getText();
                String imageStr = txtImage.getText();
                if (newName.equals("") || typeStr.equals("") || valorStr.equals("") || stockQuantityStr.equals("") ||
                        minQuantityStr.equals("") || imageStr.equals(""))
                    JOptionPane.showMessageDialog(this, "You must fill out every field.", "Change product",
                            JOptionPane.ERROR_MESSAGE);

                else {
                    try {
                        double UnitValue = Double.parseDouble(valorStr);
                        int stockQuantity = Integer.parseInt(stockQuantityStr);
                        int minimumQuantity = Integer.parseInt(minQuantityStr);

                        if (stockQuantity < 0 || minimumQuantity < 0 || UnitValue < 0)
                            JOptionPane.showMessageDialog(this, "The stock quantity, minimum quantity, and unit value " +
                                    "cannot be negative values.", "Change product", JOptionPane.ERROR_MESSAGE);

                        else {
                            Types type = Types.STATIONERY;
                            if (typeStr.equals("Pharmacy"))
                                type = Types.PHARMACY;

                            else if (typeStr.equals("Supermarket"))
                                type = Types.SUPERMARKET;


                            principal.changeProduct(txtCurrentName.getText(), newName, type, UnitValue, stockQuantity,
                                    minimumQuantity, imageStr);
                            dispose();
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "The unit value, stock quantity, and minimum quantity must " +
                                "be numeric values.", "Change product", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case SELECT_IMAGE:
                JFileChooser jfc = new JFileChooser("./data/images");
                int result = jfc.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File archive = jfc.getSelectedFile();
                    txtImage.setText(archive.getName());
                }
                break;
        }
    }

}
