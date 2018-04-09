/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_club
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.club.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import uniandes.cupi2.club.world.Club;
import uniandes.cupi2.club.world.Member.MembershipType;

/**
 * Ventana principal de la interfaz del club.
 */
@SuppressWarnings("serial")
public class InterfazClub extends JFrame {
	
	// -----------------------------------------------------------------
	// Attributes de Interfaz
	// -----------------------------------------------------------------
	
	/**
	 * Panel con el banner de la aplicaci�n.
	 */
	private PanelImagen panelImagen;
	
	/**
	 * Panel authorizedUsers.
	 */
	private PanelAuthorizeds panelAuthorizedsMember;
	
	/**
	 * Panel con la lista de members.
	 */
	private PanelListaMembers panelListaMembers;
	
	/**
	 * Panel con la informaci�n del socio actual.
	 */
	private PanelMember panelMember;
	
	/**
	 * Panel de bills.
	 */
	private PanelBills panelBills;
	
	/**
	 * Panel con las opciones de extensi�n.
	 */
	private PanelOpciones panelOpciones;
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Club principal.
	 */
	private Club club;
	
	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	
	/**
	 * M�todo que inicializa todos los paneles e inicializa el club.
	 */
	public InterfazClub() {
		setTitle("Club");
		setSize(960, 550);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		club = new Club();
		
		setLayout(new BorderLayout());
		
		panelImagen = new PanelImagen();
		add(panelImagen, BorderLayout.NORTH);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BorderLayout());
		add(panelCentro, BorderLayout.CENTER);
		
		panelListaMembers = new PanelListaMembers(this);
		panelCentro.add(panelListaMembers, BorderLayout.WEST);
		
		panelMember = new PanelMember(this);
		panelCentro.add(panelMember, BorderLayout.CENTER);
		
