/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogota - Colombia)
 * Departamento de  Ingenieria  de  Sistemas    y   Computacion
 * Licenciado   bajo    el  esquema Academic Free License version 2.1
 *      
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_album
 * Autor: Team Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.userInterface;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import uniandes.cupi2.album.world.Album;
import uniandes.cupi2.album.world.Team;
import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Positions;
import uniandes.cupi2.album.world.Card.CardType;

/**
 * Ventana principal of the  aplicacion.
 */
public class albumInterface extends JFrame
{

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Asociacion a la clase principal del world.
     */
    private Album world;

    /**
     * Índice del team que se esta mostrando actualmente.
     */
    private int indiceActual;

    // -----------------------------------------------------------------
    // Attributes of the  userInterface
    // -----------------------------------------------------------------

    /**
     * Contiene la informacion del team actual.
     */
    private PanelTeam panelTeam;

    /**
     * Contiene las opciones of the  aplicacion.
     */
    private PanelOpciones panelOpciones;

    /**
     * Contiene la navegacion a la izquierda.
     */
    private PanelLateral panelLateralIzq;

    /**
     * Contiene la navegacion a la derecha.
     */
    private PanelLateral panelLateralDer;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal of the  aplicacion. <br>
     * <b>post:</b> Todos los componentes of the  userInterface fueron inicializados.
     */
    public albumInterface( )
    {
        world = new Album( );
        cargarTeams( );

        setTitle( "Álbum" );
        setSize( 970, 750 );
        PanelFondo panelFondo = new PanelFondo( );
        panelFondo.setLayout( new BorderLayout( 10, 10 ) );
        add( panelFondo );
        setLocationRelativeTo( null );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        indiceActual = 0;
        panelTeam = new PanelTeam( this, world.getTeams( ).get( indiceActual ) );
        panelFondo.add( panelTeam, BorderLayout.CENTER );

        panelOpciones = new PanelOpciones( this );
        panelFondo.add( panelOpciones, BorderLayout.SOUTH );

        panelLateralIzq = new PanelLateral( this, PanelLateral.ANTERIOR );
        panelFondo.add( panelLateralIzq, BorderLayout.WEST );

        panelLateralDer = new PanelLateral( this, PanelLateral.SIGUIENTE );
        panelFondo.add( panelLateralDer, BorderLayout.EAST );

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Pega la lamina de un team.<br>
     * <b>pre: </b>El team existe.<br>
     * <b>post: </b>Se pego la lamina del team.
     * @param pCountry Country del team. pCountry != null && pCountry != "".
     * @param pYear Year en el cual el team represento al pais. pYear > 0.
     */
    public void pasteTeamCard( String pCountry, int pYear )
    {
        if(world.pasteTeamCard( pCountry, pYear ))
        {
            actualizar( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Esta lamina ya esta pegada", "Paste lamina team", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Pega la lamina del crest un team. <br>
     * <b>pre: </b>El team existe.<br>
     * <b>post: </b>Se pego la lamina del crest del team.
     * @param pCountry Country del team. pCountry != null && pCountry != "".
     * @param pYear Year en el cual el team represento al pais. pYear > 0.
     */
    public void pasteCrestCard( String pCountry, int pYear )
    {
        if(world.pasteCrestCard( pCountry, pYear ))
        {
            actualizar( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Esta lamina ya esta pegada", "Paste lamina crest", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Pega la lamina del player del team con el número de shirt dado.<br>
     * <b>pre: </b> El player existe.<br>
     * <b>post: </b>Se pego la lamina del player.
     * @param pCountry Country del team. pCountry != null && pCountry != "".
     * @param pYear Year en el cual el team represento al pais. pYear > 0.
     * @param pShirtNumber Número of the  shirt del player. pShirtNumber > 0.
     */
    public void pastePlayerCard( String pCountry, int pYear, int pShirtNumber )
    {
        if(world.pastePlayerCard( pShirtNumber, pCountry, pYear ))
        {
            actualizar( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Esta lamina ya esta pegada", "Paste lamina player", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Navega al team anterior.<br>
     * <b>post: </b>Se disminuyo en 1 el indice actual si era mayor a 0 y se actualizo la userInterface.
     */
    public void anterior( )
    {
        if( indiceActual == 0 )
        {
            JOptionPane.showMessageDialog( this, "No hay mas teams", "Team anterior", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            indiceActual--;
            actualizar( );
        }

    }

    /**
     * Navega al team siguiente.<br>
     * <b>post: </b>Se aumento en 1 el indice actual si era mayor a 0 y se actualizo la userInterface.
     */
    public void siguiente( )
    {
        ArrayList<Team> teams = world.getTeams( );
        if( teams.size( ) == indiceActual + 1 )
        {
            JOptionPane.showMessageDialog( this, "No hay mas teams", "Siguiente team", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            indiceActual++;
            actualizar( );
        }

    }

    /**
     * Modifica los datos de un player.<br>
     * <b>pre: </b> El player existe.<br>
     * <b>post: </b>Se modifyon los datos del player.
     * @param pCountry Country del team. pCountry != null && pCountry != "".
     * @param pYear Year en el cual el team represento al pais. pYear > 0.
     * @param pShirtNumber Número of the  shirt del player. pShirtNumber > 0.
     * @param pShirtNumberNueva Número nuevo of the  shirt del player. pShirtNumberNueva > 0.
     * @param pNameNuevo Name nuevo del player. pNameNuevo != null && pNameNuevo != "".
     * @param pPositions Position nueva del player. pPositions != null && pPositions pertenece a {"GOALKEEPER","DEFENDER","WINGER","STRIKER","UNKNOWN"}.
     * @param pBirthYear Year de nacimiento del player. pBirthYear > 0.
     * @param pHeight Height nueva del player. pHeight > 0.
     * @param pWeight Weight nuevo del player. pWeight > 0.
     * @return True si se modifico, False en caso contrario.
     */
    public boolean modifyPlayer( String pCountry, int pYear, int pShirtNumber, int pShirtNumberNueva, String pNameNuevo, String pPositions, int pBirthYear, double pHeight, double pWeight )
    {
        boolean response = world.modifyPlayer( pCountry, pYear, pShirtNumber, pShirtNumberNueva, pNameNuevo, getPosition( pPositions ), pBirthYear, pHeight, pWeight );
        if( response )
        {
            actualizar( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ya existe otro player con ese número de shirt", "Modify player", JOptionPane.ERROR_MESSAGE );
        }
        return response;
    }

    /**
     * Agrega al album un team que represento a un pais en un año dado.<br>
     * <b>post: </b>Si fue posible, se agrego el team.
     * @param pCountry Country al cual represento el team. pCountry != null && pCountry != "".
     * @param pYear Year en el cual represento el team al pais. pYear > 0.
     **/
    public void addTeam( String pCountry, int pYear )
    {
        boolean agrego = world.addTeam( pCountry, pYear );
        if( !agrego )
        {
            JOptionPane.showMessageDialog( this, "Este team ya existe en el album", "Add team", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            indiceActual = world.getTeams( ).size( ) - 1;
            actualizar( );
            JOptionPane.showMessageDialog( this, "Se agrego el team correctamente", "Add team", JOptionPane.INFORMATION_MESSAGE );
        }

    }

    /**
     * Muestra el dialogo para ingresar un año y muestra los teams de ese año.
     */
    public void findTeamsPorYear( )
    {

        String input = JOptionPane.showInputDialog( this, "Ingresa el año a consultar", "Find teams por año", JOptionPane.QUESTION_MESSAGE );
        try
        {
            int year = Integer.parseInt( input );
            ArrayList<Team> teams = world.findTeamsByYear( year );
            String mensaje = teams.size( ) > 0 ? "Los teams del año " + year + " son:" : "No se encontraron teams del año " + year + ".";
            for( Team team : teams )
            {
                mensaje += "\n- " + team.getCountry( );
            }
            JOptionPane.showMessageDialog( this, mensaje, "Find teams por año", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "El año debe ser un valor numerico", "Find teams por año", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca al player con la informacion dada por parametro.<br>
     * <b>post: </b>Si el player existe, navega hasta el team y muestra la ficha tecnica del player.
     * @param pShirt Número of the  shirt del player. pShirt > 0.
     * @param pCountry Country del team. pCountry != null && pCountry != "".
     * @param pYear Year en el cual el team represento al pais. pYear > 0.
     */
    public void findPlayer( int pShirt, String pCountry, int pYear )
    {
        Player player = world.findPlayer( pShirt, pCountry, pYear );
        if( player == null )
        {
            JOptionPane.showMessageDialog( this, "El player no existe", "Find player", JOptionPane.ERROR_MESSAGE );
        }
        else
        {

            DialogPlayer dialogo = new DialogPlayer( world.getTeams( ).get( world.findTeam( pCountry, pYear ) ), player );
            dialogo.setVisible( true );
            dialogo.setLocationRelativeTo( this );
        }

    }

    /**
     * Muestra el dialogo para conocer la edad mas común de un team del albúm.
     */
    public void mostrarMostCommonAge( )
    {
        Object[] teams = world.getTeams( ).toArray( );
        Team team = ( Team )JOptionPane.showInputDialog( this, "Selecciona el team", "Edad mas común", JOptionPane.QUESTION_MESSAGE, null, teams, teams[ 0 ] );
        int edadMasComun = world.getMostCommonAge( team.getCountry( ), team.getYear( ) );
        JOptionPane.showMessageDialog( this, "La edad mas común del team \"" + team + "\" es " + edadMasComun + "", "Edad mas común", JOptionPane.INFORMATION_MESSAGE );

    }

    /**
     * Actualiza la userInterface con la informacion del world. <br>
     * <b>post: </b>Se actualizo el team mostrado con todos sus componentes.
     */
    private void actualizar( )
    {
        Team teamActual = world.getTeams( ).get( indiceActual );
        panelTeam.actualizar( teamActual );
    }

    /**
     * Carga los teams iniciales.<br>
     * <b>pre: </b>El world esta inicializado.<br>
     * <b>post: </b> Se cargaron los teams descritos en el archivo ./data/data.txt
     */
    private void cargarTeams( )
    {
        try
        {
            BufferedReader in = new BufferedReader( new FileReader( "./data/data.txt" ) );
            String infoTeam;
            while( ( infoTeam = in.readLine( ) ) != null )
            {
                String country = infoTeam.split( ";" )[ 0 ];
                int year = Integer.parseInt( infoTeam.split( ";" )[ 1 ] );

                world.addTeam( country, year );
                for( int i = 0; i < Team.QUANTITY_OF_PLAYERS; i++ )
                {
                    String infoPlayer[] = in.readLine( ).split( ";" );

                    int numeroShirt = Integer.parseInt( infoPlayer[ 0 ] );
                    String nombre = infoPlayer[ 1 ];
                    String posicion = infoPlayer[ 2 ];
                    double peso = Double.parseDouble( infoPlayer[ 5 ] );
                    double altura = Double.parseDouble( infoPlayer[ 4 ] );
                    int yearNacimiento = Integer.parseInt( infoPlayer[ 3 ] );
                    world.modifyPlayer( country, year, -( i + 1 ), numeroShirt, nombre, getPosition( posicion ), yearNacimiento, altura, peso );
                }
            }
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }

    }
    /**
     * Retorna la posicion del player con el nombre dado.
     * @param pPositions Name of the  posicion.
     * @return Position con el nombre dado.
     */
    private Positions getPosition( String pPositions )
    {
        Positions posicion;
        switch( pPositions )
        {
            case "GOALKEEPER":
                posicion = Positions.GOALKEEPER;
                break;
            case "DEFENDER":
                posicion = Positions.DEFENDER;
                break;
            case "STRIKER":
                posicion = Positions.STRIKER;
                break;
            case "WINGER":
                posicion = Positions.WINGER;
                break;
            default:
                posicion = Positions.UNKNOWN;
                break;
        }
        return posicion;
    }

    /**
     * Muestra el dialogo con las estadisticas del album.<br>
     * <b>pre: </b> El world esta inicializado.
     */
    public void mostrarEstadisticas( )
    {
        double porcPegadoEscudos = world.getPercentageCompletenessCardType( CardType.CREST );
        double porcPegadoTeam = world.getPercentageCompletenessCardType( CardType.TEAM );
        double porcPegadoPlayers = world.getPercentageCompletenessCardType( CardType.PLAYER );

        String mensaje = "- Has pegado el " + porcPegadoEscudos + "% de los crests.\n";
        mensaje += "- Has pegado el " + porcPegadoTeam + "% de los teams.\n";
        mensaje += "- Has pegado el " + porcPegadoPlayers + "% de los playeres.\n";

        JOptionPane.showMessageDialog( this, mensaje, "Estadisticas", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Points de extension
    // -----------------------------------------------------------------

    /**
     * Extension 1
     */
    public void reqFuncOpcion1( )
    {

        String resultado = world.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Response 1", JOptionPane.INFORMATION_MESSAGE );
        actualizar( );
    }

    /**
     * Extension 2
     */
    public void reqFuncOpcion2( )
    {

        String resultado = world.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Response 2", JOptionPane.INFORMATION_MESSAGE );
        actualizar( );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este method ejecuta la aplicacion, creando una nueva userInterface
     * @param args Arreglo opcional de argumentos que se recibe por linea de commands
     */
    public static void main( String[] args )
    {
        try
        {
            // Unifica la userInterface para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            albumInterface interfaz = new albumInterface( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

}