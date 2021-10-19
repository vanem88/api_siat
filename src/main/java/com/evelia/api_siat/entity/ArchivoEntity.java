package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "ARCHIVO", schema = "datosEveliaMinimo", catalog = "")
public class ArchivoEntity {
    private long archivoId;
    private Integer cantidadDownloads;
    private Long carpetaId;
    private String descripcion;
    private Timestamp fechaUp;
    private Long id;
    private String nombre;
    private String path;
    private Double tamanio;
    private String tiempoEstimado;
    private Byte escaneadoOk;
    private Byte compartido;
    private Long autorId;
    private String nombreReal;
    private Collection<ActividadArchivosAdjuntosEntity> actividadArchivosAdjuntosByArchivoId;
    private CarpetaEntity carpetaByCarpetaId;
    private PersonaEntity personaByAutorId;
    private Collection<ArchivoCompartidoAulaEntity> archivoCompartidoAulasByArchivoId;
    private Collection<ArchivoVersionadoEntity> archivoVersionadosByArchivoId;
    private Collection<CalificacionActividadEntity> calificacionActividadsByArchivoId;
    private Collection<ComentarioEntity> comentariosByArchivoId;
    private Collection<DescargaExamenEntity> descargaExamenByArchivoId;
    private Collection<DescargaMaterialEntity> descargaMaterialsByArchivoId;
    private Collection<FraseEntity> frasesByArchivoId;
    private Collection<MensajeEntity> mensajesByArchivoId;
    private Collection<MensajeAdjuntosEntity> mensajeAdjuntosByArchivoId;
    private Collection<MensajeIngresoEntity> mensajeIngresosByArchivoId;
    private Collection<NotaEntity> notasByArchivoId;
    private Collection<NoticiaExternaEntity> noticiaExternasByArchivoId;
    private Collection<PersonaArchivoCompartidaEntity> personaArchivoCompartidasByArchivoId;
    private Collection<PreguntaExAdjuntosEntity> preguntaExAdjuntosByArchivoId;
    private Collection<ProgramaArchivosEntity> programaArchivosByArchivoId;
    private Collection<SolicitudClaveEntity> solicitudClavesByArchivoId;
    private Collection<TextoEntity> textosByArchivoId;
    private Collection<VideoconferenciaEntity> videoconferenciasByArchivoId;

    @Id
    @Column(name = "ARCHIVO_ID")
    public long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(long archivoId) {
        this.archivoId = archivoId;
    }

    @Basic
    @Column(name = "CANTIDAD_DOWNLOADS")
    public Integer getCantidadDownloads() {
        return cantidadDownloads;
    }

    public void setCantidadDownloads(Integer cantidadDownloads) {
        this.cantidadDownloads = cantidadDownloads;
    }

    @Basic
    @Column(name = "CARPETA_ID")
    public Long getCarpetaId() {
        return carpetaId;
    }

    public void setCarpetaId(Long carpetaId) {
        this.carpetaId = carpetaId;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "FECHA_UP")
    public Timestamp getFechaUp() {
        return fechaUp;
    }

    public void setFechaUp(Timestamp fechaUp) {
        this.fechaUp = fechaUp;
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
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "TAMANIO")
    public Double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    @Basic
    @Column(name = "TIEMPO_ESTIMADO")
    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    @Basic
    @Column(name = "ESCANEADO_OK")
    public Byte getEscaneadoOk() {
        return escaneadoOk;
    }

    public void setEscaneadoOk(Byte escaneadoOk) {
        this.escaneadoOk = escaneadoOk;
    }

    @Basic
    @Column(name = "COMPARTIDO")
    public Byte getCompartido() {
        return compartido;
    }