		JPanel panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout(2, 1));
		add(panelDerecha, BorderLayout.EAST);
		
		panelBills = new PanelBills(this);
		panelDerecha.add(panelBills);
		
		panelAuthorizedsMember = new PanelAuthorizeds(this);
		panelDerecha.add(panelAuthorizedsMember);
		
		panelOpciones = new PanelOpciones(this);
		add(panelOpciones, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------
	
	/**
	 * Afilia el socio con la informaci�n recibida por par�metro.
	 *
	 * @param pIdentification C�dula del socio. pIdentification != null && pIdentification != "".
	 * @param pName           Name del socio. pName != null && pName != "".
	 * @param pMembershipType MembershipType de subscripci�n. pName = {MembershipType.REGULAR,
	 *                        MembershipType.VIP}.
	 */
	public void registerMember(String pIdentification, String pName, MembershipType
			pMembershipType) {
		try {
			club.registerMember(pIdentification, pName, pMembershipType);
			panelListaMembers.refrescar(club.getMembers());
			
			actualizar();
			JOptionPane.showMessageDialog(this, "El usuario ha sido ingresado", "Afiliar socio",
			                              JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Afiliar socio", JOptionPane
					.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Agrega un autorizado con la informaci�n dada por el usuario.
	 */
	public void agregarAuthorized() {
		String nameAuthorized = JOptionPane.showInputDialog(this, "Ingrese el name del " +
				"autorizado:", "Agregar autorizado", JOptionPane.QUESTION_MESSAGE);
		String IdentificationNumberMember = panelListaMembers
				.getIdentificationMemberSeleccionado();
		if (nameAuthorized != null && !nameAuthorized.isEmpty()) {
			try {
				// Se agrega el autorizado y se actualiza la informaci�n del panel
				club.agregarAuthorizedMember(IdentificationNumberMember, nameAuthorized);
				ArrayList<String> authorizedUsers = new ArrayList<String>(club.getAuthorizedUsers
						(IdentificationNumberMember));
				panelAuthorizedsMember.cambiarAuthorizeds(authorizedUsers);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane
						.ERROR_MESSAGE);
			}
		}
	}
	
	
	/**
	 * Paga la factura actualmente seleccionada.
	 */
	public void pagarBill() {
		try {
			String IdentificationNumber = panelListaMembers.getIdentificationMemberSeleccionado();
			int facturaIndice = panelBills.darPosicionBillSeleccionada();
			
			club.pagarBillMember(IdentificationNumber, facturaIndice);
			actualizar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane
					.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Aumenta los funds del socio actual.
	 */
	public void increaseFunds() {
		String IdentificationNumber = panelListaMembers.getIdentificationMemberSeleccionado();
		String respuesta = JOptionPane.showInputDialog(this, "Ingrese el value a aumentar:",
		                                               "Aumentar funds", JOptionPane
				                                               .QUESTION_MESSAGE);
		double value = 0;
		try {
			value = Double.parseDouble(respuesta);
			try {
				if (value > 0) {
					club.increaseFundsMember(IdentificationNumber, value);
					actualizar();
				} else {
					JOptionPane.showMessageDialog(this, "El value a aumentar debe ser mayor a " +
							"cero", "Aumentar funds", JOptionPane.ERROR_MESSAGE);
					
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Aumentar funds", JOptionPane
						.ERROR_MESSAGE);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "El value a aumentar debe ser un value num�rico",
			                              "Aumentar funds", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Actualiza la interfaz
	 */
	public void actualizar() {
		String IdentificationNumber = panelListaMembers.getIdentificationMemberSeleccionado();
		panelMember.actualizar(club.findMember(IdentificationNumber));
		panelBills.cambiarBills(club.getBillsMember(IdentificationNumber));
		panelAuthorizedsMember.cambiarAuthorizeds(club.getAuthorizedUsers(IdentificationNumber));
	}
	
	/**
	 * Registra un nuevo consumo para un socio determinado.
	 *
	 * @param pName    Name del cliente a quien se le registrar� el consumo.
	 * @param pInvoice Invoice del pago. pInvoice != null && pInvoice != "".
	 * @param pValue   Value del pago. pValue >0.
	 */
	public void registerConsumption(String pName, String pInvoice, double pValue) {
		try {
			String IdentificationNumber = panelListaMembers.getIdentificationMemberSeleccionado();
			club.registerConsumption(IdentificationNumber, pName, pInvoice, pValue);
			actualizar();
			JOptionPane.showMessageDialog(this, "Se registr� el consumo exit�samente", "Registrar" +
					" " +
					"consumo", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar consumo", JOptionPane
					.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Retorna la lista de authorizedUsers del socio actual.
	 *
	 * @return Lista de authorizedUsers del socio.
	 */
	public ArrayList<String> getAuthorizedUsers() {
		return club.getAuthorizedUsers(panelListaMembers.getIdentificationMemberSeleccionado());
	}
	
	/**
	 * Este m�todo sirve para verificar que una c�dula que tenga solamente d�gitos.
	 *
	 * @param pIdentification La c�dula que se quiere verificar. pIdentification != null.
	 *
	 * @return Retorna true si la cadena hasBill solamente d�gitos, false en caso contrario.
	 */
	private boolean verificarNumero(String pIdentification) {
		boolean resultado = false;
		try {
			Integer.parseInt(pIdentification);
			resultado = true;
		} catch (Exception e) {
			resultado = false;
		}
		
		return resultado;
	}
	
	// -----------------------------------------------------------------
	// Methods de extensi�n
	// -----------------------------------------------------------------
	
	/**
	 * Solicita el c�lculo de alg�n resultado.
	 */
	public void reqFuncOpcion1() {
		String resultado = club.metodo1();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane
				.INFORMATION_MESSAGE);
	}
	
	/**
	 * Solicita el c�lculo de alg�n resultado.
	 */
	public void reqFuncOpcion2() {
		String resultado = club.metodo2();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane
				.INFORMATION_MESSAGE);
	}
	
	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------
	
	/**
	 * Ejecuta la aplicaci�n.
	 *
	 * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
	 */
	public static void main(String[] pArgs) {
		try {
			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			
			InterfazClub interfaz = new InterfazClub();
			interfaz.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
