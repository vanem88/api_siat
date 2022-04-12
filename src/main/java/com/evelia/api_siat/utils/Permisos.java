package com.evelia.api_siat.utils;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evelia.api_siat.entity.ParticipanteEntity;
import com.evelia.api_siat.entity.PermisoAccesoEntity;
import com.evelia.api_siat.repositories.ParticipanteComisionRepository;
import com.evelia.api_siat.repositories.ParticipanteRepository;
import com.evelia.api_siat.repositories.PermisoAccesoRepository;

@Service
public class Permisos {
	
	 private final static Logger logger = LoggerFactory.getLogger(Permisos.class);
	 
	  @Autowired
	  ParticipanteRepository participanteRepository;
	  
	  @Autowired
	  ParticipanteComisionRepository participanteComisionRepository;
    
      @Autowired
      PermisoAccesoRepository permisoAccesoRepository;
      
    
       /**
     * Controla si el usuario tiene permiso para acceder a un recurso en un aula,
     * @param Long idAula, Long idPersona, String recurso
     * @return boolean
    */
    public boolean tienePermisoAula(Long idAula, Long idPersona, String recurso) {
 	   try {
     			
   			List<ParticipanteEntity> participantes = participanteRepository.findByAulaIdAndPersonaId(idAula,idPersona);
   			if(participantes.size()>0) {
   				ParticipanteEntity participante = participantes.get(0);	   			
	   			if (participante != null & participante.getTipoUsuarioByTipoUsuarioId() == null)
	   				return false;
	   			List<PermisoAccesoEntity> permisos = permisoAccesoRepository.findByRecursoByRecursoIdNombreAndAulaIdAndTipoUsuarioId(recurso, idAula, participante.getTipoUsuarioId());
	   			if(permisos.isEmpty()) return false;
	  	  	   	   		    
   			}else
   				return false;
   		   
   		   return true;
   		   
   	  } catch (Exception e) {
   		logger.error("Exception tienePermisoAula: "+e.getMessage());
   		return false;
   	  }
	    
    }
    
    /**
     * Retorna si el usuario tiene permiso para acceder a un recurso en una comision,
     * @param Long idAula
     * @param Long idPersona
     * @param String recurso
     * @return boolean
    */
    public boolean tienePermisoComision(ParticipanteEntity participante, Long idComision, String recurso) {
 	   try {
 		   List<PermisoAccesoEntity> permisos = permisoAccesoRepository.findByRecursoByRecursoIdNombreAndAulaIdAndTipoUsuarioId(recurso, idComision, participante.getTipoUsuarioId());
		   if(permisos.isEmpty()) return false;			  	  	   		   	 		   		    
		   return true;
   		   
   	   }catch (Exception e) {
   		   logger.error("Exception tipoPermiso: "+e.getMessage());
   		   return false;
   	   }
	}
	    
	    
	 
}