package com.evelia.api_siat.utils.assembler;

import java.sql.Timestamp;
import com.evelia.api_siat.dto.ActividadDto;
import com.evelia.api_siat.dto.CalificacionDto;
import com.evelia.api_siat.entity.ActividadEntity;
import com.evelia.api_siat.entity.AutoexamenEntity;
import com.evelia.api_siat.entity.AutoexamenFinalizadoEntity;
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
	
	//private final static Logger logger = LoggerFactory.getLogger(AssemblerCalificacion.class);
	 	      
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
    		actividadDto.setDetalles(Util.convert(str1));
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
    	  	calificacionDto.setTitulo(Util.convert(actividad.getDescripcion()));
    	  	
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
	    		if(docente!=null) {
	    		    calificacionDto.setAutorCalificacion(docente.getNombre()+" "+docente.getApellido());	
	    		    calificacionDto.setPathFotoAutorCalificacion(docente.getPathFoto());
		    		
	    			if(cai.getDevolucionTexto()!=null) {
			    		String str = new String(cai.getDevolucionTexto());
			    		calificacionDto.setDevolucioncalificacion(Util.convert(str));		    			
	    			}
	    			if(cai.getEstadoCalificacionByEstadoCalificacionId()!=null) 
	    				calificacionDto.setEstadoCalificacion(cai.getEstadoCalificacionByEstadoCalificacionId().getNombre());
	    			if(cai.getValorCalificacionByValorCalificacionId()!=null)
	    				calificacionDto.setCalificacion(cai.getValorCalificacionByValorCalificacionId().getNombre());	 
	    		}
    		}else{
    			if(fechaEntrega!=null)
    				calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.SIN_CALIFICAR);
    			else
    			    calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.NO_ENTREGO);    				
    		}
	  	    	
	    	PersonaEntity personaRealizoEntrega = nota.getPersonaByPersonaId();
	    	if(personaRealizoEntrega!=null) {	
		    	calificacionDto.setAlumno(personaRealizoEntrega.getNombre()+" "+personaRealizoEntrega.getApellido());
		    	calificacionDto.setPathFotoAlumno(personaRealizoEntrega.getPathFoto());
	    	}		    			     	
	    	
	    	return calificacionDto;
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return null;
		}	
    }
        
    /**
     * Convierte una ExamenFinalizado Entity en su respectivo DTO
     * @param ExamenFinalizadoEntity examenFinalizado
     * @return CalificacionDto 
    */
    public static CalificacionDto ExamenFinalizadoEntityToDto(ExamenFinalizadoEntity examenFinalizado) {
    	try {    		
		  	EvaluacionFinalizadaEntity evaluacionFinalizada = examenFinalizado.getEvaluacionFinalizadaConRespuestasByExamenFinalizadoId().getEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId();
		  	PersonaEntity alumno = evaluacionFinalizada.getPersonaByAlumnoId();
		  	if(alumno!=null) {
			  	EvaluacionEntity evaluacion = examenFinalizado.getEvaluacionFinalizadaConRespuestasByExamenFinalizadoId().getEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId().getEvaluacionByEvaluacionId();
	    	  	String nombreEvaluacion = evaluacion.getNombre();
	    	  	CalificacionDto calificacionDto = new CalificacionDto();
	    	  	calificacionDto.setTitulo(Util.convert(nombreEvaluacion));    	  	
	    	  	calificacionDto.setFechaEntrega(evaluacionFinalizada.getFechaRealizacion());
	    		calificacionDto.setFechaApertura(evaluacion.getFechaHoraInicio());
			    calificacionDto.setFechaCierre(evaluacion.getFechaHoraFin());			    	
			    calificacionDto.setAlumno(alumno.getNombre()+" "+alumno.getApellido());		
			    calificacionDto.setPathFotoAlumno(alumno.getPathFoto());	
			    
			   	if(examenFinalizado.getNotaFinal()<=0) {
		    		calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.SIN_CALIFICAR);
		    	}else {
		    		PersonaEntity autorCalificacion = examenFinalizado.getPersonaByPersonaId();
		    		if(autorCalificacion!=null) {
			    		calificacionDto.setAutorCalificacion(autorCalificacion.getNombre()+" "+autorCalificacion.getApellido());
			    		calificacionDto.setPathFotoAutorCalificacion(autorCalificacion.getPathFoto());
		    		}
		    		calificacionDto.setCalificacion(String.valueOf(examenFinalizado.getNotaFinal()));
		    		calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.CALIFICADO);	    		
		    	} 			
		    	return calificacionDto;
		  	}else
		  		return null;
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return null;
		}	
    }
    
    /**
     * Convierte una Nota Entity en su respectivo DTO
     * @param ExamenEntity examen
     * @return CalificacionDto 
    */
    public static CalificacionDto ExamenEntityToDto(ExamenEntity examen) {
    	try {   		
    		//El examen esta "no entregado"
    	  	EvaluacionEntity evaluacion = examen.getEvaluacionByExamenId();
    	  	if(evaluacion !=null) {
    	  		CalificacionDto calificacionDto = new CalificacionDto();
	    	  	String nombreEvaluacion = evaluacion.getNombre();
	    	  	calificacionDto.setTitulo(Util.convert(nombreEvaluacion));    	  	
	    	  	calificacionDto.setFechaApertura(evaluacion.getFechaHoraInicio());
			    calificacionDto.setFechaCierre(evaluacion.getFechaHoraFin());			    	
		    	return calificacionDto;
    	  	}else
    	  		return null;
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return null;
		}	
    }
    
    
    /**
     * Convierte un AutoExamenFinalizado Entity en su respectivo DTO
     * @param NotaEntity nota
     * @return CalificacionDto 
    */
    public static CalificacionDto AutoExamenFinalizadoEntityToDto(AutoexamenFinalizadoEntity examenFinalizado) {
    	try {    		
		  	EvaluacionFinalizadaEntity evaluacionFinalizada = examenFinalizado.getEvaluacionFinalizadaByAutoexamenFinalizadoId();
		   	EvaluacionEntity evaluacion = examenFinalizado.getEvaluacionFinalizadaByAutoexamenFinalizadoId().getEvaluacionByEvaluacionId();
		   	
		   	PersonaEntity alumno = evaluacionFinalizada.getPersonaByAlumnoId();
		   	if(alumno!=null) {
			   	String nombreEvaluacion = evaluacion.getNombre();
			   	CalificacionDto calificacionDto = new CalificacionDto();
	    	  	calificacionDto.setTitulo(Util.convert(nombreEvaluacion));    	  	
	    	  	calificacionDto.setFechaEntrega(evaluacionFinalizada.getFechaRealizacion());
	    		calificacionDto.setFechaApertura(evaluacion.getFechaHoraInicio());
			    calificacionDto.setFechaCierre(evaluacion.getFechaHoraFin());			    	
			    calificacionDto.setAlumno(alumno.getNombre()+" "+alumno.getApellido());		
			    calificacionDto.setPathFotoAlumno(alumno.getPathFoto());	
			    
			   	if(examenFinalizado.getNotaFinal()<=0) {
		    		calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.SIN_CALIFICAR);
		    	}else {
		    		calificacionDto.setAutorCalificacion(alumno.getNombre()+" "+alumno.getApellido());
			    	calificacionDto.setPathFotoAutorCalificacion(alumno.getPathFoto());
		    		calificacionDto.setCalificacion(String.valueOf(examenFinalizado.getNotaFinal()));
		    		calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.CALIFICADO);	    		
		    	} 
			   	return calificacionDto;
		   	}else
		   		return null;	    	
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return null;
		}	
    }
    
    /**
     * Convierte una Nota Entity en su respectivo DTO
     * @param NotaEntity nota
     * @return CalificacionDto 
    */
    public static CalificacionDto AutoExamenEntityToDto(AutoexamenEntity examen) {
    	try {   		    		  	  	
    		//El autoexamen esta "no entregado"
    	  	EvaluacionEntity evaluacion = examen.getEvaluacionByAutoexamenId();
    	  	if(evaluacion!=null) {
    	  		CalificacionDto calificacionDto = new CalificacionDto();
	    	  	String nombreEvaluacion = evaluacion.getNombre();
	    	  	calificacionDto.setTitulo(Util.convert(nombreEvaluacion));    	  	
	    	  	calificacionDto.setFechaApertura(evaluacion.getFechaHoraInicio());
			    calificacionDto.setFechaCierre(evaluacion.getFechaHoraFin());
			    return calificacionDto;
    	  	}else
    	  		return null;
    	}catch(Exception ex) {
    		System.out.println("Exception NotaEntityToDto");
    		return null;
		}	
    }


}