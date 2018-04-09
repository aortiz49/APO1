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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Dialog that displays a player search.
 */
public class FindPlayerDialog extends JDialog implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to execute the action of button cancelBtn.
	 */
	private static final String CANCEL = "CANCEL";
	
	/**
	 * Command to execute the action of button btnFind.
	 */
	private static final String FIND = "FIND";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Principal window of the application
	 */
	private AlbumInterface principal;
	
	// -----------------------------------------------------------------
	// User interface attributes
	// -----------------------------------------------------------------
	
	/**
	 * Text field for the player's country.
	 */
	private JTextField txtCountry;
	
	/**
	 * Text field for el year in which the player represented his country.
	 */
	private JTextField txtYear;
	
	/**
	 * Player's shirt number.
	 */
	private JTextField txtShirtNumber;
	
	/**
	 * Button to make a player search.
	 */
	private JButton btnFind;
	
	/**
	 * Button to cancel the search.
	 */
	private JButton cancelBtn;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the dialog that modifies the player.<br>
	 * <b> post: </b> Every button, label, and text field was initialized and placed.
	 * The principal attribute was assigned to the value given by the parameter.
	 *
	 * @param pUserInterface Principal interface of the application. pUserInterface != null
	 */
	public FindPlayerDialog(AlbumInterface pUserInterface) {
		principal = pUserInterface;
		setSize(300, 200);
		setTitle("Find player");
		
		JPanel generalPanel = new JPanel(new GridLayout(4, 2, 0, 10));
		generalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(generalPanel);
		
		generalPanel.add(new JLabel("Shirt number"));
		txtShirtNumber = new JTextField();
		generalPanel.add(txtShirtNumber);
		
		generalPanel.add(new JLabel("Country"));
		txtCountry = new JTextField();
		generalPanel.add(txtCountry);
		
		generalPanel.add(new JLabel("Year"));
		txtYear = new JTextField();
		generalPanel.add(txtYear);
		
		btnFind = new JButton("Find");
		btnFind.setActionCommand(FIND);
		btnFind.addActionListener(this);
		generalPanel.add(btnFind);
		
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
	 * @param pEvent User event. pEvent != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		switch (command) {
			case CANCEL:
				dispose();
				break;
			case FIND:
				String country = txtCountry.getText();
				int shirt = 0;
				int year = 0;
				try {
					shirt = Integer.parseInt(txtShirtNumber.getText().trim());
					if (shirt <= 0) {
						throw new Exception();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "The number on the shirt is invalid. \n" +
						"It must be numeric and greater than zero.", "Illegal value", JOptionPane
						                              .ERROR_MESSAGE);
					
					break;
				}
				
				try {
					year = Integer.parseInt(txtYear.getText().trim());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "The year must be an integer value.",
					                              "Valor is not numeric ", JOptionPane
						                              .ERROR_MESSAGE);
					break;
				}
				
				dispose();
				principal.findPlayer(shirt, country, year);
				break;
			
		}
		
	}
	
}
