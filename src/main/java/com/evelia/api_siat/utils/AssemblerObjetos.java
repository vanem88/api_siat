package com.evelia.api_siat.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.evelia.api_siat.dto.ActividadDto;
import com.evelia.api_siat.dto.CalificacionDto;
import com.evelia.api_siat.dto.ComentarioDto;
import com.evelia.api_siat.dto.EventoDto;
import com.evelia.api_siat.dto.ForoDto;
import com.evelia.api_siat.dto.MensajeDto;
import com.evelia.api_siat.dto.TextoDto;
import com.evelia.api_siat.entity.ActividadEntity;
import com.evelia.api_siat.entity.CalificacionActividadEntity;
import com.evelia.api_siat.entity.ComentarioEntity;
import com.evelia.api_siat.entity.EvaluacionEntity;
import com.evelia.api_siat.entity.EvaluacionFinalizadaEntity;
import com.evelia.api_siat.entity.ExamenEntity;
import com.evelia.api_siat.entity.ExamenFinalizadoEntity;
import com.evelia.api_siat.entity.ForoEntity;
import com.evelia.api_siat.entity.MensajeAdjuntosEntity;
import com.evelia.api_siat.entity.MensajeEntity;
import com.evelia.api_siat.entity.NotaEntity;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.entity.PublicacionEntity;
import com.evelia.api_siat.entity.TextoEntity;
import com.evelia.api_siat.repositories.MensajeAdjuntoRepository;
import com.evelia.api_siat.utils.constantes.TIPOS_CALIFICACION;

public class AssemblerObjetos {
	
	static Util util = new Util();
	
	
	 private final static Logger logger = LoggerFactory.getLogger(AssemblerObjetos.class);
	 
	 /**
	     * Convierte un objeto Entity en su respectivo DTO
	     * @param Persona persona
	     * @return Persona persona
	    */
	/*    public static PersonaDto PersonaToDto(Persona persona) {
	    	PersonaDto personaDto = new PersonaDto();    		
	    	personaDto.setApellido(persona.getApellido());
	    	personaDto.setEmail(persona.getEmail());
	    	personaDto.setNombre(persona.getNombre());
	    	personaDto.setPathFoto(persona.getPathFoto());
	    	personaDto.setPersonaId(persona.getId());    		   	
	    	return personaDto;
	    }*/

	/**
     * Convierte un objeto Entity en su respectivo DTO
     * @param TextoEntity evento
     * @return TextoDto evento
    */
    public static EventoDto EventoEntityToDto(TextoEntity evento) {
    	EventoDto eventoDto = new EventoDto();    		
    	eventoDto.setId(evento.getId());
    	eventoDto.setTitulo(util.convert(evento.getTitulo()));    	
    	String str = new String(evento.getContenido());
    	eventoDto.setContenido(util.convert(str));    	
    	eventoDto.setIdPersona(evento.getPersonaId());
    	if(evento.getPersonaByPersonaId() != null)
    		eventoDto.setNombreApellidoPersona(evento.getPersonaByPersonaId().getNombre() +" "+evento.getPersonaByPersonaId().getApellido());
    	else
    		eventoDto.setNombreApellidoPersona("");
    	eventoDto.setFechaCreacion(evento.getFecha());
    	//eventoDto.setFechaUltimaModificacion(evento.getf);    	
    	eventoDto.setEliminado(evento.isEliminado());
    	eventoDto.setTipoEvento(evento.getTipoEvento());
    	eventoDto.setFechaEvento(evento.getFechaEvento());
    	eventoDto.setFechaFinEvento(evento.getFechaFinEvento());
    	eventoDto.setGenerarAlerta(evento.isGenerarAlerta());
    	eventoDto.setIdEventoRepeticion(evento.getEventoRepeticionId());    	
    	if(evento.getArchivoByArchivoId() != null)
    		eventoDto.setPathArchivo(evento.getArchivoByArchivoId().getPath());
    	else
    		eventoDto.setPathArchivo(""); 
    	
    	eventoDto.setComentarios(ComentarioEntityToDto(evento.getComentariosByTextoId()));  	   	
    	return eventoDto;
    }
    
