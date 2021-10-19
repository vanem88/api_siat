package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "EXAMEN", schema = "datosEveliaMinimo", catalog = "")
public class ExamenEntity {
    private long examenId;
    private Timestamp duracion;
    private double nota;
    private boolean temporizado;
    private Timestamp tpoAdvertencia;
    private Timestamp verNotasDesde;
    private EvaluacionEntity evaluacionByExamenId;

    @Id
    @Column(name = "EXAMEN_ID")
    public long getExamenId() {
        return examenId;
    }

    public void setExamenId(long examenId) {
        this.examenId = examenId;
    }

    @Basic
    @Column(name = "DURACION")
    public Timestamp getDuracion() {
        return duracion;
    }

    public void setDuracion(Timestamp duracion) {
        this.duracion = duracion;
    }

    @Basic
    @Column(name = "NOTA")
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Basic
    @Column(name = "TEMPORIZADO")
    public boolean isTemporizado() {
        return temporizado;
    }

    public void setTemporizado(boolean temporizado) {
        this.temporizado = temporizado;
    }

    @Basic
    @Column(name = "TPO_ADVERTENCIA")
    public Timestamp getTpoAdvertencia() {
        return tpoAdvertencia;
    }

    public void setTpoAdvertencia(Timestamp tpoAdvertencia) {
        this.tpoAdvertencia = tpoAdvertencia;
    }

    @Basic
    @Column(name = "VER_NOTAS_DESDE")
    public Timestamp getVerNotasDesde() {
        return verNotasDesde;
    }

    public void setVerNotasDesde(Timestamp verNotasDesde) {
        this.verNotasDesde = verNotasDesde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamenEntity that = (ExamenEntity) o;

        if (examenId != that.examenId) return false;
        if (Double.compare(that.nota, nota) != 0) return false;
        if (temporizado != that.temporizado) return false;
        if (duracion != null ? !duracion.equals(that.duracion) : that.duracion != null) return false;
        if (tpoAdvertencia != null ? !tpoAdvertencia.equals(that.tpoAdvertencia) : that.tpoAdvertencia != null)
            return false;
        if (verNotasDesde != null ? !verNotasDesde.equals(that.verNotasDesde) : that.verNotasDesde != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (examenId ^ (examenId >>> 32));
        result = 31 * result + (duracion != null ? duracion.hashCode() : 0);
        temp = Double.doubleToLongBits(nota);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (temporizado ? 1 : 0);
        result = 31 * result + (tpoAdvertencia != null ? tpoAdvertencia.hashCode() : 0);
        result = 31 * result + (verNotasDesde != null ? verNotasDesde.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "EXAMEN_ID", referencedColumnName = "EVALUACION_ID", nullable = false, insertable=false, updatable=false)
    public EvaluacionEntity getEvaluacionByExamenId() {
        return evaluacionByExamenId;
    }

    public void setEvaluacionByExamenId(EvaluacionEntity evaluacionByExamenId) {
        this.evaluacionByExamenId = evaluacionByExamenId;
    }
}
