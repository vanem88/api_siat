package dataBase;

import java.sql.Connection;
import java.sql.SQLException;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;

import java.sql.DriverManager;
import org.springframework.beans.factory.annotation.Value;


@SuppressWarnings("deprecation")
public class DataSource {
	
	 @Value("${spring.datasource.url}")
	    private static String url;

	    @Value("${spring.datasource.username}")
	    private static String username;
	    
	    @Value("${spring.datasource.password}")
	    private static String password;
	
    
   // private static HikariConfig config = new HikariConfig();
  //  private static HikariDataSource ds;
    
    static {
	 /*  config = new HikariConfig("/application.properties");
	   
	   config.addDataSourceProperty( "cachePrepStmts" , "true" );
       config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
       config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
       config.addDataSourceProperty( "maxLifetime" , "150000" );//( 300000 5 minutes)
                 
	   ds = new HikariDataSource(config);
    	*/
	// CARGAR EL CONTROLADOR DE BD
	  try {
		  System.out.println("REGISTER DRIVER...");
	      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	  }catch (Exception e){
		  System.out.println("Exception registracion driver");
	  }    	
    }
	
	    
    public static Connection getConnection() throws SQLException {
     //   return ds.getConnection();
    	
        Connection con = null;
        try {
           	//url="jdbc:mysql://localhost:3306/datosEveliaMinimo?useUnicode=true&characterEncoding=utf8";
           	//username="root";
           	//password="";
        	con = DriverManager.getConnection(url,username,password);
        	
        } catch (Exception e) {
            System.out.println("[SqlServerConexion] Error al obtener la conexión");
            e.printStackTrace();
        }
        return con;        
    }
  
}