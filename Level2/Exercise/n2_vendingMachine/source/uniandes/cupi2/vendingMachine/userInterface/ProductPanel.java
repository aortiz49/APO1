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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.vendingMachine.world.Product.Types;

/*
 * Contains information about a product in the machine
 */

public class ProductPanel extends JPanel {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	// Image path
	private final static String PATH = "./data/images/";
	
	// -----------------------------------------------------------------
	// Interface Attributes
	// -----------------------------------------------------------------
	
	// Text field with product information
	private JTextField lblInfo;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/*
	 * Constructs a panel with the buttons.
	 * All the buttons were initialized.
	 * pInterface: Principal interface of the application. pInterface != null.
	 * pName: Name of product.
	 * pIdentifier: Identifier of product.
	 * pPrice: Price of product.
	 * pQuantity: Quantity of units of product.
	 * pType: Type of product.
	 * isFopre: Indicates if product donates to FOPRE.
	 */
	public ProductPanel(VendingMachineInterface pInterface, String pName, String pIdentifier,
	                    double pPrice, int pQuantity, Types pType, boolean isFopre) {
		TitledBorder b = BorderFactory.createTitledBorder(pIdentifier);
		setBorder(b);
		setLayout(new BorderLayout());
		
		String imagePath = "";
		
		if (pName.startsWith("Jugo")) {
			imagePath = PATH + "juice.png";
		} else if (pName.startsWith("Chocolatina")) {
			imagePath = PATH + "chocolate.png";
		} else if (pName.startsWith("Galletas")) {
			imagePath = PATH + "cookies.png";
		} else if (pName.startsWith("Papas")) {
			imagePath = PATH + "chips.png";
		}
		
		JLabel lblName = new JLabel(pName, JLabel.CENTER);
		add(lblName, BorderLayout.NORTH);
		
		ImageIcon icon = new ImageIcon(imagePath);
		JLabel lblImage = new JLabel(icon);
		add(lblImage, BorderLayout.CENTER);
		
		JPanel panelInferior = new JPanel(new GridLayout(4, 1));
		
		JPanel panelInfo = new JPanel(new GridLayout(1, 2));
		
		panelInfo.add(new JLabel("Available: "));
		lblInfo = new JTextField("" + pQuantity, JLabel.CENTER);
		lblInfo.setHorizontalAlignment(JLabel.CENTER);
		lblInfo.setEditable(false);
		panelInfo.add(lblInfo);
		panelInferior.add(panelInfo);
		
		DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		df.applyPattern("$###,###");
		JPanel panelPrice = new JPanel(new GridLayout(1, 2));
		JTextField txtPrice = new JTextField(df.format(pPrice), JTextField.CENTER);
		txtPrice.setEditable(false);
		txtPrice.setHorizontalAlignment(JLabel.CENTER);
		panelPrice.add(new JLabel("Price: "));
		
		panelPrice.add(txtPrice);
		panelInferior.add(panelPrice);
		
		JPanel panelType = new JPanel(new GridLayout(1, 2));
		String type = pType == Types.FOOD ? "Food" : "Drink";
		JTextField txtType = new JTextField(type, JTextField.CENTER);
		txtType.setEditable(false);
		txtType.setHorizontalAlignment(JTextField.CENTER);
		panelType.add(new JLabel("Type:"));
		panelType.add(txtType);
		panelInferior.add(panelType);
		
		JPanel panelFopre = new JPanel(new GridLayout(1, 2));
		panelFopre.add(new JLabel("FOPRE: "));
		JTextField txtFopre = new JTextField(isFopre ? "Yes" : "No");
		txtFopre.setEditable(false);
		txtFopre.setHorizontalAlignment(JTextField.CENTER);
		panelFopre.add(txtFopre);
		
		panelInferior.add(panelFopre);
		
		add(panelInferior, BorderLayout.SOUTH);
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/*
	 * Updates the panel with information received through the parameter.
	 * pPrice: Price of product.
	 * pQuantity: Quantity of product.
	 */
	public void updateInterface(double pPrice, int pQuantity) {
		lblInfo.setText(pQuantity + "");
	}
	
}
