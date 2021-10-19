package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class NotaAprobarActividadNotasCualitativasEntityPK implements Serializable {
    private long notaAprobarActividadId;
    private long valorCalificacionId;

    @Column(name = "NOTA_APROBAR_ACTIVIDAD_ID")
    @Id
    public long getNotaAprobarActividadId() {
        return notaAprobarActividadId;
    }

    public void setNotaAprobarActividadId(long notaAprobarActividadId) {
        this.notaAprobarActividadId = notaAprobarActividadId;
    }

    @Column(name = "VALOR_CALIFICACION_ID")
    @Id
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

        NotaAprobarActividadNotasCualitativasEntityPK that = (NotaAprobarActividadNotasCualitativasEntityPK) o;

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
}
