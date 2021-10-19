package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "ACTIVIDAD", schema = "datosEveliaMinimo", catalog = "")
public class ActividadEntity {
	
    private long actividadId;
    private Long aulaId;
    private String descripcion;
    private Long eventoFinalizacionId;
    private Timestamp fechaApertura;
    private Timestamp fechaCierre;
    private Long id;
    private Long tipoCalificacionId;
    private Long tipoActividadId;
    private String alcance;
    private String paraQuien;
    private String modoRespuesta;
    private boolean borrador;
    private byte[] detalles;
    private Long notaAprobarId;
    private Long personaId;
    private boolean generarEvento;
    private Long publicacionId;
    private boolean duplicado;
    private AulaEntity aulaByAulaId;
    private TipoCalificacionEntity tipoCalificacionByTipoCalificacionId;
    private TipoActividadEntity tipoActividadByTipoActividadId;
    private NotaAprobarActividadEntity notaAprobarActividadByNotaAprobarId;
    private PersonaEntity personaByPersonaId;
    private PublicacionEntity publicacionByPublicacionId;
    private Collection<ActividadArchivosAdjuntosEntity> actividadArchivosAdjuntosByActividadId;
    private Collection<ActividadGrupalEntity> actividadGrupalsByActividadId;
    private Collection<NotaEntity> notasByActividadId;

    @Id
    @Column(name = "ACTIVIDAD_ID")
    public long getActividadId() {
        return actividadId;
    }

