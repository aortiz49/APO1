package uniandes.cupi2.magicalCreatures.userInterface;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uniandes.cupi2.magicalCreatures.world.*;

/**
 * Contains the map of the interface.
 */
public class MapPanel extends JPanel implements ActionListener {
	
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Image path of the visited block.
	 */
	public final static String VISITED_IMAGE_PATH = "./data/images/visited.png";
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Principal window of the application.
	 */
	private MagicalCreaturesUserInterface principal;
	
	/**
	 * Height of the map.
	 */
	private int numberOfRows;
	
	/**
	 * Length of the map.
	 */
	private int numberOfColumns;
	
	
	/**
	 * Array of buttons for the map.
	 */
	private JButton buttons[][];
	
	/**
	 * Array of cells.
	 */
	private MapCell[][] cells;
	
	/**
	 * Constructs a new map panel.
	 *
	 * @param pPrincipal Principal interface of the application.
	 */
	public MapPanel(MagicalCreaturesUserInterface pPrincipal) {
		principal = pPrincipal;
	}
	
	/**
	 * Initializes the terrain for the map configuration.
	 * <b>post: The map is initialized with the terrain to represent the newly loaded map. </b>
	 *
	 * @param pCells           The cells to be initialized in the map.
	 * @param pNumberOfRows    Number rows in the map properties.
	 * @param pNumberOfColumns Number of columns in the map properties.
	 */
	private void initializeMap(MapCell[][] pCells, int pNumberOfRows, int pNumberOfColumns) {
		cells = pCells;
		numberOfRows = pNumberOfRows;
		numberOfColumns = pNumberOfColumns;
		setLayout(new GridLayout(numberOfRows, numberOfColumns));
		setBackground(new Color(237, 221, 123));
		buttons = new JButton[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				buttons[i][j] = new JButton();
				
				// Allocate the terrain to each block of the map. Scale the icon to support
				// smaller sizes in the map dimensions. (+1 pixel for width and height to remove
				// division offset).
				String path = "./data/images/" + cells[i][j].getTerrainType() + ".png";
				buttons[i][j].setIcon(new ImageIcon(new ImageIcon(path).getImage().
					getScaledInstance(this.getWidth() / numberOfColumns + 1,
						this.getHeight() / numberOfRows + 1, Image.SCALE_DEFAULT)));
				
				buttons[i][j].addActionListener(this);
				buttons[i][j].setActionCommand("X" + Integer.toString(i) +
					"Y" + Integer.toString(j));
				buttons[i][j].setBorderPainted(false);
				buttons[i][j].setBackground(new Color(237, 221, 123));
				add(buttons[i][j]);
				setVisible(false);
			}
		}
	}
	
	/**
	 * Updates map with the next map.
	 * <b>post: The map is updated to represent the newly loaded map. </b>
	 *
	 * @param pCells           The cells to be initialized in the map.
	 * @param pNumberOfRows    Number rows in the map properties.
	 * @param pNumberOfColumns Number of columns in the map properties.
	 */
	public void updateMap(MapCell[][] pCells, int pNumberOfRows, int pNumberOfColumns) {
		
		// Remove the icons from the buttons to repaint for the next map.
		removeAll();
		initializeMap(pCells, pNumberOfRows, pNumberOfColumns);
		setVisible(true);
		
	}
	
	/**
	 * When the game is lost, disable the buttons and display a black image in order to prevent
	 * the player from continuing the game.
	 *
	 * <b>post: The buttons are disabled and the screen turns black.</b>
	 */
	public void disableMapButtons() {
		setVisible(false);
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				buttons[i][j].setEnabled(false);
				buttons[i][j].setDisabledIcon(new ImageIcon(new ImageIcon("" +
					"./data/images/black.png")
					.getImage().getScaledInstance(this.getWidth() / numberOfColumns + 1,
						this.getHeight() / numberOfRows + 1, Image.SCALE_DEFAULT)));
			}
		}
		// Disabling before and enabling visibility after allows for the black display to appear
		// at once.
		setVisible(true);
	}
	
	
	public int terrainCreature(String pTerrain) {
		int x = 0;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				if (cells[i][j].getTerrainType().equals(pTerrain) && cells[i][j].getCellCreature()
					!= null)
					x++;
			}
		}
		return x;
	}
	
	public String diagonal1() {
		int ocean = 0;
		int woods = 0;
		int meadow = 0;
		int cave = 0;
		String terr = null;
		int max = 0;
		
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j <= i; j++) {
				if (cells[i][j].isVisited() && cells[i][j].getTerrainType().equals("ocean"))
					ocean++;
				else if (cells[i][j].isVisited() && cells[i][j].getTerrainType().equals("woods"))
					woods++;
				else if (cells[i][j].isVisited() && cells[i][j].getTerrainType().equals("meadow"))
					meadow++;
				else if (cells[i][j].isVisited() && cells[i][j].getTerrainType().equals("cave"))
					cave++;
			}
			
		}
		if (ocean > max) {
			max = ocean;
			terr = "ocean";
		}
		if (woods > max) {
			max = woods;
			terr = "woods";
		}
		if (meadow > max) {
			max = meadow;
			terr = "meadow";
		}
		if (cave > max) {
			max = cave;
			terr = "cave";
		}
		return terr;
	}
	
	public String diagonal2() {
		int ocean = 0;
		int woods = 0;
		int meadow = 0;
		int cave = 0;
		String terr = null;
		int max = 0;
		
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = numberOfColumns - i - 1; j < numberOfColumns; j++) {
				if (cells[i][j].isVisited() && cells[i][j].getTerrainType().equals("ocean"))
					ocean++;
				else if (cells[i][j].isVisited() && cells[i][j].getTerrainType().equals("woods"))
					woods++;
				else if (cells[i][j].isVisited() && cells[i][j].getTerrainType().equals("meadow"))
					meadow++;
				else if (cells[i][j].isVisited() && cells[i][j].getTerrainType().equals("cave"))
					cave++;
			}
			
		}
		if (ocean > max) {
			max = ocean;
			terr = "ocean";
		}
		if (woods > max) {
			max = woods;
			terr = "woods";
		}
		if (meadow > max) {
			max = meadow;
			terr = "meadow";
		}
		if (cave > max) {
			max = cave;
			terr = "cave";
		}
		return terr;
	}
	
	public String diagonal3(int x, int y) throws Exception {
		int ocean = 0;
		int woods = 0;
		int meadow = 0;
		int cave = 0;
		String terr = null;
		int max = 0;
		
		if (x < 0 || x >= numberOfColumns || y < 0 || y >= numberOfRows)
			throw new Exception("Cell out of bounds");
		
		if (y == 0 || x == 0) {// si esta en el borne norte o west
			// x = 3
			// y = 0
			
			/// proximo 4,1
			for (int i = x; i < numberOfRows;i++) {
			
					if (cells[i][y++].isVisited() && cells[i][y++].getTerrainType().equals
						("ocean"))
					ocean++;
				
				}
			
		}
		return terr;
	}
	
	public void test() {
		for (int i = 0; i < 5; ++i) {
			if(i == 0)
				System.out.println("es 0");
		}
	}
	
	/**
	 * Executes actions based off the button the user has pressed.
	 * <b>post: Button is updated with the information caused by the user event. </b>
	 *
	 * @param pEvent The action event generated by the user.
	 */
	public void actionPerformed(ActionEvent pEvent) {
		
		String command = pEvent.getActionCommand();
		
		
		for (int i = 0; i < numberOfRows;) {
			for (int j = 0; j < numberOfColumns;) {
				
				// Detects when a button [i][j] is clicked.
				if (command.equals("X" + Integer.toString(i++) + "Y" + Integer.toString(j++))) {
					System.out.println(command);
					
					// If the box is visited for a second time, display an information
					// message. One movement is lost but not points are awarded.
					if (cells[i][j].isVisited()) {
						JOptionPane.showMessageDialog(this, "You have already visited this box.",
							"Visit box",
							JOptionPane.INFORMATION_MESSAGE);
						principal.updateMovements();
					}
					
					// Else, if the box is being visited for the first time keep going.
					else {
						// If a creature exists in the box, update the mapPanel button with the
						// image of the creature and display an information message to the user.
						if (cells[i][j].getCellCreature() != null) {
							cells[i][j].setIsVisited(true);
							JOptionPane.showMessageDialog(this, "You found 1 " +
									cells[i][j].getCellCreature().getName(), "Visit block",
								JOptionPane
									.INFORMATION_MESSAGE, new ImageIcon(new ImageIcon(cells[i][j]
									.getCellCreature().getCreatureImagePath())
									.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
							
							// Update movement after displaying information message.
							principal.updateMovements();
							buttons[i][j].setIcon(new ImageIcon(new ImageIcon("" +
								"./data/creatures/" + cells[i][j].getCellCreature().getName() +
								"" +
								".png")
								.getImage().getScaledInstance(this.getWidth() / numberOfColumns,
									this.getHeight() / numberOfRows, Image.SCALE_DEFAULT)));
							principal.updatePoints(cells[i][j].getCellCreature().getName());
						} else {
							// Else, if a creature doesn't exist in the box, update the mapPanel
							// button with the image of a "visited" icon.
							cells[i][j].setIsVisited(true);
							buttons[i][j].setIcon(new ImageIcon(new ImageIcon(VISITED_IMAGE_PATH)
								.getImage().getScaledInstance(this.getWidth() / numberOfColumns,
									this
										.getHeight() / numberOfRows, Image.SCALE_DEFAULT)));
							principal.updateMovements();
						}
						
					}
				}
				
			}
			
		}
		
	}
	
}



	

