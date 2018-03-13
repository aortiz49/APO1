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
 * Dialog to realize a player search.
 */
public class DialogFindPlayer extends JDialog implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to execute the action of the button addBtn.
	 */
	private static final String FIND = "FIND";
	
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
	// Attributes of the  userInterface
	// -----------------------------------------------------------------
	
	/**
	 * Text field for the player's country.
	 */
	private JTextField txtCountry;
	
	/**
	 * Text field for the year in which the player was on the team.
	 */
	private JTextField txtYear;
	
	/**
	 * Text field for the player's shirt number.
	 */
	private JTextField txtShirt;
	
	/**
	 * Button to perform player search.
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
	 * Constructs a dialogue that finds a player. <br>
	 * <b> post: </b> Every button, label, and text field was initialized and placed.
	 * Main attribute was assigned to teh value given by the parameter.
	 *
	 * @param pUserInterface UserInterface is the main interface of the application.
	 *                       pUserInterface != null.
	 */
	public DialogFindPlayer(albumInterface pUserInterface) {
		principal = pUserInterface;
		setSize(300, 200);
		setTitle("Find player");
		
		JPanel panelGeneral = new JPanel(new GridLayout(4, 2, 0, 10));
		panelGeneral.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panelGeneral);
		
		panelGeneral.add(new JLabel("Shirt number"));
		txtShirt = new JTextField();
		panelGeneral.add(txtShirt);
		
		panelGeneral.add(new JLabel("Country"));
		txtCountry = new JTextField();
		panelGeneral.add(txtCountry);
		
		panelGeneral.add(new JLabel("Year"));
		txtYear = new JTextField();
		panelGeneral.add(txtYear);
		
		btnFind = new JButton("Find");
		btnFind.setActionCommand(FIND);
		btnFind.addActionListener(this);
		panelGeneral.add(btnFind);
		
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
			case FIND:
				String country = txtCountry.getText();
				int shirt = 0;
				int year = 0;
				try {
					shirt = Integer.parseInt(txtShirt.getText().trim());
					if(shirt <= 0) {
						throw new Exception();
					}
				} catch(Exception e) {
					JOptionPane.showMessageDialog(this, "Invalid shirt number." +
							".\nValue must be numeric and > 0.", "Invalid Value", JOptionPane
							.ERROR_MESSAGE);
					break;
				}
				
				try {
					year = Integer.parseInt(txtYear.getText().trim());
				} catch(Exception e) {
					JOptionPane.showMessageDialog(this, "Year must be an integer. ","Value is " +
							"not numeric.", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				dispose();
				principal.findPlayer(shirt, country, year);
				break;
			
		}
		
	}
	
}