    public void setActividadId(long actividadId) {
        this.actividadId = actividadId;
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
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    @Column(name = "FECHA_APERTURA")
    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Basic
    @Column(name = "FECHA_CIERRE")
    public Timestamp getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Timestamp fechaCierre) {
        this.fechaCierre = fechaCierre;
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
    @Column(name = "TIPO_CALIFICACION_ID")
    public Long getTipoCalificacionId() {
        return tipoCalificacionId;
    }

    public void setTipoCalificacionId(Long tipoCalificacionId) {
        this.tipoCalificacionId = tipoCalificacionId;
    }

    @Basic
    @Column(name = "TIPO_ACTIVIDAD_ID")
    public Long getTipoActividadId() {
        return tipoActividadId;
    }

    public void setTipoActividadId(Long tipoActividadId) {
        this.tipoActividadId = tipoActividadId;
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
    @Column(name = "PARA_QUIEN")
    public String getParaQuien() {
        return paraQuien;
    }

    public void setParaQuien(String paraQuien) {
        this.paraQuien = paraQuien;
    }

    @Basic
    @Column(name = "MODO_RESPUESTA")
    public String getModoRespuesta() {
        return modoRespuesta;
    }

    public void setModoRespuesta(String modoRespuesta) {
        this.modoRespuesta = modoRespuesta;
    }

    @Basic
    @Column(name = "BORRADOR")
    public boolean isBorrador() {
        return borrador;
    }

    public void setBorrador(boolean borrador) {
        this.borrador = borrador;
    }

    @Basic
    @Column(name = "DETALLES")
    public byte[] getDetalles() {
        return detalles;
    }

    public void setDetalles(byte[] detalles) {
        this.detalles = detalles;
    }

    @Basic
    @Column(name = "NOTA_APROBAR_ID")
    public Long getNotaAprobarId() {
        return notaAprobarId;
    }

    public void setNotaAprobarId(Long notaAprobarId) {
        this.notaAprobarId = notaAprobarId;
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
    @Column(name = "GENERAR_EVENTO")
    public boolean isGenerarEvento() {
        return generarEvento;
    }

    public void setGenerarEvento(boolean generarEvento) {
        this.generarEvento = generarEvento;
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

        ActividadEntity that = (ActividadEntity) o;

        if (actividadId != that.actividadId) return false;
        if (borrador != that.borrador) return false;
        if (generarEvento != that.generarEvento) return false;
        if (duplicado != that.duplicado) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (eventoFinalizacionId != null ? !eventoFinalizacionId.equals(that.eventoFinalizacionId) : that.eventoFinalizacionId != null)
            return false;
        if (fechaApertura != null ? !fechaApertura.equals(that.fechaApertura) : that.fechaApertura != null)
            return false;
        if (fechaCierre != null ? !fechaCierre.equals(that.fechaCierre) : that.fechaCierre != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoCalificacionId != null ? !tipoCalificacionId.equals(that.tipoCalificacionId) : that.tipoCalificacionId != null)
            return false;
        if (tipoActividadId != null ? !tipoActividadId.equals(that.tipoActividadId) : that.tipoActividadId != null)
            return false;
        if (alcance != null ? !alcance.equals(that.alcance) : that.alcance != null) return false;
        if (paraQuien != null ? !paraQuien.equals(that.paraQuien) : that.paraQuien != null) return false;
        if (modoRespuesta != null ? !modoRespuesta.equals(that.modoRespuesta) : that.modoRespuesta != null)
            return false;
        if (!Arrays.equals(detalles, that.detalles)) return false;
        if (notaAprobarId != null ? !notaAprobarId.equals(that.notaAprobarId) : that.notaAprobarId != null)
            return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (publicacionId != null ? !publicacionId.equals(that.publicacionId) : that.publicacionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (actividadId ^ (actividadId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (eventoFinalizacionId != null ? eventoFinalizacionId.hashCode() : 0);
        result = 31 * result + (fechaApertura != null ? fechaApertura.hashCode() : 0);
        result = 31 * result + (fechaCierre != null ? fechaCierre.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (tipoCalificacionId != null ? tipoCalificacionId.hashCode() : 0);
        result = 31 * result + (tipoActividadId != null ? tipoActividadId.hashCode() : 0);
        result = 31 * result + (alcance != null ? alcance.hashCode() : 0);
        result = 31 * result + (paraQuien != null ? paraQuien.hashCode() : 0);
        result = 31 * result + (modoRespuesta != null ? modoRespuesta.hashCode() : 0);
        result = 31 * result + (borrador ? 1 : 0);
        result = 31 * result + Arrays.hashCode(detalles);
        result = 31 * result + (notaAprobarId != null ? notaAprobarId.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (generarEvento ? 1 : 0);
        result = 31 * result + (publicacionId != null ? publicacionId.hashCode() : 0);
        result = 31 * result + (duplicado ? 1 : 0);
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
    @JoinColumn(name = "TIPO_CALIFICACION_ID", referencedColumnName = "TIPO_CALIFICACION_ID", insertable=false, updatable=false)
    public TipoCalificacionEntity getTipoCalificacionByTipoCalificacionId() {
        return tipoCalificacionByTipoCalificacionId;
    }

    public void setTipoCalificacionByTipoCalificacionId(TipoCalificacionEntity tipoCalificacionByTipoCalificacionId) {
        this.tipoCalificacionByTipoCalificacionId = tipoCalificacionByTipoCalificacionId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_ACTIVIDAD_ID", referencedColumnName = "TIPO_ACTIVIDAD_ID", insertable=false, updatable=false)
    public TipoActividadEntity getTipoActividadByTipoActividadId() {
        return tipoActividadByTipoActividadId;
    }

    public void setTipoActividadByTipoActividadId(TipoActividadEntity tipoActividadByTipoActividadId) {
        this.tipoActividadByTipoActividadId = tipoActividadByTipoActividadId;
    }

    @ManyToOne
    @JoinColumn(name = "NOTA_APROBAR_ID", referencedColumnName = "NOTA_APROBAR_ACTIVIDAD_ID", insertable=false, updatable=false)
    public NotaAprobarActividadEntity getNotaAprobarActividadByNotaAprobarId() {
        return notaAprobarActividadByNotaAprobarId;
    }

    public void setNotaAprobarActividadByNotaAprobarId(NotaAprobarActividadEntity notaAprobarActividadByNotaAprobarId) {
        this.notaAprobarActividadByNotaAprobarId = notaAprobarActividadByNotaAprobarId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }

    @OneToMany(mappedBy = "actividadByActividadId")
    public Collection<ActividadArchivosAdjuntosEntity> getActividadArchivosAdjuntosByActividadId() {
        return actividadArchivosAdjuntosByActividadId;
    }

    public void setActividadArchivosAdjuntosByActividadId(Collection<ActividadArchivosAdjuntosEntity> actividadArchivosAdjuntosByActividadId) {
        this.actividadArchivosAdjuntosByActividadId = actividadArchivosAdjuntosByActividadId;
    }

    @OneToMany(mappedBy = "actividadByActividadId")
    public Collection<ActividadGrupalEntity> getActividadGrupalsByActividadId() {
        return actividadGrupalsByActividadId;
    }

    public void setActividadGrupalsByActividadId(Collection<ActividadGrupalEntity> actividadGrupalsByActividadId) {
        this.actividadGrupalsByActividadId = actividadGrupalsByActividadId;
    }

    @OneToMany(mappedBy = "actividadByActividadId")
    public Collection<NotaEntity> getNotasByActividadId() {
        return notasByActividadId;
    }

    public void setNotasByActividadId(Collection<NotaEntity> notasByActividadId) {
        this.notasByActividadId = notasByActividadId;
    }
    
    //@OneToOne(mappedBy = "actividadByPublicacionId")
    @OneToOne
    @JoinColumn(name = "PUBLICACION_ID", referencedColumnName = "PUBLICACION_ID", insertable=false, updatable=false)
    public PublicacionEntity getPublicacionByPublicacionId() {
        return this.publicacionByPublicacionId;
    }

    public void setPublicacionByPublicacionId(PublicacionEntity publicacionEntity) {
        this.publicacionByPublicacionId = publicacionEntity;
    }
}
