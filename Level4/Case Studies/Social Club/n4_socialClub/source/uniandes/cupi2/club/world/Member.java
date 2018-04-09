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

/**
 * Class that models a member.
 */
public class Member {
	// -----------------------------------------------------------------
	// Enums
	// -----------------------------------------------------------------
	
	/**
	 * Enums for the types of subscriptions.
	 */
	public enum MembershipType {
		/**
		 * Represents a VIP member.
		 */
		VIP,
		/**
		 * Represents a regular member.
		 */
		REGULAR
	}
	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------
	
	/**
	 * Initial amount of money for all regular members.
	 */
	public final static double INITIAL_FUNDS_REGULAR = 50000;
	
	/**
	 * Initial amount of money for all VIP members.
	 */
	public final static double INITIAL_FUNDS_VIP = 100000;
	
	/**
	 * Max amount of money that a regular member can have in his account.
	 */
	public final static double MAX_AMOUNT_REGULAR = 1000000;
	
	/**
	 * Max amount of money that a VIP member can have in his account.
	 */
	public final static double MAX_AMOUNT_VIP = 5000000;
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Member's Identification number.
	 */
	private String IdentificationNumber;
	
	/**
	 * Member's name.
	 */
	private String name;
	
	/**
	 * Member's available funds.
	 */
	private double funds;
	
	/**
	 * Member's subscription type.
	 */
	private MembershipType subscriptionType;
	
	/**
	 * Member's pending bills.
	 */
	private ArrayList<Bill> bills;
	
	/**
	 * Names of this member's authorized users.
	 */
	private ArrayList<String> authorizedUsers;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * Creates a club member. <br>
	 * <b>post: </b> A Member object was created with he values given by the parameter.<br>
	 * Bills and authorizedUsers vectors were initialized. <br>
	 * Initial funds were initialized.
	 *
	 * @param pIdentification Corresponds to the identification number of the new
	 *                        member.
	 *                        pIdentification != null &&  pIdentification != "".
	 * @param pName           Corresponds to the name of the new member.
	 *                        pName != null && pName != "".
	 * @param pMembershipType Corresponds to the member's subscription type. pMembershipType
	 *                        belongs to {MembershipType.VIP, MembershipType.REGULAR}.
	 */
	public Member(String pIdentification, String pName, MembershipType pMembershipType) {
		IdentificationNumber = pIdentification;
		name = pName;
		subscriptionType = pMembershipType;
		
		switch (subscriptionType) {
			case VIP:
				funds = INITIAL_FUNDS_VIP;
				break;
			default:
				funds = INITIAL_FUNDS_REGULAR;
		}
		
		bills = new ArrayList<>();
		authorizedUsers = new ArrayList<>();
	}
	
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Returns member's name. <br>
	 *
	 * @return The member's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns member's identification number. <br>
	 *
	 * @return The member's identification number.
	 */
	public String getIdentification() {
		return IdentificationNumber;
	}
	
	/**
	 * Returns member's available funds. <br>
	 *
	 * @return The member's available funds.
	 */
	public double getFunds() {
		return funds;
	}
	
	/**
	 * Returns member's subscription type. <br>
	 *
	 * @return The member's subscription type.
	 */
	public MembershipType getMembershipType() {
		return subscriptionType;
	}
	
	/**
	 * Returns the member's list of bills. <br>
	 *
	 * @return The member's list of pending bills.
	 */
	public ArrayList<Bill> getBills() {
		return bills;
	}
	
	/**
	 * Returns the member's list of authorized users. <br>
	 *
	 * @return The member's list of authorized users.
	 */
	public ArrayList<String> getAuthorizedUsers() {
		return authorizedUsers;
	}
	
	/**
	 * Indicates if a user belongs to the member's authorized users list or not.<br>
	 * <b>pre: </b> The list of authorized users has been initialized. <br>
	 *
	 * @param pNameAuthorized Name of authorized user to find.
	 *                        pNameAuthorized != null && pNameAuthorized != "".
	 *
	 * @return True if there exists an authorized user with the given name, false if contrary.
	 */
	private boolean existsAuthorizedUser(String pNameAuthorized) {
		boolean found = false;
		
		for (int i = 0; i < authorizedUsers.size() && !found; i++) {
			if (authorizedUsers.get(i).equals(pNameAuthorized)) {
				found = true;
			}
		}
		return found;
	}
	
	/**
	 * Indicates if an authorized user has a bill associated under his/her name. <br>
	 * <b>pre: </b> The list of bills has been initialized. <br>
	 *
	 * @param pNameAuthorized Name of authorized user to find.
	 *                        pNameAuthorized != null && pNameAuthorized != "".
	 *
	 * @return True if the authorized user has a bill associated under his/her name. False if
	 * contrary.
	 */
	private boolean hasBillAssociated(String pNameAuthorized) {
		boolean hasBill = false;
		for (int i = 0; i < bills.size() && !hasBill; i++) {
			Bill bill = bills.get(i);
			if (bill.getName().equals(pNameAuthorized)) {
				hasBill = true;
			}
		}
		
		return hasBill;
	}
	
