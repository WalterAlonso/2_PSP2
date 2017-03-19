package uniandes.ecos.conceptosAvanzados.tamanioRelativo.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.ArchivoCategoriaFuncional;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.TipoCategoria;

/**
 * Test de los metodos de manejo de archivos
 * @author WALONSO
 *
 */
public class ArchivoCategoriaFuncionalTest extends TestCase {
	
	/**
	 * Clase ArchivoEstimar testear
	 */
	private ArchivoCategoriaFuncional archivoProcesar;
	
	/**
	 * Constante donde estan los archivos a testear
	 */
	public static final String rutaArchivo = "./ArchivoProcesarTest/";

	/**
     * Este metodo se encarga de verificar que se cargue bien cuando es clase
     * 
     */
    public void testCargarArchivoClase() {
    	try {
    		String archivo = rutaArchivo + "ArchivoCargaLocMetodo.txt";
    		archivoProcesar = new ArchivoCategoriaFuncional(TipoCategoria.Clase, archivo);
    		archivoProcesar.procesarArchivo();
    		ArrayList<Double> datos = archivoProcesar.darDatos();
    		
    		assertEquals("Debe ser 6", 6.0, datos.get(0));
    		assertEquals("Debe ser 6", 6.0, datos.get(1));
    		assertEquals("Debe ser 6", 8.333, datos.get(2), 0.001);
    		assertEquals("Debe ser 10.333", 10.333, datos.get(3), 0.001);
    		assertEquals("Debe ser 12.333", 12.333, datos.get(4), 0.001);
    		assertEquals("Debe ser 16.4", 16.4, datos.get(5));
    		assertEquals("Debe ser 20.5", 20.5, datos.get(6));
    		assertEquals("Debe ser 21.75", 21.75, datos.get(7));
    		assertEquals("Debe ser 22.25", 22.25, datos.get(8));
    		assertEquals("Debe ser 23", 23.0, datos.get(9));
    		assertEquals("Debe ser 28.333", 28.333, datos.get(10), 0.001);
    		assertEquals("Debe ser 29", 29.0, datos.get(11));
    		assertEquals("Debe ser 55.8", 55.8, datos.get(12), 55.8);
    	}
    	catch(Exception ex) { 		
    		fail("Excepcion: " + ex.getMessage());
    	}
    }
    
	/**
     * Este metodo se encarga de verificar que se cargue bien cuando es capitulo
     * 
     */
    public void testCargarArchivoCapitulo() {
    	try {
    		String archivo = rutaArchivo + "ArchivoCargaLocCapitulos.txt";
    		archivoProcesar = new ArchivoCategoriaFuncional(TipoCategoria.Capitulo, archivo);
    		archivoProcesar.procesarArchivo();
    		ArrayList<Double> datos = archivoProcesar.darDatos();
    		
    		assertEquals("Debe ser 7", 7.0, datos.get(0));
    		assertEquals("Debe ser 12", 12.0, datos.get(1));
    		assertEquals("Debe ser 10", 10.0, datos.get(2));
    		assertEquals("Debe ser 12", 12.0, datos.get(3));
    		assertEquals("Debe ser 10", 10.0, datos.get(4));
    		assertEquals("Debe ser 12", 12.0, datos.get(5));
    		assertEquals("Debe ser 12", 12.0, datos.get(6));
    		assertEquals("Debe ser 12", 12.0, datos.get(7));
    		assertEquals("Debe ser 12", 12.0, datos.get(8));
    		assertEquals("Debe ser 8", 8.0, datos.get(9));
    		assertEquals("Debe ser 8", 8.0, datos.get(10));
    		assertEquals("Debe ser 8", 8.0, datos.get(11));
    		assertEquals("Debe ser 20", 20.0, datos.get(12));
    		assertEquals("Debe ser 14", 14.0, datos.get(13));
    		assertEquals("Debe ser 18", 18.0, datos.get(14));
    		assertEquals("Debe ser 12", 12.0, datos.get(15));
    	}
    	catch(Exception ex) { 		
    		fail("Excepcion: " + ex.getMessage());
    	}
    }
}