    /**
     * Convierte un objeto Entity en su respectivo DTO
     * @param TextoEntity evento
     * @return TextoDto evento
    */
    public static TextoDto NoticiaPizarronEntityToDto(TextoEntity evento) {
    	TextoDto eventoDto = new TextoDto();  
    	
    	eventoDto.setId(evento.getId());
    	eventoDto.setTitulo(util.convert(evento.getTitulo()));    	
    	String str = new String(evento.getContenido());
    	eventoDto.setContenido(util.convert(str));    	
    	eventoDto.setIdPersona(evento.getPersonaId());
    	if(evento.getPersonaByPersonaId() != null)
    		eventoDto.setNombreApellidoPersona(evento.getPersonaByPersonaId().getNombre() +" "+evento.getPersonaByPersonaId().getApellido());
    	else
    		eventoDto.setNombreApellidoPersona("");
    	eventoDto.setFechaCreacion(evento.getFecha());
    	//eventoDto.setFechaUltimaModificacion(evento.);    	
    	   	
    	if(evento.getArchivoByArchivoId() != null)
    		eventoDto.setPathArchivo(evento.getArchivoByArchivoId().getPath());
    	else
    		eventoDto.setPathArchivo("");
    	
    	eventoDto.setComentarios(ComentarioEntityToDto(evento.getComentariosByTextoId()));   	
    	    	
    	return eventoDto;
    }
    
    
    /**
     * Convierte una coleccion de ComentariosEntity en ComentariosDTo
     * @param Collection<ComentarioEntity> comentariosEntity
     * @return Collection<ComentarioDto> 
    */
    public static Collection<ComentarioDto> ComentarioEntityToDto(Collection<ComentarioEntity> comentariosEntity) {
    	Collection<ComentarioDto> comentarios = new ArrayList<ComentarioDto>();
    	try {	
    	   	for (ComentarioEntity comentarioEntity: comentariosEntity) { 
	    		if(comentarioEntity.getComentPadreId()==null) {
	    			ComentarioDto coment = new ComentarioDto();
		    		String str1 = new String(comentarioEntity.getContenido());
		    		coment.setContenido(util.convert(str1));
		    		coment.setFecha(comentarioEntity.getFecha());
		    		coment.setNombreApellidoPersona(comentarioEntity.getPersonaByPersonaId().getNombre()+" "+comentarioEntity.getPersonaByPersonaId().getApellido());
		    		comentarios.add(coment);
	    		}	    		
	    	}    		    	
    	}catch(Exception ex) {
    		return null;
		}	    	
    	return comentarios;
    }
    
    
    
    
    /**
     * Convierte un foro Entity en su respectivo DTO
     * @param ForoEntity foro
     * @return ForoDto foro
    */
    public static ForoDto ForoEntityToDto(ForoEntity foro,MensajeAdjuntoRepository mensajeAdjuntoRepository) {
    	
    	try {
	    	ForoDto foroDto = new ForoDto();   
	    
	    	foroDto.setAsunto(util.convert(foro.getAsunto()));
	    	foroDto.setFechaCreacion(foro.getFecha());
	    	foroDto.setFechaDesde(foro.getPublicacionByPublicacionId().getFechaApertura());
	    	foroDto.setFechaHasta(foro.getPublicacionByPublicacionId().getFechaCierre());
	    	   	   	
	    	Collection<MensajeDto> mensajes = new ArrayList<MensajeDto>();
	    	Collection<MensajeEntity> mensajesEntity = foro.getMensajesByForoId();
	    	for (MensajeEntity mensajeEntity: mensajesEntity) { 
	    		if(mensajeEntity.getMensajeByMsjPadreId()==null & mensajeEntity.getTitulo()==null) {
	    			MensajeAdjuntosEntity archivoAdjunto = mensajeAdjuntoRepository.findByMensajeId(mensajeEntity.getMensajeId());
	    			if(archivoAdjunto!=null && archivoAdjunto.getArchivoByArchivoId()!=null)
		    			foroDto.setPathArchivo(archivoAdjunto.getArchivoByArchivoId().getPath());
	    		}
	    		if(mensajeEntity.getMensajeByMsjPadreId()==null & mensajeEntity.getTitulo()!=null) {
	    			MensajeDto mens = new MensajeDto();
		    		String str1 = new String(mensajeEntity.getContenido());
		    		mens.setContenido(util.convert(str1));
		    		mens.setFecha(mensajeEntity.getFecha());
		    		mens.setPersona(mensajeEntity.getPersonaByPersonaId().getNombre()+" "+mensajeEntity.getPersonaByPersonaId().getApellido());
		    		mens.setMensajes(MensajeEntityToDTo(mensajeEntity.getMensajesByMensajeId()));

		    		MensajeAdjuntosEntity archivoAdjunto = mensajeAdjuntoRepository.findByMensajeId(mensajeEntity.getMensajeId());
		    		if(archivoAdjunto!=null && archivoAdjunto.getArchivoByArchivoId()!=null)
		    			mens.setPathArchivo(archivoAdjunto.getArchivoByArchivoId().getPath());
		    		mensajes.add(mens);
	    		}	    		
	    	}     	
	    	foroDto.setMensajes(mensajes);    	
	    	return foroDto;
    	}catch(Exception ex) {
    		
    		return null;
		}	
    }
    
