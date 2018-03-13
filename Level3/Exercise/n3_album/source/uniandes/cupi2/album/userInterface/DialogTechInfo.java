/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n3_Album
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
 * Dialog que muestra la ficha tecnica de un player.
 */
@SuppressWarnings("serial")
public class DialogTechInfo extends JDialog {
	
	// -----------------------------------------------------------------
	// User Interface Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Campo de texto con número of the  shirt del player.
	 */
	private JTextField txtShirtNumber;
	
	/**
	 * Campo de texto con el año de nacimiento del player.
	 */
	private JTextField txtBirthYear;
	
	/**
	 * Campo de texto con la altura del player.
	 */
	private JTextField txtHeight;
	
	/**
	 * Campo de texto con el peso del player.
	 */
	private JTextField txtWeight;
	
	/**
	 * Campo de texto con la posicion del player.
	 */
	private JTextField txtPositions;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Construye el dialogo que contiene la ficha tecnica el player.<br>
	 * <b> post: </b> Todos los botones, etiquetas y campos de texto fueron inicializados y
	 * ubicados.
	 *
	 * @param pPlayer Player que se va a modify. pPlayer != null.
	 */
	public DialogTechInfo(Player pPlayer) {
		
		setSize(400, 300);
		setTitle("Tech Info");
		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelGeneral.setLayout(new BorderLayout(0, 15));
		add(panelGeneral);
		
		JLabel txtName = new JLabel(pPlayer.getName());
		txtName.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		panelGeneral.add(txtName, BorderLayout.NORTH);
		
		JPanel panelInfo = new JPanel(new GridLayout(5, 2, 0, 15));
		panelGeneral.add(panelInfo, BorderLayout.CENTER);
		
		JLabel lblShirt = new JLabel("Shirt Number: ");
		panelInfo.add(lblShirt);
		txtShirtNumber = new JTextField(pPlayer.getShirtNumber() + "");
		txtShirtNumber.setEditable(false);
		panelInfo.add(txtShirtNumber);
		
		JLabel lblBirthYear = new JLabel("Year of Birth: ");
		panelInfo.add(lblBirthYear);
		txtBirthYear = new JTextField(pPlayer.getBirthYear() + "");
		txtBirthYear.setEditable(false);
		panelInfo.add(txtBirthYear);
		
		JLabel lblHeight = new JLabel("Height: ");
		panelInfo.add(lblHeight);
		txtHeight = new JTextField(pPlayer.getHeight() + "");
		txtHeight.setEditable(false);
		panelInfo.add(txtHeight);
		
		JLabel lblWeight = new JLabel("Weight: ");
		panelInfo.add(lblWeight);
		txtWeight = new JTextField(pPlayer.getWeight() + "");
		txtWeight.setEditable(false);
		panelInfo.add(txtWeight);
		
		JLabel lblPositions = new JLabel("Position: ");
		panelInfo.add(lblPositions);
		String posicion = pPlayer.getPosition().toString().toLowerCase();
		txtPositions = new JTextField(posicion.substring(0, 1).toUpperCase() + posicion.substring
                (1));
		txtPositions.setEditable(false);
		panelInfo.add(txtPositions);
		
	}
	
}
