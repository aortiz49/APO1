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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

/*
 * Dialog to add a coin.
 */
public class DialogAddCoin extends JDialog implements ActionListener {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	// Constant that represents the image size of the coins
	private final static int ICON_DIMENSION = 100;
	
	// Constant that represents the image path
	private final static String PATH = "./data/images/";
	
	// -----------------------------------------------------------------
	// Interface Attributes
	// -----------------------------------------------------------------
	
	// Array with coin buttons
	private JButton[] btnCoin;
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	// Principal window of the application
	private VendingMachineInterface principal;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/*
	 * Creates a new dialog.
	 * Components of the dialog were initialized.
	 * pPrincipal: Principal window of the application. pPrincipal != null.
	 */
	public DialogAddCoin(VendingMachineInterface pPrincipal) {
		principal = pPrincipal;
		
		setTitle("Add Coin");
		setSize(ICON_DIMENSION * 6, (int)(ICON_DIMENSION * 1.5));
		setLayout(new GridLayout(1, 5));
		
		String[] coins = {"50", "100", "200", "500", "1000"};
		btnCoin = new JButton[coins.length];
		
		for (int i = 0; i < coins.length; i++) {
			btnCoin[i] = new JButton();
			ImageIcon icon = new ImageIcon(PATH + coins[i] + ".png");
			icon = new ImageIcon(icon.getImage().getScaledInstance(ICON_DIMENSION, ICON_DIMENSION,
			                                                       Image.SCALE_SMOOTH));
			btnCoin[i].setIcon(icon);
			btnCoin[i].setActionCommand(coins[i]);
			btnCoin[i].addActionListener(this);
			add(btnCoin[i]);
		}
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/*
	 * Manage user events.
	 * pEvent: User event. pEvent != null.
	 */
	public void actionPerformed(ActionEvent pEvent) {
		int coin = Integer.parseInt(pEvent.getActionCommand());
		dispose();
		principal.addCoin(coin);
	}
	
}
