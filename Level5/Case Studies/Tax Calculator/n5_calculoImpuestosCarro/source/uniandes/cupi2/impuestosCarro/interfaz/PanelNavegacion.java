/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_calculoImpuestosCarro
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.impuestosCarro.interfaz;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

/**
 * Clase para navegaci�n entre los carros.
 */
@SuppressWarnings("serial")
public class PanelNavegacion extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ir al primer carro.
     */
    public final static String PRIMERO = "Primero";

    /**
     * Comando para ir al anterior carro.
     */
    public final static String ANTERIOR = "Anterior";

    /**
     * Comando para ir al siguiente carro.
     */
    public final static String SIGUIENTE = "Siguiente";

    /**
     * Comando para ir al �ltimo carro.
     */
    public final static String ULTIMO = "Ultimo";

    // -----------------------------------------------------------------
    // Attributes de la interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para ir al primer carro.
     */
    private JButton btnPrimero;

    /**
     * Bot�n para ir al anterior carro.
     */
    private JButton btnAnterior;

    /**
     * Bot�n para ir al siguiente carro.
     */
    private JButton btnSiguiente;

    /**
     * Bot�n para ir al �ltimo carro.
     */
    private JButton btnUltimo;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Ventana principal of the  programa.
     */
    private InterfazImpuestosCarro principal;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea el panel para la navegaci�n entre carros.
     * @param pPrincipal Instancia of the  ventana principal.
     */
    public PanelNavegacion( InterfazImpuestosCarro pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridLayout( 1, 4 ) );

        btnPrimero = new JButton( "<<" );
        btnPrimero.setActionCommand( PRIMERO );
        btnPrimero.addActionListener( this );
        add( btnPrimero );

        btnAnterior = new JButton( "<" );
        btnAnterior.setActionCommand( ANTERIOR );
        btnAnterior.addActionListener( this );
        add( btnAnterior );

        btnSiguiente = new JButton( ">" );
        btnSiguiente.setActionCommand( SIGUIENTE );
        btnSiguiente.addActionListener( this );
        add( btnSiguiente );

        btnUltimo = new JButton( ">>" );
        btnUltimo.setActionCommand( ULTIMO );
        btnUltimo.addActionListener( this );
        add( btnUltimo );

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Respuesta a los eventos en los elementos of the  interfaz.
     * @param pEvento Evento generado. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( PRIMERO ) )
        {
            principal.verPrimero( );
        }
        else if( comando.equals( ANTERIOR ) )
        {
            principal.verAnterior( );
        }
        else if( comando.equals( SIGUIENTE ) )
        {
            principal.verSiguiente( );
        }
        else
        {
            principal.verUltimo( );
        }

    }

}
