package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ESTADO_NOTA", schema = "datosEveliaMinimo", catalog = "")
public class EstadoNotaEntity {
    private long estadoNotaId;
    private String descripcion;
    private Long id;
    private Collection<NotaEntity> notasByEstadoNotaId;

    @Id
    @Column(name = "ESTADO_NOTA_ID")
    public long getEstadoNotaId() {
        return estadoNotaId;
    }

    public void setEstadoNotaId(long estadoNotaId) {
        this.estadoNotaId = estadoNotaId;
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

        EstadoNotaEntity that = (EstadoNotaEntity) o;

        if (estadoNotaId != that.estadoNotaId) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (estadoNotaId ^ (estadoNotaId >>> 32));
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "estadoNotaByEstadoNotaId")
    public Collection<NotaEntity> getNotasByEstadoNotaId() {
        return notasByEstadoNotaId;
    }

    public void setNotasByEstadoNotaId(Collection<NotaEntity> notasByEstadoNotaId) {
        this.notasByEstadoNotaId = notasByEstadoNotaId;
    }
}