	/**
	 * Increases the member's available funds.
	 *
	 * @param pFunds Value to add to the member's funds. pFunds > 0.
	 *
	 * @throws Exception Throws and exception if the member's funds will exceed the
	 *                   established limit upon completing the transaction.
	 */
	public void increaseFunds(double pFunds) throws Exception {
		if (subscriptionType == MembershipType.VIP && pFunds + funds > MAX_AMOUNT_VIP) {
			throw new Exception("with this amount, the maximum amount of funds for a VIP " +
					                    "member will be exceeded please enter a lower quantity.");
		} else if (subscriptionType == MembershipType.REGULAR && pFunds + funds >
				MAX_AMOUNT_REGULAR) {
			throw new Exception("with this amount, the maximum amount of funds for a regular " +
					                    "member will be exceeded please enter a lower quantity.");
		} else {
			funds = funds + pFunds;
		}
	}
	
	/**
	 * Registers a new invoice for the member, added by the one of his authorized users or
	 * himself. <br>
	 * <b>pre: </b> The list of bills has been initialized. <br>
	 * The name already belongs to the list of authorized users.<br>
	 * <b>post: </b> A new bill was added.
	 *
	 * @param pName    Name of the person that added the invoice. pName != null && pName != "".
	 * @param pInvoice Description of the consumption. pInvoice != null && pInvoice != "".
	 * @param pValue   Value of the consumption. pValue >= 0.
	 *
	 * @throws Exception Throws an exception if the member doens't have suffuicient funds
	 *                   for the bill.
	 */
	public void registerConsumption(String pName, String pInvoice, double pValue) throws
			Exception {
		
		if (pValue > funds) {
			throw new Exception("El socio no posee funds suficientes para este consumo");
		} else {
			Bill nuevaBill = new Bill(pName, pInvoice, pValue);
			bills.add(nuevaBill);
		}
	}
	
	/**
	 * Agrega una nueva persona autorizada al socio. <br>
	 * <b>pre: </b> La lista de authorizedUsers ha sido inicializada. <br>
	 * <b>post: </b> Se agreg� un nuevo autorizado.
	 *
	 * @param pNameAuthorized Es el name de la nueva persona autorizada para el socio.
	 *                        pNameAuthorized != null.
	 *
	 * @throws Exception <br>
	 *                   1. Dispara una excepci�n si el name del socio es igual al de name.<br>
	 *                   2. Dispara una excepci�n si el autorizado ya exist�a en la lista de
	 *                   authorizedUsers de este socio. <br>
	 *                   3. Dispara una excepci�n si el socio no hasBill funds para financiar un
	 *                   nuevo autorizado.
	 */
	public void agregarAuthorized(String pNameAuthorized) throws Exception {
		// Verificar que el name del socio no es el mismo del que se quiere autorizar
		if (pNameAuthorized.equals(getName())) {
			throw new Exception("No puede agregar el socio como autorizado.");
		}
		
		// Verificar que el socio posee funds para financiar un nuevo autorizado
		if (funds == 0) {
			throw new Exception("El socio no hasBill funds para financiar un nuevo autorizado.");
		}
		// Si el name no exist�a entonces lo agregamos
		if (!existsAuthorizedUser(pNameAuthorized)) {
			authorizedUsers.add(pNameAuthorized);
		} else {
			throw new Exception("El autorizado ya existe.");
		}
	}
	
	/**
	 * Elimina el autorizado del socio con el name dado. <br>
	 * <b>pre: </b> La lista de authorizedUsers ha sido inicializada. <br>
	 * <b>post: </b> Se elimin� un socio, con name igual a alguno de los vinculados.
	 *
	 * @param pNameAuthorized Name del autorizado. pNameAuthorized != null.
	 *
	 * @throws Exception Dispara una excepci�n si el autorizado hasBill una factura asociada.
	 */
	public void eliminarAuthorized(String pNameAuthorized) throws Exception {
		boolean found = false;
		int numAuthorizeds = authorizedUsers.size();
		if (hasBillAssociated(pNameAuthorized)) {
			throw new Exception(pNameAuthorized + " hasBill una factura sin pagar.");
		}
		for (int i = 0; i < numAuthorizeds && !found; i++) {
			String a = authorizedUsers.get(i);
			if (a.equals(pNameAuthorized)) {
				found = true;
				authorizedUsers.remove(i);
			}
		}
	}
	
	/**
	 * Paga la factura con el �ndice dado. <br>
	 * <b>pre: </b> La lista de bills ha sido inicializada. <br>
	 * <b>post: </b> Se borr� la factura de la lista de bills.
	 *
	 * @param pIndiceBill Posici�n de la factura a eliminar. facturaIndice >= 0.
	 *
	 * @throws Exception Si el socio no hasBill funds suficientes para pagar la factura.
	 */
	public void pagarBill(int pIndiceBill) throws Exception {
		Bill factura = bills.get(pIndiceBill);
		if (factura.getValue() > funds) {
			throw new Exception("El socio no posee funds suficientes para pagar esta factura");
		} else {
			funds = funds - factura.getValue();
			bills.remove(pIndiceBill);
		}
	}
	
	/**
	 * Retorna la cadena que representa al socio.
	 *
	 * @return Cadena de caracteres con la informaci�n del socio con el siguiente formato:
	 * <c�dula> - <name>.
	 */
	public String toString() {
		String socio = IdentificationNumber + " - " + name;
		return socio;
	}
	
}