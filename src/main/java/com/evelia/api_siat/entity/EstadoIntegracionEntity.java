package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ESTADO_INTEGRACION", schema = "datosEveliaMinimo", catalog = "")
public class EstadoIntegracionEntity {
    private long estadoIntegracionId;
    private String descripcion;
    private Long id;
    private Collection<TextoEntity> textosByEstadoIntegracionId;

    @Id
    @Column(name = "ESTADO_INTEGRACION_ID")
    public long getEstadoIntegracionId() {
        return estadoIntegracionId;
    }

    public void setEstadoIntegracionId(long estadoIntegracionId) {
        this.estadoIntegracionId = estadoIntegracionId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoIntegracionEntity that = (EstadoIntegracionEntity) o;

        if (estadoIntegracionId != that.estadoIntegracionId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (estadoIntegracionId ^ (estadoIntegracionId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "estadoIntegracionByEstadoId")
    public Collection<TextoEntity> getTextosByEstadoIntegracionId() {
        return textosByEstadoIntegracionId;
    }

    public void setTextosByEstadoIntegracionId(Collection<TextoEntity> textosByEstadoIntegracionId) {
        this.textosByEstadoIntegracionId = textosByEstadoIntegracionId;
    }
}
