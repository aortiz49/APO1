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

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Clase que contiene las opciones.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener
{
    
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------


    /**
     * Comando de c�lculo of the  valor de los impuestos.
     */
    public final static String CALCULAR = "calcular";

    /**
     * Constante OPCION_1, usada para la opci�n de la extensi�n 1.
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Constante OPCION_2, usada para la opci�n de la extensi�n 2.
     */
    private final static String OPCION_2 = "OPCION_2";


    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Ventana principal of the  programa.
     */
    private InterfazImpuestosCarro principal;
    
    // -----------------------------------------------------------------
    // Attributes de la interfaz
    // -----------------------------------------------------------------
    /**
     * Bot�n para calcular el total of the  liquidaci�n.
     */
    private JButton btnCalcular;

    /**
     * Bot�n para hacer la extensi�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n para hacer la extensi�n 2.
     */
    private JButton btnOpcion2;
  
    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye el panel con todos sus componentes.
     * @param pPrincipal Clase principal of the  aplicaci�n. pPrincipal != null.
     */
    public PanelOpciones( InterfazImpuestosCarro pPrincipal )
    {
        // Guarda la referencia a la ventana principal
        principal = pPrincipal;
        
     // Establece el layout como una grilla de 1 fila y 3 columnas
        setLayout( new GridLayout( 1, 3 ) );
        
        // Adiciona un marco con t�tulo
        TitledBorder border = new TitledBorder( "Opciones" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
        
        btnCalcular = new JButton( "Calcular" );
        btnCalcular.setActionCommand( CALCULAR );
        btnCalcular.addActionListener( this );
        add(btnCalcular);

        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add(btnOpcion1);

        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add(btnOpcion2);

    }

    /**
     * Respuesta a los eventos en los elementos of the  interfaz.
     * @param pEvento Evento generado. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        
        if( comando.equals( CALCULAR ) )
        {
            principal.calcularImpuestos( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
        
    }

}
