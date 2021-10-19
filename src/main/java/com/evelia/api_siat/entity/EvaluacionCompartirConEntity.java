package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "EVALUACION_COMPARTIR_CON", schema = "datosEveliaMinimo", catalog = "")
@IdClass(EvaluacionCompartirConEntityPK.class)
public class EvaluacionCompartirConEntity {
    private long evaluacionId;
    private long personaId;
    private EvaluacionEntity evaluacionByEvaluacionId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "EVALUACION_ID")
    public long getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @Id
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

        EvaluacionCompartirConEntity that = (EvaluacionCompartirConEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "EVALUACION_ID", referencedColumnName = "EVALUACION_ID", nullable = false, insertable=false, updatable=false)
    public EvaluacionEntity getEvaluacionByEvaluacionId() {
        return evaluacionByEvaluacionId;
    }

    public void setEvaluacionByEvaluacionId(EvaluacionEntity evaluacionByEvaluacionId) {
        this.evaluacionByEvaluacionId = evaluacionByEvaluacionId;
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
