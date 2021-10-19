package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_PERMISO", schema = "datosEveliaMinimo", catalog = "")
public class TipoPermisoEntity {
    private long tipoPermisoId;
    private String descripcion;
    private Long id;
    private Collection<ItemAulaPermisoEntity> itemAulaPermisosByTipoPermisoId;
    private Collection<ItemPlantillaPermisoEntity> itemPlantillaPermisosByTipoPermisoId;
    private Collection<PermisoAccesoEntity> permisoAccesosByTipoPermisoId;

    @Id
    @Column(name = "TIPO_PERMISO_ID")
    public long getTipoPermisoId() {
        return tipoPermisoId;
    }

    public void setTipoPermisoId(long tipoPermisoId) {
        this.tipoPermisoId = tipoPermisoId;
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

        TipoPermisoEntity that = (TipoPermisoEntity) o;

        if (tipoPermisoId != that.tipoPermisoId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoPermisoId ^ (tipoPermisoId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoPermisoByTipoPermisoId")
    public Collection<ItemAulaPermisoEntity> getItemAulaPermisosByTipoPermisoId() {
        return itemAulaPermisosByTipoPermisoId;
    }

    public void setItemAulaPermisosByTipoPermisoId(Collection<ItemAulaPermisoEntity> itemAulaPermisosByTipoPermisoId) {
        this.itemAulaPermisosByTipoPermisoId = itemAulaPermisosByTipoPermisoId;
    }

    @OneToMany(mappedBy = "tipoPermisoByTipoPermisoId")
    public Collection<ItemPlantillaPermisoEntity> getItemPlantillaPermisosByTipoPermisoId() {
        return itemPlantillaPermisosByTipoPermisoId;
    }

    public void setItemPlantillaPermisosByTipoPermisoId(Collection<ItemPlantillaPermisoEntity> itemPlantillaPermisosByTipoPermisoId) {
        this.itemPlantillaPermisosByTipoPermisoId = itemPlantillaPermisosByTipoPermisoId;
    }

    @OneToMany(mappedBy = "tipoPermisoByTipoPermisoId")
    public Collection<PermisoAccesoEntity> getPermisoAccesosByTipoPermisoId() {
        return permisoAccesosByTipoPermisoId;
    }

    public void setPermisoAccesosByTipoPermisoId(Collection<PermisoAccesoEntity> permisoAccesosByTipoPermisoId) {
        this.permisoAccesosByTipoPermisoId = permisoAccesosByTipoPermisoId;
    }
}
