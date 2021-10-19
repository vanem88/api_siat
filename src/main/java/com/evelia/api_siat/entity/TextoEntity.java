package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "TEXTO", schema = "datosEveliaMinimo", catalog = "")
public class TextoEntity {
    private long textoId;
    private Long archivoId;
    private Long comunicacionId;
    private byte[] contenido;
    private Timestamp fecha;
    private Timestamp fechaEvento;
    private Timestamp fechaFinEvento;
    private Long id;
    private Long personaId;
    private String titulo;
    private Long integracionId;
    private Long estadoId;
    private String tipoEvento;
    private boolean eliminado;
    private boolean generarAlerta;
    private Long eventoRepeticionId;
    private boolean conComentarios;
    private Long publicacionId;
    private boolean duplicado;
    private Collection<ComentarioEntity> comentariosByTextoId;
    private Collection<EvaluacionEntity> evaluacionsByTextoId;
    private Collection<ForoEntity> forosByTextoId;
    private Collection<ForoGrupalEntity> foroGrupalsByTextoId;
    private InvitacionEntity invitacionByTextoId;
    private SolicitudEntity solicitudByTextoId;
    private ArchivoEntity archivoByArchivoId;
    private ComunicacionEntity comunicacionByComunicacionId;
    private PersonaEntity personaByPersonaId;
    private IntegracionEntity integracionByIntegracionId;
    private EstadoIntegracionEntity estadoIntegracionByEstadoId;
    private EventoRepeticionEntity eventoRepeticionByEventoRepeticionId;
    private Collection<VideoconferenciaEntity> videoconferenciasByTextoId;

    @Id
    @Column(name = "TEXTO_ID")
    public long getTextoId() {
        return textoId;
    }

