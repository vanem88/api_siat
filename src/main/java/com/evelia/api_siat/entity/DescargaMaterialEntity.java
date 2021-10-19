package com.evelia.api_siat.entity;

import javax.persistence.*;

@Entity
@Table(name = "DESCARGA_MATERIAL", schema = "datosEveliaMinimo", catalog = "")
public class DescargaMaterialEntity {
    private long descargaMaterialId;
    private Long archivoId;
    private Integer cantidad;
    private Long id;
    private Long personaId;
    private ArchivoEntity archivoByArchivoId;
    private PersonaEntity personaByPersonaId;

    @Id
    @Column(name = "DESCARGA_MATERIAL_ID")
    public long getDescargaMaterialId() {
        return descargaMaterialId;
    }

    public void setDescargaMaterialId(long descargaMaterialId) {
        this.descargaMaterialId = descargaMaterialId;
    }

    @Basic
    @Column(name = "ARCHIVO_ID")
    public Long getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(Long archivoId) {
        this.archivoId = archivoId;
    }

    @Basic
    @Column(name = "CANTIDAD")
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
    @Column(name = "PERSONA_ID")
    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DescargaMaterialEntity that = (DescargaMaterialEntity) o;

        if (descargaMaterialId != that.descargaMaterialId) return false;
        if (archivoId != null ? !archivoId.equals(that.archivoId) : that.archivoId != null) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (descargaMaterialId ^ (descargaMaterialId >>> 32));
        result = 31 * result + (archivoId != null ? archivoId.hashCode() : 0);
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID", insertable=false, updatable=false)
    public ArchivoEntity getArchivoByArchivoId() {
        return archivoByArchivoId;
    }

    public void setArchivoByArchivoId(ArchivoEntity archivoByArchivoId) {
        this.archivoByArchivoId = archivoByArchivoId;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "PERSONA_ID", insertable=false, updatable=false)
    public PersonaEntity getPersonaByPersonaId() {
        return personaByPersonaId;
    }

    public void setPersonaByPersonaId(PersonaEntity personaByPersonaId) {
        this.personaByPersonaId = personaByPersonaId;
    }
}
