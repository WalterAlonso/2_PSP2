package uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo;

import java.util.ArrayList;

/**
 * Realiza los procesos necesarios para crear los tamanios relativos a una categoria funcional
 * @author WALONSO
 *
 */
public class CategoriaFuncional {
	
	private ArrayList<Double> partes;
	
	private TamanioRelativo tamanioVerySmall;
	
	private TamanioRelativo tamanioSmall;
	
	private TamanioRelativo tamanioMedium;
	
	private TamanioRelativo tamanioLarge;
	
	private TamanioRelativo tamanioVeryLarge;
	
	private String nombre;
	
	/**
	 * Crea una nueva categoria funcional
	 * @param partes: las partes a ser procesadas
	 * @param nombre: el nombre de la categoria.
	 */
	public CategoriaFuncional(ArrayList<Double> partes, String nombre) {
		this.partes = partes;
		this.nombre = nombre;
	}
	
	/**
	 * Da el nombre de la categoria funcional
	 * @return el nombre de la categoria funcional
	 */
	public String darNombre() {
		return this.nombre;
	}
	/**
	 * Da el tamanio very small calculado
	 * @return el tamanio very small calculado
	 */
	public TamanioRelativo darTamanioVerySmall() {
		return this.tamanioVerySmall;
	}
	
	/**
	 * Da el tamanio small calculado
	 * @return el tamanio small calculado
	 */
	public TamanioRelativo darTamanioSmall() {
		return this.tamanioSmall;
	}
	
	/**
	 * Da el tamanio Medium calculado
	 * @return el tamanio Medium calculado
	 */
	public TamanioRelativo darTamanioMedium() {
		return this.tamanioMedium;
	}
	
	/**
	 * Da el tamanio large calculado
	 * @return el tamanio large calculado
	 */
	public TamanioRelativo darTamanioLarge() {
		return this.tamanioLarge;
	}
	
	/**
	 * Da el tamanio very large calculado
	 * @return el tamanio very large calculado
	 */
	public TamanioRelativo darTamanioVeryLarge() {
		return this.tamanioVeryLarge;
	}
	
	/**
	 * Realiza el calculo de los tamanios relativos (VS,S,M,L,VL)
	 */
	public void calcularTamanios() {
		ArrayList<Double> datosLogaritmo = UtilidadCalculo.darLogaritmoNatural(partes);
		double promedio = darPromedio(datosLogaritmo);
		double desviacionEstandar = darDesviacionEstandar(promedio);
		
		calcularTamanioVerySmall(promedio, desviacionEstandar);
		calcularTamanioSmall(promedio, desviacionEstandar);
		calcularTamanioMedium(promedio, desviacionEstandar);
		calcularTamanioLarge(promedio, desviacionEstandar);
		calcularTamanioVeryLarge(promedio, desviacionEstandar);
	}
	
	/**
	 * Calcula el promedio de las partes dadas
	 * @param lista: la lista de los datos a sacar promedio.
	 * @return el promedio de las partes dadas
	 */
	private double darPromedio(ArrayList<Double> lista) {
		return UtilidadCalculo.darPromedio(lista);		
	}
	
	private double darDesviacionEstandar(double promedio) {
		ArrayList<Double> datosLogaritmo = UtilidadCalculo.darLogaritmoNatural(partes);
		ArrayList<Double> valores= UtilidadCalculo.darRestaSegunValor(datosLogaritmo, promedio);
		double cantidadDatos = datosLogaritmo.size();
		double valorSumatoriaCuadrada= UtilidadCalculo.darSumatoriaCuadrada(valores);
		double varianza = valorSumatoriaCuadrada / (cantidadDatos - 1);
		return Math.sqrt(varianza);
	}
	
	private void calcularTamanioVerySmall(double promedio, double desviacionEstandar) {
		double tamanio = promedio - (2 * desviacionEstandar);
		double tamanioCalculado = UtilidadCalculo.darExponencialInversoNeperiano(tamanio);
		this.tamanioVerySmall = new TamanioRelativo("VS", tamanioCalculado);
	}
	
	private void calcularTamanioSmall(double promedio, double desviacionEstandar) {
		double tamanio = promedio - desviacionEstandar;
		double tamanioCalculado = UtilidadCalculo.darExponencialInversoNeperiano(tamanio);
		this.tamanioSmall = new TamanioRelativo("S", tamanioCalculado);	
	}
	
	private void calcularTamanioMedium(double promedio, double desviacionEstandar) {
		double tamanio = promedio;
		double tamanioCalculado = UtilidadCalculo.darExponencialInversoNeperiano(tamanio);
		this.tamanioMedium = new TamanioRelativo("M", tamanioCalculado);
	}
	
	private void calcularTamanioLarge(double promedio, double desviacionEstandar) {
		double tamanio = promedio + desviacionEstandar;
		double tamanioCalculado = UtilidadCalculo.darExponencialInversoNeperiano(tamanio);
		this.tamanioLarge = new TamanioRelativo("L", tamanioCalculado);
	}
	
	private void calcularTamanioVeryLarge(double promedio, double desviacionEstandar) {
		double tamanio = promedio + (2 * desviacionEstandar);
		double tamanioCalculado = UtilidadCalculo.darExponencialInversoNeperiano(tamanio);
		this.tamanioVeryLarge = new TamanioRelativo("VL", tamanioCalculado);
	}
}
