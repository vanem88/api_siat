package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.PersonaDto;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.repositories.PersonaRepository;
import com.evelia.api_siat.utils.MHelper;
import dataBase.PersonaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.evelia.api_siat.utils.ProcesosConArchivos;


@Service
public class PersonaService {
    private final static Logger logger = LoggerFactory.getLogger(PersonaService.class);
    @Autowired
    PersonaRepository personaRepository;
    
    @Autowired
    FileStorageService fileStorageService;
    
     
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
    		
    		PersonaEntity p = (PersonaEntity)personaImpl.find("select * from Persona where PERSONA_ID=?",  new Object[] {idPersona});
    		String nombreArchivoNuevo=p.getId().toString()+".png";	
    		
    		Object[] args = null;
    		String SQL_QUERY = "update Persona set ";
    		    		
    		if(email.compareTo("")!=0 && fotoPerfil!=null) {
    			args = new Object[] {nombreArchivoNuevo,email,idPersona};
    			SQL_QUERY +=  "PATH_FOTO=? , EMAIL=? where PERSONA_ID=?";
    			if(fileStorageService.subirArchivo(fotoPerfil,pathSoloFoto)) 
    				ProcesosConArchivos.renombrarArchivo(pathFoto+"\\"+fotoPerfil.getOriginalFilename(),pathFoto+"\\"+nombreArchivoNuevo);    			
    		}else if(email.compareTo("")!=0) {
    			args = new Object[] {email,idPersona};
    			SQL_QUERY +=  "EMAIL=? where PERSONA_ID=?";
    		}else if(fotoPerfil!=null){
    			args = new Object[] {nombreArchivoNuevo,idPersona};
    			SQL_QUERY +=  "PATH_FOTO=? where PERSONA_ID=?";
    			if(fileStorageService.subirArchivo(fotoPerfil,pathSoloFoto)) 
    				ProcesosConArchivos.renombrarArchivo(pathFoto+"\\\\"+fotoPerfil.getOriginalFilename(),pathFoto+"\\\\"+nombreArchivoNuevo);
    		}else
    			return "No se envió ni el email ni la foto de perfil a modificar del usuario."; 		
      		
    		if(personaImpl.update(SQL_QUERY, args)>-1)
    			return "Actualización realizada con exito.";
    		else
    			return "No se pudo actualizar los datos del usuario.";      			              	      	        	
    	}catch(Exception ex){
    	   	return "Exception: "+ex.getMessage();
    	} 		          		
    }
    
   
}