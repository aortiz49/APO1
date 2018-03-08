/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_empresaTransporte
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empresaTransporte.mundo;

/**
 * Empresa de transporte.
 */
public class EmpresaTransporte
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Camión 1 de la empresa.
     */
    private Camion camion1;

    /**
     * Camión 2 de la empresa.
     */
    private Camion camion2;

    /**
     * Camión 3 de la empresa.
     */
    private Camion camion3;

    /**
     * Camión 4 de la empresa.
     */
    private Camion camion4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva empresa de transporte con 4 camiones. <br>
     * <b>post: </b> Los camiones fueron creados con los siguientes valores: <br>
     * Camión 1: Matrícula: BAC213, Capacidad (en Kgs): 150, Consumo: 85. <br>
     * Camión 2: Matrícula: CAP384, Capacidad (en Kgs): 190, Consumo: 70. <br>
     * Camión 3: Matrícula: GER273, Capacidad (en Kgs): 280, Consumo: 100. <br>
     * Camión 4: Matrícula: JKV232, Capacidad (en Kgs): 215, Consumo: 110.
     */
    public EmpresaTransporte( )
    {
        camion1 = new Camion( "BAC213", 150, 85 );
        camion2 = new Camion( "CAP384", 190, 70 );
        camion3 = new Camion( "GER273", 280, 100 );
        camion4 = new Camion( "JKV232", 215, 110 );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el camión 1.
     * @return Camión 1.
     */
    public Camion darCamion1( )
    {
        return camion1;
    }

    /**
     * Retorna el camión 2.
     * @return Camión 2.
     */
    public Camion darCamion2( )
    {
        return camion2;
    }

    /**
     * Retorna el camión 3.
     * @return Camión 3.
     */
    public Camion darCamion3( )
    {
        return camion3;
    }

    /**
     * Retorna el camión 4.
     * @return Camión 4.
     */
    public Camion darCamion4( )
    {
        return camion4;
    }

    /**
     * Carga el camión con la matricula dada y carga dada por parámetro. <br>
     * <b>post: </b> El camión tiene la carga dada.
     * @param pMatricula Matrícula del camión. pMatricula != null && pMatricula != "".
     * @param pPesoCarga Peso de la carga para cargar el camión. pPesoCarga > 0.
     * @return Retorna true si pudo realizar la carga, false en caso contrario.
     */
    public boolean cargarCamion( String pMatricula, int pPesoCarga )
    {
        boolean cargo = false;
        if( camion1.darMatricula( ).equals( pMatricula ) )
        {
            cargo = camion1.cargar( pPesoCarga );
        }
        else if( camion2.darMatricula( ).equals( pMatricula ) )
        {
            cargo = camion2.cargar( pPesoCarga );
        }
        else if( camion3.darMatricula( ).equals( pMatricula ) )
        {
            cargo = camion3.cargar( pPesoCarga );
        }
        else if( camion4.darMatricula( ).equals( pMatricula ) )
        {
            cargo = camion4.cargar( pPesoCarga );
        }
        return cargo;
    }

    /**
     * Descarga el camión con la matrícula dada por parámetro. <br>
     * <b>post: </b> El camión no tiene carga.
     * @param pMatricula Matrícula del camión. pMatricula != null && pMatricula != "".
     */
    public void descargarCamion( String pMatricula )
    {
        if( camion1.darMatricula( ).equals( pMatricula ) )
        {
            camion1.descargar( );
        }
        else if( camion2.darMatricula( ).equals( pMatricula ) )
        {
            camion2.descargar( );
        }
        else if( camion3.darMatricula( ).equals( pMatricula ) )
        {
            camion3.descargar( );
        }
        else if( camion4.darMatricula( ).equals( pMatricula ) )
        {
            camion4.descargar( );
        }
    }

    /**
     * Retorna la capacidad total de carga de los camiones.
     * @return Capacidad total de carga de los camiones.
     */
    public int darCapacidadTotal( )
    {
        return camion1.darCapacidad( ) + camion2.darCapacidad( ) + camion3.darCapacidad( ) + camion4.darCapacidad( );
    }

    /**
     * Retorna la carga total de los camiones.
     * @return Carga total de los camiones.
     */
    public int darCargaTotal( )
    {
        return camion1.darCargaActual( ) + camion2.darCargaActual( ) + camion3.darCargaActual( ) + camion4.darCargaActual( );
    }

    /**
     * Retorna la carga promedio por camión.
     * @return Carga promedio por camión.
     */
    public double calcularCargaPromedio( )
    {
        double promedio = ( double ) ( darCargaTotal( ) / 4 );
        return promedio;
    }

    /**
     * Retorna el mejor camión para transportar la carga especificada. <br>
     * El mejor camión es aquel que tiene la capacidad para cargar la carga dada y además tiene un menor consumo de gasolina.
     * @param pPesoCarga Peso de la carga a transportar. pPesoCarga > 0.
     * @return Camión ideal para llevar la carga. Si ningún camión es apto para la carga retorna null.
     */
    public Camion darMejorCamion( int pPesoCarga )
    {
        Camion mejor = null;
        double mejorConsumo = -1;
        if( camion1.darCapacidad( ) >= pPesoCarga )
        {
            mejor = camion1;
            mejorConsumo = mejor.darConsumo( );
        }
        if( camion2.darCapacidad( ) >= pPesoCarga && camion2.darConsumo( ) < mejorConsumo)
        {
            mejor = camion2;
            mejorConsumo = mejor.darConsumo( );
        }
        if( camion3.darCapacidad( ) >= pPesoCarga && camion3.darConsumo( ) < mejorConsumo )
        {
            mejor = camion3;
            mejorConsumo = mejor.darConsumo( );
        }
        if( camion4.darCapacidad( ) >= pPesoCarga && camion4.darConsumo( ) < mejorConsumo )
        {
            mejor = camion4;
            mejorConsumo = mejor.darConsumo( );
        }
        return mejor;
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
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

}