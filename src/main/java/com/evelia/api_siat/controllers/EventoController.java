package com.evelia.api_siat.controllers;

import com.evelia.api_siat.dto.EventoDto;
import com.evelia.api_siat.services.EventoService;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
public class EventoController {
    
	@Autowired
    EventoService eventoService;
	
	/**
     * Se encarga de devolver todos los eventos (de todos los tipos) de un aula desde una fecha dada
     * @param idAula
     * @param idUsuario
     * @param fechaDesde
     * @return Json List<Evento> 
    */
	@GetMapping( path = "/eventosAula")
    public List<EventoDto> eventosAulaDesdeFecha(@RequestParam("idAula") Long idAula,@RequestParam("idUsuario") Long idUsuario, @RequestParam("fechaDesde") Timestamp fechaDesde){
	    List<EventoDto> eventossDto = eventoService.eventosAulaDesdeFecha(idAula,idUsuario,fechaDesde);    
    	return eventossDto;		
    }
	
	
	
	
	
	    	
	
}

