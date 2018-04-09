/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n4_Album
 * Author: Andres Ortiz
 */

package uniandes.cupi2.album.userInterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel that contains the general options.
 */
@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Command to execute the action of button addTeamBtn.
	 */
	private static final String ADD_TEAM = "ADD TEAM";
	
	/**
	 * Command to execute the action of button findTeamsBtn.
	 */
	private static final String FIND_TEAM = "FIND TEAM";
	
	/**
	 * Command to execute the action of button mostCommonAgeBtn.
	 */
	private static final String MOST_COMMON_AGE = "MOST COMMON AGE";
	
	/**
	 * Command to execute the action of button statisticsBtn.
	 */
	private static final String STATISTICS = "STATISTICS";
	
	/**
	 * Command to execute the action of button findPlayerBtn.
	 */
	private static final String FIND_PLAYER = "FIND PLAYER";
	
	/**
	 * Command to execute the action of button seeAnnotationsBtn.
	 */
	private static final String SEE_ANNOTATIONS = "SEE ANNOTATIONS";
	
	/**
	 * Command to execute the action of button option1Btn.
	 */
	private static final String OPTION_1 = "OPTION 1";
	
	/**
	 * Command to execute the action of button option2Btn.
	 */
	private static final String OPTION_2 = "OPTION 2";
	
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
	 * Button to add a team.
	 */
	private JButton addTeamBtn;
	
	/**
	 * Button to find a team.
	 */
	private JButton findTeamsBtn;
	
	/**
	 * Button to find a player.
	 */
	private JButton findPlayerBtn;
	
	/**
	 * Button to consult the most common age.
	 */
	private JButton mostCommonAgeBtn;
	
	/**
	 * Button to consult the album statistics.
	 */
	private JButton statisticsBtn;
	
	/**
	 * Button to consult the album error annotations.
	 */
	private JButton seeAnnotationsBtn;
	
	/**
	 * Button  para la option 1.
	 */
	private JButton option1Btn;
	
	/**
	 * Button  para la option 2.
	 */
	private JButton option2Btn;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the panel with the buttons. <br>
	 * <b>post:</b> All of the buttons were initialized. The principal interface attribute was
	 * initialized with the value given by the parameter.
	 *
	 * @param pUserInterface Principal interface of the application. pUserInterface != null
	 */
	public OptionsPanel(AlbumInterface pUserInterface) {
		
		principal = pUserInterface;
		setOpaque(false);
		setLayout(new GridLayout(2, 4));
		
		addTeamBtn = new JButton("Add Team");
		addTeamBtn.setActionCommand(ADD_TEAM);
		addTeamBtn.addActionListener(this);
		add(addTeamBtn);
		
		findPlayerBtn = new JButton("Find player");
		findPlayerBtn.setActionCommand(FIND_PLAYER);
		findPlayerBtn.addActionListener(this);
		add(findPlayerBtn);
		
		findTeamsBtn = new JButton("Teams by year");
		findTeamsBtn.setActionCommand(FIND_TEAM);
		findTeamsBtn.addActionListener(this);
		add(findTeamsBtn);
		
		mostCommonAgeBtn = new JButton("Most common age");
		mostCommonAgeBtn.setActionCommand(MOST_COMMON_AGE);
		mostCommonAgeBtn.addActionListener(this);
		add(mostCommonAgeBtn);
		
		statisticsBtn = new JButton("Statistics");
		statisticsBtn.setActionCommand(STATISTICS);
		statisticsBtn.addActionListener(this);
		add(statisticsBtn);
		
		seeAnnotationsBtn = new JButton("See annotations");
		seeAnnotationsBtn.setActionCommand(SEE_ANNOTATIONS);
		seeAnnotationsBtn.addActionListener(this);
		add(seeAnnotationsBtn);
		
		option1Btn = new JButton("Option 1");
		option1Btn.setActionCommand(OPTION_1);
		option1Btn.addActionListener(this);
		add(option1Btn);
		
		option2Btn = new JButton("Option 2");
		option2Btn.setActionCommand(OPTION_2);
		option2Btn.addActionListener(this);
		add(option2Btn);
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
			case FIND_PLAYER:
				FindPlayerDialog dialogFind = new FindPlayerDialog(principal);
				dialogFind.setVisible(true);
				dialogFind.setLocationRelativeTo(principal);
				break;
			case FIND_TEAM:
				principal.findTeamsByYear();
				break;
			case ADD_TEAM:
				AddTeamDialog dialogAdd = new AddTeamDialog(principal);
				dialogAdd.setVisible(true);
				dialogAdd.setLocationRelativeTo(principal);
				break;
			case MOST_COMMON_AGE:
				principal.showMostCommonAge();
				break;
			case STATISTICS:
				principal.showStatistics();
				break;
			case SEE_ANNOTATIONS:
				principal.showAnnotations();
				break;
			case OPTION_1:
				principal.reqFuncOption1();
				break;
			case OPTION_2:
				principal.reqFuncOption2();
				break;
			
		}
		
	}
	
}
