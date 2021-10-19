package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "SOLICITUD_AULA", schema = "datosEveliaMinimo", catalog = "")
public class SolicitudAulaEntity {
    private long solicitudAulaId;
    private String asignatura;
    private Long cursoAclonarId;
    private Byte aulaNueva;
    private Long cursoResultanteId;
    private int cantidadComisiones;
    private String codigoAsignatura;
    private String estadoSolicitud;
    private String facultad;
    private Timestamp fechaInicioPeriodo;
    private Timestamp fechaSolicitud;
    private Long id;
    private String periodoDesarrolloAsignatura;
    private Long responsableId;
    private Long solicitanteId;
    private Long datosCreacionAulaId;
    private Long idFacultad;
    private Timestamp fechaUltimaModificacion;
    private String inscripcionOnLine;
    private String codigoInscripcionOnLine;
    private Long estadoSolicitudAulaId;
    private Long tipoLicenciaMaterialId;
    private Integer anioPlanEstudio;
    private Collection<ClonarInfoComisionEntity> clonarInfoComisionsBySolicitudAulaId;
    private Collection<ComisionSolicitudEntity> comisionSolicitudsBySolicitudAulaId;
    private Collection<RecursoSolicitadoEntity> recursoSolicitadosBySolicitudAulaId;
    private CursoEntity cursoByCursoAclonarId;
    private CursoEntity cursoByCursoResultanteId;
    private DocenteSolicitadoEntity docenteSolicitadoByResponsableId;
    private PersonaEntity personaBySolicitanteId;
    private DatosCreacionAulaEntity datosCreacionAulaByDatosCreacionAulaId;
    private EstadoSolicitudAulaEntity estadoSolicitudAulaByEstadoSolicitudAulaId;
    private TipoLicenciaMaterialEntity tipoLicenciaMaterialByTipoLicenciaMaterialId;
    private Collection<SolicitudDocenteAulaEntity> solicitudDocenteAulasBySolicitudAulaId;

    @Id
    @Column(name = "SOLICITUD_AULA_ID")
    public long getSolicitudAulaId() {
        return solicitudAulaId;
    }

    public void setSolicitudAulaId(long solicitudAulaId) {
        this.solicitudAulaId = solicitudAulaId;
    }

    @Basic
    @Column(name = "ASIGNATURA")
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Basic
    @Column(name = "CURSO_ACLONAR_ID")
    public Long getCursoAclonarId() {
        return cursoAclonarId;
    }

    public void setCursoAclonarId(Long cursoAclonarId) {
        this.cursoAclonarId = cursoAclonarId;
    }

    @Basic
    @Column(name = "AULA_NUEVA")
    public Byte getAulaNueva() {
        return aulaNueva;
    }

    public void setAulaNueva(Byte aulaNueva) {
        this.aulaNueva = aulaNueva;
    }

    @Basic
    @Column(name = "CURSO_RESULTANTE_ID")
    public Long getCursoResultanteId() {
        return cursoResultanteId;
    }

    public void setCursoResultanteId(Long cursoResultanteId) {
        this.cursoResultanteId = cursoResultanteId;
    }

    @Basic
    @Column(name = "CANTIDAD_COMISIONES")
    public int getCantidadComisiones() {
        return cantidadComisiones;
    }

    public void setCantidadComisiones(int cantidadComisiones) {
        this.cantidadComisiones = cantidadComisiones;
    }

    @Basic
    @Column(name = "CODIGO_ASIGNATURA")
    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    @Basic
    @Column(name = "ESTADO_SOLICITUD")
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @Basic
    @Column(name = "FACULTAD")
    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Basic
    @Column(name = "FECHA_INICIO_PERIODO")
    public Timestamp getFechaInicioPeriodo() {
        return fechaInicioPeriodo;
    }

    public void setFechaInicioPeriodo(Timestamp fechaInicioPeriodo) {
        this.fechaInicioPeriodo = fechaInicioPeriodo;
    }

    @Basic
    @Column(name = "FECHA_SOLICITUD")
    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
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
    @Column(name = "PERIODO_DESARROLLO_ASIGNATURA")
    public String getPeriodoDesarrolloAsignatura() {
        return periodoDesarrolloAsignatura;
    }

    public void setPeriodoDesarrolloAsignatura(String periodoDesarrolloAsignatura) {
        this.periodoDesarrolloAsignatura = periodoDesarrolloAsignatura;
    }

