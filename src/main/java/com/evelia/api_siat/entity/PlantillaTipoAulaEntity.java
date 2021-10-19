package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PLANTILLA_TIPO_AULA", schema = "datosEveliaMinimo", catalog = "")
public class PlantillaTipoAulaEntity {
    private long plantillaTipoAulaId;
    private Long id;
    private String nombre;
    private Long tipoAulaId;

    @Id
    @Column(name = "PLANTILLA_TIPO_AULA_ID")
    public long getPlantillaTipoAulaId() {
        return plantillaTipoAulaId;
    }

    public void setPlantillaTipoAulaId(long plantillaTipoAulaId) {
        this.plantillaTipoAulaId = plantillaTipoAulaId;
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
    @Column(name = "TIPO_AULA_ID")
    public Long getTipoAulaId() {
        return tipoAulaId;
    }

    public void setTipoAulaId(Long tipoAulaId) {
        this.tipoAulaId = tipoAulaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlantillaTipoAulaEntity that = (PlantillaTipoAulaEntity) o;

        if (plantillaTipoAulaId != that.plantillaTipoAulaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (tipoAulaId != null ? !tipoAulaId.equals(that.tipoAulaId) : that.tipoAulaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (plantillaTipoAulaId ^ (plantillaTipoAulaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (tipoAulaId != null ? tipoAulaId.hashCode() : 0);
        return result;
    }
}
