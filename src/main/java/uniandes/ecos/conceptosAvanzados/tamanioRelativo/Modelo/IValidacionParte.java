package uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo;

/**
 * Interface que indica que validar en las partes a ser cargadas
 * @author WALONSO
 *
 */
public interface IValidacionParte {
	
	/**
	 * Indica si tiene las columnas adecuadas
	 * @param linea: la linea del archivo a ser validada
	 * @param cantidadColumnasPermitidas: las clumnas permitidas.
	 * @return true si tiene las columnas, false si hay inconsistencia en las columnas
	 * @throws Exception dado que se genera excepcion al validar los numeros de columnas.
	 */
	boolean tieneColumnasAdecuadas(String linea, int cantidadColumnasPermitidas) throws Exception;
	
	/**
	 * Indica si el valor que tiene es numerico.
	 * @param valor: el valor a ser validado.
	 * @return true si es valido, false si no lo es.
	 * @throws Exception si el valor no es numerico arroja excepcion.
	 */
	int darValorEntero(String valor) throws Exception;
	
	/**
	 * valida si el dato es mayor a cero.
	 * @param valor: el valor a ser validado.
	 * @return true si es mayor a cero, false si no lo es.
	 * @throws Exception se genera si el valor no es mayor a cero.
	 */
	boolean esMayorCero(double valor) throws Exception;
}
