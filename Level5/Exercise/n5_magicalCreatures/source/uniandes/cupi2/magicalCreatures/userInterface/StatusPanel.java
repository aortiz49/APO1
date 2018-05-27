/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n5_MagicalCreatures
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.magicalCreatures.userInterface;

import uniandes.cupi2.magicalCreatures.world.Creature;
import uniandes.cupi2.magicalCreatures.world.MagicalCreatures;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Contains the status panel of the interface.
 */
public class StatusPanel extends JPanel {
	
	// -----------------------------------------------------------------
	// Attributes of the interface
	// -----------------------------------------------------------------
	
	/**
	 * Label for the points.
	 */
	private JLabel pointsLabel;
	
	/**
	 * Label for the remaining moves.
	 */
	private JLabel remainingMovesLbl;
	
	/**
	 * Text field for the points.
	 */
	private JTextField pointsTxt;
	
	/**
	 * Text field for the points.
	 */
	private JTextField remainingMovesTxt;
	
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Creates a new status panel.
	 */
	public StatusPanel() {
		setLayout(new GridLayout(1, 4, 5, 5));
		setBackground(new Color(48, 41, 84));
		TitledBorder border = new TitledBorder("Game status");
		border.setTitleColor(Color.WHITE);
		setBorder(border);
		
		// Create and add points label.
		pointsLabel = new JLabel("Points:");
		pointsLabel.setForeground(Color.WHITE);
		add(pointsLabel);
		
		
		// Create and add points text field to the panel.
		pointsTxt = new JTextField();
		pointsTxt.setEditable(false);
		pointsTxt.setForeground(Color.WHITE);
		pointsTxt.setBackground(new Color(48, 41, 84));
		add(pointsTxt);
		
		// Create and add remaining moves label to the panel.
		remainingMovesLbl = new JLabel("Remaining movements:");
		remainingMovesLbl.setForeground(Color.WHITE);
		add(remainingMovesLbl);
		
		// Create and add remaining moves text field to the panel.
		remainingMovesTxt = new JTextField();
		remainingMovesTxt.setEditable(false);
		remainingMovesTxt.setForeground(Color.WHITE);
		remainingMovesTxt.setBackground(new Color(48, 41, 84));
		add(remainingMovesTxt);
		
	}
	
	/**
	 * Updates the panel to show the player's accumulated points of moves remaining.
	 *
	 * @param pPoints         Points accumulated by the user. pPoints &gt; =  0.
	 * @param pRemainingMoves Remaining moves to be performed by the user. pRemaining moves &gt;
	 *                           = 0.
	 */
	public void updatePanel(int pPoints, int pRemainingMoves) {
		pointsTxt.setText(Integer.toString(pPoints));
		remainingMovesTxt.setText(Integer.toString(pRemainingMoves));
	}
	
}
		

	

