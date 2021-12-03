package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ComentarioDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Timestamp fecha;
    private String contenido;
    private String nombreApellidoPersona;
    private String pathfotoperfil;
  	
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getNombreApellidoPersona() {
		return nombreApellidoPersona;
	}
	public void setNombreApellidoPersona(String nombreApellidoPersona) {
		this.nombreApellidoPersona = nombreApellidoPersona;
	}
	public String getPathfotoperfil() {
		return pathfotoperfil;
	}
	public void setPathfotoperfil(String pathfotoperfil) {
		this.pathfotoperfil = pathfotoperfil;
	}
	
    
    
}
