package com.evelia.api_siat.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "AGENDA", schema = "datosEveliaMinimo", catalog = "")
public class AgendaEntity implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private long agendaId;
    private Long id;
    private long personaId;
    private long contactoId;
    private PersonaEntity personaByPersonaId;
    private PersonaEntity personaByContactoId;

    @Id
    @Column(name = "AGENDA_ID")
    public long getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(long agendaId) {
        this.agendaId = agendaId;
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
    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "CONTACTO_ID")
    public long getContactoId() {
        return contactoId;
    }

    public void setContactoId(long contactoId) {
        this.contactoId = contactoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgendaEntity that = (AgendaEntity) o;

        if (agendaId != that.agendaId) return false;
        if (personaId != that.personaId) return false;
        if (contactoId != that.contactoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (agendaId ^ (agendaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (int) (personaId ^ (personaId >>> 32));
        result = 31 * result + (int) (contactoId ^ (contactoId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", nullable = false, insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "CONTACTO_ID", referencedColumnName = "PERSONA_ID", nullable = false, insertable=false, updatable=false)
    public PersonaEntity getPersonaByContactoId() {
        return personaByContactoId;
    }

    public void setPersonaByContactoId(PersonaEntity personaByContactoId) {
        this.personaByContactoId = personaByContactoId;
    }
}
