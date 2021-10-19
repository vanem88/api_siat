package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "MENSAJE_ADJUNTOS", schema = "datosEveliaMinimo", catalog = "")
@IdClass(MensajeAdjuntosEntityPK.class)
public class MensajeAdjuntosEntity {
    private long mensajeId;
    private long archivoId;
    private MensajeEntity mensajeByMensajeId;
    private ArchivoEntity archivoByArchivoId;

    @Id
    @Column(name = "MENSAJE_ID")
    public long getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(long mensajeId) {
        this.mensajeId = mensajeId;
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

        MensajeAdjuntosEntity that = (MensajeAdjuntosEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "MENSAJE_ID", referencedColumnName = "MENSAJE_ID", nullable = false, insertable=false, updatable=false)
    public MensajeEntity getMensajeByMensajeId() {
        return mensajeByMensajeId;
    }

    public void setMensajeByMensajeId(MensajeEntity mensajeByMensajeId) {
        this.mensajeByMensajeId = mensajeByMensajeId;
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
