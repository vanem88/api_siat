package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "EVALUACION_FINALIZADA", schema = "datosEveliaMinimo", catalog = "")
public class EvaluacionFinalizadaEntity {
    private long evaluacionFinalizadaId;
    private Long alumnoId;
    private Long evaluacionId;
    private Timestamp fechaRealizacion;
    private Long id;
    private boolean dispositivoMovil;
    private String sistemaOperativo;
    private String navegador;
    private boolean eliminado;
    private AutoexamenFinalizadoEntity autoexamenFinalizadoByEvaluacionFinalizadaId;
    private Collection<DescargaExamenEntity> descargaExamenByEvaluacionFinalizadaId;
    private PersonaEntity personaByAlumnoId;
    private EvaluacionEntity evaluacionByEvaluacionId;
    private EvaluacionFinalizadaConRespuestasEntity evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaId;
    private Collection<SeguimientoExamenEntity> seguimientoExamenByEvaluacionFinalizadaId;

    @Id
    @Column(name = "EVALUACION_FINALIZADA_ID")
    public long getEvaluacionFinalizadaId() {
        return evaluacionFinalizadaId;
    }

    public void setEvaluacionFinalizadaId(long evaluacionFinalizadaId) {
        this.evaluacionFinalizadaId = evaluacionFinalizadaId;
    }

    @Basic
    @Column(name = "ALUMNO_ID")
    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    @Basic
    @Column(name = "EVALUACION_ID")
    public Long getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(Long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    @Basic
    @Column(name = "FECHA_REALIZACION")
    public Timestamp getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Timestamp fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
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
    @Column(name = "DISPOSITIVO_MOVIL")
    public boolean isDispositivoMovil() {
        return dispositivoMovil;
    }

    public void setDispositivoMovil(boolean dispositivoMovil) {
        this.dispositivoMovil = dispositivoMovil;
    }

    @Basic
    @Column(name = "SISTEMA_OPERATIVO")
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Basic
    @Column(name = "NAVEGADOR")
    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    @Basic
    @Column(name = "ELIMINADO")
    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluacionFinalizadaEntity that = (EvaluacionFinalizadaEntity) o;

        if (evaluacionFinalizadaId != that.evaluacionFinalizadaId) return false;
        if (dispositivoMovil != that.dispositivoMovil) return false;
        if (eliminado != that.eliminado) return false;
        if (alumnoId != null ? !alumnoId.equals(that.alumnoId) : that.alumnoId != null) return false;
        if (evaluacionId != null ? !evaluacionId.equals(that.evaluacionId) : that.evaluacionId != null) return false;
        if (fechaRealizacion != null ? !fechaRealizacion.equals(that.fechaRealizacion) : that.fechaRealizacion != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (sistemaOperativo != null ? !sistemaOperativo.equals(that.sistemaOperativo) : that.sistemaOperativo != null)
            return false;
        if (navegador != null ? !navegador.equals(that.navegador) : that.navegador != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (evaluacionFinalizadaId ^ (evaluacionFinalizadaId >>> 32));
        result = 31 * result + (alumnoId != null ? alumnoId.hashCode() : 0);
        result = 31 * result + (evaluacionId != null ? evaluacionId.hashCode() : 0);
        result = 31 * result + (fechaRealizacion != null ? fechaRealizacion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (dispositivoMovil ? 1 : 0);
        result = 31 * result + (sistemaOperativo != null ? sistemaOperativo.hashCode() : 0);
        result = 31 * result + (navegador != null ? navegador.hashCode() : 0);
        result = 31 * result + (eliminado ? 1 : 0);
        return result;
    }

    @OneToOne(mappedBy = "evaluacionFinalizadaByAutoexamenFinalizadoId")
    public AutoexamenFinalizadoEntity getAutoexamenFinalizadoByEvaluacionFinalizadaId() {
        return autoexamenFinalizadoByEvaluacionFinalizadaId;
    }

    public void setAutoexamenFinalizadoByEvaluacionFinalizadaId(AutoexamenFinalizadoEntity autoexamenFinalizadoByEvaluacionFinalizadaId) {
        this.autoexamenFinalizadoByEvaluacionFinalizadaId = autoexamenFinalizadoByEvaluacionFinalizadaId;
    }

    @OneToMany(mappedBy = "evaluacionFinalizadaByExamenFinalizadoId")
    public Collection<DescargaExamenEntity> getDescargaExamenByEvaluacionFinalizadaId() {
        return descargaExamenByEvaluacionFinalizadaId;
    }

    public void setDescargaExamenByEvaluacionFinalizadaId(Collection<DescargaExamenEntity> descargaExamenByEvaluacionFinalizadaId) {
        this.descargaExamenByEvaluacionFinalizadaId = descargaExamenByEvaluacionFinalizadaId;
    }

    @ManyToOne
    @JoinColumn(name = "ALUMNO_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAlumnoId() {
        return personaByAlumnoId;
    }

    public void setPersonaByAlumnoId(PersonaEntity personaByAlumnoId) {
        this.personaByAlumnoId = personaByAlumnoId;
    }

    @ManyToOne
    @JoinColumn(name = "EVALUACION_ID", referencedColumnName = "EVALUACION_ID", insertable=false, updatable=false)
    public EvaluacionEntity getEvaluacionByEvaluacionId() {
        return evaluacionByEvaluacionId;
    }

    public void setEvaluacionByEvaluacionId(EvaluacionEntity evaluacionByEvaluacionId) {
        this.evaluacionByEvaluacionId = evaluacionByEvaluacionId;
    }

    @OneToOne(mappedBy = "evaluacionFinalizadaByEvaluacionFinalizadaConRespuestasId")
    public EvaluacionFinalizadaConRespuestasEntity getEvaluacionFinalizadaConRespuestasByEvaluacionFinalizadaId() {
        return evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaId;
    }

    public void setEvaluacionFinalizadaConRespuestasByEvaluacionFinalizadaId(EvaluacionFinalizadaConRespuestasEntity evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaId) {
        this.evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaId = evaluacionFinalizadaConRespuestasByEvaluacionFinalizadaId;
    }

    @OneToMany(mappedBy = "evaluacionFinalizadaByExamenFinalizadoId")
    public Collection<SeguimientoExamenEntity> getSeguimientoExamenByEvaluacionFinalizadaId() {
        return seguimientoExamenByEvaluacionFinalizadaId;
    }

    public void setSeguimientoExamenByEvaluacionFinalizadaId(Collection<SeguimientoExamenEntity> seguimientoExamenByEvaluacionFinalizadaId) {
        this.seguimientoExamenByEvaluacionFinalizadaId = seguimientoExamenByEvaluacionFinalizadaId;
    }
}
