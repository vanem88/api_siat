package com.evelia.api_siat.dto;


import java.io.Serializable;
import java.sql.Timestamp;

//@JsonInclude(JsonInclude.Include.NON_NULL) 
public class ComentarioDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private Timestamp fecha;
    private String contenido;
    private String nombreApellidoPersona;
    private String pathfotoperfil;
    private Long textoPadreId; 
    private Long comentarioPadreId; 
    //private List<ComentarioDto> comentarios = new ArrayList<ComentarioDto>();
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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
	public String getPathfotoperfil() {
		return pathfotoperfil;
	}
	public void setPathfotoperfil(String pathfotoperfil) {
		this.pathfotoperfil = pathfotoperfil;
	}
	
		
	public Long getTextoPadreId() {
		return textoPadreId;
	}
	/*public List<ComentarioDto> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<ComentarioDto> comentarios) {
		this.comentarios = comentarios;
	}*/
	public void setTextoPadreId(Long textoPadreId) {
		this.textoPadreId = textoPadreId;
	}
	public Long getComentarioPadreId() {
		return comentarioPadreId;
	}
	public void setComentarioPadreId(Long comentarioPadreId) {
		this.comentarioPadreId = comentarioPadreId;
	}
}
