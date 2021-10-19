package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ESTADO_SOLICITUD_AULA", schema = "datosEveliaMinimo", catalog = "")
public class EstadoSolicitudAulaEntity {
    private long estadoSolicitudAulaId;
    private String descripcion;
    private Long id;
    private Collection<SolicitudAulaEntity> solicitudAulasByEstadoSolicitudAulaId;

    @Id
    @Column(name = "ESTADO_SOLICITUD_AULA_ID")
    public long getEstadoSolicitudAulaId() {
        return estadoSolicitudAulaId;
    }

    public void setEstadoSolicitudAulaId(long estadoSolicitudAulaId) {
        this.estadoSolicitudAulaId = estadoSolicitudAulaId;
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

        EstadoSolicitudAulaEntity that = (EstadoSolicitudAulaEntity) o;

        if (estadoSolicitudAulaId != that.estadoSolicitudAulaId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (estadoSolicitudAulaId ^ (estadoSolicitudAulaId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "estadoSolicitudAulaByEstadoSolicitudAulaId")
    public Collection<SolicitudAulaEntity> getSolicitudAulasByEstadoSolicitudAulaId() {
        return solicitudAulasByEstadoSolicitudAulaId;
    }

    public void setSolicitudAulasByEstadoSolicitudAulaId(Collection<SolicitudAulaEntity> solicitudAulasByEstadoSolicitudAulaId) {
        this.solicitudAulasByEstadoSolicitudAulaId = solicitudAulasByEstadoSolicitudAulaId;
    }
}
