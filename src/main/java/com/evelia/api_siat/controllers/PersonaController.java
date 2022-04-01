package com.evelia.api_siat.controllers;

import com.evelia.api_siat.dto.PersonaDto;
import com.evelia.api_siat.services.PersonaService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;
    
    /**
     * Este endPoint se encarga de obtener el usuario dado su id
     * @param id del usuario
     * @return PersonaDto
    */
    @GetMapping( path = "/{id}")
    public PersonaDto obtenerUsuarioPorId(@PathVariable("id") Long id) {  
        return this.personaService.obtenerPorId(id);
    }
    
    @PutMapping(path = "/modificarPerfil")
    public boolean modificarPerfil(@RequestParam(value ="idPersona",required = true) Long idPersona,@RequestParam("email") String email,@RequestParam("fotoPerfil") String fotoPerfil){
   	 	System.out.println("modificarPerfil");
   	 	return this.personaService.modificarPerfil(idPersona,email,fotoPerfil);
    }
    
    
 /*@PostMapping(path = "/save")
     public PersonaDto guardarUsuario(@RequestBody Persona usuario){
    	 System.out.println("guardarUsuario");
    	 return this.personaService.guardarUsuario(usuario);
     }
     
     @PutMapping(path = "/update/{id}")
     //public boolean actualizarUsuario(@PathVariable("id") Long id,@RequestBody Persona usuario){
     public boolean actualizarUsuario(@PathVariable("id") Long id,@RequestBody PersonaEntity usuario){
    	 System.out.println("actualizarUsuario");
    	 return this.personaService.actualizarUsuario(id,usuario);
     }*/
   
       
    // @GetMapping()
    // public ArrayList<PersonaDto> obtenerPersonas(){
    //     return personaService.obtenerPersonas();
    // }

    // @PostMapping()
    // public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
    //     return this.usuarioService.guardarUsuario(usuario);
    // }
   

    // @GetMapping("/query")
    // public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
    //     return this.usuarioService.obtenerPorPrioridad(prioridad);
    // }

    // @DeleteMapping( path = "/{id}")
    // public String eliminarPorId(@PathVariable("id") Long id){
    //     boolean ok = this.usuarioService.eliminarUsuario(id);
    //     if (ok){
    //         return "Se eliminó el usuario con id " + id;
    //     }else{
    //         return "No pudo eliminar el usuario con id" + id;
    //     }
    // }

}