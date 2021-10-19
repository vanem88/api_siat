package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ESTADO_AULA", schema = "datosEveliaMinimo", catalog = "")
public class EstadoAulaEntity {
    private long estadoAulaId;
    private String descripcion;
    private Long id;
    private Collection<AulaCompuestaEntity> aulaCompuestasByEstadoAulaId;
    private Collection<GrupoEntity> gruposByEstadoAulaId;

    @Id
    @Column(name = "ESTADO_AULA_ID")
    public long getEstadoAulaId() {
        return estadoAulaId;
    }

    public void setEstadoAulaId(long estadoAulaId) {
        this.estadoAulaId = estadoAulaId;
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
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoAulaEntity that = (EstadoAulaEntity) o;

        if (estadoAulaId != that.estadoAulaId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (estadoAulaId ^ (estadoAulaId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "estadoAulaByEstadoAulaId")
    public Collection<AulaCompuestaEntity> getAulaCompuestasByEstadoAulaId() {
        return aulaCompuestasByEstadoAulaId;
    }

    public void setAulaCompuestasByEstadoAulaId(Collection<AulaCompuestaEntity> aulaCompuestasByEstadoAulaId) {
        this.aulaCompuestasByEstadoAulaId = aulaCompuestasByEstadoAulaId;
    }

    @OneToMany(mappedBy = "estadoAulaByEstadoGrupoId")
    public Collection<GrupoEntity> getGruposByEstadoAulaId() {
        return gruposByEstadoAulaId;
    }

    public void setGruposByEstadoAulaId(Collection<GrupoEntity> gruposByEstadoAulaId) {
        this.gruposByEstadoAulaId = gruposByEstadoAulaId;
    }
}
