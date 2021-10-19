package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PAIS", schema = "datosEveliaMinimo", catalog = "")
public class PaisEntity {
    private long paisId;
    private Long id;
    private String nombre;
    private Collection<ProvinciaEntity> provinciasByPaisId;

    @Id
    @Column(name = "PAIS_ID")
    public long getPaisId() {
        return paisId;
    }

    public void setPaisId(long paisId) {
        this.paisId = paisId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaisEntity that = (PaisEntity) o;

        if (paisId != that.paisId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (paisId ^ (paisId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "paisByPaisId")
    public Collection<ProvinciaEntity> getProvinciasByPaisId() {
        return provinciasByPaisId;
    }

    public void setProvinciasByPaisId(Collection<ProvinciaEntity> provinciasByPaisId) {
        this.provinciasByPaisId = provinciasByPaisId;
    }
}
