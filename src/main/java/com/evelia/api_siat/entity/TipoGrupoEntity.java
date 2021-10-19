package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_GRUPO", schema = "datosEveliaMinimo", catalog = "")
public class TipoGrupoEntity {
    private long tipoGrupoId;
    private String descripcion;
    private Long id;
    private Collection<GrupoEntity> gruposByTipoGrupoId;

    @Id
    @Column(name = "TIPO_GRUPO_ID")
    public long getTipoGrupoId() {
        return tipoGrupoId;
    }

    public void setTipoGrupoId(long tipoGrupoId) {
        this.tipoGrupoId = tipoGrupoId;
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

        TipoGrupoEntity that = (TipoGrupoEntity) o;

        if (tipoGrupoId != that.tipoGrupoId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoGrupoId ^ (tipoGrupoId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoGrupoByTipoGrupoId")
    public Collection<GrupoEntity> getGruposByTipoGrupoId() {
        return gruposByTipoGrupoId;
    }

    public void setGruposByTipoGrupoId(Collection<GrupoEntity> gruposByTipoGrupoId) {
        this.gruposByTipoGrupoId = gruposByTipoGrupoId;
    }
}