    public void setTextoId(long textoId) {
        this.textoId = textoId;
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
    @Column(name = "COMUNICACION_ID")
    public Long getComunicacionId() {
        return comunicacionId;
    }

    public void setComunicacionId(Long comunicacionId) {
        this.comunicacionId = comunicacionId;
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
    @Column(name = "FECHA")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
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
    @Column(name = "FECHA_FIN_EVENTO")
    public Timestamp getFechaFinEvento() {
        return fechaFinEvento;
    }

    public void setFechaFinEvento(Timestamp fechaFinEvento) {
        this.fechaFinEvento = fechaFinEvento;
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
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
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
    @Column(name = "INTEGRACION_ID")
    public Long getIntegracionId() {
        return integracionId;
    }

    public void setIntegracionId(Long integracionId) {
        this.integracionId = integracionId;
    }

    @Basic
    @Column(name = "ESTADO_ID")
    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    @Basic
    @Column(name = "TIPO_EVENTO")
    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Basic
    @Column(name = "ELIMINADO")
    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Basic
    @Column(name = "GENERAR_ALERTA")
    public boolean isGenerarAlerta() {
        return generarAlerta;
    }

    public void setGenerarAlerta(boolean generarAlerta) {
        this.generarAlerta = generarAlerta;
    }

    @Basic
    @Column(name = "EVENTO_REPETICION_ID")
    public Long getEventoRepeticionId() {
        return eventoRepeticionId;
    }

    public void setEventoRepeticionId(Long eventoRepeticionId) {
        this.eventoRepeticionId = eventoRepeticionId;
    }

    @Basic
    @Column(name = "CON_COMENTARIOS")
    public boolean isConComentarios() {
        return conComentarios;
    }

    public void setConComentarios(boolean conComentarios) {
        this.conComentarios = conComentarios;
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
    @Column(name = "DUPLICADO")
    public boolean isDuplicado() {
        return duplicado;
    }

    public void setDuplicado(boolean duplicado) {
        this.duplicado = duplicado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextoEntity that = (TextoEntity) o;

        if (textoId != that.textoId) return false;
        if (eliminado != that.eliminado) return false;
        if (generarAlerta != that.generarAlerta) return false;
        if (conComentarios != that.conComentarios) return false;
        if (duplicado != that.duplicado) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (comunicacionId != null ? !comunicacionId.equals(that.comunicacionId) : that.comunicacionId != null)
            return false;
        if (!Arrays.equals(contenido, that.contenido)) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (fechaEvento != null ? !fechaEvento.equals(that.fechaEvento) : that.fechaEvento != null) return false;
        if (fechaFinEvento != null ? !fechaFinEvento.equals(that.fechaFinEvento) : that.fechaFinEvento != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (integracionId != null ? !integracionId.equals(that.integracionId) : that.integracionId != null)
            return false;
        if (estadoId != null ? !estadoId.equals(that.estadoId) : that.estadoId != null) return false;
        if (tipoEvento != null ? !tipoEvento.equals(that.tipoEvento) : that.tipoEvento != null) return false;
        if (eventoRepeticionId != null ? !eventoRepeticionId.equals(that.eventoRepeticionId) : that.eventoRepeticionId != null)
            return false;
        if (publicacionId != null ? !publicacionId.equals(that.publicacionId) : that.publicacionId != null)
          return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (textoId ^ (textoId >>> 32));
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (comunicacionId != null ? comunicacionId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(contenido);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (fechaEvento != null ? fechaEvento.hashCode() : 0);
        result = 31 * result + (fechaFinEvento != null ? fechaFinEvento.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (integracionId != null ? integracionId.hashCode() : 0);
        result = 31 * result + (estadoId != null ? estadoId.hashCode() : 0);
        result = 31 * result + (tipoEvento != null ? tipoEvento.hashCode() : 0);
        result = 31 * result + (eliminado ? 1 : 0);
        result = 31 * result + (generarAlerta ? 1 : 0);
        result = 31 * result + (eventoRepeticionId != null ? eventoRepeticionId.hashCode() : 0);
        result = 31 * result + (conComentarios ? 1 : 0);
        result = 31 * result + (publicacionId != null ? publicacionId.hashCode() : 0);
        result = 31 * result + (duplicado ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "textoByTextoPadreId")
    public Collection<ComentarioEntity> getComentariosByTextoId() {
        return comentariosByTextoId;
    }

    public void setComentariosByTextoId(Collection<ComentarioEntity> comentariosByTextoId) {
        this.comentariosByTextoId = comentariosByTextoId;
    }

    @OneToMany(mappedBy = "textoByEventoFinalizacionId")
    public Collection<EvaluacionEntity> getEvaluacionsByTextoId() {
        return evaluacionsByTextoId;
    }

    public void setEvaluacionsByTextoId(Collection<EvaluacionEntity> evaluacionsByTextoId) {
        this.evaluacionsByTextoId = evaluacionsByTextoId;
    }

    @OneToMany(mappedBy = "textoByEventoFinalizacionId")
    public Collection<ForoEntity> getForosByTextoId() {
        return forosByTextoId;
    }

    public void setForosByTextoId(Collection<ForoEntity> forosByTextoId) {
        this.forosByTextoId = forosByTextoId;
    }

    @OneToMany(mappedBy = "textoByEventoFinalizacionId")
    public Collection<ForoGrupalEntity> getForoGrupalsByTextoId() {
        return foroGrupalsByTextoId;
    }

    public void setForoGrupalsByTextoId(Collection<ForoGrupalEntity> foroGrupalsByTextoId) {
        this.foroGrupalsByTextoId = foroGrupalsByTextoId;
    }

    @OneToOne(mappedBy = "textoByInvitacionId")
    public InvitacionEntity getInvitacionByTextoId() {
        return invitacionByTextoId;
    }

    public void setInvitacionByTextoId(InvitacionEntity invitacionByTextoId) {
        this.invitacionByTextoId = invitacionByTextoId;
    }

    @OneToOne(mappedBy = "textoBySolicitudId")
    public SolicitudEntity getSolicitudByTextoId() {
        return solicitudByTextoId;
    }

    public void setSolicitudByTextoId(SolicitudEntity solicitudByTextoId) {
        this.solicitudByTextoId = solicitudByTextoId;
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
    @JoinColumn(name = "COMUNICACION_ID", referencedColumnName = "COMUNICACION_ID", insertable=false, updatable=false)
    public ComunicacionEntity getComunicacionByComunicacionId() {
        return comunicacionByComunicacionId;
    }

    public void setComunicacionByComunicacionId(ComunicacionEntity comunicacionByComunicacionId) {
        this.comunicacionByComunicacionId = comunicacionByComunicacionId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @ManyToOne
    @JoinColumn(name = "INTEGRACION_ID", referencedColumnName = "INTEGRACION_ID", insertable=false, updatable=false)
    public IntegracionEntity getIntegracionByIntegracionId() {
        return integracionByIntegracionId;
    }

    public void setIntegracionByIntegracionId(IntegracionEntity integracionByIntegracionId) {
        this.integracionByIntegracionId = integracionByIntegracionId;
    }

    @ManyToOne
    @JoinColumn(name = "ESTADO_ID", referencedColumnName = "ESTADO_INTEGRACION_ID", insertable=false, updatable=false)
    public EstadoIntegracionEntity getEstadoIntegracionByEstadoId() {
        return estadoIntegracionByEstadoId;
    }

    public void setEstadoIntegracionByEstadoId(EstadoIntegracionEntity estadoIntegracionByEstadoId) {
        this.estadoIntegracionByEstadoId = estadoIntegracionByEstadoId;
    }

    @ManyToOne
    @JoinColumn(name = "EVENTO_REPETICION_ID", referencedColumnName = "EVENTO_REPETICION_ID", insertable=false, updatable=false)
    public EventoRepeticionEntity getEventoRepeticionByEventoRepeticionId() {
        return eventoRepeticionByEventoRepeticionId;
    }

    public void setEventoRepeticionByEventoRepeticionId(EventoRepeticionEntity eventoRepeticionByEventoRepeticionId) {
        this.eventoRepeticionByEventoRepeticionId = eventoRepeticionByEventoRepeticionId;
    }

    @OneToMany(mappedBy = "textoByEventoFinalizacionId")
    public Collection<VideoconferenciaEntity> getVideoconferenciasByTextoId() {
        return videoconferenciasByTextoId;
    }

    public void setVideoconferenciasByTextoId(Collection<VideoconferenciaEntity> videoconferenciasByTextoId) {
        this.videoconferenciasByTextoId = videoconferenciasByTextoId;
    }
}
