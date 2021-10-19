package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_USUARIO", schema = "datosEveliaMinimo", catalog = "")
public class TipoUsuarioEntity {
    private long tipoUsuarioId;
    private Long id;
    private String nombre;
    private String nombreSingular;
    private String nombrePlural;
    private boolean habilitadoCampus;
    private boolean habilitadoCarrera;
    private boolean habilitadoAula;
    private boolean habilitadoComision;
    private boolean habilitadoGrupo;
    private Long categoriaId;
    private Collection<AulaTipoUsuarioEntity> aulaTipoUsuariosByTipoUsuarioId;
    private Collection<EncuestaSiatEntity> encuestaSiatsByTipoUsuarioId;
    private Collection<ItemAulaPermisoEntity> itemAulaPermisosByTipoUsuarioId;
    private Collection<ItemPlantillaPermisoEntity> itemPlantillaPermisosByTipoUsuarioId;
    private Collection<ParticipanteEntity> participantesByTipoUsuarioId;
    private Collection<PermisoAccesoEntity> permisoAccesosByTipoUsuarioId;
    private CategoriaUsuarioEntity categoriaUsuarioByCategoriaId;
    private Collection<TipoUsuarioEnNivelEntity> tipoUsuarioEnNivelsByTipoUsuarioId;

    @Id
    @Column(name = "TIPO_USUARIO_ID")
    public long getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(long tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
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
    @Column(name = "NOMBRE_SINGULAR")
    public String getNombreSingular() {
        return nombreSingular;
    }

    public void setNombreSingular(String nombreSingular) {
        this.nombreSingular = nombreSingular;
    }

    @Basic
    @Column(name = "NOMBRE_PLURAL")
    public String getNombrePlural() {
        return nombrePlural;
    }

    public void setNombrePlural(String nombrePlural) {
        this.nombrePlural = nombrePlural;
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
    @Column(name = "CATEGORIA_ID")
    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoUsuarioEntity that = (TipoUsuarioEntity) o;

        if (tipoUsuarioId != that.tipoUsuarioId) return false;
        if (habilitadoCampus != that.habilitadoCampus) return false;
        if (habilitadoCarrera != that.habilitadoCarrera) return false;
        if (habilitadoAula != that.habilitadoAula) return false;
        if (habilitadoComision != that.habilitadoComision) return false;
        if (habilitadoGrupo != that.habilitadoGrupo) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (nombreSingular != null ? !nombreSingular.equals(that.nombreSingular) : that.nombreSingular != null)
            return false;
        if (nombrePlural != null ? !nombrePlural.equals(that.nombrePlural) : that.nombrePlural != null) return false;
        if (categoriaId != null ? !categoriaId.equals(that.categoriaId) : that.categoriaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoUsuarioId ^ (tipoUsuarioId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (nombreSingular != null ? nombreSingular.hashCode() : 0);
        result = 31 * result + (nombrePlural != null ? nombrePlural.hashCode() : 0);
        result = 31 * result + (habilitadoCampus ? 1 : 0);
        result = 31 * result + (habilitadoCarrera ? 1 : 0);
        result = 31 * result + (habilitadoAula ? 1 : 0);
        result = 31 * result + (habilitadoComision ? 1 : 0);
        result = 31 * result + (habilitadoGrupo ? 1 : 0);
        result = 31 * result + (categoriaId != null ? categoriaId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoUsuarioByTipoUsuarioId")
    public Collection<AulaTipoUsuarioEntity> getAulaTipoUsuariosByTipoUsuarioId() {
        return aulaTipoUsuariosByTipoUsuarioId;
    }

    public void setAulaTipoUsuariosByTipoUsuarioId(Collection<AulaTipoUsuarioEntity> aulaTipoUsuariosByTipoUsuarioId) {
        this.aulaTipoUsuariosByTipoUsuarioId = aulaTipoUsuariosByTipoUsuarioId;
    }

    @OneToMany(mappedBy = "tipoUsuarioByParaQuienId")
    public Collection<EncuestaSiatEntity> getEncuestaSiatsByTipoUsuarioId() {
        return encuestaSiatsByTipoUsuarioId;
    }

    public void setEncuestaSiatsByTipoUsuarioId(Collection<EncuestaSiatEntity> encuestaSiatsByTipoUsuarioId) {
        this.encuestaSiatsByTipoUsuarioId = encuestaSiatsByTipoUsuarioId;
    }

    @OneToMany(mappedBy = "tipoUsuarioByTipoUsuarioId")
    public Collection<ItemAulaPermisoEntity> getItemAulaPermisosByTipoUsuarioId() {
        return itemAulaPermisosByTipoUsuarioId;
    }

    public void setItemAulaPermisosByTipoUsuarioId(Collection<ItemAulaPermisoEntity> itemAulaPermisosByTipoUsuarioId) {
        this.itemAulaPermisosByTipoUsuarioId = itemAulaPermisosByTipoUsuarioId;
    }

    @OneToMany(mappedBy = "tipoUsuarioByTipoUsuarioId")
    public Collection<ItemPlantillaPermisoEntity> getItemPlantillaPermisosByTipoUsuarioId() {
        return itemPlantillaPermisosByTipoUsuarioId;
    }

    public void setItemPlantillaPermisosByTipoUsuarioId(Collection<ItemPlantillaPermisoEntity> itemPlantillaPermisosByTipoUsuarioId) {
        this.itemPlantillaPermisosByTipoUsuarioId = itemPlantillaPermisosByTipoUsuarioId;
    }

    @OneToMany(mappedBy = "tipoUsuarioByTipoUsuarioId")
    public Collection<ParticipanteEntity> getParticipantesByTipoUsuarioId() {
        return participantesByTipoUsuarioId;
    }

    public void setParticipantesByTipoUsuarioId(Collection<ParticipanteEntity> participantesByTipoUsuarioId) {
        this.participantesByTipoUsuarioId = participantesByTipoUsuarioId;
    }

    @OneToMany(mappedBy = "tipoUsuarioByTipoUsuarioId")
    public Collection<PermisoAccesoEntity> getPermisoAccesosByTipoUsuarioId() {
        return permisoAccesosByTipoUsuarioId;
    }

    public void setPermisoAccesosByTipoUsuarioId(Collection<PermisoAccesoEntity> permisoAccesosByTipoUsuarioId) {
        this.permisoAccesosByTipoUsuarioId = permisoAccesosByTipoUsuarioId;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "CATEGORIA_USUARIO_ID", insertable=false, updatable=false)
    public CategoriaUsuarioEntity getCategoriaUsuarioByCategoriaId() {
        return categoriaUsuarioByCategoriaId;
    }

    public void setCategoriaUsuarioByCategoriaId(CategoriaUsuarioEntity categoriaUsuarioByCategoriaId) {
        this.categoriaUsuarioByCategoriaId = categoriaUsuarioByCategoriaId;
    }

    @OneToMany(mappedBy = "tipoUsuarioByTipoUsuarioId")
    public Collection<TipoUsuarioEnNivelEntity> getTipoUsuarioEnNivelsByTipoUsuarioId() {
        return tipoUsuarioEnNivelsByTipoUsuarioId;
    }

    public void setTipoUsuarioEnNivelsByTipoUsuarioId(Collection<TipoUsuarioEnNivelEntity> tipoUsuarioEnNivelsByTipoUsuarioId) {
        this.tipoUsuarioEnNivelsByTipoUsuarioId = tipoUsuarioEnNivelsByTipoUsuarioId;
    }
}
