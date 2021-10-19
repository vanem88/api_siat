package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "FORO", schema = "datosEveliaMinimo", catalog = "")
public class ForoEntity {
    private long foroId;
    private String asunto;
    private Long aulaId;
    private Timestamp fecha;
    private Long id;
    private String pathArchivo;
    private Timestamp fechaCierre;
    private String paraQuien;
    private String alcance;
    private Long autorId;
    private Long publicacionId;
    private boolean duplicado;
    private Long eventoFinalizacionId;
    private AulaEntity aulaByAulaId;
    private PersonaEntity personaByAutorId;
    private PublicacionEntity publicacionByPublicacionId;
    private TextoEntity textoByEventoFinalizacionId;
    private Collection<ForoGrupalEntity> foroGrupalsByForoId;
    private Collection<ForoModeradoresEntity> foroModeradoresByForoId;
    private Collection<LecturasForoEntity> lecturasForosByForoId;
    private Collection<MensajeEntity> mensajesByForoId;

    @Id
    @Column(name = "FORO_ID")
    public long getForoId() {
        return foroId;
    }

    public void setForoId(long foroId) {
        this.foroId = foroId;
    }

    @Basic
    @Column(name = "ASUNTO")
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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
    @Column(name = "PATH_ARCHIVO")
    public String getPathArchivo() {
        return pathArchivo;
    }

    public void setPathArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
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
    @Column(name = "PARA_QUIEN")
    public String getParaQuien() {
        return paraQuien;
    }

    public void setParaQuien(String paraQuien) {
        this.paraQuien = paraQuien;
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
    @Column(name = "DUPLICADO")
    public boolean isDuplicado() {
        return duplicado;
    }

    public void setDuplicado(boolean duplicado) {
        this.duplicado = duplicado;
    }

    @Basic
    @Column(name = "EVENTO_FINALIZACION_ID")
    public Long getEventoFinalizacionId() {
        return eventoFinalizacionId;
    }

    public void setEventoFinalizacionId(Long eventoFinalizacionId) {
        this.eventoFinalizacionId = eventoFinalizacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForoEntity that = (ForoEntity) o;

        if (foroId != that.foroId) return false;
        if (duplicado != that.duplicado) return false;
        if (asunto != null ? !asunto.equals(that.asunto) : that.asunto != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pathArchivo != null ? !pathArchivo.equals(that.pathArchivo) : that.pathArchivo != null) return false;
        if (fechaCierre != null ? !fechaCierre.equals(that.fechaCierre) : that.fechaCierre != null) return false;
        if (paraQuien != null ? !paraQuien.equals(that.paraQuien) : that.paraQuien != null) return false;
        if (alcance != null ? !alcance.equals(that.alcance) : that.alcance != null) return false;
        if (autorId != null ? !autorId.equals(that.autorId) : that.autorId != null) return false;
        if (publicacionId != null ? !publicacionId.equals(that.publicacionId) : that.publicacionId != null)
            return false;
        if (eventoFinalizacionId != null ? !eventoFinalizacionId.equals(that.eventoFinalizacionId) : that.eventoFinalizacionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (foroId ^ (foroId >>> 32));
        result = 31 * result + (asunto != null ? asunto.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (pathArchivo != null ? pathArchivo.hashCode() : 0);
        result = 31 * result + (fechaCierre != null ? fechaCierre.hashCode() : 0);
        result = 31 * result + (paraQuien != null ? paraQuien.hashCode() : 0);
        result = 31 * result + (alcance != null ? alcance.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        result = 31 * result + (publicacionId != null ? publicacionId.hashCode() : 0);
        result = 31 * result + (duplicado ? 1 : 0);
        result = 31 * result + (eventoFinalizacionId != null ? eventoFinalizacionId.hashCode() : 0);
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

    @OneToMany(mappedBy = "foroByForoId")
    public Collection<ForoGrupalEntity> getForoGrupalsByForoId() {
        return foroGrupalsByForoId;
    }

    public void setForoGrupalsByForoId(Collection<ForoGrupalEntity> foroGrupalsByForoId) {
        this.foroGrupalsByForoId = foroGrupalsByForoId;
    }

    @OneToMany(mappedBy = "foroByForoId")
    public Collection<ForoModeradoresEntity> getForoModeradoresByForoId() {
        return foroModeradoresByForoId;
    }

    public void setForoModeradoresByForoId(Collection<ForoModeradoresEntity> foroModeradoresByForoId) {
        this.foroModeradoresByForoId = foroModeradoresByForoId;
    }

    @OneToMany(mappedBy = "foroByForoId")
    public Collection<LecturasForoEntity> getLecturasForosByForoId() {
        return lecturasForosByForoId;
    }

    public void setLecturasForosByForoId(Collection<LecturasForoEntity> lecturasForosByForoId) {
        this.lecturasForosByForoId = lecturasForosByForoId;
    }

    @OneToMany(mappedBy = "foroByForoId")
    public Collection<MensajeEntity> getMensajesByForoId() {
        return mensajesByForoId;
    }

    public void setMensajesByForoId(Collection<MensajeEntity> mensajesByForoId) {
        this.mensajesByForoId = mensajesByForoId;
    }
    @OneToOne
    @JoinColumn(name = "PUBLICACION_ID", referencedColumnName = "PUBLICACION_ID", insertable=false, updatable=false)
    public PublicacionEntity getPublicacionByPublicacionId() {
        return this.publicacionByPublicacionId;
    }

    public void setPublicacionByPublicacionId(PublicacionEntity publicacionEntity) {
        this.publicacionByPublicacionId = publicacionEntity;
    }
}
