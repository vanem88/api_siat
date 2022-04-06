package server;

import javax.jdo.PersistenceManagerFactory;

import org.springframework.beans.factory.annotation.Value;

public class Singleton {

  static private PersistenceManagerFactory pmf=null;
  static private Server server;
  
  
  /**---------------------------------- SERVER PRUEBA (prueba.evelia.unrc.edu.ar) ------------------------------------------------------------------------------**/
  
  static public final String HOME_DIR = "C:\\desarrolloVane\\ClienteSisinfoAPI\\";
  static public final String DIR_ARCHIVOS = "C:\\desarrolloVane\\ClienteSisinfoAPI\\";
 
   //static public final String HOME_DIR_RELATIVO = "/montagna/";
   //static public final String DIR_ARCHIVOS = "/var/lib/tomcat9/webapps/montagna/";
    
    

  /**---------------------------------- LOCAL (ambiente de desarrollo, localhost) ------------------------------------------------------------------------------**/

    /*Archivos de configuraci�n*/ 
   static public final String ARCHIVO_INI_CONFIGURACION_SERVIDOR_DE_PRUEBAS_o_PRODUCCION = HOME_DIR+"config.ini";
   static private String archivoIni = ARCHIVO_INI_CONFIGURACION_SERVIDOR_DE_PRUEBAS_o_PRODUCCION;
   static public String HOME_DIR_ARCHIVOS = "";
   static public String HOME_DIR_LOGS = "";
 
   static public int cantidadBeginTransaction = 0;
   static public int cantidadCommitTransaction = 0;
   static public String driver;
   static public String  url;
   static public String userName;
   static public String password;
   
   //Tiempo de espera para consultar a la API de sisinfo si hay aulas para crear
   static public int tiempoEsperaConsultaAPI = 0;
   
   public Singleton() {}
   
   //Este metodo es el unico que se llama desde persistencia
   static synchronized public PersistenceManagerFactory getPmf() {
	 if (server==null){
     	 server = new Server();
       generarRutasAplicacion();
     }
     return pmf;
   }
   
   static synchronized public void reiniciarBaseDatos(){
     server = new Server();
     generarRutasAplicacion();
   }
   
   static synchronized public void setPmf(PersistenceManagerFactory pmfParametro) {
     pmf = pmfParametro;
   }

   private static void generarRutasAplicacion(){
 	  HOME_DIR_ARCHIVOS = DIR_ARCHIVOS+Server.getPathArchivos();
 	  HOME_DIR_LOGS = DIR_ARCHIVOS+Server.getPathLogss(); 	  
   }
   
 }