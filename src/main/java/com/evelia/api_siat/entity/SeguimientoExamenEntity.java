package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SEGUIMIENTO_EXAMEN", schema = "datosEveliaMinimo", catalog = "")
public class SeguimientoExamenEntity {
    private long seguimientoExamenId;
    private Long id;
    private long personaId;
    private boolean esDocente;
    private Long examenFinalizadoId;
    private Timestamp fecha;
    private String descripcion;
    private PersonaEntity personaByPersonaId;
    private EvaluacionFinalizadaEntity evaluacionFinalizadaByExamenFinalizadoId;

    @Id
    @Column(name = "SEGUIMIENTO_EXAMEN_ID")
    public long getSeguimientoExamenId() {
        return seguimientoExamenId;
    }

    public void setSeguimientoExamenId(long seguimientoExamenId) {
        this.seguimientoExamenId = seguimientoExamenId;
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
    @Column(name = "PERSONA_ID")
    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "ES_DOCENTE")
    public boolean isEsDocente() {
        return esDocente;
    }

    public void setEsDocente(boolean esDocente) {
        this.esDocente = esDocente;
    }

    @Basic
    @Column(name = "EXAMEN_FINALIZADO_ID")
    public Long getExamenFinalizadoId() {
        return examenFinalizadoId;
    }

    public void setExamenFinalizadoId(Long examenFinalizadoId) {
        this.examenFinalizadoId = examenFinalizadoId;
    }

    @Basic
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeguimientoExamenEntity that = (SeguimientoExamenEntity) o;

        if (seguimientoExamenId != that.seguimientoExamenId) return false;
        if (personaId != that.personaId) return false;
        if (esDocente != that.esDocente) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (examenFinalizadoId != null ? !examenFinalizadoId.equals(that.examenFinalizadoId) : that.examenFinalizadoId != null)
            return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seguimientoExamenId ^ (seguimientoExamenId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (int) (personaId ^ (personaId >>> 32));
        result = 31 * result + (esDocente ? 1 : 0);
        result = 31 * result + (examenFinalizadoId != null ? examenFinalizadoId.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", nullable = false, insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "EXAMEN_FINALIZADO_ID", referencedColumnName = "EVALUACION_FINALIZADA_ID", insertable=false, updatable=false)
    public EvaluacionFinalizadaEntity getEvaluacionFinalizadaByExamenFinalizadoId() {
        return evaluacionFinalizadaByExamenFinalizadoId;
    }

    public void setEvaluacionFinalizadaByExamenFinalizadoId(EvaluacionFinalizadaEntity evaluacionFinalizadaByExamenFinalizadoId) {
        this.evaluacionFinalizadaByExamenFinalizadoId = evaluacionFinalizadaByExamenFinalizadoId;
    }
}
