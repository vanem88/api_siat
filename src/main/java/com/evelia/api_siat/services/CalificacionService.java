package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.ActividadDto;
import com.evelia.api_siat.dto.ArchivoDto;
import com.evelia.api_siat.dto.AulaCompuestaDto;
import com.evelia.api_siat.dto.CalificacionDto;
import com.evelia.api_siat.dto.CarpetaDto;
import com.evelia.api_siat.dto.ForoDto;
import com.evelia.api_siat.dto.TextoDto;
import com.evelia.api_siat.entity.ActividadArchivosAdjuntosEntity;
import com.evelia.api_siat.entity.ActividadEntity;
import com.evelia.api_siat.entity.ArchivoEntity;
import com.evelia.api_siat.entity.AulaCompuestaEntity;
import com.evelia.api_siat.entity.AulaEntity;
import com.evelia.api_siat.entity.CarpetaEntity;
import com.evelia.api_siat.entity.ComisionEntity;
import com.evelia.api_siat.entity.EvaluacionEntity;
import com.evelia.api_siat.entity.ExamenEntity;
import com.evelia.api_siat.entity.ExamenFinalizadoEntity;
import com.evelia.api_siat.entity.ForoEntity;
import com.evelia.api_siat.entity.MaterialEntity;
import com.evelia.api_siat.entity.NotaEntity;
import com.evelia.api_siat.entity.ParticipanteEntity;
import com.evelia.api_siat.entity.PermisoAccesoEntity;
import com.evelia.api_siat.entity.TextoEntity;
import com.evelia.api_siat.entity.TipoUsuarioEntity;
import com.evelia.api_siat.repositories.ActividadArchivosAdjuntosRepository;
import com.evelia.api_siat.repositories.ActividadRepository;
import com.evelia.api_siat.repositories.AulaCompuestaRepository;
import com.evelia.api_siat.repositories.AulaRepository;
import com.evelia.api_siat.repositories.ComisionRepository;
import com.evelia.api_siat.repositories.ExamenFinalizadoRepository;
import com.evelia.api_siat.repositories.ExamenRepository;
import com.evelia.api_siat.repositories.ForoRepository;
import com.evelia.api_siat.repositories.MensajeAdjuntoRepository;
import com.evelia.api_siat.repositories.NotaRepository;
import com.evelia.api_siat.repositories.ParticipanteRepository;
import com.evelia.api_siat.repositories.PermisoAccesoRepository;
import com.evelia.api_siat.repositories.PublicacionRepository;
import com.evelia.api_siat.repositories.TextoRepository;
import com.evelia.api_siat.repositories.TipoUsuarioRepository;
import com.evelia.api_siat.utils.assembler.*;
import com.evelia.api_siat.utils.Permisos;
import com.evelia.api_siat.utils.constantes.RECURSOS;
import com.evelia.api_siat.utils.constantes.TIPOS_CALIFICACION;
import com.evelia.api_siat.utils.constantes.TIPO_USUARIOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CalificacionService {
    private final static Logger logger = LoggerFactory.getLogger(CalificacionService.class);
    
    @Autowired
    AulaCompuestaRepository aulaCRepository;
    
    @Autowired
    AulaRepository aulaRepository;
    
    @Autowired
    ParticipanteRepository participanteRepository;
    
    @Autowired
    ComisionRepository comisionRepository;
    
    @Autowired
    TextoRepository textoRepository;
    
    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;
    
    @Autowired
    ForoRepository foroRepository;
    
    @Autowired
    PublicacionRepository publicacionRepository;
    
    @Autowired
    NotaRepository notaRepository;
       
    @Autowired
    Permisos permisos;
    
    @Autowired
    ActividadRepository actividadRepository;
    
    @Autowired
    ExamenRepository examenRepository;
    
    @Autowired
    ExamenFinalizadoRepository examenFinalizadoRepository;
    
    
    /**
     * Servicio que devuelve todas las calificaciones de las actividades de un aula
     * que haya entregado el usuario en caso de ser alumno o que haya generado en caso de ser un docente.
     * @param Long idAula
     * @param Long idUsuario
     * @return Json List<Foro> 
    */
    public List<CalificacionDto> obtenerCalificaciones(Long idAula,Long idPersona){
    	logger.info("Servicio: /obtenerCalificaciones");	
    	
    	List<CalificacionDto> resultado = new ArrayList<CalificacionDto>();
    	List<NotaEntity> calificacionesEntity = new ArrayList<NotaEntity>();
    	
    	try {
	        List<ParticipanteEntity> participantes = participanteRepository.findByAulaIdAndPersonaId(idAula,idPersona); 
	        if(participantes.size()>0) {
   				ParticipanteEntity participante = participantes.get(0);
   				ParticipanteEntity participanteAlumno = participanteRepository.findByAulaIdAndPersonaIdAndTipoUsuarioByTipoUsuarioIdNombre(idAula,idPersona,TIPO_USUARIOS.ALUMNO);
   				   								
	    		if(participanteAlumno != null) {//es un alumno
	    			List<ComisionEntity> comisiones = comisionRepository.findDistinctByParticipanteComisionsByComisionIdParticipanteIdAndAulaByComisionIdAulaCompuestaId(participante.getParticipanteId(), idAula);
	    			ComisionEntity comision = comisiones.get(0);
    			   	//if (permisos.tienePermisoComision(participante,comision.getAulaId(),RECURSOS.ENVIAR_ACTIVIDADES_Y_VER_CALIFICACIONES))
	    			if (permisos.tienePermisoComision(participante,comision.getComisionId(),RECURSOS.CALIFICACIONES_VISTA_ALUMNO)) {
	    				//logger.info("CALIFICACIONES_VISTA_ALUMNO");
	    				
	    				//Actividades	    				
	    				/////////////VER TIPO DE CALIFICACION INDIVIDUAL O GRUPAL
		        		calificacionesEntity = notaRepository.CalificacionesAlumno(comision.getComisionId(), idPersona);
		        	    //calificacionesEntity = notasRepository.CalificacionesAlumno(comision.getAulaId(), idPersona);			        		
		    	        for (NotaEntity nota: calificacionesEntity) {  
				        	CalificacionDto calificacionDto = AssemblerCalificacion.NotaEntityToDto(nota);
				        	calificacionDto.setIdComision(comision.getComisionId());
			    			resultado.add(calificacionDto);	    			
				    	}    	        
	    			}
	   			 }else {
	    			TipoUsuarioEntity TipoUsuarioAlumno = this.tipoUsuarioRepository.findByNombre(TIPO_USUARIOS.ALUMNO);
	    			List<AulaEntity> comisiones = aulaRepository.findDistinctByAulaCompuestaId(idAula);
	    			  			
	    			/*List<ExamenEntity> examenesAula = examenRepository.findByEvaluacionByExamenIdAulaId(idAula);
	    			logger.info("examenesAula "+examenesAula.size());	
	    			for (ExamenEntity examenAula: examenesAula) {	
						logger.info("examenAula "+examenAula.getEvaluacionByExamenId().getNombre());	
						//List<ExamenFinalizadoEntity> examenesFinalizado =  examenFinalizadoRepository.findByEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdAlumnoIdAndEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdEvaluacionId(idAula, alumno.getPersonaId());
						List<ExamenFinalizadoEntity> examenesFinalizado =  examenFinalizadoRepository.findByEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdEvaluacionByEvaluacionIdAulaId(idAula);
						logger.info("examenesFinalizado aula "+examenesFinalizado.size());	
						if(examenesFinalizado!=null && examenesFinalizado.size()>0) {
							List<ExamenFinalizadoEntity> examenesFinalizado2 =  examenFinalizadoRepository.recuperarEvaluacionesFinalizadasAlumnoActivo(alumno.getPersonaId(),examenAula.getExamenId());
							
							ExamenFinalizadoEntity examenFinalizado = examenesFinalizado.get(0);
							logger.info("examenFinalizado "+examenFinalizado.getNotaFinal());
							CalificacionDto calificacionDto = AssemblerObjetos.ExamenEntityToDto(examenFinalizado);
				        	calificacionDto.setIdComision(idAula);
				        	resultado.add(calificacionDto);	
						}else {
							
						}
							
					}		*/	
	    			
	    			
	   				for (AulaEntity comision: comisiones) {
	   					logger.info("comision "+comision.getNombre()+" "+comision.getAulaId());	
		    			if (permisos.tienePermisoComision(participante,comision.getAulaId(),RECURSOS.CALIFICACIONES_VISTA_TUTOR)) {
		    				//logger.info("CALIFICACIONES_VISTA_TUTOR");
			    			
		    				List<ParticipanteEntity> alumnos = participanteRepository.recuperarParticipantesSegunTipoUsuarioEnComision(comision.getAulaId(), TipoUsuarioAlumno.getTipoUsuarioId());
		    					    				
		    				//Examenes
		    				List<ExamenEntity> examenes = examenRepository.findByEvaluacionByExamenIdAulaIdAndEvaluacionByExamenIdEliminado(comision.getAulaId(), false);
		    				logger.info("examenes "+examenes.size());	
		    				
		    				for (ParticipanteEntity alumno: alumnos) { 	
		    					
		    					//Actividades
			    				//List<ActividadEntity> actividades = actividadRepository.findDistinctByAulaId(comision.getAulaId());
			    			/*	List<NotaEntity> notas = notaRepository.findDistinctByActividadByActividadIdAulaIdAndPersonaId(comision.getAulaId(),alumno.getPersonaId());
				    			for (NotaEntity nota: notas) {
				    				CalificacionDto calificacionDto = AssemblerObjetos.NotaEntityToDto(nota);
						        	calificacionDto.setIdComision(comision.getAulaId());
					    			resultado.add(calificacionDto);		
			    				}	*/    					
		    					    					
		    					//Examenes
		    					for (ExamenEntity examen: examenes) {	
		    						logger.info("examenes "+examen.getEvaluacionByExamenId().getNombre());	
		    						ExamenFinalizadoEntity examenFinalizado =  examenFinalizadoRepository.findByEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdAlumnoIdAndEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdEvaluacionId(alumno.getPersonaId(),examen.getExamenId());
		    						if(examenFinalizado!=null) {
		    							logger.info("examen finalizado ");
		    							//Entregado sin o con calificacion
		    							CalificacionDto calificacionDto = AssemblerCalificacion.ExamenFinalizadoEntityToDto(examenFinalizado);
							        	calificacionDto.setIdComision(comision.getAulaId());
							        	resultado.add(calificacionDto);	    							
		    						}else {
		    							CalificacionDto calificacionDto = AssemblerCalificacion.ExamenEntityToDto(examen);
							        	calificacionDto.setIdComision(comision.getAulaId());
							        	calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.NO_ENTREGO);		    								
		    							resultado.add(calificacionDto);
		    						}				   						
		    					  } 
		    				   }//for alumnos
		    				}				
		    			}//for comisiones
	   				}//if tiene permiso
	        }//if es participante      
	        return resultado;	     	        
    	}catch(Exception ex) {
    		logger.error("Exception obtenerCalificaciones: "+ex.getMessage());
    		return null;
    	}
     }
    
}