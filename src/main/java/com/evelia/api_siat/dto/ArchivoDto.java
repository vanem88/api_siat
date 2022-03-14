package com.evelia.api_siat.dto;

import java.io.Serializable;


public class ArchivoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
    private String descripcion;
    private String URL;
    private java.sql.Timestamp fechaUP;
    private Double tamanio;
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public java.sql.Timestamp getFechaUP() {
		return fechaUP;
	}
	public void setFechaUP(java.sql.Timestamp fechaUP) {
		this.fechaUP = fechaUP;
	}
	public Double getTamanio() {
		return tamanio;
	}
	public void setTamanio(Double tamanio) {
		this.tamanio = tamanio;
	}  
    

    
}