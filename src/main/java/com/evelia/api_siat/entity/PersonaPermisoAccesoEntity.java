package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PERSONA_PERMISO_ACCESO", schema = "datosEveliaMinimo", catalog = "")
public class PersonaPermisoAccesoEntity {
    private long personaPermisoAccesoId;
    private Long id;
    private Long permisoAccesoId;
    private Long personaId;
    private PermisoAccesoEntity permisoAccesoByPermisoAccesoId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "PERSONA_PERMISO_ACCESO_ID")
    public long getPersonaPermisoAccesoId() {
        return personaPermisoAccesoId;
    }

    public void setPersonaPermisoAccesoId(long personaPermisoAccesoId) {
        this.personaPermisoAccesoId = personaPermisoAccesoId;
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
    @Column(name = "PERMISO_ACCESO_ID")
    public Long getPermisoAccesoId() {
        return permisoAccesoId;
    }

    public void setPermisoAccesoId(Long permisoAccesoId) {
        this.permisoAccesoId = permisoAccesoId;
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

        PersonaPermisoAccesoEntity that = (PersonaPermisoAccesoEntity) o;

        if (personaPermisoAccesoId != that.personaPermisoAccesoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (permisoAccesoId != null ? !permisoAccesoId.equals(that.permisoAccesoId) : that.permisoAccesoId != null)
            return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personaPermisoAccesoId ^ (personaPermisoAccesoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (permisoAccesoId != null ? permisoAccesoId.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PERMISO_ACCESO_ID", referencedColumnName = "PERMISO_ACCESO_ID", insertable=false, updatable=false)
    public PermisoAccesoEntity getPermisoAccesoByPermisoAccesoId() {
        return permisoAccesoByPermisoAccesoId;
    }

    public void setPermisoAccesoByPermisoAccesoId(PermisoAccesoEntity permisoAccesoByPermisoAccesoId) {
        this.permisoAccesoByPermisoAccesoId = permisoAccesoByPermisoAccesoId;
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
