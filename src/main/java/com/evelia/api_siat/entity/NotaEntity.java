package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "NOTA", schema = "datosEveliaMinimo", catalog = "")
public class NotaEntity {
    private long notaId;
    private Long actividadId;
    private Long archivoId;
    private Long estadoNotaId;
    private Timestamp fecha;
    private Long id;
    private String observaciones;
    private Long personaId;
    private Long personaRealizoEntregaId;
    private Timestamp fechaProrroga;
    private byte[] descripcionAlumno;
    private Long calificacionIndividualId;
    private Long calificacionGrupalId;
    private ActividadEntity actividadByActividadId;
    private ArchivoEntity archivoByArchivoId;
    private EstadoNotaEntity estadoNotaByEstadoNotaId;
    private PersonaEntity personaByPersonaId;
    private PersonaEntity personaRealizoEntregaByPersonaRealizoEntregaId;
    private CalificacionActividadEntity calificacionActividadByCalificacionIndividualId;
    private CalificacionActividadEntity calificacionActividadByCalificacionGrupalId;

    @Id
    @Column(name = "NOTA_ID")
    public long getNotaId() {
        return notaId;
    }

    public void setNotaId(long notaId) {
        this.notaId = notaId;
    }

    @Basic
    @Column(name = "ACTIVIDAD_ID")
    public Long getActividadId() {
        return actividadId;
    }

    public void setActividadId(Long actividadId) {
        this.actividadId = actividadId;
    }

    @Basic
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
    }

    @Basic
    @Column(name = "ESTADO_NOTA_ID")
    public Long getEstadoNotaId() {
        return estadoNotaId;
    }

    public void setEstadoNotaId(Long estadoNotaId) {
        this.estadoNotaId = estadoNotaId;
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
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OBSERVACIONES")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Basic
    @Column(name = "PERSONA_REALIZO_ENTREGA_ID")
    public Long getPersonaRealizoEntregaId() {
        return personaRealizoEntregaId;
    }

    public void setPersonaRealizoEntregaId(Long personaRealizoEntregaId) {
        this.personaRealizoEntregaId = personaRealizoEntregaId;
    }

    @Basic
    @Column(name = "FECHA_PRORROGA")
    public Timestamp getFechaProrroga() {
        return fechaProrroga;
    }

    public void setFechaProrroga(Timestamp fechaProrroga) {
        this.fechaProrroga = fechaProrroga;
    }

    @Basic
    @Column(name = "DESCRIPCION_ALUMNO")
    public byte[] getDescripcionAlumno() {
        return descripcionAlumno;
    }

    public void setDescripcionAlumno(byte[] descripcionAlumno) {
        this.descripcionAlumno = descripcionAlumno;
    }

    @Basic
    @Column(name = "CALIFICACION_INDIVIDUAL_ID")
    public Long getCalificacionIndividualId() {
        return calificacionIndividualId;
    }

    public void setCalificacionIndividualId(Long calificacionIndividualId) {
        this.calificacionIndividualId = calificacionIndividualId;
    }

    @Basic
    @Column(name = "CALIFICACION_GRUPAL_ID")
    public Long getCalificacionGrupalId() {
        return calificacionGrupalId;
    }

    public void setCalificacionGrupalId(Long calificacionGrupalId) {
        this.calificacionGrupalId = calificacionGrupalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaEntity that = (NotaEntity) o;

        if (notaId != that.notaId) return false;
        if (actividadId != null ? !actividadId.equals(that.actividadId) : that.actividadId != null) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (estadoNotaId != null ? !estadoNotaId.equals(that.estadoNotaId) : that.estadoNotaId != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (observaciones != null ? !observaciones.equals(that.observaciones) : that.observaciones != null)
            return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (personaRealizoEntregaId != null ? !personaRealizoEntregaId.equals(that.personaRealizoEntregaId) : that.personaRealizoEntregaId != null)
            return false;
        if (fechaProrroga != null ? !fechaProrroga.equals(that.fechaProrroga) : that.fechaProrroga != null)
            return false;
        if (!Arrays.equals(descripcionAlumno, that.descripcionAlumno)) return false;
        if (calificacionIndividualId != null ? !calificacionIndividualId.equals(that.calificacionIndividualId) : that.calificacionIndividualId != null)
            return false;
        if (calificacionGrupalId != null ? !calificacionGrupalId.equals(that.calificacionGrupalId) : that.calificacionGrupalId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (notaId ^ (notaId >>> 32));
        result = 31 * result + (actividadId != null ? actividadId.hashCode() : 0);
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (estadoNotaId != null ? estadoNotaId.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (personaRealizoEntregaId != null ? personaRealizoEntregaId.hashCode() : 0);
        result = 31 * result + (fechaProrroga != null ? fechaProrroga.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(descripcionAlumno);
        result = 31 * result + (calificacionIndividualId != null ? calificacionIndividualId.hashCode() : 0);
        result = 31 * result + (calificacionGrupalId != null ? calificacionGrupalId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ACTIVIDAD_ID", referencedColumnName = "ACTIVIDAD_ID", insertable=false, updatable=false)
    public ActividadEntity getActividadByActividadId() {
        return actividadByActividadId;
    }

    public void setActividadByActividadId(ActividadEntity actividadByActividadId) {
        this.actividadByActividadId = actividadByActividadId;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }

    @ManyToOne
    @JoinColumn(name = "ESTADO_NOTA_ID", referencedColumnName = "ESTADO_NOTA_ID", insertable=false, updatable=false)
    public EstadoNotaEntity getEstadoNotaByEstadoNotaId() {
        return estadoNotaByEstadoNotaId;
    }

    public void setEstadoNotaByEstadoNotaId(EstadoNotaEntity estadoNotaByEstadoNotaId) {
        this.estadoNotaByEstadoNotaId = estadoNotaByEstadoNotaId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID",insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
    
    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID",insertable=false, updatable=false)
    public PersonaEntity getPersonaRealizoEntregaByPersonaRealizoEntregaId() {
        return personaRealizoEntregaByPersonaRealizoEntregaId;
    }

    public void setPersonaRealizoEntregaByPersonaRealizoEntregaId(PersonaEntity personaByPersonaId) {
        this.personaRealizoEntregaByPersonaRealizoEntregaId = personaByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "CALIFICACION_INDIVIDUAL_ID", referencedColumnName = "CALIFICACION_ACTIVIDAD_ID", insertable=false, updatable=false)
    public CalificacionActividadEntity getCalificacionActividadByCalificacionIndividualId() {
        return calificacionActividadByCalificacionIndividualId;
    }

    public void setCalificacionActividadByCalificacionIndividualId(CalificacionActividadEntity calificacionActividadByCalificacionIndividualId) {
        this.calificacionActividadByCalificacionIndividualId = calificacionActividadByCalificacionIndividualId;
    }

    @ManyToOne
    @JoinColumn(name = "CALIFICACION_GRUPAL_ID", referencedColumnName = "CALIFICACION_ACTIVIDAD_ID", insertable=false, updatable=false)
    public CalificacionActividadEntity getCalificacionActividadByCalificacionGrupalId() {
        return calificacionActividadByCalificacionGrupalId;
    }

    public void setCalificacionActividadByCalificacionGrupalId(CalificacionActividadEntity calificacionActividadByCalificacionGrupalId) {
        this.calificacionActividadByCalificacionGrupalId = calificacionActividadByCalificacionGrupalId;
    }
}
