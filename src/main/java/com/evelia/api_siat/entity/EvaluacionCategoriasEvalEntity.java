package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "EVALUACION_CATEGORIAS_EVAL", schema = "datosEveliaMinimo", catalog = "")
@IdClass(EvaluacionCategoriasEvalEntityPK.class)
public class EvaluacionCategoriasEvalEntity {
    private long evaluacionId;
    private long categoriaPreguntaId;
    private EvaluacionEntity evaluacionByEvaluacionId;
    private CategoriaPreguntaEntity categoriaPreguntaByCategoriaPreguntaId;

    @Id
    @Column(name = "EVALUACION_ID")
    public long getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @Id
    @Column(name = "CATEGORIA_PREGUNTA_ID")
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

        EvaluacionCategoriasEvalEntity that = (EvaluacionCategoriasEvalEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "EVALUACION_ID", referencedColumnName = "EVALUACION_ID", nullable = false, insertable=false, updatable=false)
    public EvaluacionEntity getEvaluacionByEvaluacionId() {
        return evaluacionByEvaluacionId;
    }

    public void setEvaluacionByEvaluacionId(EvaluacionEntity evaluacionByEvaluacionId) {
        this.evaluacionByEvaluacionId = evaluacionByEvaluacionId;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_PREGUNTA_ID", referencedColumnName = "CATEGORIA_PREGUNTA_ID", nullable = false, insertable=false, updatable=false)
    public CategoriaPreguntaEntity getCategoriaPreguntaByCategoriaPreguntaId() {
        return categoriaPreguntaByCategoriaPreguntaId;
    }

    public void setCategoriaPreguntaByCategoriaPreguntaId(CategoriaPreguntaEntity categoriaPreguntaByCategoriaPreguntaId) {
        this.categoriaPreguntaByCategoriaPreguntaId = categoriaPreguntaByCategoriaPreguntaId;
    }
}
