package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.util.Collection;

public class TextoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long aulaId;
	private Long id;
	private String titulo;
	private String contenido;
	private Long idPersona;
	private String nombreApellidoPersona;
	private String pathFoto;
	private java.sql.Timestamp fechaCreacion;
	private java.sql.Timestamp fechaUltimaModificacion;	
	private java.sql.Timestamp disponibleDesde;
	private java.sql.Timestamp disponibleHasta;	
	//Comentarios tiene el pizarron
	private Collection<ComentarioDto> comentarios;
	private String pathArchivo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombreApellidoPersona() {
		return nombreApellidoPersona;
	}
	public void setNombreApellidoPersona(String nombreApellidoPersona) {
		this.nombreApellidoPersona = nombreApellidoPersona;
	}
	public java.sql.Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(java.sql.Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public java.sql.Timestamp getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public void setFechaUltimaModificacion(java.sql.Timestamp fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}


	public Collection<ComentarioDto> getComentarios() {
		return comentarios;
	}
	public void setComentarios(Collection<ComentarioDto> comentarios) {
		this.comentarios = comentarios;
	}
	public String getPathArchivo() {
		return pathArchivo;
	}
	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}
	public Long getAulaId() {
		return aulaId;
	}
	public void setAulaId(Long aulaId) {
		this.aulaId = aulaId;
	}
	public String getPathFoto() {
		return pathFoto;
	}
	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}
	public java.sql.Timestamp getDisponibleDesde() {
		return disponibleDesde;
	}
	public void setDisponibleDesde(java.sql.Timestamp disponibleDesde) {
		this.disponibleDesde = disponibleDesde;
	}
	public java.sql.Timestamp getDisponibleHasta() {
		return disponibleHasta;
	}
	public void setDisponibleHasta(java.sql.Timestamp disponibleHasta) {
		this.disponibleHasta = disponibleHasta;
	}
	
	

	
	
	
}
