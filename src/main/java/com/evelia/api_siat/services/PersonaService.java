package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.PersonaDto;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.repositories.PersonaRepository;
import com.evelia.api_siat.utils.MHelper;
import dataBase.PersonaImpl;
import persistencia.dominio.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.evelia.api_siat.utils.ProcesosConArchivos;


@Service
public class PersonaService {
    private final static Logger logger = LoggerFactory.getLogger(PersonaService.class);
    @Autowired
    PersonaRepository personaRepository;
    
    @Value("${file.upload-dir}"+"${file.photo-dir}")
    private String pathFoto;
    
    @Value("${file.photo-dir}")
    private String pathSoloFoto;
   
    public PersonaDto obtenerPorId(Long id){
       logger.info("Servicio: /obtenerUsuarioPorId");
       return MHelper.modelMapper().map(personaRepository.findById(id).get(),PersonaDto.class);
    }
    
    public String obtenerClaveEncriptada(String tipoDoc,String numeroDoc) { 
    	PersonaEntity personaEntity = personaRepository.findByTipoDocAndNumeroDoc(tipoDoc,numeroDoc);
    	return personaEntity.getPassword();    	
    }
    
    /*
     * Dado el id de la persona modifica su foto de perfil y su correo electronico
     * */
    public String modificarPerfil(Long idPersona,String email,MultipartFile fotoPerfil) {
    	try {
    		logger.info("Servicio: /modificarPerfil ");
    		PersonaImpl personaImpl = new PersonaImpl();  
    		PersonaEntity p = (PersonaEntity)personaImpl.find("select * from PERSONA where PERSONA_ID=?",  new Object[] {idPersona});
    		if(p!=null) {
    	   		String nombreArchivoNuevo=p.getId().toString()+".png";	
	    		Object[] args = null;
	    		String SQL_QUERY_Email = "select * from PERSONA where EMAIL=?";
	    		String SQL_QUERY = "update PERSONA set ";
	    		
	    		String regex = "^(.+)@(.+)$";    		 
	    		Pattern pattern = Pattern.compile(regex);
	     		
	    		if(email.compareTo("")!=0 && fotoPerfil.getOriginalFilename().compareTo("")!=0) {
	    			PersonaEntity persConEmail = (PersonaEntity)personaImpl.find(SQL_QUERY_Email, new Object[] {email});
	    			if(persConEmail!=null) return "El email de usuario ingresado esta en uso, use otro email."; 
	    			Matcher matcher = pattern.matcher(email);
	    			if(!matcher.matches()) return "Formato del email incorrecto";    			
	    			args = new Object[] {nombreArchivoNuevo,email,idPersona};
	    			SQL_QUERY +=  "PATH_FOTO=? , EMAIL=? where PERSONA_ID=?";
	    			File localFile = new File(pathFoto+"/"+fotoPerfil.getOriginalFilename());
	                fotoPerfil.transferTo(localFile);
	                ProcesosConArchivos.renombrarArchivo(pathFoto+fotoPerfil.getOriginalFilename(),pathFoto+nombreArchivoNuevo);	    			    			
	    		}else if(email.compareTo("")!=0) {
	    			PersonaEntity persConEmail = (PersonaEntity)personaImpl.find(SQL_QUERY_Email, new Object[] {email});
	    			if(persConEmail!=null) return "El email de usuario ingresado esta en uso, use otro email."; 
	    			Matcher matcher = pattern.matcher(email);
	    			if(!matcher.matches()) return "Formato del email incorrecto";    
	    			args = new Object[] {email,idPersona};
	    			SQL_QUERY +=  "EMAIL=? where PERSONA_ID=?";
	    		}else if(fotoPerfil.getOriginalFilename().compareTo("")!=0){
	    			args = new Object[] {nombreArchivoNuevo,idPersona};
	    			SQL_QUERY +=  "PATH_FOTO=? where PERSONA_ID=?";
	    			File localFile = new File(pathFoto+"/"+fotoPerfil.getOriginalFilename());
	                fotoPerfil.transferTo(localFile);
	                ProcesosConArchivos.renombrarArchivo(pathFoto+fotoPerfil.getOriginalFilename(),pathFoto+nombreArchivoNuevo);
	    		}else
	    			return "No se envió ni el email ni la foto de perfil a modificar del usuario."; 		
	      		
	    		if(personaImpl.update(SQL_QUERY, args)>-1)
	    			return "Actualización realizada con exito.";
	    		else
	    			return "No se pudo actualizar los datos del usuario.";   
    		}else
    			return "No se encuentra el usuario "+idPersona+" en la base de datos.";
    	}catch(Exception ex){
    	   	return "Exception: "+ex.getMessage();
    	} 		          		
    }
    
   
}