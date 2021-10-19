package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_SECCION", schema = "datosEveliaMinimo", catalog = "")
public class TipoSeccionEntity {
    private long tipoSeccionId;
    private Long id;
    private String nombre;

    @Id
    @Column(name = "TIPO_SECCION_ID")
    public long getTipoSeccionId() {
        return tipoSeccionId;
    }

    public void setTipoSeccionId(long tipoSeccionId) {
        this.tipoSeccionId = tipoSeccionId;
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

        TipoSeccionEntity that = (TipoSeccionEntity) o;

        if (tipoSeccionId != that.tipoSeccionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoSeccionId ^ (tipoSeccionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
