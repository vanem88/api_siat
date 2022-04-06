package server;

import java.util.*;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import persistencia.*;

@Component
public class Server{
		
	static public String PATH_ARCHIVOS = ""; 
	static public String PATH_LOGS = ""; 
	
	//@Value("${jdo.pmfClass}")
	private String pmfClass = "com.triactive.jdo.PersistenceManagerFactoryImpl";
	//@Value("${spring.datasource.driverClassName}")
	private String driver = "com.mysql.cj.jdbc.Driver";
	//@Value("${spring.datasource.url}")
	private String url ="jdbc:mysql://localhost:3306/datosEveliaMinimo?useUnicode=true&characterEncoding=utf8";
	//@Value("${spring.datasource.username}")
	private String userName ="root";
	//@Value("${spring.datasource.password}")
	private String password ="";
	//@Value("${jdo.autoCreateTable}")
	private String autoCreateTable = "true";	
	//@Value("${jdo.validateConstraints}")
	private String validateConstraints = "false";
	//@Value("${jdo.validateTables}")
	private String validateTables = "false";
	
	
	
	
		
	public Server(){
		try{
			
			System.out.println("FECHA y HORA del (RE)INICIO del SERVER ========> "+utils.Utils.hoySqlDate());
			System.out.println("HOME_DIR DE SINGLETON .................."+Singleton.HOME_DIR);
			System.out.println("DIR_ARCHIVOS DE SINGLETON........."+Singleton.DIR_ARCHIVOS);
			
			
				    	
	    	// Configuracion TJDO (Obteniendo datos del archivo de configuraci�n siatReloaded.ini)
			
			
			/*String pmfClass = iniFile.getParametro("pmfClass").trim();//com.triactive.jdo.PersistenceManagerFactoryImpl
			String driver = iniFile.getParametro("driver").trim();//org.gjt.mm.mysql.Driver
			String url = iniFile.getParametro("url").trim();
			String userName = iniFile.getParametro("userName").trim();
			String password = iniFile.getParametro("password").trim();
			String autoCreateTable = iniFile.getParametro("autoCreateTable").trim();
			String validateConstraints = iniFile.getParametro("validateConstraints").trim();
			String validateTables = iniFile.getParametro("validateTables").trim();*/
			
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
	
	public static final String getPathLogss() {
		return PATH_LOGS;
	}

	
		
}