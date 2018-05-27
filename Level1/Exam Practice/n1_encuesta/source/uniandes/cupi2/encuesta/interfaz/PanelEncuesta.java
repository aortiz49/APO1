/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_encuesta
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.encuesta.interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import uniandes.cupi2.encuesta.mundo.Encuesta;

/**
 * Panel para agregar una opinión.
 */
@SuppressWarnings("serial")
public class PanelEncuesta extends JPanel implements ActionListener
{

    // -----------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------

    /**
     * Constante para activar la vista de iniciar la encuesta.
     */
    private static final String REALIZAR_ENCUESTA = "INICIAR ENCUESTA";

    /**
     * Constante para activar la vista de rango de edad.
     */
    private static final String RANGO_EDAD = "RANGO EDAD";

    /**
     * Constante para activar la vista de estado civil.
     */
    private static final String ESTADO_CIVIL = "ESTADO CIVIL";

    /**
     * Constante para activar la vista de opinión.
     */
    private static final String OPINION = "OPINION";

    /**
     * Constante para agregar una opinion a la encuesta.
     */
    private static final String AGREGAR_OPINION = "AGREGAR_OPINION";

    /**
     * Constante para agregar una opinion a la encuesta.
     */
    private static final String VER_RESULTADOS = "VER_RESULTADOS";

    /**
     * Constante para consultar un resultado parcial de la encuesta.
     */
    private static final String CONSULTAR = "CONSULTAR";

    // -----------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazEncuesta principal;

    // -----------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------

    /**
     * Etiqueta de pregunta.
     */
    private JLabel etiquetaPregunta;

    /**
     * Etiqueta para el rango.
     */
    private JLabel etiquetaRango;

    /**
     * Etiqueta opinión.
     */
    private JLabel etiquetaOpinion;

    /**
     * Etiqueta estado civil.
     */
    private JLabel etiquetaEstadoCivil;

    /**
     * Etiqueta número de opiniones.
     */
    private JLabel etiquetaNumeroOpiniones;

    /**
     * Etiqueta Promedio de encuesta.
     */
    private JLabel etiquetaPromedioEncuesta;

    /**
     * Etiqueta filtro rango.
     */
    private JLabel etiquetaFiltroRango;

    /**
     * Etiqueta resultado consulta.
     */
    private JLabel etiquetaConsulta;

    /**
     * Etiqueta filtro estado civil.
     */
    private JLabel etiquetaFiltroEstadoCivil;

    /**
     * Caja de texto número de opiniones.
     */
    private JTextField txtNumeroOpiniones;

    /**
     * Caja de texto Promedio de encuesta.
     */
    private JTextField txtPromedioEncuesta;

    /**
     * Caja de texto resultado consulta.
     */
    private JTextField txtConsulta;

    /**
     * Botón realizar encuesta.
     */
    private JButton botonRealizarEncuesta;

    /**
     * Botón pasar a rango de edad.
     */
    private JButton botonSiguienteRangoEdad;

    /**
     * Botón volver a estado civil.
     */
    private JButton botonAnteriorEstadoCivil;

    /**
     * Botón pasar a estado civil.
     */
    private JButton botonSiguienteEstadoCivil;

    /**
     * Botón volver a opinión.
     */
    private JButton botonAnteriorOpinion;

    /**
     * Botón agregar opinión.
     */
    private JButton botonAgregarOpinion;

    /**
     * Botón consultar.
     */
    private JButton botonConsultar;

    /**
     * Botón nueva encuesta.
     */
    private JButton botonNuevaEncuesta;

    /**
     * Combo para los valores rango de la encuesta.
     */
    private JComboBox comboRango;

    /**
     * Combo para los valores de la opinión.
     */
    private JComboBox comboOpinion;

    /**
     * Combo para los valores del estado civil.
     */
    private JComboBox comboEstadoCivil;

    /**
     * Combo con los valores de filtro de los rangos.
     */
    private JComboBox comboFiltroRango;

