package com.evelia.api_siat.utils.assembler;

import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.evelia.api_siat.dto.ActividadDto;
import com.evelia.api_siat.dto.CalificacionDto;
import com.evelia.api_siat.entity.ActividadEntity;
import com.evelia.api_siat.entity.CalificacionActividadEntity;
import com.evelia.api_siat.entity.EvaluacionEntity;
import com.evelia.api_siat.entity.EvaluacionFinalizadaEntity;
import com.evelia.api_siat.entity.ExamenEntity;
import com.evelia.api_siat.entity.ExamenFinalizadoEntity;
import com.evelia.api_siat.entity.NotaEntity;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.entity.PublicacionEntity;
import com.evelia.api_siat.utils.Util;
import com.evelia.api_siat.utils.constantes.TIPOS_CALIFICACION;

public class AssemblerCalificacion {
	
	static Util util = new Util();
	
	
    private final static Logger logger = LoggerFactory.getLogger(AssemblerCalificacion.class);
	 	      
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
    		if(actividad.getPersonaByPersonaId()!=null) {
    			actividadDto.setPersona(actividad.getPersonaByPersonaId().getNombre()+" "+actividad.getPersonaByPersonaId().getApellido());
    			actividadDto.setPathFotoPerfil(actividad.getPersonaByPersonaId().getPathFoto());
    		}
    		
    		
	    	return actividadDto;
    	}catch(Exception ex) {
    		return null;
		}	
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
    		    calificacionDto.setPathFotoAutorCalificacion(docente.getPathFoto());
	    		
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
		    	calificacionDto.setPathFotoPersonaRealizoEntrega(personaRealizoEntrega.getPathFoto());
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
		    calificacionDto.setPathFotoPersonaRealizoEntrega(evaluacionFinalizada.getPersonaByAlumnoId().getPathFoto());	
		    
		    logger.info("nota"+examenFinalizado.getNotaFinal());
	    	if(examenFinalizado.getNotaFinal()<=0) {
	    		logger.info("sin nota ");
	    		calificacionDto.setAutorCalificacion("");
	    		calificacionDto.setCalificacion("");
	    		calificacionDto.setDevolucioncalificacion("");
	    		calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.SIN_CALIFICAR);
	    	}else {
	    		calificacionDto.setAutorCalificacion(examenFinalizado.getPersonaByPersonaId().getNombre()+" "+examenFinalizado.getPersonaByPersonaId().getApellido());
	    		calificacionDto.setPathFotoAutorCalificacion(examenFinalizado.getPersonaByPersonaId().getPathFoto());
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
	    	calificacionDto.setPathFotoAutorCalificacion("");
	    	calificacionDto.setCalificacion("");	    	
	    	calificacionDto.setPersonaRealizoEntrega("");	
	    	calificacionDto.setPathFotoPersonaRealizoEntrega("");
	  	    calificacionDto.setDevolucioncalificacion("");		    			
    		    	    			     	
	    	
	    	return calificacionDto;
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return calificacionDto;
		}	
    }
    
    


}