/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n3_Album
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.userInterface;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import uniandes.cupi2.album.world.Album;
import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Position;
import uniandes.cupi2.album.world.Card.CardType;

/**
 * Main window of the application.
 */
public class albumInterface extends JFrame {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Associates the class to the world.
	 */
	private Album world;
	
	/**
	 * Index of the team that is currently being shown.
	 */
	private int actualIndex;
	
	// -----------------------------------------------------------------
	// User Interface Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Contains the current team information.
	 */
	private PanelTeam teamPanel;
	
	/**
	 * Contains the application options;
	 */
	private OptionsPanel panelOptions;
	
	/**
	 * Contains the navigation on the left.
	 */
	private LateralPanel lateralPanelLeft;
	
	/**
	 * Contains the navigation on the right.
	 */
	private LateralPanel lateralPanelRight;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Constructs the main window of the application. <br>
	 * <b>post:</b> Every component was initialized.
	 */
	public albumInterface() {
		world = new Album();
		cargarTeams();
		
		setTitle("Album");
		setSize(970, 750);
		BackgroundPanel backgroundPanel = new BackgroundPanel();
		backgroundPanel.setLayout(new BorderLayout(10, 10));
		add(backgroundPanel);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		actualIndex = 0;
		teamPanel = new PanelTeam(this, world.getTeams().get(actualIndex));
		backgroundPanel.add(teamPanel, BorderLayout.CENTER);
		
		panelOptions = new OptionsPanel(this);
		backgroundPanel.add(panelOptions, BorderLayout.SOUTH);
		
		lateralPanelLeft = new LateralPanel(this, LateralPanel.ANTERIOR);
		backgroundPanel.add(lateralPanelLeft, BorderLayout.WEST);
		
		lateralPanelRight = new LateralPanel(this, LateralPanel.SIGUIENTE);
		backgroundPanel.add(lateralPanelRight, BorderLayout.EAST);
		
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Este method ejecuta la aplicacion, creando una nueva userInterface
	 *
	 * @param args Arreglo opcional de argumentos que se recibe por linea de commands
	 */
	public static void main(String[] args) {
		try {
			// Unifica la userInterface para Mac y para Windows.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			albumInterface interfaz = new albumInterface();
			interfaz.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pega la lamina de un team.<br>
	 * <b>pre: </b>El team existe.<br>
	 * <b>post: </b>Se pego la lamina del team.
	 *
	 * @param pCountry Country del team. pCountry != null && pCountry != "".
	 * @param pYear    Year en el cual el team represento al pais. pYear > 0.
	 */
	public void pasteTeamCard(String pCountry, int pYear) {
		if(world.pasteTeamCard(pCountry, pYear)) {
			actualizar();
		} else {
			JOptionPane.showMessageDialog(this, "This card is already pasted.", "Paste team card",
			                              JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Pega la lamina del crest un team. <br>
	 * <b>pre: </b>El team existe.<br>
	 * <b>post: </b>Se pego la lamina del crest del team.
	 *
	 * @param pCountry Country del team. pCountry != null && pCountry != "".
	 * @param pYear    Year en el cual el team represento al pais. pYear > 0.
	 */
	public void pasteCrestCard(String pCountry, int pYear) {
		if(world.pasteCrestCard(pCountry, pYear)) {
			actualizar();
		} else {
			JOptionPane.showMessageDialog(this, "This card is already pasted.", "Paste crest " +
					"card", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Pega la lamina del player del team con el número de shirt dado.<br>
	 * <b>pre: </b> El player existe.<br>
	 * <b>post: </b>Se pego la lamina del player.
	 *
	 * @param pCountry     Country del team. pCountry != null && pCountry != "".
	 * @param pYear        Year en el cual el team represento al pais. pYear > 0.
	 * @param pShirtNumber Número of the  shirt del player. pShirtNumber > 0.
	 */
	public void pastePlayerCard(String pCountry, int pYear, int pShirtNumber) {
		if(world.pastePlayerCard(pShirtNumber, pCountry, pYear)) {
			actualizar();
		} else {
			JOptionPane.showMessageDialog(this, "This card is already pasted.", "Paste player " +
					"card", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Navega al team anterior.<br>
	 * <b>post: </b>Se disminuyo en 1 el indice actual si era mayor a 0 y se actualizo la
	 * userInterface.
	 */
	public void anterior() {
		if(actualIndex == 0) {
			JOptionPane.showMessageDialog(this, "No more teams", "Previous team", JOptionPane
					.ERROR_MESSAGE);
		} else {
			actualIndex--;
			actualizar();
		}
		
	}
	
	/**
	 * Navega al team siguiente.<br>
	 * <b>post: </b>Se aumento en 1 el indice actual si era mayor a 0 y se actualizo la
	 * userInterface.
	 */
	public void siguiente() {
		ArrayList<Team> teams = world.getTeams();
		if(teams.size() == actualIndex + 1) {
			JOptionPane.showMessageDialog(this, "No more teams", "Next team", JOptionPane
					.ERROR_MESSAGE);
		} else {
			actualIndex++;
			actualizar();
		}
		
	}
	
	/**
	 * Modifica los datos de un player.<br>
	 * <b>pre: </b> El player existe.<br>
	 * <b>post: </b>Se modifyon los datos del player.
	 *
	 * @param pCountry          Country del team. pCountry != null && pCountry != "".
	 * @param pYear             Year en el cual el team represento al pais. pYear > 0.
	 * @param pShirtNumber      Número of the  shirt del player. pShirtNumber > 0.
	 * @param pShirtNumberNueva Número nuevo of the  shirt del player. pShirtNumberNueva > 0.
	 * @param pNameNuevo        Name nuevo del player. pNameNuevo != null && pNameNuevo != "".
	 * @param pPosition         Position nueva del player. pPosition != null && pPosition
	 *                          pertenece a
	 *                          {"GOALKEEPER","DEFENDER","WINGER","STRIKER","UNKNOWN"}.
	 * @param pBirthYear        Year de nacimiento del player. pBirthYear > 0.
	 * @param pHeight           Height nueva del player. pHeight > 0.
	 * @param pWeight           Weight nuevo del player. pWeight > 0.
	 *
	 * @return True si se modifico, False en caso contrario.
	 */
	public boolean modifyPlayer(String pCountry, int pYear, int pShirtNumber, int
			pShirtNumberNueva, String pNameNuevo, String pPosition, int pBirthYear, double
			                            pHeight, double pWeight) {
		boolean response = world.modifyPlayer(pCountry, pYear, pShirtNumber, pShirtNumberNueva,
		                                      pNameNuevo, getPosition(pPosition), pBirthYear,
		                                      pHeight, pWeight);
		if(response) {
			actualizar();
		} else {
			JOptionPane.showMessageDialog(this, "A player with this shirt number already exists.",
			                              "Modify player", JOptionPane.ERROR_MESSAGE);
		}
		return response;
	}
	
	/**
	 * Agrega al album un team que represento a un pais en un año dado.<br>
	 * <b>post: </b>Si fue posible, se agrego el team.
	 *
	 * @param pCountry Country al cual represento el team. pCountry != null && pCountry != "".
	 * @param pYear    Year en el cual represento el team al pais. pYear > 0.
	 **/
	public void addTeam(String pCountry, int pYear) {
		boolean agrego = world.addTeam(pCountry, pYear);
		if(!agrego) {
			JOptionPane.showMessageDialog(this, "This team already exists in the album", "Add " +
					                              "team",
			                              JOptionPane.ERROR_MESSAGE);
		} else {
			actualIndex = world.getTeams().size() - 1;
			actualizar();
			JOptionPane.showMessageDialog(this, "Team was added correctly", "Add team",
			                              JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	/**
	 * Muestra el dialogo para ingresar un año y muestra los teams de ese año.
	 */
	public void findTeamsPorYear() {
		
		String input = JOptionPane.showInputDialog(this, "Enter year to search", "Find " +
				"teams" + " by año", JOptionPane.QUESTION_MESSAGE);
		try {
			int year = Integer.parseInt(input);
			ArrayList<Team> teams = world.findTeamsByYear(year);
			String mensaje = teams.size() > 0 ? "The teams from year " + year + " are:" :
					"No teams were found from year " + year + ".";
			for(Team team : teams) {
				mensaje += "\n- " + team.getCountry();
			}
			JOptionPane.showMessageDialog(this, mensaje, "Find teams by year", JOptionPane
					.INFORMATION_MESSAGE);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "The year must be numeric", "Find teams by year",
			                              JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Busca al player con la informacion dada por parametro.<br>
	 * <b>post: </b>Si el player existe, navega hasta el team y muestra la ficha tecnica del
	 * player.
	 *
	 * @param pShirt   Número of the  shirt del player. pShirt > 0.
	 * @param pCountry Country del team. pCountry != null && pCountry != "".
	 * @param pYear    Year en el cual el team represento al pais. pYear > 0.
	 */
	public void findPlayer(int pShirt, String pCountry, int pYear) {
		Player player = world.findPlayer(pShirt, pCountry, pYear);
		if(player == null) {
			JOptionPane.showMessageDialog(this, "Player does not exist", "Find player", JOptionPane
					.ERROR_MESSAGE);
		} else {
			
			DialogPlayer dialogo = new DialogPlayer(world.getTeams().get(world.findTeam(pCountry,
			                                                                            pYear)),
			                                        player);
			dialogo.setVisible(true);
			dialogo.setLocationRelativeTo(this);
		}
		
	}
	
	/**
	 * Muestra el dialogo para conocer la edad mas común de un team del albúm.
	 */
	public void mostrarMostCommonAge() {
		Object[] teams = world.getTeams().toArray();
		Team team = (Team)JOptionPane.showInputDialog(this, "Select the team", "Most common age "
				, JOptionPane.QUESTION_MESSAGE, null, teams, teams[0]);
		int edadMasComun = world.getMostCommonAge(team.getCountry(), team.getYear());
		JOptionPane.showMessageDialog(this, "The most common age of team \"" + team + "\" is " +
				edadMasComun + "", "Most common age", JOptionPane.INFORMATION_MESSAGE);
		  
	}
	
	/**
	 * Actualiza la userInterface con la informacion del world. <br>
	 * <b>post: </b>Se actualizo el team mostrado con todos sus componentes.
	 */
	private void actualizar() {
		Team teamActual = world.getTeams().get(actualIndex);
		teamPanel.actualizar(teamActual);
	}
	
	/**
	 * Carga los teams iniciales.<br>
	 * <b>pre: </b>El world esta inicializado.<br>
	 * <b>post: </b> Se cargaron los teams descritos en el archivo ./data/data.txt
	 */
	private void cargarTeams() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("./data/data.txt"));
			String infoTeam;
			while((infoTeam = in.readLine()) != null) {
				String country = infoTeam.split(";")[0];
				int year = Integer.parseInt(infoTeam.split(";")[1]);
				
				world.addTeam(country, year);
				for(int i = 0; i < Team.QUANTITY_OF_PLAYERS; i++) {
					String infoPlayer[] = in.readLine().split(";");
					
					int numeroShirt = Integer.parseInt(infoPlayer[0]);
					String nombre = infoPlayer[1];
					//String posicion = infoPlayer[2];
					
					String posicion = infoPlayer[2].toLowerCase();
					String finalPos = posicion.substring(0, 1).toUpperCase() + posicion.substring(1);
					
					
					double peso = Double.parseDouble(infoPlayer[5]);
					double altura = Double.parseDouble(infoPlayer[4]);
					int yearNacimiento = Integer.parseInt(infoPlayer[3]);
					
					world.modifyPlayer(country, year, -(i + 1), numeroShirt, nombre,
					                   getPosition(finalPos), yearNacimiento, altura, peso);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Retorna la posicion del player con el nombre dado.
	 *
	 * @param pPosition Name of the  posicion.
	 *
	 * @return Position con el nombre dado.
	 */
	private Position getPosition(String pPosition) {
		Position posicion;
		switch(pPosition) {
			case "Goalkeeper":
				posicion = Position.GOALKEEPER;
				break;
			case "Defender":
				posicion = Position.DEFENDER;
				break;
			case "Striker":
				posicion = Position.STRIKER;
				break;
			case "Winger":
				posicion = Position.WINGER;
				break;
			default:
				posicion = Position.UNKNOWN;
				break;
		}
		return posicion;
	}
	
	// -----------------------------------------------------------------
	// Points de extension
	// -----------------------------------------------------------------
	
	/**
	 * Muestra el dialogo con las estadisticas del album.<br>
	 * <b>pre: </b> El world esta inicializado.
	 */
	public void mostrarEstadisticas() {
		double porcPegadoEscudos = world.getPercentageCompletenessCardType(CardType.CREST);
		double porcPegadoTeam = world.getPercentageCompletenessCardType(CardType.TEAM);
		double porcPegadoPlayers = world.getPercentageCompletenessCardType(CardType.PLAYER);
		
		String mensaje = "- You have pasted " + porcPegadoEscudos + "% of the crests.\n";
		mensaje += "- You have pasted " + porcPegadoTeam + "% of the teams.\n";
		mensaje += "- You have pasted " + porcPegadoPlayers + "% of the players.\n";
		
		JOptionPane.showMessageDialog(this, mensaje, "Statistics", JOptionPane
				.INFORMATION_MESSAGE);
	}
	
	/**
	 * Extension 1
	 */
	public void reqFuncOpcion1() {
		
		String resultado = world.method1();
		JOptionPane.showMessageDialog(this, resultado, "Response 1", JOptionPane
				.INFORMATION_MESSAGE);
		actualizar();
	}
	
	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------
	
	/**
	 * Extension 2
	 */
	public void reqFuncOpcion2() {
		
		String resultado = world.method2();
		JOptionPane.showMessageDialog(this, resultado, "Response 2", JOptionPane
				.INFORMATION_MESSAGE);
		actualizar();
	}
	
}