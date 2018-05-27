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
 * Clase que representa la encuesta del curso.
 */
public class Encuesta
{

    // -----------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------

    /**
     * Modela el rango de edad: 0 < años <= 17.
     */
    private RangoEdad rangoEdadJovenes;

    /**
     * Modela el rango de edad: 18 <= años <= 54.
     */
    private RangoEdad rangoEdadAdultos;

    /**
     * Modela el rango de edad: 55 <= años.
     */
    private RangoEdad rangoEdadMayores;

    // -----------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------

    /**
     * Inicializa la encuesta. <br>
     * <b>post: </b> Se inicializaron los tres rangos de la encuesta. <br>
     * Rango jóvenes: 0 < años <= 17 <br>
     * Rango adultos: 18 <= años <= 54 <br>
     * Rango mayores: 55 <= años <= 200
     */
    public Encuesta( )
    {
        rangoEdadJovenes = new RangoEdad( 0, 18 );
        rangoEdadAdultos = new RangoEdad( 18, 55 );
        rangoEdadMayores = new RangoEdad( 55, 200 );
    }

    /**
     * Retorna el promedio de opiniones de gente entre 0 y 17 años que sea casada.
     * @return Promedio de opiniones de personas casadas entre 0 y 17 años.
     */
    public double darResultadosJovenesCasados( )
    {
        return rangoEdadJovenes.darPromedioCasados( );
    }

    /**
     * Retorna el promedio de opiniones de gente entre 18 y 54 años que sea casada.
     * @return Promedio de opiniones de personas casadas entre 18 y 54 años.
     */
    public double darResultadosAdultosCasados( )
    {
        return rangoEdadAdultos.darPromedioCasados( );
    }

    /**
     * Retorna el promedio de opiniones de gente con 55 años o más que sea casada.
     * @return Promedio de opiniones de personas casadas con 55 años o más.
     */
    public double darResultadosMayoresCasados( )
    {
        return rangoEdadMayores.darPromedioCasados( );
    }

    /**
     * Retorna el promedio de opiniones de gente entre 0 y 17 años que sea soltera.
     * @return Promedio de opiniones de personas solteras entre 0 y 17 años.
     */
    public double darResultadosJovenesSolteros( )
    {
        return rangoEdadJovenes.darPromedioSolteros( );
    }

    /**
     * Retorna el promedio de opiniones de gente entre 18 y 54 años que sea soltera.
     * @return Promedio de opiniones de personas solteras entre 18 y 54 años.
     */
    public double darResultadosAdultosSolteros( )
    {
        return rangoEdadAdultos.darPromedioSolteros( );
    }

    /**
     * Retorna el promedio de opiniones de gente de 55 años o más que sea soltera.
     * @return Promedio de opiniones de personas solteras con 55 años o más.
     */
    public double darResultadosMayoresSolteros( )
    {
        return rangoEdadMayores.darPromedioSolteros( );
    }

    /**
     * Retorna el número total de opiniones hechas en la encuesta.
     * @return Número total de opiniones.
     */
    public int darNumeroTotalOpiniones( )
    {
        int numeroDeOpinionesTotal;
        numeroDeOpinionesTotal = rangoEdadJovenes.darNumeroOpiniones( ) + rangoEdadAdultos.darNumeroOpiniones( ) + rangoEdadMayores.darNumeroOpiniones( );
        return numeroDeOpinionesTotal;
    }

    /**
     * Retorna el número total de casados que han contestado la encuesta.
     * @return Número total de opiniones de personas casadas.
     */
    public int darNumeroTotalOpinionesCasados( )
    {
        int numeroDeOpinionesTotalCasados;
        numeroDeOpinionesTotalCasados = rangoEdadJovenes.darNumeroCasados( ) + rangoEdadAdultos.darNumeroCasados( ) + rangoEdadMayores.darNumeroCasados( );
        return numeroDeOpinionesTotalCasados;
    }

    /**
     * Retorna el número total de solteros que han contestado la encuesta.
     * @return Número total de opinions de personas solteras.
     */
    public int darNumeroTotalOpinionesSolteros( )
    {
        int numeroDeOpinionesTotalSolteros;
        numeroDeOpinionesTotalSolteros = rangoEdadJovenes.darNumeroSolteros( ) + rangoEdadAdultos.darNumeroSolteros( ) + rangoEdadMayores.darNumeroSolteros( );
        return numeroDeOpinionesTotalSolteros;
    }

    /**
     * Retorna el promedio de las respuestas de la encuesta.
     * @return Promedio de las respuestas de la encuesta.
     */
    public double darPromedio( )
    {
        double totalEncuesta;
        double promedioEncuesta;

        totalEncuesta = rangoEdadJovenes.darTotalOpiniones( ) + rangoEdadAdultos.darTotalOpiniones( ) + rangoEdadMayores.darTotalOpiniones( );

        promedioEncuesta = totalEncuesta / darNumeroTotalOpiniones( );

        return promedioEncuesta;
    }

