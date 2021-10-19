package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "SOLICITUD_DOCENTE_AULA", schema = "datosEveliaMinimo", catalog = "")
public class SolicitudDocenteAulaEntity {
    private long solicitudDocenteAulaId;
    private String comisionDeDocente;
    private Long docenteSolicitadoId;
    private Byte esAdministrador;
    private Long id;
    private String interno;
    private String rol;
    private Long solicitudAulaId;
    private Collection<ComisionSolicitudDocenteAulaEntity> comisionSolicitudDocenteAulasBySolicitudDocenteAulaId;
    private DocenteSolicitadoEntity docenteSolicitadoByDocenteSolicitadoId;
    private SolicitudAulaEntity solicitudAulaBySolicitudAulaId;

    @Id
    @Column(name = "SOLICITUD_DOCENTE_AULA_ID")
    public long getSolicitudDocenteAulaId() {
        return solicitudDocenteAulaId;
    }

    public void setSolicitudDocenteAulaId(long solicitudDocenteAulaId) {
        this.solicitudDocenteAulaId = solicitudDocenteAulaId;
    }

    @Basic
    @Column(name = "COMISION_DE_DOCENTE")
    public String getComisionDeDocente() {
        return comisionDeDocente;
    }

    public void setComisionDeDocente(String comisionDeDocente) {
        this.comisionDeDocente = comisionDeDocente;
    }

    @Basic
    @Column(name = "DOCENTE_SOLICITADO_ID")
    public Long getDocenteSolicitadoId() {
        return docenteSolicitadoId;
    }

    public void setDocenteSolicitadoId(Long docenteSolicitadoId) {
        this.docenteSolicitadoId = docenteSolicitadoId;
    }

    @Basic
    @Column(name = "ES_ADMINISTRADOR")
    public Byte getEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(Byte esAdministrador) {
        this.esAdministrador = esAdministrador;
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
    @Column(name = "INTERNO")
    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    @Basic
    @Column(name = "ROL")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Basic
    @Column(name = "SOLICITUD_AULA_ID")
    public Long getSolicitudAulaId() {
        return solicitudAulaId;
    }

    public void setSolicitudAulaId(Long solicitudAulaId) {
        this.solicitudAulaId = solicitudAulaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolicitudDocenteAulaEntity that = (SolicitudDocenteAulaEntity) o;

        if (solicitudDocenteAulaId != that.solicitudDocenteAulaId) return false;
        if (comisionDeDocente != null ? !comisionDeDocente.equals(that.comisionDeDocente) : that.comisionDeDocente != null)
            return false;
        if (docenteSolicitadoId != null ? !docenteSolicitadoId.equals(that.docenteSolicitadoId) : that.docenteSolicitadoId != null)
            return false;
        if (esAdministrador != null ? !esAdministrador.equals(that.esAdministrador) : that.esAdministrador != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (interno != null ? !interno.equals(that.interno) : that.interno != null) return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;
        if (solicitudAulaId != null ? !solicitudAulaId.equals(that.solicitudAulaId) : that.solicitudAulaId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (solicitudDocenteAulaId ^ (solicitudDocenteAulaId >>> 32));
        result = 31 * result + (comisionDeDocente != null ? comisionDeDocente.hashCode() : 0);
        result = 31 * result + (docenteSolicitadoId != null ? docenteSolicitadoId.hashCode() : 0);
        result = 31 * result + (esAdministrador != null ? esAdministrador.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (interno != null ? interno.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (solicitudAulaId != null ? solicitudAulaId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "solicitudDocenteAulaBySolicitudDocenteAulaId")
    public Collection<ComisionSolicitudDocenteAulaEntity> getComisionSolicitudDocenteAulasBySolicitudDocenteAulaId() {
        return comisionSolicitudDocenteAulasBySolicitudDocenteAulaId;
    }

    public void setComisionSolicitudDocenteAulasBySolicitudDocenteAulaId(Collection<ComisionSolicitudDocenteAulaEntity> comisionSolicitudDocenteAulasBySolicitudDocenteAulaId) {
        this.comisionSolicitudDocenteAulasBySolicitudDocenteAulaId = comisionSolicitudDocenteAulasBySolicitudDocenteAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "DOCENTE_SOLICITADO_ID", referencedColumnName = "DOCENTE_SOLICITADO_ID", insertable=false, updatable=false)
    public DocenteSolicitadoEntity getDocenteSolicitadoByDocenteSolicitadoId() {
        return docenteSolicitadoByDocenteSolicitadoId;
    }

    public void setDocenteSolicitadoByDocenteSolicitadoId(DocenteSolicitadoEntity docenteSolicitadoByDocenteSolicitadoId) {
        this.docenteSolicitadoByDocenteSolicitadoId = docenteSolicitadoByDocenteSolicitadoId;
    }

    @ManyToOne
    @JoinColumn(name = "SOLICITUD_AULA_ID", referencedColumnName = "SOLICITUD_AULA_ID", insertable=false, updatable=false)
    public SolicitudAulaEntity getSolicitudAulaBySolicitudAulaId() {
        return solicitudAulaBySolicitudAulaId;
    }

    public void setSolicitudAulaBySolicitudAulaId(SolicitudAulaEntity solicitudAulaBySolicitudAulaId) {
        this.solicitudAulaBySolicitudAulaId = solicitudAulaBySolicitudAulaId;
    }
}
