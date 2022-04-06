package com.evelia.api_siat.services;

//import com.example.filedemo.exception.FileStorageException;
//import com.example.filedemo.exception.MyFileNotFoundException;
//import com.example.filedemo.property.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.evelia.api_siat.property.FileStorageProperties;
//import java.io.IOException;
//import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
    	//this.fileStorageLocation  = Paths.get(fileStorageProperties.getUploadDir()+fileStorageProperties.getPhotoDir()).toAbsolutePath().normalize();
    	this.fileStorageLocation  = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
    	
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        	throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file,String path)  {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                //throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            	throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(path+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (Exception ex) {
            //throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        	throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);        	
        }
    }
    
    
    /*
     * Sube un archivo al servidor
     * */
    public boolean subirArchivo(MultipartFile archivo,String path) {
    	try {
	    	//String fileName = this.fileStorageService.storeFile(archivo,path);
    		String fileName = this.storeFile(archivo,path);
	        @SuppressWarnings("unused")
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();
	        return true;
    	}catch(Exception ex){
    		return false;
    	}        
    }

    /*public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }*/
}

/*
 * Ejemplo https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
 * */
 