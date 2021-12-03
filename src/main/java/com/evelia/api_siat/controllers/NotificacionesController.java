package com.evelia.api_siat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.evelia.api_siat.dto.AlertaComunicacionDto;
import com.evelia.api_siat.services.NotificacionesService;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {
	
	@Autowired
	NotificacionesService notificacionesService;
	
	/**
     * Este servicio devuelve todos las alertas generadas cuando se actualiza alguna comunicacion (Noticia, Faq, etc)
     * @param idAula por url
     * @return Json con todas las alertas
    */
	@GetMapping( path = "/alertasComunicaciones")
    public List<AlertaComunicacionDto> obtenerAlertasComunicaciones(@RequestParam("idAula") Long idAula,@RequestParam("idUsuario") Long idUsuario) {
		List<AlertaComunicacionDto> alertas = notificacionesService.obtenerAlertasComunicaciones(idAula,idUsuario);
		return alertas;   		
    }
  
}