    /**
     * Convierte un actividad Entity en su respectivo DTO
     * @param ForoEntity foro
     * @return ForoDto foro
    */
    public static ActividadDto ActividadEntityToDto(ActividadEntity actividad) {
    	try {
    		ActividadDto actividadDto = new ActividadDto();  
    		
    		PublicacionEntity publicacion = actividad.getPublicacionByPublicacionId();    		
    		actividadDto.setAulaId(actividad.getAulaId());
    		actividadDto.setBorrador(actividad.isBorrador());
    		actividadDto.setDescripcion(actividad.getDescripcion());
    		String str1 = new String(actividad.getDetalles());
    		actividadDto.setDetalles(util.convert(str1));
    		actividadDto.setFechaApertura(publicacion.getFechaApertura());
    		actividadDto.setFechaCierre(publicacion.getFechaCierre());
    		actividadDto.setPersonaId(actividad.getPersonaId());
    		
	    	return actividadDto;
    	}catch(Exception ex) {
    		return null;
		}	
    }
    
    /**
     * Convierte una coleccion de mensajesEntity en su respectiva coleccion de mensajesDTO
     * @param Collection<MensajeEntity> mensajesHijos
     * @return Collection<MensajeDto>
    */
    private static  Collection<MensajeDto> MensajeEntityToDTo(Collection<MensajeEntity> mensajesHijos){
    	Collection<MensajeDto> mensajes = new ArrayList<MensajeDto>();
    	for (MensajeEntity mensajeEntity: mensajesHijos) { 
    		try {
	    		MensajeDto mens = new MensajeDto();
	    		String str1 = new String(mensajeEntity.getContenido());
	    		mens.setContenido(util.convert(str1));
	    		mens.setFecha(mensajeEntity.getFecha());
	    		mens.setPersona(mensajeEntity.getPersonaByPersonaId().getNombre()+" "+mensajeEntity.getPersonaByPersonaId().getApellido());
	    		mens.setMensajes(MensajeEntityToDTo(mensajeEntity.getMensajesByMensajeId()));
	    		mensajes.add(mens);
	    	}catch(Exception ex) {}	
    	}  	    	
    	return mensajes;
    }
    
    /**
     * Convierte una Nota Entity en su respectivo DTO
     * @param NotaEntity nota
     * @return CalificacionDto 
    */
    public static CalificacionDto NotaEntityToDto(NotaEntity nota) {
    	try {
    		
    	  	CalificacionDto calificacionDto = new CalificacionDto();
    	  	ActividadEntity actividad = nota.getActividadByActividadId();
    	  	calificacionDto.setTitulo(util.convert(actividad.getDescripcion()));
    	  	
    	  	Timestamp fechaEntrega = nota.getFecha();
    	  	calificacionDto.setFechaEntrega(fechaEntrega);
    		    		    		   		    		
	    	try {
	    		PublicacionEntity publicacion = (PublicacionEntity)actividad.getPublicacionByPublicacionId();		    		    	  	
		    	calificacionDto.setFechaApertura(publicacion.getFechaApertura());
		    	calificacionDto.setFechaCierre(publicacion.getFechaCierre());			    	
	    	}catch(Exception ex) {
	    		System.out.println("Exception publicacion");
	    	}
	    	
	    	//Devolucion - Estado - Nota de actividad individual	    	
	    	CalificacionActividadEntity cai = nota.getCalificacionActividadByCalificacionIndividualId(); 
	    	if(cai!=null) { 
	    		//Docente que califico la actividad
	    		PersonaEntity docente = (PersonaEntity)cai.getPersonaByAutorCalificacionId();
	    		//if(docente!=null)
    		    calificacionDto.setAutorCalificacion(docente.getNombre()+" "+docente.getApellido());	
	    		
    			if(cai.getDevolucionTexto()!=null) {
		    		String str = new String(cai.getDevolucionTexto());
		    		calificacionDto.setDevolucioncalificacion(util.convert(str));		    			
    			}
    			if(cai.getEstadoCalificacionByEstadoCalificacionId()!=null) 
    				calificacionDto.setEstadoCalificacion(cai.getEstadoCalificacionByEstadoCalificacionId().getNombre());
    			if(cai.getValorCalificacionByValorCalificacionId()!=null)
    				calificacionDto.setCalificacion(cai.getValorCalificacionByValorCalificacionId().getNombre());	    		
    		}else{
    			if(fechaEntrega!=null)
    				calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.SIN_CALIFICAR);
    			else
    			    calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.NO_ENTREGO);    				
    		}
	  	    	
