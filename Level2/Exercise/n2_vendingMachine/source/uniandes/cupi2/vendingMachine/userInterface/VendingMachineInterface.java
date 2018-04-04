/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n2_VendingMachine
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.vendingMachine.userInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.vendingMachine.world.VendingMachine;
import uniandes.cupi2.vendingMachine.world.Amount;
import uniandes.cupi2.vendingMachine.world.Product;
import uniandes.cupi2.vendingMachine.world.Product.Types;

/*
 * Principal class of user interface.
 */

public class VendingMachineInterface extends JFrame {
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	// Association to vending machine class.
	private VendingMachine vendingMachine;
	
	// -----------------------------------------------------------------
	// Interface Attributes
	// -----------------------------------------------------------------
	
	// Panel options.
	private OptionsPanel panelOptions;
	
	// Alphanumeric keypad.
	private KeypadPanel keypadPanel;
	
	/*
	 * Product panels.
	 */
	private ProductPanel productPanel1;
	
	private ProductPanel productPanel2;
	
	private ProductPanel productPanel3;
	
	private ProductPanel productPanel4;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/*
	 * Constructs the main window of the application.
	 * All components of user interface were initialized.
	 */
	public VendingMachineInterface() {
		setTitle("Vending Machine");
		setSize(750, 690);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		vendingMachine = new VendingMachine();
		
		JLabel lblImage = new JLabel();
		ImageIcon icon = new ImageIcon("data/images/banner.png");
		lblImage.setIcon(icon);
		add(lblImage, BorderLayout.NORTH);
		
		JPanel centralPanel = new JPanel(new GridLayout(2, 2));
		add(centralPanel, BorderLayout.CENTER);
		
		Product p1 = vendingMachine.getProduct("A1");
		productPanel1 = new ProductPanel(this, p1.getName(), p1.getIdentifier(), p1.getPrice(),
		                                 p1.getQuantityOfUnitsAvailable(), p1.getType(),
		                                 p1.isFopre());
		centralPanel.add(productPanel1);
		
		Product p2 = vendingMachine.getProduct("A2");
		productPanel2 = new ProductPanel(this, p2.getName(), p2.getIdentifier(), p2.getPrice(),
		                                 p2.getQuantityOfUnitsAvailable(), p2.getType(),
		                                 p2.isFopre());
		centralPanel.add(productPanel2);
		
		Product p3 = vendingMachine.getProduct("B1");
		productPanel3 = new ProductPanel(this, p3.getName(), p3.getIdentifier(), p3.getPrice(),
		                                 p3.getQuantityOfUnitsAvailable(), p3.getType(),
		                                 p3.isFopre());
		centralPanel.add(productPanel3);
		
		Product p4 = vendingMachine.getProduct("B2");
		productPanel4 = new ProductPanel(this, p4.getName(), p4.getIdentifier(), p4.getPrice(),
		                                 p4.getQuantityOfUnitsAvailable(), p4.getType(),
		                                 p4.isFopre());
		centralPanel.add(productPanel4);
		
		JPanel rightPanel = new JPanel(new BorderLayout());
		add(rightPanel, BorderLayout.EAST);
		
		ButtonPanel buttonPanel = new ButtonPanel(this);
		rightPanel.add(buttonPanel, BorderLayout.CENTER);
		
		keypadPanel = new KeypadPanel(this);
		rightPanel.add(keypadPanel, BorderLayout.NORTH);
		
		panelOptions = new OptionsPanel(this);
		add(panelOptions, BorderLayout.SOUTH);
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	// This method executes the application, creating a new user interface.
	public static void main(String[] args) {
		try {
			// Unifies the user interface for Mac and Windows.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			
			VendingMachineInterface userInterface = new VendingMachineInterface();
			userInterface.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Adds a coin of the denominations received through the parameter.
	 * pCoin: Denomination of coin.
	 */
	public void addCoin(int pCoin) {
		boolean isAdded = vendingMachine.addCoin(pCoin);
		if (!isAdded) {
			
			DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
			df.applyPattern("$###,### COP");
			JOptionPane.showMessageDialog(this, "The maximum credit allowed is: " + df.format
				(Amount.MAX_VALUE) + ".", "Add coin", JOptionPane.ERROR_MESSAGE);
		} else {
			update();
		}
	}
	
	/*
	 * Purchases a product with the identifier given through the parameter.
	 *
	 * Purchase was made, and userInterface was updated.
	 * pIdentifier: Product identifier. pIdentifier != null.
	 */
	public void purchaseProduct(String pIdentifier) {
		Product product = vendingMachine.getProduct(pIdentifier);
		
		boolean isPurchased = vendingMachine.purchaseProduct(pIdentifier);
		update();
		
		if (!isPurchased) {
			if (product.getQuantityOfUnitsAvailable() == 0) {
				
				JOptionPane.showMessageDialog(this, "The product doesn't have any units " +
					                              "available.",
				                              "Purchase product", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "There is insufficient credit to make the " +
					"purchase.", "Purchase product", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			keypadPanel.resetIdentifier();
			JOptionPane.showMessageDialog(this, "Purchase was successful.", "Purchase " +
				"product", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	/*
	 * Terminates current purchase and shows the amount of change.
	 * Credit was reset.
	 */
	public void terminatePurchase() {
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern("$###,###");
		
		Amount change = vendingMachine.terminatePurchase();
		update();
		String message = "Purchase was terminated. \nChange is: " + df
			.format(change.getTotalValue()) + " COP:\n\t";
		message += "- $1000 x " + change.getQuantityOfCoins1000() + " = $" + (change
			.getQuantityOfCoins1000() * Amount.COIN_1000) + "\n\t";
		message += "- $500 x " + change.getQuantityOfCoins500() + " = " + df.format((change
			.getQuantityOfCoins500() * Amount.COIN_500)) + "\n\t";
		message += "- $200 x " + change.getQuantityOfCoins200() + " = " + df.format((change
			.getQuantityOfCoins200() * Amount.COIN_200)) + "\n\t";
		message += "- $100 x " + change.getQuantityOfCoins100() + " = " + df.format((change
			.getQuantityOfCoins100() * Amount.COIN_100)) + "\n\t";
		message += "- $50 x " + change.getQuantityOfCoins50() + " = " + df.format((change
			.getQuantityOfCoins50() * Amount.COIN_50));
		JOptionPane.showMessageDialog(this, message, "Terminate purchase",
		                              JOptionPane
			                              .INFORMATION_MESSAGE);
		
	}
	
	/*
	 * Show dialog with the total value of purchases from the machine.
	 */
	public void getValueTotalPurchases() {
		
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern("$###,### COP");
		double valueTotalPurchases = vendingMachine.getValueTotalPurchases();
		String message = "The total value of purchases from the machine is: " + df.format
			(valueTotalPurchases) + ".";
		JOptionPane.showMessageDialog(this, message, "Total value of purchases", JOptionPane
			.INFORMATION_MESSAGE);
	}
	
	/*
	 * Shows dialog with percent of restock availability of the machine.
	 */
	public void getPercentAvailability() {
		String message = "The percentage of availability of the machine is: " +
			vendingMachine.getPercentAvailability() + "%.";
		JOptionPane.showMessageDialog(this, message, "Percentage of availability", JOptionPane
			.INFORMATION_MESSAGE);
		
	}
	
	/*
	 * Shows the dialog of purchases per product.
	 */
	public void showDialogOfUnitsPurchased() {
		Product p1 = vendingMachine.getProduct("A1");
		Product p2 = vendingMachine.getProduct("A2");
		Product p3 = vendingMachine.getProduct("B1");
		Product p4 = vendingMachine.getProduct("B2");
		
		int totalQuantity = vendingMachine.getTotalQuantityOfUnitsPurchased();
		String nameProduct1 = p1.getName();
		String nameProduct2 = p2.getName();
		String nameProduct3 = p3.getName();
		String nameProduct4 = p4.getName();
		int quantityProduct1 = p1.getQuantityOfUnitsPurchased();
		int quantityProduct2 = p2.getQuantityOfUnitsPurchased();
		int quantityProduct3 = p3.getQuantityOfUnitsPurchased();
		int quantityProduct4 = p4.getQuantityOfUnitsPurchased();
		
		DialogUnitsPurchased dialog = new DialogUnitsPurchased(totalQuantity,
		                                                       quantityProduct1,
		                                                       nameProduct1,
		                                                       quantityProduct2,
		                                                       nameProduct2,
		                                                       quantityProduct3,
		                                                       nameProduct3,
		                                                       quantityProduct4,
		                                                       nameProduct4);
		dialog.setVisible(true);
	}
	
	/*
	 * Shows dialog showing FOPRE donation.
	 */
	public void showDialogFopreInformation() {
		int foodQuantity = (vendingMachine.getQuantityOfFopreUnitsPurchased(Types.FOOD));
		int drinkQuantity = vendingMachine.getQuantityOfFopreUnitsPurchased(Types.DRINK);
		double foodDonation = vendingMachine.getDonationsPerType(Types.FOOD);
		double drinkDonation = vendingMachine.getDonationsPerType(Types.DRINK);
		double totalDonation = vendingMachine.getTotalDonations();
		
		if (totalDonation == 0) {
			JOptionPane.showMessageDialog(this, "No products have been purchased that contribute" +
				" " +
				"to FOPRE.", "FOPRE Information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			DialogFopreInformation dialog = new DialogFopreInformation(foodQuantity,
			                                                           foodDonation,
			                                                           drinkQuantity,
			                                                           drinkDonation,
			                                                           totalDonation);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(this);
		}
	}
	
	/*
	 * Shows dialog of most-purchased product.
	 */
	public void getMostPurchasedProduct() {
		Product mostPurchased = vendingMachine.getMostPurchasedProduct();
		String message2 = "No product has been purchased";
		if (mostPurchased == null)
			JOptionPane.showMessageDialog(this, message2, "Most purchased product",
			                              JOptionPane.INFORMATION_MESSAGE);
		
		else {
			String message = "The most purchased product is : " + mostPurchased.getIdentifier() +
				" " +
				mostPurchased.getName() + ".\n";
			
			if (mostPurchased.getQuantityOfUnitsPurchased() == 1)
				message += "There was " + mostPurchased.getQuantityOfUnitsPurchased() + " unit " +
					"purchased.";
			else
				message += "There were " + mostPurchased.getQuantityOfUnitsPurchased() + " units" +
					" " +
					"purchased.";
			JOptionPane.showMessageDialog(this, message, "Most purchased product",
			                              JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	// -----------------------------------------------------------------
	// Extension Points
	// -----------------------------------------------------------------
	
	// Panel information is updated.
	private void update() {
		keypadPanel.update(vendingMachine.getCreditValue());
		
		Product p1 = vendingMachine.getProduct("A1");
		Product p2 = vendingMachine.getProduct("A2");
		Product p3 = vendingMachine.getProduct("B1");
		Product p4 = vendingMachine.getProduct("B2");
		
		productPanel1.updateInterface(p1.getPrice(), p1.getQuantityOfUnitsAvailable());
		productPanel2.updateInterface(p2.getPrice(), p2.getQuantityOfUnitsAvailable());
		productPanel3.updateInterface(p3.getPrice(), p3.getQuantityOfUnitsAvailable());
		productPanel4.updateInterface(p4.getPrice(), p4.getQuantityOfUnitsAvailable());
		
	}
	
	// Extension 1.
	public void reqFuncOption1() {
		
		String result = vendingMachine.method1();
		update();
		JOptionPane.showMessageDialog(this, result, "Response 1", JOptionPane
			.INFORMATION_MESSAGE);
	}
	
	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------
	
	/**
	 * Extension 2.
	 */
	public void reqFuncOption2() {
		String result = vendingMachine.method2();
		update();
		JOptionPane.showMessageDialog(this, result, "Response 2", JOptionPane
			.INFORMATION_MESSAGE);
	}
	
}
