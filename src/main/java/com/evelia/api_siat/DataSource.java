package com.evelia.api_siat;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {
    
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    
    static {
    	config.setJdbcUrl("jdbc:mysql://localhost:3306/datosEveliaMinimo?useUnicode=true&characterEncoding=utf8");
    	 config.setUsername("root");
         config.setPassword("");
    	
    	/*config.setJdbcUrl("jdbc:mysql://200.7.141.40:3306/siatreloaded2?useUnicode=true&characterEncoding=utf8");
    	config.setUsername("siatmovil");
        config.setPassword("wsMovil18");
    	*/
    	
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }
    
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    private DataSource(){}
}