    /**
     * Retorna el promedio de las respuestas de personas casadas.
     * @return Promedio de las respuestas de personas casadas.
     */
    public double darPromedioCasados( )
    {
        double totalEncuestaCasados;
        double promedioEncuesta;

        totalEncuestaCasados = rangoEdadJovenes.darTotalOpinionCasados( ) + rangoEdadAdultos.darTotalOpinionCasados( ) + rangoEdadMayores.darTotalOpinionCasados( );

        promedioEncuesta = totalEncuestaCasados / darNumeroTotalOpinionesCasados( );

        return promedioEncuesta;
    }

    /**
     * Retorna el promedio de las respuestas de personas solteras.
     * @return Promedio de las respuestas de personas solteras.
     */
    public double darPromedioSolteros( )
    {
        double totalEncuestaSolteros;
        double promedioEncuesta;

        totalEncuestaSolteros = rangoEdadJovenes.darTotalOpinionSolteros( ) + rangoEdadAdultos.darTotalOpinionSolteros( ) + rangoEdadMayores.darTotalOpinionSolteros( );

        promedioEncuesta = totalEncuestaSolteros / darNumeroTotalOpinionesSolteros( );

        return promedioEncuesta;
    }

    /**
     * Retorna el rango de edades para el primer rango de la encuesta.
     * @return Cadena con el rango de edades para el primer rango de la encuesta.
     */
    public String darRangoEdad1( )
    {
        return rangoEdadJovenes.darRangoDeEdad( );
    }

    /**
     * Retorna el rango de edades para el segundo rango de la encuesta.
     * @return Cadena con el rango de edades para el segundo rango de la encuesta.
     */
    public String darRangoEdad2( )
    {
        return rangoEdadAdultos.darRangoDeEdad( );
    }

    /**
     * Retorna el rango de edades para el tercer rango de la encuesta.
     * @return Cadena con el rango de edades para el tercer rango de la encuesta.
     */
    public String darRangoEdad3( )
    {
        return rangoEdadMayores.darRangoDeEdad( );
    }

    /**
     * Agrega una opinión de una personas soltera entre 0 y 17 años. <br>
     * <b>post: </b> Se agregó la opinión a la encuesta.
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion > 0 && pOpinion <= 10.
     */
    public void agregarOpinionRangoEdadJovenesSoltero( int pOpinion )
    {
        rangoEdadJovenes.agregarOpinionSoltero( pOpinion );
    }

    /**
     * Agrega una opinión de una personas soltera entre 18 y 55 años. <br>
     * <b>post: </b> Se agregó la opinión a la encuesta.
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion > 0 && pOpinion <= 10.
     */
    public void agregarOpinionRangoEdadAdultosSoltero( int pOpinion )
    {
        rangoEdadAdultos.agregarOpinionSoltero( pOpinion );
    }

    /**
     * Agrega una opinión de una personas soltera entre 55 y 200 años. <br>
     * <b>post: </b> Se agregó la opinión a la encuesta.
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion > 0 && pOpinion <= 10.
     */
    public void agregarOpinionRangoEdadMayoresSoltero( int pOpinion )
    {
        rangoEdadMayores.agregarOpinionSoltero( pOpinion );
    }

    /**
     * Agrega una opinión de una personas casada entre 0 y 18 años. <br>
     * <b>post: </b> Se agregó la opinión a la encuesta.
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion > 0 && pOpinion <= 10.
     */
    public void agregarOpinionRangoEdadJovenesCasado( int pOpinion )
    {
        rangoEdadJovenes.agregarOpinionCasado( pOpinion );
    }

    /**
     * Agrega una opinión de una personas casada entre 18 y 55 años. <br>
     * <b>post: </b> Se agregó la opinión a la encuesta.
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion > 0 && pOpinion <= 10.
     */
    public void agregarOpinionRangoEdadAdultosCasado( int pOpinion )
    {
        rangoEdadAdultos.agregarOpinionCasado( pOpinion );
    }

    /**
     * Agrega una opinión de una personas casada entre 55 y 200 años. <br>
     * <b>post: </b>Se agregó la opinión a la encuesta.
     * @param pOpinion Opinión que se va a agregar a la encuesta. pOpinion > 0 && pOpinion <= 10.
     */
    public void agregarOpinionRangoEdadMayoresCasado( int pOpinion )
    {
        rangoEdadMayores.agregarOpinionCasado( pOpinion );
    }
    
    public double averageSatisfaction() {
        
        return (rangoEdadAdultos.getSatisfactionLevel() + rangoEdadJovenes.getSatisfactionLevel() +
            rangoEdadMayores.getSatisfactionLevel())/3.0;
    }
   

    // -----------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------

    /**
     * Método de extensión 1 para el ejemplo.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método de extensión 2 para el ejemplo.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
