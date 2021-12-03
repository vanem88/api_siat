package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.PersonaDto;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.repositories.PersonaRepository;
import com.evelia.api_siat.utils.MHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PersonaService {
    private final static Logger logger = LoggerFactory.getLogger(PersonaService.class);
    @Autowired
    PersonaRepository personaRepository;
 
    public PersonaDto obtenerPorId(Long id){
       logger.info(personaRepository.findById(id).get().getEmail());
       return MHelper.modelMapper().map(personaRepository.findById(id).get(),PersonaDto.class);
    }
    
    public String obtenerClaveEncriptada(String tipoDoc,String numeroDoc) { 
    	PersonaEntity personaEntity = personaRepository.findByTipoDocAndNumeroDoc(tipoDoc,numeroDoc);
    	return personaEntity.getPassword();    	
    }
}