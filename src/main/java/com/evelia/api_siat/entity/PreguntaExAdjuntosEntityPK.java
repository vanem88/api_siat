package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PreguntaExAdjuntosEntityPK implements Serializable {
    
	private static final long serialVersionUID = 1L;
	private long preguntaExId;
    private long archivoId;

    @Column(name = "PREGUNTA_EX_ID")
    @Id
    public long getPreguntaExId() {
        return preguntaExId;
    }

    public void setPreguntaExId(long preguntaExId) {
        this.preguntaExId = preguntaExId;
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

        PreguntaExAdjuntosEntityPK that = (PreguntaExAdjuntosEntityPK) o;

        if (preguntaExId != that.preguntaExId) return false;
        if (archivoId != that.archivoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (preguntaExId ^ (preguntaExId >>> 32));
        result = 31 * result + (int) (archivoId ^ (archivoId >>> 32));
        return result;
    }
}
