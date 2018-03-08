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

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;

/*
 * Represents dialog of FOPRE information.
 */
public class DialogFopreInformation extends JDialog {
	
	// -----------------------------------------------------------------
	// Interface Attributes
	// -----------------------------------------------------------------
	
	// Text field of donation information.
	private JTextField txtTotalDonation;
	
	// Text field with the donation information for products of type FOOD.
	private JTextField txtFoodDonation;
	
	// Text field with the donation information for products of type DRINK.
	
	private JTextField txtDrinkDonation;
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/*
	 * Constructs a new dialog of FOPRE information.
	 * Every button was initialized.
	 * quantityOfFoodPurchases: Quantity of purchases of type FOOD.
	 * foodDonation: Value of donations from products of type FOOD.
	 * quantityOFDrinkPurchases: Quantity of purchases of type DRINK.
	 * drinkDonation: Value of donations from products of type DRINK.
	 * totalDonation: total donation to FOPRE.
	 */
	public DialogFopreInformation(int quantityOfFoodPurchases, double foodDonation, int
		quantityOFDrinkPurchases, double drinkDonation, double totalDonation) {
		setTitle("FOPRE Information");
		setSize(400, 300);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JPanel generalPanel = new JPanel();
		generalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		generalPanel.setLayout(new BorderLayout());
		add(generalPanel, BorderLayout.CENTER);
		
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern("$ ###,### COP");
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new CompoundBorder(new TitledBorder("Donations:"), new
			EmptyBorder(3, 3, 3, 3)));
		panelInferior.setLayout(new GridLayout(3, 2, 3, 3));
		generalPanel.add(panelInferior, BorderLayout.CENTER);
		
		panelInferior.add(new JLabel("Total: "));
		
		txtTotalDonation = new JTextField(df.format(totalDonation));
		txtTotalDonation.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTotalDonation.setEditable(false);
		txtTotalDonation.setHorizontalAlignment(JTextField.CENTER);
		panelInferior.add(txtTotalDonation);
		
		panelInferior.add(new JLabel("Food:"));
		
		txtFoodDonation = new JTextField(df.format(foodDonation) + "(" + quantityOfFoodPurchases
			                                 + " units)");
		txtFoodDonation.setEditable(false);
		txtFoodDonation.setHorizontalAlignment(JTextField.CENTER);
		panelInferior.add(txtFoodDonation);
		
		panelInferior.add(new JLabel("Drink:"));
		
		txtDrinkDonation = new JTextField(df.format(drinkDonation) + " (" +
			                                  quantityOFDrinkPurchases
			                                  + " units)");
		txtDrinkDonation.setEditable(false);
		txtDrinkDonation.setHorizontalAlignment(JTextField.CENTER);
		
		panelInferior.add(txtDrinkDonation);
		
	}
	
}
