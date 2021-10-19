package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "SOLICITUD", schema = "datosEveliaMinimo", catalog = "")
public class SolicitudEntity {
    private long solicitudId;
    private TextoEntity textoBySolicitudId;

    @Id
    @Column(name = "SOLICITUD_ID")
    public long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(long solicitudId) {
        this.solicitudId = solicitudId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolicitudEntity that = (SolicitudEntity) o;

        if (solicitudId != that.solicitudId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (solicitudId ^ (solicitudId >>> 32));
    }

    @OneToOne
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "TEXTO_ID", nullable = false, insertable=false, updatable=false)
    public TextoEntity getTextoBySolicitudId() {
        return textoBySolicitudId;
    }

    public void setTextoBySolicitudId(TextoEntity textoBySolicitudId) {
        this.textoBySolicitudId = textoBySolicitudId;
    }
}
