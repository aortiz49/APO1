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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Panel with buttons from the application.
 */

public class ButtonPanel extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	// Command to see total value of purchases.
	private static final String TOTAL_VALUE_PURCHASES = "Total value of purchases";
	
	// Command to see percent availability.
	private static final String PERCENT_AVAILABILITY = "Percent availability";
	
	// Command to see quantity of units purchased.
	private static final String UNITS_PURCHASED = "Units purchased";
	
	// command to see information about fopre donations.
	private static final String INFO_FOPRE_DONATION = "FOPRE information";
	
	// Command to see most purchased product.
	private static final String MOST_PURCHASED_PRODUCT = "Most purchased product";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Principal window of the application.
	 */
	private VendingMachineInterface principal;
	
	// -----------------------------------------------------------------
	// Attributes de la userInterface
	// -----------------------------------------------------------------
	
	// Button to see value of purchases
	private JButton btnValuePurchases;
	
	// Button to obtain percent availability of the machine.
	private JButton btnPercentAvailability;
	
	// Button to obtain sales of product.
	private JButton btnUnitsPurchased;
	
	// Button to obtain information about FOPRE.
	private JButton btnInfoFopreDonation;
	
	// Button to obtain information about most purchased product.
	private JButton btnMostPurchasedProduct;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/*
	 * Constructs a panel with the buttons.
	 * All the buttons were initialized.
	 * pInterface: Principal interface of the application. pInterface != null.
	 */
	public ButtonPanel(VendingMachineInterface pInterface) {
		principal = pInterface;
		setLayout(new GridLayout(5, 1, 5, 5));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		btnUnitsPurchased = new JButton(UNITS_PURCHASED);
		btnUnitsPurchased.setActionCommand(UNITS_PURCHASED);
		btnUnitsPurchased.addActionListener(this);
		add(btnUnitsPurchased);
		
		btnMostPurchasedProduct = new JButton(MOST_PURCHASED_PRODUCT);
		btnMostPurchasedProduct.setActionCommand(MOST_PURCHASED_PRODUCT);
		btnMostPurchasedProduct.addActionListener(this);
		add(btnMostPurchasedProduct);
		
		btnValuePurchases = new JButton(TOTAL_VALUE_PURCHASES);
		btnValuePurchases.setActionCommand(TOTAL_VALUE_PURCHASES);
		btnValuePurchases.addActionListener(this);
		add(btnValuePurchases);
		
		btnPercentAvailability = new JButton(PERCENT_AVAILABILITY);
		btnPercentAvailability.setActionCommand(PERCENT_AVAILABILITY);
		btnPercentAvailability.addActionListener(this);
		add(btnPercentAvailability);
		
		btnInfoFopreDonation = new JButton(INFO_FOPRE_DONATION);
		btnInfoFopreDonation.setActionCommand(INFO_FOPRE_DONATION);
		btnInfoFopreDonation.addActionListener(this);
		add(btnInfoFopreDonation);
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/*
	 * Manages user events.
	 * pEvent: User event. pEvent != null.
	 */
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		switch (command) {
			case TOTAL_VALUE_PURCHASES:
				principal.getValueTotalPurchases();
				break;
			case PERCENT_AVAILABILITY:
				principal.getPercentAvailability();
				break;
			case UNITS_PURCHASED:
				principal.showDialogOfUnitsPurchased();
				break;
			case INFO_FOPRE_DONATION:
				principal.showDialogFopreInformation();
				break;
			case MOST_PURCHASED_PRODUCT:
				principal.getMostPurchasedProduct();
				break;
		}
	}
	
}
