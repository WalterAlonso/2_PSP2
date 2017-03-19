package uniandes.ecos.conceptosAvanzados.tamanioRelativo.test;

import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.Archivo;
import junit.framework.TestCase;

/**
 * Test de los metodos de manejo de archivos
 * @author WALONSO
 *
 */
public class ArchivoTest extends TestCase {
	
	/**
	 * Clase ArchivoEstimar testear
	 */
	private Archivo archivoProcesar;
	
	/**
	 * Constante donde estan los archivos a testear
	 */
	public static final String rutaArchivo = "./ArchivoProcesarTest/TestArchivo/";
		
	/**
     * Este metodo se encarga de verificar si el archivo tiene extension erronea
     * 
     */
    public void testArchivoConExtensionErronea() {
    	try {
    		String archivo = rutaArchivo + "ArchivoExtensionErronea.dat";
    		archivoProcesar = new Archivo(archivo);
    		archivoProcesar.procesarArchivo();
    		fail("Debio fallar: No valido el formato del archivo");
    	}
    	catch(Exception ex) { 		
    		assertEquals( "El mensaje debe coincidir: El archivo debe ser en formato txt", "El archivo debe ser en formato txt", ex.getMessage());
    	}
    }
    
	/**
     * Este metodo se encarga de verificar si el archivo esta vacio
     * 
     */
    public void testArchivoVacio() {
    	try {
    		String archivo = rutaArchivo + "ArchivoVacio.txt";
    		archivoProcesar = new Archivo(archivo);
    		archivoProcesar.procesarArchivo();
    		fail("Debio fallar: No valido si el archivo estaba vacio");
    	}
    	catch(Exception ex) {  		
    		assertEquals( "El mensaje debe coincidir: El archivo esta vacio", "El archivo esta vacio", ex.getMessage());
    	}
    }
    
    /**
     * Este metodo se encarga de verificar si el archivo existe
     * 
     */
    public void testArchivoExiste() {
    	try {
    		String archivo = rutaArchivo + "ArchivoVacioNoExiste.txt";
    		archivoProcesar = new Archivo(archivo);
    		archivoProcesar.procesarArchivo();
    		fail("Debio fallar: No valido si el archivo existia");
    	}
    	catch(Exception ex) {  		
    		assertEquals( "El mensaje debe coincidir: No hay archivo que cargar", "No hay archivo que cargar", ex.getMessage());
    	}
    }
	    
    /**
     * Este metodo se encarga de verificar si el archivo tiene solo un dato, dado que arrojaria un error
     * para el calculo de la desviacion estandar
     * 
     */
    public void testDatosCargados() {
    	try {
	    	String archivo = rutaArchivo + "ArchivoCargaLocMetodo.txt";
	    	archivoProcesar = new Archivo(archivo);
	    	archivoProcesar.procesarArchivo();
	    	ArrayList<String> datos = archivoProcesar.darContenidoArchivo();
	    		    	
	    	assertEquals( "1 fila: each_char,18,3", "each_char,18,3", datos.get(0));
	    	assertEquals( "2 fila: string_read,18,3", "string_read,18,3", datos.get(1));
	    	assertEquals( "3 fila: single_character,25,3", "single_character,25,3", datos.get(2));
	    	assertEquals( "4 fila: each_line,31,3", "each_line,31,3", datos.get(3));
	    	assertEquals( "5 fila: single_char,37,3", "single_char,37,3", datos.get(4));
	    	assertEquals( "6 fila: string_builder,82,5", "string_builder,82,5", datos.get(5));
	    	assertEquals( "7 fila: string_manager,82,4", "string_manager,82,4", datos.get(6));
	    	assertEquals( "8 fila: list_clump,87,4", "list_clump,87,4", datos.get(7));
	    	assertEquals( "9 fila: list_clip,89,4", "list_clip,89,4", datos.get(8));
	    	assertEquals( "10 fila: string_decrementer,230,10", "string_decrementer,230,10", datos.get(9));
	    	assertEquals( "11 fila: Char,85,3", "Char,85,3", datos.get(10));
	    	assertEquals( "12 fila: Character,87,3", "Character,87,3", datos.get(11));
	    	assertEquals( "13 fila: Converter,558,10", "Converter,558,10", datos.get(12));	    	
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    		fail("Error :" + ex.getMessage());
    	}
    }	
}


