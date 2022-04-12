package com.evelia.api_siat;


import javax.servlet.MultipartConfigElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;


@SpringBootApplication
public class ApiSiatApplication extends SpringBootServletInitializer  {
		
	//Para generar el war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApiSiatApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiSiatApplication.class, args);
	}
	
	//Para permitir subir archivos mas grandes
	@Bean  
	public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES)); // 100MB
    	factory.setMaxRequestSize(DataSize.of(100, DataUnit.MEGABYTES));// 100MB      
        return factory.createMultipartConfig();  
    }  
	

}
