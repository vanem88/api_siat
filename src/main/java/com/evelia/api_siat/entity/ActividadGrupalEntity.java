package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVIDAD_GRUPAL", schema = "datosEveliaMinimo", catalog = "")
public class ActividadGrupalEntity {
    private long actividadGrupalId;
    private Long actividadId;
    private Long grupoId;
    private Long id;
    private ActividadEntity actividadByActividadId;
    private GrupoEntity grupoByGrupoId;

    @Id
    @Column(name = "ACTIVIDAD_GRUPAL_ID")
    public long getActividadGrupalId() {
        return actividadGrupalId;
    }

    public void setActividadGrupalId(long actividadGrupalId) {
        this.actividadGrupalId = actividadGrupalId;
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
    @Column(name = "GRUPO_ID")
    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    @Basic
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActividadGrupalEntity that = (ActividadGrupalEntity) o;

        if (actividadGrupalId != that.actividadGrupalId) return false;
        if (actividadId != null ? !actividadId.equals(that.actividadId) : that.actividadId != null) return false;
        if (grupoId != null ? !grupoId.equals(that.grupoId) : that.grupoId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (actividadGrupalId ^ (actividadGrupalId >>> 32));
        result = 31 * result + (actividadId != null ? actividadId.hashCode() : 0);
        result = 31 * result + (grupoId != null ? grupoId.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
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
    @JoinColumn(name = "GRUPO_ID", referencedColumnName = "GRUPO_ID", insertable=false, updatable=false)
    public GrupoEntity getGrupoByGrupoId() {
        return grupoByGrupoId;
    }

    public void setGrupoByGrupoId(GrupoEntity grupoByGrupoId) {
        this.grupoByGrupoId = grupoByGrupoId;
    }
}
