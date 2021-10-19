package com.evelia.api_siat.controllers;

import com.evelia.api_siat.dto.CalificacionDto;
import com.evelia.api_siat.services.CalificacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula")
public class CalificacionController {
    
	@Autowired
    CalificacionService calificacionService;
	

	/**
     * Se encarga de devolver todas las calificaciones de las actividades de un aula
     * que haya entregado el usuario en caso de ser alumno o que haya generado en caso de ser un docente.
     * @param idAula
     * @param idUsuario
     * @return CarpetaDto 
    */
	@GetMapping( path = "/obtenerCalificaciones")
    public List<CalificacionDto> obtenerCalificaciones(@RequestParam("idAula") Long idAula,@RequestParam("idUsuario")  Long idUsuario){
		List<CalificacionDto> calificacionesDto = calificacionService.obtenerCalificaciones(idAula,idUsuario);    
    	return calificacionesDto;		
    }
	
	
}