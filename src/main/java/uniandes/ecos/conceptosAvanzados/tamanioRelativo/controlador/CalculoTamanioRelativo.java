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

/**
 * Clase principal que se encarga de controlas las peticiones del usuario.
 * @author WALONSO
 *
 */
public class CalculoTamanioRelativo {

	/**
	 * Main metodo principal, recibe del usuario la informacion y de acuerdo a ello, orquesta para mostrar resultados.
	 * @param args: argmentos del sistema
	 */
	public static void main(String[] args) {
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
	}

}
