package uniandes.cupi2.magicalCreatures.world;

/**
 * Represents a cell on the map.
 */
public class MapCell {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Represents the code for a meadow terrain cell.
	 */
	public static final int MEADOW = 0;
	
	/**
	 * Represents the code for a woods terrain cell.
	 */
	public static final int WOODS = 1;
	
	/**
	 * Represents the code for an ocean terrain cell.
	 */
	public static final int OCEAN = 2;
	
	/**
	 * Represents the code for a cave cell.
	 */
	public static final int CAVE = 3;
	
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Indicates if current cell has been visited or not.
	 */
	private boolean isVisited;
	
	/**
	 * Type of terrain in the cell.
	 */
	private String terrainType;
	
	/**
	 * Creature in the cell.
	 */
	private Creature cellCreature;
	
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Sets the cell to visited.
	 * <b>post: </b> Sets isVisited to true if cell was visited, false if
	 * otherwise.
	 *
	 * @param pIsVisited Indicates if the cell is visited or not.
	 */
	public void setIsVisited(boolean pIsVisited) {
		isVisited = pIsVisited;
	}
	
	/**
	 * Returns the visit state of the cell.
	 *
	 * @return Visit state of the cell.
	 */
	public boolean isVisited() {
		return isVisited;
	}
	
	/**
	 * Sets the type of terrain in the cell. <br>
	 * <b>post: </b>  The cell's terrain is set to the value given by the parameter.
	 *
	 * @param pTerrainType The type of terrain of the cell.
	 */
	public void setTerrainType(int pTerrainType) {
		switch (pTerrainType) {
			case MEADOW:
				terrainType = "meadow";
				break;
			case WOODS:
				terrainType = "woods";
				break;
			case OCEAN:
				terrainType = "ocean";
				break;
			case CAVE:
				terrainType = "cave";
				break;
		}
		
	}
	
	/**
	 * Returns the type of terrain in the cell.
	 *
	 * @return Cell's terrain type.
	 */
	public String getTerrainType() {
		return terrainType;
	}
	
	/**
	 * Sets the creature in the cell. <br>
	 * <b>post: </b>  The cell creature is set to the creature given by the parameter.
	 *
	 * @param pCreature Creature to be placed in the cell.
	 */
	public void setCellCreature(Creature pCreature) {
		cellCreature = pCreature;
	}
	
	/**
	 * Returns the creature in the cell.
	 *
	 * @return Creature in the cell.
	 */
	public Creature getCellCreature() {
		return cellCreature;
	}
	
}
