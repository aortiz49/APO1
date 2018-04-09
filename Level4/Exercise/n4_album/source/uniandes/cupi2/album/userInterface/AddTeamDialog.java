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
 * Dialog to add a team.
 */
@SuppressWarnings("serial")
public class AddTeamDialog extends JDialog implements ActionListener {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to execute the action of button addBtn.
	 */
	private static final String ADD = "ADD";
	
	/**
	 * Command to execute the action of button cancelBtn.
	 */
	private static final String CANCEL = "CANCEL";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Principal window of the application.
	 */
	private AlbumInterface principal;
	
	// -----------------------------------------------------------------
	// User interface attributes
	// -----------------------------------------------------------------
	
	/**
	 * Text field for the team's country.
	 */
	private JTextField txtCountry;
	
	/**
	 * Text field for the year in which the team played.
	 */
	private JTextField txtYear;
	
	/**
	 * Button to perform the team addition to the album.
	 */
	private JButton addBtn;
	
	/**
	 * Button to cancel the team addition to the album.
	 */
	private JButton cancelBtn;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the dialog that adds a new team to the album. <br>
	 * <b> post: </b> All of the buttons, labels, and text fields were initialized and placed.
	 * The principal attribute was initialized with the value given by the parameter.
	 *
	 * @param pUserInterface Principal interface of the application. pUserInterface != null
	 */
	public AddTeamDialog(AlbumInterface pUserInterface) {
		principal = pUserInterface;
		setSize(300, 150);
		setTitle("Add Team");
		
		JPanel generalPanel = new JPanel(new GridLayout(3, 2, 0, 10));
		generalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(generalPanel);
		
		generalPanel.add(new JLabel("Country"));
		txtCountry = new JTextField();
		generalPanel.add(txtCountry);
		
		generalPanel.add(new JLabel("Year"));
		txtYear = new JTextField();
		generalPanel.add(txtYear);
		
		addBtn = new JButton("Add");
		addBtn.setActionCommand(ADD);
		addBtn.addActionListener(this);
		generalPanel.add(addBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setActionCommand(CANCEL);
		cancelBtn.addActionListener(this);
		generalPanel.add(cancelBtn);
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Handles user events.
	 *
	 * @param pEvent User event. . pEvent != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		
		switch (command) {
			case CANCEL:
				dispose();
				break;
			case ADD:
				String country = txtCountry.getText();
				int year = 0;
				
				try {
					year = Integer.parseInt(txtYear.getText().trim());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "The year must be an integer value.",
					                              "Value is not numeric ",
					                              JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				dispose();
				principal.addTeam(country, year);
				break;
			
		}
	}
}
