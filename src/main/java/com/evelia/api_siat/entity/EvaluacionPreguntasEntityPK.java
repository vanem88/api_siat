package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EvaluacionPreguntasEntityPK implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private long evaluacionId;
    private long preguntaExId;

    @Column(name = "EVALUACION_ID")
    @Id
    public long getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @Column(name = "PREGUNTA_EX_ID")
    @Id
    public long getPreguntaExId() {
        return preguntaExId;
    }

    public void setPreguntaExId(long preguntaExId) {
        this.preguntaExId = preguntaExId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluacionPreguntasEntityPK that = (EvaluacionPreguntasEntityPK) o;

        if (evaluacionId != that.evaluacionId) return false;
        if (preguntaExId != that.preguntaExId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (evaluacionId ^ (evaluacionId >>> 32));
        result = 31 * result + (int) (preguntaExId ^ (preguntaExId >>> 32));
        return result;
    }
}
