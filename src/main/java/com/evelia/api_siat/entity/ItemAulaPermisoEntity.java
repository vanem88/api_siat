package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ITEM_AULA_PERMISO", schema = "datosEveliaMinimo", catalog = "")
public class ItemAulaPermisoEntity {
    private long itemAulaPermisoId;
    private Long id;
    private Long aulaId;
    private Long recursoId;
    private Long tipoPermisoId;
    private Long tipoUsuarioId;
    private String nivel;
    private boolean activo;
    private Timestamp fechaCreacion;
    private Timestamp fechaDesactiva;
    private Long personaId;
    private AulaEntity aulaByAulaId;
    private RecursoEntity recursoByRecursoId;
    private TipoPermisoEntity tipoPermisoByTipoPermisoId;
    private TipoUsuarioEntity tipoUsuarioByTipoUsuarioId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "ITEM_AULA_PERMISO_ID")
    public long getItemAulaPermisoId() {
        return itemAulaPermisoId;
    }

    public void setItemAulaPermisoId(long itemAulaPermisoId) {
        this.itemAulaPermisoId = itemAulaPermisoId;
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
    @Column(name = "AULA_ID")
    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    @Basic
    @Column(name = "RECURSO_ID")
    public Long getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(Long recursoId) {
        this.recursoId = recursoId;
    }

    @Basic
    @Column(name = "TIPO_PERMISO_ID")
    public Long getTipoPermisoId() {
        return tipoPermisoId;
    }

    public void setTipoPermisoId(Long tipoPermisoId) {
        this.tipoPermisoId = tipoPermisoId;
    }

    @Basic
    @Column(name = "TIPO_USUARIO_ID")
    public Long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @Basic
    @Column(name = "NIVEL")
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Basic
    @Column(name = "ACTIVO")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "FECHA_CREACION")
    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Basic
    @Column(name = "FECHA_DESACTIVA")
    public Timestamp getFechaDesactiva() {
        return fechaDesactiva;
    }

    public void setFechaDesactiva(Timestamp fechaDesactiva) {
        this.fechaDesactiva = fechaDesactiva;
    }

    @Basic
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemAulaPermisoEntity that = (ItemAulaPermisoEntity) o;

        if (itemAulaPermisoId != that.itemAulaPermisoId) return false;
        if (activo != that.activo) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (recursoId != null ? !recursoId.equals(that.recursoId) : that.recursoId != null) return false;
        if (tipoPermisoId != null ? !tipoPermisoId.equals(that.tipoPermisoId) : that.tipoPermisoId != null)
            return false;
        if (tipoUsuarioId != null ? !tipoUsuarioId.equals(that.tipoUsuarioId) : that.tipoUsuarioId != null)
            return false;
        if (nivel != null ? !nivel.equals(that.nivel) : that.nivel != null) return false;
        if (fechaCreacion != null ? !fechaCreacion.equals(that.fechaCreacion) : that.fechaCreacion != null)
            return false;
        if (fechaDesactiva != null ? !fechaDesactiva.equals(that.fechaDesactiva) : that.fechaDesactiva != null)
            return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (itemAulaPermisoId ^ (itemAulaPermisoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (recursoId != null ? recursoId.hashCode() : 0);
        result = 31 * result + (tipoPermisoId != null ? tipoPermisoId.hashCode() : 0);
        result = 31 * result + (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        result = 31 * result + (activo ? 1 : 0);
        result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        result = 31 * result + (fechaDesactiva != null ? fechaDesactiva.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
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
    @JoinColumn(name = "RECURSO_ID", referencedColumnName = "RECURSO_ID", insertable=false, updatable=false)
    public RecursoEntity getRecursoByRecursoId() {
        return recursoByRecursoId;
    }

    public void setRecursoByRecursoId(RecursoEntity recursoByRecursoId) {
        this.recursoByRecursoId = recursoByRecursoId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_PERMISO_ID", referencedColumnName = "TIPO_PERMISO_ID", insertable=false, updatable=false)
    public TipoPermisoEntity getTipoPermisoByTipoPermisoId() {
        return tipoPermisoByTipoPermisoId;
    }

    public void setTipoPermisoByTipoPermisoId(TipoPermisoEntity tipoPermisoByTipoPermisoId) {
        this.tipoPermisoByTipoPermisoId = tipoPermisoByTipoPermisoId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "TIPO_USUARIO_ID", insertable=false, updatable=false)
    public TipoUsuarioEntity getTipoUsuarioByTipoUsuarioId() {
        return tipoUsuarioByTipoUsuarioId;
    }

    public void setTipoUsuarioByTipoUsuarioId(TipoUsuarioEntity tipoUsuarioByTipoUsuarioId) {
        this.tipoUsuarioByTipoUsuarioId = tipoUsuarioByTipoUsuarioId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
