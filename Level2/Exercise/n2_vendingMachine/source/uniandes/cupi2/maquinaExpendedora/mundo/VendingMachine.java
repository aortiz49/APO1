/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_maquinaExpendedora
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.maquinaExpendedora.mundo;

import uniandes.cupi2.maquinaExpendedora.mundo.Producto.Tipo;

/**
 * Representa la máquina expendedora.
 */
public class MaquinaExpendedora
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la máquina expendedora.
     */
    private Producto producto1;

    /**
     * Producto 2 de la máquina expendedora.
     */
    private Producto producto2;

    /**
     * Producto 3 de la máquina expendedora.
     */
    private Producto producto3;

    /**
     * Producto 4 de la máquina expendedora.
     */
    private Producto producto4;

    /**
     * Crédito disponible en la máquina.
     */
    
    //TODO Parte 3 Punto A: Declarar la relación credito según el modelo del mundo.
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva máquina expendedora. <br>
     * <b>post: </b> La cantidad en caja se inicializó en 0.<br>
     * Los 4 productos se inicializaron con sus valores iniciales y se inicializó el crédito. <br>
     */
    public MaquinaExpendedora( )
    {
        producto1 = new Producto( "A1", "Papas Natural Margarita", 1300 );
        producto2 = new Producto( "A2", "Jugo Hit", 2000 );
        producto3 = new Producto( "B1", "Chocolatina Jet", 450 );
        producto4 = new Producto( "B2", "Galletas Festival", 800 );
        // TODO Parte 3 Punto B: Hacer las modificaciones necesarias para que se incluyan los nuevos parámetros del constructor de la clase Producto. 
        //                       Completar el método constructor de la clase según la documentación dada.
    } 

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el valor del crédito disponible en la máquina.
     * @return Valor del crédito de la máquina.
     */
        //TODO Parte 3 Punto C: Declarar y completar el método darValorCredito según la documentación dada y el modelo conceptual.
    
    /**
     * Retorna el producto con el identificador recibido por parámetro. <br>
     * <b>pre: </b> Existe un producto con el identificador dado.
     * @param pIdentificador Identificador del producto buscado. pIdentificador != null && pIdentificador != "".
     * @return Producto con el identificador dado.
     */
    public Producto darProducto( String pIdentificador )
    {
        //TODO Parte 3 Punto D: Complete el método según la documentación dada.
    }
    /**
     * Agrega una moneda al crédito de la máquina.<br>
     * <b> post: </b> Se agregó la moneda al crédito.
     * @param pMoneda Denominación de la moneda. pMoneda = { Monto.MONEDA_50 , Monto.MONEDA_100 , Monto.MONEDA_200, Monto.MONEDA_500 , Monto.MONEDA_1000}.
     * @return True si pudo agregar la moneda, false si superaba el valor máximo.
     */
    public boolean agregarMoneda( int pMoneda )
    {
        // TODO Parte 3 Punto E: Complete el método según la documentación dada.
    }

    /**
     * Compra una unidad del producto con el identificador dado. <br>
     * <b> pre: </b> Existe un producto con el identificador dado. <br>
     * <b> post: </b>Si hay crédito y unidades suficientes se realiza la compra y se cambia el valor del crédito actual.<br>
     * @param pIdentificador identificador del producto. pIdentificador != null && pIdentificador != "".
     * @return Retorna true si se realizó la compra, false si no hay crédito suficiente o no habían unidades disponible.
     */
    public boolean comprarProducto( String pIdentificador )
    {

        // TODO Parte 3 Punto F: Complete el método según la documentación dada y las restricciones.
    }

    /**
     * Termina la compra y retorna el cambio.<br>
     * <b>post:<\b> Calcula el monto de dinero que se debe dar como cambio y reinicia el crédito.
     * @return Monto de dinero correspondiente al cambio.
     */
    public Monto terminarCompra( )
    {
        Monto cambio = new Monto( );
        cambio.cambiarValor( credito.darValorTotal( ) );
        credito.reiniciar( );
        return cambio;
    }

    /**
     * Calcula la cantidad total de unidades compradas de la máquina.
     * @return Cantidad total de unidades compradas de la máquina.
     */
    public int darCantidadTotalUnidadesCompradas( )
    {
        int totalCompras = producto1.darCantidadUnidadesCompradas( ) + producto2.darCantidadUnidadesCompradas( ) + producto3.darCantidadUnidadesCompradas( ) + producto4.darCantidadUnidadesCompradas( );
        return totalCompras;
    }

    /**
     * Calcula el valor total de las compras de la máquina.
     * @return Valor total de las compras de la máquina.
     */
    public double darValorTotalCompras( )
    {
        double valor = producto1.darCantidadUnidadesCompradas( ) * producto1.darPrecio( ) + producto2.darCantidadUnidadesCompradas( ) * producto2.darPrecio( ) + producto3.darCantidadUnidadesCompradas( ) * producto3.darPrecio( )
                + producto4.darCantidadUnidadesCompradas( ) * producto4.darPrecio( );
        return valor;
    }

    /**
     * Calcula el porcentaje de disponibilidad de la máquina.
     * @return Porcentaje de disponibilidad de la máquina.
     */
    public double darPorcentajeDisponibilidad( )
    {
        // TODO Parte 3 Punto G: Complete el método según la documentación dada y la definición de la funcionalidad.
    }

    /**
     * Retorna el valor total de la donación al FOPRE de productos del tipo especificado.
     * @param pTipo Tipo de producto de interés. pTipo pertenece a {Tipo.BEBIDA , Tipo.COMIDA}.
     * @return Total de donación al FOPRE del tipo de producto.
     */
    public double darDonacionPorTipo( Tipo pTipo )
    {
        // TODO Parte 3 Punto H: Complete el método según la documentación dada.
    }

    /**
     * Retorna el total de unidades FOPRE compradas para un tipo específico.
     * @param pTipo Tipo de producto de interés. pTipo pertenece a {Tipo.BEBIDA , Tipo.COMIDA}.
     * @return La suma de las unidades compradas de los productos FOPRE del tipo dado.
     */
    public int darCantidadUnidadesCompradasFopre( Tipo pTipo )
    {
        // TODO Parte 3 Punto I: Complete el método según la documentación dada.
    }

    /**
     * Retorna el producto más comprado.
     * @return Producto más comprado. Si hay dos productos con la mayor cantidad de unidades compradas, se retorna el primero encontrado.
     */
    public Producto darProductoMasComprado( )
    {
        // TODO Parte 3 Punto J: Complete el método según la documentación dada.
    }

    /**
     * Retorna el valor total de la donación al FOPRE.
     * @return Donación total al FOPRE.
     */
 // TODO Parte 3 Punto K: Declarar y completar el método darDonacionTotal según la documentación dada y el modelo conceptual.

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Extensión 1.
     * @return Respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Extensión 2.
     * @return Respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}
