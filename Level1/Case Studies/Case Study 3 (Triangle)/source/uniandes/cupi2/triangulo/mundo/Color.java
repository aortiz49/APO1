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
 * Clase que representa un color.
 */
public class Color
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Componente rojo del RGB (Red).
     */
    private int rojo;

    /**
     * Componente verde del RGB (Green).
     */
    private int verde;

    /**
     * Componente azul del RBG (Blue).
     */
    private int azul;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el color. <br>
     * <b>post: </b> Se inicializaron los atributos con los valores dados por parámetro.
     * @param pRojo Valor rojo del RGB. pRojo >= 0.
     * @param pVerde Valor green de RGB. pVerde >= 0.
     * @param pAzul Valor blue de RGB. pAzul >= 0.
     */
    public Color( int pRojo, int pVerde, int pAzul )
    {
        rojo = pRojo;
        verde = pVerde;
        azul = pAzul;
    }

    /**
     * Devuelve la valor del componente rojo (R) en el color.
     * @return Valor del componente rojo.
     */
    public int darRojo( )
    {
        return rojo;
    }

    /**
     * Devuelve la valor del componente verde (G) en el color.
     * @return Valor del componente verde.
     */
    public int darVerde( )
    {
        return verde;
    }

    /**
     * Devuelve la valor del componente azul (B) en el color.
     * @return Valor del componente azul.
     */
    public int darAzul( )
    {
        return azul;
    }

    /**
     * Cambia el valor del componente rojo (R) en el color.
     * @param pRojo Nuevo valor rojo del RGB. pRojo >= 0.
     */
    public void cambiarRojo( int pRojo )
    {
        rojo = pRojo;
    }

    /**
     * Cambia el valor del componente verde (G) en el color.
     * @param pVerde Nuevo valor verde del RGB. pVerde >= 0.
     */
    public void cambiarVerde( int pVerde )
    {
        verde = pVerde;
    }

    /**
     * Cambia el valor del componente azul (B) en el color.
     * @param pAzul Nuevo valor azul del RGB. pAzul >= 0.
     */
    public void cambiarAzul( int pAzul )
    {
        azul = pAzul;
    }

}
