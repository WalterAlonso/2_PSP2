package uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo;

/**
 * Indica la pate de la categoria funcional que se esta cargando
 * @author WALONSO
 *
 */
public class Parte implements IValidacionParte {
	
	/**
	 * Nombre de la parte
	 */
	protected String nombre;

	/**
	 * Cantidad de lineas de la parte
	 */
	protected double cantidad;
	
	/**
	 * Nombre de la parte
	 * @return el nombre de la parte
	 */
	public String darNombre() {
		return this.nombre;
	}
	
	/**
	 * Da la cantidad que debe ser procesada para la parte
	 * @return la cantidad de la parte
	 */
	public double darCantidad() {
		return this.cantidad;
	}
	
	/**
	 * Indica si tiene las columnas adecuadas
	 * @param linea: la linea del archivo a ser validada
	 * @param cantidadColumnasPermitidas: indica las columnas permitidas.
	 * @return true si tiene las columnas, false si hay inconsistencia en las columnas
	 * @throws Exception dado que se genera excepcion al validar los numeros de columnas.
	 */
	public boolean tieneColumnasAdecuadas(String linea, int cantidadColumnasPermitidas) throws Exception {
		String[] divisionValores = linea.split(",");		
		if (divisionValores.length != cantidadColumnasPermitidas) {
			throw new Exception("Tiene cantidad de columnas inadecuadas.");
		}
		return true;
	}	
	
	/**
	 * Indica si el valor que tiene es numerico.
	 * @param valor: el valor a ser validado.
	 * @return true si es valido, false si no lo es.
	 * @throws Exception si el valor no es numerico arroja excepcion.
	 */
	public int darValorEntero(String valor) throws Exception {
		try {
			return Integer.parseInt(valor);
		}
		catch(Exception ex) {
			throw new Exception("Hay un valor que no es numero real.");
		}
	}

	/**
	 * valida si el dato es mayor a cero.
	 * @param valor: el valor a ser validado.
	 * @return true si es maor a cero, false si no lo es.
	 * @throws Exception se genera si el valor no es mayor a cero.
	 */
	public boolean esMayorCero(double valor) throws Exception {
		if (valor <= 0) {
			throw new Exception("Hay valores menores o iguales a 0, los estimados deben ser mayores a 0.");
		}
		return true;
	}
}
