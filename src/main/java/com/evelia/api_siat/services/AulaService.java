package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.ActividadDto;
import com.evelia.api_siat.dto.ArchivoDto;
import com.evelia.api_siat.dto.AulaCompuestaDto;
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
import com.evelia.api_siat.entity.ForoEntity;
import com.evelia.api_siat.entity.MaterialEntity;
import com.evelia.api_siat.entity.ParticipanteEntity;
import com.evelia.api_siat.entity.PermisoAccesoEntity;
import com.evelia.api_siat.entity.TextoEntity;
import com.evelia.api_siat.repositories.ActividadArchivosAdjuntosRepository;
import com.evelia.api_siat.repositories.ActividadRepository;
import com.evelia.api_siat.repositories.AulaCompuestaRepository;
import com.evelia.api_siat.repositories.AulaRepository;
import com.evelia.api_siat.repositories.ComisionRepository;
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
import com.evelia.api_siat.utils.constantes.TIPO_USUARIOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AulaService {
    private final static Logger logger = LoggerFactory.getLogger(AulaService.class);
    
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
    PermisoAccesoRepository permisoAccesoRepository;
    
    @Autowired
    ActividadRepository actividadRepository;
    
    @Autowired
    ActividadArchivosAdjuntosRepository actividadArchivosAdjuntosRepository;
    
    @Autowired
	MensajeAdjuntoRepository mensajeAdjuntoRepository;
    
    /**
     * Servicio que devuelve todas las aulas activas donde participa un usuario
     * @param idUsuario
     * @return Json List<CursoDto> 
   */
    public List<AulaCompuestaDto> obtenerAulasPorUsuario(Long idUsuario,String estadoAula){
    	List<AulaCompuestaDto> resultado = new ArrayList<AulaCompuestaDto>();
    	try {
	    	logger.info("Servicio: /listarAulas/{idUsuario}");
	    	List<AulaCompuestaEntity> cursosEntity = aulaCRepository.findDistinctByAulaByAulaCompuestaIdParticipantesByAulaIdPersonaIdAndEstadoAulaByEstadoAulaIdDescripcion(idUsuario,estadoAula);
	    	for(AulaCompuestaEntity aulaCEntity: cursosEntity) {
	    		try {
					AulaEntity aulaentity = aulaCEntity.getAulaByAulaCompuestaId();
										
					String facultad = "";
					if(aulaentity.getAulaCompuestaByAulaCompuestaId() != null)
						facultad =  aulaentity.getAulaCompuestaByAulaCompuestaId().getAulaByAulaCompuestaId().getNombre();
										
					if(facultad != null & facultad.compareTo("Campus")!=0  & facultad.compareTo("")!=0) {
						AulaCompuestaDto aulaC = new AulaCompuestaDto();
						String docente = "";
						ParticipanteEntity participanteEntity = participanteRepository.findByAulaIdAndTipoUsuarioByTipoUsuarioIdNombre(aulaentity.getAulaId(), TIPO_USUARIOS.RESPONSABLE);
						if(participanteEntity != null)
							docente = participanteEntity.getPersonaByPersonaId().getNombre() + " " +participanteEntity.getPersonaByPersonaId().getApellido();
						aulaC.setDocente(docente);
						aulaC.setAulaCompuestaId(aulaentity.getAulaId());
						aulaC.setNombre(aulaentity.getNombre());
						aulaC.setFacultad(facultad);												
						resultado.add(aulaC);
					}
				}catch(Exception ex) {
					logger.error("Exception: "+ex.getMessage());
				}
			}	
	    	return resultado;	    	
    	}catch(Exception ex) {
    		logger.error("Exception obtenerAulasPorUsuario: "+ex.getMessage());
			return resultado;
		}
    } 
        
    /**
     * Devuelve todas las noticias del aula ordenadas por su fecha de apertura
     * @param idAula
     * @return Json List<NoticiaDto> 
    */
    public List<TextoDto> obtenerNoticias(Long idAula) {
    	List<TextoDto> resultado = new ArrayList<TextoDto>();
    	try {
    		logger.info("Servicio: /obtenerNoticias");
    		AulaEntity aula = aulaRepository.findByAulaId(idAula);    		
    		Long idComunicacion = aula.getNovedadId();    	
    		Long datetime = System.currentTimeMillis();
    		Timestamp fechaHoy = new Timestamp(datetime);
    		
    		//List<TextoEntity> noticias = textoRepository.findByComunicacionIdAndEliminadoOrderByFechaDesc(idComunicacion, false);
    		List<TextoEntity> noticias = textoRepository.ComunicacionesDisponibles(idComunicacion, false,fechaHoy);
    		
    		for(TextoEntity noticia: noticias) {
    			TextoDto noticiaDto = AssemblerComunicacion.NoticiaPizarronEntityToDto(noticia,"E");
    			//noticiaDto.setAulaId(idAula);
    			resultado.add(noticiaDto);
    		}
    		
    		return resultado;    		
    	}catch(Exception ex) {
    		logger.error("Exception obtenerNoticias: "+ex.getMessage());
			return resultado;
		}    	
    }
    
    /**
     * Devuelve todos los mensajes del pizarron de la comision en la que participa el usuario
     * @param idAula
     * @param idPersona
     * @return Json List<PizarronDto> 
    */
    public List<TextoDto> obtenerMensajesPizarron(Long idAula,Long idPersona) {
    	List<TextoDto> resultado = new ArrayList<TextoDto>();
    	try {
    		logger.info("Servicio: /obtenerMensajesPizarron");
    		//AulaEntity aula = aulaRepository.findById(idAula).get();
    		Long datetime = System.currentTimeMillis();
    		Timestamp fechaHoy = new Timestamp(datetime);
    		
    		List<ParticipanteEntity> participantes = participanteRepository.findByAulaIdAndPersonaId(idAula,idPersona); 
	        if(participantes.size()>0) {
   				ParticipanteEntity participante = participantes.get(0);
   			    List<ComisionEntity> comisiones = comisionRepository.findDistinctByParticipanteComisionsByComisionIdParticipanteIdAndAulaByComisionIdAulaCompuestaId(participante.getParticipanteId(), idAula);
		        for (ComisionEntity comision: comisiones) {
		        	List<PermisoAccesoEntity> permisos = permisoAccesoRepository.findByRecursoByRecursoIdNombreAndAulaIdAndTipoUsuarioId(RECURSOS.PIZARRON, comision.getComisionId(), participante.getTipoUsuarioId());
		   			if(!permisos.isEmpty()) {		   					   				
		        	    Long idComunicacion = comision.getAulaByComisionId().getPizarronId();
		        		//List<TextoEntity> pizarrones = textoRepository.findByComunicacionIdAndEliminadoOrderByFechaDesc(idComunicacion, false);
		        	    List<TextoEntity> pizarrones = textoRepository.ComunicacionesDisponibles(idComunicacion, false,fechaHoy);
		        	    
		        		for(TextoEntity pizarron: pizarrones) {
		        			TextoDto pizarronDto = AssemblerComunicacion.NoticiaPizarronEntityToDto(pizarron,"EC");
		        			//pizarronDto.setAulaId(comision.getComisionId());
		        			resultado.add(pizarronDto);
		        		}	        		
		    		}
		    	}   		
	    	}
	        
	        Collections.sort(resultado, new SortByDatePizarron()); 
    		return resultado;    		
    	}catch(Exception ex) {
    		logger.error("Exception obtenerMensajesPizarron: "+ex.getMessage());
			return resultado;
		}    	
    }
    
    /**
     * Permite ordenar los eventos por su fecha de creacion.
     */
    static class SortByDatePizarron implements Comparator<TextoDto> {
        @Override
        public int compare(TextoDto a, TextoDto b) {
          	if(b.getDisponibleDesde()!=null && a.getDisponibleDesde()!=null)
         	      return b.getDisponibleDesde().compareTo(a.getDisponibleDesde());
          	else if(b.getDisponibleDesde()==null)
      			return -1;
      		else
      			return 1;
        }
    }
    
    
    
    /**
     * Servicio que devuelve todas las actividades de la comision en la que participa el usuario.
     * @param Long idAula
     * @param Long idPersona
     * @return Json List<Actividad> 
    */
    public List<ActividadDto> obtenerActividades(Long idAula, Long idPersona){
    	//List<EventoDto> resultado = new ArrayList<EventoDto>();
    	List<ActividadDto> resultado = new ArrayList<ActividadDto>();
    	
    	try {
	        logger.info("Servicio: /obtenerActividades");
	        
	        //Busca las actividades de la comision en la que participa el usuario
	        //AulaEntity aula = aulaRepository.findById(idAula).get();	        
	    	//List<AulaEntity> comisiones = aulaRepository.findDistinctByAulaCompuestaId(idAula);	
	        
	        Long datetime = System.currentTimeMillis();
    		Timestamp fechaHoy = new Timestamp(datetime);
    		
	    		    	
	    	List<ParticipanteEntity> participantes = participanteRepository.findByAulaIdAndPersonaId(idAula,idPersona); 
	    	if(participantes.size()>0) {
   				ParticipanteEntity participante = participantes.get(0);   				
   				List<ComisionEntity> comisiones = comisionRepository.findDistinctByParticipanteComisionsByComisionIdParticipanteIdAndAulaByComisionIdAulaCompuestaId(participante.getParticipanteId(), idAula);
  		        				
		    	//for (AulaEntity comision: comisiones) {
   				for (ComisionEntity comision: comisiones) {
		    		//if (permisos.tienePermisoComision(idAula,comision.getAulaId(),idPersona,RECURSOS.ACTIVIDADES)) {	    
   					List<PermisoAccesoEntity> permisos = permisoAccesoRepository.findByRecursoByRecursoIdNombreAndAulaIdAndTipoUsuarioId(RECURSOS.ACTIVIDADES, comision.getComisionId(), participante.getTipoUsuarioId());
		   			if(!permisos.isEmpty()) {		        	
		    			/*Long idCalendarioComision = comision.getAulaByComisionId().getCalendarioId();
		    	    	if(idCalendarioComision!=null) {	    	
		    	    		List<TextoEntity> actividadesComision = textoRepository.findByComunicacionIdAndEliminadoAndTipoEventoOrPersonaId(idCalendarioComision,false,RECURSOS.ACTIVIDADES,idPersona);
		    	    		logger.info("Cantidad de actividades de la comision: "+actividadesComision.size());	    	    		
		    		    	for (TextoEntity actividadComision: actividadesComision) {      		    						
		    		    		EventoDto actividadComisionDto = AssemblerObjetos.EventoEntityToDto(actividadComision);
		    					actividadComisionDto.setTipoEventoNivel("EC");//evento de comision 
		    					resultado.add(actividadComisionDto);				    					
		    		    	}
		    	    	}*/
		   				//List<ActividadEntity> actividadesComision = actividadRepository.findDistinctByAulaId(comision.getComisionId());
		   				List<ActividadEntity> actividadesComision = actividadRepository.ActividadesDisponibles(comision.getComisionId(),fechaHoy);
		   				
		   				for (ActividadEntity actividadComision: actividadesComision) {      		    						
		   					ActividadDto actividadComisionDto = AssemblerCalificacion.ActividadEntityToDto(actividadComision);
		   					ActividadArchivosAdjuntosEntity archivo = actividadArchivosAdjuntosRepository.findByActividadId(actividadComision.getActividadId());
	    					if(archivo !=null)
	    						actividadComisionDto.setArchivoAdjunto(archivo.getArchivoByArchivoId().getPath());
		   					resultado.add(actividadComisionDto);				    					
	    		    	}
		   				
		   			}
		    	} 
	    	}
	    	
	    	Collections.sort(resultado, new SortByDateActividad()); 
	    	return resultado;	     	        
    	}catch(Exception ex) {
    		logger.error("Exception obtenerActividades: "+ex.getMessage());
    		return null;
    	}
     }
    
    /**
     * Permite ordenar los eventos por su fecha de creacion.
     */
    static class SortByDateActividad implements Comparator<ActividadDto> {
        @Override
        public int compare(ActividadDto a, ActividadDto b) {
           	if(b.getFechaApertura()!=null && a.getFechaApertura()!=null)
         	      return b.getFechaApertura().compareTo(a.getFechaApertura());
           	else if(b.getFechaApertura()==null)
      			return -1;
      		else
      			return 1;
           	
        }
    }
      
    /**
     * Servicio que devuelve todos los foros de un aula y de la comision en la que participa el usuario
     * @param Long idAula
     * @param Long idUsuario
     * @return Json List<Foro> 
    */
    public List<ForoDto> obtenerForos(Long idAula,Long idUsuario){
    	List<ForoDto> resultado = new ArrayList<ForoDto>();
    	try {
	        logger.info("Servicio: /obtenerForos");
	        
	        Long datetime = System.currentTimeMillis();
            Timestamp fechaHoy = new Timestamp(datetime);
            
            List<ParticipanteEntity> participantes = participanteRepository.findByAulaIdAndPersonaId(idAula,idUsuario); 
	    	if(participantes.size()>0) {
	    		ParticipanteEntity participante = participantes.get(0);   		
	    		
		        //ver foros del aula, si tiene pernmiso y foros de la comision
		    	List<PermisoAccesoEntity> permisos = permisoAccesoRepository.findByRecursoByRecursoIdNombreAndAulaIdAndTipoUsuarioId(RECURSOS.FORO_ASUNTO, idAula, participante.getTipoUsuarioId());
	   			if(!permisos.isEmpty()) {
	   				List<ForoEntity> forosAula = foroRepository.ForosConCierrePosteriorA(idAula, fechaHoy);
	   				//List<ForoEntity> forosAula = foroRepository.findByAulaId(idAula);	   				
	   				for (ForoEntity foro: forosAula) {    	
		    			ForoDto foroDto = AssemblerComunicacion.ForoEntityToDto(foro,mensajeAdjuntoRepository);
		    			foroDto.setTipoEventoNivel("E");//evento de aula
		    			foroDto.setIdAula(idAula);
		    			foroDto.setId(foro.getForoId());
		    			resultado.add(foroDto);					
			    	}		    		
		        }	        
	           						
   				List<ComisionEntity> comisiones = comisionRepository.findDistinctByParticipanteComisionsByComisionIdParticipanteIdAndAulaByComisionIdAulaCompuestaId(participante.getParticipanteId(), idAula);
   				for (ComisionEntity comision: comisiones) {
		    		List<PermisoAccesoEntity> permisosC = permisoAccesoRepository.findByRecursoByRecursoIdNombreAndAulaIdAndTipoUsuarioId(RECURSOS.FORO_ASUNTO, comision.getComisionId(), participante.getTipoUsuarioId());
		   			if(!permisosC.isEmpty()) {						
		   				   	List<ForoEntity> forosAula = foroRepository.ForosConCierrePosteriorA(comision.getAulaByComisionId().getAulaId(), fechaHoy);
		   				    //List<ForoEntity> forosAula = foroRepository.findByAulaId(comision.getAulaByComisionId().getAulaId());	   		
					       	for (ForoEntity foro: forosAula) {    	
					    		ForoDto foroDto = AssemblerComunicacion.ForoEntityToDto(foro,mensajeAdjuntoRepository);
					    		foroDto.setTipoEventoNivel("EC");//evento de comision
					    		foroDto.setIdAula(comision.getAulaByComisionId().getAulaId());
					    		foroDto.setId(foro.getForoId());
								resultado.add(foroDto);					
					    	}	    	    		    	    	
		    		}
		    	}      
	    	}
	    	
	    	Collections.sort(resultado, new SortByDateForo()); 
	    	return resultado;	     	        
    	}catch(Exception ex) {
    		logger.error("Exception obtenerForos: "+ex.getMessage());
    		return null;
    	}
     }
    
    /**
     * Permite ordenar los eventos por su fecha de creacion.
     */
    static class SortByDateForo implements Comparator<ForoDto> {
        @Override
        public int compare(ForoDto a, ForoDto b) {
           	if(b.getFechaDesde()!=null && a.getFechaDesde()!=null)
         	      return b.getFechaDesde().compareTo(a.getFechaDesde());
           	else if(b.getFechaDesde()==null)
      			return -1;
      		else
      			return 1;
        }
    }
    
    /**
     * Servicio que devuelve todos los materiales de un aula 
     * @param Long idAula
     * @param Long idUsuario
     * @return CarpetaDto
    */
    public CarpetaDto obtenerMateriales(Long idAula, Long idUsuario){
    	try {
	        logger.info("Servicio: /obtenerMateriales");	  
	        
	        AulaEntity aula = aulaRepository.findById(idAula).get();
	        if (permisos.tienePermisoAula(idAula,idUsuario,RECURSOS.MATERIALES)) {	          	
	        	MaterialEntity material = aula.getMaterialByMaterialId();	
	        	CarpetaDto carpetaDTO = obtenerCarpetaDTO(material.getCarpetaByMaterialId());
	        	return carpetaDTO;	        	
	        }else return null;	    
	        
    	}catch(Exception ex) {
    		logger.error("Exception obtenerMateriales: "+ex.getMessage());
    		return null;
    	}
     }
    
    private CarpetaDto obtenerCarpetaDTO(CarpetaEntity carpeta) {
    	CarpetaDto carpetaDTO = new CarpetaDto();
 	    carpetaDTO.setNombre(carpeta.getNombre());
 	   
 	    Iterator<ArchivoEntity> archivos = carpeta.getArchivosByCarpetaId().iterator();
 	    while (archivos.hasNext()) {
 	    	ArchivoEntity archivo = (ArchivoEntity) archivos.next();
 	    	ArchivoDto archivoDTO = new ArchivoDto();
	 		archivoDTO.setNombre(archivo.getNombre());
	 		//archivoDTO.setFechaUP(new SimpleDateFormat("dd/MM/yyyy").format(archivo.getFechaUp()));
	 		archivoDTO.setFechaUP(archivo.getFechaUp());
	 		archivoDTO.setDescripcion(archivo.getDescripcion());
	 		//archivoDTO.setTamanio(String.format("%.2f", archivo.getTamanio()));
	 		archivoDTO.setTamanio(archivo.getTamanio());
	 		String url = archivo.getPath();
	 		archivoDTO.setURL(url.substring(url.indexOf("siat2")+5));
	 		if (archivoDTO.getURL().indexOf("lib/tomcat")>0)
	 			archivoDTO.setURL(url.substring(url.indexOf("evelia")+6));	 		
	 		carpetaDTO.getArchivos().add(archivoDTO);
 	    }
 	   
 	    Iterator<CarpetaEntity> carpetas = carpeta.getCarpetasByCarpetaId().iterator(); 	   
 	    while (carpetas.hasNext()) { 	    	
 	    	CarpetaEntity carpetaHija = (CarpetaEntity) carpetas.next();
 	    	carpetaDTO.getSubcarpetas().add(obtenerCarpetaDTO(carpetaHija));
 		}
 	   
 	    return carpetaDTO;
    }
    
    
    
   
    
   
      
   
      
}