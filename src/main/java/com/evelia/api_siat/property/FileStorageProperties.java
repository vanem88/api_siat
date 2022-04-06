package com.evelia.api_siat.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;
  
    public String getUploadDir() {
        return uploadDir;
    }
  

    //lee file.upload-dir de application.properties
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
    
   
}