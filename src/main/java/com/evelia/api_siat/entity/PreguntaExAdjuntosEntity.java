package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PREGUNTA_EX_ADJUNTOS", schema = "datosEveliaMinimo", catalog = "")
@IdClass(PreguntaExAdjuntosEntityPK.class)
public class PreguntaExAdjuntosEntity {
    private long preguntaExId;
    private long archivoId;
    private PreguntaExEntity preguntaExByPreguntaExId;
    private ArchivoEntity archivoByArchivoId;

    @Id
    @Column(name = "PREGUNTA_EX_ID")
    public long getPreguntaExId() {
        return preguntaExId;
    }

    public void setPreguntaExId(long preguntaExId) {
        this.preguntaExId = preguntaExId;
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

        PreguntaExAdjuntosEntity that = (PreguntaExAdjuntosEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "PREGUNTA_EX_ID", referencedColumnName = "PREGUNTA_EX_ID", nullable = false, insertable=false, updatable=false)
    public PreguntaExEntity getPreguntaExByPreguntaExId() {
        return preguntaExByPreguntaExId;
    }

    public void setPreguntaExByPreguntaExId(PreguntaExEntity preguntaExByPreguntaExId) {
        this.preguntaExByPreguntaExId = preguntaExByPreguntaExId;
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
