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

import uniandes.cupi2.club.world.Bill;
import uniandes.cupi2.club.world.Member;
import uniandes.cupi2.club.world.Member.MembershipType;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que modela las pruebas para el socio.
 */
public class MemberTest
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Es un socio de prueba
     */
    private Member socio;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * M�todo para configuraci�n de escenario
     */
    public void setupEscenario0( )
    {
        socio = new Member( "1", "name1", MembershipType.REGULAR );
    }
    /**
     * M�todo para configuraci�n de escenario
     */
    public void setupEscenario1( )
    {

        socio = new Member( "2", "name2", MembershipType.VIP );
    }
    /**
     * M�todo para probar los authorizedUsers
     */
    @Test
    public void testAgregarAuthorized( )
    {
        setupEscenario0( );
        String name = "name2";
        boolean esta = false;
        try
        {

            socio.addAuthorized( name );
            ArrayList<String> lista = socio.getAuthorizedUsers( );
            int indice = lista.size( );
            for( int i = 0; i < indice; i++ )
            {
                String autorizado = ( String )lista.get( i );
                if( autorizado.equals( name ) )
                {
                    esta = true;
                }
            }
            assertEquals( esta, true );
        }
        catch( Exception e )
        {

            fail( "falla! " + e.getLocalizedMessage( ) );
        }

    }

    /**
     * M�todo para probar los authorizedUsers
     */
    @Test
    public void testAgregarAuthorizedigualMember( )
    {
        setupEscenario1( );
        String name = "name2";
        try
        {
            socio.addAuthorized( name );
            fail( "El socio es el mismo autorizado" );
        }
        catch( Exception e )
        {
            assertTrue( "control de duplicados correcta ", true );
        }
    }
    /**
     * M�todo para probar la eliminaci�n de authorizedUsers
     */
    @Test
    public void testEliminarAuthorized( )
    {
        setupEscenario0( );
        String name = "name2";
        try
        {
            socio.addAuthorized( name );
            ArrayList<String> lista1 = socio.getAuthorizedUsers( );

            assertEquals( lista1.size( ), 1 );
            socio.deleteAuthorized( name );
            ArrayList<String> lista = socio.getAuthorizedUsers( );

            assertEquals( lista.size( ), 0 );
        }
        catch( Exception e )
        {
            fail( "falla! " + e.getLocalizedMessage( ) );
        }

    }
    /**
     * M�todo para probar el registro de Bills
     */
    @Test
    public void testRegistroBills( )
    {
        setupEscenario1( );
        String name = "name";
        String invoice = "invoice";
        double value = 1.0;

        try
        {
            socio.registerConsumption( name, invoice, value );
        }
        catch( Exception e )
        {
            fail( "Deber�a poder registrar el consumo" );
        }
        value = 999999;
        try
        {
            socio.registerConsumption( name, invoice, value );
            fail( "No deber�a poder registrar el consumo" );
        }
        catch( Exception e )
        {

        }
        ArrayList<Bill> listaBills = socio.getBills( );
        assertEquals( listaBills.size( ), 1 );

    }
    /**
     * M�todo para probar la eliminaci�n de Bills
     */
    @Test
    public void testEliminacionBills( )
    {
        setupEscenario0( );
        String name = "name";
        String invoice = "invoice";
        double value = 1.0;
        try
        {
            socio.registerConsumption( name, invoice, value );
        }
        catch( Exception e )
        {
            fail( "Deber�a poder registrar el consumo" );
        }
        ArrayList<Bill> listaBills1 = socio.getBills( );
        assertEquals( listaBills1.size( ), 1 );
        try
        {
            socio.payBill( 0 );
        }
        catch( Exception e )
        {
            fail( "Deber�a poder pay la factura" );
        }
        ArrayList<Bill> listaBills2 = socio.getBills( );
        assertEquals( listaBills2.size( ), 0 );

    }
    /**
     * M�todo para probar la adici�n de Bills
     */
    @Test
    public void testAgregacionBills( )
    {
        setupEscenario1( );
        String name = "name";
        String invoice = "invoice";
        Bill factura = null;
        double value = 1.0;
        boolean esta = false;
        try
        {
            socio.registerConsumption( name, invoice, value );
        }
        catch( Exception e )
        {
            fail( "Deber�a poder registrar el consumo" );
        }
        ArrayList<Bill> listaBills = socio.getBills( );
        int indice = listaBills.size( );
        for( int i = 0; i < indice; i++ )
        {
            factura = ( Bill )listaBills.get( i );
            if( factura.getInvoice( ).equals( invoice ) )
            {
                esta = true;
            }
        }
        assertEquals( esta, true );

    }

}
