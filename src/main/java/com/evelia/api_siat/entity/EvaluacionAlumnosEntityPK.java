package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EvaluacionAlumnosEntityPK implements Serializable {
    private long evaluacionId;
    private long personaId;

    @Column(name = "EVALUACION_ID")
    @Id
    public long getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @Column(name = "PERSONA_ID")
    @Id
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

        EvaluacionAlumnosEntityPK that = (EvaluacionAlumnosEntityPK) o;

        if (evaluacionId != that.evaluacionId) return false;
        if (personaId != that.personaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (evaluacionId ^ (evaluacionId >>> 32));
        result = 31 * result + (int) (personaId ^ (personaId >>> 32));
        return result;
    }
}
