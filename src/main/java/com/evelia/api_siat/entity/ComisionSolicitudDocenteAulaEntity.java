package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "COMISION_SOLICITUD_DOCENTE_AULA", schema = "datosEveliaMinimo", catalog = "")
public class ComisionSolicitudDocenteAulaEntity {
    private long comisionSolicitudDocenteAulaId;
    private Long comisionSolicitudId;
    private Long id;
    private Long solicitudDocenteAulaId;
    private ComisionSolicitudEntity comisionSolicitudByComisionSolicitudId;
    private SolicitudDocenteAulaEntity solicitudDocenteAulaBySolicitudDocenteAulaId;

    @Id
    @Column(name = "COMISION_SOLICITUD_DOCENTE_AULA_ID")
    public long getComisionSolicitudDocenteAulaId() {
        return comisionSolicitudDocenteAulaId;
    }

    public void setComisionSolicitudDocenteAulaId(long comisionSolicitudDocenteAulaId) {
        this.comisionSolicitudDocenteAulaId = comisionSolicitudDocenteAulaId;
    }

    @Basic
    @Column(name = "COMISION_SOLICITUD_ID")
    public Long getComisionSolicitudId() {
        return comisionSolicitudId;
    }

    public void setComisionSolicitudId(Long comisionSolicitudId) {
        this.comisionSolicitudId = comisionSolicitudId;
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
    @Column(name = "SOLICITUD_DOCENTE_AULA_ID")
    public Long getSolicitudDocenteAulaId() {
        return solicitudDocenteAulaId;
    }

    public void setSolicitudDocenteAulaId(Long solicitudDocenteAulaId) {
        this.solicitudDocenteAulaId = solicitudDocenteAulaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComisionSolicitudDocenteAulaEntity that = (ComisionSolicitudDocenteAulaEntity) o;

        if (comisionSolicitudDocenteAulaId != that.comisionSolicitudDocenteAulaId) return false;
        if (comisionSolicitudId != null ? !comisionSolicitudId.equals(that.comisionSolicitudId) : that.comisionSolicitudId != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (solicitudDocenteAulaId != null ? !solicitudDocenteAulaId.equals(that.solicitudDocenteAulaId) : that.solicitudDocenteAulaId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (comisionSolicitudDocenteAulaId ^ (comisionSolicitudDocenteAulaId >>> 32));
        result = 31 * result + (comisionSolicitudId != null ? comisionSolicitudId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (solicitudDocenteAulaId != null ? solicitudDocenteAulaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "COMISION_SOLICITUD_ID", insertable=false, updatable=false)
    public ComisionSolicitudEntity getComisionSolicitudByComisionSolicitudId() {
        return comisionSolicitudByComisionSolicitudId;
    }

    public void setComisionSolicitudByComisionSolicitudId(ComisionSolicitudEntity comisionSolicitudByComisionSolicitudId) {
        this.comisionSolicitudByComisionSolicitudId = comisionSolicitudByComisionSolicitudId;
    }

    @ManyToOne
    // @JoinColumn(name = "SOLICITUD_DOCENTE_AULA_ID", referencedColumnName = "SOLICITUD_DOCENTE_AULA_ID")
    @JoinColumn(name = "SOLICITUD_DOCENTE_AULA_ID", insertable=false, updatable=false)
    public SolicitudDocenteAulaEntity getSolicitudDocenteAulaBySolicitudDocenteAulaId() {
        return solicitudDocenteAulaBySolicitudDocenteAulaId;
    }

    public void setSolicitudDocenteAulaBySolicitudDocenteAulaId(SolicitudDocenteAulaEntity solicitudDocenteAulaBySolicitudDocenteAulaId) {
        this.solicitudDocenteAulaBySolicitudDocenteAulaId = solicitudDocenteAulaBySolicitudDocenteAulaId;
    }
}
