/************************************************************/
Codigo curso: CSOF5101 - 2017.
Nombre curso: CONCEPTOS AVANZADOS EN INGENIERIA DE SOFTWARE.
Nombre de la tarea: Assignment Kit for Program 4.
Fecha de envío de la tarea: 19 Marzo 2017 (17:00), 
		GithHub: 19 Mar 2017 (13:00), Heroku: 20 Mar 2017 (02:47)
Autor: Walter Javier Alonso Roa
/************************************************************/


¨** Descripcion:
Primero se debe colocar el archivo a procesar en la carpeta "ArchivoProcesar". (deben ser txt),
el codigo fuente se encuentra en el repo: https://github.com/WalterAlonso/2_PSP2.git

** Ambiente de ejecucion:
Este programa fue realizado con JRE 1.8 en S.O 7.
Debe tener instalado Maven


**************** Instrucciones de ejecucion ************************
** clone repo desde github.
$git clone https://github.com/WalterAlonso/2_PSP2.git

** Ingresar al folder 2_PSP2
  	cd 2_PSP2

** Ejecucion maven

	 mvn package

** Ejecute el programa:

	java -cp target/Ecos_CalculoTamanioRelativo-1.0-SNAPSHOT.jar uniandes.ecos.conceptosAvanzados.tamanioRelativo.controlador.CalculoTamanioRelativo "ArchivoCargaLocMetodo.txt"

** Documentacion del sitio

	mvn site

** Heroku:

	https://app-tamaniorelativo.herokuapp.com/


****************  Generalidades ***********************************
Dentro de la controladora se observan dos clases con metodo main estatico, esto se debe a
que se generaron 2 clases para la aplicación consola y otra para web con spark.

	- CalculoTamanioRelativo: Inicia el sistema con programa en consola (en la cual se ejecuta este programa en instrucciones de ejecución)
	- CalculoTamanioRelativoWeb: Inicia el sistema web, el cual fue desplegado en Heroku.