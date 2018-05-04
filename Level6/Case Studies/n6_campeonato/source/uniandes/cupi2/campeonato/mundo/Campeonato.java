/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_campeonato
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.campeonato.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Esta clase representa un campeonato de f�tbol.
 */
public class Campeonato
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indica que el partido no se ha jugado.
     */
    public static final int SIN_JUGAR = -1;

    /**
     * Indica que el partido no se puede jugar porque ser�a un equipo jugando contra �l mismo.
     */
    public static final int INVALIDO = -2;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * N�mero de equipos en el campeonato.
     */
    private int maxEquipos;

    /**
     * Es la tabla con los goles. En la posici�n (i,j) aparece el n�mero de goles que el equipo i le hizo al equipo j.
     */
    private int[][] tablaGoles;

    /**
     * Es un arreglo con los equipos en el campeonato. En la posici�n i aparece la descripci�n del equipo i.
     */
    private Equipo[] equipos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo campeonato de f�tbol.
     * @param pArchivo Es el archivo que contiene la descripci�n de los equipos del campeonato. pArchivo != null.
     * @throws Exception Se lanza esta excepci�n si hay problemas cargando el archivo.
     */
    public Campeonato( File pArchivo ) throws Exception
    {
        Properties datos = cargarInfoCampeonato( pArchivo );
        inicializarEquipos( datos );
        inicializarTablaGoles( );
    }

    /**
     * Carga la informaci�n de los equipos del campeonato en un objeto de tipo Properties.
     * @param pArchivo Es el archivo que contiene la descripci�n de los equipos del campeonato.
     * @return Un objeto de la clase Properties con la informaci�n del archivo.
     * @throws Exception Se lanza esta excepci�n si el archivo no existe o si el formato del archivo no es v�lido y no puede ser le�do.
     */
    private Properties cargarInfoCampeonato( File pArchivo ) throws Exception
    {
        Properties datos = new Properties( );
        FileInputStream in = new FileInputStream( pArchivo );
        try
        {
            datos.load( in );
            in.close( );
        }
        catch( Exception e )
        {
            throw new Exception( "Formato inv�lido" );
        }
        return datos;
    }

    /**
     * Inicializa el arreglo de equipos con la informaci�n que recibe en el par�metro de entrada. <br>
     * <b>post: </b> El arreglo de equipos fue inicializado con los nombres de los equipos que ven�an en el par�metro de entrada.
     * @param pDatos Contiene la informaci�n cargada del archivo para inicializar el campeonato. Esta informaci�n es completa y v�lida.
     */
    private void inicializarEquipos( Properties pDatos )
    {
        String strNumeroEquipos = pDatos.getProperty( "campeonato.equipos" );
        maxEquipos = Integer.parseInt( strNumeroEquipos );
        // Crea el arreglo de equipos, reservando el espacio definido en la propiedad "campeonato.equipos"
        equipos = new Equipo[maxEquipos];
        // Lee el nombre de cada equipo de la respectiva propiedad y crea el objeto que lo representa
        for( int i = 0; i < maxEquipos; i++ )
        {
            String nombreEquipo = pDatos.getProperty( "campeonato.nombre" + i );
            String ruta = pDatos.getProperty( "campeonato.ruta" + i );
            equipos[ i ] = new Equipo( nombreEquipo, ruta );
        }
    }

    /**
     * Crea la matriz que contiene la tabla de goles. Es una matriz cuadrada de maxEquipos filas y maxEquipos columnas.
     */
    private void inicializarTablaGoles( )
    {
        // Crea la matriz que contiene la tabla de goles
        tablaGoles = new int[maxEquipos][maxEquipos];
        // Inicializa todos los marcadores, dejando en la diagonal una marca especial
        for( int i = 0; i < maxEquipos; i++ )
        {
            for( int j = 0; j < maxEquipos; j++ )
            {
                if( i != j )
                {
                    tablaGoles[ i ][ j ] = SIN_JUGAR;
                }
                else
                {
                    tablaGoles[ i ][ j ] = INVALIDO;
                }
            }
        }
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de goles marcados por el equipo eq1 al equipo eq2.
     * @param pEquipo1 Es el n�mero del equipo 1. eq1 es un n�mero de equipo v�lido.
     * @param pEquipo2 Es el n�mero del equipo 2. eq2 es un n�mero de equipo v�lido.
     * @return N�mero de goles marcados.
     */
    public int darGolesMarcados( int pEquipo1, int pEquipo2 )
    {
        return tablaGoles[ pEquipo1 ][ pEquipo2 ];
    }

    /**
     * Retorna el n�mero de equipos del campeonato.
     * @return N�mero de equipos del campeonato.
     */
    public int darNumeroEquipos( )
    {
        return maxEquipos;
    }

    /**
     * Retorna el equipo cuyo n�mero se pasa como par�metro.
     * @param pEquipo N�mero del equipo. pEquipo es un n�mero de equipo v�lido.
     * @return El equipo cuyo n�mero se pasa como par�metro.
     */
    public Equipo darEquipo( int pEquipo )
    {
        return equipos[ pEquipo ];
    }

    /**
     * Registra el resultado de un partido. <br>
     * <b>pre: </b> Los equipos que participan en el campeonato ya fueron inicializados. <br>
     * <b>post: </b> Se actualiz� la tabla de goles con el resultado indicado.
     * @param pEquipo1 Es el n�mero del equipo 1.
     * @param pEquipo2 Es el n�mero del equipo 2.
     * @param pGol1 Es el n�mero de goles marcados por el equipo eq1.
     * @param pGol2 Es el n�mero de goles marcados por el equipo eq2.
     * @throws Exception Se lanza esta excepci�n si los equipos no son v�lidos, si el n�mero de goles es inv�lido o si el partido ya se ha jugado.
     */
    public void registrarResultado( int pEquipo1, int pEquipo2, int pGol1, int pGol2 ) throws Exception
    {
        if( pEquipo1 < 0 || pEquipo1 >= maxEquipos || pEquipo2 < 0 || pEquipo2 >= maxEquipos )
        {
            throw new Exception( "Equipos incorrectos" );
        }
        if( pEquipo1 == pEquipo2 )
        {
            throw new Exception( "Son el mismo equipo" );
        }
        if( pGol1 < 0 || pGol2 < 0 )
        {
            throw new Exception( "N�mero de goles inv�lido" );
        }
        if( tablaGoles[ pEquipo1 ][ pEquipo2 ] != SIN_JUGAR || tablaGoles[ pEquipo2 ][ pEquipo1 ] != SIN_JUGAR )
        {
            throw new Exception( "Partido ya jugado" );
        }
        tablaGoles[ pEquipo1 ][ pEquipo2 ] = pGol1;
        tablaGoles[ pEquipo2 ][ pEquipo1 ] = pGol2;
    }

    /**
     * Retorna el n�mero total de partidos ganados por un equipo.
     * @param pEquipo N�mero del equipo. Equipo es un n�mero v�lido.
     * @return N�mero de partidos ganados.
     */
    public int darPartidosGanados( int pEquipo )
    {
        int ganados = 0;
        for( int i = 0; i < maxEquipos; i++ )
        {
            if( tablaGoles[ pEquipo ][ i ] != SIN_JUGAR && tablaGoles[ pEquipo ][ i ] != INVALIDO && tablaGoles[ pEquipo ][ i ] > tablaGoles[ i ][ pEquipo ] )
            {
                ganados++;
            }
        }
        return ganados;
    }

    /**
     * Retorna el n�mero total de partidos perdidos por un equipo.
     * @param pEquipo N�mero del equipo. Equipo es un n�mero v�lido.
     * @return N�mero de partidos perdidos.
     */
    public int darPartidosPerdidos( int pEquipo )
    {
        int perdidos = 0;
        for( int i = 0; i < maxEquipos; i++ )
        {
            if( tablaGoles[ pEquipo ][ i ] != SIN_JUGAR && tablaGoles[ pEquipo ][ i ] != INVALIDO && tablaGoles[ pEquipo ][ i ] < tablaGoles[ i ][ pEquipo ] )
            {
                perdidos++;
            }
        }
        return perdidos;
    }

    /**
     * Retorna el n�mero total de partidos empatados por un equipo.
     * @param pEquipo N�mero del equipo. Equipo es un n�mero v�lido.
     * @return N�mero de partidos empatados.
     */
    public int darPartidosEmpatados( int pEquipo )
    {
        int empatados = 0;
        for( int i = 0; i < maxEquipos; i++ )
        {
            if( tablaGoles[ pEquipo ][ i ] != SIN_JUGAR && tablaGoles[ pEquipo ][ i ] != INVALIDO && tablaGoles[ pEquipo ][ i ] == tablaGoles[ i ][ pEquipo ] )
            {
                empatados++;
            }
        }
        return empatados;
    }

    /**
     * Retorna el n�mero total de partidos jugados por un equipo.
     * @param pEquipo N�mero del equipo. Equipo es un n�mero v�lido.
     * @return N�mero de partidos jugados.
     */
    public int darPartidosJugados( int pEquipo )
    {
        int jugados = 0;
        for( int i = 0; i < maxEquipos; i++ )
        {
            if( tablaGoles[ pEquipo ][ i ] != SIN_JUGAR && tablaGoles[ pEquipo ][ i ] != INVALIDO )
            {
                jugados++;
            }
        }
        return jugados;
    }

    /**
     * Retorna el n�mero de goles en contra del equipo.
     * @param pEquipo N�mero del equipo. Equipo es un n�mero v�lido.
     * @return N�mero de goles en contra.
     */
    public int darGolesEnContra( int pEquipo )
    {
        int golesEnContra = 0;
        for( int i = 0; i < maxEquipos; i++ )
        {
            if( tablaGoles[ pEquipo ][ i ] != SIN_JUGAR && tablaGoles[ pEquipo ][ i ] != INVALIDO )
            {
                golesEnContra += tablaGoles[ i ][ pEquipo ];
            }
        }
        return golesEnContra;
    }

    /**
     * Retorna el n�mero de goles a favor del equipo.
     * @param pEquipo N�mero del equipo. Equipo es un n�mero v�lido.
     * @return N�mero de goles a favor.
     */
    public int darGolesAFavor( int pEquipo )
    {
        int golesAFavor = 0;
        for( int i = 0; i < maxEquipos; i++ )
        {
            if( tablaGoles[ pEquipo ][ i ] != SIN_JUGAR && tablaGoles[ pEquipo ][ i ] != INVALIDO )
            {
                golesAFavor += tablaGoles[ pEquipo ][ i ];
            }
        }
        return golesAFavor;
    }

    /**
     * Retorna el n�mero total de puntos que tiene un equipo.
     * @param pEquipo N�mero del equipo. Equipo es un n�mero v�lido.
     * @return N�mero total de puntos en el campeonato que tiene el equipo.
     */
    public int darTotalPuntos( int pEquipo )
    {
        return 3 * darPartidosGanados( pEquipo ) + darPartidosEmpatados( pEquipo );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Es el punto de extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Es el punto de extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}