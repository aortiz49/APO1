/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenieria de Sistemas y Computacion
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_album
 * Autor: Team Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.album.test;

import org.junit.Test;

import uniandes.cupi2.album.world.Album;
import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Positions;
import uniandes.cupi2.album.world.Card.CardType;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

/**
 * Clase de prueba para el Avion
 */
public class AlbumTest {
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Álbum sobre el cual se ejecutaran las pruebas
	 */
	private Album album;
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Prepara el album para las pruebas. <br>
	 * <b>post </b> Se crea el album, con 3 teams.
	 */
	@Before
	public void setupScenario1() {
		album = new Album();
		album.addTeam("Colombia", 2014);
		album.addTeam("Venezuela", 2018);
		album.addTeam("Venezuela", 2014);
		album.addTeam("Colombia", 1990);
	}
	
	/**
	 * <b>Test:</b> Verifies el method addTeam.<br>
	 * <b>Methods to test:</b><br>
	 * getTeams<br>
	 * addTeam<br>
	 * <b>Test Cases:</b><br>
	 * Agrega teams exitosamente.
	 */
	@Test
	public void testAddTeam() {
		assertEquals("La cantidad de teams no es correcta", album.getTeams().size(), 4);
		album.addTeam("Team1", 1950);
		album.addTeam("Team2", 1950);
		album.addTeam("Team3", 1950);
		assertEquals("La cantidad de teams no es correcta", album.getTeams().size(), 7);
	}
	
	/**
	 * <b>Test:</b> Verifies el method .<br>
	 * <b>Methods to test:</b><br>
	 * <br>
	 * <b>Test Cases:</b><br>
	 * Busca los teams exitosamente.
	 */
	@Test
	public void testFindTeamsByYear() {
		assertEquals("La cantidad de teams no es correcta", album.findTeamsByYear(1920).size(), 0);
		album.addTeam("Team1", 1950);
		album.addTeam("Team2", 1950);
		album.addTeam("Team3", 1950);
		assertEquals("La cantidad de teams no es correcta despues", album.findTeamsByYear(1950)
				.size(), 3);
	}
	
	/**
	 * <b>Test:</b> Verifies el method findTeam.<br>
	 * <b>Methods to test:</b><br>
	 * findTeam<br>
	 * <b>Test Cases:</b><br>
	 * 1. No encuentra un team que no existe. <br>
	 * 2. Busca un team exitosamente.
	 */
	@Test
	public void testFindTeam() {
		assertEquals("No debio encontrar el team pues no existe", album.findTeam("Colombia", 1998)
				, -1);
		assertEquals("No encontro el team", album.findTeam("Colombia", 2014), 3);
		int indice = album.findTeam("Colombia", 2014);
		assertTrue("El team encontrado no es correcto", album.getTeams().get(indice).getYear() ==
				2014);
		assertTrue("El team encontrado no es correcto", album.getTeams().get(indice).getCountry()
				.equals("Colombia"));
	}
	
	/**
	 * <b>Test:</b> Verifies el method findPlayer.<br>
	 * <b>Methods to test:</b><br>
	 * findPlayer<br>
	 * <b>Test Cases:</b><br>
	 * 1. No encuentra el player pues el team no existe. <br>
	 * 2. No encuentra el player pues no existe. <br>
	 * 3. Encuentra el player.
	 */
	@Test
	public void testFindPlayer() {
		assertNull("No debio encontrar el player pues el team no existe",
		           album.findPlayer(15,"Colombia", 1998));
		assertNull("No debio encontrar el player pues no existe",
		           album.findPlayer(35, "Colombia",2014));
		Team team = album.getTeams().get(2);
		Player player = team.getPlayers()[5];
		assertNotNull("Debio encontrar el player", album.findPlayer(player.getShirtNumber(), team
				.getCountry(), team.getYear()));
		assertTrue("El player encontrado no es correcto", album.findPlayer(player.getShirtNumber()
				, team.getCountry(), team.getYear()).getName().equals(player.getName()));
	}
	
	/**
	 * <b>Test:</b> Verifies el method modifyPlayer.<br>
	 * <b>Methods to test:</b><br>
	 * modifyPlayer<br>
	 * <b>Test Cases:</b><br>
	 * Modifica el player exitosamente.
	 */
	@Test
	public void testModifyPlayer() {
		assertTrue("Debio modify el player", album.modifyPlayer("Colombia", 1990, -10, -10,
		                                                        "Player", Positions.GOALKEEPER,
		                                                        1960, 1.72, 65));
	}
	
