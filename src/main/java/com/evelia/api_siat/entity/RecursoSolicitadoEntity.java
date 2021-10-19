package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "RECURSO_SOLICITADO", schema = "datosEveliaMinimo", catalog = "")
public class RecursoSolicitadoEntity {
    private long recursoSolicitadoId;
    private Long id;
    private Long recursoMigracionId;
    private Long recursoUtilizadoId;
    private Long solicitudAulaId;
    private Long herramientaUsarId;
    private RecursoMigracionEntity recursoMigracionByRecursoMigracionId;
    private RecursoEntity recursoByRecursoUtilizadoId;
    private SolicitudAulaEntity solicitudAulaBySolicitudAulaId;
    private TipoRecursoEntity tipoRecursoByHerramientaUsarId;

    @Id
    @Column(name = "RECURSO_SOLICITADO_ID")
    public long getRecursoSolicitadoId() {
        return recursoSolicitadoId;
    }

    public void setRecursoSolicitadoId(long recursoSolicitadoId) {
        this.recursoSolicitadoId = recursoSolicitadoId;
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
    @Column(name = "RECURSO_MIGRACION_ID")
    public Long getRecursoMigracionId() {
        return recursoMigracionId;
    }

    public void setRecursoMigracionId(Long recursoMigracionId) {
        this.recursoMigracionId = recursoMigracionId;
    }

    @Basic
    @Column(name = "RECURSO_UTILIZADO_ID")
    public Long getRecursoUtilizadoId() {
        return recursoUtilizadoId;
    }

    public void setRecursoUtilizadoId(Long recursoUtilizadoId) {
        this.recursoUtilizadoId = recursoUtilizadoId;
    }

    @Basic
    @Column(name = "SOLICITUD_AULA_ID")
    public Long getSolicitudAulaId() {
        return solicitudAulaId;
    }

    public void setSolicitudAulaId(Long solicitudAulaId) {
        this.solicitudAulaId = solicitudAulaId;
    }

    @Basic
    @Column(name = "HERRAMIENTA_USAR_ID")
    public Long getHerramientaUsarId() {
        return herramientaUsarId;
    }

    public void setHerramientaUsarId(Long herramientaUsarId) {
        this.herramientaUsarId = herramientaUsarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecursoSolicitadoEntity that = (RecursoSolicitadoEntity) o;

        if (recursoSolicitadoId != that.recursoSolicitadoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recursoMigracionId != null ? !recursoMigracionId.equals(that.recursoMigracionId) : that.recursoMigracionId != null)
            return false;
        if (recursoUtilizadoId != null ? !recursoUtilizadoId.equals(that.recursoUtilizadoId) : that.recursoUtilizadoId != null)
            return false;
        if (solicitudAulaId != null ? !solicitudAulaId.equals(that.solicitudAulaId) : that.solicitudAulaId != null)
            return false;
        if (herramientaUsarId != null ? !herramientaUsarId.equals(that.herramientaUsarId) : that.herramientaUsarId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (recursoSolicitadoId ^ (recursoSolicitadoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (recursoMigracionId != null ? recursoMigracionId.hashCode() : 0);
        result = 31 * result + (recursoUtilizadoId != null ? recursoUtilizadoId.hashCode() : 0);
        result = 31 * result + (solicitudAulaId != null ? solicitudAulaId.hashCode() : 0);
        result = 31 * result + (herramientaUsarId != null ? herramientaUsarId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "RECURSO_MIGRACION_ID", referencedColumnName = "RECURSO_MIGRACION_ID", insertable=false, updatable=false)
    public RecursoMigracionEntity getRecursoMigracionByRecursoMigracionId() {
        return recursoMigracionByRecursoMigracionId;
    }

    public void setRecursoMigracionByRecursoMigracionId(RecursoMigracionEntity recursoMigracionByRecursoMigracionId) {
        this.recursoMigracionByRecursoMigracionId = recursoMigracionByRecursoMigracionId;
    }

    @ManyToOne
    @JoinColumn(name = "RECURSO_UTILIZADO_ID", referencedColumnName = "RECURSO_ID", insertable=false, updatable=false)
    public RecursoEntity getRecursoByRecursoUtilizadoId() {
        return recursoByRecursoUtilizadoId;
    }

    public void setRecursoByRecursoUtilizadoId(RecursoEntity recursoByRecursoUtilizadoId) {
        this.recursoByRecursoUtilizadoId = recursoByRecursoUtilizadoId;
    }

    @ManyToOne
    @JoinColumn(name = "SOLICITUD_AULA_ID", referencedColumnName = "SOLICITUD_AULA_ID", insertable=false, updatable=false)
    public SolicitudAulaEntity getSolicitudAulaBySolicitudAulaId() {
        return solicitudAulaBySolicitudAulaId;
    }

    public void setSolicitudAulaBySolicitudAulaId(SolicitudAulaEntity solicitudAulaBySolicitudAulaId) {
        this.solicitudAulaBySolicitudAulaId = solicitudAulaBySolicitudAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "HERRAMIENTA_USAR_ID", referencedColumnName = "TIPO_RECURSO_ID", insertable=false, updatable=false)
    public TipoRecursoEntity getTipoRecursoByHerramientaUsarId() {
        return tipoRecursoByHerramientaUsarId;
    }

    public void setTipoRecursoByHerramientaUsarId(TipoRecursoEntity tipoRecursoByHerramientaUsarId) {
        this.tipoRecursoByHerramientaUsarId = tipoRecursoByHerramientaUsarId;
    }
}
