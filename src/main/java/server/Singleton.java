package server;

import javax.jdo.PersistenceManagerFactory;

public class Singleton {
  static private PersistenceManagerFactory pmf=null;
  static private Server server;
  
   static public final String HOME_DIR = "C:\\desarrolloVane\\api_siat";
   static public final String DIR_ARCHIVOS = "C:\\desarrolloVane\\api_siat\\";
    
  // static public final String HOME_DIR_RELATIVO = "/ClienteApiSisinfo/";
 //  static public final String HOME_DIR = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ClienteApiSisinfo\\";
 
    /*Archivos de configuracion*/ 
   static public final String ARCHIVO_INI_CONFIGURACION_SERVIDOR_DE_PRUEBAS_o_PRODUCCION = HOME_DIR+"//config.ini";
   static private String archivoIni = ARCHIVO_INI_CONFIGURACION_SERVIDOR_DE_PRUEBAS_o_PRODUCCION;
   
   static public String HOME_DIR_ARCHIVOS = "";
   static public int cantidadBeginTransaction = 0;
   static public int cantidadCommitTransaction = 0;
   static public String driver;
  
   // Set the connection URL for the Cloudscape database.
   static public String  url;
   static public String userName;
   static public String password;
     
   public Singleton() {}
   static synchronized public PersistenceManagerFactory getPmf() {
     if (server==null){
       server = new Server(archivoIni);
       generarRutasAplicacion();
     }
     return pmf;
   }
   static synchronized public void reiniciarBaseDatos()
   {
     server = new Server(archivoIni);
     generarRutasAplicacion();
   }
   static synchronized public void setPmf(PersistenceManagerFactory pmfParametro) {
     pmf = pmfParametro;
   }
 
   private static void generarRutasAplicacion(){
 	   HOME_DIR_ARCHIVOS = 	DIR_ARCHIVOS+Server.getPathArchivos();	 
   }
 }