package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTOEXAMEN", schema = "datosEveliaMinimo", catalog = "")
public class AutoexamenEntity {
    private long autoexamenId;
    private int intentos;
    private boolean mostrarRtasSiempre;
    private EvaluacionEntity evaluacionByAutoexamenId;

    @Id
    @Column(name = "AUTOEXAMEN_ID")
    public long getAutoexamenId() {
        return autoexamenId;
    }

    public void setAutoexamenId(long autoexamenId) {
        this.autoexamenId = autoexamenId;
    }

    @Basic
    @Column(name = "INTENTOS")
    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    @Basic
    @Column(name = "MOSTRAR_RTAS_SIEMPRE")
    public boolean isMostrarRtasSiempre() {
        return mostrarRtasSiempre;
    }

    public void setMostrarRtasSiempre(boolean mostrarRtasSiempre) {
        this.mostrarRtasSiempre = mostrarRtasSiempre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoexamenEntity that = (AutoexamenEntity) o;

        if (autoexamenId != that.autoexamenId) return false;
        if (intentos != that.intentos) return false;
        if (mostrarRtasSiempre != that.mostrarRtasSiempre) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (autoexamenId ^ (autoexamenId >>> 32));
        result = 31 * result + intentos;
        result = 31 * result + (mostrarRtasSiempre ? 1 : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "AUTOEXAMEN_ID", referencedColumnName = "EVALUACION_ID", nullable = false, insertable=false, updatable=false)
    public EvaluacionEntity getEvaluacionByAutoexamenId() {
        return evaluacionByAutoexamenId;
    }

    public void setEvaluacionByAutoexamenId(EvaluacionEntity evaluacionByAutoexamenId) {
        this.evaluacionByAutoexamenId = evaluacionByAutoexamenId;
    }
}
