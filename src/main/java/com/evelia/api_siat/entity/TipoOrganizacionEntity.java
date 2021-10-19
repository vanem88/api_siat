package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TIPO_ORGANIZACION", schema = "datosEveliaMinimo", catalog = "")
public class TipoOrganizacionEntity {
    private long tipoOrganizacionId;
    private Long id;
    private String nombre;
    private Integer orden;
    private String descripcion;
    private Collection<AulaEntity> aulasByTipoOrganizacionId;

    @Id
    @Column(name = "TIPO_ORGANIZACION_ID")
    public long getTipoOrganizacionId() {
        return tipoOrganizacionId;
    }

    public void setTipoOrganizacionId(long tipoOrganizacionId) {
        this.tipoOrganizacionId = tipoOrganizacionId;
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
    @Column(name = "ORDEN")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoOrganizacionEntity that = (TipoOrganizacionEntity) o;

        if (tipoOrganizacionId != that.tipoOrganizacionId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (orden != null ? !orden.equals(that.orden) : that.orden != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (tipoOrganizacionId ^ (tipoOrganizacionId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (orden != null ? orden.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoOrganizacionByTipoOrganizacionId")
    public Collection<AulaEntity> getAulasByTipoOrganizacionId() {
        return aulasByTipoOrganizacionId;
    }

    public void setAulasByTipoOrganizacionId(Collection<AulaEntity> aulasByTipoOrganizacionId) {
        this.aulasByTipoOrganizacionId = aulasByTipoOrganizacionId;
    }
}
