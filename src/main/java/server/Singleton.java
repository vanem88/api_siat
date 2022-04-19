package server;

import javax.jdo.PersistenceManagerFactory;

public class Singleton {

  static private PersistenceManagerFactory pmf=null;
  static private Server server;
  
  
  /**---------------------------------- SERVER PRUEBA (prueba.evelia.unrc.edu.ar) ------------------------------------------------------------------------------**/
  
 // static public final String HOME_DIR = "C:\\desarrolloVane\\api_siat\\";
  
   static public final String HOME_DIR = "/var/lib/tomcat9/webapps/api_siat/WEB-INF/classes";
    
	/**---------------------------------- LOCAL (ambiente de desarrollo, localhost) ------------------------------------------------------------------------------**/

    /*Archivos de configuracion*/ 
  //static public final String ARCHIVO_INI_CONFIGURACION_SERVIDOR_DE_PRUEBAS_o_PRODUCCION = HOME_DIR+"configuracion/siatReloaded.ini";
  //static private String archivoIni = "/application.properties";
  static private String archivoIni = HOME_DIR+"/application.properties";
   static public String HOME_DIR_ARCHIVOS = "";
  // static public String HOME_DIR_LOGS = "";
 
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
     	 server = new Server(archivoIni);
       generarRutasAplicacion();
     }
     return pmf;
   }
   
   static synchronized public void reiniciarBaseDatos(){
     server = new Server(archivoIni);
     generarRutasAplicacion();
   }
   
   static synchronized public void setPmf(PersistenceManagerFactory pmfParametro) {
     pmf = pmfParametro;
   }

   private static void generarRutasAplicacion(){
	  HOME_DIR_ARCHIVOS = HOME_DIR+Server.getPathArchivos();
 	//  HOME_DIR_LOGS = HOME_DIR+Server.getPathLogss(); 	  
   }
   
 }