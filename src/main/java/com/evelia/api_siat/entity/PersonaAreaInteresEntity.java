package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PERSONA_AREA_INTERES", schema = "datosEveliaMinimo", catalog = "")
public class PersonaAreaInteresEntity {
    private long personaAreaInteresId;
    private Long areaId;
    private Long id;
    private Long personaId;
    private AreaEntity areaByAreaId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "PERSONA_AREA_INTERES_ID")
    public long getPersonaAreaInteresId() {
        return personaAreaInteresId;
    }

    public void setPersonaAreaInteresId(long personaAreaInteresId) {
        this.personaAreaInteresId = personaAreaInteresId;
    }

    @Basic
    @Column(name = "AREA_ID")
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
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
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaAreaInteresEntity that = (PersonaAreaInteresEntity) o;

        if (personaAreaInteresId != that.personaAreaInteresId) return false;
        if (areaId != null ? !areaId.equals(that.areaId) : that.areaId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personaAreaInteresId ^ (personaAreaInteresId >>> 32));
        result = 31 * result + (areaId != null ? areaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID", insertable=false, updatable=false)
    public AreaEntity getAreaByAreaId() {
        return areaByAreaId;
    }

    public void setAreaByAreaId(AreaEntity areaByAreaId) {
        this.areaByAreaId = areaByAreaId;
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
