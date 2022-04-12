package server;

import java.util.*;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import org.springframework.stereotype.Component;
import persistencia.*;
import utils.IniFile;

@Component
public class Server{
	
	static public String PATH_ARCHIVOS = ""; 
	static public String PATH_LOGS = ""; 
	static public String NOMBRE_SERVIDOR = "";
	static public String RUTA_HTTP_SERVIDOR = "";
	static public String APLICACION = "";
	static public String SERVIDOR_EXTERNO = "";
	
	static public String PORT_SERVIDOR_EXTERNO = "";
	static public String GETTRANSPORT_SERVIDOR_EXTERNO = "";
	static public String USUARIO_SERVIDOR_EXTERNO = "";
	static public String CLAVE_SERVIDOR_EXTERNO = "";
	static public String HOST_SERVIDOR_EXTERNO = "";
	
	public Server(String archivoIni){
		try{
			
			System.out.println("FECHA y HORA del (RE)INICIO del SERVER ========> "+utils.Utils.hoySqlDate());
			//System.out.println("HOME_DIR DE SINGLETON .................."+Singleton.HOME_DIR);
							
			IniFile iniFile = new IniFile();
			iniFile.setNameFile(archivoIni); 
			
			NOMBRE_SERVIDOR = iniFile.getParametro("nombreServidor");			
			RUTA_HTTP_SERVIDOR = iniFile.getParametro("rutaHTTPServidor")+NOMBRE_SERVIDOR+"/";
			APLICACION = iniFile.getParametro("aplicacion");
			PATH_ARCHIVOS = iniFile.getParametro("file.upload-dir"); 
			SERVIDOR_EXTERNO = iniFile.getParametro("file.upload-dir"); 
			
			HOST_SERVIDOR_EXTERNO = iniFile.getParametro("smtpHostservidorExterno");
			USUARIO_SERVIDOR_EXTERNO = iniFile.getParametro("usuarioCorreoServidorExterno");
			CLAVE_SERVIDOR_EXTERNO = iniFile.getParametro("claveCorreoServidorExterno");
			GETTRANSPORT_SERVIDOR_EXTERNO = iniFile.getParametro("getTransportservidorExterno");
			PORT_SERVIDOR_EXTERNO = iniFile.getParametro("portservidorExterno");
			
			String pmfClass = iniFile.getParametro("pmfClass");//com.triactive.jdo.PersistenceManagerFactoryImpl
			String driver = iniFile.getParametro("spring.datasource.driverClassName");//org.gjt.mm.mysql.Driver
			String url = iniFile.getParametro("spring.datasource.url");
			String userName = iniFile.getParametro("spring.datasource.username");
			String password = iniFile.getParametro("spring.datasource.password");
			String autoCreateTable = iniFile.getParametro("autoCreateTable");
			String validateConstraints = iniFile.getParametro("validateConstraints");
			String validateTables = iniFile.getParametro("validateTables");
			
			// Para configuracion TJDO
			Properties props_actual = new Properties();
			props_actual.setProperty("javax.jdo.PersistenceManagerFactoryClass",pmfClass);
			props_actual.setProperty("javax.jdo.option.ConnectionDriverName",driver);
			props_actual.setProperty("javax.jdo.option.ConnectionUserName", userName);
			props_actual.setProperty("javax.jdo.option.ConnectionPassword", password);
			props_actual.setProperty("com.triactive.jdo.autoCreateTables", autoCreateTable);			
			props_actual.setProperty("com.triactive.jdo.validateConstraints", validateConstraints);			
			props_actual.setProperty("com.triactive.jdo.validateTables", validateTables);	
			props_actual.setProperty("javax.jdo.option.ConnectionURL",url);
			
			
			// SETEO LOS VALORES DE LA CONECCION A LA BASE DE DATOS PARA SER USADOS EN LA EJECUCION DE QUERIES DIRECTAMENTE EN SQL
			Singleton.driver = driver;
			Singleton.url = url;
			Singleton.userName = userName;
			Singleton.password = password;

			// Get an instance of the PersistenceManagerFactory via JDOHelper.
			PersistenceManagerFactory pmf_actual =	JDOHelper.getPersistenceManagerFactory(props_actual);

			// Inicializa el OidGenerator
			OidGenerator.init(pmf_actual);

			// setear el SINGLETON
			Singleton.setPmf(pmf_actual);				
						
			//	Setea el valor semilla que usa el algoritmo de encriptacion			
			//server.general.Util.setString(Server.SEMILLA_ENCRIPTACION);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static final String getPathArchivos() {
		return PATH_ARCHIVOS;
	}
	
	/*public static final String getPathLogss() {
		return PATH_LOGS;
	}*/

	
		
}