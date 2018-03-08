/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_cupiAppStore
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiAppStore.mundo;

/**
 * Juego de la AppStore.
 */
public class Juego
{

    // -----------------------------------------------------------------
    // Enumeraciones
    // -----------------------------------------------------------------

    /**
     * Enumeradores para la categoría del juego.
     */
    public enum Categoria
    {
        /**
         * Representa la categoría rompecabezas.
         */
        ROMPECABEZAS,

        /**
         * Representa la categoría deportes.
         */
        DEPORTE,

        /**
         * Representa la categoría acción.
         */
        ACCION
    }

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del juego.
     */
    private String nombre;

    /**
     * Categoría del juego.
     */
    private Categoria categoria;

    /**
     * Precio del juego.
     */
    private int precio;

    /**
     * Tamaño en KB del juego.
     */
    private int tamanio;

    /**
     * Cantidad de licencias del juego que se tienen.
     */
    private int cantidadLicencias;

    /**
     * Cantidad de licencias que se han vendido.
     */
    private int cantidadVendidas;

    /**
     * Ruta de la imagen.
     */
    private String rutaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo juego con los valores dados por parámetro. <br>
     * <b>post: </b> El nombre, la categoría, el precio, el tamaño, la cantidad de licencias y la ruta de la imagen fueron inicializados <br>
     * con los valores dados por parámetro. La cantidad de licencias vendidas fue inicializada en 0.
     * @param pNombre Nombre del juego. pNombre != null && pNombre != "".
     * @param pCategoria Categoría del juego. pCategoria == ROMPECABEZAS || pCategoria == DEPORTE || pCategoria == ACCION.
     * @param pPrecio Precio que tiene el juego. pPrecio > 0.
     * @param pTamanio Tamaño en KB del juego. pTamanio > 0.
     * @param pCantidadLicencias Cantidad de licencias de juego disponibles. pCantidadLicencias >= 0.
     * @param pRutaImagen Ruta de la imagen del juego. pRutaImagen != null && pRutaImagen != "".
     */
    public Juego( String pNombre, Categoria pCategoria, int pPrecio, int pTamanio, int pCantidadLicencias, String pRutaImagen )
    {
        nombre = pNombre;
        categoria = pCategoria;
        precio = pPrecio;
        tamanio = pTamanio;
        cantidadLicencias = pCantidadLicencias;
        rutaImagen = pRutaImagen;
        cantidadVendidas = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del juego.
     * @return Nombre del juego
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la categoría del juego.
     * @return Categoría del juego.
     */
    public Categoria darCategoria( )
    {
        return categoria;
    }

    /**
     * Retorna el precio del juego.
     * @return Precio del juego.
     */
    public int darPrecio( )
    {
        return precio;
    }

    /**
     * Retorna el tamaño en KB del Juego.
     * @return Tamaño en KB del Juego.
     */
    public int darTamanio( )
    {
        return tamanio;
    }

    /**
     * Retorna la cantidad de licencias del juego.
     * @return Cantidad de licencias del juego.
     */
    public int darCantidadLicencias( )
    {
        return cantidadLicencias;
    }

    /**
     * Retorna la cantidad de licencias vendidas.
     * @return Cantidad de licencias vendidas.
     */
    public int darCantidadVendidas( )
    {
        return cantidadVendidas;
    }

    /**
     * Retorna la ruta de la imagen del juego.
     * @return Ruta de la imagen del juego.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    /**
     * Compra una cantidad dada de licencias. <br>
     * <b>post: </b> Se aumentó la cantidad actual de licencias del juego en la cantidad dada.
     * @param pCantidad Cantidad de licencias que se quieren comprar. pCantidad > 0.
     */
    public void comprarLicencias( int pCantidad )
    {
        cantidadLicencias += pCantidad;
    }

    /**
     * Vende una cantidad dada de licencias, si cuenta con la cantidad suficiente. <br>
     * <b>post: </b> Disminuyó la cantidad actual de licencias del juego. <br>
     * Aumentó la cantidad de licencias vendidas.
     * @param pCantidad Cantidad de licencias que se quieren vender. pCantidad > 0.
     * @return Retorna true si logra realizar la venta, false de lo contrario.
     */
    public boolean venderLicencias( int pCantidad )
    {
        boolean respuesta = false;
        if( cantidadLicencias >= pCantidad )
        {
            cantidadLicencias -= pCantidad;
            cantidadVendidas += pCantidad;
            respuesta = true;
        }
        return respuesta;
    }
}