package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ID_OBJETO", schema = "datosEveliaMinimo", catalog = "")
public class IdObjetoEntity {
    private long idObjetoId;
    private Long id;
    private String nombreClase;

    @Id
    @Column(name = "ID_OBJETO_ID")
    public long getIdObjetoId() {
        return idObjetoId;
    }

    public void setIdObjetoId(long idObjetoId) {
        this.idObjetoId = idObjetoId;
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
    @Column(name = "NOMBRE_CLASE")
    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdObjetoEntity that = (IdObjetoEntity) o;

        if (idObjetoId != that.idObjetoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombreClase != null ? !nombreClase.equals(that.nombreClase) : that.nombreClase != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idObjetoId ^ (idObjetoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombreClase != null ? nombreClase.hashCode() : 0);
        return result;
    }
}
