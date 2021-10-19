package com.evelia.api_siat.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CIUDAD", schema = "datosEveliaMinimo", catalog = "")
public class CiudadEntity {
    private long ciudadId;
    private String codigoPostal;
    private Long id;
    private String nombre;
    private Long provinciaId;
    private ProvinciaEntity provinciaByProvinciaId;
    private Collection<PersonaEntity> personasByCiudadId;
    private Collection<RegistroPersonaEntity> registroPersonasByCiudadId;

    @Id
    @Column(name = "CIUDAD_ID")
    public long getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(long ciudadId) {
        this.ciudadId = ciudadId;
    }

    @Basic
    @Column(name = "CODIGO_POSTAL")
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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
    @Column(name = "PROVINCIA_ID")
    public Long getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Long provinciaId) {
        this.provinciaId = provinciaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CiudadEntity that = (CiudadEntity) o;

        if (ciudadId != that.ciudadId) return false;
        if (codigoPostal != null ? !codigoPostal.equals(that.codigoPostal) : that.codigoPostal != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (provinciaId != null ? !provinciaId.equals(that.provinciaId) : that.provinciaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (ciudadId ^ (ciudadId >>> 32));
        result = 31 * result + (codigoPostal != null ? codigoPostal.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (provinciaId != null ? provinciaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PROVINCIA_ID", referencedColumnName = "PROVINCIA_ID", insertable=false, updatable=false)
    public ProvinciaEntity getProvinciaByProvinciaId() {
        return provinciaByProvinciaId;
    }

    public void setProvinciaByProvinciaId(ProvinciaEntity provinciaByProvinciaId) {
        this.provinciaByProvinciaId = provinciaByProvinciaId;
    }

    @OneToMany(mappedBy = "ciudadByCiudadId")
    public Collection<PersonaEntity> getPersonasByCiudadId() {
        return personasByCiudadId;
    }

    public void setPersonasByCiudadId(Collection<PersonaEntity> personasByCiudadId) {
        this.personasByCiudadId = personasByCiudadId;
    }

    @OneToMany(mappedBy = "ciudadByCiudadId")
    public Collection<RegistroPersonaEntity> getRegistroPersonasByCiudadId() {
        return registroPersonasByCiudadId;
    }

    public void setRegistroPersonasByCiudadId(Collection<RegistroPersonaEntity> registroPersonasByCiudadId) {
        this.registroPersonasByCiudadId = registroPersonasByCiudadId;
    }
}
