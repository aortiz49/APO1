/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n4_Album
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.userInterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Position;

/**
 * Panel that allows for the modification of a player's information.
 */
@SuppressWarnings("serial")
public class ModifyPlayerDialog extends JDialog implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to execute the action of button saveBtn.
	 */
	private final static String SAVE = "SAVE";
	
	/**
	 * Command to execute the action of button cancelBtn.
	 */
	private final static String CANCEL = "Cancel";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Player on the card.
	 */
	private Player player;
	
	/**
	 * Country represented by player on the card.
	 */
	private String country;
	
	/**
	 * Year in which player on card represented his country.
	 */
	private int year;
	
	/**
	 * Principal window of the application
	 */
	private AlbumInterface principal;
	
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
	 * Combo box with the player positions.
	 */
	private JComboBox<String> cbPosition;
	
	/**
	 * Button for the save option.
	 */
	private JButton saveBtn;
	
	/**
	 * Button for the cancel option.
	 */
	private JButton cancelBtn;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the dialog that modifies the player.<br>
	 * <b> post: </b> All of the buttons, labels, and text fields were initialized and placed.
	 * Interface, country, year, and player attributes were initialized with the values given by
	 * the parameters.
	 *
	 * @param pUserInterface Principal interface of the application. pUserInterface != null
	 * @param pCountry       Country of the player searched. pCountry != null &amp;&amp;  pCountry
	 *                         != "".
	 * @param pYear          Year in which the searched team represented the country. pYear &gt; 0.
	 * @param pPlayer        Player that will be modified. pPlayer != null.
	 */
	public ModifyPlayerDialog(AlbumInterface pUserInterface, String pCountry, int pYear, Player
		pPlayer) {
		
		principal = pUserInterface;
		player = pPlayer;
		country = pCountry;
		year = pYear;
		
		setSize(400, 300);
		setTitle("Modify Player");
		
		JPanel generalPanel = new JPanel();
		add(generalPanel);
		generalPanel.setLayout(new GridLayout(7, 2, 0, 5));
		generalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel shirtNumberLbl = new JLabel("Shirt number:");
		generalPanel.add(shirtNumberLbl);
		txtShirtNumber = new JTextField(pPlayer.getShirtNumber() + "");
		txtShirtNumber.setEditable(true);
		generalPanel.add(txtShirtNumber);
		
		JLabel nameLbl = new JLabel("Name:");
		generalPanel.add(nameLbl);
		txtName = new JTextField(pPlayer.getName());
		txtName.setEditable(true);
		generalPanel.add(txtName);
		
		JLabel birthYearLbl = new JLabel("Year of birth: ");
		generalPanel.add(birthYearLbl);
		txtBirthYear = new JTextField(pPlayer.getBirthYear() + "");
		txtBirthYear.setEditable(true);
		generalPanel.add(txtBirthYear);
		
		JLabel heightLbl = new JLabel("Height: ");
		generalPanel.add(heightLbl);
		txtHeight = new JTextField(pPlayer.getHeight() + "");
		txtHeight.setEditable(true);
		generalPanel.add(txtHeight);
		
		JLabel weightLbl = new JLabel("Weight: ");
		generalPanel.add(weightLbl);
		txtWeight = new JTextField(pPlayer.getWeight() + "");
		txtWeight.setEditable(true);
		generalPanel.add(txtWeight);
		
		JLabel positionLbl = new JLabel("Position: ");
		generalPanel.add(positionLbl);
		cbPosition = new JComboBox<>(getPositions());
		cbPosition.setSelectedItem(pPlayer.getPosition());
		generalPanel.add(cbPosition);
		
		saveBtn = new JButton("SAVE");
		saveBtn.setActionCommand(SAVE);
		saveBtn.addActionListener(this);
		generalPanel.add(saveBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setActionCommand(CANCEL);
		cancelBtn.addActionListener(this);
		generalPanel.add(cancelBtn);
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Manages user events.
	 *
	 * @param pEvent User event. . pEvent != null.
	 */
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		switch (command) {
			case SAVE:
				
				String name = txtName.getText().trim();
				if (name.equals("")) {
					JOptionPane.showMessageDialog(this, "The player's name cannot be empty",
					                              "Illegal value", JOptionPane.ERROR_MESSAGE);
					break;
				}
				if (!isNumeric(txtBirthYear.getText())) {
					JOptionPane.showMessageDialog(this, "The year of birth must have an integer " +
						                              "value", "Value is not numeric",
					                              JOptionPane.ERROR_MESSAGE);
					break;
				}
				int birthYear = Integer.parseInt(txtBirthYear.getText());
				if (!isNumeric(txtHeight.getText())) {
					JOptionPane.showMessageDialog(this, "The height must have a numeric value",
					                              "Value is not numeric",
					                              JOptionPane.ERROR_MESSAGE);
					break;
				}
				double height = Double.parseDouble(txtHeight.getText());
				
				if (!isNumeric(txtWeight.getText())) {
					JOptionPane.showMessageDialog(this, "The weight must have a numeric value",
					                              "Value is not numeric",
					                              JOptionPane.ERROR_MESSAGE);
					break;
				}
				double peso = Double.parseDouble(txtWeight.getText());
				
				if (!isNumeric(txtShirtNumber.getText())) {
					JOptionPane.showMessageDialog(this, "The shirt number must have a numeric " +
						"value", "Valor is not numeric", JOptionPane.ERROR_MESSAGE);
					break;
				}
				int ShirtNumber = Integer.parseInt(txtShirtNumber.getText());
				if (ShirtNumber <= 0) {
					JOptionPane.showMessageDialog(this, "The shirt number must be greater " +
						"than 0", "Illegal value", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				principal.modifyPlayer(country, year, player.getShirtNumber(), ShirtNumber, name,
				                       Objects.requireNonNull(cbPosition.getSelectedItem())
				                              .toString(), birthYear, height, peso);
				dispose();
				
				
				break;
			case CANCEL:
				dispose();
				break;
			
		}
	}
	
	/**
	 * Returns the list of available positions.
	 *
	 * @return Returns the list of positions.
	 */
	public String[] getPositions() {
		Position[] positions = Position.values();
		String[] positionsStr = new String[positions.length];
		for (int i = 0; i < positionsStr.length; i++) {
			String position = positions[i].toString().toLowerCase();
			positionsStr[i] = position.substring(0, 1).toUpperCase() + position.substring(1);
		}
		return positionsStr;
	}
	
	
	/**
	 * Indicates if a string is numeric.
	 *
	 * @param pString String of characters to validate. pString != null &amp;&amp;  pString != "".
	 *
	 * @return True if the string of characters is numeric, false if contrary.
	 */
	private boolean isNumeric(String pString) {
		try {
			Double.parseDouble(pString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
