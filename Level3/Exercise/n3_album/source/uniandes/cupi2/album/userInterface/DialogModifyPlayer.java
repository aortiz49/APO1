/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogot� - Colombia)
 * Departamento de  Ingenier�a  de  Sistemas    y   Computaci�n
 * Licenciado   bajo    el  esquema Academic Free License versi�n 2.1
 * <p>
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_album
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.userInterface;

import java.awt.Color;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import uniandes.cupi2.album.world.Player;
import uniandes.cupi2.album.world.Player.Position;

/**
 * Panel que permite modificar la informaci�n de un jugador.
 */
@SuppressWarnings("serial")
public class DialogModifyPlayer extends JDialog implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	
	/**
	 * Comando para ejecutar la acci�n del bot�n btnGuardar.
	 */
	private final static String SAVE = "Save";
	
	/**
	 * Comando para ejecutar la acci�n del bot�n btnCancelar.
	 */
	private final static String CANCEL = "Cancel";
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * Jugador al cual pertenece la l�mina.
	 */
	private Player jugador;
	
	/**
	 * Pa�s al cual represento el jugador de la l�mina.
	 */
	private String pais;
	
	/**
	 * A�o en el cual represento al pa�s el jugador de la l�mina.
	 */
	private int anio;
	
	/**
	 * Ventana principal de la aplicaci�n
	 */
	private albumInterface principal;
	
	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------
	
	/**
	 * Campo de texto con el n�mero de camiseta del jugador.
	 */
	private JTextField txtCamiseta;
	
	/**
	 * Campo de texto con el nombre del jugador.
	 */
	private JTextField txtNombre;
	
	/**
	 * Campo de texto con el a�o de nacimiento del jugador.
	 */
	private JTextField txtAnioNacimiento;
	
	/**
	 * Campo de texto con la altura del jugador.
	 */
	private JTextField txtAltura;
	
	/**
	 * Campo de texto con el peso del jugador.
	 */
	private JTextField txtPeso;
	
	/**
	 * Lista desplegable con la posiciones.
	 */
	private JComboBox<String> cbPosition;
	
	/**
	 * Bot�n para la opci�n Guardar.
	 */
	private JButton btnGuardar;
	
	/**
	 * Bot�n para la opci�n Cancelar.
	 */
	private JButton btnCancelar;
	
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	
	/**
	 * Construye el dialogo que modifica el jugador.<br>
	 * <b> post: </b> Todos los botones, etiquetas y campos de texto fueron inicializados y
	 * ubicados. Se asignaron los atributos principal, jugador, pais y anio con los
	 * par�metros dados.
	 *
	 * @param pInterfaz Interfaz principal de la aplicaci�n. pInterfaz != null
	 * @param pPais     Pa�s al cual represento el jugador de la l�mina. pPais != null && pPais !=
	 *                  "".
	 * @param pAnio     A�o en el cual el jugador de la l�mina represento al pa�s. pAnio > 0.
	 * @param pJugador  Jugador que se va a modificar. pJugador != null.
	 */
	public DialogModifyPlayer(albumInterface pInterfaz, String pPais, int pAnio, Player
			pJugador) {
		
		principal = pInterfaz;
		jugador = pJugador;
		pais = pPais;
		anio = pAnio;
		
		setSize(400, 300);
		setTitle("Modify Player");
		
		JPanel panelGeneral = new JPanel();
		add(panelGeneral);
		panelGeneral.setLayout(new GridLayout(7, 2, 0, 5));
		panelGeneral.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblCamiseta = new JLabel("Shirt number:");
		panelGeneral.add(lblCamiseta);
		txtCamiseta = new JTextField(pJugador.getShirtNumber() + "");
		txtCamiseta.setEditable(true);
		panelGeneral.add(txtCamiseta);
		
		JLabel lblNombre = new JLabel("Name:");
		panelGeneral.add(lblNombre);
		txtNombre = new JTextField(pJugador.getName());
		txtNombre.setEditable(true);
		panelGeneral.add(txtNombre);
		
		JLabel lblAnioNacimiento = new JLabel("Birth year: ");
		panelGeneral.add(lblAnioNacimiento);
		txtAnioNacimiento = new JTextField(pJugador.getBirthYear() + "");
		txtAnioNacimiento.setEditable(true);
		panelGeneral.add(txtAnioNacimiento);
		
		JLabel lblAltura = new JLabel("Height: ");
		panelGeneral.add(lblAltura);
		txtAltura = new JTextField(pJugador.getHeight() + "");
		txtAltura.setEditable(true);
		panelGeneral.add(txtAltura);
		
		JLabel lblPeso = new JLabel("Weight: ");
		panelGeneral.add(lblPeso);
		txtPeso = new JTextField(pJugador.getWeight() + "");
		txtPeso.setEditable(true);
		panelGeneral.add(txtPeso);
		
		JLabel lblPosition = new JLabel("Position: ");
		panelGeneral.add(lblPosition);
		cbPosition = new JComboBox<>(darPosition());
		cbPosition.setSelectedItem(pJugador.getPosition());
		//cbPosition.setSelectedItem(pJugador.getPosition());
		panelGeneral.add(cbPosition);
		
		btnGuardar = new JButton("Save");
		btnGuardar.setActionCommand(SAVE);
		btnGuardar.addActionListener(this);
		panelGeneral.add(btnGuardar);
		
		btnCancelar = new JButton("Cancel");
		btnCancelar.setActionCommand(CANCEL);
		btnCancelar.addActionListener(this);
		panelGeneral.add(btnCancelar);
		
	}
	
	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------
	
	/**
	 * Manejo de eventos del usuario.
	 *
	 * @param pEvento Evento de usuario. pEvento != null.
	 */
	public void actionPerformed(ActionEvent pEvento) {
		String comando = pEvento.getActionCommand();
		switch(comando) {
			case SAVE:
				
				String nombre = txtNombre.getText().trim();
				if(nombre == null || nombre.equals("")) {
					JOptionPane.showMessageDialog(this, "The player's name cannot be empty. "
							, "Invalid value", JOptionPane.ERROR_MESSAGE);
					break;
				}
				if(!esNumerico(txtAnioNacimiento.getText())) {
					JOptionPane.showMessageDialog(this, "The year of birth must be an integer " +
							                              "value. "
							, "Invalid value", JOptionPane.ERROR_MESSAGE);
					break;
				}
				int anioNacimiento = Integer.parseInt(txtAnioNacimiento.getText());
				if(!esNumerico(txtAltura.getText())) {
					JOptionPane.showMessageDialog(this, "The height must be numeric.",
					                              "Value is not numeric", JOptionPane
							                              .ERROR_MESSAGE);
					break;
				}
				double altura = Double.parseDouble(txtAltura.getText());
				
				if(!esNumerico(txtPeso.getText())) {
					JOptionPane.showMessageDialog(this, "The weight must be numeric.",
					                              "Value is not numeric", JOptionPane.ERROR_MESSAGE);
					break;
				}
				double peso = Double.parseDouble(txtPeso.getText());
				
				if(!esNumerico(txtCamiseta.getText())) {
					JOptionPane.showMessageDialog(this, "The shirt number must be numeric. "
							, "Value is not numeric", JOptionPane.ERROR_MESSAGE);
					break;
				}
				int numeroCamiseta = Integer.parseInt(txtCamiseta.getText());
				if(numeroCamiseta <= 0) {
					JOptionPane.showMessageDialog(this, "The shirt number must be > 0.",
					                              "Incorrect value", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				if(principal.modifyPlayer(pais, anio, jugador.getShirtNumber(),
				                          numeroCamiseta, nombre, cbPosition.getSelectedItem()
						                          .toString(), anioNacimiento, altura, peso)) {
					dispose();
				}
				
				break;
			case CANCEL:
				dispose();
				break;
			
		}
	}
	
	/**
	 * Retorna la lista de posiciones posibles.
	 *
	 * @return Retorna la lista de posiciones.
	 */
	public String[] darPosition() {
		Position[] posiciones = Position.values();
		String[] strPociciones = new String[posiciones.length];
		for(int i = 0; i < strPociciones.length; i++) {
			String posicion = posiciones[i].toString().toLowerCase();
			strPociciones[i] = posicion.substring(0, 1).toUpperCase() +
					posicion.substring(1);
		}
		return strPociciones;
	}
	
	
	/**
	 * Indica si una cadena de caracteres es num�rica.
	 *
	 * @param pCadena Cadena de caracteres que se va a validar. pCadena != null && pCadena != "".
	 *
	 * @return True si la cadena de caracteres es num�rica, False en caso contrario.
	 */
	private boolean esNumerico(String pCadena) {
		try {
			Double.parseDouble(pCadena);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
