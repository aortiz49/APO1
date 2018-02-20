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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/*
 * Contains the buttons on the bottom of the interface.
 */
public class OptionsPanel extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	// Command to execute option1.
	private static final String OPTION1 = "Option 1";
	
	// Command to execute option2.
	private static final String OPTION2 = "Option 2";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/*
	 * Main window of the application.
	 */
	private VendingMachineInterface principal;
	
	// -----------------------------------------------------------------
	// Attributes de la userInterface
	// -----------------------------------------------------------------
	
	// Button for option1.
	private JButton btnOption1;
	
	// Button for option2.
	private JButton btnOption2;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/*
	 * Constructs a panel with the buttons.
	 * Every button was initialized.
	 * pPrincipal: Principal interface of the application. pPrincipal != null
	 */
	public OptionsPanel(VendingMachineInterface pPrincipal) {
		TitledBorder b = BorderFactory.createTitledBorder("Options");
		setBorder(b);
		
		principal = pPrincipal;
		setLayout(new GridLayout(1, 3));
		
		btnOption1 = new JButton(OPTION1);
		btnOption2 = new JButton(OPTION2);
		
		btnOption1.addActionListener(this);
		btnOption2.addActionListener(this);
		
		btnOption1.setActionCommand(OPTION1);
		btnOption2.setActionCommand(OPTION2);
		
		add(btnOption1);
		add(btnOption2);
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/*
	 * Manages user events.
	 * pEvent: User event. pEvent != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		if (pEvent.getActionCommand().equals(OPTION1)) {
			principal.reqFuncOption1();
		} else if (pEvent.getActionCommand().equals(OPTION2)) {
			principal.reqFuncOption2();
		}
	}
	
}
