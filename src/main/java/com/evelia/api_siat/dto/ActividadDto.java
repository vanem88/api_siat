package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ActividadDto implements Serializable {
	
  	private static final long serialVersionUID = 1L;
	private Long aulaId;
    private String descripcion;
    private Timestamp fechaApertura;
    private Timestamp fechaCierre;
    private boolean borrador;
    private String detalles;
    private String persona;
    private String pathFotoPerfil;
    private String archivoAdjunto;
    private Long actividadid;
    
	public Long getAulaId() {
		return aulaId;
	}
	public void setAulaId(Long aulaId) {
		this.aulaId = aulaId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Timestamp getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Timestamp fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public Timestamp getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Timestamp fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public boolean isBorrador() {
		return borrador;
	}
	public void setBorrador(boolean borrador) {
		this.borrador = borrador;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getArchivoAdjunto() {
		return archivoAdjunto;
	}
	public void setArchivoAdjunto(String archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public String getPathFotoPerfil() {
		return pathFotoPerfil;
	}
	public void setPathFotoPerfil(String pathFotoPerfil) {
		this.pathFotoPerfil = pathFotoPerfil;
	}
	public Long getActividadid() {
		return actividadid;
	}
	public void setActividadid(Long actividadid) {
		this.actividadid = actividadid;
	}
	
	
   
	
	
	
}
