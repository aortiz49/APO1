/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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

import uniandes.cupi2.campeonato.mundo.Campeonato;
import uniandes.cupi2.campeonato.mundo.Equipo;

/**
 * Es el panel donde se muestra la tabla de posiciones.
 */
@SuppressWarnings("serial")
public class PanelTablaPosiciones extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el área donde se escribe la tabla de posiciones.
     */
    private JLabel[][] lblsTabla;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Una referencia al objeto del modelo del mundo que representa el campeonato.
     */
    private Campeonato campeonato;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     */
    public PanelTablaPosiciones( )
    {
        setBorder( new TitledBorder( "Tabla de posiciones" ) );
        setLayout( new GridLayout( 6, 9 ) );
        setPreferredSize( new Dimension( 900, 450 ) );
        campeonato = null;
        lblsTabla = new JLabel[6][9];
        for( int i = 0; i < lblsTabla.length; i++ )
        {
            for( int j = 0; j < lblsTabla[ i ].length; j++ )
            {
                lblsTabla[ i ][ j ] = new JLabel( );
            }
        }

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Crea la tabla de posiciones mostrada.
     * @param pCampeonato El Campeonato que fue cargado con el archivo de properties.
     */
    public void crearTabla( Campeonato pCampeonato )
    {

        campeonato = pCampeonato;
        lblsTabla[ 0 ][ 0 ] = new JLabel( " " );
        lblsTabla[ 0 ][ 0 ].setHorizontalAlignment( JLabel.CENTER );
        add( lblsTabla[ 0 ][ 0 ] );

        lblsTabla[ 0 ][ 1 ] = new JLabel( "Equipo" );
        lblsTabla[ 0 ][ 1 ].setHorizontalAlignment( JLabel.CENTER );
        lblsTabla[ 0 ][ 1 ].setForeground( Color.BLUE );
        add( lblsTabla[ 0 ][ 1 ] );

        lblsTabla[ 0 ][ 2 ] = new JLabel( "Puntos" );
        lblsTabla[ 0 ][ 2 ].setHorizontalAlignment( JLabel.CENTER );
        lblsTabla[ 0 ][ 2 ].setForeground( Color.BLUE );
        add( lblsTabla[ 0 ][ 2 ] );

        lblsTabla[ 0 ][ 3 ] = new JLabel( "Jugados" );
        lblsTabla[ 0 ][ 3 ].setHorizontalAlignment( JLabel.CENTER );
        lblsTabla[ 0 ][ 3 ].setForeground( Color.BLUE );
        add( lblsTabla[ 0 ][ 3 ] );

        lblsTabla[ 0 ][ 4 ] = new JLabel( "Ganados" );
        lblsTabla[ 0 ][ 4 ].setHorizontalAlignment( JLabel.CENTER );
        lblsTabla[ 0 ][ 4 ].setForeground( Color.BLUE );
        add( lblsTabla[ 0 ][ 4 ] );

        lblsTabla[ 0 ][ 5 ] = new JLabel( "Empatados" );
        lblsTabla[ 0 ][ 5 ].setHorizontalAlignment( JLabel.CENTER );
        lblsTabla[ 0 ][ 5 ].setForeground( Color.BLUE );
        add( lblsTabla[ 0 ][ 5 ] );

        lblsTabla[ 0 ][ 6 ] = new JLabel( "Perdidos" );
        lblsTabla[ 0 ][ 6 ].setHorizontalAlignment( JLabel.CENTER );
        lblsTabla[ 0 ][ 6 ].setForeground( Color.BLUE );
        add( lblsTabla[ 0 ][ 6 ] );

        lblsTabla[ 0 ][ 7 ] = new JLabel( "Goles a favor" );
        lblsTabla[ 0 ][ 7 ].setHorizontalAlignment( JLabel.CENTER );
        lblsTabla[ 0 ][ 7 ].setForeground( Color.BLUE );
        add( lblsTabla[ 0 ][ 7 ] );

        lblsTabla[ 0 ][ 8 ] = new JLabel( "Goles en contra" );
        lblsTabla[ 0 ][ 8 ].setHorizontalAlignment( JLabel.CENTER );
        lblsTabla[ 0 ][ 8 ].setForeground( Color.BLUE );
        add( lblsTabla[ 0 ][ 8 ] );

        for( int i = 0; i < campeonato.darNumeroEquipos( ); i++ )
        {
            Equipo actual = campeonato.darEquipo( i );
            lblsTabla[ i ][ 0 ] = new JLabel( new ImageIcon( new ImageIcon( "./data/imagenes/" + actual.darRuta( ) ).getImage( ).getScaledInstance( 40, 40, Image.SCALE_DEFAULT ) ) );
            lblsTabla[ i ][ 0 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 0 ] );

            lblsTabla[ i ][ 1 ] = new JLabel( actual.darNombre( ) );
            lblsTabla[ i ][ 1 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 1 ] );

            lblsTabla[ i ][ 2 ] = new JLabel( campeonato.darTotalPuntos( i ) + "" );
            lblsTabla[ i ][ 2 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 2 ] );

            lblsTabla[ i ][ 3 ] = new JLabel( campeonato.darPartidosJugados( i ) + "" );
            lblsTabla[ i ][ 3 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 3 ] );

            lblsTabla[ i ][ 4 ] = new JLabel( campeonato.darPartidosGanados( i ) + "" );
            lblsTabla[ i ][ 4 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 4 ] );

            lblsTabla[ i ][ 5 ] = new JLabel( campeonato.darPartidosEmpatados( i ) + "" );
            lblsTabla[ i ][ 5 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 5 ] );

            lblsTabla[ i ][ 6 ] = new JLabel( campeonato.darPartidosPerdidos( i ) + "" );
            lblsTabla[ i ][ 6 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 6 ] );

            lblsTabla[ i ][ 7 ] = new JLabel( campeonato.darGolesAFavor( i ) + "" );
            lblsTabla[ i ][ 7 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 7 ] );

            lblsTabla[ i ][ 8 ] = new JLabel( campeonato.darGolesEnContra( i ) + "" );
            lblsTabla[ i ][ 8 ].setHorizontalAlignment( JLabel.CENTER );
            add( lblsTabla[ i ][ 8 ] );
        }
        validate( );
    }

    /**
     * Actualiza la tabla de posiciones mostrada.
     */
    public void refrescar( )
    {
        for( int i = 0; i < campeonato.darNumeroEquipos( ); i++ )
        {
            lblsTabla[ i ][ 2 ].setText( "" + campeonato.darTotalPuntos( i ) );
            lblsTabla[ i ][ 3 ].setText( campeonato.darPartidosJugados( i ) + "" );
            lblsTabla[ i ][ 4 ].setText( campeonato.darPartidosGanados( i ) + "" );
            lblsTabla[ i ][ 5 ].setText( campeonato.darPartidosEmpatados( i ) + "" );
            lblsTabla[ i ][ 6 ].setText( campeonato.darPartidosPerdidos( i ) + "" );
            lblsTabla[ i ][ 7 ].setText( campeonato.darGolesAFavor( i ) + "" );
            lblsTabla[ i ][ 8 ].setText( campeonato.darGolesEnContra( i ) + "" );
        }

    }

}