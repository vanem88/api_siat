package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "CURSO", schema = "datosEveliaMinimo", catalog = "")
public class CursoEntity {
    private long cursoId;
    private Date fechaFin;
    private Date fechaInicio;
    private Long tipoCalificacionId;
    private Long tipoLicenciaMaterialId;
    private Integer anioPlanEstudio;
    private AulaCompuestaEntity aulaCompuestaByCursoId;
    private TipoCalificacionEntity tipoCalificacionByTipoCalificacionId;
    private TipoLicenciaMaterialEntity tipoLicenciaMaterialByTipoLicenciaMaterialId;
    private Collection<SolicitudAulaEntity> solicitudAulasByCursoId;
    private Collection<SolicitudAulaEntity> solicitudAulasByCursoId_0;

    @Id
    @Column(name = "CURSO_ID")
    public long getCursoId() {
        return cursoId;
    }

    public void setCursoId(long cursoId) {
        this.cursoId = cursoId;
    }

    @Basic
    @Column(name = "FECHA_FIN")
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "FECHA_INICIO")
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "TIPO_CALIFICACION_ID")
    public Long getTipoCalificacionId() {
        return tipoCalificacionId;
    }

    public void setTipoCalificacionId(Long tipoCalificacionId) {
        this.tipoCalificacionId = tipoCalificacionId;
    }

    @Basic
    @Column(name = "TIPO_LICENCIA_MATERIAL_ID")
    public Long getTipoLicenciaMaterialId() {
        return tipoLicenciaMaterialId;
    }

    public void setTipoLicenciaMaterialId(Long tipoLicenciaMaterialId) {
        this.tipoLicenciaMaterialId = tipoLicenciaMaterialId;
    }

    @Basic
    @Column(name = "ANIO_PLAN_ESTUDIO")
    public Integer getAnioPlanEstudio() {
        return anioPlanEstudio;
    }

    public void setAnioPlanEstudio(Integer anioPlanEstudio) {
        this.anioPlanEstudio = anioPlanEstudio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CursoEntity that = (CursoEntity) o;

        if (cursoId != that.cursoId) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (tipoCalificacionId != null ? !tipoCalificacionId.equals(that.tipoCalificacionId) : that.tipoCalificacionId != null)
            return false;
        if (tipoLicenciaMaterialId != null ? !tipoLicenciaMaterialId.equals(that.tipoLicenciaMaterialId) : that.tipoLicenciaMaterialId != null)
            return false;
        if (anioPlanEstudio != null ? !anioPlanEstudio.equals(that.anioPlanEstudio) : that.anioPlanEstudio != null)
             return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cursoId ^ (cursoId >>> 32));
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (tipoCalificacionId != null ? tipoCalificacionId.hashCode() : 0);
        result = 31 * result + (tipoLicenciaMaterialId != null ? tipoLicenciaMaterialId.hashCode() : 0);
        result = 31 * result + (anioPlanEstudio != null ? anioPlanEstudio.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "CURSO_ID", referencedColumnName = "AULA_COMPUESTA_ID", nullable = false)
    public AulaCompuestaEntity getAulaCompuestaByCursoId() {
        return aulaCompuestaByCursoId;
    }

    public void setAulaCompuestaByCursoId(AulaCompuestaEntity aulaCompuestaByCursoId) {
        this.aulaCompuestaByCursoId = aulaCompuestaByCursoId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_CALIFICACION_ID", referencedColumnName = "TIPO_CALIFICACION_ID", insertable=false, updatable=false)
    public TipoCalificacionEntity getTipoCalificacionByTipoCalificacionId() {
        return tipoCalificacionByTipoCalificacionId;
    }

    public void setTipoCalificacionByTipoCalificacionId(TipoCalificacionEntity tipoCalificacionByTipoCalificacionId) {
        this.tipoCalificacionByTipoCalificacionId = tipoCalificacionByTipoCalificacionId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_LICENCIA_MATERIAL_ID", referencedColumnName = "TIPO_LICENCIA_MATERIAL_ID", insertable=false, updatable=false)
    public TipoLicenciaMaterialEntity getTipoLicenciaMaterialByTipoLicenciaMaterialId() {
        return tipoLicenciaMaterialByTipoLicenciaMaterialId;
    }

    public void setTipoLicenciaMaterialByTipoLicenciaMaterialId(TipoLicenciaMaterialEntity tipoLicenciaMaterialByTipoLicenciaMaterialId) {
        this.tipoLicenciaMaterialByTipoLicenciaMaterialId = tipoLicenciaMaterialByTipoLicenciaMaterialId;
    }

    @OneToMany(mappedBy = "cursoByCursoAclonarId")
    public Collection<SolicitudAulaEntity> getSolicitudAulasByCursoId() {
        return solicitudAulasByCursoId;
    }

    public void setSolicitudAulasByCursoId(Collection<SolicitudAulaEntity> solicitudAulasByCursoId) {
        this.solicitudAulasByCursoId = solicitudAulasByCursoId;
    }

    @OneToMany(mappedBy = "cursoByCursoResultanteId")
    public Collection<SolicitudAulaEntity> getSolicitudAulasByCursoId_0() {
        return solicitudAulasByCursoId_0;
    }

    public void setSolicitudAulasByCursoId_0(Collection<SolicitudAulaEntity> solicitudAulasByCursoId_0) {
        this.solicitudAulasByCursoId_0 = solicitudAulasByCursoId_0;
    }
}
