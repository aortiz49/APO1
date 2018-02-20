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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;

/*
 * Panel that contains the buttons and labels that make up the keypad of the machine. Also
 * includes buttons to add coins and buy products.
 */
public class KeypadPanel extends JPanel implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	// Constant to execute the action of key A.
	private final static String KEY_A = "A";
	
	// Constant to execute the action of key B.
	private final static String KEY_B = "B";
	
	// Constant to execute the action of key 1.
	private final static String KEY_1 = "1";
	
	// Constant to execute the action of key 2.
	private final static String KEY_2 = "2";
	
	// Constant to execute the action of add.
	private final static String ADD = "Add coin";
	
	// Constant to execute the action of purchase.
	private final static String PURCHASE = "Purchase product";
	
	// Constant to execute the action of terminate purchase.
	private final static String TERMINATE_PURCHASE = "Terminate purchase";
	
	// Constant that represents an empty action.
	private final static char EMPTY = '-';
	
	// Constant that represents the dimension of the key.
	private final static int ICON_DIM = 30;
	
	// Image path.
	private final static String PATH = "./data/images/";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	// Button for key A.
	private JButton btnKeyA;
	
	// Button for key B.
	private JButton btnKeyB;
	
	// Button for key 1.
	private JButton btnKey1;
	
	// Button for key 2.
	private JButton btnKey2;
	
	// Button to add credit.
	private JButton btnAdd;
	
	// Button to purchase a product.
	private JButton btnPurchase;
	
	// Button to terminate purchase
	private JButton btnTerminatePurchase;
	
	// Label to show credit available.
	private JLabel lblCredit;
	
	// Principal window of the application.
	private VendingMachineInterface principal;
	
	/*
	 * Array of chars that contains the selected identifier.
	 * Element 0 stores the letter and element 1 stores the number.
	 * It can contain the character '-' which represents empty.
	 */
	private char[] identifier;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/*
	 * Constructs a new keypad panel.
	 * Every button and label was initialized and placed.
	 *
	 * The identifier was initialized with '--'.
	 * pInterface: Principal window of the application.
	 */
	public KeypadPanel(VendingMachineInterface pInterface) {
		principal = pInterface;
		
		setBackground(new Color(65, 70, 73));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(307, 310));
		
		JPanel panelAux = new JPanel(new BorderLayout());
		panelAux.setOpaque(false);
		panelAux.setBorder(new EmptyBorder(15, 15, 0, 15));
		add(panelAux, BorderLayout.NORTH);
		
		JPanel panelSuperior = new JPanel(new BorderLayout());
		panelSuperior.setBackground(new Color(121, 125, 126));
		panelSuperior.setBorder(new EmptyBorder(0, 15, 0, 15));
		panelAux.add(panelSuperior, BorderLayout.NORTH);
		
		
		Image gradientButtonImg = new ImageIcon(PATH + "button2.png").getImage();
		btnAdd = new JButton("Add coin");
		btnAdd.setIcon(new ImageIcon(gradientButtonImg));
		btnAdd.setBorderPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setHorizontalTextPosition(JButton.CENTER);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setActionCommand(ADD);
		btnAdd.addActionListener(this);
		panelSuperior.add(btnAdd, BorderLayout.CENTER);
		
		JPanel auxImages = new JPanel(new BorderLayout());
		auxImages.setOpaque(false);
		panelSuperior.add(auxImages, BorderLayout.NORTH);
		
		JLabel auxImg = new JLabel(new ImageIcon(PATH + "play.png"));
		panelSuperior.add(auxImg, BorderLayout.WEST);
		
		JLabel auxImg2 = new JLabel(new ImageIcon(PATH + "broken.png"));
		auxImages.add(auxImg2, BorderLayout.WEST);
		
		JLabel auxImg3 = new JLabel(new ImageIcon(PATH + "coins.png"));
		auxImages.add(auxImg3, BorderLayout.CENTER);
		
		JPanel panelDisplay = new JPanel(new BorderLayout());
		panelDisplay.setBackground(new Color(121, 125, 126));
		panelDisplay.setBorder(new EmptyBorder(10, 15, 10, 15));
		panelAux.add(panelDisplay, BorderLayout.CENTER);
		
		lblCredit = new JLabel("$0000");
		lblCredit.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2, true), new
			EmptyBorder(5, 0, 5, 0)));
		lblCredit.setOpaque(true);
		lblCredit.setBackground(new Color(7, 100, 118));
		lblCredit.setHorizontalAlignment(JLabel.CENTER);
		lblCredit.setForeground(new Color(211, 232, 84));
		
		Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("./data/fonts/digital-readout/TrueType/SFDigitalReadout-Heavy.ttf"));
			lblCredit.setFont(font.deriveFont(40f));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		panelDisplay.add(lblCredit, BorderLayout.CENTER);
		
		JPanel panelKeys = new JPanel(new GridLayout(0, 2));
		panelKeys.setOpaque(false);
		panelKeys.setBorder(new EmptyBorder(10, 0, 10, 0));
		add(panelKeys, BorderLayout.CENTER);
		
		identifier = new char[2];
		identifier[0] = EMPTY;
		identifier[1] = EMPTY;
		
		
		int btnFontSize = 16;
		Image icon = new ImageIcon(PATH + "button.png").getImage().getScaledInstance(
			ICON_DIM, ICON_DIM, java.awt.Image.SCALE_SMOOTH);
		
		btnKeyA = new JButton(KEY_A);
		btnKeyA.setHorizontalAlignment(JButton.RIGHT);
		btnKeyA.setBorderPainted(false);
		btnKeyA.setFocusPainted(false);
		btnKeyA.setForeground(Color.WHITE);
		btnKeyA.setFont(new Font("Tahoma", Font.PLAIN, btnFontSize));
		btnKeyA.setHorizontalTextPosition(JButton.CENTER);
		btnKeyA.setContentAreaFilled(false);
		btnKeyA.setIcon(new ImageIcon(icon));
		btnKeyA.setActionCommand(KEY_A);
		btnKeyA.addActionListener(this);
		panelKeys.add(btnKeyA);
		
		btnKey1 = new JButton(KEY_1);
		btnKey1.setHorizontalAlignment(JButton.LEFT);
		btnKey1.setFocusPainted(false);
		btnKey1.setBorderPainted(false);
		btnKey1.setForeground(Color.WHITE);
		btnKey1.setFont(new Font("Tahoma", Font.PLAIN, btnFontSize));
		btnKey1.setHorizontalTextPosition(JButton.CENTER);
		btnKey1.setContentAreaFilled(false);
		btnKey1.setIcon(new ImageIcon(icon));
		btnKey1.addActionListener(this);
		btnKey1.setActionCommand(KEY_1);
		panelKeys.add(btnKey1);
		
		btnKeyB = new JButton(KEY_B);
		btnKeyB.setHorizontalAlignment(JButton.RIGHT);
		btnKeyB.setFocusPainted(false);
		btnKeyB.setBorderPainted(false);
		btnKeyB.setForeground(Color.WHITE);
		btnKeyB.setFont(new Font("Tahoma", Font.PLAIN, btnFontSize));
		btnKeyB.setHorizontalTextPosition(JButton.CENTER);
		btnKeyB.setContentAreaFilled(false);
		btnKeyB.setIcon(new ImageIcon(icon));
		btnKeyB.addActionListener(this);
		btnKeyB.setActionCommand(KEY_B);
		panelKeys.add(btnKeyB);
		
		btnKey2 = new JButton(KEY_2);
		btnKey2.setHorizontalAlignment(JButton.LEFT);
		btnKey2.setFocusPainted(false);
		btnKey2.setBorderPainted(false);
		btnKey2.setForeground(Color.WHITE);
		btnKey2.setFont(new Font("Tahoma", Font.PLAIN, btnFontSize));
		btnKey2.setHorizontalTextPosition(JButton.CENTER);
		btnKey2.setContentAreaFilled(false);
		btnKey2.setIcon(new ImageIcon(icon));
		btnKey2.addActionListener(this);
		btnKey2.setActionCommand(KEY_2);
		panelKeys.add(btnKey2);
		
		JPanel panelOptions = new JPanel();
		panelOptions.setLayout(new GridLayout(1, 2));
		panelOptions.setOpaque(false);
		panelOptions.setBorder(new EmptyBorder(10, 15, 10, 15));
		add(panelOptions, BorderLayout.SOUTH);
		
		btnPurchase = new JButton(PURCHASE);
		btnPurchase.setIcon(new ImageIcon(gradientButtonImg.getScaledInstance(115, 30, Image
			.SCALE_SMOOTH)));
		btnPurchase.setForeground(Color.WHITE);
		btnPurchase.setBorderPainted(false);
		btnPurchase.setContentAreaFilled(false);
		btnPurchase.setHorizontalTextPosition(JButton.CENTER);
		btnPurchase.addActionListener(this);
		btnPurchase.setActionCommand(PURCHASE);
		panelOptions.add(btnPurchase);
		
		btnTerminatePurchase = new JButton(TERMINATE_PURCHASE);
		btnTerminatePurchase.setIcon(new ImageIcon(gradientButtonImg.getScaledInstance(
			115, 30, Image.SCALE_SMOOTH)));
		btnTerminatePurchase.setForeground(Color.WHITE);
		btnTerminatePurchase.setBorderPainted(false);
		btnTerminatePurchase.setContentAreaFilled(false);
		btnTerminatePurchase.setHorizontalTextPosition(JButton.CENTER);
		btnTerminatePurchase.addActionListener(this);
		btnTerminatePurchase.setActionCommand(TERMINATE_PURCHASE);
		panelOptions.add(btnTerminatePurchase);
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/*
	 * Updates the information shown in available credit.
	 * credit: Available credit in the machine..
	 */
	public void update(double credit) {
		lblCredit.setText("$" + (int)credit);
	}
	
	/*
	 * Adds an on-button style to the selected button.
	 * pButton: Button that is to be added to the style.
	 */
	private void turnOnButton(JButton pButton) {
		Image imageOn = new ImageIcon(PATH + "on-button.png").getImage();
		pButton.setIcon(new ImageIcon(imageOn.getScaledInstance(
			ICON_DIM, ICON_DIM, Image.SCALE_SMOOTH)));
		
	}
	
	/*
	 * Removes the on-button style.
	 * pButton: Button that is to be removed from the style.
	 */
	private void offButton(JButton pButton) {
		Image buttonImg = new ImageIcon(PATH + "button.png").getImage();
		pButton.setIcon(new ImageIcon(buttonImg.getScaledInstance(
			ICON_DIM, ICON_DIM, Image.SCALE_SMOOTH)));
	}
	
	/*
	 * Resets the buttons and corresponding characters and turns them empty.
	 */
	public void resetIdentifier() {
		
		identifier[0] = EMPTY;
		identifier[1] = EMPTY;
		offButton(btnKey1);
		offButton(btnKey2);
		offButton(btnKeyA);
		offButton(btnKeyB);
	}
	
	/*
	 * Manage user events.
	 * pEvent: user event. pEvent != null.
	 */
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		
		switch (command) {
			case ADD:
				DialogAddCoin dialog = new DialogAddCoin(principal);
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(principal);
				dialog.setAlwaysOnTop(true);
				break;
			case KEY_A:
				identifier[0] = 'A';
				turnOnButton(btnKeyA);
				offButton(btnKeyB);
				break;
			case KEY_B:
				identifier[0] = 'B';
				turnOnButton(btnKeyB);
				offButton(btnKeyA);
				break;
			case KEY_1:
				identifier[1] = '1';
				turnOnButton(btnKey1);
				offButton(btnKey2);
				break;
			case KEY_2:
				identifier[1] = '2';
				turnOnButton(btnKey2);
				offButton(btnKey1);
				break;
			case PURCHASE:
				if ((identifier[0] == EMPTY || identifier[1] == EMPTY) && (command.equals
					(TERMINATE_PURCHASE) || command.equals(PURCHASE))) {
					JOptionPane.showMessageDialog(principal, "No identifier selected.",
					                              command, JOptionPane.WARNING_MESSAGE);
				} else {
					principal.purchaseProduct(new String(identifier));
				}
				break;
			case TERMINATE_PURCHASE:
				resetIdentifier();
				principal.terminatePurchase();
				break;
			
		}
	}
}
