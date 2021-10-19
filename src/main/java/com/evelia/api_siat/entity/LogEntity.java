package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "LOG", schema = "datosEveliaMinimo", catalog = "")
public class LogEntity {
    private long logId;
    private byte[] detalle;
    private String estado;
    private Long id;
    private Long moduloId;
    private byte[] observaciones;
    private Long personaId;
    private String titulo;
    private ModuloEntity moduloByModuloId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "LOG_ID")
    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "DETALLE")
    public byte[] getDetalle() {
        return detalle;
    }

    public void setDetalle(byte[] detalle) {
        this.detalle = detalle;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    @Column(name = "MODULO_ID")
    public Long getModuloId() {
        return moduloId;
    }

    public void setModuloId(Long moduloId) {
        this.moduloId = moduloId;
    }

    @Basic
    @Column(name = "OBSERVACIONES")
    public byte[] getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(byte[] observaciones) {
        this.observaciones = observaciones;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "TITULO")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (logId != logEntity.logId) return false;
        if (!Arrays.equals(detalle, logEntity.detalle)) return false;
        if (estado != null ? !estado.equals(logEntity.estado) : logEntity.estado != null) return false;
        if (id != null ? !id.equals(logEntity.id) : logEntity.id != null) return false;
        if (moduloId != null ? !moduloId.equals(logEntity.moduloId) : logEntity.moduloId != null) return false;
        if (!Arrays.equals(observaciones, logEntity.observaciones)) return false;
        if (personaId != null ? !personaId.equals(logEntity.personaId) : logEntity.personaId != null) return false;
        if (titulo != null ? !titulo.equals(logEntity.titulo) : logEntity.titulo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (logId ^ (logId >>> 32));
        result = 31 * result + Arrays.hashCode(detalle);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (moduloId != null ? moduloId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(observaciones);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MODULO_ID", referencedColumnName = "MODULO_ID", insertable=false, updatable=false)
    public ModuloEntity getModuloByModuloId() {
        return moduloByModuloId;
    }

    public void setModuloByModuloId(ModuloEntity moduloByModuloId) {
        this.moduloByModuloId = moduloByModuloId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