	/**
	 * <b>Test:</b> Verifies el method pasteTeamCard.<br>
	 * <b>Methods to test:</b><br>
	 * pasteTeamCard<br>
	 * <b>Test Cases:</b><br>
	 * 1. Se pega la lamina del team. <br>
	 * 2. No se pega la lamina pues ya se tiene.
	 */
	@Test
	public void testPasteTeamCard() {
		assertTrue("Debio paste la lamina ya que no se tenia", album.pasteTeamCard("Colombia",
		                                                                           2014));
		assertFalse("No debio paste la lamina pues ya estaba pegada", album.pasteTeamCard
				("Colombia", 2014));
	}
	
	/**
	 * <b>Test:</b> Verifies el method pasteCrestCard.<br>
	 * <b>Methods to test:</b><br>
	 * pasteCrestCard<br>
	 * <b>Test Cases:</b><br>
	 * 1. Se pega la lamina del escudo. <br>
	 * 2. No se pega la lamina pues ya se tiene.
	 */
	@Test
	public void testPasteCrestCard() {
		assertTrue("Debio paste la lamina ya que no se tenia", album.pasteCrestCard("Colombia",
		                                                                            2014));
		assertFalse("No debio paste la lamina pues ya estaba pegada", album.pasteCrestCard
				("Colombia", 2014));
	}
	
	/**
	 * <b>Test:</b> Verifies el method pastePlayerCard.<br>
	 * <b>Methods to test:</b><br>
	 * pastePlayerCard<br>
	 * <b>Test Cases:</b><br>
	 * 1. Se pega la lamina del player. <br>
	 * 2. No se pega la lamina pues ya se tiene.
	 */
	@Test
	public void testPastePlayerCard() {
		Player player = album.getTeams().get(0).getPlayers()[0];
		assertTrue("Debio paste la lamina ya que no se tenia", album.pastePlayerCard(player
				                                                                             .getShirtNumber(), "Colombia", 2018));
		assertFalse("No debio paste la lamina pues ya estaba pegada", album.pastePlayerCard(player
				                                                                                    .getShirtNumber(), "Colombia", 2018));
	}
	
	/**
	 * <b>Test:</b> Verifies el method getMostCommonAge.<br>
	 * <b>Methods to test:</b><br>
	 * getMostCommonAge<br>
	 * <b>Test Cases:</b><br>
	 * La edad mas común es correcta para todos los teams.
	 */
	@Test
	public void testDarMostCommonAge() {
		ArrayList<Team> teams = album.getTeams();
		for(Team team : teams) {
			int edadEsperada = team.getYear() - 1990;
			assertEquals("La edad mas esperada no es correcta", team.getMostCommonAge(),
			             edadEsperada);
		}
	}
	
	
	/**
	 * <b>Test:</b> Verifies el method getPercentageCompletenessCardType.<br>
	 * <b>Methods to test:</b><br>
	 * getPercentageCompletenessCardType<br>
	 * <b>Test Cases:</b><br>
	 * 1. El porcentaje es 0 cuando el album esta nuevo.
	 * 2. Se modifica acorde a la ocupacion.
	 */
	@Test
	public void testDarPorcentajeCompletitudCardType() {
		assertTrue("El porcentaje de completitud de playeres deberia ser 0 al crear el album",
		           album.getPercentageCompletenessCardType(CardType.PLAYER) == 0);
		assertTrue("El porcentaje de completitud de teams deberia ser 0 al crear el album", album
				.getPercentageCompletenessCardType(CardType.TEAM) == 0);
		assertTrue("El porcentaje de completitud de escudos deberia ser 0 al crear el album",
		           album.getPercentageCompletenessCardType(CardType.CREST) == 0);
		ArrayList<Team> teams = album.getTeams();
		for(int i = 0; i < teams.size(); i = i + 2) {
			Team team = teams.get(i);
			album.pasteTeamCard(team.getCountry(), team.getYear());
			album.pasteCrestCard(team.getCountry(), team.getYear());
			Player[] playeres = team.getPlayers();
			for(int j = 0; j < playeres.length / 2; j++) {
				Player player = playeres[j];
				album.pastePlayerCard(player.getShirtNumber(), team.getCountry(), team.getYear());
			}
		}
		
		
		assertTrue("El porcentaje de completitud de teams no es correcto", album
				.getPercentageCompletenessCardType(CardType.TEAM) == 50.0);
		assertTrue("El porcentaje de completitud de escudos no es correcto", album
				.getPercentageCompletenessCardType(CardType.CREST) == 50.0);
		assertTrue("El porcentaje de completitud de playeres no es correcto", album
				.getPercentageCompletenessCardType(CardType.PLAYER) == 25.0);
		
	}
	
}