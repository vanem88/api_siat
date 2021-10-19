package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MensajeAdjuntosEntityPK implements Serializable {
    private long mensajeId;
    private long archivoId;

    @Column(name = "MENSAJE_ID")
    @Id
    public long getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(long mensajeId) {
        this.mensajeId = mensajeId;
    }

    @Column(name = "ARCHIVO_ID")
    @Id
    public long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(long archivoId) {
        this.archivoId = archivoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MensajeAdjuntosEntityPK that = (MensajeAdjuntosEntityPK) o;

        if (mensajeId != that.mensajeId) return false;
        if (archivoId != that.archivoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mensajeId ^ (mensajeId >>> 32));
        result = 31 * result + (int) (archivoId ^ (archivoId >>> 32));
        return result;
    }
}
