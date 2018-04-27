package uniandes.cupi2.magicalCreatures.userInterface;

import uniandes.cupi2.magicalCreatures.world.MagicalCreatures;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ActionsPanel extends JPanel implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to view the creatures in a row.
	 */
	public final static String CREATURES_IN_ROW = "Creatures in row";
	
	/**
	 * Command to view the creatures in a column.
	 */
	public final static String CREATURES_IN_COLUMN = "Creatures in column";
	
	/**
	 * Command to view the points still available in a quadrant.
	 */
	public final static String POINTS_IN_QUADRANT = "Points in quadrant";
	
	/**
	 * Command to view the creature with the highest points yet to be discovered.
	 */
	public final static String HIGHEST_POINT_CREATURE = "Highest-point creature";
	
	// -----------------------------------------------------------------
	// Attributes of theinterface
	// -----------------------------------------------------------------
	
	/**
	 * Button to view the creatures in a row.
	 */
	private JButton creaturesInRowBtn;
	
	/**
	 * Button to view the creatures in a column.
	 */
	private JButton creaturesInColumnBtn;
	
	/**
	 * Button to view the points still available in a quadrant.
	 */
	private JButton pointsInQuadrantBtn;
	
	/**
	 * Button to view the creature with the highest points yet to be discovered.
	 */
	private JButton highestPointCreatureBtn;
	
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Principal window od the application.
	 */
	private MagicalCreaturesUserInterface principal;
	
	public ActionsPanel(MagicalCreaturesUserInterface pPrincipal) {
		principal = pPrincipal;
		setBackground(new Color(48, 41, 84));
		setLayout(new GridLayout(1, 4, 0, 5));
		TitledBorder border = new TitledBorder("Actions");
		border.setTitleColor(Color.WHITE);
		setBorder(border);
		
		// Create "creatures in row" button and add to navigation panel.
		creaturesInRowBtn = new JButton("Creatures in row");
		creaturesInRowBtn.setActionCommand(CREATURES_IN_ROW);
		creaturesInRowBtn.addActionListener(this);
		creaturesInRowBtn.setEnabled(false);
		add(creaturesInRowBtn);
		
		// Create "creatures in column" button and add to navigation panel.
		creaturesInColumnBtn = new JButton("Creatures in column");
		creaturesInColumnBtn.setActionCommand(CREATURES_IN_COLUMN);
		creaturesInColumnBtn.addActionListener(this);
		creaturesInColumnBtn.setEnabled(false);
		add(creaturesInColumnBtn);
		
		// Create "points in quadrant" button and add to navigation panel.
		pointsInQuadrantBtn = new JButton("Points in quadrant");
		pointsInQuadrantBtn.setActionCommand(POINTS_IN_QUADRANT);
		pointsInQuadrantBtn.addActionListener(this);
		pointsInQuadrantBtn.setEnabled(false);
		add(pointsInQuadrantBtn);
		
		// Create "Highest-point creature" button and add to navigation panel.
		highestPointCreatureBtn = new JButton("Highest-point creature");
		highestPointCreatureBtn.setActionCommand(HIGHEST_POINT_CREATURE);
		highestPointCreatureBtn.addActionListener(this);
		highestPointCreatureBtn.setEnabled(false);
		add(highestPointCreatureBtn);
		
		
		
	}
	
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		
		if (command.equals(CREATURES_IN_ROW)) {
			principal.loadGame();
			
		} else
			principal.loadGame();
	}
	
}
