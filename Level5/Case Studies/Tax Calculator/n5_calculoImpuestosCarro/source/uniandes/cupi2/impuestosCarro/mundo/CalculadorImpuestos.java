/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_calculoImpuestosCarro
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.impuestosCarro.mundo;

import java.io.*;
import java.util.*;

/**
 * Calculador de impuestos.
 */
public class CalculadorImpuestos {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	
	/**
	 * Porcentaje de descuento por pronto pago.
	 */
	public static final double PORC_DESC_PRONTO_PAGO = 10.0;
	
	/**
	 * Valor de descuento por servicio p�blico.
	 */
	public static final double VALOR_DESC_SERVICIO_PUBLICO = 50000.0;
	
	/**
	 * Porcentaje de descuento por traslado de cuenta.
	 */
	public static final double PORC_DESC_TRASLADO_CUENTA = 5.0;
	
	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------
	
	/**
	 * Veh�culos que maneja el calculador.
	 */
	private Vehicle[] vehiculos;
	
	/**
	 * Veh�culo actual mostrado en la aplicaci�n.
	 */
	private int posVehicleActual;
	
	/**
	 * Rangos de los impuestos.
	 */
	private RangoImpuesto[] rangosImpuesto;
	
	// -----------------------------------------------------------------
	// Constructors
	// -----------------------------------------------------------------
	
	/**
	 * Crea un calculador de impuestos, cargando la informaci�n de dos archivos. <br>
	 * <b>post: </b> Se inicializaron los arreglos de veh�culos y rangos.<br>
	 * Se cargaron los datos correctamente a partir de los archivos.
	 * @throws Exception Error al cargar los archivos.
	 */
	public CalculadorImpuestos() throws Exception {
		cargarVehicles("data/vehiculos.txt");
		cargarTablaImpuestos("data/impuestos.properties");
	}
	
	// ----------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------
	
	/**
	 * Carga los datos de los veh�culos que maneja el calculador de impuestos. <br>
	 * <b>post: </b> Se cargan todos los veh�culos of the  archivo con sus datos.
	 * @param pArchivo Name ofl archivo donde se encuentran los datos de los veh�culos. pArchivo
     *                   != null.
	 * @throws Exception Si ocurre alg�n error cargando los datos.
	 */
	private void cargarVehicles(String pArchivo) throws Exception {
		String texto, valores[], sBrand, sLine, sModelo, sImagen;
		double price;
		int cantidad = 0;
		Vehicle vehiculo;
		try {
			File datos = new File(pArchivo);
			FileReader fr = new FileReader(datos);
			BufferedReader lector = new BufferedReader(fr);
			texto = lector.readLine();
			
			cantidad = Integer.parseInt(texto);
			vehiculos = new Vehicle[cantidad];
			posVehicleActual = 0;
			
			texto = lector.readLine();
			for (int i = 0; i < vehiculos.length; i++) {
				valores = texto.split(",");
				
				sBrand = valores[0];
				sLine = valores[1];
				sModelo = valores[2];
				sImagen = valores[4];
				price = Double.parseDouble(valores[3]);
				
				vehiculo = new Vehicle(sBrand, sLine, sModelo, price, sImagen);
				vehiculos[i] = vehiculo;
				// Siguiente line
				texto = lector.readLine();
			}
			lector.close();
		} catch (IOException e) {
			throw new Exception("Error al cargar los datos almacenados de veh�culos.");
		} catch (NumberFormatException e) {
			throw new Exception("El archivo no tiene el formato esperado.");
		}
	}
	
