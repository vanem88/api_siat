package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "CALIFICACION_ACTIVIDAD", schema = "datosEveliaMinimo", catalog = "")
public class CalificacionActividadEntity {
    private long calificacionActividadId;
    private Long id;
    private Long estadoCalificacionId;
    private Timestamp fechaCalificacion;
    private Long autorCalificacionId;
    private String nota;
    private Long valorCalificacionId;
    private Timestamp fechaDevolucion;
    private Long autorDevolucionId;
    private Long archivoDevolucionId;
    private byte[] devolucionTexto;
    private EstadoCalificacionEntity estadoCalificacionByEstadoCalificacionId;
    private PersonaEntity personaByAutorCalificacionId;
    private ValorCalificacionEntity valorCalificacionByValorCalificacionId;
    private PersonaEntity personaByAutorDevolucionId;
    private ArchivoEntity archivoByArchivoDevolucionId;
    private Collection<NotaEntity> notasByCalificacionActividadId;
    private Collection<NotaEntity> notasByCalificacionActividadId_0;

    @Id
    @Column(name = "CALIFICACION_ACTIVIDAD_ID")
    public long getCalificacionActividadId() {
        return calificacionActividadId;
    }

    public void setCalificacionActividadId(long calificacionActividadId) {
        this.calificacionActividadId = calificacionActividadId;
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
    @Column(name = "ESTADO_CALIFICACION_ID")
    public Long getEstadoCalificacionId() {
        return estadoCalificacionId;
    }

    public void setEstadoCalificacionId(Long estadoCalificacionId) {
        this.estadoCalificacionId = estadoCalificacionId;
    }

    @Basic
    @Column(name = "FECHA_CALIFICACION")
    public Timestamp getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(Timestamp fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    @Basic
    @Column(name = "AUTOR_CALIFICACION_ID")
    public Long getAutorCalificacionId() {
        return autorCalificacionId;
    }

    public void setAutorCalificacionId(Long autorCalificacionId) {
        this.autorCalificacionId = autorCalificacionId;
    }

    @Basic
    @Column(name = "NOTA")
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Basic
    @Column(name = "VALOR_CALIFICACION_ID")
    public Long getValorCalificacionId() {
        return valorCalificacionId;
    }

    public void setValorCalificacionId(Long valorCalificacionId) {
        this.valorCalificacionId = valorCalificacionId;
    }

    @Basic
    @Column(name = "FECHA_DEVOLUCION")
    public Timestamp getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Basic
    @Column(name = "AUTOR_DEVOLUCION_ID")
    public Long getAutorDevolucionId() {
        return autorDevolucionId;
    }

    public void setAutorDevolucionId(Long autorDevolucionId) {
        this.autorDevolucionId = autorDevolucionId;
    }

    @Basic
    @Column(name = "ARCHIVO_DEVOLUCION_ID")
    public Long getArchivoDevolucionId() {
        return archivoDevolucionId;
    }

    public void setArchivoDevolucionId(Long archivoDevolucionId) {
        this.archivoDevolucionId = archivoDevolucionId;
    }

    @Basic
    @Column(name = "DEVOLUCION_TEXTO")
    public byte[] getDevolucionTexto() {
        return devolucionTexto;
    }

    public void setDevolucionTexto(byte[] devolucionTexto) {
        this.devolucionTexto = devolucionTexto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CalificacionActividadEntity that = (CalificacionActividadEntity) o;

        if (calificacionActividadId != that.calificacionActividadId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (estadoCalificacionId != null ? !estadoCalificacionId.equals(that.estadoCalificacionId) : that.estadoCalificacionId != null)
            return false;
        if (fechaCalificacion != null ? !fechaCalificacion.equals(that.fechaCalificacion) : that.fechaCalificacion != null)
            return false;
        if (autorCalificacionId != null ? !autorCalificacionId.equals(that.autorCalificacionId) : that.autorCalificacionId != null)
            return false;
        if (nota != null ? !nota.equals(that.nota) : that.nota != null) return false;
        if (valorCalificacionId != null ? !valorCalificacionId.equals(that.valorCalificacionId) : that.valorCalificacionId != null)
            return false;
        if (fechaDevolucion != null ? !fechaDevolucion.equals(that.fechaDevolucion) : that.fechaDevolucion != null)
            return false;
        if (autorDevolucionId != null ? !autorDevolucionId.equals(that.autorDevolucionId) : that.autorDevolucionId != null)
            return false;
        if (archivoDevolucionId != null ? !archivoDevolucionId.equals(that.archivoDevolucionId) : that.archivoDevolucionId != null)
            return false;
        if (!Arrays.equals(devolucionTexto, that.devolucionTexto)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (calificacionActividadId ^ (calificacionActividadId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (estadoCalificacionId != null ? estadoCalificacionId.hashCode() : 0);
        result = 31 * result + (fechaCalificacion != null ? fechaCalificacion.hashCode() : 0);
        result = 31 * result + (autorCalificacionId != null ? autorCalificacionId.hashCode() : 0);
        result = 31 * result + (nota != null ? nota.hashCode() : 0);
        result = 31 * result + (valorCalificacionId != null ? valorCalificacionId.hashCode() : 0);
        result = 31 * result + (fechaDevolucion != null ? fechaDevolucion.hashCode() : 0);
        result = 31 * result + (autorDevolucionId != null ? autorDevolucionId.hashCode() : 0);
        result = 31 * result + (archivoDevolucionId != null ? archivoDevolucionId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(devolucionTexto);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ESTADO_CALIFICACION_ID", referencedColumnName = "ESTADO_CALIFICACION_ID", insertable=false, updatable=false)
    public EstadoCalificacionEntity getEstadoCalificacionByEstadoCalificacionId() {
        return estadoCalificacionByEstadoCalificacionId;
    }

    public void setEstadoCalificacionByEstadoCalificacionId(EstadoCalificacionEntity estadoCalificacionByEstadoCalificacionId) {
        this.estadoCalificacionByEstadoCalificacionId = estadoCalificacionByEstadoCalificacionId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTOR_CALIFICACION_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAutorCalificacionId() {
        return personaByAutorCalificacionId;
    }

    public void setPersonaByAutorCalificacionId(PersonaEntity personaByAutorCalificacionId) {
        this.personaByAutorCalificacionId = personaByAutorCalificacionId;
    }

    @ManyToOne
    @JoinColumn(name = "VALOR_CALIFICACION_ID", referencedColumnName = "VALOR_CALIFICACION_ID", insertable=false, updatable=false)
    public ValorCalificacionEntity getValorCalificacionByValorCalificacionId() {
        return valorCalificacionByValorCalificacionId;
    }

    public void setValorCalificacionByValorCalificacionId(ValorCalificacionEntity valorCalificacionByValorCalificacionId) {
        this.valorCalificacionByValorCalificacionId = valorCalificacionByValorCalificacionId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTOR_DEVOLUCION_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAutorDevolucionId() {
        return personaByAutorDevolucionId;
    }

    public void setPersonaByAutorDevolucionId(PersonaEntity personaByAutorDevolucionId) {
        this.personaByAutorDevolucionId = personaByAutorDevolucionId;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_DEVOLUCION_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoDevolucionId() {
        return archivoByArchivoDevolucionId;
    }

    public void setArchivoByArchivoDevolucionId(ArchivoEntity archivoByArchivoDevolucionId) {
        this.archivoByArchivoDevolucionId = archivoByArchivoDevolucionId;
    }

    @OneToMany(mappedBy = "calificacionActividadByCalificacionIndividualId")
    public Collection<NotaEntity> getNotasByCalificacionActividadId() {
        return notasByCalificacionActividadId;
    }

    public void setNotasByCalificacionActividadId(Collection<NotaEntity> notasByCalificacionActividadId) {
        this.notasByCalificacionActividadId = notasByCalificacionActividadId;
    }

    @OneToMany(mappedBy = "calificacionActividadByCalificacionGrupalId")
    public Collection<NotaEntity> getNotasByCalificacionActividadId_0() {
        return notasByCalificacionActividadId_0;
    }

    public void setNotasByCalificacionActividadId_0(Collection<NotaEntity> notasByCalificacionActividadId_0) {
        this.notasByCalificacionActividadId_0 = notasByCalificacionActividadId_0;
    }
}
