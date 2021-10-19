package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CATEGORIA_USUARIO", schema = "datosEveliaMinimo", catalog = "")
public class CategoriaUsuarioEntity {
    private long categoriaUsuarioId;
    private Long id;
    private String titulo;
    private Integer orden;
    private Collection<RecursoCategoriaUsuarioEntity> recursoCategoriaUsuariosByCategoriaUsuarioId;
    private Collection<TipoUsuarioEntity> tipoUsuariosByCategoriaUsuarioId;

    @Id
    @Column(name = "CATEGORIA_USUARIO_ID")
    public long getCategoriaUsuarioId() {
        return categoriaUsuarioId;
    }

    public void setCategoriaUsuarioId(long categoriaUsuarioId) {
        this.categoriaUsuarioId = categoriaUsuarioId;
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
    @Column(name = "TITULO")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriaUsuarioEntity that = (CategoriaUsuarioEntity) o;

        if (categoriaUsuarioId != that.categoriaUsuarioId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (categoriaUsuarioId ^ (categoriaUsuarioId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoriaUsuarioByCategoriaUsuarioId")
    public Collection<RecursoCategoriaUsuarioEntity> getRecursoCategoriaUsuariosByCategoriaUsuarioId() {
        return recursoCategoriaUsuariosByCategoriaUsuarioId;
    }

    public void setRecursoCategoriaUsuariosByCategoriaUsuarioId(Collection<RecursoCategoriaUsuarioEntity> recursoCategoriaUsuariosByCategoriaUsuarioId) {
        this.recursoCategoriaUsuariosByCategoriaUsuarioId = recursoCategoriaUsuariosByCategoriaUsuarioId;
    }

    @OneToMany(mappedBy = "categoriaUsuarioByCategoriaId")
    public Collection<TipoUsuarioEntity> getTipoUsuariosByCategoriaUsuarioId() {
        return tipoUsuariosByCategoriaUsuarioId;
    }

    public void setTipoUsuariosByCategoriaUsuarioId(Collection<TipoUsuarioEntity> tipoUsuariosByCategoriaUsuarioId) {
        this.tipoUsuariosByCategoriaUsuarioId = tipoUsuariosByCategoriaUsuarioId;
    }
}
