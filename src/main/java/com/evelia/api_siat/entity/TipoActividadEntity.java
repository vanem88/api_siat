package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_ACTIVIDAD", schema = "datosEveliaMinimo", catalog = "")
public class TipoActividadEntity {
    private long tipoActividadId;
    private Long id;
    private String nombre;
    private Collection<ActividadEntity> actividadsByTipoActividadId;

    @Id
    @Column(name = "TIPO_ACTIVIDAD_ID")
    public long getTipoActividadId() {
        return tipoActividadId;
    }

    public void setTipoActividadId(long tipoActividadId) {
        this.tipoActividadId = tipoActividadId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoActividadEntity that = (TipoActividadEntity) o;

        if (tipoActividadId != that.tipoActividadId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoActividadId ^ (tipoActividadId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoActividadByTipoActividadId")
    public Collection<ActividadEntity> getActividadsByTipoActividadId() {
        return actividadsByTipoActividadId;
    }

    public void setActividadsByTipoActividadId(Collection<ActividadEntity> actividadsByTipoActividadId) {
        this.actividadsByTipoActividadId = actividadsByTipoActividadId;
    }
}
