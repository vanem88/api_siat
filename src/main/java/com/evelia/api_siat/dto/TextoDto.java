package com.evelia.api_siat.dto;


import java.io.Serializable;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL) 
public class TextoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String titulo;
	private String contenido;
	
	private String nombreApellidoPersona;
	private String pathFoto;
	private java.sql.Timestamp fechaCreacion;
	private java.sql.Timestamp fechaUltimaModificacion;
	private String tipoPublicacion;
	private java.sql.Timestamp disponibleDesde;
	private java.sql.Timestamp disponibleHasta;	
    private List<ComentarioDto> comentarios;
	private String pathArchivo;
	
	//private String tipoEvento; //siempre null
	private String tipoEventoNivel;
	private boolean eliminado;
	private boolean generarAlerta;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public List<ComentarioDto> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<ComentarioDto> comentarios) {
		this.comentarios = comentarios;
	}
	public String getPathArchivo() {
		return pathArchivo;
	}
	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
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
	public String getTipoPublicacion() {
		return tipoPublicacion;
	}
	public void setTipoPublicacion(String tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}
	/*public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public Timestamp getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(Timestamp fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public Timestamp getFechaFinEvento() {
		return fechaFinEvento;
	}
	public void setFechaFinEvento(Timestamp fechaFinEvento) {
		this.fechaFinEvento = fechaFinEvento;
	}*/
	/*public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}*/
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	public boolean isGenerarAlerta() {
		return generarAlerta;
	}
	public void setGenerarAlerta(boolean generarAlerta) {
		this.generarAlerta = generarAlerta;
	}
	public String getTipoEventoNivel() {
		return tipoEventoNivel;
	}
	public void setTipoEventoNivel(String tipoEventoNivel) {
		this.tipoEventoNivel = tipoEventoNivel;
	}
	
	
	

	
	
	
}
