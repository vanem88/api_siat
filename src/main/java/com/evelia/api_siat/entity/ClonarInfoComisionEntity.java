package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "CLONAR_INFO_COMISION", schema = "datosEveliaMinimo", catalog = "")
public class ClonarInfoComisionEntity {
    private long clonarInfoComisionId;
    private Long id;
    private long comisionOrigenId;
    private long comisionDestinoId;
    private long solicitudAulaId;
    private ComisionEntity comisionByComisionOrigenId;
    private ComisionSolicitudEntity comisionSolicitudByComisionDestinoId;
    private SolicitudAulaEntity solicitudAulaBySolicitudAulaId;

    @Id
    @Column(name = "CLONAR_INFO_COMISION_ID")
    public long getClonarInfoComisionId() {
        return clonarInfoComisionId;
    }

    public void setClonarInfoComisionId(long clonarInfoComisionId) {
        this.clonarInfoComisionId = clonarInfoComisionId;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COMISION_ORIGEN_ID")
    public long getComisionOrigenId() {
        return comisionOrigenId;
    }

    public void setComisionOrigenId(long comisionOrigenId) {
        this.comisionOrigenId = comisionOrigenId;
    }

    @Basic
    @Column(name = "COMISION_DESTINO_ID")
    public long getComisionDestinoId() {
        return comisionDestinoId;
    }

    public void setComisionDestinoId(long comisionDestinoId) {
        this.comisionDestinoId = comisionDestinoId;
    }

    @Basic
    @Column(name = "SOLICITUD_AULA_ID")
    public long getSolicitudAulaId() {
        return solicitudAulaId;
    }

    public void setSolicitudAulaId(long solicitudAulaId) {
        this.solicitudAulaId = solicitudAulaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClonarInfoComisionEntity that = (ClonarInfoComisionEntity) o;

        if (clonarInfoComisionId != that.clonarInfoComisionId) return false;
        if (comisionOrigenId != that.comisionOrigenId) return false;
        if (comisionDestinoId != that.comisionDestinoId) return false;
        if (solicitudAulaId != that.solicitudAulaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (clonarInfoComisionId ^ (clonarInfoComisionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (int) (comisionOrigenId ^ (comisionOrigenId >>> 32));
        result = 31 * result + (int) (comisionDestinoId ^ (comisionDestinoId >>> 32));
        result = 31 * result + (int) (solicitudAulaId ^ (solicitudAulaId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "COMISION_ORIGEN_ID", referencedColumnName = "COMISION_ID", nullable = false, insertable=false, updatable=false)
    public ComisionEntity getComisionByComisionOrigenId() {
        return comisionByComisionOrigenId;
    }

    public void setComisionByComisionOrigenId(ComisionEntity comisionByComisionOrigenId) {
        this.comisionByComisionOrigenId = comisionByComisionOrigenId;
    }

    @ManyToOne
    @JoinColumn(name = "COMISION_DESTINO_ID", referencedColumnName = "COMISION_SOLICITUD_ID", nullable = false, insertable=false, updatable=false)
    public ComisionSolicitudEntity getComisionSolicitudByComisionDestinoId() {
        return comisionSolicitudByComisionDestinoId;
    }

    public void setComisionSolicitudByComisionDestinoId(ComisionSolicitudEntity comisionSolicitudByComisionDestinoId) {
        this.comisionSolicitudByComisionDestinoId = comisionSolicitudByComisionDestinoId;
    }

    @ManyToOne
    @JoinColumn(name = "SOLICITUD_AULA_ID", referencedColumnName = "SOLICITUD_AULA_ID", nullable = false, insertable=false, updatable=false)
    public SolicitudAulaEntity getSolicitudAulaBySolicitudAulaId() {
        return solicitudAulaBySolicitudAulaId;
    }

    public void setSolicitudAulaBySolicitudAulaId(SolicitudAulaEntity solicitudAulaBySolicitudAulaId) {
        this.solicitudAulaBySolicitudAulaId = solicitudAulaBySolicitudAulaId;
    }
}
