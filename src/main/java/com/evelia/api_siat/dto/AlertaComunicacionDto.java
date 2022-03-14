package com.evelia.api_siat.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class AlertaComunicacionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long alertId;
	private String textoAlerta;
	private java.sql.Timestamp fecha;
	private String tipoElemento;
	private ArchivoDto archivo;	
	private TextoDto publicacion;
	private ComentarioDto comentario;
	
	
	public long getAlertId() {
		return alertId;
	}
	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}
	public String getTextoAlerta() {
		return textoAlerta;
	}
	public void setTextoAlerta(String textoAlerta) {
		this.textoAlerta = textoAlerta;
	}
	public java.sql.Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(java.sql.Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getTipoElemento() {
		return tipoElemento;
	}
	public void setTipoElemento(String tipoElemento) {
		this.tipoElemento = tipoElemento;
	}
	public ArchivoDto getArchivo() {
		return archivo;
	}
	public void setArchivo(ArchivoDto archivo) {
		this.archivo = archivo;
	}
	public TextoDto getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(TextoDto publicacion) {
		this.publicacion = publicacion;
	}
	public ComentarioDto getComentario() {
		return comentario;
	}
	public void setComentario(ComentarioDto comentario) {
		this.comentario = comentario;
	}
	
}
