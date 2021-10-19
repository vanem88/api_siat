package com.evelia.api_siat.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AulaCompuestaDto implements Serializable {

	@JsonProperty("id")
	private long aulaCompuestaId;
	private String nombre;   
    private String facultad;
    private String docente;
   	
	public long getAulaCompuestaId() {
		return aulaCompuestaId;
	}
	public void setAulaCompuestaId(long aulaCompuestaId) {
		this.aulaCompuestaId = aulaCompuestaId;
	}
	public String getNombre() {		
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFacultad() {
		return facultad;	
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	
	
	
    	  
}
