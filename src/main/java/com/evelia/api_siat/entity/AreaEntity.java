package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "AREA", schema = "datosEveliaMinimo", catalog = "")
public class AreaEntity {
    private long areaId;
    private String descripcion;
    private Long id;
    private Collection<AulaCompuestaEntity> aulaCompuestasByAreaId;
    private Collection<PersonaAreaInteresEntity> personaAreaInteresByAreaId;

    @Id
    @Column(name = "AREA_ID")
    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
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

        AreaEntity that = (AreaEntity) o;

        if (areaId != that.areaId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (areaId ^ (areaId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "areaByAreaId")
    public Collection<AulaCompuestaEntity> getAulaCompuestasByAreaId() {
        return aulaCompuestasByAreaId;
    }

    public void setAulaCompuestasByAreaId(Collection<AulaCompuestaEntity> aulaCompuestasByAreaId) {
        this.aulaCompuestasByAreaId = aulaCompuestasByAreaId;
    }

    @OneToMany(mappedBy = "areaByAreaId")
    public Collection<PersonaAreaInteresEntity> getPersonaAreaInteresByAreaId() {
        return personaAreaInteresByAreaId;
    }

    public void setPersonaAreaInteresByAreaId(Collection<PersonaAreaInteresEntity> personaAreaInteresByAreaId) {
        this.personaAreaInteresByAreaId = personaAreaInteresByAreaId;
    }
}
