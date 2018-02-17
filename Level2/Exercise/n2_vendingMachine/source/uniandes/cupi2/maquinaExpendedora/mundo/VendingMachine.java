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

import uniandes.cupi2.maquinaExpendedora.mundo.Producto.Tipo;

/**
 * Representa la m�quina expendedora.
 */
public class MaquinaExpendedora
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la m�quina expendedora.
     */
    private Producto producto1;

    /**
     * Producto 2 de la m�quina expendedora.
     */
    private Producto producto2;

    /**
     * Producto 3 de la m�quina expendedora.
     */
    private Producto producto3;

    /**
     * Producto 4 de la m�quina expendedora.
     */
    private Producto producto4;

    /**
     * Cr�dito disponible en la m�quina.
     */
    
    //TODO Parte 3 Punto A: Declarar la relaci�n credito seg�n el modelo del mundo.
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva m�quina expendedora. <br>
     * <b>post: </b> La cantidad en caja se inicializ� en 0.<br>
     * Los 4 productos se inicializaron con sus valores iniciales y se inicializ� el cr�dito. <br>
     */
    public MaquinaExpendedora( )
    {
        producto1 = new Producto( "A1", "Papas Natural Margarita", 1300 );
        producto2 = new Producto( "A2", "Jugo Hit", 2000 );
        producto3 = new Producto( "B1", "Chocolatina Jet", 450 );
        producto4 = new Producto( "B2", "Galletas Festival", 800 );
        // TODO Parte 3 Punto B: Hacer las modificaciones necesarias para que se incluyan los nuevos par�metros del constructor de la clase Producto. 
        //                       Completar el m�todo constructor de la clase seg�n la documentaci�n dada.
    } 

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el valor del cr�dito disponible en la m�quina.
     * @return Valor del cr�dito de la m�quina.
     */
        //TODO Parte 3 Punto C: Declarar y completar el m�todo darValorCredito seg�n la documentaci�n dada y el modelo conceptual.
    
    /**
     * Retorna el producto con el identificador recibido por par�metro. <br>
     * <b>pre: </b> Existe un producto con el identificador dado.
     * @param pIdentificador Identificador del producto buscado. pIdentificador != null && pIdentificador != "".
     * @return Producto con el identificador dado.
     */
    public Producto darProducto( String pIdentificador )
    {
        //TODO Parte 3 Punto D: Complete el m�todo seg�n la documentaci�n dada.
    }
    /**
     * Agrega una moneda al cr�dito de la m�quina.<br>
     * <b> post: </b> Se agreg� la moneda al cr�dito.
     * @param pMoneda Denominaci�n de la moneda. pMoneda = { Monto.MONEDA_50 , Monto.MONEDA_100 , Monto.MONEDA_200, Monto.MONEDA_500 , Monto.MONEDA_1000}.
     * @return True si pudo agregar la moneda, false si superaba el valor m�ximo.
     */
    public boolean agregarMoneda( int pMoneda )
    {
        // TODO Parte 3 Punto E: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Compra una unidad del producto con el identificador dado. <br>
     * <b> pre: </b> Existe un producto con el identificador dado. <br>
     * <b> post: </b>Si hay cr�dito y unidades suficientes se realiza la compra y se cambia el valor del cr�dito actual.<br>
     * @param pIdentificador identificador del producto. pIdentificador != null && pIdentificador != "".
     * @return Retorna true si se realiz� la compra, false si no hay cr�dito suficiente o no hab�an unidades disponible.
     */
    public boolean comprarProducto( String pIdentificador )
    {

        // TODO Parte 3 Punto F: Complete el m�todo seg�n la documentaci�n dada y las restricciones.
    }

    /**
     * Termina la compra y retorna el cambio.<br>
     * <b>post:<\b> Calcula el monto de dinero que se debe dar como cambio y reinicia el cr�dito.
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
     * Calcula la cantidad total de unidades compradas de la m�quina.
     * @return Cantidad total de unidades compradas de la m�quina.
     */
    public int darCantidadTotalUnidadesCompradas( )
    {
        int totalCompras = producto1.darCantidadUnidadesCompradas( ) + producto2.darCantidadUnidadesCompradas( ) + producto3.darCantidadUnidadesCompradas( ) + producto4.darCantidadUnidadesCompradas( );
        return totalCompras;
    }

    /**
     * Calcula el valor total de las compras de la m�quina.
     * @return Valor total de las compras de la m�quina.
     */
    public double darValorTotalCompras( )
    {
        double valor = producto1.darCantidadUnidadesCompradas( ) * producto1.darPrecio( ) + producto2.darCantidadUnidadesCompradas( ) * producto2.darPrecio( ) + producto3.darCantidadUnidadesCompradas( ) * producto3.darPrecio( )
                + producto4.darCantidadUnidadesCompradas( ) * producto4.darPrecio( );
        return valor;
    }

    /**
     * Calcula el porcentaje de disponibilidad de la m�quina.
     * @return Porcentaje de disponibilidad de la m�quina.
     */
    public double darPorcentajeDisponibilidad( )
    {
        // TODO Parte 3 Punto G: Complete el m�todo seg�n la documentaci�n dada y la definici�n de la funcionalidad.
    }

    /**
     * Retorna el valor total de la donaci�n al FOPRE de productos del tipo especificado.
     * @param pTipo Tipo de producto de inter�s. pTipo pertenece a {Tipo.BEBIDA , Tipo.COMIDA}.
     * @return Total de donaci�n al FOPRE del tipo de producto.
     */
    public double darDonacionPorTipo( Tipo pTipo )
    {
        // TODO Parte 3 Punto H: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna el total de unidades FOPRE compradas para un tipo espec�fico.
     * @param pTipo Tipo de producto de inter�s. pTipo pertenece a {Tipo.BEBIDA , Tipo.COMIDA}.
     * @return La suma de las unidades compradas de los productos FOPRE del tipo dado.
     */
    public int darCantidadUnidadesCompradasFopre( Tipo pTipo )
    {
        // TODO Parte 3 Punto I: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna el producto m�s comprado.
     * @return Producto m�s comprado. Si hay dos productos con la mayor cantidad de unidades compradas, se retorna el primero encontrado.
     */
    public Producto darProductoMasComprado( )
    {
        // TODO Parte 3 Punto J: Complete el m�todo seg�n la documentaci�n dada.
    }

    /**
     * Retorna el valor total de la donaci�n al FOPRE.
     * @return Donaci�n total al FOPRE.
     */
 // TODO Parte 3 Punto K: Declarar y completar el m�todo darDonacionTotal seg�n la documentaci�n dada y el modelo conceptual.

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Extensi�n 1.
     * @return Respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Extensi�n 2.
     * @return Respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}
