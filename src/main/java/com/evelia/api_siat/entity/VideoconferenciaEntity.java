package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "VIDEOCONFERENCIA", schema = "datosEveliaMinimo", catalog = "")
public class VideoconferenciaEntity {
    private long videoconferenciaId;
    private Long id;
    private String nombre;
    private String descripcion;
    private String alcance;
    private Long aulaId;
    private Long archivoId;
    private Timestamp fechaCreado;
    private Long autorId;
    private Long publicacionId;
    private Long eventoFinalizacionId;
    private String urlSala;
    private String nombreMostrar;
    private boolean grabar;
    private boolean verificarGrabacion;
    private boolean poseeGrabacion;
    private String nombreGrabacion;
    private Long videoRepeticionId;
    private Integer cantidadGrabaciones;
    private AulaEntity aulaByAulaId;
    private ArchivoEntity archivoByArchivoId;
    private PersonaEntity personaByAutorId;
    private TextoEntity textoByEventoFinalizacionId;
    private VideoRepeticionEntity videoRepeticionByVideoRepeticionId;
    private Collection<VideoconferenciaCompartirEntity> videoconferenciaCompartirsByVideoconferenciaId;
    private Collection<VideoconferenciaModeradoresEntity> videoconferenciaModeradoresByVideoconferenciaId;
    private Collection<VideoconferenciaParticipantesEntity> videoconferenciaParticipantesByVideoconferenciaId;
    private Collection<VideoGrabacionEntity> videoGrabacionsByVideoconferenciaId;

    @Id
    @Column(name = "VIDEOCONFERENCIA_ID")
    public long getVideoconferenciaId() {
        return videoconferenciaId;
    }

    public void setVideoconferenciaId(long videoconferenciaId) {
        this.videoconferenciaId = videoconferenciaId;
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
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ALCANCE")
    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
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
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
    }

