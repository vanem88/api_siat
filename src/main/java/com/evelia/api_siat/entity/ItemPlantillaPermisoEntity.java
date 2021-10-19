package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_PLANTILLA_PERMISO", schema = "datosEveliaMinimo", catalog = "")
public class ItemPlantillaPermisoEntity {
    private long itemPlantillaPermisoId;
    private Long id;
    private Long plantillaPermisoId;
    private Long recursoId;
    private Long tipoPermisoId;
    private Long tipoUsuarioId;
    private String nivel;
    private PlantillaPermisoEntity plantillaPermisoByPlantillaPermisoId;
    private RecursoEntity recursoByRecursoId;
    private TipoPermisoEntity tipoPermisoByTipoPermisoId;
    private TipoUsuarioEntity tipoUsuarioByTipoUsuarioId;

    @Id
    @Column(name = "ITEM_PLANTILLA_PERMISO_ID")
    public long getItemPlantillaPermisoId() {
        return itemPlantillaPermisoId;
    }

    public void setItemPlantillaPermisoId(long itemPlantillaPermisoId) {
        this.itemPlantillaPermisoId = itemPlantillaPermisoId;
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
    @Column(name = "PLANTILLA_PERMISO_ID")
    public Long getPlantillaPermisoId() {
        return plantillaPermisoId;
    }

    public void setPlantillaPermisoId(Long plantillaPermisoId) {
        this.plantillaPermisoId = plantillaPermisoId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemPlantillaPermisoEntity that = (ItemPlantillaPermisoEntity) o;

        if (itemPlantillaPermisoId != that.itemPlantillaPermisoId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (plantillaPermisoId != null ? !plantillaPermisoId.equals(that.plantillaPermisoId) : that.plantillaPermisoId != null)
            return false;
        if (recursoId != null ? !recursoId.equals(that.recursoId) : that.recursoId != null) return false;
        if (tipoPermisoId != null ? !tipoPermisoId.equals(that.tipoPermisoId) : that.tipoPermisoId != null)
            return false;
        if (tipoUsuarioId != null ? !tipoUsuarioId.equals(that.tipoUsuarioId) : that.tipoUsuarioId != null)
            return false;
        if (nivel != null ? !nivel.equals(that.nivel) : that.nivel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (itemPlantillaPermisoId ^ (itemPlantillaPermisoId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (plantillaPermisoId != null ? plantillaPermisoId.hashCode() : 0);
        result = 31 * result + (recursoId != null ? recursoId.hashCode() : 0);
        result = 31 * result + (tipoPermisoId != null ? tipoPermisoId.hashCode() : 0);
        result = 31 * result + (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PLANTILLA_PERMISO_ID", referencedColumnName = "PLANTILLA_PERMISO_ID", insertable=false, updatable=false)
    public PlantillaPermisoEntity getPlantillaPermisoByPlantillaPermisoId() {
        return plantillaPermisoByPlantillaPermisoId;
    }

    public void setPlantillaPermisoByPlantillaPermisoId(PlantillaPermisoEntity plantillaPermisoByPlantillaPermisoId) {
        this.plantillaPermisoByPlantillaPermisoId = plantillaPermisoByPlantillaPermisoId;
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
}
