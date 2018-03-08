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

import uniandes.cupi2.cupiAppStore.mundo.Juego.Categoria;

/**
 * Tienda virtual de juegos.
 */
public class AppStore
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa la cantidad mínima de licencias de juegos de rompecabezas para la primera opción de descuento.
     */
    public final static int CANT_MIN_ROMPECABEZAS = 25;

    /**
     * Representa la cantidad mínima de licencias de juegos de deporte para la segunda opción de descuento.
     */
    public final static int CANT_MIN_DEPORTE = 20;

    /**
     * Representa la cantidad mínima de licencias de juegos de acción para la segunda opción de descuento.
     */
    public final static int CANT_MIN_ACCION = 12;

    /**
     * Representa el valor del primer descuento.
     */
    public final static double DESCUENTO_1 = 0.20;

    /**
     * Representa el valor del segundo descuento.
     */
    public final static double DESCUENTO_2 = 0.15;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Juego 1 de la AppStore.
     */
    private Juego juego1;

    /**
     * Juego 2 de la AppStore.
     */
    private Juego juego2;

    /**
     * Juego 3 de la AppStore.
     */
    private Juego juego3;

    /**
     * Juego 4 de la AppStore.
     */
    private Juego juego4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la AppStore con sus 4 juegos. <br>
     * <b>post: </b> Los juegos fueron inicializados con los siguientes valores: <br>
     * Juego1 - Nombre: Candy Crush, Categoría: Rompecabezas, Precio: 3000, Tamaño (en KB): 300, Cantidad de licencias: 50, Imagen: CandyCrush.jpg. <br>
     * Juego2 - Nombre: Flow, Categoría: Rompecabezas, Precio: 5500, Tamaño (en KB): 250, Cantidad de licencias: 15, Imagen: Flow.jpg. <br>
     * Juego3 - Nombre: FIFA, Categoría: Deporte, Precio: 7500, Tamaño (en KB): 850, Cantidad de licencias: 80, Imagen: FIFA.jpg. <br>
     * Juego4 - Nombre: Clash of Clans, Categoría: Acción, Precio: 2000, Tamaño (en KB): 1000, Cantidad de licencias: 36, Imagen: ClashOfClans.jpg. <br>
     */
    public AppStore( )
    {
        juego1 = new Juego( "Candy Crush", Categoria.ROMPECABEZAS, 3000, 300, 50, "CandyCrush.jpg" );
        juego2 = new Juego( "Flow", Categoria.ROMPECABEZAS, 5500, 250, 15, "Flow.jpg" );
        juego3 = new Juego( "FIFA", Categoria.DEPORTE, 7500, 850, 80, "FIFA.jpg" );
        juego4 = new Juego( "Clash of Clans", Categoria.ACCION, 2000, 1000, 36, "ClashOfClans.jpg" );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el juego 1.
     * @return Juego 1.
     */
    public Juego darJuego1( )
    {
        return juego1;
    }

    /**
     * Retorna el juego 2.
     * @return Juego 2.
     */
    public Juego darJuego2( )
    {
        return juego2;
    }

    /**
     * Retorna el juego 2.
     * @return Juego 3.
     */
    public Juego darJuego3( )
    {
        return juego3;
    }

    /**
     * Retorna el juego 4.
     * @return Juego 4.
     */
    public Juego darJuego4( )
    {
        return juego4;
    }

    /**
     * Busca un juego dado su nombre.
     * @param pNombreJuego Nombre del juego. pNombreJuego != null && pNombreJuego != "".
     * @return Juego con el nombre dado, null en caso de no encontrarlo.
     */
    public Juego buscarJuego( String pNombreJuego )
    {
        Juego buscado = null;
        if( pNombreJuego.equals( juego1.darNombre( ) ) )
        {
            buscado = juego1;
        }
        else if( pNombreJuego.equals( juego2.darNombre( ) ) )
        {
            buscado = juego2;
        }
        else if( pNombreJuego.equals( juego3.darNombre( ) ) )
        {
            buscado = juego3;
        }
        else if( pNombreJuego.equals( juego4.darNombre( ) ) )
        {
            buscado = juego4;
        }

        return buscado;
    }

    /**
     * Registra la venta de licencias de un juego dado su nombre. <br>
     * <b>post: </b> Aumentó la cantidad de licencias vendidas del juego. <br>
     * Si la cantidad de juegos a vender era mayor que la cantidad de existencias del juego, la venta no se realizó.
     * @param pNombreJuego Nombre del juego a vender. pNombreJuego != null && pNombreJuego != "".
     * @param pCantidad Cantidad de licencias que se van a vender. pCantidad > 0.
     * @return Retorna true si logró realizar la venta, false de lo contrario.
     */
    public boolean venderLicenciasJuego( String pNombreJuego, int pCantidad )
    {
        boolean respuesta = false;
        if( buscarJuego( pNombreJuego ) != null )
        {
            respuesta = buscarJuego( pNombreJuego ).venderLicencias( pCantidad );
        }
        return respuesta;
    }

    /**
     * Registra la compra de licencias de un juego dado su nombre. <br>
     * <b>post: </b> Aumentó la cantidad de licencias del juego.
     * @param pNombreJuego Nombre del juego a comprar. pNombreJuego != null && pNombreJuego != "".
     * @param pCantidad Cantidad de licencias que se van a comprar. pCantidad > 0.
     */
    public void comprarLicenciasJuego( String pNombreJuego, int pCantidad )
    {
        if( buscarJuego( pNombreJuego ) != null )
        {
            buscarJuego( pNombreJuego ).comprarLicencias( pCantidad );
        }
    }

    /**
     * Retorna el nombre del juego con más unidades vendidas. <br>
     * En caso de que se haya vendido la misma cantidad de licencias para varios juegos y esta sea la mayor cantidad, se retorna el nombre del primero <br>
     * de los juegos que cumpla con la condición.
     * @return Nombre del juego que ha vendido una mayor cantidad de licencias o "Ninguno" en caso en el que ningún juego haya vendido licencias.
     */
    public String darJuegoMasVendido( )
    {
        String masVendido = "Ninguno";
        int cantidadMasVendida = 0;
        if( juego1.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego1.darNombre( );
            cantidadMasVendida = juego1.darCantidadVendidas( );
        }
        if( juego2.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego2.darNombre( );
            cantidadMasVendida = juego2.darCantidadVendidas( );
        }
        if( juego3.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego3.darNombre( );
            cantidadMasVendida = juego3.darCantidadVendidas( );
        }
        if( juego4.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego4.darNombre( );
            cantidadMasVendida = juego4.darCantidadVendidas( );
        }

        return masVendido;
    }

    /**
     * Retorna una cadena de texto con el descuento por ventas de juegos en volumen teniendo en cuenta las siguientes reglas: <br>
     * - Si se quieren comprar mínimo 25 licencias de juegos de rompecabezas se dará un descuento del 20% sobre el valor total. <br>
     * - Si se quieren comprar al menos 20 licencias de juegos de deportes y 12 licencias de juegos de acción se dará un descuento del 15% sobre el valor total. <br>
     * Cuando en una venta se cumplen las dos condiciones anteriores, sólo se aplica el primer descuento.
     * @param pCantidadLicenciasJuego1 Cantidad de licencias que se pretenden vender del juego1.
     * @param pCantidadLicenciasJuego2 Cantidad de licencias que se pretenden vender del juego2.
     * @param pCantidadLicenciasJuego3 Cantidad de licencias que se pretenden vender del juego3.
     * @param pCantidadLicenciasJuego4 Cantidad de licencias que se pretenden vender del juego4.
     * @return Cadena de texto que informa el precio total de las licencias de juego a vender antes del descuento, el valor del descuento y el precio final con el descuento.
     */
    public String calcularVentaPorVolumen( int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
    {
        int cantRompecab = 0;
        int cantDeporte = 0;
        int cantAccion = 0;

        switch( juego1.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego1;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego1;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego1;
                break;
            }
        }
        switch( juego2.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego2;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego2;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego2;
                break;
            }
        }
        switch( juego3.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego3;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego3;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego3;
                break;
            }
        }
        switch( juego4.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego4;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego4;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego4;
                break;
            }
        }

        double totalVenta = ( juego1.darPrecio( ) * pCantidadLicenciasJuego1 ) + ( juego2.darPrecio( ) * pCantidadLicenciasJuego2 ) + ( juego3.darPrecio( ) * pCantidadLicenciasJuego3 ) + ( juego4.darPrecio( ) * pCantidadLicenciasJuego4 );
        double descuento = 0;

        if( cantRompecab >= CANT_MIN_ROMPECABEZAS )
        {
            descuento = totalVenta * DESCUENTO_1;
        }
        else if( cantDeporte >= CANT_MIN_DEPORTE && cantAccion >= CANT_MIN_ACCION )
        {
            descuento = totalVenta * DESCUENTO_2;
        }
        else
        {
            descuento = 0;
        }

        double totalConDescuento = totalVenta - descuento;

        String mensaje = "El precio total de la venta sería: $" + totalVenta + ".\n" + "El descuento sería de: $" + descuento + "\n" + "El precio con descuento sería: $" + totalConDescuento + ".";

        return mensaje;

    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}