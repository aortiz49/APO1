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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;

import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Card.CardType;

import java.awt.Font;

/**
 * Panel that contains the team's information.
 */
@SuppressWarnings("serial")
public class TeamPanel extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Constant that represents the number of rows in the matrix of players.
	 */
	private static final int NUM_ROWS = 2;
	
	/**
	 * Constant that represents the number of columns in the matrix of players.
	 */
	private static final int NUM_COLUMNS = 6;
	
	/**
	 * Command to execute the action of button crestCardBtn.
	 */
	private static final String CREST_CARD = "CREST CARD";
	
	/**
	 * Command to execute the action of button favoriteCrestBtn.
	 */
	private static final String FAVORITE_CREST = "FAVORITE CREST";
	
	/**
	 * Command to execute the action of button teamCardBtn.
	 */
	private static final String TEAM_CARD = "TEAM CARD";
	
	/**
	 * Command to execute the action of button favoriteTeamBtn team.
	 */
	private static final String FAVORITE_TEAM = "FAVORITE TEAM";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Team that is being displayed.
	 */
	private Team team;
	
	/**
	 * Principal window of the application
	 */
	private AlbumInterface principal;
	
	// -----------------------------------------------------------------
	// User interface attributes
	// -----------------------------------------------------------------
	
	/**
	 * Label that contains the name and year of the team.
	 */
	private JLabel teamTitleLbl;
	
	/**
	 * Button that contains the crest card.
	 */
	private JButton cardBtnEscudo;
	
	/**
	 * Button to mark the crest as a favorite card.
	 */
	private JButton favoriteBtnEscudo;
	
	/**
	 * Button that contains the team card.
	 */
	private JButton cardBtnTeam;
	
	/**
	 * Button to mark the team as a favorite card.
	 */
	private JButton favoriteBtnTeam;
	
	/**
	 * Matrix containing the panels with the player cards.
	 */
	private CardPanel[][] playerCards;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the panel that contains the team's information.  <br>
	 * <b>post:</b> All of the buttons and labels were initialized.
	 *
	 * @param pTeam          Team who's information will be displayed. pTeam != null.
	 * @param pUserInterface Principal interface of the application. pUserInterface != null
	 */
	public TeamPanel(AlbumInterface pUserInterface, Team pTeam) {
		setOpaque(false);
		
		team = pTeam;
		principal = pUserInterface;
		setLayout(new BorderLayout(0, 10));
		JPanel superiorPanel = new JPanel(new BorderLayout());
		superiorPanel.setOpaque(false);
		JPanel panelCardEscudo = new JPanel(new BorderLayout());
		panelCardEscudo.setBorder(null);
		panelCardEscudo.setOpaque(false);
		JPanel panelCardTeam = new JPanel(new BorderLayout());
		panelCardTeam.setBorder(null);
		panelCardTeam.setOpaque(false);
		
		superiorPanel.add(panelCardEscudo, BorderLayout.WEST);
		superiorPanel.add(panelCardTeam, BorderLayout.EAST);
		add(superiorPanel, BorderLayout.NORTH);
		JPanel playersPanel = new JPanel(new GridLayout(NUM_ROWS, NUM_COLUMNS, 15, 15));
		playersPanel.setOpaque(false);
		add(playersPanel, BorderLayout.CENTER);
		
		cardBtnEscudo = new JButton("Paste");
		cardBtnEscudo.setActionCommand(CREST_CARD);
		cardBtnEscudo.addActionListener(this);
		cardBtnEscudo.setContentAreaFilled(false);
		cardBtnEscudo.setBorder(null);
		cardBtnEscudo.setIcon(new ImageIcon("./data/images/toPasteCrest.png"));
		cardBtnEscudo.setPreferredSize(new Dimension(105, 105));
		cardBtnEscudo.setHorizontalTextPosition(JLabel.CENTER);
		cardBtnEscudo.setForeground(Color.WHITE);
		cardBtnEscudo.setFont(new Font(new JLabel().getFont().getFontName(), Font.BOLD, 16));
		panelCardEscudo.add(cardBtnEscudo, BorderLayout.WEST);
		
		JPanel escudo = new JPanel();
		escudo.setOpaque(false);
		escudo.setLayout(new BorderLayout());
		panelCardEscudo.add(escudo, BorderLayout.SOUTH);
		
		JLabel lblEscudo = new JLabel("Escudo");
		lblEscudo.setHorizontalAlignment(JLabel.CENTER);
		lblEscudo.setForeground(Color.WHITE);
		lblEscudo.setFont(new Font(new JLabel().getFont().getFontName(), Font.BOLD, 13));
		escudo.add(lblEscudo, BorderLayout.CENTER);
		
		favoriteBtnEscudo = new JButton();
		favoriteBtnEscudo.setIcon(new ImageIcon("./data/images/off.png"));
		favoriteBtnEscudo.setActionCommand(FAVORITE_CREST);
		favoriteBtnEscudo.addActionListener(this);
		favoriteBtnEscudo.setContentAreaFilled(false);
		favoriteBtnEscudo.setBorder(null);
		escudo.add(favoriteBtnEscudo, BorderLayout.EAST);
		
		teamTitleLbl = new JLabel(team.getCountry() + " - " + team.getYear());
		teamTitleLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		teamTitleLbl.setHorizontalAlignment(JLabel.CENTER);
		teamTitleLbl.setForeground(new Color(220, 232, 255));
		superiorPanel.add(teamTitleLbl, BorderLayout.CENTER);
		
		cardBtnTeam = new JButton("Paste");
		cardBtnTeam.setActionCommand(TEAM_CARD);
		cardBtnTeam.addActionListener(this);
		cardBtnTeam.setContentAreaFilled(false);
		cardBtnTeam.setBorder(null);
		cardBtnTeam.setIcon(new ImageIcon("./data/images/toPasteTeam.png"));
		cardBtnTeam.setPreferredSize(new Dimension(150, 100));
		cardBtnTeam.setHorizontalTextPosition(JLabel.CENTER);
		cardBtnTeam.setForeground(Color.WHITE);
		cardBtnTeam.setFont(new Font(new JLabel().getFont().getFontName(), Font.BOLD, 16));
		panelCardTeam.add(cardBtnTeam, BorderLayout.CENTER);
		
		JPanel teamP = new JPanel();
		teamP.setOpaque(false);
		teamP.setLayout(new BorderLayout());
		panelCardTeam.add(teamP, BorderLayout.SOUTH);
		
		JLabel lblTeam = new JLabel("Team");
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setFont(new Font(new JLabel().getFont().getFontName(), Font.BOLD, 13));
		lblTeam.setHorizontalAlignment(JLabel.CENTER);
		teamP.add(lblTeam, BorderLayout.CENTER);
		
		favoriteBtnTeam = new JButton();
		favoriteBtnTeam.setIcon(new ImageIcon("./data/images/off.png"));
		favoriteBtnTeam.setActionCommand(FAVORITE_TEAM);
		favoriteBtnTeam.setContentAreaFilled(false);
		favoriteBtnTeam.setBorder(null);
		favoriteBtnTeam.addActionListener(this);
		teamP.add(favoriteBtnTeam, BorderLayout.EAST);
		
		playerCards = new CardPanel[NUM_ROWS][NUM_COLUMNS];
		int index = 0;
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLUMNS; j++) {
				playerCards[i][j] = new CardPanel(principal, team.getCountry(), team.getYear(),
				                                  team
					                                  .getPlayers()[index++]);
				playersPanel.add(playerCards[i][j]);
			}
		}
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Updates the team's information with the information given by the parameter.<br>
	 * <b>pre: </b> The matrix with the cards is initialized and added to the panel. <br>
	 * <b>post:</b> La information shown was updated.
	 *
	 * @param pTeam Team to be displayed on the panel. pTeam != null.
	 */
	public void updateInterface(Team pTeam) {
		team = pTeam;
		int index = 0;
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLUMNS; j++) {
				playerCards[i][j].updateInterface(team.getCountry(), team.getYear(),
				                                  team.getPlayers()[index++]);
			}
		}
		
		if (team.getTeamCard() != null) {
			ImageIcon icon = new ImageIcon("./data/images/" + team.getCountry() + "/" + team
				.getYear() + "/" + team.getTeamCard().getImageName());
			
			cardBtnTeam.setText("");
			cardBtnTeam.setBorderPainted(false);
			cardBtnTeam.setContentAreaFilled(false);
			cardBtnTeam.setIcon(icon);
			if (team.getTeamCard().isFavorite()) {
				favoriteBtnTeam.setIcon(new ImageIcon("./data/images/on.png"));
			} else {
				favoriteBtnTeam.setIcon(new ImageIcon("./data/images/off.png"));
			}
		} else {
			cardBtnTeam.setText("Paste");
			cardBtnTeam.setBorderPainted(false);
			cardBtnTeam.setContentAreaFilled(false);
			cardBtnTeam.setIcon(new ImageIcon("./data/images/toPasteTeam.png"));
			favoriteBtnTeam.setIcon(new ImageIcon("./data/images/off.png"));
		}
		
		if (team.getCrestCard() != null) {
			ImageIcon icon = new ImageIcon("./data/images/" + team.getCountry() + "/" + team
				.getYear() + "/" + team.getCrestCard().getImageName());
			
			cardBtnEscudo.setText("");
			cardBtnEscudo.setBorderPainted(false);
			cardBtnEscudo.setContentAreaFilled(false);
			cardBtnEscudo.setIcon(icon);
			if (team.getCrestCard().isFavorite()) {
				favoriteBtnEscudo.setIcon(new ImageIcon("./data/images/on.png"));
			} else {
				favoriteBtnEscudo.setIcon(new ImageIcon("./data/images/off.png"));
			}
		} else {
			cardBtnEscudo.setText("Paste");
			cardBtnEscudo.setBorderPainted(false);
			cardBtnEscudo.setContentAreaFilled(false);
			cardBtnEscudo.setIcon(new ImageIcon("./data/images/toPasteCrest.png"));
			favoriteBtnEscudo.setIcon(new ImageIcon("./data/images/off.png"));
		}
		
		teamTitleLbl.setText(team.getCountry() + " - " + team.getYear());
	}
	
	/**
	 * Manages user events.
	 *
	 * @param pEvent User event. . pEvent != null.
	 */
	@Override
	public void actionPerformed(ActionEvent pEvent) {
		String command = pEvent.getActionCommand();
		
		switch (command) {
			case TEAM_CARD:
				principal.pasteTeamCard(team.getCountry(), team.getYear());
				break;
			case CREST_CARD:
				principal.pasteCrestCard(team.getCountry(), team.getYear());
				break;
			case FAVORITE_TEAM:
				principal.changeFavoriteCardAlbum(team.getCountry(), team.getYear(), CardType
					.TEAM, 0);
				break;
			case FAVORITE_CREST:
				principal.changeFavoriteCardAlbum(team.getCountry(), team.getYear(), CardType
					.CREST, 0);
				break;
		}
		
	}
	
}
