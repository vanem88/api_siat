package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "INFORME", schema = "datosEveliaMinimo", catalog = "")
public class InformeEntity {
    private long informeId;
    private String descripcion;
    private Long id;
    private String nivel;
    private Collection<InformePedidoInformeEntity> informePedidoInformesByInformeId;

    @Id
    @Column(name = "INFORME_ID")
    public long getInformeId() {
        return informeId;
    }

    public void setInformeId(long informeId) {
        this.informeId = informeId;
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

        InformeEntity that = (InformeEntity) o;

        if (informeId != that.informeId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nivel != null ? !nivel.equals(that.nivel) : that.nivel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (informeId ^ (informeId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "informeByInformeId")
    public Collection<InformePedidoInformeEntity> getInformePedidoInformesByInformeId() {
        return informePedidoInformesByInformeId;
    }

    public void setInformePedidoInformesByInformeId(Collection<InformePedidoInformeEntity> informePedidoInformesByInformeId) {
        this.informePedidoInformesByInformeId = informePedidoInformesByInformeId;
    }
}
