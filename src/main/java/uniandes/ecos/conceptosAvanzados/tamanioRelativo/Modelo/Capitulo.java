package uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo;

/**
 * Tipo de categoria Capitulo.
 * @author WALONSO
 *
 */
public class Capitulo extends Parte {
	
	final int cantidadColumnasPermitidas = 2;
	
	/**
	 * Ctor del tipo de categoria Clase
	 * @param linea: la linea a ser procesada, segun reglas de este tipo
	 * @throws Exception se genera si no cumple con las condiciones: columnas 
	 * permitidas, valor real y valor mayor a 0. 
	 */
	public Capitulo(String linea) throws Exception {
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
			int valor = darValorEntero(divisionValores[1].trim());
			if (esMayorCero(valor)){
				this.cantidad = valor;
			}
		}			
	}		
}
