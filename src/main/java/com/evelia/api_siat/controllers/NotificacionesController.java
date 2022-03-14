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
     * @param idAula
     * @return Json con todas las alertas
    */
	@GetMapping( path = "/alertasComunicaciones")
    public List<AlertaComunicacionDto> obtenerAlertasComunicaciones(@RequestParam("idAula") Long idAula,@RequestParam(value="idComision",required=false) Long idComision,@RequestParam("idUsuario") Long idUsuario) {
		List<AlertaComunicacionDto> alertas = notificacionesService.obtenerAlertasComunicaciones2(idAula,idComision,idUsuario);
		return alertas;   		
    }
	
	/**
     * Este servicio elimina las alertas que no fueron visualizadas durante una cantidad de dias
    */
	@DeleteMapping( path = "/eliminarAlertas")
    public void eliminarAlertas(@RequestParam("cantDias") int cantDias) {
		notificacionesService.eliminaAlertasNoVisualizadas(cantDias);		   		
    }
  
}