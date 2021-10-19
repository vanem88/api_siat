package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ESTADO_CALIFICACION", schema = "datosEveliaMinimo", catalog = "")
public class EstadoCalificacionEntity {
    private long estadoCalificacionId;
    private Long id;
    private String nombre;
    private Integer orden;
    private Collection<CalificacionActividadEntity> calificacionActividadsByEstadoCalificacionId;

    @Id
    @Column(name = "ESTADO_CALIFICACION_ID")
    public long getEstadoCalificacionId() {
        return estadoCalificacionId;
    }

    public void setEstadoCalificacionId(long estadoCalificacionId) {
        this.estadoCalificacionId = estadoCalificacionId;
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
    @Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoCalificacionEntity that = (EstadoCalificacionEntity) o;

        if (estadoCalificacionId != that.estadoCalificacionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (estadoCalificacionId ^ (estadoCalificacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "estadoCalificacionByEstadoCalificacionId")
    public Collection<CalificacionActividadEntity> getCalificacionActividadsByEstadoCalificacionId() {
        return calificacionActividadsByEstadoCalificacionId;
    }

    public void setCalificacionActividadsByEstadoCalificacionId(Collection<CalificacionActividadEntity> calificacionActividadsByEstadoCalificacionId) {
        this.calificacionActividadsByEstadoCalificacionId = calificacionActividadsByEstadoCalificacionId;
    }
}
