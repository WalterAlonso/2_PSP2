package uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo;

/**
 * Crea el tamanio relativo
 * @author WALONSO
 *
 */
public class TamanioRelativo {
	
	private String tamanioRelativo;
	
	private double cantidad;
	
	/**
	 * Ctor de la clase, inicia un tamanio relativo
	 * @param nombre: el nombre de esta categoria
	 * @param cantidad: la cantidad que aplica a esta categoria.
	 */
	public TamanioRelativo(String nombre, double cantidad) {
		this.tamanioRelativo = nombre;
		this.cantidad = cantidad;
	}
	
	/**
	 * Devuelve el nombre del tamanio que se esta tratando
	 * @return el nombre del tamanio que se esta tratando
	 */
	public String darNombreTamanioRelativo() {
		return this.tamanioRelativo;
	}
	
	/**
	 * devuelve la cantidad de este tamanio relativo
	 * @return la cantidad de este tamanio relativo
	 */
	public double darCantidad() {
		return this.cantidad;
	}
}
