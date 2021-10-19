package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.util.Collection;

import com.evelia.api_siat.entity.ComentarioEntity;

public class EventoDto implements Serializable {

	private Long id;
	private String titulo;
	private String contenido;
	private Long idPersona;
	private String nombreApellidoPersona;
	private java.sql.Timestamp fechaCreacion;
	//private java.sql.Timestamp fechaUltimaModificacion;
	
	private boolean eliminado; 			
	private String tipoEvento;
	private java.sql.Timestamp fechaEvento;
	private java.sql.Timestamp fechaFinEvento;
	private boolean generarAlerta;
	private Long idEventoRepeticion;
	
	private String tipoEventoNivel;
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
	/*public java.sql.Timestamp getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public void setFechaUltimaModificacion(java.sql.Timestamp fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}*/
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public java.sql.Timestamp getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(java.sql.Timestamp fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public java.sql.Timestamp getFechaFinEvento() {
		return fechaFinEvento;
	}
	public void setFechaFinEvento(java.sql.Timestamp fechaFinEvento) {
		this.fechaFinEvento = fechaFinEvento;
	}
	public boolean isGenerarAlerta() {
		return generarAlerta;
	}
	public void setGenerarAlerta(boolean generarAlerta) {
		this.generarAlerta = generarAlerta;
	}
	public Long getIdEventoRepeticion() {
		return idEventoRepeticion;
	}
	public void setIdEventoRepeticion(Long idEventoRepeticion) {
		this.idEventoRepeticion = idEventoRepeticion;
	}
	public String getTipoEventoNivel() {
		return tipoEventoNivel;
	}
	public void setTipoEventoNivel(String tipoEventoNivel) {
		this.tipoEventoNivel = tipoEventoNivel;
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

	
	
	
}
