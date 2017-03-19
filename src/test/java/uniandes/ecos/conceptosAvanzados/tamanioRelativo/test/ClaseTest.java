package uniandes.ecos.conceptosAvanzados.tamanioRelativo.test;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.Clase;

/**
 * Valida los metodos en la clase Clase
 * @author WALONSO
 *
 */
public class ClaseTest extends TestCase {
	
	/**
	 * Valida que se cree la parte adecuadaente
	 */
	public void testClaseValida() {
    	try {
    		
    		Clase capitulo = new Clase("nombre,2,3");
    		assertEquals("Debe ser nombre", "nombre", capitulo.darNombre());
    		assertEquals("Debe ser 0.6666", 0.6666, capitulo.darCantidad(), 0.001);
    	}
    	catch(Exception ex) { 		
    		fail("Se genero excepcion "+ ex.getMessage());
    	}
    }
	
	/**
	 * Valida que no acepte mas de las columnas permitidas
	 */
	public void testColumnasMayorATres() {
    	try {
    		
    		Clase clase = new Clase("nombre,2,3,1");
    		fail("Debio haber fallado en el calculo de tres columnas ");    		
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Tiene cantidad de columnas inadecuadas.", "Tiene cantidad de columnas inadecuadas.", ex.getMessage());
    	}
    }
	
	/**
	 * Valida que no acepte mas de las columnas permitidas
	 */
	public void testColumnasMenorATres() {
    	try {
    		
    		Clase clase = new Clase("nombre,3");
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
    		
    		Clase clase = new Clase("nombre,e,2");    		
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
    		
    		Clase clase = new Clase("nombre,-1,3");    		
    		fail("Debio haber fallado obteniendo valor mayor a 0");    		
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: Hay valores menores o iguales a 0, los estimados deben ser mayores a 0.", 
    				"Hay valores menores o iguales a 0, los estimados deben ser mayores a 0.", ex.getMessage());
    	}
    }	
}