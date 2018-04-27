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
package uniandes.cupi2.impuestosCarro.mundo;

/**
 * Rango de impuesto de veh�culos.
 */
public class RangoImpuesto {
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Inicio of the  rango.
	 */
	private double inicio;
	
	/**
	 * Fin of the  rango.
	 */
	private double fin;
	
	/**
	 * Porcentaje.
	 */
	private double porcentaje;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Crea un rango de impuesto.<br>
	 * <b> post:</b> Se inicializ� el inicio, el fin y el porcentaje con la informaci�n dada por
	 * par�metro.
	 *
	 * @param pInicio     Inicio of the  rango. pInicio &gt; 0.
	 * @param pFin        Fin of the  rango. pFin &gt; pInicio
	 * @param pPorcentaje Porcentaje de impuesto que aplica para el rango. pPorcentaje &gt; 0
	 */
	public RangoImpuesto(double pInicio, double pFin, double pPorcentaje) {
		inicio = pInicio;
		fin = pFin;
		porcentaje = pPorcentaje;
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns the porcentaje.
	 *
	 * @return Porcentaje of the  rango.
	 */
	public double getPorcentaje() {
		return porcentaje;
	}
	
	/**
	 * Indica si el valor est� en el rango.
	 *
	 * @param pValor Valor que se va a buscar en el rango.
	 *
	 * @return True si el valor est� en el rango, false en caso contrario.
	 */
	public boolean contieneA(double pValor) {
		return (pValor >= inicio && pValor < fin);
	}
}