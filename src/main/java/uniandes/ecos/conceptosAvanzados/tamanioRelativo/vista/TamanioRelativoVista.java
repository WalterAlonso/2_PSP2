package uniandes.ecos.conceptosAvanzados.tamanioRelativo.vista;

import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.TamanioRelativo;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.TipoCategoria;

/**
 * Se encarga de desplegar el modelo de tamanio relativo vista.
 * @author WALONSO
 *
 */
public class TamanioRelativoVista extends Vista {
	
	private String nombreCategoriaFuncional;
	
	private TamanioRelativo tamanioVerySmall;
	
	private TamanioRelativo tamanioSmall;
	
	private TamanioRelativo tamanioMedium;
	
	private TamanioRelativo tamanioLarge;
	
	private TamanioRelativo tamanioVeryLarge;
	
	/**
	 * Pregunta al usuario cual tipo de categoria va a procesar
	 * @return el tipo de categoria
	 */
	public TipoCategoria obtenerTipoCategoria() {
		while(true) {
			
			StringBuilder solicitarTipoCategoria = new StringBuilder();
			solicitarTipoCategoria.append("Cual es el tipo de categoria a cargar: \n");
			solicitarTipoCategoria.append("		1. LOC/Method Data\n");
			solicitarTipoCategoria.append("		2. Pgs/Chapter\n");
			solicitarTipoCategoria.append("		3. Salir\n");
			String valorIngresado = obtenerDato(solicitarTipoCategoria);
						
			switch (valorIngresado) {
					case "1":
						return TipoCategoria.Clase;
					case "2":
						return TipoCategoria.Capitulo;
					case "3":
						salir();
					default:
						System.out.println("---- Opcion no encontrada, vuelva a intentarlo.----\n");
						break;
			}
		}		
	}

	/**
	 * Salir de la aplicacion
	 */
	private void salir() {
		System.exit(0);
	}
	
	/**
	 * Muestra los errores.
	 * @param error: el error a mostrar al usuario.
	 */
	public void  mostrarError(String error) {
		mostrarDatos("Error", error);
	}
	
	/**
	 * Muestra al usuario los tamanios de la categoria cargada.
	 */
	 public void MostrarTamanioRelativo() {
		 mostrarDatos("Nombre", this.nombreCategoriaFuncional);
		 mostrarDatos(this.tamanioVerySmall.darNombreTamanioRelativo(), Double.toString(this.tamanioVerySmall.darCantidad()));
		 mostrarDatos(this.tamanioSmall.darNombreTamanioRelativo(), Double.toString(this.tamanioSmall.darCantidad()));
		 mostrarDatos(this.tamanioMedium.darNombreTamanioRelativo(), Double.toString(this.tamanioMedium.darCantidad()));
		 mostrarDatos(this.tamanioLarge.darNombreTamanioRelativo(), Double.toString(this.tamanioLarge.darCantidad()));
		 mostrarDatos(this.tamanioVeryLarge.darNombreTamanioRelativo(), Double.toString(this.tamanioVeryLarge.darCantidad()));
	 }	 
	
	/**
	 * Asigna el tamanio very small
	 * @param tamanioVerySmall: la instancia del tamanio relativo para VS
	 */
	public void asignarTamanioVerySmall(TamanioRelativo tamanioVerySmall) {
		this.tamanioVerySmall = tamanioVerySmall;
	}
	
	/**
	 * Asigna el tamanio small
	 * @param tamanioSmall: la instancia del tamanio relativo para S
	 */
	public void asignarTamanioSmall(TamanioRelativo tamanioSmall) {
		this.tamanioSmall = tamanioSmall;
	}
	
	/**
	 * Asigna el tamanio Medium
	 * @param tamanioMedium: la instancia del tamanio relativo para M
	 */
	public void asignarTamanioMedium(TamanioRelativo tamanioMedium) {
		this.tamanioMedium = tamanioMedium;
	}
	
	/**
	 * Asigna el tamanio Large
	 * @param tamanioLarge: la instancia del tamanio relativo para L
	 */
	public void asignarTamanioLarge(TamanioRelativo tamanioLarge) {
		this.tamanioLarge = tamanioLarge;
	}
	
	/**
	 * Asigna el tamanio very large
	 * @param tamanioVeryLarge: la instancia del tamanio relativo para VL
	 */
	public void asignarTamanioVeryLarge(TamanioRelativo tamanioVeryLarge) {
		this.tamanioVeryLarge = tamanioVeryLarge;
	}
	
	/**
	 * Asigna el nombre
	 * @param nombre: el nombre de la categoria a desplegar
	 */
	public void asignarNombreCategoriaFuncional(String nombre) {
		this.nombreCategoriaFuncional = nombre;
	}	
}
