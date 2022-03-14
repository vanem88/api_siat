package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EvaluacionCategoriasEvalEntityPK implements Serializable {
   
	private static final long serialVersionUID = 1L;
	private long evaluacionId;
    private long categoriaPreguntaId;

    @Column(name = "EVALUACION_ID")
    @Id
    public long getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @Column(name = "CATEGORIA_PREGUNTA_ID")
    @Id
    public long getCategoriaPreguntaId() {
        return categoriaPreguntaId;
    }

    public void setCategoriaPreguntaId(long categoriaPreguntaId) {
        this.categoriaPreguntaId = categoriaPreguntaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluacionCategoriasEvalEntityPK that = (EvaluacionCategoriasEvalEntityPK) o;

        if (evaluacionId != that.evaluacionId) return false;
        if (categoriaPreguntaId != that.categoriaPreguntaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (evaluacionId ^ (evaluacionId >>> 32));
        result = 31 * result + (int) (categoriaPreguntaId ^ (categoriaPreguntaId >>> 32));
        return result;
    }
}