	/**
	 * Carga la tabla de impuestos por los rangos. <br>
	 * <b>post: </b> Se cargan todos valores de impuestos seg�n los rangos de valores.
	 * @param pArchivo Ubicaci�n of the  archivo a leer. pArchivo != null.
	 * @throws Exception Si ocurre un error al cargar los rangos.
	 */
	private void cargarTablaImpuestos(String pArchivo) throws Exception {
		Properties datos = new Properties();
		int rangos = 0;
		String texto, valores[];
		double inicio, fin, porcentaje;
		RangoImpuesto rango;
		try {
			FileInputStream input = new FileInputStream(pArchivo);
			datos.load(input);
			rangos = Integer.parseInt(datos.getProperty("numero.rangos"));
			rangosImpuesto = new RangoImpuesto[rangos];
			
			for (int i = 0; i < rangos; i++) {
				texto = datos.getProperty("rango" + (i + 1));
				valores = texto.split(",");
				try {
					inicio = Double.parseDouble(valores[0]);
					fin = Double.parseDouble(valores[1]);
					porcentaje = Double.parseDouble(valores[2]);
				} catch (Exception e) {
					throw new Exception("Error en la definici�n de rango" + i);
				}
				
				rango = new RangoImpuesto(inicio, fin, porcentaje);
				rangosImpuesto[i] = rango;
			}
		} catch (IOException e) {
			throw new Exception("Error al cargar los rangos de impuestos.");
		} catch (NumberFormatException e) {
			throw new Exception("Error en el formato of the  archivo.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error en el formato of the  archivo.");
		}
	}
	
	/**
	 * Busca, dado un valor, el rango de impuestos al que corresponde.
	 * @param pValor Valor a buscar. pValor > 0.
	 * @return Rango de impuesto que contiene al valor o null si no lo encuentra.
	 */
	private RangoImpuesto buscarRangoImpuesto(double pValor) {
		RangoImpuesto rango = null;
		for (int i = 0; i < rangosImpuesto.length && rango == null; i++) {
			RangoImpuesto rangoAux = rangosImpuesto[i];
			if (rangoAux.contieneA(pValor)) {
				rango = rangoAux;
			}
		}
		return rango;
	}
	
	/**
	 * Calcula el pago de impuesto que debe hacer el veh�culo actual. <br>
	 * <b>pre:</b> Las listas de rangos y veh�culos est�n inicializadas.
	 * @param pDescProntoPago Indica si aplica el descuento por pronto pago.
	 * @param pDescServicioPublico Indica si aplica el descuento por servicio p�blico.
	 * @param pDescTrasladoCuenta Indica si aplica el descuento por traslado de cuenta.
	 * @return Valor a pagar de acuerdo con las caracter�sticas of the  veh�culo y los descuentos que
     * se pueden aplicar.
	 */
	public double calcularPago(boolean pDescProntoPago, boolean pDescServicioPublico, boolean
        pDescTrasladoCuenta) {
		double pago = 0.0;
		double price = getVehicleActual().darPrice();
		// Calcula el impuesto seg�n el price of the  veh�culo
		RangoImpuesto rango = buscarRangoImpuesto(price);
		if (rango != null) {
			pago = price * (rango.darPorcentaje() / 100.0);
		}
		// Aplica descuento por pronto pago
		if (pDescProntoPago) {
			pago -= pago * (PORC_DESC_PRONTO_PAGO / 100);
		}
		// Aplica descuento por ser un veh�culo de servicio p�blico
		if (pDescServicioPublico) {
			pago -= VALOR_DESC_SERVICIO_PUBLICO;
		}
		// Aplica descuento por cambio de ciudad of the  veh�culo
		if (pDescTrasladoCuenta) {
			pago -= pago * (PORC_DESC_TRASLADO_CUENTA / 100);
		}
		// Si por descuentos se va a n�mero negativo se deja en cero
		if (pago < 0) {
			pago = 0;
		}
		return pago;
	}
	
	/**
	 * Returns the primer veh�culo. <br>
	 * <b>post: </b> Se actualiz� la posici�n of the  veh�culo actual.
	 * @return El primer veh�culo, que ahora es el veh�culo actual.
	 * @throws Exception Si ya se encuentra en el primer veh�culo.
	 */
	public Vehicle getPrimero() throws Exception {
		if (posVehicleActual == 0) {
			throw new Exception("Ya se encuentra en el primer veh�culo.");
		}
		posVehicleActual = 0;
		return getVehicleActual();
	}
	
	/**
	 * Returns the veh�culo anterior al actual. <br>
	 * <b>post: </b> Se actualiz� la posici�n of the  veh�culo actual.
	 * @return El anterior veh�culo, que ahora es el veh�culo actual.
	 * @throws Exception Si ya se encuentra en el primer veh�culo.
	 */
	public Vehicle getAnterior() throws Exception {
		if (posVehicleActual == 0) {
			throw new Exception("Se encuentra en el primer veh�culo.");
		}
		posVehicleActual--;
		return getVehicleActual();
	}
	
