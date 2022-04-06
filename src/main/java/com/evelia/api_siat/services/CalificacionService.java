package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.CalificacionDto;
import com.evelia.api_siat.entity.AulaEntity;
import com.evelia.api_siat.entity.ComisionEntity;
import com.evelia.api_siat.entity.ExamenEntity;
import com.evelia.api_siat.entity.ExamenFinalizadoEntity;
import com.evelia.api_siat.entity.NotaEntity;
import com.evelia.api_siat.entity.ParticipanteEntity;
import com.evelia.api_siat.entity.TipoUsuarioEntity;
import com.evelia.api_siat.repositories.ActividadRepository;
import com.evelia.api_siat.repositories.AulaCompuestaRepository;
import com.evelia.api_siat.repositories.AulaRepository;
import com.evelia.api_siat.repositories.AutoExamenFinalizadoRepository;
import com.evelia.api_siat.repositories.AutoExamenRepository;
import com.evelia.api_siat.repositories.ComisionRepository;
import com.evelia.api_siat.repositories.ExamenFinalizadoRepository;
import com.evelia.api_siat.repositories.ExamenRepository;
import com.evelia.api_siat.repositories.ForoRepository;
import com.evelia.api_siat.repositories.NotaRepository;
import com.evelia.api_siat.repositories.ParticipanteRepository;
import com.evelia.api_siat.repositories.PublicacionRepository;
import com.evelia.api_siat.repositories.TextoRepository;
import com.evelia.api_siat.repositories.TipoUsuarioRepository;
import com.evelia.api_siat.utils.assembler.*;
import com.evelia.api_siat.utils.Permisos;
import com.evelia.api_siat.utils.constantes.TIPOS_CALIFICACION;
import com.evelia.api_siat.utils.constantes.TIPO_USUARIOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    AutoExamenRepository autoExamenRepository;
    
    @Autowired
    ExamenFinalizadoRepository examenFinalizadoRepository;
    
    @Autowired
    AutoExamenFinalizadoRepository autoExamenFinalizadoRepository;
    
    
    public List<CalificacionDto> obtenerCalificaciones(Long idAula,Long idPersona){
    	logger.info("Servicio: /obtenerCalificaciones");	
    	
    	List<CalificacionDto> resultado = new ArrayList<CalificacionDto>();
    	List<NotaEntity> calificacionesEntity = new ArrayList<NotaEntity>();
    	
    	try {
	        List<ParticipanteEntity> participantes = participanteRepository.findByAulaIdAndPersonaId(idAula,idPersona); 
	        if(participantes.size()>0) { // es participante del aula
   				ParticipanteEntity participante = participantes.get(0);
   				List<ExamenEntity> examenesAula = examenRepository.findByEvaluacionByExamenIdAulaIdAndEvaluacionByExamenIdEliminadoAndEvaluacionByExamenIdPublicado(idAula,false,true);
   				//List<AutoexamenEntity> autoExamenesAula = autoExamenRepository.findByEvaluacionByAutoexamenIdAulaIdAndEvaluacionByAutoexamenIdEliminadoAndEvaluacionByAutoexamenIdPublicado(idAula,false,true);
    		  	   			
   				if(participante.getTipoUsuarioByTipoUsuarioId().getNombre().compareTo(TIPO_USUARIOS.ALUMNO)==0) {
	    			List<ComisionEntity> comisiones = comisionRepository.findDistinctByParticipanteComisionsByComisionIdParticipanteIdAndAulaByComisionIdAulaCompuestaId(participante.getParticipanteId(), idAula);
	    			Long idComision;
	    			for (ComisionEntity comision: comisiones) {
	    				idComision = comision.getComisionId();
	    			   	//if (permisos.tienePermisoComision(participante,comision.getAulaId(),RECURSOS.ENVIAR_ACTIVIDADES_Y_VER_CALIFICACIONES))
		    			//if (permisos.tienePermisoComision(participante,idComision,RECURSOS.CALIFICACIONES_VISTA_ALUMNO)) {
		    				//////////////////////////////////////////////////////
		    				//Actividades	///VER TIPO DE CALIFICACION INDIVIDUAL O GRUPAL
		    				//////////////////////////////////////////////////////			        		
		    				calificacionesEntity = notaRepository.CalificacionesAlumno(idComision, idPersona);
		    			    for (NotaEntity nota: calificacionesEntity) {  
					        	CalificacionDto calificacionDto = AssemblerCalificacion.NotaEntityToDto(nota);
					        	calificacionDto.setIdComision(idComision);
				    			resultado.add(calificacionDto);	    			
					    	}
			    	        
		    				//////////////////////////////////////////////////////
			    	        //Examenes
		    				//////////////////////////////////////////////////////
			        	    List<ExamenEntity> examenesComision = examenRepository.findByEvaluacionByExamenIdAulaIdAndEvaluacionByExamenIdEliminadoAndEvaluacionByExamenIdPublicado(idComision, false,true);
			        	    List<ExamenEntity> examenes = Stream.concat(examenesAula.stream(), examenesComision.stream()).collect(Collectors.toList());
		    				for (ExamenEntity examen: examenes) {	
		    					ExamenFinalizadoEntity examenFinalizado =  examenFinalizadoRepository.findByEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdAlumnoIdAndEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdEvaluacionId(idPersona,examen.getExamenId());
	    						if(examenFinalizado!=null) {
	    							//Entregado sin o con calificacion
	    							CalificacionDto calificacionDto = AssemblerCalificacion.ExamenFinalizadoEntityToDto(examenFinalizado);
						        	if(calificacionDto!=null) {
		    							calificacionDto.setIdComision(idComision);
							        	resultado.add(calificacionDto);
						        	}
	    						}else {
	    							CalificacionDto calificacionDto = AssemblerCalificacion.ExamenEntityToDto(examen);
						        	calificacionDto.setIdComision(idComision);
						        	calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.NO_ENTREGO);
						        	calificacionDto.setAlumno(participante.getPersonaByPersonaId().getNombre()+" "+participante.getPersonaByPersonaId().getApellido());
						        	calificacionDto.setPathFotoAlumno(participante.getPersonaByPersonaId().getPathFoto());
	    							resultado.add(calificacionDto);
	    						}				   						
	    					}
		    				
		    				//////////////////////////////////////////////////////
		    				//AutoExamenes
		    				//////////////////////////////////////////////////////   
		    				/*List<AutoexamenEntity> autoExamenesComision = autoExamenRepository.findByEvaluacionByAutoexamenIdAulaIdAndEvaluacionByAutoexamenIdEliminadoAndEvaluacionByAutoexamenIdPublicado(idComision, false,true);
		    				List<AutoexamenEntity> autoExamenes = Stream.concat(autoExamenesAula.stream(), autoExamenesComision.stream()).collect(Collectors.toList());
		    				for (AutoexamenEntity autoExamen: autoExamenes) {	
	    						AutoexamenFinalizadoEntity autoExamenFinalizado =  autoExamenFinalizadoRepository.findByEvaluacionFinalizadaByAutoexamenFinalizadoIdPersonaByAlumnoIdAndEvaluacionFinalizadaByAutoexamenFinalizadoIdEvaluacionId(idPersona, autoExamen.getAutoexamenId());
	    						if(autoExamenFinalizado!=null) {//Entregado sin o con calificacion
	    							CalificacionDto calificacionDto = AssemblerCalificacion.AutoExamenFinalizadoEntityToDto(autoExamenFinalizado);
	    							if(calificacionDto!=null) {
		    							calificacionDto.setIdComision(idComision);
							        	resultado.add(calificacionDto);
	    							}
	    						}else {
	    							CalificacionDto calificacionDto = AssemblerCalificacion.AutoExamenEntityToDto(autoExamen);
	    							if(calificacionDto!=null) {
		    							calificacionDto.setIdComision(idComision);
							        	calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.NO_ENTREGO);
							        	calificacionDto.setAlumno(participante.getPersonaByPersonaId().getNombre()+" "+participante.getPersonaByPersonaId().getApellido());
							        	calificacionDto.setPathFotoAlumno(participante.getPersonaByPersonaId().getPathFoto());
		    							resultado.add(calificacionDto);
	    							}
	    						}				   						
	    					}*/
		    			//}//tiene permiso
	    			}
	   			 }else { //No es alumno
	    			TipoUsuarioEntity TipoUsuarioAlumno = this.tipoUsuarioRepository.findByNombre(TIPO_USUARIOS.ALUMNO);
	    			List<AulaEntity> comisiones = aulaRepository.findDistinctByAulaCompuestaId(idAula);
	    		  	Long idAlumno;
	    		  	Long idComision;
	    		  	for (AulaEntity comision: comisiones) {	    		  		
	    		  		idComision = comision.getAulaId();
	    		  		//if (permisos.tienePermisoComision(participante,idComision,RECURSOS.CALIFICACIONES_VISTA_TUTOR)) {	   						
		    				List<ParticipanteEntity> alumnos = participanteRepository.recuperarParticipantesSegunTipoUsuarioEnComision(comision.getAulaId(), TipoUsuarioAlumno.getTipoUsuarioId());
		    				List<ExamenEntity> examenesComision = examenRepository.findByEvaluacionByExamenIdAulaIdAndEvaluacionByExamenIdEliminadoAndEvaluacionByExamenIdPublicado(comision.getAulaId(), false,true);
		    				List<ExamenEntity> examenes = Stream.concat(examenesAula.stream(), examenesComision.stream()).collect(Collectors.toList());
		    				//List<AutoexamenEntity> autoExamenesComision = autoExamenRepository.findByEvaluacionByAutoexamenIdAulaIdAndEvaluacionByAutoexamenIdEliminadoAndEvaluacionByAutoexamenIdPublicado(idComision, false, false);
		    				//List<AutoexamenEntity> autoExamenes = Stream.concat(autoExamenesAula.stream(), autoExamenesComision.stream()).collect(Collectors.toList());
		    					    				
		    				for (ParticipanteEntity alumno: alumnos) { 		    					
		    					//////////////////////////////////////////////////////
		    					//Actividades
		    					//////////////////////////////////////////////////////
		    					//List<ActividadEntity> actividades = actividadRepository.findDistinctByAulaId(comision.getAulaId());
		    					idAlumno = alumno.getPersonaId();		    					
			    				List<NotaEntity> notas = notaRepository.findDistinctByActividadByActividadIdAulaIdAndPersonaId(idComision,idAlumno);
				    			for (NotaEntity nota: notas) {
				    				CalificacionDto calificacionDto = AssemblerCalificacion.NotaEntityToDto(nota);
						        	calificacionDto.setIdComision(idComision);
					    			resultado.add(calificacionDto);		
			    				}  				
		    					  
				    			//////////////////////////////////////////////////////
		    					//Examenes
				    			//////////////////////////////////////////////////////	
				    			for (ExamenEntity examen: examenes) {	
		    						ExamenFinalizadoEntity examenFinalizado =  examenFinalizadoRepository.findByEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdAlumnoIdAndEvaluacionFinalizadaConRespuestasByExamenFinalizadoIdEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasIdEvaluacionId(idAlumno,examen.getExamenId());
		    						if(examenFinalizado!=null) {
		    							//Entregado sin o con calificacion
		    							CalificacionDto calificacionDto = AssemblerCalificacion.ExamenFinalizadoEntityToDto(examenFinalizado);
							        	calificacionDto.setIdComision(idComision);
							        	resultado.add(calificacionDto);	    							
		    						}else {
		    							CalificacionDto calificacionDto = AssemblerCalificacion.ExamenEntityToDto(examen);
		    							if(calificacionDto!=null) {
			    							calificacionDto.setIdComision(idComision);
								        	calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.NO_ENTREGO);
								        	calificacionDto.setAlumno(alumno.getPersonaByPersonaId().getNombre()+" "+alumno.getPersonaByPersonaId().getApellido());
								        	calificacionDto.setPathFotoAlumno(alumno.getPersonaByPersonaId().getPathFoto());
			    							resultado.add(calificacionDto);
		    							}
		    						}				   						
		    					} 
		    					
		    					//////////////////////////////////////////////////////
								//AutoExamenes
								////////////////////////////////////////////////////// 
				    			/*for (AutoexamenEntity autoExamen: autoExamenes) {	
		    						AutoexamenFinalizadoEntity autoExamenFinalizado =  autoExamenFinalizadoRepository.findByEvaluacionFinalizadaByAutoexamenFinalizadoIdPersonaByAlumnoIdAndEvaluacionFinalizadaByAutoexamenFinalizadoIdEvaluacionId(idAlumno, autoExamen.getAutoexamenId());
		    						if(autoExamenFinalizado!=null) {
		    							//Entregado sin o con calificacion
		    							CalificacionDto calificacionDto = AssemblerCalificacion.AutoExamenFinalizadoEntityToDto(autoExamenFinalizado);
		    							if(calificacionDto!=null) {
			    							calificacionDto.setIdComision(idComision);
								        	resultado.add(calificacionDto);
		    							}
		    						}else {
		    							CalificacionDto calificacionDto = AssemblerCalificacion.AutoExamenEntityToDto(autoExamen);
		    							if(calificacionDto!=null) {
			    							calificacionDto.setIdComision(idComision);
								        	calificacionDto.setEstadoCalificacion(TIPOS_CALIFICACION.NO_ENTREGO);
								        	calificacionDto.setAlumno(alumno.getPersonaByPersonaId().getNombre()+" "+alumno.getPersonaByPersonaId().getApellido());
								        	calificacionDto.setPathFotoAlumno(alumno.getPersonaByPersonaId().getPathFoto());
			    							resultado.add(calificacionDto);
		    							}
		    						}				   						
		    					} */
		    				}//for alumnos
	   					//}//tiene permisos				
	    		  	}//for comisiones    	
	   			}
	        }      
	        return resultado;	     	        
    	}catch(Exception ex) {
    		logger.error("Exception obtenerCalificaciones: "+ex.getMessage());
    		return null;
    	}
     }
    
    
    
}