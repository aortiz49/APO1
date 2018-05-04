/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_campeonato
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.campeonato.mundo;

/**
 * Es la clase que representa a un equipo.
 */
public class Equipo
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El nombre del equipo.
     */
    private String nombre;

    /**
     * La ruta del logo del equipo.
     */
    private String ruta;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva instancia de un equipo.
     * @param pNombreEquipo El nombre del equipo. pNombreEquipo != null && pNombreEquipo != "".
     * @param pRuta La ruta del logo del equipo. pEquipo != null && pEquipo != "".
     */
    public Equipo( String pNombreEquipo, String pRuta )
    {
        nombre = pNombreEquipo;
        ruta = pRuta;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del equipo.
     * @return El nombre del equipo.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el ruta del equipo.
     * @return La ruta del equipo.
     */
    public String darRuta( )
    {
        return ruta;
    }

    /**
     * Retorna una representación como cadena de caracteres del equipo.
     * @return El nombre del equipo.
     */
    public String toString( )
    {
        return nombre;
    }
}