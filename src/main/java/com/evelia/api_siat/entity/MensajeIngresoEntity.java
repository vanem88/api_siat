package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "MENSAJE_INGRESO", schema = "datosEveliaMinimo", catalog = "")
public class MensajeIngresoEntity {
    private long mensajeIngresoId;
    private Long archivoId;
    private Long aulaId;
    private Long autorId;
    private byte[] contenido;
    private Timestamp fechaEvento;
    private Timestamp fechaFin;
    private Timestamp fechaInicio;
    private Long id;
    private String tipoMensaje;
    private String titulo;
    private Long nivelAulaId;
    private String asociadoAlMensaje;
    private ArchivoEntity archivoByArchivoId;
    private AulaEntity aulaByAulaId;
    private AulaEntity aulaByNivelAulaId;
    private Collection<PersonaMensajeIngresoEntity> personaMensajeIngresosByMensajeIngresoId;

    @Id
    @Column(name = "MENSAJE_INGRESO_ID")
    public long getMensajeIngresoId() {
        return mensajeIngresoId;
    }

    public void setMensajeIngresoId(long mensajeIngresoId) {
        this.mensajeIngresoId = mensajeIngresoId;
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
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    @Basic
    @Column(name = "AUTOR_ID")
    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    @Basic
    @Column(name = "CONTENIDO")
    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    @Basic
    @Column(name = "FECHA_EVENTO")
    public Timestamp getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Timestamp fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    @Basic
    @Column(name = "FECHA_FIN")
    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "FECHA_INICIO")
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
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
    @Column(name = "TIPO_MENSAJE")
    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    @Basic
    @Column(name = "TITULO")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "NIVEL_AULA_ID")
    public Long getNivelAulaId() {
        return nivelAulaId;
    }

    public void setNivelAulaId(Long nivelAulaId) {
        this.nivelAulaId = nivelAulaId;
    }

    @Basic
    @Column(name = "ASOCIADO_AL_MENSAJE")
    public String getAsociadoAlMensaje() {
        return asociadoAlMensaje;
    }

    public void setAsociadoAlMensaje(String asociadoAlMensaje) {
        this.asociadoAlMensaje = asociadoAlMensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MensajeIngresoEntity that = (MensajeIngresoEntity) o;

        if (mensajeIngresoId != that.mensajeIngresoId) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (autorId != null ? !autorId.equals(that.autorId) : that.autorId != null) return false;
        if (!Arrays.equals(contenido, that.contenido)) return false;
        if (fechaEvento != null ? !fechaEvento.equals(that.fechaEvento) : that.fechaEvento != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoMensaje != null ? !tipoMensaje.equals(that.tipoMensaje) : that.tipoMensaje != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (nivelAulaId != null ? !nivelAulaId.equals(that.nivelAulaId) : that.nivelAulaId != null) return false;
        if (asociadoAlMensaje != null ? !asociadoAlMensaje.equals(that.asociadoAlMensaje) : that.asociadoAlMensaje != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mensajeIngresoId ^ (mensajeIngresoId >>> 32));
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(contenido);
        result = 31 * result + (fechaEvento != null ? fechaEvento.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (tipoMensaje != null ? tipoMensaje.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (nivelAulaId != null ? nivelAulaId.hashCode() : 0);
        result = 31 * result + (asociadoAlMensaje != null ? asociadoAlMensaje.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "AULA_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByAulaId() {
        return aulaByAulaId;
    }

    public void setAulaByAulaId(AulaEntity aulaByAulaId) {
        this.aulaByAulaId = aulaByAulaId;
    }

    @ManyToOne
    @JoinColumn(name = "NIVEL_AULA_ID", referencedColumnName = "AULA_ID", insertable=false, updatable=false)
    public AulaEntity getAulaByNivelAulaId() {
        return aulaByNivelAulaId;
    }

    public void setAulaByNivelAulaId(AulaEntity aulaByNivelAulaId) {
        this.aulaByNivelAulaId = aulaByNivelAulaId;
    }

    @OneToMany(mappedBy = "mensajeIngresoByMensajeId")
    public Collection<PersonaMensajeIngresoEntity> getPersonaMensajeIngresosByMensajeIngresoId() {
        return personaMensajeIngresosByMensajeIngresoId;
    }

    public void setPersonaMensajeIngresosByMensajeIngresoId(Collection<PersonaMensajeIngresoEntity> personaMensajeIngresosByMensajeIngresoId) {
        this.personaMensajeIngresosByMensajeIngresoId = personaMensajeIngresosByMensajeIngresoId;
    }
}
