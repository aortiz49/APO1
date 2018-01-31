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
import java.net.InterfaceAddress;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import uniandes.cupi2.vendingMachine.world.VendingMachine;
import uniandes.cupi2.vendingMachine.world.Product;

/**
 * Principal class for interface
 */
public class InterfaceVendingMachine extends JFrame {
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Associate principal class to the world
     */
    private VendingMachine world;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Contains the banner
     */
    private PanelImage panelImage;

    /**
     * Button pannel located in the lower zone of the interface
     */
    private PanelOptions panelOptions;

    // Create Panel for profucts
    private PanelProduct panelProduct1;
    private PanelProduct panelProduct2;
    private PanelProduct panelProduct3;
    private PanelProduct panelProduct4;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Constructs the principal window of the application 
     * Initialize every component of the interface
     */
    public InterfaceVendingMachine() {
    
        setTitle("Vending Machine");
        setSize(630, 690);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        world = new VendingMachine();

        Product p1 = world.getProduct1();
        Product p2 = world.getProduct2();
        Product p3 = world.getProduct3();
        Product p4 = world.getProduct4();

        panelProduct1 = new PanelProduct(this, p1.getName(), p1.getIdentifier(), p1.getPrice(), p1.getQuantityOfUnitsAvailable());
        panelProduct2 = new PanelProduct(this, p2.getName(), p2.getIdentifier(), p2.getPrice(), p2.getQuantityOfUnitsAvailable());
        panelProduct3 = new PanelProduct(this, p3.getName(), p3.getIdentifier(), p3.getPrice(), p3.getQuantityOfUnitsAvailable());
        panelProduct4 = new PanelProduct(this, p4.getName(), p4.getIdentifier(), p4.getPrice(), p4.getQuantityOfUnitsAvailable());

        JPanel centerPanel = new JPanel(new GridLayout(2, 2));

        centerPanel.add(panelProduct1);
        centerPanel.add(panelProduct2);
        centerPanel.add(panelProduct3);
        centerPanel.add(panelProduct4);

        add(centerPanel, BorderLayout.CENTER);

        panelImage = new PanelImage();
        add(panelImage, BorderLayout.NORTH);

        PanelButtons panelButtons = new PanelButtons(this);
        add(panelButtons, BorderLayout.EAST);

        panelOptions = new PanelOptions(this);
        add(panelOptions, BorderLayout.SOUTH);
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Restocks the machine with a specific number of units of the specified product.
     * pIdentifier: Identifier of product.
     * pQuantity: Number of units to restock.
     */
    public void restock(String pIdentifier, int pQuantity) { 
    
        Product p1 = world.getProduct1();
        Product p2 = world.getProduct2();
        Product p3 = world.getProduct3();
        Product p4 = world.getProduct4();

        if( pIdentifier.equals(p1.getIdentifier())) {      
            world.restockProduct1(pQuantity);
            panelProduct1.refreshInterface(p1.getPrice(), p1.getQuantityOfUnitsAvailable());
        }

        else if(pIdentifier.equals(p2.getIdentifier())) {        
            world.restockProduct2(pQuantity);
            panelProduct2.refreshInterface(p2.getPrice(), p2.getQuantityOfUnitsAvailable());
        }

        else if(pIdentifier.equals(p3.getIdentifier())) {
            world.restockProduct3(pQuantity);
            panelProduct3.refreshInterface(p3.getPrice(), p3.getQuantityOfUnitsAvailable());
        }

        else if(pIdentifier.equals(p4.getIdentifier())) {
            world.restockProduct4(pQuantity);
            panelProduct4.refreshInterface(p4.getPrice(), p4.getQuantityOfUnitsAvailable());
        }
    }

    /**
     * Sells a product from the machine. 
     * pIdentifier: Identifier of product to be sold.
     */
    public void sell(String pIdentifier) {
    

        Product p1 = world.getProduct1();
        Product p2 = world.getProduct2();
        Product p3 = world.getProduct3();
        Product p4 = world.getProduct4();

        if(pIdentifier.equals(p1.getIdentifier())) {        
            if( p1.getQuantityOfUnitsAvailable() > 0) {            
                world.sellProduct1();
                panelProduct1.refreshInterface(p1.getPrice(), p1.getQuantityOfUnitsAvailable());
            }

            else          
                JOptionPane.showMessageDialog(this, "This product is sold out!", "Error", JOptionPane.ERROR_MESSAGE);
            
        }

        else if(pIdentifier.equals(p2.getIdentifier())) {     
            if(p2.getQuantityOfUnitsAvailable() > 0){           
                world.sellProduct2();
                panelProduct2.refreshInterface(p2.getPrice(), p2.getQuantityOfUnitsAvailable());
            }

            else
                JOptionPane.showMessageDialog(this, "This product is sold out!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        else if(pIdentifier.equals(p3.getIdentifier())) {  
            if( p3.getQuantityOfUnitsAvailable() > 0 ) {
                world.sellProduct3();
                panelProduct3.refreshInterface(p3.getPrice(), p3.getQuantityOfUnitsAvailable());
            }

            else 
                JOptionPane.showMessageDialog(this, "This product is sold out!", "Error", JOptionPane.ERROR_MESSAGE);          
        }

        else if(pIdentifier.equals(p4.getIdentifier())) {
            if(p4.getQuantityOfUnitsAvailable() > 0) {
                world.sellProduct4();
                panelProduct4.refreshInterface(p4.getPrice(), p4.getQuantityOfUnitsAvailable());
            }
            else
                JOptionPane.showMessageDialog( this, "El producto se encuentra agotado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Shows dialog with quantity of sales from the machine
     */
    public void showDialogQuantityOfSales() {
        int totalSales = world.getQuantityOfTotalSales();
        String message = "The quantity of sales from the machine is: " + totalSales + ".";
        JOptionPane.showMessageDialog(this, message,"Quantity of sales", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shows dialog with total value of sales from the machine 
     */
    public void showDialogValueOfTotalSales() {
        double valueOfTotalSales = world.getValueOfTotalSales();
        String message = "The total value of sales from the machine is $" + valueOfTotalSales + ".";
        JOptionPane.showMessageDialog(this, message, "Total value of sales", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shows dialog with the available product capacity of the machine
     */
    public void showDialogPercentOfAvailability() {
        String capacity = JOptionPane.showInputDialog(this, "Enter product capacity of the machine");

        if(capacity != null ){
            try{
                int capacityInt = Integer.parseInt(capacity);

                if(capacityInt < 1){
                    JOptionPane.showMessageDialog( this, "The capacity must be greater than or equal to 1!", "Error", JOptionPane.INFORMATION_MESSAGE);
                }

                else{
                    double capacityAvailable = world.getPercentOfAvailability(capacityInt);
                    String message = "The percentage of product availability of the machine is: " + capacityAvailable + "%.";
                    JOptionPane.showMessageDialog( this, message, "Percentage of product availability", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            catch(Exception e){
                JOptionPane.showMessageDialog( this, "Please enter whole numbers!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Shows dialog with sales for each product
     */
    public void showDialogOfUnitsSold() {
        Product p1 = world.getProduct1();
        Product p2 = world.getProduct2();
        Product p3 = world.getProduct3();
        Product p4 = world.getProduct4();

        String message = "The quantity of units sold of each product is: ";
        message += "\n" + p1.getName() + ": " + p1.getQuantityOfUnitsSold();
        message += "\n" + p2.getName() + ": " + p2.getQuantityOfUnitsSold();
        message += "\n" + p3.getName() + ": " + p3.getQuantityOfUnitsSold();
        message += "\n" + p4.getName() + ": " + p4.getQuantityOfUnitsSold();

        JOptionPane.showMessageDialog(this, message, "Units sold", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    /**
     * Extension 1
     */
    public void reqFuncOption1() {

        String result = world.method1();
        JOptionPane.showMessageDialog(this, result, "Response 1", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Extension 2
     */
    public void reqFuncOption2() {

        String result = world.method2();
        JOptionPane.showMessageDialog(this, result, "Response 2", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * This method executes the application, creating a new interface
     */
    public static void main(String[] args) {
        try {
            // Unify interface for Mac and Windows
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            InterfaceVendingMachine userInterface = new InterfaceVendingMachine();
            userInterface.setVisible(true);
        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