	    	//PersonaEntity personaRealizoEntrega = nota.getPersonaRealizoEntregaByPersonaRealizoEntregaId();	    
	    	PersonaEntity personaRealizoEntrega = nota.getPersonaByPersonaId();
	    	if(personaRealizoEntrega!=null) {	
		    	calificacionDto.setPersonaRealizoEntrega(personaRealizoEntrega.getNombre()+" "+personaRealizoEntrega.getApellido());				    	
	    	}else System.out.println("personaRealizoEntrega null ");
		    			     	
	    	
	    	return calificacionDto;
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return null;
		}	
    }
    
    
    /**
     * Convierte una ExamenFinalizado Entity en su respectivo DTO
     * @param NotaEntity nota
     * @return CalificacionDto 
    */
    public static CalificacionDto ExamenFinalizadoEntityToDto(ExamenFinalizadoEntity examenFinalizado) {
    	CalificacionDto calificacionDto = new CalificacionDto();
    	try {    		
		  	EvaluacionFinalizadaEntity evaluacionFinalizada = examenFinalizado.getEvaluacionFinalizadaConRespuestasByExamenFinalizadoId().getEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId();
    	  	EvaluacionEntity evaluacion = examenFinalizado.getEvaluacionFinalizadaConRespuestasByExamenFinalizadoId().getEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId().getEvaluacionByEvaluacionId();
    	  	String nombreEvaluacion = evaluacion.getNombre();
    	  	calificacionDto.setTitulo(util.convert(nombreEvaluacion));    	  	
    	  	calificacionDto.setFechaEntrega(evaluacionFinalizada.getFechaRealizacion());
    		calificacionDto.setFechaApertura(evaluacion.getFechaHoraInicio());
		    calificacionDto.setFechaCierre(evaluacion.getFechaHoraFin());			    	
		    calificacionDto.setPersonaRealizoEntrega(evaluacionFinalizada.getPersonaByAlumnoId().getNombre()+" "+evaluacionFinalizada.getPersonaByAlumnoId().getApellido());		
	  	   		
		    logger.info("nota"+examenFinalizado.getNotaFinal());
	    	if(examenFinalizado.getNotaFinal()<=0) {
	    		logger.info("sin nota ");
	    		calificacionDto.setAutorCalificacion("");
	    		calificacionDto.setCalificacion("");
	    		calificacionDto.setDevolucioncalificacion("");
	    		calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.SIN_CALIFICAR);
	    	}else {
	    		calificacionDto.setAutorCalificacion(examenFinalizado.getPersonaByPersonaId().getNombre()+" "+examenFinalizado.getPersonaByPersonaId().getApellido());
	    		calificacionDto.setCalificacion(String.valueOf(examenFinalizado.getNotaFinal()));
	    		calificacionDto.setEstadoCalificacion(examenFinalizado.getEvaluacionFinalizadaConRespuestasByExamenFinalizadoId().getEstadoEx());
	    		//calificacionDto.setDevolucioncalificacion("");
	    	}
	    		
	    		
	    	
	    			    	
    				    			
    		
	   	
	    	return calificacionDto;
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return calificacionDto;
		}	
    }
    
    /**
     * Convierte una Nota Entity en su respectivo DTO
     * @param NotaEntity nota
     * @return CalificacionDto 
    */
    public static CalificacionDto ExamenEntityToDto(ExamenEntity examen) {
    	CalificacionDto calificacionDto = new CalificacionDto();
    	try {   		
    		  	  	
    	  	EvaluacionEntity evaluacion = examen.getEvaluacionByExamenId();
    	  	String nombreEvaluacion = evaluacion.getNombre();
    	  	calificacionDto.setTitulo(util.convert(nombreEvaluacion));
    	  	
    	  	calificacionDto.setFechaApertura(evaluacion.getFechaHoraInicio());
		    calificacionDto.setFechaCierre(evaluacion.getFechaHoraFin());			    	
	    	calificacionDto.setAutorCalificacion("");	
	    	calificacionDto.setCalificacion("");	    	
	    	calificacionDto.setPersonaRealizoEntrega("");		
	  	    calificacionDto.setDevolucioncalificacion("");		    			
    		    	    			     	
	    	
	    	return calificacionDto;
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return calificacionDto;
		}	
    }
    
    


}