/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * University of the Andes
 * Department of Systems and Computer Engineering
 * Licensed under Academic Free License version 2.1
 * Project Cupi2 (http://cupi2.uniandes.edu.co)
 * Exercise: n4_socialClub
 * Author: Andres Ortiz
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.club.world;

import java.util.ArrayList;

import uniandes.cupi2.club.world.Member.MembershipType;

/**
 * Class that models a club.
 */
public class Club {
	
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Maximum quantity of VIP club members.
	 */
	public final static int MAXIMO_VIP = 3;
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * List of club members.
	 */
	private ArrayList<Member> members;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Constructs a club object.  <br>
	 * <b>post: </b> List of members was initialized.
	 */
	public Club() {
		members = new ArrayList<>();
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns the members affiliated to the club.
	 *
	 * @return List of members.
	 */
	public ArrayList<Member> getMembers() {
		return members;
	}
	
	/**
	 * Registers a new member to the club. <br>
	 * <b>pre: </b> The list of members has been initialized. <br>
	 * <b>post: </b> A new member with data given by the parameters was added to the club.
	 *
	 * @param pIdentification Id of member to be registered. pIdentification != null &&
	 *                        pIdentification != "".
	 * @param pName           Name of member to register. pName != null && pName != "".
	 * @param pMembershipType Type of subscription of the member. pMembershipType != null.
	 *
	 * @throws Exception <br>
	 *                   1. If a member with the same identification number is already affiliated
	 *                   to the club. <br>
	 *                   2. If the member to be registered wants a VIP subscription but the limit
	 *                   has already been reached.
	 */
	public void registerMember(String pIdentification, String pName, MembershipType
			pMembershipType) throws Exception {
		
		// Check to make sure a member with the same identification number doesn't already
		// exist.
		Member s = findMember(pIdentification);
		if (pMembershipType == MembershipType.VIP && countVIPMembers() == MAXIMO_VIP) {
			throw new Exception("At the moment, the club isn't accepting any more VIP members");
		}
		// Check to see make sure member with id number doesn't exist.
		if (s == null) {
			// Create an object of the member to be added.
			Member newMember = new Member(pIdentification, pName, pMembershipType);
			// The member is added to the social club.
			members.add(newMember);
		} else {
			throw new Exception("The member already exists");
		}
	}
	
	/**
	 * Returns the member with the given identification number. <br>
	 * <b> pre:<b> The list of members has been initialized.<br>
	 *
	 * @param pIdentification Identification number of member to be searched for.
	 *                        pIdentificationMember != null &&
	 *                        pIdentificationMember != "".
	 *
	 * @return The member with the identification number, null if the member isn't found.
	 */
	public Member findMember(String pIdentification) {
		Member foundMember = null;
		
		boolean isFound = false;
		int numMembers = members.size();
		for (int i = 0; i < numMembers && !isFound; i++) {
			Member s = members.get(i);
			if (s.getIdentification().equals(pIdentification)) {
				foundMember = s;
				isFound = true;
			}
		}
		
		return foundMember;
	}
	
	/**
	 * Returns the quantity of VIP members that the club has. <br>
	 * <b> pre: </b> The list of members has initialized.
	 *
	 * @return Number of VIP members.
	 */
	public int countVIPMembers() {
		int count = 0;
		for (Member tempMember : members) {
			if (tempMember.getMembershipType() == MembershipType.VIP)
				count++;
		}
		
		/*
		for(int i = 0; i < members.size(); i++) {
		if(members.get(i).getMembershipType() == MembershipType.VIP)
		 */
		return count;
	}
	
	/**
	 * Returns the list of authorizedUsers users under the member given by identification number.
	 * <b> pre: </b> The list of members has been initialized.
	 * The member to be searched exists.
	 *
	 * @param pIdentification Identification number of member to be searched for.
	 *                        pIdentificationMember != null &&
	 *                        pIdentificationMember != "".	 *
	 *
	 * @return List of authorizedUsers users.
	 */
	public ArrayList<String> getAuthorizedUsers(String pIdentification) {
		Member s = findMember(pIdentification);
		ArrayList<String> authorizedUsers = new ArrayList<>();
		
		authorizedUsers.add(s.getName());
		authorizedUsers.addAll(s.getAuthorizedUsers());
		
		return authorizedUsers;
	}
	
	/**
	 * Adds a new authorizedUsers user under the member with the given identification number.  <br>
	 * <b>pre:<b/> The member with the identification number exists.
	 * <b>post: </b> New guest was added.
	 *
	 * @param pIdentification Identification number of member to be searched for.
	 *                        pIdentificationMember != null &&
	 *                        pIdentificationMember != "".	 *
	 * @param pNameAuthorized Name of the person to authorize. pNameAuthorized != null &&
	 *                        pNameAuthorized != "".
	 *
	 * @throws Exception <br>
	 *                   1. Throws an exception if the name of the member is the same as the name
	 *                   of the guest. <br>
	 *                   2. Throws an exception if the authorizedUsers user to be added already
	 *                   exists in the list of authorizedUsers users under the member.  <br>
	 *                   3. Throws an exception if the member doesn't have enough funds to
	 *                   afford a new authorizedUsers user.
	 */
	public void addAuthorizedMember(String pIdentification, String pNameAuthorized)
			throws Exception {
			if(findMember(pIdentification).getName().equals(pNameAuthorized))
				throw new Exception("Authorized member cannot have the same name as the user");

			else {
				ArrayList<String> guests = getAuthorizedUsers(pIdentification);
				for (String guest : guests) {
				if (guest.equals(pNameAuthorized))
					throw new Exception("Authorized member already exists");
			}
		
		}
		if(findMember(pIdentification).getFunds() == 0)
			throw new Exception("Not enough funds");
		
		else {
			Member s = findMember(pIdentification);
			s.addAuthorized(pNameAuthorized);
		}
		
	}
	
	/**
	 * Elimina la persona autorizada por el socio con la c�dula dada.
	 *
	 * @param pIdentificationMember La c�dula del socio que autoriz� a la persona a delete
	 *                              .pIdentificationMember!= null && pIdentificationMember! ""
	 * @param pNameAuthorized       El name del autorizado a delete. pNameAuthorized!= null &&
	 *                              pNameAuthorized!=""
	 *
	 * @throws Exception Dispara una excepci�n si el el autorizado a delete hasBill una factura
	 *                   sin pay asociada.
	 */
	public void deleteAuthorizedMember(String pIdentificationMember, String pNameAuthorized)
			throws
			Exception {
		Member s = findMember(pIdentificationMember);
		s.deleteAuthorized(pNameAuthorized);
	}
	
	/**
	 * Registra un consumo a un socio o a su autorizado. <br>
	 * <b>post: </b> Se agreg� una nueva factura al vector del socio.
	 *
	 * @param pIdentificationMember La c�dula del socio. pIdentificationMember != null &&
	 *                              pIdentificationMember != "".
	 * @param pNameCliente          El name la persona que realiz� en consumo. pNameCliente !=
	 *                              null &&
	 *                              pNameCliente != "".
	 * @param pInvoice              El invoice del consumo. pInvoice != null && pInvoice != "".
	 * @param pValue                El value del consumo. pValue >= 0.
	 *
	 * @throws Exception Dispara una excepci�n en caso de que el socio no tenga funds suficientes
	 *                   para asumir este consumo.
	 */
	public void registerConsumption(String pIdentificationMember, String pNameCliente, String
			pInvoice,
	                             double pValue) throws Exception {
		Member s = findMember(pIdentificationMember);
		s.registerConsumption(pNameCliente, pInvoice, pValue);
	}
	
	/**
	 * Retorna la lista de bills de un socio. <br>
	 * <b>pre:<b> Existe el socio con la c�dula dada.
	 *
	 * @param pIdentificationMember La c�dula del socio. pIdentificationMember != null &&
	 *                              pIdentificationMember != "".
	 *
	 * @return La lista de bills del socio.
	 */
	public ArrayList<Bill> getBillsMember(String pIdentificationMember) {
		return findMember(pIdentificationMember).getBills();
	}
	
	/**
	 * Realiza el pago de la factura de un socio. <br>
	 * <b>post: </b> Se borr� la factura del vector del socio. <br>
	 *
	 * @param pIdentificationMember La c�dula del socio. pIdentificationMember != null &&
	 *                              pIdentificationMember != "".
	 * @param pBillIndice           El �ndice de la factura a pay. pBillIndice >= 0.
	 *
	 * @throws Exception Dispara una excepci�n en caso de que el usuario no tenga funds
	 *                   suficientes.
	 */
	public void payBillMember(String pIdentificationMember, int pBillIndice) throws Exception {
		Member s = findMember(pIdentificationMember);
		s.payBill(pBillIndice);
		
	}
	
	/**
	 * Aumenta los funds de un socio en la cantidad dada. <br>
	 * <b>post: </b> Los funds del socio aumentaron en el value especificado.
	 *
	 * @param pIdentificationMember La c�dula del socio. pIdentificationMember != null &&
	 *                              pIdentificationMember != "".
	 * @param pValue                Value por el cual se desean aumentar los funds. pValue >= 0.
	 *
	 * @throws Exception Dispara una excepci�n en caso de que el value especificado genere una
	 *                   cantidad de funds no permitida para el socio.
	 */
	public void increaseFundsMember(String pIdentificationMember, double pValue) throws
			Exception {
		Member s = findMember(pIdentificationMember);
		s.increaseFunds(pValue);
	}
	
	// -----------------------------------------------------------------
	// Methods de Extensi�n
	// -----------------------------------------------------------------
	
	/**
	 * Extensi�n 1.
	 *
	 * @return Resultado extensi�n 1.
	 */
	public String metodo1() {
		return "respuesta1";
	}
	
	/**
	 * Extensi�n 2.
	 *
	 * @return Resultado extensi�n 2.
	 */
	public String metodo2() {
		return "respuesta2";
	}
}