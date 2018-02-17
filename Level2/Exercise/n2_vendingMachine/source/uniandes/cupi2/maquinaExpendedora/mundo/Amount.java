/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_maquinaExpendedora
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.maquinaExpendedora.mundo;

/**
 * Clase que representa un conjunto de monedas.
 */
public class Monto
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Valor m�ximo que puede tener el monto.
     */
    // TODO Parte 2 Punto A: Declarar la constante VALOR_MAXIMO seg�n el modelo del mundo.

    /**
     * Constante que representa una moneda de $50 COP.
     */
    // TODO Parte 2 Punto B: Declarar la constante MONEDA_50 seg�n el modelo del mundo.

    /**
     * Constante que representa una moneda de $100 COP.
     */
    // TODO Parte 2 Punto C: Declarar la constante MONEDA_100 seg�n el modelo del mundo.

    /**
     * Constante que representa una moneda de $200 COP.
     */
    // TODO Parte 2 Punto D: Declarar la constante MONEDA_200 seg�n el modelo del mundo.

    /**
     * Constante que representa una moneda de $500 COP.
     */
    // TODO Parte 2 Punto E: Declarar la constante MONEDA_500 seg�n el modelo del mundo.

    /**
     * Constante que representa una moneda de $1000 COP.
     */
    // TODO Parte 2 Punto F: Declarar la constante MONEDA_1000 seg�n el modelo del mundo.

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cantidad de monedas de $50 COP que hay en el monto.
     */
    private int cantidadMonedas50;

    /**
     * Cantidad de monedas de $100 COP que hay en el monto.
     */
    private int cantidadMonedas100;

    /**
     * Cantidad de monedas de $200 COP que hay en el monto.
     */
    private int cantidadMonedas200;

    /**
     * Cantidad de monedas de $500 COP que hay en el monto.
     */
    private int cantidadMonedas500;

    /**
     * Cantidad de monedas de $1000 COP que hay en el monto.
     */
    private int cantidadMonedas1000;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo monto sin monedas. <br>
     * <b>post: </b> Se inicializaron todas las cantidades en 0.
     */
    public Monto( )
    {
        // TODO Parte 2 Punto G: Completar el m�todo constructor de la clase seg�n la documentaci�n dada.
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de monedas de 50.
     * @return Cantidad de monedas de 50.
     */
    public int darCantidadMonedas50( )
    {
        return cantidadMonedas50;
    }

    /**
     * Retorna la cantidad de monedas de 100.
     * @return Cantidad de monedas de 100.
     */
    public int darCantidadMonedas100( )
    {
        return cantidadMonedas100;
    }

    /**
     * Retorna la cantidad de monedas de 200.
     * @return Cantidad de monedas de 200.
     */
    public int darCantidadMonedas200( )
    {
        return cantidadMonedas200;
    }

    /**
     * Retorna la cantidad de monedas de 500.
     * @return Cantidad de monedas de 500.
     */
    public int darCantidadMonedas500( )
    {
        return cantidadMonedas500;
    }

    /**
     * Retorna la cantidad de monedas de 1000.
     * @return Cantidad de monedas de 1000.
     */
    public int darCantidadMonedas1000( )
    {
        return cantidadMonedas1000;
    }

    /**
     * Retorna la cantidad total de monedas del monto.
     * @return Cantidad total de monedas en el monto.
     */
    public int darCantidadTotalMonedas( )
    {
        // TODO Parte 2 Punto H: Completar el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna el valor total del monto.
     * @return Valor total del monto.
     */
    public double darValorTotal( )
    {
        // TODO Parte 2 Punto I: Declarar y completar el m�todo darValorTotal seg�n la documentaci�n dada y el modelo conceptual.
    }

    /**
     * Agrega una moneda al monto. <br>
     * <b>post: </b> Se aument� en uno la cantidad de monedas de la denominaci�n dada.
     * @param pMoneda Denominaci�n de la moneda. pMoneda pertenece a {MONEDA_50, MONEDA_100, MONEDA_200, MONEDA_500, MONEDA_1000}.
     * @return True si pudo agregar la moneda, falso si no pudo agregarla porque sobrepasaba el valor m�ximo.
     */
    public boolean agregarMoneda( int pMoneda )
    {
        // TODO Parte 2 Punto J: Completar el m�todo seg�n la documentaci�n dada.
        // Debe usar 'switch' como parte de la soluci�n.
    }

    /**
     * Asigna la cantidad de monedas de cada denominaci�n necesaria para completar el valor que entra por par�metro.<br>
     * Se debe garantizar el uso de la m�nima cantidad de monedas. <br>
     * <b>post: </b> Se asign� la cantidad de monedas requeridas a cada denominaci�n.
     * @param pValor Valor a completar en monedas. pValor >= 0 && pValor%50 == 0.
     */
    public void cambiarValor( double pValor )
    {
        // TODO Parte 2 Punto K: Completar el m�todo seg�n la documentaci�n dada.
        // Se recomienda ver el documento de consideraciones adicionales de dise�o.
    }

    /**
     * Reinicia todas las cantidades de las monedas.<br>
     * <b>post: </b> Se cambiaron a 0 todas las cantidades de monedas.
     */
    public void reiniciar( )
    {
        cantidadMonedas50 = 0;
        cantidadMonedas100 = 0;
        cantidadMonedas200 = 0;
        cantidadMonedas500 = 0;
        cantidadMonedas1000 = 0;
    }
}
