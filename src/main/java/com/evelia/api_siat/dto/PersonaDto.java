package com.evelia.api_siat.dto;

import java.io.Serializable;

public class PersonaDto implements Serializable {

	  private Long personaId;
	  
	  private String apellido;
	  private String nombre;
	  private String email;
	  private String pathFoto;
	  
	  
	public Long getId() {
		return personaId;
	}
	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPathFoto() {
		return pathFoto;
	}
	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	  
	
}
