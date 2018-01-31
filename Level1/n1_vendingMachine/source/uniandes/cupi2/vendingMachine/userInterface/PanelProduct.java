/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 *
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: L1- vendingMachine
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.userInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Contains the buttons located in the lower part of the center window
 */

public class PanelProduct extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Command to execute the action of the button btnRestock
     */
    private static final String RESTOCK = "Restock";

    /**
     * Command to execute the action of the button btnPurchase
     */
    private static final String PURCHASE = "Purchase";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Principal window of the application
     */
    private InterfaceVendingMachine principal;

    /**
     * Identifier of product.
     */
    private String identifier;

    // -----------------------------------------------------------------
    // Attributes of the interface
    // -----------------------------------------------------------------

    /**
     * Button that purchases product 
     */
    private JButton btnPurchase;

    /**
     * Button that restocks product
     */
    private JButton btnRestock;

    /**
     * Label with product information 
     */
    private JLabel lblInfo;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs panel with buttons <br>
     * Initializes buttons
     * pInterface: Principal interface of the application. pInterface != null
     * pName: Name of the product.
     * pIdentifier: Identifier of the product.
     * pPrice: Price of the product.
     * pQuantity: Quantity of units of product.
     */
    public PanelProduct(InterfaceVendingMachine pInterface, String pName, String pIdentifier, double pPrice, int pQuantity) {
        principal = pInterface;
        identifier = pIdentifier;

        TitledBorder b = BorderFactory.createTitledBorder(pIdentifier);
        setBorder(b);
        setLayout(new BorderLayout());

        String image = "";

        if(pName.startsWith("Jugo"))
            image = "data/img/jugo.png";

        else if(pName.startsWith("Chocolatina"))
            image = "data/img/chocolatina.png";
        
        else if(pName.startsWith("Galletas"))
            image = "data/img/galletas.png";

        else if(pName.startsWith("Papas"))
            image = "data/img/papas.png";
    

        JLabel lblName = new JLabel(pName, SwingConstants.CENTER);
        add(lblName, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon(image);
        JLabel lblImage = new JLabel(icon);
        add(lblImage, BorderLayout.CENTER);

        JPanel inferiorPanel = new JPanel(new GridLayout(3, 1));

        JPanel panelInfo = new JPanel(new GridLayout(1, 2));

        panelInfo.add(new JLabel("Available: "));
        lblInfo = new JLabel("" + pQuantity, SwingConstants.CENTER);
        panelInfo.add(lblInfo);
        inferiorPanel.add(panelInfo);

        JPanel pricePanel = new JPanel( new GridLayout(1, 2));
        JLabel lblPrice = new JLabel("$" + pPrice, SwingConstants.CENTER);

        pricePanel.add(new JLabel("Price: "));
        pricePanel.add(lblPrice);
        inferiorPanel.add(pricePanel);
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));

        btnPurchase = new JButton("Purchase");
        btnPurchase.addActionListener(this);
        btnPurchase.setActionCommand(PURCHASE);
        buttonsPanel.add(btnPurchase);

        btnRestock = new JButton("Restock");
        btnRestock.addActionListener(this);
        btnRestock.setActionCommand(RESTOCK);
        buttonsPanel.add(btnRestock);

        inferiorPanel.add(buttonsPanel);

        add(inferiorPanel, BorderLayout.SOUTH);

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Refreshes panel with information received by parameter 
     * pPrice: Price of product..
     * pQuantity: Quantity of product.
     */
    public void refreshInterface(double pPrice, int pQuantity) {
        lblInfo.setText(pQuantity + "");
    }

    /**
     * Management of user events 
     * pEvent: User event. pEvent != null.
     */
   
    public void actionPerformed(ActionEvent pEvent) {
        if(pEvent.getActionCommand().equals(RESTOCK)) {
            String units = JOptionPane.showInputDialog(principal, "Enter the number of units to restock this product: ");
            try {
                if(units != null) {
                    int numUnits = Integer.parseInt(units);
                    principal.restock(identifier, numUnits);
                }

            }
            catch(Exception e){
                JOptionPane.showMessageDialog( principal, "Please enter whole numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if(pEvent.getActionCommand().equals(PURCHASE))
            principal.sell(identifier);

    }

}
