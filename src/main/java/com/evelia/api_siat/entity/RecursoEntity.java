package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "RECURSO", schema = "datosEveliaMinimo", catalog = "")
public class RecursoEntity {
    private long recursoId;
    private String descripcion;
    private Long id;
    private String nombre;
    private String nombreMostrar;
    private Long orden;
    private Long tipoRecursoId;
    private boolean habilitadoCampus;
    private boolean habilitadoCarrera;
    private boolean habilitadoAula;
    private boolean habilitadoComision;
    private boolean habilitadoGrupo;
    private Boolean editable;
    private Collection<ItemAulaPermisoEntity> itemAulaPermisosByRecursoId;
    private Collection<ItemPlantillaPermisoEntity> itemPlantillaPermisosByRecursoId;
    private Collection<PermisoAccesoEntity> permisoAccesosByRecursoId;
    private TipoRecursoEntity tipoRecursoByTipoRecursoId;
    private Collection<RecursoCategoriaUsuarioEntity> recursoCategoriaUsuariosByRecursoId;
    private Collection<RecursoSolicitadoEntity> recursoSolicitadosByRecursoId;
    private Collection<RedSocialRecursoEntity> redSocialRecursosByRecursoId;
    private Collection<SeguimientoAccesoEntity> seguimientoAccesosByRecursoId;
    private Collection<SeguimientoAccesoElementoEntity> seguimientoAccesoElementosByRecursoId;

    @Id
    @Column(name = "RECURSO_ID")
    public long getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(long recursoId) {
        this.recursoId = recursoId;
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

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    @Column(name = "ORDEN")
    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "TIPO_RECURSO_ID")
    public Long getTipoRecursoId() {
        return tipoRecursoId;
    }

    public void setTipoRecursoId(Long tipoRecursoId) {
        this.tipoRecursoId = tipoRecursoId;
    }

    @Basic
    @Column(name = "HABILITADO_CAMPUS")
    public boolean isHabilitadoCampus() {
        return habilitadoCampus;
    }

    public void setHabilitadoCampus(boolean habilitadoCampus) {
        this.habilitadoCampus = habilitadoCampus;
    }

    @Basic
    @Column(name = "HABILITADO_CARRERA")
    public boolean isHabilitadoCarrera() {
        return habilitadoCarrera;
    }

    public void setHabilitadoCarrera(boolean habilitadoCarrera) {
        this.habilitadoCarrera = habilitadoCarrera;
    }

    @Basic
    @Column(name = "HABILITADO_AULA")
    public boolean isHabilitadoAula() {
        return habilitadoAula;
    }

    public void setHabilitadoAula(boolean habilitadoAula) {
        this.habilitadoAula = habilitadoAula;
    }

    @Basic
    @Column(name = "HABILITADO_COMISION")
    public boolean isHabilitadoComision() {
        return habilitadoComision;
    }

    public void setHabilitadoComision(boolean habilitadoComision) {
        this.habilitadoComision = habilitadoComision;
    }

    @Basic
    @Column(name = "HABILITADO_GRUPO")
    public boolean isHabilitadoGrupo() {
        return habilitadoGrupo;
    }

    public void setHabilitadoGrupo(boolean habilitadoGrupo) {
        this.habilitadoGrupo = habilitadoGrupo;
    }

    @Basic
    @Column(name = "EDITABLE")
    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecursoEntity that = (RecursoEntity) o;

