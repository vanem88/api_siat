package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "LINK", schema = "datosEveliaMinimo", catalog = "")
public class LinkEntity {
    private long linkId;
    private Integer cantidadAccesos;
    private String descripcion;
    private Long id;
    private String link;
    private String nombre;
    private BibliotecaEntity bibliotecaByLinkId;
    private EnlaceEntity enlaceByLinkId;

    @Id
    @Column(name = "LINK_ID")
    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    @Basic
    @Column(name = "CANTIDAD_ACCESOS")
    public Integer getCantidadAccesos() {
        return cantidadAccesos;
    }

    public void setCantidadAccesos(Integer cantidadAccesos) {
        this.cantidadAccesos = cantidadAccesos;
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
    @Column(name = "LINK")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

        LinkEntity that = (LinkEntity) o;

        if (linkId != that.linkId) return false;
        if (cantidadAccesos != null ? !cantidadAccesos.equals(that.cantidadAccesos) : that.cantidadAccesos != null)
            return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (linkId ^ (linkId >>> 32));
        result = 31 * result + (cantidadAccesos != null ? cantidadAccesos.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "linkByBibliotecaId")
    public BibliotecaEntity getBibliotecaByLinkId() {
        return bibliotecaByLinkId;
    }

    public void setBibliotecaByLinkId(BibliotecaEntity bibliotecaByLinkId) {
        this.bibliotecaByLinkId = bibliotecaByLinkId;
    }

    @OneToOne(mappedBy = "linkByEnlaceId")
    public EnlaceEntity getEnlaceByLinkId() {
        return enlaceByLinkId;
    }

    public void setEnlaceByLinkId(EnlaceEntity enlaceByLinkId) {
        this.enlaceByLinkId = enlaceByLinkId;
    }
}
