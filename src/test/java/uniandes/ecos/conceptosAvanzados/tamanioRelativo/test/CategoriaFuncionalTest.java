package uniandes.ecos.conceptosAvanzados.tamanioRelativo.test;

import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.CategoriaFuncional;
import junit.framework.TestCase;

/**
 * Valia la clase principal que genera los tamanios relativos
 * @author WALONSO
 *
 */
public class CategoriaFuncionalTest extends TestCase {
	
	private ArrayList<Double> partes;
	
	private CategoriaFuncional categriaFunc;
	
	/**
	 * Inicializa la lista a ser calculada
	 */
	public void inicializarParte() {
		partes = new ArrayList<Double>();
		partes.add(6.0);
		partes.add(6.0);
		partes.add(8.3333);
		partes.add(10.3333);
		partes.add(12.3333);
		partes.add(16.4);
		partes.add(20.5);
		partes.add(21.75);
		partes.add(22.25);
		partes.add(23.0);
		partes.add(28.3333);
		partes.add(29.0);
		partes.add(55.8);
		
		categriaFunc = new CategoriaFuncional(partes, "LocMethod");
		categriaFunc.calcularTamanios();
	}
	
	/**
	 * Valida que el tamanio VS de acuerdo al esperado
	 */
	public void testValidarTamanioVerySmall() {
		inicializarParte();
		assertEquals("Debe ser 4.3953", 4.3953, categriaFunc.darTamanioVerySmall().darCantidad(), 0.001);		
	}
	
	/**
	 * Valida que el tamanio S de acuerdo al esperado
	 */
	public void testValidarTamanioSmall() {
		inicializarParte();
		assertEquals("Debe ser 8.5081", 8.5081, categriaFunc.darTamanioSmall().darCantidad(), 0.001);		
	}
	
	/**
	 * Valida que el tamanio M de acuerdo al esperado
	 */
	public void testValidarTamanioMedium() {
		inicializarParte();
		assertEquals("Debe ser 16.4696", 16.4696, categriaFunc.darTamanioMedium().darCantidad(), 0.001);		
	}
	
	/**
	 * Valida que el tamanio L de acuerdo al esperado
	 */
	public void testValidarTamanioLarge() {
		inicializarParte();
		assertEquals("Debe ser 31.8811", 31.8811, categriaFunc.darTamanioLarge().darCantidad(), 0.001);		
	}
	
	/**
	 * Valida que el tamanio VL de acuerdo al esperado
	 */
	public void testValidarTamanioVeryLarge() {
		inicializarParte();
		assertEquals("Debe ser 61.7137", 61.7137, categriaFunc.darTamanioVeryLarge().darCantidad(), 0.001);		
	}	
}
