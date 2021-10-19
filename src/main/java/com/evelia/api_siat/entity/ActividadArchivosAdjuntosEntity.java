package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVIDAD_ARCHIVOS_ADJUNTOS", schema = "datosEveliaMinimo", catalog = "")
@IdClass(ActividadArchivosAdjuntosEntityPK.class)
public class ActividadArchivosAdjuntosEntity {
    private long actividadId;
    private long archivoId;
    private ActividadEntity actividadByActividadId;
    private ArchivoEntity archivoByArchivoId;

    @Id
    @Column(name = "ACTIVIDAD_ID")
    public long getActividadId() {
        return actividadId;
    }

    public void setActividadId(long actividadId) {
        this.actividadId = actividadId;
    }

    @Id
    @Column(name = "ARCHIVO_ID")
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

        ActividadArchivosAdjuntosEntity that = (ActividadArchivosAdjuntosEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "ACTIVIDAD_ID", referencedColumnName = "ACTIVIDAD_ID", nullable = false, insertable=false, updatable=false)
    public ActividadEntity getActividadByActividadId() {
        return actividadByActividadId;
    }

    public void setActividadByActividadId(ActividadEntity actividadByActividadId) {
        this.actividadByActividadId = actividadByActividadId;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", nullable = false, insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }
}
