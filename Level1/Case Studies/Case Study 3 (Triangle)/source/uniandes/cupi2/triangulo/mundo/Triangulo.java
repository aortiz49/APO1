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
 * Clase que representa un triángulo.
 */
public class Triangulo
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primer punto del triángulo.
     */
    private Punto punto1;

    /**
     * Segundo punto del triángulo.
     */
    private Punto punto2;

    /**
     * Tercer punto del triángulo.
     */
    private Punto punto3;

    /**
     * Color de las líneas.
     */
    private Color colorLineas;

    /**
     * Color del relleno.
     */
    private Color colorRelleno;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el triángulo. <br>
     * <b>post: </b> Se inicializaron los atributos con los siguientes valores: <br>
     * Punto 1: 200, 50 <br>
     * Punto 2: 300, 200 <br>
     * Punto 3: 100, 200 <br>
     * Color relleno: 50, 168, 56 <br>
     * Color líneas: 0, 83, 24
     */
    public Triangulo( )
    {
        // Inicializa los puntos

        punto1 = new Punto( 200, 50 );
        punto2 = new Punto( 300, 200 );
        punto3 = new Punto( 100, 200 );

        // Inicializa los colores
        colorRelleno = new Color( 60, 168, 56 );
        colorLineas = new Color( 0, 83, 24 );
    }

    /**
     * Retorna el punto 1 del triángulo.
     * @return Punto 1.
     */
    public Punto darPunto1( )
    {
        return punto1;
    }

    /**
     * Retorna el punto 2 del triángulo.
     * @return Punto 2.
     */
    public Punto darPunto2( )
    {
        return punto2;
    }

    /**
     * Retorna el punto 3 del triángulo.
     * @return Punto 3.
     */
    public Punto darPunto3( )
    {
        return punto3;
    }

    /**
     * Retorna el color de las líneas del triángulo.
     * @return Color de las líneas.
     */
    public Color darColorLineas( )
    {
        return colorLineas;
    }

    /**
     * Retorna el color del relleno del triángulo.
     * @return Color del relleno.
     */
    public Color darColorRelleno( )
    {
        return colorRelleno;
    }

    /**
     * Retorna el perímetro del triángulo.
     * @return Perímetro del triángulo.
     */
    public double darPerimetro( )
    {
        // Retorna la suma de todos los lados
        return calcularLado1( ) + calcularLado2( ) + calcularLado3( );
    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br>
     * @return Área del triángulo.
     */
    public double darArea( )
    {
        // Calcula el valor S para la formula
        double perimetro = darPerimetro( );
        double s = perimetro / 2;

        // Calcula las restas para cada uno de los lados
        double valorLado1 = s - calcularLado1( );
        double valorLado2 = s - calcularLado2( );
        double valorLado3 = s - calcularLado3( );

        // Calcula y devuelve el área
        double area = Math.sqrt( s * valorLado1 * valorLado2 * valorLado3 );
        return area;
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     * @return Altura del triángulo.
     */
    public double darAltura( )
    {
        double area = darArea( );
        double base = calcularLado1( );
        double altura = ( area / base ) * 2;
        return altura;
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     * @return Distancia entre el punto 1 y el punto 2.
     */
    private double calcularLado1( )
    {
        // Calcula las restas
        double valorX = Math.pow( punto1.darX( ) - punto2.darX( ), 2 );
        double valorY = Math.pow( punto1.darY( ) - punto2.darY( ), 2 );

        // calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     * @return Distancia entre el punto 2 y 3.
     */
    private double calcularLado2( )
    {
        // Calcula las restas
        double valorX = Math.pow( punto2.darX( ) - punto3.darX( ), 2 );
        double valorY = Math.pow( punto2.darY( ) - punto3.darY( ), 2 );

        // calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     * @return Distancia entre el punto 3 y 1.
     */
    private double calcularLado3( )
    {
        // Calcula las restas
        double valorX = Math.pow( punto3.darX( ) - punto1.darX( ), 2 );
        double valorY = Math.pow( punto3.darY( ) - punto1.darY( ), 2 );

        // calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     * @param pX1 Coordenada X del vértice de referencia.
     * @param pY1 Coordenada Y del vértice de referencia.
     * @param pX2 Coordenada X del vértice opuesto 1.
     * @param pY2 Coordenada Y del vértice opuesto 1.
     * @param pX3 Coordenada X del vértice opuesto 2.
     * @param pY3 Coordenada Y del vértice opuesto 2.
     * @return Ángulo opuesto entre vértice de referencia y los otros dos vértices.
     */
    public double calcularAnguloOpuesto( double pX1, double pY1, double pX2, double pY2, double pX3, double pY3 )
    {
        // Ángulo 1
        double angulo1 = Math.atan2( pY2 - pY1, pX2 - pX1 );

        // Ángulo 2
        double angulo2 = Math.atan2( pY3 - pY1, pX3 - pX1 );

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if( Math.abs( angulo1 - angulo2 ) > Math.PI )
        {
            angulo1 = angulo1 < 0 ? angulo1 + 2.d * Math.PI : angulo1;
            angulo2 = angulo2 < 0 ? angulo2 + 2.d * Math.PI : angulo2;
        }

        // Calcula el ángulo opuesto
        double anguloOpuesto = ( angulo1 + angulo2 ) / 2.d + Math.PI;
        anguloOpuesto = anguloOpuesto % ( 2.d * Math.PI );
        return anguloOpuesto;
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    public void cambiarPunto1( double pX, double pY )
    {
        punto1.cambiarX( pX );
        punto1.cambiarY( pY );
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    public void cambiarPunto2( double pX, double pY )
    {
        punto2.cambiarX( pX );
        punto2.cambiarY( pY );
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    public void cambiarPunto3( double pX, double pY )
    {
        punto3.cambiarX( pX );
        punto3.cambiarY( pY );
    }

    /**
     * Cambia el color de relleno del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    public void cambiarColorRelleno( int pRojo, int pVerde, int pAzul )
    {
        colorRelleno.cambiarRojo( pRojo );
        colorRelleno.cambiarVerde( pVerde );
        colorRelleno.cambiarAzul( pAzul );
    }

    /**
     * Cambia el color de la líneas del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    public void cambiarColorLineas( int pRojo, int pVerde, int pAzul )
    {
        colorLineas.cambiarRojo( pRojo );
        colorLineas.cambiarVerde( pVerde );
        colorLineas.cambiarAzul( pAzul );
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
