package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PERSONA_ARCHIVO_COMPARTIDA", schema = "datosEveliaMinimo", catalog = "")
public class PersonaArchivoCompartidaEntity {
    private long personaArchivoCompartidaId;
    private Long archivoId;
    private Long id;
    private Long personaId;
    private Long personaDueniaDelArchivoId;
    private ArchivoEntity archivoByArchivoId;
    private PersonaEntity personaByPersonaId;
    private PersonaEntity personaByPersonaDueniaDelArchivoId;

    @Id
    @Column(name = "PERSONA_ARCHIVO_COMPARTIDA_ID")
    public long getPersonaArchivoCompartidaId() {
        return personaArchivoCompartidaId;
    }

    public void setPersonaArchivoCompartidaId(long personaArchivoCompartidaId) {
        this.personaArchivoCompartidaId = personaArchivoCompartidaId;
    }

    @Basic
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
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

    @Basic
    @Column(name = "PERSONA_DUENIA_DEL_ARCHIVO_ID")
    public Long getPersonaDueniaDelArchivoId() {
        return personaDueniaDelArchivoId;
    }

    public void setPersonaDueniaDelArchivoId(Long personaDueniaDelArchivoId) {
        this.personaDueniaDelArchivoId = personaDueniaDelArchivoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaArchivoCompartidaEntity that = (PersonaArchivoCompartidaEntity) o;

        if (personaArchivoCompartidaId != that.personaArchivoCompartidaId) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (personaDueniaDelArchivoId != null ? !personaDueniaDelArchivoId.equals(that.personaDueniaDelArchivoId) : that.personaDueniaDelArchivoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personaArchivoCompartidaId ^ (personaArchivoCompartidaId >>> 32));
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (personaDueniaDelArchivoId != null ? personaDueniaDelArchivoId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_DUENIA_DEL_ARCHIVO_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaDueniaDelArchivoId() {
        return personaByPersonaDueniaDelArchivoId;
    }

    public void setPersonaByPersonaDueniaDelArchivoId(PersonaEntity personaByPersonaDueniaDelArchivoId) {
        this.personaByPersonaDueniaDelArchivoId = personaByPersonaDueniaDelArchivoId;
    }
}
