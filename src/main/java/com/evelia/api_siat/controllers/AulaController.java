package com.evelia.api_siat.controllers;

import com.evelia.api_siat.dto.ActividadDto;
import com.evelia.api_siat.dto.AulaCompuestaDto;
import com.evelia.api_siat.dto.CarpetaDto;
import com.evelia.api_siat.dto.ForoDto;
import com.evelia.api_siat.dto.TextoDto;
//import com.evelia.api_siat.repositories.TextoRepository;
import com.evelia.api_siat.services.AulaService;
import com.evelia.api_siat.utils.constantes.ESTADO_AULAS;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula")
public class AulaController {
    
	@Autowired
    AulaService aulaService;
	
	//@Autowired
	//TextoRepository textRepository;
	    
    
    /**
     * Este servicio devuelve todas las aulas activas en las que participa el usuario
     * @param idUsuario por url
     * @return Json con una lista de aulas. 
    */
	@GetMapping( path = "/listarAulas/{idUsuario}")
    public List<AulaCompuestaDto> listarAulas(@PathVariable("idUsuario") Long idUsuario) {
		List<AulaCompuestaDto> aulasDto = aulaService.obtenerAulasPorUsuario(idUsuario,ESTADO_AULAS.ACTIVO);    
    	return aulasDto;   		
    }
	
	/**
     * Este servicio devuelve todas las noticias del aula
     * @param idAula por url
     * @return Json con una lista de noticias.  
    */
	@GetMapping( path = "/obtenerNoticias/{idAula}")
    public List<TextoDto> obtenerNoticias(@PathVariable("idAula") Long idAula) {
		List<TextoDto> noticias = aulaService.obtenerNoticias(idAula);
    	return noticias;   		
    }
	
	/**
     * Este servicio devuelve todos los mensajes del pizarron de la comision en la que participa el usuario
     * @param idAula idUsuario
     * @return Json con todos los mensajes del pizarron
    */
	@GetMapping( path = "/obtenerPizarron")
    public List<TextoDto> obtenerMensajesPizarron(@RequestParam("idAula") Long idAula,@RequestParam("idUsuario") Long idUsuario) {
		List<TextoDto> pizarrones = aulaService.obtenerMensajesPizarron(idAula,idUsuario);
    	return pizarrones;   		
    }
		
	/**
     * Se encarga de devolver todas las actividades de la comision en la que participa el usuario
     * @param idAula
     * @param idUsuario
     * @return Json List<Actividad> 
    */
	@GetMapping( path = "/obtenerActividades")
    public List<ActividadDto> obtenerActividades(@RequestParam("idAula") Long idAula,@RequestParam("idUsuario") Long idUsuario){
	    List<ActividadDto> actividadesDto = aulaService.obtenerActividades(idAula,idUsuario);    
    	return actividadesDto;		
    }
	
	/**
     * Se encarga de devolver todos los foros de un aula
     * @param idAula
     * @return Json List<Foro> 
    */
	@GetMapping( path = "/obtenerForos")
    public List<ForoDto> obtenerForos(@RequestParam("idAula") Long idAula,@RequestParam("idUsuario") Long idUsuario){
	    List<ForoDto> forosDto = aulaService.obtenerForos(idAula,idUsuario);    
    	return forosDto;		
    }
	
	/**
     * Se encarga de devolver todos los materiales de un aula
     * @param idAula
     * @param idUsuario
     * @return CarpetaDto 
    */
	@GetMapping( path = "/obtenerMateriales")
    public CarpetaDto obtenerMateriales(@RequestParam("idAula") Long idAula,@RequestParam("idUsuario")  Long idUsuario){
		CarpetaDto carpetaDto = aulaService.obtenerMateriales(idAula,idUsuario);    
    	return carpetaDto;		
    }
	
	
}