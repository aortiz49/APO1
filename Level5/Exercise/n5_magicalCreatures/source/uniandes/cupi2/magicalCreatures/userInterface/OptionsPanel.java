package uniandes.cupi2.magicalCreatures.userInterface;

import uniandes.cupi2.magicalCreatures.world.MagicalCreatures;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class OptionsPanel extends JPanel implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to load the map.
	 */
	public final static String LOAD = "Load Map";
	
	/**
	 * Command to restart the game.
	 */
	public final static String RESTART = "Restart Game";
	
	/**
	 * Command to execute option1.
	 */
	public final static String OPTION_1 = "Optionsdkljfs";
	
	/**
	 * Command to execute option2.
	 */
	public final static String OPTION_2 = "Option 2";
	
	// -----------------------------------------------------------------
	// Attributes of the interface
	// -----------------------------------------------------------------
	
	/**
	 * Button to load the map.
	 */
	private JButton loadMapBtn;
	
	/**
	 * Button to reset the game.
	 */
	private JButton restartGameBtn;
	
	/**
	 * Button to execute option 1.
	 */
	private JButton option1Btn;
	
	/**
	 * Button to execute option 2.
	 */
	private JButton option2Btn;
	
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Principal window of theapplication.
	 */
	private MagicalCreaturesUserInterface principal;
	
	/**
	 * Creates a new options panel.
	 * @param pPrincipal
	 */
	public OptionsPanel(MagicalCreaturesUserInterface pPrincipal) {
		principal = pPrincipal;
		setBackground(new Color(48, 41, 84));
		setLayout(new GridLayout(1, 4, 0, 5));
		TitledBorder border = new TitledBorder("Options");
		border.setTitleColor(Color.WHITE);
		setBorder(border);
		
		// Create "Load map" button and add to the options panel.
		loadMapBtn = new JButton("Load");
		loadMapBtn.setActionCommand(LOAD);
		loadMapBtn.addActionListener(this);
		add(loadMapBtn);
		
		// Create "reset game" button and add to the options panel.
		restartGameBtn = new JButton("Reset");
		restartGameBtn.setActionCommand(RESTART);
		restartGameBtn.addActionListener(this);
		add(restartGameBtn);
		
		// Create "option 1" button and add to the options panel.
		option1Btn = new JButton("Option 1");
		option1Btn.setActionCommand(OPTION_1);
		option1Btn.addActionListener(this);
		add(option1Btn);
		
		// Create "Highest-point creature" button and add to the options panel.
		option2Btn = new JButton("Option 2");
		option2Btn.setActionCommand(OPTION_2);
		option2Btn.addActionListener(this);
		add(option2Btn);
		
		
		
	}
	
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		
		if (command.equals(LOAD)) {
			principal.loadGame();
			
		} else
			principal.loadGame();
	}
	

	
}
