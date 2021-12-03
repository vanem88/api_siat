package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;

public class MensajeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Timestamp fecha;
   // private String titulo;
    private String contenido;
    private String persona;
    private String pathFotoPerfil;
    private Collection<MensajeDto> mensajes = new HashSet();
    private String pathArchivo;
    
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	/*public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}*/
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public Collection<MensajeDto> getMensajes() {
		return mensajes;
	}
	public void setMensajes(Collection<MensajeDto> mensajes) {
		this.mensajes = mensajes;
	}
	public String getPathArchivo() {
		return pathArchivo;
	}
	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}
	public String getPathFotoPerfil() {
		return pathFotoPerfil;
	}
	public void setPathFotoPerfil(String pathFotoPerfil) {
		this.pathFotoPerfil = pathFotoPerfil;
	}
	
	
	
    
    
    
}