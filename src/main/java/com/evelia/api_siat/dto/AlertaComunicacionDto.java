package com.evelia.api_siat.dto;

import java.io.Serializable;


public class AlertaComunicacionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String textoAlerta;
	private java.sql.Timestamp fecha;
	private String tipoElemento;
	private Long idElemento;
		
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
	public Long getIdElemento() {
		return idElemento;
	}
	public void setIdElemento(Long idElemento) {
		this.idElemento = idElemento;
	}
		
	
}
