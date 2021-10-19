package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "FORO_MODERADORES", schema = "datosEveliaMinimo", catalog = "")
public class ForoModeradoresEntity {
    
    private long foroId;
    private long personaId;
    private ForoEntity foroByForoId;
    private PersonaEntity personaByPersonaId;

    @Basic
    @Id
    @Column(name = "FORO_ID")
    public long getForoId() {
        return foroId;
    }

    public void setForoId(long foroId) {
        this.foroId = foroId;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForoModeradoresEntity that = (ForoModeradoresEntity) o;

        if (foroId != that.foroId) return false;
        if (personaId != that.personaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (foroId ^ (foroId >>> 32));
        result = 31 * result + (int) (personaId ^ (personaId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "FORO_ID", referencedColumnName = "FORO_ID", nullable = false, insertable=false, updatable=false)
    public ForoEntity getForoByForoId() {
        return foroByForoId;
    }

    public void setForoByForoId(ForoEntity foroByForoId) {
        this.foroByForoId = foroByForoId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", nullable = false, insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
