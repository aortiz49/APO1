/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_triangulo
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.triangulo.mundo;

/**
 * Clase que representa un punto del triángulo.
 */
public class Punto
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Coordenada X del punto.
     */
    private double x;

    /**
     * Coordenada Y del punto.
     */
    private double y;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el punto con los valores iniciales. <br>
     * <b>post: </b> Se inicializaron los atributos con los valores dados por parámetro.
     * @param pX Coordenada X del punto. pX >= 0.
     * @param pY Coordenada Y del punto. pY >= 0.
     */
    public Punto( double pX, double pY )
    {
        x = pX;
        y = pY;
    }

    /**
     * Retorna la coordenada X del punto.
     * @return Coordenada X del punto.
     */
    public double darX( )
    {
        return x;
    }

    /**
     * Retorna la coordenada Y del punto.
     * @return Coordenada Y del punto.
     */
    public double darY( )
    {
        return y;
    }

    /**
     * Cambia la coordenada X del punto.
     * @param pX Coordenada X del punto. pX >= 0.
     */
    public void cambiarX( double pX )
    {
        x = pX;
    }

    /**
     * Cambia la coordenada Y del punto.
     * @param pY Coordenada Y del punto. pY >= 0.
     */
    public void cambiarY( double pY )
    {
        y = pY;
    }

}
