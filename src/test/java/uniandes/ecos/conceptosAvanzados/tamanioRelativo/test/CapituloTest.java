package uniandes.ecos.conceptosAvanzados.tamanioRelativo.test;

import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.Capitulo;
import junit.framework.TestCase;

/**
 * Realiza validaciones sobre la case Capitulo
 * @author WALONSO
 *
 */
public class CapituloTest extends TestCase{
	
	/**
	 * Valida que se cree la parte adecuadaente
	 */
	public void testCapituloValido() {
    	try {
    		
    		Capitulo capitulo = new Capitulo("nombre,2");
    		assertEquals("Debe ser nombre", "nombre", capitulo.darNombre());
    		assertEquals("Debe ser 2", 2.0, capitulo.darCantidad());
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
	
	/**
	 * Valida que no acepte mas de las columnas permitidas
	 */
	public void testColumnasMayorADos() {
    	try {
    		
    		Capitulo capitulo = new Capitulo("nombre,2,3");
    		fail("Debio haber fallado en el calculo de tres columnas ");    		
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Tiene cantidad de columnas inadecuadas.", "Tiene cantidad de columnas inadecuadas.", ex.getMessage());
    	}
    }
	
	/**
	 * Valida que no acepte mas de las columnas permitidas
	 */
	public void testColumnasMenorADos() {
    	try {
    		
    		Capitulo capitulo = new Capitulo("nombre");
    		fail("Debio haber fallado en el calculo de una columna");    		
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Tiene cantidad de columnas inadecuadas.", "Tiene cantidad de columnas inadecuadas.", ex.getMessage());
    	}
    }
	
	/**
	 * Valida valor entero
	 */
	public void testValidarValorEntero() {
    	try {
    		
    		Capitulo capitulo = new Capitulo("nombre,e");    		
    		fail("Debio haber fallado en el parseo de dato");    		
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Hay un valor que no es numero real.", "Hay un valor que no es numero real.", ex.getMessage());
    	}
    }
	
	/**
	 * Valida si tiene valores mayores a 0
	 */
	public void testValidarValorMayorCero() {
    	try {
    		
    		Capitulo capitulo = new Capitulo("nombre,-1");    		
    		fail("Debio haber fallado obteniendo valor mayor a 0");    		
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Hay valores menores o iguales a 0, los estimados deben ser mayores a 0.", 
    				"Hay valores menores o iguales a 0, los estimados deben ser mayores a 0.", ex.getMessage());
    	}
    }	
}
