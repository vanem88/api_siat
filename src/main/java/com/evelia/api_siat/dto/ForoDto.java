package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

public class ForoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private long idAula;
	private String asunto;
	private String nombreAutor;
	private String pathFotoPerfil;	
	private Timestamp fechaCreacion;
    private Timestamp fechaDesde;
    private Timestamp fechaHasta;
    private String pathArchivo;
    private Collection<MensajeDto> mensajes;
    
    private String tipoEventoNivel;
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getPathArchivo() {
		return pathArchivo;
	}
	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}
		
	public Collection<MensajeDto> getMensajes() {
		return mensajes;
	}
	public void setMensajes(Collection<MensajeDto> mensajesByForoId) {
		this.mensajes = mensajesByForoId;
	}
	public String getTipoEventoNivel() {
		return tipoEventoNivel;
	}
	public void setTipoEventoNivel(String tipoEventoNivel) {
		this.tipoEventoNivel = tipoEventoNivel;
	}
	public Timestamp getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Timestamp fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Timestamp getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Timestamp fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public long getIdAula() {
		return idAula;
	}
	public void setIdAula(long idAula) {
		this.idAula = idAula;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getPathFotoPerfil() {
		return pathFotoPerfil;
	}
	public void setPathFotoPerfil(String pathFotoPerfil) {
		this.pathFotoPerfil = pathFotoPerfil;
	}
	
	
	
	
    
    

}