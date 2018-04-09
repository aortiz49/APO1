/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n4_Album
 * Author: Andres Ortiz
 */


package uniandes.cupi2.album.userInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.album.world.Player;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

/**
 * Dialog that displays the technical information of a player.
 */
@SuppressWarnings("serial")
public class TechInfoDialog extends JDialog {
	
	// -----------------------------------------------------------------
	// User interface attributes
	// -----------------------------------------------------------------
	
	/**
	 * Text field with the player's shirt number.
	 */
	private JTextField txtShirtNumber;
	
	/**
	 * Text field with the player's name.
	 */
	private JTextField txtName;
	
	/**
	 * Text field with the player's birth year.
	 */
	private JTextField txtBirthYear;
	
	/**
	 * Text field with the player's height.
	 */
	private JTextField txtHeight;
	
	/**
	 * Text field with the player's weight.
	 */
	private JTextField txtWeight;
	
	/**
	 * Text field with the player's position.
	 */
	private JTextField txtPosition;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the dialog that contains the player's technical information. <br>
	 * <b> post: </b> All of the buttons, labels, and text fields were initialized and placed.
	 *
	 * @param pPlayer Player que se va a modifyPlayer. pPlayer != null.
	 */
	public TechInfoDialog(Player pPlayer) {
		
		setSize(400, 300);
		setTitle("Tech info");
		
		JPanel generalPanel = new JPanel();
		generalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		generalPanel.setLayout(new BorderLayout(0, 15));
		add(generalPanel);
		
		JLabel txtName = new JLabel(pPlayer.getName());
		txtName.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		generalPanel.add(txtName, BorderLayout.NORTH);
		
		JPanel panelInfo = new JPanel(new GridLayout(5, 2, 0, 15));
		generalPanel.add(panelInfo, BorderLayout.CENTER);
		
		JLabel shirtNumberLbl = new JLabel("Shirt number: ");
		panelInfo.add(shirtNumberLbl);
		txtShirtNumber = new JTextField(pPlayer.getShirtNumber() + "");
		txtShirtNumber.setEditable(false);
		panelInfo.add(txtShirtNumber);
		
		JLabel birthYearLbl = new JLabel("Year of birth: ");
		panelInfo.add(birthYearLbl);
		txtBirthYear = new JTextField(pPlayer.getBirthYear() + "");
		txtBirthYear.setEditable(false);
		panelInfo.add(txtBirthYear);
		
		JLabel heightLbl = new JLabel("Height: ");
		panelInfo.add(heightLbl);
		txtHeight = new JTextField(pPlayer.getHeight() + "");
		txtHeight.setEditable(false);
		panelInfo.add(txtHeight);
		
		JLabel weightLbl = new JLabel("Weight: ");
		panelInfo.add(weightLbl);
		txtWeight = new JTextField(pPlayer.getWeight() + "");
		txtWeight.setEditable(false);
		panelInfo.add(txtWeight);
		
		JLabel positionLbl = new JLabel("Position: ");
		panelInfo.add(positionLbl);
		String position = pPlayer.getPosition().toString().toLowerCase();
		txtPosition = new JTextField(position.substring(0, 1).toUpperCase() + position.substring
			(1));
		txtPosition.setEditable(false);
		panelInfo.add(txtPosition);
		
	}
	
}
