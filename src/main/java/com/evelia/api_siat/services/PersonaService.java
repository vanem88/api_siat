package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.PersonaDto;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.repositories.PersonaRepository;
import com.evelia.api_siat.utils.MHelper;
import dataBase.PersonaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.evelia.api_siat.utils.ProcesosConArchivos;


@Service
public class PersonaService {
    private final static Logger logger = LoggerFactory.getLogger(PersonaService.class);
    @Autowired
    PersonaRepository personaRepository;
    
     
    @Value("${homeDir}"+"${pathFotos}")
    private String pathFoto;
   
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
    public boolean modificarPerfil(Long idPersona,String email,String fotoPerfil) {
    	try {
    		logger.info("Servicio: /modificarPerfil ");
    		logger.info("fotoPerfil: "+fotoPerfil);
    		fotoPerfil = fotoPerfil.replaceAll("/", "\\\\");  
    		logger.info("fotoPerfil: "+fotoPerfil);    		
    		String nombreArchivoViejo = fotoPerfil.substring(fotoPerfil.lastIndexOf("\\")+1, fotoPerfil.length());
    		logger.info("nombreArchivoViejo: "+nombreArchivoViejo);  		   		
    		PersonaImpl personaImpl = new PersonaImpl();   		
    		
    		PersonaEntity p = (PersonaEntity)personaImpl.find("select * from Persona where PERSONA_ID=?",  new Object[] {idPersona});
    		String nombreArchivoNuevo=p.getId().toString()+".png";	
    		
    		Object[] args = null;
    		String SQL_QUERY = "update Persona set ";
    		    		
    		if(email.compareTo("")!=0 && fotoPerfil.compareTo("")!=0) {
    			args = new Object[] {nombreArchivoNuevo,email,idPersona};
    			SQL_QUERY +=  "PATH_FOTO=? , EMAIL=? where PERSONA_ID=?";
    			if(ProcesosConArchivos.copiarArchivo(fotoPerfil,pathFoto)) {
    				logger.info("copie bien voy a reenombrar");
    				ProcesosConArchivos.renombrarArchivo(pathFoto+"\\\\"+nombreArchivoViejo,pathFoto+"\\\\"+nombreArchivoNuevo);
    			}
    		}else if(email.compareTo("")!=0) {
    			args = new Object[] {email,idPersona};
    			SQL_QUERY +=  "EMAIL=? where PERSONA_ID=?";
    		}else if(fotoPerfil.compareTo("")!=0){
    			args = new Object[] {nombreArchivoNuevo,idPersona};
    			SQL_QUERY +=  "PATH_FOTO=? where PERSONA_ID=?";
    			if(ProcesosConArchivos.copiarArchivo(fotoPerfil,pathFoto)) {
    				logger.info("copie bien voy a reenombrar");
    				ProcesosConArchivos.renombrarArchivo(pathFoto+"\\\\"+nombreArchivoViejo,pathFoto+"\\\\"+nombreArchivoNuevo);
    			}
    		}else
    			return false;
      		
      		return personaImpl.update(SQL_QUERY, args)>-1;      			              	      	        	
    	}catch(Exception ex){
    	    System.out.println("Exception modificarPerfil");
    		return false;
    	} 		          		
    }
}