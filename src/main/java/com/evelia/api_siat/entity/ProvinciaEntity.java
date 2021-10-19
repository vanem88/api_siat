package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PROVINCIA", schema = "datosEveliaMinimo", catalog = "")
public class ProvinciaEntity {
    private long provinciaId;
    private Long id;
    private String nombre;
    private Long paisId;
    private Collection<CiudadEntity> ciudadsByProvinciaId;
    private PaisEntity paisByPaisId;

    @Id
    @Column(name = "PROVINCIA_ID")
    public long getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(long provinciaId) {
        this.provinciaId = provinciaId;
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
    @Column(name = "PAIS_ID")
    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinciaEntity that = (ProvinciaEntity) o;

        if (provinciaId != that.provinciaId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (paisId != null ? !paisId.equals(that.paisId) : that.paisId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (provinciaId ^ (provinciaId >>> 32));
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (paisId != null ? paisId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "provinciaByProvinciaId")
    public Collection<CiudadEntity> getCiudadsByProvinciaId() {
        return ciudadsByProvinciaId;
    }

    public void setCiudadsByProvinciaId(Collection<CiudadEntity> ciudadsByProvinciaId) {
        this.ciudadsByProvinciaId = ciudadsByProvinciaId;
    }

    @ManyToOne
    @JoinColumn(name = "PAIS_ID", referencedColumnName = "PAIS_ID", insertable=false, updatable=false)
    public PaisEntity getPaisByPaisId() {
        return paisByPaisId;
    }

    public void setPaisByPaisId(PaisEntity paisByPaisId) {
        this.paisByPaisId = paisByPaisId;
    }
}
