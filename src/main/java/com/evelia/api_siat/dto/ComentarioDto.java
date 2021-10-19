package com.evelia.api_siat.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import com.evelia.api_siat.entity.ArchivoEntity;
import com.evelia.api_siat.entity.ComentarioEntity;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.entity.TextoEntity;

public class ComentarioDto implements Serializable {

    private Timestamp fecha;
    private String contenido;
    private String nombreApellidoPersona;
    /*private Long archivoId;
    private Long textoPadreId;
    private Long comentPadreId;
    private PersonaEntity personaByPersonaId;
    private ArchivoEntity archivoByArchivoId;
    private TextoEntity textoByTextoPadreId;
    private ComentarioEntity comentarioByComentPadreId;
    private Collection<ComentarioEntity> comentariosByComentarioId;*/
    
	
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
    
    
}
