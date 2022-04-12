package dataBase;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {

    private static HikariConfig config;
    private static HikariDataSource ds;

    static {
    	//config = new HikariConfig("/application.properties");
    	config = new HikariConfig("/datasource.properties");
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.addDataSourceProperty("maxLifetime", "300000");
        ds = new HikariDataSource( config );
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {  	
    		 return ds.getConnection();
    }
}