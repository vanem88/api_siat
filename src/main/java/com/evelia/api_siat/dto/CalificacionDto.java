package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

public class CalificacionDto implements Serializable {
	
	private Long idComision;
	private String titulo;//Actividad, examen, autoexamen, cuestionario
	private Timestamp fechaApertura;
	private Timestamp fechaCierre;
	private String autorCalificacion;
	private String personaRealizoEntrega;
	
	private String estadoCalificacion;
	private String calificacion;
	private String devolucioncalificacion;
	private Timestamp fechaEntrega;
	
	public Long getIdComision() {
		return idComision;
	}
	public void setIdComision(Long idComision) {
		this.idComision = idComision;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public String getAutorCalificacion() {
		return autorCalificacion;
	}
	public void setAutorCalificacion(String autorCalificacion) {
		this.autorCalificacion = autorCalificacion;
	}
	public String getPersonaRealizoEntrega() {
		return personaRealizoEntrega;
	}
	public void setPersonaRealizoEntrega(String personaRealizoEntrega) {
		this.personaRealizoEntrega = personaRealizoEntrega;
	}
	public String getEstadoCalificacion() {
		return estadoCalificacion;
	}
	public void setEstadoCalificacion(String estadoCalificacion) {
		this.estadoCalificacion = estadoCalificacion;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getDevolucioncalificacion() {
		return devolucioncalificacion;
	}
	public void setDevolucioncalificacion(String devolucioncalificacion) {
		this.devolucioncalificacion = devolucioncalificacion;
	}
	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Timestamp fechaEvtrega) {
		this.fechaEntrega = fechaEvtrega;
	}
	
	
	
}