    @Basic
    @Column(name = "RESPONSABLE_ID")
    public Long getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Long responsableId) {
        this.responsableId = responsableId;
    }

    @Basic
    @Column(name = "SOLICITANTE_ID")
    public Long getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Long solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    @Basic
    @Column(name = "DATOS_CREACION_AULA_ID")
    public Long getDatosCreacionAulaId() {
        return datosCreacionAulaId;
    }

    public void setDatosCreacionAulaId(Long datosCreacionAulaId) {
        this.datosCreacionAulaId = datosCreacionAulaId;
    }

    @Basic
    @Column(name = "ID_FACULTAD")
    public Long getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Long idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Basic
    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    public Timestamp getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Timestamp fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    @Basic
    @Column(name = "INSCRIPCION_ON_LINE")
    public String getInscripcionOnLine() {
        return inscripcionOnLine;
    }

    public void setInscripcionOnLine(String inscripcionOnLine) {
        this.inscripcionOnLine = inscripcionOnLine;
    }

    @Basic
    @Column(name = "CODIGO_INSCRIPCION_ON_LINE")
    public String getCodigoInscripcionOnLine() {
        return codigoInscripcionOnLine;
    }

    public void setCodigoInscripcionOnLine(String codigoInscripcionOnLine) {
        this.codigoInscripcionOnLine = codigoInscripcionOnLine;
    }

    @Basic
    @Column(name = "ESTADO_SOLICITUD_AULA_ID")
    public Long getEstadoSolicitudAulaId() {
        return estadoSolicitudAulaId;
    }

    public void setEstadoSolicitudAulaId(Long estadoSolicitudAulaId) {
        this.estadoSolicitudAulaId = estadoSolicitudAulaId;
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

        SolicitudAulaEntity that = (SolicitudAulaEntity) o;

        if (solicitudAulaId != that.solicitudAulaId) return false;
        if (cantidadComisiones != that.cantidadComisiones) return false;
        if (asignatura != null ? !asignatura.equals(that.asignatura) : that.asignatura != null) return false;
        if (cursoAclonarId != null ? !cursoAclonarId.equals(that.cursoAclonarId) : that.cursoAclonarId != null)
            return false;
        if (aulaNueva != null ? !aulaNueva.equals(that.aulaNueva) : that.aulaNueva != null) return false;
        if (cursoResultanteId != null ? !cursoResultanteId.equals(that.cursoResultanteId) : that.cursoResultanteId != null)
            return false;
        if (codigoAsignatura != null ? !codigoAsignatura.equals(that.codigoAsignatura) : that.codigoAsignatura != null)
            return false;
        if (estadoSolicitud != null ? !estadoSolicitud.equals(that.estadoSolicitud) : that.estadoSolicitud != null)
            return false;
        if (facultad != null ? !facultad.equals(that.facultad) : that.facultad != null) return false;
        if (fechaInicioPeriodo != null ? !fechaInicioPeriodo.equals(that.fechaInicioPeriodo) : that.fechaInicioPeriodo != null)
            return false;
        if (fechaSolicitud != null ? !fechaSolicitud.equals(that.fechaSolicitud) : that.fechaSolicitud != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (periodoDesarrolloAsignatura != null ? !periodoDesarrolloAsignatura.equals(that.periodoDesarrolloAsignatura) : that.periodoDesarrolloAsignatura != null)
            return false;
        if (responsableId != null ? !responsableId.equals(that.responsableId) : that.responsableId != null)
            return false;
        if (solicitanteId != null ? !solicitanteId.equals(that.solicitanteId) : that.solicitanteId != null)
            return false;
        if (datosCreacionAulaId != null ? !datosCreacionAulaId.equals(that.datosCreacionAulaId) : that.datosCreacionAulaId != null)
            return false;
        if (idFacultad != null ? !idFacultad.equals(that.idFacultad) : that.idFacultad != null) return false;
        if (fechaUltimaModificacion != null ? !fechaUltimaModificacion.equals(that.fechaUltimaModificacion) : that.fechaUltimaModificacion != null)
            return false;
        if (inscripcionOnLine != null ? !inscripcionOnLine.equals(that.inscripcionOnLine) : that.inscripcionOnLine != null)
            return false;
        if (codigoInscripcionOnLine != null ? !codigoInscripcionOnLine.equals(that.codigoInscripcionOnLine) : that.codigoInscripcionOnLine != null)
            return false;
        if (estadoSolicitudAulaId != null ? !estadoSolicitudAulaId.equals(that.estadoSolicitudAulaId) : that.estadoSolicitudAulaId != null)
            return false;
        if (tipoLicenciaMaterialId != null ? !tipoLicenciaMaterialId.equals(that.tipoLicenciaMaterialId) : that.tipoLicenciaMaterialId != null)
            return false;
        if (anioPlanEstudio != null ? !anioPlanEstudio.equals(that.anioPlanEstudio) : that.anioPlanEstudio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (solicitudAulaId ^ (solicitudAulaId >>> 32));
        result = 31 * result + (asignatura != null ? asignatura.hashCode() : 0);
        result = 31 * result + (cursoAclonarId != null ? cursoAclonarId.hashCode() : 0);
        result = 31 * result + (aulaNueva != null ? aulaNueva.hashCode() : 0);
        result = 31 * result + (cursoResultanteId != null ? cursoResultanteId.hashCode() : 0);
        result = 31 * result + cantidadComisiones;
        result = 31 * result + (codigoAsignatura != null ? codigoAsignatura.hashCode() : 0);
        result = 31 * result + (estadoSolicitud != null ? estadoSolicitud.hashCode() : 0);
        result = 31 * result + (facultad != null ? facultad.hashCode() : 0);
        result = 31 * result + (fechaInicioPeriodo != null ? fechaInicioPeriodo.hashCode() : 0);
        result = 31 * result + (fechaSolicitud != null ? fechaSolicitud.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (periodoDesarrolloAsignatura != null ? periodoDesarrolloAsignatura.hashCode() : 0);
        result = 31 * result + (responsableId != null ? responsableId.hashCode() : 0);
        result = 31 * result + (solicitanteId != null ? solicitanteId.hashCode() : 0);
        result = 31 * result + (datosCreacionAulaId != null ? datosCreacionAulaId.hashCode() : 0);
        result = 31 * result + (idFacultad != null ? idFacultad.hashCode() : 0);
        result = 31 * result + (fechaUltimaModificacion != null ? fechaUltimaModificacion.hashCode() : 0);
        result = 31 * result + (inscripcionOnLine != null ? inscripcionOnLine.hashCode() : 0);
        result = 31 * result + (codigoInscripcionOnLine != null ? codigoInscripcionOnLine.hashCode() : 0);
        result = 31 * result + (estadoSolicitudAulaId != null ? estadoSolicitudAulaId.hashCode() : 0);
        result = 31 * result + (tipoLicenciaMaterialId != null ? tipoLicenciaMaterialId.hashCode() : 0);
        result = 31 * result + (anioPlanEstudio != null ? anioPlanEstudio.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "solicitudAulaBySolicitudAulaId")
    public Collection<ClonarInfoComisionEntity> getClonarInfoComisionsBySolicitudAulaId() {
        return clonarInfoComisionsBySolicitudAulaId;
    }

    public void setClonarInfoComisionsBySolicitudAulaId(Collection<ClonarInfoComisionEntity> clonarInfoComisionsBySolicitudAulaId) {
        this.clonarInfoComisionsBySolicitudAulaId = clonarInfoComisionsBySolicitudAulaId;
    }

    @OneToMany(mappedBy = "solicitudAulaBySolicitudAulaId")
    public Collection<ComisionSolicitudEntity> getComisionSolicitudsBySolicitudAulaId() {
        return comisionSolicitudsBySolicitudAulaId;
    }

    public void setComisionSolicitudsBySolicitudAulaId(Collection<ComisionSolicitudEntity> comisionSolicitudsBySolicitudAulaId) {
        this.comisionSolicitudsBySolicitudAulaId = comisionSolicitudsBySolicitudAulaId;
    }

    @OneToMany(mappedBy = "solicitudAulaBySolicitudAulaId")
    public Collection<RecursoSolicitadoEntity> getRecursoSolicitadosBySolicitudAulaId() {
        return recursoSolicitadosBySolicitudAulaId;
    }

    public void setRecursoSolicitadosBySolicitudAulaId(Collection<RecursoSolicitadoEntity> recursoSolicitadosBySolicitudAulaId) {
        this.recursoSolicitadosBySolicitudAulaId = recursoSolicitadosBySolicitudAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "CURSO_ACLONAR_ID", referencedColumnName = "CURSO_ID", insertable=false, updatable=false)
    public CursoEntity getCursoByCursoAclonarId() {
        return cursoByCursoAclonarId;
    }

    public void setCursoByCursoAclonarId(CursoEntity cursoByCursoAclonarId) {
        this.cursoByCursoAclonarId = cursoByCursoAclonarId;
    }

    @ManyToOne
    @JoinColumn(name = "CURSO_RESULTANTE_ID", referencedColumnName = "CURSO_ID", insertable=false, updatable=false)
    public CursoEntity getCursoByCursoResultanteId() {
        return cursoByCursoResultanteId;
    }

    public void setCursoByCursoResultanteId(CursoEntity cursoByCursoResultanteId) {
        this.cursoByCursoResultanteId = cursoByCursoResultanteId;
    }

    @ManyToOne
    @JoinColumn(name = "RESPONSABLE_ID", referencedColumnName = "DOCENTE_SOLICITADO_ID", insertable=false, updatable=false)
    public DocenteSolicitadoEntity getDocenteSolicitadoByResponsableId() {
        return docenteSolicitadoByResponsableId;
    }

    public void setDocenteSolicitadoByResponsableId(DocenteSolicitadoEntity docenteSolicitadoByResponsableId) {
        this.docenteSolicitadoByResponsableId = docenteSolicitadoByResponsableId;
    }

    @ManyToOne
    @JoinColumn(name = "SOLICITANTE_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaBySolicitanteId() {
        return personaBySolicitanteId;
    }

    public void setPersonaBySolicitanteId(PersonaEntity personaBySolicitanteId) {
        this.personaBySolicitanteId = personaBySolicitanteId;
    }

    @ManyToOne
    @JoinColumn(name = "DATOS_CREACION_AULA_ID", referencedColumnName = "DATOS_CREACION_AULA_ID", insertable=false, updatable=false)
    public DatosCreacionAulaEntity getDatosCreacionAulaByDatosCreacionAulaId() {
        return datosCreacionAulaByDatosCreacionAulaId;
    }

    public void setDatosCreacionAulaByDatosCreacionAulaId(DatosCreacionAulaEntity datosCreacionAulaByDatosCreacionAulaId) {
        this.datosCreacionAulaByDatosCreacionAulaId = datosCreacionAulaByDatosCreacionAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "ESTADO_SOLICITUD_AULA_ID", referencedColumnName = "ESTADO_SOLICITUD_AULA_ID", insertable=false, updatable=false)
    public EstadoSolicitudAulaEntity getEstadoSolicitudAulaByEstadoSolicitudAulaId() {
        return estadoSolicitudAulaByEstadoSolicitudAulaId;
    }

    public void setEstadoSolicitudAulaByEstadoSolicitudAulaId(EstadoSolicitudAulaEntity estadoSolicitudAulaByEstadoSolicitudAulaId) {
        this.estadoSolicitudAulaByEstadoSolicitudAulaId = estadoSolicitudAulaByEstadoSolicitudAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_LICENCIA_MATERIAL_ID", referencedColumnName = "TIPO_LICENCIA_MATERIAL_ID", insertable=false, updatable=false)
    public TipoLicenciaMaterialEntity getTipoLicenciaMaterialByTipoLicenciaMaterialId() {
        return tipoLicenciaMaterialByTipoLicenciaMaterialId;
    }

    public void setTipoLicenciaMaterialByTipoLicenciaMaterialId(TipoLicenciaMaterialEntity tipoLicenciaMaterialByTipoLicenciaMaterialId) {
        this.tipoLicenciaMaterialByTipoLicenciaMaterialId = tipoLicenciaMaterialByTipoLicenciaMaterialId;
    }

    @OneToMany(mappedBy = "solicitudAulaBySolicitudAulaId")
    public Collection<SolicitudDocenteAulaEntity> getSolicitudDocenteAulasBySolicitudAulaId() {
        return solicitudDocenteAulasBySolicitudAulaId;
    }

    public void setSolicitudDocenteAulasBySolicitudAulaId(Collection<SolicitudDocenteAulaEntity> solicitudDocenteAulasBySolicitudAulaId) {
        this.solicitudDocenteAulasBySolicitudAulaId = solicitudDocenteAulasBySolicitudAulaId;
    }
}
