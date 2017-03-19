package uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo;

import java.util.ArrayList;

/**
 * Maneja los archivos especificos para calcular el tamanio relativo
 * @author WALONSO
 *
 */
public class ArchivoCategoriaFuncional extends Archivo {
	
	private TipoCategoria tipoCategoria;
	
	/**
	 * Ctor para el manejo de los archivos especificos para calcular el tamanio relativo
	 * @param tipoCategoria: el tipo de categoria a procesar, sea Clase o Capitulo
	 * @param rutaArchivo: la ruta donde se encuentra el archivo a procesar
	 */
	public ArchivoCategoriaFuncional(TipoCategoria tipoCategoria, String rutaArchivo) {
		super(rutaArchivo);
		this.tipoCategoria = tipoCategoria;
	}
	
	/**
	 * Retorna los datos del archivo cargado en una lista numerica
	 * @return los datos del archivo cargado en una lista numerica
	 * @throws Exception generada al tratar de obtener los datos.
	 */
	public ArrayList<Double> darDatos() throws Exception {	
		tieneMasDeUnRegistroHistorico();
		if (tipoCategoria == TipoCategoria.Capitulo) {
			ArrayList<Parte> capitulos = cargarCategoriaCapitulo();
			return convertirAListaNumerica(capitulos);
		}
		ArrayList<Parte> clases = cargarCategoriaClase();
		return convertirAListaNumerica(clases);
	}
	
	/**
	 * Carga la categoria funcional de capitulo
	 * @return la lista de partes de capitulo
	 * @throws Exception generada al tratar de cargar lel capitulo.
	 */
	private ArrayList<Parte> cargarCategoriaCapitulo() throws Exception {
		ArrayList<Parte> capitulos = new ArrayList<Parte>();
		for (int indice = 0; indice < contenidoArchivo.size(); indice ++) {
			String linea = contenidoArchivo.get(indice);
			Capitulo capitulo = new Capitulo(linea);
			capitulos.add(capitulo);
		}
		return capitulos;
	}
	
	/**
	 * Carga la categoria funcional de Clase
	 * @return la lista de partes de clase
	 * @throws Exception generada al tratar de cargar la clase.
	 */
	private ArrayList<Parte> cargarCategoriaClase() throws Exception {
		ArrayList<Parte> clases = new ArrayList<Parte>();
		for (int indice = 0; indice < contenidoArchivo.size(); indice ++) {
			String linea = contenidoArchivo.get(indice);
			Clase clase = new Clase(linea);
			clases.add(clase);
		}
		return clases;
	}
	
	private ArrayList<Double> convertirAListaNumerica(ArrayList<Parte> lista) {
		ArrayList<Double> listaNumerica = new ArrayList<>(); 
		for (int indice = 0; indice < lista.size(); indice ++) {
			Parte parte = lista.get(indice);
			listaNumerica.add(parte.darCantidad());
		}
		return listaNumerica;
	}
	
	private void tieneMasDeUnRegistroHistorico() throws Exception {
		if (this.contenidoArchivo.size() < 2) {
			throw new Exception("No se tiene mas de 1 registro historico, lo que no permite calcular los tamanios."); 
		}		
	}
}
