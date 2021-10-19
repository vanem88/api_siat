package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTOEXAMEN_FINALIZADO", schema = "datosEveliaMinimo", catalog = "")
public class AutoexamenFinalizadoEntity {
    private long autoexamenFinalizadoId;
    private int intentosRealizados;
    private int intentosRestantes;
    private double notaFinal;
    private EvaluacionFinalizadaEntity evaluacionFinalizadaByAutoexamenFinalizadoId;

    @Id
    @Column(name = "AUTOEXAMEN_FINALIZADO_ID")
    public long getAutoexamenFinalizadoId() {
        return autoexamenFinalizadoId;
    }

    public void setAutoexamenFinalizadoId(long autoexamenFinalizadoId) {
        this.autoexamenFinalizadoId = autoexamenFinalizadoId;
    }

    @Basic
    @Column(name = "INTENTOS_REALIZADOS")
    public int getIntentosRealizados() {
        return intentosRealizados;
    }

    public void setIntentosRealizados(int intentosRealizados) {
        this.intentosRealizados = intentosRealizados;
    }

    @Basic
    @Column(name = "INTENTOS_RESTANTES")
    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public void setIntentosRestantes(int intentosRestantes) {
        this.intentosRestantes = intentosRestantes;
    }

    @Basic
    @Column(name = "NOTA_FINAL")
    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoexamenFinalizadoEntity that = (AutoexamenFinalizadoEntity) o;

        if (autoexamenFinalizadoId != that.autoexamenFinalizadoId) return false;
        if (intentosRealizados != that.intentosRealizados) return false;
        if (intentosRestantes != that.intentosRestantes) return false;
        if (Double.compare(that.notaFinal, notaFinal) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (autoexamenFinalizadoId ^ (autoexamenFinalizadoId >>> 32));
        result = 31 * result + intentosRealizados;
        result = 31 * result + intentosRestantes;
        temp = Double.doubleToLongBits(notaFinal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToOne
    @JoinColumn(name = "AUTOEXAMEN_FINALIZADO_ID", referencedColumnName = "EVALUACION_FINALIZADA_ID", nullable = false, insertable=false, updatable=false)
    public EvaluacionFinalizadaEntity getEvaluacionFinalizadaByAutoexamenFinalizadoId() {
        return evaluacionFinalizadaByAutoexamenFinalizadoId;
    }

    public void setEvaluacionFinalizadaByAutoexamenFinalizadoId(EvaluacionFinalizadaEntity evaluacionFinalizadaByAutoexamenFinalizadoId) {
        this.evaluacionFinalizadaByAutoexamenFinalizadoId = evaluacionFinalizadaByAutoexamenFinalizadoId;
    }
}
