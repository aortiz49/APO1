package uniandes.cupi2.magicalCreatures.userInterface;

import uniandes.cupi2.magicalCreatures.world.MagicalCreatures;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel that contains the creature encyclopedia.
 */
@SuppressWarnings("serial")
public class EncyclopediaPanel extends JPanel implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to view the previous creature.
	 */
	public final static String PREVIOUS = "Previous";
	
	/**
	 * Command to view the next creature.
	 */
	public final static String NEXT = "Next";
	
	// -----------------------------------------------------------------
	// Attributes of the interface
	// -----------------------------------------------------------------
	
	/**
	 * Label for the magical creature's name.
	 */
	private JLabel creatureNameLbl;
	
	/**
	 * Label for the creature's points.
	 */
	private JLabel creaturePointsLbl;
	
	/**
	 * Label for the creature's profile picture.
	 */
	private JLabel creatureImageLbl;
	
	/**
	 * Label for the creature's interests.
	 */
	private JLabel creatureInterestsLbl;
	
	/**
	 * Label for the creature's fears.
	 */
	private JLabel creatureFearsLbl;
	
	/**
	 * Text field for the creature's fears.
	 */
	private JTextField creatureFearsTxt;
	
	/**
	 * Text field for the creature's interests.
	 */
	private JTextField creatureInterestsTxt;
	
	/**
	 * Check box indicating if the creature is a being of light.
	 */
	private JCheckBox creatureIsLightCb;
	
	/**
	 * Button to view the previous creature.
	 */
	private JButton previousBtn;
	
	/**
	 * Button to view the next creature.
	 */
	private JButton nextBtn;
	
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Principal window od the application.
	 */
	private MagicalCreaturesUserInterface principal;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Creates a new Encyclopedia panel.
	 *
	 * @param pPrincipal Principal window of the application.
	 */
	public EncyclopediaPanel(MagicalCreaturesUserInterface pPrincipal) {
		
		principal = pPrincipal;
		setLayout(new BorderLayout());
		setBackground(new Color(48, 41, 84));
		TitledBorder border = new TitledBorder("Encyclopedia");
		border.setTitleColor(Color.WHITE);
		setBorder(border);
		
		// Create top panel to hold creature's name and points.
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(48, 41, 84));
		topPanel.setLayout(new GridLayout(2, 1, 5, 5));
		add(topPanel, BorderLayout.NORTH);
		
		// Create label for creature's name and add to the top panel.
		creatureNameLbl = new JLabel();
		creatureNameLbl.setForeground(new Color(255, 252, 222));
		creatureNameLbl.setFont(new Font("Helvetica", Font.BOLD, 22));
		creatureNameLbl.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(creatureNameLbl);
		
		// Create label for creature's points and add to the top panel.
		creaturePointsLbl = new JLabel();
		creaturePointsLbl.setForeground(Color.WHITE);
		creaturePointsLbl.setFont(new Font("Helvetica", Font.BOLD, 22));
		creaturePointsLbl.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(creaturePointsLbl);
		
		// Creature label for creature's image and add to the panel.
		creatureImageLbl = new JLabel();
		add(creatureImageLbl, BorderLayout.CENTER);
		
		// Create bottom panel to hold information panel and navigation panel.
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(48, 41, 84));
		bottomPanel.setLayout(new BorderLayout());
		add(bottomPanel, BorderLayout.SOUTH);
		
		// Create information panel to hold the creature's interests and fears.
		JPanel informationPanel = new JPanel();
		informationPanel.setBackground(new Color(48, 41, 84));
		informationPanel.setLayout(new GridLayout(5, 1, 5, 5));
		bottomPanel.add(informationPanel, BorderLayout.CENTER);
		
		// Create label for the creature's interests and add to the information panel.
		creatureInterestsLbl = new JLabel("Interests:");
		creatureInterestsLbl.setForeground(Color.WHITE);
		creatureInterestsLbl.setForeground(new Color(255, 252, 222));
		informationPanel.add(creatureInterestsLbl);
		
		// Create text field for the creature's interests and add to the information panel.
		creatureInterestsTxt = new JTextField();
		creatureInterestsTxt.setEditable(false);
		creatureInterestsTxt.setBackground(new Color(48, 41, 84));
		creatureInterestsTxt.setForeground(Color.WHITE);
		informationPanel.add(creatureInterestsTxt);
		
		// Create label for the creature's fears and add to the information panel.
		creatureFearsLbl = new JLabel("Fears:");
		creatureFearsLbl.setForeground(Color.WHITE);
		creatureFearsLbl.setForeground(new Color(255, 252, 222));
		informationPanel.add(creatureFearsLbl);
		
		// Create text field for the creature's fears and add to the information panel.
		creatureFearsTxt = new JTextField();
		creatureFearsTxt.setEditable(false);
		creatureFearsTxt.setBackground(new Color(48, 41, 84));
		creatureFearsTxt.setForeground(Color.WHITE);
		informationPanel.add(creatureFearsTxt);
		
		// Create check box to indicate if the creature is a being of light and add to the
		// information panel.
		creatureIsLightCb = new JCheckBox("Being of light");
		creatureIsLightCb.setSelected(false);
		creatureIsLightCb.setBackground(new Color(48, 41, 84));
		creatureIsLightCb.setEnabled(false);
		//creatureFearsTxt.setOpaque(false);
		informationPanel.add(creatureIsLightCb);
		
		// Create navigation panel to iterate through every creature.
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(new Color(48, 41, 84));
		navigationPanel.setLayout(new GridLayout(1, 2, 0, 5));
		bottomPanel.add(navigationPanel, BorderLayout.SOUTH);
		
		// Create "previous" button and add to navigation panel.
		previousBtn = new JButton("<");
		previousBtn.setActionCommand(PREVIOUS);
		previousBtn.addActionListener(this);
		navigationPanel.add(previousBtn);
		
		// Create "next" button and add to navigation panel.
		nextBtn = new JButton(">");
		nextBtn.setActionCommand(NEXT);
		nextBtn.addActionListener(this);
		navigationPanel.add(nextBtn);
		
	}
	
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Responds to the events generated in the user interface.
	 *
	 * @param pEvent Event generated. pEvent != null.
	 */
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		
		if (command.equals(NEXT)) {
			principal.seeNext();
			
		} else
			principal.seePrevious();
	}
	
	/**
	 * Updates the encyclopedia information that is displayed for each magical creature. <br>
	 * <b>post: </b> The information in the panel is updated for the current magical creature.
	 *
	 * @param pName         Name of the creature. pName != null &amp;&amp; pName != "".
	 * @param pPoints       Points the player obtains when finding a creature. pPoints &gt; 0.
	 * @param pImagePath    Image path of the creature.
	 *                      pCreatureImagePath != null &amp;&amp; pCreatureImagePath != "".
	 * @param pInterests    Interests of the creature. pInterests != null &amp;&amp; pInterests != "".
	 * @param pFears        Fears of the creature. pFears != null &amp;&amp; pFears != "".
	 * @param pBeingOfLight True if the creature is a being of light, false if contrary.
	 */
	public void updatePanel(String pName, int pPoints, String pImagePath, String pInterests,
	                        String pFears, boolean pBeingOfLight) {
		creatureNameLbl.setText(pName);
		creaturePointsLbl.setText(Integer.toString(pPoints));
		creatureImageLbl.setIcon(
			new ImageIcon(new ImageIcon(pImagePath).getImage().getScaledInstance(
				200, 200, Image.SCALE_DEFAULT)));
		
		creatureInterestsTxt.setText(pInterests);
		creatureFearsTxt.setText(pFears);
		creatureIsLightCb.setSelected(pBeingOfLight);
		
	}
}

