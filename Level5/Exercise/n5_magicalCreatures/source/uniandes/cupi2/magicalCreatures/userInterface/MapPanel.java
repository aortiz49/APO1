package uniandes.cupi2.magicalCreatures.userInterface;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class MapPanel extends JPanel {
	// -----------------------------------------------------------------
	// Attributes of the interface
	// -----------------------------------------------------------------
	
	/**
	 * Label to display the map image.
	 */
	private JLabel mapImageLbl;
	/**
	 * The last date loaded by the game.
	 */
	private Properties data;
	
	public MapPanel() {
		
		mapImageLbl = new JLabel();
		add(mapImageLbl);
		
	}
	
	public void loadMap(String pImagePath) throws Exception {
		mapImageLbl.setIcon(new ImageIcon(pImagePath));
		
		}
	}
	

