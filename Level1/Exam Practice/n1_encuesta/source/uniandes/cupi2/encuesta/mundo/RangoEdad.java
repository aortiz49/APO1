/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_encuesta
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.encuesta.mundo;

/**
 * Clase que representa un rango de edad para la encuesta.
 */
public class RangoEdad
{

    // -----------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------

    /**
     * Cantidad de opiniones hechas por gente soltera en este rango de edad.
     */
    private int numeroDeSolteros;

    /**
     * Cantidad de opiniones hechas por gente casada en este rango de edad.
     */
    private int numeroDeCasados;

    /**
     * Suma de las opiniones hechas por gente soltera en este rango de edad.
     */
    private int totalOpinionSolteros;

    /**
     * Suma de las opiniones hechas por gente casada en este rango de edad.
     */
    private int totalOpinionCasados;

    /**
     * Edad mínima para este rango de la población.
     */
    private int edadMinima;

    /**
     * Edad máxima para este rango de la población.
     */
    private int edadMaxima;
	
	/**
	 * Satisfaction level.
	 */
	private int satisfactionLevel;
	
	// -----------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------
    /**
     * Construye el rango de encuestas. <br>
     * <b>post: </b> La edad mínima y edad máxima fueron inicializadas con los valores dados por parámetro. <br>
     * El número de casados, número de solteros, el total de opiniones de solteros y el total de opiniones de casados fueron inicializados en 0.
     * @param pEdadMinima Edad mínima para este rango de la población. pEdadMinima > 0.
     * @param pEdadMaxima Edad máxima para este rango de la población. pEdadMaxima > 0 && pEdadMaxima > pEdadMinima.
     */
    public RangoEdad( int pEdadMinima, int pEdadMaxima )
    {
        numeroDeCasados = 0;
        numeroDeSolteros = 0;
        totalOpinionSolteros = 0;
        totalOpinionCasados = 0;
        edadMinima = pEdadMinima;
        edadMaxima = pEdadMaxima;
    }
    
    /**
     * Retorna el promedio de la encuesta en el rango de edad. <br>
     * @return Promedio de la encuesta en el rango de edad.
     */
    public double darPromedio( )
    {
        return ( double )darTotalOpiniones( ) / darNumeroOpiniones( );
    }
    
    /**
     * Retorna la edad mínima de este rango de edad.
     * @return Edad mínima de este rango de edad.
     */
    public int darEdadMinima( )
    {
        return edadMinima;
    }

    /**
     * Retorna la edad máxima para este rango de edad.
     * @return Edad máxima para este rango de edad.
     */
    public int darEdadMaxima( )
    {
        return edadMaxima;
    }
    
    /**
     * Retorna el promedio de las opiniones de la gente casada en este rango de edad.
     * @return Promedio de opinión del curso en la encuesta en este rango de edad de la clase considerando sólo los casados.
     */
    public double darPromedioCasados( )
    {
        return ( double )totalOpinionCasados / numeroDeCasados;
    }
    
    /**
     * Retorna el promedio de las opiniones de la gente soltera en este rango.
     * @return Promedio de opinión del curso en la encuesta en el rango de edad de la clase considerando sólo los solteros.
     */
    public double darPromedioSolteros( )
    {
        return ( double )totalOpinionSolteros / numeroDeSolteros;
    }
    
    /**
     * Retorna el número de opiniones hechas para este rango.
     * @return Cantidad total de opiniones.
     */
    public int darNumeroOpiniones( )
    {
        return numeroDeCasados + numeroDeSolteros;
    }
    
    /**
     * Retorna la suma de opiniones hechas para este rango.
     * @return Total de opiniones del curso.
     */
    public int darTotalOpiniones( )
    {
        return totalOpinionCasados + totalOpinionSolteros;
    }
    
    /**
     * Retorna el número de personas casadas que respondieron la encuesta en este rango de edad.
     * @return Número de personas casadas que respondieron la encuesta.
     */
    public int darNumeroCasados( )
    {
        return numeroDeCasados;
    }
    
    /**
     * Retorna el número de personas solteras que respondieron la encuesta en este rango de edad.
     * @return Número de personas solteras que respondieron la encuesta en este rango de edad.
     */
    public int darNumeroSolteros( )
    {
        return numeroDeSolteros;
    }
    
    /**
     * Retorna el número total de opiniones de los encuestados casados en este rango de edad.
     * @return Número total de opiniones de los encuestados casados en este rango de edad.
     */
    public int darTotalOpinionCasados( )
    {
        return totalOpinionCasados;
    }
    
    /**
     * Retorna el número total de opiniones de los encuestados solteros en este rango de edad.
     * @return Número total de opiniones de los encuestados solteros en este rango de edad.
     */
    public int darTotalOpinionSolteros( )
    {
        return totalOpinionSolteros;
    }
    
    /**
     * Retorna una cadena de texto con la edad mínima y edad máxima.
     * @return Cadena de carácteres con el rango de edades para este grupo.
     */
    public String darRangoDeEdad( )
    {
        return edadMinima + "-" + ( edadMaxima - 1 );
    }
    
    /**
     * Agrega una opinión de una persona soltera para este rango de edad. <br>
     * <b>post: </b> Se agregó una nueva opinión.
     * @param pOpinion Opinion del encuestado. pOpinion >= 0 && pOpinion < 11.
     */
    public void agregarOpinionSoltero( int pOpinion )
    {
        numeroDeSolteros = numeroDeSolteros + 1;
        totalOpinionSolteros = totalOpinionSolteros + pOpinion;
    }
    
    /**
     * Agrega una opinión de una persona casada para este rango de la población. <br>
     * <b>post: </b> Se agregó una nueva opinión.
     * @param pOpinion Opinion del encuestado. pOpinion >= 0 && pOpinion < 11.
     */
    public void agregarOpinionCasado( int pOpinion )
    {
        numeroDeCasados = numeroDeCasados + 1;
        totalOpinionCasados = totalOpinionCasados + pOpinion;
    }
    
    public int getSatisfactionLevel() {
    	return satisfactionLevel;
    }

    public void setSatisfactonLevel(int pSatisfactionLevel) {
    	satisfactionLevel = pSatisfactionLevel;
    }
	
	
	public double differenceSatisfaction(RangoEdad pRangoEdad) {
		return satisfactionLevel - pRangoEdad.getSatisfactionLevel();
	}
}
