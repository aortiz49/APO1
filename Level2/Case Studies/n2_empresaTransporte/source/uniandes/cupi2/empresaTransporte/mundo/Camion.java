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
 * Camión de la empresa de transporte.
 */
public class Camion
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Matricula del camión.
     */
    private String matricula;

    /**
     * Capacidad del camión (en Kg).
     */
    private int capacidad;

    /**
     * Consumo de gasolina del camión (en galones de gasolina/kilómetro).
     */
    private double consumo;

    /**
     * Carga actual del camión (en Kg).
     */
    private int cargaActual;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo camión con los . <br>
     * <b>post: </b> La matrícula, la capacidad y el consumo fueron inicializados con los valores dados por parámetro. <br>
     * La carga actual del camión fue inicializada en 0.
     * @param pMatricula Matricula del camión. pMatricula != null && pMatricula != "".
     * @param pCapacidad Capacidad (en Kg.) del camión. pCapacidad > 0.
     * @param pConsumo Consumo de gasolina (en gasolina/kilómetro). pConsumo > 0.
     */
    public Camion( String pMatricula, int pCapacidad, double pConsumo )
    {
        matricula = pMatricula;
        capacidad = pCapacidad;
        consumo = pConsumo;
        cargaActual = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la capacidad del camión.
     * @return Capacidad del camión.
     */
    public int darCapacidad( )
    {
        return capacidad;
    }

    /**
     * Retorna el consumo de gasolina del camión.
     * @return Consumo de gasolina del camión.
     */
    public double darConsumo( )
    {
        return consumo;
    }

    /**
     * Retorna la matricula del camión.
     * @return Matricula del camión.
     */
    public String darMatricula( )
    {
        return matricula;
    }

    /**
     * Retorna la carga actual del camión.
     * @return Carga actual del camión.
     */
    public int darCargaActual( )
    {
        return cargaActual;
    }

    /**
     * Carga el camión con la carga dada por parámetro. <br>
     * <b>post: </b> El camión fue cargado con el valor dado por parámetro.
     * @param pPesoCarga Peso a cargar (en Kg). pPesoCarga > 0.
     * @return Retorna true si logra cargar el camión, false de lo contrario.
     */
    public boolean cargar( int pPesoCarga )
    {
        boolean cargo = false;
        if( pPesoCarga <= capacidad )
        {
            cargo = true;
            cargaActual = pPesoCarga;
        }
        return cargo;
    }

    /**
     * Descarga el camión. <br>
     * <b>post: </b> La carga del camión es 0.
     */
    public void descargar( )
    {
        cargaActual = 0;
    }

}
