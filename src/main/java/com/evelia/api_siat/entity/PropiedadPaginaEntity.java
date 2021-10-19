package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "PROPIEDAD_PAGINA", schema = "datosEveliaMinimo", catalog = "")
public class PropiedadPaginaEntity {
    private long propiedadPaginaId;
    private Long id;
    private String nombre;
    private String path;
    private ColorFondoEntity colorFondoByPropiedadPaginaId;
    private EncabezadoPaginaEntity encabezadoPaginaByPropiedadPaginaId;
    private PaginaEstiloEntity paginaEstiloByPropiedadPaginaId;

    @Id
    @Column(name = "PROPIEDAD_PAGINA_ID")
    public long getPropiedadPaginaId() {
        return propiedadPaginaId;
    }

    public void setPropiedadPaginaId(long propiedadPaginaId) {
        this.propiedadPaginaId = propiedadPaginaId;
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
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropiedadPaginaEntity that = (PropiedadPaginaEntity) o;

        if (propiedadPaginaId != that.propiedadPaginaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (propiedadPaginaId ^ (propiedadPaginaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "propiedadPaginaByColorFondoId")
    public ColorFondoEntity getColorFondoByPropiedadPaginaId() {
        return colorFondoByPropiedadPaginaId;
    }

    public void setColorFondoByPropiedadPaginaId(ColorFondoEntity colorFondoByPropiedadPaginaId) {
        this.colorFondoByPropiedadPaginaId = colorFondoByPropiedadPaginaId;
    }

    @OneToOne(mappedBy = "propiedadPaginaByEncabezadoPaginaId")
    public EncabezadoPaginaEntity getEncabezadoPaginaByPropiedadPaginaId() {
        return encabezadoPaginaByPropiedadPaginaId;
    }

    public void setEncabezadoPaginaByPropiedadPaginaId(EncabezadoPaginaEntity encabezadoPaginaByPropiedadPaginaId) {
        this.encabezadoPaginaByPropiedadPaginaId = encabezadoPaginaByPropiedadPaginaId;
    }

    @OneToOne(mappedBy = "propiedadPaginaByPaginaEstiloId")
    public PaginaEstiloEntity getPaginaEstiloByPropiedadPaginaId() {
        return paginaEstiloByPropiedadPaginaId;
    }

    public void setPaginaEstiloByPropiedadPaginaId(PaginaEstiloEntity paginaEstiloByPropiedadPaginaId) {
        this.paginaEstiloByPropiedadPaginaId = paginaEstiloByPropiedadPaginaId;
    }
}
