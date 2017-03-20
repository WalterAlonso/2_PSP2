/**
 * Proposito:     Calcular el tamanio relativo de varias partes.
 * Autor(s):   Walter Javier Alonso Roa
 * Fecha creacion: 19 Marzo 2017
 * Modificado por: Walter Alonso 
 * Ultima modificacion: 19 Marzo 2017
*/

package uniandes.ecos.conceptosAvanzados.tamanioRelativo.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.ArchivoCategoriaFuncional;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.CategoriaFuncional;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.TipoCategoria;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

/**
 * Clase principal que se encarga de controlas las peticiones web del usuario.
 * 
 * @author WALONSO
 *
 */
public class CalculoTamanioRelativoWeb {

	/**
	 * Main metodo principal, recibe del usuario la informacion y de acuerdo a
	 * ello, orquesta para mostrar resultados.
	 * 
	 * @param args:
	 *            argmentos del sistema
	 */
	public static void main(String[] args) {
		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/ArchivoProcesar");
		//Request al home del sitio.
		get("/", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String archivoLoc = "src/main/resources/ArchivoProcesar/ArchivoCargaLocMetodo.txt";
				procesarArchivo(attributes, TipoCategoria.Clase, archivoLoc, "LOC/Method Data", "TipoCategoriaLoc");

				String archivoCapitulos = "src/main/resources/ArchivoProcesar/ArchivoCargaLocCapitulos.txt";
				procesarArchivo(attributes, TipoCategoria.Capitulo, archivoCapitulos, "Pgs/Chapter",
						"TipoCategoriaCapitulo");

				return new ModelAndView(attributes, "calculoTamanioRelativo.ftl");
			} catch (Exception ex) {
				attributes.put("message", ex.getMessage());
				return new ModelAndView(attributes, "error.ftl");
			}
		}, new FreeMarkerEngine());

		// Request para ver las pruebas de archivo
		get("/PruebasArchivo", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			try {
				String archivo = "ArchivoExtensionErronea.dat";
				ArchivoCategoriaFuncional archivoCategoriaFuncional = new ArchivoCategoriaFuncional(TipoCategoria.Clase,
						archivo);
				archivoCategoriaFuncional.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ExtensionErronea", ex.getMessage());
				attributes.put("MensajeEsperadoExtensionErronea", "El archivo debe ser en formato txt");
			}

			try {
				String archivo = "/ArchivoProcesar/ArchivoVacio.txt";
				ArchivoCategoriaFuncional archivoCategoriaFuncional = new ArchivoCategoriaFuncional(TipoCategoria.Clase,
						archivo);
				archivoCategoriaFuncional.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ArchivoVacio", ex.getMessage());
				attributes.put("MensajeEsperadoArchivoVacio", "El archivo esta vacio");
			}

			try {
				String archivo = "/ArchivoProcesar/ArchivoNoExiste.txt";
				ArchivoCategoriaFuncional archivoCategoriaFuncional = new ArchivoCategoriaFuncional(TipoCategoria.Clase,
						archivo);
				archivoCategoriaFuncional.procesarArchivo();
			} catch (Exception ex) {
				attributes.put("ArchivoNoExiste", ex.getMessage());
				attributes.put("MensajeEsperadoArchivoNoExiste", "No hay archivo que cargar");
			}

			return new ModelAndView(attributes, "testArchivo.ftl");
		}, new FreeMarkerEngine());
	}

	private static void procesarArchivo(Map<String, Object> attributes, TipoCategoria tipoCategoria, String archivo,
			String nombreCategoria, String llave) throws Exception {
		ArchivoCategoriaFuncional archivoCategoriaFuncional = new ArchivoCategoriaFuncional(tipoCategoria, archivo);
		archivoCategoriaFuncional.procesarArchivo();
		ArrayList<Double> contenidoArchivo = archivoCategoriaFuncional.darDatos();
		CategoriaFuncional categoriaFuncional = new CategoriaFuncional(contenidoArchivo, nombreCategoria);
		categoriaFuncional.calcularTamanios();

		attributes.put(llave, categoriaFuncional.darNombre());
		attributes.put(llave + "VS", categoriaFuncional.darTamanioVerySmall().darCantidad());
		attributes.put(llave + "S", categoriaFuncional.darTamanioSmall().darCantidad());
		attributes.put(llave + "M", categoriaFuncional.darTamanioMedium().darCantidad());
		attributes.put(llave + "L", categoriaFuncional.darTamanioLarge().darCantidad());
		attributes.put(llave + "VL", categoriaFuncional.darTamanioVeryLarge().darCantidad());
	}
}
