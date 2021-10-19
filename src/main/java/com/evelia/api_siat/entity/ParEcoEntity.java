package com.evelia.api_siat.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "PAR_ECO", schema = "datosEveliaMinimo", catalog = "")
public class ParEcoEntity {
    @Id
    private String personaId;

    @Basic
    @Column(name = "PERSONA_ID")
    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParEcoEntity that = (ParEcoEntity) o;

        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return personaId != null ? personaId.hashCode() : 0;
    }
}
