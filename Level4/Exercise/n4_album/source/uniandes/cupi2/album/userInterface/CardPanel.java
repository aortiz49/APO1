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
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Card.CardType;

import java.awt.Font;

/**
 * Panel that contains the elements contained in a card.
 */
@SuppressWarnings("serial")
public class CardPanel extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Default card image.
	 */
	public static final ImageIcon DEFAULT_CARD = new ImageIcon("./data/images/player.png");
	
	/**
	 * Command to execute the action of button cardBtn.
	 */
	private static final String PASTE_CARD = "PASTE CARD";
	
	/**
	 * Command to execute the action of button techInfoBtn.
	 */
	private static final String TECH_INFO = "TECH INFO";
	
	/**
	 * Command to execute the action of button modifyBtn.
	 */
	private static final String MODIFY = "MODIFY";
	
	/**
	 * Command to execute the action of button favoriteBtn.
	 */
	private static final String FAVORITE = "FAVORITE";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Player on the card.
	 */
	private Player player;
	
	/**
	 * Country represented by player on the card.
	 */
	private String country;
	
	/**
	 * Year in which player on card represented his country.
	 */
	private int year;
	
	/**
	 * Principal window of the application
	 */
	private AlbumInterface principal;
	
	// -----------------------------------------------------------------
	// User interface attributes
	// -----------------------------------------------------------------
	
	/**
	 * Label that contains the player's name.
	 */
	private JLabel playerNameLbl;
	
	/**
	 * Button to paste the card/show the image of the card.
	 */
	private JButton cardBtn;
	
	/**
	 * Button to see the player's technical information.B
	 */
	private JButton techInfoBtn;
	
	/**
	 * Button to modify the player;s information.
	 */
	private JButton modifyBtn;
	
	/**
	 * Button to mark a card as a favorite.
	 */
	private JButton favoriteBtn;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the panel with the card information.  <br>
	 * <b>post:</b> Every button was initialized. Principal, player, country, and year attributes
	 * were initialized with the information given by the parameters.
	 *
	 * @param pUserInterface Principal interface of the application. pUserInterface != null
	 * @param pCountry       Country of the team being searched. pCountry != null &amp;&amp;
	 *                          pCountry !=
	 *                       "".
	 * @param pYear          Year in which the searched team represented the country. pYear &gt; 0.
	 * @param pPlayer        Player that is on the card. pPlayer != null.
	 */
	public CardPanel(AlbumInterface pUserInterface, String pCountry, int pYear, Player pPlayer) {
		player = pPlayer;
		principal = pUserInterface;
		country = pCountry;
		year = pYear;
		
		setLayout(new BorderLayout(0, 5));
		setOpaque(false);
		setBorder(null);
		
		JPanel optionsPanel = new JPanel(new BorderLayout());
		optionsPanel.setOpaque(false);
		add(optionsPanel, BorderLayout.SOUTH);
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2, 1));
		buttons.setOpaque(false);
		buttons.setBorder(null);
		optionsPanel.add(buttons, BorderLayout.CENTER);
		
		playerNameLbl = new JLabel(player.getName());
		playerNameLbl.setHorizontalAlignment(JLabel.CENTER);
		playerNameLbl.setForeground(new Color(220, 232, 255));
		playerNameLbl.setFont(new Font(new JLabel().getFont().getFontName(), Font.BOLD, 13));
		add(playerNameLbl, BorderLayout.NORTH);
		
		cardBtn = new JButton("Paste");
		cardBtn.setActionCommand(PASTE_CARD);
		cardBtn.addActionListener(this);
		cardBtn.setContentAreaFilled(false);
		cardBtn.setBorder(null);
		cardBtn.setForeground(Color.WHITE);
		cardBtn.setHorizontalTextPosition(JLabel.CENTER);
		cardBtn.setFont(new Font(new JLabel().getFont().getFontName(), Font.BOLD, 16));
		cardBtn.setIcon(new ImageIcon("./data/images/toPaste.png"));
		
		add(cardBtn, BorderLayout.CENTER);
		
		techInfoBtn = new JButton("Tech info");
		techInfoBtn.setActionCommand(TECH_INFO);
		techInfoBtn.addActionListener(this);
		buttons.add(techInfoBtn);
		
		modifyBtn = new JButton("Modify");
		modifyBtn.setActionCommand(MODIFY);
		modifyBtn.addActionListener(this);
		buttons.add(modifyBtn);
		
		favoriteBtn = new JButton("");
		favoriteBtn.setIcon(new ImageIcon("./data/images/off.png"));
		favoriteBtn.setActionCommand(FAVORITE);
		favoriteBtn.setContentAreaFilled(false);
		favoriteBtn.setBorder(null);
		favoriteBtn.addActionListener(this);
		optionsPanel.add(favoriteBtn, BorderLayout.EAST);
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Updates the information shown with the information given by the parameters.
	 * <b>pre: </b> The buttons and labels were initialized and added. <br>
	 * <b>post:</b> The information shown was updated.<br>
	 *
	 * @param pCountry Country of the team being searched. pCountry != null &amp;&amp;  pCountry
	 *                    != "".
	 * @param pYear    Year in which the searched team represented the country. pYear &gt; 0.
	 * @param pPlayer  Player that is on the card. pPlayer != null.
	 */
	public void updateInterface(String pCountry, int pYear, Player pPlayer) {
		player = pPlayer;
		country = pCountry;
		year = pYear;
		
		if (player.getCard() != null) {
			cardBtn.setText("");
			String imagePath = player.getCard().getImageName();
			File fileImage = new File("./data/images/" + pCountry + "/" + pYear + "/" + imagePath);
			ImageIcon icon = fileImage.exists() ? new ImageIcon(fileImage.getAbsolutePath()) :
				DEFAULT_CARD;
			cardBtn.setIcon(icon);
			cardBtn.setContentAreaFilled(false);
			cardBtn.setBorderPainted(false);
			if (player.getCard().isFavorite()) {
				favoriteBtn.setIcon(new ImageIcon("./data/images/on.png"));
			} else {
				favoriteBtn.setIcon(new ImageIcon("./data/images/off.png"));
			}
		} else {
			cardBtn.setIcon(new ImageIcon("./data/images/toPaste.png"));
			cardBtn.setText("Paste");
			cardBtn.setContentAreaFilled(false);
			cardBtn.setBorderPainted(false);
			cardBtn.setBorder(null);
			cardBtn.setHorizontalTextPosition(JLabel.CENTER);
			favoriteBtn.setIcon(new ImageIcon("./data/images/off.png"));
		}
		playerNameLbl.setText(player.getName());
		
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
			case PASTE_CARD:
				principal.pastePlayerCard(country, year, player.getShirtNumber());
				break;
			
			case MODIFY:
				ModifyPlayerDialog modifyDialog = new ModifyPlayerDialog(principal, country,
				                                                         year, player);
				modifyDialog.setVisible(true);
				modifyDialog.setLocationRelativeTo(principal);
				break;
			case TECH_INFO:
				TechInfoDialog techInfoDialog = new TechInfoDialog(player);
				techInfoDialog.setVisible(true);
				techInfoDialog.setLocationRelativeTo(principal);
				break;
			case FAVORITE:
				principal.changeFavoriteCardAlbum(country, year, CardType.PLAYER, player
					.getShirtNumber());
				break;
			
		}
		
	}
}
