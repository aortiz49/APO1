package uniandes.cupi2.magicalCreatures.userInterface;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Contains the map of the interface.
 */
public class MapPanel extends JPanel {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Image path of the map.
	 */
	public final static String MAP_IMAGE_PATH = "./data/map.png";
	
	
	// -----------------------------------------------------------------
	// Attributes of the interface
	// -----------------------------------------------------------------
	
	/**
	 * Label to display the map image.
	 */
	private JLabel mapImageLbl;
	
	public MapPanel() {
		setLayout(new BorderLayout());
		mapImageLbl = new JLabel();
		
		add(mapImageLbl, BorderLayout.CENTER);
		
	}
	/**
	 * Loads the map of the game.
	 * <b>post: </b> Display the image in the user interface.
	 */
	public void loadMap()  {
		mapImageLbl.setIcon(new ImageIcon(new ImageIcon(MAP_IMAGE_PATH).getImage().getScaledInstance(
			mapImageLbl.getWidth(), mapImageLbl.getHeight(), Image.SCALE_DEFAULT)));
		
	}
}
	

