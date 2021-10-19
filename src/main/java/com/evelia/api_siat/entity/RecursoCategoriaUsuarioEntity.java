package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "RECURSO_CATEGORIA_USUARIO", schema = "datosEveliaMinimo", catalog = "")
public class RecursoCategoriaUsuarioEntity {
    private long recursoCategoriaUsuarioId;
    private Long id;
    private Long recursoId;
    private Long categoriaUsuarioId;
    private boolean habilitado;
    private RecursoEntity recursoByRecursoId;
    private CategoriaUsuarioEntity categoriaUsuarioByCategoriaUsuarioId;

    @Id
    @Column(name = "RECURSO_CATEGORIA_USUARIO_ID")
    public long getRecursoCategoriaUsuarioId() {
        return recursoCategoriaUsuarioId;
    }

    public void setRecursoCategoriaUsuarioId(long recursoCategoriaUsuarioId) {
        this.recursoCategoriaUsuarioId = recursoCategoriaUsuarioId;
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
    @Column(name = "CATEGORIA_USUARIO_ID")
    public Long getCategoriaUsuarioId() {
        return categoriaUsuarioId;
    }

    public void setCategoriaUsuarioId(Long categoriaUsuarioId) {
        this.categoriaUsuarioId = categoriaUsuarioId;
    }

    @Basic
    @Column(name = "HABILITADO")
    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecursoCategoriaUsuarioEntity that = (RecursoCategoriaUsuarioEntity) o;

        if (recursoCategoriaUsuarioId != that.recursoCategoriaUsuarioId) return false;
        if (habilitado != that.habilitado) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recursoId != null ? !recursoId.equals(that.recursoId) : that.recursoId != null) return false;
        if (categoriaUsuarioId != null ? !categoriaUsuarioId.equals(that.categoriaUsuarioId) : that.categoriaUsuarioId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (recursoCategoriaUsuarioId ^ (recursoCategoriaUsuarioId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (recursoId != null ? recursoId.hashCode() : 0);
        result = 31 * result + (categoriaUsuarioId != null ? categoriaUsuarioId.hashCode() : 0);
        result = 31 * result + (habilitado ? 1 : 0);
        return result;
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
    @JoinColumn(name = "CATEGORIA_USUARIO_ID", referencedColumnName = "CATEGORIA_USUARIO_ID", insertable=false, updatable=false)
    public CategoriaUsuarioEntity getCategoriaUsuarioByCategoriaUsuarioId() {
        return categoriaUsuarioByCategoriaUsuarioId;
    }

    public void setCategoriaUsuarioByCategoriaUsuarioId(CategoriaUsuarioEntity categoriaUsuarioByCategoriaUsuarioId) {
        this.categoriaUsuarioByCategoriaUsuarioId = categoriaUsuarioByCategoriaUsuarioId;
    }
}
