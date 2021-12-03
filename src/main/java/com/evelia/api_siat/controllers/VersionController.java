package com.evelia.api_siat.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class VersionController {
	
	/**
     * Este endPoint devuelve la version de la API
     */
    @GetMapping( path = "/version")
    public String version() {  
        return "V1.1";
    }   
  
}