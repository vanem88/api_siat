package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUESTIONARIO", schema = "datosEveliaMinimo", catalog = "")
public class CuestionarioEntity {
    private long cuestionarioId;
    private boolean obligatorio;
    private boolean estadisticasPublicas;
    private EvaluacionEntity evaluacionByCuestionarioId;

    @Id
    @Column(name = "CUESTIONARIO_ID")
    public long getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(long cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

    @Basic
    @Column(name = "OBLIGATORIO")
    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    @Basic
    @Column(name = "ESTADISTICAS_PUBLICAS")
    public boolean isEstadisticasPublicas() {
        return estadisticasPublicas;
    }

    public void setEstadisticasPublicas(boolean estadisticasPublicas) {
        this.estadisticasPublicas = estadisticasPublicas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuestionarioEntity that = (CuestionarioEntity) o;

        if (cuestionarioId != that.cuestionarioId) return false;
        if (obligatorio != that.obligatorio) return false;
        if (estadisticasPublicas != that.estadisticasPublicas) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cuestionarioId ^ (cuestionarioId >>> 32));
        result = 31 * result + (obligatorio ? 1 : 0);
        result = 31 * result + (estadisticasPublicas ? 1 : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "CUESTIONARIO_ID", referencedColumnName = "EVALUACION_ID", nullable = false, insertable=false, updatable=false)
    public EvaluacionEntity getEvaluacionByCuestionarioId() {
        return evaluacionByCuestionarioId;
    }

    public void setEvaluacionByCuestionarioId(EvaluacionEntity evaluacionByCuestionarioId) {
        this.evaluacionByCuestionarioId = evaluacionByCuestionarioId;
    }
}
