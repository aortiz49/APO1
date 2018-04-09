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
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Player;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

/**
 * Dialog that displays the player's information.
 */
@SuppressWarnings("serial")
public class PlayerDialog extends JDialog {
	
	// -----------------------------------------------------------------
	// User interface attributes
	// -----------------------------------------------------------------
	
	/**
	 * Text field with the player's name.
	 */
	private JTextField txtName;
	
	/**
	 * Text field with the player's year of birth..
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
	 * Text field with player's position.
	 */
	private JTextField txtPosition;
	
	/**
	 * Text field with player's team.
	 */
	private JTextField txtTeam;
	
	/**
	 * Label that contains the image of the player.
	 */
	private JLabel cardLbl;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the dialog that contains the player's technical information. <br>
	 * <b> post: </b> Every button, label, and text field was initialized and placed.
	 *
	 * @param pTeam   Team in which the player belongs to. pTeam != null.
	 * @param pPlayer Player to display. pPlayer != null.
	 */
	public PlayerDialog(Team pTeam, Player pPlayer) {
		
		setSize(450, 300);
		setTitle("Tech info");
		JPanel generalPanel = new JPanel();
		generalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(generalPanel);
		
		generalPanel.setLayout(new BorderLayout(0, 15));
		JPanel panelInfo = new JPanel(new GridLayout(5, 2, 0, 15));
		generalPanel.add(panelInfo, BorderLayout.CENTER);
		
		cardLbl = new JLabel();
		ImageIcon icon;
		
		if (pPlayer.hasCard()) {
			File fileImage = new File("./data/images/" + pTeam.getCountry() + "/" + pTeam.getYear
				() + "/" + pPlayer.getCard().getImageName());
			icon = fileImage.exists() ? new ImageIcon(fileImage.getAbsolutePath()) : CardPanel
				.DEFAULT_CARD;
		} else {
			icon = new ImageIcon("./data/images/toPaste.png");
		}
		cardLbl.setIcon(icon);
		add(cardLbl, BorderLayout.WEST);
		
		txtName = new JTextField(pPlayer.getName());
		txtName.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setEditable(false);
		generalPanel.add(txtName, BorderLayout.NORTH);
		
		JLabel lblTeam = new JLabel("Team: ");
		panelInfo.add(lblTeam);
		txtTeam = new JTextField(pTeam.toString());
		txtTeam.setEditable(false);
		panelInfo.add(txtTeam);
		
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