    /**
     * Combo con los valores de filtro del estado civil.
     */
    private JComboBox comboFiltroEstadoCivil;

    /**
     * Panel con las preguntas de la encuesta.
     */
    private JPanel panelPreguntas;

    /**
     * Dataset las encuestas para casados.
     */
    private DefaultCategoryDataset datosCasados;

    /**
     * Dataset las encuestas para solteros.
     */
    private DefaultCategoryDataset datosSolteros;

    // -----------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se inicializó el panel.
     * @param pPrincipal Ventana principal. pPrincipal != null.
     */
    public PanelEncuesta( InterfazEncuesta pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        TitledBorder titulo = BorderFactory.createTitledBorder( "Agregar opinión a encuesta" );
        setBorder( titulo );

        // Panel bienvenida.
        etiquetaPregunta = new JLabel( "Bienvenido(a) a nuestra encuesta!" );
        etiquetaPregunta.setFont( new Font( "Time New Roman", Font.BOLD, 24 ) );
        JPanel panelCabecera = new JPanel( );
        panelCabecera.setBackground( new Color( 198, 226, 255 ) );
        panelCabecera.add( etiquetaPregunta );
        Border borde = BorderFactory.createEtchedBorder( );
        panelCabecera.setBorder( borde );

        panelPreguntas = new JPanel( new CardLayout( ) );
        JPanel panelInternoIniciarEncuesta = new JPanel( );
        botonRealizarEncuesta = new JButton( "Realizar encuesta" );
        botonRealizarEncuesta.addActionListener( this );
        botonRealizarEncuesta.setActionCommand( RANGO_EDAD );
        panelInternoIniciarEncuesta.setLayout( new GridLayout( 1, 1 ) );
        panelInternoIniciarEncuesta.add( botonRealizarEncuesta );

        // Panel pregunta 1.
        JPanel panelInternoRangoEdad = new JPanel( );
        JPanel panelBotonesRangoEdad = new JPanel( );
        JPanel panelPreguntaRangoEdad = new JPanel( );
        ImageIcon iconoRangoEdad = new ImageIcon( "data/RangoEdad.png" );
        JLabel imagenRangoEdad = new JLabel( );
        imagenRangoEdad = new JLabel( "" );
        imagenRangoEdad.setIcon( iconoRangoEdad );

        etiquetaRango = new JLabel( "Por favor, seleccione su rango de edad: " );
        comboRango = new JComboBox( principal.darRangoEdades( ) );
        comboRango.addActionListener( this );
        comboRango.setPreferredSize( new Dimension( 150, 0 ) );
        botonSiguienteRangoEdad = new JButton( ">>" );
        botonSiguienteRangoEdad.addActionListener( this );
        botonSiguienteRangoEdad.setActionCommand( ESTADO_CIVIL );
        botonSiguienteRangoEdad.setPreferredSize( new Dimension( 80, 30 ) );

        panelInternoRangoEdad.setLayout( new BorderLayout( ) );
        panelBotonesRangoEdad.setLayout( new BorderLayout( ) );
        panelPreguntaRangoEdad.setLayout( new BorderLayout( ) );
        panelPreguntaRangoEdad.setBorder( new EmptyBorder( 0, 82, 0, 10 ) );

        panelInternoRangoEdad.add( panelBotonesRangoEdad, BorderLayout.NORTH );
        panelInternoRangoEdad.add( imagenRangoEdad, BorderLayout.CENTER );
        panelBotonesRangoEdad.add( new JLabel( " " ), BorderLayout.WEST );
        panelBotonesRangoEdad.add( botonSiguienteRangoEdad, BorderLayout.EAST );
        panelBotonesRangoEdad.add( panelPreguntaRangoEdad, BorderLayout.CENTER );
        panelPreguntaRangoEdad.add( etiquetaRango, BorderLayout.CENTER );
        panelPreguntaRangoEdad.add( comboRango, BorderLayout.EAST );

        // Panel pregunta 2
        JPanel panelInternoEstadoCivil = new JPanel( );
        JPanel panelBotonesEstadoCivil = new JPanel( );
        JPanel panelPreguntaEstadoCivil = new JPanel( );
        ImageIcon iconoEstadoCivil = new ImageIcon( "data/EstadoCivil.png" );
        JLabel imagenEstadoCivil = new JLabel( );
        imagenEstadoCivil = new JLabel( "" );
        imagenEstadoCivil.setIcon( iconoEstadoCivil );
        etiquetaEstadoCivil = new JLabel( "Su estado civil es: " );
        String[] listaEstados = { "Casado(a)", "Soltero(a)" };
        comboEstadoCivil = new JComboBox( listaEstados );
        comboEstadoCivil.addActionListener( this );
        comboEstadoCivil.setPreferredSize( new Dimension( 150, 0 ) );
        botonAnteriorEstadoCivil = new JButton( "<<" );
        botonAnteriorEstadoCivil.addActionListener( this );
        botonAnteriorEstadoCivil.setActionCommand( RANGO_EDAD );
        botonAnteriorEstadoCivil.setPreferredSize( new Dimension( 80, 30 ) );
        botonSiguienteEstadoCivil = new JButton( ">>" );
        botonSiguienteEstadoCivil.addActionListener( this );
        botonSiguienteEstadoCivil.setActionCommand( OPINION );
        botonSiguienteEstadoCivil.setPreferredSize( new Dimension( 80, 30 ) );

        panelInternoEstadoCivil.setLayout( new BorderLayout( ) );
        panelBotonesEstadoCivil.setLayout( new BorderLayout( ) );
        panelPreguntaEstadoCivil.setLayout( new BorderLayout( ) );
        panelPreguntaEstadoCivil.setBorder( new EmptyBorder( 0, 10, 0, 10 ) );

        panelInternoEstadoCivil.add( panelBotonesEstadoCivil, BorderLayout.NORTH );
        panelInternoEstadoCivil.add( imagenEstadoCivil, BorderLayout.CENTER );
        panelBotonesEstadoCivil.add( botonAnteriorEstadoCivil, BorderLayout.WEST );
        panelBotonesEstadoCivil.add( botonSiguienteEstadoCivil, BorderLayout.EAST );
        panelBotonesEstadoCivil.add( panelPreguntaEstadoCivil, BorderLayout.CENTER );
        panelPreguntaEstadoCivil.add( etiquetaEstadoCivil, BorderLayout.CENTER );
        panelPreguntaEstadoCivil.add( comboEstadoCivil, BorderLayout.EAST );

        // Panel pregunta 3
        JPanel panelInternoOpinion = new JPanel( );
        JPanel panelBotonesOpinion = new JPanel( );
        JPanel panelPreguntaOpinion = new JPanel( );
        ImageIcon iconoOpinion = new ImageIcon( "data/Calificacion.png" );
        JLabel imagenOpinion = new JLabel( );
        imagenOpinion = new JLabel( "" );
        imagenOpinion.setIcon( iconoOpinion );
        etiquetaOpinion = new JLabel( "Califique de 0 a 10 el curso: " );
        String[] listaOpiniones = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        comboOpinion = new JComboBox( listaOpiniones );
        comboOpinion.addActionListener( this );
        comboOpinion.setPreferredSize( new Dimension( 150, 0 ) );
        botonAnteriorOpinion = new JButton( "<<" );
        botonAnteriorOpinion.addActionListener( this );
        botonAnteriorOpinion.setActionCommand( ESTADO_CIVIL );
        botonAnteriorOpinion.setPreferredSize( new Dimension( 80, 30 ) );
        botonAgregarOpinion = new JButton( "Enviar" );
        botonAgregarOpinion.addActionListener( this );
        botonAgregarOpinion.setActionCommand( AGREGAR_OPINION );
        botonAgregarOpinion.setPreferredSize( new Dimension( 80, 30 ) );

        panelInternoOpinion.setLayout( new BorderLayout( ) );
        panelBotonesOpinion.setLayout( new BorderLayout( ) );
        panelPreguntaOpinion.setLayout( new BorderLayout( ) );
        panelPreguntaOpinion.setBorder( new EmptyBorder( 0, 10, 0, 10 ) );

        panelInternoOpinion.add( panelBotonesOpinion, BorderLayout.NORTH );
        panelInternoOpinion.add( imagenOpinion, BorderLayout.CENTER );
        panelBotonesOpinion.add( botonAnteriorOpinion, BorderLayout.WEST );
        panelBotonesOpinion.add( botonAgregarOpinion, BorderLayout.EAST );
        panelBotonesOpinion.add( panelPreguntaOpinion, BorderLayout.CENTER );
        panelPreguntaOpinion.add( etiquetaOpinion, BorderLayout.CENTER );
        panelPreguntaOpinion.add( comboOpinion, BorderLayout.EAST );

        // Panel Resultados.
        JPanel panelInternoResultados = new JPanel( );
        JPanel panelConsulta = new JPanel( );
        panelInternoResultados.setLayout( new BorderLayout( ) );
        panelConsulta.setLayout( new GridLayout( 2, 1 ) );
        panelConsulta.setBorder( new CompoundBorder( new EmptyBorder( 3, 5, 3, 5 ), new TitledBorder( "Consulta por sector demográfico" ) ) );

        etiquetaConsulta = new JLabel( "" );
        etiquetaConsulta.setFont( new Font( "Tahoma", Font.BOLD, 14 ) );
        etiquetaNumeroOpiniones = new JLabel( "Número total de opiniones:" );
        etiquetaPromedioEncuesta = new JLabel( "Promedio total encuesta:" );

        txtConsulta = new JTextField( );
        txtConsulta.setEditable( false );
        txtConsulta.setPreferredSize( new Dimension( 100, 0 ) );
        txtConsulta.setVisible( false );

        txtNumeroOpiniones = new JTextField( );
        txtNumeroOpiniones.setEditable( false );
        txtNumeroOpiniones.setPreferredSize( new Dimension( 100, 0 ) );

        txtPromedioEncuesta = new JTextField( );
        txtPromedioEncuesta.setEditable( false );
        txtPromedioEncuesta.setPreferredSize( new Dimension( 100, 0 ) );

        etiquetaFiltroRango = new JLabel( "Rango de edad" );
        etiquetaFiltroEstadoCivil = new JLabel( "Estado civil" );

        botonConsultar = new JButton( "Consultar" );
        botonConsultar.addActionListener( this );
        botonConsultar.setActionCommand( CONSULTAR );

        botonNuevaEncuesta = new JButton( "Responder nuevamente" );
        botonNuevaEncuesta.addActionListener( this );
        botonNuevaEncuesta.setActionCommand( RANGO_EDAD );

        comboFiltroRango = new JComboBox( principal.darRangoEdades( ) );
        comboFiltroEstadoCivil = new JComboBox( listaEstados );

        JPanel panelInterno1 = new JPanel( );
        JPanel panelInterno2 = new JPanel( );

        panelInterno1.setLayout( new GridLayout( 1, 5, 5, 5 ) );
        panelInterno2.setLayout( new BorderLayout( ) );

        panelInterno1.add( etiquetaFiltroRango );
        panelInterno1.add( comboFiltroRango );
        panelInterno1.add( etiquetaFiltroEstadoCivil );
        panelInterno1.add( comboFiltroEstadoCivil );
        panelInterno1.add( botonConsultar );

        panelInterno2.add( etiquetaConsulta, BorderLayout.CENTER );
        panelInterno2.add( txtConsulta, BorderLayout.EAST );

        panelConsulta.add( panelInterno1 );
        panelConsulta.add( panelInterno2 );

        JPanel panelGrafico = new JPanel( );
        panelGrafico.setLayout( new GridLayout( 1, 2 ) );

        datosCasados = new DefaultCategoryDataset( );
        datosSolteros = new DefaultCategoryDataset( );
        JFreeChart graficoCasados = crearGrafico( "Calificación casados", datosCasados );
        JFreeChart graficoSolteros = crearGrafico( "Calificación solteros", datosSolteros );

        ChartPanel panelCasados = new ChartPanel( graficoCasados );
        panelCasados.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        panelGrafico.add( panelCasados );

        ChartPanel panelSolteros = new ChartPanel( graficoSolteros );
        panelSolteros.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        panelGrafico.add( panelSolteros );
        JPanel panelEstadisticasGenerales = new JPanel( );
        panelEstadisticasGenerales.setLayout( new BorderLayout( ) );
        JPanel panelTotales = new JPanel( );
        panelTotales.setLayout( new GridLayout( 2, 1 ) );
        panelTotales.setBorder( new EmptyBorder( 5, 1, 1, 1 ) );
        JPanel panelInterno3 = new JPanel( );
        JPanel panelInterno4 = new JPanel( );
        panelInterno3.setLayout( new BorderLayout( ) );
        panelInterno4.setLayout( new BorderLayout( ) );
        panelInterno3.add( etiquetaNumeroOpiniones, BorderLayout.CENTER );
        panelInterno3.add( txtNumeroOpiniones, BorderLayout.EAST );
        panelInterno4.add( etiquetaPromedioEncuesta, BorderLayout.CENTER );
        panelInterno4.add( txtPromedioEncuesta, BorderLayout.EAST );
        panelTotales.add( panelInterno3 );
        panelTotales.add( panelInterno4 );
        panelEstadisticasGenerales.add( panelTotales, BorderLayout.NORTH );
        panelEstadisticasGenerales.add( panelGrafico, BorderLayout.CENTER );
        panelEstadisticasGenerales.setBorder( new CompoundBorder( new EmptyBorder( 3, 5, 3, 5 ), new TitledBorder( "Estadísticas generales" ) ) );

        panelInternoResultados.add( panelConsulta, BorderLayout.NORTH );
        panelInternoResultados.add( panelEstadisticasGenerales, BorderLayout.CENTER );
        panelInternoResultados.add( botonNuevaEncuesta, BorderLayout.SOUTH );

        // Ingreso de paneles
        panelPreguntas.add( panelInternoIniciarEncuesta, REALIZAR_ENCUESTA );
        panelPreguntas.add( panelInternoRangoEdad, RANGO_EDAD );
        panelPreguntas.add( panelInternoEstadoCivil, ESTADO_CIVIL );
        panelPreguntas.add( panelInternoOpinion, OPINION );
        panelPreguntas.add( panelInternoResultados, VER_RESULTADOS );

        add( panelCabecera, BorderLayout.NORTH );
        add( panelPreguntas, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------

    /**
     * Muestra resultados de la encuesta en una ventana.
     * @param pResultado Resultado parcial de la encuesta según rango y estado Civil. pResultado > 0.
     * @param pRango Edad de las personas para este grupo de resultados.
     * @param pEsCasado Estados civil de las personas para este grupo de resultados.
     */
    private void mostrarResultados( double pResultado, int pRango, boolean pEsCasado )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );

        if( !Double.isNaN( pResultado ) )
        {
            etiquetaConsulta.setText( "Los participantes le dieron una calificación promedio de : " );
            txtConsulta.setText( df.format( pResultado ) );
            txtConsulta.setVisible( true );
        }
        else
        {
            etiquetaConsulta.setText( "Los participantes aún no han calificado el curso" );
            txtConsulta.setText( "" );
            txtConsulta.setVisible( false );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        CardLayout layout = ( CardLayout ) ( panelPreguntas.getLayout( ) );
        if( pEvento.getActionCommand( ) == CONSULTAR )
        {
            boolean esCasado = ( comboFiltroEstadoCivil.getSelectedIndex( ) == 0 ? true : false );
            int rango = comboFiltroRango.getSelectedIndex( ) + 1;

            double resultado = principal.darResultadosParciales( rango, esCasado );
            mostrarResultados( resultado, rango, esCasado );
        }
        else if( pEvento.getActionCommand( ) == AGREGAR_OPINION )
        {
            int opinion = comboOpinion.getSelectedIndex( );
            int rango = comboRango.getSelectedIndex( ) + 1;
            boolean esCasado = ( comboEstadoCivil.getSelectedIndex( ) == 0 ? true : false );
            getToolkit( ).beep( );
            principal.agregarOpinion( rango, esCasado, opinion );
            principal.actualizar( );

            comboOpinion.setSelectedIndex( 0 );
            comboRango.setSelectedIndex( 0 );
            comboEstadoCivil.setSelectedIndex( 0 );
            comboFiltroRango.setSelectedIndex( 0 );
            comboFiltroEstadoCivil.setSelectedIndex( 0 );
            etiquetaConsulta.setText( "" );
            txtConsulta.setText( "" );
            txtConsulta.setVisible( false );

            layout.show( panelPreguntas, VER_RESULTADOS );
        }
        else
        {
            layout.show( panelPreguntas, pEvento.getActionCommand( ) );
        }

    }

    /**
     * Actualiza la información
     * @param pEncuesta Encuesta de la cual se va a mostrar la información. pEncuesta != null.
     */
    public void actualizar( Encuesta pEncuesta )
    {
        txtNumeroOpiniones.setText( "" + pEncuesta.darNumeroTotalOpiniones( ) );
        txtPromedioEncuesta.setText( principal.formatearValorReal( pEncuesta.darPromedio( ) ) );

        datosCasados.setValue( pEncuesta.darResultadosJovenesCasados( ), "0-17 años", "" );
        datosCasados.setValue( pEncuesta.darResultadosAdultosCasados( ), "18-54 años", "" );
        datosCasados.setValue( pEncuesta.darResultadosMayoresCasados( ), "55 o más", "" );
        datosSolteros.setValue( pEncuesta.darResultadosJovenesSolteros( ), "0-17 años", "" );
        datosSolteros.setValue( pEncuesta.darResultadosAdultosSolteros( ), "18-54 años", "" );
        datosSolteros.setValue( pEncuesta.darResultadosMayoresSolteros( ), "55 o más", "" );
    }

    /**
     * Crea y configura los atributos de la gráfica en barras.
     * @param pTitulo Título de la gráfica.
     * @return Los datos que se dibujan en la gráfica.
     */
    private static JFreeChart crearGrafico( String pTitulo, DefaultCategoryDataset pDatos )
    {

        JFreeChart chart = ChartFactory.createBarChart( pTitulo, "Sector demográfico", "Promedio", pDatos, PlotOrientation.VERTICAL, true, true, false );

        chart.setBackgroundPaint( Color.white );

        CategoryPlot plot = chart.getCategoryPlot( );
        plot.setBackgroundPaint( Color.lightGray );
        plot.setDomainGridlinePaint( Color.white );
        plot.setRangeGridlinePaint( Color.white );

        NumberAxis rangeAxis = ( NumberAxis )plot.getRangeAxis( );
        rangeAxis.setStandardTickUnits( NumberAxis.createIntegerTickUnits( ) );

        BarRenderer renderer = ( BarRenderer )plot.getRenderer( );
        renderer.setDrawBarOutline( false );

        CategoryAxis domainAxis = plot.getDomainAxis( );
        domainAxis.setCategoryLabelPositions( CategoryLabelPositions.createUpRotationLabelPositions( Math.PI / 6.0 ) );
        return chart;
    }

}
