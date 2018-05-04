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
package uniandes.cupi2.campeonato.interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.campeonato.mundo.*;

/**
 * Este es el panel donde se muestra la tabla de goles del campeonato.
 */
@SuppressWarnings("serial")
public class PanelTablaGoles extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Una referencia al objeto del modelo del mundo que representa el campeonato.
     */
    private Campeonato campeonato;

    /**
     * N�mero de equipos que juega en el campeonato.
     */
    private int numeroEquipos;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Las etiquetas donde se escriben los resultados.
     */
    private JLabel[][] tablaEtiquetasGoles;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel sin ning�n campeonato.
     */
    public PanelTablaGoles( )
    {
        campeonato = null;
        numeroEquipos = 0;
        setBorder( new TitledBorder( "Tabla de goles" ) );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa la visualizaci�n de la tabla de goles del campeonato.
     * @param pCampeonato Objeto del modelo del mundo que representa el campeonato. pCampeonato != null.
     */
    public void iniciarTablaGoles( Campeonato pCampeonato )
    {
        campeonato = pCampeonato;
        numeroEquipos = campeonato.darNumeroEquipos( );
        setLayout( new GridLayout( numeroEquipos + 1, numeroEquipos + 1 ) );
        tablaEtiquetasGoles = new JLabel[numeroEquipos + 1][numeroEquipos + 1];

        // Crear las etiquetas de los marcadores
        for( int i = 0; i < numeroEquipos + 1; i++ )
        {
            for( int j = 0; j < numeroEquipos + 1; j++ )
            {
                if( i == 0 && j == 0 )
                {
                    tablaEtiquetasGoles[ 0 ][ 0 ] = new JLabel( "" );
                }
                else if( i == 0 )
                {
                    tablaEtiquetasGoles[ 0 ][ j ] = new JLabel( campeonato.darEquipo( j - 1 ).darNombre( ) + " " );
                    tablaEtiquetasGoles[ 0 ][ j ].setForeground( Color.BLUE );
                }
                else if( j == 0 )
                {
                    tablaEtiquetasGoles[ i ][ 0 ] = new JLabel( campeonato.darEquipo( i - 1 ).darNombre( ) + " " );
                    tablaEtiquetasGoles[ i ][ 0 ].setForeground( Color.BLUE );
                }
                else if( i == j )
                {
                    tablaEtiquetasGoles[ i ][ i ] = new JLabel( "X" );
                }
                else
                {
                    tablaEtiquetasGoles[ i ][ j ] = new JLabel( "-" );

                }
                tablaEtiquetasGoles[ i ][ j ].setHorizontalAlignment( JLabel.CENTER );
                add( tablaEtiquetasGoles[ i ][ j ] );
            }
        }
        validate( );
    }

    /**
     * Actualiza la informaci�n mostrada en la tabla de goles.
     */
    public void refrescar( )
    {
        if( campeonato != null )
        {
            // Desplegar los resultados de los partidos
            for( int i = 0; i < numeroEquipos; i++ )
            {
                for( int j = 0; j < numeroEquipos; j++ )
                {
                    int resultado = campeonato.darGolesMarcados( i, j );
                    if( i != j && resultado != Campeonato.SIN_JUGAR )
                    {
                        tablaEtiquetasGoles[ i + 1 ][ j + 1 ].setText( "" + resultado );
                    }
                }
            }
        }
    }
}