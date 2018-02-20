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

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Represents dialog of purchase information.
 */

public class DialogUnitsPurchased extends JDialog {
	
	// -----------------------------------------------------------------
	// Interface Attributes.
	// -----------------------------------------------------------------
	
	// Text field with total purchases.
	private JTextField txtTotalQuantity;
	
	/**
	 * Text field with the purchase information of all the products.
	 */
	private JTextField txtProductQuantity1;
	private JTextField txtProductQuantity2;
	private JTextField txtProductQuantity3;
	private JTextField txtProductQuantity4;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/*
	 * Constructs a dialog with information about purchased units.
	 * Created a dialog with each of its components.
	 * pTotalQuantity: Total quantity of units purchased. pTotalQuantity >=0.
	 * pProductQuantity1: Quantity of units purchased of product 1. pProductQuantity1>=0.
	 * pProductName1: Name of product 1. pName != null && pName != "".
	 * pProductQuantity2: Quantity of units purchased of product 2. pProductQuantity2>=0.
	 * pProductName2: Name of product 2. pName != null && pName != "".
	 * pProductQuantity3: Quantity of units purchased of product 3. pProductQuantity3>=0.
	 * pProductName3: Name of product 3. pName != null && pName != "".
	 * pProductQuantity4: Quantity of units purchased of product 4. pProductQuantity4>=0.
	 * pProductName4: Name of product 4. pName != null && pName != "".
	 */
	public DialogUnitsPurchased(int pTotalQuantity, int pProductQuantity1, String pProductName1,
                                int pProductQuantity2, String pProductName2, int
                                    pProductQuantity3, String pProductName3, int pProductQuantity4,
	                            String pProductName4) {
		setTitle("Information about purchased units");
		setSize(380, 250);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JPanel generalPanel = new JPanel();
		generalPanel.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new
            TitledBorder("Quantity of units purchased:")));
		generalPanel.setLayout(new GridLayout(5, 2, 4, 4));
		add(generalPanel, BorderLayout.CENTER);
		
		JLabel lblTotal = new JLabel("Total:");
		generalPanel.add(lblTotal);
		
		txtTotalQuantity = new JTextField(pTotalQuantity + "");
		txtTotalQuantity.setEditable(false);
		generalPanel.add(txtTotalQuantity);
		
		JLabel lblProduct1 = new JLabel(pProductName1 + ":");
		generalPanel.add(lblProduct1);
		
		txtProductQuantity1 = new JTextField(pProductQuantity1 + "");
		txtProductQuantity1.setEditable(false);
		generalPanel.add(txtProductQuantity1);
		
		JLabel lblProduct2 = new JLabel(pProductName2 + ":");
		generalPanel.add(lblProduct2);
		
		txtProductQuantity2 = new JTextField(pProductQuantity2 + "");
		txtProductQuantity2.setEditable(false);
		generalPanel.add(txtProductQuantity2);
		
		JLabel lblProduct3 = new JLabel(pProductName3 + ":");
		generalPanel.add(lblProduct3);
		
		txtProductQuantity3 = new JTextField(pProductQuantity3 + "");
		txtProductQuantity3.setEditable(false);
		generalPanel.add(txtProductQuantity3);
		
		JLabel lblProduct4 = new JLabel(pProductName4 + ":");
		generalPanel.add(lblProduct4);
		
		txtProductQuantity4 = new JTextField(pProductQuantity4 + "");
		txtProductQuantity4.setEditable(false);
		generalPanel.add(txtProductQuantity4);
	}
}
