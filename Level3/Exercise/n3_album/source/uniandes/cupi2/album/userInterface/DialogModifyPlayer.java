/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 * <p>
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_album
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.album.userInterface;

import java.awt.Color;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *
 * Proyecto Cupi2   (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_album
 * Autor: Equipo Cupi2 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

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
import uniandes.cupi2.album.world.Player.Positions;

/**
 * Panel que permite modificar la información de un jugador.
 */
@SuppressWarnings("serial")
public class DialogModifyPlayer extends JDialog implements ActionListener {
	
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	
	/**
	 * Comando para ejecutar la acción del botón btnGuardar.
	 */
	private final static String GUARDAR = "Guardar";
	
	/**
	 * Comando para ejecutar la acción del botón btnCancelar.
	 */
	private final static String CANCELAR = "Cancelar";
	
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	
	/**
	 * Jugador al cual pertenece la lámina.
	 */
	private Player jugador;
	
	/**
	 * País al cual represento el jugador de la lámina.
	 */
	private String pais;
	
	/**
	 * Año en el cual represento al país el jugador de la lámina.
	 */
	private int anio;
	
	/**
	 * Ventana principal de la aplicación
	 */
	private albumInterface principal;
	
	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------
	
	/**
	 * Campo de texto con el número de camiseta del jugador.
	 */
	private JTextField txtCamiseta;
	
	/**
	 * Campo de texto con el nombre del jugador.
	 */
	private JTextField txtNombre;
	
	/**
	 * Campo de texto con el año de nacimiento del jugador.
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
	 * Botón para la opción Guardar.
	 */
	private JButton btnGuardar;
	
	/**
	 * Botón para la opción Cancelar.
	 */
	private JButton btnCancelar;
	
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	
	/**
	 * Construye el dialogo que modifica el jugador.<br>
	 * <b> post: </b> Todos los botones, etiquetas y campos de texto fueron inicializados y
	 * ubicados. Se asignaron los atributos principal, jugador, pais y anio con los
	 * parámetros dados.
	 * @param pInterfaz Interfaz principal de la aplicación. pInterfaz != null
	 * @param pPais País al cual represento el jugador de la lámina. pPais != null && pPais != "".
	 * @param pAnio Año en el cual el jugador de la lámina represento al país. pAnio > 0.
	 * @param pJugador Jugador que se va a modificar. pJugador != null.
	 */
	public DialogModifyPlayer(albumInterface pInterfaz, String pPais, int pAnio, Player
			pJugador) {
		
		principal = pInterfaz;
		jugador = pJugador;
		pais = pPais;
		anio = pAnio;
		
		setSize(400, 300);
		setTitle("Modificar Jugador");
		
		JPanel panelGeneral = new JPanel();
		add(panelGeneral);
		panelGeneral.setLayout(new GridLayout(7, 2, 0, 5));
		panelGeneral.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel lblCamiseta = new JLabel("Número de camiseta:");
		panelGeneral.add(lblCamiseta);
		txtCamiseta = new JTextField(pJugador.getShirtNumber() + "");
		txtCamiseta.setEditable(true);
		panelGeneral.add(txtCamiseta);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panelGeneral.add(lblNombre);
		txtNombre = new JTextField(pJugador.getName());
		txtNombre.setEditable(true);
		panelGeneral.add(txtNombre);
		
		JLabel lblAnioNacimiento = new JLabel("Año de nacimiento: ");
		panelGeneral.add(lblAnioNacimiento);
		txtAnioNacimiento = new JTextField(pJugador.getBirthYear() + "");
		txtAnioNacimiento.setEditable(true);
		panelGeneral.add(txtAnioNacimiento);
		
		JLabel lblAltura = new JLabel("Altura: ");
		panelGeneral.add(lblAltura);
		txtAltura = new JTextField(pJugador.getHeight() + "");
		txtAltura.setEditable(true);
		panelGeneral.add(txtAltura);
		
		JLabel lblPeso = new JLabel("Peso: ");
		panelGeneral.add(lblPeso);
		txtPeso = new JTextField(pJugador.getWeight() + "");
		txtPeso.setEditable(true);
		panelGeneral.add(txtPeso);
		
		JLabel lblPosition = new JLabel("Position: ");
		panelGeneral.add(lblPosition);
		cbPosition = new JComboBox<>(darPositions());
		cbPosition.setSelectedItem(pJugador.getPosition());
		panelGeneral.add(cbPosition);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand(GUARDAR);
		btnGuardar.addActionListener(this);
		panelGeneral.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		panelGeneral.add(btnCancelar);
		
	}
	
	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	
	/**
	 * Manejo de eventos del usuario.
	 * @param pEvento Evento de usuario. pEvento != null.
	 */
	public void actionPerformed(ActionEvent pEvento) {
		String comando = pEvento.getActionCommand();
		switch(comando) {
			case GUARDAR:
				
				String nombre = txtNombre.getText().trim();
				if(nombre == null || nombre.equals("")) {
					JOptionPane.showMessageDialog(this, "El nombre del jugador no puede ser vacio" +
							".", "Valor inválido", JOptionPane.ERROR_MESSAGE);
					break;
				}
				if(!esNumerico(txtAnioNacimiento.getText())) {
					JOptionPane.showMessageDialog(this, "El año de nacimiento debe ser un valor " +
							"numérico entero.", "Valor no númerico", JOptionPane.ERROR_MESSAGE);
					break;
				}
				int anioNacimiento = Integer.parseInt(txtAnioNacimiento.getText());
				if(!esNumerico(txtAltura.getText())) {
					JOptionPane.showMessageDialog(this, "La altura debe ser un valor numérico.",
					                              "Valor no númerico", JOptionPane.ERROR_MESSAGE);
					break;
				}
				double altura = Double.parseDouble(txtAltura.getText());
				
				if(!esNumerico(txtPeso.getText())) {
					JOptionPane.showMessageDialog(this, "El peso debe ser un valor numérico.",
					                              "Valor no númerico", JOptionPane.ERROR_MESSAGE);
					break;
				}
				double peso = Double.parseDouble(txtPeso.getText());
				
				if(!esNumerico(txtCamiseta.getText())) {
					JOptionPane.showMessageDialog(this, "El número de camiseta ser un valor " +
							"numérico.", "Valor no númerico", JOptionPane.ERROR_MESSAGE);
					break;
				}
				int numeroCamiseta = Integer.parseInt(txtCamiseta.getText());
				if(numeroCamiseta <= 0) {
					JOptionPane.showMessageDialog(this, "El número de camiseta ser un valor mayor " +
							"a 0.", "Valor incorrecto", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				if(principal.modifyPlayer(pais, anio, jugador.getShirtNumber(),
				                              numeroCamiseta, nombre, cbPosition.getSelectedItem()
						                              .toString(), anioNacimiento, altura, peso)) {
					dispose();
				}
				
				break;
			case CANCELAR:
				dispose();
				break;
			
		}
	}
	
	/**
	 * Retorna la lista de posiciones posibles.
	 * @return Retorna la lista de posiciones.
	 */
	public String[] darPositions() {
		Positions[] posiciones = Positions.values();
		String[] strPociciones = new String[posiciones.length];
		for(int i = 0; i < strPociciones.length; i++) {
			String posicion = posiciones[i].toString();
			strPociciones[i] = posicion;
		}
		return strPociciones;
	}
	
	/**
	 * Retorna la posición del jugador con el nombre dado.
	 * @param pPosition Nombre de la posición.
	 * @return Posición con el nombre dado.
	 */
	/*
	public Position darPosition(String pPosition) {
		Position posicion;
		switch(pPosition) {
			case "ARQUERO":
				posicion = Position.ARQUERO;
				break;
			case "DEFENSA":
				posicion = Position.DEFENSA;
				break;
			case "DELANTERO":
				posicion = Position.DELANTERO;
				break;
			case "VOLANTE":
				posicion = Position.VOLANTE;
				break;
			default:
				posicion = Position.DESCONCIDA;
				break;
		}
		return posicion;
	}*/
	
	/**
	 * Indica si una cadena de caracteres es numérica.
	 * @param pCadena Cadena de caracteres que se va a validar. pCadena != null && pCadena != "".
	 * @return True si la cadena de caracteres es numérica, False en caso contrario.
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
