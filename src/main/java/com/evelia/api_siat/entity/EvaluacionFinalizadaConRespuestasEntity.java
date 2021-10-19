package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "EVALUACION_FINALIZADA_CON_RESPUESTAS", schema = "datosEveliaMinimo", catalog = "")
public class EvaluacionFinalizadaConRespuestasEntity {
    private long evaluacionFinalizadaConRespuestasId;
    private String estadoEx;
    private CuestionarioFinalizadoEntity cuestionarioFinalizadoByEvaluacionFinalizadaConRespuestasId;
    private EvaluacionFinalizadaEntity evaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId;
    private ExamenFinalizadoEntity examenFinalizadoByEvaluacionFinalizadaConRespuestasId;
    private Collection<RespuestaExEntity> respuestaExesByEvaluacionFinalizadaConRespuestasId;

    @Id
    @Column(name = "EVALUACION_FINALIZADA_CON_RESPUESTAS_ID")
    public long getEvaluacionFinalizadaConRespuestasId() {
        return evaluacionFinalizadaConRespuestasId;
    }

    public void setEvaluacionFinalizadaConRespuestasId(long evaluacionFinalizadaConRespuestasId) {
        this.evaluacionFinalizadaConRespuestasId = evaluacionFinalizadaConRespuestasId;
    }

    @Basic
    @Column(name = "ESTADO_EX")
    public String getEstadoEx() {
        return estadoEx;
    }

    public void setEstadoEx(String estadoEx) {
        this.estadoEx = estadoEx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluacionFinalizadaConRespuestasEntity that = (EvaluacionFinalizadaConRespuestasEntity) o;

        if (evaluacionFinalizadaConRespuestasId != that.evaluacionFinalizadaConRespuestasId) return false;
        if (estadoEx != null ? !estadoEx.equals(that.estadoEx) : that.estadoEx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (evaluacionFinalizadaConRespuestasId ^ (evaluacionFinalizadaConRespuestasId >>> 32));
        result = 31 * result + (estadoEx != null ? estadoEx.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "evaluacionFinalizadaConRespuestasByCuestionarioFinalizadoId")
    public CuestionarioFinalizadoEntity getCuestionarioFinalizadoByEvaluacionFinalizadaConRespuestasId() {
        return cuestionarioFinalizadoByEvaluacionFinalizadaConRespuestasId;
    }

    public void setCuestionarioFinalizadoByEvaluacionFinalizadaConRespuestasId(CuestionarioFinalizadoEntity cuestionarioFinalizadoByEvaluacionFinalizadaConRespuestasId) {
        this.cuestionarioFinalizadoByEvaluacionFinalizadaConRespuestasId = cuestionarioFinalizadoByEvaluacionFinalizadaConRespuestasId;
    }

    @OneToOne
    @JoinColumn(name = "EVALUACION_FINALIZADA_CON_RESPUESTAS_ID", referencedColumnName = "EVALUACION_FINALIZADA_ID", nullable = false)
    public EvaluacionFinalizadaEntity getEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId() {
        return evaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId;
    }

    public void setEvaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId(EvaluacionFinalizadaEntity evaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId) {
        this.evaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId = evaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId;
    }

    @OneToOne(mappedBy = "evaluacionFinalizadaConRespuestasByExamenFinalizadoId")
    public ExamenFinalizadoEntity getExamenFinalizadoByEvaluacionFinalizadaConRespuestasId() {
        return examenFinalizadoByEvaluacionFinalizadaConRespuestasId;
    }

    public void setExamenFinalizadoByEvaluacionFinalizadaConRespuestasId(ExamenFinalizadoEntity examenFinalizadoByEvaluacionFinalizadaConRespuestasId) {
        this.examenFinalizadoByEvaluacionFinalizadaConRespuestasId = examenFinalizadoByEvaluacionFinalizadaConRespuestasId;
    }

    @OneToMany(mappedBy = "evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaConRespuestasId")
    public Collection<RespuestaExEntity> getRespuestaExesByEvaluacionFinalizadaConRespuestasId() {
        return respuestaExesByEvaluacionFinalizadaConRespuestasId;
    }

    public void setRespuestaExesByEvaluacionFinalizadaConRespuestasId(Collection<RespuestaExEntity> respuestaExesByEvaluacionFinalizadaConRespuestasId) {
        this.respuestaExesByEvaluacionFinalizadaConRespuestasId = respuestaExesByEvaluacionFinalizadaConRespuestasId;
    }
}
