package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUESTIONARIO_FINALIZADO", schema = "datosEveliaMinimo", catalog = "")
public class CuestionarioFinalizadoEntity {
    private long cuestionarioFinalizadoId;
    private EvaluacionFinalizadaConRespuestasEntity evaluacionFinalizadaConRespuestasByCuestionarioFinalizadoId;

    @Id
    @Column(name = "CUESTIONARIO_FINALIZADO_ID")
    public long getCuestionarioFinalizadoId() {
        return cuestionarioFinalizadoId;
    }

    public void setCuestionarioFinalizadoId(long cuestionarioFinalizadoId) {
        this.cuestionarioFinalizadoId = cuestionarioFinalizadoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuestionarioFinalizadoEntity that = (CuestionarioFinalizadoEntity) o;

        if (cuestionarioFinalizadoId != that.cuestionarioFinalizadoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (cuestionarioFinalizadoId ^ (cuestionarioFinalizadoId >>> 32));
    }

    @OneToOne
    @JoinColumn(name = "CUESTIONARIO_FINALIZADO_ID", referencedColumnName = "EVALUACION_FINALIZADA_CON_RESPUESTAS_ID", nullable = false)
    public EvaluacionFinalizadaConRespuestasEntity getEvaluacionFinalizadaConRespuestasByCuestionarioFinalizadoId() {
        return evaluacionFinalizadaConRespuestasByCuestionarioFinalizadoId;
    }

    public void setEvaluacionFinalizadaConRespuestasByCuestionarioFinalizadoId(EvaluacionFinalizadaConRespuestasEntity evaluacionFinalizadaConRespuestasByCuestionarioFinalizadoId) {
        this.evaluacionFinalizadaConRespuestasByCuestionarioFinalizadoId = evaluacionFinalizadaConRespuestasByCuestionarioFinalizadoId;
    }
}
