package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ARCHIVO_VERSIONADO", schema = "datosEveliaMinimo", catalog = "")
public class ArchivoVersionadoEntity {
    private long archivoVersionadoId;
    private Long archivoId;
    private Long autorId;
    private Integer cantidadDownloads;
    private Boolean compartido;
    private String descripcion;
    private Boolean escaneadoOk;
    private Timestamp fechaUp;
    private Long id;
    private String nombre;
    private int nroVersion;
    private Double tamanio;
    private String tiempoEstimado;
    private ArchivoEntity archivoByArchivoId;
    private PersonaEntity personaByAutorId;

    @Id
    @Column(name = "ARCHIVO_VERSIONADO_ID")
    public long getArchivoVersionadoId() {
        return archivoVersionadoId;
    }

    public void setArchivoVersionadoId(long archivoVersionadoId) {
        this.archivoVersionadoId = archivoVersionadoId;
    }

    @Basic
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
    }

    @Basic
    @Column(name = "AUTOR_ID")
    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    @Basic
    @Column(name = "CANTIDAD_DOWNLOADS")
    public Integer getCantidadDownloads() {
        return cantidadDownloads;
    }

    public void setCantidadDownloads(Integer cantidadDownloads) {
        this.cantidadDownloads = cantidadDownloads;
    }

    @Basic
    @Column(name = "COMPARTIDO")
    public Boolean getCompartido() {
        return compartido;
    }

    public void setCompartido(Boolean compartido) {
        this.compartido = compartido;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ESCANEADO_OK")
    public Boolean getEscaneadoOk() {
        return escaneadoOk;
    }

    public void setEscaneadoOk(Boolean escaneadoOk) {
        this.escaneadoOk = escaneadoOk;
    }

    @Basic
    @Column(name = "FECHA_UP")
    public Timestamp getFechaUp() {
        return fechaUp;
    }

    public void setFechaUp(Timestamp fechaUp) {
        this.fechaUp = fechaUp;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "NRO_VERSION")
    public int getNroVersion() {
        return nroVersion;
    }

    public void setNroVersion(int nroVersion) {
        this.nroVersion = nroVersion;
    }

    @Basic
    @Column(name = "TAMANIO")
    public Double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    @Basic
    @Column(name = "TIEMPO_ESTIMADO")
    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArchivoVersionadoEntity that = (ArchivoVersionadoEntity) o;

        if (archivoVersionadoId != that.archivoVersionadoId) return false;
        if (nroVersion != that.nroVersion) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (autorId != null ? !autorId.equals(that.autorId) : that.autorId != null) return false;
        if (cantidadDownloads != null ? !cantidadDownloads.equals(that.cantidadDownloads) : that.cantidadDownloads != null)
            return false;
        if (compartido != null ? !compartido.equals(that.compartido) : that.compartido != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (escaneadoOk != null ? !escaneadoOk.equals(that.escaneadoOk) : that.escaneadoOk != null) return false;
        if (fechaUp != null ? !fechaUp.equals(that.fechaUp) : that.fechaUp != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (tamanio != null ? !tamanio.equals(that.tamanio) : that.tamanio != null) return false;
        if (tiempoEstimado != null ? !tiempoEstimado.equals(that.tiempoEstimado) : that.tiempoEstimado != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (archivoVersionadoId ^ (archivoVersionadoId >>> 32));
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        result = 31 * result + (cantidadDownloads != null ? cantidadDownloads.hashCode() : 0);
        result = 31 * result + (compartido != null ? compartido.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (escaneadoOk != null ? escaneadoOk.hashCode() : 0);
        result = 31 * result + (fechaUp != null ? fechaUp.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + nroVersion;
        result = 31 * result + (tamanio != null ? tamanio.hashCode() : 0);
        result = 31 * result + (tiempoEstimado != null ? tiempoEstimado.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAutorId() {
        return personaByAutorId;
    }

    public void setPersonaByAutorId(PersonaEntity personaByAutorId) {
        this.personaByAutorId = personaByAutorId;
    }
}
