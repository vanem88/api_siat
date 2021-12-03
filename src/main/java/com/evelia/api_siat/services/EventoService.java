package com.evelia.api_siat.services;

import java.util.Collections;
import com.evelia.api_siat.dto.EventoDto;
import com.evelia.api_siat.entity.AulaEntity;
import com.evelia.api_siat.entity.ComisionEntity;
import com.evelia.api_siat.entity.ParticipanteEntity;
import com.evelia.api_siat.entity.PermisoAccesoEntity;
import com.evelia.api_siat.entity.TextoEntity;
import com.evelia.api_siat.repositories.AulaRepository;
import com.evelia.api_siat.repositories.ComisionRepository;
import com.evelia.api_siat.repositories.ParticipanteRepository;
import com.evelia.api_siat.repositories.PermisoAccesoRepository;
import com.evelia.api_siat.repositories.TextoRepository;
import com.evelia.api_siat.utils.assembler.*;
import com.evelia.api_siat.utils.Permisos;
import com.evelia.api_siat.utils.constantes.RECURSOS;
import com.evelia.api_siat.utils.constantes.TIPO_EVENTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class EventoService {
    private final static Logger logger = LoggerFactory.getLogger(EventoService.class);
    
    @Autowired
    TextoRepository textRepository;
    
    @Autowired
    AulaRepository aulaRepository;
    
    @Autowired
    Permisos permisos;
    
    @Autowired
    PermisoAccesoRepository permisoAccesoRepository;
    
    @Autowired
    ParticipanteRepository participanteRepository;
    
    @Autowired
    ComisionRepository comisionRepository;
    
    /**
     * Servicio que devuelve todos los eventos del aula a partir de una fecha
     * @param Long idAula
     * @param Long idPersona
     * @param Timestamp fechaDesde
     * @return Json List<Evento> (Todo lo del calendario.) 
    */
    public List<EventoDto> eventosAulaDesdeFecha(Long idAula, Long idPersona,Timestamp fechaDesde){
    	List<EventoDto> resultado = new ArrayList<EventoDto>();
    	try {
	        logger.info("Servicio: /eventosAulaDesdeFecha");
	        
	        if (!permisos.tienePermisoAula(idAula,idPersona,RECURSOS.CALENDARIO)) {
	        	logger.info("El usuario no tiene permiso para acceder al calendario del aula.");
	        	return null;
	        }
				  
	        //Buscar los eventos del calendario de un aula
	        AulaEntity aula = aulaRepository.findById(idAula).get();
	       	Long idCalendario = aula.getCalendarioId();
	    	if(idCalendario!=null) {	    	
	    		List<TextoEntity> eventosAula = textRepository.EventosDelCalendarioDisponibles(idCalendario,false,fechaDesde);
		    	for (TextoEntity evento: eventosAula) {    	
		    			//TextoDto eventoDto = AssemblerObjetos.EventoEntityToDto(evento);
		    		    EventoDto eventoDto = AssemblerComunicacion.EventoEntityToDto(evento);
						eventoDto.setTipoEventoNivel("E");//evento de aula
						resultado.add(eventoDto);					
		    	}
	    	}	    	
	    	
	    	//Buscar los eventos del calendario de la comision en las que participa el usuario
	    	List<ParticipanteEntity> participantes = participanteRepository.findByAulaIdAndPersonaId(idAula,idPersona); 
	    	if(participantes.size()>0) {
   				ParticipanteEntity participante = participantes.get(0);     	
   				List<ComisionEntity> comisiones = comisionRepository.findDistinctByParticipanteComisionsByComisionIdParticipanteIdAndAulaByComisionIdAulaCompuestaId(participante.getParticipanteId(), idAula);
   					
		    	//List<AulaEntity> comisiones = aulaRepository.findDistinctByAulaCompuestaId(idAula);	    
		    	//for (AulaEntity comision: comisiones) {
   				for (ComisionEntity comision: comisiones) {
		    		//if (permisos.tienePermisoComision(idAula,comision.getAulaId(),idPersona,RECURSOS.CALENDARIO)) {
   					List<PermisoAccesoEntity> permisos = permisoAccesoRepository.findByRecursoByRecursoIdNombreAndAulaIdAndTipoUsuarioId(RECURSOS.CALENDARIO, comision.getComisionId(), participante.getTipoUsuarioId());
   						
   					if(!permisos.isEmpty()) {
		    			//Long idCalendarioComision = comision.getCalendarioId();	    			
		   				Long idCalendarioComision = comision.getAulaByComisionId().getCalendarioId();
		    	    	if(idCalendarioComision!=null) {	    	
		    	    		List<TextoEntity> eventosComision = textRepository.EventosDelCalendarioDisponibles(idCalendarioComision,false,fechaDesde);
		    	    		for (TextoEntity eventoComision: eventosComision) {      		    						
		    		    		EventoDto eventoComisionDto = AssemblerComunicacion.EventoEntityToDto(eventoComision);
		    						eventoComisionDto.setTipoEventoNivel("EC");//evento de comision 
		    						resultado.add(eventoComisionDto);				    					
		    		    	}
		    	    	}		    	    	
		    		}
		    	}
	    	}
	    	
	    	//Buscar los eventos personales
	    	List<TextoEntity> eventosPersonales = textRepository.findByPersonaIdAndTipoEventoAndEliminadoAndFechaEventoAfterOrderByFechaDesc(idPersona,TIPO_EVENTO.PERSONALES, false, fechaDesde);
	    	for (TextoEntity eventoPersonal: eventosPersonales) {    		    						
	    		EventoDto eventoPersonalDto = AssemblerComunicacion.EventoEntityToDto(eventoPersonal);
					eventoPersonalDto.setTipoEventoNivel("EP");//evento personal 
					resultado.add(eventoPersonalDto);									
	    	}
	    	    	
	    	Collections.sort(resultado, new SortByDateEvento());  	   	
	    	    	
	    	return resultado;	       
	        
    	}catch(Exception ex) {
    		logger.error("Exception eventosAulaDesdeFecha: "+ex.getMessage());
    		return null;
    	}
     }
    
    /**
     * Permite ordenar los eventos por su fecha de creacion.
     */
    static class SortByDateEvento implements Comparator<EventoDto> {
        @Override
        public int compare(EventoDto a, EventoDto b) {
        	
        	if(b.getFechaEvento()!=null && a.getFechaEvento()!=null)
           	      return b.getFechaEvento().compareTo(a.getFechaEvento());
        	else if(b.getFechaEvento()==null)
        			return -1;
        		else
        			return 1;
        }
    }
    
    
    
   
    
  
}