        if (recursoId != that.recursoId) return false;
        if (habilitadoCampus != that.habilitadoCampus) return false;
        if (habilitadoCarrera != that.habilitadoCarrera) return false;
        if (habilitadoAula != that.habilitadoAula) return false;
        if (habilitadoComision != that.habilitadoComision) return false;
        if (habilitadoGrupo != that.habilitadoGrupo) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (nombreMostrar != null ? !nombreMostrar.equals(that.nombreMostrar) : that.nombreMostrar != null)
            return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;
        if (tipoRecursoId != null ? !tipoRecursoId.equals(that.tipoRecursoId) : that.tipoRecursoId != null)
            return false;
        if (editable != null ? !editable.equals(that.editable) : that.editable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (recursoId ^ (recursoId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (nombreMostrar != null ? nombreMostrar.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        result = 31 * result + (tipoRecursoId != null ? tipoRecursoId.hashCode() : 0);
        result = 31 * result + (habilitadoCampus ? 1 : 0);
        result = 31 * result + (habilitadoCarrera ? 1 : 0);
        result = 31 * result + (habilitadoAula ? 1 : 0);
        result = 31 * result + (habilitadoComision ? 1 : 0);
        result = 31 * result + (habilitadoGrupo ? 1 : 0);
        result = 31 * result + (editable != null ? editable.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "recursoByRecursoId")
    public Collection<ItemAulaPermisoEntity> getItemAulaPermisosByRecursoId() {
        return itemAulaPermisosByRecursoId;
    }

    public void setItemAulaPermisosByRecursoId(Collection<ItemAulaPermisoEntity> itemAulaPermisosByRecursoId) {
        this.itemAulaPermisosByRecursoId = itemAulaPermisosByRecursoId;
    }

    @OneToMany(mappedBy = "recursoByRecursoId")
    public Collection<ItemPlantillaPermisoEntity> getItemPlantillaPermisosByRecursoId() {
        return itemPlantillaPermisosByRecursoId;
    }

    public void setItemPlantillaPermisosByRecursoId(Collection<ItemPlantillaPermisoEntity> itemPlantillaPermisosByRecursoId) {
        this.itemPlantillaPermisosByRecursoId = itemPlantillaPermisosByRecursoId;
    }

    @OneToMany(mappedBy = "recursoByRecursoId")
    public Collection<PermisoAccesoEntity> getPermisoAccesosByRecursoId() {
        return permisoAccesosByRecursoId;
    }

    public void setPermisoAccesosByRecursoId(Collection<PermisoAccesoEntity> permisoAccesosByRecursoId) {
        this.permisoAccesosByRecursoId = permisoAccesosByRecursoId;
    }

    @ManyToOne
    @JoinColumn(name = "TIPO_RECURSO_ID", referencedColumnName = "TIPO_RECURSO_ID", insertable=false, updatable=false)
    public TipoRecursoEntity getTipoRecursoByTipoRecursoId() {
        return tipoRecursoByTipoRecursoId;
    }

    public void setTipoRecursoByTipoRecursoId(TipoRecursoEntity tipoRecursoByTipoRecursoId) {
        this.tipoRecursoByTipoRecursoId = tipoRecursoByTipoRecursoId;
    }

    @OneToMany(mappedBy = "recursoByRecursoId")
    public Collection<RecursoCategoriaUsuarioEntity> getRecursoCategoriaUsuariosByRecursoId() {
        return recursoCategoriaUsuariosByRecursoId;
    }

    public void setRecursoCategoriaUsuariosByRecursoId(Collection<RecursoCategoriaUsuarioEntity> recursoCategoriaUsuariosByRecursoId) {
        this.recursoCategoriaUsuariosByRecursoId = recursoCategoriaUsuariosByRecursoId;
    }

    @OneToMany(mappedBy = "recursoByRecursoUtilizadoId")
    public Collection<RecursoSolicitadoEntity> getRecursoSolicitadosByRecursoId() {
        return recursoSolicitadosByRecursoId;
    }

    public void setRecursoSolicitadosByRecursoId(Collection<RecursoSolicitadoEntity> recursoSolicitadosByRecursoId) {
        this.recursoSolicitadosByRecursoId = recursoSolicitadosByRecursoId;
    }

    @OneToMany(mappedBy = "recursoByRecursoId")
    public Collection<RedSocialRecursoEntity> getRedSocialRecursosByRecursoId() {
        return redSocialRecursosByRecursoId;
    }

    public void setRedSocialRecursosByRecursoId(Collection<RedSocialRecursoEntity> redSocialRecursosByRecursoId) {
        this.redSocialRecursosByRecursoId = redSocialRecursosByRecursoId;
    }

    @OneToMany(mappedBy = "recursoByRecursoId")
    public Collection<SeguimientoAccesoEntity> getSeguimientoAccesosByRecursoId() {
        return seguimientoAccesosByRecursoId;
    }

    public void setSeguimientoAccesosByRecursoId(Collection<SeguimientoAccesoEntity> seguimientoAccesosByRecursoId) {
        this.seguimientoAccesosByRecursoId = seguimientoAccesosByRecursoId;
    }

    @OneToMany(mappedBy = "recursoByRecursoId")
    public Collection<SeguimientoAccesoElementoEntity> getSeguimientoAccesoElementosByRecursoId() {
        return seguimientoAccesoElementosByRecursoId;
    }

    public void setSeguimientoAccesoElementosByRecursoId(Collection<SeguimientoAccesoElementoEntity> seguimientoAccesoElementosByRecursoId) {
        this.seguimientoAccesoElementosByRecursoId = seguimientoAccesoElementosByRecursoId;
    }
}
