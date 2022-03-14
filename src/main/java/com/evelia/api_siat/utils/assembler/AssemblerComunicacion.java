package com.evelia.api_siat.utils.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.evelia.api_siat.dto.ComentarioDto;
import com.evelia.api_siat.dto.EventoDto;
import com.evelia.api_siat.dto.ForoDto;
import com.evelia.api_siat.dto.MensajeDto;
import com.evelia.api_siat.dto.TextoDto;
import com.evelia.api_siat.entity.ComentarioEntity;
import com.evelia.api_siat.entity.ForoEntity;
import com.evelia.api_siat.entity.MensajeAdjuntosEntity;
import com.evelia.api_siat.entity.MensajeEntity;
import com.evelia.api_siat.entity.TextoEntity;
import com.evelia.api_siat.repositories.MensajeAdjuntoRepository;
import com.evelia.api_siat.utils.Util;


public class AssemblerComunicacion {
	//private final static Logger logger = LoggerFactory.getLogger(AssemblerComunicacion.class);
    
    /**
     * Convierte un objeto Entity en su respectivo DTO
     * @param TextoEntity evento
     * @return TextoDto evento
    */
    public static EventoDto EventoEntityToDto(TextoEntity evento) {
    	EventoDto eventoDto = new EventoDto();    		
    	eventoDto.setId(evento.getId());
    	eventoDto.setTitulo(Util.convert(evento.getTitulo()));    	
    	String str = new String(evento.getContenido());
    	eventoDto.setContenido(Util.convert(str));    	
    	eventoDto.setIdPersona(evento.getPersonaId());
    	if(evento.getPersonaByPersonaId() != null) {
    		eventoDto.setNombreApellidoPersona(evento.getPersonaByPersonaId().getNombre() +" "+evento.getPersonaByPersonaId().getApellido());
    		eventoDto.setPathFoto(evento.getPersonaByPersonaId().getPathFoto());
    	}else
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
    public static TextoDto NoticiaPizarronEntityToDto(TextoEntity evento,String tipoNivelEvento) {
    	TextoDto eventoDto = new TextoDto();  
    	
    	eventoDto.setId(evento.getTextoId());
    	eventoDto.setTitulo(Util.convert(evento.getTitulo()));    	
    	String str = new String(evento.getContenido());
    	eventoDto.setContenido(Util.convert(str));    	
    	if(evento.getPersonaByPersonaId() != null) {
    		eventoDto.setNombreApellidoPersona(evento.getPersonaByPersonaId().getNombre() +" "+evento.getPersonaByPersonaId().getApellido());
    		eventoDto.setPathFoto(evento.getPersonaByPersonaId().getPathFoto());
    	}else
    		eventoDto.setNombreApellidoPersona("");
    	eventoDto.setFechaCreacion(evento.getFecha());
    	//eventoDto.setFechaUltimaModificacion(evento.);    	
    	   	
    	if(evento.getArchivoByArchivoId() != null)
    		eventoDto.setPathArchivo(evento.getArchivoByArchivoId().getPath());
    	else
    		eventoDto.setPathArchivo("");
    	
    	if(evento.getPublicacionByPublicacionId()!=null){
    		eventoDto.setTipoPublicacion(evento.getPublicacionByPublicacionId().getTipoPublicacion());
    		eventoDto.setDisponibleDesde(evento.getPublicacionByPublicacionId().getFechaApertura());
    		eventoDto.setDisponibleHasta(evento.getPublicacionByPublicacionId().getFechaCierre());    		
    	}
    	
    	eventoDto.setEliminado(evento.isEliminado());
    	eventoDto.setGenerarAlerta(evento.isGenerarAlerta());
    	eventoDto.setTipoEventoNivel(tipoNivelEvento);
    	
    	eventoDto.setComentarios(ComentarioEntityToDto(evento.getComentariosByTextoId()));   	
    	    	
    	return eventoDto;
    }
    
    
    /**
     * Convierte una coleccion de ComentariosEntity en ComentariosDTo
     * @param Collection<ComentarioEntity> comentariosEntity
     * @return Collection<ComentarioDto> 
    */
    public static List<ComentarioDto> ComentarioEntityToDto(Collection<ComentarioEntity> comentariosEntity) {
    	List<ComentarioDto> comentarios = new ArrayList<ComentarioDto>();
    	try {	
    	   	for (ComentarioEntity comentarioEntity: comentariosEntity) { 
	    		//if(comentarioEntity.getComentPadreId()==null) {
	    			ComentarioDto coment = new ComentarioDto();
		    		String str1 = new String(comentarioEntity.getContenido());
		    		coment.setContenido(Util.convert(str1));
		    		coment.setId(comentarioEntity.getComentarioId());
		    		coment.setFecha(comentarioEntity.getFecha());
		    		coment.setTextoPadreId(comentarioEntity.getTextoPadreId());
		    		coment.setComentarioPadreId(comentarioEntity.getComentPadreId());
		    		coment.setNombreApellidoPersona(comentarioEntity.getPersonaByPersonaId().getNombre()+" "+comentarioEntity.getPersonaByPersonaId().getApellido());
		    		coment.setPathfotoperfil(comentarioEntity.getPersonaByPersonaId().getPathFoto());
		    		comentarios.add(coment);
	    	    //}	    		
	    	}    		    	
    	}catch(Exception ex) {
    		return null;
		}	    	
    	return comentarios;
    }

  /* public static Collection<ComentarioDto> ObtenerComentariosAnidados(Collection<ComentarioEntity> comentariosEntity) {
    	Collection<ComentarioDto> comentarios = new ArrayList<ComentarioDto>();
    	try {	
    		System.out.println("entre......................");
    		
    	   	for (ComentarioEntity comentarioEntity: comentariosEntity) { 
    	   			ComentarioDto coment = new ComentarioDto();
		    		String str1 = new String(comentarioEntity.getContenido());
		    		coment.setContenido(util.convert(str1));
		    		System.out.println("contenido: "+util.convert(str1));
		    		coment.setFecha(comentarioEntity.getFecha());
		    		coment.setNombreApellidoPersona(comentarioEntity.getPersonaByPersonaId().getNombre()+" "+comentarioEntity.getPersonaByPersonaId().getApellido());
		    		coment.setPathfotoperfil(comentarioEntity.getPersonaByPersonaId().getPathFoto());
	    	   		
		    		Collection<ComentarioDto> comentarioshijos = new ArrayList<ComentarioDto>();
		    		comentarioshijos =  ObtenerComentariosAnidados(comentarioEntity.getComentariosByComentarioId());
		    		System.out.println("sali de al recursiva");
		    		coment.setComentarios(comentarioshijos);
		    		comentarios.add(coment);    	   		
	    	}    		    	
    	}catch(Exception ex) {
    		return null;
		}	    	
    	return comentarios;
    }*/
    
    
    /**
     * Convierte un foro Entity en su respectivo DTO
     * @param ForoEntity foro
     * @return ForoDto foro
    */
    public static ForoDto ForoEntityToDto(ForoEntity foro,MensajeAdjuntoRepository mensajeAdjuntoRepository) {
    	
    	try {
	    	ForoDto foroDto = new ForoDto();   
	    
	    	foroDto.setAsunto(Util.convert(foro.getAsunto()));
	    	foroDto.setFechaCreacion(foro.getFecha());
	    	foroDto.setFechaDesde(foro.getPublicacionByPublicacionId().getFechaApertura());
	    	foroDto.setFechaHasta(foro.getPublicacionByPublicacionId().getFechaCierre());
	    	if(foro.getPersonaByAutorId()!=null) {
	    		foroDto.setNombreAutor(foro.getPersonaByAutorId().getNombre()+" "+foro.getPersonaByAutorId().getApellido());
	    		foroDto.setPathFotoPerfil(foro.getPersonaByAutorId().getPathFoto());
	    	}
	    	   	   	
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
		    		mens.setId(mensajeEntity.getMensajeId());
		    		mens.setMsjPadreId(mensajeEntity.getMsjPadreId());
		    		mens.setContenido(Util.convert(str1));
		    		mens.setFecha(mensajeEntity.getFecha());
		    		mens.setPersona(mensajeEntity.getPersonaByPersonaId().getNombre()+" "+mensajeEntity.getPersonaByPersonaId().getApellido());
		    		mens.setPathFotoPerfil(mensajeEntity.getPersonaByPersonaId().getPathFoto());
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
	    		mens.setContenido(Util.convert(str1));
	    		mens.setFecha(mensajeEntity.getFecha());
	    		mens.setPersona(mensajeEntity.getPersonaByPersonaId().getNombre()+" "+mensajeEntity.getPersonaByPersonaId().getApellido());
	    		mens.setPathFotoPerfil(mensajeEntity.getPersonaByPersonaId().getPathFoto());
	    		mens.setMensajes(MensajeEntityToDTo(mensajeEntity.getMensajesByMensajeId()));
	    		mens.setId(mensajeEntity.getMensajeId());
	    		mens.setMsjPadreId(mensajeEntity.getMsjPadreId());
	    		mensajes.add(mens);
	    	}catch(Exception ex) {}	
    	}  	    	
    	return mensajes;
    }
    
    
    
    
   

}