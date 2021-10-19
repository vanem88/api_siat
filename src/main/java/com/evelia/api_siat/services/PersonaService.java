package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.PersonaDto;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.repositories.PersonaRepository;
import com.evelia.api_siat.utils.AssemblerObjetos;
import com.evelia.api_siat.utils.MHelper;

/*import persistencia.Persistencia;
import persistencia.dominio.AccesoPagina;
import persistencia.dominio.Persona;
import server.Control;
import server.Singleton;
*/
/*
import persistencia.OidGenerator;
import persistencia.Persistencia;
import persistencia.dominio.Persona;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PersonaService {
    private final static Logger logger = LoggerFactory.getLogger(PersonaService.class);
    @Autowired
    PersonaRepository personaRepository;
    
    static EntityManagerFactory pmf=null;
    static EntityManager manager = null;
    
    
    public PersonaDto obtenerPorId(Long id){
       logger.info(personaRepository.findById(id).get().getEmail());
       return MHelper.modelMapper().map(personaRepository.findById(id).get(),PersonaDto.class);
    }
    
    public String obtenerClaveEncriptada(String tipoDoc,String numeroDoc) { 
    	PersonaEntity personaEntity = personaRepository.findByTipoDocAndNumeroDoc(tipoDoc,numeroDoc);
    	return personaEntity.getPassword();    	
    }
    
    
  /*  public PersonaDto guardarUsuario(Persona personaJson) {
     	Persistencia persistencia  = new Persistencia();     	
    	try {
    		persistencia.crearTransaccion();
    		Persona persona = new Persona();  
    		System.out.println("id "+persona.getId() );
    		persona.setNombre(personaJson.getNombre());
    		persona.setEmail(personaJson.getEmail());
    		persona.setApellido(personaJson.getApellido());	 
    		persona.setLogin(personaJson.getLogin());
    		persona.setPassword(personaJson.getPassword());
    		persona.setNumeroDoc(personaJson.getNumeroDoc());
    		
    		persistencia.hacerPersistente(persona);
	    	System.out.println("hacerPersistente");
	    	PersonaDto p = new PersonaDto();
	    	p.setNombre(persona.getNombre());
	    	p.setEmail(persona.getEmail());
	    	p.setApellido(persona.getApellido());
	    	p.setPersonaId(persona.getId());  	
	    	System.out.println("commit");
	        persistencia.commit();	  
    		    		    		    	
	    	return p;
    	}catch(Exception e) {
    		System.out.println("rollback "+e.getMessage());
    		persistencia.rollback();
    		return null;
    	}
	}
    
    public boolean actualizarUsuario(Long idPersona,PersonaEntity personaJson) {    	
    	PersonaEntity p = (PersonaEntity)personaRepository.findById(idPersona).get();
    	p.setNombre(personaJson.getNombre());
    	p.setApellido(personaJson.getApellido());
    	personaRepository.saveAndFlush(p);
    	return true;    
	}*/
    

}