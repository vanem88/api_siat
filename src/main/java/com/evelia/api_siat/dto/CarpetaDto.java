package com.evelia.api_siat.dto;


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class CarpetaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
    private Collection<ArchivoDto> archivos = new HashSet<ArchivoDto>();
    private Collection<CarpetaDto> subcarpetas = new HashSet<CarpetaDto>();
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Collection<ArchivoDto> getArchivos() {
		return archivos;
	}
	public void setArchivos(Collection<ArchivoDto> archivos) {
		this.archivos = archivos;
	}
	public Collection<CarpetaDto> getSubcarpetas() {
		return subcarpetas;
	}
	public void setSubcarpetas(Collection<CarpetaDto> subcarpetas) {
		this.subcarpetas = subcarpetas;
	}
    
    
    
}