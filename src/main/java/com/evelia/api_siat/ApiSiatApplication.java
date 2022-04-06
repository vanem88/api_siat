package com.evelia.api_siat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.evelia.api_siat.property.FileStorageProperties;

@SpringBootApplication
//Para trabajar con archivo
@EnableConfigurationProperties({
        FileStorageProperties.class
})


public class ApiSiatApplication extends SpringBootServletInitializer  {
	
	//Para generar el war
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApiSiatApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiSiatApplication.class, args);
	}

}
