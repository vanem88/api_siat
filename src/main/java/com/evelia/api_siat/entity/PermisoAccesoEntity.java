package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PERMISO_ACCESO", schema = "datosEveliaMinimo", catalog = "")
public class PermisoAccesoEntity {
    private long permisoAccesoId;
    private Long aulaId;
    private Long id;
    private Long recursoId;
    private Long tipoPermisoId;
    private Long tipoUsuarioId;
    private AulaEntity aulaByAulaId;
    private RecursoEntity recursoByRecursoId;
    private TipoPermisoEntity tipoPermisoByTipoPermisoId;
    private TipoUsuarioEntity tipoUsuarioByTipoUsuarioId;
    private Collection<PersonaPermisoAccesoEntity> personaPermisoAccesosByPermisoAccesoId;

    @Id
    @Column(name = "PERMISO_ACCESO_ID")
    public long getPermisoAccesoId() {
        return permisoAccesoId;
    }

    public void setPermisoAccesoId(long permisoAccesoId) {
        this.permisoAccesoId = permisoAccesoId;
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
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermisoAccesoEntity that = (PermisoAccesoEntity) o;

        if (permisoAccesoId != that.permisoAccesoId) return false;
        if (aulaId != null ? !aulaId.equals(that.aulaId) : that.aulaId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recursoId != null ? !recursoId.equals(that.recursoId) : that.recursoId != null) return false;
        if (tipoPermisoId != null ? !tipoPermisoId.equals(that.tipoPermisoId) : that.tipoPermisoId != null)
            return false;
        if (tipoUsuarioId != null ? !tipoUsuarioId.equals(that.tipoUsuarioId) : that.tipoUsuarioId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (permisoAccesoId ^ (permisoAccesoId >>> 32));
        result = 31 * result + (aulaId != null ? aulaId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (recursoId != null ? recursoId.hashCode() : 0);
        result = 31 * result + (tipoPermisoId != null ? tipoPermisoId.hashCode() : 0);
        result = 31 * result + (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
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

    @OneToMany(mappedBy = "permisoAccesoByPermisoAccesoId")
    public Collection<PersonaPermisoAccesoEntity> getPersonaPermisoAccesosByPermisoAccesoId() {
        return personaPermisoAccesosByPermisoAccesoId;
    }

    public void setPersonaPermisoAccesosByPermisoAccesoId(Collection<PersonaPermisoAccesoEntity> personaPermisoAccesosByPermisoAccesoId) {
        this.personaPermisoAccesosByPermisoAccesoId = personaPermisoAccesosByPermisoAccesoId;
    }
}
