package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TEMA", schema = "datosEveliaMinimo", catalog = "")
public class TemaEntity {
    private long temaId;
    private Long id;
    private Long listadoTemasId;
    private String nombre;
    private ListadoTemasEntity listadoTemasByListadoTemasId;
    private Collection<TemaTratadoGrupoEntity> temaTratadoGruposByTemaId;

    @Id
    @Column(name = "TEMA_ID")
    public long getTemaId() {
        return temaId;
    }

    public void setTemaId(long temaId) {
        this.temaId = temaId;
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
    @Column(name = "LISTADO_TEMAS_ID")
    public Long getListadoTemasId() {
        return listadoTemasId;
    }

    public void setListadoTemasId(Long listadoTemasId) {
        this.listadoTemasId = listadoTemasId;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemaEntity that = (TemaEntity) o;

        if (temaId != that.temaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (listadoTemasId != null ? !listadoTemasId.equals(that.listadoTemasId) : that.listadoTemasId != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (temaId ^ (temaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (listadoTemasId != null ? listadoTemasId.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LISTADO_TEMAS_ID", referencedColumnName = "LISTADO_TEMAS_ID", insertable=false, updatable=false)
    public ListadoTemasEntity getListadoTemasByListadoTemasId() {
        return listadoTemasByListadoTemasId;
    }

    public void setListadoTemasByListadoTemasId(ListadoTemasEntity listadoTemasByListadoTemasId) {
        this.listadoTemasByListadoTemasId = listadoTemasByListadoTemasId;
    }

    @OneToMany(mappedBy = "temaByTemaId")
    public Collection<TemaTratadoGrupoEntity> getTemaTratadoGruposByTemaId() {
        return temaTratadoGruposByTemaId;
    }

    public void setTemaTratadoGruposByTemaId(Collection<TemaTratadoGrupoEntity> temaTratadoGruposByTemaId) {
        this.temaTratadoGruposByTemaId = temaTratadoGruposByTemaId;
    }
}
