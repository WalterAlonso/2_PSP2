package uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo;

/**
 * Tipo de categoria Clase.
 * @author WALONSO
 *
 */
public class Clase extends Parte {
		
	final int cantidadColumnasPermitidas = 3;
	
	/**
	 * Ctor del tipo de categoria Clase
	 * @param linea: la linea a ser procesada, segun reglas de este tipo
	 * @throws Exception se genera si no cumple con las condiciones: columnas 
	 * permitidas, valor real y valor mayor a 0. 
	 */
	public Clase(String linea) throws Exception {
		procesarParte(linea);
	}
	
	/**
	 * Procesa la linea que llega, para validarla y agregarla a este tipo.
	 * @param linea: la cadena a ser validada
	 * @throws Exception se genera si no cumple con las condiciones: columnas 
	 * permitidas, valor real y valor mayor a 0.
	 */
	public void procesarParte(String linea) throws Exception {
		if (tieneColumnasAdecuadas(linea, cantidadColumnasPermitidas)) {
			String[] divisionValores = linea.split(",");	
			this.nombre = divisionValores[0].trim();
			double locClase = Double.parseDouble(Integer.toString(darValorEntero(divisionValores[1].trim())));
			double numberItems = Double.parseDouble(Integer.toString(darValorEntero(divisionValores[2].trim())));
			if (esMayorCero(locClase) && esMayorCero(locClase)){
				this.cantidad = locClase / numberItems;
			}
		}			
	}
}
