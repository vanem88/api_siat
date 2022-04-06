package com.evelia.api_siat.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.evelia.api_siat.services.ActividadService;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
    ActividadService actividadService;
	
	/**
     * Servicio que genera la entrega de una actividad por parte de un estudiante
     */
	@PostMapping( path = "/entregarActividad")
    public String entregarActividad(@RequestParam(value ="idPersona",required = true) Long idPersona,
    		                        @RequestParam(value ="idActividad",required = true) Long idActividad,
    		                        @RequestParam("comentario") String comentario,
    		                        @RequestParam(value ="archivo",required = true) MultipartFile archivosEntregados) {
		try {
			return actividadService.entregarActividad(idPersona,idActividad, comentario, archivosEntregados);			
		}catch(Exception ex) {
			return "Exception: "+ex.getMessage();
		}
    }
	

}