    @Basic
    @Column(name = "FECHA_CREADO")
    public Timestamp getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Timestamp fechaCreado) {
        this.fechaCreado = fechaCreado;
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
    @Column(name = "PUBLICACION_ID")
    public Long getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Long publicacionId) {
        this.publicacionId = publicacionId;
    }

    @Basic
    @Column(name = "EVENTO_FINALIZACION_ID")
    public Long getEventoFinalizacionId() {
        return eventoFinalizacionId;
    }

    public void setEventoFinalizacionId(Long eventoFinalizacionId) {
        this.eventoFinalizacionId = eventoFinalizacionId;
    }

    @Basic
    @Column(name = "URL_SALA")
    public String getUrlSala() {
        return urlSala;
    }

    public void setUrlSala(String urlSala) {
        this.urlSala = urlSala;
    }

    @Basic
    @Column(name = "NOMBRE_MOSTRAR")
    public String getNombreMostrar() {
        return nombreMostrar;
    }

    public void setNombreMostrar(String nombreMostrar) {
        this.nombreMostrar = nombreMostrar;
    }

    @Basic
    @Column(name = "GRABAR")
    public boolean isGrabar() {
        return grabar;
    }

    public void setGrabar(boolean grabar) {
        this.grabar = grabar;
    }

    @Basic
    @Column(name = "VERIFICAR_GRABACION")
    public boolean isVerificarGrabacion() {
        return verificarGrabacion;
    }

    public void setVerificarGrabacion(boolean verificarGrabacion) {
        this.verificarGrabacion = verificarGrabacion;
    }

    @Basic
    @Column(name = "POSEE_GRABACION")
    public boolean isPoseeGrabacion() {
        return poseeGrabacion;
    }

    public void setPoseeGrabacion(boolean poseeGrabacion) {
        this.poseeGrabacion = poseeGrabacion;
    }

    @Basic
    @Column(name = "NOMBRE_GRABACION")
    public String getNombreGrabacion() {
        return nombreGrabacion;
    }

    public void setNombreGrabacion(String nombreGrabacion) {
        this.nombreGrabacion = nombreGrabacion;
    }

    @Basic
    @Column(name = "VIDEO_REPETICION_ID")
    public Long getVideoRepeticionId() {
        return videoRepeticionId;
    }

    public void setVideoRepeticionId(Long videoRepeticionId) {
        this.videoRepeticionId = videoRepeticionId;
    }

    @Basic
    @Column(name = "CANTIDAD_GRABACIONES")
    public Integer getCantidadGrabaciones() {
        return cantidadGrabaciones;
    }

    public void setCantidadGrabaciones(Integer cantidadGrabaciones) {
        this.cantidadGrabaciones = cantidadGrabaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoconferenciaEntity that = (VideoconferenciaEntity) o;

        if (videoconferenciaId != that.videoconferenciaId) return false;
        if (grabar != that.grabar) return false;
        if (verificarGrabacion != that.verificarGrabacion) return false;
        if (poseeGrabacion != that.poseeGrabacion) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (alcance != null ? !alcance.equals(that.alcance) : that.alcance != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (fechaCreado != null ? !fechaCreado.equals(that.fechaCreado) : that.fechaCreado != null) return false;
        if (autorId != null ? !autorId.equals(that.autorId) : that.autorId != null) return false;
        if (publicacionId != null ? !publicacionId.equals(that.publicacionId) : that.publicacionId != null)
            return false;
        if (eventoFinalizacionId != null ? !eventoFinalizacionId.equals(that.eventoFinalizacionId) : that.eventoFinalizacionId != null)
            return false;
        if (urlSala != null ? !urlSala.equals(that.urlSala) : that.urlSala != null) return false;
        if (nombreMostrar != null ? !nombreMostrar.equals(that.nombreMostrar) : that.nombreMostrar != null)
            return false;
        if (nombreGrabacion != null ? !nombreGrabacion.equals(that.nombreGrabacion) : that.nombreGrabacion != null)
            return false;
        if (videoRepeticionId != null ? !videoRepeticionId.equals(that.videoRepeticionId) : that.videoRepeticionId != null)
            return false;
        if (cantidadGrabaciones != null ? !cantidadGrabaciones.equals(that.cantidadGrabaciones) : that.cantidadGrabaciones != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (videoconferenciaId ^ (videoconferenciaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (alcance != null ? alcance.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (fechaCreado != null ? fechaCreado.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        result = 31 * result + (publicacionId != null ? publicacionId.hashCode() : 0);
        result = 31 * result + (eventoFinalizacionId != null ? eventoFinalizacionId.hashCode() : 0);
        result = 31 * result + (urlSala != null ? urlSala.hashCode() : 0);
        result = 31 * result + (nombreMostrar != null ? nombreMostrar.hashCode() : 0);
        result = 31 * result + (grabar ? 1 : 0);
        result = 31 * result + (verificarGrabacion ? 1 : 0);
        result = 31 * result + (poseeGrabacion ? 1 : 0);
        result = 31 * result + (nombreGrabacion != null ? nombreGrabacion.hashCode() : 0);
        result = 31 * result + (videoRepeticionId != null ? videoRepeticionId.hashCode() : 0);
        result = 31 * result + (cantidadGrabaciones != null ? cantidadGrabaciones.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTOR_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByAutorId() {
        return personaByAutorId;
    }

    public void setPersonaByAutorId(PersonaEntity personaByAutorId) {
        this.personaByAutorId = personaByAutorId;
    }

    @ManyToOne
    @JoinColumn(name = "EVENTO_FINALIZACION_ID", referencedColumnName = "TEXTO_ID", insertable=false, updatable=false)
    public TextoEntity getTextoByEventoFinalizacionId() {
        return textoByEventoFinalizacionId;
    }

    public void setTextoByEventoFinalizacionId(TextoEntity textoByEventoFinalizacionId) {
        this.textoByEventoFinalizacionId = textoByEventoFinalizacionId;
    }

    @ManyToOne
    @JoinColumn(name = "VIDEO_REPETICION_ID", referencedColumnName = "VIDEO_REPETICION_ID", insertable=false, updatable=false)
    public VideoRepeticionEntity getVideoRepeticionByVideoRepeticionId() {
        return videoRepeticionByVideoRepeticionId;
    }

    public void setVideoRepeticionByVideoRepeticionId(VideoRepeticionEntity videoRepeticionByVideoRepeticionId) {
        this.videoRepeticionByVideoRepeticionId = videoRepeticionByVideoRepeticionId;
    }

    @OneToMany(mappedBy = "videoconferenciaByVideoconferenciaId")
    public Collection<VideoconferenciaCompartirEntity> getVideoconferenciaCompartirsByVideoconferenciaId() {
        return videoconferenciaCompartirsByVideoconferenciaId;
    }

    public void setVideoconferenciaCompartirsByVideoconferenciaId(Collection<VideoconferenciaCompartirEntity> videoconferenciaCompartirsByVideoconferenciaId) {
        this.videoconferenciaCompartirsByVideoconferenciaId = videoconferenciaCompartirsByVideoconferenciaId;
    }

    @OneToMany(mappedBy = "videoconferenciaByVideoconferenciaId")
    public Collection<VideoconferenciaModeradoresEntity> getVideoconferenciaModeradoresByVideoconferenciaId() {
        return videoconferenciaModeradoresByVideoconferenciaId;
    }

    public void setVideoconferenciaModeradoresByVideoconferenciaId(Collection<VideoconferenciaModeradoresEntity> videoconferenciaModeradoresByVideoconferenciaId) {
        this.videoconferenciaModeradoresByVideoconferenciaId = videoconferenciaModeradoresByVideoconferenciaId;
    }

    @OneToMany(mappedBy = "videoconferenciaByVideoconferenciaId")
    public Collection<VideoconferenciaParticipantesEntity> getVideoconferenciaParticipantesByVideoconferenciaId() {
        return videoconferenciaParticipantesByVideoconferenciaId;
    }

    public void setVideoconferenciaParticipantesByVideoconferenciaId(Collection<VideoconferenciaParticipantesEntity> videoconferenciaParticipantesByVideoconferenciaId) {
        this.videoconferenciaParticipantesByVideoconferenciaId = videoconferenciaParticipantesByVideoconferenciaId;
    }

    @OneToMany(mappedBy = "videoconferenciaByVideoconferenciaId")
    public Collection<VideoGrabacionEntity> getVideoGrabacionsByVideoconferenciaId() {
        return videoGrabacionsByVideoconferenciaId;
    }

    public void setVideoGrabacionsByVideoconferenciaId(Collection<VideoGrabacionEntity> videoGrabacionsByVideoconferenciaId) {
        this.videoGrabacionsByVideoconferenciaId = videoGrabacionsByVideoconferenciaId;
    }
}
