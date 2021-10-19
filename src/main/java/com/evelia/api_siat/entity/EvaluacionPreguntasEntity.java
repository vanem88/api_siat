package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "EVALUACION_PREGUNTAS", schema = "datosEveliaMinimo", catalog = "")
@IdClass(EvaluacionPreguntasEntityPK.class)
public class EvaluacionPreguntasEntity {
    private long evaluacionId;
    private long preguntaExId;
    private EvaluacionEntity evaluacionByEvaluacionId;
    private PreguntaExEntity preguntaExByPreguntaExId;

    @Id
    @Column(name = "EVALUACION_ID")
    public long getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @Id
    @Column(name = "PREGUNTA_EX_ID")
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

        EvaluacionPreguntasEntity that = (EvaluacionPreguntasEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "EVALUACION_ID", referencedColumnName = "EVALUACION_ID", nullable = false,insertable=false, updatable=false)
    public EvaluacionEntity getEvaluacionByEvaluacionId() {
        return evaluacionByEvaluacionId;
    }

    public void setEvaluacionByEvaluacionId(EvaluacionEntity evaluacionByEvaluacionId) {
        this.evaluacionByEvaluacionId = evaluacionByEvaluacionId;
    }

    @ManyToOne
    @JoinColumn(name = "PREGUNTA_EX_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false,insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPreguntaExId() {
        return preguntaExByPreguntaExId;
    }

    public void setPreguntaExByPreguntaExId(PreguntaExEntity preguntaExByPreguntaExId) {
        this.preguntaExByPreguntaExId = preguntaExByPreguntaExId;
    }
}
