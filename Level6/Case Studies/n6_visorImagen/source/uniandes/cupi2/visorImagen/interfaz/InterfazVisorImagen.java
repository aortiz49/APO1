/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_visorImagen
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.visorImagen.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * Interfaz del visor de im�genes.
 */
@SuppressWarnings("serial")
public class InterfazVisorImagen extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Dimensi�n para la convoluci�n.
     */
    public static final int DIMENSION_CONVOLUCION = 3;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Panel del banner de la aplicaci�n.
     */
    private PanelBanner panelBanner;

    /**
     * Panel de la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel de los botones.
     */
    private PanelBotones panelBotones;

    /**
     * Panel de los botones.
     */
    private PanelCargarImagen panelCargarImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la interfaz para el visor de im�genes.
     */
    public InterfazVisorImagen( )
    {
        setTitle( "Visor de im�genes" );
        setSize( 731, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Establece el distribuidor gr�fico
        setLayout( new BorderLayout( ) );

        // Crea y adiciona el panel del banner
        panelBanner = new PanelBanner( );
        add( panelBanner, BorderLayout.NORTH );

        // Crea y adiciona el panel de la imagen
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.CENTER );

        JPanel panel = new JPanel( );
        panel.setLayout( new GridLayout( 2, 1 ) );

        // Crea y adiciona el panel de cargar la imagen

        panelCargarImagen = new PanelCargarImagen( this );
        panel.add( panelCargarImagen );

        // Crea y adiciona el panel de botones

        panelBotones = new PanelBotones( this );
        panel.add( panelBotones );

        add( panel, BorderLayout.SOUTH );

        setLocationRelativeTo( null );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escoge la imagen de la ruta que quieres cargar.
     */
    public void cargarImagen( )
    {
        JFileChooser fc = new JFileChooser( "./data" );
        int response = fc.showOpenDialog( this );
        if( response == JFileChooser.APPROVE_OPTION )
        {
            File file = fc.getSelectedFile( );
            panelImagen.actualizarImagen( file.getAbsolutePath( ) );
            panelCargarImagen.actualizarRuta( file.getAbsolutePath( ) );

        }
        else
        {
            JOptionPane.showMessageDialog( this, "No se ha elegido ninguna imagen" );
        }
    }

    /**
     * Da el color promedio de la imagen.
     * @return El color promedio.
     */
    public Color colorPromedio( )
    {
        return panelImagen.colorPromedio( );
    }

    /**
     * Convierte la imagen en su negativo.
     */
    public void convertirNegativo( )
    {
        panelImagen.convertirNegativo( );
    }

    /**
     * Refleja la imagen.
     */
    public void reflejarImagen( )
    {
        panelImagen.reflejarImagen( );
    }

    /**
     * Presenta el di�logo de definici�n del umbral de binarizaci�n.
     */
    public void presentarDialogoUmbral( )
    {
        DialogoUmbralBinarizacion dialogoUmbral = new DialogoUmbralBinarizacion( this );
        dialogoUmbral.setVisible( true );
    }

    /**
     * Binariza la imagen.
     * @param pUmbral Umbral de binarizaci�n.
     */
    public void binarizarImagen( double pUmbral )
    {
        panelImagen.binarizarImagen( pUmbral );
    }

    /**
     * Pixela la imagen.
     */
    public void pixelarImagen( )
    {
        panelImagen.pixelarImagen( );
    }

    /**
     * Convierte a tonos de gris la imagen.
     */
    public void convertirAGrises( )
    {
        panelImagen.convertirAGrises( );
    }

    /**
     * Presenta el di�logo de definici�n de la matriz de convoluci�n.
     */
    public void presentarDialogoMatrizConvolucion( )
    {
        DialogoMatrizConvolucion dialogoMatriz = new DialogoMatrizConvolucion( this );
        dialogoMatriz.setVisible( true );
    }

    /**
     * Aplica el operador de convoluci�n representado en la matriz.
     * @param pConv Matriz de convoluci�n.
     */
    public void aplicarOperadorConvolucion( double pConv[][] )
    {
        panelImagen.aplicarOperadorConvolucion( pConv );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        panelImagen.extension1( );
    }

    /**
     * Extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        panelImagen.extension2( );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazVisorImagen i = new InterfazVisorImagen( );
            i.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