	/**
	 * Returns the veh�culo siguiente al actual. <br>
	 * <b>post: </b> Se actualiz� la posici�n of the  veh�culo actual.
	 * @return El siguiente veh�culo, que ahora es el veh�culo actual.
	 * @throws Exception Si ya se encuentra en el �ltimo veh�culo
	 */
	public Vehicle getSiguiente() throws Exception {
		if (posVehicleActual == vehiculos.length - 1) {
			throw new Exception("Se encuentra en el �ltimo veh�culo.");
		}
		posVehicleActual++;
		return getVehicleActual();
	}
	
	/**
	 * Returns the �ltimo veh�culo. <br>
	 * <b>post: </b> Se actualiz� la posici�n of the  veh�culo actual.
	 * @return El �ltimo veh�culo, que ahora es el veh�culo actual.
	 * @throws Exception Si ya se encuentra en el �ltimo veh�culo
	 */
	public Vehicle getUltimo() throws Exception {
		if (posVehicleActual == vehiculos.length - 1) {
			throw new Exception("Ya se encuentra en el �ltimo veh�culo.");
		}
		posVehicleActual = vehiculos.length - 1;
		return getVehicleActual();
	}
	
	/**
	 * Returns the veh�culo actual.
	 * @return El veh�culo actual.
	 */
	public Vehicle getVehicleActual() {
		return vehiculos[posVehicleActual];
	}
	
	/**
	 * Busca el veh�culo m�s caro, lo asigna como actual y lo retorna.
	 * @return El veh�culo m�s caro.
	 */
	public Vehicle buscarVehicleMasCaro() {
		Vehicle masCaro = null;
		double valorVehicle = 0;
		
		for (int i = 0; i < vehiculos.length; i++) {
			Vehicle vehiculo = vehiculos[i];
			if (vehiculo.darPrice() > valorVehicle) {
				masCaro = vehiculo;
				posVehicleActual = i;
				valorVehicle = vehiculo.darPrice();
			}
		}
		
		return masCaro;
		
	}
	
	/**
	 * Busca y retorna el primer veh�culo que encuentra con la brand que llega por par�metro. <br>
	 * <b>post: </b> Se asigna como veh�culo actual al veh�culo encontrado.
	 * @param pBrand Brand buscada.
	 * @return El primer veh�culo of the  brand. Si no encuentra ninguno retorna null.
	 */
	public Vehicle buscarVehiclePorBrand(String pBrand) {
		Vehicle buscado = null;
		for (int i = 0; i < vehiculos.length && buscado == null; i++) {
			Vehicle vehiculo = vehiculos[i];
			if (vehiculo.darBrand().equalsIgnoreCase(pBrand)) {
				buscado = vehiculo;
				posVehicleActual = i;
			}
		}
		
		return buscado;
	}
	
	/**
	 * Busca y retorna el veh�culo of the  line buscada. <br>
	 * <b>post: </b> Se asigna como veh�culo actual al veh�culo encontrado.
	 * @param pLine L�nea buscada. pLine != null &amp;&amp; pLine != ""
	 * @return El veh�culo of the  line, null si no encuentra ninguno.
	 */
	public Vehicle buscarVehiclePorLine(String pLine) {
		Vehicle buscado = null;
		for (int i = 0; i < vehiculos.length && buscado == null; i++) {
			Vehicle vehiculo = vehiculos[i];
			
			if (vehiculo.darLine().equalsIgnoreCase(pLine)) {
				buscado = vehiculo;
				posVehicleActual = i;
			}
		}
		
		return buscado;
	}
	
	// ----------------------------------------------------------------
	// Puntos de Extensi�n
	// ----------------------------------------------------------------
	
	/**
	 * M�todo para la extensi�n 1 of the  ejercicio.
	 * @return Respuesta 1.
	 */
	public String metodo1() {
		return "Respuesta 1";
	}
	
	/**
	 * M�todo para la extensi�n 2 of the  ejercicio.
	 * @return Respuesta 2.
	 */
	public String metodo2() {
		return "Respuesta 2";
	}
	
}