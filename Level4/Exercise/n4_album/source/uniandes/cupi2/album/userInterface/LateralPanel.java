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

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Panel that contains the later navigation buttons.
 */
public class LateralPanel extends JPanel implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Constant that represents the action of going to the previous team.
	 */
	public static final String PREVIOUS = "<";
	
	/**
	 * Constant that represents the action of going to the next team.
	 */
	public static final String NEXT = ">";
	
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
	 * Button with the arrow indicating the direction.
	 */
	private JButton directionBtn;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the panel with the lateral direction buttons.  <br>
	 * <b>post:</b> Every button was initialized.  The principal attribute was assigned to the
	 * value given by the parameter.
	 *
	 * @param pUserInterface Principal interface of the application. pUserInterface != null
	 * @param pDirection     Direction represented in the lateral panel. pDirection  != null &amp;
	 *                          &amp;
	 *                       pDirection belongs to {PREVIOUS, NEXT}
	 */
	public LateralPanel(AlbumInterface pUserInterface, String pDirection) {
		principal = pUserInterface;
		
		setLayout(new GridLayout(5, 1));
		setOpaque(false);
		
		add(new JLabel());
		add(new JLabel());
		directionBtn = new JButton();
		directionBtn.setActionCommand(pDirection);
		directionBtn.setContentAreaFilled(false);
		directionBtn.setBorder(null);
		directionBtn.setIcon(new ImageIcon(pDirection.equals(PREVIOUS) ? "./data/images/previous" +
			".png" : "./data/images/next.png"));
		directionBtn.addActionListener(this);
		
		add(directionBtn, BorderLayout.CENTER);
		add(new JLabel());
		add(new JLabel());
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Manages user events.
	 *
	 * @param pEvent User event. . pEvent != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		switch (command) {
			case PREVIOUS:
				principal.previous();
				break;
			case NEXT:
				principal.next();
				break;
			
		}
		
	}
	
}
