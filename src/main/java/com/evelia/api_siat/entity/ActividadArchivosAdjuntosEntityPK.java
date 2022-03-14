package com.evelia.api_siat.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ActividadArchivosAdjuntosEntityPK implements Serializable {
   
	private static final long serialVersionUID = 1L;
	private long actividadId;
    private long archivoId;

    @Column(name = "ACTIVIDAD_ID")
    @Id
    public long getActividadId() {
        return actividadId;
    }

    public void setActividadId(long actividadId) {
        this.actividadId = actividadId;
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

        ActividadArchivosAdjuntosEntityPK that = (ActividadArchivosAdjuntosEntityPK) o;

        if (actividadId != that.actividadId) return false;
        if (archivoId != that.archivoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (actividadId ^ (actividadId >>> 32));
        result = 31 * result + (int) (archivoId ^ (archivoId >>> 32));
        return result;
    }
}
