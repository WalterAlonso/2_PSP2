/**
 * Proposito:     Calcular el tamanio relativo de varias partes.
 * Autor(s):   Walter Javier Alonso Roa
 * Fecha creacion: 19 Marzo 2017
 * Modificado por: Walter Alonso 
 * Ultima modificacion: 19 Marzo 2017
*/

package uniandes.ecos.conceptosAvanzados.tamanioRelativo.controlador;

import java.util.ArrayList;

import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.ArchivoCategoriaFuncional;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.CategoriaFuncional;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.Modelo.TipoCategoria;
import uniandes.ecos.conceptosAvanzados.tamanioRelativo.vista.TamanioRelativoVista;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

/**
 * Clase principal que se encarga de controlas las peticiones del usuario.
 * @author WALONSO
 *
 */
public class CalculoTamanioRelativo {

	/** Main para heroku **/
	public static void main(String[] args) {

	    port(Integer.valueOf(System.getenv("PORT")));
	    staticFileLocation("/public");

	    get("/Loc", (req, res) -> {
	    	TamanioRelativoVista vista = new TamanioRelativoVista();
	    	try{
	    	String archivo = "./ArchivoProcesar/ArchivoCargaLocCapitulos.txt";
			TipoCategoria tipoCategoria = TipoCategoria.Clase;
			ArchivoCategoriaFuncional archivoCategoriaFuncional = new ArchivoCategoriaFuncional(tipoCategoria, archivo);
			archivoCategoriaFuncional.procesarArchivo();
			ArrayList<Double> contenidoArchivo = archivoCategoriaFuncional.darDatos();
			String nombreCategoria = "LOC/Method Data";
			CategoriaFuncional categoriaFuncional = new CategoriaFuncional(contenidoArchivo, nombreCategoria);
			categoriaFuncional.calcularTamanios();
			
			vista.asignarNombreCategoriaFuncional(categoriaFuncional.darNombre());
			vista.asignarTamanioVerySmall(categoriaFuncional.darTamanioVerySmall());
			vista.asignarTamanioSmall(categoriaFuncional.darTamanioSmall());
			vista.asignarTamanioMedium(categoriaFuncional.darTamanioMedium());
			vista.asignarTamanioLarge(categoriaFuncional.darTamanioLarge());
			vista.asignarTamanioVeryLarge(categoriaFuncional.darTamanioVeryLarge());
			vista.MostrarTamanioRelativo();
	    	
	    	return new ModelAndView(categoriaFuncional.darTamanioVeryLarge(), "error.ftl");
	    	}
	    	catch(Exception ex) {
	    		vista.mostrarError(ex.getMessage());
	    		return new ModelAndView(ex.getMessage(),"error.ftl");
	    	}
	    }, new FreeMarkerEngine());

	    /*get("/", (request, response) -> {
	        Map<String, Object> attributes = new HashMap<>();
	        attributes.put("message", "Hello World!");

	        return new ModelAndView(attributes, "index.ftl");
	    }, new FreeMarkerEngine());

	    HikariConfig config = new  HikariConfig();
	    config.setJdbcUrl(System.getenv("JDBC_DATABASE_URL"));
	    final HikariDataSource dataSource = (config.getJdbcUrl() != null) ?
	      new HikariDataSource(config) : new HikariDataSource();

	    get("/db", (req, res) -> {
	      Map<String, Object> attributes = new HashMap<>();
	      try(Connection connection = dataSource.getConnection()) {
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
	        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
	        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

	        ArrayList<String> output = new ArrayList<String>();
	        while (rs.next()) {
	          output.add( "Read from DB: " + rs.getTimestamp("tick"));
	        }

	        attributes.put("results", output);
	        return new ModelAndView(attributes, "db.ftl");
	      } catch (Exception e) {
	        attributes.put("message", "There was an error: " + e);
	        return new ModelAndView(attributes, "error.ftl");
	      }
	    }, new FreeMarkerEngine());
*/
	  }

	
	/** Main app normal **/	
	/**
	 * Main metodo principal, recibe del usuario la informacion y de acuerdo a ello, orquesta para mostrar resultados.
	 * @param args: argmentos del sistema
	 */
	/*public static void main(String[] args) {
		TamanioRelativoVista vista = new TamanioRelativoVista();
		try
		{		
			if(args.length < 1) {
				throw new Exception("No tiene argumentos, debe ingresar la ruta del archivo");
			}
			
			String archivo = "./ArchivoProcesar/" + args[0];
			TipoCategoria tipoCategoria = vista.obtenerTipoCategoria();
			ArchivoCategoriaFuncional archivoCategoriaFuncional = new ArchivoCategoriaFuncional(tipoCategoria, archivo);
			archivoCategoriaFuncional.procesarArchivo();
			ArrayList<Double> contenidoArchivo = archivoCategoriaFuncional.darDatos();
			String nombreCategoria = "Pgs/Chapte";
			if (tipoCategoria == TipoCategoria.Clase) {
				nombreCategoria = "LOC/Method Data";
			}
			
			CategoriaFuncional categoriaFuncional = new CategoriaFuncional(contenidoArchivo, nombreCategoria);
			categoriaFuncional.calcularTamanios();
			
			vista.asignarNombreCategoriaFuncional(categoriaFuncional.darNombre());
			vista.asignarTamanioVerySmall(categoriaFuncional.darTamanioVerySmall());
			vista.asignarTamanioSmall(categoriaFuncional.darTamanioSmall());
			vista.asignarTamanioMedium(categoriaFuncional.darTamanioMedium());
			vista.asignarTamanioLarge(categoriaFuncional.darTamanioLarge());
			vista.asignarTamanioVeryLarge(categoriaFuncional.darTamanioVeryLarge());
			vista.MostrarTamanioRelativo();
		}
		catch(Exception ex) {				
			vista.mostrarError(ex.getMessage());
		}
	}*/

}
