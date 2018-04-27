/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n5_MagicalCreatures
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.magicalCreatures.world;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Magical creatures searching game.
 */
public class MagicalCreatures {
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Encyclopedia of creatures that can be found.
	 */
	private Creature[] encyclopedia;
	
	/**
	 * The latest data loaded by the game.
	 */
	private Properties data;
	
	/**
	 * Current creature on display.
	 */
	private int currentCreature;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Crea la instancia principal of the aplicaci�n y carga la encyclopedia de creatures. <br>
	 * <b>post: </b> Se ha cargado la informaci�n del arreglo de creatures.
	 *
	 * @param pImagePathCreatures Ruta del archivo donde se encuentra la informaci�n of the
	 *                       encyclopedia de creatures. pImagePathCreatures != null && pImagePathCreatures
	 *                       != "".
	 *
	 * @throws Exception Si hubo error al load the archivo.
	 *                   Si hubo error al leer the formato del archivo.
	 */
	public MagicalCreatures(String pImagePathCreatures) throws Exception {
		try {
			load(pImagePathCreatures);
			initializeCreatures();
		} catch (Exception e) {
			throw e;
		}
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns la creature actual of the encyclopedia.
	 *
	 * @return La creature actual of the encyclopedia.
	 */
	public Creature getCurrentCreature() {
		return encyclopedia[currentCreature];
	}
	
	/**
	 * Returns la nextCreature creature a la creature actual. <br>
	 * <b>post: </b> Se ha modificado la creature actual a la nextCreature creature.
	 *
	 * @return La nextCreature creature.
	 * @throws Exception Si ya se encuentra en la �ltima creature of the encyclopedia.
	 */
	public Creature getNext() throws Exception {
		if (currentCreature == encyclopedia.length - 1) {
			throw new Exception("Ya se encuentra en la �ltima creature.");
		}
		
		currentCreature++;
		return encyclopedia[currentCreature];
	}
	
	/**
	 * Returns la anterior creature a la creature actual. <br>
	 * <b>post: </b> Se ha modificado la creature actual a la anterior creature.
	 *
	 * @return La anterior creature.
	 * @throws Exception Si ya se encuentra en la primera creature of the encyclopedia.
	 */
	public Creature getPrevious() throws Exception {
		if (currentCreature == 0) {
			throw new Exception("Ya se encuentra en la primera creature.");
		}
		
		currentCreature--;
		return encyclopedia[currentCreature];
	}
	
	/**
	 * Returns the puntaje del jugador. Este valor siempre es 0.
	 *
	 * @return El  puntaje del jugador.
	 */
	public int getPoints() {
		return 0;
	}
	
	/**
	 * Returns la cantidad de movimientos restantes del jugador. Este valor siempre es 10.
	 *
	 * @return La cantidad de movimientos restantes del jugador.
	 */
	public int getRemainingMoves() {
		return 10;
	}
	
	/**
	 * Busca una creature por su name en la encyclopedia de creatures.
	 *
	 * @param pName Name of the creature. pName != null && pName != "".
	 *
	 * @return La creature con the name especificado. Si no la encuentra retorna null.
	 */
	public Creature findCreature(String pName) {
		Creature buscada = null;
		for (int i = 0; i < encyclopedia.length && buscada == null; i++) {
			if (encyclopedia[i].getName().equals(pName)) {
				buscada = encyclopedia[i];
			}
		}
		
		return buscada;
	}
	
	/**
	 * Carga the archivo especificado por par�metro para procesarlo.
	 *
	 * @param pImagePath Ruta del archivo especificado. pImagePath != null && pImagePath != "".
	 *
	 * @throws Exception Si se encuentra alg�n problema al load the archivo.
	 */
	private void load(String pImagePath) throws Exception {
		data = new Properties();
		FileInputStream in = new FileInputStream(pImagePath);
		try {
			data.load(in);
			in.close();
			
		} catch (IOException e) {
			throw new Exception("Error al load the archivo, archivo no v�lido.");
		}
	}
	
	/**
	 * Inicializa the arreglo de creatures a partir del archivo de configuraci�n. <br>
	 * <b>post: </b> Ha sido inicializada la encyclopedia de creatures.
	 *
	 * @throws Exception Lanza excepci�n si hay alg�n error al initialize las creatures.
	 */
	private void initializeCreatures() throws Exception {
		try {
			int cantidadCreatures = Integer.parseInt(data.getProperty("creatures.cantidad"));
			
			encyclopedia = new Creature[cantidadCreatures];
			for (int i = 0; i < cantidadCreatures; i++) {
				String name = data.getProperty("creatures.creature" + (i + 1) + ".name");
				String interests = data.getProperty("creatures.creature" + (i + 1) + "" +
                                                         ".interests");
				String fears = data.getProperty("creatures.creature" + (i + 1) + ".fears");
				boolean isBeingOfLight = true;
				int points = Integer.parseInt(data.getProperty("creatures.creature" + (i + 1) + "" +
                                                                    ".points"));
				
				if (data.getProperty("creatures.creature" + (i + 1) + ".isBeingOfLight").equals
                    ("false")) {
					isBeingOfLight = false;
				}
				String creatureImagePath = data.getProperty("creatures.creature" + (i + 1) + "" +
                                                                 ".path");
				
				encyclopedia[i] = new Creature(name, interests, fears, isBeingOfLight, points,
                                               creatureImagePath);
			}
			
			currentCreature = 0;
		} catch (Exception e) {
			throw new Exception("Error al leer the formato del archivo.");
		}
	}
	
	/**
	 * Returns la cantidad de creatures en la fila especificada. Esta cantidad se genera
	 * aleatoriamente.
	 *
	 * @param pFila Fila que se desea consultar.
	 *
	 * @return Cantidad de creatures en la fila especificada.
	 */
	public int getQuantityCreaturesRow(int pFila) {
		double valorAleatorio = Math.random();
		int cantidad = (int)(5 * valorAleatorio);
		
		return cantidad;
	}
	
	/**
	 * Returns la cantidad de creatures en la columna especificada. Esta cantidad se genera
	 * aleatoriamente.
	 *
	 * @param pColumna Columna que se desea consultar.
	 *
	 * @return Cantidad de creatures en la columna especificada.
	 */
	public int getQuantityCreaturesColumn(int pColumna) {
		double valorAleatorio = Math.random();
		int cantidad = (int)(5 * valorAleatorio);
		
		return cantidad;
	}
	
	/**
	 * Returns the puntaje total que se puede obtener si se encuentran todas las creatures the
	 * cuadrante especificado. Esta cantidad se genera aleatoriamente.
	 *
	 * @param pCuadrante Cuadrante que se desea consultar. pCuadrante > 0 && pCuadrante <= 4
	 *
	 * @return El puntaje que se puede obtener en cuadrante especificado.
	 */
	public int calculatePointsInQuadrant(int pCuadrante) {
		double valorAleatorio = Math.random();
		int cantidad = (int)(2000 * valorAleatorio);
		
		return cantidad;
		
	}
	
	/**
	 * Returns la creature de luz no encontrada que tiene the mayor puntaje. Siempre retorna the
     * drag�n.
	 *
	 * @return Creature con the mayor puntaje.
	 */
	public Creature getHighestPointsCreature() {
		return findCreature("Dragon");
	}
	
	// ----------------------------------------------------------------
	// Methods de Extensi�n
	// ----------------------------------------------------------------
	
	/**
	 * M�todo para la extensi�n 1.
	 *
	 * @return Respuesta 1.
	 */
	public String method1() {
		return "Respuesta 1";
	}
	
	/**
	 * M�todo para la extensi�n 2.
	 *
	 * @return Respuesta 2.
	 */
	public String method2() {
		return "Respuesta 2";
	}
	
}
