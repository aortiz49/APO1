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
public class DialogAddTeam extends JDialog implements ActionListener {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to execute the action of the button addBtn.
	 */
	private static final String ADD = "ADD";
	
	/**
	 * Command to execute the action of the button cancelBtn.
	 */
	private static final String CANCEL = "CANCEL";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Main window of the application.
	 */
	private albumInterface principal;
	
	// -----------------------------------------------------------------
	// Interface Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Text field for the player's text field.
	 */
	private JTextField txtCountry;
	
	/**
	 * Text field for the year in which the player was on the team.
	 */
	private JTextField txtYear;
	
	/**
	 * Button to perform player search.
	 */
	private JButton addBtn;
	
	/**
	 * Button to cancel the search.
	 */
	private JButton cancelBtn;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs a dialogue that adds the team. <br>
	 * <b> post: </b> Every button, label, and text field was initialized and placed.
	 * Main attribute was assigned to teh value given by the parameter.
	 *
	 * @param pUserInterface UserInterface is the main interface of the application.
	 *                       pUserInterface != null.
	 */
	public DialogAddTeam(albumInterface pUserInterface) {
		principal = pUserInterface;
		setSize(300, 150);
		setTitle("Add team");
		
		JPanel panelGeneral = new JPanel(new GridLayout(3, 2, 0, 10));
		panelGeneral.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panelGeneral);
		
		panelGeneral.add(new JLabel("Country"));
		txtCountry = new JTextField();
		panelGeneral.add(txtCountry);
		
		panelGeneral.add(new JLabel("Year"));
		txtYear = new JTextField();
		panelGeneral.add(txtYear);
		
		addBtn = new JButton("Add");
		addBtn.setActionCommand(ADD);
		addBtn.addActionListener(this);
		panelGeneral.add(addBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setActionCommand(CANCEL);
		cancelBtn.addActionListener(this);
		panelGeneral.add(cancelBtn);
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
		
		switch(command) {
			case CANCEL:
				dispose();
				break;
			case ADD:
				String country = txtCountry.getText();
				int year = 0;
				
				try {
					year = Integer.parseInt(txtYear.getText().trim());
				} catch(Exception e) {
					JOptionPane.showMessageDialog(this, "Year must be an integer. ","Value is " +
							"not numeric.", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				dispose();
				principal.addTeam(country, year);
				break;
			
		}
	}
}
