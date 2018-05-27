/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_club
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.club.test;

import java.util.ArrayList;

import uniandes.cupi2.club.world.Club;
import uniandes.cupi2.club.world.Bill;
import uniandes.cupi2.club.world.Member;
import uniandes.cupi2.club.world.Member.MembershipType;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que modela las pruebas para el Club
 */
public class ClubTest
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Es un socio de prueba
     */
    private Member socio;
    /**
     * 
     * /** Es un club de prueba
     */
    private Club club;
    /**
     * M�todo para configuraci�n de escenario
     */
    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    public void setupEscenario0( )
    {

        club = new Club( );
        socio = new Member( "1", "name1", MembershipType.REGULAR );
    }
    /**
     * M�todo para configuraci�n de escenario
     */
    public void setupEscenario1( )
    {

        club = new Club( );
        socio = new Member( "2", "name2", MembershipType.VIP );
    }

    /**
     * M�todo para probar afiliaci�n socio no existente
     */
    @Test
    public void testAfiliarMemberNoExiste( )
    {
        setupEscenario0( );
        try
        {
            club.registerMember( "1", "name1", MembershipType.REGULAR );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
        Member socio2 = club.findMember( "1" );
        assertEquals( socio.getName( ), socio2.getName( ) );

    }
    /**
     * M�todo para probar afiliaci�n socio no existente
     */
    @Test
    public void testAfiliarMemberExiste( )
    {
        setupEscenario0( );

        try
        
        {
            club.registerMember( "3", "name3", MembershipType.REGULAR );
            club.registerMember( "3", "name3", MembershipType.REGULAR );
            fail( "El socio esta repetido" );
        }
        catch( Exception e )
        {

        }

    }
    /**
     * M�todo para probar afiliaci�n socio no existente
     */
    @Test
    public void testBuscarMember( )
    {
        setupEscenario1( );
        try
        {
            club.registerMember( "2", "name2", MembershipType.VIP );
        }
        catch( Exception e )
        {

            e.printStackTrace( );
        }
        Member socio2 = club.findMember( "2" );
        assertEquals( socio.getName( ), socio2.getName( ) );
    }

    /**
     * M�todo para probar que devuelve la lista de authorizedUsers de un socio correctamente.
     */
    @Test
    public void testDarAuthorizedsMember1( )
    {
        setupEscenario1( );

        try
        {
            club.registerMember( socio.getIdentification( ), socio.getName( ), socio.getMembershipType( ) );

            club.addAuthorizedMember( socio.getIdentification( ), "nameAuthorized1" );
            club.addAuthorizedMember( socio.getIdentification( ), "nameAuthorized2" );
            club.addAuthorizedMember( socio.getIdentification( ), "nameAuthorized3" );

            ArrayList<String> authorizedUsers = club.getAuthorizedUsers( socio.getIdentification( ) );

            if( authorizedUsers.size( ) < 4 )
            {
                fail( "No agrego a todos los authorizedUsers" );
            }

            for( int i = 1; i < authorizedUsers.size( ); i++ )
            {
                String nameAuthorized = ( String )authorizedUsers.get( i );
                assertEquals( "El autorizado no es el correcto", nameAuthorized, "nameAuthorized" + i );
            }
        }
        catch( Exception e )
        {
            fail( e.getMessage( ) );
        }
    }

    /**
     * M�todo para probar que lanza excepciones cuando intenta devolver la lista de authorizedUsers de un socio correctamente.
     */
    @Test
    public void testDarAuthorizedsMember2( )
    {
        setupEscenario1( );

        // Cuando intenta add un autorizado a un socio inexistente en el club
        try
        {
            club.addAuthorizedMember( socio.getIdentification( ), "nameAuthorized1" );
            fail( "Deber�a lanzar la excepci�n de no encontrar el socio" );
        }
        catch( Exception e )
        {
            // Deber�a pasar por ac�
        }
    }

    /**
     * M�todo para probar que agrega un autorizado a un socio
     */
    @Test
    public void testAgregarAuthorized1( )
    {
        setupEscenario1( );

        try
        {
            club.registerMember( socio.getIdentification( ), socio.getName( ), socio.getMembershipType( ) );

            int numAuthorizedsAntes = club.getAuthorizedUsers( socio.getIdentification( ) ).size( );
            club.addAuthorizedMember( socio.getIdentification( ), "nameAuthorized" );
            int numAuthorizedsDespues = club.getAuthorizedUsers( socio.getIdentification( ) ).size( );

            assertEquals( "La cantidad de authorizedUsers debe ser incrementado", numAuthorizedsAntes + 1, numAuthorizedsDespues );
        }
        catch( Exception e )
        {
            fail( e.getMessage( ) );
        }
    }

    /**
     * M�todo para probar que lanza las excepciones cuando intenta agrega un autorizado a un socio
     */
    @Test
    public void testAgregarAuthorized2( )
    {
        setupEscenario1( );

        // Cuando el socio no existe
        try
        {
            club.addAuthorizedMember( socio.getIdentification( ), "nameAuthorized" );
            fail( "El socio no existe en el club" );
        }
        catch( Exception e )
        {
            // Debe lanzar la excepci�n
        }

        try
        {
            club.registerMember( socio.getIdentification( ), socio.getName( ), socio.getMembershipType( ) );
            club.addAuthorizedMember( socio.getIdentification( ), "nameAuthorized" );
        }
        catch( Exception e1 )
        {
            fail( "Deber�a poder add el socio: " + e1.getMessage( ) );
        }

        // Cuando intenta add a un autorizado con el mismo name del socio
        try
        {
            club.addAuthorizedMember( socio.getIdentification( ), socio.getName( ) );
            fail( "Deber�a lanzar excepci�n de no poder add un autorizado con el mismo name de socio" );
        }
        catch( Exception e )
        {
            // Debe lanzar la excepci�n
        }

        // Cuando intenta add a un autorizado que ya exist�a
        try
        {
            club.addAuthorizedMember( socio.getIdentification( ), "nameAuthorized" );
            fail( "Deber�a lanzar excepci�n de no poder add un autorizado ya existente en la lista" );
        }
        catch( Exception e )
        {
            // Debe lanzar la excepci�n
        }
    }

    /**
     * Prueba que registra correctamente el consumo para un socio.
     */
    @Test
    public void testRegistrarConsumo1( )
    {
        setupEscenario1( );

        try
        {
            club.registerMember( socio.getIdentification( ), socio.getName( ), socio.getMembershipType( ) );
            club.addAuthorizedMember( socio.getIdentification( ), "A" );
        }
        catch( Exception e1 )
        {
            fail( "Deber�a poder add el socio: " + e1.getMessage( ) );
        }

        try
        {
            int numBillsAntes = club.getBillsMember( socio.getIdentification( ) ).size( );
            club.registerConsumption( socio.getIdentification( ), "A", "invoice", 1000 );
            int numBillsDespues = club.getBillsMember( socio.getIdentification( ) ).size( );

            assertEquals( "El n�mero de bills debi� incrementar en una", numBillsAntes + 1, numBillsDespues );
        }
        catch( Exception e )
        {
            fail( e.getMessage( ) );
        }
    }

    /**
     * Prueba que al registrar un consumo lanza las excepciones correctas
     */
    @Test
    public void testRegistrarConsumo2( )
    {
        setupEscenario1( );

        // Cuando el socio no existe
        try
        {
            club.registerConsumption( socio.getIdentification( ), "nameAuthorized", "invoice", 1000 );
            fail( "El socio no existe en el club" );
        }
        catch( Exception e )
        {
            // Debe lanzar la excepci�n
        }
    }

    /**
     * M�todo que prueba que este retornando correctamente la lista de bills
     */
    @Test
    public void testDarBills1( )
    {
        setupEscenario1( );

        try
        {
            club.registerMember( socio.getIdentification( ), socio.getName( ), socio.getMembershipType( ) );
            club.addAuthorizedMember( socio.getIdentification( ), "A" );

            club.registerConsumption( socio.getIdentification( ), "A", "invoice1", 1000 );
            club.registerConsumption( socio.getIdentification( ), "A", "invoice2", 1000 );
            club.registerConsumption( socio.getIdentification( ), "A", "invoice3", 1000 );
            club.registerConsumption( socio.getIdentification( ), "A", "invoice4", 1000 );

            ArrayList<Bill> bills = club.getBillsMember( socio.getIdentification( ) );
            for( int i = 0; i < bills.size( ); i++ )
            {
                Bill factura = ( Bill )bills.get( i );
                assertEquals( "El name del cliente de la factura no es correcto", "A", factura.getName( ) );
                assertEquals( "El invoice de la factura no es correcto", "invoice" + ( i + 1 ), factura.getInvoice( ) );
                assertEquals( "El value de la factura no es correcto", 1000, factura.getValue( ), 0.01 );
            }
        }
        catch( Exception e )
        {
            fail( e.getMessage( ) );
        }
    }

    /**
     * Prueba que al retornar una lista de bills lanza las excepciones correctas
     */
    @Test
    public void testDarBills2( )
    {
        setupEscenario1( );

        // Cuando el socio no existe
        try
        {
            club.getBillsMember( socio.getIdentification( ) );
            fail( "El socio no existe en el club" );
        }
        catch( Exception e )
        {
            // Debe lanzar la excepci�n
        }
    }

    /**
     * M�todo que prueba que para la factura de un socio del club
     */
    @Test
    public void testPagarBillMember1( )
    {
        setupEscenario1( );

        try
        {
            club.registerMember( socio.getIdentification( ), socio.getName( ), socio.getMembershipType( ) );
            club.addAuthorizedMember( socio.getIdentification( ), "A" );

            club.registerConsumption( socio.getIdentification( ), "A", "invoice1", 1000 );
            club.registerConsumption( socio.getIdentification( ), "A", "invoice2", 1000 );
            club.registerConsumption( socio.getIdentification( ), "A", "invoice3", 1000 );
            club.registerConsumption( socio.getIdentification( ), "A", "invoice4", 1000 );

            int billsSinPagarAntes = club.getBillsMember( socio.getIdentification( ) ).size( );
            club.payBillMember( socio.getIdentification( ), 0 );
            int billsSinPagarDespues = club.getBillsMember( socio.getIdentification( ) ).size( );

            assertEquals( "El n�mero de bills debi� disminuir", billsSinPagarAntes - 1, billsSinPagarDespues );
        }
        catch( Exception e )
        {
            fail( e.getMessage( ) );
        }
    }

    /**
     * M�todo que prueba que lanza excepci�n al intentar pay la factura de un socio del club
     */
    @Test
    public void testPagarBillMember2( )
    {
        setupEscenario1( );

        // Cuando el socio no existe
        try
        {
            club.payBillMember( socio.getIdentification( ), 0 );
            fail( "El socio no existe en el club" );
        }
        catch( Exception e )
        {
            // Debe lanzar la excepci�n
        }
    }
}