    public void setCompartido(Byte compartido) {
        this.compartido = compartido;
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
    @Column(name = "NOMBRE_REAL")
    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArchivoEntity that = (ArchivoEntity) o;

        if (archivoId != that.archivoId) return false;
        if (cantidadDownloads != null ? !cantidadDownloads.equals(that.cantidadDownloads) : that.cantidadDownloads != null)
            return false;
        if (carpetaId != null ? !carpetaId.equals(that.carpetaId) : that.carpetaId != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (fechaUp != null ? !fechaUp.equals(that.fechaUp) : that.fechaUp != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (tamanio != null ? !tamanio.equals(that.tamanio) : that.tamanio != null) return false;
        if (tiempoEstimado != null ? !tiempoEstimado.equals(that.tiempoEstimado) : that.tiempoEstimado != null)
            return false;
        if (escaneadoOk != null ? !escaneadoOk.equals(that.escaneadoOk) : that.escaneadoOk != null) return false;
        if (compartido != null ? !compartido.equals(that.compartido) : that.compartido != null) return false;
        if (autorId != null ? !autorId.equals(that.autorId) : that.autorId != null) return false;
        if (nombreReal != null ? !nombreReal.equals(that.nombreReal) : that.nombreReal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (archivoId ^ (archivoId >>> 32));
        result = 31 * result + (cantidadDownloads != null ? cantidadDownloads.hashCode() : 0);
        result = 31 * result + (carpetaId != null ? carpetaId.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaUp != null ? fechaUp.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (tamanio != null ? tamanio.hashCode() : 0);
        result = 31 * result + (tiempoEstimado != null ? tiempoEstimado.hashCode() : 0);
        result = 31 * result + (escaneadoOk != null ? escaneadoOk.hashCode() : 0);
        result = 31 * result + (compartido != null ? compartido.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        result = 31 * result + (nombreReal != null ? nombreReal.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<ActividadArchivosAdjuntosEntity> getActividadArchivosAdjuntosByArchivoId() {
        return actividadArchivosAdjuntosByArchivoId;
    }

    public void setActividadArchivosAdjuntosByArchivoId(Collection<ActividadArchivosAdjuntosEntity> actividadArchivosAdjuntosByArchivoId) {
        this.actividadArchivosAdjuntosByArchivoId = actividadArchivosAdjuntosByArchivoId;
    }

    @ManyToOne
    @JoinColumn(name = "CARPETA_ID", referencedColumnName = "CARPETA_ID", insertable=false, updatable=false)
    public CarpetaEntity getCarpetaByCarpetaId() {
        return carpetaByCarpetaId;
    }

    public void setCarpetaByCarpetaId(CarpetaEntity carpetaByCarpetaId) {
        this.carpetaByCarpetaId = carpetaByCarpetaId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAutorId() {
        return personaByAutorId;
    }

    public void setPersonaByAutorId(PersonaEntity personaByAutorId) {
        this.personaByAutorId = personaByAutorId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<ArchivoCompartidoAulaEntity> getArchivoCompartidoAulasByArchivoId() {
        return archivoCompartidoAulasByArchivoId;
    }

    public void setArchivoCompartidoAulasByArchivoId(Collection<ArchivoCompartidoAulaEntity> archivoCompartidoAulasByArchivoId) {
        this.archivoCompartidoAulasByArchivoId = archivoCompartidoAulasByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<ArchivoVersionadoEntity> getArchivoVersionadosByArchivoId() {
        return archivoVersionadosByArchivoId;
    }

    public void setArchivoVersionadosByArchivoId(Collection<ArchivoVersionadoEntity> archivoVersionadosByArchivoId) {
        this.archivoVersionadosByArchivoId = archivoVersionadosByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoDevolucionId")
    public Collection<CalificacionActividadEntity> getCalificacionActividadsByArchivoId() {
        return calificacionActividadsByArchivoId;
    }

    public void setCalificacionActividadsByArchivoId(Collection<CalificacionActividadEntity> calificacionActividadsByArchivoId) {
        this.calificacionActividadsByArchivoId = calificacionActividadsByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<ComentarioEntity> getComentariosByArchivoId() {
        return comentariosByArchivoId;
    }

    public void setComentariosByArchivoId(Collection<ComentarioEntity> comentariosByArchivoId) {
        this.comentariosByArchivoId = comentariosByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<DescargaExamenEntity> getDescargaExamenByArchivoId() {
        return descargaExamenByArchivoId;
    }

    public void setDescargaExamenByArchivoId(Collection<DescargaExamenEntity> descargaExamenByArchivoId) {
        this.descargaExamenByArchivoId = descargaExamenByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<DescargaMaterialEntity> getDescargaMaterialsByArchivoId() {
        return descargaMaterialsByArchivoId;
    }

    public void setDescargaMaterialsByArchivoId(Collection<DescargaMaterialEntity> descargaMaterialsByArchivoId) {
        this.descargaMaterialsByArchivoId = descargaMaterialsByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByAdjuntoId")
    public Collection<FraseEntity> getFrasesByArchivoId() {
        return frasesByArchivoId;
    }

    public void setFrasesByArchivoId(Collection<FraseEntity> frasesByArchivoId) {
        this.frasesByArchivoId = frasesByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<MensajeEntity> getMensajesByArchivoId() {
        return mensajesByArchivoId;
    }

    public void setMensajesByArchivoId(Collection<MensajeEntity> mensajesByArchivoId) {
        this.mensajesByArchivoId = mensajesByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<MensajeAdjuntosEntity> getMensajeAdjuntosByArchivoId() {
        return mensajeAdjuntosByArchivoId;
    }

    public void setMensajeAdjuntosByArchivoId(Collection<MensajeAdjuntosEntity> mensajeAdjuntosByArchivoId) {
        this.mensajeAdjuntosByArchivoId = mensajeAdjuntosByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<MensajeIngresoEntity> getMensajeIngresosByArchivoId() {
        return mensajeIngresosByArchivoId;
    }

    public void setMensajeIngresosByArchivoId(Collection<MensajeIngresoEntity> mensajeIngresosByArchivoId) {
        this.mensajeIngresosByArchivoId = mensajeIngresosByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<NotaEntity> getNotasByArchivoId() {
        return notasByArchivoId;
    }

    public void setNotasByArchivoId(Collection<NotaEntity> notasByArchivoId) {
        this.notasByArchivoId = notasByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<NoticiaExternaEntity> getNoticiaExternasByArchivoId() {
        return noticiaExternasByArchivoId;
    }

    public void setNoticiaExternasByArchivoId(Collection<NoticiaExternaEntity> noticiaExternasByArchivoId) {
        this.noticiaExternasByArchivoId = noticiaExternasByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<PersonaArchivoCompartidaEntity> getPersonaArchivoCompartidasByArchivoId() {
        return personaArchivoCompartidasByArchivoId;
    }

    public void setPersonaArchivoCompartidasByArchivoId(Collection<PersonaArchivoCompartidaEntity> personaArchivoCompartidasByArchivoId) {
        this.personaArchivoCompartidasByArchivoId = personaArchivoCompartidasByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<PreguntaExAdjuntosEntity> getPreguntaExAdjuntosByArchivoId() {
        return preguntaExAdjuntosByArchivoId;
    }

    public void setPreguntaExAdjuntosByArchivoId(Collection<PreguntaExAdjuntosEntity> preguntaExAdjuntosByArchivoId) {
        this.preguntaExAdjuntosByArchivoId = preguntaExAdjuntosByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<ProgramaArchivosEntity> getProgramaArchivosByArchivoId() {
        return programaArchivosByArchivoId;
    }

    public void setProgramaArchivosByArchivoId(Collection<ProgramaArchivosEntity> programaArchivosByArchivoId) {
        this.programaArchivosByArchivoId = programaArchivosByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByDniEscaneadoId")
    public Collection<SolicitudClaveEntity> getSolicitudClavesByArchivoId() {
        return solicitudClavesByArchivoId;
    }

    public void setSolicitudClavesByArchivoId(Collection<SolicitudClaveEntity> solicitudClavesByArchivoId) {
        this.solicitudClavesByArchivoId = solicitudClavesByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<TextoEntity> getTextosByArchivoId() {
        return textosByArchivoId;
    }

    public void setTextosByArchivoId(Collection<TextoEntity> textosByArchivoId) {
        this.textosByArchivoId = textosByArchivoId;
    }

    @OneToMany(mappedBy = "archivoByArchivoId")
    public Collection<VideoconferenciaEntity> getVideoconferenciasByArchivoId() {
        return videoconferenciasByArchivoId;
    }

    public void setVideoconferenciasByArchivoId(Collection<VideoconferenciaEntity> videoconferenciasByArchivoId) {
        this.videoconferenciasByArchivoId = videoconferenciasByArchivoId;
    }
}
