package com.evelia.api_siat.dto;

import java.io.Serializable;

public class ArchivoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
    private String descripcion;
    private String URL;
    private String fechaUP;
    private String tamanio;
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getFechaUP() {
		return fechaUP;
	}
	public void setFechaUP(String fechaUP) {
		this.fechaUP = fechaUP;
	}
	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
    
    

    
}