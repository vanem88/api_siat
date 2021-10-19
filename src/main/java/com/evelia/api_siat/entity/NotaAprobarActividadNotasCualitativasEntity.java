package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "NOTA_APROBAR_ACTIVIDAD_NOTAS_CUALITATIVAS", schema = "datosEveliaMinimo", catalog = "")
@IdClass(NotaAprobarActividadNotasCualitativasEntityPK.class)
public class NotaAprobarActividadNotasCualitativasEntity {
    private long notaAprobarActividadId;
    private long valorCalificacionId;
    private NotaAprobarActividadEntity notaAprobarActividadByNotaAprobarActividadId;
    private ValorCalificacionEntity valorCalificacionByValorCalificacionId;

    @Id
    @Column(name = "NOTA_APROBAR_ACTIVIDAD_ID")
    public long getNotaAprobarActividadId() {
        return notaAprobarActividadId;
    }

    public void setNotaAprobarActividadId(long notaAprobarActividadId) {
        this.notaAprobarActividadId = notaAprobarActividadId;
    }

    @Id
    @Column(name = "VALOR_CALIFICACION_ID")
    public long getValorCalificacionId() {
        return valorCalificacionId;
    }

    public void setValorCalificacionId(long valorCalificacionId) {
        this.valorCalificacionId = valorCalificacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaAprobarActividadNotasCualitativasEntity that = (NotaAprobarActividadNotasCualitativasEntity) o;

        if (notaAprobarActividadId != that.notaAprobarActividadId) return false;
        if (valorCalificacionId != that.valorCalificacionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (notaAprobarActividadId ^ (notaAprobarActividadId >>> 32));
        result = 31 * result + (int) (valorCalificacionId ^ (valorCalificacionId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NOTA_APROBAR_ACTIVIDAD_ID", referencedColumnName = "NOTA_APROBAR_ACTIVIDAD_ID", nullable = false, insertable=false, updatable=false)
    public NotaAprobarActividadEntity getNotaAprobarActividadByNotaAprobarActividadId() {
        return notaAprobarActividadByNotaAprobarActividadId;
    }

    public void setNotaAprobarActividadByNotaAprobarActividadId(NotaAprobarActividadEntity notaAprobarActividadByNotaAprobarActividadId) {
        this.notaAprobarActividadByNotaAprobarActividadId = notaAprobarActividadByNotaAprobarActividadId;
    }

    @ManyToOne
    @JoinColumn(name = "VALOR_CALIFICACION_ID", referencedColumnName = "VALOR_CALIFICACION_ID", nullable = false, insertable=false, updatable=false)
    public ValorCalificacionEntity getValorCalificacionByValorCalificacionId() {
        return valorCalificacionByValorCalificacionId;
    }

    public void setValorCalificacionByValorCalificacionId(ValorCalificacionEntity valorCalificacionByValorCalificacionId) {
        this.valorCalificacionByValorCalificacionId = valorCalificacionByValorCalificacionId;
    }
}
