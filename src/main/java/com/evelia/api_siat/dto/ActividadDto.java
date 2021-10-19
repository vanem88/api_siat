package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.sql.Timestamp;


public class ActividadDto implements Serializable {
	
    private Long aulaId;
    private String descripcion;
    private Timestamp fechaApertura;
    private Timestamp fechaCierre;
    //private Long tipoCalificacionId;
    //private Long tipoActividadId;
    //private String alcance;
   // private String paraQuien;
    //private String modoRespuesta;
    private boolean borrador;
    private String detalles;
    //private Long notaAprobarId;
    private Long personaId;
    private String archivoAdjunto;
    
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
	/*public Long getTipoCalificacionId() {
		return tipoCalificacionId;
	}
	public void setTipoCalificacionId(Long tipoCalificacionId) {
		this.tipoCalificacionId = tipoCalificacionId;
	}
	public Long getTipoActividadId() {
		return tipoActividadId;
	}
	public void setTipoActividadId(Long tipoActividadId) {
		this.tipoActividadId = tipoActividadId;
	}
	public String getAlcance() {
		return alcance;
	}
	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}
	public String getParaQuien() {
		return paraQuien;
	}
	public void setParaQuien(String paraQuien) {
		this.paraQuien = paraQuien;
	}
	public String getModoRespuesta() {
		return modoRespuesta;
	}
	public void setModoRespuesta(String modoRespuesta) {
		this.modoRespuesta = modoRespuesta;
	}*/
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
	/*public Long getNotaAprobarId() {
		return notaAprobarId;
	}
	public void setNotaAprobarId(Long notaAprobarId) {
		this.notaAprobarId = notaAprobarId;
	}*/
	public Long getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}
	public String getArchivoAdjunto() {
		return archivoAdjunto;
	}
	public void setArchivoAdjunto(String archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}
   
	
	
	
}
